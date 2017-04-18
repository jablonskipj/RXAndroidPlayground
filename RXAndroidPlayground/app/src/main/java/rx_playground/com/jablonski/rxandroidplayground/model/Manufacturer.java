package rx_playground.com.jablonski.rxandroidplayground.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by yabol on 08.04.2017.
 */

public class Manufacturer implements Parcelable {
    int id;
    String name;
    String niceName;
    ArrayList<Car> models;

    public Manufacturer(String niceName){
        this.niceName = niceName;
    }
    public Manufacturer(){

    }

    public void addModel(Car car){
        if(models == null) models = new ArrayList<>();

        models.add(car);
    }

    public String getName(){
        return this.name;
    }
    public String getNiceName(){
        return this.niceName;
    }
    public ArrayList<Car>getModels(){
        return this.models;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator<Manufacturer>(){

        @Override
        public Manufacturer createFromParcel(Parcel source) {
            return new Manufacturer(source);
        }

        @Override
        public Manufacturer[] newArray(int size) {
            return new Manufacturer[size];
        }
    };

    public Manufacturer(Parcel in){
        String [] fields = new String[3];
        in.readStringArray(fields);

        this.id = Integer.parseInt(fields[0]);
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
                String.valueOf(this.id),
                this.name,
                this.niceName
        });
        dest.writeList(models);
    }
}
