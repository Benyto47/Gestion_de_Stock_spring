package com.j2ee.getionStock.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity  /* tout les commentaires qu'on a fait dans gestion de vente sont les mêmes qu'ici*/
public class Appvment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String nomArt ;
    private String image ;
    private Date dateLivraison ;
    private Integer qte_cmd ;

    @ManyToOne
    private Cat cat;

}
