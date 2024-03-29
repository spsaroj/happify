package com.example.happify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
    public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.JournalViewHolder> {
        public void JournalAdapter() {
        }
        @NonNull
        @Override
        public JournalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_journal_list,parent,false);
            JournalViewHolder vh = new JournalViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull JournalAdapter.JournalViewHolder holder, int position) {
            TextView nameTV = holder.itemView.findViewById(R.id.journalItemTV);
            nameTV.setText(JournalModel.getModel().journals.get(position).getJournalItem());
        }

        @Override
        public int getItemCount() {
            return JournalModel.getModel().journals.size();
        }
        public static class JournalViewHolder extends RecyclerView.ViewHolder{
            public JournalViewHolder(View v){
                super(v);
            }
        }
    }
