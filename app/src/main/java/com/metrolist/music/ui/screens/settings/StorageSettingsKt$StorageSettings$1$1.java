package com.metrolist.music.ui.screens.settings;

import androidx.media3.datasource.cache.SimpleCache;
import coil3.SingletonImageLoader;
import coil3.disk.RealDiskCache;
import com.metrolist.music.utils.SyncUtils;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StorageSettingsKt$StorageSettings$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ Object $imageDiskCache;
    public final /* synthetic */ int $maxImageCacheSize;
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StorageSettingsKt$StorageSettings$1$1(int i, CoroutineScope coroutineScope, Object obj, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$maxImageCacheSize = i;
        this.$coroutineScope = coroutineScope;
        this.$imageDiskCache = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$imageDiskCache;
        switch (b) {
            case 0:
                return new StorageSettingsKt$StorageSettings$1$1(this.$maxImageCacheSize, this.$coroutineScope, (RealDiskCache) obj2, continuation, (byte) 0);
            default:
                return new StorageSettingsKt$StorageSettings$1$1(this.$maxImageCacheSize, this.$coroutineScope, (SimpleCache) obj2, continuation, (byte) 1);
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
                ((StorageSettingsKt$StorageSettings$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((StorageSettingsKt$StorageSettings$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.$imageDiskCache;
        CoroutineScope coroutineScope = this.$coroutineScope;
        int i = this.$maxImageCacheSize;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                SingletonImageLoader.reference.set(null);
                if (i == 0) {
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new SyncUtils.AnonymousClass3((RealDiskCache) obj2, null, (byte) 13), 2);
                }
                break;
            default:
                ResultKt.throwOnFailure(obj);
                if (i == 0) {
                    DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                    AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new StorageSettingsKt$StorageSettings$2$1$1((SimpleCache) obj2, null, (byte) 0), 2);
                }
                break;
        }
        return unit;
    }
}
