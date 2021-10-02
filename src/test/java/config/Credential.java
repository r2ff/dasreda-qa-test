package config;

import org.aeonbits.owner.ConfigFactory;

public class Credential {
    public static CredentialConfig config = ConfigFactory.create(CredentialConfig.class, System.getProperties());
}
