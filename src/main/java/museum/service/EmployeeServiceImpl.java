package museum.service;

import museum.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    List<Employee> emplist = Arrays.asList(new Employee(1,"Rohan","Payments"),
            new Employee(1,"Rohan","Payments"),
            new Employee(1,"Rohan","Payments")
    );

    @Override
    public List<Employee> getAllEmployee() {
        return emplist;
    }
}
