package pl.kinert.mswowitemclient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class TokenServiceImpl implements TokenService {

    public static final String ACCESS_TOKEN = "&access_token=";

    @Value("${authentication.service.token.url}")
    private String authenticationServiceUrl;

    public String getToken() throws URISyntaxException {
        URI uri = new URI(authenticationServiceUrl);
        String token = new RestTemplate().getForObject(
                uri,
                String.class);
        return ACCESS_TOKEN + token;
    }
}
