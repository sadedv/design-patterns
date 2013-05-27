package networking.multicast;

public final class ApplicationContext {
    
    private static ApplicationContext applicationContext;
    
    private ApplicationContext() {
    }
    
    public static ApplicationContext getContext() {
        if (applicationContext == null) {
            applicationContext = new ApplicationContext();
        }
        return applicationContext;
    }

}
