package com.example.monitorowaniejednostekmorskich.token;

import com.example.monitorowaniejednostekmorskich.token.model.Token;
import com.example.monitorowaniejednostekmorskich.token.model.TokenRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class TokenRequestService {

    private final TokenRequest tokenRequest;

    public TokenRequestService(TokenRequest tokenRequest) {
        this.tokenRequest = tokenRequest;
    }

    public String getToken() {
        URI url = null;
        try {
            url = new URI("https://id.barentswatch.no/connect/token");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("client_id", tokenRequest.getClientId());
        body.add("scope", tokenRequest.getScope());
        body.add("client_secret", tokenRequest.getClientSecret());
        body.add("grant_type", tokenRequest.getGrantType());

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
        ResponseEntity<Token> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                Token.class);

        return response.getBody().getAccessToken();
    }
}
