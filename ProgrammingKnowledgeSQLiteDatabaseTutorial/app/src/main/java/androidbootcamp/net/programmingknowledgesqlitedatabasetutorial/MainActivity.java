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


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName, editSurname, editMarks, editId;
    Button btnAddData;
    Button btnViewData;
    Button btnUpdateData;
    Button btnDeleteData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        //Assigning everything
        editName = (EditText) findViewById(R.id.editText_name);
        editSurname = (EditText) findViewById(R.id.editText_surname);
        editMarks = (EditText) findViewById(R.id.editText_marks);
        editId = (EditText) findViewById(R.id.editText_id);

        btnAddData = (Button) findViewById(R.id.btnAddData);
        btnViewData = (Button) findViewById(R.id.btnViewData);
        btnUpdateData = (Button) findViewById(R.id.btnUpdateData);
        btnDeleteData = (Button) findViewById(R.id.btnDeleteData);

        addData();
        viewAll();
        updateData();
        deleteData();
    }

        public void updateData() {
            btnUpdateData.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    boolean isUpdated = myDb.updateData(editId.getText().toString(),editName.getText().toString(),editSurname.getText().toString(),editMarks.getText().toString());
                    if(isUpdated == true) Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
                                     else Toast.makeText(MainActivity.this, "Data is not Updated", Toast.LENGTH_LONG).show();
                    }

            });
        }

        public void deleteData() {
            btnDeleteData.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Integer deletedRows = myDb.deleteData(editId.getText().toString());
                    if (deletedRows > 0) Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                                    else Toast.makeText(MainActivity.this, "Data is not Deleted", Toast.LENGTH_LONG).show();
                }

            });
        }

        public void addData() {
            btnAddData.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    boolean isInserted = myDb.insertData(editName.getText().toString(), editSurname.getText().toString(), editMarks.getText().toString());
                    if(isInserted == true) Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                                      else Toast.makeText(MainActivity.this, "Data is not Inserted", Toast.LENGTH_LONG).show();
                }

            });
        }

        public void viewAll() {
            btnViewData.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                   Cursor res = myDb.getAllData();
                   if(res.getCount() == 0) { //If no information can be found, this error is displayed
                       showMessage("ERROR", "nothing found");
                       return;
                   }


                   StringBuffer buffer = new StringBuffer();
                   while (res.moveToNext()) {
                       buffer.append("Id: " + res.getString(0) + "\n");
                       buffer.append("Name: " + res.getString(1) + "\n");
                       buffer.append("Surname: " + res.getString(2) + "\n");
                       buffer.append("Marks: " + res.getString(3) + "\n\n");

                   }

                    showMessage("Data", buffer.toString()); //this shows all the data

                }

            });
        }

        public void showMessage(String title, String message) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(message);
            builder.show();
        }
    }
