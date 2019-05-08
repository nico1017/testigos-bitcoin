package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bo.testigos_del_bitcoin.betsports.adapter.EquipoEscogerAdapter;
import bo.testigos_del_bitcoin.betsports.model.equipos;

public class EquiposEscogerActivity extends AppCompatActivity {
    private Context mContext;
    private ListView equipos;
    private EquipoEscogerAdapter equiposAdapter;
    private List<equipos> equipoArray = new ArrayList<>();
    private String deporteElegido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos_escoger);
        mContext=this;
        receiveData();
        if(deporteElegido.equals("futbol")) {
        equipoArray.add(new equipos(1,"The Strongest" ,R.drawable.futbol ));
        equipoArray.add(new equipos(2,"Bolivar" ,R.drawable.futbol ));
        equipoArray.add(new equipos(3,"Barcelona" ,R.drawable.futbol ));
        equipoArray.add(new equipos(4,"Real Madrid" ,R.drawable.futbol ));
        equipoArray.add(new equipos(5,"Juventus" ,R.drawable.futbol ));
        equipoArray.add(new equipos(6,"Manchester city" ,R.drawable.futbol ));
        equipoArray.add(new equipos(7,"Manchester United" ,R.drawable.futbol ));
        equipoArray.add(new equipos(8,"Ajax" ,R.drawable.futbol ));
        equipoArray.add(new equipos(9,"Liverpool" ,R.drawable.futbol ));
        equipoArray.add(new equipos(10,"AS Roma" ,R.drawable.futbol ));
        equipoArray.add(new equipos(11,"River Plate" ,R.drawable.futbol ));
        equipoArray.add(new equipos(12,"Boca Jr" ,R.drawable.futbol ));
        initViews();
        addEvents();
        }
        if(deporteElegido.equals("basquetball")) {
            equipoArray.add(new equipos(1,"Toronto Raptors" ,R.drawable.futbol ));
            equipoArray.add(new equipos(2,"Los Angeles Lakers" ,R.drawable.futbol ));
            equipoArray.add(new equipos(3,"Chicago Bulls" ,R.drawable.futbol ));
            equipoArray.add(new equipos(4,"New York Knicks" ,R.drawable.futbol ));
            equipoArray.add(new equipos(5,"Orlando Magic" ,R.drawable.futbol ));
            equipoArray.add(new equipos(6,"Houston Rockets" ,R.drawable.futbol ));
            equipoArray.add(new equipos(7,"Philadelphia 76ers" ,R.drawable.futbol ));
            equipoArray.add(new equipos(8,"BostonCeltics" ,R.drawable.futbol ));
            equipoArray.add(new equipos(9,"San Antonio Spurs" ,R.drawable.futbol ));
            equipoArray.add(new equipos(10,"Miami Heat" ,R.drawable.futbol ));
            equipoArray.add(new equipos(11,"Dallas Mavericks" ,R.drawable.futbol ));
            equipoArray.add(new equipos(12,"Atlanta Hawks" ,R.drawable.futbol ));
            initViews();
            addEvents();
        }
        if(deporteElegido.equals("tenis")) {
            equipoArray.add(new equipos(1,"Novak Djokovic" ,R.drawable.futbol ));
            equipoArray.add(new equipos(2,"Roger Federer" ,R.drawable.futbol ));
            equipoArray.add(new equipos(3,"Kevin Anderson" ,R.drawable.futbol ));
            equipoArray.add(new equipos(4,"Stefanos Tsitsipas" ,R.drawable.futbol ));
            equipoArray.add(new equipos(5,"John Isner" ,R.drawable.futbol ));
            equipoArray.add(new equipos(6,"Marin Cilics" ,R.drawable.futbol ));
            equipoArray.add(new equipos(7,"Rafael Nadal" ,R.drawable.futbol ));
            equipoArray.add(new equipos(8,"Alexander Zverev" ,R.drawable.futbol ));
            equipoArray.add(new equipos(9,"Dominic Thiem" ,R.drawable.futbol ));
            equipoArray.add(new equipos(10,"Kei Nishikori" ,R.drawable.futbol ));
            equipoArray.add(new equipos(11,"Juan Martin del Potro" ,R.drawable.futbol ));
            equipoArray.add(new equipos(12,"Fabio Fognini" ,R.drawable.futbol ));
            initViews();
            addEvents();
        }
        if(deporteElegido.equals("ufc")) {
            equipoArray.add(new equipos(1,"Todd Duffee" ,R.drawable.futbol ));
            equipoArray.add(new equipos(2,"Walt Harris" ,R.drawable.futbol ));
            equipoArray.add(new equipos(3,"Daniel Spitz" ,R.drawable.futbol ));
            equipoArray.add(new equipos(4,"Juan Adams" ,R.drawable.futbol ));
            equipoArray.add(new equipos(5,"Luke Rockhold" ,R.drawable.futbol ));
            equipoArray.add(new equipos(6,"Carlos Condit" ,R.drawable.futbol ));
            equipoArray.add(new equipos(7,"Ben Rothwell" ,R.drawable.futbol ));
            equipoArray.add(new equipos(8,"Travis Browne" ,R.drawable.futbol ));
            equipoArray.add(new equipos(9,"Curtis Blaydes" ,R.drawable.futbol ));
            equipoArray.add(new equipos(10,"Tai Tuivasa" ,R.drawable.futbol ));
            equipoArray.add(new equipos(11,"Nick Diaz" ,R.drawable.futbol ));
            equipoArray.add(new equipos(12,"Diego Sanchez" ,R.drawable.futbol ));
            initViews();
            addEvents();
        }
        if(deporteElegido.equals("carrera de caballos")) {
            equipoArray.add(new equipos(1,"Arrogate" ,R.drawable.futbol ));
            equipoArray.add(new equipos(2,"Chautauqua" ,R.drawable.futbol ));
            equipoArray.add(new equipos(3,"DLegal Eagle" ,R.drawable.futbol ));
            equipoArray.add(new equipos(4,"Hoppertunity" ,R.drawable.futbol ));
            equipoArray.add(new equipos(5,"Neorealism" ,R.drawable.futbol ));
            equipoArray.add(new equipos(6,"Heaven" ,R.drawable.futbol ));
            equipoArray.add(new equipos(7,"Winx" ,R.drawable.futbol ));
            equipoArray.add(new equipos(8,"Hartnell" ,R.drawable.futbol ));
            equipoArray.add(new equipos(9,"Werther" ,R.drawable.futbol ));
            equipoArray.add(new equipos(10,"Hey Doc" ,R.drawable.futbol ));
            equipoArray.add(new equipos(11,"Terravista" ,R.drawable.futbol ));
            equipoArray.add(new equipos(12,"Whisky Baron" ,R.drawable.futbol ));
            initViews();
            addEvents();
        }
        if(deporteElegido.equals("formula")) {
            equipoArray.add(new equipos(1,"Lewis Hamilton" ,R.drawable.futbol ));
            equipoArray.add(new equipos(2,"Kimi Raikkonen" ,R.drawable.futbol ));
            equipoArray.add(new equipos(3,"Max Verstappen" ,R.drawable.futbol ));
            equipoArray.add(new equipos(4,"Esteban Ocon" ,R.drawable.futbol ));
            equipoArray.add(new equipos(5,"Sergey Sirotkin" ,R.drawable.futbol ));
            equipoArray.add(new equipos(6,"Brendon Hartley" ,R.drawable.futbol ));
            equipoArray.add(new equipos(7,"Valtteri Bottas" ,R.drawable.futbol ));
            equipoArray.add(new equipos(8,"Sebastian Vettel" ,R.drawable.futbol ));
            equipoArray.add(new equipos(9,"Daniel Ricciardo" ,R.drawable.futbol ));
            equipoArray.add(new equipos(10,"Sergio Perez" ,R.drawable.futbol ));
            equipoArray.add(new equipos(11,"Lance Stroll" ,R.drawable.futbol ));
            equipoArray.add(new equipos(12,"Pierre Gasly" ,R.drawable.futbol ));
            initViews();
            addEvents();
        }
        if(deporteElegido.equals("e sports")) {
            equipoArray.add(new equipos(1,"Liquid" ,R.drawable.futbol ));
            equipoArray.add(new equipos(2,"Mousesport" ,R.drawable.futbol ));
            equipoArray.add(new equipos(3,"Vici Gaming" ,R.drawable.futbol ));
            equipoArray.add(new equipos(4,"Heroic" ,R.drawable.futbol ));
            equipoArray.add(new equipos(5,"Cloud9" ,R.drawable.futbol ));
            equipoArray.add(new equipos(6,"MVP" ,R.drawable.futbol ));
            equipoArray.add(new equipos(7,"NiP" ,R.drawable.futbol ));
            equipoArray.add(new equipos(8,"BIG" ,R.drawable.futbol ));
            equipoArray.add(new equipos(9,"NRG" ,R.drawable.futbol ));
            equipoArray.add(new equipos(10,"FNATIC" ,R.drawable.futbol ));
            equipoArray.add(new equipos(11,"TeamSoloMid" ,R.drawable.futbol ));
            equipoArray.add(new equipos(12,"OpTic Gaming" ,R.drawable.futbol ));
            initViews();
            addEvents();
        }
        if(deporteElegido.equals("pelea de gallos")) {
            equipoArray.add(new equipos(1,"Chicken Little" ,R.drawable.futbol ));
            equipoArray.add(new equipos(2,"Gallo Campine" ,R.drawable.futbol ));
            equipoArray.add(new equipos(3,"Kelso" ,R.drawable.futbol ));
            equipoArray.add(new equipos(4,"Radio" ,R.drawable.futbol ));
            equipoArray.add(new equipos(5,"Hatch" ,R.drawable.futbol ));
            equipoArray.add(new equipos(6,"Albany" ,R.drawable.futbol ));
            equipoArray.add(new equipos(7,"El Gallo Claudio" ,R.drawable.futbol ));
            equipoArray.add(new equipos(8,"Brahma" ,R.drawable.futbol ));
            equipoArray.add(new equipos(9,"Combatiente Ingles" ,R.drawable.futbol ));
            equipoArray.add(new equipos(10,"Giro Hatch" ,R.drawable.futbol ));
            equipoArray.add(new equipos(11,"Brownred" ,R.drawable.futbol ));
            equipoArray.add(new equipos(12,"RoundHead" ,R.drawable.futbol ));
            initViews();
            addEvents();
        }
    }
    private void initViews() {
        equipos = findViewById(R.id.evento);

        equiposAdapter = new EquipoEscogerAdapter(mContext, equipoArray);
        equipos.setAdapter(equiposAdapter);
    }
    private void receiveData() {
        Intent intent = getIntent();
        deporteElegido = intent.getStringExtra(Constants.KEY_DEPORTE_CHECKBOX);
    }

    private void addEvents() {
        equipos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, MainMenuActivity.class);
                Toast.makeText(mContext, "Elecciones: " + equipoArray.get(position).getEquipo(), Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }
}
