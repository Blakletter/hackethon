package com.group.hackethon.models;

public class Response {
    private String distance;
    private String time;
    private double car;
    private double bus;
    private double airplane;
    private double train;
    private double motorcycle;
    private double hybrid;
    private double running;
    private double miles;

    public Response(String distance, String time, double car, double bus, double airplane, double train, double motorcycle, double hybrid, double running, double miles) {
        this.distance = distance;
        this.time = time;
        this.car = car;
        this.bus = bus;
        this.airplane = airplane;
        this.train = train;
        this.motorcycle = motorcycle;
        this.hybrid = hybrid;
        this.running = running;
        this.miles = miles;
    }

    public double getMiles() {
        return miles;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getCar() {
        return car;
    }

    public void setCar(double car) {
        this.car = car;
    }

    public double getBus() {
        return bus;
    }

    public void setBus(double bus) {
        this.bus = bus;
    }

    public double getAirplane() {
        return airplane;
    }

    public void setAirplane(double airplane) {
        this.airplane = airplane;
    }

    public double getTrain() {
        return train;
    }

    public void setTrain(double train) {
        this.train = train;
    }

    public double getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(double motorcycle) {
        this.motorcycle = motorcycle;
    }

    public double getHybrid() {
        return hybrid;
    }

    public void setHybrid(double hybrid) {
        this.hybrid = hybrid;
    }

    public double getRunning() {
        return running;
    }

    public void setRunning(double running) {
        this.running = running;
    }
}
