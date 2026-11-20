package sh.calvin.reorderable;

import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Scroller$ScrollInfo$Companion$Null$1 extends Lambda implements Function0 {
    public static final Scroller$ScrollInfo$Companion$Null$1 INSTANCE;
    public static final Scroller$ScrollInfo$Companion$Null$1 INSTANCE$1;
    public static final Scroller$ScrollInfo$Companion$Null$1 INSTANCE$2;
    public final /* synthetic */ byte $r8$classId;

    static {
        int i = 0;
        INSTANCE$1 = new Scroller$ScrollInfo$Companion$Null$1((byte) 1, i);
        INSTANCE$2 = new Scroller$ScrollInfo$Companion$Null$1((byte) 2, i);
        INSTANCE = new Scroller$ScrollInfo$Companion$Null$1((byte) 0, i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Scroller$ScrollInfo$Companion$Null$1(byte b, int i) {
        super(i);
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO);
            case 1:
            default:
                return unit;
        }
    }
}
