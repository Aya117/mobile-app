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

    public static final phone[] phones = {
            new phone("Iphone 12", R.drawable.iphone12,"Screen: 6.1 inch","Operating System: iOS 14", "Battery: 2815 mAh"," Memory: 64 GB", "Weight: 164 gram","price:3500"),
            new phone("Redmi 8 Pro", R.drawable.redmi8pro,"Screen: 6.53 inch"," Operating System: Android 9.0 pie", "Battery: 4500 mAh", "Memory: 256 GB", "Weight: 199 gram","price:850"),
            new phone("Redmi Note 9 Pro Max", R.drawable.redmi, "Screen: 6.67 inch", "Operating System: Android 10" ," Battery: 5020 mAh", "Memory: 64 GB"," Weight: 209 gram","price:1000"),
            new phone("Iphone 10", R.drawable.iphone10," Screen: 5.8 inch","Operating System: iOS 13.6.1.", "Battery: 2716 mAh" , "Memory: 64/256 GB"," Weight: 174 gram","price:2000"),
            new phone("Redmi Note 10", R.drawable.note10," Screen: 6.57 inch", "Operating System: Android 10", "Battery: 4800 mAh", "Memory: 256/64 GB", "Weight: 210 gram","price:900" ),
            new phone("Samsung s10", R.drawable.s10,"Screen: 6.2 inch","Operating System: Android 10", "Battery: 4000 mAh", "Memory:128 GB", "Weight: 190 gram","1100"),
            new phone("Samsung s20 ultra", R.drawable.ulto," Screen: 6.2 inch","Operating System: Android 10", "Battery: 4000 mAh"," Memory:128 GB"," Weight: 190 gram","price:1300"),
            new phone("nokia lumia", R.drawable.nokia, " Screen 4.5 inch", "Operating System: Android 8.1", "Battery: 2000 mAh"," Memory:8 GB"," Weight: 174 gram","price:1100"),
            new phone("oopo a53", R.drawable.oopo," Screen 6.5 inch", "Operating System: Android 10", "Battery: 5000 mAh", "Memory:64/128 GB"," Weight: 200 gram","price:950"),
            new phone("relmi 7 pro", R.drawable.relmi,"Screen 6.4 inch", "Operating System: Android 10", "Battery: 4500 mAh", "Memory:128 GB"," Weight: 190 gram","price:750"),

    };

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



