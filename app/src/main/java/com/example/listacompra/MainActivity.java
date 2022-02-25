package com.example.listacompra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textViewTotal;
    private EditText editTextQuant;
    private ListView listViewProduto;
    private float total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referencias:
        textViewTotal=findViewById(R.id.textViewTotal);
        editTextQuant=findViewById(R.id.editTextQuant);
        listViewProduto=findViewById(R.id.produto);


        //criando um evento
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (!editTextQuant.getText().toString().isEmpty()) {
                    //obter o valor do produto comprado
                    int quantidade = Integer.parseInt(editTextQuant.getText().toString());
                    //obter o produto selecionado
                    String produto = ((TextView) view).getText().toString();
                    switch (produto) {
                        case "Arroz":
                            total += quantidade * 13.00;
                            break;
                        case "Feijão":
                            total += quantidade * 7.00;
                            break;
                        case "Leite":
                            total += quantidade * 2.69;
                            break;
                        case "Macarrão":
                            total += quantidade * 2.20;
                            break;
                        case "Óleo":
                            total += quantidade * 2.99;
                            break;
                        case "Açúcar":
                            total += quantidade * 2.25;
                            break;
                    }
                    textViewTotal.setText("Total:\n" + total); //mostrando o total da compra
                    editTextQuant.setText(""); //apagar o campo quantidade
                }else Toast.makeText(MainActivity.this, "Preencha o campo quantidade!", Toast.LENGTH_LONG).show();
            }
        };
        listViewProduto.setOnItemClickListener(itemClickListener);
    }
    //apagando o valor total
    public void onNovaCompra(View v){
        textViewTotal.setText("Total:");
    }
}