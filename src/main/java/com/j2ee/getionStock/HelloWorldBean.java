package com.j2ee.getionStock;




import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;

/* pour utliser JSF , dans cette Bean va nous retourner ces messages quand il sera appéllé sur la vue */
@Controller
@RequestScoped
public class HelloWorldBean {
    public String getHello() {
        return "http://localhost:3000/";
    }

    @PostConstruct
    public void init(){
        System.out.println("Init Method calling...");
    }

    public void search(){
        System.out.println("Search Method calling...");
    }
}