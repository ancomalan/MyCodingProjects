//alan vo 
//factorial demo 
//occc fall 2023
//advanced java

import java.util.Scanner; 
import java.math.BigInteger;

public class Factorial {

	//big integer recursive version of factorial function 
	public static BigInteger bigIntRecursion(int f) {
		 BigInteger x = BigInteger.ONE; 
		 BigInteger y = BigInteger.valueOf(f);

		 if (y.compareTo(BigInteger.ZERO) > 0) {
			 x = y.multiply(bigIntRecursion(f-1));
		 }
		 return x;
	}	

	//recursive version of factorial function
	public static long factorialRecursion(int f) {
		long result = 1; 
		if (f > 0 ) {
			result = f * factorialRecursion(f-1);
		}
		return result; 
	}
	
	//big integer non-recursive factorial function
	public static BigInteger bigIntFactorialLoop(int f) {
		BigInteger x = BigInteger.ONE;
		BigInteger y = BigInteger.valueOf(f);
		
		if (y.compareTo(BigInteger.ZERO) > 0) {
			for (BigInteger d = BigInteger.valueOf(1); d.compareTo(y)<=0 ;d = d.add(BigInteger.ONE) ) {
				x = x.multiply(d);
			}
		}
		return x;
		
	}
	
	//non-recursive factorial function
	public static long factorialLoop(int f) {
		long result = 1 ;
		if (f > 0) {
			for (int i = 1; i <= f; i++) {
				result *= i ;
			}
		}
	
		return result; 
		
		
	}
	public static void main(String[] args) {
		int f; 
		if (args.length == 1) {
			f = Integer.parseInt(args[0]);
		}
		else {
			System.out.print("Please enter an integer: ");
			Scanner s = new Scanner (System.in);
			f = Integer.parseInt(s.nextLine());
			s.close();
		}
		long t1 = System.currentTimeMillis();
		System.out.println(f + "! = " + bigIntFactorialLoop(f)); //print non recursive function 
		long t2 = System.currentTimeMillis();
		System.out.println("The elapsed time for NON-RECURSIVE factorial function is: " + ( t2 - t1 ) / 1000. + " seconds");
		
		//check how many digits in factorial loop
		BigInteger x = bigIntFactorialLoop(f);
		String y = x.toString();
		System.out.println("There are " + y.length() + " number of digits in factorial " + f);
		System.out.println();
		
		long t3 = System.currentTimeMillis();
		System.out.println(f + "!= " + bigIntRecursion(f)); //print recursive function
		long t4 = System.currentTimeMillis();
		System.out.println("The elapsed time for RECURSIVE factorial function is: " + ( t4 - t3 ) / 1000. + " seconds");

	}

}
