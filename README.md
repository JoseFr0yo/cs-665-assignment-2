
| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | Jose Andres Leal           |
| Date         | 10/20/2026                 |
| Course       | Fall 2026                  |
| Assignment # | 2                          |

# Assignment Overview
This assignment implements a notification system for shops. These shops work
with drivers to get deliveries to customers. The shop receives an order and broadcasts
it to registered drivers.

# GitHub Repository Link:
https://github.com/JoseFr0yo/cs-665-assignment-2

# Implementation Description 

## Design Pattern: Observer

I chose to use the Observer pattern for the notification system. 
Since we are dealing with a one-to-many relationship the observer pattern was an easy choice.

Notifications use the push model: the shop passes the unchanged DeliveryRequest to all registered drivers.

There are 5 classes present:
- DeliverySubject: is a subject interface
- DeliveryObserver: is an observer interface
- Shop: is a concrete subject
- Driver: is a concrete observer
- DeliveryRequest: The data pushed to available observers


# Maven Commands

## Compile

```bash
mvn clean compile
```

## Run the JUnit tests

```bash
mvn clean test
```

The tests in `TestDeliverySystem` cover:

1. One shop broadcasting one request to five drivers, all of whom receive it with correct details.
2. A removed (busy) driver not receiving the request.
3. A duplicate registration resulting in only one notification.
4. A broadcast with no registered drivers completing without errors.
5. `null` values being rejected.