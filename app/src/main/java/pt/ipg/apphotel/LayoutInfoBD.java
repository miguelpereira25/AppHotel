package pt.ipg.apphotel;

import android.content.ContentValues;
import android.database.Cursor;

public class LayoutInfoBD {
    private long id;
    private String Evento;//chave estrangeira
    private long Data;//chaveEstrangeira
    private long Vegan;
    private long Vegeta;
    private long Alergias;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEvento() {
        return Evento;
    }

    public void setEvento(String Evento) {
        this.Evento = Evento;
    }

    public long getData() {
        return Data;
    }

    public void setData(long Data) {
        this.Data = Data;
    }

    public long getVegan() {
        return Vegan;
    }

    public void setVegan(long vegan) {
        this.Vegan = vegan;
    }

    public long getVegeta() {
        return Vegeta;
    }

    public void setVegeta(long vegeta) {
        this.Vegeta = vegeta;
    }

    public long getAlergias() {
        return Alergias;
    }

    public void setAlergias(long alergias) {
        this.Alergias = alergias;
    }
    public ContentValues getContentValues() {
        ContentValues valores = new ContentValues();
        valores.put(BDTabelaEventos.CAMPO_EVENTO, Evento);
        valores.put(BDTabelaEventos.CAMPO_DATA, Data);
        valores.put(BDTabelaLayoutInfo.CAMPO_VEGAN, Vegan);
        valores.put(BDTabelaLayoutInfo.CAMPO_VEGETA, Vegeta);
        valores.put(BDTabelaLayoutInfo.CAMPO_ALERGIAS, Alergias);
        return valores;
    }
    public static LayoutInfoBD fromCursor(Cursor cursor) {
        long id = cursor.getLong(cursor.getColumnIndex(BDTabelaEventos._ID));
        String Evento = cursor.getString(cursor.getColumnIndex(BDTabelaEventos.CAMPO_EVENTO));
        long Data = cursor.getLong(cursor.getColumnIndex(BDTabelaEventos.CAMPO_DATA));
        long Vegan=cursor.getLong(cursor.getColumnIndex(BDTabelaLayoutInfo.CAMPO_VEGAN));
        long Vegeta = cursor.getLong(cursor.getColumnIndex(BDTabelaLayoutInfo.CAMPO_VEGETA));
        long Alergias = cursor.getLong(cursor.getColumnIndex(BDTabelaLayoutInfo.CAMPO_ALERGIAS));

        LayoutInfoBD layoutInfoBD = new LayoutInfoBD();

        layoutInfoBD.setId(id);
        layoutInfoBD.setEvento(Evento);
        layoutInfoBD.setData(Data);
        layoutInfoBD.setVegan(Vegan);
        layoutInfoBD.setVegeta(Vegeta);
        layoutInfoBD.setAlergias(Alergias);

        return layoutInfoBD;
    }
}
