package hospital;
 
import java.sql.*; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.logging.Level; 

import java.util.logging.Logger; 
public class CONICTAION { // take care this is the class which already exist 
public static Connection con; 
public static void ConnectToSQL(){ // to connect to SQL 
try { 
String url = "jdbc:sqlserver://localhost:1433;databaseName=HOSPITAL;encrypt=true;trustServerCertificate=true"; 
String username ="Ahmed"; 
String password ="01100"; 
 con = DriverManager.getConnection(url, username,password); 
System.out.println("CONNECTED"); 
} catch (SQLException ex) { 
Logger.getLogger(CONICTAION.class.getName()).log(Level.SEVERE, null, ex); 
System.out.println("Error CONNECTION"); 
}} 
public static void Close () { // to close the connection of SQL 
try { con.close(); 
} catch (SQLException ex) { System.out.println("ERROR Connection"); } 
} 
public static boolean executeNonquary (String sqlStatement) { //to update, delete, insert 
try{   
//ConnectToSQL(); 
Statement stmt = con.createStatement(); 
stmt.execute(sqlStatement); 
return true; 
}catch (SQLException e){ 
System.out.println(e); 
 
return false; 
} 
}    
}
