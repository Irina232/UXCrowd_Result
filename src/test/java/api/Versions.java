package api;

public class Versions {
    private Integer id;
    private String version;
    private String pluginType;
    private String environmentType;

    public String getVersion() {
        return version;
    }

    public Integer getId() {
        return id;
    }

    public String getPluginType() {
        return pluginType;
    }

    public String getEnvironmentType() {
        return environmentType;
    }
}
