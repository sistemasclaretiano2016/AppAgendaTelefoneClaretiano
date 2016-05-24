package br.android.appagendatelefone;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaAdicionar extends Activity implements View.OnClickListener {

    private Button btnSalvar;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_adicionar);

        btnSalvar = (Button)findViewById(R.id.btnSalvar);
        btnCancelar = (Button)findViewById(R.id.btnCancelar);
        btnSalvar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnSalvar){

            EditText edt1 = (EditText)findViewById(R.id.edtNome);
            EditText edt2 = (EditText)findViewById(R.id.edtTelefone);

            ContentValues contato = new ContentValues();
            contato.put("nome",edt1.getText().toString());
            contato.put("telefone",edt2.getText().toString());

            long id = new ContatoDAO(this).inserir(contato);
            if ( id > 0 ){
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setMessage("Operação realizada com sucesso!\nID="+id);
                dlg.setCancelable(false);
                dlg.setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TelaAdicionar.this.finish();
                    }
                });
                dlg.show();
            }


        }else if (view.getId()==R.id.btnCancelar){
            super.onBackPressed();
        }
    }
}
