package br.com.uni.web.controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.uni.modelo.Bookmark;
import br.com.uni.modelo.persistencia.BookmarkDAO;

/**
 * Servlet implementation class BookmarkServlet
 */
@WebServlet("/BookmarkServlet")
public class BookmarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookmarkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String descricao = request.getParameter("descricao");
		String link = request.getParameter("link");
		String act = request.getParameter("act");
		String id = request.getParameter("id"); 
		String pageFlow = "booklist.jsp";
		
		BookmarkDAO dao = new BookmarkDAO();
		
		String mensagemErro = null;
		if(descricao == null)
			mensagemErro = "descricao está vazia";
		if(link == null)
			mensagemErro = "link está vazio";
		
		

		if("formEditar".equals(act)){
			//exibir formulario para editar
			Bookmark book = dao.getByID(Integer.parseInt(id));
			request.setAttribute("book", book);
			pageFlow = "edit.jsp";
		}
		
		if("gravarEditar".equals(act)){
			//editar
			Bookmark bookmark = new Bookmark(Integer.parseInt(id), descricao, link);
			dao.editar(bookmark);
		}
		
		if("excluir".equals(act)){
			//excluir
			dao.excluir(Integer.parseInt(id));
		}
		
		if("salvar".equals(act) ){
		//logica da aplicação para guardar os dados
			Bookmark bookmark = new Bookmark(descricao, link);
			dao.salvar(bookmark);
		}
		//logica do controle para enviar dados para a tela
		HttpSession session = request.getSession(); 
		session.setAttribute("lista", dao.listar());
		request.setAttribute("mensagemErro", mensagemErro);
		//chamar a próxima página levando os objetos da sesão
		request.getRequestDispatcher(pageFlow).forward(request, response);
		
	}

}



