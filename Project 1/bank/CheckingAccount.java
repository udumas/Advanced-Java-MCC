/**
 * Program: CheckingAccount Class
 * Course Title: Advanced Java
 * @Author: Joel Salisbury
 * @version 1.0
 * Date:
 * Lab: #
 * Description: This Class defines an object with 
 * four parameters first name last name and id.
 * contains methods 
 *		to compare objects of the Customer Class
 * 		check for equality
 * 		output String representing all class attributes
 *		and setters and getters for each class value 
 **/
public class CheckingAccount
	extends Customer
		implements Comparable{

	private double balance;

/**
 * Default Constructor sets lastname, firstname and id to null.
 * 
 **/
public CheckingAccount(){
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
public CheckingAccount(String lastName, String firstName, String id, double balance){
	super(lastName, firstName, id);
	this.balance=balance;
}

/**
 * This Constructor accepts two Strings and sets the last name and first name to the strings.
 * @param lastName - the lastname to be associated with this Customer 
 * @param firstName - the firstName to be associated with this Customer
 **/
public CheckingAccount(String lastName, String firstName){
	super(lastName, firstName);
	this.id=null;
	this.balance=0;
}
/**
 * This Constructor accepts ta single String representing the id.
 * @param id - the id number to be associated with this customer
 **/
public CheckingAccount(String id){
	super(id);
}

public void deposit(double amount){
	if(!(amount<0)){
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
	String returnString=super.toString() + this.balance + "\t" + "Checking";
	return returnString;

}




/**
 * This method generates a an error message to return to the screen 
 * @param transactionType - the transactionType determines whether to send 
 * an invalid deposit or invalid withdraw
 * @param amount - the amount the user attempted to withdraw or deposit from
 * the account 
 * @return returns a String to send to std output	

 **/	
public String printError(String transactionType, double amount){
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


}