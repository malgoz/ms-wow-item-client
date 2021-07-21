package pl.kinert.mswowitemclient.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.kinert.mswowitemclient.model.ItemClassDTO;
import pl.kinert.mswowitemclient.model.ItemCollectionDTO;
import pl.kinert.mswowitemclient.model.ItemDTO;
import pl.kinert.mswowitemclient.service.TokenService;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class ItemClient {

    @Value("${battlenet.base.url}")
    private String battlenetBaseUrl;

    @Value("${battlenet.namespace.locale.string}")
    private String battlenetNamespaceLocale;

    private final TokenService tokenService;

    public ItemClient(TokenService tokenService){
        this.tokenService = tokenService;
    }

    public ItemCollectionDTO getItemClasses() throws URISyntaxException {
        String token = tokenService.getToken();
        URI uri = new URI(battlenetBaseUrl + "/item-class/index?" + battlenetNamespaceLocale + token);
        ItemCollectionDTO itemClasses = new RestTemplate().getForObject(
                uri,
                ItemCollectionDTO.class);
        return itemClasses;
    }

    public ItemClassDTO getItemClass(long id) throws URISyntaxException {
        String token = tokenService.getToken();
        URI uri = new URI(battlenetBaseUrl + "/item-class/" + id + "?" + battlenetNamespaceLocale + token);
        ItemClassDTO itemClass = new RestTemplate().getForObject(
                uri,
                ItemClassDTO.class);
        return itemClass;
    }

    public ItemDTO getItemById(long id) throws URISyntaxException {
        String token = tokenService.getToken();
        URI uri = new URI(battlenetBaseUrl + "/item/" + id + "?" + battlenetNamespaceLocale + token);
        ItemDTO item = new RestTemplate().getForObject(
                uri,
                ItemDTO.class);
        return item;
    }
}
