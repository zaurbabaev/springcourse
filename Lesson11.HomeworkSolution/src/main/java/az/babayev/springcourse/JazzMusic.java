package az.babayev.springcourse;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JazzMusic implements Music {
    @Override
    public List<String> getSong() {
        return List.of("The Girl From Ipanema", "All Blues", "Body and Soul");
    }
}
