package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ChooseSportActivity extends AppCompatActivity implements View.OnClickListener{
    private Context mContext;
    CheckBox futbolc,basketc,formulac,carrerac,ufcc,peleac,tenisc, espc;
    private Button aceptar;
    private TextView bienv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_sport);

        bienv = findViewById(R.id.bienv);
        aceptar = findViewById(R.id.button);
        basketc= (CheckBox) findViewById(R.id.basketball);
        formulac=(CheckBox)findViewById(R.id.formula);
        carrerac=(CheckBox)findViewById(R.id.carrera);
        ufcc=(CheckBox)findViewById(R.id.ufc);
        peleac=(CheckBox)findViewById(R.id.pelea);
        tenisc=(CheckBox)findViewById(R.id.tenis);
        futbolc=(CheckBox)findViewById(R.id.futbol);
        espc=(CheckBox)findViewById(R.id.Esports);

        reciveData();
        addEvents();
    }

    public void addEvents(){
        aceptar.setOnClickListener(this);
    }

    public void reciveData(){
        Intent intent= getIntent();
        String nombreUsuario = intent.getStringExtra(Constants.CODIGO_PASAR_A_CHOOSE);

        bienv.setText("Bienvenido " + nombreUsuario);
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
        String prueba = "elecciones: ";
        if(basketc.isChecked() ){
            prueba+="basketball ";
            Intent intent = new Intent(mContext, EquiposEscogerActivity.class);
            intent.putExtra(Constants.KEY_DEPORTE, "basquetball");
            startActivity(intent);
        }
        if(futbolc.isChecked() ){
            prueba+="futbol ";
            Intent intent = new Intent(mContext, EquiposEscogerActivity.class);
            intent.putExtra(Constants.KEY_DEPORTE, "futbol");

        }
        if(tenisc.isChecked() ){
            prueba+="tenis ";
            Intent intent = new Intent(mContext, EquiposEscogerActivity.class);
            intent.putExtra(Constants.KEY_DEPORTE_CHECKBOX, "tenis");
        }
        if(ufcc.isChecked() ){
            prueba+="ufc ";
            Intent intent = new Intent(mContext, EquiposEscogerActivity.class);
            intent.putExtra(Constants.KEY_DEPORTE_CHECKBOX, "ufc");
        }
        if(carrerac.isChecked() ){
            prueba+="Carrera de caballos ";
            Intent intent = new Intent(mContext, EquiposEscogerActivity.class);
            intent.putExtra(Constants.KEY_DEPORTE_CHECKBOX, "carrera de caballos");
        }
        if(peleac.isChecked() ){
            prueba+="pelea de gallos ";
            Intent intent = new Intent(mContext, EquiposEscogerActivity.class);
            intent.putExtra(Constants.KEY_DEPORTE_CHECKBOX, "pelea de gallos");
        }
        if(formulac.isChecked() ){
            prueba+="formula 1 ";
            Intent intent = new Intent(mContext, EquiposEscogerActivity.class);
            intent.putExtra(Constants.KEY_DEPORTE_CHECKBOX, "formula");
        }
        if(espc.isChecked() ){
            prueba+="E-sports ";
            Intent intent = new Intent(mContext, EquiposEscogerActivity.class);
            intent.putExtra(Constants.KEY_DEPORTE_CHECKBOX, "e sports");
        }
        Toast.makeText(getApplicationContext(),prueba,Toast.LENGTH_SHORT).show();

    }
}
