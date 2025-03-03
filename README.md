# Parking Management System

## Overview
A comprehensive parking management solution designed to efficiently manage parking spaces, vehicle entry/exit, and fee calculation. This system handles multiple vehicle types (cars, motorcycles, and trucks) with a clean MVC architecture.

## Features
- **Multi-vehicle support**: Separately manages parking spaces for cars, motorcycles, and trucks
- **Real-time availability tracking**: Monitors available spaces for each vehicle type
- **Automated ticket generation**: Creates tickets upon vehicle entry with timestamps
- **Dynamic fee calculation**: Calculates parking fees based on duration and vehicle type
- **In-memory data storage**: Utilizes in-memory repositories for data management
- **Console interface**: Simple text-based user interface for system interaction

## System Architecture
The project follows the MVC (Model-View-Controller) design pattern:
- **Model**: Repositories and domain objects representing the parking system state
- **View**: Console interface for user interaction
- **Controller**: Coordinates actions between the view and service layer
- **Service Layer**: Contains business logic for parking operations and fee calculation

## Technical Components
- **Repositories**: 
  - `ParkingRepository`: Manages parking spaces and availability
  - `TicketRepository`: Handles parking ticket creation and retrieval
- **Services**:
  - `ParkingService`: Coordinates parking operations
  - `FeeCalculationService`: Calculates parking fees based on duration
- **Configuration**:
  - `AppConfig`: Provides dependency injection and component configuration

## Setup
1. Clone the repository
2. Open the project in NetBeans
3. Build and run the application

## Usage
The system supports the following operations:
- Park vehicles (car, motorcycle, truck)
- Check parking availability
- Retrieve vehicle with fee calculation
- View parking statistics

## Value Proposition
This parking management system delivers value through:

1. **Operational Efficiency**: Automates parking management, reducing manual errors and paperwork
2. **Resource Optimization**: Provides real-time insights into parking space utilization
3. **Revenue Management**: Ensures accurate fee calculation and collection
4. **Scalability**: Modular design allows for easy expansion to additional vehicle types or pricing models
5. **Maintenance Simplicity**: Clear separation of concerns makes the system easy to maintain and extend
6. **Learning Value**: Demonstrates clean code principles, design patterns, and Java programming best practices

## Technical Implementation
The system is built using:
- Java programming language
- OOP principles (encapsulation, inheritance, polymorphism)
- Design patterns (MVC, Singleton, Repository)
- In-memory data stores
- Clean code practices
