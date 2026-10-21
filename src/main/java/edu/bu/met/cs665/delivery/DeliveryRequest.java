/**
 * Name: Jose Andres Leal
 * Course: CS-665 Software Design & Patterns
 * Date: 10/20/2026
 * File Name: DeliveryRequest.java
 * Description: Single product delivery request created by a shop.
 */

package edu.bu.met.cs665.delivery;

import java.util.Objects;

/**
 * Details of a delivery request.
 *
 * fields are final, so that all drivers receive
 * exactly the same unchangeable data.
 */
public class DeliveryRequest {

    private final String shopName;
    private final String product;
    private final String destination;


    /**
     * Creates delivery request
     *
     * @param shopName is the name of the shop that created the request
     * @param product is the product being delivered
     * @param destination is the address where the product is being delivered
     * @throws NullPointerException if any argument is null
     */
    public DeliveryRequest(String shopName, String product, String destination) {
        this.shopName = Objects.requireNonNull(shopName, "shopName");
        this.product = Objects.requireNonNull(product, "product");
        this.destination = Objects.requireNonNull(destination, "destination");
    }

    /**
     * Returns the name of the shop that created request.
     *
     * @return the shop name
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * Returns the product being delivered.
     *
     * @return the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * Returns the destination for the delivery.
     *
     * @return the destination address
     */
    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "DeliveryRequest{shop=" + shopName + ", product=" + product
                + ", destination=" + destination + '}';
    }
}
