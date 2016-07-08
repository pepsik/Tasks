package org.aleksandr.berezovyi.task2_cities.model;

/**
 * Created by pepsik on 7/5/2016.
 */
public class Path {
    private int srcId;
    private int destId;
    private int cost;

    public Path(int src, int dest, int cost) {
        this.srcId = src;
        this.destId = dest;
        this.cost = cost;
    }

    public int getSrcId() {
        return srcId;
    }

    public int getDestId() {
        return destId;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Path that = (Path) o;

        return srcId == that.srcId && destId == that.destId;
    }

    @Override
    public int hashCode() {
        int result = srcId;
        result = 31 * result + destId;
        return result;
    }

    @Override
    public String toString() {
        return "Path{" +
                "between " + srcId +
                " and " + destId +
                " cost=" + cost +
                '}';
    }
}
