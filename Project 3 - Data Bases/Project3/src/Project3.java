import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;




public class Project3 
{
	public static void main(String[] args)throws Exception
	{
	
	String EmployeeFieldsCreate = "Employee_Id INTEGER, First_Name VARCHAR(10), "+
                                "Last_Name VARCHAR(10), Department VARCHAR(20), "+
                                "Hours INTEGER";
	String employeeFields = "Employee_Id, First_Name, Last_Name, Department, Hours";
	String locationFieldsCreate = "Department VARCHAR(20),LOCATION VARCHAR(20),State Char(2)";
	String locationFields ="Department, LOCATION, State";
	String line;
	Scanner locationData = new Scanner(new File("Table2"));
	Scanner employeeData = new Scanner(new File("Table1"));
	String employee[]={"Employee ID","First Name","Last Name","Department","Hours"};
    ArrayList<String> employeeArrayList = new ArrayList<String>(Arrays.asList(employee));


	DataBase db = new DataBase("dbprops.dat");
	db.createTable("Employees", "employeeFieldsCreate");
	while(employeeData.hasNext())
	{
	db.insertToTable("employee", employeeFields,employeeData.nextLine());
	}
	db.createTable("Locations", locationFields);

	while(locationData.hasNext())
	{
	db.insertToTable("Locations", locationFields, locationData.nextLine());
	}
	String tableName="Employees";
	db.showTablesInfo(tableName);
	db.displayTableData(tableName, employeeArrayList);
	tableName="Location";
	db.showTablesInfo(tableName);
	db.displayTableData(tableName,employeeArrayList);
	String query1= "SELECT Employees.* "+
                      "From Employees " +
                      "WHERE DEPARTMENT='COMPUTER' ";
	db.createQuery(query1, 5);
	String query2 = query1+" AND HOURS<=40";
	db.createQuery(query2, 2);
	String query3 = "SELECT EMPLOYEES.First_Name, EMPLOYEES.Last_Name, EMPLOYEES.EMPLOYEE_ID, "+
                      "EMPLOYEES.HOURS, LOCATIONS.LOCATION "+
                      "FROM EMPLOYEES, LOCATIONS "+
                      "WHERE EMPLOYEES.DEPARTMENT=LOCATIONS.DEPARTMENT "+
                      "AND LOCATIONS.LOCATION='Brighton'";

	db.createQuery(query3, 4);
	
	}
}

	