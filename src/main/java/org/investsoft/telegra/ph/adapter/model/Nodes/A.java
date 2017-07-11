/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.investsoft.telegra.ph.adapter.model.Nodes;

import java.util.ArrayList;
import java.util.HashMap;
import org.investsoft.telegra.ph.adapter.model.Node;

/**
 *
 * @author SMS
 */
public class A extends Node {

    public void setHref(String href) {
        if (this.attrs == null) {
            this.attrs = new HashMap<>();
        }
        this.attrs.put("href", href);
    }

    public void setAlt(String alt) {
        if (this.attrs == null) {
            this.attrs = new HashMap<>();
        }
        this.attrs.put("alt", alt);
    }

    public void setValue(String val) {
        this.children = new ArrayList<>();
        this.children.add(val);
    }
}
