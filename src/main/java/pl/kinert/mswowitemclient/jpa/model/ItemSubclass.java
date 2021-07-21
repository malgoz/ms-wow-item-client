package pl.kinert.mswowitemclient.jpa.model;

import javax.persistence.*;

@Entity
@Table(name="item_subclasses")
public class ItemSubclass {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private long subclassId;
    @ManyToOne
    @JoinColumn(name = "item_class_id")
    private ItemClass itemClass;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemClass getItemClass() {
        return itemClass;
    }

    public void setItemClass(ItemClass itemClass) {
        this.itemClass = itemClass;
    }

    public long getSubclassId() {
        return subclassId;
    }

    public void setSubclassId(long subclassId) {
        this.subclassId = subclassId;
    }
}
