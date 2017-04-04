/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  The main program for the Ball class
 *  @see
 *  @author       :  Hayato Hori
 *  Date written  :  2017-03-21
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
   private final double xTemp;
   private final double yTemp;
   double xSpeed;
   double ySpeed;
   private final double xTempSpeed;
   private final double yTempSpeed;

   /**
   *  Constructor
   *  This makes a ball with weight 1, radius 4.45, and initializes position at 0,0
   */

   public Ball(double x, double y, double xSpd, double ySpd) {
      weight = 1;
      radius = 0.37;
      xPosition = x;
      yPosition = y;
      xTemp = x;
      yTemp = y;
      xSpeed = xSpd;
      ySpeed = ySpd;
      xTempSpeed = xSpd;
      yTempSpeed = ySpd;
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

   public double getXSpeed(double xVel, double seconds) {
      xSpeed = (xVel * seconds) * (1 - (0.01 * seconds));
      return xSpeed;
   }

   public double getYSpeed(double yVel, double seconds) {
      ySpeed = (yVel * seconds) * (1 - (0.01 * seconds));
      return ySpeed;
   }

   public void setPosition(double x, double y) {
      xPosition = x;
      yPosition = y;
   }

   public void moveBall(double seconds) {
      if ((Math.sqrt(xSpeed * xSpeed + ySpeed * ySpeed) > 0.083)) {

         while (seconds >= 1.0) {
           xPosition += xSpeed;
           yPosition += ySpeed;
           xSpeed -= 0.01 * xSpeed;
           ySpeed -= 0.01 * ySpeed;
           seconds -= 1.0;
         }
         if (seconds > 0.0) {
           xPosition += xSpeed * seconds;
           yPosition += ySpeed * seconds;
           xSpeed -= 0.01 * xSpeed * seconds;
           ySpeed -= 0.01 * ySpeed * seconds;
         }
      }
   }

   public boolean isZeroVelocity() {
      if (xSpeed <= 0.083 && ySpeed <= 0.083) {
         return true;
      }

      return false;
   }

   public double getDistance(Ball b) {
      double distance = Math.sqrt(Math.pow(b.xPosition - xPosition, 2) + Math.pow(b.yPosition - yPosition, 2));
      return distance;
   }

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
      System.out.println("Getting Speed of Ball at X " + b.getXSpeed(1, 5));
      System.out.println("Getting Speed of Ball at Y " + b.getYSpeed(2, 5));
      b.moveBall(10);
      System.out.println("The new xPosition of the ball is " + b.getXPosition());
      System.out.println("The new yPosition of the ball is " + b.getYPosition());
      System.out.println("Getting Speed of Ball at X " + b.getXSpeed(1, 10));
      System.out.println("Getting Speed of Ball at Y " + b.getYSpeed(2, 10));
      Ball c = new Ball(3, 3, 4, 1);
      System.out.println("The distance between the two balls " + b.getDistance(c));
      System.out.println("Are the balls colliding? " + b.isColliding(c));
   }
 }
