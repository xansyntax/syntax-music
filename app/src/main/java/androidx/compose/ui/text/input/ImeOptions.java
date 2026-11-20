package androidx.compose.ui.text.input;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.intl.LocaleList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ImeOptions {
    public static final ImeOptions Default = new ImeOptions(false, 0, true, 1, 1, LocaleList.Empty);
    public final boolean autoCorrect;
    public final int capitalization;
    public final LocaleList hintLocales;
    public final int imeAction;
    public final int keyboardType;
    public final boolean singleLine;

    public ImeOptions(boolean z, int i, boolean z2, int i2, int i3, LocaleList localeList) {
        this.singleLine = z;
        this.capitalization = i;
        this.autoCorrect = z2;
        this.keyboardType = i2;
        this.imeAction = i3;
        this.hintLocales = localeList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImeOptions)) {
            return false;
        }
        ImeOptions imeOptions = (ImeOptions) obj;
        return this.singleLine == imeOptions.singleLine && this.capitalization == imeOptions.capitalization && this.autoCorrect == imeOptions.autoCorrect && this.keyboardType == imeOptions.keyboardType && this.imeAction == imeOptions.imeAction && Intrinsics.areEqual(this.hintLocales, imeOptions.hintLocales);
    }

    public final int hashCode() {
        return this.hintLocales.localeList.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.imeAction, IntIntPair$$ExternalSyntheticOutline0.m(this.keyboardType, IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.capitalization, Boolean.hashCode(this.singleLine) * 31, 31), this.autoCorrect, 31), 31), 961);
    }

    public final String toString() {
        String str;
        int i = this.capitalization;
        if (i == -1) {
            str = "Unspecified";
        } else if (i == 0) {
            str = "None";
        } else if (i == 1) {
            str = "Characters";
        } else if (i == 2) {
            str = "Words";
        } else {
            str = i == 3 ? "Sentences" : "Invalid";
        }
        return "ImeOptions(singleLine=" + this.singleLine + ", capitalization=" + str + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + KeyboardType.m761toStringimpl(this.keyboardType) + ", imeAction=" + ImeAction.m760toStringimpl(this.imeAction) + ", platformImeOptions=null, hintLocales=" + this.hintLocales + ")";
    }
}
