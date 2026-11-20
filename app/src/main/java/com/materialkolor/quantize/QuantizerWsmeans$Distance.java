package com.materialkolor.quantize;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QuantizerWsmeans$Distance implements Comparable {
    public int index = -1;
    public double distance = -1.0d;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        QuantizerWsmeans$Distance quantizerWsmeans$Distance = (QuantizerWsmeans$Distance) obj;
        quantizerWsmeans$Distance.getClass();
        return Double.compare(this.distance, quantizerWsmeans$Distance.distance);
    }
}
