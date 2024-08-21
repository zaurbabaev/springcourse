package az.babayev.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");


        Music musicBean = context.getBean("rockMusic", Music.class);

        MusicPlayer musicPlayer = new MusicPlayer();

        musicPlayer.setMusic(musicBean); // set metodu vasitəsilə DI



        musicPlayer.playMusic();

        context.close();
    }


}
