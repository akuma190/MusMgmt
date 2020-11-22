package museum.controller;

import museum.repository.*;
import museum.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {

    @Autowired
    EmployeeServiceImpl empServ;

    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @Autowired
    UsersRepository usersRepo;

    @Autowired
    AshishRepository ashRepo;

    @Autowired
    ArtistRepository artistRepo;

    @Autowired
    ArtworkRepository artworkRepository;

    @Autowired
    CollectorRepository collectorRepository;

    @Autowired
    ReportRepository reportRepository;

    @RequestMapping("/empIndex")
    public String empIndex(){

        return "emp_index";
    }

    @RequestMapping("/empPaintSold")
    public String empPaintSold(){

        return "emp_paint_sold";
    }

    @RequestMapping("/empPayStub")
    public String empPayStub(){

        return "emp_pay_stub";
    }
}
