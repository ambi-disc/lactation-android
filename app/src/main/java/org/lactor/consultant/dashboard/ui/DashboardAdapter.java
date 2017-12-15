package org.lactor.consultant.dashboard.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.lactor.consultant.R;
import org.lactor.consultant.core.model.Mother;
import org.lactor.consultant.dashboard.interfaces.SwitchToMother;

import java.util.List;

/**
 * Created by nbeesett on 11/21/17.
 */

public class DashboardAdapter extends RecyclerView.Adapter<DashboardViewHolder> {
    List<Mother> mothers;
    SwitchToMother switchToMotherInterface;

    public DashboardAdapter(List<Mother> mothers, SwitchToMother switchToMotherInterface) {
        this.mothers = mothers;
        this.switchToMotherInterface = switchToMotherInterface;
    }
    @Override
    public DashboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mother, parent, false);
        DashboardViewHolder vh = new DashboardViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(DashboardViewHolder holder, final int position) {
        final Mother mother = mothers.get(position);
        holder.name.setText(mother.name);
        holder.age.setText(mother.age);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Switching to mother " + position);
                switchToMotherInterface.switchToMother(mother);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mothers.size();
    }
}
