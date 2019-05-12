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
public class SavingsAccount
	extends Customer
		implements Comparable{

	private double balance;

/**
 * Default Constructor sets lastname, firstname and id to null.
 * 
 **/
public SavingsAccount(){
	super();
	this.balance=0;
	
}

/**
 * This Constructor accepts three Strings and one double sets the last name first name and id to the strings.
 * and the balance to the double
 * @param lastName - the lastname to be associated with this Customer 
 * @param firstName - the firstName to be associated with this Customer
 * @param id - the id number to be associated with this customer
 * @param balance
 **/
public SavingsAccount(String lastName, String firstName, String id, double balance){
	super(lastName, firstName, id);
	this.balance=balance;
}

/**
 * This Constructor accepts two Strings and sets the last name and first name to the strings.
 * @param lastName - the lastname to be associated with this Customer 
 * @param firstName - the firstName to be associated with this Customer
 **/
public SavingsAccount(String lastName, String firstName){
	super(lastName, firstName);
}

/**
 * This Constructor accepts ta single String representing the id.
 * @param id - the id number to be associated with this customer
 **/
public SavingsAccount(String id){
	super(id);
}

public void deposit(double amount){
	if((amount>0)){
		this.balance+=amount;
	}else{
		System.out.println(printError("deposit", amount));
	}

}
public void withdraw(double amount){
	if(!(amount>0)){
		this.balance-=amount;
		if(this.balance<amount)
			System.out.print("Withdrawl Amount: " + amount + "Greater than the current Balance ");
	}
	else{
		System.out.println(printError("withdraw", amount));
	}
}

/**
 * Returns a formatted String containing 
 * the last name, first name, and id of the Customer
 * @return returnString
 **/
public String toString(){
	String returnString=super.toString() + this.balance + "\t" + "Savings";
	return returnString;


/**
 * @param transactionType - A String representing either a savings or checking acount
 * @param amount 		  - the amount that the transaction is for.
 */
private String printError(String transactionType, double amount){
	String returnString=null;
	switch(transactionType){

		case "withdraw":	
		 returnString = "---ERROR--- invalid " + transactionType +" amount\n"
							+ this.toString() + "\n"
							+ "Balance: " + this.balance
							+ "Amount Requested: " + amount;
		break;
		case "deposit":
		 returnString = "---ERROR--- invalid " + transactionType +" amount\n"
							+ this.toString() + "\n"
							+ "Balance: " + this.balance
							+ "Amount: " + amount;
		break;
		default:
		 returnString = "---ERROR--- Invalid Transaction Type\n"
							+ this.toString() + "\n"
							+ "Balance: " + this.balance;

		}
	return returnString;
}

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
		int value=0
		String id;
		if (!(otherObject instanceof Customer)){
			// Checks to see if the Object passed is of the Customer Class
			// If the passed Object is of the Customer Class assigns the value of the passed
			// Objects id attribute to the methods id value.
			throw new IllegalStateException
					("The Object is not of the Customer Class");
		
		}else{
			int value = 0;
			id=((;
			value=(int)this.id.compareTo((Customer)otherObject).getId());
			return value;
		}
	}

}