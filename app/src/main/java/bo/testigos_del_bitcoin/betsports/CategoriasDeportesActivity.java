package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    private ImageView backArrow;

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
        backArrow = findViewById(R.id.backArrow);
    }

}
