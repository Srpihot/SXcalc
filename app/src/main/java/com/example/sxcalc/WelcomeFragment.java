package com.example.sxcalc;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sxcalc.databinding.FragmentWelcomeBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {


    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModel myViewModel=ViewModelProviders.of(requireActivity(),new SavedStateVMFactory(requireActivity())).get(MyViewModel.class);
        FragmentWelcomeBinding binding;
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_welcome,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_welcomeFragment_to_questionFragment);
            }
        });
        return binding.getRoot();

    }

}
