package fri.uniza.sk.cookbookexample;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import fri.uniza.sk.cookbookexample.model.Recipe;
import fri.uniza.sk.cookbookexample.model.Singleton;
import fri.uniza.sk.cookbookexample.utilities.LoadData;

public class MainActivity extends AppCompatActivity implements RecipeFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            //Load only on application start
            if (Singleton.getInstance().getRecipes() == null) {
                InputStream openFile = getAssets().open("recepty.json");
                List<Recipe> recipes = LoadData.loadRecepies(openFile);
                Singleton.getInstance().setRecipes(recipes);
                Log.d("CookBook", String.valueOf(recipes.size()));
            }

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("CookBook","Data read error");
        }

//        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.listFrameLayout);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.listFrameLayout,RecipeFragment.newInstance());
        fragmentTransaction.commit();

    }

    @Override
    public void onListFragmentInteraction(Recipe item) {
        Toast.makeText(this,item.title,Toast.LENGTH_SHORT).show();
    }
}
