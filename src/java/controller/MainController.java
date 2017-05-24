package controller;

import com.google.gson.Gson;
import dao.MainDao;
import hibernate.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Job;
import pojo.Persona;

/**
 *
 * @author Nicola & Thomas
 */
@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String index(ModelMap m) {
        return "index";
    }

    /**
     * Metodo per ajax
     *
     * @param text
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public @ResponseBody
    Object search(@RequestParam("text") String text) {
        SessionFactory s = HibernateUtil.getSessionFactory();
        ArrayList<Persona> l = (ArrayList<Persona>) MainDao.searchPersone(s, text);
        
        // bufu
        for(Persona p : l) {
            for(Job j : p.getJobs()) {
                j.setPersone(null);
            }
            p.getDipartimento().setPersone(null);
        }
        
        Gson g = new Gson();
                
        return g.toJson(l);
    }
}
