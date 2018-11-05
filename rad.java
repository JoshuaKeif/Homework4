/*Joshua Keif
Radix Sort(using bucket sort)
Comp435 homwork #4

Due to issues with the compiler on my laptop im not entirely sure if this will run on every version
Two sites I've been able to run my code off of succesfully

https://www.jdoodle.com/online-java-compiler
https://www.tutorialspoint.com/compile_java_online.php

The bellow code will automatically populate an array of a predetermined length
The following calls will print out the random array, sort the array, and reprint the now sorted array
*/
import java.util.*;
public class Radix 
{
    //main function to call all my functions
    public static void main(String args[]) 
    {
        //int[] radArray = {10,22,654,653,23,1,0}
        //Customization of our Array
        int maxElements = 50;
        int min = 0;
        int max = 9999;
        int[] radArray = new int[maxElements];
        
        //Calls to each respective function
        populate(radArray,maxElements,max,min);
        //Printout of unsorted Array
        System.out.println("Unsorted:");
        printing(radArray,maxElements);
        radixsort(radArray,maxElements);
        //Printout of sorted Array
        System.out.println("Sorted:");
        printing(radArray,maxElements);
    }
    //Prints Array
    public static void printing(int[] radArray,int maxElements)
    {
        int i = 0;
        while(i < maxElements)
        {
            System.out.println("Array Element " + i + " is " + radArray[i]);
            i++;
        }
    }
    //Bucket Sort used
    public static void radixsort(int[] radArray,int maxElements)
    {
    //Initial List
    List<Integer>[] buckets = new ArrayList[10];
        //Creates buckets 0...9(I don't know why but using the loop fails every 20 odd runs)
        buckets[0] = new ArrayList<Integer>();
        buckets[1] = new ArrayList<Integer>();
        buckets[2] = new ArrayList<Integer>();
        buckets[3] = new ArrayList<Integer>();
        buckets[4] = new ArrayList<Integer>();
        buckets[5] = new ArrayList<Integer>();
        buckets[6] = new ArrayList<Integer>();
        buckets[7] = new ArrayList<Integer>();
        buckets[8] = new ArrayList<Integer>();
        buckets[9] = new ArrayList<Integer>();
        //our modulous divisor that we increase each loop
        int m = 1;
        boolean outOfScope = false;
        int j;
        while(!outOfScope)
        {
            outOfScope = true;
            // Each element is put into its respective bucket
            for (Integer i : radArray) 
            {
                //determining which bucket 
                j = i / m;
                //appending to the correct bucket
                buckets[j % 10].add(i);
                //checking if weve exceeded the highest digit in the array to break the do while loop to prevent us from sorting out of the scope of the numbers
                if (j > 0) {outOfScope = false;}
            }
            //increase modulous divisor to the next column
            m *= 10;
            //The buckets are emptied back into our original array sorted in the nth column
            int a = 0;
            //Cycles through each primary list(Can be reversed for GSD)
            for (int k = 0; k < 10; k++) 
            {
                //emptys the secondary lists in order of LSD(can be reversed for GSD)
                for (Integer i : buckets[k]) 
                {radArray[a++] = i;/*System.out.println("Bucket element" + i );*/}
                //empties buckets after each secondary list is copied for the next time we run the cycle
                buckets[k].clear();
                //System.out.println("Next Bucket" + k );
            }
        }
    }
    //Populates Array with random integers
    public static void populate(int[] radArray,int maxElements,int max,int min)
    {
        int i = 0;
        while(i < maxElements)
        {
            radArray[i] = (int)(Math.random() * ((max - min) +1) + min);
            i++;
        }
    }
}