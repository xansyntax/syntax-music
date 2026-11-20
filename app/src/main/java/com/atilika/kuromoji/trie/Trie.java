package com.atilika.kuromoji.trie;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class Trie {
    private Node root = new Node();

    public void add(String str) {
        this.root.add(str, true);
    }

    public Node getRoot() {
        return this.root;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class Node {
        private List<Node> children = new ArrayList();
        private char key;

        public Node(char c) {
            this.key = c;
        }

        private Node getChild(char c) {
            for (Node node : this.children) {
                if (node.getKey() == c) {
                    return node;
                }
            }
            return null;
        }

        public void add(String str, boolean z) {
            if (str.length() == 0) {
                return;
            }
            Node nodeAddChild = addChild(Trie.this.new Node(str.charAt(0)));
            for (int i = 1; i < str.length(); i++) {
                nodeAddChild = nodeAddChild.addChild(Trie.this.new Node(str.charAt(i)));
            }
            if (!z || nodeAddChild == null) {
                return;
            }
            nodeAddChild.addChild(Trie.this.new Node((char) 1));
        }

        public Node addChild(Node node) {
            Node child = getChild(node.getKey());
            if (child != null) {
                return child;
            }
            this.children.add(node);
            return node;
        }

        public List<Node> getChildren() {
            return this.children;
        }

        public char getKey() {
            return this.key;
        }

        public boolean hasSinglePath() {
            int size = this.children.size();
            if (size == 0) {
                return true;
            }
            if (size != 1) {
                return false;
            }
            return this.children.get(0).hasSinglePath();
        }

        public Node() {
        }

        public void add(String str) {
            add(str, false);
        }
    }
}
