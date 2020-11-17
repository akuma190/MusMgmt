package museum.service;

import museum.model.Employee;
import org.springframework.stereotype.Service;


import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployee();
}
