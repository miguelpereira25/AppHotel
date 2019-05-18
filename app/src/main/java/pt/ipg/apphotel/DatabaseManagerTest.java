package pt.ipg.apphotel;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/*

RunWith(AndroidJUnit4.class)

public class DatabaseManagerTest {

    @Before
    public void apagaBaseDados() {
        getAppContext().deleteDatabase(DatabaseManager.HOTELDB);
    }

    @Test
    public void criaStaff() {
        // Context of the app under test.
        Context appContext = getAppContext();

        DatabaseManager openHelper = new DatabaseManager(appContext);

        SQLiteDatabase db = openHelper.getReadableDatabase();

        assertTrue(db.isOpen());
    }

    private Context getAppContext() {
        return InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void testCRUD() {
        DatabaseManager openHelper = new DatabaseManager(getAppContext());
        SQLiteDatabase db = openHelper.getWritableDatabase();

        Staff tabelaStaff = new Staff(db);

        // Teste read staff (cRud)
        Cursor cursorStaff = getCategorias(tabelaStaff);
        assertEquals(0, cursorStaff.getCount());

        // Teste create/read staff (CRud)
        String nome = "staff";
        long idRomance = criaCategoria(tabelaStaff , nome);

        cursorStaff = getCategorias(tabelaStaff);
        assertEquals(1, cursorStaff.getCount());

        Staff staff = getStaffComID(cursorStaff, idRomance);

        assertEquals(nome, staff.getDescricao());

        nome = "Suspense";
        long idSuspense = criaCategoria(tabelaCategorias, nome);

        cursorCategorias = getCategorias(tabelaCategorias);
        assertEquals(2, cursorCategorias.getCount());

        categoria = getCategoriaComID(cursorCategorias, idSuspense);

        assertEquals(nome, categoria.getDescricao());

        // Teste Update/Read categorias (cRUd)
        nome = "Drama / suspense";
        categoria.setDescricao(nome);

        int registosAlterados = tabelaCategorias.update(categoria.getContentValues(), BdTableCategorias._ID + "=?", new String[]{String.valueOf(idSuspense)});

        assertEquals(1, registosAlterados);

        cursorCategorias = getCategorias(tabelaCategorias);
        categoria = getCategoriaComID(cursorCategorias, idSuspense);

        assertEquals(nome, categoria.getDescricao());

        // Teste Create/Delete/Read categorias (CRuD)
        long id = criaCategoria(tabelaCategorias, "TESTE");
        cursorCategorias = getCategorias(tabelaCategorias);
        assertEquals(3, cursorCategorias.getCount());

        tabelaCategorias.delete(BdTableCategorias._ID + "=?", new String[]{String.valueOf(id)});
        cursorCategorias = getCategorias(tabelaCategorias);
        assertEquals(2, cursorCategorias.getCount());

        getCategoriaComID(cursorCategorias, idRomance);
        getCategoriaComID(cursorCategorias, idSuspense);

        BdTableLivros tabelaLivros = new BdTableLivros(db);

        // Teste read livros (cRud)
        Cursor cursorLivros = getLivros(tabelaLivros);
        assertEquals(0, cursorLivros.getCount());

        // Teste create/read categorias (CRud)
        String titulo = "Dom Quixote";
        int pagina = 23;

        id = criaLivro(tabelaLivros, titulo, pagina, idRomance);
        cursorLivros = getLivros(tabelaLivros);
        assertEquals(1, cursorLivros.getCount());

        Livro livro = getLivroComID(cursorLivros, id);
        assertEquals(titulo, livro.getTitulo());
        assertEquals(pagina, livro.getPagina());
        assertEquals(idRomance, livro.getCategoria());

        titulo = "Fahrenheit 451";
        pagina = 1;
        id = criaLivro(tabelaLivros, titulo, pagina, idSuspense);
        cursorLivros = getLivros(tabelaLivros);
        assertEquals(2, cursorLivros.getCount());

        livro = getLivroComID(cursorLivros, id);
        assertEquals(titulo, livro.getTitulo());
        assertEquals(pagina, livro.getPagina());
        assertEquals(idSuspense, livro.getCategoria());

        id = criaLivro(tabelaLivros, "Teste", 1, idRomance);
        cursorLivros = getLivros(tabelaLivros);
        assertEquals(3, cursorLivros.getCount());

        // Teste read/update livros (cRUd)
        livro = getLivroComID(cursorLivros, id);
        titulo = "Bird cage";
        pagina = 7;

        livro.setTitulo(titulo);
        livro.setPagina(pagina);
        livro.setCategoria(idSuspense);

        tabelaLivros.update(livro.getContentValues(), BdTableLivros._ID + "=?", new String[]{String.valueOf(id)});

        cursorLivros = getLivros(tabelaLivros);

        livro = getLivroComID(cursorLivros, id);
        assertEquals(titulo, livro.getTitulo());
        assertEquals(pagina, livro.getPagina());
        assertEquals(idSuspense, livro.getCategoria());

        // Teste read/delete livros (cRuD)
        tabelaLivros.delete(BdTableLivros._ID + "=?", new String[]{String.valueOf(id)});
        cursorLivros = getLivros(tabelaLivros);
        assertEquals(2, cursorLivros.getCount());
    }

    private long criaCategoria(BdTableCategorias tabelaCategorias, String nome) {
        Categoria categoria = new Categoria();
        categoria.setDescricao(nome);

        long id = tabelaCategorias.insert(categoria.getContentValues());
        assertNotEquals(-1, id);

        return id;
    }

    private Cursor getCategorias(BdTableCategorias tabelaCategorias) {
        return tabelaCategorias.query(BdTableCategorias.TODAS_COLUNAS, null, null, null, null, null);
    }

    private Categoria getCategoriaComID(Cursor cursor, long id) {
        Categoria categoria = null;

        while (cursor.moveToNext()) {
            categoria = Categoria.fromCursor(cursor);

            if (categoria.getId() == id) {
                break;
            }
        }

        assertNotNull(categoria);

        return categoria;
    }

    private long criaLivro(BdTableLivros tabelaLivros, String titulo, int pagina, long categoria) {
        Livro livro = new Livro();

        livro.setTitulo(titulo);
        livro.setPagina(pagina);
        livro.setCategoria(categoria);

        long id = tabelaLivros.insert(livro.getContentValues());
        assertNotEquals(-1, id);

        return id;
    }

    private Cursor getLivros(BdTableLivros tabelaLivros) {
        return tabelaLivros.query(BdTableLivros.TODAS_COLUNAS, null, null, null, null, null);
    }

    private Livro getLivroComID(Cursor cursor, long id) {
        Livro livro = null;

        while (cursor.moveToNext()) {
            livro = Livro.fromCursor(cursor);

            if (livro.getId() == id) {
                break;
            }
        }

        assertNotNull(livro);

        return livro;
    }
}*/

}
