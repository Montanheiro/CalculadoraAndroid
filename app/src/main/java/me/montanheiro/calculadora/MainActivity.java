package me.montanheiro.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.towel.math.Expression;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View view){

        EditText input1 = (EditText) findViewById(R.id.valor1);
        String valor1 =input1.getText().toString();
        EditText input2 = (EditText) findViewById(R.id.valor2);
        String valor2 = input2.getText().toString();


        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.operacao);
        int radioButtonID = radioGroup.getCheckedRadioButtonId();

        if(radioButtonID == -1 || valor1.isEmpty() || valor2.isEmpty()){

            Toast toast = Toast.makeText(MainActivity.this, "Você não preencheu todos os valores", Toast.LENGTH_LONG);
            toast.show();

        }else{
            RadioButton radioButton = radioGroup.findViewById(radioButtonID);
            int idButtonSelected = radioGroup.indexOfChild(radioButton);
            String textButtonSelected = radioButton.getText().toString();
            String contentDescriptionSelected = radioButton.getContentDescription().toString();

            Intent it = new Intent(MainActivity.this, Resultado.class);

            Bundle bundle = new Bundle();
            bundle.putString("valor1", valor1);
            bundle.putString("valor2", valor2);
            bundle.putString("textButtonSelected", textButtonSelected);
            bundle.putString("contentDescriptionSelected", contentDescriptionSelected);

            it.putExtras(bundle);

            startActivity(it);
        }

    }

    public void calculdoraAntiga(View view){
        Intent it = new Intent(MainActivity.this, CalculadoraEmUmaTela.class);
        startActivity(it);
    }

}
