package com.example.lamou.applicationinterfacesimplelamouranthony;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String datetext;
    private TextView Mail;
    private TextView Nom;
    private TextView Prenom;
    private TextView MaDate;
    private RadioButton H;
    private RadioButton F;
    private TextView NbHeure;
    private Button Res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.i("Lancement application","Le programme vous espionne");
        MaDate= (TextView) findViewById(R.id.Date);
        Nom= (TextView) findViewById(R.id.NOM);
        Prenom= (TextView) findViewById(R.id.Prenom);
        NbHeure= (TextView) findViewById(R.id.Heure);
        datetext=new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        MaDate.setText(datetext);
        Mail = (TextView) findViewById(R.id.Mail) ;
        H = (RadioButton) findViewById(R.id.Homme) ;
        F = (RadioButton) findViewById(R.id.Femme) ;
        Res = (Button) findViewById(R.id.Res) ;
        Res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nom.setText("");
                Prenom.setText("");
                NbHeure.setText("");
                H.setChecked(false);
                F.setChecked(false);
                Log.i("RAZ","Raz executer");
            }
        });
        NbHeure.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                try {
                    int num = Integer.parseInt(NbHeure.getEditableText().toString());
                    if (num <= 5) {
                        int duration = Toast.LENGTH_SHORT;
                        Toast.makeText(MainActivity.this, "Correct", duration).show();
                    } else if (num > 5 && num<=10) {
                        int duration = Toast.LENGTH_SHORT;
                        Toast.makeText(MainActivity.this, "Attention", duration).show();
                    } else if (num < 10) {
                        int duration = Toast.LENGTH_LONG;
                        Toast.makeText(MainActivity.this, "Addict", duration).show();
                    }
                }catch (NumberFormatException e) {
                    Log.i("",NbHeure.getEditableText().toString()+" is not a number");
                }
            }
        });
        H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(H.isChecked()){
                    int duration = Toast.LENGTH_SHORT;
                    if(Nom.getEditableText().toString()!=""){
                        Toast.makeText(MainActivity.this,"Bonjour Moinsieur "+Nom.getEditableText().toString(),duration ).show();
                    }else{
                        Toast.makeText(MainActivity.this,"Bonjour Moinsieur ",duration ).show();
                    }

                }
            }
        });
        F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(F.isChecked()){
                    int duration = Toast.LENGTH_SHORT;
                    if(Nom.getEditableText().toString()!=""){
                        Toast.makeText(MainActivity.this,"Bonjour Madame "+Nom.getEditableText().toString(),duration ).show();
                    }else{
                        Toast.makeText(MainActivity.this,"Bonjour Madame ",duration ).show();
                    }

                }
            }
        });
        Mail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
              @Override
              public void onFocusChange(View v, boolean hasFocus) {
                  if(Nom.getText().toString()!="" && Prenom.getText().toString()!=""){
                      String MailEtudiant;
                      MailEtudiant=Prenom.getEditableText().toString().toLowerCase().charAt(0)+"."+Nom.getEditableText().toString().toLowerCase()+"@ludus-academie.com";
                      Mail.setText(MailEtudiant);
                  }
              }
          });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
