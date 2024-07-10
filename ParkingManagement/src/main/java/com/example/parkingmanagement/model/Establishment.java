package com.example.parkingmanagement.model;


import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "establishments")
public class Establishment {

    @Id
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String cnpj;
    @NotNull
    private String address;
    @NotNull
    private String phone;
    @NotNull
    private int motorcycleSpots;
    @NotNull
    private int carSpots;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMotorcycleSpots() {
        return motorcycleSpots;
    }

    public void setMotorcycleSpots(int motorcycleSpots) {
        this.motorcycleSpots = motorcycleSpots;
    }

    public int getCarSpots() {
        return carSpots;
    }

    public void setCarSpots(int carSpots) {
        this.carSpots = carSpots;
    }


    public Establishment(){

    }
    public Establishment(String id, String name, String cnpj, String address, String phone, int motorcycleSpots, int carSpots) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.address = address;
        this.phone = phone;
        this.motorcycleSpots = motorcycleSpots;
        this.carSpots = carSpots;
    }

//toString()
    @Override
    public String toString(){
        return "Establishment{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", motorcycleSpots=" + motorcycleSpots +
                ", carSpots=" + carSpots +
                '}';
    }


}
