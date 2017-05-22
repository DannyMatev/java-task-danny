package com.company.task;

public class Tomato extends Product {
    private String variety;

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    @Override
    public String getType() {
        return "Tomato";
    }

    @Override
    public String getOrigin() {
        return getVariety();
    }

    @Override
    void calculatePrice() {
        switch (quality) {
            case "1":
                price = 6;
                break;
            case "2":
                price = 4.50;
                break;
            case "3":
                price = 2;
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tomato)) return false;
        if (!super.equals(o)) return false;

        Tomato tomato = (Tomato) o;

        return variety != null ? variety.equals(tomato.variety) : tomato.variety == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (variety != null ? variety.hashCode() : 0);
        return result;
    }
}
