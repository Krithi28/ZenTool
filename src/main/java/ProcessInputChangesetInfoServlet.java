/**
 * Created by 441691 on 2/13/2015.
 */

import org.codehaus.plexus.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by 441691 on 1/13/2015.
 */
@WebServlet(name = "ProcessInputChangesetInfoServlet")
public class ProcessInputChangesetInfoServlet extends HttpServlet {

    private static final String CATEGORY = "category";
    private static final String CHANGESET = "changeset";
    private static final String TICKET = "ticket";
    private static final String DOC = "doc";
    private static final String COMMENTS = "comments";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         try {

            // getting input values
            response.setContentType("text/html;charset=UTF-8");
            String category = request.getParameter(CATEGORY);
            String changeset = request.getParameter(CHANGESET);
            String ticket = request.getParameter(TICKET);
            String doc = request.getParameter(DOC);
            String comments = request.getParameter(COMMENTS);

            // passing values to java class
            ProcessInputChangesetModel retrival = new ProcessInputChangesetModel();

            if (StringUtils.isNotBlank(category) && StringUtils.isNotBlank(changeset) && StringUtils.isNotBlank(ticket) && StringUtils.isNotBlank(doc))
                retrival.values(category, changeset, ticket, doc, comments);

            getServletConfig().getServletContext().getRequestDispatcher("/ViewChangesetInfo.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

