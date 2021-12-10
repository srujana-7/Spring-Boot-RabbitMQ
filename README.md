# Spring-Boot-RabbitMQ

This is a Spring Boot Messaging Service implemented through RabbitMQ .
Order service notifies user of the order the user books.A message is first sent to acknowledge the user that his order is received and later order is processed.

The project has four components -'
1. A config class that defines the queueing architecture - queue , Exchange and Binding.
2. Data Object classes for order and Order status.
3. A publisher of the message queue.
4. A consumer of the message queue.
