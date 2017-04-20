/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Fibonacci.java
 *  Purpose       :  Provides a class defining methods for the Fibonacci class
 *  @author       :  Hayato Hori
 *  Date written  :  2017-04-20
 *  Description   :  This class provides a bunch of methods which may be useful for the Fibonacci class
 *                   for Homework 6.  Includes the following:
 *
 *  Notes         :  States what the nth number is in the fibonacci sequence. For example the 0th, number is 0. The 5th, is 3.
 *  Warnings      :  It only works until the 8th Fibonacci Sequence.
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */



public class Fibonacci {
    public static void main(String[] args) {
    	if (args.length <= 0) {
    		System.out.println("Please enter a number");
    	}

    	GinormousInt a = null;
    	GinormousInt b = null;
    	GinormousInt c = null;
    	int temp = Integer.parseInt(args[0]);

    	if (temp > 5000) {
    		System.out.println("\n                            Working......");
    	}

		if (args.length == 1) {
			if (temp == 0) {
				System.out.println(0);
				return;
			}
			if (temp <= 2) {
				System.out.println(1);
			} else {
				a = new GinormousInt("1");
				b = new GinormousInt("2");
				for (int i = 3; i < temp; i++) {
					c = new GinormousInt(a.add(b));
					a = new GinormousInt(b.toString());
					b = new GinormousInt(c.toString());
				}

				System.out.println(b.toString());
			}
		}
    }
}
