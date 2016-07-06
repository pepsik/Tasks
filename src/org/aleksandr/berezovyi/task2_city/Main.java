package org.aleksandr.berezovyi.task2_city;

import org.aleksandr.berezovyi.task2_city.business.CityManager;
import org.aleksandr.berezovyi.task2_city.business.TravelManager;
import org.aleksandr.berezovyi.task2_city.business.impl.CityManagerImpl;
import org.aleksandr.berezovyi.task2_city.business.impl.TravelManagerImpl;
import org.aleksandr.berezovyi.task2_city.model.City;

public class Main {
    public static void main(String[] args) {

        int numberOfCities = 4;
        String _1 = "gdansk";
        String _2 = "bydgoszcz";
        String _3 = "torun";
        String _4 = "warszawa";
        String _5 = "Kyiv";
        String _6 = "Kharkiv";

        CityManager cityManager = new CityManagerImpl();
        TravelManager travelManager = new TravelManagerImpl(cityManager);

        City _1City = cityManager.add(_1, 2);
        travelManager.addConnection(_1City.getId(), 2, 1);
        travelManager.addConnection(_1City.getId(), 3, 3);

        City _2City = cityManager.add(_2, 3);
        travelManager.addConnection(_2City.getId(), 1, 1);
        travelManager.addConnection(_2City.getId(), 3, 1);
        travelManager.addConnection(_2City.getId(), 4, 4);

        City _3City = cityManager.add(_3, 3);
        travelManager.addConnection(_3City.getId(), 1, 3);
        travelManager.addConnection(_3City.getId(), 2, 1);
        travelManager.addConnection(_3City.getId(), 4, 1);

        City _4City = cityManager.add(_4, 3);
        travelManager.addConnection(_4City.getId(), 2, 4);
        travelManager.addConnection(_4City.getId(), 3, 1);
        travelManager.addConnection(_4City.getId(), 5, 2);

        City _5City = cityManager.add(_5, 1);
        travelManager.addConnection(_5City.getId(), 4, 2);
        travelManager.addConnection(_5City.getId(), 6, 1);

        City _6City = cityManager.add(_6, 1);
        travelManager.addConnection(_6City.getId(), 5, 1);

        travelManager.setNumberOfPathsToFind(2);

//        int cost = travelManager.findLowerCostPath(cityManager.find("gdansk"), cityManager.find("warszawa"));

        System.out.print("Minimum cost between " + _1City.getName() + " and " + _4City.getName() + " = ");
        System.out.println(travelManager.findLowerCostPath(_1City, _4City));

        System.out.print("Minimum cost between " + _2City.getName() + " and " + _4City.getName() + " = ");
        System.out.println(travelManager.findLowerCostPath(_2City, _4City));
    }
}
