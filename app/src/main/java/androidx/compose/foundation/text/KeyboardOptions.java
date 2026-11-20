package androidx.compose.foundation.text;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class KeyboardOptions {
    public static final KeyboardOptions Default = new KeyboardOptions(0, 0, 127);
    public final int imeAction;
    public final int keyboardType;

    public KeyboardOptions(int i, int i2, int i3) {
        i = (i3 & 4) != 0 ? 0 : i;
        i2 = (i3 & 8) != 0 ? -1 : i2;
        this.keyboardType = i;
        this.imeAction = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyboardOptions)) {
            return false;
        }
        KeyboardOptions keyboardOptions = (KeyboardOptions) obj;
        return this.keyboardType == keyboardOptions.keyboardType && this.imeAction == keyboardOptions.imeAction;
    }

    public final int hashCode() {
        return IntIntPair$$ExternalSyntheticOutline0.m(this.imeAction, IntIntPair$$ExternalSyntheticOutline0.m(this.keyboardType, Integer.hashCode(-1) * 961, 31), 29791);
    }

    public final ImeOptions toImeOptions$foundation(boolean z) {
        ImeAction imeAction;
        int i = this.keyboardType;
        KeyboardType keyboardType = new KeyboardType(i);
        if (i == 0) {
            keyboardType = null;
            imeAction = null;
        } else {
            imeAction = null;
        }
        int i2 = keyboardType != null ? keyboardType.value : 1;
        int i3 = this.imeAction;
        ImeAction imeAction2 = new ImeAction(i3);
        if (i3 == -1) {
            imeAction2 = imeAction;
        }
        return new ImeOptions(z, 0, true, i2, imeAction2 != null ? imeAction2.value : 1, LocaleList.Empty);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("KeyboardOptions(capitalization=Unspecified, autoCorrectEnabled=null, keyboardType=", KeyboardType.m761toStringimpl(this.keyboardType), ", imeAction=", ImeAction.m760toStringimpl(this.imeAction), ", platformImeOptions=nullshowKeyboardOnFocus=null, hintLocales=null)");
    }
}
