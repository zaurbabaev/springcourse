package az.babayev.springcourse;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassicalMusic implements Music {


    @Override
    public List<String> getSong() {
        return List.of("Bolero", "Surprise Symphony", "Hungarian Rhapsody");
    }


}
