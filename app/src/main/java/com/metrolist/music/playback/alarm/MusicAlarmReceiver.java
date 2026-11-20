package com.metrolist.music.playback.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.view.DisplayCompat;
import com.metrolist.music.playback.MusicService;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicAlarmReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: com.metrolist.music.playback.alarm.MusicAlarmReceiver$onReceive$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ BroadcastReceiver.PendingResult $pendingResult;
        public final /* synthetic */ byte $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(Context context, BroadcastReceiver.PendingResult pendingResult, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$context = context;
            this.$pendingResult = pendingResult;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            BroadcastReceiver.PendingResult pendingResult = this.$pendingResult;
            Context context = this.$context;
            switch (b) {
                case 0:
                    return new AnonymousClass1(context, pendingResult, continuation, (byte) 0);
                default:
                    return new AnonymousClass1(context, pendingResult, continuation, (byte) 1);
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
            Context context = this.$context;
            BroadcastReceiver.PendingResult pendingResult = this.$pendingResult;
            switch (b) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    try {
                        DisplayCompat.scheduleFromPreferences(context);
                        return unit;
                    } finally {
                        pendingResult.finish();
                    }
                default:
                    ResultKt.throwOnFailure(obj);
                    try {
                        DisplayCompat.scheduleFromPreferences(context);
                        return unit;
                    } finally {
                        pendingResult.finish();
                    }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        context.getClass();
        Continuation continuation = null;
        if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "com.metrolist.music.action.TRIGGER_ALARM")) {
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            String stringExtra = intent.getStringExtra("extra_alarm_id");
            if (stringExtra == null) {
                stringExtra = "";
            }
            String stringExtra2 = intent.getStringExtra("extra_alarm_playlist_id");
            Intent intentPutExtra = new Intent(context, (Class<?>) MusicService.class).setAction("com.metrolist.music.action.ALARM_TRIGGER").putExtra("extra_alarm_id", stringExtra).putExtra("extra_alarm_playlist_id", stringExtra2 != null ? stringExtra2 : "").putExtra("extra_alarm_random_song", intent.getBooleanExtra("extra_alarm_random_song", false));
            intentPutExtra.getClass();
            context.startForegroundService(intentPutExtra);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            AwaitKt.launch$default(AwaitKt.CoroutineScope(DefaultIoScheduler.INSTANCE), null, null, new AnonymousClass1(context, pendingResultGoAsync, continuation, (byte) 0), 3);
        }
    }
}
