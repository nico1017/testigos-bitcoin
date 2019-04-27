package bo.testigos_del_bitcoin.betsports;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import bo.testigos_del_bitcoin.betsports.adapter.CategoriasPremiosAdapter;
import bo.testigos_del_bitcoin.betsports.model.Deportes;

public class ListaPremiosActivity extends AppCompatActivity {

    private Context mContext;

    private ListView premios;
    private CategoriasPremiosAdapter premiosAdapter;

    private List<Deportes> premiosArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_premios);
    }
}
