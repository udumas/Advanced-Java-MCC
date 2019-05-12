import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class DataBase
{
	/**
	 * constructor 
	 * @param pfile string containing the name of the filename 
	 * with connection parameters
	 */
	public DataBase(String pfile)
	{
		
	}
	
	
	/**
	 * Gets a connection from the properties specified in the pfile
	 * @param pfile
	 * @return
	 */
	public Connection getConnection(String pfile)
	{
	Connection connection = new Connection();
	return connection;
	}
	
	public void createTable(String tName, String fields) throws SQLException
	{
		
	}
	
	public void insertToTable(String tName, String fields, String line) throws Exception
	{
		
	}
	
	public void showTablesInfo(String tName)
	{
		
	}
	
	public void displayTableData(String tName, ArrayList<String> fields )
	{
		
	}
	
	public void createQuery(String query, int numberOfFields) throws SQLException
	{
		
	}
	
	public void close() throws SQLException, IOException
	{
		
	}
}
