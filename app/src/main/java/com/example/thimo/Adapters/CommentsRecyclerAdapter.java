package com.example.thimo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thimo.R;
import com.example.thimo.models.Comment;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class CommentsRecyclerAdapter extends RecyclerView.Adapter<CommentsRecyclerAdapter.CommentViewHolder> {
    private final String TAG = "CommentAdapter";
    public List<Comment> comments;
    public Context context;

    public CommentsRecyclerAdapter(Context context, List<Comment> comments) {
        this.context = context;
        this.comments = comments;
    }

    @Override
    public CommentsRecyclerAdapter.CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item, parent, false);
        return new CommentsRecyclerAdapter.CommentViewHolder(v);
    }
    @Override
    public void onBindViewHolder(CommentsRecyclerAdapter.CommentViewHolder holder, int position) {
        holder.itemView.setTag(comments.get(position));
        Comment comment = comments.get(position);

        holder.userName.setText(comment.getUserName());
        holder.userComment.setText(comment.getUserComment());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        public TextView userName;
        public TextView userComment;
        private Context context;

        public CommentViewHolder(final View itemView) {
            super(itemView);
            context = itemView.getContext();
            userName = itemView.findViewById(R.id.txt_userName);
            userComment = itemView.findViewById(R.id.txt_comment);
        }
    }
}
