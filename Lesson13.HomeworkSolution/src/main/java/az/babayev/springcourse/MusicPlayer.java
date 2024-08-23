package az.babayev.springcourse;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class MusicPlayer {

    private final List<Music> musicList;

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public String playMusic() {
        Random random = new Random();
        int randomNumber = random.nextInt(musicList.size());
        return "Playing: " + musicList.get(randomNumber).getSong();
    }


}



