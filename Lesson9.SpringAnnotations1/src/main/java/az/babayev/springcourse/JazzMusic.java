package az.babayev.springcourse;


import org.springframework.stereotype.Component;

@Component
public class JazzMusic implements Music
{
    @Override
    public String getSong() {
        return "Swing is the Answer";
    }
}
