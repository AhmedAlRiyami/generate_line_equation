/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hw1_125695;

/**
 *
 * @author Ahmed Al Riyami , ID#: 125695
 * COMP2202 , Sec#: 30
 * Assignment #1
 * 
 */


import java.util.Scanner;
import java.awt.geom.Point2D;
import java.util.Random;



public class HW1_125695 {

    /**
     * This program compute lines equation of two constructed points with random coordinates for a set of lines.
     * 
    Input:
     *  number of lines  (integer)

    Output:
     *   two constructed random points       (Double random coordinates)
     *   the distance between the 2 points   (Double)
     *   the lines equation

    Algorithm:
        1) display prompt for the number of lines
        2) while loop for the Input validation and get the number of lines from the user
            3) check the input if it has integer or not
                4) if the input has integer check if it is greater than zero or not
                    5) input has integer and greater than zero, so input is valid and end while loop
                6) else: integer less than 0,then display Error and Enter integer value > 0 Again
            7)else: input not integer,so display Error It is not integer value and break loop and exit program
        8)Construct new random object 
        9)Construct new Point object as p1 and other one as p2 with random coordinates 
        10)for loop to display and compute the distance and lines equation for each line in number of lines
        - compute the distance by distance method
        - compute delta Y and delta X for slope
        - if deltaX == 0 then the line is vertical so the slop undefined
        - if deltaY == 0 then the line is horizontal so the slop = 0
        - compute slope by formula slope = delta Y / delta X
        - and update the location of two points.
        * 
    test case: Construct fixed points >>>>>>>>>>>> expected result
        * p1(3.50 , 77.37),p2(3.50 , 90.26) >>>>>> Distance:12.89  ... LineEqua x= 3.50
        * p1(10 , 10),p2(20 , 20)           >>>>>> Distance:14.14  ... LineEqua y= 1.00x + 0.00
        * p1(87.99, 60.72),p2(2.13 , 77.14) >>>>>> Distance:87.41  ... LineEqua y=-0.19x + 77.54
        * p1(67.82, 20.50),p2(53.78, 20.50) >>>>>> Distance:14.04  ... LineEqua y= 20.50
        * 
    test case: Reading input and Input validation >>>>>>>> expected
        * how many line equations: -5        >>>>>> Error Try Again.. and Please enter how many line ..
        * how many line equations: s         >>>>>> Error: It is not integer value...Exit the program
        * how many line equations: 3         >>>>>> compute lines equation for 3 lines
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //prompt message for user to get input
        System.out.print("Please enter how many line equations you would like to generate: ");
        Scanner in = new Scanner(System.in); //Construct Scanner to read from keyboard
        
        //initialize Variable for number of lines
        int lineNum=0;
        
        
        boolean lineNumValid = false; //flag for while loop as long as the the flag down
        while (!lineNumValid) // while loop to read input and check input validation 
        {            
            if (in.hasNextInt()) //let the user enter input and be true if it has integer
            {
                lineNum = in.nextInt(); //set the integer value to lineNum
                if (lineNum > 0)
                {
                    lineNumValid = true; //lineNum is integer and greater than zero, so flag up to end while loop
                                        
                }
                else //lineNum is integer but less than zero, so show error and prompt message again and  NO update for the flag
                {
                    //lineNumValid = false;
                    System.out.println("Error: Enter integer value > 0...Try Again ");
                    System.out.print("Please enter how many line equations you would like to generate: ");
                }
            }
            
            else //the input not integer, it is invalid so NO update for the flag and break the loop to exit the program
            {
                System.out.println("Error: It is not integer value...Exit");
                break;
            }
            
        }
        
        //check if input has integer and greater than zero, so the program can do calculations otherwise not.
        if ((lineNum > 0) && (lineNumValid == true))
        {
            Random rnd = new Random(); //Construct new random object 
            //Construct new Point object with random coordinates
            Point2D p1 = new Point2D.Double( rnd.nextDouble()* 100, rnd.nextDouble()* 100);
            Point2D p2 = new Point2D.Double( rnd.nextDouble()* 100, rnd.nextDouble()* 100);
            
            //display the header 
            System.out.printf("%-10s %-20s %-20s %-10s %-20s", 
                    "Line No", "P1(x1,y1)" , "P2(x2,y2)", "Distance", "Line Equation"); 
            System.out.println();
            System.out.println("*".repeat(90));
            
            //initialize Variable to use in and out of the for loop
            double dist; //distance between the 2 points
            double deltaY; //change in y coordinates of 2 points
            double deltaX; //change in x coordinates of 2 points
            double slope ; //slope of Line Equation (m)
            double y_intercept; //the value of y when x = 0 (b)
            double x_intercept; //the value of x when y = 0, needed when the line is vertical
            String LineEqu; //Line Equation
            for (int i = 1; i <= lineNum ; i++)
            {
                dist = p1.distance(p2);
                
                //to compute the slope = deltaY / deltaX
                deltaY = p2.getY() - p1.getY();
                deltaX = p2.getX() - p1.getX();
                
                if (deltaY == 0) //horizontal line No change in y coordinates of 2 points so the slope is 0
                {
                    
                    y_intercept = p1.getY(); //No change in y coordinates so p1.getY() same as p2.getY()
                    //the slope is 0 so the Line Equation will be y = b which is y_intercept
                    LineEqu = String.format("%s %.2f ","y=", y_intercept);
                }
                else if (deltaX == 0) ////vertical line No change in x coordinates of 2 points so the slope is undefined
                {
                    x_intercept = p1.getX(); //No change in x coordinates so p1.getX() same as p2.getX()
                    //the slope is undefined so the Line Equation will be x = x_intercept wich is y_intercept
                    LineEqu = String.format("%s %.2f ","x=", x_intercept);
                }
                else
                {
                    slope = deltaY /deltaX; ///slope formula (y2-y1)/(x2-x1)
                    //to compute y_intercept from slope formula,substitute p1(x1,y1) and let (x2 , y2) = (0,y_intercept)
                    y_intercept = p1.getY() - (slope * p1.getX()); 
                    
                    //Line Equation format
                    LineEqu = String.format("%s%5.2f%s %.2f ","y=", slope ,"x +" , y_intercept);
                }
                
                
                //display the results
                System.out.printf("%-10d P1(%-5.2f, %-5.2f) %3s P2(%-5.2f, %-5.2f) %3s %-10.2f  %s ",
                        i ,p1.getX() , p1.getY() ," " ,p2.getX() , p2.getY(), " " , dist , LineEqu); 
                
                System.out.println();
                
                //update the location of two points
                p1.setLocation(rnd.nextDouble()* 100, rnd.nextDouble()* 100);
                p2.setLocation(rnd.nextDouble()* 100, rnd.nextDouble()* 100);
            }

        }

        
    }
    
}
