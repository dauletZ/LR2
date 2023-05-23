package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "AnimeServlet", value = "/anime")
public class AnimeServlet extends HttpServlet {
    private static final String FILE_PATH = "H:/LR2/list.txt";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Anime> library = loadLibrary();
        String json = new Gson().toJson(library);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String format = request.getParameter("format");
        String releaseDate = request.getParameter("releaseDate");
        String genre = request.getParameter("genre");
        String status = request.getParameter("status");

        Anime newAnime = new Anime(title, format, releaseDate, genre, status);
        List<Anime> library = loadLibrary();
        library.add(newAnime);
        saveLibrary(library);
    }

    private List<Anime> loadLibrary() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        List<Anime> library = new Gson().fromJson(reader, new TypeToken<List<Anime>>(){}.getType());
        reader.close();

        if (library == null) {
            library = new ArrayList<>();
        }

        return library;
    }

    private void saveLibrary(List<Anime> library) throws IOException {
        FileWriter writer = new FileWriter(FILE_PATH);
        new Gson().toJson(library, writer);
        writer.close();
    }
}
