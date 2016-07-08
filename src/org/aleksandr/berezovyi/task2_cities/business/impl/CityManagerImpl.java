package org.aleksandr.berezovyi.task2_cities.business.impl;

import org.aleksandr.berezovyi.task2_cities.business.CityManager;
import org.aleksandr.berezovyi.task2_cities.model.City;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pepsik on 7/5/2016.
 */
public class CityManagerImpl implements CityManager {
    private static int counter = 0;

    private Map<Integer, City> citiesById = new HashMap<>();
    private Map<String, City> citiesByName = new HashMap<>();

    public static void clearCount() {
        counter = 0;
    }

    @Override
    public City add(String name) {
        City city = new City(name, ++counter);
        citiesById.put(city.getId(), city);
        citiesByName.put(city.getName(), city);
        return city;
    }

    @Override
    public City find(String name) {
        return citiesByName.get(name);
    }

    @Override
    public City find(int id) {
        return citiesById.get(id);
    }

    @Override
    public Collection<City> getAll() {
        return citiesById.values();
    }
}
