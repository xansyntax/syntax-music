package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.text.AndroidParagraph;
import androidx.compose.ui.text.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import java.io.IOException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextFieldDelegateKt {
    public static final String EmptyTextReplacement = StringsKt__StringsJVMKt.repeat(10, "H");

    public static long computeSizeForDefaultText$default(TextStyle textStyle, Density density, FontFamily.Resolver resolver) throws IOException {
        AndroidParagraph androidParagraphParagraphForDefaultText = paragraphForDefaultText(textStyle, density, resolver, 1, false);
        return (((long) BasicTextKt.ceilToIntPx(androidParagraphParagraphForDefaultText.paragraphIntrinsics.getMinIntrinsicWidth())) << 32) | (((long) BasicTextKt.ceilToIntPx(androidParagraphParagraphForDefaultText.resolvedLineHeight)) & 4294967295L);
    }

    public static final AndroidParagraph paragraphForDefaultText(TextStyle textStyle, Density density, FontFamily.Resolver resolver, int i, boolean z) throws IOException {
        String strJoinToString$default = CollectionsKt.joinToString$default(UuidKt.until(0, i), "\n", null, null, new OffsetKt$$ExternalSyntheticLambda0((byte) 29), 30);
        EmptyList emptyList = EmptyList.INSTANCE;
        return new AndroidParagraph(new AndroidParagraphIntrinsics(strJoinToString$default, textStyle, emptyList, emptyList, resolver, density, z), i, 1, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15));
    }
}
