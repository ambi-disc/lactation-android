package org.lactor.consultant.displaydata.ui.morbidity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.lactor.consultant.R;
import org.lactor.consultant.displaydata.model.MorbidityEntry;

import java.util.List;

/**
 * Created by nbeesett on 12/7/17.
 */

public class MorbidityAdapter extends RecyclerView.Adapter<MorbidityViewHolder> {
    private List<MorbidityEntry> mMorbidityEntries;

    public MorbidityAdapter(List <MorbidityEntry> morbidityEntries){
        mMorbidityEntries = morbidityEntries;
    }

    @Override
    public MorbidityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_morbidity, null);
        MorbidityViewHolder viewHolder = new MorbidityViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(MorbidityViewHolder holder, int position){
        MorbidityEntry morbidityEntry = mMorbidityEntries.get(position);
        holder.date_morbidity.setText("Dec 06 2018");
        holder.type.setText("Type: " + morbidityEntry.type);

    }

    @Override
    public int getItemCount() { return mMorbidityEntries.size();}

}
