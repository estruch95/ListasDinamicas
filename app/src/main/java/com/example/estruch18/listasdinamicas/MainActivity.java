package com.example.estruch18.listasdinamicas;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private Spinner spPaises, spCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spPaises = (Spinner)findViewById(R.id.sp_paises);
        spCiudades = (Spinner)findViewById(R.id.sp_ciudades);

        cargarSPPaises();
        seleccionPais();
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

    public void cargarSPPaises(){
        ArrayAdapter adaptador = ArrayAdapter.createFromResource(this, R.array.paises, android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPaises.setAdapter(adaptador);
    }

    public void seleccionPais(){
        spPaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cargarCiudades();
                Toast.makeText(getApplicationContext(), "Has seleccionado: "+spPaises.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void cargarCiudades(){
        ArrayAdapter adaptadorCiudades = null;

        switch (spPaises.getSelectedItem().toString()){
            case "España":
                adaptadorCiudades = ArrayAdapter.createFromResource(this, R.array.ciudades_esp, android.R.layout.simple_spinner_item);
                adaptadorCiudades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spCiudades.setAdapter(adaptadorCiudades);
                break;
            case "França":
                adaptadorCiudades = ArrayAdapter.createFromResource(this, R.array.ciudades_fra, android.R.layout.simple_spinner_item);
                adaptadorCiudades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spCiudades.setAdapter(adaptadorCiudades);
                break;
            case "Alemanya":
                adaptadorCiudades = ArrayAdapter.createFromResource(this, R.array.ciudades_ale, android.R.layout.simple_spinner_item);
                adaptadorCiudades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spCiudades.setAdapter(adaptadorCiudades);
                break;
            case "Italia":
                adaptadorCiudades = ArrayAdapter.createFromResource(this, R.array.ciudades_ita, android.R.layout.simple_spinner_item);
                adaptadorCiudades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spCiudades.setAdapter(adaptadorCiudades);
                break;
        }
    }
}
