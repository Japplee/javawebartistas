/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Artista;
import entidades.Estilo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
public class ControladorArtista extends HttpServlet {
    public ArrayList<Artista> artistas = new ArrayList<>();
    List<Estilo> estilos = Arrays.asList(Estilo.values());

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
        //artistas = (ArrayList<Artista>) session.getAttribute("artistasArray");
        //Valor del input nombre
        String inNombre = "";
        //Valor del input estilo
        String inEstilo = "";
        //Define si el formulario es de edición
        String inAction = "Guardar";
        //Artista a editar
        String indexEdit = "";
        
        //acciones por post
        if (request.getMethod().equals("POST")){
            String nombre = request.getParameter("nombre");
            String estilo  = request.getParameter("estilo");
            //Editar un artista
            if (request.getParameter("postAction").equals("Editar")){
                artistas.get(Integer.parseInt(request.getParameter("indexEdit"))).setNombre(nombre);
                artistas.get(Integer.parseInt(request.getParameter("indexEdit"))).setEstilo(Estilo.valueOf(estilo));
            //Agregar nuevo artista
            } else {
                Artista nuevoArtista = new Artista();
                nuevoArtista.setNombre(nombre);
                nuevoArtista.setEstilo(Estilo.valueOf(estilo));
                artistas.add(nuevoArtista);
            }       
        }
        
        String action = (String) request.getParameter("action");
        if (action != null) {
            //Eliminar un artista
            if (action.equals("delete")){
               // falta validar que exista el index
                artistas.remove(Integer.parseInt(request.getParameter("id")));
            //Cargar datos vista editar
            } else if (action.equals("edit")){
                //falta validar que exista el index
                inNombre = artistas.get(Integer.parseInt(request.getParameter("id"))).getNombre();
               
                inEstilo = artistas.get(Integer.parseInt(request.getParameter("id"))).getEstilo().toString();
                
                inAction = "Editar";
                indexEdit = request.getParameter("id");     
            }
        }
        
        request.setAttribute("inNombre", inNombre);
        request.setAttribute("inEstilo", inEstilo);
        request.setAttribute("inAction", inAction);
        request.setAttribute("indexEdit", indexEdit);
        request.setAttribute("artistas", artistas);
        request.setAttribute("estilos", estilos);
        
        session.setAttribute("artistasArray", artistas);
        
        RequestDispatcher rd = request.getRequestDispatcher("vista-artista.jsp");
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
