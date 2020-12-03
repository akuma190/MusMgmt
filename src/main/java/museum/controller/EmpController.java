package museum.controller;

import museum.model.Session;
import museum.model.artwork;
import museum.model.employee;
import museum.model.report;
import museum.repository.*;
import museum.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.List;

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

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/empIndex")
    public String empIndex(ModelMap model, @SessionAttribute("session") Session session){
        model.put("session",session);
        employee empl=employeeRepository.findBySalesName(session.getUsername());
        System.out.println(empl);
//        System.out.println(artworkRepository.findBySalesIdName(3));
        List<artwork> listArt=artworkRepository.findBySalesIdName(empl.getStaffid());
        System.out.println(listArt);
        model.put("listArt",listArt);
        return "emp_index";
    }

    @RequestMapping("/empPaintSold")
    public String empPaintSold(ModelMap model,@SessionAttribute("session") Session session){
        model.put("session",session);
        employee empl=employeeRepository.findBySalesName(session.getUsername());
        System.out.println(empl);
        List<report> repo=reportRepository.findAllBySalesper(empl.getStaffid());
        System.out.println(repo);
        model.put("repo",repo);
        return "emp_paint_sold";
    }

    @RequestMapping("/empPayStub")
    public String empPayStub(ModelMap model,@SessionAttribute("session") Session session){
        model.put("session",session);
        model.put("session",session);
        employee empl=employeeRepository.findBySalesName(session.getUsername());
        System.out.println(empl);
        List<report> repo=reportRepository.findAllBySalesper(empl.getStaffid());
        System.out.println(repo);
        HashMap<report,Double> hash=new HashMap<report,Double>();
        Double total=0.0;
        for(report rpt:repo){
            hash.put(rpt,(rpt.getSoldamount()*.05));
            total=total+(rpt.getSoldamount()*.05);
        }
        model.put("hash",hash);
        model.put("total",total);
        return "emp_pay_stub";
    }
}
