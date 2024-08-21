package az.babayev.springcourse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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
        switch (musicEnum) {
            case CLASSICAL -> System.out.println(music1.getSong());
            case JAZZ -> System.out.println(music2.getSong());
            case ROCK -> System.out.println(music3.getSong());
        }
    }


}



