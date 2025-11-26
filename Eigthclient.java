package cnlabexam;

import java.net.*;

public class Eigthclient {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ip = InetAddress.getByName("127.0.0.1");

            String msg = "hello server";
            byte[] data = msg.getBytes();

            DatagramPacket packet =
                    new DatagramPacket(data, data.length, ip, 6788);
            socket.send(packet);

            byte[] buffer = new byte[1024];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);

            socket.receive(reply);
            System.out.println("Server replied: " +
                    new String(reply.getData(), 0, reply.getLength()));

            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}