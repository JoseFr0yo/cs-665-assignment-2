/**
 * Name: Jose Andres Leal
 * Course: CS-665 Software Design & Patterns
 * Date: 10/20/2026
 * File Name: Driver.java
 * Description: Driver that receives delivery request broadcasts.
 */

package edu.bu.met.cs665.delivery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The Driver is the concrete observer, when a shop broadcasts a delivery request,
 * the driver's DeliveryRequest is called and recorded
 */
public class Driver implements DeliveryObserver {
    private final String name;
    private final String vehicleType;
    private final List<DeliveryRequest> receivedRequests = new ArrayList<>();

    /**
     * Creates a driver.
     *
     * @param name is the driver's name
     * @param vehicleType is the type of vehicle the driver is using
     * @throws NullPointerException if an argument is null
     */
    public Driver(String name, String vehicleType) {
        this.name = Objects.requireNonNull(name, "name");
        this.vehicleType = Objects.requireNonNull(vehicleType, "vehicleType");
    }

    /**
     * Records a request broadcast by a shop.
     *
     * @param request the delivery request being broadcast
     */
    @Override
    public void update(DeliveryRequest request) {
        receivedRequests.add(request);
    }

    /**
     * Returns a list of received requests
     *
     * @return read-only list of requests received by driver
     */
    public List<DeliveryRequest> getReceivedRequests() {
        return Collections.unmodifiableList(receivedRequests);
    }

    /**
     * Returns driver's name
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type of vehicle the driver is using.
     *
     * @return the vehicle type
     */
    public String getVehicleType() {
        return vehicleType;
    }
}
