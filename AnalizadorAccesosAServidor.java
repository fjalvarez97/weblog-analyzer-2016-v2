import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> accesos;

    /**
     * Constructor de la clase AnalizadorAccesosAServidor.
     */
    public AnalizadorAccesosAServidor() 
    {
        accesos = new ArrayList<>();
    }

    /**
     * Metodo que analiza los archivos .log.
     * @param archivo : la ruta del archivo que vamos a analizar.
     */
    public void analizarArchivoDeLog(String archivo)
    {
        accesos.clear();
        File archivoALeer = new File(archivo);
        try {
            Scanner sc = new Scanner(archivoALeer);
            while (sc.hasNextLine()) {
                String lineaLeida = sc.nextLine();               
                Acceso accesoActual = new Acceso(lineaLeida);
                accesos.add(accesoActual);
            }
            sc.close();
        }
        catch (Exception e) {
            System.out.println("Ocurrio algun error al leer el archivo.");
        }
    }

    /**
     * Metodo que devuelve la hora con mas accesos
     * @return valorADevolver: la hora con mas accesos.
     */
    public int obtenerHoraMasAccesos() 
    {
        int valorADevolver = -1;
        if (!accesos.isEmpty()) {
            int[] accesosPorHora = new int[24];
            for (Acceso accesoActual : accesos) {
                int horaAccesoActual = accesoActual.getHora();
                accesosPorHora[horaAccesoActual] = accesosPorHora[horaAccesoActual] + 1;
            }

            int numeroDeAccesosMasAlto = accesosPorHora[0];
            int horaDeAccesosMasAlto = 0;
            for (int i = 0; i < accesosPorHora.length; i++) {
                if (accesosPorHora[i] >= numeroDeAccesosMasAlto) {
                    numeroDeAccesosMasAlto = accesosPorHora[i];
                    horaDeAccesosMasAlto = i;
                }
            }
            valorADevolver = horaDeAccesosMasAlto;                      
        }
        return valorADevolver;
    }

    /**
     * Metodo que devuelve la pagina web mas solicitada
     * @return paginaMasSolicitada: la pagina web mas solicitada.
     */
    public String paginaWebMasSolicitada()
    {
        String paginaMasSolicitada = null;
        int contador2 = 0;
        if (accesos.size()>0)
        {
            for (int i = 0; accesos.size() > i; i++)
            {
                String primeraWeb = accesos.get(i).getWebPage();
                int contador = 0;
                for (int j = 0; accesos.size() > j; j++)
                {
                    String webAComparar = accesos.get(j).getWebPage();
                    if (webAComparar.equals(primeraWeb))
                    {
                        contador ++;
                        if (contador > contador2 )
                        {
                            paginaMasSolicitada = primeraWeb;
                            contador2 = contador;
                        }
                    }
                }
            }
        }
        return paginaMasSolicitada;
    }

    /**
     * Metodo que devuelve la direccion ip con mas accesos exitosos
     * @return clienteMasAccesos: la direccion ip con mas accesos exitosos (la mayor en caso de empate).
     */
    public String clienteConMasAccesosExitosos()
    {
        String clienteMasAccesos = null;
        int contador2 = 0;
        if (accesos.size()>0)
        {
            for (int i = 0; accesos.size() > i; i++)
            {
                Acceso primerAcceso = accesos.get(i);
                int contador = 0;
                for (int j = 0; accesos.size() > j; j++)
                {
                    Acceso accesoAComparar = accesos.get(j);

                    if (primerAcceso.getIp().equals(accesoAComparar.getIp()) && accesoAComparar.getCodRespuesta() == 200 && primerAcceso.getCodRespuesta() == 200)
                    {
                        contador ++;
                        if (contador > contador2)
                        {
                            clienteMasAccesos = primerAcceso.getIp();
                            contador2 = contador;
                        }   
                        if (contador == contador2 && primerAcceso.getUltimoNumIp() > accesoAComparar.getUltimoNumIp())
                        {
                            clienteMasAccesos = primerAcceso.getIp();
                            contador2 = contador;
                        }
                    }
                }
            }
        }
        return clienteMasAccesos;
    }

}
