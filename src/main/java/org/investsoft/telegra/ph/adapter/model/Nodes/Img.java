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
public final class Img extends Node {

    public Img() {
        super();
    }

    public Img(String src, String alt, Align align, Long border) {
        super();
        this.setSrc(src);
        this.setAlt(alt);
        this.setAlign(align);
        this.setBorder(border);
    }

    public void setSrc(String src) {
        if (src != null && !src.isEmpty()) {
            if (this.attrs == null) {
                this.attrs = new HashMap<>();
            }
            this.attrs.put("src", src);
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

    public void setAlign(Align align) {
        if (align != null) {
            if (this.attrs == null) {
                this.attrs = new HashMap<>();
            }
            this.attrs.put("align", align.name());
        }
    }

    public void setBorder(Long border) {
        if (border != null) {
            if (this.attrs == null) {
                this.attrs = new HashMap<>();
            }
            this.attrs.put("border", border);
        }
    }
}
