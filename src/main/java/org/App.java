/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;

import org.investsoft.telegra.ph.adapter.client.Client;
import org.investsoft.telegra.ph.adapter.model.CreateAccountRequest;
import org.investsoft.telegra.ph.adapter.model.CreateAccountResponse;

/**
 *
 * @author SMS
 */
public class App {

    public static void main(String... args) {
        CreateAccountRequest req = new CreateAccountRequest();
        req.short_name = "Вася";
        Object res = new Client().execute(Client.Method.createAccount, req, CreateAccountResponse.class);
        System.out.println(res);
    }
}
