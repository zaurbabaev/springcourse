package az.babayev.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ClassicalMusic implements Music {


    @Override
    public String getSong() {
        List<String> stringList = List.of
                ("Bolero", "Surprise Symphony", "Hungarian Rhapsody");
        Random random = new Random();
        int i = random.nextInt(stringList.size());
        return stringList.get(i);
    }


}
