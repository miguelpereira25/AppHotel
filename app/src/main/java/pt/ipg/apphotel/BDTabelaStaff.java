package pt.ipg.apphotel;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BDTabelaStaff implements BaseColumns {
    public static final String NOME_TABELA = "Staff";
    public static final String CAMPO_NOME = "Nome Staff";
    public static final String CAMPO_CONTACTO_STAFF ="Contacto staff";
    public static final String CAMPO_NIB ="NIB";
    public static final String CAMPO_SS = "Seguranca Social";
    public static final String[] TODAS_COLUNAS_STAFF = new String[] {_ID, CAMPO_NOME, CAMPO_CONTACTO_STAFF, CAMPO_NIB, CAMPO_SS};

    private SQLiteDatabase db;

    public BDTabelaStaff (SQLiteDatabase db){
        this.db = db;

    }

    public void cria() {
        db.execSQL(
                "CREATE TABLE" + NOME_TABELA + "(" +
                        _ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                        CAMPO_NOME + "TEXT NOT NULL," +
                        CAMPO_CONTACTO_STAFF + "INTEGER NOT NULL," +
                        CAMPO_NIB + "INTEGER NOT NULL," +
                        CAMPO_SS + "INTEGER NOT NULL," +
                        ")"
        );
    }
        public Cursor query (String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy){
            return db.query(NOME_TABELA,columns, selection, selectionArgs, groupBy, having, orderBy);
        }

        public long insert (ContentValues values){

            return db.insert(NOME_TABELA, null, values);
        }

        public int update (ContentValues values, String whereClause, String[] whereArgs){
            return db.update(NOME_TABELA, values, whereClause, whereArgs);
        }

        public int delete (String whereClause, String[] whereArgs){
            return  db.delete(NOME_TABELA, whereClause, whereArgs);
        }
    }



