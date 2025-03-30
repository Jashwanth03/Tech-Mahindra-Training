import java.util.Scanner;

public class Employee {

    int empId;
    String empName;
    double sal;

    Scanner in;

//    public Employee(int empId, String empName, float sal) {
//        this.empId = empId;
//        this.empName = empName;
//        this.sal = sal;
//    }

    public Object[] getEmployeeDetails(){
        System.out.println("Employee Details: ");
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee Salary: " + sal);

        return new Object[]{empId, empName, sal};
    }

    public void setEmployeeDetails(int empId, String empName, double sal){
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;

        System.out.println("Employee details has been set successfully!!!");
    }

    public double getLoanEligibility(int exp){
        double eligible = 0;
        in = new Scanner(System.in);

        if (exp <= 5){
            return 0;
        }

        if (sal < 600000) eligible = 0;

        else if (sal ==  600000) {
            eligible = 500000;
        }

        else if (sal >=  1000000 && sal < 1500000) {
            eligible = 500000;
        }

        else if (sal >=  1500000) {
            eligible = 700000;
        }

        return eligible;
    }
}
