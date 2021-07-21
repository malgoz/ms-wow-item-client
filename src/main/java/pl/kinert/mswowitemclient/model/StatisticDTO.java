package pl.kinert.mswowitemclient.model;

public class StatisticDTO {
    private TypeDTO type;
    private int value;

    public TypeDTO getType() {
        return type;
    }

    public void setType(TypeDTO type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
