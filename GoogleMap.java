package com.example.coda1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class GoogleMap extends FragmentActivity implements OnMapReadyCallback {

    com.google.android.gms.maps.GoogleMap map;
    SearchView mySearchView;
    ListView myList;


    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

        mySearchView = (SearchView) findViewById(R.id.searchView);
        mySearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GoogleMap.this, Services.class));


            }
        });



        mySearchView = (SearchView)findViewById(R.id.searchView);
        myList = (ListView)findViewById(R.id.myList);

        list= new ArrayList<String>();

        list.add("Region 1 Medical Center");
        list.add("Viliaflor Hospital");
        list.add("Luzon Medical Center");
        list.add("The Medical Center");

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        myList.setAdapter(adapter);
        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                adapter.getFilter().filter(s);

                return false;
            }
        });

        SupportMapFragment mapFragment =(SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull com.google.android.gms.maps.GoogleMap googleMap) {

        map = googleMap;

        LatLng latLng = new LatLng(16.04346059195531, 120.3333636582459);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("My position");
        markerOptions.position(latLng);
        googleMap.addMarker(markerOptions);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 5);
        googleMap.animateCamera(cameraUpdate);

        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);
        googleMap.getUiSettings().setZoomGesturesEnabled(true);
        googleMap.getUiSettings().setScrollGesturesEnabled(true);
        googleMap.getUiSettings().setRotateGesturesEnabled(true);

    }
}