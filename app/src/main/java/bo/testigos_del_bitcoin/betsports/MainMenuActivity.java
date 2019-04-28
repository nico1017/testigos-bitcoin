package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import bo.testigos_del_bitcoin.betsports.adapter.CategoriasDeportesAdapter;
import bo.testigos_del_bitcoin.betsports.model.Deportes;

public class MainMenuActivity extends AppCompatActivity {

    private Context mContext;

    private Button proximos;
    private Button populares;
    private Button juego;
    private ListView listaGeneral;
    //private Toolbar toolbar;
    //private ActionBarDrawerToggle drawerToggle;
    //private DrawerLayout drawerLayout;

    private List<Deportes> listProximos;
    private List<Deportes> listPopulares;
    private List<Deportes> listEnJuego;

    private int listaActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mContext = this;
        listaActual = 1;

        createLists();
        initViews();
        addEvents();

        /*if (this.toolbar != null) {
            // Aqui configuramos nuestro Toolbar, con el ícono del Drawer a la izquierda
            this.toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));

            drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
            drawerToggle.setDrawerIndicatorEnabled(false);
            drawerToggle.setHomeAsUpIndicator(R.drawable.icon_hamburger);
            drawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawerLayout.openDrawer(GravityCompat.START); // Podemos abrir y cerrar nuestro drawer programáticamente!!
                }
            });
        }*/
    }

    public void initViews(){
        proximos = findViewById(R.id.proximos);
        populares = findViewById(R.id.populares);
        juego = findViewById(R.id.juego);
        listaGeneral = findViewById(R.id.lista);
        //toolbar = findViewById(R.id.toolbar);
        //drawerLayout = findViewById(R.layout.--);
        CategoriasDeportesAdapter adapter = new CategoriasDeportesAdapter(mContext, listProximos);
        listaGeneral.setAdapter(adapter);
    }

    public void createLists(){
        listProximos = new ArrayList<>();
        listPopulares = new ArrayList<>();
        listEnJuego = new ArrayList<>();
        listProximos.add(new Deportes(1, "Equipo A", "Equipo B", R.drawable.futbol, 2019,5,4, 8, 30));
        listProximos.add(new Deportes(2, "Equipo C", "Equipo D", R.drawable.futbol, 2019,5,4, 10, 30));
        listProximos.add(new Deportes(3, "Equipo E", "Equipo F", R.drawable.futbol, 2019,5,5, 9, 00));
        listProximos.add(new Deportes(4, "Equipo G", "Equipo H", R.drawable.futbol, 2019,5,5, 12, 00));
        listProximos.add(new Deportes(5, "Equipo I", "Equipo J", R.drawable.futbol, 2019,5,7, 8, 30));
        listProximos.add(new Deportes(6, "Equipo K", "Equipo L", R.drawable.futbol, 2019,5,7, 13, 30));
        listProximos.add(new Deportes(7, "Equipo M", "Equipo N", R.drawable.futbol, 2019,5,7, 13, 30));
        listProximos.add(new Deportes(8, "Equipo O", "Equipo P", R.drawable.futbol, 2019,5,7, 13, 30));

        listPopulares.add(new Deportes(1, "Equipo A", "Equipo B", R.drawable.baloncesto, 2019,5,4, 10, 30));
        listPopulares.add(new Deportes(2, "Equipo C", "Equipo D", R.drawable.baloncesto, 2019,5,4, 10, 30));
        listPopulares.add(new Deportes(3, "Equipo E", "Equipo F", R.drawable.baloncesto, 2019,5,4, 10, 30));
        listPopulares.add(new Deportes(4, "Equipo G", "Equipo H", R.drawable.baloncesto, 2019,5,4, 10, 30));
        listPopulares.add(new Deportes(5, "Equipo I", "Equipo J", R.drawable.baloncesto, 2019,5,4, 10, 30));
        listPopulares.add(new Deportes(6, "Equipo K", "Equipo L", R.drawable.baloncesto, 2019,5,4, 10, 30));
        listPopulares.add(new Deportes(7, "Equipo M", "Equipo N", R.drawable.baloncesto, 2019,5,4, 10, 30));
        listPopulares.add(new Deportes(8, "Equipo O", "Equipo P", R.drawable.baloncesto, 2019,5,4, 10, 30));

        listEnJuego.add(new Deportes(1, "Equipo A", "Equipo B", R.drawable.e_sports, 2019,5,4, 10, 30));
        listEnJuego.add(new Deportes(2, "Equipo C", "Equipo D", R.drawable.e_sports, 2019,5,4, 10, 30));
        listEnJuego.add(new Deportes(3, "Equipo E", "Equipo F", R.drawable.e_sports, 2019,5,4, 10, 30));
        listEnJuego.add(new Deportes(4, "Equipo G", "Equipo H", R.drawable.e_sports, 2019,5,4, 10, 30));
        listEnJuego.add(new Deportes(5, "Equipo I", "Equipo J", R.drawable.e_sports, 2019,5,4, 10, 30));
        listEnJuego.add(new Deportes(6, "Equipo K", "Equipo L", R.drawable.e_sports, 2019,5,4, 10, 30));
        listEnJuego.add(new Deportes(7, "Equipo M", "Equipo N", R.drawable.e_sports, 2019,5,4, 10, 30));
        listEnJuego.add(new Deportes(8, "Equipo O", "Equipo P", R.drawable.e_sports, 2019,5,4, 10, 30));
    }

    public void addEvents(){
        proximos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoriasDeportesAdapter adapter = new CategoriasDeportesAdapter(mContext, listProximos);
                listaGeneral.setAdapter(adapter);
                listaActual = 1;
            }
        });

        populares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoriasDeportesAdapter adapter = new CategoriasDeportesAdapter(mContext, listPopulares);
                listaGeneral.setAdapter(adapter);
                listaActual = 2;
            }
        });

        juego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoriasDeportesAdapter adapter = new CategoriasDeportesAdapter(mContext, listEnJuego);
                listaGeneral.setAdapter(adapter);
                listaActual = 3;
            }
        });

        if(listaActual == 1) {
            listaGeneral.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(mContext, BetActivity.class);
                    String seleccionado = new Gson().toJson(listProximos.get(position));
                    intent.putExtra(Constants.CODIGO_PASAR_A_APUESTA, seleccionado);
                    startActivity(intent);

                }
            });
        }else if(listaActual == 2){
            listaGeneral.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(mContext, BetActivity.class);
                    String seleccionado = new Gson().toJson(listPopulares.get(position));
                    intent.putExtra(Constants.CODIGO_PASAR_A_APUESTA, seleccionado);
                    startActivity(intent);

                }
            });
        }else if(listaActual == 3){
            listaGeneral.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(mContext, BetActivity.class);
                    String seleccionado = new Gson().toJson(listEnJuego.get(position));
                    intent.putExtra(Constants.CODIGO_PASAR_A_APUESTA, seleccionado);
                    startActivity(intent);

                }
            });
        }
    }
}
