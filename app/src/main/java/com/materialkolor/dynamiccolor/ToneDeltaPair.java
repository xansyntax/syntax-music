package com.materialkolor.dynamiccolor;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ToneDeltaPair {
    public final double delta;
    public final DeltaConstraint deltaConstraint;
    public final TonePolarity polarity;
    public final DynamicColor roleA;
    public final DynamicColor roleB;
    public final boolean stayTogether;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DeltaConstraint {
        public static final /* synthetic */ DeltaConstraint[] $VALUES;
        public static final DeltaConstraint EXACT;
        public static final DeltaConstraint FARTHER;

        static {
            DeltaConstraint deltaConstraint = new DeltaConstraint("EXACT", 0);
            EXACT = deltaConstraint;
            DeltaConstraint deltaConstraint2 = new DeltaConstraint("NEARER", 1);
            DeltaConstraint deltaConstraint3 = new DeltaConstraint("FARTHER", 2);
            FARTHER = deltaConstraint3;
            $VALUES = new DeltaConstraint[]{deltaConstraint, deltaConstraint2, deltaConstraint3};
        }

        public static DeltaConstraint valueOf(String str) {
            return (DeltaConstraint) Enum.valueOf(DeltaConstraint.class, str);
        }

        public static DeltaConstraint[] values() {
            return (DeltaConstraint[]) $VALUES.clone();
        }
    }

    public ToneDeltaPair(DynamicColor dynamicColor, DynamicColor dynamicColor2, double d, TonePolarity tonePolarity, boolean z, DeltaConstraint deltaConstraint, int i) {
        z = (i & 16) != 0 ? true : z;
        deltaConstraint = (i & 32) != 0 ? DeltaConstraint.EXACT : deltaConstraint;
        dynamicColor.getClass();
        dynamicColor2.getClass();
        this.roleA = dynamicColor;
        this.roleB = dynamicColor2;
        this.delta = d;
        this.polarity = tonePolarity;
        this.stayTogether = z;
        this.deltaConstraint = deltaConstraint;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ToneDeltaPair)) {
            return false;
        }
        ToneDeltaPair toneDeltaPair = (ToneDeltaPair) obj;
        return Intrinsics.areEqual(this.roleA, toneDeltaPair.roleA) && Intrinsics.areEqual(this.roleB, toneDeltaPair.roleB) && Double.compare(this.delta, toneDeltaPair.delta) == 0 && this.polarity == toneDeltaPair.polarity && this.stayTogether == toneDeltaPair.stayTogether && this.deltaConstraint == toneDeltaPair.deltaConstraint;
    }

    public final int hashCode() {
        return this.deltaConstraint.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m((this.polarity.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.delta, (this.roleB.hashCode() + (this.roleA.hashCode() * 31)) * 31, 31)) * 31, this.stayTogether, 31);
    }

    public final String toString() {
        return "ToneDeltaPair(roleA=" + this.roleA + ", roleB=" + this.roleB + ", delta=" + this.delta + ", polarity=" + this.polarity + ", stayTogether=" + this.stayTogether + ", deltaConstraint=" + this.deltaConstraint + ")";
    }
}
