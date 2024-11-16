package OpenChallenge6;

import java.util.HashMap;
import java.util.Scanner;

class Location {
    private String cityName;
    private double latitude;
    private double longitude;

    public Location(String cityName, double latitude, double longitude) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCityName() {
        return cityName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void printLocation() {
        System.out.println(cityName + "\t" + latitude + "\t" + longitude);
    }
}

public class LocationManager {

    public static void main(String[] args) {
        HashMap<String, Location> locationMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("도시, 경도, 위도를 입력하세요.");
        for (int i = 0; i < 4; i++) {
            System.out.print(">> ");
            String input = scanner.nextLine();
            String[] parts = input.split(", ");
            String city = parts[0];
            double latitude = Double.parseDouble(parts[1]);
            double longitude = Double.parseDouble(parts[2]);
            
            locationMap.put(city, new Location(city, latitude, longitude));
        }
        
        System.out.println("---------------------------------");
        for (Location location : locationMap.values()) {
            location.printLocation();
        }
        System.out.println("---------------------------------");

        while (true) {
            System.out.print("도시 이름>> ");
            String cityName = scanner.nextLine();
            
            if (cityName.equals("그만")) {
                break;
            }

            if (locationMap.containsKey(cityName)) {
                locationMap.get(cityName).printLocation();
            } else {
                System.out.println(cityName + "는 없습니다.");
            }
        }

        scanner.close();
    }
}
