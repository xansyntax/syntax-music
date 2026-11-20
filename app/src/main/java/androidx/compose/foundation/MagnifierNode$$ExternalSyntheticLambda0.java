package androidx.compose.foundation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MagnifierNode$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MagnifierNode f$0;

    public /* synthetic */ MagnifierNode$$ExternalSyntheticLambda0(MagnifierNode magnifierNode, byte b) {
        this.$r8$classId = b;
        this.f$0 = magnifierNode;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        MagnifierNode magnifierNode = this.f$0;
        switch (b) {
            case 0:
                magnifierNode.updateMagnifier();
                return Unit.INSTANCE;
            case 1:
                return new Offset(magnifierNode.sourceCenterInRoot);
            default:
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) magnifierNode.layoutCoordinates$delegate.getValue();
                return new Offset(layoutCoordinates != null ? layoutCoordinates.mo606localToRootMKHz9U(0L) : 9205357640488583168L);
        }
    }
}
