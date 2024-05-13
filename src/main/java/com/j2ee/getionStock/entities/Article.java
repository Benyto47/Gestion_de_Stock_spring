package com.j2ee.getionStock.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity  /* on a décider d'utiliser une seule base de donnée , pour cela dans les 2 App de Vente et Stock
il faut avoir une cohérence des entités */
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String nom ;
    private String image ;
    private String descp ;
    private String color ;
    private Integer stockage ;
    private String type ; 
    private Float prix ;
    private String date ;
    private Integer qte_art ;
    private Boolean sell ;
    private Integer qte_client ;
    private Boolean commander ;

    @ToString.Exclude//éviter la boucle infinie lors de la méthode toString()
    @JsonIgnore
    @ManyToOne
    private User user ;

    @ManyToOne
    private Category category ;

}
