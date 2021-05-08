package com.example.rahatapppractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.rahatapppractice.Model.States;
import com.example.rahatapppractice.RecyclerViewAdapters.Recycler_States;

import java.util.ArrayList;

public class Home_Screen extends AppCompatActivity {
private RecyclerView recV_states;
private Recycler_States adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

//        adapter = new Recycler_States(getStatesList(), this);
//        recV_states = findViewById(R.id.recycler_states);
//        recV_states.setLayoutManager(new LinearLayoutManager(this));
//        recV_states.setHasFixedSize(true);
//        recV_states.setAdapter(adapter);


    }

    /**
     * Generates a list of state objects containing the state name and the respective helpline number
     * @author Satvik Mittal
     *
     * @return statesArrayList
     */
//    private ArrayList<States> getStatesList(){
//        ArrayList<States> statesArrayList = new ArrayList<>();
//        STATES states_name = STATES.values();
//        String[] helpline = RESOURCES.helpline;
//        for(int i=0; i<states_name.length; i++){
//            States state = new States(states_name[i],helpline[i]);
//            statesArrayList.add(state);
//        }
//        return statesArrayList;
//    }
}