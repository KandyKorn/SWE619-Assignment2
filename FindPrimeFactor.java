package assignment2;

import java.util.*;



/**
 * @author Andoni arias

 * @version 2-5
 * 
 * Finds the first prime factor of A in B
 * 
 * @findPrimeFactor returns the index of the first number in B that is a prime factor of the number at the same index in A
 * 					returns NullPointerException if any value in A or B is null
 * 					returns IndexOutOfBoundsException if the list is empty or if there is no value i such that B[i] is a prime factor of A[i]
 * @isPrime			returns true if the passed value is true, false if the passed value is false
 */

public class FindPrimeFactor
{
    public static int findPrimeFactor(List<Integer> a,List<Integer> b) throws NullPointerException
    {
    	if (a == null || b == null)
    	{
    		throw new NullPointerException();
    	}

    	int current_val = -1; //will never be returned, exceptions will all be handled, but java requires an int be returned 
    	try
    	{
        int max_iterations; //shorter list determines max number of loops

        int a_val;
    	

        max_iterations = b.size() + 1;// the +1 allows the program to throw an OutOfBounds exception if there is no b(i) that is prime factor of a(i)
        if (a.size() < b.size()) //find shortest list

        {

            max_iterations = a.size() + 1; //adjusts max number of iterations as necessary

        }
        for (int i = 0; i < max_iterations; i++)

        {

        	a_val = a.get(i);

            current_val = b.get(i); //compare two values in each index

            if (isPrime(current_val) == true && a_val % current_val == 0) //b(i) must be prime AND a factor of a(i)

            {

                return i;

            }

        }
    	}
    	catch (NullPointerException e) 
    	{
    		System.out.println(e);
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		System.out.println("There is no b[i] such that b[i] is a prime factor of a[i]. " + e + " was found.");
    	}

    	return current_val;
  
    }

    public static boolean isPrime(int x)

    {

        if (x == 1) //account for x = 1

            return true;

        if (x <= 0) //account for negatives (this is not specified in assignment directions)

            return false;
        if (x == 2)
        	
        	return true;

        for(int i = 2; i<x; i++)

        {

            if (x % i == 0)

                return false;

        }

        return true;

    }

}
