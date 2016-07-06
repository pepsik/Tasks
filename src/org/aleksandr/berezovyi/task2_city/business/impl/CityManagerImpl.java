package org.aleksandr.berezovyi.task2_city.business.impl;

import org.aleksandr.berezovyi.task2_city.business.CityManager;
import org.aleksandr.berezovyi.task2_city.model.City;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pepsik on 7/5/2016.
 */
public class CityManagerImpl implements CityManager {
    private int numberOfCities = 0;
    private Map<Integer, City> citiesById = new HashMap<>();
    private Map<String, City> citiesByName = new HashMap<>();

    @Override
    public City add(String name, int numberOfNeighbours) {
        City city = new City(name, numberOfNeighbours);
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

    @Override
    public void setNumberOfCities(int number) {
        this.numberOfCities = number;
    }
}
