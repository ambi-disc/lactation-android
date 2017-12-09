package org.lactor.consultant.displaydata.ui.output;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.lactor.consultant.R;

/**
 * Created by nbeesett on 12/7/17.
 */

public class OutputViewHolder extends RecyclerView.ViewHolder {
    public TextView date_output;
    public TextView urinecolor;
    public TextView urinesaturation;
    public TextView stoolcolor;
    public TextView stoolconsistency;
    public TextView numberofdiapers;


    public OutputViewHolder(View itemView){
        super(itemView);
        date_output = (TextView) itemView.findViewById(R.id.date_output);
        urinecolor = (TextView) itemView.findViewById(R.id.urinecolor);
        urinesaturation = (TextView) itemView.findViewById(R.id.urinesaturation);
        stoolcolor = (TextView) itemView.findViewById(R.id.stoolcolor);
        stoolconsistency = (TextView) itemView.findViewById(R.id.stoolconsistency);
        numberofdiapers = (TextView) itemView.findViewById(R.id.numberdiapers);
    }

}
