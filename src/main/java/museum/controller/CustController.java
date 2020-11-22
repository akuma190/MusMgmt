package museum.controller;

import museum.repository.*;
import museum.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    //to generate the links of all the artist pages pages.
    @RequestMapping("/customerIndex")
    public String customerIndex(){
        return "customer_index";
    }

    @RequestMapping("/customerEventPaintings")
    public String customerEventPaintings(){
        return "customer_event_paintings";
    }

    @RequestMapping("/customerEvents")
    public String customerEvents(){
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
