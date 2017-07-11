/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.investsoft.telegra.ph.adapter.model;

import org.investsoft.telegra.ph.adapter.model.annotations.FieldDescription;

/**
 *
 * @author SMS
 */
public class CreateAccountRequest {

    @FieldDescription(length = 32)
    public String short_name;
    @FieldDescription(length = 128)
    public String author_name;
    @FieldDescription(length = 512)
    public String author_url;
}
