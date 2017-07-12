/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.investsoft.telegra.ph.adapter.model.factories;

import org.investsoft.telegra.ph.adapter.model.Node;
import org.investsoft.telegra.ph.adapter.model.Nodes.A;
import org.investsoft.telegra.ph.adapter.model.Nodes.B;
import org.investsoft.telegra.ph.adapter.model.Nodes.Blockquote;
import org.investsoft.telegra.ph.adapter.model.Nodes.Img;
import org.investsoft.telegra.ph.adapter.model.Nodes.P;
import org.investsoft.telegra.ph.adapter.model.Nodes.Strong;
import org.jsoup.nodes.Element;

/**
 *
 * @author SMS
 */
public class NodeFactory {

    public Node createNode(Element el) {
        Node ret = null;
        System.out.println(el.tagName().toLowerCase());
        switch (el.tagName().toLowerCase()) {
            case "a":
                ret = this.createA(el);
                break;
            case "b":
                ret = this.createB(el);
                break;
            case "p":
                ret = this.createP(el);
                break;
            case "strong":
                ret = this.createStrong(el);
                break;
            case "img":
                ret = this.createImg(el);
                break;
        }
        return ret;
    }

    private Node createA(Element el) {
        A ret = new A();
        if (el.hasText()) {
            ret.setHref(el.attr("href"));
            ret.setAlt(el.attr("alt"));
            ret.setValue(el.text());
        }
        if (el.childNodeSize() > 0) {
            el.children().forEach(t -> ret.addNode(createNode(t)));
        }
        return ret;
    }

    private Node createB(Element el) {
        B ret = new B();
        if (el.hasText()) {
            ret.setValue(el.text());
        }
        if (el.childNodeSize() > 0) {
            el.children().forEach(t -> ret.addNode(createNode(t)));
        }
        return ret;
    }

    private Node createStrong(Element el) {
        Strong ret = new Strong();
        if (el.hasText()) {
            ret.setValue(el.text());
        }
        if (el.childNodeSize() > 0) {
            el.children().forEach(t -> ret.addNode(createNode(t)));
        }
        return ret;
    }

    private Node createP(Element el) {
        P ret = new P();
        if (el.hasText()) {
            ret.setAlign(Node.Align.getAlign(el.attr("align")));
            ret.setValue(el.text());
        }
        if (el.childNodeSize() > 0) {
            el.children().forEach(t -> ret.addNode(createNode(t)));
        }
        return ret;
    }
    
    private Node createImg(Element el) {
        Img ret = new Img();
        if (el.hasText()) {
            ret.setAlign(Node.Align.getAlign(el.attr("align")));
            ret.setAlt(el.attr("alt"));
            ret.setSrc(el.attr("src"));
        }
        if (el.childNodeSize() > 0) {
            el.children().forEach(t -> ret.addNode(createNode(t)));
        }
        return ret;
    }
}
