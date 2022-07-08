# E-commerce

## Context

This app was created as a Final Project for the Backend Developer Program @Vodafone by AkaPeople

![Logo](/images/logo.PNG "Logo")

## Author

Luis Matos Ferreira (https://www.linkedin.com/in/luismatosferreira/)
    under the supervision of:

- António Arrais de Castro
- Igor Silveira
- Paulo Azevedo
- Ricardo Coelho
- Ricardo Moreira

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
![Endpoints ](/images/endpoints_productcatalog_categories.PNG "endpoints")

![Endpoints](/images/postgres.PNG "endpoints")


## Order Service

This service will be used by the store POS. 
Its goal is post customer orders in the system.

![Endpoints](/images/endpoints_orderservice.PNG "endpoints")

![Endpoints](/images/mongo.PNG "endpoints")


## Notification Service

This service will consume messages from the order queue and send
an email to the customer with the order details.


## Documentation

Swagger API documentation can be seen on localhost:8080



## Aditional Steps

Refactoring time!

Make sure your code is clean, easy to undestand and behaves as expected!
- Lookout for large methods, classes or complex code that can be split into cleaner units
- Care about names: is the name of your functions, classes and variables consistent and self explanatory?
- Make sure you deal with errors and edge cases:
- Your API should never return 500 error
- Your Service should never die unexpectedly
- Validate your inputs! (what happens if the user send a string in a number field?)
- Return Bad Request with a proper validation message to guide the API user
- What happens when your code fails? Are you catching exceptions, logging errors and sending the appropriate
message to your users?


## Usefull kinks
 

JAVA

- [ ] [spring](https://start.spring.io/)
- [ ] [JPA](https://spring.io/guides/gs/accessing-data-jpa/)
- [ ] [OpenAPI](https://www.baeldung.com/spring-rest-openapi-documentation)
- [ ] [Basic Auth](https://docs.spring.io/spring-security/reference/5.7.0-RC1/servlet/getting-started.html)
- [ ] [JWT](https://github.com/spring-projects/spring-security-samples/tree/main/servlet/spring-boot/java/jwt/login)

Javascript

- [ ] [express](https://expressjs.com/en/starter/generator.html)

Databases

- [ ] [mongoose](https://mongoosejs.com/docs/)
- [ ] [rabbitmq](https://www.rabbitmq.com/tutorials/tutorial-one-javascript.html)

Email

- [ ] [mailjet api](https://dev.mailjet.com/email/guides/send-api-v31/)

Containers

- [ ] [dockerfiles](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#container-images.dockerfiles)
- [ ] [Kubernetes](https://kubernetes.github.io/ingress-nginx/user-guide/nginx-configuration/annotations/)

