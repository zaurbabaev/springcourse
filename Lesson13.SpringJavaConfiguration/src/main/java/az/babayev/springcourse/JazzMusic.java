package az.babayev.springcourse;


import org.springframework.stereotype.Component;

public class JazzMusic implements Music {
    @Override
    public String getSong() {
        return "Body and Soul";
    }
}