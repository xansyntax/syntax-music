package com.atilika.kuromoji.viterbi;

import com.atilika.kuromoji.TokenizerBase;
import com.atilika.kuromoji.dict.ConnectionCosts;
import com.atilika.kuromoji.dict.UnknownDictionary;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ViterbiSearcher {
    private static final int DEFAULT_COST = Integer.MAX_VALUE;
    private final ConnectionCosts costs;
    private int kanjiPenalty;
    private int kanjiPenaltyLengthTreshold;
    private final TokenizerBase.Mode mode;
    private int otherPenalty;
    private int otherPenaltyLengthThreshold;
    private final UnknownDictionary unknownDictionary;

    public ViterbiSearcher(TokenizerBase.Mode mode, ConnectionCosts connectionCosts, UnknownDictionary unknownDictionary, List<Integer> list) {
        if (!list.isEmpty()) {
            this.kanjiPenaltyLengthTreshold = list.get(0).intValue();
            this.kanjiPenalty = list.get(1).intValue();
            this.otherPenaltyLengthThreshold = list.get(2).intValue();
            this.otherPenalty = list.get(3).intValue();
        }
        this.mode = mode;
        this.costs = connectionCosts;
        this.unknownDictionary = unknownDictionary;
    }

    private LinkedList<ViterbiNode> backtrackBestPath(ViterbiNode viterbiNode) {
        LinkedList<ViterbiNode> linkedList = new LinkedList<>();
        linkedList.add(viterbiNode);
        while (true) {
            viterbiNode = viterbiNode.getLeftNode();
            if (viterbiNode == null) {
                return linkedList;
            }
            if (this.mode == TokenizerBase.Mode.EXTENDED && viterbiNode.getType() == ViterbiNode.Type.UNKNOWN) {
                linkedList.addAll(convertUnknownWordToUnigramNode(viterbiNode));
            } else {
                linkedList.addFirst(viterbiNode);
            }
        }
    }

    private ViterbiNode[][] calculatePathCosts(ViterbiLattice viterbiLattice) {
        ViterbiNode[][] startIndexArr = viterbiLattice.getStartIndexArr();
        ViterbiNode[][] endIndexArr = viterbiLattice.getEndIndexArr();
        for (int i = 1; i < startIndexArr.length; i++) {
            ViterbiNode[] viterbiNodeArr = startIndexArr[i];
            if (viterbiNodeArr != null && endIndexArr[i] != null) {
                for (ViterbiNode viterbiNode : viterbiNodeArr) {
                    if (viterbiNode == null) {
                        break;
                    }
                    updateNode(endIndexArr[i], viterbiNode);
                }
            }
        }
        return endIndexArr;
    }

    private LinkedList<ViterbiNode> convertUnknownWordToUnigramNode(ViterbiNode viterbiNode) {
        LinkedList<ViterbiNode> linkedList = new LinkedList<>();
        String surface = viterbiNode.getSurface();
        for (int length = surface.length(); length > 0; length--) {
            linkedList.addFirst(new ViterbiNode(0, surface.substring(length - 1, length), this.unknownDictionary, (viterbiNode.getStartIndex() + length) - 1, ViterbiNode.Type.UNKNOWN));
        }
        return linkedList;
    }

    private int getPenaltyCost(ViterbiNode viterbiNode) {
        int i;
        int i2;
        String surface = viterbiNode.getSurface();
        int length = surface.length();
        if (length <= this.kanjiPenaltyLengthTreshold) {
            return 0;
        }
        if (isKanjiOnly(surface)) {
            i = length - this.kanjiPenaltyLengthTreshold;
            i2 = this.kanjiPenalty;
        } else {
            int i3 = this.otherPenaltyLengthThreshold;
            if (length <= i3) {
                return 0;
            }
            i = length - i3;
            i2 = this.otherPenalty;
        }
        return i * i2;
    }

    private boolean isKanjiOnly(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.UnicodeBlock.of(str.charAt(i)) != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) {
                return false;
            }
        }
        return true;
    }

    private void updateNode(ViterbiNode[] viterbiNodeArr, ViterbiNode viterbiNode) {
        int leftId = viterbiNode.getLeftId();
        int wordCost = viterbiNode.getWordCost();
        int i = DEFAULT_COST;
        for (ViterbiNode viterbiNode2 : viterbiNodeArr) {
            if (viterbiNode2 == null) {
                return;
            }
            int pathCost = this.costs.get(viterbiNode2.getRightId(), leftId) + viterbiNode2.getPathCost() + wordCost;
            TokenizerBase.Mode mode = this.mode;
            if (mode == TokenizerBase.Mode.SEARCH || mode == TokenizerBase.Mode.EXTENDED) {
                pathCost += getPenaltyCost(viterbiNode);
            }
            if (pathCost < i) {
                viterbiNode.setPathCost(pathCost);
                viterbiNode.setLeftNode(viterbiNode2);
                i = pathCost;
            }
        }
    }

    public List<ViterbiNode> search(ViterbiLattice viterbiLattice) {
        return backtrackBestPath(calculatePathCosts(viterbiLattice)[0][0]);
    }
}
