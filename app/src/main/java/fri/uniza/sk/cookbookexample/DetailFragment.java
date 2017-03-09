package fri.uniza.sk.cookbookexample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import fri.uniza.sk.cookbookexample.model.Singleton;


public class DetailFragment extends Fragment {

    private static final String ARG_PARAM1 = "recipiePos";
    private int position = -1;

    public DetailFragment() {
        // Required empty public constructor
    }


    public static DetailFragment newInstance(int position) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            if (position == -1)
                throw new AssertionError("Read recipe position from bundle arguments");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_recipe, container, false);
        ((ImageView) view.findViewById(R.id.recipeImage)).setImageBitmap(Singleton.getInstance().getRecipes().get(position).getBitmapFromAsset(getContext()));
        ((TextView) view.findViewById(R.id.detailRecipe)).setText(Singleton.getInstance().getRecipes().get(position).detail);
        ListView listView = (ListView) view.findViewById(R.id.ingredientsList);
        //TODO use basic ArrayAdapter<String> to show ingredients for recipe. As view layout use "android.R.layout.simple_list_item_1"
        //listView.setAdapter(new ....);

        if (null == listView.getAdapter())
            throw new AssertionError("add corrent adapter for listView.");

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

}
