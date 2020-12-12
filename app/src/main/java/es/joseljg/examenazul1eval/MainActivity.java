package es.joseljg.examenazul1eval;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_INGRESO = ".es.joseljg.MainActivity.ingresos";
    public static final String EXTRA_PRECIO_ENTRADA = "es.joseljg.MainActivity.precioEntrada";
    public static final String EXTRA_NUM_VIAJEROS = "es.joseljg.MainActivity.numViajeros";
    private EditText edt_num_personas;
    private EditText edt_precio_viaje;
    private TextView txt_ingresos;
    private double ingresos = 0.0;
    int num_personas = 0;
    double precio_viaje = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_num_personas = (EditText) findViewById(R.id.edt_num_personas);
        edt_precio_viaje = (EditText) findViewById(R.id.edt_precio_viaje);
        txt_ingresos = (TextView) findViewById(R.id.txt_ingresos);


        if(savedInstanceState != null)
        {
            Log.i("salvado", "actualizando el ingreso");
            ingresos = savedInstanceState.getDouble(EXTRA_INGRESO);
            txt_ingresos.setText(String.valueOf(ingresos) +"€");
        }
        else{
            Log.i("salvado", "no hay nada salvado");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(EXTRA_INGRESO, ingresos);
    }

    public void calcular_ingresos(View view) {

        try{
            String txt_num_personas = String.valueOf(edt_num_personas.getText());
            num_personas = Integer.valueOf(txt_num_personas);
        }catch (NumberFormatException e)
        {
            edt_num_personas.setError("error, debes introducir un número entero");
        }
        try{
            String txt_precio_viaje = String.valueOf(edt_precio_viaje.getText());
           precio_viaje = Double.valueOf(txt_precio_viaje);
        }catch (NumberFormatException e)
        {
            edt_precio_viaje.setError("error, debes introducir un número decimal");
        }

        ingresos = num_personas * precio_viaje;
        ingresos = Math.round(ingresos * 100.0)/100.0;
        txt_ingresos.setText(String.valueOf(ingresos) +"€");
    }

    public void siguiente(View view)
    {

        try{
            String txt_num_personas = String.valueOf(edt_num_personas.getText());
            num_personas = Integer.valueOf(txt_num_personas);
        }catch (NumberFormatException e)
        {
            edt_num_personas.setError("error, debes introducir un número entero");
        }
        try{
            String txt_precio_viaje = String.valueOf(edt_precio_viaje.getText());
            precio_viaje = Double.valueOf(txt_precio_viaje);
        }catch (NumberFormatException e)
        {
            edt_precio_viaje.setError("error, debes introducir un número decimal");
        }

        ingresos = num_personas * precio_viaje;
        ingresos = Math.round(ingresos * 100.0)/100.0;
        txt_ingresos.setText(String.valueOf(ingresos) +"€");

        Intent intent = new Intent(this, SegundoActivity.class);
        intent.putExtra(EXTRA_NUM_VIAJEROS, num_personas);
        intent.putExtra(EXTRA_PRECIO_ENTRADA, precio_viaje);
        startActivity(intent);
    }

}