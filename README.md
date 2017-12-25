# TrainingTests
Training test for clean code in `Java`
## Description
 This test is about a building having several elevators with different states.
 For example, each elevator can be at a different level, and can be going up,
 or down.</br>
 The objective of this exercise is to write a program that will identify which
 elevator will be served once a request for an elevator is registered.
 </p>
 
 Please note these rules : </br>
 - An elevator is requested by default from <b>top</b> floor. </br>
 - An elevator can be resting at a given floor, going up or going down. </br>
 - An elevator switch automatically his direction when reaching the edges of
  the building (means the first and top floors). </br>
 - An elevator can not switch his direction in the middle of a building.
  Example: in a building of 10 floors, an elevator at the 3rd floor and
  ascending can never go down before reaching the 10th floor. And vice
  versa.</br>
  - An elevator is never in between floors.

## Author 
Test Author : [SQLI](http://www.sqli.com/)</br>
Code Author : [Taha Zirari](http://www.linkedin.com/in/taha-zirari)
## Statements
If you want to challenge yourself, you'll find the `Test Class` in the test package : </br> 
`TrainingTests/elevators/src/test/java/com/sqli/test/elevators/` </br>
Ps : It's all you will need to solve the test.
