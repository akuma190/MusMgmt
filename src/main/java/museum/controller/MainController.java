package museum.controller;

import museum.model.Ashish;
import museum.model.Employee;
import museum.model.Test;
import museum.repository.AshishRepository;
import museum.service.EmployeeServiceImpl;
import museum.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    EmployeeServiceImpl empServ;

    @Autowired
    AshishRepository ashRepo;

    @RequestMapping("/")
    public String getHome(){
        System.out.println("hello");
        return "index";
    }

    @RequestMapping("/home")
    public String getNewHome(){
        System.out.println("This is for the log prininting");
        return "index1";
    }

    @RequestMapping("/getData")
    @ResponseBody
    public String getData(){
        ArrayList<Test> arr=new ArrayList<Test>();
        Test data=new Test();
        data.setAge(21);
        data.setName("Ashish");
        Test data1=new Test();
        data1.setAge(22);
        data1.setName("Mishra");
        arr.add(data);
        arr.add(data1);
        return arr.toString();
    }

    @RequestMapping("/getFullData")
    @ResponseBody
    public List<Employee> getFullData(){
        return empServ.getAllEmployee();
    }

    @RequestMapping("/getTableData")
    @ResponseBody
    public List<Ashish> getTableData(){
        return (List<Ashish>) ashRepo.findAll();
    }
}
