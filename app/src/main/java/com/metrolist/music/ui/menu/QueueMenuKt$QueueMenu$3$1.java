package com.metrolist.music.ui.menu;

import com.metrolist.music.models.MediaMetadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QueueMenuKt$QueueMenu$3$1 extends SuspendLambda implements Function1 {
    public final /* synthetic */ MediaMetadata $mediaMetadata;
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueueMenuKt$QueueMenu$3$1(MediaMetadata mediaMetadata, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.$mediaMetadata = mediaMetadata;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        byte b = this.$r8$classId;
        MediaMetadata mediaMetadata = this.$mediaMetadata;
        switch (b) {
            case 0:
                return new QueueMenuKt$QueueMenu$3$1(mediaMetadata, continuation, (byte) 0);
            default:
                return new QueueMenuKt$QueueMenu$3$1(mediaMetadata, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = (Continuation) obj;
        switch (b) {
            case 0:
                break;
        }
        return ((QueueMenuKt$QueueMenu$3$1) create(continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        MediaMetadata mediaMetadata = this.$mediaMetadata;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                break;
            default:
                ResultKt.throwOnFailure(obj);
                break;
        }
        return CollectionsKt__IterablesKt.listOf(mediaMetadata.id);
    }
}
