package ap40.c147.tpg9;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.ToString;

/** Clase {@code Configuracion} usada como modelo para
 * la configuración del programa.
 * @author Castaño Ulises.
 * @author ulises27.000@gmail.com
 */
@ToString
@Getter
public class Configuracion {

    @CsvBindByName private String database;
    @CsvBindByName private String username;
    @CsvBindByName private String password;
    @CsvBindByName private int puntos;
    @CsvBindByName private int puntosExtra;

}
