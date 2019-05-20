package pt.ipg.apphotel;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class BDTest {
    @Before
    public  void apagaBaseDados (){

        getAppContext().deleteDatabase(BDEventoOpenHelper.NOME_BASE_DADOS);
    }
    @Test
        public void criaBdMovimentos() {
            // Context of the app under test.
            Context appContext = getAppContext();

            BDEventoOpenHelper openHelper = new BDEventoOpenHelper(appContext);

            SQLiteDatabase db = openHelper.getReadableDatabase();

            assertTrue(db.isOpen());
        }

        private Context getAppContext() {
            return InstrumentationRegistry.getTargetContext();
        }

        @Test
        public void testCRUD (){

            BDEventoOpenHelper openHelper = new BDEventoOpenHelper(getAppContext());
            SQLiteDatabase db = openHelper.getWritableDatabase();
    }
    //Tabela Eventos
    private long criaEvento(BDTabelaEventos tabelaEventos, String Evento,long Data,long Quantidade,String Responsavel,String Observacoes) {


        EventBD evento = new EventBD();
        evento.setEvento(Evento);
        evento.setData(Data);
        evento.setQuantidade(Quantidade);
        evento.setResponsavel(Responsavel);
        evento.setObservacoes(Observacoes);



        long id = tabelaEventos.insert(evento.getContentValues());
        assertNotEquals(-1, id);

        return id;
    }

    private Cursor getEvento(BDTabelaEventos tabelaEventos) {

        return tabelaEventos.query(BDTabelaEventos.TODAS_COLUNAS_EVENTOS, null, null, null, null, null);
    }

    private EventBD getEventoComID(Cursor cursor, long id) {

        EventBD eventBD = null;

        while (cursor.moveToNext()) {
            eventBD = EventBD.fromCursor(cursor);

            if (eventBD.getId() == id) {
                break;
            }
        }

        assertNotNull(eventBD);

        return eventBD;
    }

    //Tabela Staff
    private long criaStaff(BDTabelaStaff tabelaStaff, String nomeStaff,long ContactoStaff,long Nib,long SocialSecurity) {

        StaffBD staff = new StaffBD();
        staff.setNomeStaff(nomeStaff);
        staff.setContactoStaff(ContactoStaff);
        staff.setNib(Nib);
        staff.setSocialSecurity(SocialSecurity);

        long id = tabelaStaff.insert(staff.getContentValues());
        assertNotEquals(-1, id);

        return id;
    }

    private Cursor getStaff (BDTabelaStaff tabelaStaff) {

        return tabelaStaff.query(BDTabelaStaff.TODAS_COLUNAS_STAFF, null, null, null, null, null);
    }

    private StaffBD getStaffComID(Cursor cursor, long id) {

        StaffBD staff = null;

        while (cursor.moveToNext()) {
            staff = StaffBD.fromCursor(cursor);

            if (staff.getId() == id) {
                break;
            }
        }

        assertNotNull(staff);

        return staff;
    }

    //Tabela Layout Info
    private long criaLayoutInfo(BDTabelaLayoutInfo tabelaLayoutInfo, String Evento, long Data, long Vegan, long Vegeta, long Alergias) {
        LayoutInfoBD layoutInfoBD = new LayoutInfoBD();

        layoutInfoBD.setEvento(Evento);
        layoutInfoBD.setData(Data);
        layoutInfoBD.setVegan(Vegan);
        layoutInfoBD.setVegeta(Vegeta);
        layoutInfoBD.setAlergias(Alergias);

        long id = tabelaLayoutInfo.insert(layoutInfoBD.getContentValues());
        assertNotEquals(-1, id);

        return id;
    }

    private Cursor getLayoutInfo(BDTabelaLayoutInfo tabelaLayoutInfo) {
        return tabelaLayoutInfo.query(BDTabelaLayoutInfo.TODAS_COLUNAS_INFO, null, null, null, null, null);
    }

    private LayoutInfoBD getLayoutInfoComId(Cursor cursor, long id) {
        LayoutInfoBD layoutInfoBD = null;

        while (cursor.moveToNext()) {
            layoutInfoBD = LayoutInfoBD.fromCursor(cursor);

            if (layoutInfoBD.getId() == id) {
                break;
            }
        }

        assertNotNull(layoutInfoBD);

        return layoutInfoBD;
    }
}
