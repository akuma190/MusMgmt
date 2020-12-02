package museum.controller;

import museum.model.*;
import museum.repository.*;
import museum.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    @Autowired
    QuotationRepository quotationRepository;

    @Autowired
    EventArtWorkRepository eventArtWorkRepository;

    @Autowired
    CharacteristicsRepository characteristicsRepository;

    //to generate the links of all the artist pages pages.
    @RequestMapping("/artistIndex")
    public String artistIndex(@SessionAttribute("session") Session session,ModelMap model){
        model.put("session",session);
        return "artist_index";
    }

    @RequestMapping("/artistAddPaintings")
    public String artistAddPaintings(ModelMap model, @SessionAttribute("session") Session session){
        model.put("session",session);
        return "artist_add_paintings";
    }

    @RequestMapping("/artistPaintApprove")
    public String artistPaintApprove(ModelMap model, @SessionAttribute("session") Session session){
        model.put("session",session);
        System.out.println(session.getUsername());
        artist artistDet=artistRepo.findOne(session.getUsername());
        System.out.println(artistDet);
        List<artwork> artList=artworkRepository.findForArtistApp(artistDet.getArtist_id());
        System.out.println(artList);
        HashMap<artwork,quotation> hash=new HashMap<artwork,quotation>();
        for(artwork artwo:artList){
            quotation quot=quotationRepository.findOne(artwo.getArtworkid());
            System.out.println(quot);
            hash.put(artwo,quot);
        }
        System.out.println(hash);
        model.put("hash",hash);
        return "artist_paint_approve";
    }

    @RequestMapping("/artistCheck/{cheqId}")
    public String artistCheck(@PathVariable("cheqId") Integer cheqId,ModelMap model, @SessionAttribute("session") Session session){
        model.put("session",session);
        System.out.println(cheqId);
        report repo=reportRepository.findByReportId(cheqId);
        System.out.println(repo);
        model.put("repo",repo);
        return "artist_check";
    }

    @RequestMapping("/artistCheckPage")
    public String artistCheckPage(@SessionAttribute("session") Session session,ModelMap model){
        model.put("session",session);
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
        model.put("session",session);
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
    public String addArtistPaintings(artwork art, @SessionAttribute("session") Session session,ModelMap model,characteristics charect){
        model.put("session",session);
        art.setArtist_type(session.getType());
        //below is th code to change the staus if the  painter has sold more than 10 painitngs.
//        art.setStatus("waiting_for_approval");
        System.out.println(session.getUsername());
        System.out.println(session.getType());
        if(session.getType().equals("collector")){
            collector artVar=collectorRepository.findOne(session.getUsername());
            art.setArtcolid(artVar.getCollector_id());
            if(artworkRepository.findCountForApproval(artVar.getCollector_id())>10){
                art.setStatus("in_museum");
            }else{
                art.setStatus("waiting_for_approval");
            }
        }else if(session.getType().equals("artist")){
            artist artVar=artistRepo.findOne(session.getUsername());
            art.setArtcolid(artVar.getArtist_id());
            if(artworkRepository.findCountForApproval(artVar.getArtist_id())>=10){
                art.setStatus("in_museum");
            }else{
                art.setStatus("waiting_for_approval");
            }
        }
        System.out.println(art);

//        artworkRepository.save(art);
        int max=0;
        for(artwork artVar:artworkRepository.findAll()){
            if(artVar.getArtworkid()>max){
                max=artVar.getArtworkid();
            }
        }
        charect.setArtworkid(max);
        System.out.println(charect);
//        characteristicsRepository.save(charect);
        return "redirect:artistAddPaintings";
    }

    @RequestMapping("/artistFinalApprove/{artId}")
    public String artistFinalApprove(@PathVariable Integer artId, @SessionAttribute("session") Session session,ModelMap model){
        System.out.println(artId);
        System.out.println("hello"+eventArtWorkRepository.findByArt(artId));
        quotation quote=quotationRepository.findOne(artId);
        artwork artWo=artworkRepository.findOne(artId);
        if(eventArtWorkRepository.findByArt(artId)!=null){
            eventArtwork eventArt=eventArtWorkRepository.findByArt(artId);
            eventArt.setStatus("sold");
            quote.setStatus("sold");
            artWo.setStatus("sold");
//            eventArtWorkRepository.save(eventArt);
//            quotationRepository.save(quote);
//            artworkRepository.save(artWo);
            System.out.println(eventArt);
            System.out.println(quote);
            System.out.println(artWo);
        }else{
            quote.setStatus("sold");
            artWo.setStatus("sold");
//            eventArtWorkRepository.save(eventArt);
//            quotationRepository.save(quote);
//            artworkRepository.save(artWo);
            System.out.println(quote);
            System.out.println(artWo);
        }
        return "redirect:../artistPaintApprove";
    }

    @RequestMapping("/deleteArtistArtwork")
    public String deleteArtistArtwork(@RequestParam int artId, ModelMap model, @SessionAttribute("session") Session session){
        model.put("session",session);
        System.out.println(artId);
        System.out.println("hello"+eventArtWorkRepository.findByArt(artId));
        quotation quote=quotationRepository.findOne(artId);
        artwork artWo=artworkRepository.findOne(artId);
        if(eventArtWorkRepository.findByArt(artId)!=null){
            eventArtwork eventArt=eventArtWorkRepository.findByArt(artId);
            eventArt.setStatus("in_event");
            quote.setStatus("in_event");
            artWo.setStatus("in_event");
            eventArtWorkRepository.save(eventArt);
            quotationRepository.save(quote);
            artworkRepository.save(artWo);
            System.out.println(eventArt);
            System.out.println(quote);
            System.out.println(artWo);
        }else{
            quote.setStatus("in_event");
            artWo.setStatus("in_event");
            quotationRepository.save(quote);
            artworkRepository.save(artWo);
            System.out.println(quote);
            System.out.println(artWo);
        }
        return "redirect:artistPaintApprove";
    }
}
