package bo.testigos_del_bitcoin.betsports.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import bo.testigos_del_bitcoin.betsports.R;
import bo.testigos_del_bitcoin.betsports.model.Premios;

public class CategoriasPremiosAdapter extends BaseAdapter {

    private Context context;
    private List<Premios> items;

    public CategoriasPremiosAdapter(Context context, List<Premios> items){
        this. context = context;
        this.items = items;
    }

    @Override
    public int getCount(){ return items.size();}

    @Override
    public Premios getItem(int position){
        return items.get(position);
    }

    @Override
    public long getItemId(int position) { return items.get(position).getId();}

    @Override
    public View getView(int position, View vista, ViewGroup parent) {
        ViewHolder viewHolder;
        if(vista == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.layout_premios,null);


        }
        return vista;
    }

    static class ViewHolder{

    }
}
