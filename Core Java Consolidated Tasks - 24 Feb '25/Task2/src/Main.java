/*
* Create a class named Employee with the following details:
*
empId :: int
*
empName :: String
*
sal :: double
Methods
getEmployeeDetails() setEmployeeDetails() getLoanEligibility()
check if the employee is eligible to get loan. The conditions arE:
*
an employee should have worked for greater than 5 years.
*
If his /her annual salary is 6 lakhs then 2 lakhs of loan is granted.
*
If his/her annual salary is >=10 lakhs then 5 lakhs of loan is granted.
*
If his/her annual salary is >=15 lakhs then 7 lakhs of loan is granted.
* */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Employee e = new Employee();

        System.out.println("Enter employee details" );

        System.out.println("Enter employee Id: ");
        int id = in.nextInt();

        System.out.println("Enter employee Name: ");
        String name = in.next();

        System.out.println("Enter employee salary: ");
        double salary = in.nextDouble();

        e.setEmployeeDetails(id,name,salary);

        System.out.println("The employee details is: ");
        e.getEmployeeDetails();

        System.out.println("Checking loan criteria: ");

        int exp =  in.nextInt();
        System.out.println("Enter you working experience: ");
        double loan = e.getLoanEligibility(exp);

        if (loan == 0){
            System.out.println("Ineligible for loan");
        }
        else{
            System.out.println("Loan amount sanctioned for you is Rs. "+loan);
        }

    }
}