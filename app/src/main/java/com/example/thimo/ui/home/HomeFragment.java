package com.example.thimo.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thimo.Adapters.CustomRecyclerAdapter;
import com.example.thimo.R;
import com.example.thimo.models.Thimo;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    final String TAG = "FragmentHome";

    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    List<Thimo> thimoUtilsList;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
//        final Text/View textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        recyclerView = root.findViewById(R.id.proverb_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        thimoUtilsList = new ArrayList<>();
        thimoUtilsList.add(new Thimo("Sample kikuyu proverb 0"));
        thimoUtilsList.add(new Thimo("Sample kikuyu proverb 1"));
        thimoUtilsList.add(new Thimo("Sample kikuyu proverb 2"));
        thimoUtilsList.add(new Thimo("Sample kikuyu proverb 3"));
        thimoUtilsList.add(new Thimo("Sample kikuyu proverb 4"));
        thimoUtilsList.add(new Thimo("Sample kikuyu proverb 5"));
        thimoUtilsList.add(new Thimo("Sample kikuyu proverb 6"));
        thimoUtilsList.add(new Thimo("Sample kikuyu proverb 7"));
        thimoUtilsList.add(new Thimo("Sample kikuyu proverb 8"));
        thimoUtilsList.add(new Thimo("Sample kikuyu proverb 9"));
        thimoUtilsList.add(new Thimo("Sample kikuyu proverb 10"));
        thimoUtilsList.add(new Thimo("Sample kikuyu proverb 11"));
        thimoUtilsList.add(new Thimo("Sample kikuyu proverb 12"));
        thimoUtilsList.add(new Thimo("Sample kikuyu proverb 13"));
        thimoUtilsList.add(new Thimo("Sample kikuyu proverb 14"));
        thimoUtilsList.add(new Thimo("Sample kikuyu proverb 15"));

        Log.d(TAG, "List of thimos::" + thimoUtilsList.size());

        mAdapter = new CustomRecyclerAdapter(getContext(), thimoUtilsList);
        recyclerView.setAdapter(mAdapter);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return root;
    }
}