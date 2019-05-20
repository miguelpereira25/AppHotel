package pt.ipg.apphotel;

import android.content.ContentValues;
import android.database.Cursor;

public class StaffBD {

    private long id;
    private String nomeStaff;
    private long ContactoStaff;
    private long Nib;
    private long SocialSecurity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeStaff() {
        return nomeStaff;
    }

    public void setNomeStaff(String nomeStaff) {
        this.nomeStaff = nomeStaff;
    }

    public long getContactoStaff() {
        return ContactoStaff;
    }

    public void setContactoStaff(long contactoStaff) {
        this.ContactoStaff = contactoStaff;
    }

    public long getNib() {
        return Nib;
    }

    public void setNib(long nib) {
        this.Nib = nib;
    }

    public long getSocialSecurity() {
        return SocialSecurity;
    }

    public void setSocialSecurity(long socialSecurity) {
        this.SocialSecurity = socialSecurity;
    }
    public ContentValues getContentValues(){
        ContentValues valores = new ContentValues();

        valores.put(BDTabelaStaff.CAMPO_NOME,nomeStaff);
        valores.put(BDTabelaStaff.CAMPO_CONTACTO_STAFF,ContactoStaff);
        valores.put(BDTabelaStaff.CAMPO_NIB,Nib);
        valores.put(BDTabelaStaff.CAMPO_SS,SocialSecurity);

        return valores;

    }
    public static StaffBD fromCursor (Cursor cursor){
        StaffBD staff = new StaffBD();

        long id = cursor.getLong(cursor.getColumnIndex(BDTabelaStaff._ID));
        String nomeStaff = cursor.getString(cursor.getColumnIndex(BDTabelaStaff.CAMPO_NOME));
        long ContactoStaff = cursor.getLong(cursor.getColumnIndex(BDTabelaStaff.CAMPO_CONTACTO_STAFF));
        long Nib = cursor.getLong(cursor.getColumnIndex(BDTabelaStaff.CAMPO_NIB));
        long SocialSecurity = cursor.getLong(cursor.getColumnIndex(BDTabelaStaff.CAMPO_SS));

        staff.setId(id);
        staff.setNomeStaff(nomeStaff);
        staff.setContactoStaff(ContactoStaff);
        staff.setNib(Nib);
        staff.setSocialSecurity(SocialSecurity);

        return staff;

    }

}
