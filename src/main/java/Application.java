import DAO.EmployeeDAO;
import DAO.Impl.EmployeeDAOImpl;
import model.Employee;

public class Application {
    private static final EmployeeDAO EMPLOYEE_DAO = new EmployeeDAOImpl();

    public static void main(String[] args) {
        Employee employee1 = new Employee("Amogus", "Abigus", "Male", 36, 4);
        EMPLOYEE_DAO.create(employee1);

        System.out.println(EMPLOYEE_DAO.readById(9));

        EMPLOYEE_DAO.readAll().forEach(System.out::println);

        Employee employee1Updated = new Employee(9, "Abigus", "Amogus", "Female", 20, 4);
        EMPLOYEE_DAO.update(employee1Updated);

        EMPLOYEE_DAO.delete(employee1Updated);
    }
}