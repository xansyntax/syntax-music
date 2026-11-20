package com.metrolist.music.viewmodels;

import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import com.metrolist.music.utils.SyncOperation;
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
public final class LibraryPlaylistsViewModel$sync$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ LibraryPlaylistsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LibraryPlaylistsViewModel$sync$1(LibraryPlaylistsViewModel libraryPlaylistsViewModel, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = libraryPlaylistsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        LibraryPlaylistsViewModel libraryPlaylistsViewModel = this.this$0;
        switch (b) {
            case 0:
                return new LibraryPlaylistsViewModel$sync$1(libraryPlaylistsViewModel, continuation, (byte) 0);
            default:
                return new LibraryPlaylistsViewModel$sync$1(libraryPlaylistsViewModel, continuation, (byte) 1);
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
                ((LibraryPlaylistsViewModel$sync$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((LibraryPlaylistsViewModel$sync$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        LibraryPlaylistsViewModel libraryPlaylistsViewModel = this.this$0;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                libraryPlaylistsViewModel.syncUtils.enqueue(SyncOperation.SavedPlaylists.INSTANCE);
                break;
            default:
                ResultKt.throwOnFailure(obj);
                CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(libraryPlaylistsViewModel);
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new LibraryPlaylistsViewModel$sync$1(libraryPlaylistsViewModel, null, (byte) 0), 2);
                break;
        }
        return unit;
    }
}
