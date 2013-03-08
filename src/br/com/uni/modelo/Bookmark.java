package br.com.uni.modelo;

public class Bookmark {
   
	 private static int COUNT;
	 
	 private int id = 1;
	 
	 private String descricao;
	 
	 private String link;
	 
	 //construtor
	 public Bookmark() {
		 id = Bookmark.COUNT++;
	 }

	 public Bookmark(String descricao, String link){
		 this();
		 this.descricao = descricao;
		 this.link = link;
	 }
	 
	 //gets
	public String getDescricao() {
		return descricao;
	}

	
	public String getLink() {
		return link;
	}

	public int getId(){
		return id;
	}
	 
	public int setId(int id){
		return id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setLink(String link) {
		this.link = link;
	}

	 
	 
	
}
