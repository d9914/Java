package edu.altierd.Assign02;
import java.util.Scanner;

public class PrintShop {
   
    
 public static BusinessCard askForBusinessCardData(Scanner input){

System.out.println("Enter business name:");
String name=input.nextLine();



System.out.println("Enter boundary character:" );
char boundaryChar= input.nextLine().charAt(0);

String [] sloganLines=new String[4];
System.out.println("Enter slogan (max 4 lines):");
for(int i=0;i<4;i++){
    sloganLines[i]=input.nextLine();
    
}


BusinessCard cards= new BusinessCard(name, sloganLines, boundaryChar);



return cards;
 }   



public static void main(String [] args){
    Scanner input = new Scanner(System.in);
    BusinessCard card= askForBusinessCardData(input);
    
    System.out.println("Your new business card:");
    System.out.println(card);
    
    
}


}
