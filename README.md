# Katas-mars-rover
Resolution of the Mars Rover Kata using TDD and design patterns in Java 

## Definition of the Exercise
[Google Code Archive](https://code.google.com/archive/p/marsrovertechchallenge/)

## Summary
The exercise consists on developing an API to control a Rover vehicle to be movin on the surface of Mars with the following rules:

1. The starting point (0,0,N) where the rover begins will be provided.
2. 0,0 are X,Y coordinates on a (10,10) grid.
3. N is the direction the rover is facing (i.e. N,S,E,W).
4. L and R commands stand for turn Left and Right.
5. M allows the rover to move one unit in the current direction.
6. The rover receives a char array of commands e.g. RMMLM and returns the finishing point after the moves e.g. 2:1:N
7. The rover wraps around if it reaches the end of the grid.
8. The grid may have obstacles. If a given sequence of commands encounters an obstacle, the rover will backtrack to the last coordinate from which it attempted to access the obstacle and report the obstacle adding a 0 at the beginning of the returned string e.g. O:2:2:N

## Final Notes to improve
After doing the exercise there are a couple of things that I think that could improve the readability of the code applying some code patterns, I decide not to implement those because this is a basic example and it would make the code more complex without necessity, but in real life, they may be useful:

1. In the Rover Class, all the functionality included in the for each loop, with nested if..elses, I think that maybe using a combination of Command/Strategy patterns, I could extract the different behaviours to tiny classes with just two methods: one executor to execute its command, and one decision evaluator to check if the command applies to that particular class.
2. I would apply the same combination in the Grid class, where the next coordinate is calculated.
