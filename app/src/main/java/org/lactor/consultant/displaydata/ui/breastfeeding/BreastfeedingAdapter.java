package org.lactor.consultant.displaydata.ui.breastfeeding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.lactor.consultant.R;
import org.lactor.consultant.displaydata.model.BreastfeedEntry;

import java.util.List;

/**
 * @Author Matthew Page
 * @Date 12/7/17
 */

public class BreastfeedingAdapter extends RecyclerView.Adapter<BreastfeedingViewHolder> {
    private List<BreastfeedEntry> mBreastfeedEntries;

    public BreastfeedingAdapter(List<BreastfeedEntry> breastfeedEntries) {
        mBreastfeedEntries = breastfeedEntries;
    }

    @Override
    public BreastfeedingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_breastfeeding, null);
        BreastfeedingViewHolder viewHolder = new BreastfeedingViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BreastfeedingViewHolder holder, int position) {
        BreastfeedEntry breastfeedEntry = mBreastfeedEntries.get(position);
        holder.date.setText(breastfeedEntry.entryDate); // FIXME
        holder.duration.setText("Duration: " + breastfeedEntry.breastfeedingduration);
        holder.infantstate.setText("Infant State: " + breastfeedEntry.infantstate);
        holder.latching.setText("Latching: " + breastfeedEntry.latching);
        holder.maternalproblems.setText("Maternal Problems: " + breastfeedEntry.maternalproblems);
        holder.pumpingamount.setText("Pumping Amount: " + breastfeedEntry.pumpingamount);
        holder.pumpingmethod.setText("Pumping Method: " + breastfeedEntry.pumpingmethod);
        holder.side.setText("Side: " + breastfeedEntry.side);
    }

    @Override
    public int getItemCount() {
        return mBreastfeedEntries.size();
    }
}
