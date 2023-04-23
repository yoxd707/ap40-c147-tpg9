package ap40.c147.tpg9;

import ap40.c147.datos.ParticipanteDAO;
import ap40.c147.datos.ParticipanteDAOCsv;
import ap40.c147.db.DbManager;
import java.io.FileReader;
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        listarParticipantes();

        try {
            String archivoDeConfiguracion = args[0];

            List<Configuracion> csvConfiguracion = new CsvToBeanBuilder<Configuracion>(new FileReader(archivoDeConfiguracion))
                    .withType(Configuracion.class)
                    .build()
                    .parse();

            if (csvConfiguracion.size() == 0) {
                throw new RuntimeException("El archivo de configuración no contiene datos.");
            }

            Configuracion configuracion = csvConfiguracion.get(0);

            DbManager dbManager = new DbManager(
                    configuracion.getDatabase(),
                    configuracion.getUsername(),
                    configuracion.getPassword()
            );

            dbManager.setup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void listarParticipantes() {

        ParticipanteDAO participanteDAO = new ParticipanteDAOCsv();

        Map<Integer, Participante> participantes = participanteDAO.select();

        System.out.println("Listado de participantes: \n");
        participantes.forEach((id, participante) -> {
            System.out.println("Participante nro: " + id);
            System.out.println("Id: " + id);
            System.out.println("Nombre: " + participante.getNombre() + "\n");
        });

    }

}
