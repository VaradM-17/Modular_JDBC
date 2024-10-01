package com.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDao 
{
    // Insert
    public void insertData(CustomerEntity ce) 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipcart", "root", "root");
            String query = "insert into customer (cid, cname, cage, cstate) values (?, ?, ?, ?)";
            
            PreparedStatement ps = c.prepareStatement(query);
            
            ps.setInt(1, ce.getId());
            ps.setString(2, ce.getName());
            ps.setInt(3, ce.getAge());
            ps.setString(4, ce.getState());
            
           int i = ps.executeUpdate();
           
           if(i>0)
        	   System.out.println("Data Inserted");
           else
        	   System.out.println("Data Not Inserted");
           
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
            
            String query = "update customer set cname = ?, cage = ?, cstate = ? where cid = ?";
            
            PreparedStatement ps = c.prepareStatement(query);
            
            ps.setString(1, ce.getName());
            ps.setInt(2, ce.getAge());
            ps.setString(3, ce.getState());
            ps.setInt(4, ce.getId());
            
            int i = ps.executeUpdate();
            
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
            
            String query = "delete from customer where cid = ?";
            
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, cid);
            
            int i = ps.executeUpdate();
            if(i>0)
            	System.out.println("Data Deleted");
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
            
            String query = "select * from customer";
            PreparedStatement ps = c.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
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
