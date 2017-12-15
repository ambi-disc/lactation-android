package org.lactor.consultant.displaydata.ui.supplement;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.lactor.consultant.R;
import org.lactor.consultant.core.model.Mother;
import org.lactor.consultant.displaydata.model.SupplementEntry;

import java.util.ArrayList;
import java.util.List;

public class DisplaySupplementDataFragment extends Fragment {
    private static final String ARG_MOTHER = "mother";
    private static final String ARG_ENTRIES = "entries";

    private Mother mMother;
    private List<SupplementEntry> mSupplementEntries;

    private DisplaySupplementDataFragment.OnFragmentInteractionListener mListener;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public DisplaySupplementDataFragment() {
        // Required empty public constructor
    }

    public static DisplaySupplementDataFragment newInstance(Mother mother, ArrayList<SupplementEntry> supplementEntries) {
        DisplaySupplementDataFragment fragment = new DisplaySupplementDataFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_MOTHER, mother);
        args.putParcelableArrayList(ARG_ENTRIES, supplementEntries);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMother = getArguments().getParcelable(ARG_MOTHER);
            mSupplementEntries = getArguments().getParcelableArrayList(ARG_ENTRIES);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_display_supplement_data, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.supplement_recycler_view);

        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new SupplementAdapter(mSupplementEntries);
        mRecyclerView.setAdapter(mAdapter);

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
