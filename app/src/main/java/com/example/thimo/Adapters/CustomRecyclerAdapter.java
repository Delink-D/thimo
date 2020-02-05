package com.example.thimo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thimo.R;
import com.example.thimo.models.Thimo;

import java.util.List;

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

    public class ProverbsViewHolder extends RecyclerView.ViewHolder {

        public TextView proverb;

        public ProverbsViewHolder(View itemView) {
            super(itemView);

            proverb = itemView.findViewById(R.id.txt_proverb);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Thimo thimo = (Thimo) view.getTag();

                    Toast.makeText(view.getContext(), thimo.getProverb(), Toast.LENGTH_SHORT).show();

                }
            });

        }

    }
}
