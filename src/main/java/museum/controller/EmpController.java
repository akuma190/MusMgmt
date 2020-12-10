package museum.controller;

import museum.model.*;
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

    @Autowired
    EventRepository eventRepository;

    @Autowired
    CustomerRepository customerRepository;

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
        HashMap<Integer,String> hashArt=new HashMap<Integer,String>();
        for(artwork ar:artworkRepository.findAll()){
            //System.out.println(ar);
            hashArt.put(ar.getArtworkid(),ar.getArtworkname());
        }
        HashMap<Integer,String> hashArtist=new HashMap<Integer,String>();
        for(artist ar:artistRepo.findAll()){
            //System.out.println(ar);
            hashArtist.put(ar.getArtist_id(),ar.getArtist_name());
        }
        HashMap<Integer,String> hashCol=new HashMap<Integer,String>();
        for(collector ar:collectorRepository.findAll()){
            //System.out.println(ar);
            hashArtist.put(ar.getCollector_id(),ar.getCollector_name());
        }
        HashMap<Integer,Integer> hashArtPrice=new HashMap<Integer,Integer>();
        for(artwork ar:artworkRepository.findAll()){
            //System.out.println(ar);
            hashArtPrice.put(ar.getArtworkid(),ar.getPrice());
        }
        HashMap<Integer,String> hashEvent=new HashMap<Integer,String>();
        for(event ar:eventRepository.findAll()){
            //System.out.println(ar);
            hashEvent.put(ar.getEventid(),ar.getEventname());
        }


        model.put("hashArt",hashArt);
        model.put("hashArtist",hashArtist);
        model.put("hashCol",hashCol);
        model.put("hashArtPrice",hashArtPrice);
        model.put("hashEvent",hashEvent);

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
        //System.out.println(artworkRepository.findAll());
        HashMap<Integer,String> hashArt=new HashMap<Integer,String>();
        for(artwork ar:artworkRepository.findAll()){
            //System.out.println(ar);
            hashArt.put(ar.getArtworkid(),ar.getArtworkname());
        }
        HashMap<Integer,String> hashArtist=new HashMap<Integer,String>();
        for(artist ar:artistRepo.findAll()){
            //System.out.println(ar);
            hashArtist.put(ar.getArtist_id(),ar.getArtist_name());
        }
        HashMap<Integer,String> hashCol=new HashMap<Integer,String>();
        for(collector ar:collectorRepository.findAll()){
            //System.out.println(ar);
            hashArtist.put(ar.getCollector_id(),ar.getCollector_name());
        }
        HashMap<Integer,Integer> hashArtPrice=new HashMap<Integer,Integer>();
        for(artwork ar:artworkRepository.findAll()){
            //System.out.println(ar);
            hashArtPrice.put(ar.getArtworkid(),ar.getPrice());
        }
        model.put("hashArt",hashArt);
        model.put("hashArtist",hashArtist);
        model.put("hashCol",hashCol);
        model.put("hashArtPrice",hashArtPrice);
        model.put("hash",hash);
        model.put("total",total);
        return "emp_pay_stub";
    }

    @RequestMapping("/empManageAccount")
    public String empManageAccount(ModelMap model, @SessionAttribute("session") Session session){
        model.put("session",session);
        users user=usersRepo.findOne(session.getUsername());
        model.put("user",user);
        return "emp_manage_account";
    }

    @RequestMapping("/empChangeAccount")
    public String artistChangeAccount(ModelMap model,@SessionAttribute("session") Session session,users user){
        model.put("session",session);
        System.out.println(user);
        usersRepo.save(user);
        return "redirect:empManageAccount";
    }
}
