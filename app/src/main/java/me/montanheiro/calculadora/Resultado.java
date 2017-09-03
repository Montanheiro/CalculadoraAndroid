package me.montanheiro.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.towel.math.Expression;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent it = getIntent();
        if(it != null){
            Bundle bundle = it.getExtras();
            if (bundle != null){
                String valor1 = bundle.getString("valor1");
                String valor2 = bundle.getString("valor2");
                String operacaoNome = bundle.getString("textButtonSelected");
                String operacaoCalculo = bundle.getString("contentDescriptionSelected");

                TextView viewV1 = (TextView) findViewById(R.id.valor1);
                TextView viewV2 = (TextView) findViewById(R.id.valor2);
                TextView viewOp = (TextView) findViewById(R.id.operacao);
                TextView viewResultado = (TextView) findViewById(R.id.resultado);

                viewV1.setText(valor1);
                viewV2.setText(valor2);
                viewOp.setText(operacaoNome);
                viewResultado.setText(calcular(valor1, valor2, operacaoCalculo));
            }
        }


    }

    public String calcular(String valor1, String valor2, String operacaoCalculo){
        double resultado = new Expression(valor1 + operacaoCalculo + valor2).resolve();
        return String.valueOf(resultado);
    }

    public void voltar(View view){
        finish();
    }
}
