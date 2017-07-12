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
public final class P extends Node {

    public P() {
        super();
    }

    public P(String val, Align align) {
        super();
        this.setValue(val);
        this.setAlign(align);
    }

    public void setValue(String val) {
        if (val != null && !val.isEmpty()) {
            if (this.children == null) {
                this.children = new ArrayList<>();
            }
            this.children.add(val);
        }
    }

    public void setAlign(Align align) {
        if (align != null) {
            if (this.attrs == null) {
                this.attrs = new HashMap<>();
            }
            this.attrs.put("align", align.name());
        }
    }
}
