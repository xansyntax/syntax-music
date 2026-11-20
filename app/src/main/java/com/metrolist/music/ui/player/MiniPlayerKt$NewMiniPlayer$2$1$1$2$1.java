package com.metrolist.music.ui.player;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.SpringSpec;
import com.yalantis.ucrop.view.CropImageView;
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
public final class MiniPlayerKt$NewMiniPlayer$2$1$1$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ SpringSpec $animationSpec;
    public final /* synthetic */ Animatable $offsetXAnimatable;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MiniPlayerKt$NewMiniPlayer$2$1$1$2$1(Animatable animatable, SpringSpec springSpec, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$offsetXAnimatable = animatable;
        this.$animationSpec = springSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new MiniPlayerKt$NewMiniPlayer$2$1$1$2$1(this.$offsetXAnimatable, this.$animationSpec, continuation, (byte) 0);
            case 1:
                return new MiniPlayerKt$NewMiniPlayer$2$1$1$2$1(this.$offsetXAnimatable, this.$animationSpec, continuation, (byte) 1);
            case 2:
                return new MiniPlayerKt$NewMiniPlayer$2$1$1$2$1(this.$offsetXAnimatable, this.$animationSpec, continuation, (byte) 2);
            default:
                return new MiniPlayerKt$NewMiniPlayer$2$1$1$2$1(this.$offsetXAnimatable, this.$animationSpec, continuation, (byte) 3);
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
        return ((MiniPlayerKt$NewMiniPlayer$2$1$1$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    Float f = new Float(CropImageView.DEFAULT_ASPECT_RATIO);
                    this.label = true;
                    return Animatable.animateTo$default(this.$offsetXAnimatable, f, this.$animationSpec, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
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
                    Float f2 = new Float(CropImageView.DEFAULT_ASPECT_RATIO);
                    this.label = true;
                    return Animatable.animateTo$default(this.$offsetXAnimatable, f2, this.$animationSpec, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z2) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 2:
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    Float f3 = new Float(CropImageView.DEFAULT_ASPECT_RATIO);
                    this.label = true;
                    return Animatable.animateTo$default(this.$offsetXAnimatable, f3, this.$animationSpec, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z3) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                boolean z4 = this.label;
                if (!z4) {
                    ResultKt.throwOnFailure(obj);
                    Float f4 = new Float(CropImageView.DEFAULT_ASPECT_RATIO);
                    this.label = true;
                    return Animatable.animateTo$default(this.$offsetXAnimatable, f4, this.$animationSpec, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
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
