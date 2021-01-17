package edu.cs.birzeit.mobileapp;

public class phone {
    private String name;
    private int imageID;
    private String ScreenSize;
    private String operatingSystem;
    private String battery;
    private String Memory;
    private String weight;
    private String price;


    public phone(String name, int imageID, String screenSize, String operatingSystem, String battery, String memory,
                 String weight, String price) {
        super();
        this.name = name;
        this.imageID = imageID;
        ScreenSize = screenSize;
        this.operatingSystem = operatingSystem;
        this.battery = battery;
        Memory = memory;
        this.weight = weight;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getImageID() {
        return imageID;
    }
    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
    public String getScreenSize() {
        return ScreenSize;
    }
    public void setScreenSize(String screenSize) {
        ScreenSize = screenSize;
    }
    public String getOperatingSystem() {
        return operatingSystem;
    }
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
    public String getBattery() {
        return battery;
    }
    public void setBattery(String battery) {
        this.battery = battery;
    }
    public String getMemory() {
        return Memory;
    }
    public void setMemory(String memory) {
        Memory = memory;
    }
    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

}



