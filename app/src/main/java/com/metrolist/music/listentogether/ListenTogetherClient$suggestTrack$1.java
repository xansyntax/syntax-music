package com.metrolist.music.listentogether;

import android.content.Context;
import android.widget.Toast;
import com.yalantis.ucrop.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ListenTogetherClient$suggestTrack$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ ListenTogetherClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListenTogetherClient$suggestTrack$1(ListenTogetherClient listenTogetherClient, Continuation continuation) {
        super(2, continuation);
        this.this$0 = listenTogetherClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ListenTogetherClient$suggestTrack$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ListenTogetherClient$suggestTrack$1 listenTogetherClient$suggestTrack$1 = (ListenTogetherClient$suggestTrack$1) create((CoroutineScope) obj, (Continuation) obj2);
        Unit unit = Unit.INSTANCE;
        listenTogetherClient$suggestTrack$1.invokeSuspend(unit);
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ResultKt.throwOnFailure(obj);
        Context context = this.this$0.context;
        Toast.makeText(context, context.getString(R.string.listen_together_suggestion_sent), 0).show();
        return Unit.INSTANCE;
    }
}
