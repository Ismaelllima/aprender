<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <c:import url="/WEB-INF/jsp/css.jsp"></c:import>
            <title>Formulario</title>
        </head>
        <body>	
            <div class="col-lg-8 col-lg-offset-2">
            <c:forEach items="${errors}" var="erro">
                ${erro.category}:${erro.message}<br />
            </c:forEach>

                <form action="${linkTo[LivrosController].salva}" method="post" enctype="multipart/form-data">
                <fieldset>
                    <h2>Cadastro de livros</h2>
                    <ul>

                        <input type="hidden" name="livro.id" value="${livro.id}" />

                        <li>Titulo:<br /> <input type="text" name="livro.titulo" value="${livro.titulo}" />
                        </li>
                        
                        <li>Capa:<br/> <input type="file" name="capa" /></li>

                        <li>Descrição:<br /> <textarea  name="livro.descricao" value="${livro.descricao}" cols="5" rows="10"></textarea>
                        </li>

                        <li>ISBN:<br /> <input type="text" name="livro.isbn" value="${livro.isbn}" />
                        </li>

                        <li>Preço:<br /> <input type="text" name="livro.preco"	value="${livro.preco}" />
                        </li>

                        <li>Data de publicação: <br /> <input type="text" data-format="dd/MM/yyyy hh:mm:ss" name="livro.dataPublicacao" value='<fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss" value="${livro.dataPublicacao}" />' />
                        </li>

                        <button class="btn btn-primary" type="submit">Salvar</button>
                    </ul>

                </fieldset>
            </form>
        </div>
    </body>
</html>