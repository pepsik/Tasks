package org.aleksandr.berezovyi.task2_cities.business;

import org.aleksandr.berezovyi.task2_cities.model.City;

import java.util.Collection;

/**
 * Created by pepsik on 7/5/2016.
 */
public interface CityManager {
    City add(String name);

    City find(String name);

    City find(int id);

    Collection<City> getAll();

    void clear();
}
