/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Timer.java
 *  Purpose       :  Provides a class defining methods for the Timer class
 *  @author       :  Hayato Hori
 *  Date written  :  2017-04-04
 *  Description   :  This class provides a bunch of methods which may be useful for the SoccerSim class
 *                   for Homework 5, part 1.  Includes the following:
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Timer {
  /**
   *  Class field definintions go here
   */
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private double seconds;
   private double minutes;
   private double hour;
   public double totalSeconds;

  /**
   *  Constructor goes here
   */
   public Timer() {
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
      this.minutes += Math.floor(this.seconds / 60);
      if (minutes >= 60) {
         this.hour++;
         this.minutes = this.minutes - 60;
      }
      this.seconds = this.seconds % 60;

      if (hour == 12) {
         this.hour = 0;
      }

      return totalSeconds;
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
      System.out.println( "Next Timer Tick: " + clock.tick(120));
      System.out.println( "Next Clock Tick: " + clock.tick(1000));
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "Next Clock Tick: " + clock.tick(1000));
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "Next Clock Tick: " + clock.tick(1000));
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "Next Clock Tick: " + clock.tick(1000));
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "Next Clock Tick: " + clock.tick(1000));
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "Next Clock Tick: " + clock.tick(1000));
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "Next Clock Tick: " + clock.tick(1000));
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "Next Clock Tick: " + clock.tick(1000));
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "Next Clock Tick: " + clock.tick(1000));
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "Next Clock Tick: " + clock.tick(1000));
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "Next Clock Tick: " + clock.tick(1000));
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "Next Clock Tick: " + clock.tick(1000));
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "Next Clock Tick: " + clock.tick(1000));
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "Next Clock Tick: " + clock.tick(1000));
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "Next Clock Tick: " + clock.tick(1000));
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "Next Clock Tick: " + clock.tick(1000));
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "Next Clock Tick: " + clock.tick(1000));
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "Next Clock Tick: " + clock.tick(1000.1999));
      System.out.println( "    New clock created: " + clock.toString() );
   }
}

