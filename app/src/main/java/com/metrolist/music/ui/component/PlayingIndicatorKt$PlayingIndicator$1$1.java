package com.metrolist.music.ui.component;

import androidx.compose.animation.core.Animatable;
import androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1;
import androidx.datastore.core.FileStorageKt;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayingIndicatorKt$PlayingIndicator$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ List $animatables;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlayingIndicatorKt$PlayingIndicator$1$1(List list, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$animatables = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        List list = this.$animatables;
        switch (b) {
            case 0:
                PlayingIndicatorKt$PlayingIndicator$1$1 playingIndicatorKt$PlayingIndicator$1$1 = new PlayingIndicatorKt$PlayingIndicator$1$1(list, continuation, (byte) 0);
                playingIndicatorKt$PlayingIndicator$1$1.L$0 = obj;
                return playingIndicatorKt$PlayingIndicator$1$1;
            default:
                PlayingIndicatorKt$PlayingIndicator$1$1 playingIndicatorKt$PlayingIndicator$1$2 = new PlayingIndicatorKt$PlayingIndicator$1$1(list, continuation, (byte) 1);
                playingIndicatorKt$PlayingIndicator$1$2.L$0 = obj;
                return playingIndicatorKt$PlayingIndicator$1$2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((PlayingIndicatorKt$PlayingIndicator$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            default:
                return ((PlayingIndicatorKt$PlayingIndicator$1$1) create((DataStoreImpl$InitDataStore$doRun$initData$1$api$1) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        List list = this.$animatables;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = coroutineScope;
                    this.label = true;
                    if (AwaitKt.delay(300L, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    AwaitKt.launch$default(coroutineScope, null, null, new PlayingIndicatorKt$PlayingIndicator$1$1$1$1((Animatable) it.next(), null, (byte) 0), 3);
                }
                return unit;
            default:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    DataStoreImpl$InitDataStore$doRun$initData$1$api$1 dataStoreImpl$InitDataStore$doRun$initData$1$api$1 = (DataStoreImpl$InitDataStore$doRun$initData$1$api$1) this.L$0;
                    this.label = true;
                    return FileStorageKt.Companion.runMigrations(list, dataStoreImpl$InitDataStore$doRun$initData$1$api$1, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z2) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
