package org.lactor.consultant.inbox.ui.tabfragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.lactor.consultant.R;
import org.lactor.consultant.core.model.Mother;
import org.lactor.consultant.core.webrequests.LactorApiHelper;

import java.io.IOException;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ComposeInboxFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ComposeInboxFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ComposeInboxFragment extends Fragment {
    private static final String ARG_MOTHER = "mother";
    private TextView mStartDateTextView;

    private Mother mMother;
    private String[] mMotherNames;
    private List<Mother> mMothers;


    private OnFragmentInteractionListener mListener;

    public ComposeInboxFragment() {
        // Required empty public constructor
    }

    public static ComposeInboxFragment newInstance(Mother mother) {
        ComposeInboxFragment fragment = new ComposeInboxFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_MOTHER, mother);
        fragment.setArguments(args);
        return fragment;
    }

    public static ComposeInboxFragment newInstance() {
        ComposeInboxFragment fragment = new ComposeInboxFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compose_inbox, container, false);


        try {
            // TODO this is kinda bad, you should throw this into an async talk when you have time.
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            mMothers = LactorApiHelper.getInstance().getListOfMothers("AXNTHAUONTUOAENHTOEUA").execute().body().mothers;
            for(int i=0; i < mMothers.size(); i++){
                Mother mother = mMothers.get(i);
                if(mother == null || mother.name == null) {
                    mMothers.remove(i);
                    i--;
                }
            }
            mMotherNames = new String[mMothers.size()];
            for(int i=0; i < mMothers.size(); i++){
                mMotherNames[i] = mMothers.get(i).name;
            }
            Spinner s = (Spinner) view.findViewById(R.id.motherInformation);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),
                    android.R.layout.simple_spinner_item, mMotherNames);
            s.setAdapter(adapter);
        } catch (IOException e) {
            e.printStackTrace();
        }



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
