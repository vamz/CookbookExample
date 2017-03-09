package fri.uniza.sk.cookbookexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import fri.uniza.sk.cookbookexample.RecipeFragment.OnListFragmentInteractionListener;
import fri.uniza.sk.cookbookexample.model.Recipe;

import java.util.List;


public class MyRecepyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecepyRecyclerViewAdapter.ViewHolder> {

    private final List<Recipe> recipes;
    private final OnListFragmentInteractionListener mListener;
    private Context context;

    public MyRecepyRecyclerViewAdapter(List<Recipe> items, OnListFragmentInteractionListener listener) {
        recipes = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_recipe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
       //TODO BIND DATA

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    if (holder.recipe==null) throw new AssertionError("Initialize variables in holder");
                    mListener.onListFragmentInteraction(holder.recipe);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Recipe recipe;
        //TODO IMPLEMNT VIEWHOLDER

        public ViewHolder(View itemView) {
            super(itemView);
        }

    }
}
