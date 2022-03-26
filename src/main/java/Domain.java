import bl.Util;
import entity.Address;
import entity.EmplProj;
import entity.Employee;
import entity.Project;
import service.AddressService;
import service.EmplProjService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.SQLException;
import java.util.Calendar;

public class Domain {
    public static void main(String[] args) {
        //Util util = new Util();
        //util.getConnection();

        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();
        EmplProjService emplProjService = new EmplProjService();

        Address address = new Address();
        address.setId(1L);
        address.setCountry("DC");
        address.setCity("Gotham");
        address.setStreet("street one");
        address.setPostCode("12345");

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("James");
        employee.setLastName("Gord");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);

        employee.setBirthday(new java.sql.Date(calendar.getTime().getTime()));
        employee.setAddressId(address.getId());

        Project project = new Project();
        project.setId(1L);
        project.setTitle("Bla bla bla");

        EmplProj emplProj = new EmplProj();
        emplProj.setEmployeeId(employee.getId());
        emplProj.setProjectId(project.getId());

        try {
            addressService.add(address);
            employeeService.add(employee);
            projectService.add(project);
            emplProjService.add(emplProj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
