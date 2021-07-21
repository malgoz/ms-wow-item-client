package pl.kinert.mswowitemclient.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class ItemDTO extends BaseItemDTO {

    private TypeDTO quality;
    private int level;
    @JsonAlias("required_level")
    private int requiredLevel;
    @JsonAlias("item_class")
    private ItemClassDTO itemClass;
    @JsonAlias("item_subclass")
    private BaseItemDTO itemSubclass;
    @JsonAlias("inventory_type")
    private TypeDTO inventoryType;
    @JsonAlias("purchase_price")
    private long purchasePrice;
    @JsonAlias("sell_price")
    private long sellPrice;
    @JsonAlias("preview_item")
    private ItemDetailsDTO itemDetails;

    public TypeDTO getQuality() {
        return quality;
    }

    public void setQuality(TypeDTO quality) {
        this.quality = quality;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public ItemClassDTO getItemClass() {
        return itemClass;
    }

    public void setItemClass(ItemClassDTO itemClass) {
        this.itemClass = itemClass;
    }

    public BaseItemDTO getItemSubclass() {
        return itemSubclass;
    }

    public void setItemSubclass(BaseItemDTO itemSubclass) {
        this.itemSubclass = itemSubclass;
    }

    public TypeDTO getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(TypeDTO inventoryType) {
        this.inventoryType = inventoryType;
    }

    public long getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(long purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public long getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(long sellPrice) {
        this.sellPrice = sellPrice;
    }

    public ItemDetailsDTO getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(ItemDetailsDTO itemDetails) {
        this.itemDetails = itemDetails;
    }
}
