/**
 * Two examples of methods for determining whether an int is prime. 
 * You will be asked questions about this code on the loops test.
 * 
 * @author Jon Cooper
 * @version November 18, 2013
 */

import java.util.ArrayList;
public class Primes 
{
    /**
     * Determine if an int is prime.
     * 
     * @param n     number to test
     * @return      true if number is prime, false otherwise
     */
    public static boolean isPrime1(int n)
    {
        for (int i=2; i<n; i++)
        {
            if (n % i == 0) return false;
        }

        return true;
    }

    /**
     * A more efficient way to determine if an int is prime.
     * 
     * @param n     number to test
     * @return      true if number is prime, false otherwise
     */
    public static boolean isPrime2(int n)
    {
        if (n < 2) return false;
        else if (n == 2) return true;
        else if (n % 2==0) return false;

        double limit = Math.sqrt(n);

        for (int i=3; i<=limit; i+=2){
            if (n % i == 0) return false;
        }

        return true;
    }

    public static int nthPrime(int index){

        int primeNum = 0;
        int num = 1;

        while (primeNum != index) {
            num++;
            if (isPrime2(num)) primeNum++;
        }

        return num;
    }
    
    public static int numPrime(int lower, int upper) {
        int count = 0;
        
        for (int i = lower; i < upper; i++) {
            if (isPrime2(i)) count++;
        }
        return count;
    }
    
    public static int primeSum(int upper) {
        int sum = 0;
        
        for (int i = 2; i < upper; i++) {
            if (isPrime2(i)) sum += i;
        }
        
        return sum;
    }

    public static int sumFirst(int limit) {
        int sum = 0;
        int primeNum = 1;
        
        for (int i = 0; i < limit; i++) {
            if (isPrime2(i)) primeNum++; sum += i;
            
        }
        
        return sum;
    }
    public static void main(String[] args)
    {
        // test isPrime1
        long x = 23234423563L;
        System.out.println( isPrime2(1) );
        System.out.println( isPrime2(19) );
        System.out.println(isPrime2(91));
        System.out.println(isPrime2(643));

        System.out.println();

        // test isPrime2
        System.out.println( isPrime2(1) );
        System.out.println( isPrime2(19) );
        System.out.println(isPrime2(91));
        System.out.println(isPrime2(643));

        // Study the isPrime1 and isPrime2 methods to answer the following:
        // 0. Study the method isPrime1. Describe the set of numbers that would be 
        //    tested as divisors when checking the value 19 for primality. Do the 
        //    same for 91 and 643.

        /**
         * All numbers between 2 and n are checked if the product of n%i == 0
         */

        // 1. Study the method isPrime2. Describe the set of numbers that would be 
        //    tested as divisors when checking the value 19 for primality. Do the 
        //    same for 91 and 643.

        // 2. The number 15,485,863 is the 1 millionth prime number. Suppose it is 
        //    tested in both isPrime1 and isPrime2 for primality. About how much
        //    faster will isPrime2 finish testing. Show how you determined your answer.

        // isPrime2 will answer quicker as it dows not have to go through all 15 million numbers.
        // isPrime1 will do 15 million calculations whereas isPrime2 will do roughly 1900

        // 3. In isPrime2, why is the limit calculated before the loop rather than
        //    writing the loop as for (int i=3; i<=Math.sqrt(n); i=i+2)?

        // Because everytime the loop is iterated, the computer will have to compute the squrt of n
        // which is not efficent for computation times.

        // 4. The number 1 is not prime, however both prime function say that it is.
        //    Negative numbers cannot be prime either. Fix each function so that all
        //    ints less than 2 return false.

        // 

        System.out.println();
        // Write blocks of code that use isPrime2 to solve the following problems:

        // 5. Generate a list of the first 50 prime numbers.

        ArrayList<Integer> primes50 = new ArrayList<Integer>();
        for (int i = 0; i < 50; i++) {
            if (isPrime2(i)) primes50.add(i);

        }

        System.out.println(primes50.toString());

        // 6. What is the 100th prime? the 1000th? The 12847th?
        System.out.println("100th prime is " + nthPrime(100));
        System.out.println("1000th prime is " + nthPrime(1000));
        System.out.println("12847th prime is " + nthPrime(12847));

        System.out.println();
        // 7. In the set of integers from 2-1000000, how many are prime?
        System.out.println(numPrime(2,1000000));
        // 8. What is the sum of the all prime numbers below 1000000?
        System.out.println("Sum of all primes below 1000000 is: " + -1 * primeSum(1000000)); // why is this returning a negative number??
        // 9. What is the sum of the first 1000 prime numbers?
        System.out.println("Sum of first 1000 prime numbers is " + sumFirst(1000));

    }

}
