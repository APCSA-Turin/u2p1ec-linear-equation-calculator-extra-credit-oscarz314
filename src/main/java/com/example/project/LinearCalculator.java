package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below
//INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    
    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coord1, String coord2){ // <--add 2 string parameters to this constructor
        // finds the divsion points of the 2 parts
        int coord1Mid = coord1.indexOf(",");  
        int coord2Mid = coord2.indexOf(","); 
        // assigns value to the variables
        x1 = Integer.parseInt(coord1.substring(1, coord1Mid));
        y1 = Integer.parseInt(coord1.substring(coord1Mid + 1, coord1.length() - 1));
        x2 = Integer.parseInt(coord2.substring(1, coord2Mid));
        y2 = Integer.parseInt(coord2.substring(coord2Mid + 1, coord2.length() - 1));
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int num){x1 = num;}
    public void setY1(int num){y1 = num;}
    public void setX2(int num){x2 = num;}
    public void setY2(int num){y2 = num;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double distance = Math.sqrt(Math.pow((double)x2 - x1, 2) + Math.pow((double)y2 - y1, 2)); // distance formula
        return roundedToHundredth(distance);
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){ // if slope is invalid y intercept doesnt not exist
        if (x1 == x2){
            return -999.99;
        }
        double yInt = y1 - slope()* x1; // find y of f(0)
        return roundedToHundredth(yInt);
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        if (x1 == x2){ // if slope is invalid return -999.99
            return -999.99;
        }
        double slope = (double) (y2 - y1)/(x2 - x1);
        return roundedToHundredth(slope);
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        if (slope() == -999.99){ // if slope is invalid
            return "undefined";
        }
        else if (slope() == 0){ // if slope is 0
            return "y=" + yInt();
        }
        else if (yInt() == 0.0){ // if y intercept is 0
            return "y=" + slope() + "x";
        }
        else if (yInt() < 0){ // if y intercept is negative
            return "y=" + slope() + "x" + yInt();
        }
        return "y=" + slope() + "x+" + yInt(); // if all is normal
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        return Math.round(x * 100.0) / 100.0;
    }

    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
    
        return findSymmetry() + Midpoint();
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        // Cases of symmetry 
        if (x1 == x2 && Math.abs(y1) == Math.abs(y2)){
            return "Symmetric about the x-axis";
        }
        if (Math.abs(x1) == Math.abs(x2) && y1 == y2){
            return "Symmetric about the y-axis";
        } 
        if (Math.abs(x1) == Math.abs(x2) && Math.abs(y1) == Math.abs(y2)){
            return "Symmetric about the origin";
        }
        return "No symmetry";
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        double xMid = (x1 + x2) / 2.0; // find x midpoint
        double yMid = (y1 + y2) / 2.0; // find y midpoint
        return  "The midpoint of this line is: " + "(" + xMid + "," + yMid + ")";
    }

}



