package com.java.Car_Rental_System.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.java.Car_Rental_System.model.Payment;

public class PaymentDaoImplTest {

    private PaymentDaoImpl paymentDao;

    @BeforeEach
    public void setUp() {
        paymentDao = new PaymentDaoImpl();
    }

    @Test
    public void testInsertPayment() throws SQLException, ClassNotFoundException {
        String payid = "P001";
        String leid = "L001";
        Date paymentDate = Date.valueOf("2024-11-25");
        double amount = 500.0;
    }

    @Test
    public void testShowByLeaseID() throws SQLException, ClassNotFoundException {
        String leid = "L001";
        Payment payment = paymentDao.ShowByLeaseID(leid);
    }

    @Test
    public void testPendingPayments() throws SQLException, ClassNotFoundException {
        List<Payment> pendingPayments = paymentDao.PendingPayments();
    }
}
