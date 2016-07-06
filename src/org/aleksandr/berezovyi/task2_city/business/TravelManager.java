package org.aleksandr.berezovyi.task2_city.business;

import org.aleksandr.berezovyi.task2_city.model.City;
import org.aleksandr.berezovyi.task2_city.model.Connection;

import java.util.List;

/**
 * Created by pepsik on 7/5/2016.
 */
public interface TravelManager {
    void addConnection(int fromCityId, int toCityId, int cost);

    void setNumberOfPathsToFind(int number);

    List<Connection> findAllPaths(City from);

    int findLowerCostPath(City from, City to);

    List<Connection> getAll();
}
