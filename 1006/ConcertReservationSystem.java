package OpenChallenge3;

import java.util.Scanner;

class Seat {
    private String type; // 좌석 종류 (S, A, B)
    private boolean[] reserved; // 예약 상태
    private String[] names; // 예약자 이름

    public Seat(String type) {
        this.type = type;
        this.reserved = new boolean[10]; // 각 좌석은 10개
        this.names = new String[10];
    }

    public String getType() {
        return type;
    }

    public boolean reserve(int number, String name) {
        if (number < 1 || number > 10) {
            System.out.println("잘못된 좌석 번호입니다.");
            return false;
        }
        if (reserved[number - 1]) {
            System.out.println("이미 예약된 좌석입니다.");
            return false;
        }
        reserved[number - 1] = true;
        names[number - 1] = name;
        System.out.println(name + "님이 " + type + "석 " + number + "번을 예약하셨습니다.");
        return true;
    }

    public void display() {
        for (int i = 0; i < reserved.length; i++) {
            if (reserved[i]) {
                System.out.print(names[i] + "\t");
            } else {
                System.out.print("...\t");
            }
        }
        System.out.println();
    }

    public void showSeatStatus() {
        System.out.print(type + "석 >> ");
        display();
    }

    public boolean cancel(String name) {
        for (int i = 0; i < reserved.length; i++) {
            if (reserved[i] && names[i].equals(name)) {
                reserved[i] = false;
                names[i] = null;
                System.out.println(name + "님의 예약이 취소되었습니다.");
                return true;
            }
        }
        System.out.println("이름이 없습니다. 확인 후 다시 시도하세요.");
        return false;
    }
}

public class ConcertReservationSystem {
    private Seat[] seats;

    public ConcertReservationSystem() {
        seats = new Seat[3];
        seats[0] = new Seat("S");
        seats[1] = new Seat("A");
        seats[2] = new Seat("B");
    }

    public void reserve(Scanner scanner) {
        System.out.print("좌석구분 S(1), A(2), B(3)>> ");
        int typeChoice = scanner.nextInt();
        String type = "";

        if (typeChoice == 1) {
            type = "S";
        } else if (typeChoice == 2) {
            type = "A";
        } else if (typeChoice == 3) {
            type = "B";
        } else {
            System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            return;
        }

        System.out.println(type + "석의 예약 현황을 확인합니다:");
        findSeatByType(type).showSeatStatus();

        System.out.print("좌석 번호(1~10)? ");
        int number = scanner.nextInt();
        System.out.print("예약자 이름? ");
        String name = scanner.next();

        Seat seat = findSeatByType(type);
        if (seat != null) {
            seat.reserve(number, name);
        }
    }

    public void display() {
        for (Seat seat : seats) {
            seat.showSeatStatus();
        }
        System.out.println("<<<조회를 완료하였습니다.>>>");
    }

    public void cancel(Scanner scanner) {
        System.out.print("예약자 이름? ");
        String name = scanner.next();
        boolean found = false;
        for (Seat seat : seats) {
            if (seat.cancel(name)) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("예약이 없습니다.");
        }
    }

    private Seat findSeatByType(String type) {
        for (Seat seat : seats) {
            if (seat.getType().equalsIgnoreCase(type)) {
                return seat;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ConcertReservationSystem system = new ConcertReservationSystem();
        Scanner scanner = new Scanner(System.in);
        System.out.println("명품콘서트홈 예약 시스템입니다.");

        while (true) {
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>> ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.reserve(scanner);
                    break;
                case 2:
                    system.display();
                    break;
                case 3:
                    system.cancel(scanner);
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 메뉴입니다. 다시 선택하세요.");
            }
        }
    }
}