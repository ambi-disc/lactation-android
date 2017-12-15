package org.lactor.consultant.displaydata.ui.supplement;

import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;

import org.lactor.consultant.R;

/**
 * Created by nbeesett on 12/7/17.
 */

public class SupplementViewHolder extends RecyclerView.ViewHolder {

    public TextView date_supplement;
    public TextView suptype;
    public TextView supmethod;
    public TextView numberofdiapers;
    public TextView totalamount;
    public TextView numberoftimes;

    public SupplementViewHolder(View itemView){
        super(itemView);
        date_supplement = (TextView) itemView.findViewById(R.id.date_supplement);
        suptype= (TextView) itemView.findViewById(R.id.suptype);
        supmethod = (TextView) itemView.findViewById(R.id.supmethod);
        numberofdiapers = (TextView) itemView.findViewById(R.id.numberofdiapers);
        totalamount = (TextView) itemView.findViewById(R.id.totalamount);
        numberoftimes = (TextView) itemView.findViewById(R.id.numberoftimes);


    }
}
