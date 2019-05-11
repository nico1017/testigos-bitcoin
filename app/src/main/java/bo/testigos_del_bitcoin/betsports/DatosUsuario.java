package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import bo.testigos_del_bitcoin.betsports.db.DatabaseHelper;

public class DatosUsuario extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;

    private TextView nombr,monedas;
    private String nombreUsuario;
    private Toolbar toolbar;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);

        mContext = this;
        dbHelper = new DatabaseHelper(mContext);

        nombr = findViewById(R.id.nombr);
        monedas = findViewById(R.id.monedas);
        toolbar = findViewById(R.id.toolbar);

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
        nombr.setText(nombreUsuario);
        monedas.setText(dbHelper.getMonedasDeUsuario(nombreUsuario) + "$");
    }
    public void addEvents(){
       // ib1.setOnClickListener(this);
        //ib2.setOnClickListener(this);
    }
    public void reciveData(){
        Intent intent = getIntent();
        nombreUsuario = intent.getStringExtra(Constants.CODIGO_PASAR_A_DATOSUSUARIO);
    }

    @Override
    public void onClick(View v) {
        Intent siguiente = new Intent(this,DatosUsuario.class);
        startActivity(siguiente);

    }
}
