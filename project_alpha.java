/** Saltykov Daniil, 29/11/2022
 * TITLE: Course Project CS 105
 * Version 2.0
 * 
 * This is a Java program contains an infinite loop that acts as a menu. 
 * In this menu, you can select one of 6 utilities, each of which 
 * performs different mathematical operations.
 * 
 * You can read more about each utility in the description, 
 * which can be called up in the menu when by pressing 0.
 * 
 * The program also catches invalid input and provides detailed 
 * step-by-step instructions to the end user.
 * 
 * Code released as open source under the GNU public license.
 * 
 * 20220372@student.act.edu
 */

// Importing all of the required libraries for IO and etc
import java.util.Scanner;  //importing library for using scanner as input mean
import java.io.*;          //importing library for IO for format output
import java.lang.Math;     //importing library for math operations and functions          
 
public class project_alpha {
    
    //This function performs the whole description for all of the utilities
    static void Description() {
        System.out.println("DESCRIPTION");
        System.out.println("----------------------------------");
        System.out.println("1 - Prime Integer Detector");
        System.out.println("Displays all prime numbers between 0 and 100, their population\ncount, sum and average.");
        System.out.println();
        System.out.println("2 - Statistics of exact powers of 4");
        System.out.println("Calculates and displays the list of all integer numbers between\n0 and 25000 which are the exact 4th power of another integer.");
        System.out.println();
        System.out.println("3 - Text to Morse Converter");
        System.out.println("This program converts English text to Morse code and vice versa.");
        System.out.println();
        System.out.println("4 - Statistics of sorted integers");
        System.out.println("This program sorts the array in ascending order and provides\nstatistics such as min and max values, sum and average.");
        System.out.println();
        System.out.println("5 - Palindrome detector");
        System.out.println("Сhecks if the given string is a palindrome or not.");
        System.out.println();
        System.out.println("6 - Amicable Integers Detecter");
        System.out.println("Searches and identifies all the pairs of amicable integer numbers\nbetween 0 and 3000.");
        System.out.println("----------------------------------");
        System.out.println();
    }
    
    
    
    //This function performs the prime integer search between 0 and 100
    //and also calculates sum, average and amount of them
    static void PrimeIntegerDetector() {
        
        System.out.println("------------------------------------------------------");
        System.out.println("This utility displays the list of all prime numbers");
        System.out.println("between 0 and 100 and their amount, avg and sum.");
        System.out.println("------------------------------------------------------\n");
        
        //Initializing the variables
        double sum = 0, counter = 0, average = 0;
        boolean check = false; 
        
        System.out.println("Prime numbers in range between 0 and 100 are: \n");
        
        //Check all of the numbers within the range
        for (int numCheck = 2; numCheck <= 100; numCheck++){
            
            check = false;
            
            //This loop checks if the number being checked is 
            //evenly divisible by another
            for (int i = 2; i < numCheck; i++){
                if (numCheck % i == 0) //if yes, then checker = true
                    check = true;
            }
            
            //If the checker is false, then we print the number and change 
            //sum and counter variables
            if (!check){
                System.out.print(numCheck + " "); 
                sum += numCheck;
                counter++;
            }
        }
        
        //calculates the average
        average = sum/counter;
        
        //printing the results
        System.out.println();
        System.out.println("\nThere are " + (int) counter + " numbers. Their sum is " + (int) sum + ",\nand their average is " + average + ".");
        System.out.println();
    }
    
    
    
    
    
    //This function calculates and prints inetegers that are the exact power of 4 of another integer
    //Also calculates their sum, average, standart deviation and statistical variance 
    static void ExactPowersOf4() {
        
        //initializing variables
        double sum = 0, average = 0, variance = 0, deviation = 0;
        int poweredNum = 0, counter = 0;
        int[] answerList = new int[15];
        
        System.out.println("------------------------------------------------------");
        System.out.println("This utility displays the list of all integer numbers");
        System.out.println("between 0 and 25000 which are the exact 4th power\nof another integer.");
        System.out.println("------------------------------------------------------\n");
        
        System.out.println("The exact 4th powers are: \n");
        
        //listing all the exact 4th powers until it less than 25000
        while (poweredNum <= 25000){
            System.out.print(poweredNum + " "); 
            sum += poweredNum;                  //calculates the sum of integers
            answerList[counter] = poweredNum;           //saving them in array
            poweredNum = (int) Math.pow(++counter, 4);
        }
        
        //calculates the average
        average = sum/counter;
        
        //calculates the variance using formula
        for (int i = 0; i < counter; i++){
            variance += Math.pow(answerList[i] - average, 2);
        }
        
        variance /= counter;
        
        //calculates the deviation
        deviation = Math.sqrt(variance);
        
        //printing the results
        System.out.println();
        System.out.println("\nThere are " + (int) counter + " numbers. Their sum is " + (int) sum + ",\nand their average is " + average + ".\n");
        
        System.out.printf("The statistical variance for this array is: %.1f\n", variance);
        System.out.printf("The standart deviation is: %.4f\n", deviation);
        System.out.println();
    }
    
    
    
    
    
    //This function present the text to morse and vice versa converter
    static void text_morse_converter() throws IOException{ 
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("-------------------------------------------------------");
        System.out.println("This utility converts text to morse code and vice versa.");
        System.out.println("-------------------------------------------------------\n");
        
        //initializing variables
        boolean check = false;
        int choice = -1, spacePoint = 0, lastSpace = 0;
        String text = "";
        String sub = "";
        
        //initializing arrays for English alphabet and corresponding morse codes
        char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f',
                          'g', 'h', 'i', 'j', 'k', 'l',
                          'm', 'n', 'o', 'p', 'q', 'r',
                          's', 't', 'u', 'v', 'w', 'x',
                          'y', 'z', ' ', '0', '1', '2', 
                          '3', '4', '5', '6', '7', '8',
                          '9', ',', '.', '?', '!' };
                          
        String[] morseCode = { ".-",   "-...", "-.-.", "-..",  ".",
                        "..-.", "--.",  "....", "..",   ".---",
                        "-.-",  ".-..", "--",   "-.",   "---",
                        ".--.", "--.-", ".-.",  "...",  "-",
                        "..-",  "...-", ".--",  "-..-", "-.--",
                        "--..", " ", "-----", ".----", "..---", 
                        "...--", "....-", ".....", "-....", 
                        "--...", "---..", "----.", "--..--", 
                        ".-.-.-", "..--..", "-.-.--" };
        
        //starting while loop for menu untill user inputs 0
        do {
            System.out.println("What would you like to do?\n");
            System.out.println("Enter '0' to exit");
            System.out.println("Enter '1' to perform text to morse");
            System.out.println("Enter '2' to perform morse to text\n");
            
            if (sc.hasNextInt()){
                
                choice = sc.nextInt();     //read the case
                
                switch (choice) {
                    //case for exit
                    case 0: 
                        System.out.println("\nBye Bye!\n");
                        break;
                    
                    //case for text to morse convertation
                    case 1:
                        
                        text = "";          //clear the text variable for next input
                        
                        //making new scan for this input
                        Scanner textScan = new Scanner(System.in);
                        
                        //scaning input with nextLine in order to scan the whole string even if it has spaces
                        System.out.println("\nEnter your text.\n");
                        text += textScan.nextLine();
                        
                        textScan.close();     //closing scaner for nextLine needs
                        
                        System.out.println("\nYour morse code is: \n");
                        
                        //This loop compares the letter in the input with the letters in the alphabet 
                        //And outputs the corresponding morse code
                        for (int i = 0; i < text.length(); i++) {
                            for (int j = 0; j < alphabet.length; j++) {
                                if (Character.toLowerCase(text.charAt(i)) == alphabet[j]) {
                                    System.out.print(morseCode[j] + " ");
                                    break;
                                }
                            }
                        }
                        
                        System.out.println();
                        System.out.println("\nPress Enter to continue");
                        System.in.read();
                        break;
                        
                    //case for morse to text convertation
                    case 2:
                        
                        text = "";
                        sub = "";
                        spacePoint = 0;
                        lastSpace = 0;
                        
                        Scanner morseScan = new Scanner(System.in);
                        System.out.println("\nEnter your morse code.\n");
                        text += morseScan.nextLine();
                        
                        morseScan.close();
                        
                        System.out.println("\nYour text is: \n");
                        
                        //work with the input text untill the end of the line
                        while (spacePoint != -1){
                            //finds space to separate code words between each other
                            spacePoint = text.indexOf(" ", spacePoint);
                            
                            //takes a substring to compare with table 
                            //and checks if this is the last code word in the line
                            if (spacePoint != -1){
                                sub = text.substring(lastSpace, spacePoint);
                                lastSpace = ++spacePoint;
                            }
                            else{ //if it the last one then take the last substring 
                                sub = text.substring(lastSpace, text.length());
                            }
                            
                            //compare the substring with the alphabet to find the corresponding letter
                            for (int j = 0; j < morseCode.length; j++) {
                                if (sub.compareTo(morseCode[j]) == 0) {
                                    System.out.print(alphabet[j] + " ");
                                    break;
                                }
                            }
                        }
                        
                        System.out.println();
                        System.out.println("\nPress Enter to continue");
                        System.in.read();
                        
                        break;
                        
                    //case for wrong option
                    default:
                        System.out.println("\nInvalid option. You have only three options!\n");
                        break;
                }
            } else {     //in case of wrong data type input
                System.out.println("\nInvalid data input. Enter integers only!\n");
                sc.next(); //Clear the scaner buffer
            }
        }while (choice != 0);
    }
    
    
    
    //This function present sorting the input array and calculates the statistics
    static void sorterAndStatistics() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("This utility sorting the array and computes min, max, sum and average of them.");
        System.out.println("------------------------------------------------------------------------------\n");
        
        //initializing variables
        int max = -2147483648, min = 2147483647;
        double sum = 0, average = 0;
        
        int positionSave = 0;
        
        int[] array = new int[7];
        
        System.out.println("Enter 7 positive integers\n");
        System.out.println("Hint: Enter -1 to exit");
           
        //reading the 7 positive integers for input
        for (int i = 0; i < 7; i++){
            do{ //if there any exceptions, repeat the last input
                try{
                    System.out.println("\nEnter " + (i+1) + " number.\n");
                    
                    array[i] = sc.nextInt();
                    
                    //asks user to repeat the enter until it is not negative
                    while (array[i] < 0) {
                        
                        //checks if user prints -1 to exit program
                        if (array[i] == -1){
                            System.out.println("\nBye Bye!\n");
                            return;
                        }
                        
                        System.out.println("\nSorry. The input should be positive.\n\nEnter " + (i+1) + " number.\n");
                        array[i] = sc.nextInt();
                    }
                    
                    //calsulates the minimum value
                    if (array[i] < min)
                        min = array[i];
                        
                    //calsulates the maximum value
                    if (array[i] > max)
                        max = array[i];
                       
                    //calculates the sum of elements
                    sum += array[i];
                    
                    break;
                }
                //if the input is not integer, catch it and ask user to repeat input
                catch (Exception e){
                    System.out.println("\nWrong input! Only positive integers!"); 
                    sc.next();
                }
            }
            while (true);
        }
           
        System.out.println("\n----------------------------");
        System.out.println("Your sorted array is: \n");
        
        //this loop present the sorting of the array
        for (int i = 0; i < 7; i++){ //for every element in array do...
            
            //declares the element we are cheking as the minimum
            positionSave = i;
            
            //finds the minimum element goes after the one we are checking
            for (int j = i + 1; j < 7; j++){
                if (array[j] < array[positionSave])
                    positionSave = j;
            }
            
            //switching the current element we are checking with the minimum elements that goes afterwards
            array[i] = array[i] ^ array[positionSave] ^ (array[positionSave] = array[i]);
            
            //printing sorted elements one by one
            System.out.print(array[i]+" ");
        }
        
        System.out.println();
        
        //calculates the average value
        average = sum / 7.0;
        
        //printing the results of statistics
        System.out.println("\nThe sum of this numbers is: " + (int) sum);
        System.out.printf("The average value of them is: %.4f\n", average);
        System.out.println("The minimum value: " + min + "\nThe maximum value: " + max + "\n");
        
    }
    
    
    
    //This function present palindrome checker
    static void palindromeChecker(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("-----------------------------------------------------");
        System.out.println("This utility checks the string for palindrome.");
        System.out.println("-----------------------------------------------------\n");
        
        //initializing variables
        String inputText = "";
        
        System.out.println("Hint: Enter \"exit\" to exit\n");
        System.out.println("Enter your string to check:");
        System.out.println("P.S. It is not case sensetive)\n");
        
        //reading the string to check
        inputText += sc.nextLine();
        
        //deleting all spaces
        inputText = inputText.replace(" ","");
        
        //making all the letters to lower case to make it not case sensetive
        inputText = inputText.toLowerCase();
        
        //if user type "exit" then exit the program
        if (inputText.equals("exit")){
            System.out.println("\nBye Bye!\n");
            return;
        }
        
        //this loop checks letters from both start and end of line to be similar
        //and goes one by one towards the center of string
        for (int i = 0, j = inputText.length() - 1; i < j; i++, j--){
            
            //if any letters are not the same, print the result
            if (inputText.charAt(i) != inputText.charAt(j)){
                System.out.println("\n----------------------------------\n");
                System.out.println("Your string is not a palindrome(\n");
                return;
            }
        }
        
        //if all the letters from both sides equals respectevily, print the result
        System.out.println("\n----------------------------------\n");
        System.out.println("Your string is a palindrome)\n");
    }
    
    
    
    //This function finds the sum of all the devidors of an integer
    //It is used in next function 
    static int properDivisorsSum(int checkNum){
        //initializing variables
        int sum = 1, i = 2;
        
        //checks if an integer devids checking integer entirely
        while ( i < checkNum){
            if (checkNum % i == 0)
                sum += i;
            i++;
        }
        
        return sum;
    }
    
    
    
    ////This function searches and prints all the unic amicable pairs in the range betweem 0 and 3000
    static void amicablePairs(){
        System.out.println("-----------------------------------------------------");
        System.out.println("This utility calculates and displays amicable pairs.");
        System.out.println("-----------------------------------------------------\n");
        
        //initializing variables
        int checkSum = 0, previousCheck = 0;
        
        System.out.println("All the pairs of unique amicable integer pairs");
        System.out.println("in the range between 0 and 3000 are:\n");
        
        //checks all the integers in a range to follow next rules..
        for (int i = 2; i < 3000; i++){
            
            //calculates the sum of deviders
            checkSum = properDivisorsSum(i);
            
            //if the sum of the deviders of checkSum is the same as first integer
            //and do not repeat each other
            //then print this pair
            if ((i == properDivisorsSum(checkSum))  
                && (i != checkSum)
                && (i != previousCheck)){
                previousCheck = checkSum;
                System.out.println(i + ", " + checkSum + ";");
            }
        }
        
        System.out.println();
    }
    
    
    
    //main function implementing the menu
    public static void main(String[] args) throws IOException
    {
        // Prepare for input
        Scanner sc = new Scanner(System.in);                                          // Text variable to receive the user's input
        
        // Declare Variables
        int choice = -1;     
        
        //Greets the user
        System.out.println("Hello user! This program provides the ability to \nuse different tools in one place just by using the \nmenu! Amazing isn't it?\n");
        System.out.println("Now, you can choose which program to run.\n");
        
        //This loop keeps menu run until the exit code is entered
        do { 
            //Printing menu options
            System.out.println("Please enter your choice:\n");
            System.out.println("Enter '0' for help");
            System.out.println("Enter '1' to call Prime Integer Detection");
            System.out.println("Enter '2' to call Statistics Of Exact Powers Of 4");
            System.out.println("Enter '3' to call Text To Morse Converter");
            System.out.println("Enter '4' to call The Statistics Of Sorted Integers Method");
            System.out.println("Enter '5' to call Palindrome Detector");
            System.out.println("Enter '6' to call Amicable Integers Detecter");
            System.out.println("Enter '7' to exit this program\n");
            
            //Checks if the input is integer
            if (sc.hasNextInt()) { 
                
                choice = sc.nextInt(); //Reads input code
                
                switch (choice) {
                    
                    //Case for help comand
                    case 0:
                        //indent output to delimit outputs
                        System.out.println("\n\n\n\n\n\n\n\n");
                        
                        //Thanking the user
                        System.out.println("You have selected description option!\n");
                        
                        //Call function to print the description
                        Description(); 
                        
                        System.out.println("Press Enter to continue");
                        
                        //Whaits until the user press Enter
                        System.in.read(); 
                        
                        //indent output before displaying the menu
                        System.out.println("\n\n\n\n\n\n\n\n");
                        break;
                      
                    //Case for the Prime Integer Detector comand
                    case 1: 
                        System.out.println("\n\n\n\n\n\n\n\n");
                        System.out.println("You have selected option one!\n");
                        
                        PrimeIntegerDetector(); //Call the function for Prime Integer Detector
                        
                        System.out.println("Press Enter to continue");
                        System.in.read();
                        System.out.println("\n\n\n\n\n\n\n\n");
                        break;
                        
                    //Case for the Exact Power Of 4 comand
                    case 2:  
                        System.out.println("\n\n\n\n\n\n\n\n");
                        System.out.println("You have selected option two!\n");
                        
                        ExactPowersOf4(); //Call the function for statistics of exact powers of 4
                
                        System.out.println("Press Enter to continue");
                        System.in.read();
                        System.out.println("\n\n\n\n\n\n\n\n");
                        break;
                      
                    //Case for the morse_text converter
                    case 3:  
                        System.out.println("\n\n\n\n\n\n\n\n");
                        System.out.println("You have selected option three!\n");
                        
                        text_morse_converter(); //Call the function for text_morse converter
                
                        System.out.println("Press Enter to continue");
                        System.in.read();
                        System.out.println("\n\n\n\n\n\n\n\n");
                        break;
                        
                    //Case for the Exact Power Of 4 comand
                    case 4:  
                        System.out.println("\n\n\n\n\n\n\n\n");
                        System.out.println("You have selected option four!\n");
                        
                        sorterAndStatistics();
                        
                        System.out.println("Press Enter to continue");
                        System.in.read();
                        System.out.println("\n\n\n\n\n\n\n\n");
                        break;
                        
                    //Case for the Palindrome Checker 
                    case 5:  
                        System.out.println("\n\n\n\n\n\n\n\n");
                        System.out.println("You have selected option five!\n");
                        
                        palindromeChecker();
                        
                        System.out.println("Press Enter to continue");
                        System.in.read();
                        System.out.println("\n\n\n\n\n\n\n\n");
                        break;
                        
                    //Case for the Amicable Pairs Finder 
                    case 6:  
                        System.out.println("\n\n\n\n\n\n\n\n");
                        System.out.println("You have selected option six!\n");
                        
                        amicablePairs();
                        
                        System.out.println("Press Enter to continue");
                        System.in.read();
                        System.out.println("\n\n\n\n\n\n\n\n");
                        break;
                        
                    //Case to exit the program
                    case 7: 
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("You decided to exit(\n");
                        break;
                        
                    //The default case for any wrong integer input code
                    default:
                        System.out.println("\n\n\n\n\n\n\n\n");
                        System.out.println("Invalid option. The menu has only 8 options!\n");
                        break;
                    }
            } else { //If the input is not integer, ask user to repeat the input code
                
                System.out.println("\n\n\n\n\n\n\n\n");
                System.out.println("Invalid data input. Enter integers only!\n");
                
                sc.next(); //Clear the scaner buffer
            }
        }
        while (choice != 7); //if the code is 7, then exit the menu
        
        //Thank the user and say goodbye to him
        System.out.println("Thank you for using Project_Alpha!\n");
        System.out.println("We hope you were satisfied with our work!\n");
        System.out.println("See you soon!");
        System.out.println("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧");
    } 
}