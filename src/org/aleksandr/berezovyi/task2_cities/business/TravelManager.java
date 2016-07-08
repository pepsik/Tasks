package org.aleksandr.berezovyi.task2_cities.business;

import org.aleksandr.berezovyi.task2_cities.model.City;
import org.aleksandr.berezovyi.task2_cities.model.Path;

import java.util.Set;

/**
 * Created by pepsik on 7/5/2016.
 */
public interface TravelManager {
    void addPath(int srcCityId, int destCityId, int cost);

    Set<Path> findAllPaths(City src);

    int findLowerCostPath(City src, City dest);

    Set<Path> getAll();
}
