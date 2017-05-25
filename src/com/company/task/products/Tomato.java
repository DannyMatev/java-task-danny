package com.company.task.products;

public class Tomato extends Product {
    private String variety;
    private String type;

    public Tomato(String serialNumber, String quality, String variety) {
        this.serialNumber = serialNumber;
        this.quality = quality;
        this.variety = variety;
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
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
