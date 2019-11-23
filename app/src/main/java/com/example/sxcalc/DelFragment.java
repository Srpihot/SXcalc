package com.example.sxcalc;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sxcalc.databinding.FragmentDelBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class DelFragment extends Fragment {


    public DelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModel myViewModel= ViewModelProviders.of(requireActivity(),new SavedStateVMFactory(requireActivity())).get(MyViewModel.class);
        FragmentDelBinding binding;
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_del,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());
        binding.button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_delFragment_to_welcomeFragment);
            }
        });
        return binding.getRoot();
    }

}
