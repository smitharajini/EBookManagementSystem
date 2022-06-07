
package ebook.management;
import java.util.Scanner;
import java.sql.*;

public class User {
    DBConnection db = new DBConnection();
    Users users = new Users();
    public void getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Name: ");
        String name = sc.nextLine();
        users.setName(name);
        System.out.print("Enter the Age: ");
        int age=Integer.parseInt(sc.nextLine());
        users.setAge(age);
        System.out.print("Enter the Address: ");
        String address = sc.nextLine();
        users.setAddress(address);
        System.out.print("Enter the Contact Number: ");
        long contactNb = Long.parseLong(sc.nextLine());
        users.setContactNb(contactNb);
        System.out.print("Enter the Mail-id: ");
        String mailId = sc.nextLine();
        users.setMailId(mailId);
        System.out.print("Enter the Username:");
        String userName = sc.nextLine();
        users.setUserName(userName);
        System.out.print("Enter the Password:");
        String password = sc.nextLine();
        users.setPassword(password);
        try{
            insert();
        }
        catch(Exception e){ }
    }
    public void insert() throws Exception{
       
       db.ps = db.con.prepareStatement("INSERT INTO ADMIN(NAME,AGE,ADDRESS,CONTACT_NB,ADMIN_ID,ADMIN_USERNAME,PASSWORD) VALUES(?,?,?,?,?,?,?)");
       db.ps.setString(1,users.getName());
       db.ps.setInt(2,users.getAge());
       db.ps.setString(3, users.getAddress());
       db.ps.setLong(4,users.getContactNb());
       db.ps = db.con.prepareStatement("INSERT INTO LOGIN(USERNAME,PASSWORD) VALUES(?,?)");
       db.ps.setString(5, users.getUserName());
       db.ps.setString(6, users.getPassword());
       db.ps.executeUpdate();
       System.out.println("Sucessfully inserted");
}
    
}
class Users{
    private String name;
    private int age;
    private String address;
    private long contactNb;
    private String mailId;
    private String userName;
    private String password;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }
    public void setContactNb(long contactNb){
        this.contactNb = contactNb;
    }
    public long getContactNb() {
        return this.contactNb;
    }
    public void setMailId(String mailId){
        this.mailId = mailId;
    }
    public String getMailId() {
        return this.mailId;
    }
    public void setUserName(String UserName){
        this.userName = userName;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }                
    
}
