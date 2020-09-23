package gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.temporal.ValueRange;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstClass
 */
@WebServlet("/")
public class FirstClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//List of student reference number
	 private HashMap<Long,Float> studentRefNo; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //0. start
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		//create a new student reference number list
		studentRefNo = new HashMap<Long,Float>();
		
		//fill the list with student reference numbers
		studentRefNo.put(107001L, 82.3f);
		studentRefNo.put(107002L, 70.89f);
		studentRefNo.put(107003L, 50.32f);
		studentRefNo.put(107004L, 66.12f);
		studentRefNo.put(107005L, 55.55f);
		studentRefNo.put(107006L, 82.3f);
		studentRefNo.put(107007L, 70.89f);
		studentRefNo.put(107008L, 50.32f);
		studentRefNo.put(107009L, 66.12f);
		studentRefNo.put(1070010L, 55.55f);
		
		
		//html view for the client
		out.println("<html>");
		out.println("\r\n"
				+ "<head>\r\n"
				+ "  <meta charset=\"utf-8\">\r\n"
				+ "  <title>First Class</title>");
		out.println("<body>");
		out.println("<div class = \"container\" style=\"width:100vw; height:100vh; text-align:center;\">");
		
		out.println("<div class=\"container-wrapper\" style=\"position:absolute;top:45%; left:50%;transform: translate(-50%,-45%);\">");
			out.println("<h1>" + "First Class Or We Move?" + "</h1>");
			out.println("<div class = \"content\" \">");
			out.println("<form method=\"get\">\r\n"
				+ "  <label>Student Reference Number:\r\n"
				+ "    <input name=\"reference-number\" type=\"text\" value=\"\" placeholder=\"Enter Reference Number\">\r\n"
				+ "  </label>\r\n"
				+ "  <button \"style=position:sticky;\">Search</button>\r\n"
				+ "</form>\r\n"
				+ "");
			out.println("</div>");
			
		
		
	     //2.
	    //display status
	    Long parseLong = null;
	    boolean firstClass = false;
	    Object obj = new Object(); //object to clear dialog view
	    try{
	    	ValueRange stuRefRange = ValueRange.of(107001, 1070010);//range of acceptable student reference number
		   
	    	String getStuRefNo = request.getParameter("reference-number");
	    	
	    	System.out.println(getStuRefNo);  //debug get request value
		    parseLong = Long.parseLong(getStuRefNo);
			if(!stuRefRange.isValidValue(parseLong)) //if student reference number not in range then prompt user
				out.println("<dialog open>\r\n"
		    			+ "  <p>Acceptable Student Reference Number: <em>107001 - 1070010</em>.</p>\r\n"
		    			+ "</dialog>");
		    System.out.println("debug parseLong:" + parseLong);
	    } catch(RuntimeException e) {
	    	System.out.println("Runtime Exception thrown");
	    } finally {
	    	try{
	    		//3.
	    		System.out.println("Value:" + studentRefNo.get(parseLong));
	    		obj = studentRefNo.get(parseLong); //save null
	    		firstClass = studentRefNo.get(parseLong) >= 70.00; //true for grades greater or equal to 70.00
	    		System.out.println("Debug obj:"+obj);	
	    	} catch(RuntimeException e) {
	    		System.out.println("Runtime Exception caught");
	    	} finally {
	    		if(obj == null);
	    		else
	    		if(!firstClass) //if not in range then We MOVE TO brother
	    			out.println("<dialog open>\r\n"
			    			+ "  <p>My Brother, You have to move.</p>\r\n"
			    			+ "</dialog>");
				else //WELL DONE..First Class
	    		out.println("<dialog open>\r\n"
		    			+ "  <p>Well Done. First Class Honours!</p>\r\n"
		    			+ "</dialog>");
	    		
	    		
	    	}
	    	
	    }
	    //.4
	    out.println("</div>");
	    out.println("</div>");
	    out.println("</body>");
		out.println("</html>");
	
			
		
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
