package rx_playground.com.jablonski.rxandroidplayground.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;



import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.contracts.BaseViewCotract;
import rx_playground.com.jablonski.rxandroidplayground.contracts.ConcernsViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Concern;
import rx_playground.com.jablonski.rxandroidplayground.utils.images.ResourcesUtils;

/**
 * Created by yabol on 12.04.2017.
 */

public class ConcernListAdapter extends RecyclerView.Adapter<ConcernListAdapter.ViewHolder> {
    private BaseViewCotract.BaseProvider<Concern> provider;
    private BaseViewCotract.BaseOnItemCLickListener<Concern> onClickListener;
    private Context context;
    public ConcernListAdapter(Context context, BaseViewCotract.BaseProvider<Concern> provider){
        this.provider = provider;
        this.context = context;
    }

    public void setOnClickListener(BaseViewCotract.BaseOnItemCLickListener<Concern> onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.concern_list_row, parent, false);

        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(holder != null){
            final Concern concern = provider.getObject(position);
            if(concern != null){
                holder.concernName.setText(concern.getNiceName());
                Picasso.with(context).
                        load(ResourcesUtils.getDrawableIDByName(context, concern.getNiceName())).
                        memoryPolicy(MemoryPolicy.NO_STORE).
                        fit().centerInside().
                        into(holder.concernLogo);
                if(this.onClickListener != null){
                    holder.rowView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onClickListener.performClick(concern);
                        }
                    });
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return provider.getCount();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.concernLogo)
        ImageView concernLogo;

        @BindView(R.id.concernName)
        TextView concernName;
        View rowView;
        public ViewHolder(View view){
            super(view);
            this.rowView = view;
            ButterKnife.bind(this, view);
        }
    }
}