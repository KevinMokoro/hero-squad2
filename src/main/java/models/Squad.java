package models;

import java.util.ArrayList;

public class Squad {
    private String cause;
    private int maxSize;
    private String name;
    private static ArrayList<Squad> instances = new ArrayList<>();
    private int id;


    public Squad(String name,int maxSize,String cause){
        this.name = name;
        this.maxSize = maxSize;
        this.cause = cause;
        instances.add(this);
        this.id = instances.size();

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

    public int getId() {
        return id;
    }
    public static Squad findById(int id){
        return instances.get(id-1);
    }
    public void update(String name,int maxSize,String cause){
        this.name = name;
        this.maxSize = maxSize;
        this.cause = cause;
    }
    public void delete() {
        instances.remove(id-1);
    }


}