package pl.kinert.mswowitemclient.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class DamageDTO {

    @JsonAlias("min_value")
    private int minValue;
    @JsonAlias("max_value")
    private int maxValue;
    @JsonAlias("damage_class")
    private TypeDTO damageClass;

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public TypeDTO getDamageClass() {
        return damageClass;
    }

    public void setDamageClass(TypeDTO damageClass) {
        this.damageClass = damageClass;
    }
}
