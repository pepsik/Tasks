package org.aleksandr.berezovyi.task2_cities.business.impl;

import org.aleksandr.berezovyi.task2_cities.business.CityManager;
import org.aleksandr.berezovyi.task2_cities.business.TravelManager;
import org.aleksandr.berezovyi.task2_cities.model.City;
import org.aleksandr.berezovyi.task2_cities.model.Connection;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by pepsik on 7/5/2016.
 */
public class TravelManagerImpl implements TravelManager {
    public static final int INF = 1_000;

    private Set<Connection> connections = new HashSet<>();
    private CityManager cityManager;

    public TravelManagerImpl(CityManager cityManager) {
        this.cityManager = cityManager;
    }

    @Override
    public void addConnection(int fromCityId, int toCityId, int cost) {
        Connection connection = new Connection(fromCityId, toCityId, cost);
        connections.add(connection);
    }

    @Override
    public Set<Connection> findAllPaths(City from) {
        return connections.stream().filter(connection -> connection.getFromCityId() == from.getId()).collect(Collectors.toSet());
    }

    /**
     * Using Dijkstra's algorithm to find the shortest ways to move from one first city to each other city in the graph
     **/
    @Override
    public int findLowerCostPath(City from, City to) {
        List<City> cityList = new ArrayList<>(cityManager.getAll());
        int[] travelCosts = new int[cityList.size()];
        boolean[] exploredCity = new boolean[cityList.size()];
        int currCityId = from.getId();
        Arrays.fill(travelCosts, INF);
        travelCosts[currCityId - 1] = 0;

        for (int i = 0; i < cityList.size(); i++) {
            int minCost = INF;
            exploredCity[currCityId - 1] = true;
            Set<Connection> paths = findAllPaths(cityList.get(currCityId - 1));
            for (Connection path : paths) {
                if (exploredCity[path.getToCityId() - 1])
                    continue;
                if (path.getCost() + travelCosts[path.getFromCityId() - 1] < travelCosts[path.getToCityId() - 1]) {
                    travelCosts[path.getToCityId() - 1] = travelCosts[path.getFromCityId() - 1] + path.getCost();
                }
                if (path.getCost() < minCost) {
                    minCost = path.getCost();
                    currCityId = path.getToCityId();
                }
            }

            if (minCost == INF) {
                for (int j = 0; j < exploredCity.length; j++) {
                    if (!exploredCity[j] && travelCosts[j] != INF) {
                        currCityId = j + 1;
                    }
                }
            }
        }
        return travelCosts[to.getId() - 1];
    }


    public Set<Connection> getAll() {
        return connections;
    }

    @Override
    public void clear() {
        connections.clear();
    }
}
