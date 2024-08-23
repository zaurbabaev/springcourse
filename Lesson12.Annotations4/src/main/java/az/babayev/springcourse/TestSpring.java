package az.babayev.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        System.out.println(musicPlayer.getVolume());
        System.out.println(musicPlayer.getName());

        System.out.println("-".repeat(60));

        System.out.println(musicPlayer.playMusic());

        System.out.println("-".repeat(60));

        ClassicalMusic classicalMusic1 = context.getBean(ClassicalMusic.class);
        ClassicalMusic classicalMusic2 = context.getBean(ClassicalMusic.class);

        System.out.println(classicalMusic1==classicalMusic2);

        context.close();
    }


}
