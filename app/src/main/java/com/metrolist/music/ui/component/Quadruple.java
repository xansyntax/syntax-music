package com.metrolist.music.ui.component;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.graphics.Color;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Quadruple {
    public final Integer first;
    public final BiasAlignment fourth;
    public final Color second;
    public final Color third;

    public Quadruple(Integer num, Color color, Color color2, BiasAlignment biasAlignment) {
        this.first = num;
        this.second = color;
        this.third = color2;
        this.fourth = biasAlignment;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Quadruple)) {
            return false;
        }
        Quadruple quadruple = (Quadruple) obj;
        return this.first.equals(quadruple.first) && this.second.equals(quadruple.second) && this.third.equals(quadruple.third) && this.fourth.equals(quadruple.fourth);
    }

    public final int hashCode() {
        return this.fourth.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.first.hashCode() * 31, 31, this.second.value), 31, this.third.value);
    }

    public final String toString() {
        return "Quadruple(first=" + this.first + ", second=" + this.second + ", third=" + this.third + ", fourth=" + this.fourth + ")";
    }
}
