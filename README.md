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

![Endpoints width="200"](/images/endpoints_productcatalog_products.PNG "endpoints")
![Endpoints width="200"](/images/endpoints_productcatalog_categories.PNG "endpoints")


## Order Service

This service will be used by the store POS. 
Its goal is post customer orders in the system.

![Endpoints width="200"](/images/endpoints_orderservice.PNG "endpoints")


## Notification Service

This service will consume messages from the order queue and send
an email to the customer with the order details.


## Documentation

Swagger API documentation can be seen on localhost:8080


## Usefull kinks
 

- [ ] [mailjet api](https://dev.mailjet.com/email/guides/send-api-v31/)
- [ ] [express](https://expressjs.com/en/starter/generator.html)
- [ ] [mongoose](https://mongoosejs.com/docs/)
- [ ] [rabbitmq](https://www.rabbitmq.com/tutorials/tutorial-one-javascript.html)
- [ ] [spring](https://start.spring.io/)
- [ ] [dockerfiles](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#container-images.dockerfiles)
- [ ] [JPA](https://spring.io/guides/gs/accessing-data-jpa/)
- [ ] [OpenAPI](https://www.baeldung.com/spring-rest-openapi-documentation)
- [ ] [Kubernetes](https://kubernetes.github.io/ingress-nginx/user-guide/nginx-configuration/annotations/)
- [ ] [Basic Auth](https://docs.spring.io/spring-security/reference/5.7.0-RC1/servlet/getting-started.html)
- [ ] [JWT](https://github.com/spring-projects/spring-security-samples/tree/main/servlet/spring-boot/java/jwt/login)
