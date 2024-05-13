package com.j2ee.getionStock.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Date dateCmd ;
    private Long qteCmd ;

    /*Dans commande je ne verrai pas l'article*/
    @ManyToOne
    private User user ;



}
