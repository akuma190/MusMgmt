package museum.controller;

import museum.model.*;
import museum.repository.*;
import museum.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.ArrayList;

@Controller
public class ArtistController {

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
    @RequestMapping("/artistIndex")
    public String artistIndex(){
        return "artist_index";
    }

    @RequestMapping("/artistAddPaintings")
    public String artistAddPaintings(){
        return "artist_add_paintings";
    }

    @RequestMapping("/artistCheck/{cheqId}")
    public String artistCheck(@PathVariable("cheqId") int cheqId,ModelMap model){

        return "artist_check";
    }

    @RequestMapping("/artistCheckPage")
    public String artistCheckPage(@SessionAttribute("session") Session session,ModelMap model){
        ArrayList<report> repo=new ArrayList<report>();
        if(session.getType().equals("collector")){
            collector artVar=collectorRepository.findOne(session.getUsername());
            repo= (ArrayList<report>) reportRepository.findOne(artVar.getCollector_id());
        }else if(session.getType().equals("artist")){
            artist artVar=artistRepo.findOne(session.getUsername());
            repo= (ArrayList<report>) reportRepository.findOne(artVar.getArtist_id());
        }

        System.out.println(repo);
        model.put("repo",repo);
        return "artist_check_page";
    }

    @RequestMapping("/artistPayStub")
    public String artistPayStub(ModelMap model, @SessionAttribute("session") Session session) {
        ArrayList<report> repo=new ArrayList<report>();
        if(session.getType().equals("collector")){
            collector var=collectorRepository.findOne(session.getUsername());
            repo= (ArrayList<report>) reportRepository.findOne(var.getCollector_id());
        }
        if(session.getType().equals("artist")){
            artist var=artistRepo.findOne(session.getUsername());
            repo= (ArrayList<report>) reportRepository.findOne(var.getArtist_id());
        }
        System.out.println(repo);
        model.put("repo",repo);
        return "artist_pay_stub";
    }


    //Controllers for the working of the artist pages.
    @RequestMapping("/addArtistPaintings")
    public String addArtistPaintings(artwork art, @SessionAttribute("session") Session session){
        art.setArtist_type(session.getType());
        art.setStatus("waiting_for_approval");
        System.out.println(session.getUsername());
        System.out.println(session.getType());
        if(session.getType().equals("collector")){
            collector artVar=collectorRepository.findOne(session.getUsername());
            art.setArt_col_id(artVar.getCollector_id());
        }else if(session.getType().equals("artist")){
            artist artVar=artistRepo.findOne(session.getUsername());
            art.setArt_col_id(artVar.getArtist_id());
        }
        System.out.println(art);
        artworkRepository.save(art);

        return "redirect:artistAddPaintings";
    }
}
