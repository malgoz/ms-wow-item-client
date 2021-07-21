package pl.kinert.mswowitemclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.kinert.mswowitemclient.model.ItemDTO;
import pl.kinert.mswowitemclient.model.ItemClassDTO;
import pl.kinert.mswowitemclient.model.ItemCollectionDTO;
import pl.kinert.mswowitemclient.service.ItemClassService;
import pl.kinert.mswowitemclient.service.ItemService;

import java.net.URISyntaxException;

@RestController
public class ItemRestController {

    private final ItemClassService itemClassService;

    private final ItemService itemService;

    public ItemRestController(
            ItemClassService itemClassService,
            ItemService itemService
    ){
        this.itemClassService = itemClassService;
        this.itemService = itemService;
    }

    @GetMapping("/item-class")
    public ItemCollectionDTO getItemClasses() throws URISyntaxException {
        return itemClassService.getItemClasses();
    }

    @GetMapping("/item-class/{id}")
    public ItemClassDTO getItemClass(@PathVariable long id) throws URISyntaxException {
        return itemClassService.getItemClass(id);
    }

    @GetMapping("/item/{id}")
    public ItemDTO getItemById(@PathVariable long id) throws URISyntaxException {
        return itemService.getItemById(id);
    }

}
