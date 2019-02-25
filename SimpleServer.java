// SimpleServer.java: a simple server program
import java.net.*;
import java.io.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//*Autor: Raul Ernesto Perez Barcenas*//
//*Matricula: 148661*//
//*Version: 1.0*//
//*Asignatura: Programacion Integrativa (UACJ)*//
public class SimpleServer
{
    public static String data="";
    public static String st="";
    public static OutputStream os = null;
    public static int checksum;
  	public static void inicio()
  	{
      data=st.trim();
      writeUsingOutputStream(data);
    }
    public static void writeUsingOutputStream(String data)
  	{
      try
      {
        os = new FileOutputStream(new File("medicion.txt"),true);
        os.write(data.getBytes(), 0, data.length());
      }
  		catch (IOException e)
  		{
        e.printStackTrace();
      }
  		finally
  		{
        try
  			{
          os.close();
        }
  			catch (IOException e)
  			{
          e.printStackTrace();
        }
      }
    }
    /****/
    public static void inicio2()
  	{
      data=st.trim();
      writeUsingOutputStream2(data);
    }
    public static void writeUsingOutputStream2(String data)
  	{
      try
      {
        os = new FileOutputStream(new File("transaccion.txt"),true);
        os.write(data.getBytes(), 0, data.length());
      }
  		catch (IOException e)
  		{
        e.printStackTrace();
      }
  		finally
  		{
        try
  			{
          os.close();
        }
  			catch (IOException e)
  			{
          e.printStackTrace();
        }
      }
    }
    /****/


  	public void Lectura()
  	{
    	BufferedReader reader;
    	try
    	{
    		reader = new BufferedReader(new FileReader(
    				"medicion.txt"));
    		String line = reader.readLine();
    		while (line != null)
        {
    			System.out.println(line);
    			line = reader.readLine();
    		}
    		reader.close();
    	}
    	catch (IOException e)
    	{
    		e.printStackTrace();
    	}
  	}
  public static void main(String[] args) throws IOException
  {
    if (args.length < 1)
    {
      System.out.println("Usage SimpleServer portNumber");
      System.exit(1);
    }
    int port = Integer.parseInt(args[0]);
    ServerSocket s = new ServerSocket(port);
    while(true)
    {
            Socket s1=s.accept();
            InputStream s1In = s1.getInputStream();
            DataInputStream dis = new DataInputStream(s1In);
            byte[] buffer = new byte[255];
            dis.read(buffer,0,31);
            st = new String (buffer);
            char[] comp = st.toCharArray();
            for (int y=0;y<comp.length;y++)
            {
              checksum = checksum + (int) comp[y];
            }
            int compare = (int) comp[0];
            if(compare==85)
            {
              inicio();
              System.out.println("Valor de checksum: "+checksum+ ".");
            }
            if(compare==82)
            {
              inicio2();
              System.out.println("Valor de checksum: "+checksum+ ".");
            }
            System.out.println(st);
            OutputStream s1out = s1.getOutputStream();
            DataOutputStream dos = new DataOutputStream (s1out);
            dos.close();
            dis.close();
            s1In.close();
            s1out.close();
            s1.close();
    }
  }
}
