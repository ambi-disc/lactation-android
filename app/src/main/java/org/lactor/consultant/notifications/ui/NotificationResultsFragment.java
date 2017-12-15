package org.lactor.consultant.notifications.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.lactor.consultant.R;
import org.lactor.consultant.notifications.model.LactorNotification;

import java.util.ArrayList;
import java.util.List;


public class NotificationResultsFragment extends Fragment {
    private static final String ARG_NOTIFICATION_LIST = "notificationList";

    private List<LactorNotification> mNotificationList;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public NotificationResultsFragment() {
    }

    public static NotificationResultsFragment newInstance(ArrayList<LactorNotification> notificationList) {
        NotificationResultsFragment fragment = new NotificationResultsFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_NOTIFICATION_LIST, notificationList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mNotificationList = getArguments().getParcelableArrayList(ARG_NOTIFICATION_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification_results, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new NotificationsAdapter(mNotificationList);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
