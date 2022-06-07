package ebook.management;
import java.sql.*;
class DBConnection {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    DBConnection(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
             con=DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "system","welcome");
             System.out.println("Connection Established");
        }catch(Exception e){}
    }
   
public void insert(String name, int age , String address , int contact_nb , int user_id , String user_username , String password ) throws Exception{
       ps = con.prepareStatement("INSERT INTO USERS(NAME,AGE,ADDRESS,CONTACT_NB,USER_ID,USER_USERNAME,PASSWORD) VALUES(?,?,?,?,?,?,?)");
       ps.setString(1,name);
       ps.setInt(2,age);
       ps.setString(3, address);
       ps.setInt(4,contact_nb);
       ps.setInt(5, user_id);
       ps.setString(6, user_username);
       ps.setString(7, password);
       ps.executeUpdate();
       System.out.println("Sucessfully inserted");
}
public void login(String admin_username,String password) throws Exception{
       ps = con.prepareStatement("SELECT * FROM ADMIN WHERE ADMIN_USERNAME = ? AND PASSWORD = ?");
       ps.setString(1, admin_username);
       ps.setString(2, password);
       ps.executeUpdate();
       
}

public void loginuser(String user_username,String password) throws Exception{
       ps = con.prepareStatement("SELECT * FROM USERS  WHERE USER_USERNAME = ? AND PASSWORD = ?");
       ps.setString(1, user_username);
       ps.setString(2, password);
       ps.executeUpdate();
       
}

public void insertbook(int b_id, String b_name, String a_name,String p_name,int isbn) throws Exception{
       ps = con.prepareStatement("INSERT INTO BOOK(B_ID,B_NAME,A_NAME,P_NAME,ISBN) VALUES(?,?,?,?,?)");
       ps.setInt(1, b_id);
       ps.setString(2,b_name);
       ps.setString(3,a_name);
       ps.setString(4,p_name);
       ps.setInt(5, isbn);
        ps.executeUpdate();
       System.out.println("Sucessfully inserted");
}
public void updatebook(String b_name, String p_name,int isbn) throws Exception{
     ps = con.prepareStatement("UPDATE BOOK SET P_NAME = ?,ISBN = ? WHERE B_NAME = ?");
    
     ps.setString(3,b_name);
       ps.setString(1,p_name);
       ps.setInt(2, isbn);
       
        ps.executeUpdate();
       System.out.println("Sucessfully updated");
}
public void updatedetails(int user_id, String address, int age) throws Exception{
     ps = con.prepareStatement("UPDATE USERS SET ADDRESS = ?, AGE = ? WHERE USER_ID = ?");
     ps.setInt(3, user_id);
       ps.setString(1,address);
       ps.setInt(2, age);
       
        ps.executeUpdate();
       System.out.println("Sucessfully updated");
}
public void deletebook(int b_id) throws Exception{
    
    ps = con.prepareStatement(" SELECT * FROM BOOK WHERE B_ID = ?");
    ps.setInt(1,b_id);
    rs = ps.executeQuery();
    if(rs.next()){
        ps = con.prepareStatement("DELETE FROM BOOK WHERE B_ID = ?");
        ps.setInt(1,b_id);
         ps.executeUpdate();
         System.out.println("DELETED");
         
       System.out.println("Sucessfully deleted");
    }
    else
        System.out.println("NOT FOUND");
}
public void displayadmins()throws Exception{
    ps = con.prepareStatement("SELECT * FROM ADMIN");
    rs = ps.executeQuery();
    while(rs.next()){
        System.out.printf("%-15s%20s%20s%20s%20s%20s%20s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
    }
}

public void searchByBookId(int b_id)throws Exception{
   ps = con.prepareStatement("SELECT * FROM BOOK WHERE B_Id = ? ");
   ps.setInt(1, b_id);
   rs = ps.executeQuery();
    if(rs.next()){
        System.out.printf("%-15s%20s%20s%20s%20s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
         System.out.println("Requested book is shown");}
      else
        System.out.println("NOT FOUND");
    }     

public void searchByBookName(String b_name)throws Exception{
   ps = con.prepareStatement("SELECT * FROM BOOK WHERE B_NAME= ? ");
   ps.setString(1, b_name);
   rs = ps.executeQuery();
    if(rs.next()){
        System.out.printf("%-15s%20s%20s%20s%20s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
           System.out.println("\n Requested book is shown ");}
      else
        System.out.println("NOT FOUND");
    }   

public void manageuserdetailsbyname()throws Exception{
    ps = con.prepareStatement("SELECT * FROM USERS ORDER BY NAME DESC");
    rs = ps.executeQuery();
    while(rs.next()){
        System.out.printf("%-15s%20s%20s%20s%20s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
    }
}
public void close() throws Exception{
    con.close();
    System.out.println("Connection closed");
}

    


}
