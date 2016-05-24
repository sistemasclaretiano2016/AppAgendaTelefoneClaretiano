package br.android.appagendatelefone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaInicial extends Activity implements View.OnClickListener{

    private Button btnAdicionar;
    private Button btnAtualizar;
    private Button btnRemover;
    private Button btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        btnAdicionar = (Button)findViewById(R.id.btnAdicionar);
        btnAtualizar = (Button)findViewById(R.id.btnAtualizar);
        btnRemover = (Button)findViewById(R.id.btnRemover);
        btnListar = (Button)findViewById(R.id.btnListar);
        btnAdicionar.setOnClickListener(this);
        btnAtualizar.setOnClickListener(this);
        btnRemover.setOnClickListener(this);
        btnListar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent it = null;
        switch (view.getId()){
            case R.id.btnAdicionar:
                it = new Intent(getApplicationContext(),TelaAdicionar.class);
                break;
            case R.id.btnAtualizar:
                it = new Intent(getApplicationContext(),TelaAdicionar.class);
                break;
            case R.id.btnRemover:
                it = new Intent(getApplicationContext(),TelaAdicionar.class);
                break;
            case R.id.btnListar:
                it = new Intent(getApplicationContext(),TelaListar.class);
                break;
        }
        if(it!=null){
            startActivity(it);
        }
    }
}
