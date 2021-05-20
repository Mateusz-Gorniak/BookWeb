package pl.giszka.bookweb;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {
  //  public static final int DISPLAY_SHOW_TITLE = android.app.ActionBar.DISPLAY_SHOW_TITLE;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_bookweb, R.id.nav_math, R.id.nav_inf, R.id.nav_elec, R.id.nav_lista)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        Helper.setToolbarTile(getSupportActionBar(),"Strona Główna");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void Toast1(MenuItem item) {

        Toast.makeText(HomeActivity.this, "BookWeb", Toast.LENGTH_SHORT).show();
    }

    public void Toast2(MenuItem item) {
        Toast.makeText(HomeActivity.this, "Matematyka", Toast.LENGTH_SHORT).show();
    }

    public void Toast3(MenuItem item) {
        Toast.makeText(HomeActivity.this, "Informatyka", Toast.LENGTH_SHORT).show();
    }

    public void Toast4(MenuItem item) {
        Toast.makeText(HomeActivity.this, "Elektronika", Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent info = new Intent(HomeActivity.this, AboutProgramActivity.class);
                startActivity(info);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void share(MenuItem item) {
        /*Create an ACTION_SEND Intent*/
        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        /*This will be the actual content you wish you share.*/
        String shareBody = "I just made an app check it out!";
        /*The type of the content is text, obviously.*/
        intent.setType("text/plain");
        /*Applying information Subject and Body.*/
      //  intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Udostępnienie informacji o aplikacji");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        /*Fire!*/
        startActivity(Intent.createChooser(intent, "Udostępnienie informacji o aplikacji"));

    }

    public void Lista(MenuItem item) {

        Intent list = new Intent(HomeActivity.this, BooksListActivity.class);
        startActivity(list);
    }
}