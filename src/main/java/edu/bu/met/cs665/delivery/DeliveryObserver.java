/**
 * Name: Jose Andres Leal
 * Course: CS-665 Software Design & Patterns
 * Date: 10/20/2026
 * File Name: DeliveryObserver.java
 * Description: Observer interface for objects that receive delivery requests.
 */

package edu.bu.met.cs665.delivery;

/**
 * Observer: Any object that wants delivery request notifications implements the Observer.
 */
public interface DeliveryObserver {

    /**
     * Receives a delivery request.
     *
     * @param request delivery request being broadcast
     */
    void update(DeliveryRequest request);
}
