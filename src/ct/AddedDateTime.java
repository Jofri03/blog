package ct;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class AddedDateTime extends SimpleTagSupport {
	private Date date;

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public void doTag() throws JspException, IOException {
		try {
			PageContext pageContext = (PageContext)getJspContext();
			JspWriter out = pageContext.getOut();
			SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy HH:mm");
			out.write(String.format("<span class='text-success'>%s</span>", sdf.format(this.date)));
			System.out.println(this.date);
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
