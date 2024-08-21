package az.babayev.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");


        MusicPlayer musicPlayerFirst = context.getBean("musicPlayer", MusicPlayer.class);

        System.out.println(musicPlayerFirst.getVolume()); // dəyərini properties fayldan götürür

        MusicPlayer musicPlayerSecond = context.getBean("musicPlayer", MusicPlayer.class);

        musicPlayerSecond.setVolume(50); // yeni dəyər məniməsdilir. və scope property olsuğundan bu dəyər yalnızca musicPlayerSecond bean-inda
        // dəyişir. firstMusicBean-in valuesi propertiesdə olandır
        System.out.println(musicPlayerFirst == musicPlayerSecond);

        System.out.println(musicPlayerFirst);
        System.out.println(musicPlayerSecond);

        System.out.println(musicPlayerFirst.getVolume());
        System.out.println(musicPlayerSecond.getVolume());



        context.close();
    }


}
