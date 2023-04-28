# Class Collaboration Repo

This repo is stored here https://github.com/jlu1985/csi01__csc330__s23__18731__class-collab

Mural board: https://bit.ly/csc330-s23-pizzeria

folder structures

| name | description |
| - | - |
| class-exercise | Programs we went through during class |
| week3 | class project snapshot at week 3 |
| week5-class | We spent some time think a little in UML class diagram and Sequence diagram then got some code written |
| week6-properties | properties file, file IO, stream reader/writer, arrays and Collections |
| week7-inheritance | inheritance, use case and unit test |
| week8-abstraction | abstraction and interface, polymorphism |

## Week 3
Project starts

## week5-class
We got UMLs and finally able to start coding a little. The idea is to keep each week's work in its own folder, so that we can review the progression each week we introduced new topics that could enhance the code

## week6-properties
We talked about Streams and File IO, and reworked our Menu class and MenuLoader to dynamically load menus from a properties file.

Originally Menu class has fields, and each field is one Pizza type. Since we are introducing properties, we rework the Menu creation logic to create the menu from reading from a properties files. It allows us dynamically create the Pizzas.

Thursday, we talked about Arrays and Collections. We also updated PriceCalculator to handle the pricing logic for Pepperoni and Hawaiian pizzas.

## Week8-abstract
Tuesday, we talked about abstraction, interfaces and polymorphism. We finally added the 99cents and 49cents and have the pizzas display those values for example, if the calculated price for a pizza is $10. the expected menu display price should be $10.49. We applied abstract class to the price calculator, and turn PriceCalculator into AbstractPriceCalculator so that it can have 'half-half' concrete logics. The PriceCalculator name is not transfer to a new interface class keeping the original method signature.

# Week14 Design Patterns
Applying builder, decorator and other patterns to the project