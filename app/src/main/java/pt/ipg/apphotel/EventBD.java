package pt.ipg.apphotel;

import android.content.ContentValues;
import android.database.Cursor;

public class EventBD {

    private long id;
    private String Evento;
    private long Data;
    private long Quantidade;
    private String Responsavel;
    private long Contacto;
    private String Observacoes;


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

    public long getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(long Quantidade) {
        this.Quantidade = Quantidade;
    }

    public String getResponsavel() {
        return Responsavel;
    }

    public void setResponsavel(String Responsavel) {
        this.Responsavel = Responsavel;
    }

    public long getContacto() {
        return Contacto;
    }

    public void setContacto(long Contacto) {
        this.Contacto = Contacto;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String Observacoes) {
        this.Observacoes = Observacoes;
    }


    public ContentValues getContentValues() {
        ContentValues valores = new ContentValues();
        valores.put(BDTabelaEventos.CAMPO_EVENTO, Evento);
        valores.put(BDTabelaEventos.CAMPO_DATA, Data);
        valores.put(BDTabelaEventos.CAMPO_QUANTIDADE, Quantidade);
        valores.put(BDTabelaEventos.CAMPO_RESPONSAVEL, Responsavel);
        valores.put(BDTabelaEventos.CAMPO_CONTACTO, Contacto);
        valores.put(BDTabelaEventos.CAMPO_OBS, Observacoes);

        return valores;
    }

    public static EventBD fromCursor(Cursor cursor) {
        long id = cursor.getLong(cursor.getColumnIndex(BDTabelaEventos._ID));
        String Evento = cursor.getString(cursor.getColumnIndex(BDTabelaEventos.CAMPO_EVENTO));
        long Data = cursor.getLong(cursor.getColumnIndex(BDTabelaEventos.CAMPO_DATA));
        long Quantidade = cursor.getLong(cursor.getColumnIndex(BDTabelaEventos.CAMPO_QUANTIDADE));
        String Responsavel = cursor.getString(cursor.getColumnIndex(BDTabelaEventos.CAMPO_RESPONSAVEL));
        long Contacto = cursor.getLong(cursor.getColumnIndex(BDTabelaEventos.CAMPO_CONTACTO));
        String Observacoes = cursor.getString(cursor.getColumnIndex(BDTabelaEventos.CAMPO_OBS));

        EventBD evento =new EventBD();


        evento.setId(id);
        evento.setEvento(Evento);
        evento.setData(Data);
        evento.setQuantidade(Quantidade);
        evento.setResponsavel(Responsavel);
        evento.setObservacoes(Observacoes);
        return evento;




    }


}
