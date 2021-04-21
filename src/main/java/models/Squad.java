package models;

public class Squad {
    private int maxSize;
    private String name;


    public Squad(String name,int maxSize,String cause){
        this.name = name;
        this.maxSize = maxSize;

    }

    public String getName() {
        return name;
    }

    public int getMaxSize() {
        return maxSize;
    }

}