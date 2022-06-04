//package com.github.kmusial1988.teamManagerBeta;
//
//import com.github.kmusial1988.teamManagerBeta.parent.model.Parent;
//import com.github.kmusial1988.teamManagerBeta.parent.repository.ParentRepository;
//import com.github.kmusial1988.teamManagerBeta.player.model.Player;
//import com.github.kmusial1988.teamManagerBeta.player.repository.PlayerRepository;
//import com.github.kmusial1988.teamManagerBeta.trainer.model.Trainer;
//import com.github.kmusial1988.teamManagerBeta.trainer.repository.TrainerRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Controller;
//
//import java.util.ArrayList;
//
//import static com.github.kmusial1988.teamManagerBeta.global.globalEnum.RoleEnum.*;
//import static com.github.kmusial1988.teamManagerBeta.global.globalEnum.RoleEnum.PARENT;
//import static com.github.kmusial1988.teamManagerBeta.global.globalEnum.Status.NO;
//import static com.github.kmusial1988.teamManagerBeta.global.globalEnum.Status.YES;
//
//@Controller
//public class AddingToBD {
//    @Bean
//    CommandLineRunner run(TrainerRepository trainerRepository, PlayerRepository playerRepository, ParentRepository parentRepository) {
//
//        return args -> {
//
//            trainerRepository.save(new Trainer(null, "Jan", "Kowalski","kowalski@gmail.com", "kowalski",
//                    "https://e7.pngegg.com/pngimages/263/387/png-clipart-smiley-emoji-illustration-emoji-emoticon-smiley-computer-icons-blushing-emoji-face-computer-wallpaper-thumbnail.png","16.15.1955", YES, TRAINER, new ArrayList<>()));
//            trainerRepository.save(new Trainer(null, "Stefan", "Nowak","nowak@gmail.com", "nowak",
//                    "https://w7.pngwing.com/pngs/407/764/png-transparent-yellow-smiley-emoji-emoji-computer-icons-emoticon-sunglasses-emoji-smiley-sticker-glasses.png","11.19.1698",
//                    NO, TRAINER, new ArrayList<>()));
//            trainerRepository.save(new Trainer(null, "Janusz", "Kot","kot@gmail.com", "kot",
//                    "https://e7.pngegg.com/pngimages/746/343/png-clipart-emoji-shocked-apple-color-emoji-surprise-sticker-emoji-smiley-anger-thumbnail.png","15.15.1555", YES, TRAINER, new ArrayList<>()));
//
//            trainerRepository.save(new Trainer(null, "Jan", "Kowalski","0kowalski@gmail.com", "kowalski",
//                    "https://e7.pngegg.com/pngimages/263/387/png-clipart-smiley-emoji-illustration-emoji-emoticon-smiley-computer-icons-blushing-emoji-face-computer-wallpaper-thumbnail.png","16.15.1955", YES, TRAINER, new ArrayList<>()));
//            trainerRepository.save(new Trainer(null, "Stefan", "Nowak","0nowak@gmail.com", "nowak",
//                    "https://w7.pngwing.com/pngs/407/764/png-transparent-yellow-smiley-emoji-emoji-computer-icons-emoticon-sunglasses-emoji-smiley-sticker-glasses.png","11.19.1698", NO, TRAINER, new ArrayList<>()));
//            trainerRepository.save(new Trainer(null, "Janusz", "Kot","0kot@gmail.com", "kot",
//                    "https://e7.pngegg.com/pngimages/746/343/png-clipart-emoji-shocked-apple-color-emoji-surprise-sticker-emoji-smiley-anger-thumbnail.png","15.15.1555", YES, TRAINER, new ArrayList<>()));
//
//            trainerRepository.save(new Trainer(null, "Jan", "Kowalski","1kowalski@gmail.com", "kowalski",
//                    "https://e7.pngegg.com/pngimages/263/387/png-clipart-smiley-emoji-illustration-emoji-emoticon-smiley-computer-icons-blushing-emoji-face-computer-wallpaper-thumbnail.png","16.15.1955", YES, TRAINER, new ArrayList<>()));
//            trainerRepository.save(new Trainer(null, "Stefan", "Nowak","1nowak@gmail.com", "nowak",
//                    "https://w7.pngwing.com/pngs/407/764/png-transparent-yellow-smiley-emoji-emoji-computer-icons-emoticon-sunglasses-emoji-smiley-sticker-glasses.png","11.19.1698", NO, TRAINER, new ArrayList<>()));
//            trainerRepository.save(new Trainer(null, "Janusz", "Kot","1kot@gmail.com", "kot",
//                    "https://e7.pngegg.com/pngimages/746/343/png-clipart-emoji-shocked-apple-color-emoji-surprise-sticker-emoji-smiley-anger-thumbnail.png","15.15.1555", YES, TRAINER, new ArrayList<>()));
//
//            trainerRepository.save(new Trainer(null, "Jan", "Kowalski","2kowalski@gmail.com", "kowalski",
//                    "https://e7.pngegg.com/pngimages/263/387/png-clipart-smiley-emoji-illustration-emoji-emoticon-smiley-computer-icons-blushing-emoji-face-computer-wallpaper-thumbnail.png","16.15.1955", YES, TRAINER, new ArrayList<>()));
//            trainerRepository.save(new Trainer(null, "Stefan", "Nowak","2nowak@gmail.com", "nowak",
//                    "https://w7.pngwing.com/pngs/407/764/png-transparent-yellow-smiley-emoji-emoji-computer-icons-emoticon-sunglasses-emoji-smiley-sticker-glasses.png","11.19.1698", NO, TRAINER, new ArrayList<>()));
//            trainerRepository.save(new Trainer(null, "Janusz", "Kot","2kot@gmail.com", "kot",
//                    "https://e7.pngegg.com/pngimages/746/343/png-clipart-emoji-shocked-apple-color-emoji-surprise-sticker-emoji-smiley-anger-thumbnail.png","15.15.1555", YES, TRAINER, new ArrayList<>()));
//
//            trainerRepository.save(new Trainer(null, "Jan", "Kowalski","3kowalski@gmail.com", "kowalski",
//                    "https://e7.pngegg.com/pngimages/263/387/png-clipart-smiley-emoji-illustration-emoji-emoticon-smiley-computer-icons-blushing-emoji-face-computer-wallpaper-thumbnail.png","16.15.1955", YES, TRAINER, new ArrayList<>()));
//            trainerRepository.save(new Trainer(null, "Stefan", "Nowak","3nowak@gmail.com", "nowak",
//                    "https://w7.pngwing.com/pngs/407/764/png-transparent-yellow-smiley-emoji-emoji-computer-icons-emoticon-sunglasses-emoji-smiley-sticker-glasses.png","11.19.1698", NO, TRAINER, new ArrayList<>()));
//            trainerRepository.save(new Trainer(null, "Janusz", "Kot","3kot@gmail.com", "kot",
//                    "https://e7.pngegg.com/pngimages/746/343/png-clipart-emoji-shocked-apple-color-emoji-surprise-sticker-emoji-smiley-anger-thumbnail.png","15.15.1555", YES, TRAINER, new ArrayList<>()));
//
//
//
//
//
//
//
//
//            parentRepository.save(new Parent(null, "Alojzy", "Klepka", "klepka@gmail.com", "klepka", "https://w7.pngwing.com/pngs/407/764/png-transparent-yellow-smiley-emoji-emoji-computer-icons-emoticon-sunglasses-emoji-smiley-sticker-glasses.png",
//                    "11.09.1955",NO, PARENT, new ArrayList<>()));
//            parentRepository.save(new Parent(null, "Atanazy", "Kielp", "kielp@gmail.com", "kielp", "https://w7.pngwing.com/pngs/407/764/png-transparent-yellow-smiley-emoji-emoji-computer-icons-emoticon-sunglasses-emoji-smiley-sticker-glasses.png",
//                    "09.11.1985",YES, PARENT, new ArrayList<>()));
//            parentRepository.save(new Parent(null, "Wieslaw", "Bibik", "bibik@gmail.com", "bibik", "https://w7.pngwing.com/pngs/407/764/png-transparent-yellow-smiley-emoji-emoji-computer-icons-emoticon-sunglasses-emoji-smiley-sticker-glasses.png",
//                    "09.11.1985",YES, PARENT, new ArrayList<>()));
//
////            playerRepository.save(new Player(null, "Eustachy", "Kot","Eustachy@gmail.com", "kot",
////                    "https://e7.pngegg.com/pngimages/746/343/png-clipart-emoji-shocked-apple-color-emoji-surprise-sticker-emoji-smiley-anger-thumbnail.png","12.09.1855", YES, PLAYER, new Parent()));
////
////            playerRepository.save(new Player(null, "Szymon", "Kot","Szymon@gmail.com", "kot",
////                    "https://w7.pngwing.com/pngs/407/764/png-transparent-yellow-smiley-emoji-emoji-computer-icons-emoticon-sunglasses-emoji-smiley-sticker-glasses.png","25.10.1785", YES, PLAYER, new Parent()));
////
////            playerRepository.save(new Player(null, "Mieczysław", "Kot","Mieczysław@gmail.com", "kot",
////                    "https://e7.pngegg.com/pngimages/263/387/png-clipart-smiley-emoji-illustration-emoji-emoticon-smiley-computer-icons-blushing-emoji-face-computer-wallpaper-thumbnail.png","15.15.1555", YES, PLAYER, new Parent()));
//
//        };
//    }
//
//}
