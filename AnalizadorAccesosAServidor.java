import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> accesos;

    public AnalizadorAccesosAServidor() 
    {
        accesos = new ArrayList<>();
    }

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

    
    public String paginaWebMasSolicitada()
    {
        String aDevolver = null;
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
                            aDevolver = primeraWeb;
                            contador2 = contador;
                        }
                    }
                }
            }
        }
        return aDevolver;
    }

    public String clienteConMasAccesosExitosos()
    {
        return "";
    }

}
