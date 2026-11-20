package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollState;
import androidx.compose.material3.internal.DropdownMenuPositionProvider;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MenuKt$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Modifier f$0;
    public final /* synthetic */ MutableTransitionState f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ ScrollState f$3;
    public final /* synthetic */ Shape f$4;
    public final /* synthetic */ long f$5;
    public final /* synthetic */ float f$7;
    public final /* synthetic */ ComposableLambdaImpl f$9;

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda4(Modifier modifier, MutableTransitionState mutableTransitionState, DropdownMenuPositionProvider dropdownMenuPositionProvider, ScrollState scrollState, Shape shape, long j, float f, ComposableLambdaImpl composableLambdaImpl) {
        this.f$0 = modifier;
        this.f$1 = mutableTransitionState;
        this.f$2 = dropdownMenuPositionProvider;
        this.f$3 = scrollState;
        this.f$4 = shape;
        this.f$5 = j;
        this.f$7 = f;
        this.f$9 = composableLambdaImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$2;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                MenuKt.m305DropdownMenuContentQj0Zi0g(this.f$0, this.f$1, (Function0) obj3, this.f$3, this.f$4, this.f$5, this.f$7, this.f$9, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            default:
                DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(1 & iIntValue, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    boolean zChanged = gapComposer.changed(dropdownMenuPositionProvider);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new SliderState$$ExternalSyntheticLambda0((byte) 25, dropdownMenuPositionProvider);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    MenuKt.m305DropdownMenuContentQj0Zi0g(this.f$0, this.f$1, (Function0) objRememberedValue, this.f$3, this.f$4, this.f$5, this.f$7, this.f$9, gapComposer, 0);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda4(Modifier modifier, MutableTransitionState mutableTransitionState, Function0 function0, ScrollState scrollState, Shape shape, long j, float f, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$0 = modifier;
        this.f$1 = mutableTransitionState;
        this.f$2 = function0;
        this.f$3 = scrollState;
        this.f$4 = shape;
        this.f$5 = j;
        this.f$7 = f;
        this.f$9 = composableLambdaImpl;
    }
}
