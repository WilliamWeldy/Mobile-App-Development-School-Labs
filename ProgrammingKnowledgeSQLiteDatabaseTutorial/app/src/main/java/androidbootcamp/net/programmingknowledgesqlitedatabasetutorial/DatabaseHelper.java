package androidbootcamp.net.programmingknowledgesqlitedatabasetutorial;


/*
Video: Android SQLite Database Tutorial 1 # Introduction + Creating Database and Tables (Part 1)
by: ProgrammingKnowledge
Link:  https://www.youtube.com/watch?v=cp2rL3sAFmI

Video: Android SQLite Database Tutorial 2 # Introduction + Creating Database and Tables (Part 2)
by: ProgrammingKnowledge
Link:  https://www.youtube.com/watch?v=p8TaTgr4uKM

Video: Android SQLite Database Tutorial 3 # Insert values to SQLite Database table using Android
by: ProgrammingKnowledge
Link:  https://www.youtube.com/watch?v=T0ClYrJukPA

Video: Android SQLite Database Tutorial 4 # Show SQLite Database table Values using Android
by: ProgrammingKnowledge
Link:  https://www.youtube.com/watch?v=KUq5wf3Mh0c

Android SQLite Database Tutorial 5 # Update values in SQLite Database table using Android
by: ProgrammingKnowledge
Link:  https://www.youtube.com/watch?v=PA4A9IesyCg

Android SQLite Database Tutorial 6 # Delete values in SQLite Database table using Android
by: ProgrammingKnowledge
Link:  https://www.youtube.com/watch?v=neaCUaHa2Ek
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper { //A subclass is created in order to modify the database.
    public static final String DATABASE_NAME = "student.db"; //A case-insensitive name of the database itself.
    public static final String TABLE_NAME = "student_table"; //The table's name in the .db database file.
    public static final String COL_1 = "ID"; //Primary Key
    public static final String COL_2 = "NAME"; //the first name
    public static final String COL_3 = "SURNAME"; //Surname or last name
    public static final String COL_4 = "MARKS"; //Marks or grades


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1); //The superclass's constructor is called
        //SQLiteDatabase db = this.getWritableDatabase(); //creates the database and table, but used for checking purposes when inside this constructor.
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT, MARKS INTEGER)"); //The SQL query CREATE TABLE is executed
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String surname, String marks) {
        SQLiteDatabase db = this.getWritableDatabase(); //Creates the database and table

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);

        long result = db.insert(TABLE_NAME,null,contentValues); //If the data's not inserted, the result will be -1
            if(result == -1) return false;
                        else return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase(); //Creates the database and table
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null); //SQL query: SELECT all FROM (table_name)
        return res;
    }

    public boolean updateData(String id, String name, String surname, String marks) {
        SQLiteDatabase db = this.getWritableDatabase(); //Creates the database and table
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        db.update(TABLE_NAME, contentValues,"ID = ?", new String[] { id });
        return true;
    }

    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase(); //Creates the database and table
        return db.delete(TABLE_NAME, "ID = ?", new String[] { id });
    }
}
