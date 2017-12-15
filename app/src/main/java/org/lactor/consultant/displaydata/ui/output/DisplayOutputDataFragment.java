package org.lactor.consultant.displaydata.ui.output;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.lactor.consultant.R;
import org.lactor.consultant.core.model.Mother;
import org.lactor.consultant.displaydata.model.OutputEntry;


import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DisplayOutputDataFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DisplayOutputDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplayOutputDataFragment extends Fragment {
    private static final String ARG_MOTHER = "mother";
    private static final String ARG_ENTRIES = "entries";

    private Mother mMother;
    private List<OutputEntry> mOutputEntries;

    private DisplayOutputDataFragment.OnFragmentInteractionListener mListener;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public DisplayOutputDataFragment() {
        // Required empty public constructor
    }

    public static DisplayOutputDataFragment newInstance(Mother mother, ArrayList<OutputEntry> breastfeedEntries) {
        DisplayOutputDataFragment fragment = new DisplayOutputDataFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_MOTHER, mother);
        args.putParcelableArrayList(ARG_ENTRIES, breastfeedEntries);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMother = getArguments().getParcelable(ARG_MOTHER);
            mOutputEntries = getArguments().getParcelableArrayList(ARG_ENTRIES);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_output_data, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.output_recycler_view);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new OutputAdapter(mOutputEntries);
        mRecyclerView.setAdapter(mAdapter);
        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
