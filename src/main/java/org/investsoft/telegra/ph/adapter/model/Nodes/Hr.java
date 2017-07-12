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
public final class Hr extends Node {

    public Hr() {
        super();
    }

    public Hr(Align align, String color, Long size, Long width) {
        super();
        this.setAlign(align);
        this.setColor(color);
        this.setSize(size);
        this.setWidth(width);
    }

    public void setAlign(Align align) {
        if (align != null) {
            if (this.attrs == null) {
                this.attrs = new HashMap<>();
            }
            this.attrs.put("align", align.name());
        }
    }

    public void setColor(String color) {
        if (color != null && !color.isEmpty()) {
            if (this.attrs == null) {
                this.attrs = new HashMap<>();
            }
            this.attrs.put("color", color);
        }
    }

    public void setSize(Long size) {
        if (size != null) {
            if (this.attrs == null) {
                this.attrs = new HashMap<>();
            }
            this.attrs.put("size", size);
        }
    }

    public void setWidth(Long width) {
        if (width != null) {
            if (this.attrs == null) {
                this.attrs = new HashMap<>();
            }
            this.attrs.put("width", width);
        }
    }
}
