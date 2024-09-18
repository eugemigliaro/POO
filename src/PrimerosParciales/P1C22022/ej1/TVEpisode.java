package PrimerosParciales.P1C22022.ej1;

import java.time.LocalDate;

/* Se desea modelar una temporada de episodios de televisión.
Cada episodio cuenta con un número identificador único, un título, un rating (un valor no nulo entre 0.0 y 10.0 inclusive)
basado en las puntuaciones del usuario y una fecha de emisión.
Una temporada se compone de un arreglo de episodios.
Ya cuenta con la implementación de la clase TVEpisode (que puede modificarse).

La clase que modela a la temporda de episodios recibe, al momento de instanciarse, el arreglo de episodios de televisión que la componen.
Esta clase debe contar con métodos para consultar los episodios de la temporada con cierto orden.
Implementar TVSeason y todo lo necesario para que, con el siguiente programa de prueba, se obtenga la salida indicada en los comentarios:
*/

public class TVEpisode {
    private final int id;
    private final String title;
    private final double rating;
    private final LocalDate airedDate;

    public TVEpisode (int id, String title, double rating, LocalDate airedDate){
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.airedDate = airedDate;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public double getRating() {
        return rating;
    }

    public LocalDate getAiredDate(){
        return airedDate;
    }
}
