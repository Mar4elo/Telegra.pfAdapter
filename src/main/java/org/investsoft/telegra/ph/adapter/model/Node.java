/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.investsoft.telegra.ph.adapter.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SMS
 */
public class Node {

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
    }
}
