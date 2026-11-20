package androidx.compose.ui.layout;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FixedSizeIntrinsicsPlaceable extends Placeable {
    public final /* synthetic */ byte $r8$classId;

    public FixedSizeIntrinsicsPlaceable(int i, int i2, byte b) {
        this.$r8$classId = b;
        switch (b) {
            case 1:
                m617setMeasuredSizeozmzZPI((((long) i2) & 4294967295L) | (((long) i) << 32));
                break;
            case 2:
                m617setMeasuredSizeozmzZPI((((long) i2) & 4294967295L) | (((long) i) << 32));
                break;
            default:
                m617setMeasuredSizeozmzZPI((((long) i2) & 4294967295L) | (((long) i) << 32));
                break;
        }
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final int get(AlignmentLine alignmentLine) {
        switch (this.$r8$classId) {
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno, reason: not valid java name */
    public final void mo602placeAtf8xVGno(long j, float f, Function1 function1) {
        byte b = this.$r8$classId;
    }

    /* JADX INFO: renamed from: placeAt-f8xVGno$androidx$compose$ui$layout$FixedSizeIntrinsicsPlaceable, reason: not valid java name */
    private final void m599xf00bb1d6(long j, float f, Function1 function1) {
    }

    /* JADX INFO: renamed from: placeAt-f8xVGno$androidx$compose$ui$layout$MeasuringIntrinsics$EmptyPlaceable, reason: not valid java name */
    private final void m600xa65dbe67(long j, float f, Function1 function1) {
    }

    /* JADX INFO: renamed from: placeAt-f8xVGno$androidx$compose$ui$node$NodeMeasuringIntrinsics$EmptyPlaceable, reason: not valid java name */
    private final void m601x3c56d5b1(long j, float f, Function1 function1) {
    }
}
