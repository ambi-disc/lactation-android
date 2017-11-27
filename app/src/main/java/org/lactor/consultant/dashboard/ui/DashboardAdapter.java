package org.lactor.consultant.dashboard.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.lactor.consultant.R;

import java.util.ArrayList;

/**
 * Created by nbeesett on 11/21/17.
 */

public class DashboardAdapter extends RecyclerView.Adapter<DashboardViewHolder> {
    ArrayList<String> personNames;

    public DashboardAdapter(ArrayList<String> personNames) {
        this.personNames = personNames;
    }
    @Override
    public DashboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mother, parent, false);
        DashboardViewHolder vh = new DashboardViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(DashboardViewHolder holder, final int position) {
        holder.name.setText(personNames.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
            }
        });
    }
    @Override
    public int getItemCount() {
        return personNames.size();
    }
}
