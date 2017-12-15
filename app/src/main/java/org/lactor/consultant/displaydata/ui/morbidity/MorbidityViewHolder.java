package org.lactor.consultant.displaydata.ui.morbidity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.lactor.consultant.R;

/**
 * Created by nbeesett on 12/7/17.
 */

public class MorbidityViewHolder extends RecyclerView.ViewHolder {
    public TextView date_morbidity;
    public TextView type;


    public MorbidityViewHolder(View itemView){
        super(itemView);
        date_morbidity = (TextView) itemView.findViewById(R.id.date_morbidity);
        type = (TextView) itemView.findViewById(R.id.type);


    }

}
