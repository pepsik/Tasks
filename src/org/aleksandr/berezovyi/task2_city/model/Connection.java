package org.aleksandr.berezovyi.task2_city.model;

/**
 * Created by pepsik on 7/5/2016.
 */
public class Connection {
    private int fromCityId;
    private int toCityId;
    private int cost;

    public Connection(int from, int to, int cost) {
        this.fromCityId = from;
        this.toCityId = to;
        this.cost = cost;
    }

    public int getFromCityId() {
        return fromCityId;
    }

    public int getToCityId() {
        return toCityId;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "between " + fromCityId +
                " and " + toCityId +
                " cost=" + cost +
                '}';
    }
}
