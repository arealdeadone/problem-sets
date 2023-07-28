
# Introduction
This repository contains the solutions in Java to the problems presented in the book Cracking the Coding Interview. All the solutions are arranged in their respective folder according to the chapter names. Each problem is its own Java maven project with their directory names being the same as the problem title in bold as mentioned in the book.

# Getting Started

## Requirements
The code has been tested with Java 17, although there are not specific Java 17 features used in the code. It should run fine with any of the Java version > Java 8. Just change the source java version and target java version in the `pom.xml` file.

Following are the components that the project assumes are already installed in the system.

    - JDK > 8
    - Maven > 3.8
    - Any Terminal (bash/zsh/command prompt/Power shell)

## Building and Running
Each project can be compiled and executed using the following steps:
```sh
cd <project-directory>
mvn clean package # Or mvn clean install
java -cp target/<project-1.0-SNAPSHOT.jar> tech.arvindrachuri.Main
```

# Chapters

## Arrays and Strings

## Linked Lists

## Stacks and Queues

## Trees and Graphs

### Route Between Nodes
**Question**: Given a directed graph, design an algorithm to find out whether there is a route between tow nodes.
**Solution** [Route Betweeb Nodes](TreesAndGraphs/tree-routes/)

