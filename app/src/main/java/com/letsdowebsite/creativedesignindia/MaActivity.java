package com.letsdowebsite.creativedesignindia;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MaActivity extends AppCompatActivity {
    ImageView img, usa;
    //To store longitude and latitude from map
    private double longitude;
    private double latitude;
    private GPSTracker gpsTracker;
    static String countryCode;

    /**********************Permission Array for App******************************/

    private static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;
    private String[] permissions = new String[]
            {
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.INTERNET,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,

            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //checkPermissions();
      //  gpsTracker=new GPSTracker(MaActivity.this);


        img = (ImageView) findViewById(R.id.india);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  if(countryCode.equalsIgnoreCase("IN")){
                    Intent intent = new Intent(MaActivity.this, INDIA.class);
                    startActivity(intent);
              //  }

            }
        });


        usa = (ImageView) findViewById(R.id.usa);
        usa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   if(countryCode.equalsIgnoreCase("US")) {
                    Intent intent = new Intent(MaActivity.this, USA.class);
                    startActivity(intent);
                }
           // }
        });


    }

  //  private boolean checkPermissions() {
      //  int result;
      //  List<String> listPermissionsNeeded = new ArrayList<>();
      //  for (String permission : permissions) {
       //     result = ContextCompat.checkSelfPermission(MaActivity.this, permission);
        //    if (result != PackageManager.PERMISSION_GRANTED) {
       //         listPermissionsNeeded.add(permission);
        //    }
     //   }
     //   if (!listPermissionsNeeded.isEmpty()) {
      //      ActivityCompat.requestPermissions(MaActivity.this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
      //      return false;
    //    }
     //   return true;
  //  }

  //  @Override
   // protected void onResume() {
    //    super.onResume();
     //   try {
      //      latitude=gpsTracker.getLatitude();
        //    longitude=gpsTracker.getLongitude();
        //    Log.e("TestLoction","latitude"+latitude);
        //    Log.e("TestLoction","longitude"+longitude);
          //  Log.e("KhooshbooTest",">>>>>>>>>>>>>>"+getAddress(MaActivity.this,latitude,longitude));
        //    List<Address> address=getAddress(MaActivity.this,latitude,longitude);
     //   }catch (Exception ex){
     //       ex.printStackTrace();
     //   }

   // }

 //   public static List<Address> getAddress(Context mContext, double lat, double lng) {
     //   List<Address> addresses = null;
       // Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());
     //   try {
       //     addresses = geocoder.getFromLocation(lat, lng, 1);
       //     Address obj = addresses.get(0);
        //    String add = obj.getAddressLine(0);
        //    add = add + "\n" + obj.getCountryName();
        //    add = add + "\n" + obj.getCountryCode();
         //   add = add + "\n" + obj.getAdminArea();
         //   add = add + "\n" + obj.getPostalCode();
         //   add = add + "\n" + obj.getSubAdminArea();
           // add = add + "\n" + obj.getLocality();
          //  add = add + "\n" + obj.getSubThoroughfare();
         //   countryCode= obj.getCountryCode();
         //   Log.v("IGA", "Address" + add);

       // } catch (IOException e) {
       //     // TODO Auto-generated catch block
        //    e.printStackTrace();
       //     Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
    //    }
     //   return addresses;
   // }

}
