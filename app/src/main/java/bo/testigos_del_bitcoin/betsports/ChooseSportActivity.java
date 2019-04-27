package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ChooseSportActivity extends AppCompatActivity {
    CheckBox futbolc,basketc,formulac,carrerac,ufcc,peleac,tenisc, espc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_sport);

        basketc= (CheckBox) findViewById(R.id.basketball);
        formulac=(CheckBox)findViewById(R.id.formula);
        carrerac=(CheckBox)findViewById(R.id.carrera);
        ufcc=(CheckBox)findViewById(R.id.ufc);
        peleac=(CheckBox)findViewById(R.id.pelea);
        tenisc=(CheckBox)findViewById(R.id.tenis);
        futbolc=(CheckBox)findViewById(R.id.futbol);
        espc=(CheckBox)findViewById(R.id.Esports);
    }

    public void validar(View view){
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

        }
        if(peleac.isChecked() ){

        }
        if(formulac.isChecked() ){

        }
        if(espc.isChecked() ){

        }
        Toast.makeText(getApplicationContext(),prueba,Toast.LENGTH_SHORT).show();
        Intent siguiente = new Intent(this,EquiposEscogerActivity.class);
        startActivity(siguiente);

    }
}
