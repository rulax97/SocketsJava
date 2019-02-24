import java.util.Scanner;
import java.lang.*;
class Entrada
{
    public static void main(String[] args)
    {
      //SENSOR
      Scanner entrada=new Scanner(System.in);
      String tipo, nombresensor, nombresensor2, tiempo, fecha, nombreobservante,total2="";
      double dato;
      int checksum=0;
      boolean prueba;
      System.out.print("Selecciona tu tipo de usuario: U (Sensor) y R (Observador): ");
      tipo=entrada.nextLine();
      char[] sta1 = tipo.toCharArray(); //Arreglo de char mediante string.
      if(sta1[0]=='u'||sta1[0]=='U')
      {
        try
        {
          do
          {
            System.out.print("Ingresa el nombre del sensor (8 caracteres solamente): ");
            nombresensor = entrada.nextLine();
              if(nombresensor.length()==1)
              {
                nombresensor=nombresensor+"XXXXXXX";
              }
              else if(nombresensor.length()==2)
              {
                nombresensor=nombresensor+"XXXXXX";
              }
              else if(nombresensor.length()==3)
              {
                nombresensor=nombresensor+"XXXXX";
              }
              else if(nombresensor.length()==4)
              {
                nombresensor=nombresensor+"XXXX";
              }
              else if(nombresensor.length()==5)
              {
                nombresensor=nombresensor+"XXX";
              }
              else if(nombresensor.length()==6)
              {
                nombresensor=nombresensor+"XX";
              }
              else if(nombresensor.length()==7)
              {
                nombresensor=nombresensor+"X";
              }
              else if(nombresensor.length()==8)
              {
                nombresensor=nombresensor;
              }
              else
              {
                System.out.println("No ingresaste un nombre de sensor correcto.");
              }
          }while(nombresensor.length()>0 && nombresensor.length()<8);

          do
          {
            System.out.print("Ingresa dato de medicion (8 digitos solamente): ");
            dato = entrada.nextDouble();
            entrada.nextLine(); //Limpia el bufer de entrada.
            if(dato>=-99999.9 && dato<=999999.9)
            {
              total2 = Double.toString(dato);
              prueba = true;
            }
            else
            {
              prueba = false;
            }
          }while(!prueba);
          //(total2.length()>0 && total2.length()<8)
          System.out.print("Ingresa el tiempo (HHMMSS): ");
          tiempo = entrada.nextLine();
          System.out.print("Ingresa la fecha (DDMMAAAA)): ");
          fecha = entrada.nextLine();
          String Mensaje = tipo+nombresensor+total2+tiempo+fecha;
          System.out.print(Mensaje);
          //r4 = (int)dato; //Cast de Double a int.
          /*for (int x=0;x<sta1.length;x++)
          {
          r = r + (int) sta1[x];
          }
          char[] sta2 = tiempo.toCharArray();
          for (int x=0;x<sta2.length;x++)
          {
            r1 = r1 + (int) sta2[x];
          }
          char[] sta3 = nombresensor.toCharArray();
          for (int x=0;x<sta3.length;x++)
          {
            r2 = r2 + (int) sta3[x];
          }
          */
          //checksum=r+r1+r2+r4;
          //System.out.println(checksum);
          //String mensaje = tiempo+nombresensor+dato;
          /*Date date3 = Calendar.getInstance().getTime();
          SimpleDateFormat df = new SimpleDateFormat("d-MM-YYYY");
          System.out.println(df.format(date3));
          */
        }
        catch (Exception Q)
        {
          System.out.println("Error no ingresaste el valor correcto.");
        }
      }
      else if (sta1[0]=='r'||sta1[0]=='R')
      {
        try
        {
          //OBSERVANTE
          System.out.print("Ingresa el nombre del observante (8 caracteres solamente): ");
          nombreobservante = entrada.nextLine();
          System.out.print("Ingresa el nombre del sensor (8 caracteres solamente): ");
          nombresensor2 = entrada.nextLine();
          /*char[] sta4 = nombresensor2.toCharArray();
          char[] sta5 = nombreobservante.toCharArray();
          for (int x=0;x<sta4.length;x++)
          {
            r6 = r6 + (int) sta4[x];
          }
          for (int x=0;x<sta5.length;x++)
          {
            r5 = r5 + (int) sta5[x];
          }
          */
          //checksum2=r5+r6;
          //System.out.println(checksum2);
        }
        catch (Exception QW)
        {
          System.out.println("Error no seleccionaste la opcion correcta.");
        }
      }
      else
      {
        try
        {
          System.out.println("Error, no ingresaste la opcion correcta.");
        }
        catch (Exception QQ)
        {
          System.out.println("Error, no se ingreso una opcion valida.");
        }
      }
  }
}
