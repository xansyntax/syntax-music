package com.metrolist.music.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.ScrollingLogic;
import androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1;
import androidx.datastore.preferences.core.MutablePreferences;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.dokar.quickjs.QuickJs;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.extensions.ContextExtKt$isSyncEnabled$1;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SyncUtils$tryAutoSync$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public byte label;
    public final /* synthetic */ SyncUtils this$0;

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$tryAutoSync$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ long $now;
        public final /* synthetic */ byte $r8$classId;
        public /* synthetic */ Object L$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(long j, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$now = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$now, continuation, (byte) 0);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                default:
                    AnonymousClass1 anonymousClass2 = new AnonymousClass1(this.$now, continuation, (byte) 1);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    ((AnonymousClass1) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(unit);
                    break;
                default:
                    ((AnonymousClass1) create((ScrollingLogic$nestedScrollScope$1) obj, (Continuation) obj2)).invokeSuspend(unit);
                    break;
            }
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            long j = this.$now;
            switch (b) {
                case 0:
                    MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutablePreferences.set(PreferenceKeysKt.LastFullSyncKey, new Long(j));
                    break;
                default:
                    ResultKt.throwOnFailure(obj);
                    ScrollingLogic scrollingLogic = ((ScrollingLogic$nestedScrollScope$1) this.L$0).this$0;
                    scrollingLogic.m103performScroll3eAAhYA(scrollingLogic.outerStateScope, j, 1);
                    break;
            }
            return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SyncUtils$tryAutoSync$1(SyncUtils syncUtils, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = syncUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        SyncUtils syncUtils = this.this$0;
        switch (b) {
            case 0:
                return new SyncUtils$tryAutoSync$1(syncUtils, continuation, (byte) 0);
            default:
                return new SyncUtils$tryAutoSync$1(syncUtils, continuation, (byte) 1);
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
        return ((SyncUtils$tryAutoSync$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01ad A[Catch: Exception -> 0x01c5, CancellationException -> 0x01d2, TryCatch #2 {CancellationException -> 0x01d2, Exception -> 0x01c5, blocks: (B:7:0x0020, B:103:0x01b9, B:8:0x0025, B:100:0x01ad, B:9:0x002a, B:94:0x0193, B:10:0x002f, B:91:0x0188, B:11:0x0034, B:88:0x017b, B:12:0x0039, B:85:0x0170, B:13:0x003e, B:82:0x0163, B:14:0x0043, B:79:0x0158, B:15:0x0048, B:73:0x0140, B:16:0x004d, B:70:0x0134, B:17:0x0052, B:64:0x0119, B:18:0x0057, B:61:0x010d, B:19:0x005c, B:55:0x00f2, B:20:0x0061, B:52:0x00e7, B:21:0x0066, B:49:0x00da, B:22:0x006b, B:46:0x00d0, B:23:0x006f, B:40:0x00b6, B:24:0x0073, B:37:0x00ab, B:34:0x009f), top: B:140:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0092  */
    /* JADX WARN: Code duplicated, block: B:34:0x009f A[Catch: Exception -> 0x01c5, CancellationException -> 0x01d2, TRY_ENTER, TryCatch #2 {CancellationException -> 0x01d2, Exception -> 0x01c5, blocks: (B:7:0x0020, B:103:0x01b9, B:8:0x0025, B:100:0x01ad, B:9:0x002a, B:94:0x0193, B:10:0x002f, B:91:0x0188, B:11:0x0034, B:88:0x017b, B:12:0x0039, B:85:0x0170, B:13:0x003e, B:82:0x0163, B:14:0x0043, B:79:0x0158, B:15:0x0048, B:73:0x0140, B:16:0x004d, B:70:0x0134, B:17:0x0052, B:64:0x0119, B:18:0x0057, B:61:0x010d, B:19:0x005c, B:55:0x00f2, B:20:0x0061, B:52:0x00e7, B:21:0x0066, B:49:0x00da, B:22:0x006b, B:46:0x00d0, B:23:0x006f, B:40:0x00b6, B:24:0x0073, B:37:0x00ab, B:34:0x009f), top: B:140:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ab A[Catch: Exception -> 0x01c5, CancellationException -> 0x01d2, TryCatch #2 {CancellationException -> 0x01d2, Exception -> 0x01c5, blocks: (B:7:0x0020, B:103:0x01b9, B:8:0x0025, B:100:0x01ad, B:9:0x002a, B:94:0x0193, B:10:0x002f, B:91:0x0188, B:11:0x0034, B:88:0x017b, B:12:0x0039, B:85:0x0170, B:13:0x003e, B:82:0x0163, B:14:0x0043, B:79:0x0158, B:15:0x0048, B:73:0x0140, B:16:0x004d, B:70:0x0134, B:17:0x0052, B:64:0x0119, B:18:0x0057, B:61:0x010d, B:19:0x005c, B:55:0x00f2, B:20:0x0061, B:52:0x00e7, B:21:0x0066, B:49:0x00da, B:22:0x006b, B:46:0x00d0, B:23:0x006f, B:40:0x00b6, B:24:0x0073, B:37:0x00ab, B:34:0x009f), top: B:140:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b6 A[Catch: Exception -> 0x01c5, CancellationException -> 0x01d2, TryCatch #2 {CancellationException -> 0x01d2, Exception -> 0x01c5, blocks: (B:7:0x0020, B:103:0x01b9, B:8:0x0025, B:100:0x01ad, B:9:0x002a, B:94:0x0193, B:10:0x002f, B:91:0x0188, B:11:0x0034, B:88:0x017b, B:12:0x0039, B:85:0x0170, B:13:0x003e, B:82:0x0163, B:14:0x0043, B:79:0x0158, B:15:0x0048, B:73:0x0140, B:16:0x004d, B:70:0x0134, B:17:0x0052, B:64:0x0119, B:18:0x0057, B:61:0x010d, B:19:0x005c, B:55:0x00f2, B:20:0x0061, B:52:0x00e7, B:21:0x0066, B:49:0x00da, B:22:0x006b, B:46:0x00d0, B:23:0x006f, B:40:0x00b6, B:24:0x0073, B:37:0x00ab, B:34:0x009f), top: B:140:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:43:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d0 A[Catch: Exception -> 0x01c5, CancellationException -> 0x01d2, TryCatch #2 {CancellationException -> 0x01d2, Exception -> 0x01c5, blocks: (B:7:0x0020, B:103:0x01b9, B:8:0x0025, B:100:0x01ad, B:9:0x002a, B:94:0x0193, B:10:0x002f, B:91:0x0188, B:11:0x0034, B:88:0x017b, B:12:0x0039, B:85:0x0170, B:13:0x003e, B:82:0x0163, B:14:0x0043, B:79:0x0158, B:15:0x0048, B:73:0x0140, B:16:0x004d, B:70:0x0134, B:17:0x0052, B:64:0x0119, B:18:0x0057, B:61:0x010d, B:19:0x005c, B:55:0x00f2, B:20:0x0061, B:52:0x00e7, B:21:0x0066, B:49:0x00da, B:22:0x006b, B:46:0x00d0, B:23:0x006f, B:40:0x00b6, B:24:0x0073, B:37:0x00ab, B:34:0x009f), top: B:140:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00da A[Catch: Exception -> 0x01c5, CancellationException -> 0x01d2, TryCatch #2 {CancellationException -> 0x01d2, Exception -> 0x01c5, blocks: (B:7:0x0020, B:103:0x01b9, B:8:0x0025, B:100:0x01ad, B:9:0x002a, B:94:0x0193, B:10:0x002f, B:91:0x0188, B:11:0x0034, B:88:0x017b, B:12:0x0039, B:85:0x0170, B:13:0x003e, B:82:0x0163, B:14:0x0043, B:79:0x0158, B:15:0x0048, B:73:0x0140, B:16:0x004d, B:70:0x0134, B:17:0x0052, B:64:0x0119, B:18:0x0057, B:61:0x010d, B:19:0x005c, B:55:0x00f2, B:20:0x0061, B:52:0x00e7, B:21:0x0066, B:49:0x00da, B:22:0x006b, B:46:0x00d0, B:23:0x006f, B:40:0x00b6, B:24:0x0073, B:37:0x00ab, B:34:0x009f), top: B:140:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e7 A[Catch: Exception -> 0x01c5, CancellationException -> 0x01d2, TryCatch #2 {CancellationException -> 0x01d2, Exception -> 0x01c5, blocks: (B:7:0x0020, B:103:0x01b9, B:8:0x0025, B:100:0x01ad, B:9:0x002a, B:94:0x0193, B:10:0x002f, B:91:0x0188, B:11:0x0034, B:88:0x017b, B:12:0x0039, B:85:0x0170, B:13:0x003e, B:82:0x0163, B:14:0x0043, B:79:0x0158, B:15:0x0048, B:73:0x0140, B:16:0x004d, B:70:0x0134, B:17:0x0052, B:64:0x0119, B:18:0x0057, B:61:0x010d, B:19:0x005c, B:55:0x00f2, B:20:0x0061, B:52:0x00e7, B:21:0x0066, B:49:0x00da, B:22:0x006b, B:46:0x00d0, B:23:0x006f, B:40:0x00b6, B:24:0x0073, B:37:0x00ab, B:34:0x009f), top: B:140:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00f2 A[Catch: Exception -> 0x01c5, CancellationException -> 0x01d2, TryCatch #2 {CancellationException -> 0x01d2, Exception -> 0x01c5, blocks: (B:7:0x0020, B:103:0x01b9, B:8:0x0025, B:100:0x01ad, B:9:0x002a, B:94:0x0193, B:10:0x002f, B:91:0x0188, B:11:0x0034, B:88:0x017b, B:12:0x0039, B:85:0x0170, B:13:0x003e, B:82:0x0163, B:14:0x0043, B:79:0x0158, B:15:0x0048, B:73:0x0140, B:16:0x004d, B:70:0x0134, B:17:0x0052, B:64:0x0119, B:18:0x0057, B:61:0x010d, B:19:0x005c, B:55:0x00f2, B:20:0x0061, B:52:0x00e7, B:21:0x0066, B:49:0x00da, B:22:0x006b, B:46:0x00d0, B:23:0x006f, B:40:0x00b6, B:24:0x0073, B:37:0x00ab, B:34:0x009f), top: B:140:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0107  */
    /* JADX WARN: Code duplicated, block: B:58:0x0108  */
    /* JADX WARN: Code duplicated, block: B:60:0x010b  */
    /* JADX WARN: Code duplicated, block: B:61:0x010d A[Catch: Exception -> 0x01c5, CancellationException -> 0x01d2, TryCatch #2 {CancellationException -> 0x01d2, Exception -> 0x01c5, blocks: (B:7:0x0020, B:103:0x01b9, B:8:0x0025, B:100:0x01ad, B:9:0x002a, B:94:0x0193, B:10:0x002f, B:91:0x0188, B:11:0x0034, B:88:0x017b, B:12:0x0039, B:85:0x0170, B:13:0x003e, B:82:0x0163, B:14:0x0043, B:79:0x0158, B:15:0x0048, B:73:0x0140, B:16:0x004d, B:70:0x0134, B:17:0x0052, B:64:0x0119, B:18:0x0057, B:61:0x010d, B:19:0x005c, B:55:0x00f2, B:20:0x0061, B:52:0x00e7, B:21:0x0066, B:49:0x00da, B:22:0x006b, B:46:0x00d0, B:23:0x006f, B:40:0x00b6, B:24:0x0073, B:37:0x00ab, B:34:0x009f), top: B:140:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0117  */
    /* JADX WARN: Code duplicated, block: B:64:0x0119 A[Catch: Exception -> 0x01c5, CancellationException -> 0x01d2, TryCatch #2 {CancellationException -> 0x01d2, Exception -> 0x01c5, blocks: (B:7:0x0020, B:103:0x01b9, B:8:0x0025, B:100:0x01ad, B:9:0x002a, B:94:0x0193, B:10:0x002f, B:91:0x0188, B:11:0x0034, B:88:0x017b, B:12:0x0039, B:85:0x0170, B:13:0x003e, B:82:0x0163, B:14:0x0043, B:79:0x0158, B:15:0x0048, B:73:0x0140, B:16:0x004d, B:70:0x0134, B:17:0x0052, B:64:0x0119, B:18:0x0057, B:61:0x010d, B:19:0x005c, B:55:0x00f2, B:20:0x0061, B:52:0x00e7, B:21:0x0066, B:49:0x00da, B:22:0x006b, B:46:0x00d0, B:23:0x006f, B:40:0x00b6, B:24:0x0073, B:37:0x00ab, B:34:0x009f), top: B:140:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x012e  */
    /* JADX WARN: Code duplicated, block: B:67:0x012f  */
    /* JADX WARN: Code duplicated, block: B:69:0x0132  */
    /* JADX WARN: Code duplicated, block: B:70:0x0134 A[Catch: Exception -> 0x01c5, CancellationException -> 0x01d2, TryCatch #2 {CancellationException -> 0x01d2, Exception -> 0x01c5, blocks: (B:7:0x0020, B:103:0x01b9, B:8:0x0025, B:100:0x01ad, B:9:0x002a, B:94:0x0193, B:10:0x002f, B:91:0x0188, B:11:0x0034, B:88:0x017b, B:12:0x0039, B:85:0x0170, B:13:0x003e, B:82:0x0163, B:14:0x0043, B:79:0x0158, B:15:0x0048, B:73:0x0140, B:16:0x004d, B:70:0x0134, B:17:0x0052, B:64:0x0119, B:18:0x0057, B:61:0x010d, B:19:0x005c, B:55:0x00f2, B:20:0x0061, B:52:0x00e7, B:21:0x0066, B:49:0x00da, B:22:0x006b, B:46:0x00d0, B:23:0x006f, B:40:0x00b6, B:24:0x0073, B:37:0x00ab, B:34:0x009f), top: B:140:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x013e  */
    /* JADX WARN: Code duplicated, block: B:73:0x0140 A[Catch: Exception -> 0x01c5, CancellationException -> 0x01d2, TryCatch #2 {CancellationException -> 0x01d2, Exception -> 0x01c5, blocks: (B:7:0x0020, B:103:0x01b9, B:8:0x0025, B:100:0x01ad, B:9:0x002a, B:94:0x0193, B:10:0x002f, B:91:0x0188, B:11:0x0034, B:88:0x017b, B:12:0x0039, B:85:0x0170, B:13:0x003e, B:82:0x0163, B:14:0x0043, B:79:0x0158, B:15:0x0048, B:73:0x0140, B:16:0x004d, B:70:0x0134, B:17:0x0052, B:64:0x0119, B:18:0x0057, B:61:0x010d, B:19:0x005c, B:55:0x00f2, B:20:0x0061, B:52:0x00e7, B:21:0x0066, B:49:0x00da, B:22:0x006b, B:46:0x00d0, B:23:0x006f, B:40:0x00b6, B:24:0x0073, B:37:0x00ab, B:34:0x009f), top: B:140:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0153  */
    /* JADX WARN: Code duplicated, block: B:76:0x0154  */
    /* JADX WARN: Code duplicated, block: B:78:0x0157  */
    /* JADX WARN: Code duplicated, block: B:79:0x0158 A[Catch: Exception -> 0x01c5, CancellationException -> 0x01d2, TryCatch #2 {CancellationException -> 0x01d2, Exception -> 0x01c5, blocks: (B:7:0x0020, B:103:0x01b9, B:8:0x0025, B:100:0x01ad, B:9:0x002a, B:94:0x0193, B:10:0x002f, B:91:0x0188, B:11:0x0034, B:88:0x017b, B:12:0x0039, B:85:0x0170, B:13:0x003e, B:82:0x0163, B:14:0x0043, B:79:0x0158, B:15:0x0048, B:73:0x0140, B:16:0x004d, B:70:0x0134, B:17:0x0052, B:64:0x0119, B:18:0x0057, B:61:0x010d, B:19:0x005c, B:55:0x00f2, B:20:0x0061, B:52:0x00e7, B:21:0x0066, B:49:0x00da, B:22:0x006b, B:46:0x00d0, B:23:0x006f, B:40:0x00b6, B:24:0x0073, B:37:0x00ab, B:34:0x009f), top: B:140:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0162  */
    /* JADX WARN: Code duplicated, block: B:82:0x0163 A[Catch: Exception -> 0x01c5, CancellationException -> 0x01d2, TryCatch #2 {CancellationException -> 0x01d2, Exception -> 0x01c5, blocks: (B:7:0x0020, B:103:0x01b9, B:8:0x0025, B:100:0x01ad, B:9:0x002a, B:94:0x0193, B:10:0x002f, B:91:0x0188, B:11:0x0034, B:88:0x017b, B:12:0x0039, B:85:0x0170, B:13:0x003e, B:82:0x0163, B:14:0x0043, B:79:0x0158, B:15:0x0048, B:73:0x0140, B:16:0x004d, B:70:0x0134, B:17:0x0052, B:64:0x0119, B:18:0x0057, B:61:0x010d, B:19:0x005c, B:55:0x00f2, B:20:0x0061, B:52:0x00e7, B:21:0x0066, B:49:0x00da, B:22:0x006b, B:46:0x00d0, B:23:0x006f, B:40:0x00b6, B:24:0x0073, B:37:0x00ab, B:34:0x009f), top: B:140:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x016f  */
    /* JADX WARN: Code duplicated, block: B:85:0x0170 A[Catch: Exception -> 0x01c5, CancellationException -> 0x01d2, TryCatch #2 {CancellationException -> 0x01d2, Exception -> 0x01c5, blocks: (B:7:0x0020, B:103:0x01b9, B:8:0x0025, B:100:0x01ad, B:9:0x002a, B:94:0x0193, B:10:0x002f, B:91:0x0188, B:11:0x0034, B:88:0x017b, B:12:0x0039, B:85:0x0170, B:13:0x003e, B:82:0x0163, B:14:0x0043, B:79:0x0158, B:15:0x0048, B:73:0x0140, B:16:0x004d, B:70:0x0134, B:17:0x0052, B:64:0x0119, B:18:0x0057, B:61:0x010d, B:19:0x005c, B:55:0x00f2, B:20:0x0061, B:52:0x00e7, B:21:0x0066, B:49:0x00da, B:22:0x006b, B:46:0x00d0, B:23:0x006f, B:40:0x00b6, B:24:0x0073, B:37:0x00ab, B:34:0x009f), top: B:140:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x017a  */
    /* JADX WARN: Code duplicated, block: B:88:0x017b A[Catch: Exception -> 0x01c5, CancellationException -> 0x01d2, TryCatch #2 {CancellationException -> 0x01d2, Exception -> 0x01c5, blocks: (B:7:0x0020, B:103:0x01b9, B:8:0x0025, B:100:0x01ad, B:9:0x002a, B:94:0x0193, B:10:0x002f, B:91:0x0188, B:11:0x0034, B:88:0x017b, B:12:0x0039, B:85:0x0170, B:13:0x003e, B:82:0x0163, B:14:0x0043, B:79:0x0158, B:15:0x0048, B:73:0x0140, B:16:0x004d, B:70:0x0134, B:17:0x0052, B:64:0x0119, B:18:0x0057, B:61:0x010d, B:19:0x005c, B:55:0x00f2, B:20:0x0061, B:52:0x00e7, B:21:0x0066, B:49:0x00da, B:22:0x006b, B:46:0x00d0, B:23:0x006f, B:40:0x00b6, B:24:0x0073, B:37:0x00ab, B:34:0x009f), top: B:140:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0187  */
    /* JADX WARN: Code duplicated, block: B:91:0x0188 A[Catch: Exception -> 0x01c5, CancellationException -> 0x01d2, TryCatch #2 {CancellationException -> 0x01d2, Exception -> 0x01c5, blocks: (B:7:0x0020, B:103:0x01b9, B:8:0x0025, B:100:0x01ad, B:9:0x002a, B:94:0x0193, B:10:0x002f, B:91:0x0188, B:11:0x0034, B:88:0x017b, B:12:0x0039, B:85:0x0170, B:13:0x003e, B:82:0x0163, B:14:0x0043, B:79:0x0158, B:15:0x0048, B:73:0x0140, B:16:0x004d, B:70:0x0134, B:17:0x0052, B:64:0x0119, B:18:0x0057, B:61:0x010d, B:19:0x005c, B:55:0x00f2, B:20:0x0061, B:52:0x00e7, B:21:0x0066, B:49:0x00da, B:22:0x006b, B:46:0x00d0, B:23:0x006f, B:40:0x00b6, B:24:0x0073, B:37:0x00ab, B:34:0x009f), top: B:140:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0192  */
    /* JADX WARN: Code duplicated, block: B:94:0x0193 A[Catch: Exception -> 0x01c5, CancellationException -> 0x01d2, TryCatch #2 {CancellationException -> 0x01d2, Exception -> 0x01c5, blocks: (B:7:0x0020, B:103:0x01b9, B:8:0x0025, B:100:0x01ad, B:9:0x002a, B:94:0x0193, B:10:0x002f, B:91:0x0188, B:11:0x0034, B:88:0x017b, B:12:0x0039, B:85:0x0170, B:13:0x003e, B:82:0x0163, B:14:0x0043, B:79:0x0158, B:15:0x0048, B:73:0x0140, B:16:0x004d, B:70:0x0134, B:17:0x0052, B:64:0x0119, B:18:0x0057, B:61:0x010d, B:19:0x005c, B:55:0x00f2, B:20:0x0061, B:52:0x00e7, B:21:0x0066, B:49:0x00da, B:22:0x006b, B:46:0x00d0, B:23:0x006f, B:40:0x00b6, B:24:0x0073, B:37:0x00ab, B:34:0x009f), top: B:140:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:97:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:99:0x01ac  */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01b5, code lost:
    
        if (kotlinx.coroutines.AwaitKt.delay(50, r13) == r8) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02a8, code lost:
    
        if (com.metrolist.music.utils.UtilsKt.safeDataStoreEdit(r14, r4, r13) == r7) goto L138;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object objWithContext;
        Object objWithContext2;
        Object objWithContext3;
        Object objWithContext4;
        Object objWithContext5;
        byte b = 2;
        byte b2 = 1;
        Continuation continuation = null;
        byte b3 = 0;
        switch (this.$r8$classId) {
            case 0:
                Unit unit = Unit.INSTANCE;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                byte b4 = this.label;
                if (b4 != 0) {
                    if (b4 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (b4 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                SyncUtils syncUtils = this.this$0;
                this.label = (byte) 1;
                int i = SyncUtils.$r8$clinit;
                obj = syncUtils.isLoggedIn(this);
                if (obj != coroutineSingletons) {
                }
                return coroutineSingletons;
                if (((Boolean) obj).booleanValue()) {
                    if (((Boolean) AwaitKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new ContextExtKt$isSyncEnabled$1(this.this$0.context, continuation, b3))).booleanValue()) {
                        Object systemService = this.this$0.context.getSystemService("connectivity");
                        systemService.getClass();
                        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                        if (networkCapabilities != null ? networkCapabilities.hasCapability(12) : false) {
                            long jMax = Math.max(((Number) UtilsKt.get(UtilsKt.getDataStore(this.this$0.context), PreferenceKeysKt.LastFullSyncKey, new Long(0L))).longValue(), this.this$0.cachedLastSyncEpoch);
                            LocalDateTime localDateTimeNow = LocalDateTime.now();
                            ZoneOffset zoneOffset = ZoneOffset.UTC;
                            long epochSecond = localDateTimeNow.toEpochSecond(zoneOffset);
                            if (jMax <= 0 || epochSecond - jMax >= 1800) {
                                this.this$0.enqueue(SyncOperation.FullSync.INSTANCE);
                                long epochSecond2 = LocalDateTime.now().toEpochSecond(zoneOffset);
                                this.this$0.cachedLastSyncEpoch = epochSecond2;
                                Context context = this.this$0.context;
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(epochSecond2, continuation, b3);
                                this.label = (byte) 2;
                            }
                        }
                    }
                    break;
                } else {
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                }
                return unit;
            default:
                Unit unit2 = Unit.INSTANCE;
                SyncUtils syncUtils2 = this.this$0;
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                try {
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            this.label = (byte) 1;
                            int i2 = SyncUtils.$r8$clinit;
                            obj = syncUtils2.isLoggedIn(this);
                            if (obj != coroutineSingletons2) {
                                if (!((Boolean) obj).booleanValue()) {
                                    this.label = (byte) 2;
                                    int i3 = SyncUtils.$r8$clinit;
                                    if (syncUtils2.executeSyncLikedSongs(this) == coroutineSingletons2) {
                                        this.label = (byte) 3;
                                        if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                            this.label = (byte) 4;
                                            int i4 = SyncUtils.$r8$clinit;
                                            DefaultScheduler defaultScheduler = Dispatchers.Default;
                                            objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new MutatorMutex.AnonymousClass2(syncUtils2, (Continuation) null, (byte) 5), this);
                                            if (objWithContext == coroutineSingletons2) {
                                                objWithContext = unit2;
                                            }
                                            if (objWithContext == coroutineSingletons2) {
                                                this.label = (byte) 5;
                                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                    this.label = (byte) 6;
                                                    int i5 = SyncUtils.$r8$clinit;
                                                    if (syncUtils2.executeSyncUploadedSongs(this) == coroutineSingletons2) {
                                                        this.label = (byte) 7;
                                                        if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                            this.label = (byte) 8;
                                                            int i6 = SyncUtils.$r8$clinit;
                                                            DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                                                            objWithContext2 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncPlaylist$2(syncUtils2, continuation, b), this);
                                                            if (objWithContext2 == coroutineSingletons2) {
                                                                objWithContext2 = unit2;
                                                            }
                                                            if (objWithContext2 == coroutineSingletons2) {
                                                                this.label = (byte) 9;
                                                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                    this.label = (byte) 10;
                                                                    int i7 = SyncUtils.$r8$clinit;
                                                                    DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                                                                    objWithContext3 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b2), this);
                                                                    if (objWithContext3 == coroutineSingletons2) {
                                                                        objWithContext3 = unit2;
                                                                    }
                                                                    if (objWithContext3 == coroutineSingletons2) {
                                                                        this.label = (byte) 11;
                                                                        if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                            this.label = (byte) 12;
                                                                            int i8 = SyncUtils.$r8$clinit;
                                                                            DefaultScheduler defaultScheduler4 = Dispatchers.Default;
                                                                            objWithContext4 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new QuickJs.AnonymousClass3(syncUtils2, null), this);
                                                                            if (objWithContext4 == coroutineSingletons2) {
                                                                                objWithContext4 = unit2;
                                                                            }
                                                                            if (objWithContext4 == coroutineSingletons2) {
                                                                                this.label = (byte) 13;
                                                                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                                    this.label = (byte) 14;
                                                                                    int i9 = SyncUtils.$r8$clinit;
                                                                                    if (syncUtils2.executeSyncPodcastSubscriptions(this) == coroutineSingletons2) {
                                                                                        this.label = (byte) 15;
                                                                                        if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                                            this.label = (byte) 16;
                                                                                            int i10 = SyncUtils.$r8$clinit;
                                                                                            if (syncUtils2.executeSyncEpisodesForLater(this) == coroutineSingletons2) {
                                                                                                this.label = (byte) 17;
                                                                                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                                                    this.label = (byte) 18;
                                                                                                    int i11 = SyncUtils.$r8$clinit;
                                                                                                    DefaultScheduler defaultScheduler5 = Dispatchers.Default;
                                                                                                    objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b3), this);
                                                                                                    if (objWithContext5 == coroutineSingletons2) {
                                                                                                        objWithContext5 = unit2;
                                                                                                    }
                                                                                                    if (objWithContext5 == coroutineSingletons2) {
                                                                                                        this.label = (byte) 19;
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    Timber.Forest.getClass();
                                    ConnectionPool.w(new Object[0]);
                                }
                                return unit2;
                            }
                            return coroutineSingletons2;
                        case 1:
                            ResultKt.throwOnFailure(obj);
                            if (!((Boolean) obj).booleanValue()) {
                                this.label = (byte) 2;
                                int i12 = SyncUtils.$r8$clinit;
                                if (syncUtils2.executeSyncLikedSongs(this) == coroutineSingletons2) {
                                    this.label = (byte) 3;
                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                        this.label = (byte) 4;
                                        int i13 = SyncUtils.$r8$clinit;
                                        DefaultScheduler defaultScheduler6 = Dispatchers.Default;
                                        objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new MutatorMutex.AnonymousClass2(syncUtils2, (Continuation) null, (byte) 5), this);
                                        if (objWithContext == coroutineSingletons2) {
                                            objWithContext = unit2;
                                        }
                                        if (objWithContext == coroutineSingletons2) {
                                            this.label = (byte) 5;
                                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                this.label = (byte) 6;
                                                int i14 = SyncUtils.$r8$clinit;
                                                if (syncUtils2.executeSyncUploadedSongs(this) == coroutineSingletons2) {
                                                    this.label = (byte) 7;
                                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                        this.label = (byte) 8;
                                                        int i15 = SyncUtils.$r8$clinit;
                                                        DefaultScheduler defaultScheduler7 = Dispatchers.Default;
                                                        objWithContext2 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncPlaylist$2(syncUtils2, continuation, b), this);
                                                        if (objWithContext2 == coroutineSingletons2) {
                                                            objWithContext2 = unit2;
                                                        }
                                                        if (objWithContext2 == coroutineSingletons2) {
                                                            this.label = (byte) 9;
                                                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                this.label = (byte) 10;
                                                                int i16 = SyncUtils.$r8$clinit;
                                                                DefaultScheduler defaultScheduler8 = Dispatchers.Default;
                                                                objWithContext3 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b2), this);
                                                                if (objWithContext3 == coroutineSingletons2) {
                                                                    objWithContext3 = unit2;
                                                                }
                                                                if (objWithContext3 == coroutineSingletons2) {
                                                                    this.label = (byte) 11;
                                                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                        this.label = (byte) 12;
                                                                        int i17 = SyncUtils.$r8$clinit;
                                                                        DefaultScheduler defaultScheduler9 = Dispatchers.Default;
                                                                        objWithContext4 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new QuickJs.AnonymousClass3(syncUtils2, null), this);
                                                                        if (objWithContext4 == coroutineSingletons2) {
                                                                            objWithContext4 = unit2;
                                                                        }
                                                                        if (objWithContext4 == coroutineSingletons2) {
                                                                            this.label = (byte) 13;
                                                                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                                this.label = (byte) 14;
                                                                                int i18 = SyncUtils.$r8$clinit;
                                                                                if (syncUtils2.executeSyncPodcastSubscriptions(this) == coroutineSingletons2) {
                                                                                    this.label = (byte) 15;
                                                                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                                        this.label = (byte) 16;
                                                                                        int i19 = SyncUtils.$r8$clinit;
                                                                                        if (syncUtils2.executeSyncEpisodesForLater(this) == coroutineSingletons2) {
                                                                                            this.label = (byte) 17;
                                                                                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                                                this.label = (byte) 18;
                                                                                                int i110 = SyncUtils.$r8$clinit;
                                                                                                DefaultScheduler defaultScheduler10 = Dispatchers.Default;
                                                                                                objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b3), this);
                                                                                                if (objWithContext5 == coroutineSingletons2) {
                                                                                                    objWithContext5 = unit2;
                                                                                                }
                                                                                                if (objWithContext5 == coroutineSingletons2) {
                                                                                                    this.label = (byte) 19;
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                return coroutineSingletons2;
                            }
                            Timber.Forest.getClass();
                            ConnectionPool.w(new Object[0]);
                            return unit2;
                        case 2:
                            ResultKt.throwOnFailure(obj);
                            this.label = (byte) 3;
                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                this.label = (byte) 4;
                                int i111 = SyncUtils.$r8$clinit;
                                DefaultScheduler defaultScheduler11 = Dispatchers.Default;
                                objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new MutatorMutex.AnonymousClass2(syncUtils2, (Continuation) null, (byte) 5), this);
                                if (objWithContext == coroutineSingletons2) {
                                    objWithContext = unit2;
                                }
                                if (objWithContext == coroutineSingletons2) {
                                    this.label = (byte) 5;
                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                        this.label = (byte) 6;
                                        int i112 = SyncUtils.$r8$clinit;
                                        if (syncUtils2.executeSyncUploadedSongs(this) == coroutineSingletons2) {
                                            this.label = (byte) 7;
                                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                this.label = (byte) 8;
                                                int i113 = SyncUtils.$r8$clinit;
                                                DefaultScheduler defaultScheduler12 = Dispatchers.Default;
                                                objWithContext2 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncPlaylist$2(syncUtils2, continuation, b), this);
                                                if (objWithContext2 == coroutineSingletons2) {
                                                    objWithContext2 = unit2;
                                                }
                                                if (objWithContext2 == coroutineSingletons2) {
                                                    this.label = (byte) 9;
                                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                        this.label = (byte) 10;
                                                        int i114 = SyncUtils.$r8$clinit;
                                                        DefaultScheduler defaultScheduler13 = Dispatchers.Default;
                                                        objWithContext3 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b2), this);
                                                        if (objWithContext3 == coroutineSingletons2) {
                                                            objWithContext3 = unit2;
                                                        }
                                                        if (objWithContext3 == coroutineSingletons2) {
                                                            this.label = (byte) 11;
                                                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                this.label = (byte) 12;
                                                                int i115 = SyncUtils.$r8$clinit;
                                                                DefaultScheduler defaultScheduler14 = Dispatchers.Default;
                                                                objWithContext4 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new QuickJs.AnonymousClass3(syncUtils2, null), this);
                                                                if (objWithContext4 == coroutineSingletons2) {
                                                                    objWithContext4 = unit2;
                                                                }
                                                                if (objWithContext4 == coroutineSingletons2) {
                                                                    this.label = (byte) 13;
                                                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                        this.label = (byte) 14;
                                                                        int i116 = SyncUtils.$r8$clinit;
                                                                        if (syncUtils2.executeSyncPodcastSubscriptions(this) == coroutineSingletons2) {
                                                                            this.label = (byte) 15;
                                                                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                                this.label = (byte) 16;
                                                                                int i117 = SyncUtils.$r8$clinit;
                                                                                if (syncUtils2.executeSyncEpisodesForLater(this) == coroutineSingletons2) {
                                                                                    this.label = (byte) 17;
                                                                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                                        this.label = (byte) 18;
                                                                                        int i118 = SyncUtils.$r8$clinit;
                                                                                        DefaultScheduler defaultScheduler15 = Dispatchers.Default;
                                                                                        objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b3), this);
                                                                                        if (objWithContext5 == coroutineSingletons2) {
                                                                                            objWithContext5 = unit2;
                                                                                        }
                                                                                        if (objWithContext5 == coroutineSingletons2) {
                                                                                            this.label = (byte) 19;
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return coroutineSingletons2;
                        case 3:
                            ResultKt.throwOnFailure(obj);
                            this.label = (byte) 4;
                            int i119 = SyncUtils.$r8$clinit;
                            DefaultScheduler defaultScheduler16 = Dispatchers.Default;
                            objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new MutatorMutex.AnonymousClass2(syncUtils2, (Continuation) null, (byte) 5), this);
                            if (objWithContext == coroutineSingletons2) {
                                objWithContext = unit2;
                            }
                            if (objWithContext == coroutineSingletons2) {
                                this.label = (byte) 5;
                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                    this.label = (byte) 6;
                                    int i1110 = SyncUtils.$r8$clinit;
                                    if (syncUtils2.executeSyncUploadedSongs(this) == coroutineSingletons2) {
                                        this.label = (byte) 7;
                                        if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                            this.label = (byte) 8;
                                            int i1111 = SyncUtils.$r8$clinit;
                                            DefaultScheduler defaultScheduler17 = Dispatchers.Default;
                                            objWithContext2 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncPlaylist$2(syncUtils2, continuation, b), this);
                                            if (objWithContext2 == coroutineSingletons2) {
                                                objWithContext2 = unit2;
                                            }
                                            if (objWithContext2 == coroutineSingletons2) {
                                                this.label = (byte) 9;
                                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                    this.label = (byte) 10;
                                                    int i1112 = SyncUtils.$r8$clinit;
                                                    DefaultScheduler defaultScheduler18 = Dispatchers.Default;
                                                    objWithContext3 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b2), this);
                                                    if (objWithContext3 == coroutineSingletons2) {
                                                        objWithContext3 = unit2;
                                                    }
                                                    if (objWithContext3 == coroutineSingletons2) {
                                                        this.label = (byte) 11;
                                                        if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                            this.label = (byte) 12;
                                                            int i1113 = SyncUtils.$r8$clinit;
                                                            DefaultScheduler defaultScheduler19 = Dispatchers.Default;
                                                            objWithContext4 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new QuickJs.AnonymousClass3(syncUtils2, null), this);
                                                            if (objWithContext4 == coroutineSingletons2) {
                                                                objWithContext4 = unit2;
                                                            }
                                                            if (objWithContext4 == coroutineSingletons2) {
                                                                this.label = (byte) 13;
                                                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                    this.label = (byte) 14;
                                                                    int i1114 = SyncUtils.$r8$clinit;
                                                                    if (syncUtils2.executeSyncPodcastSubscriptions(this) == coroutineSingletons2) {
                                                                        this.label = (byte) 15;
                                                                        if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                            this.label = (byte) 16;
                                                                            int i1115 = SyncUtils.$r8$clinit;
                                                                            if (syncUtils2.executeSyncEpisodesForLater(this) == coroutineSingletons2) {
                                                                                this.label = (byte) 17;
                                                                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                                    this.label = (byte) 18;
                                                                                    int i1116 = SyncUtils.$r8$clinit;
                                                                                    DefaultScheduler defaultScheduler110 = Dispatchers.Default;
                                                                                    objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b3), this);
                                                                                    if (objWithContext5 == coroutineSingletons2) {
                                                                                        objWithContext5 = unit2;
                                                                                    }
                                                                                    if (objWithContext5 == coroutineSingletons2) {
                                                                                        this.label = (byte) 19;
                                                                                        break;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return coroutineSingletons2;
                        case 4:
                            ResultKt.throwOnFailure(obj);
                            this.label = (byte) 5;
                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                this.label = (byte) 6;
                                int i1117 = SyncUtils.$r8$clinit;
                                if (syncUtils2.executeSyncUploadedSongs(this) == coroutineSingletons2) {
                                    this.label = (byte) 7;
                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                        this.label = (byte) 8;
                                        int i1118 = SyncUtils.$r8$clinit;
                                        DefaultScheduler defaultScheduler111 = Dispatchers.Default;
                                        objWithContext2 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncPlaylist$2(syncUtils2, continuation, b), this);
                                        if (objWithContext2 == coroutineSingletons2) {
                                            objWithContext2 = unit2;
                                        }
                                        if (objWithContext2 == coroutineSingletons2) {
                                            this.label = (byte) 9;
                                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                this.label = (byte) 10;
                                                int i1119 = SyncUtils.$r8$clinit;
                                                DefaultScheduler defaultScheduler112 = Dispatchers.Default;
                                                objWithContext3 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b2), this);
                                                if (objWithContext3 == coroutineSingletons2) {
                                                    objWithContext3 = unit2;
                                                }
                                                if (objWithContext3 == coroutineSingletons2) {
                                                    this.label = (byte) 11;
                                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                        this.label = (byte) 12;
                                                        int i11110 = SyncUtils.$r8$clinit;
                                                        DefaultScheduler defaultScheduler113 = Dispatchers.Default;
                                                        objWithContext4 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new QuickJs.AnonymousClass3(syncUtils2, null), this);
                                                        if (objWithContext4 == coroutineSingletons2) {
                                                            objWithContext4 = unit2;
                                                        }
                                                        if (objWithContext4 == coroutineSingletons2) {
                                                            this.label = (byte) 13;
                                                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                this.label = (byte) 14;
                                                                int i11111 = SyncUtils.$r8$clinit;
                                                                if (syncUtils2.executeSyncPodcastSubscriptions(this) == coroutineSingletons2) {
                                                                    this.label = (byte) 15;
                                                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                        this.label = (byte) 16;
                                                                        int i11112 = SyncUtils.$r8$clinit;
                                                                        if (syncUtils2.executeSyncEpisodesForLater(this) == coroutineSingletons2) {
                                                                            this.label = (byte) 17;
                                                                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                                this.label = (byte) 18;
                                                                                int i11113 = SyncUtils.$r8$clinit;
                                                                                DefaultScheduler defaultScheduler114 = Dispatchers.Default;
                                                                                objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b3), this);
                                                                                if (objWithContext5 == coroutineSingletons2) {
                                                                                    objWithContext5 = unit2;
                                                                                }
                                                                                if (objWithContext5 == coroutineSingletons2) {
                                                                                    this.label = (byte) 19;
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return coroutineSingletons2;
                        case 5:
                            ResultKt.throwOnFailure(obj);
                            this.label = (byte) 6;
                            int i11114 = SyncUtils.$r8$clinit;
                            if (syncUtils2.executeSyncUploadedSongs(this) == coroutineSingletons2) {
                                this.label = (byte) 7;
                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                    this.label = (byte) 8;
                                    int i11115 = SyncUtils.$r8$clinit;
                                    DefaultScheduler defaultScheduler115 = Dispatchers.Default;
                                    objWithContext2 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncPlaylist$2(syncUtils2, continuation, b), this);
                                    if (objWithContext2 == coroutineSingletons2) {
                                        objWithContext2 = unit2;
                                    }
                                    if (objWithContext2 == coroutineSingletons2) {
                                        this.label = (byte) 9;
                                        if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                            this.label = (byte) 10;
                                            int i11116 = SyncUtils.$r8$clinit;
                                            DefaultScheduler defaultScheduler116 = Dispatchers.Default;
                                            objWithContext3 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b2), this);
                                            if (objWithContext3 == coroutineSingletons2) {
                                                objWithContext3 = unit2;
                                            }
                                            if (objWithContext3 == coroutineSingletons2) {
                                                this.label = (byte) 11;
                                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                    this.label = (byte) 12;
                                                    int i11117 = SyncUtils.$r8$clinit;
                                                    DefaultScheduler defaultScheduler117 = Dispatchers.Default;
                                                    objWithContext4 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new QuickJs.AnonymousClass3(syncUtils2, null), this);
                                                    if (objWithContext4 == coroutineSingletons2) {
                                                        objWithContext4 = unit2;
                                                    }
                                                    if (objWithContext4 == coroutineSingletons2) {
                                                        this.label = (byte) 13;
                                                        if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                            this.label = (byte) 14;
                                                            int i11118 = SyncUtils.$r8$clinit;
                                                            if (syncUtils2.executeSyncPodcastSubscriptions(this) == coroutineSingletons2) {
                                                                this.label = (byte) 15;
                                                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                    this.label = (byte) 16;
                                                                    int i11119 = SyncUtils.$r8$clinit;
                                                                    if (syncUtils2.executeSyncEpisodesForLater(this) == coroutineSingletons2) {
                                                                        this.label = (byte) 17;
                                                                        if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                            this.label = (byte) 18;
                                                                            int i111110 = SyncUtils.$r8$clinit;
                                                                            DefaultScheduler defaultScheduler118 = Dispatchers.Default;
                                                                            objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b3), this);
                                                                            if (objWithContext5 == coroutineSingletons2) {
                                                                                objWithContext5 = unit2;
                                                                            }
                                                                            if (objWithContext5 == coroutineSingletons2) {
                                                                                this.label = (byte) 19;
                                                                                break;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return coroutineSingletons2;
                        case 6:
                            ResultKt.throwOnFailure(obj);
                            this.label = (byte) 7;
                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                this.label = (byte) 8;
                                int i111111 = SyncUtils.$r8$clinit;
                                DefaultScheduler defaultScheduler119 = Dispatchers.Default;
                                objWithContext2 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncPlaylist$2(syncUtils2, continuation, b), this);
                                if (objWithContext2 == coroutineSingletons2) {
                                    objWithContext2 = unit2;
                                }
                                if (objWithContext2 == coroutineSingletons2) {
                                    this.label = (byte) 9;
                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                        this.label = (byte) 10;
                                        int i111112 = SyncUtils.$r8$clinit;
                                        DefaultScheduler defaultScheduler1110 = Dispatchers.Default;
                                        objWithContext3 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b2), this);
                                        if (objWithContext3 == coroutineSingletons2) {
                                            objWithContext3 = unit2;
                                        }
                                        if (objWithContext3 == coroutineSingletons2) {
                                            this.label = (byte) 11;
                                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                this.label = (byte) 12;
                                                int i111113 = SyncUtils.$r8$clinit;
                                                DefaultScheduler defaultScheduler1111 = Dispatchers.Default;
                                                objWithContext4 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new QuickJs.AnonymousClass3(syncUtils2, null), this);
                                                if (objWithContext4 == coroutineSingletons2) {
                                                    objWithContext4 = unit2;
                                                }
                                                if (objWithContext4 == coroutineSingletons2) {
                                                    this.label = (byte) 13;
                                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                        this.label = (byte) 14;
                                                        int i111114 = SyncUtils.$r8$clinit;
                                                        if (syncUtils2.executeSyncPodcastSubscriptions(this) == coroutineSingletons2) {
                                                            this.label = (byte) 15;
                                                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                this.label = (byte) 16;
                                                                int i111115 = SyncUtils.$r8$clinit;
                                                                if (syncUtils2.executeSyncEpisodesForLater(this) == coroutineSingletons2) {
                                                                    this.label = (byte) 17;
                                                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                        this.label = (byte) 18;
                                                                        int i111116 = SyncUtils.$r8$clinit;
                                                                        DefaultScheduler defaultScheduler1112 = Dispatchers.Default;
                                                                        objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b3), this);
                                                                        if (objWithContext5 == coroutineSingletons2) {
                                                                            objWithContext5 = unit2;
                                                                        }
                                                                        if (objWithContext5 == coroutineSingletons2) {
                                                                            this.label = (byte) 19;
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return coroutineSingletons2;
                        case 7:
                            ResultKt.throwOnFailure(obj);
                            this.label = (byte) 8;
                            int i111117 = SyncUtils.$r8$clinit;
                            DefaultScheduler defaultScheduler1113 = Dispatchers.Default;
                            objWithContext2 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncPlaylist$2(syncUtils2, continuation, b), this);
                            if (objWithContext2 == coroutineSingletons2) {
                                objWithContext2 = unit2;
                            }
                            if (objWithContext2 == coroutineSingletons2) {
                                this.label = (byte) 9;
                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                    this.label = (byte) 10;
                                    int i111118 = SyncUtils.$r8$clinit;
                                    DefaultScheduler defaultScheduler1114 = Dispatchers.Default;
                                    objWithContext3 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b2), this);
                                    if (objWithContext3 == coroutineSingletons2) {
                                        objWithContext3 = unit2;
                                    }
                                    if (objWithContext3 == coroutineSingletons2) {
                                        this.label = (byte) 11;
                                        if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                            this.label = (byte) 12;
                                            int i111119 = SyncUtils.$r8$clinit;
                                            DefaultScheduler defaultScheduler1115 = Dispatchers.Default;
                                            objWithContext4 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new QuickJs.AnonymousClass3(syncUtils2, null), this);
                                            if (objWithContext4 == coroutineSingletons2) {
                                                objWithContext4 = unit2;
                                            }
                                            if (objWithContext4 == coroutineSingletons2) {
                                                this.label = (byte) 13;
                                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                    this.label = (byte) 14;
                                                    int i1111110 = SyncUtils.$r8$clinit;
                                                    if (syncUtils2.executeSyncPodcastSubscriptions(this) == coroutineSingletons2) {
                                                        this.label = (byte) 15;
                                                        if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                            this.label = (byte) 16;
                                                            int i1111111 = SyncUtils.$r8$clinit;
                                                            if (syncUtils2.executeSyncEpisodesForLater(this) == coroutineSingletons2) {
                                                                this.label = (byte) 17;
                                                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                    this.label = (byte) 18;
                                                                    int i1111112 = SyncUtils.$r8$clinit;
                                                                    DefaultScheduler defaultScheduler1116 = Dispatchers.Default;
                                                                    objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b3), this);
                                                                    if (objWithContext5 == coroutineSingletons2) {
                                                                        objWithContext5 = unit2;
                                                                    }
                                                                    if (objWithContext5 == coroutineSingletons2) {
                                                                        this.label = (byte) 19;
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return coroutineSingletons2;
                        case 8:
                            ResultKt.throwOnFailure(obj);
                            this.label = (byte) 9;
                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                this.label = (byte) 10;
                                int i1111113 = SyncUtils.$r8$clinit;
                                DefaultScheduler defaultScheduler1117 = Dispatchers.Default;
                                objWithContext3 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b2), this);
                                if (objWithContext3 == coroutineSingletons2) {
                                    objWithContext3 = unit2;
                                }
                                if (objWithContext3 == coroutineSingletons2) {
                                    this.label = (byte) 11;
                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                        this.label = (byte) 12;
                                        int i1111114 = SyncUtils.$r8$clinit;
                                        DefaultScheduler defaultScheduler1118 = Dispatchers.Default;
                                        objWithContext4 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new QuickJs.AnonymousClass3(syncUtils2, null), this);
                                        if (objWithContext4 == coroutineSingletons2) {
                                            objWithContext4 = unit2;
                                        }
                                        if (objWithContext4 == coroutineSingletons2) {
                                            this.label = (byte) 13;
                                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                this.label = (byte) 14;
                                                int i1111115 = SyncUtils.$r8$clinit;
                                                if (syncUtils2.executeSyncPodcastSubscriptions(this) == coroutineSingletons2) {
                                                    this.label = (byte) 15;
                                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                        this.label = (byte) 16;
                                                        int i1111116 = SyncUtils.$r8$clinit;
                                                        if (syncUtils2.executeSyncEpisodesForLater(this) == coroutineSingletons2) {
                                                            this.label = (byte) 17;
                                                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                                this.label = (byte) 18;
                                                                int i1111117 = SyncUtils.$r8$clinit;
                                                                DefaultScheduler defaultScheduler1119 = Dispatchers.Default;
                                                                objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b3), this);
                                                                if (objWithContext5 == coroutineSingletons2) {
                                                                    objWithContext5 = unit2;
                                                                }
                                                                if (objWithContext5 == coroutineSingletons2) {
                                                                    this.label = (byte) 19;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return coroutineSingletons2;
                        case 9:
                            ResultKt.throwOnFailure(obj);
                            this.label = (byte) 10;
                            int i1111118 = SyncUtils.$r8$clinit;
                            DefaultScheduler defaultScheduler11110 = Dispatchers.Default;
                            objWithContext3 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b2), this);
                            if (objWithContext3 == coroutineSingletons2) {
                                objWithContext3 = unit2;
                            }
                            if (objWithContext3 == coroutineSingletons2) {
                                this.label = (byte) 11;
                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                    this.label = (byte) 12;
                                    int i1111119 = SyncUtils.$r8$clinit;
                                    DefaultScheduler defaultScheduler11111 = Dispatchers.Default;
                                    objWithContext4 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new QuickJs.AnonymousClass3(syncUtils2, null), this);
                                    if (objWithContext4 == coroutineSingletons2) {
                                        objWithContext4 = unit2;
                                    }
                                    if (objWithContext4 == coroutineSingletons2) {
                                        this.label = (byte) 13;
                                        if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                            this.label = (byte) 14;
                                            int i11111110 = SyncUtils.$r8$clinit;
                                            if (syncUtils2.executeSyncPodcastSubscriptions(this) == coroutineSingletons2) {
                                                this.label = (byte) 15;
                                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                    this.label = (byte) 16;
                                                    int i11111111 = SyncUtils.$r8$clinit;
                                                    if (syncUtils2.executeSyncEpisodesForLater(this) == coroutineSingletons2) {
                                                        this.label = (byte) 17;
                                                        if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                            this.label = (byte) 18;
                                                            int i11111112 = SyncUtils.$r8$clinit;
                                                            DefaultScheduler defaultScheduler11112 = Dispatchers.Default;
                                                            objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b3), this);
                                                            if (objWithContext5 == coroutineSingletons2) {
                                                                objWithContext5 = unit2;
                                                            }
                                                            if (objWithContext5 == coroutineSingletons2) {
                                                                this.label = (byte) 19;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return coroutineSingletons2;
                        case 10:
                            ResultKt.throwOnFailure(obj);
                            this.label = (byte) 11;
                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                this.label = (byte) 12;
                                int i11111113 = SyncUtils.$r8$clinit;
                                DefaultScheduler defaultScheduler11113 = Dispatchers.Default;
                                objWithContext4 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new QuickJs.AnonymousClass3(syncUtils2, null), this);
                                if (objWithContext4 == coroutineSingletons2) {
                                    objWithContext4 = unit2;
                                }
                                if (objWithContext4 == coroutineSingletons2) {
                                    this.label = (byte) 13;
                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                        this.label = (byte) 14;
                                        int i11111114 = SyncUtils.$r8$clinit;
                                        if (syncUtils2.executeSyncPodcastSubscriptions(this) == coroutineSingletons2) {
                                            this.label = (byte) 15;
                                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                this.label = (byte) 16;
                                                int i11111115 = SyncUtils.$r8$clinit;
                                                if (syncUtils2.executeSyncEpisodesForLater(this) == coroutineSingletons2) {
                                                    this.label = (byte) 17;
                                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                        this.label = (byte) 18;
                                                        int i11111116 = SyncUtils.$r8$clinit;
                                                        DefaultScheduler defaultScheduler11114 = Dispatchers.Default;
                                                        objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b3), this);
                                                        if (objWithContext5 == coroutineSingletons2) {
                                                            objWithContext5 = unit2;
                                                        }
                                                        if (objWithContext5 == coroutineSingletons2) {
                                                            this.label = (byte) 19;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return coroutineSingletons2;
                        case 11:
                            ResultKt.throwOnFailure(obj);
                            this.label = (byte) 12;
                            int i11111117 = SyncUtils.$r8$clinit;
                            DefaultScheduler defaultScheduler11115 = Dispatchers.Default;
                            objWithContext4 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new QuickJs.AnonymousClass3(syncUtils2, null), this);
                            if (objWithContext4 == coroutineSingletons2) {
                                objWithContext4 = unit2;
                            }
                            if (objWithContext4 == coroutineSingletons2) {
                                this.label = (byte) 13;
                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                    this.label = (byte) 14;
                                    int i11111118 = SyncUtils.$r8$clinit;
                                    if (syncUtils2.executeSyncPodcastSubscriptions(this) == coroutineSingletons2) {
                                        this.label = (byte) 15;
                                        if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                            this.label = (byte) 16;
                                            int i11111119 = SyncUtils.$r8$clinit;
                                            if (syncUtils2.executeSyncEpisodesForLater(this) == coroutineSingletons2) {
                                                this.label = (byte) 17;
                                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                    this.label = (byte) 18;
                                                    int i111111110 = SyncUtils.$r8$clinit;
                                                    DefaultScheduler defaultScheduler11116 = Dispatchers.Default;
                                                    objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b3), this);
                                                    if (objWithContext5 == coroutineSingletons2) {
                                                        objWithContext5 = unit2;
                                                    }
                                                    if (objWithContext5 == coroutineSingletons2) {
                                                        this.label = (byte) 19;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return coroutineSingletons2;
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                            ResultKt.throwOnFailure(obj);
                            this.label = (byte) 13;
                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                this.label = (byte) 14;
                                int i111111111 = SyncUtils.$r8$clinit;
                                if (syncUtils2.executeSyncPodcastSubscriptions(this) == coroutineSingletons2) {
                                    this.label = (byte) 15;
                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                        this.label = (byte) 16;
                                        int i111111112 = SyncUtils.$r8$clinit;
                                        if (syncUtils2.executeSyncEpisodesForLater(this) == coroutineSingletons2) {
                                            this.label = (byte) 17;
                                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                                this.label = (byte) 18;
                                                int i111111113 = SyncUtils.$r8$clinit;
                                                DefaultScheduler defaultScheduler11117 = Dispatchers.Default;
                                                objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b3), this);
                                                if (objWithContext5 == coroutineSingletons2) {
                                                    objWithContext5 = unit2;
                                                }
                                                if (objWithContext5 == coroutineSingletons2) {
                                                    this.label = (byte) 19;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return coroutineSingletons2;
                        case 13:
                            ResultKt.throwOnFailure(obj);
                            this.label = (byte) 14;
                            int i111111114 = SyncUtils.$r8$clinit;
                            if (syncUtils2.executeSyncPodcastSubscriptions(this) == coroutineSingletons2) {
                                this.label = (byte) 15;
                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                    this.label = (byte) 16;
                                    int i111111115 = SyncUtils.$r8$clinit;
                                    if (syncUtils2.executeSyncEpisodesForLater(this) == coroutineSingletons2) {
                                        this.label = (byte) 17;
                                        if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                            this.label = (byte) 18;
                                            int i111111116 = SyncUtils.$r8$clinit;
                                            DefaultScheduler defaultScheduler11118 = Dispatchers.Default;
                                            objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b3), this);
                                            if (objWithContext5 == coroutineSingletons2) {
                                                objWithContext5 = unit2;
                                            }
                                            if (objWithContext5 == coroutineSingletons2) {
                                                this.label = (byte) 19;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            return coroutineSingletons2;
                        case 14:
                            ResultKt.throwOnFailure(obj);
                            this.label = (byte) 15;
                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                this.label = (byte) 16;
                                int i111111117 = SyncUtils.$r8$clinit;
                                if (syncUtils2.executeSyncEpisodesForLater(this) == coroutineSingletons2) {
                                    this.label = (byte) 17;
                                    if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                        this.label = (byte) 18;
                                        int i111111118 = SyncUtils.$r8$clinit;
                                        DefaultScheduler defaultScheduler11119 = Dispatchers.Default;
                                        objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b3), this);
                                        if (objWithContext5 == coroutineSingletons2) {
                                            objWithContext5 = unit2;
                                        }
                                        if (objWithContext5 == coroutineSingletons2) {
                                            this.label = (byte) 19;
                                            break;
                                        }
                                    }
                                }
                            }
                            return coroutineSingletons2;
                        case 15:
                            ResultKt.throwOnFailure(obj);
                            this.label = (byte) 16;
                            int i111111119 = SyncUtils.$r8$clinit;
                            if (syncUtils2.executeSyncEpisodesForLater(this) == coroutineSingletons2) {
                                this.label = (byte) 17;
                                if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                    this.label = (byte) 18;
                                    int i1111111110 = SyncUtils.$r8$clinit;
                                    DefaultScheduler defaultScheduler111110 = Dispatchers.Default;
                                    objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b3), this);
                                    if (objWithContext5 == coroutineSingletons2) {
                                        objWithContext5 = unit2;
                                    }
                                    if (objWithContext5 == coroutineSingletons2) {
                                        this.label = (byte) 19;
                                        break;
                                    }
                                }
                            }
                            return coroutineSingletons2;
                        case 16:
                            ResultKt.throwOnFailure(obj);
                            this.label = (byte) 17;
                            if (AwaitKt.delay(50L, this) != coroutineSingletons2) {
                                this.label = (byte) 18;
                                int i1111111111 = SyncUtils.$r8$clinit;
                                DefaultScheduler defaultScheduler111111 = Dispatchers.Default;
                                objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b3), this);
                                if (objWithContext5 == coroutineSingletons2) {
                                    objWithContext5 = unit2;
                                }
                                if (objWithContext5 == coroutineSingletons2) {
                                    this.label = (byte) 19;
                                    break;
                                }
                            }
                            return coroutineSingletons2;
                        case 17:
                            ResultKt.throwOnFailure(obj);
                            this.label = (byte) 18;
                            int i1111111112 = SyncUtils.$r8$clinit;
                            DefaultScheduler defaultScheduler111112 = Dispatchers.Default;
                            objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(syncUtils2, continuation, b3), this);
                            if (objWithContext5 == coroutineSingletons2) {
                                objWithContext5 = unit2;
                            }
                            if (objWithContext5 == coroutineSingletons2) {
                                this.label = (byte) 19;
                                break;
                            }
                            return coroutineSingletons2;
                        case 18:
                            ResultKt.throwOnFailure(obj);
                            this.label = (byte) 19;
                            break;
                        case 19:
                            ResultKt.throwOnFailure(obj);
                            Timber.Forest.getClass();
                            ConnectionPool.d(new Object[0]);
                            return unit2;
                        default:
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                    }
                } catch (CancellationException e) {
                    throw e;
                } catch (Exception unused) {
                    Timber.Forest.getClass();
                    ConnectionPool.e$1(new Object[0]);
                }
                break;
        }
    }
}
