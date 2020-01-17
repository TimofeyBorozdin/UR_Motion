import java.util.Scanner;

public class UR_Motion {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("v - velocity");
        System.out.println("s - displacement");
        System.out.println("t - time");
        
        boolean stop = false;

        byte i;
        
        double s = 0;
        double v = 0;
        double t = 0;
        
        Scanner givenIn = new Scanner(System.in);
        Scanner Progressor = new Scanner(System.in);
        Scanner valuesIn = new Scanner(System.in);
        
        while(stop == false){
            System.out.println();
            System.out.println("What is given?");
            System.out.println("Please list given variables without spaces");
            String given = givenIn.nextLine();
            if(given.length() > 3){                                 //if input is long
                System.out.println("Your input is too long.");
                //progressor
                stop = Stop(Progressor);
            }
            else if((given.length() == 0)){                          //if input is short
                System.out.println("Your input is too short.");
                //progressor
                stop = Stop(Progressor);
            }
            else{                                                   //if input is of a valid length
                //not enough variables - special case
                if( ( (given.contains("s"))||(given.contains("v"))||(given.contains("t")) )&&(given.length() == 1) ){
                    System.out.println("Your input has not enough variables.");
                    //progressor
                    stop = Stop(Progressor);
                }
                //work out situations - special case
                else if( ( (given.contains("s"))&&(given.contains("t"))||(given.contains("s"))&&(given.contains("v"))||(given.contains("v"))&&(given.contains("t")) )&& (given.length() == 2)){
                    if( (given.contains("s"))&&(given.contains("t")) ){
                        i = 1;
                        workOut(i, valuesIn, s, v, t);
                        stop = Stop(Progressor);
                    }
                    else if( (given.contains("s"))&&(given.contains("v")) ){
                        i = 2;
                        workOut(i, valuesIn, s, v, t);
                        stop = Stop(Progressor);
                    }
                    else if( (given.contains("v"))&&(given.contains("t")) ){
                        i = 3;
                        workOut(i, valuesIn, s, v, t);
                        stop = Stop(Progressor);
                    }
                }
                //everything is given - special case
                else if( ( (given.contains("s"))&&(given.contains("v"))&&(given.contains("t")) )&&(given.length() == 3) ){
                    System.out.println("Your input include all of the variables");
                    //progressor
                    stop = Stop(Progressor);
                }
                //not enough variables - general case
                else{
                    System.out.println("Your input is wrong.");
                    //progressor
                    stop = Stop(Progressor);
                }
            }
        }
        System.out.println("The End. :)");
    }
    
    public static boolean Stop (Scanner Progressor) {
        String stopCheck = "stop";
        String againCheck = "again";
        
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Enter 'stop' to stop the program or 'again' to start input again.");
        String choice = Progressor.nextLine();
        if(choice.contains(stopCheck)){
            System.out.println("I am stopped.");  
            return true;
        }
        else if(choice.contains(againCheck)){
            System.out.println("Starting again.");
            return false;
        }
        else{
            System.out.println("Error. Please try again.");
            return Stop(Progressor);
        }
    }
    
    static void workOut(byte i, Scanner valuesIn, double s, double v, double t) {
        int n = 3;
        switch(i) {
            case 1:
                System.out.println();
                System.out.println("I can find velocity (v).");
                System.out.println();
                
                System.out.println("Please enter the value of displacement (s).");
                s = valuesIn.nextDouble();
                System.out.println("Please enter the value of time (t).");
                t = valuesIn.nextDouble();
                
                v = s / t;
                System.out.println("Velocity (v) is equal to " + v + ".");
                
                break;
            case 2:
                System.out.println();
                System.out.println("I can find time (t).");
                System.out.println();
                
                System.out.println("Please enter the value of displacement (s).");
                s = valuesIn.nextDouble();
                System.out.println("Please enter the value of velocity (v).");
                v = valuesIn.nextDouble();
                
                t = s / v;
                System.out.println("Time (t) is equal to " + t + ".");
                
                break;
            case 3:
                System.out.println();
                System.out.println("I can find displacement (s).");
                System.out.println();
                
                System.out.println("Please enter the value of velocity (v).");
                v = valuesIn.nextDouble();
                System.out.println("Please enter the value of time (t).");
                t = valuesIn.nextDouble();
                
                s = v * t;
                System.out.println("Displacement (s) is equal to " + s + ".");
                
                break;
        }
    }
}
