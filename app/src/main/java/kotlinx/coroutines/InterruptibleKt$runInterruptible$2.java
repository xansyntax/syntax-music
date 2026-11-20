package kotlinx.coroutines;

import _COROUTINE.ArtificialStackFramesUnsafe;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.core.view.DisplayCompat;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.base.Splitter;
import com.metrolist.innertube.YouTube;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.db.entities.RecognitionHistory;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.listentogether.ListenTogetherEvent;
import com.metrolist.music.ui.screens.HomeScreenKt;
import com.metrolist.music.ui.screens.playlist.PlaylistType;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.viewmodels.AutoPlaylistViewModel;
import com.metrolist.music.viewmodels.AutoPlaylistViewModel$syncLikedSongs$1;
import com.metrolist.music.viewmodels.CachedSongPartition;
import com.metrolist.music.viewmodels.LocalSearchViewModel;
import com.metrolist.music.viewmodels.OnlineSearchSuggestionViewModel;
import com.metrolist.music.viewmodels.OnlineSearchViewModel;
import com.metrolist.shazamkit.models.RecognitionResult;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import sun.misc.Unsafe;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InterruptibleKt$runInterruptible$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $block;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object L$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InterruptibleKt$runInterruptible$2(Object obj, Object obj2, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.L$0 = obj;
        this.$block = obj2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$block;
        switch (b) {
            case 0:
                InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2((ImageLoader$Builder$$ExternalSyntheticLambda1) obj2, continuation, (byte) 0);
                interruptibleKt$runInterruptible$2.L$0 = obj;
                return interruptibleKt$runInterruptible$2;
            case 1:
                return new InterruptibleKt$runInterruptible$2((MutableState) this.L$0, (ParcelableSnapshotMutableLongState) obj2, continuation, (byte) 1);
            case 2:
                return new InterruptibleKt$runInterruptible$2((LazyListState) this.L$0, (FocusOwner) obj2, continuation, (byte) 2);
            case 3:
                return new InterruptibleKt$runInterruptible$2((PlaylistType) this.L$0, (AutoPlaylistViewModel) obj2, continuation, (byte) 3);
            case 4:
                return new InterruptibleKt$runInterruptible$2((MusicDatabase) this.L$0, (RecognitionHistory) obj2, continuation, (byte) 4);
            case 5:
                return new InterruptibleKt$runInterruptible$2((MusicDatabase) this.L$0, (RecognitionResult) obj2, continuation, (byte) 5);
            case 6:
                return new InterruptibleKt$runInterruptible$2((Function1) this.L$0, (RecognitionResult) obj2, continuation, (byte) 6);
            case 7:
                return new InterruptibleKt$runInterruptible$2((LocalSearchViewModel) this.L$0, (String) obj2, continuation, (byte) 7);
            case 8:
                return new InterruptibleKt$runInterruptible$2((String) this.L$0, (MutableState) obj2, continuation, (byte) 8);
            case 9:
                return new InterruptibleKt$runInterruptible$2((OnlineSearchViewModel) this.L$0, (DataStoreKt$rememberPreference$1$1) obj2, continuation, (byte) 9);
            case 10:
                InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$3 = new InterruptibleKt$runInterruptible$2((OnlineSearchSuggestionViewModel) obj2, continuation, (byte) 10);
                interruptibleKt$runInterruptible$3.L$0 = obj;
                return interruptibleKt$runInterruptible$3;
            case 11:
                return new InterruptibleKt$runInterruptible$2((Context) this.L$0, (List) obj2, continuation, (byte) 11);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$4 = new InterruptibleKt$runInterruptible$2((Context) obj2, continuation, (byte) 12);
                interruptibleKt$runInterruptible$4.L$0 = obj;
                return interruptibleKt$runInterruptible$4;
            case 13:
                return new InterruptibleKt$runInterruptible$2((byte[]) this.L$0, (Splitter) obj2, continuation, (byte) 13);
            case 14:
                return new InterruptibleKt$runInterruptible$2((List) this.L$0, (SyncUtils) obj2, continuation, (byte) 14);
            case 15:
                InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$5 = new InterruptibleKt$runInterruptible$2((SongEntity) obj2, continuation, (byte) 15);
                interruptibleKt$runInterruptible$5.L$0 = obj;
                return interruptibleKt$runInterruptible$5;
            case 16:
                InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$6 = new InterruptibleKt$runInterruptible$2((PodcastEntity) obj2, continuation, (byte) 16);
                interruptibleKt$runInterruptible$6.L$0 = obj;
                return interruptibleKt$runInterruptible$6;
            default:
                InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$7 = new InterruptibleKt$runInterruptible$2((CachedSongPartition) obj2, continuation, (byte) 17);
                interruptibleKt$runInterruptible$7.L$0 = obj;
                return interruptibleKt$runInterruptible$7;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 2:
                ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 3:
                ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 4:
                ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 5:
                ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 6:
                ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 7:
                ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 8:
                ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 9:
                ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 10:
                ((InterruptibleKt$runInterruptible$2) create((String) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 11:
                ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((InterruptibleKt$runInterruptible$2) create((ListenTogetherEvent) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 13:
                return ((InterruptibleKt$runInterruptible$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 14:
                ((InterruptibleKt$runInterruptible$2) create((MusicDatabase) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 15:
                ((InterruptibleKt$runInterruptible$2) create((MusicDatabase) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 16:
                ((InterruptibleKt$runInterruptible$2) create((MusicDatabase) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            default:
                ((InterruptibleKt$runInterruptible$2) create((MusicDatabase) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Unsafe unsafe;
        long j;
        int intVolatile;
        Bitmap bitmapCreateIndependentCopy;
        byte b = this.$r8$classId;
        Continuation continuation = null;
        byte b2 = 1;
        boolean z = false;
        int i = 0;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.$block;
        switch (b) {
            case 0:
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
                ImageLoader$Builder$$ExternalSyntheticLambda1 imageLoader$Builder$$ExternalSyntheticLambda1 = (ImageLoader$Builder$$ExternalSyntheticLambda1) obj2;
                try {
                    ThreadState threadState = new ThreadState();
                    threadState.cancelHandle = AwaitKt.invokeOnCompletion(AwaitKt.getJob(coroutineContext), true, threadState);
                    try {
                        do {
                            unsafe = ArtificialStackFramesUnsafe.unsafe;
                            j = ThreadState._state$volatile$FU$offset;
                            intVolatile = unsafe.getIntVolatile(threadState, j);
                            if (intVolatile != 0) {
                                if (intVolatile != 2 && intVolatile != 3) {
                                    ThreadState.invalidState(intVolatile);
                                    throw null;
                                }
                            }
                            return imageLoader$Builder$$ExternalSyntheticLambda1.invoke();
                        } while (!unsafe.compareAndSwapInt(threadState, j, intVolatile, 0));
                        return imageLoader$Builder$$ExternalSyntheticLambda1.invoke();
                    } finally {
                        threadState.clearInterrupt();
                    }
                } catch (InterruptedException e) {
                    throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e);
                }
            case 1:
                ResultKt.throwOnFailure(obj);
                MutableState mutableState = (MutableState) this.L$0;
                List list = HomeScreenKt.DailyDiscoverMessages;
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                    ((ParcelableSnapshotMutableLongState) obj2).setLongValue(System.currentTimeMillis());
                }
                return unit;
            case 2:
                ResultKt.throwOnFailure(obj);
                if (((LazyListState) this.L$0).scrollableState.isScrollInProgress()) {
                    ((FocusOwnerImpl) ((FocusOwner) obj2)).m409clearFocusI7lrPNg(8, false, true);
                }
                return unit;
            case 3:
                AutoPlaylistViewModel autoPlaylistViewModel = (AutoPlaylistViewModel) obj2;
                ResultKt.throwOnFailure(obj);
                PlaylistType playlistType = (PlaylistType) this.L$0;
                if (playlistType == PlaylistType.LIKE) {
                    System.out.println((Object) "[UPLOAD_DEBUG] AutoPlaylistScreen: Calling syncLikedSongs()");
                    CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(autoPlaylistViewModel);
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new AutoPlaylistViewModel$syncLikedSongs$1(autoPlaylistViewModel, continuation, z ? (byte) 1 : (byte) 0), 2);
                }
                if (playlistType == PlaylistType.UPLOADED) {
                    System.out.println((Object) "[UPLOAD_DEBUG] AutoPlaylistScreen: Calling syncUploadedSongs()");
                    CloseableCoroutineScope viewModelScope2 = ViewModelKt.getViewModelScope(autoPlaylistViewModel);
                    DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                    AwaitKt.launch$default(viewModelScope2, DefaultIoScheduler.INSTANCE, null, new AutoPlaylistViewModel$syncLikedSongs$1(autoPlaylistViewModel, continuation, b2), 2);
                }
                return unit;
            case 4:
                ResultKt.throwOnFailure(obj);
                ((MusicDatabase) this.L$0).query(new MimesKt$$ExternalSyntheticLambda0((byte) 13, (RecognitionHistory) obj2));
                return unit;
            case 5:
                ResultKt.throwOnFailure(obj);
                ((MusicDatabase) this.L$0).query(new MimesKt$$ExternalSyntheticLambda0((byte) 14, (RecognitionResult) obj2));
                return unit;
            case 6:
                ResultKt.throwOnFailure(obj);
                ((Function1) this.L$0).invoke((RecognitionResult) obj2);
                return unit;
            case 7:
                ResultKt.throwOnFailure(obj);
                ((LocalSearchViewModel) this.L$0).query.setValue((String) obj2);
                return unit;
            case 8:
                ResultKt.throwOnFailure(obj);
                String str = (String) this.L$0;
                int length = str.length();
                ((MutableState) obj2).setValue(new TextFieldValue(4, TextRangeKt.TextRange(length, length), str));
                return unit;
            case 9:
                OnlineSearchViewModel onlineSearchViewModel = (OnlineSearchViewModel) this.L$0;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) ((DataStoreKt$rememberPreference$1$1) obj2).$state.getValue()).booleanValue()) {
                    YouTube.SearchFilter searchFilter = (YouTube.SearchFilter) onlineSearchViewModel.filter.getValue();
                    String str2 = searchFilter != null ? searchFilter.value : null;
                    if (str2 != null ? str2.equals("EgWKAQIQAWoKEAkQChAFEAMQBA%3D%3D") : false) {
                        onlineSearchViewModel.filter.setValue(null);
                    }
                }
                return unit;
            case 10:
                String str3 = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                ((OnlineSearchSuggestionViewModel) obj2).query.setValue(str3);
                return unit;
            case 11:
                ResultKt.throwOnFailure(obj);
                DisplayCompat.scheduleAll((Context) this.L$0, (List) obj2);
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Context context = (Context) obj2;
                ListenTogetherEvent listenTogetherEvent = (ListenTogetherEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
                if (listenTogetherEvent != null && !(listenTogetherEvent instanceof ListenTogetherEvent.RoomCreated)) {
                    if (listenTogetherEvent instanceof ListenTogetherEvent.JoinApproved) {
                        Toast.makeText(context, "Joined room: ".concat(((ListenTogetherEvent.JoinApproved) listenTogetherEvent).roomCode), 0).show();
                    } else if (listenTogetherEvent instanceof ListenTogetherEvent.JoinRejected) {
                        Toast.makeText(context, "Join rejected: ".concat(((ListenTogetherEvent.JoinRejected) listenTogetherEvent).reason), 0).show();
                    } else if (listenTogetherEvent instanceof ListenTogetherEvent.JoinRequestReceived) {
                        Toast.makeText(context, ((ListenTogetherEvent.JoinRequestReceived) listenTogetherEvent).username.concat(" wants to join"), 0).show();
                    } else if (listenTogetherEvent instanceof ListenTogetherEvent.Kicked) {
                        Toast.makeText(context, "Kicked: ".concat(((ListenTogetherEvent.Kicked) listenTogetherEvent).reason), 0).show();
                    } else if (listenTogetherEvent instanceof ListenTogetherEvent.ConnectionError) {
                        Toast.makeText(context, "Connection error: ".concat(((ListenTogetherEvent.ConnectionError) listenTogetherEvent).error), 0).show();
                    } else if (listenTogetherEvent instanceof ListenTogetherEvent.ServerError) {
                        Toast.makeText(context, "Error: ".concat(((ListenTogetherEvent.ServerError) listenTogetherEvent).message), 0).show();
                    }
                }
                return unit;
            case 13:
                ResultKt.throwOnFailure(obj);
                try {
                    byte[] bArr = (byte[]) this.L$0;
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    return (bitmapDecodeByteArray == null || (bitmapCreateIndependentCopy = Splitter.createIndependentCopy(bitmapDecodeByteArray)) == null) ? Splitter.createFallbackBitmap() : bitmapCreateIndependentCopy;
                } catch (Exception unused) {
                    Timber.Forest.tag("CoilBitmapLoader");
                    ConnectionPool.w$1(new Object[0]);
                    return Splitter.createFallbackBitmap();
                }
            case 14:
                ResultKt.throwOnFailure(obj);
                SyncUtils syncUtils = (SyncUtils) obj2;
                Iterator it = ((List) this.L$0).iterator();
                while (it.hasNext()) {
                    syncUtils.database.update((PlaylistSongMap) it.next());
                }
                return unit;
            case 15:
                MusicDatabase musicDatabase = (MusicDatabase) this.L$0;
                ResultKt.throwOnFailure(obj);
                SongEntity songEntityCopy$default = SongEntity.copy$default((SongEntity) obj2, null, 0, null, null, null, false, null, null, null, null, null, 0, false, false, false, null, 134209535);
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.update(songEntityCopy$default);
                return unit;
            case 16:
                MusicDatabase musicDatabase2 = (MusicDatabase) this.L$0;
                ResultKt.throwOnFailure(obj);
                PodcastEntity podcastEntityCopy$default = PodcastEntity.copy$default((PodcastEntity) obj2, null, null, null, null, null, null, 479);
                musicDatabase2.getClass();
                musicDatabase2.$$delegate_0.update(podcastEntityCopy$default);
                return unit;
            default:
                MusicDatabase musicDatabase3 = (MusicDatabase) this.L$0;
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList = ((CachedSongPartition) obj2).stale;
                int size = arrayList.size();
                while (i < size) {
                    Object obj3 = arrayList.get(i);
                    i++;
                    SongEntity songEntityCopy$default2 = SongEntity.copy$default(((Song) obj3).song, null, 0, null, null, null, false, null, null, null, null, null, 0, false, false, false, null, 134201343);
                    musicDatabase3.getClass();
                    musicDatabase3.$$delegate_0.update(songEntityCopy$default2);
                }
                return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InterruptibleKt$runInterruptible$2(Object obj, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$block = obj;
    }
}
