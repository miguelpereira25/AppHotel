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
        public void criaBDEventos() {
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


            /************
             *Operaçoda tabela eventos *
             ************/
            BDTabelaEventos tabelaEventos = new BDTabelaEventos(db);
            //test read Eventos
            Cursor cursorEventos = getEvento(tabelaEventos);
            assertEquals(0,cursorEventos.getCount());
            //test create/read Eventos
            String nome_evento = "Casamento Rui e Joana";
            int data = 25/02/2020;
            int quantidade =120;
            String nome_responsavel = "Rita Barroso";
            int Contacto =964255960;
            String Observacoes ="Nada a declarar";
            long idCasamento = criaEvento(tabelaEventos, nome_evento, data,quantidade,nome_responsavel, Contacto, Observacoes);

            cursorEventos = getEvento(tabelaEventos);
            assertEquals(1, cursorEventos.getCount());

            EventBD eventBD = getEventoComID(cursorEventos, idCasamento);
            assertEquals(nome_evento, eventBD.getEvento());
            assertEquals(data,eventBD.getData());
            assertEquals(quantidade,eventBD.getQuantidade());
            assertEquals(nome_responsavel,eventBD.getResponsavel());
            assertEquals(Contacto, eventBD.getContacto());
            assertEquals(Observacoes, eventBD.getObservacoes());


            /*************************************/

            nome_evento = "Congresso Medicina dentaria";
            data = 19/02/2020;
            quantidade = 200;
            nome_responsavel = "Joao Bras";
            Contacto = 925656002;
            Observacoes ="3 Cofee breaks completos verificar folha";

            long idMedicina = criaEvento(tabelaEventos, nome_evento,data,quantidade,nome_responsavel,Contacto,Observacoes);

            cursorEventos = getEvento(tabelaEventos);
            assertEquals(1, cursorEventos.getCount());

            eventBD = getEventoComID(cursorEventos, idMedicina);
            assertEquals(nome_evento, eventBD.getEvento());
            assertEquals(data,eventBD.getData());
            assertEquals(quantidade,eventBD.getQuantidade());
            assertEquals(nome_responsavel,eventBD.getResponsavel());
            assertEquals(Contacto,eventBD.getContacto());
            assertEquals(Observacoes,eventBD.getObservacoes());



            //Teste Update/Read Evento

            nome_evento = "Casamento Rui e Joana / Casamento Rui e Joana";
            eventBD.setEvento(nome_evento);

            int registoAlteradoEvento = tabelaEventos.update(eventBD.getContentValues(), BDTabelaEventos._ID + "=?", new String[] {String.valueOf(idCasamento)});

            assertEquals(1, registoAlteradoEvento);

            cursorEventos = getEvento(tabelaEventos);
            eventBD= getEventoComID(cursorEventos, idCasamento);

            assertEquals(nome_evento, eventBD.getEvento());

            //Teste Create/delete/read tipo
            long id = criaEvento(tabelaEventos, "Casamento Rui e Joana",25/02/2020,120,"Rita Barroso",964255960,"Nada a declarar" );
            cursorEventos = getEvento(tabelaEventos);
            assertEquals(3,cursorEventos.getCount());



            tabelaEventos.delete(BDTabelaEventos._ID + "=?", new String[] {String.valueOf(id)});
            cursorEventos = getEvento(tabelaEventos);
            assertEquals(2, cursorEventos.getCount());

            getEventoComID(cursorEventos, idCasamento);
            getEventoComID(cursorEventos, idMedicina);

            /*******************************
             * Operações da Tabela Staff*
             *******************************/

            BDTabelaStaff tabelaStaff = new BDTabelaStaff(db);

            //Teste read Serviço
            Cursor cursorStaff = getStaff(tabelaStaff);
            assertEquals(0, cursorStaff.getCount());

            //Teste create/read Serviço
            String nome_staff = "João";
            long ContactoStaff = 917220260;
            long Nib = 1234567891;//put the rest in obs
            long SocialSecurity = 123456789;

            long idJoao = criaStaff(tabelaStaff, nome_staff,ContactoStaff,Nib,SocialSecurity );
            cursorStaff = getStaff(tabelaStaff);
            assertEquals(1, cursorStaff.getCount());

            StaffBD staffBD = getStaffComID(cursorStaff, idJoao);
            assertEquals(nome_staff, staffBD.getNomeStaff());
            assertEquals(ContactoStaff, staffBD.getContactoStaff());
            assertEquals(Nib, staffBD.getNib());
            assertEquals(SocialSecurity, staffBD.getSocialSecurity());


            nome_staff = "Antonio";
            ContactoStaff = 914522650;
            Nib = 1234567891;
            SocialSecurity = 987654321;
            long idAntonio = criaStaff(tabelaStaff, nome_staff, ContactoStaff,Nib,SocialSecurity);
            cursorStaff = getStaff(tabelaStaff);
            assertEquals(2, cursorStaff.getCount());

            staffBD = getStaffComID(cursorStaff, idAntonio);
            assertEquals(nome_staff, staffBD.getNomeStaff());
            assertEquals(ContactoStaff, staffBD.getContactoStaff());
            assertEquals(Nib, staffBD.getNib());
            assertEquals(SocialSecurity, staffBD.getSocialSecurity());


            //Teste Update/Read servico
            nome_staff = "João / Antonio";
            staffBD.setNomeStaff(nome_staff);


            int registoAlteradoStaff = tabelaStaff.update(staffBD.getContentValues(), BDTabelaStaff._ID + "=?", new String[] {String.valueOf(idJoao)});

            assertEquals(1, registoAlteradoStaff);

            cursorStaff = getStaff(tabelaStaff);
            staffBD = getStaffComID(cursorStaff, idJoao);

            assertEquals(nome_staff, staffBD.getNomeStaff());

            //Teste Create/delete/read Staff
            id = criaStaff(tabelaStaff, "João", 917220268, 1234567891,123456789);
            cursorStaff = getStaff(tabelaStaff);
            assertEquals(3, cursorStaff.getCount());

            tabelaStaff.delete(BDTabelaStaff._ID + "=?", new String[] {String.valueOf(id)});
            cursorStaff = getStaff(tabelaStaff);
            assertEquals(2, cursorStaff.getCount());

            getStaffComID(cursorStaff, idAntonio);
            getStaffComID(cursorStaff, idJoao);


            /*******************************
             * Operações da Tabela Layout info*
             *******************************/

            BDTabelaLayoutInfo tabelaLayoutInfo = new BDTabelaLayoutInfo(db);

            //Teste read Serviço
            Cursor cursorLayoutInfo = getLayoutInfo(tabelaLayoutInfo);
            assertEquals(0, cursorLayoutInfo.getCount());

            //Teste create/read Serviço
            String nome_Evento= "Casamento Rui e Joana";
            long Data =25/02/2020;
            long Vegan = 2;
            long Vegeta = 3;
            long Alergias = 0;

            long idCasamentoLayout = criaLayoutInfo(tabelaLayoutInfo, nome_Evento,Data,Vegan,Vegeta,Alergias);
            cursorLayoutInfo = getLayoutInfo(tabelaLayoutInfo);
            assertEquals(1, cursorLayoutInfo.getCount());

            LayoutInfoBD layoutInfoBD = getLayoutInfoComId(cursorLayoutInfo, idCasamentoLayout);
            assertEquals(nome_Evento, layoutInfoBD.getEvento());
            assertEquals(Data, layoutInfoBD.getData());
            assertEquals(Vegan,layoutInfoBD.getVegan());
            assertEquals(Vegeta, layoutInfoBD.getVegeta());
            assertEquals(Alergias,layoutInfoBD.getAlergias());


            nome_Evento="Congresso Medicina Dentaria";
            Data =19/02/2020;
            Vegan = 5;
            Vegeta = 1;
            Alergias = 10;

            long idMedicinaLayout = criaLayoutInfo(tabelaLayoutInfo, nome_Evento,Data,Vegan,Vegeta,Alergias);
            cursorLayoutInfo = getLayoutInfo(tabelaLayoutInfo);
            assertEquals(1, cursorLayoutInfo.getCount());

            layoutInfoBD = getLayoutInfoComId(cursorLayoutInfo, idMedicinaLayout);
            assertEquals(nome_Evento, layoutInfoBD.getEvento());
            assertEquals(Data, layoutInfoBD.getData());
            assertEquals(Vegan,layoutInfoBD.getVegan());
            assertEquals(Vegeta, layoutInfoBD.getVegeta());
            assertEquals(Alergias,layoutInfoBD.getAlergias());


            //Teste Update/Read layout
            nome_Evento = "Casamento Rui e Joana / Casamento Rui e Joana";
            layoutInfoBD.setEvento(nome_Evento);


            int registoAlteradoLayout = tabelaStaff.update(staffBD.getContentValues(), BDTabelaStaff._ID + "=?", new String[] {String.valueOf(idJoao)});

            assertEquals(1, registoAlteradoLayout);

            cursorLayoutInfo = getLayoutInfo(tabelaLayoutInfo);
            layoutInfoBD = getLayoutInfoComId(cursorLayoutInfo, idCasamentoLayout);

            assertEquals(nome_Evento, layoutInfoBD.getEvento());
            assertEquals(Data, layoutInfoBD.getData());
            assertEquals(Vegan,layoutInfoBD.getVegan());
            assertEquals(Vegeta, layoutInfoBD.getVegeta());
            assertEquals(Alergias,layoutInfoBD.getAlergias());



            //Teste Create/delete/read Layout
            id = criaLayoutInfo(tabelaLayoutInfo,"Casamento Rui e Joana", 25/02/2020,2,3,0 );
            cursorLayoutInfo = getLayoutInfo(tabelaLayoutInfo);
            assertEquals(3, cursorLayoutInfo.getCount());

            tabelaLayoutInfo.delete(BDTabelaLayoutInfo._ID + "=?", new String[] {String.valueOf(id)});
            cursorLayoutInfo = getLayoutInfo(tabelaLayoutInfo);
            assertEquals(2, cursorLayoutInfo.getCount());

            getStaffComID(cursorLayoutInfo, idCasamentoLayout);
            getStaffComID(cursorStaff, idMedicinaLayout);




    }
    //Tabela Eventos
    private long criaEvento(BDTabelaEventos tabelaEventos, String Evento,int Data,int Quantidade,String Responsavel, int Contacto,String Observacoes) {


        EventBD evento = new EventBD();
        evento.setEvento(Evento);
        evento.setData(Data);
        evento.setQuantidade(Quantidade);
        evento.setResponsavel(Responsavel);
        evento.setContacto(Contacto);
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
