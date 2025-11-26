package cnlabexam;
import java.net.*;

public class Fifthsend {
    public static void main(String[] args) throws Exception {

        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");

        String msg = "Hello, Sliding Window!";
        byte[] data = msg.getBytes();

        int window = 4;
        int base = 0;

        while (base < data.length) {

            for (int i = base; i < base + window && i < data.length; i++) {

                byte[] sendData = new byte[2];
                sendData[0] = (byte) i;
                sendData[1] = data[i];

                DatagramPacket p = new DatagramPacket(sendData, sendData.length, ip, 9999);
                System.out.println("Sent: " + (char) data[i] + " | Seq=" + i);
                socket.send(p);
            }

            byte[] ackBuf = new byte[1];
            DatagramPacket ackPacket = new DatagramPacket(ackBuf, ackBuf.length);

            socket.receive(ackPacket);
            int ack = ackBuf[0] & 0xFF;

            System.out.println("Received ACK: " + ack);

            base = ack + 1;
        }

        socket.close();
    }
}
