Here is the "Robot programming" project, as requested we can choose the size of the room, as well as the size of the robot. If the format of the Robot or the room is incorrect, error management has been implemented.
result :
The robot's position is displayed in a textfield, but if you want to see the robot move cell by cell, look in the console.
Probleme :
For rotation, if the robot is a rectangle, it must pass from one:
2x6 facing North
      6
  _ _ _ _ _ _
2 |
  |

by turning left has a :

 |
 |
6|
 |
 |
 |_ _
   2

And in my code, it will not rotate, but only change the direction of facing. In higher versions the code should be functional.

