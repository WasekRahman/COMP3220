package io.CS3220.WindsorPublicDatabase.controllers;

import io.CS3220.WindsorPublicDatabase.models.GetDataKeys;
import io.CS3220.WindsorPublicDatabase.models.Read;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String redirect()
    {

        return home();
    }

    @GetMapping("/home")
    public String home()
    {

        return "home";
    }


    @RequestMapping(path="/data", produces= MediaType.TEXT_PLAIN_VALUE)
    public String dataForm(@RequestParam() String filename,
                              Model model) throws IOException {
        filename = "data/"+filename;
        model.addAttribute("filename",filename);
        return "data";
    }

    @GetMapping("/Datasets")
    public String catalogue(Model model) throws IOException {

        GetDataKeys k = new GetDataKeys();

        model.addAttribute("datasets",k.getkeys());
        return "catalogue";
    }

    @RequestMapping(path="/json", produces= MediaType.TEXT_PLAIN_VALUE)
    public String processForm(@RequestParam() String filename,
                               Model model) throws IOException {

        Read obj = new Read();
        String json = obj.readFile(filename);
        model.addAttribute("jsonFormat",json);
        return "json";
    }



}
