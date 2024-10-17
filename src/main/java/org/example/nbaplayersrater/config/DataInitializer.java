package org.example.nbaplayersrater.config;

import lombok.AllArgsConstructor;
import org.example.nbaplayersrater.model.Player;
import org.example.nbaplayersrater.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    // TODO: Replace this class with Liquibase

    private final PlayerRepository playerRepository;

    @Override
    public void run(String... args) {
        String filePath = "src/main/resources/nba_players_data.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    // Split by comma (name, surname, image_url)
                    String[] parts = line.split(",", 3);
                    if (parts.length == 3) {
                        String name = parts[0];
                        String surname = parts[1];
                        String imageUrl = parts[2]; // URL is the third part

                        // Initialize the Player with name, surname, rating (default: 1000), and imageUrl
                        Player player = new Player(name, surname, 1000, imageUrl);
                        playerRepository.save(player);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
