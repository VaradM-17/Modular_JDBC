package com.statement;

import java.util.Scanner;

public class CustomerController 
{
    public static void main(String[] args) 
    {
        CustomerService cs = new CustomerService(); 
        int option;

        do 
        {
        	Scanner sc = new Scanner(System.in);
			
			System.out.println("\n*************************************************");
			System.out.println("            😊 Customer Management Menu 😊       ");
			System.out.println("*************************************************");
			System.out.println("  1. ➤ Insert New Customer Data");
			System.out.println("  2. ➤ Update Existing Customer Data");
			System.out.println("  3. ➤ Delete Customer Data");
			System.out.println("  4. ➤ Display All Customer Records");
			System.out.println("  5. ➤ Exit Program");
			System.out.println("*************************************************");
			System.out.print("👉 Choose Option : ");
            
            option = sc.nextInt();

            switch(option) 
            {
                case 1:
                    cs.insertData();
                    break;
                    
                case 2:
                    cs.updateData();
                    break;
                    
                case 3:
                    cs.deleteData();
                    break;
                    
                case 4:
                    cs.displayData();
                    break;
                    
                case 5:
                    System.out.println("...... Program Exited .....");
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } 
        while (option!=5);
    }
}
