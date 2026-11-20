package com.metrolist.music.ui.screens.settings;

import androidx.media3.datasource.cache.SimpleCache;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StorageSettingsKt$StorageSettings$2$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ SimpleCache $playerCache;
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StorageSettingsKt$StorageSettings$2$1$1(SimpleCache simpleCache, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$playerCache = simpleCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        SimpleCache simpleCache = this.$playerCache;
        switch (b) {
            case 0:
                return new StorageSettingsKt$StorageSettings$2$1$1(simpleCache, continuation, (byte) 0);
            case 1:
                return new StorageSettingsKt$StorageSettings$2$1$1(simpleCache, continuation, (byte) 1);
            default:
                return new StorageSettingsKt$StorageSettings$2$1$1(simpleCache, continuation, (byte) 2);
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
                ((StorageSettingsKt$StorageSettings$2$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            case 1:
                ((StorageSettingsKt$StorageSettings$2$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((StorageSettingsKt$StorageSettings$2$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SimpleCache simpleCache = this.$playerCache;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Iterator it = simpleCache.getKeys().iterator();
                while (it.hasNext()) {
                    simpleCache.removeResource((String) it.next());
                }
                break;
            case 1:
                ResultKt.throwOnFailure(obj);
                Iterator it2 = simpleCache.getKeys().iterator();
                while (it2.hasNext()) {
                    simpleCache.removeResource((String) it2.next());
                }
                break;
            default:
                ResultKt.throwOnFailure(obj);
                Iterator it3 = simpleCache.getKeys().iterator();
                while (it3.hasNext()) {
                    simpleCache.removeResource((String) it3.next());
                }
                break;
        }
        return unit;
    }
}
