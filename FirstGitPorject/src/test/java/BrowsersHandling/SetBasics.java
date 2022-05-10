package BrowsersHandling;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetBasics {

	public static void main(String[] args) throws InterruptedException {

		
		  ArrayList<String> al = new ArrayList<String>(); al.add("Ramu");
		  al.add("Swathi"); al.add("Prasant"); System.out.println("Al="+al); //
//		  Al=[Ramu, Swathi, Prasant] al.get(0);
		  System.out.println("al.get of 0="+al.get(0));
		  System.out.println("al.get of 1="+al.get(1)); // al.get of 0=Ramu // al.get
//		  of 1=Swathi
		  
		  // learn dif method in array list // remove //
		  for(String eachVal : al) {
		  System.out.println("eachVal  from arraylist="+eachVal);
		  
//		  eachVal from arraylist=Ramu eachVal from arraylist=Swathi eachVal from
//		  arraylist=Prasant
		  
		  }

//	Iterator<String> it = al.iterator();
//
//	// String al0= it.next(); 
//	// String al1= it.next(); // //
////	System.out.println("al0="+al0); // System.out.println("al1="+al1); //
////	al0=Ramu // al1=Swathi
//
//	while(it.hasNext())
//	{
//			  String valFromArrlist=it.next();
//		  System.out.println("valFromArrlist="+valFromArrlist); //
////		  valFromArrlist=Prasant ?
//				  }
//	
//	//
//	ListIterator<String>  lit= al.listIterator();
//	//  can iterate vals in forward direction, in reverse direction
//	
//	while(lit.hasNext())
//	{
//		System.out.println("lit hasNext=" +lit.next());
////		lit=Ramu
////				lit=Swathi
////				lit=Prasant
//	}
//	
//	while(lit.hasPrevious())
//	{
//		System.out.println("lit hasPrevious=" +lit.previous());
////		lit hasPrevious=Prasant
////				lit hasPrevious=Swathi
////				lit hasPrevious=Ramu
//	}

	// *********************************
	//
	/*
	 * HashSet<String> hs = new HashSet<String>(); hs.add("Ram"); hs.add("Swathi");
	 * hs.add("Prashanth"); System.out.println("HashSet ="+hs); //HashSet =[Swathi,
	 * Prashanth, Ram]
	 * 
	 * // for each loop for(String eachVal : hs) {
	 * System.out.println("eachVal from hashset obj="+eachVal);
	 * 
	 * eachVal from hashset obj=Swathi eachVal from hashset obj=Prashanth eachVal
	 * from hashset obj=Ram
	 * 
	 * }
	 * 
	 * // iterator Iterator<String> it= hs.iterator();
	 * 
	 * while(it.hasNext()) { String EahVal= it.next();
	 * System.out.println("EahVal="+EahVal); // EahVal=Swathi // EahVal=Prashanth //
	 * EahVal=Ram // }
	 * 
	 * // stores vals in random order .. no listiterator() fro hashset class
	 */
		  
		  
		  
	System.out.println("ends");

}

}
