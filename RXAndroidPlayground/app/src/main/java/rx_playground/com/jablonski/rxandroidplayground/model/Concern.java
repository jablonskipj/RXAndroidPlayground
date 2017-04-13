package rx_playground.com.jablonski.rxandroidplayground.model;

import java.util.List;

/**
 * Created by yabol on 08.04.2017.
 */

public class Concern {
    int id;
    String name;
    String niceName;
    List<Car> models;

    public Concern(String niceName){
        this.niceName = niceName;
    }
    public Concern(){

    }

    public String getName(){
        return this.name;
    }
    public String getNiceName(){
        return this.niceName;
    }
}
