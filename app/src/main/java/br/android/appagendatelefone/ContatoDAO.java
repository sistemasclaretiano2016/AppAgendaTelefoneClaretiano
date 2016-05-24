package br.android.appagendatelefone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ContatoDAO extends SQLiteOpenHelper {

    private String SQL =
        "CREATE TABLE contato( " +
            "id integer primary key autoincrement," +
            "nome text,     " +
            "telefone text " +
        ")";

    private SQLiteDatabase db; //enviar as instruções para o BD

    public ContatoDAO(Context contexto){
        super(contexto,"agenda.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE contato;");
        db.execSQL(SQL);
    }

    public long inserir(ContentValues contato){

        //PERMISSÃO DE ESCRITA
        this.db = getWritableDatabase();

        //INSERIR e RETORNAR o ID
        long id = this.db.insert(
                "contato",null,contato);

        return id;
    }

    public List<ContentValues> listar(){
        String sql="SELECT * FROM contato ORDER BY nome";

        //PERMISSÃO DE LEITURA
        this.db = getReadableDatabase();

        //EXECUTAR CONSULTA
        Cursor c = this.db.rawQuery(sql, null);

        //RETORNOU DADOS?
        if (c.moveToFirst() ){
            List<ContentValues> lista = new ArrayList<>();
            while(c.moveToNext()){
                ContentValues contato = new ContentValues();
                contato.put("id",c.getInt(0));
                contato.put("nome",c.getString(1));
                contato.put("telefone",c.getString(2));
                lista.add(contato);
            }
            return lista;
        }else {
            return null;
        }
    }

}






