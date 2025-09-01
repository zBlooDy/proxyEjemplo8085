package com.ar.edu.utn.frba.ddsi.proxyEjemplo.models.services;

import com.ar.edu.utn.frba.ddsi.proxyEjemplo.models.entities.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HechoServices {

    private  List<Hecho> HECHOS;
    private  Coleccion COLECCION_A;
    private  Coleccion COLECCION_B;
    private  List<Coleccion> COLECCIONES;


    public HechoServices() {
        HECHOS = new ArrayList<>();
        COLECCIONES = new ArrayList<>();
    }
    @PostConstruct
    public void inicializarDatos() {
        Contribuyente contribuyente1 = new Registrado(UUID.randomUUID(), "Juan Perez");
        Contribuyente contribuyente2 = new Registrado(UUID.randomUUID(), "Maria Lopez");
        Contribuyente contribuyente3= new Registrado(UUID.randomUUID(), "Carlos Gomez");

        HECHOS = new ArrayList<>(List.of(new HechoTextual(
                        "SOY INSTANCIA 8082 Noticia Destacada",
                        "noticia",
                        new Categoria("Actualidad"),
                        new Ubicacion(3.4, 5.6),
                        LocalDateTime.now(),
                        List.of(new Etiqueta("Etiqueta2")),
                        contribuyente2,
                        "Contenido del hecho textual A"
                ),
                new HechoMultimedia(
                        "SOY INSTANCIA 8082 Reporte Visual",
                        "reporte",
                        new Categoria("Multimedia"),
                        new Ubicacion(7.8, 9.0),
                        LocalDateTime.now(),
                        List.of(new Etiqueta("Etiqueta3")),
                        contribuyente1,
                        List.of("imagen1.png", "video1.mp4")
                ),
                new HechoTextual(
                        "SOY INSTANCIA 8082 Curiosidad Local",
                        "curiosidad",
                        new Categoria("Cultura"),
                        new Ubicacion(4.2, 1.9),
                        LocalDateTime.now(),
                        List.of(new Etiqueta("Etiqueta4")),
                        contribuyente3,
                        "Descripción de la curiosidad local"
                ),
                new HechoMultimedia(
                        "SOY INSTANCIA 8082 Evidencia Fotográfica",
                        "evidencia",
                        new Categoria("Pruebas"),
                        new Ubicacion(6.1, 3.3),
                        LocalDateTime.now(),
                        List.of(new Etiqueta("Etiqueta5")),
                        Anonimo.getInstance(),
                        List.of("foto2.jpg", "audio1.mp3")
                ),
                new HechoTextual(
                        "SOY INSTANCIA 8082 Relato Vecinal",
                        "relato",
                        new Categoria("Testimonios"),
                        new Ubicacion(2.5, 8.7),
                        LocalDateTime.now(),
                        List.of(new Etiqueta("Etiqueta6")),
                        contribuyente1,
                        "Relato de un vecino sobre el evento"
                ),
                new HechoMultimedia(
                        "SOY INSTANCIA 8082 Archivo Multimedia",
                        "archivo",
                        new Categoria("Documentos"),
                        new Ubicacion(5.5, 7.7),
                        LocalDateTime.now(),
                        List.of(new Etiqueta("Etiqueta7")),
                        contribuyente2,
                        List.of("documento.pdf", "grabacion.wav")
                ),
                //"Ráfagas de más de 100 km/h causa estragos en San Vicente, Misiones",La región de San Vicente en Misiones sufrió los efectos de una intensa ráfagas de más de 100 km/h. El incidente obligando a evacuar a residentes de la zona. Se ha convocado al comité de crisis para coordinar las acciones de respuesta.,Ráfagas de más de 100 km/h,-27.029465,-54.436559,21/12/2007
                new HechoTextual(
                        "Ráfagas de más de 100 km/h causa estragos en San Vicente, Misiones",
                        "La región de San Vicente en Misiones sufrió los efectos de una intensa ráfagas de más de 100 km/h. El incidente obligando a evacuar a residentes de la zona. Se ha convocado al comité de crisis para coordinar las acciones de respuesta.",
                        new Categoria("Ráfagas de más de 100 km/h"),
                        new Ubicacion(-27.029465, -54.436559),
                        LocalDateTime.of(2007, 12, 21, 0, 0),
                        List.of(),
                        contribuyente3,
                        "La región de San Vicente en Misiones sufrió los efectos de una intensa ráfagas de más de 100 km/h. El incidente obligando a evacuar a residentes de la zona. Se ha convocado al comité de crisis para coordinar las acciones de respuesta."
                )));

        COLECCION_A = new Coleccion(
                "A123",
                List.of(
                        new HechoTextual(
                                "Hecho A1",
                                "noticia",
                                new Categoria("Actualidad"),
                                new Ubicacion(3.4, 5.6),
                                LocalDateTime.now(),
                                List.of(new Etiqueta("Etiqueta2")),
                                Anonimo.getInstance(),
                                "Texto del hecho A1"
                        ),
                        new HechoMultimedia(
                                "Hecho A2",
                                "reporte",
                                new Categoria("Multimedia"),
                                new Ubicacion(7.8, 9.0),
                                LocalDateTime.now(),
                                List.of(new Etiqueta("Etiqueta3")),
                                Anonimo.getInstance(),
                                List.of("imagenA2.png", "videoA2.mp4")
                        )
                )
        );
        COLECCION_B = new Coleccion(
                "B456",
                List.of(
                        new HechoTextual(
                                "Hecho B1",
                                "curiosidad",
                                new Categoria("Cultura"),
                                new Ubicacion(4.2, 1.9),
                                LocalDateTime.now(),
                                List.of(new Etiqueta("Etiqueta4")),
                                contribuyente1,
                                "Texto del hecho B1"
                        ),
                        new HechoMultimedia(
                                "Hecho B2",
                                "evidencia",
                                new Categoria("Pruebas"),
                                new Ubicacion(6.1, 3.3),
                                LocalDateTime.now(),
                                List.of(new Etiqueta("Etiqueta5")),
                                new Registrado(UUID.randomUUID(), "Juan Perez"),
                                List.of("fotoB2.jpg", "audioB2.mp3")
                        )
                )

        );
        COLECCIONES = List.of(COLECCION_A, COLECCION_B);
    }

    public List<Hecho> getHechos() {
        return HECHOS;
    }

    public Hecho getHechoPorId(@PathVariable UUID id) {
        return HECHOS.stream()
                .filter(h -> id.equals(h.getId()))
                .findFirst()
                .orElse(null);
    }


    public List<Hecho> getHechosPorColeccion(@PathVariable String id) {
        return COLECCIONES.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .map(Coleccion::getHechos)
                .orElse(List.of());
    }

}
