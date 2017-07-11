/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.investsoft.telegra.ph.adapter.model;

import java.util.List;
import org.investsoft.telegra.ph.adapter.model.annotations.FieldDescription;

/**
 *
 * @author SMS
 */
public class CreatePageRequest {

    public String access_token;
    @FieldDescription(length = 256)
    public String title;
    @FieldDescription(length = 128)
    public String author_name;
    @FieldDescription(length = 512)
    public String author_url;
    @FieldDescription(length = 64000, asJson = true)
    public List<Node> content;
    public Boolean return_content = false;
}
