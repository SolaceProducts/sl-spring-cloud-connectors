[![Build Status](https://travis-ci.org/SolaceLabs/sl-spring-cloud-connectors.svg?branch=v0.1-maintenance)](https://travis-ci.org/SolaceLabs/sl-spring-cloud-connectors)

# Solace Messaging Spring Cloud Connectors

A Spring Cloud Connector for an instance of SolaceMessaging in Cloud Foundry. Specifically a ServiceInfo and ServiceInfoCreator implementation for SolaceMessaging in Cloud Foundry.

## Contents

* [Overview](#overview)
* [Spring Cloud Connectors](#spring-cloud-connectors)
* [Java Applications](#java-applications)
* [Spring Applications](#spring-applications)
* [Checking out and Building](#checking-out-and-building)
* [Example Build Dependency](#example-build-dependency)
* [Resources](#resources)


---

## Overview

This project provides an implementation of the ServiceInfo and ServiceInfoCreator interfaces to extend the Spring Cloud Connectors project the SolaceMessaging Clound Foundry service. Using this in your Spring application can make consuming the Solace messaging service simpler than straight parsing of the `VCAP_SERVICES` environment variable.

The Spring cloud documentation provides both a nice introduction to Cloud Connectors and a nice overview of the options for [extending Spring Cloud](http://cloud.spring.io/spring-cloud-connectors/spring-cloud-connectors.html#_extending_spring_cloud_connectors). This project provides a Cloud Service Support extension to make it easy to consume the SolaceMessaging Cloud Foundry Service in your Cloud Foundry application.

## Spring Cloud connectors

This a project extends Spring Cloud Connectors. If you are new to Spring Cloud Connectors, check out their project on GitHub here: https://github.com/spring-cloud/spring-cloud-connectors

The following is a brief introduction copied from their README:

>Spring Cloud Connectors simplifies the process of connecting to services and gaining operating environment awareness in cloud platforms such as Cloud Foundry and Heroku, especially for Spring applications. It is designed for extensibility: you can use one of the provided cloud connectors or write one for your cloud platform, and you can use the built-in support for commonly-used services (relational databases, MongoDB, Redis, RabbitMQ) or extend Spring Cloud Connectors to work with your own services.

## Java Applications

Applications can use this connector with Spring Cloud to access the information in VCAP_SERVICES environment variable, necessary to connect to a Solace Messaging Service Instance. The code finds the `SolaceMessaging` Cloud Foundry service instance and uses the `SolaceMessagingInfo` object to connect a Solace Messaging API for Java (JCSMP) session.

```java
CloudFactory cloudFactory = new CloudFactory();
Cloud cloud = cloudFactory.getCloud();
SolaceMessagingInfo solacemessaging = (SolaceMessagingInfo) cloud.getServiceInfo("MyService");

// Setting up the JCSMP Connection
final JCSMPProperties props = new JCSMPProperties();
props.setProperty(JCSMPProperties.HOST, solacemessaging.getSmfUri());
props.setProperty(JCSMPProperties.VPN_NAME, solacemessaging.getMsgVpnName());
props.setProperty(JCSMPProperties.USERNAME, solacemessaging.getClientUsername());
props.setProperty(JCSMPProperties.PASSWORD, solacemessaging.getClientPassword());

JCSMPSession session = JCSMPFactory.onlyInstance().createSession(props);
session.connect();
```

## Spring Applications

TODO: Add details.


## Checking out and Building

This project depends on maven for building. To build the jar locally, check out the project and build from source by doing the following:

    git clone https://github.com/SolaceLabs/sl-solace-messaging-service-info.git
    cd sl-solace-messaging-service-info
    mvn package

This will build a jar file which will be named similar to the following:

```
target/sol-labs-spring-cloud-connector-1.0-SNAPSHOT.jar
```

You can install this file in your maven repository locally.

## Example Build Dependency

If you're building with Gradle, you can simply add the following to your dependencies:

```
// Solace Cloud
compile("com.solacesystems.labs.cloud:sol-labs-spring-cloud-connector:+")
```

## Resources

For more information about Cloud Foundry and the Solace messaging service these resources:
- TODO - Need link to online Solace CloudFoundry documentation.
- [Cloud Foundry Documentation](http://docs.cloudfoundry.org/)
- For an introduction to Cloud Foundry: https://www.cloudfoundry.org/

For more information about Spring Cloud try these resources:
- [Spring Cloud](http://projects.spring.io/spring-cloud/)
- [Spring Cloud Connectors](http://cloud.spring.io/spring-cloud-connectors/)
- [Spring Cloud Connectors Docs](http://cloud.spring.io/spring-cloud-connectors/spring-cloud-connectors.html)
- [Spring Cloud Connectors GitHub](https://github.com/spring-cloud/spring-cloud-connectors)

For more information about Solace technology in general try these resources:

- The Solace Developer Portal website at: http://dev.solacesystems.com
- Get a better understanding of [Solace technology.](http://dev.solacesystems.com/tech/)
