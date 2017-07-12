/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.investsoft.telegra.ph.adapter.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SMS
 */
public abstract class Node implements Serializable {

    public String tag;
    public Map<String, Object> attrs;
    public List<Object> children;
    public String value;

    public Node() {
        this.tag = this.getClass().getSimpleName().toLowerCase();
    }

    public void addNode(Node node) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        this.children.add(node);
    }

    public enum Align {
        center, left, right;

        public static Align getAlign(String val) {
            Align ret = null;
            switch (val) {
                case "center":
                    ret = center;
                    break;
                case "left":
                    ret = left;
                    break;
                case "right":
                    ret = right;
                    break;
            }
            return ret;
        }
    }
}
