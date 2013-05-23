package connection;

import java.util.HashMap;
import java.util.Map;

import context.ApplicationClass;

public final class ConnectionPool extends ApplicationClass {

    private static ConnectionPool connectionPool;

    private Map<Connection, Boolean> connections;

    private ConnectionPool() {
        connections = new HashMap<Connection, Boolean>();
    }

    public static ConnectionPool getInstance() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    public Connection requestConnection() {
        for (Map.Entry<Connection, Boolean> entry : connections.entrySet()) {
            if (!entry.getValue()) {
                entry.setValue(true);
                System.out
                        .println("Connection was provided. " + entry.getKey());
                return entry.getKey();
            }
        }

        if (connections.size() < 5) {
            Connection c = new Connection();
            connections.put(c, true);
            System.out.println("Connection was provided. " + c);
            return c;
        }

        System.out.println("Connection limit exceeded.");

        return null;
    }

    public void freeConnection(Connection connection) {
        connections.put(connection, false);
    }

    public static void main(String[] args) {

        // ConnectionPool pool = ConnectionPool.getInstance();
        //
        // Connection c1 = pool.requestConnection();
        // Connection c2 = pool.requestConnection();
        // Connection c3 = pool.requestConnection();
        // Connection c4 = pool.requestConnection();
        // Connection c5 = pool.requestConnection();
        // Connection c6 = pool.requestConnection();
        // pool.freeConnection(c1);
        // c6 = pool.requestConnection();

    }

}
