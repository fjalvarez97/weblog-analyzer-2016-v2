public class Acceso
{
    private String ip;
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    private String webPage;
    private int codRespuesta;
    /**
     * Constructor de la clase Acceso
     * @param fecha: una cadena con los datos del acceso.
     */
    public Acceso(String fecha)
    {
        fecha = fecha.replace("[","");
        fecha = fecha.replace("]","");
        String[] elementos = fecha.split(" ");
        ip = elementos[0];
        ano = Integer.parseInt(elementos[1]);
        mes = Integer.parseInt(elementos[2]);
        dia = Integer.parseInt(elementos[3]);
        hora = Integer.parseInt(elementos[4]);
        minutos = Integer.parseInt(elementos[5]);
        webPage = elementos[6];
        codRespuesta = Integer.parseInt(elementos[7]);
    }

    /**
     * Metodo getter del ano.
     * @return ano : el ano del acceso.
     */
    public int getAno() 
    {
        return ano;
    }

    /**
     * Metodo getter del ano.
     * @return mes : el mes del acceso.
     */
    public int getMes()
    {
        return mes;
    }

    /**
     * Metodo getter del dia.
     * @return dia : el dia del acceso.
     */
    public int getDia()
    {
        return dia;
    }

    /**
     * Metodo getter de la hora.
     * @return hora : la hora del acceso.
     */
    public int getHora()
    {
        return hora;
    }

    /**
     * Metodo getter de los minutos.
     * @return minutos : los minutos de la hora del acceso.
     */
    public int getMinutos()
    {
        return minutos;
    }

    /**
     * Metodo getter de la direccion ip.
     * @return ip : la direccion ip del acceso.
     */
    public String getIp()
    {
        return ip;
    }

    /**
     * Metodo getter de la direccion web.
     * @return webPage : la direccion web del acceso.
     */
    public String getWebPage()
    {
        return webPage;
    }

    /**
     * Metodo getter del codRespuesta.
     * @return codRespuesta : el codigo de la respuesta del acceso.
     */
    public int getCodRespuesta()
    {
        return codRespuesta;
    }

    /**
     * Metodo getter del ultimo numero de la direccion ip.
     * @return numIp : el ultimo bloque de numeros de la direccion ip.
     */
    public int getUltimoNumIp()
    {
        String ip2 = ip.substring(ip.length()-2,ip.length()).replace(".","");
        int numIp = Integer.parseInt(ip2);
        return numIp;
    }
}