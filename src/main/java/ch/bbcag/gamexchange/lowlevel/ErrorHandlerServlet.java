package ch.bbcag.gamexchange.lowlevel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorHandlerServlet
 */
@WebServlet(urlPatterns={"/ErrorHandler"})
public class ErrorHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorHandlerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processError(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processError(request, response);
	}
	
	private void processError(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    // Analyze the servlet exception
	    Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
	    Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
	    String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
	    if (servletName == null) {
	      servletName = "Unbekannt";
	    }
	    String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
	    if (requestUri == null) {
	      requestUri = "Unbekannt";
	    }

	    // Set response content type
	    response.setContentType("text/html");

	    PrintWriter out = response.getWriter();
	    out.write("<html><head><title>Exception/Fehler Detail</title></head><body>");
	    if (statusCode != 500) {
	      out.write("<h3>Error Detail</h3>");
	      out.write("<strong>Fehlercode</strong>:" + statusCode + "<br>");
	      out.write("<strong>Aufgerufene URI</strong>:" + requestUri);
	    } else {
	      out.write("<h3>Exception Detail</h3>");
	      out.write("<ul><li>Servlet Name:" + servletName + "</li>");
	      out.write("<li>Exception Name:" + throwable.getClass().getName() + "</li>");
	      out.write("<li>Aufgerufene URI:" + requestUri + "</li>");
	      out.write("<li>Exception:" + throwable.getMessage() + "</li>");
	      out.write("</ul>");
	    }

	    out.write("<br><br>");
	    out.write("<a href=\"/inf-mod-ee-lowlevel\">Startseite</a>");
	    out.write("</body></html>");
	  }
}
