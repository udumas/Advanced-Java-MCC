/**
 * Program: Customer Class
 * Course Title: Advanced Java
 * @Author: Joel Salisbury
 * @version 1.0
 * Date:
 * Lab: #
 * Description: This Class defines an object with 
 * three parameters first anme last name and id.
 * contains methods 
 *		to compare objects of the Customer Class
 * 		check for equality
 * 		output String representing all class attributes
 *		and setters and getters for each class value 
 **/

public class Bank{

    private int count;
    
    private Customer[] list;
    
    public Bank(){
    	list = new Customer[0];
    	count=0;
    }
    private void add(Customer aCustomer){
    	
    	ensureCapacity(count+1);
    	
    	list[count-1] = aCustomer;
    }
    /**
     * Changes the Capacity of the array using arraycopy to copy the contents of the current list to
     * another array with a length of 10 greater than the previous list
     * @param capacity -- integer representing the current capacity of the array
     * to be enlarged
     * @return biggerArray --Customer[] that has a greater capacity
     * @pre
     */
    public void ensureCapacity(int capacity){
    	Customer[] biggerArray = new Customer[capacity+1];
    	if ((list.length-1)<count){
    		System.arraycopy(this.list, 0, biggerArray,0,count);
    		list = biggerArray;
    	}
    	
    }
    /**
     * Deletes a Customer from the account list
     * @param Customer -- A customer Object that contains the same id as the customer to be deleted
     * @return boolean -- True if Customer deleted, returns false if the Customer to be deleted is not found
     * 
     */
    public boolean delete(Customer aCustomer){
    	return true;
    }
    
    
    /** 
     * Searches the list for a Customer with the same ID as the Customer 
     * passed to the method
     * @param Customer -- A Customer object witht the same ID as the Customer to be found
     * @return int -- Returns an integer value equal to the index of a Customer with the ID of the 
     * Customer passed to the method
     */
    private int findIndex(Customer aCustomer){
    	int index=-1;
    
    	for(int counter=0; count<list.length;count++)
    		if(list[counter].equals(aCustomer))
    			index=counter;
    	return index;
    
    }
    
    /**
     * @return Customer a Customer with an ID matching the ID of the Customer 
     * passed to the method
     * @param Customer -- receives a Customer Object with the ID of the desired Customer 
     */
    public Customer retrieve(Customer aCustomer){
    	int index = findIndex(aCustomer);
    	return list[index];
    }

    public String toString(){
    	String returnString=null;
    	for(int i=0; i<list.length; i++){
    		returnString+=list[i].toString();
    	}
    	return returnString;
    }
}