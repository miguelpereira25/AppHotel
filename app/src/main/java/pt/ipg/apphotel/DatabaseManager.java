package pt.ipg.apphotel;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseManager extends SQLiteOpenHelper {

    public static final String HOTELDB = "hotel.db";
    private static final int VERSAO_BASE_DADOS = 1;


    public DatabaseManager(@Nullable Context context) {
        super(context, HOTELDB, null, VERSAO_BASE_DADOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        new Staff(db).cria();
        new Eventos(db).cria;
        new LayoutInfo(db).cria;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
