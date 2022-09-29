package com.alireza.model;

import java.util.Objects;

public class League {
    private String name;
    private String type;

    public League(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        League league = (League) o;
        return name.equals(league.name) && type.equals(league.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        return "League{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
