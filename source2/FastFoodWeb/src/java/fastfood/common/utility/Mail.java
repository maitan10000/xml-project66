/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfood.common.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Everything
 */
public class Mail {

    public static void Send(String from, String to, String subject, String message) {

        try {
            String headers = "From: " + from + "\r\n";
            headers += "MIME-Version: 1.0\r\n";
            headers += "Content-type: text/html; charset=iso-8859-1\r\n";

            String address = "http://jrvnpz.comze.com/mail.php";
            String post = "";
            post = "to=" + URLEncoder.encode(to, "UTF-8")
                    + "&headers=" + URLEncoder.encode(headers, "UTF-8")
                    + "&subject=" + URLEncoder.encode(subject, "UTF-8")
                    + "&message=" + URLEncoder.encode(message, "UTF-8");

            URL url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", String.valueOf(post.length()));
            OutputStream os = connection.getOutputStream();
            os.write(post.getBytes());
            StringBuilder response = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String content = "";
            while ((content = br.readLine()) != null) {
                response.append(content);
            }
            br.close();
            os.close();

        } catch (IOException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
