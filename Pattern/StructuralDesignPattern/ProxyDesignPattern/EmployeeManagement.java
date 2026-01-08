package Pattern.StructuralDesignPattern.ProxyDesignPattern;

public class EmployeeManagement {
    public static void main(String[] args) {
        System.out.println("===== Proxy Design Pattern =====");

        EmployeeDao userProxyObj = new EmployeeDaoProxy("USER");
        userProxyObj.getEmployeeInfo(50);
        userProxyObj.createEmployee(new EmployeeDo());
    }
}
