package br.com.onlinevendas.danilosouza.bean;

import br.com.onlinevendas.danilosouza.dao.ProdutoDAO;
import br.com.onlinevendas.danilosouza.entidade.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ProdutoBean {
    
    private Produto p = new Produto();
    private List<Produto> listaComProdutos = new ArrayList<>();
    private ProdutoDAO dao = new ProdutoDAO();
    
    public void salvar(){
        dao.salvar(p);
        p = new Produto();
    }
    
    public void buscar(){
        listaComProdutos = dao.buscar();
    }
    
    public Produto getP() {
        return p;
    }

    public void setP(Produto p) {
        this.p = p;
    }

    public List<Produto> getListaComProdutos() {
        return listaComProdutos;
    }

    public void setListaComProdutos(List<Produto> listaComProdutos) {
        this.listaComProdutos = listaComProdutos;
    }
    
    
}
