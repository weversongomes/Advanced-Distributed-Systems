package livro;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;
import java.net.DatagramPacket;

public class ServidorMulticast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket socket = new DatagramSocket();
			byte dados[] = new byte[1];
			
			for(;;) {
				dados[0] = (byte)(Math.random()*50);
				InetAddress enderecoMulticast = InetAddress.getByName("235.0.0.1");
				
				DatagramPacket datagrama = new DatagramPacket(dados, 1, enderecoMulticast, 8866);
				socket.send(datagrama);
				
				System.out.println("Dados servidor: "+dados[0]);
				TimeUnit.SECONDS.sleep(2);
			}
			
		}catch(Exception exc) {
			System.err.println(exc.getMessage());
		}

	}

}
