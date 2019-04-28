package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bo.testigos_del_bitcoin.betsports.adapter.CategoriasDeportesAdapter;
import bo.testigos_del_bitcoin.betsports.model.Deportes;

public class ListaDeportesActivity extends AppCompatActivity {

    private Context mContext;

    private String categoriaElegida;

    private ListView deportes;
    private TextView depCategoria;
    private CategoriasDeportesAdapter deportesAdapter;

    private List<Deportes> deportesArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_deportes);
        mContext = this;

        receiveData();

        if(categoriaElegida.equals("Futbol")) {


            depCategoria = findViewById(R.id.categoria);
            depCategoria.setText(categoriaElegida);

            deportesArray.add(new Deportes(1, "A", "B", R.drawable.futbol, 2019, 04, 25, 16, 00));
            deportesArray.add(new Deportes(2, "C", "D", R.drawable.futbol, 2019, 04, 25, 17, 00));
            deportesArray.add(new Deportes(3, "E", "F", R.drawable.futbol, 2019, 04, 25, 18, 00));
            deportesArray.add(new Deportes(4, "G", "H", R.drawable.futbol, 2019, 04, 25, 19, 00));
            deportesArray.add(new Deportes(5, "I", "J", R.drawable.futbol, 2019, 04, 25, 20, 00));
            deportesArray.add(new Deportes(6, "K", "L", R.drawable.futbol, 2019, 04, 25, 21, 00));
        }

        initViews();
        addEvents();
    }

    private void receiveData() {
        Intent intent = getIntent();
        categoriaElegida = intent.getStringExtra(Constants.KEY_DEPORTE);
    }

    private void initViews() {
        deportes = findViewById(R.id.eventos);

        deportesAdapter = new CategoriasDeportesAdapter(mContext, deportesArray);
        deportes.setAdapter(deportesAdapter);
    }

    private void addEvents() {
    }
}
