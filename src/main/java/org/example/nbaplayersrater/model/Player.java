package org.example.nbaplayersrater.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Setter
    private int score;
    private String imageUrl;

    public Player(String name, String surname, Integer score, String imageUrl) {
        this.name = name;
        this.surname = surname;
        this.score = score;
        this.imageUrl = imageUrl;
    }

}
