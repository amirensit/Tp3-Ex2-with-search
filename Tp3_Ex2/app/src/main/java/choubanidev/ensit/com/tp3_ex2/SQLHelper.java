package choubanidev.ensit.com.tp3_ex2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class SQLHelper extends SQLiteOpenHelper {


    public static final int databaseVersion = 2;
    private static final String DATABASE_NAME = "Etudiant";
    private static final String TABLE_NAME = "etudiant";
    private static final String ID = "id";
    private static final String NOM = "nom";
    private static final String EMAIL = "email";
    private static final String OPTION = "option";
    private static final String ABS = "abs";

    public SQLHelper(Context context) {
        super(context, DATABASE_NAME, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ETUDIANT_TABLE = "CREATE TABLE " + TABLE_NAME
                + "("
                + ID + " INTEGER PRIMARY KEY ,"
                + NOM + " TEXT, "
                + EMAIL + " TEXT, "
                + OPTION + " TEXT, "
                + ABS+ " INTEGER"+
                ")";
        db.execSQL(CREATE_ETUDIANT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);


    }

    void addListEtudiant(Etudiant etudiant) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOM, etudiant.getNom());
        values.put(EMAIL, etudiant.getEmail());
        values.put(OPTION, etudiant.getOption());
        values.put(ABS, etudiant.getAbs());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Cursor getAllEtudiant() {

        SQLiteDatabase database = this.getReadableDatabase();
        return database.query(TABLE_NAME, null, null, new String[]{}, null, null, null);
    }


    public int getEtudiantsCount() {
        String countQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }


    public int updateData(Etudiant etudiant)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOM, etudiant.getNom());
        values.put(EMAIL, etudiant.getEmail());
        values.put(OPTION, etudiant.getOption());
        values.put(ABS, etudiant.getAbs());
       int r= db.update(TABLE_NAME,values,"nom=?",new  String[] {etudiant.getNom()} );
        db.close();
        return r;

    }

    public int deleteData(Etudiant etudiant)
    {
        SQLiteDatabase db = this.getWritableDatabase();
       int r= db.delete(TABLE_NAME,"nom=?",new  String[] {etudiant.getNom()});
        return r;

    }

    public Cursor search(String nom)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME +" where nom = ? ",new String[]{nom});
        return res;

    }







}
