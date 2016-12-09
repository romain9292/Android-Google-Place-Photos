package io.beedev.googleplacephotoapi;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.gms.location.places.*;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.TextView;

//Google API getCurrentLocation

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private static final String LOG_TAG = "PlacesAPIActivity";
    private static final int GOOGLE_API_CLIENT_ID = 0;
    private GoogleApiClient mGoogleApiClient;
    private static final int PERMISSION_REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mGoogleApiClient = new GoogleApiClient.Builder(MainActivity.this)
                .addApi(Places.PLACE_DETECTION_API)
                .addApi(Places.GEO_DATA_API)
                .enableAutoManage(this, GOOGLE_API_CLIENT_ID, this)
                .build();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                placePhotosTask();
                Snackbar.make(view, "Ca marche :)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    //Tester la connexion à l'api
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.e(LOG_TAG, "Google Places API connection failed with error code: "
                + connectionResult.getErrorCode());

        Toast.makeText(this,
                "Google Places API connection failed with error code:" +
                        connectionResult.getErrorCode(),
                Toast.LENGTH_LONG).show();
    }


    //Créer une nouvelle async Task lorque le
    private void placePhotosTask() {

        //On définit la view ou l'image sera affichée
        final ImageView display = (ImageView) findViewById(R.id.display);

        //On peut trouver l'Id de chaques place sur https://developers.google.com/places/place-id?hl=fr
        final String placeId = "ChIJiQnyVcZRqEcRY0xnhE77uyY"; // Branderburg tor
        Log.i(LOG_TAG,placeId);

        // Create a new AsyncTask that displays the bitmap and attribution once loaded.

        new PhotoTask(display.getWidth(), display.getHeight(), mGoogleApiClient ) {
            @Override
            protected void onPreExecute() {
                // Display a temporary image to show while bitmap is loading.
                Log.i(LOG_TAG,"Entrain de s'executer");
            }

            @Override
            protected void onPostExecute(AttributedPhoto attributedPhoto) {
                if (attributedPhoto != null) {
                    // Photo has been loaded, display it.
                    display.setImageBitmap(attributedPhoto.bitmap);
                    Log.i(LOG_TAG,"Ok On post execute");

                    // Display the attribution as HTML content if set.
                    if (attributedPhoto.attribution == null) {
                        Log.i(LOG_TAG,"Pas d'attributs pour la photo");
                    } else {
                        Log.i(LOG_TAG, attributedPhoto.attribution.toString());
                    }

                }
            }
        }.execute(placeId);
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
