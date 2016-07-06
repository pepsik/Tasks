package org.aleksandr.berezovyi.task2_city.business;


import org.aleksandr.berezovyi.task2_city.model.City;

import java.util.Collection;

/**
 * Created by pepsik on 7/5/2016.
 */
public interface CityManager {
    City add(String name, int numberOfNeighbours);

    City find(String name);

    City find(int id);

    Collection<City> getAll();

    void setNumberOfCities(int number);
}
