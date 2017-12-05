package org.lactor.consultant.displaydata.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.lactor.consultant.R;
import org.lactor.consultant.core.model.Mother;
import org.lactor.consultant.displaydata.model.MorbidityEntry;

import java.util.ArrayList;
import java.util.List;

public class DisplayMorbidityDataFragment extends Fragment {
    private static final String ARG_MOTHER = "mother";
    private static final String ARG_ENTRIES = "entries";

    private Mother mMother;
    private List<MorbidityEntry> mMorbidityEntries;

    private OnFragmentInteractionListener mListener;

    public DisplayMorbidityDataFragment() {
        // Required empty public constructor
    }

    public static DisplayMorbidityDataFragment newInstance(Mother mother, ArrayList<MorbidityEntry> morbidityEntries) {
        DisplayMorbidityDataFragment fragment = new DisplayMorbidityDataFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_MOTHER, mother);
        args.putParcelableArrayList(ARG_ENTRIES, morbidityEntries);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMother = getArguments().getParcelable(ARG_MOTHER);
            mMorbidityEntries = getArguments().getParcelableArrayList(ARG_ENTRIES);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_morbidity_data, container, false);
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
