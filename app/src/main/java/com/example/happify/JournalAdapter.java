package com.example.happify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.JournalViewHolder> {
    public JournalAdapter(){}
    @NonNull
    @Override
    public JournalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.journal_item_view,parent,false);
        return new JournalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull JournalViewHolder holder, int position) {
        TextView journalTV = holder.itemView.findViewById(R.id.journalItemTV);
        String journalItem = AppModel.getAppModel().journals.get(position).getJournalItem();
//        String journalItem = JournalModel.getModel().journals.get(position).getJournalItem();
        journalTV.setText(journalItem);
    }

    @Override
    public int getItemCount() {
        return AppModel.getAppModel().journals.size();
    }
    public static class JournalViewHolder extends RecyclerView.ViewHolder{
        public JournalViewHolder(@NonNull View v){
            super(v);

        }
    }
}