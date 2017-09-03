package me.montanheiro.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.towel.math.Expression;

public class CalculadoraEmUmaTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_em_uma_tela);
    }

    public void buttonClick(View view){
        Button botao = (Button) view;
        String digitado = botao.getText().toString();

        TextView visor = (TextView) findViewById(R.id.visor);
        visor.setText(visor.getText().toString() + digitado);
    }

    public void calcular(View view){
        TextView visor = (TextView) findViewById(R.id.visor);
        TextView calculo = (TextView) findViewById(R.id.calculo);
        calculo.setText(visor.getText().toString());
        double resultado = new Expression(visor.getText().toString()).resolve();
        visor.setText(String.valueOf(resultado));
    }

    public void limpar(View view){
        TextView visor = (TextView) findViewById(R.id.visor);
        TextView calculo = (TextView) findViewById(R.id.calculo);
        visor.setText("");
        calculo.setText("");
    }


}
