
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
   <jsp:useBean id="book" class="br.com.uni.modelo.Bookmark" scope="request">
   </jsp:useBean>
   <jsp:setProperty property="*" name="book"/> 
 
   <h1>Bookmark list</h1>
   <hr/>
   
   <form action="BookmarkServlet?act=gravarEditar" method="post" >
    
      <fieldset style="border-color: black; ">
          <legend>Formulário</legend>
          
          
          <label>Id</label>
          <fieldset style="border-color: black; ">
             <%=book.getId() %> 
             <input type="hidden" value="<%=book.getId() %>" name="id">  
          </fieldset>
           
          <br/>
          
          
          <label>Descrição</label>
          <input type="text" size="80" name="descricao" value="<%=book.getDescricao() %>" >
          <br/>
          
          <label>Link</label>
          <input type="text" size="80" name="link" value="<%=book.getLink() %>" >
          <br/>
          
          <input type="submit" value="Gravar">          
      </fieldset>
      
   </form>
   
   <!-- fim do form -->

</body>
</html>