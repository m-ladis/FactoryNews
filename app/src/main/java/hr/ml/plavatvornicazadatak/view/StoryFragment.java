package hr.ml.plavatvornicazadatak.view;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hr.ml.plavatvornicazadatak.R;

public class StoryFragment extends BaseFragment implements StoryIFragment {

    public StoryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_story, container, false);
    }
}