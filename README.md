# Parking Management System

## Overview
A robust Spring Boot application designed to manage parking establishments and vehicle operations. This system provides a comprehensive solution for tracking vehicles, managing parking spaces, and maintaining parking records with secure API endpoints.

## Features
- **Establishment Management**
  - Create and manage parking establishments
  - Configure establishment details and capacity
  - Track establishment status and availability

- **Vehicle Management**
  - Support for different vehicle types
  - Vehicle registration and tracking
  - Vehicle history and status monitoring

- **Parking Operations**
  - Real-time parking record management
  - Entry and exit tracking
  - Duration calculation and history maintenance

- **Security**
  - Spring Security integration
  - Protected API endpoints
  - Role-based access control

## Technology Stack
- **Backend Framework**: Spring Boot 3.3.1
- **Java Version**: Java 22
- **Database**: MongoDB
- **Security**: Spring Security
- **Additional Features**:
  - Spring Boot Actuator for monitoring
  - Spring Data MongoDB for database operations
  - Spring Validation for data validation
  - Lombok for reducing boilerplate code
  - Spring DevTools for development convenience

## Project Structure

## Requirements

- Java 22
- MongoDB

## Setup and Installation

1. **Clone the repository**

2. **Configure MongoDB**
Make sure MongoDB is installed and running. You can download and install MongoDB from 
https://www.mongodb.com/try/download/community

3. **Configure MongoDB**
Update the src/main/resources/application.properties file with your MongoDB connection details if needed. The default configuration is:

spring.application.name=ParkingManagement
spring.data.mongodb.uri=mongodb://localhost:27017/parking

4. **Run the application**


## API Endpoints

### Establishments

* Create an establishment

POST /api/establishments

{
  "name": "Parking Lot A",
  "cnpj": "12345678901234",
  "address": "123 Main St",
  "phone": "123-456-7890",
  "motorcycleSpots": 10,
  "carSpots": 50
}

* Get all establishments

GET /api/establishments

* Get establishment by ID

GET /api/establishments/{id}

* Update establishment

PUT /api/establishments/{id}

{
  "name": "Parking Lot B",
  "cnpj": "12345678901234",
  "address": "456 Elm St",
  "phone": "987-654-3210",
  "motorcycleSpots": 15,
  "carSpots": 55
}

* Delete establishment

DELETE /api/establishments/{id}

### Vehicles

* Create an Vehicle

POST /api/vehicles

{
  "brand": "Toyota",
  "model": "Corolla",
  "color": "Blue",
  "plate": "ABC-1234",
  "type": "CAR"
}

* Get all vehicles

GET /api/vehicles

* Get vehicles by ID

GET /api/vehicles/{id}

* Update vehicles

PUT /api/vehicles/{id}

{
  "brand": "Honda",
  "model": "Civic",
  "color": "Red",
  "plate": "XYZ-5678",
  "type": "CAR"
}

* Delete vehicles

DELETE /api/vehicles/{id}

### Parking Records

* Register vehicle entry

POST /api/parkingRecords/entry

{
  "vehicleId": "668ff5e0e537f5243d5b4586",
  "establishmentId": "668eda54cb7f862723f68290"
}

* Register vehicle exit

POST /api/parkingRecords/exit

{
  "vehicleId": "668ff5e0e537f5243d5b4586"
}

### Reports

GET /api/reports/summary
