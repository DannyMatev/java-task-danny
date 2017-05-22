package com.company.task;

public class Bread extends Product {
    private String flour;

    public String getFlour() {
        return flour;
    }

    public void setFlour(String flour) {
        this.flour = flour;
    }

    @Override
    public String getType() {
        return "Bread";
    }

    @Override
    public String getOrigin() {
        return getFlour();
    }

    @Override
    void calculatePrice() {
        switch (quality) {
            case "1":
                price = 2;
                break;
            case "2":
                price = 1.5;
                break;
            case "3":
                price = 1;
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bread)) return false;
        if (!super.equals(o)) return false;

        Bread bread = (Bread) o;

        return flour != null ? flour.equals(bread.flour) : bread.flour == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (flour != null ? flour.hashCode() : 0);
        return result;
    }
}
