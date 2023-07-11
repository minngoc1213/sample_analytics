# Sample Analytics

Simple web application using Spring Boot and MongoDB to implement CRUD operations.

# Table of Contents

    Prerequisites
    Installation
    Usage

[//]: # (    Contributing)

[//]: # (    License)

[//]: # (    Contact)

# Prerequisites

Before you continue, ensure you meet the following requirements:

* You have installed Docker on your local machine.
* You have jdk-17 or later.

# Installation

Sample Analytics uses mongo official image latest version on Docker Hub. Run the mongo image in port 21017 by default. You can change configuration in file docker-compose.yml and application.properties.

To load the data, open MongoSH and follow these steps:

1. Cd in your project directory and open the command line interface or terminal for your operating system.

2. Connect to your MongoDB instance:

`mongo`

3. Create a new database named "sample_analytics":

`use sample_analytics`

4. Create a new collection named "accounts" and import data from the "accounts.json" file into the "accounts" collection:

`db.createCollection("accounts")`

`mongoimport --jsonArray --db sample_analytics --collection accounts --file ./json/accounts.json`

5. Create a new collection named "customers" and import data from the "customers.json" file into the "customers" collection:

`db.createCollection("customers")`

`mongoimport --jsonArray --db sample_analytics --collection customers --file ./json/customers.json`

6. Create a new collection named "transactions" and import data from the "transactions.json" file into the "transactions" collection:

`db.createCollection("transactions")`

`mongoimport --jsonArray --db sample_analytics --collection transactions --file ./json/transactions.json`

# Usage

Sample Analytics web application runs on local machine. You can use Postman to send HTTP requests. The default base URL is http://localhost:8080.

[//]: # (# Contributing)

[//]: # ()
[//]: # (Guidelines for contributing to the project.)

[//]: # ()
[//]: # (# License)

[//]: # ()
[//]: # (Information about the project's license.)

[//]: # ()
[//]: # (# Contact)

[//]: # ()
[//]: # (Contact information for the project's maintainers.)
