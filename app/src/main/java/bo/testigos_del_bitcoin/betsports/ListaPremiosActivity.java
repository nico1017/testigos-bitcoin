package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import bo.testigos_del_bitcoin.betsports.adapter.CategoriasPremiosAdapter;
import bo.testigos_del_bitcoin.betsports.model.Deportes;
import bo.testigos_del_bitcoin.betsports.model.Premios;

public class ListaPremiosActivity extends AppCompatActivity {

    private Context mContext;

    private String categoriaElegida;

    private GridView premios;
    private TextView premCategoria;
    private CategoriasPremiosAdapter premiosAdapter;

    private List<Premios> premiosArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_premios);
        mContext = this;

        receiveData();

        if(categoriaElegida.equals("Tarjetas de Regalo")) {


            premCategoria = findViewById(R.id.premio);
            premCategoria.setText(categoriaElegida);

            premiosArray.add(new Premios(1,R.drawable.tarplaystation,10000,"Tarjeta PlayStation Store","Tarjeta PlayStation Store"));
            premiosArray.add(new Premios(2,R.drawable.tarxbox,10000,"Tarjeta Xbox Live","Tarjeta Xbox Live"));
            premiosArray.add(new Premios(3,R.drawable.tarspotify,10000,"Tarjeta Spotify","Tarjeta Spotify"));
            premiosArray.add(new Premios(4,R.drawable.taramazon,10000,"Tarjeta Amazon","Tarjeta Amazon"));
            premiosArray.add(new Premios(5,R.drawable.tarplaystore,10000,"Tarjeta PlayStore","Tarjeta PlayStore"));
            premiosArray.add(new Premios(6,R.drawable.tarnetflix,10000,"Tarjeta Netflix","Tarjeta Netflix"));
        }

        if(categoriaElegida.equals("Electronicos")) {


            premCategoria = findViewById(R.id.premio);
            premCategoria.setText(categoriaElegida);

            premiosArray.add(new Premios(1,R.drawable.ps4,2000000,"PS4","PlayStation 4"));
            premiosArray.add(new Premios(2,R.drawable.xbox,2000000,"PS5","PlayStation 5"));
            premiosArray.add(new Premios(3,R.drawable.beats,750000,"PS4","PlayStation 4"));
            premiosArray.add(new Premios(4,R.drawable.nintendo,2000000,"PS5","PlayStation 5"));
            premiosArray.add(new Premios(5,R.drawable.iphone,2000000,"PS4","PlayStation 4"));
            premiosArray.add(new Premios(6,R.drawable.laptop,1500000,"PS5","PlayStation 5"));
        }

        if(categoriaElegida.equals("Articulos Deportivos")) {


            premCategoria = findViewById(R.id.premio);
            premCategoria.setText(categoriaElegida);

            premiosArray.add(new Premios(1,R.drawable.pelota,2000,"Pelota de Futbol","Pelota de Futbol"));
            premiosArray.add(new Premios(2,R.drawable.polera,5000,"Polera","Polera"));
            premiosArray.add(new Premios(3,R.drawable.bate,2000,"Bate de beisbol","Bate de beisbol"));
            premiosArray.add(new Premios(4,R.drawable.bate,5000,"Bate de beisbol","Bate de beisbol"));
            premiosArray.add(new Premios(5,R.drawable.polera,2000,"Polera","Polera"));
            premiosArray.add(new Premios(6,R.drawable.pelota,5000,"Pelota de Futbol","Pelota de Futbol"));
        }

        initViews();
        //addEvents();
    }

    private void receiveData() {
        Intent intent = getIntent();
        categoriaElegida = intent.getStringExtra(Constants.KEY_PREMIO);
    }

    private void initViews() {
        premios = findViewById(R.id.premios);

        premiosAdapter = new CategoriasPremiosAdapter(mContext, premiosArray);
        premios.setAdapter(premiosAdapter);
    }

    /*private void addEvents() {
        premios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, BetActivity.class);
                String seleccionado = new Gson().toJson(deportesArray.get(position));
                intent.putExtra(Constants.CODIGO_PASAR_A_APUESTA1, seleccionado);
                startActivity(intent);

            }
        });
    }*/
}
