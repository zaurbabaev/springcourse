package az.babayev.springcourse;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class JazzMusic implements Music
{
    @Override
    public String getSong() {
        List<String> stringList = List.of("The Girl From Ipanema", "All Blues", "Body and Soul");
        Random random = new Random();
        int i = random.nextInt(stringList.size());
        return stringList.get(i);
    }
}
