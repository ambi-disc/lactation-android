package org.lactor.consultant.dashboard.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.lactor.consultant.R;

/**
 * Created by nbeesett on 11/21/17.
 */

public class DashboardViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView age;

    public DashboardViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.mother_item_name);
        age = (TextView) itemView.findViewById(R.id.mother_item_age);
    }
}