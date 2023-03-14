package ru.rsreu.kibamba.linter.model;

public class Dorm {
    private final long number;
    private final String address;

    private final String telephone;

    public Dorm(long number, String address, String telephone) {
        this.number = number;
        this.address = address;
        this.telephone = telephone;
    }

    public long getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }
}
