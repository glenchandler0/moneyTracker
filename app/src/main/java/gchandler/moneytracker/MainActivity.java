package gchandler.moneytracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final FloatingActionButton plus = (FloatingActionButton) findViewById(R.id.plus);
        final FloatingActionButton minus = (FloatingActionButton) findViewById(R.id.minus);
        final TextView total = (EditText) findViewById(R.id.totalValueDisplay);


        //Class used for keeping track of all values, contains useful functions for calculations
        //Will later expand to other classes and libraries for further features
        final Data sessionDate = new Data();

        total.setText("" + sessionDate.getTotalValue());

        //Set listeners for items on the screen
        plus.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //Get value from some UI for addinghere
               sessionDate.add(12.34);

               //Update value
               total.setText("" + sessionDate.getTotalValue());
           }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get value from some UI for addinghere
                sessionDate.subtract(12.34);

                //Update value
                total.setText("" + sessionDate.getTotalValue());
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
