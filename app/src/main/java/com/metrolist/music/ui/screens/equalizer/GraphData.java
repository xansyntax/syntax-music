package com.metrolist.music.ui.screens.equalizer;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GraphData {
    public final double dbBottom;
    public final double dbRange;
    public final double dbTop;
    public final ArrayList points;

    public GraphData(ArrayList arrayList, double d, double d2, double d3) {
        this.points = arrayList;
        this.dbTop = d;
        this.dbBottom = d2;
        this.dbRange = d3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GraphData)) {
            return false;
        }
        GraphData graphData = (GraphData) obj;
        return this.points.equals(graphData.points) && Double.compare(this.dbTop, graphData.dbTop) == 0 && Double.compare(this.dbBottom, graphData.dbBottom) == 0 && Double.compare(this.dbRange, graphData.dbRange) == 0 && Double.compare(2.5d, 2.5d) == 0;
    }

    public final int hashCode() {
        return Double.hashCode(2.5d) + Fragment$5$$ExternalSyntheticOutline0.m(this.dbRange, Fragment$5$$ExternalSyntheticOutline0.m(this.dbBottom, Fragment$5$$ExternalSyntheticOutline0.m(this.dbTop, this.points.hashCode() * 31, 31), 31), 31);
    }

    public final String toString() {
        return "GraphData(points=" + this.points + ", dbTop=" + this.dbTop + ", dbBottom=" + this.dbBottom + ", dbRange=" + this.dbRange + ", dbStep=2.5)";
    }
}
