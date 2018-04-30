package main.java.conf;

import java.io.File;

import main.java.serialization.Serializer;

public class Config
{
    private static String path = System.getProperty("user.dir");

    private static File configTemplate;
    private static File config;

    private static Settings settings;

    static
    {
        configTemplate = new File(path + "/src/main/java/conf/configTemplate.xml");
        config = new File(path + "/src/main/java/conf/config.xml");

        if (config.exists())
        {
            settings = Serializer.deserialize(Settings.class, config);
        }
        else
        {
            settings = new Settings();
        }
    }

    public static Settings getSettings()
    {
        if (config.exists() && config.isFile())
        {
            return Serializer.deserialize(Settings.class, config);
        }
        return new Settings();
    }

    public static void setRoot(String root)
    {
        settings.Root = root;

        Serializer.serialize(settings, config);
    }
}