package br.android.appagendatelefone;


import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterListView extends BaseAdapter {

    private List<ContentValues> lista;
    private LayoutInflater layout;

    public AdapterListView(Context c, List<ContentValues> lista){
        this.lista = lista;
        this.layout = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ContentValues contato = lista.get(position);
        convertView = layout.inflate(R.layout.item_lista,null);

        TextView tv1 = (TextView)convertView.findViewById(R.id.tvId);
        TextView tv2 = (TextView)convertView.findViewById(R.id.tvNome);
        TextView tv3 = (TextView)convertView.findViewById(R.id.tvTelefone);

        tv1.setText(contato.getAsString("id"));
        tv2.setText(contato.getAsString("nome"));
        tv3.setText(contato.getAsString("telefone"));


        return convertView;
    }
}
