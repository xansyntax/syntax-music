package com.metrolist.music.listentogether;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationManagerCompat;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorJobImpl;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ListenTogetherActionReceiver extends BroadcastReceiver {
    public static final ContextScope scope;

    /* JADX INFO: renamed from: com.metrolist.music.listentogether.ListenTogetherActionReceiver$onReceive$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ ListenTogetherClient $client;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ String $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(ListenTogetherClient listenTogetherClient, String str, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$client = listenTogetherClient;
            this.$userId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            String str = this.$userId;
            ListenTogetherClient listenTogetherClient = this.$client;
            switch (b) {
                case 0:
                    return new AnonymousClass1(listenTogetherClient, str, continuation, (byte) 0);
                case 1:
                    return new AnonymousClass1(listenTogetherClient, str, continuation, (byte) 1);
                case 2:
                    return new AnonymousClass1(listenTogetherClient, str, continuation, (byte) 2);
                default:
                    return new AnonymousClass1(listenTogetherClient, str, continuation, (byte) 3);
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
                    ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
                case 1:
                    ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
                case 2:
                    ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
                default:
                    ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
            }
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            String str = this.$userId;
            ListenTogetherClient listenTogetherClient = this.$client;
            switch (b) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    listenTogetherClient.approveJoin(str);
                    break;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    listenTogetherClient.rejectJoin(str, null);
                    break;
                case 2:
                    ResultKt.throwOnFailure(obj);
                    listenTogetherClient.approveSuggestion(str);
                    break;
                default:
                    ResultKt.throwOnFailure(obj);
                    listenTogetherClient.rejectSuggestion(str, null);
                    break;
            }
            return unit;
        }
    }

    static {
        SupervisorJobImpl supervisorJobImplSupervisorJob$default = AwaitKt.SupervisorJob$default();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        scope = AwaitKt.CoroutineScope(StringsKt__IndentKt.plus(supervisorJobImplSupervisorJob$default, DefaultIoScheduler.INSTANCE));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String stringExtra;
        String stringExtra2;
        String stringExtra3;
        String stringExtra4;
        context.getClass();
        intent.getClass();
        String str = ListenTogetherClient.DEFAULT_SERVER_URL;
        ListenTogetherClient listenTogetherClient = ListenTogetherClient.instance;
        if (listenTogetherClient == null) {
            return;
        }
        byte b = 0;
        new NotificationManagerCompat(context).cancel(intent.getIntExtra("extra_notification_id", 0));
        String action = intent.getAction();
        if (action != null) {
            byte b2 = 3;
            Continuation continuation = null;
            switch (action.hashCode()) {
                case -1202276630:
                    if (action.equals("com.metrolist.music.LISTEN_TOGETHER_REJECT_SUGGESTION") && (stringExtra = intent.getStringExtra("extra_suggestion_id")) != null) {
                        AwaitKt.launch$default(scope, null, null, new AnonymousClass1(listenTogetherClient, stringExtra, continuation, b2), 3);
                    }
                    break;
                case -1060111664:
                    if (action.equals("com.metrolist.music.LISTEN_TOGETHER_APPROVE_SUGGESTION") && (stringExtra2 = intent.getStringExtra("extra_suggestion_id")) != null) {
                        AwaitKt.launch$default(scope, null, null, new AnonymousClass1(listenTogetherClient, stringExtra2, continuation, (byte) 2), 3);
                    }
                    break;
                case 1268775568:
                    if (action.equals("com.metrolist.music.LISTEN_TOGETHER_REJECT_JOIN") && (stringExtra3 = intent.getStringExtra("extra_user_id")) != null) {
                        AwaitKt.launch$default(scope, null, null, new AnonymousClass1(listenTogetherClient, stringExtra3, continuation, (byte) 1), 3);
                    }
                    break;
                case 1773904630:
                    if (action.equals("com.metrolist.music.LISTEN_TOGETHER_APPROVE_JOIN") && (stringExtra4 = intent.getStringExtra("extra_user_id")) != null) {
                        AwaitKt.launch$default(scope, null, null, new AnonymousClass1(listenTogetherClient, stringExtra4, continuation, b), 3);
                    }
                    break;
            }
        }
    }
}
