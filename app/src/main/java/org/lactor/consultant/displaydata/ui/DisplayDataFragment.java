package org.lactor.consultant.displaydata.ui;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import org.lactor.consultant.R;
import org.lactor.consultant.core.model.Mother;
import org.lactor.consultant.core.webrequests.LactorApiHelper;
import org.lactor.consultant.dashboard.ui.DashboardAdapter;
import org.lactor.consultant.displaydata.model.BreastfeedEntry;
import org.lactor.consultant.displaydata.model.MorbidityEntry;
import org.lactor.consultant.displaydata.model.OutputEntry;
import org.lactor.consultant.displaydata.model.SupplementEntry;
import org.lactor.consultant.displaydata.webrequests.DiaryDataResponse;
import org.lactor.consultant.homepage.ui.MainActivity;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
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

    private String[] mMotherNames;
    private List<Mother> mMothers;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display_data, container, false);
        view.findViewById(R.id.search_button).setOnClickListener(this);
        mStartDateTextView = (TextView) view.findViewById(R.id.textViewFrom);
        mStartDateTextView.setOnClickListener(this);

        //create an object that gets mothers, store in a list-like array



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

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.search_button:
                String startDate;
                String endDate;
                int MotherID;

                startDate= ((TextView)getView().findViewById(R.id.textViewTo)).getText().toString();
                endDate = ((TextView)getView().findViewById(R.id.textViewFrom)).getText().toString();
                MotherID = mMothers.get(((Spinner)getView().findViewById(R.id.MotherName)).getSelectedItemPosition()).motherId;


                try {
                    DiaryDataResponse response = LactorApiHelper.getInstance().getDiaryData(
                            "AXNTHAUONTUOAENHTOEUA",
                            startDate,
                            endDate,
                            true,
                            true,
                            true,
                            true
                    ).execute().body();
                    ((MainActivity)getActivity()).onRetrievedDiaryInfo(
                            response.breastfeedEntries,
                            response.morbidityEntries,
                            response.outputEntries,
                            response.supplementEntries
                    );

                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
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
        void onRetrievedDiaryInfo(
                List<BreastfeedEntry> breastfeedEntries,
                List<MorbidityEntry> morbidityEntries,
                List<OutputEntry> outputEntries,
                List<SupplementEntry> supplementEntries
        );
    }
}
