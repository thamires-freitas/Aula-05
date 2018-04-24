package br.usjt.deswebmob.servicedesk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**

 */

public class ChamadoAdapter extends BaseAdapter {
    Activity contexto;
    Chamado[] chamados;

    public ChamadoAdapter(Activity contexto, Chamado[] chamados) {
        this.contexto = contexto;
        this.chamados = chamados;
    }

    @Override
    public int getCount() {
        return chamados.length;
    }

    @Override
    public Object getItem(int position) {
        if (position >= 0 && position < chamados.length)
            return chamados[position];
        else
            return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        LayoutInflater inflater = (LayoutInflater)
                contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.linha_chamado, parent, false);

        ImageView foto = (ImageView) view.findViewById(R.id.foto_fila);
        TextView datas = (TextView) view.findViewById(R.id.abertura_fechamento_chamado);
        TextView numero = (TextView) view.findViewById(R.id.numero_status_chamado);
        TextView detalhe = (TextView) view.findViewById(R.id.detalhe_chamado);

        detalhe.setText(chamados[position].getDescricao());
        String strFechamento = String.format("%tD",chamados[position].getDataFechamento());
        datas.setText(String.format("abertura: %tD - fechamento: %s",
                chamados[position].getDataAbertura(), strFechamento.equals("null")?" ":strFechamento));
        numero.setText(String.format("número: %d - status: %s", chamados[position].getNumero(),
                chamados[position].getStatus()));
        Drawable drawable = Util.getDrawable(contexto, chamados[position].getFigura());
        foto.setImageDrawable(drawable);

        return view;
    }
}
