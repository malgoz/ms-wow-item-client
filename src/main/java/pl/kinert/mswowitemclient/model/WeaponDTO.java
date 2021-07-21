package pl.kinert.mswowitemclient.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class WeaponDTO {
    private DamageDTO damage;
    @JsonAlias("attack_speed")
    private DisplayValueDTO attackSpeed;
    private DisplayValueDTO dps;

    public DamageDTO getDamage() {
        return damage;
    }

    public void setDamage(DamageDTO damage) {
        this.damage = damage;
    }

    public DisplayValueDTO getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(DisplayValueDTO attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public DisplayValueDTO getDps() {
        return dps;
    }

    public void setDps(DisplayValueDTO dps) {
        this.dps = dps;
    }
}
