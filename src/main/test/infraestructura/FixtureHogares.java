package infraestructura;

import infraestructura.hogares.Hogar;
import infraestructura.hogares.HogaresResponse;

import java.util.ArrayList;

public class FixtureHogares {

    protected static HogaresResponse hogaresResponse = crear_hogares();

    private static HogaresResponse crear_hogares() {
        hogaresResponse = new HogaresResponse();
        Hogar hogar = new Hogar();
        hogaresResponse.hogares = new ArrayList<>();
        hogaresResponse.hogares.add(hogar);
        return hogaresResponse;
    }

}