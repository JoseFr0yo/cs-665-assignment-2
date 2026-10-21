/**
 * Name: Jose Andres Leal
 * Course: CS-665 Software Design & Patterns
 * Date: 10/20/2026
 * File Name: Shop.java
 * Description: A shop that creates delivery requests received by available drivers.
 */

package edu.bu.met.cs665.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A shop broadcasting delivery requests to drivers is the concrete subject,
 * Drivers register when available, and when an order comes in, it pushes a
 * DeliveryRequest to every driver registered.
 */
public class Shop implements DeliverySubject {

    private final String name;
    private final List<DeliveryObserver> drivers = new ArrayList<>();

    /**
     * Creates a shop.
     *
     * @param name the shop's name
     * @throws NullPointerException if the name is null
     */
    public Shop(String name) {
        this.name = Objects.requireNonNull(name, "name");
    }

    /**
     * Registers a driver, if the driver is already registered it will not be added again.
     *
     * @param driver the driver being registered
     * @throws NullPointerException if the driver is null
     */
    @Override
    public void registerDriver(DeliveryObserver driver) {
        Objects.requireNonNull(driver, "driver");
        if (!drivers.contains(driver)) {
            drivers.add(driver);
        }
    }

    /**
     * Removes a driver.
     *
     * @param driver the driver being removed
     */
    @Override
    public void removeDriver(DeliveryObserver driver) {
        drivers.remove(driver);
    }

    /**
     * Pushes a delivery request to all registered drivers.
     *
     * @param request the delivery request to be broadcast
     * @throws NullPointerException if request is null
     */
    @Override
    public void notifyDrivers(DeliveryRequest request) {
        Objects.requireNonNull(request, "request");
        for (DeliveryObserver driver : new ArrayList<>(drivers)) {
            driver.update(request);
        }
    }

    /**
     * Creates a delivery request and broadcasts it to all registered drivers.
     *
     * @param product the item/product being delivered
     * @param destination the address it's being delivered to
     * @return the delivery request which was broadcast
     */
    public DeliveryRequest createDeliveryRequest(String product, String destination) {
        DeliveryRequest request = new DeliveryRequest(name, product, destination);
        notifyDrivers(request);
        return request;
    }

    /**
     * Returns the name of the shop.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
}
