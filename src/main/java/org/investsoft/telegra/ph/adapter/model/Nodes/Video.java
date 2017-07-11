/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.investsoft.telegra.ph.adapter.model.Nodes;

import java.util.HashMap;
import org.investsoft.telegra.ph.adapter.model.Node;

/**
 *
 * @author SMS
 */
public class Video extends Node {

    public void setSrc(String src) {
        if (this.attrs == null) {
            this.attrs = new HashMap<>();
        }
        this.attrs.put("src", src);
    }

}
