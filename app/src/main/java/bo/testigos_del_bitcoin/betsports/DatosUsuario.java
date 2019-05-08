package bo.testigos_del_bitcoin.betsports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DatosUsuario extends AppCompatActivity implements View.OnClickListener{
    private ImageView ib1,clave, moned;
    private TextView nombr,monedas,contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);
       ib1 =  findViewById(R.id.ib1);
       clave = findViewById(R.id.clave);
       nombr = findViewById(R.id.nombr);
       moned = findViewById(R.id.moned);
        monedas = findViewById(R.id.monedas);
        contra = findViewById(R.id.contra);
        reciveData();
        addEvents();
    }
    public void addEvents(){
        ib1.setOnClickListener(this);
        //ib2.setOnClickListener(this);
    }
    public void reciveData(){
        Intent intent= getIntent();
        String nombreUsuario = intent.getStringExtra(Constants.CODIGO_PASAR_A_USUARIO);
        nombr.setText( nombreUsuario);
    }

    @Override
    public void onClick(View v) {
        Intent siguiente = new Intent(this,DatosUsuario.class);
        startActivity(siguiente);

    }
}
