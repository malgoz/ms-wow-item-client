package pl.kinert.mswowitemclient.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class ItemCollectionDTO {

    @JsonAlias({"item_classes", "item_sets"})
    private List<BaseItemDTO> itemCollection;

    public List<BaseItemDTO> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(List<BaseItemDTO> itemCollection) {
        this.itemCollection = itemCollection;
    }
}
