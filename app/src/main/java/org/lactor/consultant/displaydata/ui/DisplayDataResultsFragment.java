package org.lactor.consultant.displaydata.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.lactor.consultant.R;
import org.lactor.consultant.core.model.Mother;
import org.lactor.consultant.displaydata.model.BreastfeedEntry;
import org.lactor.consultant.displaydata.model.MorbidityEntry;
import org.lactor.consultant.displaydata.model.OutputEntry;
import org.lactor.consultant.displaydata.model.SupplementEntry;

import java.util.ArrayList;
import java.util.List;

public class DisplayDataResultsFragment extends Fragment {

    private static final String ARG_MOTHER = "mother";
    private static final String ARG_BREASTFEED_ENTRY_LIST = "breastfeed entry list";
    private static final String ARG_SUPPLEMENTENT_LIST = "supplement entry list";
    private static final String ARG_OUTPUT_ENTRY_LIST = "output entry list";
    private static final String ARG_MORBIDITY_ENTRY_LIST = "morbidity entry list";


    private Mother mMother;
    private List<BreastfeedEntry> mBreastfeedEntryList;
    private List<SupplementEntry> mSupplementEntryList;
    private List<OutputEntry> mOutputEntryList;
    private List<MorbidityEntry> mMorbidityEntryList;

    private OnFragmentInteractionListener mListener;

    public DisplayDataResultsFragment() {
        // Required empty public constructor
    }

    public static DisplayDataResultsFragment newInstance(Mother mother,
                                                         ArrayList<BreastfeedEntry> breastfeedEntryList,
                                                         ArrayList<SupplementEntry> supplementEntryList,
                                                         ArrayList<OutputEntry> outputEntryList,
                                                         ArrayList<MorbidityEntry> morbidityEntryList) {
        DisplayDataResultsFragment fragment = new DisplayDataResultsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_MOTHER, mother);
        args.putParcelableArrayList(ARG_BREASTFEED_ENTRY_LIST, breastfeedEntryList);
        args.putParcelableArrayList(ARG_SUPPLEMENTENT_LIST, supplementEntryList);
        args.putParcelableArrayList(ARG_OUTPUT_ENTRY_LIST, outputEntryList);
        args.putParcelableArrayList(ARG_MORBIDITY_ENTRY_LIST, morbidityEntryList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMother = getArguments().getParcelable(ARG_MOTHER);
            mBreastfeedEntryList = getArguments().getParcelableArrayList(ARG_BREASTFEED_ENTRY_LIST);
            mSupplementEntryList = getArguments().getParcelableArrayList(ARG_SUPPLEMENTENT_LIST);
            mOutputEntryList = getArguments().getParcelableArrayList(ARG_OUTPUT_ENTRY_LIST);
            mMorbidityEntryList = getArguments().getParcelableArrayList(ARG_MORBIDITY_ENTRY_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display_data_results, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        TabLayout tabs = (TabLayout) view.findViewById(R.id.result_tabs);
        tabs.setupWithViewPager(viewPager);
        return view;
    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        DisplayDataResultsFragment.Adapter adapter = new DisplayDataResultsFragment.Adapter(getChildFragmentManager());
        adapter.addFragment(
                DisplayBreastfeedingDataFragment.newInstance(
                        mMother,
                        new ArrayList<>(mBreastfeedEntryList)),
                "Breastfeeding"
        );
        adapter.addFragment(
                DisplaySupplementDataFragment.newInstance(
                        mMother,
                        new ArrayList<>(mSupplementEntryList)),
                "Supplement"
        );
        adapter.addFragment(
                DisplayOutputDataFragment.newInstance(
                        mMother,
                        new ArrayList<>(mOutputEntryList)),
                "Output"
        );
        adapter.addFragment(
                DisplayMorbidityDataFragment.newInstance(
                        mMother,
                        new ArrayList<>(mMorbidityEntryList)),
                "Morbidity"
        );
        viewPager.setAdapter(adapter);
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

    static class Adapter extends FragmentPagerAdapter {
        private final List<android.support.v4.app.Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(android.support.v4.app.Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
