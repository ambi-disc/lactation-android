package org.lactor.consultant.displaydata.ui.breastfeeding;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.lactor.consultant.R;

/**
 * @Author Matthew Page
 * @Date 12/7/17
 */

public class BreastfeedingViewHolder extends RecyclerView.ViewHolder {
    public TextView date;
    public TextView duration;
    public TextView infantstate;
    public TextView latching;
    public TextView maternalproblems;
    public TextView pumpingamount;
    public TextView pumpingmethod;
    public TextView side;

    public BreastfeedingViewHolder(View itemView) {
        super(itemView);
        date = (TextView) itemView.findViewById(R.id.date_breastfeeding);
        duration = (TextView) itemView.findViewById(R.id.duration);
        infantstate = (TextView) itemView.findViewById(R.id.infantstate);
        latching = (TextView) itemView.findViewById(R.id.latching);
        maternalproblems = (TextView) itemView.findViewById(R.id.maternalproblems);
        pumpingamount = (TextView) itemView.findViewById(R.id.pumpingamount);
        pumpingmethod = (TextView) itemView.findViewById(R.id.pumpingmethod);
        side = (TextView) itemView.findViewById(R.id.side);
    }
}
