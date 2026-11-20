package com.atilika.kuromoji.viterbi;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ViterbiLattice {
    private static final String BOS = "BOS";
    private static final String EOS = "EOS";
    private final int dimension;
    private final ViterbiNode[][] endIndexArr;
    private final int[] endSizeArr;
    private final ViterbiNode[][] startIndexArr;
    private final int[] startSizeArr;

    public ViterbiLattice(int i) {
        this.dimension = i;
        this.startIndexArr = new ViterbiNode[i][];
        this.endIndexArr = new ViterbiNode[i][];
        this.startSizeArr = new int[i];
        this.endSizeArr = new int[i];
    }

    private void addNodeToArray(ViterbiNode viterbiNode, int i, ViterbiNode[][] viterbiNodeArr, int[] iArr) {
        int i2 = iArr[i];
        expandIfNeeded(i, viterbiNodeArr, i2);
        viterbiNodeArr[i][i2] = viterbiNode;
        iArr[i] = i2 + 1;
    }

    private void expandIfNeeded(int i, ViterbiNode[][] viterbiNodeArr, int i2) {
        if (i2 == 0) {
            viterbiNodeArr[i] = new ViterbiNode[10];
        }
        ViterbiNode[] viterbiNodeArr2 = viterbiNodeArr[i];
        if (viterbiNodeArr2.length <= i2) {
            viterbiNodeArr[i] = extendArray(viterbiNodeArr2);
        }
    }

    private ViterbiNode[] extendArray(ViterbiNode[] viterbiNodeArr) {
        ViterbiNode[] viterbiNodeArr2 = new ViterbiNode[viterbiNodeArr.length * 2];
        System.arraycopy(viterbiNodeArr, 0, viterbiNodeArr2, 0, viterbiNodeArr.length);
        return viterbiNodeArr2;
    }

    public void addBos() {
        addNode(new ViterbiNode(-1, BOS, 0, 0, 0, -1, ViterbiNode.Type.KNOWN), 0, 1);
    }

    public void addEos() {
        addNode(new ViterbiNode(-1, EOS, 0, 0, 0, this.dimension - 1, ViterbiNode.Type.KNOWN), this.dimension - 1, 0);
    }

    public void addNode(ViterbiNode viterbiNode, int i, int i2) {
        addNodeToArray(viterbiNode, i, getStartIndexArr(), getStartSizeArr());
        addNodeToArray(viterbiNode, i2, getEndIndexArr(), getEndSizeArr());
    }

    public ViterbiNode[][] getEndIndexArr() {
        return this.endIndexArr;
    }

    public int[] getEndSizeArr() {
        return this.endSizeArr;
    }

    public ViterbiNode[][] getStartIndexArr() {
        return this.startIndexArr;
    }

    public int[] getStartSizeArr() {
        return this.startSizeArr;
    }

    public boolean tokenEndsWhereCurrentTokenStarts(int i) {
        return getEndSizeArr()[i + 1] != 0;
    }
}
