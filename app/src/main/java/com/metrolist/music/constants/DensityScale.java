package com.metrolist.music.constants;

import kotlin.enums.EnumEntriesList;
import okio.Path;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.metrolist.music.constants.DensityScale[], still in use, count: 1, list:
  (r0v1 com.metrolist.music.constants.DensityScale[]) from 0x0062: CONSTRUCTOR (r0v1 com.metrolist.music.constants.DensityScale[]) A[MD:(java.lang.Enum[]):void (m), WRAPPED] (LINE:99) call: kotlin.enums.EnumEntriesList.<init>(java.lang.Enum[]):void type: CONSTRUCTOR
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DensityScale {
    /* JADX INFO: Fake field, exist only in values array */
    LARGE(1.25f, "Large (125%)"),
    /* JADX INFO: Fake field, exist only in values array */
    SLIGHTLY_LARGE(1.15f, "Slightly Large (115%)"),
    NATIVE(1.0f, "Native (100%)"),
    /* JADX INFO: Fake field, exist only in values array */
    SLIGHTLY_COMPACT(0.85f, "Slightly Compact (85%)"),
    /* JADX INFO: Fake field, exist only in values array */
    COMPACT(0.75f, "Compact (75%)"),
    /* JADX INFO: Fake field, exist only in values array */
    VERY_COMPACT(0.65f, "Very Compact (65%)"),
    /* JADX INFO: Fake field, exist only in values array */
    ULTRA_COMPACT(0.55f, "Ultra Compact (55%)");

    public static final /* synthetic */ EnumEntriesList $ENTRIES;
    public static final Path.Companion Companion = new Path.Companion((byte) 5);
    public final String label;
    public final float value;

    static {
        $ENTRIES = new EnumEntriesList(new DensityScale[]{r0, r1, r2, new DensityScale(0.85f, "Slightly Compact (85%)"), new DensityScale(0.75f, "Compact (75%)"), new DensityScale(0.65f, "Very Compact (65%)"), new DensityScale(0.55f, "Ultra Compact (55%)")});
    }

    public DensityScale(float f, String str) {
        super(str, i);
        this.value = f;
        this.label = str;
    }

    public static DensityScale valueOf(String str) {
        return (DensityScale) Enum.valueOf(DensityScale.class, str);
    }

    public static DensityScale[] values() {
        return (DensityScale[]) $VALUES.clone();
    }
}
