package museum.controller;

import museum.model.*;
import museum.repository.*;
import museum.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OwnerController {

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
    EventArtWorkRepository eventArtWorkRepository;

    //to generate the links of all the artist pages pages.
    @RequestMapping("/ownerIndex")
    public String ownerIndex(){
        return "owner_index";
    }

    @RequestMapping("/ownerArtworkList")
    public String ownerArtworkList(){
        return "owner_artwork_list";
    }

    @RequestMapping("/ownerPaintingsApprove")
    public String ownerPaintingsApprove(ModelMap model){
        System.out.println(artworkRepository.findAllByWait());
        List<artwork> repo=artworkRepository.findAllByWait();
        model.put("repo",repo);
        return "owner_painting_approve";
    }

    @RequestMapping("/ownerCreateEvent")
    public String ownerCreateEvent(ModelMap map){
        List<artist> repo= (List<artist>) artistRepo.findAll();
        List<event> eventRepo= (List<event>) eventRepository.findAll();
        map.put("repo",repo);
        return "owner_create_event";
    }

    @RequestMapping("/ownerCheckReport")
    public String ownerCheckReport(){
        return "owner_check_report";
    }

    @RequestMapping("/ownerManagePaintings")
    public String ownerManagePaintings(){
        return "owner_manage_paintings";
    }

    @RequestMapping("/ownerEventInter")
    public String ownerEventInter(@ModelAttribute("eve")event eve, ModelMap model){
        model.put("eve",eve);
        return "owner_event_inter";
    }

    @RequestMapping("/ownerAddPaintings")
    public String ownerAddPaintings(event eve,ModelMap model){
        List<event> eventRepo= (List<event>) eventRepository.findAll();
        int max=0;
        for(event ar:eventRepo){
            if(ar.getEventid()>max){
                max=ar.getEventid();
            }
        }
        eve.setEventid(max+1);
        System.out.println(eve);

        System.out.println(eve.getArtistid());
        List<artwork> artRepo=new ArrayList<>();
        if(eve.getArtistid()==-1){
            artRepo=artworkRepository.findAllForEvent();

        }else{
            artRepo=artworkRepository.findForEvent(eve.getArtistid());
        }
        System.out.println(eve);
        eventRepository.save(eve);
        System.out.println(artRepo);
        model.put("artRepo",artRepo);
        model.put("max",(max+1));
        return "owner_add_paintings";
    }

    @RequestMapping("/ownerPaintingDetails")
    public String ownerPaintingDetails(){
        return "owner_painting_details";
    }

    @RequestMapping("/ownerfinalApprove/{artId}")
    public String ownerfinalApprove(@PathVariable Integer artId,ModelMap model){
        System.out.println(artId);
        System.out.println(employeeRepository.findAll());
        ArrayList<employee> arr= (ArrayList<employee>) employeeRepository.findAllXcpt();
        artwork repo=artworkRepository.findOne(artId);
        model.put("repo",repo);
        model.put("arr",arr);

        return "owner_final_approve";
    }

    @RequestMapping("/deleteArtwork")
    public String deleteArtwork(@RequestParam int artId){
        System.out.println(artId);
        artwork art=artworkRepository.findOne(artId);
        artworkRepository.delete(art);
        return "redirect:ownerPaintingsApprove";
    }

    @RequestMapping("/actionAddPainting")
    public String actionAddPainting(@RequestParam String artId,@RequestParam String salesname){
        System.out.println(artId);
        System.out.println(salesname);
        artwork art=artworkRepository.findOne(Integer.parseInt(artId));
        art.setStatus("in_museum");
        art.setSalesperson(Integer.parseInt(salesname));
        artworkRepository.save(art);
        return "redirect:ownerPaintingsApprove";
    }

    @RequestMapping("/addNewEvent")
    public String actionAddPainting(@RequestParam int eventId,CheckBox chkb){
        System.out.println("hello");
        System.out.println(eventId);
        System.out.println(chkb);
        String[] arr=chkb.getCheckBoxes();
        int max=0;
        for(eventArtwork test :eventArtWorkRepository.findAll()){
            if(test.getEventartid()>max){
                max=test.getArtworkid();
            }
        }
        System.out.println(max);
        for(String ir:arr){
            max=max+1;
            eventArtwork eventArt=new eventArtwork();
            eventArt.setEventid(eventId);
            artwork art=artworkRepository.findOne(Integer.parseInt(ir));
            System.out.println(art);
            eventArt.setArtworkid(Integer.parseInt(ir));
            eventArt.setSalesperson(art.getSalesperson());
            eventArt.setEventartid(max);
            System.out.println(eventArt);
            eventArtWorkRepository.save(eventArt);
            art.setStatus("in_event");
            artworkRepository.save(art);

        }

        return "owner_create_event";
    }
}