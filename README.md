<h1>Table of Contents</h1>

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
    - [3.4.5. Validate BST](#345-validate-bst)
    - [3.4.6. Successor](#346-successor)
    - [3.4.7. Build order](#347-build-order)
    - [3.4.8. First Common Ancestor](#348-first-common-ancestor)
    - [3.4.9. BST Sequences](#349-bst-sequences)
    - [3.4.10. Check Subtree](#3410-check-subtree)

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
**Chapter 4 - Trees and Graphs**

### 3.4.1. Route Between Nodes
| **Question** | **Solution** |
|--------------|--------------|
| Given a directed graph, design an algorithm to find out whether there is a route between tow nodes. | [Route Between Nodes](TreesAndGraphs/route-between-nodes/) |

### 3.4.2. Minimal Tree
| **Question** | **Solution** |
|--------------|--------------|
| Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height. | [Minimal Tree](TreesAndGraphs/minimal-tree) |

### 3.4.3. List of Depths
| **Question** | **Solution** |
|--------------|--------------|
| Given a binary tree, design an algorithm which create a linked list of all the nodes at each depth (eg. if you have a tree with depth D, you'll have D linked lists). | [List of Depths](TreesAndGraphs/list-of-depths) |

### 3.4.4. Check Balanced
| **Question** | **Solution** |
|--------------|--------------|
| Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of two subtrees of any node never differ by more than one. | [Check Balanced](TreesAndGraphs/check-balanced/) |

### 3.4.5. Validate BST
| **Question** | **Solution** |
|--------------|--------------|
| Implement a function to check if a binary is a binary search tree | [Validate BST](TreesAndGraphs/validate-bst/) |

### 3.4.6. Successor
| **Question** | **Solution** |
|--------------|--------------|
| Write an algortihm to find the "next"(i.e. in-order successor) of a given node in a binary search tree. You may assume that each node has a link to its parent. | [Successor](TreesAndGraphs/successor/) |

### 3.4.7. Build order
| **Question** | **Solution** |
|--------------|--------------|
| You are given a kist of projects and a list of dependencies (which is a list of pairs of projects, where the second project is dependent on the first project). All of a project's dependencies must be build before the project is. Find a build order that will allow the projects to be built. If there is no valid build order, return an error.<br>EXAMPLE:<br>Input:<br>  _projects:_ _a,b,c,d,e,f_ <br>  _dependencies:_ _(a,d), (f,b), (b,d), (f,a), (d,c)_ <br>Output: <br> _f, e, a, b, d, c_ | [Build order](TreesAndGraphs/build-order/) |

### 3.4.8. First Common Ancestor
| **Question** | **Solution** |
|--------------|--------------|
| Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not necessarilt a binary search tree. | [First Common Ancestor](TreesAndGraphs/first-common-ancestor/) |

### 3.4.9. BST Sequences
| **Question** | **Solution** |
|--------------|--------------|
| A binary search tree was created by traversing through an array from left to right and inserting each element. Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree. | [BST Sequences](TreesAndGraphs/bst-sequences/) |

### 3.4.10. Check Subtree
| **Question** | **Solution** |
|--------------|--------------|
| T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an algorithm to determine if T2 is a subtree of T1.<br>A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. That is, if you cut off the tree at node n, the two tree would be identical. | [Check Subtree](TreesAndGraphs/check-subtree/) |