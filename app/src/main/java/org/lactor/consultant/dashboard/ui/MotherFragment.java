package org.lactor.consultant.dashboard.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.lactor.consultant.R;
import org.lactor.consultant.core.model.Mother;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MotherFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MotherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MotherFragment extends Fragment {
    private static final String MOTHER_ARG = "mother";

    private Mother mMother;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MotherFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MotherFragment newInstance(Mother mother) {
        MotherFragment fragment = new MotherFragment();
        Bundle args = new Bundle();
        args.putParcelable(MOTHER_ARG, mother);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMother = getArguments().getParcelable(MOTHER_ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mother, container, false);
        ((TextView)view.findViewById(R.id.mother_fragment_name)).setText(mMother.name);
        ((TextView)view.findViewById(R.id.mother_fragment_age)).setText(mMother.age);
        ((TextView)view.findViewById(R.id.mother_fragment_ethnicity)).setText(mMother.ethnicity);
        ((TextView)view.findViewById(R.id.mother_fragment_race)).setText(mMother.race);
        ((TextView)view.findViewById(R.id.mother_fragment_residence)).setText(mMother.residence);
        ((TextView)view.findViewById(R.id.mother_fragment_mhdp)).setText(mMother.mhdp);
        ((TextView)view.findViewById(R.id.mother_fragment_delivery)).setText(mMother.methodOfDelivery);
        ((TextView)view.findViewById(R.id.mother_fragment_pbe)).setText(mMother.pbe);
        ((TextView)view.findViewById(R.id.mother_fragment_phone)).setText(mMother.phone);
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
