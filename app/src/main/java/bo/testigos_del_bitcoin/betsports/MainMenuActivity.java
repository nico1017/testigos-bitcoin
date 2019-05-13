package bo.testigos_del_bitcoin.betsports;

 import android.content.Context;
import android.content.Intent;
 import android.content.SharedPreferences;
 import android.net.Uri;
 import android.preference.PreferenceManager;
 import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import bo.testigos_del_bitcoin.betsports.adapter.CategoriasDeportesAdapter;
 import bo.testigos_del_bitcoin.betsports.db.DatabaseHelper;
 import bo.testigos_del_bitcoin.betsports.model.Deportes;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;
    private String usuarioConectado;

    private Button proximos;
    private Button populares;
    private Button juego;
    private ListView listaGeneral;
    private int listaActual;
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;

    private List<Deportes> listProximos;
    private List<Deportes> listPopulares;
    private List<Deportes> listEnJuego;

    private TextView Futbol;
    private TextView Baloncesto;
    private TextView Tenis;
    private TextView E_sports;
    private TextView Gallos;
    private TextView Caballos;
    private TextView Ufc;
    private TextView F1;

    private View panelDep;
    private View panelPrem;

    private TextView TarjetasRegalo;
    private TextView Electronicos;
    private TextView ArticulosDeportivos;

    private TextView cantidad_monedas;
    private DatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mContext = this;
        listaActual = 1;

        createLists();
        initViews();
        addEvents();

        Intent intent = getIntent();
        usuarioConectado = intent.getStringExtra(Constants.CODIGO_PASAR_A_MAINMENU);

        dbhelper = new DatabaseHelper(mContext);
        cantidad_monedas.setText(String.valueOf(dbhelper.getMonedasDeUsuario(usuarioConectado)));

        if (this.toolbar != null) {
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
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        cantidad_monedas.setText(String.valueOf(dbhelper.getMonedasDeUsuario(usuarioConectado)) + "$");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        cantidad_monedas.setText(String.valueOf(dbhelper.getMonedasDeUsuario(usuarioConectado)) + "$");
    }

    @Override
    protected void onStart(){
        super.onStart();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        cantidad_monedas.setText(String.valueOf(dbhelper.getMonedasDeUsuario(usuarioConectado)) + "$");
    }

    @Override
    protected void onPause(){
        super.onPause();
        cantidad_monedas.setText(String.valueOf(dbhelper.getMonedasDeUsuario(usuarioConectado)) + "$");
    }

    @Override
    protected void onStop() {
        super.onStop();
        cantidad_monedas.setText(String.valueOf(dbhelper.getMonedasDeUsuario(usuarioConectado)) + "$");
    }

    public void initViews(){
        proximos = findViewById(R.id.proximos);
        populares = findViewById(R.id.populares);
        juego = findViewById(R.id.juego);
        listaGeneral = findViewById(R.id.lista);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.navigationDrawer);
        CategoriasDeportesAdapter adapter = new CategoriasDeportesAdapter(mContext, listProximos);
        listaGeneral.setAdapter(adapter);
        Futbol = findViewById(R.id.Futbol);
        Baloncesto = findViewById(R.id.Baloncesto);
        Tenis = findViewById(R.id.Tenis);
        E_sports = findViewById(R.id.Esports);
        Gallos = findViewById(R.id.Gallo);
        Caballos = findViewById(R.id.Caballo);
        Ufc = findViewById(R.id.Ufc);
        F1 = findViewById(R.id.F1);

        panelDep = findViewById(R.id.panelDep);
        panelPrem = findViewById(R.id.panelPremios);

        TarjetasRegalo = findViewById(R.id.Tarjetas);
        Electronicos = findViewById(R.id.Electronicos);
        ArticulosDeportivos = findViewById(R.id.Deportivos);
        cantidad_monedas = findViewById(R.id.cantidad_monedas);
    }

    public void createLists(){
        listProximos = new ArrayList<>();
        listPopulares = new ArrayList<>();
        listEnJuego = new ArrayList<>();
        listProximos.add(new Deportes(1, "Toronto Raptors", "Philadelphia 76ers", R.drawable.baloncesto, 2019, 04, 25, "16", "00"));
        listProximos.add(new Deportes(2, "Los Angeles Lakers", "BostonCeltics", R.drawable.baloncesto, 2019, 04, 25, "17", "00"));
        listProximos.add(new Deportes(3, "Novak Djokovic", "Rafael Nadal", R.drawable.tenis, 2019, 04, 25, "16", "00"));
        listProximos.add(new Deportes(4, "Roger Federer", "Alexander Zverev", R.drawable.tenis, 2019, 04, 25, "17", "00"));
        listProximos.add(new Deportes(5, "Chicken Little", "El Gallo Claudio", R.drawable.gallo, 2019, 04, 25, "16", "00"));
        listProximos.add(new Deportes(6, "Gallo Campine", "Brahma", R.drawable.gallo, 2019, 04, 25, "17", "00"));
        listProximos.add(new Deportes(7, "Todd Duffee", "Ben Rothwell", R.drawable.ufc, 2019, 04, 25, "16", "00"));
        listProximos.add(new Deportes(8, "Walt Harris", "Travis Browne", R.drawable.ufc, 2019, 04, 25, "17", "00"));

        listPopulares.add(new Deportes(0, "hola", "chau", R.drawable.baloncesto, 2019, 04, 25, "16", "00"));
        listPopulares.add(new Deportes(1, "Toronto Raptors", "Philadelphia 76ers", R.drawable.baloncesto, 2019, 04, 25, "16", "00"));
        listPopulares.add(new Deportes(2, "Los Angeles Lakers", "BostonCeltics", R.drawable.baloncesto, 2019, 04, 25, "17", "00"));
        listPopulares.add(new Deportes(3, "Novak Djokovic", "Rafael Nadal", R.drawable.tenis, 2019, 04, 25, "16", "00"));
        listPopulares.add(new Deportes(4, "Roger Federer", "Alexander Zverev", R.drawable.tenis, 2019, 04, 25, "17", "00"));
        listPopulares.add(new Deportes(5, "Chicken Little", "El Gallo Claudio", R.drawable.gallo, 2019, 04, 25, "16", "00"));
        listPopulares.add(new Deportes(6, "Gallo Campine", "Brahma", R.drawable.gallo, 2019, 04, 25, "17", "00"));
        listPopulares.add(new Deportes(7, "Todd Duffee", "Ben Rothwell", R.drawable.ufc, 2019, 04, 25, "16", "00"));
        listPopulares.add(new Deportes(8, "Walt Harris", "Travis Browne", R.drawable.ufc, 2019, 04, 25, "17", "00"));

        listEnJuego.add(new Deportes(1, "Toronto Raptors", "Philadelphia 76ers", R.drawable.baloncesto, 2019, 04, 25, "16", "00"));
        listEnJuego.add(new Deportes(2, "Los Angeles Lakers", "BostonCeltics", R.drawable.baloncesto, 2019, 04, 25, "17", "00"));
        listEnJuego.add(new Deportes(3, "Novak Djokovic", "Rafael Nadal", R.drawable.tenis, 2019, 04, 25, "16", "00"));
        listEnJuego.add(new Deportes(4, "Roger Federer", "Alexander Zverev", R.drawable.tenis, 2019, 04, 25, "17", "00"));
        listEnJuego.add(new Deportes(5, "Chicken Little", "El Gallo Claudio", R.drawable.gallo, 2019, 04, 25, "16", "00"));
        listEnJuego.add(new Deportes(6, "Gallo Campine", "Brahma", R.drawable.gallo, 2019, 04, 25, "17", "00"));
        listEnJuego.add(new Deportes(7, "Todd Duffee", "Ben Rothwell", R.drawable.ufc, 2019, 04, 25, "16", "00"));
        listEnJuego.add(new Deportes(8, "Walt Harris", "Travis Browne", R.drawable.ufc, 2019, 04, 25, "17", "00"));
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

        listaGeneral.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(listaActual == 1) {
                    mostrarLista(1, position);
                }else if(listaActual == 2){
                    mostrarLista(2, position);
                }else if(listaActual == 3){
                    mostrarLista(3, position);
                }
            }
        });
    }

    public void goToCategorias(View view){
        Intent intent = new Intent(mContext, CategoriasDeportesActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        String url = "https://www.facebook.com/BetSports-852952505043115/?modal=admin_todo_tour";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void mostrarLista(int i, int position){
        if(i == 1){
            Intent intent = new Intent(mContext, BetActivity.class);
            String seleccionado = new Gson().toJson(listProximos.get(position));
            intent.putExtra(Constants.CODIGO_PASAR_A_APUESTA1, seleccionado);
            intent.putExtra(Constants.CODIGO_PASAR_A_APUESTA, usuarioConectado);
            startActivity(intent);
        }else if(i == 2){
            Intent intent = new Intent(mContext, BetActivity.class);
            String seleccionado = new Gson().toJson(listPopulares.get(position));
            intent.putExtra(Constants.CODIGO_PASAR_A_APUESTA2, seleccionado);
            intent.putExtra(Constants.CODIGO_PASAR_A_APUESTA, usuarioConectado);
            startActivity(intent);
        }else if(i == 3){
            Intent intent = new Intent(mContext, BetActivity.class);
            String seleccionado = new Gson().toJson(listEnJuego.get(position));
            intent.putExtra(Constants.CODIGO_PASAR_A_APUESTA3, seleccionado);
            intent.putExtra(Constants.CODIGO_PASAR_A_APUESTA, usuarioConectado);
            startActivity(intent);
        }
    }


    public void goToFutbol(View view){
        String deporte = Futbol.getText().toString();

        Intent intent = new Intent(mContext, ListaDeportesActivity.class);
        intent.putExtra(Constants.KEY_DEPORTE, deporte);
        intent.putExtra(Constants.CODIGO_PASAR_NOMBRE_USUARIO, usuarioConectado);
        startActivity(intent);
    }

    public void goToBaloncesto(View view){
        String deporte = Baloncesto.getText().toString();

        Intent intent = new Intent(mContext, ListaDeportesActivity.class);
        intent.putExtra(Constants.KEY_DEPORTE, deporte);
        intent.putExtra(Constants.CODIGO_PASAR_NOMBRE_USUARIO, usuarioConectado);
        startActivity(intent);
    }

    public void goToTenis(View view){
        String deporte = Tenis.getText().toString();

        Intent intent = new Intent(mContext, ListaDeportesActivity.class);
        intent.putExtra(Constants.KEY_DEPORTE, deporte);
        intent.putExtra(Constants.CODIGO_PASAR_NOMBRE_USUARIO, usuarioConectado);
        startActivity(intent);
    }

    public void goToEsports(View view){
        String deporte = E_sports.getText().toString();

        Intent intent = new Intent(mContext, ListaDeportesActivity.class);
        intent.putExtra(Constants.KEY_DEPORTE, deporte);
        intent.putExtra(Constants.CODIGO_PASAR_NOMBRE_USUARIO, usuarioConectado);
        startActivity(intent);
    }

    public void goToGallo(View view){
        String deporte = Gallos.getText().toString();

        Intent intent = new Intent(mContext, ListaDeportesActivity.class);
        intent.putExtra(Constants.KEY_DEPORTE, deporte);
        intent.putExtra(Constants.CODIGO_PASAR_NOMBRE_USUARIO, usuarioConectado);
        startActivity(intent);
    }

    public void goToCaballo(View view){
        String deporte = Caballos.getText().toString();

        Intent intent = new Intent(mContext, ListaDeportesActivity.class);
        intent.putExtra(Constants.KEY_DEPORTE, deporte);
        intent.putExtra(Constants.CODIGO_PASAR_NOMBRE_USUARIO, usuarioConectado);
        startActivity(intent);
    }

    public void goToUfc(View view){
        String deporte = Ufc.getText().toString();

        Intent intent = new Intent(mContext, ListaDeportesActivity.class);
        intent.putExtra(Constants.KEY_DEPORTE, deporte);
        intent.putExtra(Constants.CODIGO_PASAR_NOMBRE_USUARIO, usuarioConectado);
        startActivity(intent);
    }

    public void goToF1(View view){
        String deporte = F1.getText().toString();

        Intent intent = new Intent(mContext, ListaDeportesActivity.class);
        intent.putExtra(Constants.KEY_DEPORTE, deporte);
        intent.putExtra(Constants.CODIGO_PASAR_NOMBRE_USUARIO, usuarioConectado);
        startActivity(intent);
    }

    public void goToTarjetas(View view){
        String premio = TarjetasRegalo.getText().toString();

        Intent intent = new Intent(mContext, ListaPremiosActivity.class);
        intent.putExtra(Constants.KEY_PREMIO, premio);
        intent.putExtra(Constants.CODIGO_PASAR_NOMBRE_USUARIO, usuarioConectado);
        startActivity(intent);
    }

    public void goToElectronicos(View view){
        String premio1 = Electronicos.getText().toString();

        Intent intent = new Intent(mContext, ListaPremiosActivity.class);
        intent.putExtra(Constants.KEY_PREMIO, premio1);
        intent.putExtra(Constants.CODIGO_PASAR_NOMBRE_USUARIO, usuarioConectado);
        startActivity(intent);
    }

    public void goToDeportivos(View view){
        String premio = ArticulosDeportivos.getText().toString();

        Intent intent = new Intent(mContext, ListaPremiosActivity.class);
        intent.putExtra(Constants.KEY_PREMIO, premio);
        intent.putExtra(Constants.CODIGO_PASAR_NOMBRE_USUARIO, usuarioConectado);
        startActivity(intent);
    }

    public void goToDatosUsuario(View view){
        Intent intent = new Intent(mContext, DatosUsuario.class);
        intent.putExtra(Constants.CODIGO_PASAR_A_DATOSUSUARIO, usuarioConectado);
        startActivity(intent);
    }

    public void showDeportes(View view){
        panelDep.setVisibility(View.VISIBLE);
        panelPrem.setVisibility(View.GONE);
    }

    public void showPremios(View view){
        panelDep.setVisibility(View.GONE);
        panelPrem.setVisibility(View.VISIBLE);
    }
}
