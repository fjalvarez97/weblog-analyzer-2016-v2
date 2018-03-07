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

    public int getAno() 
    {
        return ano;
    }

    public int getMes()
    {
        return mes;
    }

    public int getDia()
    {
        return dia;
    }

    public int getHora()
    {
        return hora;
    }

    public int getMinutos()
    {
        return minutos;
    }

    public String getIp()
    {
        return ip;
    }

    public String getWebPage()
    {
        return webPage;
    }

    public int getCodRespuesta()
    {
        return codRespuesta;
    }

    public int getUltimoNumIp()
    {
        String ip2 = ip.substring(ip.length()-2,ip.length()).replace(".","");
        int numIp = Integer.parseInt(ip2);
        return numIp;
    }
}