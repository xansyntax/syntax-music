package com.metrolist.innertube;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.SemaphoreImpl;
import kotlinx.coroutines.sync.SemaphoreKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTube$resolveArtistIdMap$9 extends SuspendLambda implements Function2 {
    public final /* synthetic */ LinkedHashSet $missingNames;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ YouTube$resolveArtistIdMap$9(LinkedHashSet linkedHashSet, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$missingNames = linkedHashSet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        LinkedHashSet linkedHashSet = this.$missingNames;
        switch (b) {
            case 0:
                YouTube$resolveArtistIdMap$9 youTube$resolveArtistIdMap$9 = new YouTube$resolveArtistIdMap$9(linkedHashSet, continuation, (byte) 0);
                youTube$resolveArtistIdMap$9.L$0 = obj;
                return youTube$resolveArtistIdMap$9;
            default:
                YouTube$resolveArtistIdMap$9 youTube$resolveArtistIdMap$10 = new YouTube$resolveArtistIdMap$9(linkedHashSet, continuation, (byte) 1);
                youTube$resolveArtistIdMap$10.L$0 = obj;
                return youTube$resolveArtistIdMap$10;
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
        return ((YouTube$resolveArtistIdMap$9) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        LinkedHashSet linkedHashSet = this.$missingNames;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        byte b2 = 1;
        Continuation continuation = null;
        switch (b) {
            case 0:
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    int i = SemaphoreKt.MAX_SPIN_CYCLES;
                    SemaphoreImpl semaphoreImpl = new SemaphoreImpl(8);
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(linkedHashSet, 10));
                    Iterator it = linkedHashSet.iterator();
                    while (it.hasNext()) {
                        arrayList.add(AwaitKt.async$default(coroutineScope, null, new YouTube$resolveArtistIdMap$9$1$1(semaphoreImpl, (String) it.next(), continuation, (byte) 0), 3));
                    }
                    this.L$0 = null;
                    this.label = true;
                    obj = AwaitKt.awaitAll(arrayList, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return MapsKt__MapsKt.toMap(CollectionsKt.filterNotNull((Iterable) obj));
            default:
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    int i2 = SemaphoreKt.MAX_SPIN_CYCLES;
                    SemaphoreImpl semaphoreImpl2 = new SemaphoreImpl(8);
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(linkedHashSet, 10));
                    Iterator it2 = linkedHashSet.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(AwaitKt.async$default(coroutineScope2, null, new YouTube$resolveArtistIdMap$9$1$1(semaphoreImpl2, (String) it2.next(), continuation, b2), 3));
                    }
                    this.L$0 = null;
                    this.label = true;
                    obj = AwaitKt.awaitAll(arrayList2, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return MapsKt__MapsKt.toMap(CollectionsKt.filterNotNull((Iterable) obj));
        }
    }
}
