package androidx.compose.foundation.text;

import androidx.compose.ui.text.font.TypefaceResult;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HeightInLinesNode$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ HeightInLinesNode f$0;

    public /* synthetic */ HeightInLinesNode$$ExternalSyntheticLambda0(HeightInLinesNode heightInLinesNode, byte b) {
        this.$r8$classId = b;
        this.f$0 = heightInLinesNode;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        HeightInLinesNode heightInLinesNode = this.f$0;
        switch (b) {
            case 0:
                TypefaceResult typefaceResult = heightInLinesNode.fontResolutionState;
                if (typefaceResult == null) {
                    throw Fragment$5$$ExternalSyntheticOutline0.m("Font resolution state is not set.");
                }
                typefaceResult.getValue();
                return unit;
            default:
                TypefaceResult typefaceResult2 = heightInLinesNode.fontResolutionState;
                if (typefaceResult2 == null) {
                    throw Fragment$5$$ExternalSyntheticOutline0.m("Font resolution state is not set.");
                }
                typefaceResult2.getValue();
                return unit;
        }
    }
}
