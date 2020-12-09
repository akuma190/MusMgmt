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

import java.time.LocalDate;
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

    @Autowired
    CustomerRepository customerRepository;


    //to generate the links of all the artist pages pages.
    @RequestMapping("/artistIndex")
    public String artistIndex(@SessionAttribute("session") Session session,ModelMap model){
        model.put("session",session);
        List<report> list=new ArrayList<report>();
        if(session.getType().equals("artist")){
            artist arti=artistRepo.findOne(session.getUsername());
            System.out.println(reportRepository.findOne(arti.getArtist_id()));
            list=reportRepository.findOne(arti.getArtist_id());
        }
        if(session.getType().equals("collector")){
            collector col=collectorRepository.findOne(session.getUsername());
            System.out.println(reportRepository.findOne(col.getCollector_id()));
            list=reportRepository.findOne(col.getCollector_id());
        }

        HashMap<Integer,String> hasArtwo=new HashMap<Integer,String>();
        for(artwork ar:artworkRepository.findAll()){
            hasArtwo.put(ar.getArtworkid(),ar.getArtworkname());
        }
        model.put("list",list);
        model.put("hasArtwo",hasArtwo);
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
        users user=usersRepo.findOne(session.getUsername());
        customer cust=customerRepository.findOne(repo.getCustomerid());
        users myCustomer=usersRepo.findOne(cust.getCustomername());
        artwork artWo=artworkRepository.findOne(repo.getArtworkid());
        double finAmount=repo.getSoldamount();
        double comission=(.1 *finAmount);
        double salesComm=(comission/2);
        double OwnerComm=(comission/2);
        double total=(finAmount-comission);
        model.put("total",total);
        model.put("salesComm",salesComm);
        model.put("OwnerComm",OwnerComm);
        model.put("user",user);
        model.put("repo",repo);
        model.put("myCustomer",myCustomer);
        model.put("artWo",artWo);
        return "artist_check";
    }

    @RequestMapping("/artistCheckPage")
    public String artistCheckPage(@SessionAttribute("session") Session session,ModelMap model){
        model.put("session",session);
        artist arti=artistRepo.findOne(session.getUsername());
        List<report> repo=reportRepository.findOne(arti.getArtist_id());
        HashMap<report,artwork> hash=new HashMap<report,artwork>();
        for(report re:repo){
            System.out.println(re);
            // System.out.println(artworkRepository.findOne(re.getArtworkid()));
            hash.put(re,artworkRepository.findOne(re.getArtworkid()));
        }
        System.out.println(hash);
        model.put("hash",hash);
        return "artist_check_page";
    }

    @RequestMapping("/artistPayStub")
    public String artistPayStub(ModelMap model, @SessionAttribute("session") Session session) {
        model.put("session",session);
        ArrayList<report> repo=new ArrayList<report>();
        double total=0.0;
        //HashMap<Integer,String> hasName=new HashMap<Integer,String>();
        if(session.getType().equals("collector")){
            collector var=collectorRepository.findOne(session.getUsername());
            repo= (ArrayList<report>) reportRepository.findOne(var.getCollector_id());
        }
        if(session.getType().equals("artist")){
            artist var=artistRepo.findOne(session.getUsername());
            repo= (ArrayList<report>) reportRepository.findOne(var.getArtist_id());
        }
        System.out.println(repo);
        for(report dat:repo){
            total=total+dat.getSoldamount();
        }

        HashMap<Integer,String> hasArtwo=new HashMap<Integer,String>();
        for(artwork ar:artworkRepository.findAll()){
            hasArtwo.put(ar.getArtworkid(),ar.getArtworkname());
        }

        HashMap<Integer,Integer> hasPrice=new HashMap<Integer,Integer>();
        for(artwork ar:artworkRepository.findAll()){
            hasPrice.put(ar.getArtworkid(),ar.getPrice());
        }
        model.put("repo",repo);
        model.put("hasPrice",hasPrice);
        model.put("total",total);
        model.put("hasArtwo",hasArtwo);
        model.put("session",session);
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
            if(artworkRepository.findCountForApproval(artVar.getCollector_id())!=null && artworkRepository.findCountForApproval(artVar.getCollector_id())>10){
                art.setStatus("in_museum");
            }else{
                art.setStatus("waiting_for_approval");
            }
        }else if(session.getType().equals("artist")){
            artist artVar=artistRepo.findOne(session.getUsername());
            art.setArtcolid(artVar.getArtist_id());
            if(artworkRepository.findCountForApproval(artVar.getArtist_id())!=null && artworkRepository.findCountForApproval(artVar.getArtist_id())>=10){
                art.setStatus("in_museum");
            }else{
                art.setStatus("waiting_for_approval");
            }
        }
        System.out.println(art);

        artworkRepository.save(art);
        int max=0;
        for(artwork artVar:artworkRepository.findAll()){
            if(artVar.getArtworkid()>max){
                max=artVar.getArtworkid();
            }
        }
        System.out.println(max);
        charect.setArtworkid(max);
        System.out.println(charect);
        characteristicsRepository.save(charect);
        return "redirect:artistAddPaintings";
    }

    @RequestMapping("/artistFinalApprove/{artId}")
    public String artistFinalApprove(@PathVariable Integer artId, @SessionAttribute("session") Session session,ModelMap model){
        System.out.println(artId);
        System.out.println("hello"+eventArtWorkRepository.findByArt(artId));
        quotation quote=quotationRepository.findOne(artId);
        artwork artWo=artworkRepository.findOne(artId);
        report myReport=new report();
        if(eventArtWorkRepository.findByArt(artId)!=null){
            eventArtwork eventArt=eventArtWorkRepository.findByArt(artId);
            eventArt.setStatus("sold");
            quote.setStatus("sold");
            artWo.setStatus("sold");
            eventArtWorkRepository.save(eventArt);
            quotationRepository.save(quote);
            artworkRepository.save(artWo);
            System.out.println(eventArt);
            System.out.println(quote);
            System.out.println(artWo);
        }else{
            quote.setStatus("sold");
            artWo.setStatus("sold");
            quotationRepository.save(quote);
            artworkRepository.save(artWo);
            System.out.println(quote);
            System.out.println(artWo);
        }

        myReport.setEventid(quote.getEventid());
        myReport.setArtworkid(quote.getArtworkid());
        myReport.setEmployeeid(quote.getEmployeeid());
        myReport.setSoldamount(quote.getQuotedprice());
        myReport.setCreationdate(quote.getCreationdate());
        myReport.setArtcolid(quote.getArtcolid());
        myReport.setSolddate(LocalDate.now().toString());
        myReport.setCustomerid(quote.getUsername());
        reportRepository.save(myReport);
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

    @RequestMapping("/artistManageAccount")
    public String artistManageAccount(ModelMap model, @SessionAttribute("session") Session session){
        model.put("session",session);
        users user=usersRepo.findOne(session.getUsername());
        model.put("user",user);
        return "artist_manage_account";
    }

    @RequestMapping("/artistChangeAccount")
    public String artistChangeAccount(ModelMap model,@SessionAttribute("session") Session session,users user){
        model.put("session",session);
        System.out.println(user);
        usersRepo.save(user);
        return "redirect:artistManageAccount";
    }
}
