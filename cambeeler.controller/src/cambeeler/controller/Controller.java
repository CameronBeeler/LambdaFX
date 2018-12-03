package cambeeler.controller;

import javafx.fxml.FXML;

import java.util.*;

public class Controller {

    List<Employee> employee = new ArrayList<>();

    @FXML public void iGotPushed()
    {
        System.out.println("You pushed the Button!");
        new Thread(()->
                   {
                       System.out.println("This is the lambda execute of the thread - iGotPushed");
                       System.out.println("This is line 2 of the inner lambda method");
                   }
                   ).start();
//        new Thread(new Runnable(){
//
//            @Override
//            public
//            void run()
//            {
//                System.out.println("Printing from Runnable thread - iGotPushed");
//            }
//        }).start();
        employee.add(new Employee("Cameron", 50));
        employee.add(new Employee("Kim", 48));
        employee.add(new Employee("Shiloh", 18));
        employee.add(new Employee("Wyatt", 14));
        employee.add(new Employee("Ani", 16));

//        Collections.sort(employee, new Comparator<Employee>()
//        {
//            @Override
//            public
//            int compare(Employee first, Employee second)
//            {
//                return first.getName().compareToIgnoreCase(second.getName());
//            }
//        });
/*
        Collections.sort(employee, (Employee employee1, Employee employee2)->
        {return employee1.getName().compareToIgnoreCase(employee2.getName());});
        */

//        Alternate Lambda implementation...

        Collections.sort(employee, (employee1, employee2)->
          employee1.getName().compareToIgnoreCase(employee2.getName()));

        for(Employee emp:employee)
        {
            System.out.println(emp.getName());
        }
    }
}

class Employee
{
    private String name;
    private int age;

    public
    Employee(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public
    String getName()
    {
        return name;
    }

    public
    void setName(String name)
    {
        this.name = name;
    }

    public
    int getAge()
    {
        return age;
    }

    public
    void setAge(int age)
    {
        this.age = age;
    }
}
