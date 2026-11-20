package dev.chrisbanes.haze;

import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RenderScriptBlurEffect$drawEffect$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Ref$FloatRef $blurRadiusPx;
    public final /* synthetic */ GraphicsLayer $layer;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ RenderScriptBlurEffect this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RenderScriptBlurEffect$drawEffect$2$1(RenderScriptBlurEffect renderScriptBlurEffect, GraphicsLayer graphicsLayer, Ref$FloatRef ref$FloatRef, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = renderScriptBlurEffect;
        this.$layer = graphicsLayer;
        this.$blurRadiusPx = ref$FloatRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new RenderScriptBlurEffect$drawEffect$2$1(this.this$0, this.$layer, this.$blurRadiusPx, continuation, (byte) 0);
            default:
                return new RenderScriptBlurEffect$drawEffect$2$1(this.this$0, this.$layer, this.$blurRadiusPx, continuation, (byte) 1);
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
        }
        return ((RenderScriptBlurEffect$drawEffect$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Ref$FloatRef ref$FloatRef = this.$blurRadiusPx;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        RenderScriptBlurEffect renderScriptBlurEffect = this.this$0;
        GraphicsLayer graphicsLayer = this.$layer;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    float f = ref$FloatRef.element;
                    this.label = true;
                    if (renderScriptBlurEffect.updateSurface(graphicsLayer, f, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ((GraphicsContext) HitTestResultKt.currentValueOf(renderScriptBlurEffect.node, CompositionLocalsKt.LocalGraphicsContext)).releaseGraphicsLayer(graphicsLayer);
                return unit;
            default:
                HazeEffectNode hazeEffectNode = renderScriptBlurEffect.node;
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    float f2 = ref$FloatRef.element;
                    this.label = true;
                    if (renderScriptBlurEffect.updateSurface(graphicsLayer, f2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ((GraphicsContext) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalGraphicsContext)).releaseGraphicsLayer(graphicsLayer);
                if (!renderScriptBlurEffect.drawSkipped) {
                    return unit;
                }
                HitTestResultKt.invalidateDraw(hazeEffectNode);
                return unit;
        }
    }
}
