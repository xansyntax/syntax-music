package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.unit.Dp;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IndicatorLineNode$update$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ IndicatorLineNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IndicatorLineNode$update$1(IndicatorLineNode indicatorLineNode, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = indicatorLineNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        IndicatorLineNode indicatorLineNode = this.this$0;
        switch (b) {
            case 0:
                return new IndicatorLineNode$update$1(indicatorLineNode, continuation, (byte) 0);
            case 1:
                return new IndicatorLineNode$update$1(indicatorLineNode, continuation, (byte) 1);
            case 2:
                return new IndicatorLineNode$update$1(indicatorLineNode, continuation, (byte) 2);
            default:
                return new IndicatorLineNode$update$1(indicatorLineNode, continuation, (byte) 3);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        return ((IndicatorLineNode$update$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        IndicatorLineNode indicatorLineNode = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    return indicatorLineNode.trackFocusState(this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = indicatorLineNode.colorAnimatable;
                    if (animatable == null) {
                        return unit;
                    }
                    TextFieldColors textFieldColorsDefaultTextFieldColors$material3 = indicatorLineNode._colors;
                    if (textFieldColorsDefaultTextFieldColors$material3 == null) {
                        textFieldColorsDefaultTextFieldColors$material3 = TextFieldDefaults.defaultTextFieldColors$material3(((MaterialTheme$Values) HitTestResultKt.currentValueOf(indicatorLineNode, MaterialThemeKt._localMaterialTheme)).colorScheme, (TextSelectionColors) HitTestResultKt.currentValueOf(indicatorLineNode, TextSelectionColorsKt.LocalTextSelectionColors));
                    }
                    Color color = new Color(textFieldColorsDefaultTextFieldColors$material3.m345indicatorColorXeAY9LY(indicatorLineNode.enabled, indicatorLineNode.focused));
                    AnimationSpec animationSpecM269fromTokenbmhGWGE = indicatorLineNode.enabled ? CardKt.m269fromTokenbmhGWGE(((MaterialTheme$Values) HitTestResultKt.currentValueOf(indicatorLineNode, MaterialThemeKt._localMaterialTheme)).motionScheme, 4) : ArcSplineKt.snap$default();
                    this.label = true;
                    obj = Animatable.animateTo$default(animatable, color, animationSpecM269fromTokenbmhGWGE, null, null, this, 12);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return unit;
            case 2:
                boolean z3 = this.label;
                if (z3) {
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Animatable animatable2 = indicatorLineNode.widthAnimatable;
                Dp dp = new Dp((indicatorLineNode.focused && indicatorLineNode.enabled) ? indicatorLineNode.focusedIndicatorWidth : indicatorLineNode.unfocusedIndicatorWidth);
                AnimationSpec animationSpecM269fromTokenbmhGWGE2 = indicatorLineNode.enabled ? CardKt.m269fromTokenbmhGWGE(((MaterialTheme$Values) HitTestResultKt.currentValueOf(indicatorLineNode, MaterialThemeKt._localMaterialTheme)).motionScheme, 1) : ArcSplineKt.snap$default();
                this.label = true;
                return Animatable.animateTo$default(animatable2, dp, animationSpecM269fromTokenbmhGWGE2, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                boolean z4 = this.label;
                if (!z4) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    return indicatorLineNode.trackFocusState(this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z4) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
