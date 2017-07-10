/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.investsoft.telegra.ph.adapter.ws;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.investsoft.telegra.ph.adapter.model.*;

/**
 *
 * @author SMS
 */
@WebService(name = "TelegraphFacade", serviceName = "TelegraphFacadeService")
@Stateless
public class Facade {

    @WebMethod( action = "org.investsoft.telegra.ph.adapter.ws.createAccount", operationName = "createAccount")
    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        CreateAccountResponse ret = null;

        return ret;
    }
}
