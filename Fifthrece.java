package cnlabexam;
import java.net.*;

public class Fifthrece {
    public static void main(String[] args) throws Exception {

        DatagramSocket socket = new DatagramSocket(9999);
        int expect = 0;

        while (true) {

            byte[] buf = new byte[2];
            DatagramPacket p = new DatagramPacket(buf, buf.length);
            socket.receive(p);

            int seq = buf[0] & 0xFF;
            char ch = (char) buf[1];

            if (seq == expect) {
                System.out.println("Received: " + ch + " | Seq=" + seq);

                DatagramPacket ack = new DatagramPacket(new byte[]{(byte) seq}, 1, p.getAddress(), p.getPort());
                socket.send(ack);
                expect++;
            }

            if (ch == '!') break; // Stop automatically at end of message
        }

        socket.close();
    }
}
 