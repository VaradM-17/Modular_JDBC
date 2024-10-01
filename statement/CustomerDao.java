package com.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerDao 
{
	
	// Insert
    public void insertData(CustomerEntity ce) 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipcart", "root", "root");
            Statement s = c.createStatement();

            String query = "insert into customer (cid, cname, cage, cstate) values (" +
                    ce.getId() + ", '" + ce.getName() + "', " + ce.getAge() + ", '" + ce.getState() + "')";

            int i = s.executeUpdate(query);
            
            if(i>0)
            	System.out.println("Data Inserted");
            else 
            	System.out.println("Data Not Insert");

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    // Update
    public void updateData(CustomerEntity ce) 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipcart", "root", "root");
            
            Statement s = c.createStatement();
            
            String query = "update customer set cname = '" + ce.getName() + "', cage = " + ce.getAge() +
                    ", cstate = '" + ce.getState() + "' where cid = " + ce.getId();
            
           int i =  s.executeUpdate(query);
           
           if(i>0)
        	   System.out.println("Data Updated");
           else
        	   System.out.println("Data Not Updated");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteData(int cid) 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipcart", "root", "root");

            Statement s = c.createStatement();

            String query = "delete from customer where cid = " + cid;

           int i = s.executeUpdate(query);
           
           if(i>0)
        	   System.out.println("Data Deketed");
           else
        	   System.out.println("Data Not Deleted");
  
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    // Display
    public void displayData() 
    {
        try 
        {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipcart", "root", "root");

            Statement s = c.createStatement();

            ResultSet rs = s.executeQuery("select * from customer");

            System.out.println("\n*************************************************");
            System.out.println("                📋 Customer Records 📋            ");
            System.out.println("*************************************************");

             while (rs.next()) 
             {
                int id = rs.getInt("cid");
                String name = rs.getString("cname");
                int age = rs.getInt("cage");
                String state = rs.getString("cstate");

                System.out.printf(" Customer ID: %d\n Customer Name: %s\n Customer Age: %d\n Customer State: %s\n", id, name, age, state);
                System.out.println("-------------------------------------------------");
                
             }

            System.out.println("*************************************************\n\n\n");
  
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
