package museum.controller;

import museum.model.event;
import museum.model.eventArtwork;
import museum.repository.*;
import museum.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustController {

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
    EventRepository eventRepository;

    @Autowired
    EventArtWorkRepository eventArtWorkRepository;

    //to generate the links of all the artist pages pages.
    @RequestMapping("/customerIndex")
    public String customerIndex(){
        return "customer_index";
    }

    @RequestMapping("/customerEventPaintings/{eventId}")
    public String customerEventPaintings(@PathVariable Integer eventId){
        System.out.println(eventId);
        List<eventArtwork> evenArt=eventArtWorkRepository.findOne(eventId);
        System.out.println(evenArt);
        return "customer_event_paintings";
    }

    @RequestMapping("/customerEvents")
    public String customerEvents(ModelMap model){
        List<event> eventList= (List<event>) eventRepository.findAll();
        model.put("eventList",eventList);
        return "customer_events";
    }

    @RequestMapping("/customerPaintingBuy")
    public String customerPaintingBuy(){
        return "customer_painting_buy";
    }

    @RequestMapping("/customerReceiptPage")
    public String customerReceiptPage(){
        return "customer_receipt_page";
    }

    @RequestMapping("/customerGalleryPaintings")
    public String customerGalleryPaintings(){
        return "customer_gallery_paintings";
    }

    @RequestMapping("/customerReceipt")
    public String customerReceipt(){
        return "customer_receipt";
    }
}
