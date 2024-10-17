package org.example.nbaplayersrater.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@ToString
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToOne
    @JoinColumn(name = "matchup_id")
    private Matchup matchup;
    private Long winnerId;
    private Long loserId;
    private LocalDateTime answeredAt;



    public Answer(Matchup matchup, Long winnerId, Long loserId) {
        this.matchup = matchup;
        this.winnerId = winnerId;
        this.loserId = loserId;
        this.answeredAt = LocalDateTime.now();
    }
}
