package az.babayev.springcourse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer2 {

    private Music music1;
    private Music music2;

    @Autowired
    public MusicPlayer2(@Qualifier("classicalMusic") Music music1,
                        @Qualifier("jazzMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public String playMusic() {
        return "Playing: " + music1.getSong() + " and " + music2.getSong();
    }


}



