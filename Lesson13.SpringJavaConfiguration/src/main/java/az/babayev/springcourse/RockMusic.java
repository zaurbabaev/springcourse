package az.babayev.springcourse;


import org.springframework.stereotype.Component;

public class RockMusic implements Music {

    @Override
    public String getSong() {
        return "November rain";
    }
}
