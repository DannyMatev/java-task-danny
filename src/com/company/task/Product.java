package com.company.task;

public class Product {
    private String serialNumber;
    private String type;
    private String quality;
    private String origin;
    private double price;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void calculatePrice() {
        switch (type) {
            case "Bread":
                switch (quality) {
                    case "1":
                        price = 2.00;
                        break;
                    case "2":
                        price = 1.50;
                        break;
                    case "3":
                        price = 1.00;
                        break;
                }
                break;
            case "Cheese":
                switch (quality) {
                    case "1":
                        price = 15.00;
                        break;
                    case "2":
                        price = 12.00;
                        break;
                    case "3":
                        price = 6.00;
                        break;
                }
                break;
            case "Tomato":
                switch (quality) {
                    case "1":
                        price = 6.00;
                        break;
                    case "2":
                        price = 4.50;
                        break;
                    case "3":
                        price = 2.00;
                        break;
                }
                break;
        }
    }

}
