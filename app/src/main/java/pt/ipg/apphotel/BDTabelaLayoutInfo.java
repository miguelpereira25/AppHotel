package pt.ipg.apphotel;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BDTabelaLayoutInfo implements BaseColumns {
    public static final String NOME_TABELA = "Layoout Info";
    public static final String CAMPO_EVENTO = "Evento";
    public static final String CAMPO_DATA = "Data";
    public static final String CAMPO_VEGAN = "Vegans";
    public static final String CAMPO_VEGETA = "Vegetarianos";
    public static final String CAMPO_ALERGIAS = "Alergias";

    public static final String[] TODAS_COLUNAS_INFO = new String[]{_ID, CAMPO_EVENTO, CAMPO_DATA, CAMPO_VEGAN, CAMPO_VEGETA, CAMPO_ALERGIAS};

    private SQLiteDatabase db;

    public BDTabelaLayoutInfo(SQLiteDatabase db) {
        this.db = db;
    }

    public void cria() {
        db.execSQL(
                "CREATE TABLE " + NOME_TABELA + "(" +
                        _ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                        CAMPO_EVENTO + "TEXT NOT NULL," +
                        CAMPO_DATA + "TEXT NOT NULL," +
                        CAMPO_VEGAN + "INTEGER," +
                        CAMPO_VEGETA + "INTEGER," +
                        CAMPO_ALERGIAS + "INTEGER," +
                        "FOREIGN KEY("+CAMPO_EVENTO +") REFERENCES" + BDTabelaEventos.NOME_TABELA +"("+ BDTabelaEventos._ID + "),"+
                        "FOREIGN KEY("+CAMPO_DATA +")REFERENCES"+ BDTabelaEventos.NOME_TABELA+"("+BDTabelaEventos._ID + "),"+
                        ")"
        );
    }

    public Cursor query(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return db.query(NOME_TABELA, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public long insert(ContentValues values) {

        return db.insert(NOME_TABELA, null, values);
    }

    public int update(ContentValues values, String whereClause, String[] whereArgs) {
        return db.update(NOME_TABELA, values, whereClause, whereArgs);
    }

    public int delete(String whereClause, String[] whereArgs) {
        return db.delete(NOME_TABELA, whereClause, whereArgs);
    }
}

