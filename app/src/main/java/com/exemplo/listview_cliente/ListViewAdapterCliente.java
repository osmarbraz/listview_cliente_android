package com.exemplo.listview_cliente;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapterCliente extends BaseAdapter {

    private List<Cliente> listaClientes;
    private Activity activity;

    ListViewAdapterCliente(List<Cliente> listaClientes, Activity activity) {
        this.listaClientes = listaClientes;
        this.activity = activity;
    }

    /**
     * Retorna a quantidade de elementos da lista
     * @return A quantidade de elementos da lista.
     */
    @Override
    public int getCount() {
        return listaClientes.size();
    }

    /**
     * Retorna um elemnto de uma posição da lista
     * @param i Posição do elemento a ser retornado.
     * @return Um elemento da posição i
     */
    @Override
    public Cliente getItem(int i) {
        return listaClientes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null) {
            v = activity.getLayoutInflater().inflate(R.layout.item_cliente_view, viewGroup, false);
        }
        Cliente cliente = listaClientes.get(i);
        TextView clienteId = (TextView) v.findViewById(R.id.textViewClienteId);
        TextView nome = (TextView) v.findViewById(R.id.textViewNome);
        TextView cpf = (TextView) v.findViewById(R.id.textViewCpf);
        clienteId.setText(cliente.getClienteId());
        nome.setText(cliente.getNome());
        cpf.setText(cliente.getCpf());
        return v;
    }

    /**
     * Adiciona um novo cliente a lista
     *
     * @param novo Um cliente
     */
    public void adicionarCliente(Cliente novo) {
        listaClientes.add(novo); //adiciona o item na ultima posicao
        notifyDataSetChanged();// notifica que meus items foi alterado
    }

    /**
     * Remove um cliente da lista pela posição
     *
     * @param posicao Posição do cliente a ser excluído
     */
    public void removerCliente(int posicao) {
        listaClientes.remove(posicao); //remove o item na posicao desejada
        notifyDataSetChanged();
    }

}