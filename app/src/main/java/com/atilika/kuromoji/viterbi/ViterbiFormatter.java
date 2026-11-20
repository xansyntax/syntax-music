package com.atilika.kuromoji.viterbi;

import com.atilika.kuromoji.dict.ConnectionCosts;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ViterbiFormatter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String BOS_LABEL = "BOS";
    private static final String EOS_LABEL = "EOS";
    private static final String FONT_NAME = "Helvetica";
    private ConnectionCosts costs;
    private boolean foundBOS;
    private Map<String, ViterbiNode> nodeMap = new HashMap();
    private Map<String, String> bestPathMap = new HashMap();

    public ViterbiFormatter(ConnectionCosts connectionCosts) {
        this.costs = connectionCosts;
    }

    private String formatEdge(ViterbiNode viterbiNode, ViterbiNode viterbiNode2, String str) {
        return getNodeId(viterbiNode) + " -> " + getNodeId(viterbiNode2) + " [ label=\"" + getCost(viterbiNode, viterbiNode2) + "\" " + str + "  ]\n";
    }

    private String formatHeader() {
        return "digraph viterbi {\ngraph [ fontsize=30 labelloc=\"t\" label=\"\" splines=true overlap=false rankdir = \"LR\" ];\n# A2 paper size\nsize = \"34.4,16.5\";\n# try to fill paper\nratio = fill;\nedge [ fontname=\"Helvetica\" fontcolor=\"red\" color=\"#606060\" ]\nnode [ style=\"filled\" fillcolor=\"#e8e8f0\" shape=\"Mrecord\" fontname=\"Helvetica\" ]\n";
    }

    private String formatNode(ViterbiNode viterbiNode) {
        StringBuilder sb = new StringBuilder("\"");
        sb.append(getNodeId(viterbiNode));
        sb.append("\" [ label=");
        sb.append(formatNodeLabel(viterbiNode));
        if (viterbiNode.getType() == ViterbiNode.Type.USER) {
            sb.append(" fillcolor=\"#e8f8e8\"");
        } else if (viterbiNode.getType() == ViterbiNode.Type.UNKNOWN) {
            sb.append(" fillcolor=\"#f8e8f8\"");
        } else if (viterbiNode.getType() == ViterbiNode.Type.INSERTED) {
            sb.append(" fillcolor=\"#ffe8e8\"");
        }
        sb.append(" ]");
        return sb.toString();
    }

    private String formatNodeIfNew(ViterbiNode viterbiNode) {
        String nodeId = getNodeId(viterbiNode);
        if (this.nodeMap.containsKey(nodeId)) {
            return "";
        }
        this.nodeMap.put(nodeId, viterbiNode);
        return formatNode(viterbiNode);
    }

    private String formatNodeLabel(ViterbiNode viterbiNode) {
        return "<<table border=\"0\" cellborder=\"0\"><tr><td>" + getNodeLabel(viterbiNode) + "</td></tr><tr><td><font color=\"blue\">" + viterbiNode.getWordCost() + "</font></td></tr></table>>";
    }

    private String formatNodes(ViterbiLattice viterbiLattice) {
        ViterbiNode viterbiNode;
        ViterbiNode[][] startIndexArr = viterbiLattice.getStartIndexArr();
        ViterbiNode[][] endIndexArr = viterbiLattice.getEndIndexArr();
        this.nodeMap.clear();
        this.foundBOS = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < endIndexArr.length; i++) {
            if (endIndexArr[i] != null && startIndexArr[i] != null) {
                int i2 = 0;
                while (true) {
                    ViterbiNode[] viterbiNodeArr = endIndexArr[i];
                    if (i2 < viterbiNodeArr.length) {
                        ViterbiNode viterbiNode2 = viterbiNodeArr[i2];
                        if (viterbiNode2 != null) {
                            sb.append(formatNodeIfNew(viterbiNode2));
                            int i3 = 0;
                            while (true) {
                                ViterbiNode[] viterbiNodeArr2 = startIndexArr[i];
                                if (i3 >= viterbiNodeArr2.length || (viterbiNode = viterbiNodeArr2[i3]) == null) {
                                    break;
                                }
                                sb.append(formatNodeIfNew(viterbiNode));
                                sb.append(formatEdge(viterbiNode2, viterbiNode));
                                i3++;
                            }
                        }
                        i2++;
                    }
                }
            }
        }
        return sb.toString();
    }

    private String formatTrailer() {
        return "}";
    }

    private int getCost(ViterbiNode viterbiNode, ViterbiNode viterbiNode2) {
        return this.costs.get(viterbiNode.getLeftId(), viterbiNode2.getRightId());
    }

    private String getNodeId(ViterbiNode viterbiNode) {
        return String.valueOf(viterbiNode.hashCode());
    }

    private String getNodeLabel(ViterbiNode viterbiNode) {
        if (viterbiNode.getType() != ViterbiNode.Type.KNOWN || viterbiNode.getWordId() != 0) {
            return viterbiNode.getSurface();
        }
        if (this.foundBOS) {
            return EOS_LABEL;
        }
        this.foundBOS = true;
        return BOS_LABEL;
    }

    private void initBestPathMap(List<ViterbiNode> list) {
        this.bestPathMap.clear();
        if (list == null) {
            return;
        }
        int i = 0;
        while (i < list.size() - 1) {
            ViterbiNode viterbiNode = list.get(i);
            i++;
            this.bestPathMap.put(getNodeId(viterbiNode), getNodeId(list.get(i)));
        }
    }

    public String format(ViterbiLattice viterbiLattice, List<ViterbiNode> list) {
        initBestPathMap(list);
        return formatHeader() + formatNodes(viterbiLattice) + formatTrailer();
    }

    public String format(ViterbiLattice viterbiLattice) {
        return format(viterbiLattice, null);
    }

    private String formatEdge(ViterbiNode viterbiNode, ViterbiNode viterbiNode2) {
        if (this.bestPathMap.containsKey(getNodeId(viterbiNode)) && this.bestPathMap.get(getNodeId(viterbiNode)).equals(getNodeId(viterbiNode2))) {
            return formatEdge(viterbiNode, viterbiNode2, "color=\"#40e050\" fontcolor=\"#40a050\" penwidth=3 fontsize=20 ");
        }
        return formatEdge(viterbiNode, viterbiNode2, "");
    }
}
