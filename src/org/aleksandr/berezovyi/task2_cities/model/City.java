package org.aleksandr.berezovyi.task2_cities.model;

/**
 * Created by pepsik on 7/5/2016.
 */
public class City {
    private int id;
    private String name;

    public City(String name, int id) {
        this.id = id;
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
