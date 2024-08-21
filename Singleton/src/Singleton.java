public class Singleton {

    private static Singleton instance;

    private String value;

    private Singleton(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}
