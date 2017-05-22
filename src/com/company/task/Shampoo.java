package com.company.task;

public class Shampoo extends Product {
    private String specialization;

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String getType() {
        return "Shampoo";
    }

    @Override
    public String getOrigin() {
        return getSpecialization();
    }

    @Override
    void calculatePrice() {
        switch (quality) {
            case "1":
                price = 12;
                break;
            case "2":
                price = 8;
                break;
            case "3":
                price = 4.50;
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shampoo)) return false;
        if (!super.equals(o)) return false;

        Shampoo shampoo = (Shampoo) o;

        return specialization != null ? specialization.equals(shampoo.specialization) : shampoo.specialization == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (specialization != null ? specialization.hashCode() : 0);
        return result;
    }
}
