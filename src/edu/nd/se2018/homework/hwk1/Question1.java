package edu.nd.se2018.homework.hwk1;

import java.util.HashSet;
import java.util.Set;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){

		Set<Integer> seen = new HashSet<Integer>();
		int total = 0;
		for (int i : numbers) {
			if (seen.contains(i))
				continue;
			else {
				total += i;
				seen.add(i);
			}		
		}
		return total;
	}
}
