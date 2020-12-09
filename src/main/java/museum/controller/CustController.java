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
import java.util.Optional;

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

    @Autowired
    QuotationRepository quotationRepository;

    @Autowired
    CustomerRepository customerRepository;

    //to generate the links of all the artist pages pages.
    @RequestMapping("/customerIndex")
    public String customerIndex(ModelMap model, @SessionAttribute("session") Session session){
        model.put("session",session);
//        customer cust=customerRepository.findOne(session.getUsername());
//        System.out.println(cust);
        List<report> repo=reportRepository.findAllByCustomer(session.getUsername());
        HashMap<report,artwork> hash=new HashMap<report,artwork>();
        for(report re:repo){
            System.out.println(re);
           // System.out.println(artworkRepository.findOne(re.getArtworkid()));
            hash.put(re,artworkRepository.findOne(re.getArtworkid()));
        }
        model.put("hash",hash);
        return "customer_index";
    }

    @RequestMapping("/customerEventPaintings/{eventId}")
    public String customerEventPaintings(@PathVariable Integer eventId,ModelMap model, @SessionAttribute("session") Session session){
        model.put("session",session);
        System.out.println("hello"+eventId);
        List<eventArtwork> evenArt=eventArtWorkRepository.findOne(eventId);
        List<artwork> paintingList=new ArrayList<artwork>();
        for(eventArtwork eve:evenArt){
            artwork art=artworkRepository.findOne(eve.getArtworkid());
            System.out.println("int the"+art);
            paintingList.add(art);
        }
        System.out.println(evenArt);
        model.put("paintingList",paintingList);
        return "customer_event_paintings";
    }

    @RequestMapping("/customerEvents")
    public String customerEvents(ModelMap model, @SessionAttribute("session") Session session){
        model.put("session",session);
        List<event> eventList= (List<event>) eventRepository.findAll();
        model.put("eventList",eventList);
        return "customer_events";
    }

    @RequestMapping("/customerPaintingBuy/{artWorkId}")
    public String customerPaintingBuy(@PathVariable Integer artWorkId,ModelMap model, @SessionAttribute("session") Session session){
        model.put("session",session);
        artwork art=artworkRepository.findOne(artWorkId);
        model.put("art",art);
        return "customer_painting_buy";
    }

    @RequestMapping("/customerReceiptPage")
    public String customerReceiptPage(ModelMap model, @SessionAttribute("session") Session session){
        model.put("session",session);
//        customer cust=customerRepository.findOne(session.getUsername());
//        System.out.println(cust);
        List<report> repo=reportRepository.findAllByCustomer(session.getUsername());
        HashMap<report,artwork> hash=new HashMap<report,artwork>();
        for(report re:repo){
            System.out.println(re);
            // System.out.println(artworkRepository.findOne(re.getArtworkid()));
            hash.put(re,artworkRepository.findOne(re.getArtworkid()));
        }
        model.put("hash",hash);
        return "customer_receipt_page";
    }

    @RequestMapping("/customerGalleryPaintings")
    public String customerGalleryPaintings(ModelMap model, @SessionAttribute("session") Session session){
        List<artwork> artList=artworkRepository.findAllForEvent();
        model.put("session",session);
        model.put("artList",artList);
        return "customer_gallery_paintings";
    }

    @RequestMapping("/customerReceipt/{reportId}")
    public String customerReceipt(@PathVariable Integer reportId,ModelMap model, @SessionAttribute("session") Session session){
        model.put("session",session);
        System.out.println(reportId);
        report repo=reportRepository.findByReportId(reportId);
        users user=usersRepo.findOne(session.getUsername());
        artwork artWo=artworkRepository.findOne(repo.getArtworkid());
        artist arti=artistRepo.findOneById(repo.getArtcolid());
        users artUser=usersRepo.findOne(arti.getArtist_name());
        double finAmount=repo.getSoldamount();
        double comission=(.1 *finAmount);
        double salesComm=(comission/2);
        double OwnerComm=(comission/2);
        double total=(finAmount-comission);
        model.put("total",total);
        model.put("artUser",artUser);
        model.put("salesComm",salesComm);
        model.put("OwnerComm",OwnerComm);
        model.put("user",user);
        model.put("artWo",artWo);
        model.put("repo",repo);
        return "customer_receipt";
    }

    @RequestMapping("/buyFinalPainitngs")
    public String buyFinalPainitngs(@RequestParam Integer price,@RequestParam Integer artId,ModelMap model, @SessionAttribute("session") Session session){
        model.put("session",session);
        System.out.println(price+" "+artId);
        artwork art=artworkRepository.findOne(artId);
        eventArtwork eveArt=eventArtWorkRepository.findByArt(artId);
        System.out.println(art);
        System.out.println(eveArt);
        quotation quote=new quotation();

        if(eventArtWorkRepository.findByArt(artId)!=null){
            quote.setEventid(eveArt.getEventid());
            quote.setUsername(session.getUsername());
            quote.setArtworkid(eveArt.getArtworkid());
            quote.setQuotedprice(price);

            quote.setCreationdate(LocalDate.now().toString());
            quote.setEmployeeid(eveArt.getSalesperson());
            quote.setArtcolid(art.getArtcolid());

            if(price>art.getPrice()){
                quote.setStatus("sold");
                art.setStatus("sold");
                eveArt.setStatus("sold");
            }else{
                quote.setStatus("in_discussion");
                art.setStatus("in_discussion");
                eveArt.setStatus("in_discussion");
            }

            System.out.println(quote);
            System.out.println(art);
            System.out.println(eveArt);
            quotationRepository.save(quote);
            artworkRepository.save(art);
            eventArtWorkRepository.save(eveArt);

        }else{
            quote.setEventid(-1);
            quote.setUsername(session.getUsername());
            quote.setArtworkid(art.getArtworkid());
            quote.setQuotedprice(price);

            quote.setCreationdate(LocalDate.now().toString());
            quote.setEmployeeid(art.getSalesperson());
            quote.setArtcolid(art.getArtcolid());

            if(price>art.getPrice()){
                quote.setStatus("sold");
                art.setStatus("sold");
            }else{
                quote.setStatus("in_discussion");
                art.setStatus("in_discussion");
            }

            System.out.println(quote);
            System.out.println(art);
            System.out.println(eveArt);
            quotationRepository.save(quote);
            artworkRepository.save(art);

        }


        //if()
        return "redirect:customerEvents";
    }

    @RequestMapping("/customerManageAccount")
    public String customerManageAccount(ModelMap model, @SessionAttribute("session") Session session){
        model.put("session",session);
        users user=usersRepo.findOne(session.getUsername());
        model.put("user",user);
        return "customer_manage_account";
    }

    @RequestMapping("/customerChangeAccount")
    public String artistChangeAccount(ModelMap model,@SessionAttribute("session") Session session,users user){
        model.put("session",session);
        System.out.println(user);
        usersRepo.save(user);
        return "redirect:customerManageAccount";
    }
}
