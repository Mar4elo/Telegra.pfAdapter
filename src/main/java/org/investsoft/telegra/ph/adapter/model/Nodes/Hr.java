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
public class Hr extends Node {

    public void setAlign(Align align) {
        if (this.attrs == null) {
            this.attrs = new HashMap<>();
        }
        this.attrs.put("align", align.name());
    }

    public void setColor(String color) {
        if (this.attrs == null) {
            this.attrs = new HashMap<>();
        }
        this.attrs.put("color", color);
    }

    public void setSize(Long size) {
        if (this.attrs == null) {
            this.attrs = new HashMap<>();
        }
        this.attrs.put("size", size);
    }

    public void setWidth(Long width) {
        if (this.attrs == null) {
            this.attrs = new HashMap<>();
        }
        this.attrs.put("width", width);
    }

}
