package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.google.gson.Gson;

import bo.testigos_del_bitcoin.betsports.model.Deportes;

public class BetActivity extends AppCompatActivity {
    private TextView cuota1;

    private Context mContext;

    private TextView nombreEquipo1;
    private TextView nombreEquipo2;
    private TextView cuota2;
    private EditText cantidad;
    private ImageView backArrow;
    private Button jugar;
    private TextView gananciText;

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apuesta);

        mContext = this;

        initViews();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        reciveData();
        addEvents();
    }

    public void initViews(){
        nombreEquipo1 = findViewById(R.id.nombreEquipo1);
        nombreEquipo2 = findViewById(R.id.nombreEquipoB);
        cuota1 = findViewById(R.id.cuota1);
        cuota2 = findViewById(R.id.cuota2);
        cantidad = findViewById(R.id.cantidad);
        gananciText = findViewById(R.id.gananciaText);

        cantidad.setInputType(InputType.TYPE_CLASS_NUMBER);

        jugar = findViewById(R.id.button);
        backArrow = findViewById(R.id.backArrow);
        toolbar = findViewById(R.id.toolbar);
    }

    public void reciveData(){
        Deportes seleccionado1 = new Gson().fromJson(getIntent().getStringExtra(Constants.CODIGO_PASAR_A_APUESTA1), Deportes.class);
        Deportes seleccionado2 = new Gson().fromJson(getIntent().getStringExtra(Constants.CODIGO_PASAR_A_APUESTA2), Deportes.class);
        Deportes seleccionado3 = new Gson().fromJson(getIntent().getStringExtra(Constants.CODIGO_PASAR_A_APUESTA3), Deportes.class);

        if (seleccionado1 != null) {
            nombreEquipo1.setText(seleccionado1.getEquipoUno());
            nombreEquipo2.setText(seleccionado1.getEquipoDos());
        }else if(seleccionado2 != null){
            nombreEquipo1.setText(seleccionado2.getEquipoUno());
            nombreEquipo2.setText(seleccionado2.getEquipoDos());
        }else if(seleccionado3 != null){
            nombreEquipo1.setText(seleccionado3.getEquipoUno());
            nombreEquipo2.setText(seleccionado3.getEquipoDos());
        }
    }

    public void addEvents(){
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cantidad.getText().toString().isEmpty()){
                    cantidad.setText("200");
                    Toast.makeText(mContext, "La apuesta minima es de 200$", Toast.LENGTH_LONG).show();
                }else if(Integer.parseInt(cantidad.getText().toString()) >= 200) {
                    Toast.makeText(mContext, "Tu apuesta ha sido registrada", Toast.LENGTH_LONG).show();
                }else {
                    cantidad.setText("200");
                    Toast.makeText(mContext, "La apuesta minima es de 200$", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
