package az.babayev.springcourse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {

    private Music music1;
    private Music music2;
    private Music music3;

    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic") Music music1,
                       @Qualifier("jazzMusic") Music music2,
                       @Qualifier("rockMusic") Music music3) {
        this.music1 = music1;
        this.music2 = music2;
        this.music3 = music3;
    }

    public void playMusic(MusicEnum musicEnum) {
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        switch (musicEnum) {
            case CLASSICAL -> System.out.println(music1.getSong().get(randomNumber));
            case JAZZ -> System.out.println(music2.getSong().get(randomNumber));
            default -> System.out.println(music3.getSong().get(randomNumber));
        }
    }


}



