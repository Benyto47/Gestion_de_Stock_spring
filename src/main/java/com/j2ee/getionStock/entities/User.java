package com.j2ee.getionStock.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name ;
    private String prenom ;

    @Column(unique = true)
    private String email ;

    private String password ;
    private Boolean passCmd ;
    private Boolean selectedArt;
    private Boolean connected ;
    private Boolean admin ;

    @OneToMany(mappedBy = "user")
    private List<Article> articles ;

    /*j'ai beosin de voir , mes commandes directement lorsque j'affiche l'entité User*/
   /* Avec REMOVE lorsque on supprime une commande SPRING BOOT se charger de supprimer les relations entre commandes et users */
    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<Commande> commande ;


}
