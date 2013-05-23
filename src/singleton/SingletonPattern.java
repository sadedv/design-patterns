package singleton;

public final class SingletonPattern {

    private static SingletonPattern pattern;

    private SingletonPattern() {
    }

    public static SingletonPattern getInstance() {
        if (pattern == null) {
            pattern = new SingletonPattern();
        }
        return pattern;
    }

}
