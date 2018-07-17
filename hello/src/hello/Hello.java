package hello;

import java.sql.*;

public class Hello
{
	
    public static PreparedStatement pstmt1 = null;
    public static PreparedStatement pstmt2 = null;
    public static Connection conn = null;
    public static Statement stmt = null;
    
    
    
	public static Connection getConnection() throws Exception
	{
	 String JDBC_DRIVER="org.h2.Driver"; //Driver connection
	 String DB_URL="jdbc:h2:~/STARTUPS"; //Path of FOUNDERS db
	
	 String USER_NAME="sa"; //User_name
	 String PASSWORD="";    //Password
	
	//registering JDBC driver
	Class.forName(JDBC_DRIVER);
			
	//Connecting to JDBC
	Connection con=DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
	System.out.println("Database Created!");
	return con;
	}
	
	public void createcom() throws SQLException
	{
		    //Connection for SQL statement
		    Statement stmt=conn.createStatement();
			
			//Creating COMPANY table
			String query="CREATE TABLE COMPANY_TAB"+
			              "(id INTEGER not NULL,"+
					      "name VARCHAR(255),"+
					      "city VARCHAR(255),"+
					      "Company_id INTEGER not NULL,"+
			              "PRIMARY KEY(id))";
			
			//Executing query
			stmt.executeUpdate(query);
			System.out.println("Company Table has been Created!");
		    
	}
	
	
	public void createfoun() throws SQLException
	{
		        //Connection for SQL statement
				Statement stmt=conn.createStatement();
				
				//Creating FOUNDERS table
				String query="CREATE TABLE COMPANY_FOUND"+
				              "(id INTEGER not NULL,"+
						      "name VARCHAR(255),"+
						      "Company_id INTEGER not NULL,"+
						      "website VARCHAR(512),"+
						      "Com_Linkedin_link VARCHAR(512),"+
						      "Fou_Linkedin_link VARCHAR(512),"+
						      "Com_Twitter_Link VARCHAR(512),"+
						      "Fou_Twitter_Link VARCHAR(512),"+
						      "Com_Fb_link VARCHAR(512),"+
						      "Fou_Fb_link VARCHAR(512),"+
						      "Com_email_id VARCHAR(512),"+
						      "Com_Blog_link VARCHAR(512),"+
						      "Ref_link VARCHAR(512),"+
						      "FOREIGN KEY(Company_id) REFERENCES COM_TAB(Company_id))";
				
				//Executing query
				stmt.executeUpdate(query);
				System.out.println("Founders Table has been Created!");
				
	}
	
	
	public int insertcomp(int id,String name,String city,int Company_id) throws SQLException
	{
		//SQL query
		String query= "INSERT INTO COMPANY_TAB(id,name,city,Company_id) VALUES (?, ?, ?, ?)";
		
		//Prepared Statement 
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, id);
		statement.setString(2,name);
		statement.setString(3,city);
		statement.setInt(4,Company_id);
		
		//executing query
		 int x=statement.executeUpdate();
		 return x;
	}
	
	
	public void retrievecomp() throws SQLException
	{
		String sql = "SELECT * FROM COMPANY_TAB"; 
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql); 
        
        while(rs.next()) 
        { 
           int id  = rs.getInt(1); 
           String name = rs.getString(2); 
           String city = rs.getString(3);  
           int Company_id=rs.getInt(4);
           
           System.out.print("ID: " + id); 
           System.out.print(", NAME: " + name);  
           System.out.println(", CITY: " + city); 
           System.out.println(",COMPANY_ID:"+Company_id);
        } 
        rs.close();
	}
	
	
	public void insertfoun(int id,String name,int Company_id,String website,String Com_Linkedin_link,String Fou_Linkedin_link,String Com_Twitter_Link,String Fou_Twitter_Link,String Com_Fb_link,String Fou_Fb_link,String Com_email_id,String Com_Blog_link,String Ref_link) throws SQLException
	{
		//SQL query
		String query= "INSERT INTO COMPANY_FOUND(id,name,Company_id,website,Com_Linkedin_link,Fou_Linkedin_link,Com_Twitter_Link,Fou_Twitter_Link,Com_Fb_link,Fou_Fb_link,Com_email_id,Com_Blog_link,Ref_link) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		//Prepared Statement 
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, id);
		statement.setString(2,name);
		statement.setInt(3,Company_id);
		statement.setString(4,website);
		statement.setString(5,Com_Linkedin_link);
		statement.setString(6,Fou_Linkedin_link);
		statement.setString(7,Com_Twitter_Link);
		statement.setString(8,Com_Twitter_Link);
		statement.setString(9,Com_Fb_link);
		statement.setString(10,Fou_Fb_link);
		statement.setString(11,Com_email_id);
		statement.setString(12,Com_Blog_link);
		statement.setString(13,Ref_link);
		
		//executing query
		 statement.executeUpdate();
	}
	
	public void retrievefoun()throws SQLException{
		String sql = "SELECT * FROM COMPANY_FOUND"; 
		
		Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql); 
         
        while(rs.next()) 
        { 
           int id  = rs.getInt(1); 
           String name = rs.getString(2); 
           int Company_id=rs.getInt(3);
           String website=rs.getString(4);
           String Com_Linkedin_link=rs.getString(5);
           String Fou_Linkedin_link = rs.getString(6);  
           String Com_Twitter_link = rs.getString(7);
           String Fou_Twitter_link = rs.getString(8);
           String Com_Fb_link = rs.getString(9);
           String Fou_Fb_link = rs.getString(10);
           String Com_email_id = rs.getString(11);
           String Com_Blog_link = rs.getString(12);
           String Ref_link = rs.getString(13);
           
           
           
           
           System.out.print("ID: " + id); 
           System.out.print(", NAME: " + name);  
           System.out.println(", Company_id: " + Company_id); 
           System.out.println(",website " + website); 
           System.out.println(",Com_Linkedin_link " + Com_Linkedin_link); 
           System.out.println(", Fou_Linkedin_link " + Fou_Linkedin_link); 
           System.out.println(", Com_Twitter_link " +Com_Twitter_link ); 
           System.out.println(", Fou_Twitter_link " +Fou_Twitter_link); 
           System.out.println(",Com_Fb_link " + Com_Fb_link); 
           System.out.println(", Fou_Fb_link " +Fou_Fb_link ); 
           System.out.println(", Com_email_id " +Com_email_id ); 
           System.out.println(", Com_Blog_link " +Com_Blog_link ); 
           System.out.println(",Ref_link " + Ref_link); 
         } 
        rs.close();
	  }

	
	
	
	
	public static void main (String[] args) throws Exception
	{
		
	  try
	  {
		
	    conn=getConnection();
	    
	    
	    //to create company & founders table
	    Hello obj=new Hello();
	    obj.createcom();
	    obj.createfoun();
	    int y;
	    //to call inserting company details method
	    y=obj.insertcomp(01,"Biriyani By Kilo","Noida",101);
		y=obj.insertcomp(02,"firstcry.com","Chennai",102);
		y=obj.insertcomp(03,"doodleblue Innovations","Chennai",103);
		y=obj.insertcomp(04,"Karomi Smart Solutions","Chennai",104);
		y=obj.insertcomp(05,"CallHealth Services","Hyderabad",105);
		
		//to retrieve company details data
		obj.retrievecomp();;
		
		//to call inserting founders details method
		obj.insertfoun(01,"Kaushik Roy",101,"https://biryanibykilo.com/","https://www.linkedin.com/company/biryanibykilo/","https://www.linkedin.com/in/kaushik-roy-a283bb/",
				"https://twitter.com/biryanibykilo","NIL","https://www.facebook.com/biryanibykilo/","https://www.facebook.com/kaushikroy9","mail@biryanibykilo.com","https://biryanibykilo.com/blog","https://www.crunchbase.com/organization/biryani-by-kilo");
		
		obj.insertfoun(02,"Supam Maheshwari",102,"http://www.firstcry.com/","https://www.linkedin.com/company/firstcry/","https://www.linkedin.com/in/supam-maheshwari-a735a5/?locale=de_DE",
				  "https://twitter.com/firstcryindia","https://twitter.com/supammaheshwari?lang=en","https://www.facebook.com/FirstCryIndia","NIL","customercare@firstcry.com","https://blog.firstcry.com/","https://www.crunchbase.com/organization/firstcry-com#section-overview");
		
		obj.insertfoun(03,"Atishe Chordia",103,"https://www.doodleblue.com/","https://www.linkedin.com/company/doodleblue/","https://www.linkedin.com/in/atishe-chordia-567a8723/","https://twitter.com/Doodleblue7",
				 "https://twitter.com/atishechordia","https://www.facebook.com/doodleblue.Innovations","NIL","genius@doodleblue.com","https://www.doodleblue.com/blog.php","https://www.crunchbase.com/organization/doodleblue#section-overview");
		
		obj.insertfoun(04,"Vilva Natarajan",104,"http://www.karomi.com/","https://www.linkedin.com/company/karomi-technology/","https://www.linkedin.com/in/vilva-natarajan-805917/","https://twitter.com/karomitec",
	     "https://twitter.com/vilva_karomi","https://www.facebook.com/pg/Karomi-Technology-Private-Limited-511424635641418/about/?ref=page_internal","https://www.facebook.com/vilva.natarajan","marketing@karomi.com","http://karomi.com/blog/hello-world/","https://www.crunchbase.com/organization/karomi#section-overview");
		
		obj.insertfoun(05,"Sandhiya Raju",105,"https://www.callhealth.com/","https://www.linkedin.com/company/call-health/?originalSubdomain=in","NIL","https://twitter.com/callhealthindia?lang=en",
				 "https://twitter.com/sandhyaraju","https://www.facebook.com/callhealthofficial/","https://www.facebook.com/sandhya.raju.378?lst=100005051198783%3A679419971%3A1511591173","response@callhealth.com",
				 "https://blog.callhealth.com/","https://www.crunchbase.com/organization/callhealth-services-pvt-ltd#section-overview");
		
		//to retrieve founder details data
	    obj.retrievefoun();
	  }
	  	  
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  
	  finally {
		  conn.close();
	  }
		
   }
}
