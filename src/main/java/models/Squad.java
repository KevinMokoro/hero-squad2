package models;

import java.util.ArrayList;

public class Squad {
    private String cause;
    private int maxSize;
    private String name;
    private static ArrayList<Squad> instances = new ArrayList<>();


    public Squad(String name,int maxSize,String cause){
        this.name = name;
        this.maxSize = maxSize;
        this.cause = cause;
        instances.add(this);

    }

    public String getName() {
        return name;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public String getCause() {
        return cause;
    }
    public static ArrayList<Squad> getAll() {
        return instances;
    }
    public static void clearAllSquads() {
        instances.clear();
    }

}