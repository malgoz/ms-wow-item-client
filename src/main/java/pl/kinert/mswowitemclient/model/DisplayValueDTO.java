package pl.kinert.mswowitemclient.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class DisplayValueDTO {
    private double value;
    @JsonAlias("display_string")
    private String displayString;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDisplayString() {
        return displayString;
    }

    public void setDisplayString(String displayString) {
        this.displayString = displayString;
    }
}
