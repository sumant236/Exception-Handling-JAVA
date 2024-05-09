import java.util.Scanner;

class InvalidUserException extends Exception{
    public InvalidUserException(String msg){
        super(msg);
    }
}
class ATM{
    private int accNumber = 1111;
    private int passID = 2222;
    int acc;
    int pwd;
    public void input(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Kindly enter the account number: ");
        acc = scan.nextInt();
        System.out.println("Kindly enter the password: ");
        pwd = scan.nextInt();
    }

    public void verify() throws InvalidUserException {
        if(acc==accNumber && passID==pwd){
            System.out.println("Collect your cash");
        }
        else{
            InvalidUserException ice = new InvalidUserException("Invalid credentials! Try Again?");
            System.out.println(ice.getMessage());
            throw ice;
        }
    }
}

class Bank{
    public void initiate(){
        ATM atm = new ATM();
        try{
            atm.input();
            atm.verify();
        }
        catch(InvalidUserException e){
            try{
                atm.input();
                atm.verify();
            }
            catch(InvalidUserException exc){
                try{
                    atm.input();
                    atm.verify();
                } catch (InvalidUserException excep){
                    System.out.println("Your card is blocked!!");
                }
            }
        }
    }
}

public class AtmCard {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.initiate();
    }
}