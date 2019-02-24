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
public class SimpleServer
{
  public static void main(String[] args) throws IOException
  {
    if (args.length < 1)
    {
      System.out.println("Usage SimpleServer portNumber");
      System.exit(1);
    }
    // Register service on port
    int port = Integer.parseInt(args[0]);
    ServerSocket s = new ServerSocket(port);
    while(true)
    {
            Socket s1=s.accept(); // Wait and accept a connection
            // Get a communication stream associated with the socket
            InputStream s1In = s1.getInputStream();
            DataInputStream dis = new DataInputStream(s1In);
            // read(byte[] b, int off, int len)
            byte[] buffer = new byte[255];
            dis.read(buffer,0,8);
            String st = new String (buffer);
            System.out.println(st);
            OutputStream s1out = s1.getOutputStream();
            DataOutputStream dos = new DataOutputStream (s1out);
            // Send a string!
            String text = "I got your message";
             //   write(byte[] b, int off, int len)
            dos.write(text.getBytes("utf-8"), 0, 18);
            // Close the connection
            dos.close();
            dis.close();
            s1In.close();
            s1out.close();
            s1.close();
    }
  }
}


/////////////////////
class General
{
	public static void archivo(String[] args)
	{
		EscribirArchivo c = new EscribirArchivo();
		c.inicio();
		LeerArchivo d = new LeerArchivo();
		d.Lectura();
	}
}

/*****/
class EscribirArchivo
{
	public static void inicio()
	{
    String data = "I will write this String to File in Java";
    writeUsingOutputStream(data);
    System.out.println("DONE");
  }

  public static void writeUsingOutputStream(String data)
	{
    OutputStream os = null;
    try {
      os = new FileOutputStream(new File("Archivo.txt"));
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
}
/******/
class LeerArchivo
{
	public static void Lectura()
	{
	BufferedReader reader;
	try
	{
		reader = new BufferedReader(new FileReader(
				"Archivo.txt"));
		String line = reader.readLine();
		while (line != null) {
			System.out.println(line);
			// read next line
			line = reader.readLine();
		}
		reader.close();
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
	}
}
