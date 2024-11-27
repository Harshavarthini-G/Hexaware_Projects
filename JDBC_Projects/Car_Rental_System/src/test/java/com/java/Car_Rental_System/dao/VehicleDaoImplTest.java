package com.java.Car_Rental_System.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.java.Car_Rental_System.model.Vehicle;

public class VehicleDaoImplTest {

    private VehicleDaoImpl vehicleDao;

    @BeforeEach
    public void setUp() {
        vehicleDao = new VehicleDaoImpl();
    }

    @Test
    public void testInsertVehicle() throws SQLException, ClassNotFoundException {
        boolean isInserted = vehicleDao.insertVehicle("V001", "Toyota", "Camry", 100, "Available", 5, "2.5L");
        assertTrue(isInserted, "Vehicle should be inserted successfully");
    }

    @Test
    public void testSearchByVehId() throws SQLException, ClassNotFoundException {
        vehicleDao.insertVehicle("V002", "Honda", "Accord", 120, "Available", 5, "2.0L");
        Vehicle vehicle = vehicleDao.searchByVehId("V002");
        assertNotNull(vehicle, "Vehicle should be found for ID: V002");
        assertEquals("V002", vehicle.getVehicle_ID(), "Vehicle ID should match");
        assertEquals("Honda", vehicle.getMake(), "Vehicle make should match");
        assertEquals("Accord", vehicle.getModel(), "Vehicle model should match");
    }

    @Test
    public void testSearchByCapacity() throws SQLException, ClassNotFoundException {
        vehicleDao.insertVehicle("V003", "Ford", "Escape", 90, "Available", 5, "1.5L");
        List<Vehicle> vehicles = vehicleDao.searchByCapacity(5);
        assertNotNull(vehicles, "Vehicle list should not be null");
        assertFalse(vehicles.isEmpty(), "Vehicle list should not be empty");
    }

    @Test
    public void testDelVehicle() throws SQLException, ClassNotFoundException {
        vehicleDao.insertVehicle("V004", "Chevrolet", "Malibu", 110, "Available", 5, "1.8L");
        boolean isDeleted = vehicleDao.DelVehicle("V004");
        assertTrue(isDeleted, "Vehicle should be deleted successfully");
    }

    @Test
    public void testShowVehDao() throws SQLException, ClassNotFoundException {
        vehicleDao.insertVehicle("V005", "Nissan", "Altima", 95, "Available", 5, "2.5L");
        List<Vehicle> vehicles = vehicleDao.showVehDao();
        assertNotNull(vehicles, "Vehicle list should not be null");
        assertTrue(vehicles.size() > 0, "Vehicle list should contain at least one vehicle");
    }
}
