import DAO.Impl.EmployeeDAOImpl;
import model.Employee;

public class Application {
    public static void main(String[] args) {
        task1();
    }
    public static void task1() {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        employeeDAO.create(new Employee("Anton", "Lenin", "Male", 40, 4));

        System.out.println("Проверка 1");
        employeeDAO.readAll().forEach(System.out::println);
        System.out.println();

        System.out.println("Проверка 2");
        Employee employee = employeeDAO.readById(2);
        System.out.println(employee);

        employee.setFirstName("Maksim");
        employeeDAO.update(employee);

        System.out.println("Проверка 3");
        System.out.println(employeeDAO.readById(3));

        employeeDAO.delete(employee);
        employeeDAO.readAll().forEach(System.out::println);

    }
}


