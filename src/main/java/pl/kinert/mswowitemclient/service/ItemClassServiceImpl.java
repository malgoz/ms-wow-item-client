package pl.kinert.mswowitemclient.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kinert.mswowitemclient.client.ItemClient;
import pl.kinert.mswowitemclient.jpa.model.ItemClass;
import pl.kinert.mswowitemclient.jpa.model.ItemSubclass;
import pl.kinert.mswowitemclient.jpa.repository.ItemClassRepository;
import pl.kinert.mswowitemclient.jpa.repository.ItemSubclassRepository;
import pl.kinert.mswowitemclient.model.BaseItemDTO;
import pl.kinert.mswowitemclient.model.ItemClassDTO;
import pl.kinert.mswowitemclient.model.ItemCollectionDTO;

import java.net.URISyntaxException;
import java.util.Optional;

import static pl.kinert.mswowitemclient.utils.Mapper.mapItemClass;
import static pl.kinert.mswowitemclient.utils.Mapper.mapItemSubclass;

@Service
public class ItemClassServiceImpl implements ItemClassService {

    private final ItemClassRepository itemClassRepository;

    private final ItemSubclassRepository itemSubclassRepository;

    private final ItemClient itemClient;

    public ItemClassServiceImpl(ItemClassRepository itemClassRepository,
                                ItemSubclassRepository itemSubclassRepository,
                                ItemClient itemClient){
        this.itemClassRepository = itemClassRepository;
        this.itemSubclassRepository = itemSubclassRepository;
        this.itemClient = itemClient;
    }

    public ItemCollectionDTO getItemClasses() throws URISyntaxException {
        ItemCollectionDTO itemClasses = itemClient.getItemClasses();
        getSubclassesAndSave(itemClasses);
        return itemClasses;
    }

    public ItemClassDTO getItemClass(long id) throws URISyntaxException {
        return itemClient.getItemClass(id);
    }

    public ItemClass getItemClassById(long id){
        Optional<ItemClass> itemClass = itemClassRepository.findById(id);
        return itemClass.get();
    }

    public ItemSubclass getItemSubclassByName(String name, long id){
        return itemSubclassRepository.findByNameAndSubclassId(name, id);
    }

    @Transactional
    private void getSubclassesAndSave(ItemCollectionDTO itemClasses) throws URISyntaxException {
        for (BaseItemDTO itemClass: itemClasses.getItemCollection()) {
            ItemClass item = mapItemClass(itemClass);
            itemClassRepository.save(item);
            ItemClassDTO itemClassDetalis = getItemClass(item.getId());
            for (BaseItemDTO itemSubclass : itemClassDetalis.getItemSubclasses()) {
                itemSubclassRepository.save(mapItemSubclass(itemSubclass, item));
            }
        }
    }


}
