package org.aleksandr.berezovyi.task2_cities;

import org.aleksandr.berezovyi.task2_cities.business.CityManager;
import org.aleksandr.berezovyi.task2_cities.business.TravelManager;
import org.aleksandr.berezovyi.task2_cities.business.impl.CityManagerImpl;
import org.aleksandr.berezovyi.task2_cities.business.impl.TravelManagerImpl;
import org.aleksandr.berezovyi.task2_cities.model.City;

import java.io.*;
import java.util.Scanner;

public class Cities {
    public static void main(String[] args) {

        try (Scanner scanIn = new Scanner(new FileInputStream(
                new File("src/org/aleksandr/berezovyi/task2_cities/test_cases.txt")))) {
            int testsCount = Integer.parseInt(scanIn.nextLine());
            while (testsCount-- > 0) {
                System.out.println("------- TEST -------");
                CityManagerImpl.clearCount();
                CityManager cityManager = new CityManagerImpl();
                TravelManager travelManager = new TravelManagerImpl(cityManager);

                int citiesCount = Integer.parseInt(scanIn.nextLine());
                for (int i = 0; i < citiesCount; i++) {
                    String cityName = scanIn.nextLine();
                    int neighboursCount = Integer.parseInt(scanIn.nextLine());
                    City created = cityManager.add(cityName);
                    for (int j = 0; j < neighboursCount; j++) {
                        String[] parts = scanIn.nextLine().split(" ");
                        travelManager.addConnection(created.getId(), Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                    }
                }
                int pathsToFind = Integer.parseInt(scanIn.nextLine());
                for (int i = 0; i < pathsToFind; i++) {
                    String[] parts = scanIn.nextLine().split(" ");
                    System.out.println("Minimum COST is "
                            + travelManager.findLowerCostPath(cityManager.find(parts[0]), cityManager.find(parts[1])));
                }
                if (scanIn.hasNextLine())
                    scanIn.nextLine();
                System.out.println("--------------------");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
