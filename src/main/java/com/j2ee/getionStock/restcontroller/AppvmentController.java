package com.j2ee.getionStock.restcontroller;

import com.j2ee.getionStock.entities.Appvment;
import com.j2ee.getionStock.entities.Article;
import com.j2ee.getionStock.repository.AppvmentRepository;
import com.j2ee.getionStock.service.AppvmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/appvment")
@CrossOrigin
public class AppvmentController {

    @Autowired /* injection des dépendance ,pour dire que une classe depend d'un autre classe ou objet */
    private AppvmentService appvmentService ;

    @Autowired
    private AppvmentRepository appvmentRepository ;

    @PostMapping
    public ResponseEntity<Appvment> saveAppvment(@RequestBody Appvment appvment) {
        Appvment saveAppvment = appvmentService.saveAppvment(appvment);
        return new ResponseEntity<>(saveAppvment, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Appvment> updateAppvment(@RequestBody Appvment appvment) {
        Appvment saveAppvment = appvmentService.updateAppvment(appvment);
        return new ResponseEntity<>(saveAppvment, HttpStatus.CREATED);
    }


    @PostMapping("/all")
    public List<Appvment> saveAllApvment(@RequestBody List<Appvment> appvments) {

        return appvmentService.saveAllAppvment(appvments);
    }

    @GetMapping(value="/{id}")
    public Appvment findAppvment(@PathVariable Long id){

        return appvmentService.getAppvmentById(id);
    }


    @GetMapping("/all")
    public List<Appvment> findAllAppvment(){

        return appvmentService.getAllAppvment() ;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppvmentById(@PathVariable Long id) {
        appvmentService.deleteAppvmentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    //ADMIN afficher le nombre d'articles par pages
    @GetMapping("/admin")
    public Page<Appvment> getAppvments(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "8") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return appvmentRepository.findAll(pageable);
    }

}
