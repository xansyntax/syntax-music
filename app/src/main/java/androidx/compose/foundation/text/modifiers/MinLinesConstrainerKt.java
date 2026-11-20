package androidx.compose.foundation.text.modifiers;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MinLinesConstrainerKt {
    public static final String EmptyTextReplacement;
    public static final String TwoLineTextReplacement;

    static {
        String strRepeat = StringsKt__StringsJVMKt.repeat(10, "H");
        EmptyTextReplacement = strRepeat;
        TwoLineTextReplacement = Fragment$5$$ExternalSyntheticOutline0.m(strRepeat, "\n", strRepeat);
    }
}
