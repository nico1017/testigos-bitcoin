package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

//import com.Timer_con_countdown.Timer_con_countdown;
import com.google.gson.Gson;

import bo.testigos_del_bitcoin.betsports.db.DatabaseHelper;
import bo.testigos_del_bitcoin.betsports.model.Deportes;

import android.os.CountDownTimer;

public class BetActivity extends AppCompatActivity {
    private TextView cuota1;

    private Context mContext;
    private String usuarioConectado;

    private RadioButton nombreEquipo1;
    private RadioButton nombreEquipo2;
    private TextView cuota2;
    private EditText cantidad;
    private Button jugar;
    private TextView gananciText;
    private TextView monedas;
    private int apuesta;
    private double ganancia;
    private int total;

    private DatabaseHelper dbhelper;

    private Toolbar toolbar;

    private int cantActual;


    Contador counter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apuesta);

        mContext = this;

        initViews();

        Intent intent = getIntent();
        usuarioConectado = intent.getStringExtra(Constants.CODIGO_PASAR_A_APUESTA);

        dbhelper = new DatabaseHelper(mContext);
        monedas.setText(String.valueOf(dbhelper.getMonedasDeUsuario(usuarioConectado)));

        reciveData();
        addEvents();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        apuesta = Integer.parseInt(cantidad.getText().toString());
        ganancia = Double.valueOf(cuota1.getText().toString());
        total = (int)(apuesta*ganancia);
        gananciText.setText(String.valueOf(total));

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        jugar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        monedas.setText(String.valueOf(dbhelper.getMonedasDeUsuario(usuarioConectado)));
    }

    public void initViews(){
        nombreEquipo1 = findViewById(R.id.nombreEquipo1);
        nombreEquipo2 = findViewById(R.id.nombreEquipo2);
        cuota1 = findViewById(R.id.cuota1);
        cuota2 = findViewById(R.id.cuota2);
        cantidad = findViewById(R.id.cantidad);
        gananciText = findViewById(R.id.gananciaText);
        monedas = findViewById(R.id.cantidad_monedas);

        cantidad.setInputType(InputType.TYPE_CLASS_NUMBER);

        jugar = findViewById(R.id.button);
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
                if (nombreEquipo1.isChecked() || nombreEquipo2.isChecked()) {
                    if (cantidad.getText().toString().isEmpty()) {
                        cantidad.setText("200");
                        Toast.makeText(mContext, "La apuesta minima es de 200$", Toast.LENGTH_LONG).show();
                    } else if (Integer.parseInt(cantidad.getText().toString()) >= 200) {
                        cantActual = Integer.parseInt(monedas.getText().toString());
                        if (cantActual >= Integer.parseInt(cantidad.getText().toString())) {
                            jugar.setVisibility(View.INVISIBLE);
                            Toast.makeText(mContext, "Tu apuesta ha sido registrada", Toast.LENGTH_LONG).show();
                            cantActual = Integer.parseInt(monedas.getText().toString()) - Integer.parseInt(cantidad.getText().toString());
                            monedas.setText(String.valueOf(cantActual));
                            dbhelper.cambiarMonedasDeUsuario(usuarioConectado, cantActual);

                            counter = new Contador(10000, 1000);

                            counter.start();
                        } else {
                            Toast.makeText(mContext, "Saldo insuficiente", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        cantidad.setText("200");
                        Toast.makeText(mContext, "La apuesta minima es de 200$", Toast.LENGTH_LONG).show();
                    }


                }else {
                    Toast.makeText(mContext, "Elija un Equipo por favor", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public class Contador extends CountDownTimer{

        public Contador(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            simularJuego();
        }

        @Override
        public void onTick(long millisUntilFinished) {
        }

    }

    public void simularJuego(){
        int posibilidad;
        posibilidad = (int) ((Math.random() * 2) + 1);
        if (posibilidad == 2){
            apuesta = Integer.parseInt(cantidad.getText().toString());
            ganancia = Double.valueOf(cuota1.getText().toString());
            total = (int)(apuesta*ganancia);
            monedas.setText(String.valueOf(total+cantActual));
            dbhelper.cambiarMonedasDeUsuario(usuarioConectado, total+cantActual);

            Toast.makeText(mContext, "Ganaste tu apuesta!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(mContext, "Perdiste tu apuesta, moral nomas choco", Toast.LENGTH_LONG).show();
        }
    }
}
