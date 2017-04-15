package rx_playground.com.jablonski.rxandroidplayground.contracts;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import rx_playground.com.jablonski.rxandroidplayground.model.Car;
import rx_playground.com.jablonski.rxandroidplayground.model.Concern;
import rx_playground.com.jablonski.rxandroidplayground.model.Result;

/**
 * Created by yabol on 06.04.2017.
 */

public class ViewContract {

    public interface View{
        void showView(List<Concern> concerns);
        void loadElements();
        void showListFragment(List<Car> elements);
    }

    public interface Presenter<T>{
        void loadElemetnts(String year);
        void displayElements(List<T> elements);
        List<T> getElements();
    }
    public interface Repository{
        void getConcerns(String year);
    }
    public interface Provider<T>{
        int getCount();
        int getId(int position);
        T getObject(int position);
    }
    public interface ListItemClickListener<T>{
        void performClick(T item);
    }
}
