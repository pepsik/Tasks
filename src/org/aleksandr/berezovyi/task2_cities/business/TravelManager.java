package org.aleksandr.berezovyi.task2_cities.business;

import org.aleksandr.berezovyi.task2_cities.model.City;
import org.aleksandr.berezovyi.task2_cities.model.Connection;

import java.util.Set;

/**
 * Created by pepsik on 7/5/2016.
 */
public interface TravelManager {
    void addConnection(int fromCityId, int toCityId, int cost);

    Set<Connection> findAllPaths(City from);

    int findLowerCostPath(City from, City to);

    Set<Connection> getAll();

    void clear();
}
