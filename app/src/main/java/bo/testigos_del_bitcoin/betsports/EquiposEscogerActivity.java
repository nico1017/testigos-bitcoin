package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import bo.testigos_del_bitcoin.betsports.adapter.EquipoEscogerAdapter;
import bo.testigos_del_bitcoin.betsports.model.equipos;

public class EquiposEscogerActivity extends AppCompatActivity {
    private Context mContext;
    private ListView equipos;
    private EquipoEscogerAdapter equiposAdapter;
    private List<equipos> equipoArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos_escoger);
        mContext=this;
        equipoArray.add(new equipos(1,"The Strongest" ,R.drawable.futbol ));
        equipoArray.add(new equipos(2,"8olivar" ,R.drawable.futbol ));
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
    private void initViews() {
        equipos = findViewById(R.id.evento);

        equiposAdapter = new EquipoEscogerAdapter(mContext, equipoArray);
        equipos.setAdapter(equiposAdapter);
    }

    private void addEvents() {
    }
}
