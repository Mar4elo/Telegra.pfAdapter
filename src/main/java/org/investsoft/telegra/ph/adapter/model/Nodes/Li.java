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
public final class Li extends Node {

    public Li() {
        super();
    }

    public Li(String type, Long value) {
        super();
        this.setType(type);
        this.setValue(value);
    }

    public void setType(String type) {
        if (type != null && !type.isEmpty()) {
            if (this.attrs == null) {
                this.attrs = new HashMap<>();
            }
            this.attrs.put("type", type);
        }
    }

    public void setValue(Long value) {
        if (value != null) {
            if (this.attrs == null) {
                this.attrs = new HashMap<>();
            }
            this.attrs.put("value", value);
        }
    }
}
