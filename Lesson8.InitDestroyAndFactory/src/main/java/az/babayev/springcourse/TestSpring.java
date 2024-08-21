package az.babayev.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");


        ClassicalMusic music = context.getBean("musicBeanClassical", ClassicalMusic.class);
        ClassicalMusic music2 = context.getBean("musicBeanClassical", ClassicalMusic.class);
        System.out.println(music.getSong());
        System.out.println(music2.getSong());


        context.close();
    }


}
