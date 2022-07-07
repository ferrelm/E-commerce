# E-commerce

## Context

This app was created as a Final Project for the Backend Developer Program @Vodafone by AkaPeople

## Purpose

To create a Simple E-commerce app


![Project Diagram](/images/diagram.PNG "Project Diagram")


***

## Microservices

There are 3 microservices:

- Product Catalog
- Order Service
- Notification ServiceNotification Service


## Product Catalog

This service will be used by administrators. 
Its goal is to manage products and product categories.


## Order Service

This service will be used by the store POS. 
Its goal is post customer orders in the system.


## Notification Service

This service will consume messages from the order queue and send
an email to the customer with the order details.


## Documentation

Swagger API documentation can be seen on localhost:8080


## Usefull kinks
 

- [ ] [mailjet api](https://dev.mailjet.com/email/guides/send-api-v31/)


