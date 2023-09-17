//alan vo 
//occc fall 2023
//advanced java 
//fibonacci 
import java.util.Scanner;
import java.math.BigInteger; 
public class Fibonacci {

	//i could not figure out to use a int vector for the memoization part so I got help from: https://medium.com/@apk2072/fibonacci-solution-three-ways-883607b9ba7f
	
	//big integer memo recursive version 
	private static BigInteger bigIntMemoRecursion(int n, BigInteger[] memo) {
		//if there is value in memo array at index, return it
		if(memo[n] != null) {
			return memo[n];
		}
		//if 0,1,or 2, return 1
		BigInteger result = BigInteger.valueOf(0);
		if(n <= 2) {
			result = BigInteger.valueOf(1);
		}
		//otherwise use recursion to compute fib number
		else {
			result = bigIntMemoRecursion(n-1, memo).add(bigIntMemoRecursion(n-2, memo));
			memo[n] = result; //add to memo array
		}
		return result;
	}

	//big integer version of fibonacci loop
	public static BigInteger bigIntLoop (int n) {
		BigInteger x = BigInteger.ONE; 
		BigInteger y = BigInteger.valueOf(n);
		if (y.compareTo(BigInteger.TWO)>0) {
			BigInteger a = BigInteger.ONE;
			BigInteger b = BigInteger.ONE; 
			for (int i = 3; i <= n ; i++) {
				x = a.add(b);
				a = b;
				b = x;
			}
		}
		return x; 
	}


	public static long[] theMemo;
	public static long memoFibRecursion (int n) {
		long result = 1; 
		if (n > 2) {
			if (theMemo[n] != 0) {
				result = theMemo[n];
			}
			else {
				result = memoFibRecursion(n-1) + memoFibRecursion(n-2);
				theMemo[n] = result;
			}

		}
		return result;
	}


	public static long fib_loop(long n ) {
		long result = 1; 
		if (n > 2) {
			long a = 1; 
			long b = 1; 
			for (int i = 3; i <= n ; i++) {
				result = a + b; 
				a = b ; 
				b = result; 
			}
		}
		return result;
	}

	public static long fibRecursion (int n) {
		long result = 1;
		if (n > 2) {
			result = fibRecursion(n-1) + fibRecursion(n-2);
		}
		return result;
	}


	public static void main (String [] args) {
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
		System.out.println("Fib(" + f + ") = " + bigIntLoop(f));
		long t2 = System.currentTimeMillis();
		System.out.println("Elapsed time for loop: " + ( t2 - t1 ) / 1000. + " seconds");
		System.out.println();

		long t3 = System.currentTimeMillis();	
		BigInteger[] memo = new BigInteger[f+1]; //create big integer memo array
		System.out.println("Fib(" + f + ") = " + (bigIntMemoRecursion(f,memo)));
		long t4 = System.currentTimeMillis();
		System.out.println("Elapsed time for recursion: " + (t4 - t3) /1000. + " seconds");

	}
}
