package com.company.task.products;

public class Cheese extends Product {
    private String milk;
    private String type;

    public Cheese(String serialNumber, String quality, String milk) {
        this.serialNumber = serialNumber;
        this.quality = quality;
        this.milk = milk;
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    @Override
    void calculatePrice() {
        switch (quality) {
            case "1":
                price = 15;
                break;
            case "2":
                price = 12;
                break;
            case "3":
                price = 6;
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cheese)) return false;
        if (!super.equals(o)) return false;

        Cheese cheese = (Cheese) o;

        return milk != null ? milk.equals(cheese.milk) : cheese.milk == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (milk != null ? milk.hashCode() : 0);
        return result;
    }
}
