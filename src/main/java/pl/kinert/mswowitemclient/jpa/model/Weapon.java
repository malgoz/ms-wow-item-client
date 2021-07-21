package pl.kinert.mswowitemclient.jpa.model;

import javax.persistence.*;

@Entity
@Table(name="weapons")
public class Weapon {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="min_value")
    private int minDamageValue;
    @Column(name="max_value")
    private int maxDamageValue;
    private String damageClass;
    private double attackSpeed;
    private String attackSpeedTxt;
    private double dps;
    private String dpsTxt;
    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMinDamageValue() {
        return minDamageValue;
    }

    public void setMinDamageValue(int minDamageValue) {
        this.minDamageValue = minDamageValue;
    }

    public int getMaxDamageValue() {
        return maxDamageValue;
    }

    public void setMaxDamageValue(int maxDamageValue) {
        this.maxDamageValue = maxDamageValue;
    }

    public String getDamageClass() {
        return damageClass;
    }

    public void setDamageClass(String damageClass) {
        this.damageClass = damageClass;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public String getAttackSpeedTxt() {
        return attackSpeedTxt;
    }

    public void setAttackSpeedTxt(String attackSpeedTxt) {
        this.attackSpeedTxt = attackSpeedTxt;
    }

    public double getDps() {
        return dps;
    }

    public void setDps(double dps) {
        this.dps = dps;
    }

    public String getDpsTxt() {
        return dpsTxt;
    }

    public void setDpsTxt(String dpsTxt) {
        this.dpsTxt = dpsTxt;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
