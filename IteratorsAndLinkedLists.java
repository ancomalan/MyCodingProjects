//alan vo 
//occc fall 2023 
//advanced java 
//iterators and linked lists

import java.util.*;
import java.util.Scanner;
public class IteratorsAndLinkedLists {
	public static void main(String[] args) {
		int numEntries = 0;
		Scanner s = new Scanner (System.in);
		System.out.print("Please enter number of entries to generate: ");
		numEntries = s.nextInt();

		// generate random integers in a loop
		List<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < numEntries; i++) {
			arrayList.add(i);
		}
		LinkedList<Integer> linkedList = new LinkedList<>(arrayList);

		// Time how long it takes the iterator to traverse the list
		long iteratorStart = System.currentTimeMillis();
		ListIterator<Integer> listIterator = linkedList.listIterator();
		while (listIterator.hasNext()) {
			listIterator.next();
		}
		long iteratorEnd = System.currentTimeMillis();

		System.out.println("Number of entries: " + numEntries);

		// Display how long it took to traverse list using iterator 
		System.out.println("Time to traverse the list using an iterator : "
				+ (iteratorEnd - iteratorStart) / 1000. + " seconds!");

		// Time how long it takes the get(index) method to traverse the list
		long getMethodStart = System.currentTimeMillis();
		for (int i = 0; i < numEntries; i++) {
			linkedList.get(i);
		}
		long getMethodEnd = System.currentTimeMillis();

		// Display how long it took to traverse list using get(index) method
		System.out.println("Time to traverse the list using the get(index) method : "
				+ (getMethodEnd - getMethodStart) / 1000. + " seconds!");

		s.close();
	}
}
