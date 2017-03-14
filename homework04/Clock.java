/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  Hayato Hori
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Clock {
  /**
   *  Class field definintions go here
   */
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private double seconds;
   private double minutes;
   private double hour;
   public double totalSeconds;

  /**
   *  Constructor goes here
   */
   public Clock() {
      this.seconds = 0.0;
      this.minutes = 0;
      this.hour = 0;
   }

  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick(double timeslice) {
      if ((timeslice < 0) || (timeslice > 1800)) {
         throw new IllegalArgumentException("The maximum time slice allowed is 1800 seconds.");
      }

      totalSeconds += timeslice;
      this.seconds += timeslice;
      if (seconds >= 60) {
         this.minutes += this.seconds / 60;
         this.seconds = this.seconds % 60;
      }

      if (this.minutes == 60) {
         this.hour++;
         this.minutes = 0;
      }

      if (this.hour == 12) {
         this.hour = 0;
      }

      return totalSeconds;
   }

  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
   public double validateAngleArg( String argValue ) {
      double angleValue = Double.parseDouble(argValue);
      if (angleValue > 360.0 || angleValue < 0) {
         throw new IllegalArgumentException("Invalid angle");
      }

      return angleValue;
   }

  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public double validateTimeSliceArg( String argValue ) {
      double timeSliceValue = Double.parseDouble(argValue);
      if (timeSliceValue > 1800 || timeSliceValue < 0) {
         return -1.0;
      }

      return timeSliceValue;
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHand() {
      return this.hour;
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHand() {
      return this.minutes;

   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
      double hourAngle = totalSeconds * 0.00833;
      double minuteAngle = totalSeconds * 0.1;
      double difference;
      if (hourAngle < 180) {
         difference = Math.abs(hourAngle - minuteAngle);
      } else {
         difference = Math.abs(hourAngle - minuteAngle - 360);
      }
      return difference;
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
      String hourStr = Double.toString(hour);
      String minStr = Double.toString(minutes);
      String secStr = Double.toString(seconds);

      return hourStr + ":" + minStr + ":" + secStr;
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock();
      System.out.println( "Next Clock Tick: " + clock.tick(150));
      System.out.println( "Next Clock Tick: " + clock.tick(150));
      System.out.println( "Validating Angle Argument..." + clock.validateAngleArg("350"));
      System.out.println( "Validating Time Slice Argument..." + clock.validateTimeSliceArg("1700"));
      System.out.println( "Getting Time of Hour Hand " + clock.getHourHand());
      System.out.println( "Getting Time of Minute Hand " + clock.getMinuteHand());
      System.out.println( "Getting Angle Between the Hands " + clock.getHandAngle());
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  0 degrees', expecting double value   0.0" );
      try { System.out.println( (0.0 == clock.validateAngleArg( "0.0" )) ? " - got   0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
   }
}

