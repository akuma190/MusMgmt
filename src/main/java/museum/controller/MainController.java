package museum.controller;

import museum.model.*;
import museum.repository.*;
import museum.service.EmployeeServiceImpl;
import museum.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("session")
public class MainController {

    @ModelAttribute("session")
    public Session setUpUserForm() {
        return new Session();
    }

    @Autowired
    EmployeeServiceImpl empServ;

    @Autowired
    StoreStatusRepository storeStatusRepository;

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
    CustomerRepository customerRepository;


    @RequestMapping("/")
    public String getHome(){
        //System.out.println("hello");
        System.out.println(usersRepo.applyJoin("john"));
        return "login";
    }

    @RequestMapping("/home")
    public String getNewHome(){
        System.out.println("This is for the log prininting");
        return "owner_painting_details";
    }

    @RequestMapping("/invoice")
    public String getInvoice(){
        return "invoice";
    }

//    @RequestMapping("/getData")
//    @ResponseBody
//    public String getData(){
//        ArrayList<Test> arr=new ArrayList<Test>();
//        Test data=new Test();
//        data.setAge(21);
//        data.setName("Ashish");
//        Test data1=new Test();
//        data1.setAge(22);
//        data1.setName("Mishra");
//        arr.add(data);
//        arr.add(data1);
//        return arr.toString();
//    }

//    @RequestMapping("/getFullData")
//    @ResponseBody
//    public List<Employee> getFullData(){
//        return empServ.getAllEmployee();
//    }

//    @RequestMapping("/getTableData")
//    @ResponseBody
//    public List<Ashish> getTableData(){
//        return (List<Ashish>) ashRepo.findAll();
//    }
//
//    @RequestMapping("/testInsert")
//    public String testInsert(){
//        artist art=new artist();
//        art.setArtist_id(1);
//        art.setArtist_name("ashish");
//
//        art.setCreation_date("dd");
//        artistRepo.save(art);
//        return "invoice";
//    }

    //validating the login details.
    @RequestMapping("/checkLogin")
    public String checkLogin(users user, RedirectAttributes ra, @ModelAttribute Session session, ModelMap model){
        users val=usersRepo.findOne(user.getUsername());
        if(val.getPassword().equals(user.getPassword())){
            authorities value=authoritiesRepository.findOne(user.getUsername());
            if(value.getAuthority().equals("owner")){
                session.setUsername(user.getUsername());
                session.setType(value.getAuthority());
                model.put("session",session);
                return "redirect:ownerIndex";
            }
            if(value.getAuthority().equals("artist")){
                session.setUsername(user.getUsername());
                session.setType(value.getAuthority());
                model.put("session",session);
                return "redirect:artistIndex";
            }
            if(value.getAuthority().equals("collector")){
                session.setUsername(user.getUsername());
                session.setType(value.getAuthority());
                model.put("session",session);
                return "redirect:artistIndex";
            }
            if(value.getAuthority().equals("salesperson")){
                session.setUsername(user.getUsername());
                session.setType(value.getAuthority());
                model.put("session",session);
                return "redirect:empIndex";
            }
            if(value.getAuthority().equals("customer")){
                session.setUsername(user.getUsername());
                session.setType(value.getAuthority());
                model.put("session",session);
                return "redirect:customerIndex";
            }

        }else{
            return "login";
        }
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/newRegister")
    public String register(@RequestParam String username,@RequestParam String password,@RequestParam String firstname,@RequestParam String lastname,@RequestParam String type){
        System.out.println(lastname);
        users user=new users();
        authorities auth=new authorities();
        user.setEnabled(true);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setPassword(password);
        user.setUsername(username);
        auth.setAuthority(type);
        auth.setUsername(username);
        usersRepo.save(user);
        authoritiesRepository.save(auth);
        if(type.equals("collector")){
            collector col=new collector();
            col.setCollector_name(username);
            col.setCreation_date(LocalDate.now().toString());
            collectorRepository.save(col);

        }else if(type.equals("artist")){
            artist art=new artist();
            art.setArtist_name(username);
            art.setCreation_date(LocalDate.now().toString());
            artistRepo.save(art);

        }else if(type.equals("customer")){
            customer cust=new customer();
            cust.setCustomername(username);
            cust.setCreationdate(LocalDate.now().toString());
            customerRepository.save(cust);
        }

        return "redirect:/";
    }

    @RequestMapping("/testSession")
    @ResponseBody
    public String testSession(@SessionAttribute("session") Session session){
        System.out.println(storeStatusRepository.findAll());
        return session.getUsername();
    }


}
