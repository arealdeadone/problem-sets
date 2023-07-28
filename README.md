
# 1. Introduction
This repository contains the solutions in Java to the problems presented in the book Cracking the Coding Interview. All the solutions are arranged in their respective folder according to the chapter names. Each problem is its own Java maven project with their directory names being the same as the problem title in bold as mentioned in the book.

# 2. Getting Started

## 2.1. Requirements
The code has been tested with Java 17, although there are not specific Java 17 features used in the code. It should run fine with any of the Java version > Java 8. Just change the source java version and target java version in the `pom.xml` file.

Following are the components that the project assumes are already installed in the system.

    - JDK > 8
    - Maven > 3.8
    - Any Terminal (bash/zsh/command prompt/Power shell)

## 2.2. Building and Running
Each project can be compiled and executed using the following steps:
```sh
cd <project-directory>
mvn clean package # Or mvn clean install
java -cp target/<project-1.0-SNAPSHOT.jar> tech.arvindrachuri.Main
```

# 3. Chapters

## 3.1. Arrays and Strings

## 3.2. Linked Lists

## 3.3. Stacks and Queues

## 3.4. Trees and Graphs

### 3.4.1. Route Between Nodes
| **Question** | **Solution** |
|--------------|--------------|
| Given a directed graph, design an algorithm to find out whether there is a route between tow nodes. | [Route Betweeb Nodes](TreesAndGraphs/route-between-nodes/)- [Route Between Nodes](TreesAndGraphs/route-between-nodes/) |

### 3.4.2. Minimal Tree
| **Question** | **Solution** |
|--------------|--------------|
| Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height. | [Minimal Tree](TreesAndGraphs/minimal-tree) |

### 3.4.3. List of Depths
| **Question** | **Solution** |
|--------------|--------------|
| Given a binary tree, design an algorithm which create a linked list of all the nodes at each depth (eg. if you have a tree with depth D, you'll have D linked lists). | [List of Depths](TreesAndGraphs/list-of-depths) |

### 3.4.4. Check Balanced
| **Question**                                                                                                                                                                                                            | **Solution**                                     |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------|
| Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of two subtrees of any node never differ by more than one. | [Check Balanced](TreesAndGraphs/check-balanced/) |


- [1. Introduction](#1-introduction)
- [2. Getting Started](#2-getting-started)
  - [2.1. Requirements](#21-requirements)
  - [2.2. Building and Running](#22-building-and-running)
- [3. Chapters](#3-chapters)
  - [3.1. Arrays and Strings](#31-arrays-and-strings)
  - [3.2. Linked Lists](#32-linked-lists)
  - [3.3. Stacks and Queues](#33-stacks-and-queues)
  - [3.4. Trees and Graphs](#34-trees-and-graphs)
    - [3.4.1. Route Between Nodes](#341-route-between-nodes)
    - [3.4.2. Minimal Tree](#342-minimal-tree)
    - [3.4.3. List of Depths](#343-list-of-depths)
    - [3.4.4. Check Balanced](#344-check-balanced)


