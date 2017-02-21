package com.cooksys.ftd.assignments.control;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * FizzBuzz is an old programming exercise.
 * The goal is to iterate over a range of numbers and print a message about each number's divisibility.
 * <p>
 * The message is generated the following way:
 * *) if the number is divisible by three, the message is `Fizz`
 * *) if the number is divisible by five, the message is `Buzz`
 * *) if the number is divisible by both three and five, the message is `FizzBuzz`
 * *) otherwise, no message is produced
 * <p>
 * The exact message format for this assignment is specified in the `message(n)` method.
 */
public class FizzBuzz {

    /**
     * Checks whether a given int `a` is evenly divisible by a given int `b` or not.
     * For example, `divides(4, 2)` returns `true` and `divides(4, 3)` returns `false`.
     *
     * @param a the number to be divided
     * @param b the number to divide by
     * @return `true` if a is evenly divisible by b, `false` otherwise
     * @throws IllegalArgumentException if b is zero
     */
    public static boolean divides(int a, int b){ //throws IllegalArgumentException {
    	
    	if (b == 0)
    	{
    		throw new IllegalArgumentException();
    	}
    	
    	if (a % b != 0 )
        {
        	return false;
        }
        else
        {
        	return true;
        }
    	
    }

    /**
     * Generates a divisibility message for a given number. Returns null if the given number is not divisible by 3 or 5.
     * Message formatting examples:
     * 1 -> null // not divisible by 3 or 5
     * 3 -> "3: Fizz" // divisible by only 3
     * 5 -> "5: Buzz" // divisible by only 5
     * 15 -> "15: FizzBuzz" // divisible by both three and five
     *
     * @param n the number to generate a message for
     * @return a message according to the format above, or null if n is not divisible by either 3 or 5
     */
    public static String message(int n) {
    	
    	if (!divides(n,3) && !divides(n,5))
    	{
    		return null;
    	}
    	else if (divides(n,3) && divides(n,5))
    	{
    		return "" + n + ": FizzBuzz";
    		
    	} 
    	else if (!divides(n,3) && divides(n,5))
    	{
    		return "" + n + ": Buzz";
    	}
    	else if (divides(n,3) && !divides(n,5))
    	{
    		return "" + n + ": Fizz";
    		
    	}
    	
    	return null;
    	/*
    	if (n == 0) return null;
    	
        if (n % 3 == 0 && n % 5 ==0)
        {
        	return "FizzBuzz";
        }
        else if (n % 3 == 0 && n % 5 != 0)
        {
        	return "Fizz";
        }
        else if (n % 3 != 0 && n % 5 == 0)
        {
        	return "Buzz";
        	
        }
        else
        {
        	return null;
        }
        */
    }

    /**
     * Generates an array of messages to print for a given range of numbers.
     * If there is no message for an individual number (i.e., `message(n)` returns null),
     * it should be excluded from the resulting array.
     *
     * @param start the number to start with (inclusive)
     * @param end the number to end with (exclusive)
     * @return an array of divisibility messages
     * @throws IllegalArgumentException if the given end is less than the given start
     */
    public static String[] messages(int start, int end) throws IllegalArgumentException {
        
    	if (end < start) throw new IllegalArgumentException();
    	
    	String[] messages;
    	
    	if (start == end) 
    	{
    		messages = new String[1];
    	}
    	else
    	{
    		messages = new String[end-start];
    	}
        
    	int count_of_non_null = 0;
    	
    	for (int i = start; i < end; i++)
        {
    		if (!(message(i) == null))
    		{
    			messages[count_of_non_null] = message(i);
    			count_of_non_null++;
    		}
        }
    	
    	String[] non_null_messages = new String[count_of_non_null];
    	
    	//non_null_messages = messages.clone();
    	
    	
    	//return non_null_messages;
    	
    	int counter2 = 0;
    	
    	for (String m : messages)
    	{
    		if (m != null && m != "0")
    		{
    			non_null_messages[counter2] = m;
    			counter2++;
    		}
    	}
    	
    	//System.out.println(non_null_messages.length);
    	
    	return non_null_messages;
    	
    }

    /**
     * For this main method, iterate over the numbers 1 through 115 and print
     * the relevant messages to sysout
     */
    public static void main(String[] args) {
        String[] msgs_to_print = messages(1, 116);
        
        for (int i = 0; i < msgs_to_print.length; i++)
        {
        	System.out.println(msgs_to_print[i]);
        }
    }

}
