package com.example.sxcalc;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sxcalc.databinding.FragmentQuestionBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {


    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final MyViewModel myViewModel = ViewModelProviders.of(requireActivity(), new SavedStateVMFactory(requireActivity())).get(MyViewModel.class);
        myViewModel.generator();
        myViewModel.getCurrentScore().setValue(0);
        final FragmentQuestionBinding binding;
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());
        final StringBuilder builder = new StringBuilder();
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button2:
                        builder.append("1");
                        break;
                    case R.id.button3:
                        builder.append("2");
                        break;
                    case R.id.button4:
                        builder.append("3");
                        break;
                    case R.id.button5:
                        builder.append("4");
                        break;
                    case R.id.button6:
                        builder.append("5");
                        break;
                    case R.id.button7:
                        builder.append("6");
                        break;
                    case R.id.button8:
                        builder.append("7");
                        break;
                    case R.id.button9:
                        builder.append("8");
                        break;
                    case R.id.button10:
                        builder.append("9");
                        break;
                    case R.id.button12:
                        builder.append("0");
                        break;
                    case R.id.button11:
                        builder.setLength(0);
                        break;
                }
                if (builder.length() == 0) {
                    binding.textView9.setText(R.string.Question_Message);
                } else {
                    binding.textView9.setText(builder.toString());
                }
            }
        };

        binding.button2.setOnClickListener(listener);
        binding.button3.setOnClickListener(listener);
        binding.button4.setOnClickListener(listener);
        binding.button5.setOnClickListener(listener);
        binding.button6.setOnClickListener(listener);
        binding.button7.setOnClickListener(listener);
        binding.button8.setOnClickListener(listener);
        binding.button9.setOnClickListener(listener);
        binding.button10.setOnClickListener(listener);
        binding.button11.setOnClickListener(listener);
        binding.button12.setOnClickListener(listener);

        binding.button13.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("ConstantConditions")
            @Override
            public void onClick(View v) {
                if (builder.length() == 0) {
                    builder.append("-1");
                }
                if (Integer.valueOf(builder.toString()).intValue() == myViewModel.getAnswer().getValue()) {
                    myViewModel.answerCorrect();
                    builder.setLength(0);
                    binding.textView9.setText(R.string.Go_On);
                } else {
                    NavController controller = Navigation.findNavController(v);
                    if (myViewModel.win_flag) {
                        controller.navigate(R.id.action_questionFragment_to_winFragment);
                        myViewModel.win_flag = false;
                        myViewModel.save();
                    } else {
                        controller.navigate(R.id.action_questionFragment_to_delFragment);
                    }
                }


            }
        });
return binding.getRoot();

    }
}