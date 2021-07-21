package pl.kinert.mswowitemclient.service;

import pl.kinert.mswowitemclient.jpa.model.ItemClass;
import pl.kinert.mswowitemclient.jpa.model.ItemSubclass;
import pl.kinert.mswowitemclient.model.ItemClassDTO;
import pl.kinert.mswowitemclient.model.ItemCollectionDTO;

import java.net.URISyntaxException;

public interface ItemClassService {

    ItemCollectionDTO getItemClasses() throws URISyntaxException;

    ItemClassDTO getItemClass(long id) throws URISyntaxException;

    ItemClass getItemClassById(long id);

    ItemSubclass getItemSubclassByName(String name, long id);
}
