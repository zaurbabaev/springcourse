package az.babayev.springcourse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {

    private ClassicalMusic classicalMusic;

    private RockMusic rockMusic;

    @Autowired
    private MusicPlayer(ClassicalMusic classicalMusic,
                        RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }


//    public MusicPlayer(Music music) {
//        this.music = music;
//    }
//
//    @Autowired
//    public void setMusic(Music music){
//        this.music=music;
//    }

    public String playMusic() {
       return "Playing: " + classicalMusic.getSong() + " and "+rockMusic.getSong();
    }

}



