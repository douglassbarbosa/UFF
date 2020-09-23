

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
        <%
           String tmp = null;
           String op= null;
           float a = 0;
           float b = 0;
           float resultado = 0;
           
           tmp = request.getParameter("Campo1");
           a = Float.parseFloat(tmp);
           
           tmp = request.getParameter("Campo2");
           b = Float.parseFloat(tmp);
           
           op = request.getParameter("operador");
            switch (op) {
                case '+':
                        resultado = a+b
                        System.out.println ("Resultado Final = " + resultado);
                        break;                   
                case '-':
                        resultado = a-b
                        System.out.println ("Resultado Final = " + resultado);
                        break;                   
                case '*':
                        resultado = a*b
                        System.out.println ("Resultado Final = " + resultado);
                        break;                   
                case '/':
                   if (b != 0){     
                        resultado = a/b
                        System.out.println ("Resultado Final = " + resultado);
                        break;
                    } else {
                        System.out.println ("Resultado Final = INVALIDO");
                        break;
                    }
               default:
                        System.out.println ("Operador Inválido");
            }
        %>
    </head>
    <body>
        <h1>Resultado</h1>
        <br>
        <p> Resultado = <%= resultado %></p>
    </body>
</html>
