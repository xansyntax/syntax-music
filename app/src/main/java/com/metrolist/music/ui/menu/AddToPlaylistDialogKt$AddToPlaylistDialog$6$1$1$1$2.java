package com.metrolist.music.ui.menu;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AddToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Function0 $onDismiss;
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2(Function0 function0, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$onDismiss = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new AddToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2(this.$onDismiss, continuation, (byte) 0);
            case 1:
                return new AddToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2(this.$onDismiss, continuation, (byte) 1);
            case 2:
                return new AddToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2(this.$onDismiss, continuation, (byte) 2);
            default:
                return new AddToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2(this.$onDismiss, continuation, (byte) 3);
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
                ((AddToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            case 1:
                ((AddToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            case 2:
                ((AddToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((AddToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function0 function0 = this.$onDismiss;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                function0.invoke();
                break;
            case 1:
                ResultKt.throwOnFailure(obj);
                function0.invoke();
                break;
            case 2:
                ResultKt.throwOnFailure(obj);
                function0.invoke();
                break;
            default:
                ResultKt.throwOnFailure(obj);
                function0.invoke();
                break;
        }
        return unit;
    }
}
