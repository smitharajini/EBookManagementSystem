/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebook.management;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
/**
 *
 * @author SMITHARAJINI T
 */
public class HomePage {
    public static void main(String[] args) throws Exception{
    int choice= -1;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    DBConnection con = new DBConnection();
    
    do{
        System.out.println("********WELCOME TO OUR E-BOOK MANAGEMENT SYSTEM***************");
        System.out.println("1. LOGIN");
        System.out.println("2. SIGN UP");
        System.out.println("3. EXIT");
        choice = Integer.parseInt(br.readLine());
        switch(choice){
            case 1:
                System.out.println("1. LOGIN");
                break;
            case 2:
                System.out.println("1. LOGIN");
                break;
            case 3:
                con.close();
                System.out.println("THANKS");
                break;
        }
    }while(choice!=3);
}
}