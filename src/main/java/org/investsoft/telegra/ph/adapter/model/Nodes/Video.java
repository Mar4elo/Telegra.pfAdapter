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
public final class Video extends Node {

    public Video() {
        super();
    }

    public Video(String src) {
        super();
        this.setSrc(src);
    }

    public void setSrc(String src) {
        if (src != null && !src.isEmpty()) {
            if (this.attrs == null) {
                this.attrs = new HashMap<>();
            }
            this.attrs.put("src", src);
        }
    }
}
