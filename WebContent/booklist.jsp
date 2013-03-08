
<%@page import="br.com.uni.modelo.Bookmark"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   <h1>Bookmark list</h1>
   <hr/>
   
   <form action="BookmarkServlet?act=salvar" method="post" >
    
      <fieldset style="border-color: gray; ">
          <legend>Formulário</legend>
          
          <label>Descrição</label>
          <input type="text" size="80" name="descricao">
          <br/>
          
          <label>Link</label>
          <input type="text" size="80" name="link">
          <br/>
          
          <input type="submit" value="Gravar">          
      </fieldset>
      
   </form>
   
   <!-- fim do form -->
   <br/>
   
   <table cellpadding="1" cellspacing="0" border="1" style="width: 80%" > 
     <caption>Lista de bookmarks</caption>
  <tr>
    <th>Descrição</th>
    <th>Link</th>
    <th>Opções</th>
  </tr>
  
  <%
     List<Bookmark> lista = (List<Bookmark>) session.getAttribute("lista");
  	 if(lista != null)
  	 for(Bookmark b : lista){
  %>
  
  <tr>
    <td><%= b.getDescricao() %></td>
    <td> <%= b.getLink() %> </td>
    
    <td> 
      <a href="BookmarkServlet?id=<%= b.getId() %>&act=formEditar" >Editar</a>
      |
     <a href="BookmarkServlet?id=<%= b.getId() %>&act=excluir" >Excluir</a>
    
    </td>
    
  </tr>
  
  <%
  
  	 }
  	 %>
  
  
</table>

   
   
   
   
   


</body>
</html>