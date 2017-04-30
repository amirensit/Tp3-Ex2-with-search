package choubanidev.ensit.com.tp3_ex2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SupprimerStudent extends AppCompatActivity {
    EditText nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer_student);
        nom=(EditText)findViewById(R.id.nom);
    }
    public void supprimer(View v) {
        Intent intent = new Intent();
        Etudiant etudiant=new Etudiant(nom.getText().toString());
        intent.putExtra("supprimerEtudiant", etudiant);
        setResult(2,intent);
        finish();
    }

}
