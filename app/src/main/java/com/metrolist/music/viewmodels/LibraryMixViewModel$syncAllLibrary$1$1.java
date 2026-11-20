package com.metrolist.music.viewmodels;

import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$tryAutoSync$1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LibraryMixViewModel$syncAllLibrary$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ LibraryMixViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LibraryMixViewModel$syncAllLibrary$1$1(LibraryMixViewModel libraryMixViewModel, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = libraryMixViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        LibraryMixViewModel libraryMixViewModel = this.this$0;
        switch (b) {
            case 0:
                return new LibraryMixViewModel$syncAllLibrary$1$1(libraryMixViewModel, continuation, (byte) 0);
            default:
                return new LibraryMixViewModel$syncAllLibrary$1$1(libraryMixViewModel, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Exception {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                ((LibraryMixViewModel$syncAllLibrary$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((LibraryMixViewModel$syncAllLibrary$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        LibraryMixViewModel libraryMixViewModel = this.this$0;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                SyncUtils syncUtils = libraryMixViewModel.syncUtils;
                AwaitKt.launch$default(syncUtils.syncScope, null, null, new SyncUtils$tryAutoSync$1(syncUtils, null, (byte) 0), 3);
                break;
            default:
                ResultKt.throwOnFailure(obj);
                libraryMixViewModel.syncAllLibrary.invoke();
                break;
        }
        return unit;
    }
}
