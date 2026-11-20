package androidx.compose.ui.text.input;

import androidx.compose.ui.graphics.Matrix;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CursorAnchorInfoController$invalidate$1$1 implements Function1 {
    public static final CursorAnchorInfoController$invalidate$1$1 INSTANCE = new CursorAnchorInfoController$invalidate$1$1(0);
    public static final CursorAnchorInfoController$invalidate$1$1 INSTANCE$1 = new CursorAnchorInfoController$invalidate$1$1(1);
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ CursorAnchorInfoController$invalidate$1$1(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                float[] fArr = ((Matrix) obj).values;
                break;
            default:
                float[] fArr2 = ((Matrix) obj).values;
                break;
        }
        return unit;
    }
}
