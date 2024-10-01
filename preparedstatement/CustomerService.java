package com.preparedstatement;

import java.util.Scanner;

public class CustomerService 
{
    CustomerDao cd = new CustomerDao();

    // Insert
    public void insertData() 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Customer ID: ");
        int id = sc.nextInt();

        System.out.println("Enter Customer Name: ");
        String name = sc.next();

        System.out.println("Enter Customer Age: ");
        int age = sc.nextInt();

        System.out.println("Enter Customer State: ");
        String state = sc.next();

        CustomerEntity ce = new CustomerEntity(id, name, age, state);

        cd.insertData(ce);
    }

    // Update
    public void updateData() 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Customer ID to update: ");
        int id = sc.nextInt();

        System.out.println("Enter New Customer Name: ");
        String name = sc.next();

        System.out.println("Enter New Customer Age: ");
        int age = sc.nextInt();

        System.out.println("Enter New Customer State: ");
        String state = sc.next();

        CustomerEntity ce = new CustomerEntity(id, name, age, state);
        cd.updateData(ce);
    }

    // Delete
    public void deleteData() 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Customer ID to delete: ");
        int id = sc.nextInt();

        cd.deleteData(id);
    }

    // Display
    public void displayData() 
    {
        cd.displayData();
    }
}
