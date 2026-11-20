package com.metrolist.music.ui.component;

import androidx.compose.animation.core.Animatable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayingIndicatorKt$PlayingIndicator$1$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Animatable $animatable;
    public final /* synthetic */ byte $r8$classId;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlayingIndicatorKt$PlayingIndicator$1$1$1$1(Animatable animatable, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$animatable = animatable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new PlayingIndicatorKt$PlayingIndicator$1$1$1$1(this.$animatable, continuation, (byte) 0);
            case 1:
                return new PlayingIndicatorKt$PlayingIndicator$1$1$1$1(this.$animatable, continuation, (byte) 1);
            default:
                return new PlayingIndicatorKt$PlayingIndicator$1$1$1$1(this.$animatable, continuation, (byte) 2);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                ((PlayingIndicatorKt$PlayingIndicator$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return coroutineSingletons;
            case 1:
                return ((PlayingIndicatorKt$PlayingIndicator$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            default:
                ((PlayingIndicatorKt$PlayingIndicator$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return coroutineSingletons;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004e -> B:12:0x0026). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00de -> B:42:0x00ac). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.component.PlayingIndicatorKt$PlayingIndicator$1$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
