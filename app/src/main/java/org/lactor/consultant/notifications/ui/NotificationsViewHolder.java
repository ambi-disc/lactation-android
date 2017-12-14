package org.lactor.consultant.notifications.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.lactor.consultant.R;

/**
 * Created by nbeesett on 12/12/17.
 */

public class NotificationsViewHolder extends RecyclerView.ViewHolder {
    public TextView date;
    public TextView seenByMother;
    public TextView title;
    public TextView body;

    public NotificationsViewHolder(View itemView){
        super(itemView);
        date = (TextView) itemView.findViewById(R.id.date);
        seenByMother = (TextView) itemView.findViewById(R.id.seenByMother);
        title = (TextView) itemView.findViewById(R.id.title);
        body = (TextView) itemView.findViewById(R.id.body);
    }

}
