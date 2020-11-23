package museum.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

//    List<Employee> emplist = Arrays.asList(new Employee(1,"Rohan","Payments"),
//            new Employee(1,"Rohan","Payments"),
//            new Employee(1,"Rohan","Payments")
//    );

    @Override
    public String getAllEmployee() {
        return "hello";
    }
}
