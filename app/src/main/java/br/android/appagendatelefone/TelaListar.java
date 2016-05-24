package br.android.appagendatelefone;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class TelaListar extends Activity {

    private ListView lista;
    private List<ContentValues> listaContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_listar);

        lista = (ListView)findViewById(R.id.lista);

        //CONSULTAR CONTATOS
        listaContato = new ContatoDAO(this).listar();

        //EXIBIR NO ListView
        AdapterListView adpt = new AdapterListView(this,listaContato);
        lista.setAdapter(adpt);

    }
}
