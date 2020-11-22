package museum.controller;

import museum.repository.*;
import museum.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String ownerPaintingsApprove(){
        return "owner_painting_approve";
    }

    @RequestMapping("/ownerCreateEvent")
    public String ownerCreateEvent(){
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
}
