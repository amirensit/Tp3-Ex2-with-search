package choubanidev.ensit.com.tp3_ex2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ModifierStudent extends AppCompatActivity {

    EditText nom;
    EditText email;
    EditText option;
    EditText abs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_student);

        nom=(EditText)findViewById(R.id.nom);
        email=(EditText)findViewById(R.id.email);
        option=(EditText)findViewById(R.id.option);
        abs=(EditText)findViewById(R.id.abs);
    }
    public void modifier(View v) {
        Intent intent = new Intent();
        Etudiant etudiant=new Etudiant(nom.getText().toString(),email.getText().toString(),option.getText().toString(),Integer.parseInt(abs.getText().toString()));
        intent.putExtra("modifierEtudiant", etudiant);
        setResult(1,intent);
        finish();
    }
}
