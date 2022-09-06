package edu.altierd.Assign01;

import java.util.*;  
public class DMV{
public static void main(String[] args){


System.out.println("Enter name:");

Scanner scan = new Scanner(System.in); 

String firstName = scan.next();  
String lastName = scan.next();  

System.out.println("Enter DOB (month day year):");

int month = scan.nextInt();
int date= scan.nextInt();
int year= scan.nextInt();


System.out.println("Enter height in inches:");

int inches = scan.nextInt();

int feet=inches/12;
int remainders=inches%12;

System.out.println("NAME: "+lastName+", "+firstName);  

String m = String.format("%02d", month);
String d = String.format("%02d", date);

System.out.printf("DOB: "+m+"/"+d+"/"+year+"\n" );
System.out.println("HEIGHT: "+feet + "'-"+remainders+"\"");
        scan.close();  
}


}