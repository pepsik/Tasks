package org.aleksandr.berezovyi.task2_city.model;

/**
 * Created by pepsik on 7/5/2016.
 */
public class City {
    public static int counter = 0;

    private int id;
    private String name;

    public City(String name, int numberOfNeighbours) {
        this.id = ++counter;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
