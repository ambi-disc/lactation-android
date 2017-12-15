package org.lactor.consultant.displaydata.ui.output;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.lactor.consultant.R;

import org.lactor.consultant.displaydata.model.OutputEntry;

import java.util.List;

/**
 * Created by nbeesett on 12/7/17.
 */

public class OutputAdapter extends RecyclerView.Adapter<OutputViewHolder> {
    private List<OutputEntry> mOutputEntries;

    public OutputAdapter(List <OutputEntry> outputEntries){

        mOutputEntries = outputEntries;
    }

    @Override
    public OutputViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_output, null);
        OutputViewHolder viewHolder = new OutputViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OutputViewHolder holder, int position) {
        OutputEntry outputEntry = mOutputEntries.get(position);
        holder.date_output.setText(outputEntry.entryDate);
        holder.urinecolor.setText("Urine Color: " + outputEntry.urinecolor);
        holder.urinesaturation.setText("Urine Saturation: " + outputEntry.urinesaturation);
        holder.stoolcolor.setText("Stool Color: " + "" + outputEntry.stoolcolor);
        holder.stoolconsistency.setText("Stool Consistency: " + outputEntry.stoolconsistency);
        holder.numberofdiapers.setText("Number of Diapers: " +
                (outputEntry.numberdiapers != null ? outputEntry.numberdiapers : "Unknown")
        );

    }

    @Override
    public int getItemCount() {
        System.out.println("****************************** Size: " + mOutputEntries.size());
        return mOutputEntries.size();
    }
}
