package Pattern.StructuralDesignPattern.ProxyDesignPattern;

public class EmployeeDaoImp1 implements EmployeeDao {

    @Override
    public void createEmployee(EmployeeDo obj) {
        System.out.println("Creating employee: " + obj);    
    }

    @Override
    public void getEmployeeInfo(int empId) {
        System.out.println("Fetching employee info for ID: " + empId);
    }
    
}
