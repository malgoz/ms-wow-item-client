package pl.kinert.mswowitemclient.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="item_classes")
public class ItemClass {

    @Id
    private long id;
    private String name;
    @OneToMany
    private List<ItemSubclass> itemSubclasses;

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

    public List<ItemSubclass> getItemSubclasses() {
        return itemSubclasses;
    }

    public void setItemSubclasses(List<ItemSubclass> itemSubclasses) {
        this.itemSubclasses = itemSubclasses;
    }
}
