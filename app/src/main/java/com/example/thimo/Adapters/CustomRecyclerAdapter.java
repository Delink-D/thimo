package com.example.thimo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thimo.R;
import com.example.thimo.models.Thimo;
import com.example.thimo.ui.dialog.FullScreenDialogFragment;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ProverbsViewHolder> {
    private Context context;
    private List<Thimo> thimoUtils;

    public CustomRecyclerAdapter(Context context, List thimoUtils) {
        this.context = context;
        this.thimoUtils = thimoUtils;
    }
    @Override
    public CustomRecyclerAdapter.ProverbsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.proverb_item, parent, false);
        ProverbsViewHolder viewHolder = new ProverbsViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProverbsViewHolder holder, int position) {
        holder.itemView.setTag(thimoUtils.get(position));

        Thimo thimo = thimoUtils.get(position);

        holder.proverb.setText(thimo.getProverb());
    }

    @Override
    public int getItemCount() {
        return thimoUtils.size();
    }

    public class ProverbsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView proverb;
        private Context context;

        public ProverbsViewHolder(final View itemView) {
            super(itemView);

            context = itemView.getContext();
            itemView.setOnClickListener(this);
            proverb = itemView.findViewById(R.id.txt_proverb);
        }

        @Override
        public void onClick(View view) {
            FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
            FullScreenDialogFragment newFragment = new FullScreenDialogFragment();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            newFragment.show(transaction, FullScreenDialogFragment.TAG);
        }
    }
}
