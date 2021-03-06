package rx_playground.com.jablonski.rxandroidplayground.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yabol on 08.04.2017.
 */

public class Model implements Parcelable, ListElement {
    public static final String MODEL_NAME = "modelName";
    public static final String MODEL_DRIVEN_WHEELS = "drivenWheels";
    public static final String MODEL_NUMBER_OF_DOORS = "numberOfDoors";

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("niceName")
    private String niceName;
    @SerializedName("styles")
    private List<Model> submodels;
    @SerializedName("trim")
    private String submodelName;
    private Engine engine;
    private Transmission transmission;
    private Category category;
    private int numberOfDoors;
    private String drivenWheels;


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator<Model>() {

        @Override
        public Model createFromParcel(Parcel source) {
            return new Model(source);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };


    public Model(String name) {
        this.name = name;
    }

    public Model(Parcel in) {
        String[] fields = new String[3];
        in.readStringArray(fields);

        this.id = fields[0];
        this.name = fields[1];
        this.niceName = fields[2];
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{
                this.id,
                this.name,
                this.niceName,
        });
    }

    public void addSubmodel(Model model) {
        if (this.submodels == null) {
            this.submodels = new ArrayList<>();
        }
        this.submodels.add(model);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Model> getSubmodels() {
        return submodels;
    }

    public void setSubmodels(List<Model> submodels) {
        this.submodels = submodels;
    }

    public String getSubmodelName() {
        return submodelName;
    }

    public void setSubmodelName(String submodelName) {
        this.submodelName = submodelName;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getDrivenWheels() {
        return drivenWheels;
    }

    public void setDrivenWheels(String drivenWheels) {
        this.drivenWheels = drivenWheels;
    }

    @Override
    public int getViewType() {
        return 0;
    }

    @Override
    public RowConfig getRowConfig() {
        NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        RowConfig config = new RowConfig();
        config.addValue(MODEL_NAME, this.name);
        config.addValue(MODEL_DRIVEN_WHEELS, this.drivenWheels);
        config.addValue(MODEL_NUMBER_OF_DOORS, integerFormat.format(this.numberOfDoors));
        return config;
    }
}
