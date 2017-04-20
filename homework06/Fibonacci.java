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
    	GinormousInt a = new GinormousInt("01");
    	GinormousInt b = new GinormousInt("01");
    	int temp = Integer.parseInt(args[0]);
		if (args.length == 1) {
			if (temp <= 2) {
				System.out.println(1);
			} else {
				for (int i = 3; i < temp; i++) {
					GinormousInt c = new GinormousInt(a.add(b));
					a = b;
					b = c; 
				}

				System.out.println(b.toString());
			}
		}
    }
}
