package museum.controller;

import museum.model.Session;
import museum.repository.*;
import museum.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

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
    public String empIndex(ModelMap model, @SessionAttribute("session") Session session){
        model.put("session",session);
        return "emp_index";
    }

    @RequestMapping("/empPaintSold")
    public String empPaintSold(ModelMap model,@SessionAttribute("session") Session session){
        model.put("session",session);
        return "emp_paint_sold";
    }

    @RequestMapping("/empPayStub")
    public String empPayStub(ModelMap model,@SessionAttribute("session") Session session){
        model.put("session",session);
        return "emp_pay_stub";
    }
}
