package androidx.compose.ui.graphics.vector;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.emoji2.text.EmojiProcessor;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class VectorComponent$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ VectorComponent f$0;

    public /* synthetic */ VectorComponent$$ExternalSyntheticLambda0(VectorComponent vectorComponent, byte b) {
        this.$r8$classId = b;
        this.f$0 = vectorComponent;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        VectorComponent vectorComponent = this.f$0;
        switch (b) {
            case 0:
                vectorComponent.isDirty = true;
                vectorComponent.invalidateCallback.invoke();
                return unit;
            default:
                DrawScope drawScope = (DrawScope) obj;
                GroupComponent groupComponent = vectorComponent.root;
                float f = vectorComponent.rootScaleX;
                float f2 = vectorComponent.rootScaleY;
                EmojiProcessor drawContext = drawScope.getDrawContext();
                long jM831getSizeNHjbRc = drawContext.m831getSizeNHjbRc();
                drawContext.getCanvas().save();
                try {
                    ((DrawResult) drawContext.mSpanFactory).m403scale0AR0LA0(f, f2, 0L);
                    groupComponent.draw(drawScope);
                    return unit;
                } finally {
                    IntIntPair$$ExternalSyntheticOutline0.m(drawContext, jM831getSizeNHjbRc);
                }
        }
    }
}
