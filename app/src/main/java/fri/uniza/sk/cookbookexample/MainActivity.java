package fri.uniza.sk.cookbookexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import fri.uniza.sk.cookbookexample.model.Recipe;
import fri.uniza.sk.cookbookexample.model.Singleton;
import fri.uniza.sk.cookbookexample.utilities.LoadData;

public class MainActivity extends AppCompatActivity {

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
        }
    }
}
