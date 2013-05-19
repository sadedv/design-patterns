package context;

import connection.ConnectionPool;

/**
 * ApplicationContext is implemented as singleton
 * 
 * @author Tomas Jakubco
 * 
 */
public final class ApplicationContext {

    /**
     * Application context object
     */
    private static ApplicationContext ctx;

    /**
     * Instance attribute
     */
    private String attribute = "no_attribute";
    
    /**
     * ConnectionPool
     */
    private ConnectionPool connectionPool;

    /**
     * Private constructor
     */
    private ApplicationContext() {
    }

    /**
     * Get reference to object
     * 
     * @return
     */
    protected static ApplicationContext getInstance() {
        if (ctx == null) {
            ctx = new ApplicationContext();
        }
        return ctx;
    }

    /**
     * Get particular attribute of application context
     * 
     * @return
     */
    public String getAttribute() {
        return attribute;
    }
    
    /**
     * Returns a reference to connection pool object
     * @return
     */
    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }

}
