package androidx.compose.foundation.text.selection;

import android.view.textclassifier.TextClassification;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.TextRange;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextClassificationResult {
    public final ArrayList icons;
    public final long selection;
    public final CharSequence text;
    public final TextClassification textClassification;

    public TextClassificationResult(CharSequence charSequence, long j, TextClassification textClassification, ArrayList arrayList) {
        this.text = charSequence;
        this.selection = j;
        this.textClassification = textClassification;
        this.icons = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextClassificationResult)) {
            return false;
        }
        TextClassificationResult textClassificationResult = (TextClassificationResult) obj;
        return Intrinsics.areEqual(this.text, textClassificationResult.text) && TextRange.m740equalsimpl0(this.selection, textClassificationResult.selection) && Intrinsics.areEqual(this.textClassification, textClassificationResult.textClassification) && this.icons.equals(textClassificationResult.icons);
    }

    public final int hashCode() {
        int iHashCode = this.text.hashCode() * 31;
        int i = TextRange.$r8$clinit;
        return this.icons.hashCode() + ((this.textClassification.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(iHashCode, 31, this.selection)) * 31);
    }

    public final String toString() {
        return "TextClassificationResult(text=" + ((Object) this.text) + ", selection=" + TextRange.m746toStringimpl(this.selection) + ", textClassification=" + this.textClassification + ", icons=" + this.icons + ")";
    }
}
