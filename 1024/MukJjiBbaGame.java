package OpenChallenge4;

import java.util.Random;
import java.util.Scanner;

abstract class Player {
    String name;
    String choice;
    
    public Player(String name) {
        this.name = name;
    }

    public abstract void makeChoice();
    
    public String getChoice() {
        return choice;
    }
}

class Human extends Player {
    public Human(String name) {
        super(name);
    }

    @Override
    public void makeChoice() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(name + ">> ");
            choice = sc.nextLine();
            if (choice.equals("묵") || choice.equals("찌") || choice.equals("빠")) {
                break;
            } else {
                System.out.println("묵 찌 빠 중에서 다시 입력하세요.");
            }
        }
    }
}

class Computer extends Player {
    public Computer(String name) {
        super(name);
    }

    @Override
    public void makeChoice() {
        String[] choices = {"묵", "찌", "빠"};
        Random rand = new Random();
        choice = choices[rand.nextInt(choices.length)];
        System.out.println("AI>> 결정하였습니다.");
    }
}

public class MukJjiBbaGame {
    static Player owner;
    static Player human;
    static Player computer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("***** 묵찌빠 게임을 시작합니다. *****");

        System.out.print("선수이름 입력>> ");
        String humanName = sc.nextLine();
        human = new Human(humanName);

        System.out.print("컴퓨터이름 입력>> ");
        String computerName = sc.nextLine();
        computer = new Computer(computerName);

        System.out.println("2명의 선수를 생성 완료하였습니다.\n");

        owner = human;

        boolean isFirstRound = true;

        while (true) {
            if (!isFirstRound) {
                System.out.println("오너가 " + owner.name + "로 변경되었습니다.\n");
            } else {
                isFirstRound = false;
            }

            human.makeChoice();
            computer.makeChoice();

            System.out.print(human.name + " : " + human.getChoice() + ", ");
            System.out.println(computer.name + " : " + computer.getChoice());

            if (owner.getChoice().equals(computer.getChoice())) {
                System.out.println(owner.name + "이 이겼습니다.");
                break;
            } else {
                if (determineWinner(human.getChoice(), computer.getChoice())) {
                    owner = human;
                } else {
                    owner = computer;
                }
            }
        }
    }

    public static boolean determineWinner(String humanChoice, String computerChoice) {
        if (humanChoice.equals("묵") && computerChoice.equals("찌") ||
            humanChoice.equals("찌") && computerChoice.equals("빠") ||
            humanChoice.equals("빠") && computerChoice.equals("묵")) {
            return true;
        } else {
            return false;
        }
    }
}