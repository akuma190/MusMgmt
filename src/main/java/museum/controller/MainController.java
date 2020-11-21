package museum.controller;

import museum.model.*;
import museum.repository.*;
import museum.service.EmployeeServiceImpl;
import museum.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
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

    @RequestMapping("/testInsert")
    public String testInsert(){
        artist art=new artist();
        art.setArtist_id(1);
        art.setArtist_name("ashish");

        art.setCreation_date("dd");
        artistRepo.save(art);
        return "invoice";
    }

    //validating the login details.
    @RequestMapping("/checkLogin")
    public String checkLogin(users user, RedirectAttributes ra,@ModelAttribute Session session){
        users val=usersRepo.findOne(user.getUsername());
        if(val.getPassword().equals(user.getPassword())){
            authorities value=authoritiesRepository.findOne(user.getUsername());
            if(value.getAuthority().equals("owner")){
                session.setUsername(user.getUsername());
                session.setType(value.getAuthority());
                return "owner_index";
            }
            if(value.getAuthority().equals("artist")){
                session.setUsername(user.getUsername());
                session.setType(value.getAuthority());
                return "artist_index";
            }
            if(value.getAuthority().equals("collector")){
                session.setUsername(user.getUsername());
                session.setType(value.getAuthority());
                return "artist_index";
            }
            if(value.getAuthority().equals("salesperson")){
                return "owner_index";
            }
            if(value.getAuthority().equals("customer")){
                return "owner_index";
            }

        }else{
            return "login";
        }
        return "login";
    }

    @RequestMapping("/testSession")
    @ResponseBody
    public String testSession(@SessionAttribute("session") Session session){
        System.out.println(storeStatusRepository.findAll());
        return session.getUsername();
    }


}
