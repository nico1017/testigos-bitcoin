package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CategoriasPremiosActivity extends AppCompatActivity {

    private Context mContext;
    private TextView TarjetasRegalo;
    private TextView Electronicos;
    private TextView ArticulosDeportivos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout_prem);
        mContext = this;

        initViews();
    }

    private void initViews() {
        TarjetasRegalo = findViewById(R.id.Tarjetas);
        Electronicos = findViewById(R.id.Electronicos);
        ArticulosDeportivos = findViewById(R.id.Deportivos);
    }

    public void goToTarjetas(View view){
        String premio = TarjetasRegalo.getText().toString();

        Intent intent = new Intent(mContext, ListaPremiosActivity.class);
        intent.putExtra(Constants.KEY_PREMIO, premio);
        startActivity(intent);
    }

    public void goToElectronicos(View view){
        String premio = Electronicos.getText().toString();

        Intent intent = new Intent(mContext, ListaPremiosActivity.class);
        intent.putExtra(Constants.KEY_PREMIO, premio);
        startActivity(intent);
    }

    public void goToDeportivos(View view){
        String premio = ArticulosDeportivos.getText().toString();

        Intent intent = new Intent(mContext, ListaPremiosActivity.class);
        intent.putExtra(Constants.KEY_PREMIO, premio);
        startActivity(intent);
    }

    public void goToDeportes(View view){
        Intent intent = new Intent(mContext, CategoriasDeportesActivity.class);
        startActivity(intent);
    }
}
