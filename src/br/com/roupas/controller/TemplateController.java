package br.com.roupas.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import br.com.roupas.application.Session;
import br.com.roupas.dao.UsuarioDAO;
import br.com.roupas.model.Usuario;

@Named
@ViewScoped
public class TemplateController extends UsuarioDAO implements Serializable {

	private static final long serialVersionUID = -925765300233216226L;

	private Usuario usuarioLogado = null;

	//tentar arrumar metodo usuarioLogado
	public Usuario getUsuarioLogado() {
		if (usuarioLogado == null) { // buscando o usuario da sessao
			usuarioLogado = (Usuario) Session.getInstance().getAttribute("usuarioLogado");
			if(usuarioLogado!=null)
					usuarioLogado = findById(usuarioLogado.getId());
		}
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String encerrarSessao() {
		// encerrando a sessao
		Session.getInstance().invalidateSession();
		return "login.xhtml?faces-redirect=true";
	}

}
