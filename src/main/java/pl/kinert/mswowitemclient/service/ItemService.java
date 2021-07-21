package pl.kinert.mswowitemclient.service;

import pl.kinert.mswowitemclient.model.ItemDTO;

import java.net.URISyntaxException;

public interface ItemService {

    ItemDTO getItemById(long id) throws URISyntaxException;
}
