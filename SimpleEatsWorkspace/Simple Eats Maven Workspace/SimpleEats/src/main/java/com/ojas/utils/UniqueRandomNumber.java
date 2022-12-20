package com.ojas.utils;

import java.util.ArrayList;
import java.util.Collections;

public class UniqueRandomNumber {
	 public static int getUniqueRandomNumber() {
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        for (int i=1; i<1000; i++) list.add(i);
	        Collections.shuffle(list);
			return list.get(0);
	    }
}
