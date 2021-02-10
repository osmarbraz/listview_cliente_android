package com.exemplo.listview_cliente;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button botaoAdicionar;
    private Button buttonFechar;
    private ListView listView;
    private List<Cliente> listaCliente = new ArrayList();
    private ListViewAdapterCliente adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Associa os componentes da interface as propriedades
        botaoAdicionar = findViewById(R.id.buttonAdicionar);
        buttonFechar = findViewById(R.id.buttonFechar);

        //Adiciona alguns clientes para popular a lista
        listaCliente.add(new Cliente("1", "João", "123"));
        listaCliente.add(new Cliente("2", "Carlos", "223"));
        listaCliente.add(new Cliente("3", "Pedro", "323"));
        listaCliente.add(new Cliente("4", "Luiz", "534"));

        //Cria o Adapter para a lista de cliente e o listView
        adapter = new ListViewAdapterCliente(listaCliente, this);

        //Recupera o listView
        listView = (ListView) findViewById(R.id.listView);

        //Seta o adapter do listView
        listView.setAdapter(adapter);
    }

    /**
     * Evento do botão adicionar cliente
     *
     * @param v
     */
    public void onClickBotaoAdicionar(View v) {
        //Recupera o intennt para a tela2
        Intent intent = new Intent(this, MainActivity2.class);
        // Abre a segunda tela
        startActivityForResult(intent, 0);
    }

    /**
     * Evento do botão fechar
     *
     * @param v
     */
    public void onClickBotaoFechar(View v) {
        System.exit(0);
    }

    /**
     * Verifica o resultado do retorno da chamada de um activity.
     *
     * @param requestCode Código da requisição
     * @param resultCode  Código de retorno
     * @param data        Dados do intent
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Executa no retorno das telas
        super.onActivityResult(requestCode, resultCode, data);
        //Se o retorno foi Ok
        if (resultCode == RESULT_OK) {
            //Verifica se os dados foram preenchidos
            if (data.hasExtra("clienteId") && data.hasExtra("nome") && data.hasExtra("cpf")) {
                String clienteId = data.getExtras().getString("clienteId");
                String nome = data.getExtras().getString("nome");
                String cpf = data.getExtras().getString("cpf");
                //Adiciona os dados na lsita
                adapter.adicionarCliente(new Cliente(clienteId, nome, cpf));
            }
        }
    }
}