public class SingletonExample {
    public static void main(String[] args) {
        // Example of Early Instantiation (ConfigurationManager)
        ConfigurationManager configManager =
                ConfigurationManager.getInstance();
        System.out.println("Configuration Manager Instance: "
                + configManager);

        // Example of Lazy Instantiation (DatabaseManager)
        DatabaseManager dbManager1 =
                DatabaseManager.getInstance();
        System.out.println("Database Manager Instance 1: "
                + dbManager1);

        // Creating another instance of DatabaseManager will still return the same instance
        DatabaseManager dbManager2 =
                DatabaseManager.getInstance();
        System.out.println("Database Manager Instance 2: "
                + dbManager2);

        // Both instances point to the same object
        System.out.println("Are Database Managers the same? "
                + (dbManager1 == dbManager2));
    }
}

class ConfigurationManager {
    private static final
    ConfigurationManager instance = new ConfigurationManager();

    private ConfigurationManager() {
        // Load and initialize configuration settings
        System.out.println("Configuration Manager is loaded at the start.");
    }

    public static ConfigurationManager getInstance() {
        return instance;
    }
}

class DatabaseManager {
    private static DatabaseManager instance;

    private DatabaseManager() {
        // Initialization code for database connection
        System.out.println("Database connected");
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }
}
