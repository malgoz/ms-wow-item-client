package pl.kinert.mswowitemclient.jpa.model;

import javax.persistence.*;

@Entity
@Table(name="armors")
public class Armor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private int value;
    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
