package androidx.compose.foundation.text.contextmenu.internal;

import android.graphics.drawable.Drawable;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.graphics.Color;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextContextMenuHelperApi28$textClassificationItem$2$1 implements Function3 {
    public final /* synthetic */ Object $icon;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ TextContextMenuHelperApi28$textClassificationItem$2$1(byte b, Object obj) {
        this.$r8$classId = b;
        this.$icon = obj;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) throws XmlPullParserException, IOException {
        byte b = this.$r8$classId;
        TextContextMenuHelperApi28 textContextMenuHelperApi28 = TextContextMenuHelperApi28.INSTANCE;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.$icon;
        switch (b) {
            case 0:
                long j = ((Color) obj).value;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Number) obj3).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    textContextMenuHelperApi28.IconBox((Drawable) obj4, gapComposer, 48);
                }
                break;
            case 1:
                long j2 = ((Color) obj).value;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Number) obj3).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    textContextMenuHelperApi28.IconBox((Drawable) obj4, gapComposer2, 48);
                }
                break;
            default:
                long j3 = ((Color) obj).value;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Number) obj3).intValue();
                if ((iIntValue3 & 6) == 0) {
                    iIntValue3 |= ((GapComposer) composer3).changed(j3) ? 4 : 2;
                }
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    DefaultTextContextMenuDropdownProvider_androidKt.m209IconBoxRPmYEkk(((TextContextMenuItem) obj4).leadingIcon, j3, gapComposer3, (iIntValue3 << 3) & 112);
                }
                break;
        }
        return unit;
    }
}
