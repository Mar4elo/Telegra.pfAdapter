/*
 * To change this license header, choose License Headers in Project P                return null; //To change body of generated lambdas, choose Tools | Templates.
rope                return null; //To change body of generated lambdas, choose Tools | Templates.
rties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.investsoft.telegra.ph.adapter.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.investsoft.telegra.ph.adapter.model.Node;
import org.investsoft.telegra.ph.adapter.model.Nodes.A;
import org.investsoft.telegra.ph.adapter.model.Nodes.Img;
import org.investsoft.telegra.ph.adapter.model.Nodes.P;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author SMS
 */
public class Parser {

    private String text = "";
    private String url = "";
    private final List<Node> nodes = new ArrayList<>();

    public Parser(String url) {
        this.url = url;
        this.text = this.getFromDisk(url);
    }

    public String getTitle(String pat) {
        String ret = "";
        Pattern pattern = Pattern.compile(pat, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.text);
        if (matcher.find()) {
            ret = matcher.group(1).trim();
        }
        return ret;
    }

    public List<Node> getNodes(String pat) {
        try {
            //Document doc = Jsoup.connect(this.url).get();
            Document doc = Jsoup.parse(new File(this.url), "UTF-8", "http://example.com/");
            doc.select("div[class='text __sun_article_text']").stream().collect(Collectors.toList()).get(0).children()
                    .stream().forEach(t -> {
                        addNode(t);
                        el(t.children());
                    });

            int a = 1;
        } catch (IOException ex) {
        }

        return this.nodes;
    }

    private void el(Elements els) {
        if (els != null) {
            els.stream().forEach(t -> {
                addNode(t);
                el(t.children());
            });
        }
    }

    private void addNode(Element el) {
        System.out.println(el.tagName() + ": " + el.text());
        Node n = null;
        switch (el.tagName().toLowerCase()) {
            case "img":
                n = new Img();
                ((Img) n).setSrc(el.attr("src"));
                ((Img) n).setAlt(el.attr("alt"));
                break;
            case "p":
                if (el.hasText()) {
                    n = new P();
                    ((P) n).setValue(el.text());
                }
                break;
            case "a":
                if (el.hasText()) {
                    n = new A();
                    ((A) n).setHref(el.attr("href"));
                    ((A) n).setAlt(el.attr("alt"));
                    ((A) n).setValue(el.text());
                }
                break;

        }
        if (n != null) {
            this.nodes.add(n);
        }
    }

    public String getSource(String url) {
        String ret = "";
        try {
            URLConnection conn = new URL(url).openConnection();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringWriter sw = new StringWriter();
                    BufferedWriter bw = new BufferedWriter(sw)) {
                String inputLine;
                while ((inputLine = br.readLine()) != null) {
                    bw.write(inputLine);
                }
                ret = sw.toString();
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public String getFromDisk(String path) {
        String ret = "";
        try {
            ret = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
}
