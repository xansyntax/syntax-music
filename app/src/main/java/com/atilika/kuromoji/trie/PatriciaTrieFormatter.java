package com.atilika.kuromoji.trie;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class PatriciaTrieFormatter<V> {
    private static final String FONT_NAME = "Helvetica";

    private String formatHeader() {
        return "digraph patricia {\nnodesep=1.5;node [ style=\"filled\" fillcolor=\"#e8e8f0\" shape=\"Mrecord\" fontname=\"Helvetica\" ]\n";
    }

    private String formatNode(PatriciaTrie.PatriciaNode<V> patriciaNode, int i, PatriciaTrie.KeyMapper<String> keyMapper, boolean z) {
        if (patriciaNode.getBit() <= i) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer("\"");
        stringBuffer.append(getNodeId(patriciaNode));
        stringBuffer.append("\" [ label=");
        stringBuffer.append(formatNodeLabel(patriciaNode, keyMapper, z));
        stringBuffer.append(" ]\n");
        stringBuffer.append(formatPointer(patriciaNode, patriciaNode.getLeft(), "l", "sw"));
        stringBuffer.append(formatPointer(patriciaNode, patriciaNode.getRight(), "r", "se"));
        stringBuffer.append(formatNode(patriciaNode.getLeft(), patriciaNode.getBit(), keyMapper, z));
        stringBuffer.append(formatNode(patriciaNode.getRight(), patriciaNode.getBit(), keyMapper, z));
        return stringBuffer.toString();
    }

    private String formatNodeLabel(PatriciaTrie.PatriciaNode<V> patriciaNode, PatriciaTrie.KeyMapper<String> keyMapper, boolean z) {
        StringBuilder sb = new StringBuilder("<<table border=\"0\" cellborder=\"0\"><tr><td>key: <font color=\"#00a000\">");
        sb.append(getNodeLabel(patriciaNode));
        sb.append("</font> </td></tr><tr><td>bit: <font color=\"blue\">");
        sb.append(patriciaNode.getBit());
        sb.append("</font> </td></tr>");
        if (z) {
            sb.append("<tr><td>bitString: <font color=\"blue\">");
            String bitString = keyMapper.toBitString(patriciaNode.getKey());
            int bit = (patriciaNode.getBit() / 4) + patriciaNode.getBit();
            sb.append(bitString.substring(0, bit));
            sb.append("<font color=\"red\">");
            sb.append(bitString.charAt(bit));
            sb.append("</font>");
            sb.append(bitString.substring(bit + 1));
            sb.append("</font> </td></tr>");
        }
        sb.append("<tr><td>value: <font color=\"#00a0a0\">");
        sb.append(patriciaNode.getValue());
        sb.append("</font> </td></tr></table>>");
        return sb.toString();
    }

    private String formatPointer(PatriciaTrie.PatriciaNode<V> patriciaNode, PatriciaTrie.PatriciaNode<V> patriciaNode2, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(getNodeId(patriciaNode));
        sb.append(" -> ");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, getNodeId(patriciaNode2), " [ label=\"", str, " \"tailport=\"");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, str2, " \"fontcolor=\"#666666\"  ]\n");
    }

    private String formatTrailer() {
        return "}";
    }

    private String getNodeId(PatriciaTrie.PatriciaNode<V> patriciaNode) {
        return patriciaNode == null ? "null" : patriciaNode.getKey();
    }

    private String getNodeLabel(PatriciaTrie.PatriciaNode<V> patriciaNode) {
        return patriciaNode.getKey();
    }

    public String format(PatriciaTrie<V> patriciaTrie, boolean z) {
        return formatHeader() + formatNode(patriciaTrie.getRoot().getLeft(), -1, patriciaTrie.getKeyMapper(), z) + formatTrailer();
    }

    public String format(PatriciaTrie<V> patriciaTrie) {
        return format((PatriciaTrie) patriciaTrie, true);
    }

    public void format(PatriciaTrie<V> patriciaTrie, File file) {
        format(patriciaTrie, file, false);
    }

    public void format(PatriciaTrie<V> patriciaTrie, File file, boolean z) {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(file));
        printWriter.println(format(patriciaTrie, z));
        printWriter.close();
    }
}
