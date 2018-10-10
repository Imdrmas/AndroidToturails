package com.issam.drmas.pokemon

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        loadPeckemon()
        checkPermission()
    }

    val accessLocation = 123
    fun checkPermission(){

        if (Build.VERSION.SDK_INT>=23){
            if (ActivityCompat.checkSelfPermission(this,
                            android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), accessLocation)
                return
            }
        }

        getUserLocation()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        when(requestCode){
            accessLocation->{
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    getUserLocation()
                }
                else{
                    Toast.makeText(this, " Location access is deny", Toast.LENGTH_LONG).show()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    fun  getUserLocation(){
        Toast.makeText(this, " Location access now", Toast.LENGTH_LONG).show()

        val myLocation = MyLocationListener()
        val locationManger = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationManger.requestLocationUpdates(LocationManager.GPS_PROVIDER,3,3f,myLocation)

        val myThread = MyThread()
        myThread.start()
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

    }

    var myLocation:Location?=null
   inner class MyLocationListener:LocationListener{
       constructor(){
           myLocation = Location("me")
           myLocation!!.longitude=0.0
           myLocation!!.longitude=0.0
       }
        override fun onLocationChanged(location: Location?) {

            myLocation = location

        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

        }

        override fun onProviderEnabled(provider: String?) {

        }

        override fun onProviderDisabled(provider: String?) {

        }
    }

    var oldLocation:Location?=null
    inner class MyThread:Thread{
        constructor():super(){
            oldLocation = Location("oldLocation")
            oldLocation!!.longitude=0.0
            oldLocation!!.longitude=0.0
        }

        override fun run() {
            while (true){
                try {

                    if (oldLocation!!.distanceTo(myLocation)==0f){
                        continue
                    }
                    oldLocation=myLocation

                // Add a marker in Sydney and move the camera
                runOnUiThread {
                    mMap!!.clear()

                    val sydney = LatLng(myLocation!!.latitude, myLocation!!.longitude)
                    mMap.addMarker(MarkerOptions()
                            .position(sydney)
                            .title("Me")
                            .snippet("Here is my location")
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.mario))
                    )
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 14f))

                    for (i in 0..listOfPockemon.size-1){
                        var newPokemon=listOfPockemon[1]
                        if (newPokemon.isCatch==false){

                            val pockLocation = LatLng(newPokemon.location!!.latitude, newPokemon.location!!.longitude)
                                    mMap!!.addMarker(MarkerOptions()
                                            .position(pockLocation)
                                            .title(newPokemon.name)
                                            .snippet(newPokemon.des +", power:"+ newPokemon.power)
                                            .icon(BitmapDescriptorFactory.fromResource(newPokemon.image!!)))

                            if (myLocation!!.distanceTo(newPokemon.location) <2){
                                myPower+=myPower+newPokemon.power!!
                                newPokemon.isCatch=true
                                listOfPockemon[i]=newPokemon
                                Toast.makeText(applicationContext, "You catch new pockemon, your new power is"+myPower,
                                        Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                }


                    Thread.sleep(1000)
                }catch (ex:Exception){}
            }
        }
    }

    var myPower:Double=0.0

    var listOfPockemon = ArrayList<Pokemon>()
    fun loadPeckemon(){

        listOfPockemon.add(Pokemon(R.mipmap.charmander, "charmander",
                "charmander living in Japan", 55.0, 37.23, -122.0))

        listOfPockemon.add(Pokemon(R.mipmap.bulbasaur, "Bulbasaur",
                "Bulbasaur living in USA", 90.5, 37.7949568502667, -122.410494089127))

        listOfPockemon.add(Pokemon(R.mipmap.squirtle, "Squirtle",
                "Squirtle living in France", 33.5, 37.7816621152613, -122.41225361824))
    }
}
