/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.investsoft.telegra.ph.adapter.model.Nodes;

import java.util.ArrayList;
import org.investsoft.telegra.ph.adapter.model.Node;

/**
 *
 * @author SMS
 */
public class I extends Node {

    public I() {
        super();
    }

    public I(String val) {
        super();
        this.setValue(val);
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
