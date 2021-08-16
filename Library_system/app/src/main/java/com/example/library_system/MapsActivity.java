package com.example.library_system;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    LatLng cgb = new LatLng(55.68700700136036, 52.296991684088376);
    LatLng cdb = new LatLng(55.74530634471321, 52.40936001422653);
    LatLng bic = new LatLng(55.7365889307855, 52.416509986325906);
    LatLng fone = new LatLng(55.697836175628616, 52.34810128347826);
    LatLng fthree = new LatLng(55.70005566552713, 52.36320170114159);
    LatLng ffive = new LatLng(55.6706460290701, 52.284912245442825);
    LatLng fsix = new LatLng(55.75167907282548, 52.43255791788911);
    LatLng feight = new LatLng(55.697800025374825, 52.35024716672434);
    LatLng ften = new LatLng(55.68080520605409, 52.29409494386611);
    LatLng feleven = new LatLng(55.7317289729782, 52.40016134445903);
    LatLng ftwelve = new LatLng(55.697836175628616, 52.34810128347826);
    LatLng fthirteen = new LatLng(55.76358849113029, 52.43574793279278);
    LatLng ffourteen = new LatLng(55.763590965424974, 52.42376552862294);
    LatLng ffifteen = new LatLng(55.75422920892153, 52.40448990600095);
    LatLng fsixteen = new LatLng(55.74634989180948, 52.392924532172486);
    LatLng fseventeen = new LatLng(55.77085509893534, 52.42628453117836);
    LatLng ftwthree = new LatLng(55.694817154698505, 52.3356196008551);
    LatLng ftwfour = new LatLng(55.72620662848133, 52.398876302950896);
    private ArrayList<LatLng> locationArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationArrayList = new ArrayList<>();
        locationArrayList.add(cgb);
        locationArrayList.add(cdb);
        locationArrayList.add(bic);
        locationArrayList.add(fone);
        locationArrayList.add(fthree);
        locationArrayList.add(ffive);
        locationArrayList.add(fsix);
        locationArrayList.add(feight);
        locationArrayList.add(ften);
        locationArrayList.add(feleven);
        locationArrayList.add(ftwelve);
        locationArrayList.add(fthirteen);
        locationArrayList.add(ffifteen);
        locationArrayList.add(ffifteen);
        locationArrayList.add(fsixteen);
        locationArrayList.add(fseventeen);
        locationArrayList.add(ftwthree);
        locationArrayList.add(ftwfour);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        for (int i = 0; i < locationArrayList.size(); i++) {
            mMap.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title("Библиотека"));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList.get(i)));
        }
    }
}