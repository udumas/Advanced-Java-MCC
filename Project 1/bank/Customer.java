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




public class Customer
	implements Comparable{
	String id;
	String lastName;
	String firstName;


	/**
	 * Default Constructor sets lastname, firstname and id to null.
	 * 
	 **/
	public Customer(){
		lastName=null;
		firstName=null;
		id=null;
	}



	/**
	 * This Constructor accepts three Strings and sets the last name first name and id to the strings.
	 * @param lastName - the lastname to be associated with this Customer 
	 * @param firstName - the firstName to be associated with this Customer
	 * @param id - the id number to be associated with this customer
	 **/
	public Customer(String lastName, String firstName, String id){
		this.lastName=lastName;
		this.firstName=firstName;
		this.id=id;
	}

	/**
	 * This Constructor accepts two Strings and sets the last name and first name to the strings.
	 * @param lastName - the lastname to be associated with this Customer 
	 * @param firstName - the firstName to be associated with this Customer
	 **/
	public Customer(String lastName, String firstName){
		this.lastName=lastName;
		this.firstName=firstName;
		this.id=null;

	}
	
	
	/**
	 * This Constructor accepts ta single String representing the id.
	 * @param id - the id number to be associated with this customer
	 **/
	private Customer(String id){
		this.firstName=null;
		this.lastName=null;
		this.id=id;

	}
	/**
 	 * Returns the account ID
 	 * @return id 
 	 **/
	private String getId(){ 
		return id;
	}

	/**
	 * sets the first name of the Customer
	 * @param id
	 **/
	private void setId(String id){
		this.id = id;
	}

	/**
	 * Returns the first and last names of the Customer
	 * @return name
	 **/
	private String getName(){
		String name = this.lastName + "," + this.firstName;
		return name;
	}
	
	/**
	 * Returns the last name of the Customer
	 * @return lastName
	 **/
	public String getLastName(){
		return this.lastName;
	} 

	/**
	 * sets the last name of the Customer
	 * @param lastName
	 **/
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	/**
	 * Returns the first name of the Customer
	 * @return firstName
	 **/
	public String getFirstName(){
		return this.firstName;
	}

	/**
	 * sets the first name of the Customer
	 * @param firstName
	 **/
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}


	/**
	 * Returns a formatted String containing 
	 * the last name, first name, and id of the Customer
	 * @return customerString
	 **/
	public String toString(){
		String returnString = getName()+ "\t" + this.id;
		return returnString;
	}
	
	/**
	 * Deermines whether this Customer is equal to the Customer passed 
	 * @param object - an object of the Customer Class
	 * @return isEqual - returns true if the Customer parameter has the same id as this Customer
	 **/
	public boolean equals(Object otherObject){
		Boolean isEqual = false;
		String id;
		
			if (this.compareTo(otherObject)==0){
	

				isEqual = true;
			}else{
				isEqual = false;
			} 

		
		return isEqual;	
	}
	/**
	 * Calls the compareTo method of the Strig class to compare the id of two Customer Objects.
	 * @param obj - an object of the Customer Class.
	 * @return value - returns an positive integer if this object is greater than the otherObject 
	 * a negative value if the otherObject is greater than this object
	 * and zero if this object is equal to the otherObject.
	 */
	public int compareTo(Object otherObject){
		
		String id;
		if (!(otherObject instanceof Customer)){
			// Checks to see if the Object passed is of the Customer Class
			// If the passed Object is of the Customer Class assigns the value of the passed
			// Objects id attribute to the methods id value.
			throw new IllegalStateException
					("The Object is not of the Customer Class");
		
		}else{
			int value = 0;
			id=((Customer)otherObject).getId();
			value=(int)this.id.compareTo(id);
			return value;
		}
	}
}