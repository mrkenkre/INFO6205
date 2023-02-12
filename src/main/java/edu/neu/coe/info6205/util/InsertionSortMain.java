package edu.neu.coe.info6205.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;

public class InsertionSortMain {

	public static Integer[] randomArray(int size) {
		Random random = new Random();
		Integer[] arr = new Integer[size];
		for (int i = 0; i < size; i++) {
			arr[i] = random.nextInt(size);
		}
		return arr;
	}

	public static Integer[] orderedArray(int size) {
		Integer[] arr = new Integer[size];
		for (int i = 0; i < size; i++) {
			arr[i] = i;
		}
		return arr;
	}

	public static Integer[] partiallyOrderedArray(int size) {
		Random random = new Random();
		Integer[] arr = orderedArray(size);
		for (int i = 0; i < size / 2; i++) {
			int j = random.nextInt(size);
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		return arr;
	}

	public static Integer[] reverseOrderedArray(int size) {
		Integer[] arr = orderedArray(size);
		Collections.reverse(Arrays.asList(arr));
		return arr;
	}

	public static void exec(int n, int runs) {

		Benchmark_Timer benchmarkTimer = new Benchmark_Timer<Integer[]>("Insertion Sort",
				t -> new InsertionSort<Integer>().sort(t, 0, t.length));
		double randomTime, partialTime, orderedTime, reverseTime;
		randomTime = benchmarkTimer.runFromSupplier(() -> randomArray(n), runs);
		orderedTime = benchmarkTimer.runFromSupplier(() -> orderedArray(n), runs);
		partialTime = benchmarkTimer.runFromSupplier(() -> partiallyOrderedArray(n), runs);
		reverseTime = benchmarkTimer.runFromSupplier(() -> reverseOrderedArray(n), runs);
		
		System.out.println("Length : " + n + "  Random Array : " + (randomTime) + " Sorted array: " + (orderedTime) + " partial ordered: "
				+ (partialTime) + " Reverse order: " + (reverseTime));
	}

	// return j;

	public static void main(String[] args) {
		Benchmark_Timer bt = new Benchmark_Timer<Integer[]>("Insertion sort",
				t -> new InsertionSort<Integer>().sort(t, 0, t.length));
		double time;
		// time = bt.runFromSupplier(() -> randomArray(10), 30);
		InsertionSortMain insertionSortMain = new InsertionSortMain();
		int n = 500;
		for (int j = 0; j <= 5; j++) {
			if (j > 0)
				n = n * 2;
			exec(n, 30);
			/*
			 * Integer[] randomArray = insertionSortMain.randomArray(n);
			 * System.out.println("Random Array: " + randomArray.length); //
			 * Arrays.toString(randomArray).length()); time = bt.runFromSupplier(() ->
			 * insertionSortMain.randomArray(n), 30); System.out.println("Time: "+time);
			 * 
			 * Integer[] orderedArray = orderedArray(j);
			 * System.out.println("Ordered Array: " + orderedArray.length);
			 * 
			 * // Arrays.toString(orderedArray).length());
			 * 
			 * Integer[] partiallyOrderedArray = partiallyOrderedArray(j);
			 * System.out.println("Partially Ordered Array: " +
			 * partiallyOrderedArray.length);
			 * 
			 * // Arrays.toString(partiallyOrderedArray).length());
			 * 
			 * Integer[] reverseOrderedArray = reverseOrderedArray(j);
			 * System.out.println("Reverse Ordered Array: " + reverseOrderedArray.length);
			 * 
			 * // Arrays.toString(reverseOrderedArray).length());
			 */ }
	}
}
