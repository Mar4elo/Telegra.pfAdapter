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
public final class A extends Node {

    public A() {
        super();
    }

    public A(String href, String alt, String val) {
        super();
        this.setHref(href);
        this.setAlt(alt);
        this.setValue(val);
    }

    public void setHref(String href) {
        if (href != null && !href.isEmpty()) {
            if (this.attrs == null) {
                this.attrs = new HashMap<>();
            }
            this.attrs.put("href", href);
        }
    }

    public void setAlt(String alt) {
        if (alt != null && !alt.isEmpty()) {
            if (this.attrs == null) {
                this.attrs = new HashMap<>();
            }
            this.attrs.put("alt", alt);
        }
    }

    public void setValue(String val) {
        if (val != null && !val.isEmpty()) {
            if (this.children == null) {
                this.children = new ArrayList<>();
            }
            this.children.add(val);
        }
    }
}
