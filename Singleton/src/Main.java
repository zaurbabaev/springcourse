public class Main {
    public static void main(String[] args) {

        Singleton first = Singleton.getInstance("Hello");
        Singleton second = Singleton.getInstance("Java");

        System.out.println(first==second); // true
        System.out.println(second.getValue());
    }
}