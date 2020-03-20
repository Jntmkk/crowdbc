package cn.edu.jnu.crowdbc.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.web3j.abi.datatypes.Address;
import org.web3j.crypto.Credentials;

@Component
public class CredentialsManager {
    public CredentialsManager() {

    }
    public static Credentials getCredentials(Address address) {
        return Credentials.create("84495972845D968D351EABCB8266D0E6C756008EAB94FEF903573177889382AF");

    }
}
