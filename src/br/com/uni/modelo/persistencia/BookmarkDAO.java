
package br.com.uni.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.com.uni.modelo.Bookmark;

public class BookmarkDAO {

	private static List<Bookmark> LISTA = new ArrayList<Bookmark>();
	
	public void salvar(Bookmark bookmark){
		LISTA.add(bookmark);
	}
	
	public List<Bookmark> listar(){
		return LISTA;
	}
	
	public Bookmark getByID(int id){
		for (Bookmark book : LISTA) {
			if(book.getId() == id){
				return book;
			}
		}
		return new Bookmark();
	}
	
	
	public void editar(Bookmark bookmark){
		for (Bookmark book : LISTA) {
			if(book.getId() == bookmark.getId()){
				book.setDescricao(bookmark.getDescricao());
				book.setLink(bookmark.getLink());
				book.setId(bookmark.getId());
				break;
			}
		}
		System.out.println("done");
		
	}
	
	public void excluir(int id){
		
		for (Bookmark book : LISTA) {
			if(book.getId() == id){
				LISTA.remove(book);
				break;
			}
		}
	}
	
	
	
	
	
	
}
