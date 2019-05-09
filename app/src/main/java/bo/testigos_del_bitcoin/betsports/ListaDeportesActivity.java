package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

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

            deportesArray.add(new Deportes(1, "Barcelona", "Liverpool", R.drawable.futbol, 2019, 04, 25, "16", "00"));
            deportesArray.add(new Deportes(2, "Tottenham", "Ajax Amsterdam", R.drawable.futbol, 2019, 04, 25, "17", "00"));
            deportesArray.add(new Deportes(3, "Valencia", "Arsenal", R.drawable.futbol, 2019, 04, 25, "18", "00"));
            deportesArray.add(new Deportes(4, "The Strongest", "Wilstermann", R.drawable.futbol, 2019, 04, 25, "19", "00"));
            deportesArray.add(new Deportes(5, "Blooming", "Aurora", R.drawable.futbol, 2019, 04, 25, "20", "00"));
            deportesArray.add(new Deportes(6, "Bolivar", "Royal Pari", R.drawable.futbol, 2019, 04, 29, "21", "00"));
        }

        if(categoriaElegida.equals("Baloncesto")) {


            depCategoria = findViewById(R.id.categoria);
            depCategoria.setText(categoriaElegida);

            deportesArray.add(new Deportes(1, "Toronto Raptors", "Philadelphia 76ers", R.drawable.baloncesto, 2019, 04, 25, "16", "00"));
            deportesArray.add(new Deportes(2, "Los Angeles Lakers", "BostonCeltics", R.drawable.baloncesto, 2019, 04, 25, "17", "00"));
            deportesArray.add(new Deportes(3, "Chicago Bulls", "San Antonio Spurs", R.drawable.baloncesto, 2019, 04, 25, "18", "00"));
            deportesArray.add(new Deportes(4, "New York Knicks", "Miami Heat", R.drawable.baloncesto, 2019, 04, 25, "19", "00"));
            deportesArray.add(new Deportes(5, "Orlando Magic", "Dallas Mavericks", R.drawable.baloncesto, 2019, 04, 25, "20", "00"));
            deportesArray.add(new Deportes(6, "Houston Rockets", "Atlanta Hawks", R.drawable.baloncesto, 2019, 04, 25, "21", "00"));
        }

        if(categoriaElegida.equals("Tenis")) {


            depCategoria = findViewById(R.id.categoria);
            depCategoria.setText(categoriaElegida);

            deportesArray.add(new Deportes(1, "Novak Djokovic", "Rafael Nadal", R.drawable.tenis, 2019, 04, 25, "16", "00"));
            deportesArray.add(new Deportes(2, "Roger Federer", "Alexander Zverev", R.drawable.tenis, 2019, 04, 25, "17", "00"));
            deportesArray.add(new Deportes(3, "Kevin Anderson", "Dominic Thiem", R.drawable.tenis, 2019, 04, 25, "18", "00"));
            deportesArray.add(new Deportes(4, "Stefanos Tsitsipas", "Kei Nishikori", R.drawable.tenis, 2019, 04, 25, "19", "00"));
            deportesArray.add(new Deportes(5, "John Isner", "Juan Martin del Potro", R.drawable.tenis, 2019, 04, 25, "20", "00"));
            deportesArray.add(new Deportes(6, "Marin Cilic", "Fabio Fognini", R.drawable.tenis, 2019, 04, 25, "21", "00"));
        }

        if(categoriaElegida.equals("E-sports")) {


            depCategoria = findViewById(R.id.categoria);
            depCategoria.setText(categoriaElegida);

            deportesArray.add(new Deportes(1, "Liquid", "NiP", R.drawable.e_sports, 2019, 04, 25, "16", "00"));
            deportesArray.add(new Deportes(2, "Mousesport", "BIG", R.drawable.e_sports, 2019, 04, 25, "17", "00"));
            deportesArray.add(new Deportes(3, "Vici Gaming", "NRG", R.drawable.e_sports, 2019, 04, 25, "18", "00"));
            deportesArray.add(new Deportes(4, "Heroic", "FNATIC", R.drawable.e_sports, 2019, 04, 25, "19", "00"));
            deportesArray.add(new Deportes(5, "Cloud9", "TeamSoloMid", R.drawable.e_sports, 2019, 04, 25, "20", "00"));
            deportesArray.add(new Deportes(6, "MVP", "OpTic Gaming", R.drawable.e_sports, 2019, 04, 25, "21", "00"));
        }

        if(categoriaElegida.equals("Pelea de gallos")) {


            depCategoria = findViewById(R.id.categoria);
            depCategoria.setText(categoriaElegida);

            deportesArray.add(new Deportes(1, "Chicken Little", "El Gallo Claudio", R.drawable.gallo, 2019, 04, 25, "16", "00"));
            deportesArray.add(new Deportes(2, "Gallo Campine", "Brahma", R.drawable.gallo, 2019, 04, 25, "17", "00"));
            deportesArray.add(new Deportes(3, "Kelso", "Combatiente Ingles", R.drawable.gallo, 2019, 04, 25, "18", "00"));
            deportesArray.add(new Deportes(4, "Radio", "Giro Hatch", R.drawable.gallo, 2019, 04, 25, "19", "00"));
            deportesArray.add(new Deportes(5, "Hatch", "Brownred", R.drawable.gallo, 2019, 04, 25, "20", "00"));
            deportesArray.add(new Deportes(6, "Albany", "RoundHead", R.drawable.gallo, 2019, 04, 25, "21", "00"));
        }

        if(categoriaElegida.equals("Carrera de caballos")) {


            depCategoria = findViewById(R.id.categoria);
            depCategoria.setText(categoriaElegida);

            deportesArray.add(new Deportes(1, "Arrogate", "Winx", R.drawable.caballo, 2019, 04, 25, "16", "00"));
            deportesArray.add(new Deportes(2, "Chautauqua", "Hartnell", R.drawable.caballo, 2019, 04, 25, "17", "00"));
            deportesArray.add(new Deportes(3, "Legal Eagle", "Werther", R.drawable.caballo, 2019, 04, 25, "18", "00"));
            deportesArray.add(new Deportes(4, "Hoppertunity", "Hey Doc", R.drawable.caballo, 2019, 04, 25, "19", "00"));
            deportesArray.add(new Deportes(5, "Neorealism", "Terravista", R.drawable.caballo, 2019, 04, 25, "20", "00"));
            deportesArray.add(new Deportes(6, "Heaven", "Whisky Baron", R.drawable.caballo, 2019, 04, 25, "21", "00"));
        }

        if(categoriaElegida.equals("UFC")) {


            depCategoria = findViewById(R.id.categoria);
            depCategoria.setText(categoriaElegida);

            deportesArray.add(new Deportes(1, "Todd Duffee", "Ben Rothwell", R.drawable.ufc, 2019, 04, 25, "16", "00"));
            deportesArray.add(new Deportes(2, "Walt Harris", "Travis Browne", R.drawable.ufc, 2019, 04, 25, "17", "00"));
            deportesArray.add(new Deportes(3, "Daniel Spitz", "Curtis Blaydes", R.drawable.ufc, 2019, 04, 25, "18", "00"));
            deportesArray.add(new Deportes(4, "Juan Adams", "Tai Tuivasa", R.drawable.ufc, 2019, 04, 25, "19", "00"));
            deportesArray.add(new Deportes(5, "Luke Rockhold", "Nick Diaz", R.drawable.ufc, 2019, 04, 25, "20", "00"));
            deportesArray.add(new Deportes(6, "Carlos Condit", "Diego Sanchez", R.drawable.ufc, 2019, 04, 25, "21", "00"));
        }

        if(categoriaElegida.equals("Formula 1")) {


            depCategoria = findViewById(R.id.categoria);
            depCategoria.setText(categoriaElegida);

            deportesArray.add(new Deportes(1, "Lewis Hamilton", "Valtteri Bottas", R.drawable.f1, 2019, 04, 25, "16", "00"));
            deportesArray.add(new Deportes(2, "Kimi Raikkonen", "Sebastian Vettel", R.drawable.f1, 2019, 04, 25, "17", "00"));
            deportesArray.add(new Deportes(3, "Max Verstappen", "Daniel Ricciardo", R.drawable.f1, 2019, 04, 25, "18", "00"));
            deportesArray.add(new Deportes(4, "Esteban Ocon", "Sergio Perez", R.drawable.f1, 2019, 04, 25, "19", "00"));
            deportesArray.add(new Deportes(5, "Sergey Sirotkin", "Lance Stroll", R.drawable.f1, 2019, 04, 25, "20", "00"));
            deportesArray.add(new Deportes(6, "Brendon Hartley", "Pierre Gasly", R.drawable.f1, 2019, 04, 25, "21", "00"));
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
        deportes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, BetActivity.class);
                String seleccionado = new Gson().toJson(deportesArray.get(position));
                intent.putExtra(Constants.CODIGO_PASAR_A_APUESTA1, seleccionado);
                startActivity(intent);

            }
        });
    }
}
