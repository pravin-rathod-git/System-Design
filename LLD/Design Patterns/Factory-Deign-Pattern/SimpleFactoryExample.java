// ============================================================================
// Product Interface
// ============================================================================

/**
 * Common interface for all vehicle types.
 * Every vehicle must provide its own implementation of the drive() method.
 */
interface Vehicle {
    void drive();
}

// ============================================================================
// Concrete Product - Car
// ============================================================================

/**
 * Represents a Car object.
 */
class Car implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving a Car 🚗");
    }
}

// ============================================================================
// Concrete Product - Bike
// ============================================================================

/**
 * Represents a Bike object.
 */
class Bike implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving a Bike 🏍");
    }
}

// ============================================================================
// Concrete Product - Truck
// ============================================================================

/**
 * Represents a Truck object.
 */
class Truck implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving a Truck 🚚");
    }
}

// ============================================================================
// Factory Class
// ============================================================================

/**
 * Responsible for creating Vehicle objects.
 * The client requests a vehicle from this factory instead of creating it directly.
 */
class VehicleFactory {

    /**
     * Returns the appropriate Vehicle object based on the given type.
     *
     * @param type Type of vehicle to create
     * @return Vehicle object
     */
    public static Vehicle getVehicle(String type) {

        // Return null if no type is provided.
        if (type == null) {
            return null;
        }

        // Create and return a Car object.
        if (type.equalsIgnoreCase("CAR")) {
            return new Car();
        }

        // Create and return a Bike object.
        if (type.equalsIgnoreCase("BIKE")) {
            return new Bike();
        }

        // Create and return a Truck object.
        if (type.equalsIgnoreCase("TRUCK")) {
            return new Truck();
        }

        // Return null if the requested vehicle type is not supported.
        return null;
    }
}

// ============================================================================
// Client
// ============================================================================

/**
 * Demonstrates the usage of the Simple Factory.
 */
public class SimpleFactoryExample {

    public static void main(String[] args) {

        // Request a Car object from the factory.
        Vehicle car = VehicleFactory.getVehicle("CAR");
        car.drive();

        // Request a Bike object from the factory.
        Vehicle bike = VehicleFactory.getVehicle("BIKE");
        bike.drive();

        // Request a Truck object from the factory.
        Vehicle truck = VehicleFactory.getVehicle("TRUCK");
        truck.drive();

        // Request an unsupported vehicle.
        Vehicle bus = VehicleFactory.getVehicle("BUS");

        // Check whether the factory returned a valid object.
        if (bus == null) {
            System.out.println("Vehicle type not supported.");
        }
    }
}