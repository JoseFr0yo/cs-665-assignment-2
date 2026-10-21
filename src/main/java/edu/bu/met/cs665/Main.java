/**
 * Name: Jose Andres Leal
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/20/2026
 * File Name: Main.java
 * Description: Entry point for notification system. Tested using JUnit tests.
 */

package edu.bu.met.cs665;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Demonstrates basic Log4j logging.
 */
public class Main {
  private static final Logger LOGGER = LogManager.getLogger(Main.class);

  /**
   * Run a small Log4j demonstration.
   */
  public static void main(String[] args) {
    LOGGER.info("Application started.");
    LOGGER.debug("Debug details are useful while developing.");
    LOGGER.warn("This is an example warning.");
  }

}
