package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CategoriasDeportesActivity extends AppCompatActivity {

    private Context mContext;
    private TextView Futbol;
    private TextView Baloncesto;
    private TextView Tenis;
    private TextView E_sports;
    private TextView Gallos;
    private TextView Caballos;
    private TextView Ufc;
    private TextView F1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout_dep);
        mContext = this;

        initViews();
    }

    private void initViews() {
        Futbol = findViewById(R.id.Futbol);
        Baloncesto = findViewById(R.id.Baloncesto);
        Tenis = findViewById(R.id.Tenis);
        E_sports = findViewById(R.id.Esports);
        Gallos = findViewById(R.id.Gallo);
        Caballos = findViewById(R.id.Caballo);
        Ufc = findViewById(R.id.Ufc);
        F1 = findViewById(R.id.F1);
    }

    public void goToFutbol(View view){
        String deporte = Futbol.getText().toString();

        Intent intent = new Intent(mContext, ListaDeportesActivity.class);
        intent.putExtra(Constants.KEY_DEPORTE, deporte);
        startActivity(intent);
    }

    public void goToBaloncesto(View view){
        String deporte = Baloncesto.getText().toString();

        Intent intent = new Intent(mContext, ListaDeportesActivity.class);
        intent.putExtra(Constants.KEY_DEPORTE, deporte);
        startActivity(intent);
    }

    public void goToTenis(View view){
        String deporte = Tenis.getText().toString();

        Intent intent = new Intent(mContext, ListaDeportesActivity.class);
        intent.putExtra(Constants.KEY_DEPORTE, deporte);
        startActivity(intent);
    }

    public void goToEsports(View view){
        String deporte = E_sports.getText().toString();

        Intent intent = new Intent(mContext, ListaDeportesActivity.class);
        intent.putExtra(Constants.KEY_DEPORTE, deporte);
        startActivity(intent);
    }

    public void goToGallo(View view){
        String deporte = Gallos.getText().toString();

        Intent intent = new Intent(mContext, ListaDeportesActivity.class);
        intent.putExtra(Constants.KEY_DEPORTE, deporte);
        startActivity(intent);
    }

    public void goToCaballo(View view){
        String deporte = Caballos.getText().toString();

        Intent intent = new Intent(mContext, ListaDeportesActivity.class);
        intent.putExtra(Constants.KEY_DEPORTE, deporte);
        startActivity(intent);
    }

    public void goToUfc(View view){
        String deporte = Ufc.getText().toString();

        Intent intent = new Intent(mContext, ListaDeportesActivity.class);
        intent.putExtra(Constants.KEY_DEPORTE, deporte);
        startActivity(intent);
    }

    public void goToF1(View view){
        String deporte = F1.getText().toString();

        Intent intent = new Intent(mContext, ListaDeportesActivity.class);
        intent.putExtra(Constants.KEY_DEPORTE, deporte);
        startActivity(intent);
    }

    public void goToPremios(View view){
        Intent intent = new Intent(mContext, CategoriasPremiosActivity.class);
        startActivity(intent);
    }

    /*@Override
    public void onClick(View view) {
        String usuario = mUsuarioEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();
        Log.e("Mis datos", usuario + " " + password);

        Intent intent = new Intent(mContext, ListaActivity.class);
        intent.putExtra(Constants.KEY_USUARIO, usuario);
        intent.putExtra(Constants.KEY_PASSWORD, password);
        startActivity(intent);
    }*/
}
