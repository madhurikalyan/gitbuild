package AllWebElements;

import java.util.ArrayList;
import java.util.List;

public class ListBasics {

	public static void main(String[] args) {
//		 List : of vals, alphbets 
//		Java -List is Interface -- can be used to hold multiple vals 
		//   has empty methods-- abstr methods
		
		// ArrayList-Class  --implementtation class
		
		//define arraylist
		ArrayList<String>  alObj= new ArrayList<String>();
		// create an empty list
		
		//add 3 vals
		alObj.add("Ram");
		alObj.add("Sam");
		alObj.add("Sita");
		// stores the vals sequentiall in array list
		System.out.println("Array list="+alObj);
		//Array list=[Ram, Sam, Sita]
		
		// 2. count from aaray list
		int cnt= alObj.size();
		System.out.println("cnt =" +cnt);// 3 
		
		// 3. remove
		boolean remSuccessfully= alObj.remove("Ram");
		System.out.println("remSuccessfully="+remSuccessfully);
		//remSuccessfully=true
		
		// returns  true/false
//		boolean rem= alObj.remove("ram");//Case sensitive 
//		System.out.println("rem ="+rem);//rem =false .. but it will not throw any errro
		
		System.out.println("Array list="+alObj);
//		Array list=[Sam, Sita]
		
//		alObj.clear();
//		System.out.println("Array list="+alObj);
		//Array list=[]
		
		//Hw1" 
//		alObj.add(cnt, null);
		
		//Hw1
		alObj.contains("Ram");
		
		
		String getFirst=alObj.get(0);
		System.out.println("getFirst="+getFirst);
		
		// get 2nd index val from arraylist
		String get2nd=alObj.get(1);
		System.out.println("get2nd="+get2nd);
		/*
		 * getFirst=Sam 
		 * get2nd=Sita
		 */

			// Hw: invlaid index ???
		
		alObj.add("Raju");
		alObj.add("Ravi");
		System.out.println("Array list="+alObj);
		// 1. get all vals from al obj
//		alObj.get(0);
//		alObj.get(1);
//		alObj.get(2);
		int cnt2= alObj.size(); // 4
		for(int i=0;i<=cnt2-1;i++)
		{
//			alObj.get(0);
//			alObj.get(1);
//			alObj.get(2);
			String val= alObj.get(i);
			System.out.println("val="+val);
		}
		/*
		 * val=Sam 
		 * val=Sita 
		 * val=Raju 
		 * val=Ravi
		 */
		
		// 2nd way : how to get all vals from arry list obje -use for each loop
		for(String eachval : alObj)
		{
			System.out.println("eachval="+eachval);
		}
		
		/*
		 * eachval=Sam 
		 * eachval=Sita 
		 * eachval=Raju 
		 * eachval=Ravi
		 */
		
//		List
			
	   List<String>  alObj2= new ArrayList<String>();
		// repeat all previous steps
	
		
		

	}

}
