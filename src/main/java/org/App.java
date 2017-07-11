/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;

import java.util.ArrayList;
import org.investsoft.telegra.ph.adapter.client.Client;
import org.investsoft.telegra.ph.adapter.client.Parser;
import org.investsoft.telegra.ph.adapter.model.Nodes.A;
import org.investsoft.telegra.ph.adapter.model.Nodes.B;
import org.investsoft.telegra.ph.adapter.model.CreateAccountRequest;
import org.investsoft.telegra.ph.adapter.model.CreateAccountResponse;
import org.investsoft.telegra.ph.adapter.model.CreatePageRequest;

/**
 *
 * @author SMS
 */
public class App {

    public static void main(String... args) {
        Parser p = new Parser("c:\\temp\\s111.html");
        //Parser p = new Parser("https://sdelanounas.ru/blogs/93265/");
        CreatePageRequest req = new CreatePageRequest();
        req.access_token = "1e47e0f4216a322878119fb9fbcc184a567837d5a6e9326c90acf1ddfa6f";
        req.author_name = "Вася";
        req.title = p.getTitle("<h1 class=\"h1_openblog\">(.*?)<\\/h1>");
        req.content = new ArrayList<>();
        A n1 = new A();
        n1.setHref("https://regex101.com/");
        n1.setAlt("Прямая ссылка");
        B n2 = new B();
        n2.setValue("https://regex101.com/");
        n1.addNode(n2);
        //req.content.add(n1);
        req.return_content= true;
        req.content.addAll(p.getNodes("<div class=\"text __sun_article_text\">(.*)<div class=\"info\">"));
        new Client().makeRequest(req);
    }

    public static void createAccount() {
        CreateAccountRequest req = new CreateAccountRequest();
        req.short_name = "Вася";
        req.author_name = "Василий";
        req.author_url = "http://google.com/";
        Object res = new Client().execute(Client.Method.createAccount, req, CreateAccountResponse.class);
        System.out.println(res);
    }
}
