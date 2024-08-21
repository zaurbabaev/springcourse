package az.babayev.springcourse;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {

    private List<Music> musicList = new ArrayList<>();

    private String name;

    private int volume;

    public String getName() {
        return name;
    }

    public MusicPlayer(List<Music> musicList){
        this.musicList=musicList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public MusicPlayer() {
    }


    public void playMusic() {
        musicList.forEach(s -> System.out.println("Playing " + s.getSong()));

    }


}
