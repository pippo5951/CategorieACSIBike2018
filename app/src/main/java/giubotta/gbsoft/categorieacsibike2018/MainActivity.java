package giubotta.gbsoft.categorieacsibike2018;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

Button btn_Calcola;
EditText et_Input;
TextView tv_Output;
int intero;
String categoria="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_Input = (EditText)findViewById(R.id.et_Input);
        tv_Output = (TextView) findViewById(R.id.tv_Output);
        btn_Calcola = (Button)findViewById(R.id.btn_Calcola);

        btn_Calcola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et_Input.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "devi inserire l'anno di nascita!", Toast.LENGTH_SHORT).show();
                } else {
                    intero = Integer.parseInt(et_Input.getText().toString());
                    categoria="Non rientra in nessuna categoria";
                    if (intero >= 2005 && intero <= 2006){categoria = "Primavera";}
                    if (intero >= 2007 && intero <= 2013){categoria = "Cucciolo";}
                    if (intero >= 2001 && intero <= 2004){categoria = "Debuttante";}
                    if (intero >= 1990 && intero <= 2000){categoria = "Junior";}
                    if (intero >= 1985 && intero <= 1989){categoria = "Senior 1";}
                    if (intero >= 1980 && intero <= 1984){categoria = "Senior 2";}
                    if (intero >= 1975 && intero <= 1979){categoria = "Veterano 1";}
                    if (intero >= 1970 && intero <= 1974){categoria = "Veterano 2";}
                    if (intero >= 1965 && intero <= 1969){categoria = "Gentlemen 1";}
                    if (intero >= 1960 && intero <= 1964){categoria = "Gentlemen 2";}
                    if (intero >= 1955 && intero <= 1959){categoria = "Super Gentlemen A";}
                    if (intero >= 1945 && intero <= 1954){categoria = "Super Gentlemen B";}
                    //if (intero >= 1941 && intero <= 1943){categoria = "Super Gentlemen C";}
                    tv_Output.setText("");
                    et_Input.setText("");
                    HideKeyboard();
                    tv_Output.setText(intero+"\n"+categoria);
                }
            }
        });
    }
    private void HideKeyboard() {
        //nasconde la tastiera dopo il click
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(et_Input.getWindowToken(), 0);
    }
}
