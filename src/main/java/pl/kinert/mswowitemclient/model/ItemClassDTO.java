package pl.kinert.mswowitemclient.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class ItemClassDTO extends BaseItemDTO {

    @JsonAlias("item_subclasses")
    List<BaseItemDTO> itemSubclasses;

    public List<BaseItemDTO> getItemSubclasses() {
        return itemSubclasses;
    }

    public void setItemSubclasses(List<BaseItemDTO> itemSubclasses) {
        this.itemSubclasses = itemSubclasses;
    }
}
