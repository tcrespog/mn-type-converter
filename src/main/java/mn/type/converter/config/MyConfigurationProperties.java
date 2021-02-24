package mn.type.converter.config;

import java.time.LocalDate;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties(MyConfigurationProperties.PREFIX)
public class MyConfigurationProperties {

    public static final String PREFIX = "myapp";

    protected int version;
    protected LocalDate updatedAt;

    public int getVersion() {
        return this.version;
    }

    public LocalDate getUpdatedAt() {
        return this.updatedAt;
    }

}
