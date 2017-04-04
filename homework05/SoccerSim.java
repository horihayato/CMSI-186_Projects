/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  Provides a class defining methods for the SoccerSim class
 *  @author       :  Hayato Hori
 *  Date written  :  2017-04-04
 *  Description   :  This class provides a bunch of methods which may be useful for the SoccerSim class
 *                   for Homework 5, part 1.  Includes the following:
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.lang.*;

public class SoccerSim  {

	public static void main(String args[]) {
      int numOfBalls;
      Timer clock = new Timer();
      Ball[] ballArray;
      // If user does not enter at least two balls, ask them to try again.
      if (args.length < 9) {
         throw new UnsupportedOperationException("Please enter at least two balls and it's positions, as well as the timeslice. Ex. (java SoccerSim 0 3 3 3 0 3 2 1 10");
      } 

      // If user inputs right parameters, conduct the following:
      if (args.length >= 9 && (args.length % 2) == 1) {

         // Creates number of balls
         numOfBalls = (int) Math.floor(args.length / 4);

         // Creates array of balls
         ballArray = new Ball[numOfBalls];

         // Constructs each unique ball given user input
         for (int i = 0, j = 0; i < args.length - 1; i += 4, j++) {
            ballArray[j] = new Ball(Double.parseDouble(args[i]), Double.parseDouble(args[i + 1]), Double.parseDouble(args[i + 2]), Double.parseDouble(args[i + 3]));
            System.out.println("You have created Ball: " + j + " at position: ");
            ballArray[j].getBothPosition();
         }

         // Infinite loop to see if there is a collision or not.
         while (true) {
            double tickTime = clock.tick(Double.parseDouble(args[args.length - 1]));
            System.out.println("\n Time passed: " + clock.toString());

            // Moves each ball according to its speed
            for (int i = 0; i < ballArray.length; i++) {
               System.out.println("\n Ball: " + i);
               ballArray[i].moveBall(Double.parseDouble(args[args.length - 1]));
               ballArray[i].getBothPosition();
            }

            // Compares each ball to see if they collide with each other
            for (int i = 0; i < ballArray.length; i++) {
               for (int j = i + 1; j < ballArray.length; j++) {
                  if (ballArray[i].isColliding(ballArray[j])) {
                     System.out.println("\n Ball " + i + ": " + ballArray[i].getXPosition() + ", " + ballArray[i].getYPosition() + " is colliding with Ball " + j + ": " + ballArray[j].getXPosition() + ", " + ballArray[j].getYPosition());
                     return;
                  } else {
                     continue;
                  }
               }
            }

            // If all the velocity of the balls is less than 1 inch per second, end loop
            for (int i = 0; i < ballArray.length; i++) {
               if (ballArray[i].isZeroVelocity() == true) {
                  System.out.println("\n No Collision Found");
                  return;
               }
            }
         }
      }
   }
}
