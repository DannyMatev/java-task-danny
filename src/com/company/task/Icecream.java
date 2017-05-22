package com.company.task;

/**
 * Created by daniel.matev on 22.5.2017 г..
 */
public class Icecream extends Product {
    private String flavour;

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    @Override
    public String getType() {
        return "Icecream";
    }

    @Override
    public String getOrigin() {
        return getFlavour();
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
