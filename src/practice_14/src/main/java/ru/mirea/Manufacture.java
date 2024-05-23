package ru.mirea;

public class Manufacture {
    String name;
    String address;
    Worker worker;

    public Manufacture(String name, String address, Worker worker) {
        this.name = name;
        this.address = address;
        this.worker = worker;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
