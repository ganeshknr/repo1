//	program for implementing quicksort algorithm

//	import the scanner package for reading input from terminal
import java.util.Scanner;

//	class for the quicksort method
public class QuickSort {

  //	method for quicksort algorithm
  public static void quickSort( int[] array, int low_index, int high_index ) {

  	int pivot = low_index;	//	pivot element i am taking as first element
  	int loop_low = low_index + 1;
  	int loop_high = high_index;

 		/*	if there are any elements to verify with pivot element
  	 *	then only enter into the loop
  	 */
 		while( loop_low <= loop_high ) {

  		/*	find a element which is greater than pivot from left to right
  		 *	and index should not go out of bounds as incrementing
  		 */
  		while( ( loop_low <= high_index ) && ( array[loop_low] < array[pivot] ) ) {

		  	loop_low++;

  		}

  		/*	find a element which is less than pivot from right to left
  		 *	and index should not cross pivot
  		 */
 			while( ( loop_high > pivot ) && ( array[loop_high] > array[pivot] ) ) {

  			loop_high--;

	  	}

		  /* 	if there are still elements to verify between the elements 
		   *	found then swap the elements found and continue to verify
		   */
  		if( loop_low < loop_high ) {

	  		//	swapping elements
	  		array[loop_low] = array[loop_low] ^ array[loop_high];
	  		array[loop_high] = array[loop_low] ^ array[loop_high];
	  		array[loop_low] = array[loop_low] ^ array[loop_high];

		  } else {

				/* 	-if there are no elements to verify then we found the exact
				 *	 position for pivot element, i.e. loop_high position, a 
				 *	 position where all left side are lesser and all right side 
				 *	 are greater than pivot element.

				 *	-Now swap the elements pivot and loop_high.
				 */
	  		if( pivot != loop_high ) {

		  		//	swapping elements
		  		array[pivot] = array[pivot] ^ array[loop_high];
		  		array[loop_high] = array[pivot] ^ array[loop_high];
		  		array[pivot] = array[pivot] ^ array[loop_high];

			  }

				/*	Now pivot element got placed at correct position. List is 
				 *	divided into two lists (left to the pivot element and 
				 *	right to the pivot element) which are to be sorted.
				 */

    		//	sort the list left side to the pivot element
	  		quickSort( array, low_index, loop_high - 1 );

		  	//	sort the list right side to the pivot element
		  	quickSort( array, loop_high + 1, high_index);

  		}	//	if else control block end

  	}	//	first while loop end

 	}	//	quickSort method termination

  //main method
  public static void main( String[] args ) {
		
    int size;	//	number of elements which user wants to enter
    int loop_var;
    Scanner input = new Scanner(System.in);	//	object to read input

    //	reading the number of elements from user
   	System.out.println("enter size of array");
   	size = input.nextInt();

    int array[] = new int[size];	//	array for the elements to store

  	System.out.println("Enter "+array.length+" elements into array");

  	//	reading the values into the array from user
  	for( loop_var = 0; loop_var < size; loop_var++ ) {
		
  	  array[loop_var] = input.nextInt();

  	}

   	//	calling method to sort the array using quicksort algorithm
   	quickSort( array, 0, size - 1);

    //	displaying the sorted array
 	  System.out.println("Sorted list:");
    for(loop_var = 0; loop_var < size; loop_var++) {

      System.out.println( array[loop_var] );

    }

  }	//	main method terminated

}	//	QuickSort class closed

