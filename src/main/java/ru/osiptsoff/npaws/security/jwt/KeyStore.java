package ru.osiptsoff.npaws.security.jwt;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
class KeyDto {
    private String key;
}

@Component
class KeyStore {
    private static final String ACCESS_PUBLIC_KEY = "public_access";

    private final RestTemplate restTemplate;

    private Map<String, Key> keys;
    
    @Setter
    @Value("${app.config.security.keyEndpoint}")
    private String keyEndpoint;

    @Setter
    @Value("${app.config.keyfile}")
    private String keyFilePath;

    public KeyStore(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        keys = new HashMap<>();
    }

    @PostConstruct
    protected void initializeKeys() throws InvalidKeySpecException,
            NullPointerException, IOException, NoSuchAlgorithmException, RestClientException {
        String encodedKey;
        try {
            encodedKey = Files.readString(Paths.get(keyFilePath));
        } catch (IOException e) {
            encodedKey = restTemplate
                .getForObject(keyEndpoint, KeyDto.class)
                .getKey();

            try(var out = new PrintWriter(keyFilePath)) {
                out.print(encodedKey);
            }
        } 
        decodeAndSetKey(encodedKey);
    }

    public PublicKey getAccessPublicKey() {
        return (PublicKey)keys.get(ACCESS_PUBLIC_KEY);
    }

    private void decodeAndSetKey(String encodedKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        var rsaKeyFactory = KeyFactory.getInstance("RSA");
        var keyBytes = Base64.getDecoder().decode(encodedKey);
        var pubKeySpec = new X509EncodedKeySpec(keyBytes);
        var pubKey = rsaKeyFactory.generatePublic(pubKeySpec);

        keys.put(ACCESS_PUBLIC_KEY, pubKey);
    }
}
