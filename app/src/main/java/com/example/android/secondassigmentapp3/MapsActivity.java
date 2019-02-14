package com.example.android.secondassigmentapp3;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        List<Marker> List = new ArrayList<>();
        //get the userid
        Intent intent = getIntent();
        String userid = intent.getStringExtra("userid");
        String selection = "_USERID=?";
        String [] selectionArgs = new String[]{userid};

        //get all the rows with the userid from the editext
        Cursor cursor = getContentResolver().query(Uri.parse("content://com.example.android.firstassignment/datatable/userid"), null, selection,selectionArgs, null);

        while(cursor.moveToNext()) {

            //get the longtitude and the latitude for every row and put it inside the List
            double lon = Double.parseDouble(cursor.getString(2));
            double lat = Double.parseDouble(cursor.getString(3));
            LatLng latlon = new LatLng(lat,lon);
            Marker pin = mMap.addMarker(new MarkerOptions().position(latlon));
            List.add(pin);

            }
        }
    }

