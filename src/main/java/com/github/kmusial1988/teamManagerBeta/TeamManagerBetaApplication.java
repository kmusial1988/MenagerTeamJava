package com.github.kmusial1988.teamManagerBeta;

import com.github.kmusial1988.teamManagerBeta.player.model.Player;
import com.github.kmusial1988.teamManagerBeta.player.repository.PlayerRepository;
import com.github.kmusial1988.teamManagerBeta.trainer.model.Trainer;
import com.github.kmusial1988.teamManagerBeta.trainer.repository.TrainerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

import static com.github.kmusial1988.teamManagerBeta.global.globalEnum.RoleEnum.PLAYER;
import static com.github.kmusial1988.teamManagerBeta.global.globalEnum.RoleEnum.TRAINER;
import static com.github.kmusial1988.teamManagerBeta.global.globalEnum.Status.NO;
import static com.github.kmusial1988.teamManagerBeta.global.globalEnum.Status.YES;

@SpringBootApplication
public class TeamManagerBetaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamManagerBetaApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:3000"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));

        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }


    @Bean
    CommandLineRunner run(TrainerRepository trainerRepository, PlayerRepository playerRepository) {

        return args -> {

            trainerRepository.save(new Trainer(null, "Jan", "Kowalski","kowalski@gmail.com", "kowalski",
                    "https://e7.pngegg.com/pngimages/263/387/png-clipart-smiley-emoji-illustration-emoji-emoticon-smiley-computer-icons-blushing-emoji-face-computer-wallpaper-thumbnail.png","16.15.1955", YES, TRAINER));
            trainerRepository.save(new Trainer(null, "Stefan", "Nowak","nowak@gmail.com", "nowak",
                    "https://w7.pngwing.com/pngs/407/764/png-transparent-yellow-smiley-emoji-emoji-computer-icons-emoticon-sunglasses-emoji-smiley-sticker-glasses.png","11.19.1698", NO, TRAINER));
            trainerRepository.save(new Trainer(null, "Janusz", "Kot","kot@gmail.com", "kot",
                    "https://e7.pngegg.com/pngimages/746/343/png-clipart-emoji-shocked-apple-color-emoji-surprise-sticker-emoji-smiley-anger-thumbnail.png","15.15.1555", YES, TRAINER));

            playerRepository.save(new Player(null, "Eustachy", "Kot","Eustachy@gmail.com", "kot",
                    "https://e7.pngegg.com/pngimages/746/343/png-clipart-emoji-shocked-apple-color-emoji-surprise-sticker-emoji-smiley-anger-thumbnail.png","12.09.1855", YES, PLAYER));

            playerRepository.save(new Player(null, "Szymon", "Kot","Szymon@gmail.com", "kot",
                    "https://w7.pngwing.com/pngs/407/764/png-transparent-yellow-smiley-emoji-emoji-computer-icons-emoticon-sunglasses-emoji-smiley-sticker-glasses.png","25.10.1785", YES, PLAYER));

            playerRepository.save(new Player(null, "Mieczysław", "Kot","Mieczysław@gmail.com", "kot",
                    "https://e7.pngegg.com/pngimages/263/387/png-clipart-smiley-emoji-illustration-emoji-emoticon-smiley-computer-icons-blushing-emoji-face-computer-wallpaper-thumbnail.png","15.15.1555", YES, PLAYER));


        };
    }

}
