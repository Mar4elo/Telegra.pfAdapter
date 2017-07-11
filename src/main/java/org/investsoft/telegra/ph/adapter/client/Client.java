/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.investsoft.telegra.ph.adapter.client;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.investsoft.telegra.ph.adapter.model.annotations.FieldDescription;

/**
 *
 * @author SMS
 */
public class Client {

    public Client() {
    }

    public <T> T execute(Method method, Object request, Class<T> responseClass) {
        String req = this.makeRequest(request);
        String ret = this.POST(method, req);
        return this.makeResponse(ret, responseClass);
    }

    public enum Method {
        createAccount, createPage;
    }

    private String POST(Method method, String req) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL("https://api.telegra.ph/".concat(method.name()));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            try (OutputStream os = connection.getOutputStream()) {
                os.write(req.getBytes("UTF-8"));
                os.flush();
            }
            try (InputStream ins = connection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(ins);
                    BufferedReader in = new BufferedReader(isr)) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    sb.append(inputLine);
                }
            };
        } catch (MalformedURLException | ProtocolException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }

    public String makeRequest(Object req) {
        StringBuilder sb = new StringBuilder();
        for (Field f : req.getClass().getDeclaredFields()) {
            try {
                Object val = f.get(req);
                if (val != null) {
                    String name = f.getName();
                    if(f.isAnnotationPresent(FieldDescription.class) && f.getAnnotation(FieldDescription.class).asJson()){
                        val = this.getJSON(val);
                    }
                    if (f.isAnnotationPresent(FieldDescription.class)
                            && val instanceof String
                            && val.toString().length() > f.getAnnotation(FieldDescription.class).length()) {
                        val = val.toString().substring(0, f.getAnnotation(FieldDescription.class).length());
                    }
                    sb.append(sb.length() > 0 ? "&" : "").append(name).append("=").append(val.toString());
                }
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    private <T> T makeResponse(String response, Class<T> responseClass) {
        System.out.println(response);
        return null;
    }
    
    private String getJSON(Object obj){
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

}
