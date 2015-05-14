Pset 5
======

Here are some resources to help with this problem set:

* [Mike Menne's Factory Pattern video](http://tv.launchcode.us/#/videos/java_factory_design_pattern?lesson=Java)
* [Another great Factory Pattern video](https://www.youtube.com/watch?t=72&v=ub0DXaeV6hA)
* [Static methods in Java](http://www.programmingsimplified.com/java/source-code/java-static-method-program)
* [A great article on refactoring](http://www.cs.usfca.edu/~parrt/course/601/lectures/refactoring/refactoring.html)

# Part 1: Refactoring ArraySorter

The previous problem set, pset4, could have benefited from the Factory pattern. Your first task is to go back and refactor your code
to incorporate the Factory Pattern. While you're at it, check the rest of your code for good design, and refactor as necessary.

You should also check over your code to see if there is any unnecessary repetition, or unnecessary complexity. Refactor these out of your code, and make sure your tests still pass!

# Part 2: Attack Robots

Your task for the rest of this assignment will be to create a small game involving attack robots. We could say that a robot has-a:

* Amount of durability (health)
* Amount of power (used to attack other robots)
* Movement speed
* Location

Your robots will inflict damage on each other based on their power. If a robot runs out of health (durability == 0) then the battle is over and it cannot make any more moves.

To keep things simple, we will assume that the robots are restricted to movement in one direction. That is, they can move forward and backward, but not side to side.

Our robots can attack and move, however they will be pre-programmed to operate based on a particular `Strategy`. Instead of telling the robot to attack or move directly, we want the robot to choose its next behavior based on its given strategy.

Your strategies should choose what to do next based on the robots helath, position, speed, etc.

Create some strategies for your robots using the Strategy Pattern. Make sure your robot can accept a strategy and execute its next move based on its strategy. Some ideas for strategies could be:

* Always attack no matter what
* Always run away no matter what
* Attack until health falls below a particular level, then run

Create some strategies for your robots using the Strategy Pattern. Make sure your robot can accept a strategy and execute its next move based on its strategy. **Implement a factory to create strategies**.

#It's time for battle!

Once your robot is working as you expect when given a particular strategy (test this thoroughly!), set up some robot battles. To make this easier, you may want to do the following:

* Limit the position of the robot to a particular range (its position has to be between 0 and 100, for example).
* Limit the number of moves per battle (for example, if no one has won within 100 moves, declare it a tie).

Make a few robots and see which strategies work the best.

#But wait, there's more!

Finally, create a factory for robots, using the factory pattern. This factory could work in conjunction with your strategy factory!

When you are finished, test your code thoroughly and notify the instructor.
