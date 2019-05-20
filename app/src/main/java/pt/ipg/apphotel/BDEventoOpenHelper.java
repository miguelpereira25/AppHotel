package pt.ipg.apphotel;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDEventoOpenHelper extends SQLiteOpenHelper {
    public static final String NOME_BASE_DADOS = "Eventos.db";
    public static final int VERSAO_BASE_DADOS = 1;


    public  BDEventoOpenHelper(@Nullable Context context){
        super(context, NOME_BASE_DADOS,null,VERSAO_BASE_DADOS);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        new BDTabelaEventos(db).cria();
        new BDTabelaStaff(db).cria();
        new BDTabelaLayoutInfo(db).cria();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
