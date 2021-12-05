package com.example.monitorowaniejednostekmorskich.token.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


//@ConfigurationProperties("token")
@Configuration
public class TokenRequest {

    private final String clientId;
    private final String scope;
    private final String clientSecret;
    private final String grantType;



    public TokenRequest(@Value("${token.clientId}") String clientId,
                        @Value("${token.scope}") String scope,
                        @Value("${token.clientSecret}") String clientSecret,
                        @Value("${token.grantType}") String grantType) {
        this.clientId = clientId;
        this.scope = scope;
        this.clientSecret = clientSecret;
        this.grantType = grantType;
    }



//    public TokenProperty( String clientId, String scope, String clientSecret, String grantType) {
//        this.clientId = clientId;
//        this.scope = scope;
//        this.clientSecret = clientSecret;
//        this.grantType = grantType;
//    }



    public String getClientId() {
        return clientId;
    }


    public String getScope() {
        return scope;
    }


    public String getClientSecret() {
        return clientSecret;
    }

    public String getGrantType() {
        return grantType;
    }
}
