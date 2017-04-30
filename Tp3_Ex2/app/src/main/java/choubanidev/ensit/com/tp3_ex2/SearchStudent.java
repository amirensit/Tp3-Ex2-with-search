package choubanidev.ensit.com.tp3_ex2;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SearchStudent extends AppCompatActivity {

    SQLHelper db;
    Cursor res;
    EditText nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_student);
        nom=(EditText)findViewById(R.id.nom);
    }




    public void Afficher(View v)
    {

        Etudiant etudiant=new Etudiant(nom.getText().toString());


        res=db.search( etudiant.getNom());
        if(res.getCount() ==0 )
        {
            message("error","nothing found");
            return;}

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext())
        {

            buffer.append("nom : " +res.getString(1) +"\n");
            buffer.append("email : " +res.getString(2) +"\n");
            buffer.append("option : " +res.getString(3) +"\n");
            buffer.append("nombre absence : " +res.getString(4) +"\n\n");


        }
        message("data",buffer.toString());

    }




     void message(String title,String msg)
    {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();


    }

}
