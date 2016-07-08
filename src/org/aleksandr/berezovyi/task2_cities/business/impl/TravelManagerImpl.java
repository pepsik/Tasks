package org.aleksandr.berezovyi.task2_cities.business.impl;

import org.aleksandr.berezovyi.task2_cities.business.CityManager;
import org.aleksandr.berezovyi.task2_cities.business.TravelManager;
import org.aleksandr.berezovyi.task2_cities.model.City;
import org.aleksandr.berezovyi.task2_cities.model.Path;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by pepsik on 7/5/2016.
 */
public class TravelManagerImpl implements TravelManager {
    public static final int INF = 1_000;

    private Set<Path> paths = new HashSet<>();
    private CityManager cityManager;

    public TravelManagerImpl(CityManager cityManager) {
        this.cityManager = cityManager;
    }

    @Override
    public void addPath(int srcId, int destId, int cost) {
        Path path = new Path(srcId, destId, cost);
        paths.add(path);
    }

    @Override
    public Set<Path> findAllPaths(City src) {
        return paths.stream().filter(path -> path.getSrcId() == src.getId()).collect(Collectors.toSet());
    }

    /**
     * Using Dijkstra's algorithm to find the shortest ways to move from one first city to each other city in the graph
     **/
    @Override
    public int findLowerCostPath(City src, City dest) {
        List<City> cityList = new ArrayList<>(cityManager.getAll());
        int[] travelCosts = new int[cityList.size()]; // accumulate minimum travel costs through each city
        boolean[] exploredCity = new boolean[cityList.size()];
        int currCityId = src.getId();
        Arrays.fill(travelCosts, INF); //All travel costs are INF
        travelCosts[currCityId - 1] = 0; //except src

        //Iterate
        for (int i = 0; i < cityList.size(); i++) {
            int minCost = INF;
            // if we get destination, ignore, it will be last explored city
            if (currCityId != dest.getId())
                exploredCity[currCityId - 1] = true;
            //find all paths of city to iterate
            Set<Path> paths = findAllPaths(cityList.get(currCityId - 1));
            for (Path path : paths) {
                if (exploredCity[path.getDestId() - 1])
                    continue;
                //if from city cost + path cost < to city cost, then assign new value
                if (path.getCost() + travelCosts[path.getSrcId() - 1] < travelCosts[path.getDestId() - 1]) {
                    travelCosts[path.getDestId() - 1] = travelCosts[path.getSrcId() - 1] + path.getCost();
                }
                //find minimum path cost of cur city
                if (path.getCost() < minCost) {
                    minCost = path.getCost();
                    currCityId = path.getDestId();
                }
            }
            //to find remaining not explored cities
            if (minCost == INF) {
                for (int j = 0; j < exploredCity.length; j++) {
                    if (!exploredCity[j] && dest.getId() != (j + 1) && travelCosts[j] != INF) {
                        currCityId = j + 1;
                    }
                }
            }
        }
        //last explored city is destination
        exploredCity[dest.getId() - 1] = true;

        return travelCosts[dest.getId() - 1];
    }

    public Set<Path> getAll() {
        return paths;
    }
}
