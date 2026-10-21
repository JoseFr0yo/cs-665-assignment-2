/**
 * Name: Jose Andres Leal
 * Course: CS-665 Software Design & Patterns
 * Date: 10/20/2026
 * File Name: TestDeliverySystem.java
 * Description: JUnit tests for the delivery request notifications.
 */

package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import edu.bu.met.cs665.delivery.DeliveryRequest;
import edu.bu.met.cs665.delivery.Driver;
import edu.bu.met.cs665.delivery.Shop;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the observer delivery system
 */
public class TestDeliverySystem {

    private Shop shop;
    private List<Driver> drivers;

    /**
     * Creates a shop and five registered drivers for each test
     */
    @Before
    public void setUp() {
        shop = new Shop("Market Basket");
        drivers = new ArrayList<>();
        drivers.add(new Driver("Alex", "Van"));
        drivers.add(new Driver("Freddy", "Scooter"));
        drivers.add(new Driver("Jonas", "Sudan"));
        drivers.add(new Driver("Lawrence", "Van"));
        drivers.add(new Driver("Kim", "Scooter"));
        for (Driver driver : drivers) {
            shop.registerDriver(driver);
        }
    }

    @Test
    public void testBroadcastNotifiesAllFiveDrivers() {
        /**
         * When shop receives an order, and broadcasts one request
         */
        DeliveryRequest request = shop.createDeliveryRequest("Groceries", "Questrom Building");

        /**
         * All drivers receive same request.
         */
        for (Driver driver : drivers) {
            assertEquals(1, driver.getReceivedRequests().size());
            DeliveryRequest received = driver.getReceivedRequests().get(0);
            assertSame(request, received);
            assertEquals("Market Basket", received.getShopName());
            assertEquals("Groceries", received.getProduct());
            assertEquals("Questrom Building", received.getDestination());
        }
    }

    @Test
    public void testRemovedDriverIsNotNotified() {
        /**
         * Driver gets busy, and unregisters
         */
        Driver busyDriver = drivers.get(1);
        shop.removeDriver(busyDriver);

        /**
         * When a new request is broadcast
         */
        shop.createDeliveryRequest("Assignment 2", "CAS Building");

        /**
         * Then the busy driver does not receive the notification,
         * but the other four do.
         */
        assertTrue(busyDriver.getReceivedRequests().isEmpty());
        for (Driver driver : drivers) {
            if (driver != busyDriver) {
                assertEquals(1, driver.getReceivedRequests().size());
            }
        }
    }

    @Test
    public void testDuplicateRegistrationNotifiesOnce() {
        /**
         * A driver who is registered, registers again
         */
        Driver driver = drivers.get(0);
        shop.registerDriver(driver);

        /**
         * When a request is broadcast
         */
        shop.createDeliveryRequest("BLT", "Downtown Crossing");

        /**
         * Then the driver is only notified once.
         */
        assertEquals(1, driver.getReceivedRequests().size());
    }

    @Test
    public void testBroadcastWithNoDriversDoesNotFail() {
        /**
         * shop with no registered drivers
         */
        Shop emptyShop = new Shop("Empty Shop");

        /**
         * When a request is broadcast
         */
        DeliveryRequest request = emptyShop.createDeliveryRequest("Laptop", "METCS Building");

        /**
         * Then the request is created anyway
         */
        assertEquals("Empty Shop", request.getShopName());
        assertEquals("Laptop", request.getProduct());
    }

    @Test
    public void testDeliveryRequestRejectsNullValues() {
        assertThrows(NullPointerException.class,
                () -> new DeliveryRequest(null, "Groceries", "Questrom Building"));
        assertThrows(NullPointerException.class,
                () -> shop.createDeliveryRequest("Groceries", null));
        assertThrows(NullPointerException.class, () -> shop.registerDriver(null));
    }
}
