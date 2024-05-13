package com.j2ee.getionStock.service;

import com.j2ee.getionStock.entities.Appvment;
import com.j2ee.getionStock.repository.AppvmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppvmentServiceImpl implements AppvmentService {

    @Autowired
    private AppvmentRepository appvmentRepository ;

    @Override
    public Appvment saveAppvment(Appvment appvment) {

        Appvment art = appvment ;

        if (art.getImage() == null || art.getImage().isEmpty()) {
            String categoryNom = art.getCat().getNom();
            if (categoryNom.equals("Téléphone"))
                art.setImage("/image/telephone/apple-14-pro-renders.jpg");
            else if (categoryNom.equals("Tablette"))
                art.setImage("/image/tablette/tablette noire.jpg");
            else if (categoryNom.equals("Ordinateur"))
                art.setImage("/image/pc/dell 13.jpg");
            else if (categoryNom.equals("Lunette"))
                art.setImage("/image/lunette/hugo-boss.jpg");
        }

        return appvmentRepository.save(appvment);
    }

    @Override
    public List<Appvment> saveAllAppvment(List<Appvment> appvments) {

        List<Appvment> updatedAppvments = new ArrayList<>();

        for (Appvment art : appvments) {
            if (art.getImage() == null || art.getImage().isEmpty()) {
                String categoryNom = art.getCat().getNom();
                if (categoryNom.equals("Téléphone"))
                    art.setImage("/image/telephone/apple-14-pro-renders.jpg");
                else if (categoryNom.equals("Tablette"))
                    art.setImage("/image/tablette/tablette noire.jpg");
                else if (categoryNom.equals("Ordinateur"))
                    art.setImage("/image/pc/dell 13.jpg");
                else if (categoryNom.equals("Lunette"))
                    art.setImage("/image/lunette/hugo-boss.jpg");
            }

            updatedAppvments.add(art);
        }


        return appvmentRepository.saveAll(updatedAppvments);
    }

    @Override
    public Appvment updateAppvment(Appvment appvment) {

        Appvment art = appvment ;

        if (art.getImage() == null || art.getImage().isEmpty()) {
            String categoryNom = art.getCat().getNom();
            if (categoryNom.equals("Téléphone"))
                art.setImage("/image/telephone/apple-14-pro-renders.jpg");
            else if (categoryNom.equals("Tablette"))
                art.setImage("/image/tablette/tablette noire.jpg");
            else if (categoryNom.equals("Ordinateur"))
                art.setImage("/image/pc/dell 13.jpg");
            else if (categoryNom.equals("Lunette"))
                art.setImage("/image/lunette/hugo-boss.jpg");
        }

        return appvmentRepository.save(appvment);
    }

    @Override
    public void deleteAppvmentById(Long id) {

        appvmentRepository.deleteById(id);
    }

    @Override
    public void deleteAppvment(Appvment appvment) {

        appvmentRepository.delete(appvment);
    }

    @Override
    public List<Appvment> getAllAppvment() {
        return appvmentRepository.findAll();
    }

    @Override
    public Appvment getAppvmentById(Long id) {
        return appvmentRepository.findById(id).get();
    }
}
