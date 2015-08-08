package com.jbetfairng;

import com.google.gson.Gson;
import com.jbetfairng.enums.Exchange;
import com.jbetfairng.exceptions.LoginException;
import org.apache.http.client.methods.HttpPost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;

public class BetfairClient {

    private Exchange exchange;
    private Network networkClient;
    private String appKey;
    private String sessionToken;
    private Logger tracer;

    public BetfairClient(Exchange exchange, String appKey) {
        this.tracer = LogManager.getFormatterLogger("BetfairClient");
        this.exchange = exchange;
        this.appKey = appKey;
    }

    public Boolean login(
            String p12CertificateLocation,
            String p12CertificatePassword,
            String username,
            String password) throws LoginException {

        if (Helpers.isNullOrWhitespace(p12CertificateLocation))
            throw new IllegalArgumentException(p12CertificateLocation);
        if (Helpers.isNullOrWhitespace(p12CertificatePassword))
            throw new IllegalArgumentException(username);
        if (Helpers.isNullOrWhitespace(username))
            throw new IllegalArgumentException(username);
        if (Helpers.isNullOrWhitespace(password))
            throw new IllegalArgumentException(password);

        FileInputStream keyStream = null;
        try {
            KeyStore clientStore = KeyStore.getInstance("PKCS12");
            keyStream = new FileInputStream(p12CertificateLocation);
            clientStore.load(keyStream, p12CertificatePassword.toCharArray());

            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(clientStore, p12CertificatePassword.toCharArray());
            KeyManager[] kms = kmf.getKeyManagers();

            SSLContext sslContext = null;
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kms, null, new SecureRandom());

            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
            URL url = new URL("https://identitysso-api.betfair.com/api/certlogin");

            String postData = String.format("username=%s&password=%s", username, password);

            HttpsURLConnection request = (HttpsURLConnection) url.openConnection();
            request.setRequestMethod("POST");
            request.setRequestProperty("X-Application", this.appKey);
            request.setDoOutput(true);
            DataOutputStream writer = new DataOutputStream(request.getOutputStream());
            writer.writeBytes(postData);
            writer.flush();
            writer.close();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(request.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString());
            Gson gson = new Gson();
            LoginResponse loginResult = gson.fromJson(response.toString(), LoginResponse.class);
            if (loginResult.loginStatus.equals("SUCCESS")) {
                this.sessionToken = loginResult.sessionToken;
                this.networkClient = new Network(this.appKey, this.sessionToken, false);
                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            throw new LoginException(ex);
        } finally {
            try {
                keyStream.close();
            } catch (Exception ignore) {}
        }
    }

    public BetfairServerResponse<KeepAliveResponse> keepAlive() {
        return networkClient.keepAliveSynchronous();
    }
}
