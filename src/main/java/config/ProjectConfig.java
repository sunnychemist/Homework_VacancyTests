package config;


import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:configuration/config.properties"
})
public interface ProjectConfig extends Config {

    ProjectConfig PROJECT_CONFIG = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    @DefaultValue("chrome")
    String browser();
    @DefaultValue("91.0")
    String browserVersion();
    @DefaultValue("1920x1080")
    String browserSize();
    String removeUrl();
    @DefaultValue("https://www.rabota.ru")
    String baseUrl();
    @Key("localRun")
    @DefaultValue(value = "false")
    boolean localRun();
}