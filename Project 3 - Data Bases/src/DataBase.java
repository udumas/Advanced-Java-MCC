import java.io.*;
import java.sql.*;
import java.util.*;


public class DataBase 
{
	Connection con;
	Statement stat;
	String cmd;
	
	/**
	 * Constructor
	 * @throws SQLException, IOException 
	 */
	public DataBase(String pfile) throws SQLException, IOException
	{
		con = getConnection(pfile);
		stat = con.createStatement();
	}
	
	/**
	 * Gets a connection from the properties specified
	 * in the file database.properties
	 * @return the database connection
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public Connection getConnection(String pfile) throws IOException, SQLException
	{
		Properties props = new Properties();

	    FileInputStream in = new FileInputStream(pfile);
	    props.load(in);
	    in.close();
	
	    String drivers = props.getProperty("jdbc.drivers");
	    if (drivers != null)
	    	System.setProperty("jdbc.drivers", drivers);
	    String url = props.getProperty("jdbc.url");
	    String username = props.getProperty("jdbc.username");
	    String password = props.getProperty("jdbc.password");
	
	    return DriverManager.getConnection(url, username, password);
	}
	
	/**
	 * Create Table
	 */
	public void createTable(String tName, String fields) throws SQLException
	{
		String cmd = "CREATE TABLE " + tName + fields;
		stat.execute(cmd);
	}
	
	/**
	 * Insert data into the table
	 * @throws SQLException 
	 */
	public void insertDataToTable(String tName, String fields, String values) throws SQLException
	{
		cmd = "INSERT INTO " + tName + fields + "\r" + "VALUES" + values;
		stat.execute(cmd);
	}
	
	/**
	 * Using Meta Data to display the information about each table, 
	 * like the column name, column size, column type
	 * @throws SQLException 
	 */
	public void showTablesInfo(String tName)
	{
		try
	     {
			Statement stat2 = con.createStatement();
	      	ResultSet rs = stat2.executeQuery("SELECT * FROM " + tName);
	      	ResultSetMetaData rsmd = rs.getMetaData();

	      	System.out.println("   number of columns in  " + tName + " table is  "
	      	                     +rsmd.getColumnCount());
	      	for (int i = 1; i <= rsmd.getColumnCount(); i++)
	      	{
	         	String columnName = rsmd.getColumnLabel(i);
	         	int columnWidth  = rsmd.getColumnDisplaySize(i);


	         	System.out.print( "   column Name  " + " " +columnName );
	            System.out.println( " \t column Width  " + " " +columnWidth );

	        }

	      	rs.close();

	      }
	      catch(SQLException e)
	      {
	    	  System.out.println("in showTablesInfo --> " + e);
		  }
	}
	
	/**
	 *Display the records of the table
	 * @throws SQLException 
	 */
	public void displayTableData(String tName, String fields)
	{
		try
	      {
			 Statement stat3 = con.createStatement();
			 System.out.println("\n----displaying the records for " +tName+
			                                                        " Table ----");
			 String query = "SELECT * FROM " + tName ;
			 ResultSet result= stat3.executeQuery(query);

			 while ( result.next())
			   System.out.println(result.getString(1)+" "+ result.getInt(2)+" "+
			                     result.getString(3)+" "+result.getString(4));

			 result.close();
	      }
	      catch(SQLException e)
	      {
			 System.out.println("in displayTableData --> " + e);
		  }
	}
	
	/**
	 *Create a query
	 */
	public void createQuery(String query, int numberOfFields) throws SQLException
	{
		
	}
	
	/**
	*Close the statement and the connection
	*/
	public void close() throws SQLException, IOException
	{
		stat.close();
		con.close();
	}

}