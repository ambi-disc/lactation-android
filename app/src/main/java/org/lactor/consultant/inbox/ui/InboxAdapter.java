package org.lactor.consultant.inbox.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.lactor.consultant.R;
import org.lactor.consultant.core.util.DateUtils;
import org.lactor.consultant.inbox.model.InboxMessage;

import java.util.List;

/**
 * @Author Matthew Page
 * @Date 11/18/17
 */

public class InboxAdapter extends RecyclerView.Adapter<InboxMessageViewHolder> {
    private List<InboxMessage> mMessages;

    public InboxAdapter(List<InboxMessage> inboxMessages) {
        mMessages = inboxMessages;
    }

    @Override
    public InboxMessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, null);
        InboxMessageViewHolder viewHolder = new InboxMessageViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(InboxMessageViewHolder holder, int position) {
        InboxMessage message = mMessages.get(position);
        holder.messageTextView.setText(message.getMessage());
        holder.senderNameTextView.setText(message.getSenderName());
        holder.dateTextView.setText(DateUtils.timestampToString(message.getMessageSendTimestamp()));
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }
}
