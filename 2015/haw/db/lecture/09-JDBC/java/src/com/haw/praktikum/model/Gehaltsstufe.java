package com.haw.praktikum.model;

public enum Gehaltsstufe {
    IT1, IT2, IT3, IT4, IT5, IT6;

    public String toString() {
        return name().toLowerCase();
    }

    public static Gehaltsstufe create(final String name) {
        return valueOf(name.toUpperCase());
    }
}
