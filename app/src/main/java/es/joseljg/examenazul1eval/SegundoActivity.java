package es.joseljg.examenazul1eval;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SegundoActivity extends AppCompatActivity {


    TextView txt_num_viajeros;
    TextView txt_precio_viaje;
    TextView txt_ingresos;
    TextView txt_gastos;
    TextView txt_total;
    //-------------------------------
    EditText edt_gasto;
    //-------------------------------
    int num_viajeros = 0;
    double precio_entrada = 0.0;
    double ingresos = 0.0;
    double gastos = 0.0;
    double total = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        Intent intent =getIntent();
        txt_num_viajeros = (TextView) findViewById(R.id.txt_num_viajeros2);
        txt_precio_viaje = (TextView) findViewById(R.id.txt_precio_billete);
        txt_ingresos = (TextView) findViewById(R.id.txt_ingresos2);
        txt_gastos = (TextView) findViewById(R.id.txt_gastos2);
        txt_total = (TextView) findViewById(R.id.txt_total2);
        //-----------------------------------------------------
        edt_gasto = (EditText) findViewById(R.id.edt_precio_autobus);
        //-----------------------------------------------------
        if(intent != null)
        {
            num_viajeros = intent.getIntExtra(MainActivity.EXTRA_NUM_VIAJEROS, 0);
            precio_entrada = intent.getDoubleExtra(MainActivity.EXTRA_PRECIO_ENTRADA, 0.0);
            ingresos = num_viajeros * precio_entrada;
        }
        total =Math.round(((ingresos - gastos))*100.0)/100.0;
        //----------------------------------------------------
        txt_num_viajeros.setText("num viajeros: " + String.valueOf(num_viajeros)+"€");
        txt_precio_viaje.setText("precio viaje: " + String.valueOf(precio_entrada)+"€");
        txt_ingresos.setText("ingresos: " + String.valueOf(ingresos)+"€");
        txt_gastos.setText("gastos: " + String.valueOf(gastos)+"€");
        txt_total.setText("total: "  + String.valueOf(total)+"€");
    }


public  void aplicar(View view)
{
    try {
        gastos = Double.valueOf(String.valueOf(edt_gasto.getText()));
        Toast.makeText(this,"gasto del autobus aplicado correctamente" , Toast.LENGTH_SHORT).show();
    }
    catch(NumberFormatException e)
    {
        edt_gasto.setError("error, debes introducir un número decimal");
       gastos = 0.0;
    }
    txt_gastos.setText("gastos: " + String.valueOf(gastos)+"€");
    total =Math.round((ingresos - gastos)*100.0)/100.0;
    txt_total.setText("total: "  + String.valueOf(total)+"€");
}

}