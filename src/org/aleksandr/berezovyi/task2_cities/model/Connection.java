package org.aleksandr.berezovyi.task2_cities.model;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Connection that = (Connection) o;

        return fromCityId == that.fromCityId && toCityId == that.toCityId;

    }

    @Override
    public int hashCode() {
        int result = fromCityId;
        result = 31 * result + toCityId;
        return result;
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
