# Smart Parking Lot System (Low-Level Design)

A modular and scalable Low-Level Design (LLD) implementation of a Parking Lot System using Java and Object-Oriented Design Principles.

## Architecture Design
The following diagram illustrates the class relationships and the high-level architecture of the system.

![System Architecture Diagram](ParkingLot_LLD_Architecture.png)

## Key Features
* **Modular Architecture:** Clean separation of concerns using distinct packages for models, managers, factories, and strategies.
* **Design Patterns Implemented:**
    * **Factory Pattern:** Used for creating Vehicle and ParkingSpotManager objects dynamically based on input types.
    * **Strategy Pattern:** Implemented to handle distinct pricing algorithms for different vehicle types (e.g., hourly for bikes, minute-based for cars) without modifying existing code.
* **Scalability:** The design easily supports adding new vehicle types or spot types in the future.
* **Robust Pricing Logic:** Includes real-time calculation based on entry/exit times, minimum charge validation, and type-specific rates.
* **Encapsulation:** Ensures data security by using private variables accessed via public getter/setter methods.

## Tech Stack
* **Language:** Java (JDK 17+)
* **Core Concepts:** Polymorphism, Inheritance, Encapsulation, Abstraction (OOPs)
* **Version Control:** Git, GitHub

## Project Structure Overview
```text
ParkingLot/
├── models/         # Data entities (Vehicle, Ticket, ParkingSpot subtypes)
├── strategies/     # Pricing logic implementations (CostComputation interfaces)
├── managers/       # Core business logic for managing spots
├── factories/      # Centralized object creation logic
├── gates/          # Entry and Exit point operations
├── Main.java       # Application entry point and simulation demo
└── ParkingLot_LLD_Architecture.png # System Design Diagram     