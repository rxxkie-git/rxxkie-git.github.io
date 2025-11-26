package cnlabexam;

import java.io.*;
import java.net.*;

public class Sevenserver {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(4000);
        System.out.println("Server ready for connection");

        Socket s = ss.accept();
        System.out.println("Connection is successful and waiting for chatting");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        String fname = in.readLine();
        File f = new File(fname);

        if (!f.exists()) {
            out.println("File not found");
            s.close();
            ss.close();
            return;
        }

        BufferedReader fileReader = new BufferedReader(new FileReader(f));
        String line;

        while ((line = fileReader.readLine()) != null)
            out.println(line);

        fileReader.close();
        s.close();
        ss.close();
}
}