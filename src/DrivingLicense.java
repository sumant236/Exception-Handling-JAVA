import java.util.Scanner;

class UnderAgeException extends Exception{
    public UnderAgeException(String msg){
        super(msg);
    }
}

class OverAgeException extends Exception{
    public OverAgeException(String msg){
        super(msg);
    }
}

class Applicant{
    int age;
    String name;
    Scanner scan = new Scanner(System.in);

    public void inputUserDetails(){
        System.out.println("Please enter you name: ");
        name = scan.nextLine();
    }
    public void inputAge(){
        System.out.println("Please enter your age: ");
        age=scan.nextInt();
    }

    public void verify()throws UnderAgeException, OverAgeException {
        if (age>60) {
            OverAgeException oae = new OverAgeException("Sorry " + name + ", you're too old");
            System.out.println(oae.getMessage());
            throw oae;
        } else if (age<18) {
            UnderAgeException uae = new UnderAgeException("Sorry " + name + ", you're too young");
            System.out.println(uae.getMessage());
            throw uae;
        } else{
            System.out.println("Congratulations " + name + ", you've successfully applied for driving license. We will inform you the further steps after processing.");
        }
    }
}

class RTO {
    public void initiate() {
        Applicant user = new Applicant();
        try {
            user.inputUserDetails();
            user.inputAge();
            user.verify();
        } catch (UnderAgeException | OverAgeException e) {
            try {
                user.inputAge();
                user.verify();
            } catch (UnderAgeException | OverAgeException exc) {
                try {
                    user.inputAge();
                    user.verify();
                } catch (UnderAgeException | OverAgeException excep) {
                    System.out.println("Your account has been reported and blocked!!");
                }
            }
        }
    }
}

public class DrivingLicense {
    public static void main(String[] args) {
        RTO rto = new RTO();
        rto.initiate();
    }
}
