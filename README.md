# Teaching-HEIGVD-AMT-2019-First-Steps-With-SpringBoot
## Introduction

In the first part of the semester, we have used some of the Java EE APIs to illustrate architectural patterns, such as MVC, DAO, Inversion of Control and Dependency Injection.

In the programming model that we have used so far, the application server played a major role: it provides a runtime environment, into which we deployed our applications. The application server was very visible. It is a piece of software that is installed and configured. There is an admin Web UI and an admin CLI that we have used quite a bit.

When we were talking about "managed components", it was the application server that was responsible for managing these components. It was the application server that was creating instances of servlets. It was the application server that was creating instances of EJBs.

So far, we have also worked with "raw" Java EE APIs. Compared to using the Socket API, we worked at a high level of abstraction. But compared to the APIs that we will see in the second part of the course, it is rather low level. We had to write quite a bit of repetitive code in the servlets and the DAOs for instance.

## Spring: building on top of (selected) Java EE APIs

What we will use from now on is the Spring Boot application framework, which is itself built on top of the Spring Framework. 

There are frequent misconceptions about the relationship between Java EE and Spring. Very often, you will hear statements like "I don't want to use Java EE, I want to use Spring", as if these were completely different platforms. It is not the case. In fact, the two platform have a lot in common and are based on the same standard APIs (servlets, JDBC, JPA, JMS, etc.).

The original Spring Framework was developed 20 years ago, way before EJB 3 were proposed. At the time, developing EJBs was much more cumbersome that it is today. Spring was built as a framework that could be deployed in an application server and that made Java EE development faster. The title of the first book was "Java EE without EJBs" and one of the key points was that when using the Java EE stack, you do not have to use every single API it provides. It is ok not to use EJBs. It is ok not to use JPA. As always, there are tradeoffs to consider.

What Spring did, was to re-implement some of the Java EE mechanisms (managed components) on top of Plain Old Java Objects (POJO). Because these mechanisms are implemented at the framework level, we do not need to run in an application server to execute them. One area where this makes a huge difference is automated testing. When we used EJBs and wanted to test them, we had to use Arquillian to have the tests executed in a container. With Spring, managed components can be created and tested in any VM.

## Spring Boot: an opinionated way to use Spring

It is important that there are two distinct frameworks. 

The first one is the **Spring Framework**. You can think of it as a toolbox, a set of APIs that can be used to build applications in many different ways. It offers lots of variations and possible combinations. It is very rich, but can be overwhelming. 

The second one is **Spring Boot**, which is build on top of the Spring Framework and proposed one way to use it. In other words, it makes certain choices, so that the developer can follow a "standard" way to use the APIs. Nonetheless, it remains fairly open and there are still choices that the developer has to make.

Spring Boot integrates concepts and features that became important with the adoption of cloud computing and DevOps practices. It provides ways to configure and monitor applications, fostering the idea that operating an application in production should be considered from the beginning of the project.

## What are we going to do with Spring and how?

In the second part of the semester, we will use Spring Boot to continue the study of multi-tiered applications. The big topics that we will cover include:

* The use of an **Object Relational Mapping (ORM)** as an alternative to using JDBC. The ORM that we will use, Hibernate, is also frequently used in Java EE applications that do not use Spring, but we will see that the Spring Data framework adds a layer on top of it. 
* The **design of REST APIs** and their implementation with Spring MVC (an alternative would be to use the standard JAX-RS API, which is very similar). We will not only see how to build REST endpoints, but also how to create formal descriptions of REST APIs with Swagger / Open API.
* The application of **Behaviour Driven Development** (BDD), a practice that complements Test Driven Development. We will use BDD to validate the behaviour of our REST APIs.

This week, we will start with hands-on experiences and get familiar with the framework. To do that, we will use standard tutorials and developers guides proposed by Spring. They are quick and easy to do and will give us a good feel for the framework.

One thing that we will see is that there is no need to install and configure the application server. However, that does not mean that it is gone: when we will run our apps, we will see that a Tomcat server is embedded in the app and starts automatically. 

From next week, during the lectures, we will come back to the mechanisms implemented by Spring Boot and the Spring Framework. As it was the case so far, the goal is not only to be able to use the framework but also to understand what happens "behind the curtains". Indeed, if there was a level of "magic" when we used Java EE APIs so far, that level is only going to increase with Spring.

## Objectives of this week

* Read this document.
* Do the following tutorials:
  * [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/) (15 minutes)
  * [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/) (15 minutes)
  * [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/) (15 minutes)
* Go through the Spring documentation:
  * Spend 30 minutes to do through [the Spring Boot reference documentation](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/reference/html/). The goal is to get a quick idea of what the framework provides, so that you can go back to the doc when a certain need or problem arises.
  * Spend 30 minutes to go through [the Spring Framework documentation](https://docs.spring.io/spring/docs/current/spring-framework-reference/). The goal is the same: to get a first idea of the scope covered by the framework.
  * It is very important for you to keep in mind that when you work on labs and projects, you will use features implemented at the Spring Boot level and features implemented at the Spring Framework level. Hence, do not forget to dig into the Spring Framework documentation when you work on lower-level issues.