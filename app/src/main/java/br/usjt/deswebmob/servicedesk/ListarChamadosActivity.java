package br.usjt.deswebmob.servicedesk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class ListarChamadosActivity extends Activity {

    public static final String CHAMADO = "br.usjt.deswebmob.servicedesk.descricao";
    ArrayList<Chamado> lista;
    Activity atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_chamados);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);
        lista = buscaChamados(chave);
        ChamadoAdapter adapter = new ChamadoAdapter(this, lista.toArray(new Chamado[0]));
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalheChamadoActivity.class);
                intent.putExtra(CHAMADO, lista.get(position));

                startActivity(intent);

            }

        });

    }

    public ArrayList<Chamado> buscaChamados(String chave) {
        ArrayList<Chamado> lista = geraListaChamados();
        if (chave == null || chave.length() == 0) {
            return lista;
        } else {
            ArrayList<Chamado> subLista = new ArrayList<>();
            for (Chamado chamado : lista) {
                if (chamado.getFila().getNome().toUpperCase().contains(chave.toUpperCase())) {
                    subLista.add(chamado);
                }
            }
            return subLista;
        }
    }

    public ArrayList<Chamado> geraListaChamados() {
        ArrayList<Chamado> lista = new ArrayList<>();
        lista.add(new Chamado(1, new Date(), null, Chamado.ABERTO,
                "Computador da secretária quebrado.",
                new Fila(FilaId.DESKTOPS.id(), FilaId.DESKTOPS.nome(), FilaId.DESKTOPS.icone())));

        lista.add(new Chamado(2, new Date(), new Date(), Chamado.FECHADO,
                "Manutenção no proxy.", new Fila(FilaId.REDES.id(), FilaId.REDES.nome(), FilaId.REDES.icone())));

        lista.add(new Chamado(3, new Date(), null, Chamado.ABERTO,
                "Lentidão generalizada.", new Fila(FilaId.REDES.id(), FilaId.REDES.nome(), FilaId.REDES.icone())));

        lista.add(new Chamado(4, new Date(), null, Chamado.ABERTO,
                "CRM.", new Fila(FilaId.PROJETOS.id(), FilaId.PROJETOS.nome(), FilaId.PROJETOS.icone())));

        lista.add(new Chamado(5, new Date(), new Date(), Chamado.FECHADO,
                "Troca de senha.", new Fila(FilaId.DESKTOPS.id(), FilaId.DESKTOPS.nome(), FilaId.DESKTOPS.icone())));

        lista.add(new Chamado(6, new Date(), null, Chamado.ABERTO,
                "Falha no Windows.", new Fila(FilaId.DESKTOPS.id(), FilaId.DESKTOPS.nome(), FilaId.DESKTOPS.icone())));

        lista.add(new Chamado(7, new Date(), null, Chamado.ABERTO,
                "Manutenção Sistema de Vendas: incluir pipeline.",
                new Fila(FilaId.PROJETOS.id(), FilaId.PROJETOS.nome(), FilaId.PROJETOS.icone())));

        lista.add(new Chamado(8, new Date(), new Date(), Chamado.FECHADO,
                "Liberar celular.", new Fila(FilaId.TELEFONIA.id(), FilaId.TELEFONIA.nome(), FilaId.TELEFONIA.icone())));

        lista.add(new Chamado(9, new Date(), null, Chamado.ABERTO,
                "Consertar ramal.", new Fila(FilaId.TELEFONIA.id(), FilaId.TELEFONIA.nome(), FilaId.TELEFONIA.icone())));

        lista.add(new Chamado(10, new Date(), null, Chamado.ABERTO,
                "Gestão de Orçamento.", new Fila(FilaId.PROJETOS.id(), FilaId.PROJETOS.nome(), FilaId.PROJETOS.icone())));

        lista.add(new Chamado(11, new Date(), null, Chamado.ABERTO,
                "Big Data.", new Fila(FilaId.PROJETOS.id(), FilaId.PROJETOS.nome(), FilaId.PROJETOS.icone())));

        lista.add(new Chamado(12, new Date(), null, Chamado.ABERTO,
                "Internet com lentidão.", new Fila(FilaId.REDES.id(), FilaId.REDES.nome(), FilaId.REDES.icone())));

        lista.add(new Chamado(13, new Date(), null, Chamado.ABERTO,
                "Chatbot.", new Fila(FilaId.PROJETOS.id(), FilaId.PROJETOS.nome(), FilaId.PROJETOS.icone())));

        lista.add(new Chamado(14, new Date(), null, Chamado.ABERTO,
                "ITIL v3.", new Fila(FilaId.PROJETOS.id(), FilaId.PROJETOS.nome(), FilaId.PROJETOS.icone())));

        lista.add(new Chamado(15, new Date(), null, Chamado.ABERTO,
                "Ferramenta EMM.", new Fila(FilaId.PROJETOS.id(), FilaId.PROJETOS.nome(), FilaId.PROJETOS.icone())));

        lista.add(new Chamado(16, new Date(), new Date(), Chamado.FECHADO,
                "Erro Contábil.", new Fila(FilaId.ERP.id(), FilaId.ERP.nome(), FilaId.ERP.icone())));


        return lista;
    }
}
