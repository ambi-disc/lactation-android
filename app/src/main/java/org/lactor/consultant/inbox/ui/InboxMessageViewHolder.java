package org.lactor.consultant.inbox.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.lactor.consultant.R;

/**
 * @Author Matthew Page
 * @Date 11/18/17
 */

public class InboxMessageViewHolder extends RecyclerView.ViewHolder {
    public TextView senderNameTextView;
    public TextView dateTextView;
    public TextView messageTextView;

    public InboxMessageViewHolder(View itemView) {
        super(itemView);
        this.senderNameTextView = (TextView) itemView.findViewById(R.id.message_sender_name_text_view);
        this.dateTextView = (TextView) itemView.findViewById(R.id.date_text_view);
        this.messageTextView = (TextView) itemView.findViewById(R.id.message_text_view);
    }
}
