package org.lactor.consultant.notifications.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.lactor.consultant.R;

import org.lactor.consultant.notifications.model.LactorNotification;

import java.util.List;

/**
 * Created by nbeesett on 12/12/17.
 */

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsViewHolder> {
    private List<LactorNotification> mNotifications;

    public NotificationsAdapter(List<LactorNotification> notificationsMothers){
        mNotifications= notificationsMothers;
    }

    public NotificationsViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, null);
        NotificationsViewHolder viewHolder = new NotificationsViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(NotificationsViewHolder holder, int position){
        LactorNotification notification = mNotifications.get(position);
        holder.title.setText(notification.title);
        holder.body.setText(notification.description);
        holder.date.setText(notification.date);
        holder.seenByMother.setText(notification.seenByMother ? "Seen by mother" : "Unseen by mother");
    }

    @Override
    public int getItemCount() {
        return mNotifications.size();
    }

}
