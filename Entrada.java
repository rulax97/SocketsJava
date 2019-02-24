import java.util.Scanner;
import java.lang.*;
class Entrada
{
    public static void main(String[] args)
    {
      //SENSOR
      Scanner entrada=new Scanner(System.in);
      String tipo="", nombresensor="", nombresensor2="", tiempo="", fecha="", nombreobservante="",total2="";
      double dato=0;
      int checksum=0,checksum2=0;
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
          do
          {
            System.out.print("Ingresa el tiempo (HHMMSS): ");
            tiempo = entrada.nextLine();
          }while(tiempo.length()>0 && tiempo.length()<6);
          do
          {
            System.out.print("Ingresa la fecha (DDMMAAAA)): ");
            fecha = entrada.nextLine();
          } while (fecha.length()>0 && fecha.length()<8);
          String Mensaje = sta1[0]+nombresensor+total2+tiempo+fecha;
          System.out.print(Mensaje);
          char[] sta2 = Mensaje.toCharArray();
          for (int x=0;x<sta2.length;x++)
          {
            checksum= checksum + (int) sta2[x];
          }
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
          do
          {
            System.out.print("Ingresa el nombre del observante (8 caracteres solamente): ");
            nombreobservante = entrada.nextLine();
            if(nombreobservante.length()==1)
            {
              nombreobservante=nombreobservante+"XXXXXXX";
            }
            else if(nombreobservante.length()==2)
            {
              nombreobservante=nombreobservante+"XXXXXX";
            }
            else if(nombreobservante.length()==3)
            {
              nombreobservante=nombreobservante+"XXXXX";
            }
            else if(nombreobservante.length()==4)
            {
              nombreobservante=nombreobservante+"XXXX";
            }
            else if(nombreobservante.length()==5)
            {
              nombreobservante=nombreobservante+"XXX";
            }
            else if(nombreobservante.length()==6)
            {
              nombreobservante=nombreobservante+"XX";
            }
            else if(nombreobservante.length()==7)
            {
              nombreobservante=nombreobservante+"X";
            }
            else if(nombreobservante.length()==8)
            {
              nombreobservante=nombreobservante;
            }
            else
            {
              System.out.println("No ingresaste un nombre de observante correcto.");
            }
          } while(nombreobservante.length()>0 && nombreobservante.length()<8);
          do
          {
            System.out.print("Ingresa el nombre del sensor (8 caracteres solamente): ");
            nombresensor2 = entrada.nextLine();
              if(nombresensor2.length()==1)
              {
                nombresensor2=nombresensor2+"XXXXXXX";
              }
              else if(nombresensor2.length()==2)
              {
                nombresensor2=nombresensor2+"XXXXXX";
              }
              else if(nombresensor2.length()==3)
              {
                nombresensor2=nombresensor2+"XXXXX";
              }
              else if(nombresensor2.length()==4)
              {
                nombresensor2=nombresensor2+"XXXX";
              }
              else if(nombresensor2.length()==5)
              {
                nombresensor2=nombresensor2+"XXX";
              }
              else if(nombresensor2.length()==6)
              {
                nombresensor2=nombresensor2+"XX";
              }
              else if(nombresensor2.length()==7)
              {
                nombresensor2=nombresensor2+"X";
              }
              else if(nombresensor2.length()==8)
              {
                nombresensor2=nombresensor2;
              }
              else
              {
                System.out.println("No ingresaste un nombre de observante correcto.");
              }
          } while(nombresensor2.length()>0 && nombresensor2.length()<8);
        }
        catch (Exception QW)
        {
          System.out.println("Error no ingresaste un valor correcto.");
        }
        String Mensaje2 = sta1[0]+nombreobservante+nombresensor2;
        System.out.print(Mensaje2);
        char[] sta3 = Mensaje2.toCharArray();
        for (int y=0;y<sta3.length;y++)
        {
          checksum2= checksum2 + (int) sta3[y];
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
