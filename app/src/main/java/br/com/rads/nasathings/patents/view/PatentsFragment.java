package br.com.rads.nasathings.patents.view;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import br.com.rads.nasathings.R;
import br.com.rads.nasathings.databinding.FragmentPatentsBinding;
import br.com.rads.nasathings.patents.model.Patent;
import br.com.rads.nasathings.patents.response.PatentsResponse;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PatentsFragment extends Fragment {

    private static String PARAMS = "params";

//    @Bind(R.id.patent_name_text_view)
    TextView patentNameTextView;

//    @Bind(R.id.patent_description_text_view)
    TextView patentDescriptionTextView;

    private Patent patent;

    public static PatentsFragment newInstance(Patent patent){
        PatentsFragment patentsFragment = new PatentsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(PARAMS, patent);
        patentsFragment.setArguments(bundle); 
        return patentsFragment;
    }

    public PatentsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null){
            patent = (Patent) getArguments().getSerializable(PARAMS);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentPatentsBinding viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_patents, container, false);
        View view = viewDataBinding.getRoot();
        viewDataBinding.setPatent(patent);
        ButterKnife.bind(this, view);

//        patentNameTextView = (TextView) view.findViewById(R.id.patent_name_text_view);
//        patentDescriptionTextView = (TextView) view.findViewById(R.id.patent_description_text_view);
//
//        patentNameTextView.setText(patent.getTitle());
//        patentDescriptionTextView.setText(patent.getDescription());

        return view;
    }

    @OnClick(R.id.button_test)
    public void test(){
        patent.setDescription("meh mudou");
        Toast.makeText(getActivity(), "patents : " + patent.getDescription(), Toast.LENGTH_SHORT).show();
    }

}
