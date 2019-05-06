package bo.testigos_del_bitcoin.betsports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DatosUsuario extends AppCompatActivity implements View.OnClickListener{
    private Button ib1,ib2;
    private TextView nombr,moned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);
        //ib1 =  findViewById(R.id.ib1);
       // ib2 = findViewById(R.id.ib2);
        nombr = findViewById(R.id.nombr);
        moned = findViewById(R.id.moned);
        reciveData();
        addEvents();
    }
    public void addEvents(){
        ib1.setOnClickListener(this);
        ib2.setOnClickListener(this);
    }
    public void reciveData(){
        Intent intent= getIntent();
        String nombreUsuario = intent.getStringExtra(Constants.CODIGO_PASAR_A_USUARIO);
        nombr.setText( nombreUsuario);
    }

    /*public void validar(View view){
        String prueba = "elecciones: ";
        if(basketc.isChecked() ){
            prueba+="basketball";
        }
        if(futbolc.isChecked() ){
            prueba+="futbol";

        }
        if(tenisc.isChecked() ){
            prueba+="tenis";
        }
        if(ufcc.isChecked() ){
            prueba+="ufc";
        }
        if(carrerac.isChecked() ){
            prueba+="Carrera de caballos";
        }
        if(peleac.isChecked() ){
            prueba+="pelea de gallos";
        }
        if(formulac.isChecked() ){
            prueba+="formula 1";
        }
        if(espc.isChecked() ){
            prueba+="E sports";
        }
        if(espc.isChecked() ){
            prueba+="E sports";
        }
        Toast.makeText(getApplicationContext(),prueba,Toast.LENGTH_SHORT).show();
        Intent siguiente = new Intent(this,EquiposEscogerActivity.class);
        startActivity(siguiente);

    }*/

    @Override
    public void onClick(View v) {
        Intent siguiente = new Intent(this,DatosUsuario.class);
        startActivity(siguiente);

    }
}
