package com.materialkolor.temperature;

import androidx.compose.ui.semantics.SemanticsSortKt$special$$inlined$thenBy$1;
import com.materialkolor.hct.Hct;
import com.materialkolor.hct.HctSolver;
import com.materialkolor.utils.MathUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TemperatureCache {
    public static final Companion Companion = new Companion();
    public final Hct input;
    public Hct precomputedComplement;
    public ArrayList precomputedHctsByHue;
    public ArrayList precomputedHctsByTemp;
    public HashMap precomputedTempsByHct;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion {
        public static double rawTemperature(Hct hct) {
            hct.getClass();
            double[] dArrLabFromArgb = MathUtils.labFromArgb(hct.argb);
            double dAtan2 = (Math.atan2(dArrLabFromArgb[2], dArrLabFromArgb[1]) * 57.29577951308232d) % 360.0d;
            if (dAtan2 < 0.0d) {
                dAtan2 += 360.0d;
            }
            double dPow = Math.pow(Math.hypot(dArrLabFromArgb[1], dArrLabFromArgb[2]), 1.07d) * 0.02d;
            double d = (dAtan2 - 50.0d) % 360.0d;
            if (d < 0.0d) {
                d += 360.0d;
            }
            return (Math.cos(d * 0.017453292519943295d) * dPow) - 0.5d;
        }
    }

    public TemperatureCache(Hct hct) {
        hct.getClass();
        this.input = hct;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TemperatureCache) && Intrinsics.areEqual(this.input, ((TemperatureCache) obj).input);
    }

    public final Hct getColdest() {
        return (Hct) getHctsByTemp().get(0);
    }

    public final List getHctsByHue() {
        ArrayList arrayList = this.precomputedHctsByHue;
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (double d = 0.0d; d <= 360.0d; d += 1.0d) {
            Hct hct = this.input;
            arrayList2.add(new Hct(HctSolver.solveToInt(d, hct.chroma, hct.tone)));
        }
        ArrayList arrayListFlatten = CollectionsKt__IterablesKt.flatten(CollectionsKt__IterablesKt.listOf(arrayList2));
        this.precomputedHctsByHue = arrayListFlatten;
        return arrayListFlatten;
    }

    public final List getHctsByTemp() {
        ArrayList arrayList = this.precomputedHctsByTemp;
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(getHctsByHue());
        arrayList2.add(this.input);
        CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList2, new SemanticsSortKt$special$$inlined$thenBy$1((byte) 2, this));
        this.precomputedHctsByTemp = arrayList2;
        return arrayList2;
    }

    public final double getRelativeTemperature(Hct hct) {
        hct.getClass();
        Object obj = ((HashMap) getTempsByHct()).get(getWarmest());
        obj.getClass();
        double dDoubleValue = ((Number) obj).doubleValue();
        Object obj2 = ((HashMap) getTempsByHct()).get(getColdest());
        obj2.getClass();
        double dDoubleValue2 = dDoubleValue - ((Number) obj2).doubleValue();
        Object obj3 = ((HashMap) getTempsByHct()).get(hct);
        obj3.getClass();
        double dDoubleValue3 = ((Number) obj3).doubleValue();
        Object obj4 = ((HashMap) getTempsByHct()).get(getColdest());
        obj4.getClass();
        double dDoubleValue4 = dDoubleValue3 - ((Number) obj4).doubleValue();
        if (dDoubleValue2 == 0.0d) {
            return 0.5d;
        }
        return dDoubleValue4 / dDoubleValue2;
    }

    public final Map getTempsByHct() {
        HashMap map = this.precomputedTempsByHct;
        if (map != null) {
            return map;
        }
        ArrayList arrayList = new ArrayList(getHctsByHue());
        arrayList.add(this.input);
        HashMap map2 = new HashMap();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Hct hct = (Hct) obj;
            map2.put(hct, Double.valueOf(Companion.rawTemperature(hct)));
        }
        this.precomputedTempsByHct = map2;
        return map2;
    }

    public final Hct getWarmest() {
        return (Hct) getHctsByTemp().get(getHctsByTemp().size() - 1);
    }

    public final int hashCode() {
        return this.input.argb;
    }

    public final String toString() {
        return "TemperatureCache(input=" + this.input + ")";
    }
}
