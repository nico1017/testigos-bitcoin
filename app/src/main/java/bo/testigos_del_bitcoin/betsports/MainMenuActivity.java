package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toolbar;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mContext = this;

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
        ///TODO llenar todas las listas
        listProximos = new ArrayList<>();
        listPopulares = new ArrayList<>();
        listEnJuego = new ArrayList<>();
        listProximos.add(new Deportes(1, "Equipo A", "Equipo B", R.drawable.futbol, 2019,5,4, 8, 30));
        listProximos.add(new Deportes(1, "Equipo C", "Equipo D", R.drawable.futbol, 2019,5,4, 10, 30));
        listProximos.add(new Deportes(1, "Equipo E", "Equipo F", R.drawable.futbol, 2019,5,5, 9, 00));
        listProximos.add(new Deportes(1, "Equipo G", "Equipo H", R.drawable.futbol, 2019,5,5, 12, 00));
        listProximos.add(new Deportes(1, "Equipo I", "Equipo J", R.drawable.futbol, 2019,5,7, 8, 30));
        listProximos.add(new Deportes(1, "Equipo K", "Equipo L", R.drawable.futbol, 2019,5,7, 13, 30));
        listProximos.add(new Deportes(1, "Equipo M", "Equipo N", R.drawable.futbol, 2019,5,7, 13, 30));
        listProximos.add(new Deportes(1, "Equipo O", "Equipo O", R.drawable.futbol, 2019,5,7, 13, 30));

        listPopulares.add(new Deportes(1, "Equipo C", "Equipo D", R.drawable.baloncesto, 2019,5,4, 10, 30));
        listPopulares.add(new Deportes(1, "Equipo C", "Equipo D", R.drawable.baloncesto, 2019,5,4, 10, 30));
        listPopulares.add(new Deportes(1, "Equipo C", "Equipo D", R.drawable.baloncesto, 2019,5,4, 10, 30));
        listPopulares.add(new Deportes(1, "Equipo C", "Equipo D", R.drawable.baloncesto, 2019,5,4, 10, 30));
        listPopulares.add(new Deportes(1, "Equipo C", "Equipo D", R.drawable.baloncesto, 2019,5,4, 10, 30));
        listPopulares.add(new Deportes(1, "Equipo C", "Equipo D", R.drawable.baloncesto, 2019,5,4, 10, 30));
        listPopulares.add(new Deportes(1, "Equipo C", "Equipo D", R.drawable.baloncesto, 2019,5,4, 10, 30));
        listPopulares.add(new Deportes(1, "Equipo C", "Equipo D", R.drawable.baloncesto, 2019,5,4, 10, 30));
        listPopulares.add(new Deportes(1, "Equipo C", "Equipo D", R.drawable.baloncesto, 2019,5,4, 10, 30));

        listEnJuego.add(new Deportes(1, "Equipo C", "Equipo D", R.drawable.e_sports, 2019,5,4, 10, 30));
        listEnJuego.add(new Deportes(1, "Equipo C", "Equipo D", R.drawable.e_sports, 2019,5,4, 10, 30));
        listEnJuego.add(new Deportes(1, "Equipo C", "Equipo D", R.drawable.e_sports, 2019,5,4, 10, 30));
        listEnJuego.add(new Deportes(1, "Equipo C", "Equipo D", R.drawable.e_sports, 2019,5,4, 10, 30));
        listEnJuego.add(new Deportes(1, "Equipo C", "Equipo D", R.drawable.e_sports, 2019,5,4, 10, 30));
        listEnJuego.add(new Deportes(1, "Equipo C", "Equipo D", R.drawable.e_sports, 2019,5,4, 10, 30));
        listEnJuego.add(new Deportes(1, "Equipo C", "Equipo D", R.drawable.e_sports, 2019,5,4, 10, 30));
        listEnJuego.add(new Deportes(1, "Equipo C", "Equipo D", R.drawable.e_sports, 2019,5,4, 10, 30));
    }

    public void addEvents(){
        proximos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoriasDeportesAdapter adapter = new CategoriasDeportesAdapter(mContext, listProximos);
                listaGeneral.setAdapter(adapter);
            }
        });

        populares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoriasDeportesAdapter adapter = new CategoriasDeportesAdapter(mContext, listPopulares);
                listaGeneral.setAdapter(adapter);
            }
        });

        juego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoriasDeportesAdapter adapter = new CategoriasDeportesAdapter(mContext, listEnJuego);
                listaGeneral.setAdapter(adapter);
            }
        });
    }
}
