package br.usjt.deswebmob.servicedesk;

/**

 */

public enum FilaId {
    PROJETOS(1,"Novos Projetos", "ic_projetos"),
    VENDAS(2,"Manutenção do Sistema de Vendas", "ic_vendas"),
    ERP(3,"Manutenção do Sistema ERP", "ic_erp"),
    SERVIDORES(4,"Servidores", "ic_servidores"),
    REDES(5,"Redes", "ic_redes"),
    TELEFONIA(6,"Telefonia", "ic_telefonia"),
    DESKTOPS(7,"Desktops", "ic_desktops");

    private final String nome, icone;
    private final int id;

    FilaId(int num, String s, String ic) {
        nome = s;
        id = num;
        icone = ic;
    }

    public String nome(){
        return nome;
    }

    public int id(){
        return id;
    }

    public String icone(){
        return icone;
    }
}
