package az.babayev.springcourse;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("az.babayev.springcourse")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

    @Bean
    @Scope("prototype")
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }

    @Bean
    public JazzMusic jazzMusic() {
        return new JazzMusic();
    }


    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(classicalMusic(), rockMusic(), jazzMusic());
    }

    @Bean
    public Computer computer() {
        return new Computer(musicPlayer());
    }
}
