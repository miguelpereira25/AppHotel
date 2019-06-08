package pt.ipg.apphotel;

import android.content.ContentValues;
import android.database.Cursor;

public class EventBD {

    private long id;
    private String Evento;
    private int Data;
    private int Quantidade;
    private String Responsavel;
    private int Contacto;
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

    public int getData() {
        return Data;
    }

    public void setData(int Data) {
        this.Data = Data;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public String getResponsavel() {
        return Responsavel;
    }

    public void setResponsavel(String Responsavel) {
        this.Responsavel = Responsavel;
    }

    public int getContacto() {
        return Contacto;
    }

    public void setContacto(int Contacto) {
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
        int Data = cursor.getInt(cursor.getColumnIndex(BDTabelaEventos.CAMPO_DATA));
        int Quantidade = cursor.getInt(cursor.getColumnIndex(BDTabelaEventos.CAMPO_QUANTIDADE));
        String Responsavel = cursor.getString(cursor.getColumnIndex(BDTabelaEventos.CAMPO_RESPONSAVEL));
        int Contacto = cursor.getInt(cursor.getColumnIndex(BDTabelaEventos.CAMPO_CONTACTO));
        String Observacoes = cursor.getString(cursor.getColumnIndex(BDTabelaEventos.CAMPO_OBS));

        EventBD evento =new EventBD();


        evento.setId(id);
        evento.setEvento(Evento);
        evento.setData(Data);
        evento.setQuantidade( Quantidade);
        evento.setResponsavel(Responsavel);
        evento.setContacto(Contacto);
        evento.setObservacoes(Observacoes);
        return evento;




    }


}
