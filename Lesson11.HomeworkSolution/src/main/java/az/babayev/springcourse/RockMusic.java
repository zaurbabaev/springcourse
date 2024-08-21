package az.babayev.springcourse;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class RockMusic implements Music {

    @Override
    public String getSong() {
        List<String> stringList = List.of
                ("Carrie", "I remember you", "November rain");
        Random random = new Random();
        int i = random.nextInt(stringList.size());
        return stringList.get(i);
    }
}
