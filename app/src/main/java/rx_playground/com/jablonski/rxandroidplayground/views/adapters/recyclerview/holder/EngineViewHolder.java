package rx_playground.com.jablonski.rxandroidplayground.views.adapters.recyclerview.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx_playground.com.jablonski.rxandroidplayground.R;
import rx_playground.com.jablonski.rxandroidplayground.model.Engine;
import rx_playground.com.jablonski.rxandroidplayground.model.RowConfig;

/**
 * Created by yabol on 15.05.2017.
 */

public class EngineViewHolder extends BaseDetailViewHolder  {
    Context context;
    @BindView(R.id.engineName)
    TextView engineName;
    @BindView(R.id.engineCompression)
    TextView engineCompression;
    @BindView(R.id.engineCylindersCount)
    TextView engineCylindersCount;
    @BindView(R.id.engineSize)
    TextView engineSize;
    @BindView(R.id.engineDisplacement)
    TextView engineDisplacement;
    @BindView(R.id.engineConfiguration)
    TextView engineConfiguration;
    @BindView(R.id.engineHorsePower)
    TextView engineHorsePower;
    @BindView(R.id.engineTorque)
    TextView engineTorque;

    public EngineViewHolder(View itemView, Context context) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = context;
    }

    @Override
    public void setUp(RowConfig config) {
        this.engineName.setText(this.context.getString(R.string.details_engine_name, config.getValue(Engine.ENGINE_NAME)));
        this.engineCompression.setText(this.context.getString(R.string.details_engine_compression_ration, config.getValue(Engine.ENGINE_COMPRESSION_RATIO)));
        this.engineCylindersCount.setText(this.context.getString(R.string.details_engine_cylinder_count, config.getValue(Engine.ENGINE_CYLINDERS_COUNT)));
        this.engineSize.setText(this.context.getString(R.string.details_engine_size, config.getValue(Engine.ENGINE_SIZE)));
        this.engineConfiguration.setText(this.context.getString(R.string.details_engine_configuration, config.getValue(Engine.ENGINE_CONFIGURATION)));
        this.engineHorsePower.setText(this.context.getString(R.string.details_engine_horse_power, config.getValue(Engine.ENGINE_POWER)));
        this.engineTorque.setText(this.context.getString(R.string.details_engine_torque, config.getValue(Engine.ENGINE_TORQUE)));
        this.engineDisplacement.setText(this.context.getString(R.string.details_engine_displacement, config.getValue(Engine.ENGINE_DISPLACEMENT)));
    }
}
