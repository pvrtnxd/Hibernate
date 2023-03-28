import DAO.Impl.CityDAOImpl;
import DAO.Impl.EmployeeDAOImpl;
import model.City;
import model.Employee;

public class Application {
    public static void main(String[] args) {
        task1();
    }
    public static void task1() {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        CityDAOImpl cityDAO = new CityDAOImpl();

        City msk = new City(null, "Moscow", null);
        cityDAO.create(msk);
        employeeDAO.create(new Employee("Anton", "Lenin", "Male", 40, msk ));

        employeeDAO.readAll().forEach(employee -> System.out.printf("%s %s City: %s\n",employee.getFirstName(),
                employee.getLastName(), employee.getCity().getName()));

        cityDAO.readAll().forEach(city -> {
            System.out.println(city);
            city.getEmployees().forEach(System.out::println);
        });


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


