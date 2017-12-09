package org.lactor.consultant.displaydata.ui.supplement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.lactor.consultant.R;
import org.lactor.consultant.displaydata.model.SupplementEntry;

import android.support.v7.widget.RecyclerView;
import java.util.List;


/**
 * Created by nbeesett on 12/7/17.
 */

public class SupplementAdapter extends RecyclerView.Adapter<SupplementViewHolder> {
    private List<SupplementEntry> mSupplementEntries;

    public SupplementAdapter(List<SupplementEntry> supplementEntries){
        mSupplementEntries = supplementEntries;

    }

    @Override
    public SupplementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_supplement, null);
        SupplementViewHolder viewHolder = new SupplementViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SupplementViewHolder holder, int position) {
        SupplementEntry supplementEntry = mSupplementEntries.get(position);
        holder.date_supplement.setText("Dec 5 2018");
        holder.suptype.setText("Supplement Type: " + supplementEntry.suptype);
        holder.supmethod.setText("Supplement Method: " + supplementEntry.supmethod);
        holder.numberofdiapers.setText("Number of diapers: " + supplementEntry.numberdiapers);
        holder.totalamount.setText("Total Amount: " + supplementEntry.totalamount);
        holder.numberoftimes.setText("Number of Times: " + supplementEntry.numbertimes);


    }

    @Override
    public int getItemCount() { return mSupplementEntries.size();}
}
