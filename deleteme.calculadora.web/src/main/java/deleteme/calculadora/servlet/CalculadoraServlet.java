package deleteme.calculadora.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import deleteme.calculadora.component.CalculadoraEngine;

public class CalculadoraServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		renderHtml(res, "0", "Por favor escriba los numeros, la operacion y pulse el boton de calcular");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String primerOperando = req.getParameter("primeroperando");
		String operador = req.getParameter("operador");
		String segundoOperando = req.getParameter("segundooperando");
		String calcular = req.getParameter("calcular");

		try {

			CalculadoraEngine engine = new CalculadoraEngine();
			String resultado = engine.calcular(primerOperando, operador, segundoOperando, calcular);
			renderHtml(res, resultado, "Por favor escriba los numeros, la operacion y pulse el boton de calcular");
		}
		catch (Exception ex) {
			renderHtml(res, "N/A", ex.getMessage());
		}
	}

	public void renderHtml(HttpServletResponse res, String resultado, String mensajes) throws ServletException, IOException {
		// Obtenemos un objeto Print Writer para enviar respuesta
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("");
		pw.println("<html lang='en' xmlns='http://www.w3.org/1999/xhtml'>");
		pw.println("<head>");
		pw.println("    <meta charset='utf-8' />");
		pw.println("    <title>Calculadora Web</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("    <h1>Calculadora Web</h1>");
		pw.println("    <form action='' method='POST'>");
		pw.println("		<fieldset>");
		pw.println("			<div>");
		pw.println("				<textarea name='resultado' rows='10' cols='40' readonly>");
		pw.println("				" + resultado + "");
		pw.println("				</textarea>");
		pw.println("				<p></p>");
		pw.println("				<span name='mensajes'>" + mensajes + "</span>");
		pw.println("			</div>");
		pw.println("			<hr>");
		pw.println("			<div>");
		pw.println("				<input name='primeroperando' type='text' />");
		pw.println("				<p></p>");
		pw.println("				<select name='operador'>");
		pw.println("				  <option value='add'>+</option>");
		pw.println("				  <option value='substract'>-</option>");
		pw.println("				  <option value='multiply'>*</option>");
		pw.println("				  <option value='divide'>/</option>");
		pw.println("				</select>");
		pw.println("				<p></p>");
		pw.println("				<input name='segundooperando' type='text' />");
		pw.println("			</div>");
		pw.println("			<hr>");
		pw.println("			<div>");
		pw.println("				<input name='calcular' type='submit' value='Calcular' />");
		pw.println("			</div>");
		pw.println("		</fieldset>");
		pw.println("    </form>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
} 