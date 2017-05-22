package com.company.task;

public class Cheese extends Product {
    private String milk;

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    @Override
    public String getType() {
        return "Cheese";
    }

    @Override
    public String getOrigin() {
        return getMilk();
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
