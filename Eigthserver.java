package cnlabexam;

import java.net.*;
import java.util.Scanner;

public class Eigthserver {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(6788);
            byte[] buffer = new byte[1024];
            Scanner sc = new Scanner(System.in);

            System.out.println("Server started...");

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                System.out.println("Client says: " + new String(packet.getData(), 0, packet.getLength()));

                System.out.print("Enter reply: ");
                String reply = sc.nextLine();
                byte[] sendData = reply.getBytes();

                DatagramPacket sendPacket =
                        new DatagramPacket(sendData, sendData.length,
                                           packet.getAddress(), packet.getPort());

                socket.send(sendPacket);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
}
}