package com.example.rahatapppractice.RecyclerViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahatapppractice.Model.States;
import com.example.rahatapppractice.R;

import java.util.ArrayList;

public class Recycler_States extends RecyclerView.Adapter<Recycler_States.ViewHolder> {
    ArrayList<States> stateList;
    Context context;

    public Recycler_States(ArrayList<States> stateList, Context context) {
        this.stateList = stateList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_state_card,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        States state = stateList.get(position);
        TextView tv_name = holder.tv_name, tv_helpline = holder.tv_helpline;
        Button btn_requestVCN = holder.btn_requestVCN;

        tv_name.setText(state.getName());
        tv_helpline.setText(state.getHelpline());

        btn_requestVCN.setOnClickListener(v -> {

        });


    }

    @Override
    public int getItemCount() {
        return stateList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_helpline;
        Button btn_requestVCN;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_stateName);
            tv_helpline = itemView.findViewById(R.id.tv_state_helpline);
            btn_requestVCN = itemView.findViewById(R.id.btn_requestVCN);
        }
    }
}

