package bo.testigos_del_bitcoin.betsports.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bo.testigos_del_bitcoin.betsports.R;
import bo.testigos_del_bitcoin.betsports.model.Deportes;

public class CategoriasDeportesAdapter extends BaseAdapter {

    private Context context;
    private List<Deportes> items;

    public CategoriasDeportesAdapter(Context context, List<Deportes> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {return items.size();}

    @Override
    public Deportes getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {return items.get(position).getId();}

    @Override
    public View getView(int position, View vista, ViewGroup parent){
        ViewHolder viewHolder;
        if(vista == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.layout_deportes,null);

            viewHolder.logo = vista.findViewById(R.id.logo);
            viewHolder.anio = vista.findViewById(R.id.anio);
            viewHolder.mes = vista.findViewById(R.id.mes);
            viewHolder.dia = vista.findViewById(R.id.dia);
            viewHolder.hora= vista.findViewById(R.id.hora);
            viewHolder.minutos = vista.findViewById(R.id.minutos);
            viewHolder.equipoA = vista.findViewById(R.id.equipoA);
            viewHolder.equipoB = vista.findViewById(R.id.equipoB);
            vista.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) vista.getTag();
        }
        Deportes deporteActual = items.get(position);
        viewHolder.logo.setImageResource(deporteActual.getLogo());
        viewHolder.anio.setText(String.valueOf(deporteActual.getAnio()));
        viewHolder.mes.setText(String.valueOf(deporteActual.getMes()));
        viewHolder.dia.setText(String.valueOf(deporteActual.getDia()));
        viewHolder.hora.setText(String.valueOf(deporteActual.getHora()));
        viewHolder.minutos.setText(String.valueOf(deporteActual.getMinutos()));
        viewHolder.equipoA.setText(deporteActual.getEquipoUno());
        viewHolder.equipoB.setText(deporteActual.getEquipoDos());
        return vista;
    }

    static class ViewHolder {
        ImageView logo;
        TextView anio;
        TextView mes;
        TextView dia;
        TextView hora;
        TextView minutos;
        TextView equipoA;
        TextView equipoB;
    }
}
