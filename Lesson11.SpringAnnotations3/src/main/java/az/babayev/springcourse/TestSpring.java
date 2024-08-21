package az.babayev.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer2 musicPlayer = context.getBean("musicPlayer2", MusicPlayer2.class);

        System.out.println(musicPlayer.playMusic());


        context.close();
    }


}
