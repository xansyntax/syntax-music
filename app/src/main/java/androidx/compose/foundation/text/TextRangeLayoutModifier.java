package androidx.compose.foundation.text;

import androidx.compose.ui.layout.ParentDataModifier;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextRangeLayoutModifier implements ParentDataModifier {
    public final TextLinkScope$$ExternalSyntheticLambda10 measurePolicy;

    public TextRangeLayoutModifier(TextLinkScope$$ExternalSyntheticLambda10 textLinkScope$$ExternalSyntheticLambda10) {
        this.measurePolicy = textLinkScope$$ExternalSyntheticLambda10;
    }

    @Override // androidx.compose.ui.layout.ParentDataModifier
    public final Object modifyParentData() {
        return this;
    }
}
