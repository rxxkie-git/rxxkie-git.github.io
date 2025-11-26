package cnlabexam;

import java.io.*;
import java.net.*;

public class Sevenclient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.1", 4000);

        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the file name: ");
        String fname = kb.readLine();

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println(fname);

        BufferedReader serverData = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line;
        while ((line = serverData.readLine()) != null)
            System.out.println(line);

        s.close();
}
}