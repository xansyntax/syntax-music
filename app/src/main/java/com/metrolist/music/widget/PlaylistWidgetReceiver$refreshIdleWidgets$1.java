package com.metrolist.music.widget;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaylistWidgetReceiver$refreshIdleWidgets$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int[] $appWidgetIds;
    public final /* synthetic */ AppWidgetManager $appWidgetManager;
    public final /* synthetic */ BroadcastReceiver.PendingResult $pendingResult;
    public int I$0;
    public int I$1;
    public int[] L$0;
    public PlaylistWidgetReceiver L$1;
    public AppWidgetManager L$2;
    public boolean label;
    public final /* synthetic */ PlaylistWidgetReceiver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaylistWidgetReceiver$refreshIdleWidgets$1(int[] iArr, BroadcastReceiver.PendingResult pendingResult, PlaylistWidgetReceiver playlistWidgetReceiver, AppWidgetManager appWidgetManager, Continuation continuation) {
        super(2, continuation);
        this.$appWidgetIds = iArr;
        this.$pendingResult = pendingResult;
        this.this$0 = playlistWidgetReceiver;
        this.$appWidgetManager = appWidgetManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PlaylistWidgetReceiver$refreshIdleWidgets$1(this.$appWidgetIds, this.$pendingResult, this.this$0, this.$appWidgetManager, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((PlaylistWidgetReceiver$refreshIdleWidgets$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0032 A[Catch: all -> 0x0019, Exception -> 0x0060, Merged into TryCatch #1 {all -> 0x0019, Exception -> 0x0060, blocks: (B:6:0x0015, B:15:0x0032, B:17:0x0038, B:22:0x0056, B:23:0x005b, B:25:0x0060, B:13:0x0024), top: B:31:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0038 A[Catch: all -> 0x0019, Exception -> 0x0060, Merged into TryCatch #1 {all -> 0x0019, Exception -> 0x0060, blocks: (B:6:0x0015, B:15:0x0032, B:17:0x0038, B:22:0x0056, B:23:0x005b, B:25:0x0060, B:13:0x0024), top: B:31:0x0007 }, TRY_LEAVE] */
    /* JADX WARN: Code duplicated, block: B:20:0x0053 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0051 -> B:21:0x0054). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            boolean r0 = r11.label
            r1 = 0
            r2 = 0
            android.content.BroadcastReceiver$PendingResult r3 = r11.$pendingResult
            r4 = 1
            if (r0 == 0) goto L21
            if (r0 != r4) goto L1b
            int r0 = r11.I$1
            int r5 = r11.I$0
            android.appwidget.AppWidgetManager r6 = r11.L$2
            com.metrolist.music.widget.PlaylistWidgetReceiver r7 = r11.L$1
            int[] r8 = r11.L$0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L60
            goto L54
        L19:
            r11 = move-exception
            goto L70
        L1b:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r11)
            return r1
        L21:
            kotlin.ResultKt.throwOnFailure(r12)
            int[] r12 = r11.$appWidgetIds     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L60
            com.metrolist.music.widget.PlaylistWidgetReceiver r0 = r11.this$0     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L60
            android.appwidget.AppWidgetManager r5 = r11.$appWidgetManager     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L60
            int r6 = r12.length     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L60
            r8 = r12
            r7 = r0
            r0 = r6
            r6 = r5
            r5 = r2
        L30:
            if (r5 >= r0) goto L5c
            r12 = r8[r5]     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L60
            com.metrolist.music.widget.PlaylistWidgetManager r9 = r7.playlistWidgetManager     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L60
            if (r9 == 0) goto L56
            android.os.Bundle r10 = r6.getAppWidgetOptions(r12)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L60
            r10.getClass()     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L60
            r11.L$0 = r8     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L60
            r11.L$1 = r7     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L60
            r11.L$2 = r6     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L60
            r11.I$0 = r5     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L60
            r11.I$1 = r0     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L60
            r11.label = r4     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L60
            java.lang.Object r12 = r9.updateIdleWidget(r12, r10, r11)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L60
            kotlin.coroutines.intrinsics.CoroutineSingletons r9 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r12 != r9) goto L54
            return r9
        L54:
            int r5 = r5 + r4
            goto L30
        L56:
            java.lang.String r11 = "playlistWidgetManager"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L60
            throw r1     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L60
        L5c:
            r3.finish()
            goto L6d
        L60:
            okhttp3.ConnectionPool r11 = timber.log.Timber.Forest     // Catch: java.lang.Throwable -> L19
            java.lang.String r12 = "PlaylistWidgetReceiver"
            r11.tag(r12)     // Catch: java.lang.Throwable -> L19
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L19
            okhttp3.ConnectionPool.e$1(r11)     // Catch: java.lang.Throwable -> L19
            goto L5c
        L6d:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L70:
            r3.finish()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.widget.PlaylistWidgetReceiver$refreshIdleWidgets$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
