package pt.ipg.apphotel;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BDTabelaEventos implements BaseColumns {
    public static final String NOME_TABELA = "Eventos";
    public static final String CAMPO_EVENTO = "Evento";
    public static final String CAMPO_DATA = "Data";
    public static final String CAMPO_QUANTIDADE = "Quantidade";
    public static final String CAMPO_RESPONSAVEL = "Responsavel";
    public static final String CAMPO_CONTACTO = "Contacto";
    public static final String CAMPO_OBS = "Observacoes";

    public static final String[] TODAS_COLUNAS_EVENTOS = new String[]{_ID, CAMPO_EVENTO, CAMPO_DATA, CAMPO_QUANTIDADE, CAMPO_RESPONSAVEL, CAMPO_CONTACTO, CAMPO_OBS};

    private SQLiteDatabase db;

    public BDTabelaEventos(SQLiteDatabase db) {
        this.db = db;
    }

    public void cria() {
        db.execSQL(
                "CREATE TABLE " + NOME_TABELA + "(" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        CAMPO_EVENTO + " TEXT NOT NULL," +
                        CAMPO_DATA + "INTEGER NOT NULL," +
                        CAMPO_QUANTIDADE + "INTEGER NOT NULL," +
                        CAMPO_RESPONSAVEL + "TEXT NOT NULL," +
                        CAMPO_CONTACTO + "INTEGER NOT NULL," +
                        CAMPO_OBS + "TEXT," +
                        ") "

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

