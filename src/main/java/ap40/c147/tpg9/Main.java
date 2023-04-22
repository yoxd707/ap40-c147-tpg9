package ap40.c147.tpg9;

import ap40.c147.db.DbManager;
import java.io.FileReader;
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder;

public class Main {

    public static void main(String[] args) {
        try {
            String archivoDeConfiguracion = args[0];

            List<Configuracion> csvConfiguracion = new CsvToBeanBuilder<Configuracion>(new FileReader(archivoDeConfiguracion))
                .withType(Configuracion.class)
                .build()
                .parse();

            if (csvConfiguracion.size() == 0)
                throw new RuntimeException("El archivo de configuración no contiene datos.");

            Configuracion configuracion = csvConfiguracion.get(0);

            DbManager dbManager = new DbManager(
                configuracion.getDatabase(),
                configuracion.getUsername(),
                configuracion.getPassword()
            );

            dbManager.setup();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
