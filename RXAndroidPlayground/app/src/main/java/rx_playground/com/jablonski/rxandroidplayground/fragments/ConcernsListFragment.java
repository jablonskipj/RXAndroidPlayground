package rx_playground.com.jablonski.rxandroidplayground.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.MainActivity;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.contracts.BaseViewCotract;
import rx_playground.com.jablonski.rxandroidplayground.contracts.ConcernsViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Car;
import rx_playground.com.jablonski.rxandroidplayground.model.Concern;
import rx_playground.com.jablonski.rxandroidplayground.presenters.ConcernsListPresenter;
import rx_playground.com.jablonski.rxandroidplayground.repositories.ConcernsRepository;
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.ConcernListAdapter;

/**
 * Created by yabol on 06.04.2017.
 */

public class ConcernsListFragment extends Fragment implements ConcernsViewContract.View<Concern>{
    private ConcernsListPresenter presenter;
    private ConcernListAdapter adapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    MainActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        activity = (MainActivity) getActivity();
        if(this.presenter == null){
            this.presenter = new ConcernsListPresenter(this);
            ConcernsRepository repository = new ConcernsRepository(this.presenter);
            //ConcernsRepositoryMock repository = new ConcernsRepositoryMock(presenter);
            this.presenter.setRepository(repository);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cars_list, container, false);
        ButterKnife.bind(this, view);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(savedInstanceState != null && savedInstanceState.getParcelableArrayList("Concerns") != null){
            presenter.displayElements(savedInstanceState.<Concern>getParcelableArrayList("Concerns"));
        }else {
            loadElements();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("Concerns", (ArrayList<? extends Parcelable>) presenter.getElements());
    }

    @Override
    public void showView(List<Concern> concerns) {
        if(this.adapter == null){
            this.adapter = new ConcernListAdapter(getContext(), this.presenter);
            this.adapter.setOnClickListener(this.presenter);
        }
        if(this.recyclerView.getAdapter() == null){
            this.recyclerView.setAdapter(this.adapter);
        }
        this.adapter.notifyDataSetChanged();

    }



    @Override
    public void loadElements() {
        this.presenter.loadElemetnts("2005");
    }

    @Override
    public void showListFragment(List<Car> elements) {
        CarsListFragment fragment = new CarsListFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("Cars", (ArrayList<? extends Parcelable>) elements);
        fragment.setArguments(bundle);
        activity.startFragment(fragment, false);
    }

}