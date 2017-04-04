/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  The main program for the Ball class
 *  @see
 *  @author       :  Hayato Hori
 *  Date written  :  2017-04-04
 *  Description   :  This class provides a bunch of methods which may be useful for the Ball class
 *                   for Homework 5, part 1.  Includes the following:
  *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  Margin of error is 4 degrees when looking for angle between hands and the corresponding angle you are looking for.
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Ball {
   int weight;
   double radius;
   double xPosition;
   double yPosition;
   double xSpeed;
   double ySpeed;

   /**
   *  Constructor
   *  This makes a ball with weight 1, radius .37 in feet, and initializes position based on user input
   */

   public Ball(double x, double y, double xSpd, double ySpd) {
      weight = 1;
      radius = 0.37;
      xPosition = x;
      yPosition = y;
      xSpeed = xSpd;
      ySpeed = ySpd;
   }

   public double getRadius() {
      return radius;
   }

   public int getWeight() {
      return weight;
   }

   public void getBothPosition() {
      String s = "";
      String s1 = "";
      s = Double.toString(xPosition);
      s1 = Double.toString(yPosition);
      System.out.println(s + ", " + s1);
   }

   public double getXPosition() {
      return xPosition;
   }

   public double getYPosition() {
      return yPosition;
   }

   public void setPosition(double x, double y) {
      xPosition = x;
      yPosition = y;
   }

   /**
   *  Method
   *  Moves ball according to timeslice
   */
   public void moveBall(double seconds) {
      if ((Math.sqrt(xSpeed * xSpeed + ySpeed * ySpeed) > 0.083)) {

         while (seconds >= 1) {
           xPosition += xSpeed;
           yPosition += ySpeed;
           xSpeed = xSpeed * 0.99;
           ySpeed = ySpeed * 0.99;
           seconds -= 1;
         }

         if (seconds > 0) {
           xPosition += xSpeed * seconds;
           yPosition += ySpeed * seconds;
           xSpeed -= 0.01 * xSpeed * seconds;
           ySpeed -= 0.01 * ySpeed * seconds;
         }
      }
   }

   /**
   *  Method
   *  Checks to see if the velocity is low enough
   */
   public boolean isZeroVelocity() {
      if (xSpeed <= 0.083 && ySpeed <= 0.083) {
         return true;
      }

      return false;
   }

   /**
   *  Method
   *  Determines distance between two balls
   */
   public double getDistance(Ball b) {
      double distance = Math.sqrt(Math.pow(b.xPosition - xPosition, 2) + Math.pow(b.yPosition - yPosition, 2));
      return distance;
   }

   /**
   *  Method
   *  Checks to see whether or not two balls are colliding
   */
   public boolean isColliding(Ball b) {
      if (getDistance(b) <= 0.74) {
         return true;
      }

      return false;
   }


   public static void main(String args[]) {
      Ball b = new Ball(1, 2, 3, 3);
      System.out.println("\n Testing Ball Class...");
      System.out.println("The radius of the ball is " + b.getRadius() + " feet");
      System.out.println("The weight of the ball is " + b.getWeight());
      System.out.println("The xPosition of the ball is " + b.getXPosition());
      System.out.println("The yPosition of the ball is " + b.getYPosition());
      System.out.println("\n Setting new ball position...");
      b.setPosition(1, 2);
      System.out.println("The new xPosition of the ball is " + b.getXPosition());
      System.out.println("The new yPosition of the ball is " + b.getYPosition());
      b.getBothPosition();
      System.out.println("\n Moving ball...");
      b.moveBall(5);
      System.out.println("The new xPosition of the ball is " + b.getXPosition());
      System.out.println("The new yPosition of the ball is " + b.getYPosition());
      b.moveBall(2);
      System.out.println("The new xPosition of the ball is " + b.getXPosition());
      System.out.println("The new yPosition of the ball is " + b.getYPosition());
      b.moveBall(-3);
      System.out.println("The new xPosition of the ball is " + b.getXPosition());
      System.out.println("The new yPosition of the ball is " + b.getYPosition());
      b.moveBall(1);
      System.out.println("The new xPosition of the ball is " + b.getXPosition());
      System.out.println("The new yPosition of the ball is " + b.getYPosition());
      b.moveBall(4);
      System.out.println("The new xPosition of the ball is " + b.getXPosition());
      System.out.println("The new yPosition of the ball is " + b.getYPosition());
      b.moveBall(2);
      System.out.println("The new xPosition of the ball is " + b.getXPosition());
      System.out.println("The new yPosition of the ball is " + b.getYPosition());
      b.moveBall(1);
      System.out.println("The new xPosition of the ball is " + b.getXPosition());
      System.out.println("The new yPosition of the ball is " + b.getYPosition());
      b.moveBall(0);
      System.out.println("The new xPosition of the ball is " + b.getXPosition());
      System.out.println("The new yPosition of the ball is " + b.getYPosition());
      b.moveBall(-1);
      System.out.println("The new xPosition of the ball is " + b.getXPosition());
      System.out.println("The new yPosition of the ball is " + b.getYPosition());
      Ball c = new Ball(3, 3, 4, 1);
      System.out.println("The distance between the two balls " + b.getDistance(c));
      System.out.println("Are the balls colliding? " + b.isColliding(c));
   }
 }
