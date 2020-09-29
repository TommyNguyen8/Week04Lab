package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author 791662
 */
public class NoteServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {   
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
                try (BufferedReader br = new BufferedReader(new FileReader(new File(path)))) 
                {
                    String title = null;
                    String content = null;
                    String line;
                    int counter = 0;

                    while((line = br.readLine()) != null)
                    {
                        counter++;
                        if(counter == 1)
                        {
                            title = line;
                        }
                        else
                        {
                            content = line;
                        }
                    }

                    Note note = new Note(title, content);
                    request.setAttribute("note", note);

                    br.close();
                }
                
            String edit = request.getParameter("edit");
            
            if(edit != null)
            {   
                getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                        .forward(request, response);
                return;
            }
            
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
            
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)))) 
        {
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            
            pw.println(title);
            pw.println(content);
            
            Note note = new Note(title, content);
            request.setAttribute("note", note);
            
            pw.close();
            
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                    .forward(request, response);
        }
    }
}
