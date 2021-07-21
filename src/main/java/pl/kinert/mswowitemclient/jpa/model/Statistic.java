package pl.kinert.mswowitemclient.jpa.model;

import javax.persistence.*;

@Entity
@Table(name="statistics")
public class Statistic {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private int value;
    private String type;
    @ManyToOne
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
