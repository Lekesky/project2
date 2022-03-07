// Leke Obayemi
// 3/3/22
//Project 1
package com.company;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static int action;  // Initialize action variable
    static ArrayList<Task> list = new ArrayList<>();     // Create the ArrayList

    public static void prompt(){        //Prompt
        System.out.println("""
                        Please choose an option:

                        (1) Add a task.
                        (2) Remove a task.
                        (3) Update a task.
                        (4) List all tasks.
                        (5) List all tasks of a certain priority
                        (0) Exit.
                        """);
        System.out.println("Select an Action ");
    }

    public static void addTask(){       //Adds task
        System.out.println("What task would you like to add?"); //Name of task
        input.nextLine();
        String itemAdd = input.nextLine();
        System.out.println("Enter task description");
        String itemDesc = input.nextLine();
        System.out.println("Enter task priority: (5 - Most Important   0 - Least Important)");
        int itemPrior = input.nextInt();
        Task a = new Task(itemAdd, itemDesc, itemPrior);
        list.add(a);
        System.out.println("List has been updated!");
    }

    public static void removeTask(){        //Removes task
        System.out.println("List: " + list);
        System.out.println("What task would you like to remove?");
        int itemRemove = input.nextInt();
        list.remove(itemRemove);
        System.out.println("List has been updated!");
    }

    public static void updateTask(){        //Updates task
        System.out.println("List: " + list);
        System.out.println("Select an element to update");
        int itemUpdateNum = input.nextInt();
        System.out.println("What task would you like to replace it with?");
        input.nextLine();
        String itemUpdate = input.nextLine();
        System.out.println("Enter new description for task");
        String itemNewDesc = input.nextLine();
        System.out.println("Enter new priority: (5 - Most Important   0 - Least Important)");
        int itemNewPrior = input.nextInt();
        Task a = new Task(itemUpdate,itemNewDesc, itemNewPrior);
        list.set(itemUpdateNum, a);
        System.out.println("List has been updated!");
    }

    public static void listTask(){      //Prints all tasks in the ArrayList
        System.out.println("List: " + list);
    }

    public static void listTaskPriority(){
        System.out.println("Enter a priority: (5 - Most Important   0 - Least Important)");
        input.nextLine();
        int priority = input.nextInt();

        for (Task a: list){     //Prints all task of a specified priority
            if (a.priority == priority){
                System.out.println(a);
            }
        }
    }
        

    public static void main(String[] args) {

        prompt();       //Initially prompt user with options before entering the while loop
        try {
            int action = input.nextInt();
            input.nextLine();
        }catch (Exception e){
//            System.out.println("Action must be an integer");
//            prompt();
//            input.nextLine();
//            int action2 = input.nextInt();
//            action = action2;
            input.nextLine();
            Main.main(null);
        }


        while(action != 0 ) {
            if (action == 1) {
                addTask();

            } else if (action == 2) {
                removeTask();

            } else if (action == 3) {
                updateTask();

            } else if (action == 4) {
                listTask();

            } else if (action == 5) {
                listTaskPriority();

            } else if (action == 0) {
                System.out.println("Good-bye!");
                break;
            } else {
                System.out.println("Invalid action, Please try again..");
            }
            try {
                prompt();       //Prompts user again after completing option
                int action2 = input.nextInt();
                if (action2 == (int)action2) {
                    action = action2;
                }
//                action = action2;       //Updates the action with new action
            } catch (InputMismatchException e) {
                System.out.println("Action must be an integer");
                input.nextLine();
                prompt();
                int action2 = input.nextInt();
                action = action2;
            }

        }
        System.out.println("Good-bye!");        //Prints if user initially enters 0
    }
}
