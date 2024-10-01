package com.preparedstatement;

public class CustomerEntity 
{
    // Fields
    private int id;
    private String name;
    private int age;
    private String state;

    // No Argument Constructor
    public CustomerEntity() 
    {
    }

    // Parameterized Constructor
    public CustomerEntity(int id, String name, int age, String state) 
    {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.state = state;
    }

    // Getters And Setters
    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getAge() 
    {
        return age;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }

    public String getState() 
    {
        return state;
    }

    public void setState(String state) 
    {
        this.state = state;
    }

    // To String Method
    @Override
    public String toString() 
    {
        return "Customer Details \nCustomer ID : " + id + "\nCustomer Name : " + name + "\nCustomer Age : " + age + "\nCustomer State=" + state;
    }
}
