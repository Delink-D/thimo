package com.example.thimo.ui.dialog;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.thimo.Adapters.CommentsRecyclerAdapter;
import com.example.thimo.R;
import com.example.thimo.models.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class FullScreenDialogFragment extends DialogFragment {

    public static String TAG = "FullScreenDialog";
    RecyclerView commentRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Comment> comments;

    // actions
    LinearLayout commentLikeLayout;
    ImageView commentLike;
    Boolean hasUserLiked = false;

    private String proverb;

    public static FullScreenDialogFragment newInstance(String title) {
        FullScreenDialogFragment dialog = new FullScreenDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        dialog.setArguments(args);
        Log.d(TAG, "Data:" + args);
        return dialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = getActivity();
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
        proverb = getArguments() != null ? getArguments().getString("title") : null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_full_screen_dialog, container, false);
        commentLikeLayout = view.findViewById(R.id.layout_like);
        commentLike = view.findViewById(R.id.comment_like);

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
        comments.add(new Comment("John Doh", "Some cool comment about this proverb"));
        comments.add(new Comment("John Doh", "Some cool comment about this proverb"));
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
