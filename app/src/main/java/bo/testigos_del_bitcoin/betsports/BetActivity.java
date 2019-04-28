package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import bo.testigos_del_bitcoin.betsports.model.Deportes;

public class BetActivity extends AppCompatActivity {

    private Context mContext;

    private TextView nombreEquipo1;
    private TextView nombreEquipo2;
    private TextView cuota1;
    private TextView cuota2;
    private EditText cantidad;
    private Button jugar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apuesta);

        mContext = this;

        initViews();
        reciveData();
        addEvents();
    }

    public void initViews(){
        nombreEquipo1 = findViewById(R.id.nombreEquipo1);
        nombreEquipo2 = findViewById(R.id.nombreEquipoB);
        cuota1 = findViewById(R.id.cuota1);
        cuota2 = findViewById(R.id.cuota2);
        cantidad = findViewById(R.id.cantidad);
        jugar = findViewById(R.id.button);

    }

    public void reciveData(){
        Deportes seleccionado = new Gson().fromJson(getIntent().getStringExtra(Constants.CODIGO_PASAR_A_APUESTA), Deportes.class);

        nombreEquipo1.setText(seleccionado.getEquipoUno());
        nombreEquipo2.setText(seleccionado.getEquipoDos());
    }

    public void addEvents(){
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Tu apuesta ha sido registrada", Toast.LENGTH_LONG).show();
            }
        });
    }
}
