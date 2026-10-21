/**
 * Name: Jose Andres Leal
 * Course: CS-665 Software Design & Patterns
 * Date: 10/20/2026
 * File Name: DeliverySubject.java
 * Description: Subject interface for objects broadcasting delivery requests.
 */

package edu.bu.met.cs665.delivery;

/**
 * Subject: list of registered observers and notifies all when a
 * new delivery request is created.
 */
public interface DeliverySubject {

    /**
     * Registers an observer to receive future delivery requests.
     *
     * @param driver observer to register
     */
    void registerDriver(DeliveryObserver driver);

    /**
     * Removes an observer, to no longer receive delivery requests
     *
     * @param driver observer to remove
     */
    void removeDriver(DeliveryObserver driver);

    /**
     * Sends a delivery request to all registered observers.
     *
     * @param request delivery request to broadcast
     */
    void notifyDrivers(DeliveryRequest request);
}
