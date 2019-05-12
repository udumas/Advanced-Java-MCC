import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class Project3 {
	public static String parseFieldNames(String fileName){
		return "'Name', 'Employee_ID', 'First_Name', 'Last_Name', 'Department', 'Hours'";
		
	}
	public static String parseFields(String filename){
		return "Name VARCHAR(30) , " +
			    "Employee_ID INTEGER, " +
				"First_Name VARCHAR(10), " +
				"Last_Name VARCHAR(10), " +
				"Department VARCHAR(20), " +
				"Hours INTEGER";
		
	}
	public static String parseValues(String values){
		return "8901, 'Dan', 'Howard', 'Computer', '38'";
	}
	
	public static void main(String args[]) throws SQLException, IOException
	{
		DataBase db = new DataBase("dbprops.dat");		
		db.createTable("Test", parseFields("hi"));		
		db.insertDataToTable("Test", parseFields("hi"), parseValues("hi"));
		ArrayList<String> fields = new ArrayList<String>();
		String fieldNames = parseFieldNames("hi");
		for(int i=0; i<5; i++)
			String[] tokens = fieldNames.split(" ,'");
			fields.add(tokens[i]);
		db.displayTableData("Test", );
		db.close();
	}
}
