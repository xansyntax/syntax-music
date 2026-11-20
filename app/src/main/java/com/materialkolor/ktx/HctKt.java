package com.materialkolor.ktx;

import androidx.compose.ui.graphics.Color;
import com.materialkolor.hct.Hct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0015\u0010\u0007\u001a\u00020\u0004*\u00020\u0001H\u0007b\u0002\b\t¢\u0006\u0002\u0010\b\u001a\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b*\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007b\u0002\b\t\u001a\u0011\u0010\f\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\r\u0010\u000e\u001a\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b*\b\u0012\u0004\u0012\u00020\u00040\u000b¨\u0006\u0010"}, d2 = {"from", "Lcom/materialkolor/hct/Hct;", "Lcom/materialkolor/hct/Hct$Companion;", "color", "Landroidx/compose/ui/graphics/Color;", "from-4WTKRHQ", "(Lcom/materialkolor/hct/Hct$Companion;J)Lcom/materialkolor/hct/Hct;", "toColor", "(Lcom/materialkolor/hct/Hct;)J", "Landroidx/compose/runtime/Stable;", "toColors", "", "toHct", "toHct-8_81llA", "(J)Lcom/materialkolor/hct/Hct;", "toHcts", "MaterialKolor:material-kolor"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class HctKt {
    /* JADX INFO: renamed from: from-4WTKRHQ, reason: not valid java name */
    public static final Hct m972from4WTKRHQ(Hct.Companion companion, long j) {
        companion.getClass();
        return new Hct(androidx.compose.ui.graphics.ColorKt.m498toArgb8_81llA(j));
    }

    public static final long toColor(Hct hct) {
        hct.getClass();
        return ((long) hct.argb) << 32;
    }

    public static final List<Color> toColors(List<Hct> list) {
        list.getClass();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Color(toColor((Hct) it.next())));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: toHct-8_81llA, reason: not valid java name */
    public static final Hct m973toHct8_81llA(long j) {
        return m972from4WTKRHQ(Hct.Companion, j);
    }

    public static final List<Hct> toHcts(List<Color> list) {
        list.getClass();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(m973toHct8_81llA(((Color) it.next()).value));
        }
        return arrayList;
    }
}
