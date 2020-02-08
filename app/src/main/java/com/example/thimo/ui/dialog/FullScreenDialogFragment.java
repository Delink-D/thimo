package com.example.thimo.ui.dialog;


import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thimo.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class FullScreenDialogFragment extends DialogFragment {

    public static  String TAG = "FullScreenDialog";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_full_screen_dialog, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_close_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        toolbar.setTitle(proverb);

        commentRecyclerView = view.findViewById(R.id.comments_recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        commentRecyclerView.setLayoutManager(layoutManager);

        comments = new ArrayList<>();

        // adding comments to comments array
        comments.add(new Comment("John Doh", "Some cool comment about this proverb"));


        mAdapter = new CommentsRecyclerAdapter(getActivity(), comments);
        commentRecyclerView.setAdapter(mAdapter);

        // toggle the like icon
        commentLikeLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (!hasUserLiked) {
                    hasUserLiked = true;
                    commentLike.setImageResource(R.drawable.ic_favorite_liked_24dp);
                } else {
                    hasUserLiked = false;
                    commentLike.setImageResource(R.drawable.ic_favorite_black_24dp);
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            Objects.requireNonNull(dialog.getWindow()).setLayout(width, height);
        }
    }
}
