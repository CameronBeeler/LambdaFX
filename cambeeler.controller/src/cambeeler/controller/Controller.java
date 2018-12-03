package cambeeler.controller;

import javafx.fxml.FXML;

import java.util.*;

public class Controller {

    List<Employee> employee = new ArrayList<>();

    @FXML public void iGotPushed()
    {
        System.out.println("You pushed the Button!");
        new Thread(() ->
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

        Collections.sort(employee, (employee1, employee2) ->
                employee1.getName().compareToIgnoreCase(employee2.getName()));

        for (Employee emp : employee)
        {
            System.out.println(emp.getName());
        }


//        String sillyString = doStringStuff(new UpperConcat()
//       {
//           @Override
//           public
//           String upperAndConcat(String s1, String s2)
//           {
//              return s1.toUpperCase() + s2.toUpperCase();
//           }
//       }, employee.get(0).getName(), employee.get(1).getName());

        // Quick and easy single use lambda
//        String sillyString = doStringStuff((s1, s2)-> s1.toUpperCase() + s2.toUpperCase(),
//                                           employee.get(0).getName(),
//                                           employee.get(1).getName());

        // assign the lambda to a variable and you can use it multiple times...
        UpperConcat uc = (s1, s2) -> {
            String result = s1.toUpperCase() + "+" + s2.toUpperCase();
            return result;
        };
        String sillyString = doStringStuff(uc, employee.get(0).getName(), employee.get(1).getName());

        System.out.println(sillyString);
        sillyString = doStringStuff(uc, employee.get(3).getName() ,    employee.get(2).getName());

       System.out.println(sillyString);
}
    public final static String doStringStuff(UpperConcat uc, String s1, String s2)
    {
        return uc.upperAndConcat(s1, s2);
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

interface UpperConcat
{
    public String upperAndConcat(String s1, String s2);
}
