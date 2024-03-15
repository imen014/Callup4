package com.worldcompany3.callup4;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainFragment extends Fragment implements  View.OnClickListener {
    MyInterfaceForDiscussion mcallback;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.createCallbackToParentActivity();
    }

    public interface MyInterfaceForDiscussion{
        void myFirstFctForCommunication();
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View result= inflater.inflate(R.layout.fragment_main, container, false);
       result.findViewById(R.id.btn1).setOnClickListener(this);
       return result;
    }

    @Override
    public void onClick(View v) {
        mcallback.myFirstFctForCommunication();
    }

    public void createCallbackToParentActivity(){
        try{
            mcallback = (MyInterfaceForDiscussion) getActivity();
        }catch(ClassCastException e){
            throw new ClassCastException(e.toString()+" must implement onClicked funct");
        }

    }
}