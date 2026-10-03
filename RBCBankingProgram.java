/******************************
Program: RBCBankingProgram.java
Programmer's Name: Emerilus 
Date: June 12th, 2026
Project: RBCBankingProgram
*******************************/




package rbcbankingprogram;

import java.util.Scanner; 
import java.text.*; 

public class RBCBankingProgram {

    
    public static void main(String[] args){
        
        //Declare Variables
        Scanner scanN = new Scanner (System.in); 
        DecimalFormat twoDigit = new DecimalFormat ("0.00"); 
        double balance; 
        int MenuChoice; 
        double rewards = (double) (850 + Math.random( ) * (1000 - 850 + 1));
        double [] values = new double [2];
        
        
        
        //Banner
        banner(); 
        System.out.println ("\t\t  Welcome to RBC Banking Services"); 
        banner(); 
        
        //Generate Balance
        balance = AccountBalance(); 
        
        
        
        
        do{
            
            //Account Balance
            System.out.println ("\nYour current account balance is $" + twoDigit.format (balance) + "."); 


            //Menu 
            System.out.println ("\nPlease choose from the following services: \n1. Withdrawal\n2. Deposit\n3. E-Transfer\n4. Loans\n5. Rewards\n6. Credit Cards\n7. Quit");
            MenuChoice = scanN.nextInt();
            
            switch (MenuChoice){
                
                case 1:{
                   balance = Withdrawal (balance); 
                   break;
                    
                }
                
                case 2:{
                    balance = Deposit (balance);
                    break; 
                }
                
                case 3:{
                    balance = ETransfer (balance); 
                    break; 
                }
                
                case 4:{
                    balance = Loan (balance); 
                    break;
                }
                
                case 5:{
                    values = Rewards (balance, rewards); 
                    rewards = values[0];  
                    balance = values[1];
                    break;
                }
                
                case 6:{
                    Credit_Cards (balance); 
                    break; 
                }
                
                case 7:{
                    System.out.println ("Thank you for using RBC Banking Services. Have a wonderful day!");  
                    break; 
                }
                
                default: {
                    System.out.println ("Not a valid option. Please try again.");
                    break;
                }
                
                
                
            }//end of switch
    

        }//end of do loop
        
        
        while (MenuChoice != 7); 
        
    
       
   
    }//end of main method
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * banner 
     * This method will print a welcome banner
     */
    public static void banner () {
        
        for (int rows = 0; rows < 3; rows++){
            
            for (int col = 0; col < 70; col++){ 
                System.out.print ("*"); 
            } 
            System.out.println (); 
            
        }
    }//end of banner method
        
        
    
    
    
    
    
    
    
    
    
    
    
    /**
     * AccountBalance 
     * This method generates the account balance at the start of the program
     * @return balance - returns the generated account balance to main
     */    
    public static double AccountBalance () {
     
        double balance;
        balance = (double) (1000 + Math.random( ) * (3000 - 1000 + 1));
        return balance;
    }//End of account balance
    
    
    
    
    /**
     * Withdrawal
     * This method allows user to withdraw money as bills from their balance
     * @param balance - current account balance
     * @return balance - updated account balance 
     */
    public static double Withdrawal (double balance){ 
        
        
        Scanner scanN = new Scanner (System.in); 
        int withdrawal; 
        int [] num = new int [6];
        int [] value = new int [6]; 
        int TotalBills; 
        
        
        //making sure withdraw is not greater than balance
        do{
             System.out.println ("How much would you like to withdraw? No cents."); 
             withdrawal = scanN.nextInt();
        }
        
        while (withdrawal > balance); 
        
       
        System.out.println ("\nYou have the option to withdraw $100, $50, $20, $10, $5, and $1 bills. If the requested amount of bills is less than or greater than the requested withdrawal amount, you will be asked to try again.");
        
        
         //Withdrawing Bills
        do{
     
           System.out.println ("\nHow many $100 bills would you like to withdraw?"); 
           num[5] = scanN.nextInt();

           System.out.println ("How many $50 bills would you like to withdraw?"); 
           num[4] = scanN.nextInt(); 

           System.out.println ("How many $20 bills would you like to withdraw?"); 
           num[3] = scanN.nextInt(); 

           System.out.println ("How many $10 bills would you like to withdraw?"); 
           num[2] = scanN.nextInt(); 

           System.out.println ("How many $5 bills would you like to withdraw?"); 
           num[1] = scanN.nextInt(); 

           System.out.println ("How many $1 bills would you like to withdraw?"); 
           num[0] = scanN.nextInt(); 
           
           
           //Requested Withdrawal Calculation
           value[5] = num[5] * 100; 
           value[4] = num[4] * 50; 
           value[3] = num[3] * 20; 
           value[2] = num[2]* 10; 
           value[1] = num[1] * 5; 
           value[0] = num[0] * 1; 
           TotalBills = value[5] + value[4] + value[3] + value[2] + value[1] + value[0];
        }
        
        while (TotalBills != withdrawal); 
        
       balance -= withdrawal; 
      
       System.out.println ("Success! You have withdrawn $" + withdrawal + " in " + num[5] + " $100 bills, " + num[4] + " $50 bills, " + num[3] + " $20 bills, " + num[2] + " $10 bills, " + num[1] + " $5 bills, " + num[0] + " $1 bills."); 
       return balance; 
        
        
        
    }//end of Withdrawal method
    
    
    
    
    
    
    
    
    
    /**
     * Deposit
     * This method allows the user to deposit money and add to their balance
     * @param balance - current balance
     * @return balance - updated balance
     */
    public static double Deposit (double balance){
        
        Scanner scanN = new Scanner (System.in); 
        int deposit; 
        
        
       do {
        System.out.println ("How much would you like to deposit? Must be between $1-1000, no cents."); 
        deposit = scanN.nextInt(); 
       }
       
       while (deposit < 1 || deposit > 1000); 
       
       balance += deposit;
       System.out.println ("You have deposited $" + deposit + "."); 
       return balance; 
  
    }//end of Deposit method
    
    
    
    
    
    
    /**
     * ETrransfer
     * This method allows the user to E-Transfer money to a recipient 
     * @param balance - current account balance
     * @return balance - updated balance 
     */
    public static double ETransfer (double balance){
        
        Scanner scanN = new Scanner (System.in); 
        Scanner scanS = new Scanner (System.in); 
        DecimalFormat twoDigit = new DecimalFormat ("0.00"); 
        double etransfer; 
        String Security_Question; 
        char confirm_question; 
        String Answer; 
        char confirm_answer; 
        String transfer_name;
        char confirm_name;
        String transfer_contact; 
        char confirm_contact; 
        
        
        do{ 
            System.out.println ("How much would you like to E-Transfer? (Cannot be the entire balance)."); 
            etransfer = scanN.nextDouble(); 
        }
        while (etransfer > balance); 
        
        
        
        
        //Security Question
        do {
            System.out.println ("\nPlease enter one security question."); 
            Security_Question = scanS.nextLine();
        
            System.out.println ("Confirm: \"" + Security_Question + "\" | Enter Y to confirm, N to re-enter the question."); 
            confirm_question = scanS.nextLine().charAt(0); 
      
        }
        while (confirm_question == 'n' || confirm_question == 'N'); 
       
        
        
        //Security Answer
        do {
            System.out.println ("\nPlease enter the answer to the security question."); 
            Answer = scanS.nextLine(); 
            
            System.out.println ("Confirm: \"" + Answer + "\"| Enter Y to confirm, N to re-enter the question."); 
            confirm_answer = scanS.nextLine().charAt(0);
        }
        
        while (confirm_answer == 'n' || confirm_answer == 'N'); 
        
        
        System.out.println ("Security question has been stored."); 
        
        
        
        //Recipient
        do { 
            System.out.println ("\nPlease enter the name of the recipient.");
            transfer_name = scanS.nextLine();    

            System.out.println ("Confirm: \"" + transfer_name + "\"| Enter Y to confirm, N to re-enter the question."); 
            confirm_name = scanS.nextLine().charAt(0);
        
        }
        
        while (confirm_name == 'n' || confirm_name == 'N');
        
        
        //Contact
        do {
           System.out.println ("\nPlease enter the email/phone number of the recipient."); 
           transfer_contact = scanS.nextLine(); 
           
           System.out.println ("Confirm: \"" + transfer_contact + "\" | Enter Y to confirm, N to re-enter the question."); 
           confirm_contact = scanS.nextLine().charAt(0);
        }
        
        while (confirm_contact == 'n' || confirm_contact == 'N');
        
        
        
        System.out.println ("\nSuccess! $" + twoDigit.format (etransfer) + " has been transferred to " + transfer_name + "!"); 
        
        balance -= etransfer; 
        return balance; 
    
    }//end of ETransfer method
    
    
    
    
    
    
    
    /**
     * Loan
     * This method allows the user to take a loan 
     * @param balance - current balance
     * @return balance - updated balance
     */
    public static double Loan (double balance){ 
        
        Scanner scanN = new Scanner (System.in); 
        Scanner scanS = new Scanner (System.in); 
        DecimalFormat twoDigit = new DecimalFormat ("0.00"); 
        String reason_loan; 
        int loan; 
        int loan_years; 
        String interest; 
        double monthly_payment; 
        double interest_value;
        double final_monthly; 
        
        System.out.println ("What is the reason for this loan?"); 
        reason_loan = scanS.nextLine(); 
        
        
        do{ 
             System.out.println ("\nHow much would you like to be loaned? Must be over $500, no cents."); 
            loan = scanN.nextInt(); 
        }
        while (loan < 500); 
        
        
        do{ 
            System.out.println ("\nOver how long would you like to pay off the loan? Must be between 1-5 years."); 
            loan_years = scanN.nextInt(); 
        }
        while (loan_years < 1 || loan_years > 5); 
        
        System.out.println ("\nWould you prefer a fixed interest rate (4%) or a variable interest rate (starting at %3) to be applied?"); 
        interest = scanS.nextLine(); 
        
        if (interest.equalsIgnoreCase ("fixed")){
            
            monthly_payment = loan/ (loan_years *12); 
            interest_value = monthly_payment * 0.4; 
            final_monthly = interest_value + monthly_payment;  
        }
        
        else{
            
            monthly_payment = loan/ (loan_years *12); 
            interest_value = monthly_payment * 0.3; 
            final_monthly = interest_value + monthly_payment;
        }
        
        balance += loan; 
        
        System.out.println ("\n$" + loan +" has been transfered to your account. Your monthly payment in 30 days will be $" + twoDigit.format (final_monthly)+ "."); 
        
        return balance;
        
        
    }//end of Loan method

        
    
/**
 * Rewards
 * This method allows the user to choose between different ways to use their rewards points
 * @param balance - current account balance
 * @param rewards - current rewards balance
 * @return values - an array for updated rewards and balance values 
 */
public static double [] Rewards (double balance, double rewards){
    
    Scanner scanN = new Scanner (System.in); 
    DecimalFormat twoDigit = new DecimalFormat ("0.00"); 
    int Rewards_MenuChoice;
    double points_used; 
    int points; 
    int price; 
    double subtotal; 
    double taxes; 
    double total;
    double [] values = new double [2];
    
    
    System.out.println ("\nYou have " + twoDigit.format (rewards) + " Avion Points"); 
    
    System.out.println ("Please choose what you would like to use your points for: \n1. 50pts for Super Mario Party ($90)\n2. 700pts for Sony XM5 Headphones ($400)\n3. 100pts for Ninja Air Fryer ($200)\n4. None"); 
    Rewards_MenuChoice = scanN.nextInt(); 
    
   
    if (Rewards_MenuChoice != 4){
        switch (Rewards_MenuChoice){
        
        case 1:{
            
            System.out.println ("Success! You have purchased Super Mario Party."); 
            points_used = 50 * 0.2;
            points = 50;
            price = 90; 
            break;
        }
        
        case 2:{
            
            System.out.println ("Success! You have purchased Sony XM5 Headphones."); 
            points_used = 700 * 0.2; 
            points = 700;
            price = 400;
            break; 
        }
        
        
        case 3:{
            
            System.out.println ("Success! You have purchased a Ninja Air Fryer."); 
            points_used = 100 * 0.2; 
            points = 100;
            price = 200;
            break; 
        }
        
        default: {
            System.out.println ("Not an option.");  
            return values;
        } 
        
    }//end of switch
    
    subtotal = price - points_used; 
    taxes = subtotal * 0.13; 
    total = subtotal + 0.13;
    
     
    //Print Invoice
    System.out.println ("\nInvoice:"); 
    System.out.println ("Total cost of product: \t\t\t$" + twoDigit.format (price));
    System.out.println ("Avion Points used: \t\t\t" + points);
    System.out.println ("Total savings from Avion Points: \t$" + twoDigit.format (points_used)); 
    System.out.println ("Subtotal: \t\t\t\t$" + twoDigit.format (subtotal)); 
    System.out.println ("Taxes: \t\t\t\t\t$" + twoDigit.format (taxes)); 
    System.out.println ("Final Price (deducted from balance): \t$" + twoDigit.format (total)); 
    
    balance -= total; 
    rewards -= points; 
    
    
    values [0] = rewards; 
    values [1] = balance;
    return values;
    
    }// end of if statement
    
    else {
        System.out.println ("You will be re-routed to the main menu."); 
        values[1] = balance; 
        values[0] = rewards;
        return values; 
    }

}//end of Rewards method 





/**
 * Credit_Card
 * This method allows the user to discover which credit card is right for them
 * @param balance - current account balance
 */
public static void Credit_Cards (double balance){
    
    Scanner scanS = new Scanner (System.in); 
    DecimalFormat twoDigit = new DecimalFormat ("0.00");
    String personality_trait; 
    
    
    System.out.println ("\nAt RBC, we have a number of credit cards for you to choose from. ");
    System.out.println ("Let us assist you in finding the perfect card that fits your needs."); 
    System.out.println ("\nDo you prioritize travelling, rewards, or cashback? ");
    personality_trait = scanS.nextLine(); 
    
    if (personality_trait.equalsIgnoreCase ("travelling")){
        System.out.println ("\nThe WestJet RBC World Elite Mastercard is perfect for you!"); 
    }
    
    else if (personality_trait.equalsIgnoreCase ("rewards")){
        System.out.println ("\nThe RBC Ion+ Visa Card is perfect for you!"); 
    }
    
    else if (personality_trait.equalsIgnoreCase ("cashback")){
        System.out.println ("\nThe RBC CashBack Mastercard is perfect for you!"); 
    }
    
    else {
        System.out.println ("That was not an option."); 
    }
    
    System.out.println ("\nConsider using some of your $" + twoDigit.format (balance) + " dollars to invest in a credit card!"); 
    System.out.println ("Please contact a RBC financial advsior if you would like to apply for a credit card. ");
    
            
}//end of Credit_Cards method
        
    







    
}//end of class
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

