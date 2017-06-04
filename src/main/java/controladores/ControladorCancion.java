/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Artista;
import entidades.Cancion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author heberarratia
 */
public class ControladorCancion extends HttpServlet {

    public ArrayList<Artista> artistas = new ArrayList<>();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        artistas = (ArrayList<Artista>) session.getAttribute("artistasArray");
        int id = Integer.parseInt(request.getParameter("id"));
        String inNombre = artistas.get(id).getNombre();
        String inCancion = "";
        Double inDuracion = 0.0;
        String inAction = "Guardar";
        if(request.getMethod().equals("POST")) {
            //Editar cancion
            if(request.getParameter("postAction").equals("Editar")) {
              int indexCancion = 0;
                String nombreCancion = request.getParameter("cancion");
                Double duracion = Double.parseDouble(request.getParameter("duracion"));
                artistas.get(id).editarCancion(indexCancion, nombreCancion, duracion);     
            //Agregar cancion
            }else { 
                String nombre = request.getParameter("nombre");
                String nombreCancion = request.getParameter("cancion");
                Double duracion = Double.parseDouble(request.getParameter("duracion"));
                Cancion cancion = new Cancion(nombreCancion, duracion);
                artistas.get(id).agregarCancion(cancion);
            }
        }
        
        String action = (String) request.getParameter("action");       
        if (action != null) {
            int idCancion = Integer.parseInt(request.getParameter("idcancion"));
            if(action.equals("delete")) {
                
                artistas.get(id).canciones.remove(idCancion);
                
            }else if(action.equals("edit")) {
                inCancion = artistas.get(id).canciones.get(idCancion).getNombre();
                inDuracion = artistas.get(id).canciones.get(idCancion).getDuracion();
                inAction = "Editar";
            }
        }
        request.setAttribute("inNombre", inNombre);
        request.setAttribute("inCancion", inCancion);
        request.setAttribute("inDuracion", inDuracion);
        request.setAttribute("inAction", inAction);
        
        RequestDispatcher rd = request.getRequestDispatcher("vista-cancion.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
