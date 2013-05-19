package context;

/**
 * ApplicationClass should not be instantiated.
 * 
 * @author Tomas Jakubco
 * 
 */
public abstract class ApplicationClass implements ApplicationInterface {

    public ApplicationClass() {
    }

    @Override
    public ApplicationContext getApplicationContext() {
        return ApplicationContext.getInstance();
    }

}
