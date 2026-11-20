package com.metrolist.music.ui.screens.settings;

import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.media3.datasource.cache.SimpleCache;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StorageSettingsKt$StorageSettings$4$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ SimpleCache $playerCache;
    public final /* synthetic */ ParcelableSnapshotMutableLongState $playerCacheSize$delegate;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StorageSettingsKt$StorageSettings$4$1(SimpleCache simpleCache, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$playerCache = simpleCache;
        this.$playerCacheSize$delegate = parcelableSnapshotMutableLongState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = this.$playerCacheSize$delegate;
        SimpleCache simpleCache = this.$playerCache;
        switch (b) {
            case 0:
                StorageSettingsKt$StorageSettings$4$1 storageSettingsKt$StorageSettings$4$1 = new StorageSettingsKt$StorageSettings$4$1(simpleCache, parcelableSnapshotMutableLongState, continuation, (byte) 0);
                storageSettingsKt$StorageSettings$4$1.L$0 = obj;
                return storageSettingsKt$StorageSettings$4$1;
            default:
                StorageSettingsKt$StorageSettings$4$1 storageSettingsKt$StorageSettings$4$2 = new StorageSettingsKt$StorageSettings$4$1(simpleCache, parcelableSnapshotMutableLongState, continuation, (byte) 1);
                storageSettingsKt$StorageSettings$4$2.L$0 = obj;
                return storageSettingsKt$StorageSettings$4$2;
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
        return ((StorageSettingsKt$StorageSettings$4$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0070  */
    /* JADX WARN: Code duplicated, block: B:33:0x007a  */
    /* JADX WARN: Code duplicated, block: B:38:0x0088  */
    /* JADX WARN: Code duplicated, block: B:39:0x008d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0039 -> B:42:0x003d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0078 -> B:44:0x007c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            byte r0 = r14.$r8$classId
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r2 = 0
            androidx.media3.datasource.cache.SimpleCache r4 = r14.$playerCache
            androidx.compose.runtime.ParcelableSnapshotMutableLongState r5 = r14.$playerCacheSize$delegate
            r6 = 500(0x1f4, double:2.47E-321)
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            kotlin.coroutines.intrinsics.CoroutineSingletons r9 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            r10 = 1
            r11 = 0
            switch(r0) {
                case 0: goto L54;
                default: goto L15;
            }
        L15:
            java.lang.Object r0 = r14.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            boolean r12 = r14.label
            if (r12 == 0) goto L28
            if (r12 != r10) goto L23
            kotlin.ResultKt.throwOnFailure(r15)
            goto L3d
        L23:
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r8)
            r1 = r11
            goto L53
        L28:
            kotlin.ResultKt.throwOnFailure(r15)
        L2b:
            boolean r15 = kotlinx.coroutines.AwaitKt.isActive(r0)
            if (r15 == 0) goto L53
            r14.L$0 = r0
            r14.label = r10
            java.lang.Object r15 = kotlinx.coroutines.AwaitKt.delay(r6, r14)
            if (r15 != r9) goto L3d
            r1 = r9
            goto L53
        L3d:
            long r12 = r4.getCacheSpace()     // Catch: java.lang.Exception -> L46
            java.lang.Long r15 = java.lang.Long.valueOf(r12)     // Catch: java.lang.Exception -> L46
            goto L47
        L46:
            r15 = r11
        L47:
            if (r15 == 0) goto L4e
            long r12 = r15.longValue()
            goto L4f
        L4e:
            r12 = r2
        L4f:
            r5.setLongValue(r12)
            goto L2b
        L53:
            return r1
        L54:
            java.lang.Object r0 = r14.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            boolean r12 = r14.label
            if (r12 == 0) goto L67
            if (r12 != r10) goto L62
            kotlin.ResultKt.throwOnFailure(r15)
            goto L7c
        L62:
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r8)
            r1 = r11
            goto L92
        L67:
            kotlin.ResultKt.throwOnFailure(r15)
        L6a:
            boolean r15 = kotlinx.coroutines.AwaitKt.isActive(r0)
            if (r15 == 0) goto L92
            r14.L$0 = r0
            r14.label = r10
            java.lang.Object r15 = kotlinx.coroutines.AwaitKt.delay(r6, r14)
            if (r15 != r9) goto L7c
            r1 = r9
            goto L92
        L7c:
            long r12 = r4.getCacheSpace()     // Catch: java.lang.Exception -> L85
            java.lang.Long r15 = java.lang.Long.valueOf(r12)     // Catch: java.lang.Exception -> L85
            goto L86
        L85:
            r15 = r11
        L86:
            if (r15 == 0) goto L8d
            long r12 = r15.longValue()
            goto L8e
        L8d:
            r12 = r2
        L8e:
            r5.setLongValue(r12)
            goto L6a
        L92:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.screens.settings.StorageSettingsKt$StorageSettings$4$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
