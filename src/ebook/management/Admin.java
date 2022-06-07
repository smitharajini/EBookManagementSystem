/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebook.management;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author SMITHARAJINI T
 */
public class Admin {
public static void main(String[] args) throws Exception{
    int choice= -1,choice1 = -1,choice3 = -1,choice4 = -1;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    DBConnection con = new DBConnection();
    
 Scanner sc = new Scanner(System.in);
 while(choice !=3){
        System.out.println("********WELCOME TO OUR E-BOOK MANAGEMENT SYSTEM***************");
        System.out.println("1. SIGNUP");
        System.out.println("2. LOGIN");
        System.out.println("3. EXIT");
        System.out.print("Make your choice: ");  
        choice = sc.nextInt();
        if(choice == 1){
            System.out.println("Enter the Name:");
                String name=br.readLine();
                
                System.out.println("Enter the Age:");
                int age=Integer.parseInt(br.readLine());
                
                System.out.println("Enter the Address:");
                String address=br.readLine();
                
                System.out.println("Enter the Contact Number: ");
                int contact_nb=Integer.parseInt(br.readLine());
                
                System.out.println("Enter the ID:");
                int user_id=Integer.parseInt(br.readLine());
           
                System.out.println("Enter the Username:");
                String user_username=br.readLine();
                
                System.out.println("Enter the Password:");
                String password=br.readLine();
                con.insert(name, age, address, contact_nb, user_id, user_username, password);
                System.out.println("SUCESSFULLY SIGNED UP");
        }
        else if(choice == 2){
            while(choice1 !=3){
                 System.out.println("1. LOGIN IF YOU ARE ADMIN");
                 System.out.println("2. LOGIN IF YOU ARE USER");
                 System.out.println("3. EXIT");
                  System.out.print("Make your choice: ");  
                 choice1 = sc.nextInt();
                 if(choice1 ==1){
                     
                System.out.println("Enter the Username: ");
                String admin_username=br.readLine();
               
                System.out.println("Enter the Password: ");
                String password=br.readLine();
                con.login(admin_username,password);
                System.out.println("Successfully logged in");
                do{
                    System.out.println("********WELCOME TO OUR E-BOOK MANAGEMENT SYSTEM - ADMIN PORTAL***************");
                    System.out.println("1. INSERT BOOK");
                    System.out.println("2. SEARCH BOOK BY ID");
                    System.out.println("3. SEARCH BOOK BY NAME");
                    System.out.println("4. UPDATE BOOK");
                    System.out.println("5. DELETE BOOK");
                    System.out.println("6. MANAGE USER DETAILS");
                    System.out.println("7. EXIT");
                    System.out.print("Make your choice: "); 
                    choice3 = Integer.parseInt(br.readLine());
                    switch(choice3){
                    case 1:
                    System.out.println("Enter the Book ID:");
                    int b_id=Integer.parseInt(br.readLine());
                
                 System.out.println("Enter the Book Name:");
                 String b_name=br.readLine();
                
                 System.out.println("Enter the Author Name: ");
                 String a_name=br.readLine();
                
                System.out.println("Enter the Publication Name: ");
                String p_name=br.readLine();
                
                System.out.println("Enter the ISBN : ");
                int isbn =Integer.parseInt(br.readLine());
                
                con.insertbook(b_id,b_name,a_name,p_name,isbn);
                break;
            case 2:
                System.out.print("Enter Book ID to search: ");
             
                b_id = Integer.parseInt(br.readLine());
                con.searchByBookId(b_id);
                break;
                   
             case 3:
                System.out.print("Enter Book Name to search: ");
                 b_name=br.readLine();
                 con.searchByBookName(b_name);
                break;    
            case 4:
                 System.out.println("Enter the Book Name to be updated: ");
                 b_name=br.readLine();
                
                
                System.out.println("Enter the Publication Name:");
                p_name=br.readLine();
                
                System.out.println("Enter the ISBN: ");
                isbn =Integer.parseInt(br.readLine());
                con.updatebook(b_name,p_name,isbn);
                break;
            case 5:
                System.out.println("Enter the book id to delete: ");
                b_id = Integer.parseInt(br.readLine());
                con.deletebook(b_id);
                break;
            case 6:
                System.out.println("BY NAME");
                con.manageuserdetailsbyname();
                break;
                    }  
                }while(choice3 !=7);
 }
            if(choice1 ==2){
                     
                System.out.println("Enter the Username: ");
                String user_username=br.readLine();
               
                System.out.println("Enter the Password: ");
                String password=br.readLine();
                con.loginuser(user_username,password);
                System.out.println("Successfully logged in");
                do{
                    System.out.println("********WELCOME TO OUR E-BOOK MANAGEMENT SYSTEM - USER PORTAL***************");
                    System.out.println("1. SEARCH BOOK");
                    System.out.println("2. UPDATE DETAILS");
                    System.out.println("3. EXIT");
                     System.out.print("Make your choice: ");  
                    choice4 = Integer.parseInt(br.readLine());
             switch(choice4){
            
            case 1:
                System.out.print("Enter Book Name to search: ");
                 String b_name=br.readLine();
                 con.searchByBookName(b_name);
                break;  
               
             
            case 2:
                System.out.print("Enter User ID :");
                 int admin_id = Integer.parseInt(br.readLine());
                 System.out.println("Enter the Address to update: ");
                 String address =br.readLine();
                
                System.out.println("Enter the Age to update: ");
                int age=Integer.parseInt(br.readLine());
               
                con.updatedetails(admin_id,address, age);
                break;
            
                
             }
                }while(choice4!=3);
            
            
            
            }
}
}
}
}
}
