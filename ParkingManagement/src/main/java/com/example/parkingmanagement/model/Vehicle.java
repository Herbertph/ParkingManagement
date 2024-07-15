package com.example.parkingmanagement.model;


import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicles")
public class Vehicle {

    @Id
    private String id;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    private String color;
    @NotNull
    private String plate;
    @NotNull
    private VehicleType type;

    public Vehicle (){}

    public Vehicle(String id, String brand, String model, String color, String plate, VehicleType type) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.plate = plate;
        this.type = type;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", plate='" + plate + '\'' +
                ", type=" + type +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NotNull String getBrand() {
        return brand;
    }

    public void setBrand(@NotNull String brand) {
        this.brand = brand;
    }

    public @NotNull String getModel() {
        return model;
    }

    public void setModel(@NotNull String model) {
        this.model = model;
    }

    public @NotNull String getColor() {
        return color;
    }

    public void setColor(@NotNull String color) {
        this.color = color;
    }

    public @NotNull String getPlate() {
        return plate;
    }

    public void setPlate(@NotNull String plate) {
        this.plate = plate;
    }

    @NotNull
    public VehicleType getType() {
        return type;
    }

    public void setType(@NotNull VehicleType type) {
        this.type = type;
    }

}

