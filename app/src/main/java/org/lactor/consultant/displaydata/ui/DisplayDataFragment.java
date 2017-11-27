package org.lactor.consultant.displaydata.ui;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import org.lactor.consultant.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DisplayDataFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DisplayDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplayDataFragment extends Fragment implements View.OnClickListener {
    private TextView mStartDateTextView;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static Calendar filterMethodDateStart = null;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DisplayDataFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DisplayDataFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DisplayDataFragment newInstance(String param1, String param2) {
        DisplayDataFragment fragment = new DisplayDataFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display_data, container, false);

        mStartDateTextView = (TextView) view.findViewById(R.id.textViewFrom);
        mStartDateTextView.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.textViewFrom:
                /*DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        if (DisplayDataFragment.filterMethodDateStart != null) {
                            DisplayDataFragment.filterMethodDateStart.set(year, monthOfYear, dayOfMonth);
                        } else {
                            DisplayDataFragment.filterMethodDateStart = Calendar.getInstance();
                            DisplayDataFragment.filterMethodDateStart.set(year, monthOfYear, dayOfMonth);
                        }

                        String myFormat = "MM/dd/yy"; //In which you need put here
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                        mStartDateTextView.setText(sdf.format(DisplayDataFragment.filterMethodDateStart.getTime()));
                    }
                };

                if (DisplayDataFragment.filterMethodDateStart != null) {
                    Calendar c = DisplayDataFragment.filterMethodDateStart;

                    int year = c.get(Calendar.YEAR);
                    int month = c.get(Calendar.MONTH);
                    int day = c.get(Calendar.DAY_OF_MONTH);

                    new DatePickerDialog(getActivity(), date, year, month, day).show();
                } else {
                    Calendar c = Calendar.getInstance();

                    int year = c.get(Calendar.YEAR);
                    int month = c.get(Calendar.MONTH);
                    int day = c.get(Calendar.DAY_OF_MONTH);

                    new DatePickerDialog(getActivity(), date, year, month, day).show();
                } */
        }
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
