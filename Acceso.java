public class Acceso
{
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;

    public Acceso(String fecha)
    {
        ano = Integer.parseInt(fecha.substring(0,4));
        mes = Integer.parseInt(fecha.substring(5,7));
        dia = Integer.parseInt(fecha.substring(8,10));
        hora = Integer.parseInt(fecha.substring(11,13));
        minutos = Integer.parseInt(fecha.substring(14,16));
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
}