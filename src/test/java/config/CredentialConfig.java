package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/credentials.properties"
})
public interface CredentialConfig extends Config {

    String email();

    String password();

    @Key("wrongemail")
    String wrongEmail();

    String token();
}