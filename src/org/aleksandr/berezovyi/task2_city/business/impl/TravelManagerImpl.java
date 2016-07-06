package org.aleksandr.berezovyi.task2_city.business.impl;

import org.aleksandr.berezovyi.task2_city.business.CityManager;
import org.aleksandr.berezovyi.task2_city.business.TravelManager;
import org.aleksandr.berezovyi.task2_city.model.City;
import org.aleksandr.berezovyi.task2_city.model.Connection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pepsik on 7/5/2016.
 */
public class TravelManagerImpl implements TravelManager {
    public static final int INF = 1_000;

    private int numberOfPathsToFind;
    private List<Connection> connections = new ArrayList<>();
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
    public void setNumberOfPathsToFind(int number) {
        this.numberOfPathsToFind = number;
    }

    @Override
    public List<Connection> findAllPaths(City from) {
        return connections.stream().filter(connection -> connection.getFromCityId() == from.getId()).collect(Collectors.toList());
    }

    /** Using Dijkstra's algorithm to find the shortest ways to move from one first city to each other city in the graph **/
    @Override
    public int findLowerCostPath(City from, City to) {
        int[] travelCosts = new int[cityManager.getAll().size()];
        boolean[] exploredCity = new boolean[cityManager.getAll().size()];
        List<City> cityList = new ArrayList<>(cityManager.getAll());
        int currentCityId = from.getId();
        Arrays.fill(travelCosts, INF);
        travelCosts[currentCityId - 1] = 0;

        for (int i = 0; i < cityManager.getAll().size(); i++) {
            List<Connection> connections = findAllPaths(cityList.get(currentCityId - 1));
            int minCost = INF;
            exploredCity[currentCityId - 1] = true;
            for (Connection conn : connections) {
                if (conn.getCost() < travelCosts[conn.getToCityId() - 1] && !exploredCity[conn.getToCityId() - 1]) {
                    travelCosts[conn.getToCityId() - 1] = travelCosts[conn.getFromCityId() - 1] + conn.getCost();
                }
                if (conn.getCost() < minCost && !exploredCity[conn.getToCityId() - 1]) {
                    minCost = conn.getCost();
                    currentCityId = conn.getToCityId();
                }
            }

            if (minCost == INF) {
                for (int j = 0; j < exploredCity.length; j++) {
                    if (!exploredCity[j] && travelCosts[j] != INF){
                        currentCityId = j + 1;
                    }
                }
            }
        }
        return travelCosts[to.getId() - 1];
    }



    public List<Connection> getAll() {
        return connections;
    }
}
