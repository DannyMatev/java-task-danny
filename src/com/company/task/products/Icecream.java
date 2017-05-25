package com.company.task.products;

public class Icecream extends Product {
    private String flavour;

    public Icecream(String serialNumber, String quality, String flavour) {
        this.serialNumber = serialNumber;
        this.quality = quality;
        this.flavour = flavour;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
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
        if (!(o instanceof Icecream)) return false;
        if (!super.equals(o)) return false;

        Icecream icecream = (Icecream) o;

        return flavour != null ? flavour.equals(icecream.flavour) : icecream.flavour == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (flavour != null ? flavour.hashCode() : 0);
        return result;
    }
}
