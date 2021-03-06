package rx_playground.com.jablonski.rxandroidplayground.model;

/**
 * Created by yabol on 11.05.2017.
 */

public class Transmission implements ListElement {
    public static final String TRANSMISSION_NAME = "transmissionName";
    public static final String TRANSMISSION_TYPE = "transmissionType";

    private String id;
    private String name;
    private String transmissionType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    @Override
    public int getViewType() {
        return 3;
    }

    @Override
    public RowConfig getRowConfig() {
        RowConfig config = new RowConfig();
        config.addValue(TRANSMISSION_NAME, this.name);
        config.addValue(TRANSMISSION_TYPE, this.transmissionType);
        return config;
    }
}
