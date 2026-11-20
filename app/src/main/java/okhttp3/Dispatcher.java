package okhttp3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.os.Handler;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.activity.EdgeToEdge$$ExternalSyntheticLambda0;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.Animations;
import androidx.compose.animation.core.FloatAnimationSpec;
import androidx.compose.animation.core.VectorizedFiniteAnimationSpec;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.input.pointer.InternalPointerEvent;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda5;
import androidx.core.internal.view.SupportMenuItem;
import androidx.datastore.core.AtomicInt;
import androidx.datastore.core.Data;
import androidx.datastore.core.DataStoreImpl;
import androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1;
import androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1;
import androidx.datastore.core.RunOnce$runIfNeeded$1;
import androidx.datastore.core.SingleProcessCoordinator;
import androidx.emoji2.text.MetadataRepo$Node;
import androidx.emoji2.text.TypefaceEmojiRasterizer;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.emoji2.text.flatbuffer.MetadataList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.internal.SynchronizedObject;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil$H265VideoSignalInfosAndIndices;
import androidx.media3.exoplayer.audio.AudioCapabilities;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.pgs.PgsParser$CueBuilder;
import androidx.media3.session.CommandButton;
import androidx.media3.session.ConnectedControllersManager$AsyncCommand;
import androidx.media3.session.ConnectedControllersManager$ConnectedControllerRecord;
import androidx.media3.session.MediaLibrarySessionImpl;
import androidx.media3.session.MediaSession$ControllerInfo;
import androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda5;
import androidx.media3.session.PlayerInfo;
import androidx.media3.session.SessionCommand;
import androidx.media3.session.SessionCommands;
import androidx.room.RoomDatabase$closeBarrier$1;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import androidx.savedstate.SavedStateRegistry;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.metrolist.music.App;
import com.yalantis.ucrop.view.CropImageView;
import dagger.hilt.EntryPoints;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.Inflater;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda1;
import okhttp3.internal.connection.RealCall;
import okio.Buffer;
import okio.Okio__OkioKt;
import okio.Segment;
import okio.SegmentPool;
import okio.Sink;
import okio.Socket;
import okio.Source;
import okio.Timeout;
import okio.internal.DefaultSocket$SocketSink;
import okio.internal.DefaultSocket$SocketSource;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Dispatcher implements ActionMode.Callback, VectorizedFiniteAnimationSpec, SubtitleParser, SelectClause1, Socket {
    public final /* synthetic */ byte $r8$classId;
    public Object executorServiceOrNull;
    public Object readyAsyncCalls;
    public Object runningAsyncCalls;
    public Object runningSyncCalls;

    public Dispatcher(Typeface typeface, MetadataList metadataList) {
        int i;
        int i2;
        int i3;
        int i4;
        this.$r8$classId = (byte) 6;
        this.runningSyncCalls = typeface;
        this.executorServiceOrNull = metadataList;
        this.runningAsyncCalls = new MetadataRepo$Node(1024);
        int i__offset = metadataList.__offset(6);
        if (i__offset != 0) {
            int i5 = i__offset + metadataList.bb_pos;
            i = ((ByteBuffer) metadataList.bb).getInt(((ByteBuffer) metadataList.bb).getInt(i5) + i5);
        } else {
            i = 0;
        }
        this.readyAsyncCalls = new char[i * 2];
        int i__offset2 = metadataList.__offset(6);
        if (i__offset2 != 0) {
            int i6 = i__offset2 + metadataList.bb_pos;
            i2 = ((ByteBuffer) metadataList.bb).getInt(((ByteBuffer) metadataList.bb).getInt(i6) + i6);
        } else {
            i2 = 0;
        }
        for (int i7 = 0; i7 < i2; i7++) {
            TypefaceEmojiRasterizer typefaceEmojiRasterizer = new TypefaceEmojiRasterizer(this, i7);
            MetadataItem metadataItem = typefaceEmojiRasterizer.getMetadataItem();
            int i__offset3 = metadataItem.__offset(4);
            Character.toChars(i__offset3 != 0 ? ((ByteBuffer) metadataItem.bb).getInt(i__offset3 + metadataItem.bb_pos) : 0, (char[]) this.readyAsyncCalls, i7 * 2);
            MetadataItem metadataItem2 = typefaceEmojiRasterizer.getMetadataItem();
            int i__offset4 = metadataItem2.__offset(16);
            if (i__offset4 != 0) {
                int i8 = i__offset4 + metadataItem2.bb_pos;
                i3 = ((ByteBuffer) metadataItem2.bb).getInt(((ByteBuffer) metadataItem2.bb).getInt(i8) + i8);
            } else {
                i3 = 0;
            }
            if (!(i3 > 0)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("invalid metadata codepoint length");
                throw null;
            }
            MetadataRepo$Node metadataRepo$Node = (MetadataRepo$Node) this.runningAsyncCalls;
            MetadataItem metadataItem3 = typefaceEmojiRasterizer.getMetadataItem();
            int i__offset5 = metadataItem3.__offset(16);
            if (i__offset5 != 0) {
                int i9 = i__offset5 + metadataItem3.bb_pos;
                i4 = ((ByteBuffer) metadataItem3.bb).getInt(((ByteBuffer) metadataItem3.bb).getInt(i9) + i9);
            } else {
                i4 = 0;
            }
            metadataRepo$Node.put(typefaceEmojiRasterizer, 0, i4 - 1);
        }
    }

    public static void promoteAndExecute$default(Dispatcher dispatcher, RealCall.AsyncCall asyncCall, RealCall realCall, RealCall.AsyncCall asyncCall2, int i) {
        Dispatcher$promoteAndExecute$Effects dispatcher$promoteAndExecute$Effects;
        RealCall.AsyncCall asyncCallFindExistingCallWithHost;
        if ((i & 1) != 0) {
            asyncCall = null;
        }
        if ((i & 2) != 0) {
            realCall = null;
        }
        if ((i & 4) != 0) {
            asyncCall2 = null;
        }
        dispatcher.getClass();
        TimeZone timeZone = _UtilJvmKt.UTC;
        boolean zIsShutdown = dispatcher.executorService().isShutdown();
        synchronized (dispatcher) {
            if (realCall != null) {
                try {
                    if (!((ArrayDeque) dispatcher.runningSyncCalls).remove(realCall)) {
                        throw new IllegalStateException("Call wasn't in-flight!");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (asyncCall2 != null) {
                asyncCall2.callsPerHost.decrementAndGet();
                if (!((ArrayDeque) dispatcher.runningAsyncCalls).remove(asyncCall2)) {
                    throw new IllegalStateException("Call wasn't in-flight!");
                }
            }
            if (asyncCall != null) {
                ((ArrayDeque) dispatcher.readyAsyncCalls).add(asyncCall);
                RealCall realCall2 = RealCall.this;
                if (!realCall2.forWebSocket && (asyncCallFindExistingCallWithHost = dispatcher.findExistingCallWithHost(realCall2.originalRequest.url.host)) != null) {
                    asyncCall.callsPerHost = asyncCallFindExistingCallWithHost.callsPerHost;
                }
            }
            if ((realCall != null || asyncCall2 != null) && (zIsShutdown || ((ArrayDeque) dispatcher.runningAsyncCalls).isEmpty())) {
                ((ArrayDeque) dispatcher.runningSyncCalls).isEmpty();
            }
            if (zIsShutdown) {
                List list = CollectionsKt.toList((ArrayDeque) dispatcher.readyAsyncCalls);
                ((ArrayDeque) dispatcher.readyAsyncCalls).clear();
                dispatcher$promoteAndExecute$Effects = new Dispatcher$promoteAndExecute$Effects(list);
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((ArrayDeque) dispatcher.readyAsyncCalls).iterator();
                it.getClass();
                while (it.hasNext()) {
                    RealCall.AsyncCall asyncCall3 = (RealCall.AsyncCall) it.next();
                    if (((ArrayDeque) dispatcher.runningAsyncCalls).size() >= 64) {
                        break;
                    }
                    if (asyncCall3.callsPerHost.get() < 5) {
                        it.remove();
                        asyncCall3.callsPerHost.incrementAndGet();
                        arrayList.add(asyncCall3);
                        ((ArrayDeque) dispatcher.runningAsyncCalls).add(asyncCall3);
                    }
                }
                dispatcher$promoteAndExecute$Effects = new Dispatcher$promoteAndExecute$Effects(arrayList);
            }
        }
        int size = dispatcher$promoteAndExecute$Effects.callsToExecute.size();
        boolean z = true;
        for (int i2 = 0; i2 < size; i2++) {
            RealCall.AsyncCall asyncCall4 = (RealCall.AsyncCall) dispatcher$promoteAndExecute$Effects.callsToExecute.get(i2);
            if (asyncCall4 == asyncCall) {
                z = false;
            } else {
                RealCall.this.eventListener.getClass();
            }
            if (zIsShutdown) {
                asyncCall4.getClass();
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(null);
                RealCall realCall3 = RealCall.this;
                realCall3.noMoreExchanges$okhttp(interruptedIOException);
                asyncCall4.responseCallback.onFailure(realCall3, interruptedIOException);
            } else {
                ExecutorService executorService = dispatcher.executorService();
                asyncCall4.getClass();
                RealCall realCall4 = RealCall.this;
                realCall4.client.dispatcher.getClass();
                try {
                    try {
                        executorService.execute(asyncCall4);
                    } catch (RejectedExecutionException e) {
                        InterruptedIOException interruptedIOException2 = new InterruptedIOException("executor rejected");
                        interruptedIOException2.initCause(e);
                        RealCall realCall5 = RealCall.this;
                        realCall5.noMoreExchanges$okhttp(interruptedIOException2);
                        asyncCall4.responseCallback.onFailure(realCall5, interruptedIOException2);
                        Dispatcher dispatcher2 = realCall4.client.dispatcher;
                        dispatcher2.getClass();
                        promoteAndExecute$default(dispatcher2, null, null, asyncCall4, 3);
                    }
                } catch (Throwable th2) {
                    Dispatcher dispatcher3 = realCall4.client.dispatcher;
                    dispatcher3.getClass();
                    promoteAndExecute$default(dispatcher3, null, null, asyncCall4, 3);
                    throw th2;
                }
            }
        }
        if (!z || asyncCall == null) {
            return;
        }
        RealCall.this.eventListener.getClass();
    }

    public void addController(Object obj, MediaSession$ControllerInfo mediaSession$ControllerInfo, SessionCommands sessionCommands, Player.Commands commands) {
        synchronized (this.executorServiceOrNull) {
            try {
                MediaSession$ControllerInfo controller = getController(obj);
                if (controller == null) {
                    ((ArrayMap) this.readyAsyncCalls).put(obj, mediaSession$ControllerInfo);
                    ((ArrayMap) this.runningAsyncCalls).put(mediaSession$ControllerInfo, new ConnectedControllersManager$ConnectedControllerRecord(obj, new NodeChain.Differ(), sessionCommands, commands));
                } else {
                    ConnectedControllersManager$ConnectedControllerRecord connectedControllersManager$ConnectedControllerRecord = (ConnectedControllersManager$ConnectedControllerRecord) ((ArrayMap) this.runningAsyncCalls).get(controller);
                    connectedControllersManager$ConnectedControllerRecord.getClass();
                    connectedControllersManager$ConnectedControllerRecord.sessionCommands = sessionCommands;
                    connectedControllersManager$ConnectedControllerRecord.playerCommands = commands;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addToCommandQueue(MediaSession$ControllerInfo mediaSession$ControllerInfo, int i, ConnectedControllersManager$AsyncCommand connectedControllersManager$AsyncCommand) {
        synchronized (this.executorServiceOrNull) {
            try {
                ConnectedControllersManager$ConnectedControllerRecord connectedControllersManager$ConnectedControllerRecord = (ConnectedControllersManager$ConnectedControllerRecord) ((ArrayMap) this.runningAsyncCalls).get(mediaSession$ControllerInfo);
                if (connectedControllersManager$ConnectedControllerRecord != null) {
                    Player.Commands commands = connectedControllersManager$ConnectedControllerRecord.commandQueuePlayerCommands;
                    commands.getClass();
                    SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
                    FlagSet flagSet = commands.flags;
                    for (int i2 = 0; i2 < flagSet.flags.size(); i2++) {
                        int i3 = flagSet.get(i2);
                        UtilsKt.checkState(!false);
                        sparseBooleanArray.append(i3, true);
                    }
                    UtilsKt.checkState(!false);
                    sparseBooleanArray.append(i, true);
                    UtilsKt.checkState(!false);
                    connectedControllersManager$ConnectedControllerRecord.commandQueuePlayerCommands = new Player.Commands(new FlagSet(sparseBooleanArray));
                    connectedControllersManager$ConnectedControllerRecord.commandQueue.add(connectedControllersManager$AsyncCommand);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean block$room_runtime() {
        synchronized (this) {
            if (((AtomicBoolean) this.runningAsyncCalls).get()) {
                return false;
            }
            ((AtomicInteger) this.readyAsyncCalls).incrementAndGet();
            return true;
        }
    }

    @Override // okio.Socket
    public void cancel() throws IOException {
        ((java.net.Socket) this.executorServiceOrNull).close();
    }

    public synchronized void cancelAll() {
        try {
            Iterator it = ((ArrayDeque) this.readyAsyncCalls).iterator();
            it.getClass();
            while (it.hasNext()) {
                RealCall.this.cancel();
            }
            Iterator it2 = ((ArrayDeque) this.runningAsyncCalls).iterator();
            it2.getClass();
            while (it2.hasNext()) {
                RealCall.this.cancel();
            }
            Iterator it3 = ((ArrayDeque) this.runningSyncCalls).iterator();
            it3.getClass();
            while (it3.hasNext()) {
                ((RealCall) it3.next()).cancel();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void dispatchToView(PointerEvent pointerEvent, boolean z) {
        PointerInteropFilter pointerInteropFilter = (PointerInteropFilter) this.runningSyncCalls;
        List list = pointerEvent.changes;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((PointerInputChange) list.get(i)).isConsumed()) {
                stopDispatching(pointerEvent);
                return;
            }
        }
        NodeCoordinator nodeCoordinator = (NodeCoordinator) this.executorServiceOrNull;
        if (nodeCoordinator == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("layoutCoordinates not set");
            return;
        }
        PointerIconKt.m589toMotionEventScopeubNVwUQ(pointerEvent, nodeCoordinator.mo606localToRootMKHz9U(0L), new ZIndexNode$$ExternalSyntheticLambda0((Object) this, (Object) pointerInteropFilter, (byte) 26), false);
        if (((PointerInteropFilter.DispatchToViewState) this.readyAsyncCalls) == PointerInteropFilter.DispatchToViewState.Dispatching) {
            if (z) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((PointerInputChange) list.get(i2)).consume();
                }
            }
            InternalPointerEvent internalPointerEvent = pointerEvent.internalPointerEvent;
            if (internalPointerEvent != null) {
                internalPointerEvent.suppressMovementConsumption = !pointerInteropFilter.disallowIntercept;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
    
        if (r7 == r2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0065, code lost:
    
        if (r7 == r2) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doRun(ContinuationImpl continuationImpl) {
        DataStoreImpl$InitDataStore$doRun$1 dataStoreImpl$InitDataStore$doRun$1;
        Data data;
        DataStoreImpl dataStoreImpl = (DataStoreImpl) this.runningSyncCalls;
        if (continuationImpl instanceof DataStoreImpl$InitDataStore$doRun$1) {
            dataStoreImpl$InitDataStore$doRun$1 = (DataStoreImpl$InitDataStore$doRun$1) continuationImpl;
            int i = dataStoreImpl$InitDataStore$doRun$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                dataStoreImpl$InitDataStore$doRun$1.label = i - Integer.MIN_VALUE;
            } else {
                dataStoreImpl$InitDataStore$doRun$1 = new DataStoreImpl$InitDataStore$doRun$1(this, continuationImpl);
            }
        } else {
            dataStoreImpl$InitDataStore$doRun$1 = new DataStoreImpl$InitDataStore$doRun$1(this, continuationImpl);
        }
        Object dataOrHandleCorruption = dataStoreImpl$InitDataStore$doRun$1.result;
        int i2 = dataStoreImpl$InitDataStore$doRun$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(dataOrHandleCorruption);
            List list = (List) this.runningAsyncCalls;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (list == null || list.isEmpty()) {
                dataStoreImpl$InitDataStore$doRun$1.label = 1;
                dataOrHandleCorruption = dataStoreImpl.readDataOrHandleCorruption(false, dataStoreImpl$InitDataStore$doRun$1);
            } else {
                SingleProcessCoordinator coordinator = dataStoreImpl.getCoordinator();
                DataStoreImpl$InitDataStore$doRun$initData$1 dataStoreImpl$InitDataStore$doRun$initData$1 = new DataStoreImpl$InitDataStore$doRun$initData$1(dataStoreImpl, this, null);
                dataStoreImpl$InitDataStore$doRun$1.label = 2;
                dataOrHandleCorruption = coordinator.lock(dataStoreImpl$InitDataStore$doRun$initData$1, dataStoreImpl$InitDataStore$doRun$1);
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            ResultKt.throwOnFailure(dataOrHandleCorruption);
            data = (Data) dataOrHandleCorruption;
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(dataOrHandleCorruption);
            data = (Data) dataOrHandleCorruption;
        }
        dataStoreImpl.inMemoryCache.tryUpdate(data);
        return Unit.INSTANCE;
    }

    public synchronized ExecutorService executorService() {
        ThreadPoolExecutor threadPoolExecutor;
        threadPoolExecutor = (ThreadPoolExecutor) this.executorServiceOrNull;
        if (threadPoolExecutor == null) {
            ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new _UtilJvmKt$$ExternalSyntheticLambda1(_UtilJvmKt.okHttpName + " Dispatcher", false));
            this.executorServiceOrNull = threadPoolExecutor2;
            threadPoolExecutor = threadPoolExecutor2;
        }
        return threadPoolExecutor;
    }

    public RealCall.AsyncCall findExistingCallWithHost(String str) {
        Iterator it = ((ArrayDeque) this.runningAsyncCalls).iterator();
        it.getClass();
        while (it.hasNext()) {
            RealCall.AsyncCall asyncCall = (RealCall.AsyncCall) it.next();
            if (Intrinsics.areEqual(RealCall.this.originalRequest.url.host, str)) {
                return asyncCall;
            }
        }
        Iterator it2 = ((ArrayDeque) this.readyAsyncCalls).iterator();
        it2.getClass();
        while (it2.hasNext()) {
            RealCall.AsyncCall asyncCall2 = (RealCall.AsyncCall) it2.next();
            if (Intrinsics.areEqual(RealCall.this.originalRequest.url.host, str)) {
                return asyncCall2;
            }
        }
        return null;
    }

    public void flushCommandQueue(ConnectedControllersManager$ConnectedControllerRecord connectedControllersManager$ConnectedControllerRecord) {
        MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) ((WeakReference) this.runningSyncCalls).get();
        if (mediaLibrarySessionImpl == null) {
            return;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        while (atomicBoolean.get()) {
            atomicBoolean.set(false);
            ConnectedControllersManager$AsyncCommand connectedControllersManager$AsyncCommand = (ConnectedControllersManager$AsyncCommand) connectedControllersManager$ConnectedControllerRecord.commandQueue.poll();
            if (connectedControllersManager$AsyncCommand == null) {
                connectedControllersManager$ConnectedControllerRecord.commandQueueIsFlushing = false;
                return;
            }
            AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
            Dispatcher dispatcher = this;
            Util.postOrRun(mediaLibrarySessionImpl.applicationHandler, new TransactionExecutor$$ExternalSyntheticLambda0(mediaLibrarySessionImpl, this.getController(connectedControllersManager$ConnectedControllerRecord.controllerKey), new EdgeToEdge$$ExternalSyntheticLambda0(dispatcher, connectedControllersManager$AsyncCommand, atomicBoolean2, connectedControllersManager$ConnectedControllerRecord, atomicBoolean, (byte) 1)));
            atomicBoolean2.set(false);
            this = dispatcher;
        }
    }

    public SupportActionModeWrapper getActionModeWrapper(ActionMode actionMode) {
        ArrayList arrayList = (ArrayList) this.runningAsyncCalls;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            SupportActionModeWrapper supportActionModeWrapper = (SupportActionModeWrapper) arrayList.get(i);
            if (supportActionModeWrapper != null && supportActionModeWrapper.mWrappedObject == actionMode) {
                return supportActionModeWrapper;
            }
        }
        SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper((Context) this.readyAsyncCalls, actionMode);
        arrayList.add(supportActionModeWrapper2);
        return supportActionModeWrapper2;
    }

    public Player.Commands getAvailablePlayerCommands(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        synchronized (this.executorServiceOrNull) {
            try {
                ConnectedControllersManager$ConnectedControllerRecord connectedControllersManager$ConnectedControllerRecord = (ConnectedControllersManager$ConnectedControllerRecord) ((ArrayMap) this.runningAsyncCalls).get(mediaSession$ControllerInfo);
                if (connectedControllersManager$ConnectedControllerRecord == null) {
                    return null;
                }
                return connectedControllersManager$ConnectedControllerRecord.playerCommands;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ImmutableList getConnectedControllers() {
        ImmutableList immutableListCopyOf;
        synchronized (this.executorServiceOrNull) {
            immutableListCopyOf = ImmutableList.copyOf(((ArrayMap) this.readyAsyncCalls).values());
        }
        return immutableListCopyOf;
    }

    public MediaSession$ControllerInfo getController(Object obj) {
        MediaSession$ControllerInfo mediaSession$ControllerInfo;
        synchronized (this.executorServiceOrNull) {
            mediaSession$ControllerInfo = (MediaSession$ControllerInfo) ((ArrayMap) this.readyAsyncCalls).get(obj);
        }
        return mediaSession$ControllerInfo;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        int size$animation_core = animationVector.getSize$animation_core();
        long jMax = 0;
        for (int i = 0; i < size$animation_core; i++) {
            jMax = Math.max(jMax, ((Animations) this.executorServiceOrNull).get(i).getDurationNanos(animationVector.get$animation_core(i), animationVector2.get$animation_core(i), animationVector3.get$animation_core(i)));
        }
        return jMax;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        AnimationVector animationVectorNewVector$animation_core = (AnimationVector) this.runningSyncCalls;
        if (animationVectorNewVector$animation_core == null) {
            animationVectorNewVector$animation_core = animationVector3.newVector$animation_core();
            this.runningSyncCalls = animationVectorNewVector$animation_core;
        }
        int size$animation_core = animationVectorNewVector$animation_core.getSize$animation_core();
        int i = 0;
        while (true) {
            AnimationVector animationVector4 = (AnimationVector) this.runningSyncCalls;
            if (i >= size$animation_core) {
                if (animationVector4 != null) {
                    return animationVector4;
                }
                Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
                throw null;
            }
            if (animationVector4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
                throw null;
            }
            animationVector4.set$animation_core(i, ((Animations) this.executorServiceOrNull).get(i).getEndVelocity(animationVector.get$animation_core(i), animationVector2.get$animation_core(i), animationVector3.get$animation_core(i)));
            i++;
        }
    }

    public PlaybackException getPlaybackException(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        synchronized (this.executorServiceOrNull) {
            try {
                return ((ConnectedControllersManager$ConnectedControllerRecord) ((ArrayMap) this.runningAsyncCalls).get(mediaSession$ControllerInfo)) != null ? null : null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public PlayerInfo getPlayerInfoForPlaybackException(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        synchronized (this.executorServiceOrNull) {
            try {
                return ((ConnectedControllersManager$ConnectedControllerRecord) ((ArrayMap) this.runningAsyncCalls).get(mediaSession$ControllerInfo)) != null ? null : null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public NodeChain.Differ getSequencedFutureManager(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        ConnectedControllersManager$ConnectedControllerRecord connectedControllersManager$ConnectedControllerRecord;
        synchronized (this.executorServiceOrNull) {
            connectedControllersManager$ConnectedControllerRecord = (ConnectedControllersManager$ConnectedControllerRecord) ((ArrayMap) this.runningAsyncCalls).get(mediaSession$ControllerInfo);
        }
        if (connectedControllersManager$ConnectedControllerRecord != null) {
            return connectedControllersManager$ConnectedControllerRecord.sequencedFutureManager;
        }
        return null;
    }

    @Override // okio.Socket
    public Sink getSink() {
        return (DefaultSocket$SocketSink) this.runningSyncCalls;
    }

    @Override // okio.Socket
    public Source getSource() {
        return (DefaultSocket$SocketSource) this.runningAsyncCalls;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getValueFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        AnimationVector animationVectorNewVector$animation_core = (AnimationVector) this.readyAsyncCalls;
        if (animationVectorNewVector$animation_core == null) {
            animationVectorNewVector$animation_core = animationVector.newVector$animation_core();
            this.readyAsyncCalls = animationVectorNewVector$animation_core;
        }
        int size$animation_core = animationVectorNewVector$animation_core.getSize$animation_core();
        int i = 0;
        while (true) {
            AnimationVector animationVector4 = (AnimationVector) this.readyAsyncCalls;
            if (i >= size$animation_core) {
                if (animationVector4 != null) {
                    return animationVector4;
                }
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                throw null;
            }
            if (animationVector4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                throw null;
            }
            long j2 = j;
            animationVector4.set$animation_core(i, ((Animations) this.executorServiceOrNull).get(i).getValueFromNanos(animationVector.get$animation_core(i), animationVector2.get$animation_core(i), animationVector3.get$animation_core(i), j2));
            i++;
            j = j2;
        }
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getVelocityFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        AnimationVector animationVectorNewVector$animation_core = (AnimationVector) this.runningAsyncCalls;
        if (animationVectorNewVector$animation_core == null) {
            animationVectorNewVector$animation_core = animationVector3.newVector$animation_core();
            this.runningAsyncCalls = animationVectorNewVector$animation_core;
        }
        int size$animation_core = animationVectorNewVector$animation_core.getSize$animation_core();
        int i = 0;
        while (true) {
            AnimationVector animationVector4 = (AnimationVector) this.runningAsyncCalls;
            if (i >= size$animation_core) {
                if (animationVector4 != null) {
                    return animationVector4;
                }
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                throw null;
            }
            if (animationVector4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                throw null;
            }
            long j2 = j;
            animationVector4.set$animation_core(i, ((Animations) this.executorServiceOrNull).get(i).getVelocityFromNanos(animationVector.get$animation_core(i), animationVector2.get$animation_core(i), animationVector3.get$animation_core(i), j2));
            i++;
            j = j2;
        }
    }

    public ViewModel getViewModel$lifecycle_viewmodel(ClassReference classReference, String str) {
        ViewModel viewModel;
        ViewModel viewModelCreate;
        synchronized (((SynchronizedObject) this.runningSyncCalls)) {
            try {
                viewModel = (ViewModel) ((ViewModelStore) this.executorServiceOrNull).map.get(str);
                if (classReference.isInstance(viewModel)) {
                    ViewModelProvider$Factory viewModelProvider$Factory = (ViewModelProvider$Factory) this.readyAsyncCalls;
                    if (viewModelProvider$Factory instanceof SavedStateViewModelFactory) {
                        SavedStateViewModelFactory savedStateViewModelFactory = (SavedStateViewModelFactory) viewModelProvider$Factory;
                        viewModel.getClass();
                        Lifecycle lifecycle = savedStateViewModelFactory.lifecycle;
                        if (lifecycle != null) {
                            SavedStateRegistry savedStateRegistry = savedStateViewModelFactory.savedStateRegistry;
                            savedStateRegistry.getClass();
                            ViewModelKt.attachHandleIfNeeded(viewModel, savedStateRegistry, lifecycle);
                        }
                    }
                    viewModel.getClass();
                } else {
                    MutableCreationExtras mutableCreationExtras = new MutableCreationExtras((CreationExtras) this.runningAsyncCalls);
                    mutableCreationExtras.extras.put(ViewModelKt.VIEW_MODEL_KEY, str);
                    ViewModelProvider$Factory viewModelProvider$Factory2 = (ViewModelProvider$Factory) this.readyAsyncCalls;
                    try {
                        try {
                            viewModelCreate = viewModelProvider$Factory2.create(classReference, mutableCreationExtras);
                        } catch (AbstractMethodError unused) {
                            viewModelCreate = viewModelProvider$Factory2.create(Okio__OkioKt.getJavaClass(classReference));
                        }
                    } catch (AbstractMethodError unused2) {
                        viewModelCreate = viewModelProvider$Factory2.create(Okio__OkioKt.getJavaClass(classReference), mutableCreationExtras);
                    }
                    viewModel = viewModelCreate;
                    ViewModelStore viewModelStore = (ViewModelStore) this.executorServiceOrNull;
                    viewModelStore.getClass();
                    viewModel.getClass();
                    ViewModel viewModel2 = (ViewModel) viewModelStore.map.put(str, viewModel);
                    if (viewModel2 != null) {
                        viewModel2.clear$lifecycle_viewmodel();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return viewModel;
    }

    public boolean isConnected(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        boolean z;
        synchronized (this.executorServiceOrNull) {
            z = ((ArrayMap) this.runningAsyncCalls).get(mediaSession$ControllerInfo) != null;
        }
        return z;
    }

    public boolean isPlayerCommandAvailable(MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        ConnectedControllersManager$ConnectedControllerRecord connectedControllersManager$ConnectedControllerRecord;
        synchronized (this.executorServiceOrNull) {
            connectedControllersManager$ConnectedControllerRecord = (ConnectedControllersManager$ConnectedControllerRecord) ((ArrayMap) this.runningAsyncCalls).get(mediaSession$ControllerInfo);
        }
        MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) ((WeakReference) this.runningSyncCalls).get();
        return connectedControllersManager$ConnectedControllerRecord != null && connectedControllersManager$ConnectedControllerRecord.playerCommands.contains(i) && mediaLibrarySessionImpl != null && mediaLibrarySessionImpl.playerWrapper.getAvailableCommands().contains(i);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003c A[RETURN] */
    public boolean isSessionCommandAvailable(MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        ConnectedControllersManager$ConnectedControllerRecord connectedControllersManager$ConnectedControllerRecord;
        boolean z;
        synchronized (this.executorServiceOrNull) {
            connectedControllersManager$ConnectedControllerRecord = (ConnectedControllersManager$ConnectedControllerRecord) ((ArrayMap) this.runningAsyncCalls).get(mediaSession$ControllerInfo);
        }
        if (connectedControllersManager$ConnectedControllerRecord != null) {
            SessionCommands sessionCommands = connectedControllersManager$ConnectedControllerRecord.sessionCommands;
            sessionCommands.getClass();
            UtilsKt.checkArgument("Use contains(Command) for custom command", i != 0);
            Iterator<E> it = sessionCommands.commands.iterator();
            while (it.hasNext()) {
                if (((SessionCommand) it.next()).commandCode == i) {
                    z = true;
                    if (z) {
                        return true;
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return ((android.view.ActionMode.Callback) this.executorServiceOrNull).onActionItemClicked(getActionModeWrapper(actionMode), new MenuItemWrapperICS((Context) this.readyAsyncCalls, (SupportMenuItem) menuItem));
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, MenuBuilder menuBuilder) {
        android.view.ActionMode.Callback callback = (android.view.ActionMode.Callback) this.executorServiceOrNull;
        SupportActionModeWrapper actionModeWrapper = getActionModeWrapper(actionMode);
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.runningSyncCalls;
        Menu menuWrapperICS = (Menu) simpleArrayMap.get(menuBuilder);
        if (menuWrapperICS == null) {
            menuWrapperICS = new MenuWrapperICS((Context) this.readyAsyncCalls, menuBuilder);
            simpleArrayMap.put(menuBuilder, menuWrapperICS);
        }
        return callback.onCreateActionMode(actionModeWrapper, menuWrapperICS);
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        ((android.view.ActionMode.Callback) this.executorServiceOrNull).onDestroyActionMode(getActionModeWrapper(actionMode));
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        android.view.ActionMode.Callback callback = (android.view.ActionMode.Callback) this.executorServiceOrNull;
        SupportActionModeWrapper actionModeWrapper = getActionModeWrapper(actionMode);
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.runningSyncCalls;
        Menu menuWrapperICS = (Menu) simpleArrayMap.get(menu);
        if (menuWrapperICS == null) {
            menuWrapperICS = new MenuWrapperICS((Context) this.readyAsyncCalls, (MenuBuilder) menu);
            simpleArrayMap.put(menu, menuWrapperICS);
        }
        return callback.onPrepareActionMode(actionModeWrapper, menuWrapperICS);
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public void parse(byte[] bArr, int i, int i2, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        Cue cue;
        int i3;
        int i4;
        int unsignedByte;
        int i5;
        int i6;
        int unsignedInt24;
        PgsParser$CueBuilder pgsParser$CueBuilder = (PgsParser$CueBuilder) this.runningAsyncCalls;
        int[] iArr = pgsParser$CueBuilder.colors;
        ParsableByteArray parsableByteArray = pgsParser$CueBuilder.bitmapData;
        ParsableByteArray parsableByteArray2 = (ParsableByteArray) this.readyAsyncCalls;
        ParsableByteArray parsableByteArray3 = (ParsableByteArray) this.executorServiceOrNull;
        parsableByteArray3.reset(bArr, i + i2);
        parsableByteArray3.setPosition(i);
        Inflater inflater = (Inflater) this.runningSyncCalls;
        if (inflater == null) {
            inflater = new Inflater();
            this.runningSyncCalls = inflater;
        }
        if (Util.maybeInflate(parsableByteArray3, parsableByteArray2, inflater)) {
            parsableByteArray3.reset(parsableByteArray2.data, parsableByteArray2.limit);
        }
        int i7 = 0;
        pgsParser$CueBuilder.planeWidth = 0;
        pgsParser$CueBuilder.planeHeight = 0;
        pgsParser$CueBuilder.bitmapX = 0;
        pgsParser$CueBuilder.bitmapY = 0;
        pgsParser$CueBuilder.bitmapWidth = 0;
        pgsParser$CueBuilder.bitmapHeight = 0;
        parsableByteArray.reset(0);
        pgsParser$CueBuilder.colorsSet = false;
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray3.bytesLeft() >= 3) {
            int i8 = parsableByteArray3.limit;
            int unsignedByte2 = parsableByteArray3.readUnsignedByte();
            int unsignedShort = parsableByteArray3.readUnsignedShort();
            int i9 = parsableByteArray3.position + unsignedShort;
            if (i9 > i8) {
                parsableByteArray3.setPosition(i8);
                i3 = i7;
                cue = null;
            } else {
                char c = 128;
                if (unsignedByte2 != 128) {
                    switch (unsignedByte2) {
                        case 20:
                            if (unsignedShort % 5 == 2) {
                                parsableByteArray3.skipBytes(2);
                                Arrays.fill(iArr, i7);
                                int i10 = unsignedShort / 5;
                                int i11 = i7;
                                while (i11 < i10) {
                                    int unsignedByte3 = parsableByteArray3.readUnsignedByte();
                                    char c2 = c;
                                    double unsignedByte4 = parsableByteArray3.readUnsignedByte();
                                    double unsignedByte5 = parsableByteArray3.readUnsignedByte() - 128;
                                    double unsignedByte6 = parsableByteArray3.readUnsignedByte() - 128;
                                    iArr[unsignedByte3] = Util.constrainValue((int) ((unsignedByte6 * 1.772d) + unsignedByte4), 0, 255) | (parsableByteArray3.readUnsignedByte() << 24) | (Util.constrainValue((int) ((1.402d * unsignedByte5) + unsignedByte4), 0, 255) << 16) | (Util.constrainValue((int) ((unsignedByte4 - (0.34414d * unsignedByte6)) - (unsignedByte5 * 0.71414d)), 0, 255) << 8);
                                    i11++;
                                    c = c2;
                                    pgsParser$CueBuilder = pgsParser$CueBuilder;
                                }
                                pgsParser$CueBuilder.colorsSet = true;
                            }
                            break;
                        case 21:
                            if (unsignedShort >= 4) {
                                parsableByteArray3.skipBytes(3);
                                int i12 = unsignedShort - 4;
                                if (((128 & parsableByteArray3.readUnsignedByte()) != 0 ? 1 : i7) == 0) {
                                    i5 = parsableByteArray.position;
                                    i6 = parsableByteArray.limit;
                                    if (i5 < i6 && i12 > 0) {
                                        int iMin = Math.min(i12, i6 - i5);
                                        parsableByteArray3.readBytes(parsableByteArray.data, i5, iMin);
                                        parsableByteArray.setPosition(i5 + iMin);
                                    }
                                } else if (i12 >= 7 && (unsignedInt24 = parsableByteArray3.readUnsignedInt24()) >= 4) {
                                    pgsParser$CueBuilder.bitmapWidth = parsableByteArray3.readUnsignedShort();
                                    pgsParser$CueBuilder.bitmapHeight = parsableByteArray3.readUnsignedShort();
                                    parsableByteArray.reset(unsignedInt24 - 4);
                                    i12 = unsignedShort - 11;
                                    i5 = parsableByteArray.position;
                                    i6 = parsableByteArray.limit;
                                    if (i5 < i6) {
                                        int iMin2 = Math.min(i12, i6 - i5);
                                        parsableByteArray3.readBytes(parsableByteArray.data, i5, iMin2);
                                        parsableByteArray.setPosition(i5 + iMin2);
                                    }
                                }
                            }
                            break;
                        case 22:
                            if (unsignedShort >= 19) {
                                pgsParser$CueBuilder.planeWidth = parsableByteArray3.readUnsignedShort();
                                pgsParser$CueBuilder.planeHeight = parsableByteArray3.readUnsignedShort();
                                parsableByteArray3.skipBytes(11);
                                pgsParser$CueBuilder.bitmapX = parsableByteArray3.readUnsignedShort();
                                pgsParser$CueBuilder.bitmapY = parsableByteArray3.readUnsignedShort();
                            }
                            break;
                    }
                    cue = null;
                    i3 = 0;
                } else {
                    if (pgsParser$CueBuilder.planeWidth == 0 || pgsParser$CueBuilder.planeHeight == 0 || pgsParser$CueBuilder.bitmapWidth == 0 || pgsParser$CueBuilder.bitmapHeight == 0 || (i4 = parsableByteArray.limit) == 0 || parsableByteArray.position != i4 || !pgsParser$CueBuilder.colorsSet) {
                        cue = null;
                    } else {
                        parsableByteArray.setPosition(0);
                        int i13 = pgsParser$CueBuilder.bitmapWidth * pgsParser$CueBuilder.bitmapHeight;
                        int[] iArr2 = new int[i13];
                        int i14 = 0;
                        while (i14 < i13) {
                            int unsignedByte7 = parsableByteArray.readUnsignedByte();
                            if (unsignedByte7 != 0) {
                                unsignedByte = i14 + 1;
                                iArr2[i14] = iArr[unsignedByte7];
                            } else {
                                int unsignedByte8 = parsableByteArray.readUnsignedByte();
                                if (unsignedByte8 != 0) {
                                    unsignedByte = ((unsignedByte8 & 64) == 0 ? unsignedByte8 & 63 : ((unsignedByte8 & 63) << 8) | parsableByteArray.readUnsignedByte()) + i14;
                                    Arrays.fill(iArr2, i14, unsignedByte, (unsignedByte8 & 128) == 0 ? iArr[0] : iArr[parsableByteArray.readUnsignedByte()]);
                                }
                            }
                            i14 = unsignedByte;
                        }
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr2, pgsParser$CueBuilder.bitmapWidth, pgsParser$CueBuilder.bitmapHeight, Bitmap.Config.ARGB_8888);
                        float f = pgsParser$CueBuilder.bitmapX;
                        float f2 = pgsParser$CueBuilder.planeWidth;
                        float f3 = f / f2;
                        float f4 = pgsParser$CueBuilder.bitmapY;
                        float f5 = pgsParser$CueBuilder.planeHeight;
                        cue = new Cue(null, null, null, bitmapCreateBitmap, f4 / f5, 0, 0, f3, 0, Integer.MIN_VALUE, -3.4028235E38f, pgsParser$CueBuilder.bitmapWidth / f2, pgsParser$CueBuilder.bitmapHeight / f5, false, -16777216, Integer.MIN_VALUE, CropImageView.DEFAULT_ASPECT_RATIO, 0);
                    }
                    i3 = 0;
                    pgsParser$CueBuilder.planeWidth = 0;
                    pgsParser$CueBuilder.planeHeight = 0;
                    pgsParser$CueBuilder.bitmapX = 0;
                    pgsParser$CueBuilder.bitmapY = 0;
                    pgsParser$CueBuilder.bitmapWidth = 0;
                    pgsParser$CueBuilder.bitmapHeight = 0;
                    parsableByteArray.reset(0);
                    pgsParser$CueBuilder.colorsSet = false;
                }
                parsableByteArray3.setPosition(i9);
            }
            if (cue != null) {
                arrayList.add(cue);
            }
            i7 = i3;
        }
        consumer.accept(new CuesWithTiming(-9223372036854775807L, -9223372036854775807L, arrayList));
    }

    public void removeController(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        synchronized (this.executorServiceOrNull) {
            try {
                ConnectedControllersManager$ConnectedControllerRecord connectedControllersManager$ConnectedControllerRecord = (ConnectedControllersManager$ConnectedControllerRecord) ((ArrayMap) this.runningAsyncCalls).remove(mediaSession$ControllerInfo);
                if (connectedControllersManager$ConnectedControllerRecord == null) {
                    return;
                }
                ((ArrayMap) this.readyAsyncCalls).remove(connectedControllersManager$ConnectedControllerRecord.controllerKey);
                connectedControllersManager$ConnectedControllerRecord.sequencedFutureManager.release();
                MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) ((WeakReference) this.runningSyncCalls).get();
                if (mediaLibrarySessionImpl == null || mediaLibrarySessionImpl.isReleased()) {
                    return;
                }
                Util.postOrRun(mediaLibrarySessionImpl.applicationHandler, new MediaSessionImpl$$ExternalSyntheticLambda5(mediaLibrarySessionImpl, mediaSession$ControllerInfo, (byte) 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public Object runIfNeeded(ContinuationImpl continuationImpl) throws Throwable {
        RunOnce$runIfNeeded$1 runOnce$runIfNeeded$1;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        CompletableDeferredImpl completableDeferredImpl = (CompletableDeferredImpl) this.readyAsyncCalls;
        if (continuationImpl instanceof RunOnce$runIfNeeded$1) {
            runOnce$runIfNeeded$1 = (RunOnce$runIfNeeded$1) continuationImpl;
            int i = runOnce$runIfNeeded$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                runOnce$runIfNeeded$1.label = i - Integer.MIN_VALUE;
            } else {
                runOnce$runIfNeeded$1 = new RunOnce$runIfNeeded$1(this, continuationImpl);
            }
        } else {
            runOnce$runIfNeeded$1 = new RunOnce$runIfNeeded$1(this, continuationImpl);
        }
        Object obj = runOnce$runIfNeeded$1.result;
        int i2 = runOnce$runIfNeeded$1.label;
        Unit unit = Unit.INSTANCE;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if (completableDeferredImpl.isCompleted()) {
                    return unit;
                }
                mutex = (MutexImpl) this.executorServiceOrNull;
                runOnce$runIfNeeded$1.L$0 = mutex;
                runOnce$runIfNeeded$1.label = 1;
                if (mutex.lock(runOnce$runIfNeeded$1) != obj2) {
                }
                return obj2;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mutex2 = runOnce$runIfNeeded$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    completableDeferredImpl.makeCompleting$kotlinx_coroutines_core(unit);
                    mutex2.unlock(null);
                    return unit;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = runOnce$runIfNeeded$1.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            if (completableDeferredImpl.isCompleted()) {
                mutex.unlock(null);
                return unit;
            }
            runOnce$runIfNeeded$1.L$0 = mutex;
            runOnce$runIfNeeded$1.label = 2;
            if (doRun(runOnce$runIfNeeded$1) != obj2) {
                mutex2 = mutex;
                completableDeferredImpl.makeCompleting$kotlinx_coroutines_core(unit);
                mutex2.unlock(null);
                return unit;
            }
            return obj2;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
    }

    public void stopDispatching(PointerEvent pointerEvent) {
        if (((PointerInteropFilter.DispatchToViewState) this.readyAsyncCalls) == PointerInteropFilter.DispatchToViewState.Dispatching) {
            NodeCoordinator nodeCoordinator = (NodeCoordinator) this.executorServiceOrNull;
            if (nodeCoordinator == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("layoutCoordinates not set");
                return;
            } else {
                PointerIconKt.m589toMotionEventScopeubNVwUQ(pointerEvent, nodeCoordinator.mo606localToRootMKHz9U(0L), new TextKt$$ExternalSyntheticLambda2((byte) 23, (PointerInteropFilter) this.runningSyncCalls), true);
            }
        }
        this.readyAsyncCalls = PointerInteropFilter.DispatchToViewState.NotDispatching;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 16:
                String string = ((java.net.Socket) this.executorServiceOrNull).toString();
                string.getClass();
                return string;
            default:
                return super.toString();
        }
    }

    public void unblock$room_runtime() {
        synchronized (this) {
            ((AtomicInteger) this.readyAsyncCalls).decrementAndGet();
            if (((AtomicInteger) this.readyAsyncCalls).get() < 0) {
                throw new IllegalStateException("Unbalanced call to unblock() detected.");
            }
        }
    }

    public boolean isSessionCommandAvailable(MediaSession$ControllerInfo mediaSession$ControllerInfo, SessionCommand sessionCommand) {
        ConnectedControllersManager$ConnectedControllerRecord connectedControllersManager$ConnectedControllerRecord;
        synchronized (this.executorServiceOrNull) {
            connectedControllersManager$ConnectedControllerRecord = (ConnectedControllersManager$ConnectedControllerRecord) ((ArrayMap) this.runningAsyncCalls).get(mediaSession$ControllerInfo);
        }
        if (connectedControllersManager$ConnectedControllerRecord == null) {
            return false;
        }
        ImmutableSet immutableSet = connectedControllersManager$ConnectedControllerRecord.sessionCommands.commands;
        sessionCommand.getClass();
        return immutableSet.contains(sessionCommand) || CommandButton.isPredefinedCustomCommandButtonCode(sessionCommand.customAction);
    }

    public void flushCommandQueue(final MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        synchronized (this.executorServiceOrNull) {
            try {
                ConnectedControllersManager$ConnectedControllerRecord connectedControllersManager$ConnectedControllerRecord = (ConnectedControllersManager$ConnectedControllerRecord) ((ArrayMap) this.runningAsyncCalls).get(mediaSession$ControllerInfo);
                if (connectedControllersManager$ConnectedControllerRecord == null) {
                    return;
                }
                final Player.Commands commands = connectedControllersManager$ConnectedControllerRecord.commandQueuePlayerCommands;
                connectedControllersManager$ConnectedControllerRecord.commandQueuePlayerCommands = Player.Commands.EMPTY;
                connectedControllersManager$ConnectedControllerRecord.commandQueue.add(new ConnectedControllersManager$AsyncCommand(mediaSession$ControllerInfo, commands) { // from class: androidx.media3.session.ConnectedControllersManager$$ExternalSyntheticLambda0
                    public final /* synthetic */ MediaSession$ControllerInfo f$1;

                    @Override // androidx.media3.session.ConnectedControllersManager$AsyncCommand
                    public final ListenableFuture run() {
                        MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) ((WeakReference) this.f$0.runningSyncCalls).get();
                        if (mediaLibrarySessionImpl != null) {
                            mediaLibrarySessionImpl.onPlayerInteractionFinishedOnHandler(this.f$1);
                        }
                        return ImmediateFuture.NULL;
                    }
                });
                if (connectedControllersManager$ConnectedControllerRecord.commandQueueIsFlushing) {
                    return;
                }
                connectedControllersManager$ConnectedControllerRecord.commandQueueIsFlushing = true;
                flushCommandQueue(connectedControllersManager$ConnectedControllerRecord);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Dispatcher(ViewModelStore viewModelStore, ViewModelProvider$Factory viewModelProvider$Factory, CreationExtras creationExtras) {
        this.$r8$classId = (byte) 7;
        viewModelStore.getClass();
        creationExtras.getClass();
        this.executorServiceOrNull = viewModelStore;
        this.readyAsyncCalls = viewModelProvider$Factory;
        this.runningAsyncCalls = creationExtras;
        this.runningSyncCalls = new SynchronizedObject();
    }

    public Dispatcher(RoomDatabase$closeBarrier$1 roomDatabase$closeBarrier$1) {
        this.$r8$classId = (byte) 14;
        this.executorServiceOrNull = roomDatabase$closeBarrier$1;
        this.readyAsyncCalls = new AtomicInteger(0);
        this.runningAsyncCalls = new AtomicBoolean(false);
        this.runningSyncCalls = new AtomicBoolean(false);
    }

    public Dispatcher(java.net.Socket socket) {
        this.$r8$classId = (byte) 16;
        this.executorServiceOrNull = socket;
        this.readyAsyncCalls = new AtomicInteger();
        this.runningAsyncCalls = new Source() { // from class: okio.internal.DefaultSocket$SocketSource
            public final InputStream inputStream;
            public final SocketAsyncTimeout timeout;

            {
                java.net.Socket socket2 = (java.net.Socket) this.this$0.executorServiceOrNull;
                this.inputStream = socket2.getInputStream();
                this.timeout = new SocketAsyncTimeout(socket2);
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public final void close() throws IOException {
                int i;
                Dispatcher dispatcher = this.this$0;
                SocketAsyncTimeout socketAsyncTimeout = this.timeout;
                socketAsyncTimeout.enter();
                try {
                    try {
                        AtomicInteger atomicInteger = (AtomicInteger) dispatcher.readyAsyncCalls;
                        java.net.Socket socket2 = (java.net.Socket) dispatcher.executorServiceOrNull;
                        atomicInteger.getClass();
                        while (true) {
                            int i2 = atomicInteger.get();
                            if ((i2 & 2) != 0) {
                                i = 0;
                                break;
                            }
                            int i3 = i2 | 2;
                            if (atomicInteger.compareAndSet(i2, i3)) {
                                i = i3;
                                break;
                            }
                        }
                        if (i == 0) {
                            socketAsyncTimeout.exit();
                            return;
                        }
                        if (i == 3) {
                            socket2.close();
                        } else if (socket2.isClosed() || socket2.isInputShutdown()) {
                            socketAsyncTimeout.exit();
                            return;
                        } else {
                            try {
                                socket2.shutdownInput();
                            } catch (UnsupportedOperationException unused) {
                                this.inputStream.close();
                            }
                        }
                        if (socketAsyncTimeout.exit()) {
                            throw socketAsyncTimeout.newTimeoutException(null);
                        }
                    } catch (IOException e) {
                        if (!socketAsyncTimeout.exit()) {
                            throw e;
                        }
                        throw socketAsyncTimeout.newTimeoutException(e);
                    }
                } catch (Throwable th) {
                    socketAsyncTimeout.exit();
                    throw th;
                }
            }

            @Override // okio.Source
            public final long read(Buffer buffer, long j) throws IOException {
                buffer.getClass();
                if (j == 0) {
                    return 0L;
                }
                if (j < 0) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount < 0: "));
                    return 0L;
                }
                SocketAsyncTimeout socketAsyncTimeout = this.timeout;
                socketAsyncTimeout.throwIfReached();
                Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
                int iMin = (int) Math.min(j, 8192 - segmentWritableSegment$okio.limit);
                try {
                    socketAsyncTimeout.enter();
                    try {
                        try {
                            int i = this.inputStream.read(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, iMin);
                            if (socketAsyncTimeout.exit()) {
                                throw socketAsyncTimeout.newTimeoutException(null);
                            }
                            if (i != -1) {
                                segmentWritableSegment$okio.limit += i;
                                long j2 = i;
                                buffer.size += j2;
                                return j2;
                            }
                            if (segmentWritableSegment$okio.pos != segmentWritableSegment$okio.limit) {
                                return -1L;
                            }
                            buffer.head = segmentWritableSegment$okio.pop();
                            SegmentPool.recycle(segmentWritableSegment$okio);
                            return -1L;
                        } catch (IOException e) {
                            if (socketAsyncTimeout.exit()) {
                                throw socketAsyncTimeout.newTimeoutException(e);
                            }
                            throw e;
                        }
                    } catch (Throwable th) {
                        socketAsyncTimeout.exit();
                        throw th;
                    }
                } catch (AssertionError e2) {
                    if (_JavaIoKt.isAndroidGetsocknameError(e2)) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
            }

            @Override // okio.Source
            public final Timeout timeout() {
                return this.timeout;
            }

            public final String toString() {
                return "source(" + ((java.net.Socket) this.this$0.executorServiceOrNull) + ')';
            }
        };
        this.runningSyncCalls = new Sink() { // from class: okio.internal.DefaultSocket$SocketSink
            public final OutputStream outputStream;
            public final SocketAsyncTimeout timeout;

            {
                java.net.Socket socket2 = (java.net.Socket) this.this$0.executorServiceOrNull;
                this.outputStream = socket2.getOutputStream();
                this.timeout = new SocketAsyncTimeout(socket2);
            }

            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public final void close() throws IOException {
                int i;
                OutputStream outputStream = this.outputStream;
                Dispatcher dispatcher = this.this$0;
                SocketAsyncTimeout socketAsyncTimeout = this.timeout;
                socketAsyncTimeout.enter();
                try {
                    try {
                        AtomicInteger atomicInteger = (AtomicInteger) dispatcher.readyAsyncCalls;
                        java.net.Socket socket2 = (java.net.Socket) dispatcher.executorServiceOrNull;
                        atomicInteger.getClass();
                        while (true) {
                            int i2 = atomicInteger.get();
                            if ((i2 & 1) != 0) {
                                i = 0;
                                break;
                            }
                            int i3 = i2 | 1;
                            if (atomicInteger.compareAndSet(i2, i3)) {
                                i = i3;
                                break;
                            }
                        }
                        if (i == 0) {
                            socketAsyncTimeout.exit();
                            return;
                        }
                        if (i != 3) {
                            if (!socket2.isClosed() && !socket2.isOutputShutdown()) {
                                outputStream.flush();
                                try {
                                    socket2.shutdownOutput();
                                } catch (UnsupportedOperationException unused) {
                                    outputStream.close();
                                }
                            }
                            socketAsyncTimeout.exit();
                            return;
                        }
                        socket2.close();
                        if (socketAsyncTimeout.exit()) {
                            throw socketAsyncTimeout.newTimeoutException(null);
                        }
                    } catch (Throwable th) {
                        socketAsyncTimeout.exit();
                        throw th;
                    }
                } catch (IOException e) {
                    if (!socketAsyncTimeout.exit()) {
                        throw e;
                    }
                    throw socketAsyncTimeout.newTimeoutException(e);
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public final void flush() throws IOException {
                SocketAsyncTimeout socketAsyncTimeout = this.timeout;
                socketAsyncTimeout.enter();
                try {
                    try {
                        this.outputStream.flush();
                        if (socketAsyncTimeout.exit()) {
                            throw socketAsyncTimeout.newTimeoutException(null);
                        }
                    } catch (IOException e) {
                        if (!socketAsyncTimeout.exit()) {
                            throw e;
                        }
                        throw socketAsyncTimeout.newTimeoutException(e);
                    }
                } catch (Throwable th) {
                    socketAsyncTimeout.exit();
                    throw th;
                }
            }

            @Override // okio.Sink
            public final Timeout timeout() {
                return this.timeout;
            }

            public final String toString() {
                return "sink(" + ((java.net.Socket) this.this$0.executorServiceOrNull) + ')';
            }

            @Override // okio.Sink
            public final void write(Buffer buffer, long j) throws IOException {
                buffer.getClass();
                HexFormatKt.checkOffsetAndCount(buffer.size, 0L, j);
                while (j > 0) {
                    SocketAsyncTimeout socketAsyncTimeout = this.timeout;
                    socketAsyncTimeout.throwIfReached();
                    Segment segment = buffer.head;
                    segment.getClass();
                    int iMin = (int) Math.min(j, segment.limit - segment.pos);
                    socketAsyncTimeout.enter();
                    try {
                        try {
                            this.outputStream.write(segment.data, segment.pos, iMin);
                            if (socketAsyncTimeout.exit()) {
                                throw socketAsyncTimeout.newTimeoutException(null);
                            }
                            int i = segment.pos + iMin;
                            segment.pos = i;
                            long j2 = iMin;
                            j -= j2;
                            buffer.size -= j2;
                            if (i == segment.limit) {
                                buffer.head = segment.pop();
                                SegmentPool.recycle(segment);
                            }
                        } catch (IOException e) {
                            if (!socketAsyncTimeout.exit()) {
                                throw e;
                            }
                            throw socketAsyncTimeout.newTimeoutException(e);
                        }
                    } catch (Throwable th) {
                        socketAsyncTimeout.exit();
                        throw th;
                    }
                }
            }
        };
    }

    public Dispatcher(PointerInteropFilter pointerInteropFilter) {
        this.$r8$classId = (byte) 3;
        this.runningSyncCalls = pointerInteropFilter;
        this.readyAsyncCalls = PointerInteropFilter.DispatchToViewState.Unknown;
    }

    public Dispatcher(byte b) {
        this.$r8$classId = b;
        switch (b) {
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                this.executorServiceOrNull = new ParsableByteArray();
                this.readyAsyncCalls = new ParsableByteArray();
                this.runningAsyncCalls = new PgsParser$CueBuilder();
                break;
            default:
                this.readyAsyncCalls = new ArrayDeque();
                this.runningAsyncCalls = new ArrayDeque();
                this.runningSyncCalls = new ArrayDeque();
                break;
        }
    }

    public Dispatcher(MediaLibrarySessionImpl mediaLibrarySessionImpl) {
        this.$r8$classId = (byte) 13;
        this.readyAsyncCalls = new ArrayMap(0);
        this.runningAsyncCalls = new ArrayMap(0);
        this.executorServiceOrNull = new Object();
        this.runningSyncCalls = new WeakReference(mediaLibrarySessionImpl);
    }

    public Dispatcher(CoroutineScope coroutineScope, DiskLruCache$$ExternalSyntheticLambda0 diskLruCache$$ExternalSyntheticLambda0, SaversKt$$ExternalSyntheticLambda5 saversKt$$ExternalSyntheticLambda5, App.C01391 c01391) {
        this.$r8$classId = (byte) 5;
        this.executorServiceOrNull = coroutineScope;
        this.readyAsyncCalls = c01391;
        this.runningAsyncCalls = EntryPoints.Channel$default(Integer.MAX_VALUE, 6, null);
        this.runningSyncCalls = new AtomicInt((byte) 0);
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.Key.$$INSTANCE);
        if (job != null) {
            job.invokeOnCompletion(new UtilsKt$$ExternalSyntheticLambda0((Object) diskLruCache$$ExternalSyntheticLambda0, (Object) this, (Object) saversKt$$ExternalSyntheticLambda5, (byte) 25));
        }
    }

    public Dispatcher(Context context) {
        this.$r8$classId = (byte) 10;
        this.executorServiceOrNull = context != null ? context.getApplicationContext() : null;
        this.runningAsyncCalls = AudioSink.AudioTrackConfig.DEFAULT;
        if (context == null) {
            this.runningSyncCalls = AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES;
        }
    }

    public Dispatcher(Context context, android.view.ActionMode.Callback callback) {
        this.$r8$classId = (byte) 1;
        this.readyAsyncCalls = context;
        this.executorServiceOrNull = callback;
        this.runningAsyncCalls = new ArrayList();
        this.runningSyncCalls = new SimpleArrayMap(0);
    }

    public Dispatcher(BufferedChannel bufferedChannel, Function3 function3, Function3 function4, ListItemKt$$ExternalSyntheticLambda17 listItemKt$$ExternalSyntheticLambda17) {
        this.$r8$classId = (byte) 15;
        this.executorServiceOrNull = bufferedChannel;
        this.readyAsyncCalls = function3;
        this.runningAsyncCalls = function4;
        this.runningSyncCalls = listItemKt$$ExternalSyntheticLambda17;
    }

    public Dispatcher(RegularImmutableList regularImmutableList, NalUnitUtil$H265VideoSignalInfosAndIndices nalUnitUtil$H265VideoSignalInfosAndIndices, WeakCache weakCache, NalUnitUtil$H265VideoSignalInfosAndIndices nalUnitUtil$H265VideoSignalInfosAndIndices2) {
        Object objCopyOf;
        this.$r8$classId = (byte) 8;
        if (regularImmutableList != null) {
            objCopyOf = ImmutableList.copyOf((Collection) regularImmutableList);
        } else {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            objCopyOf = RegularImmutableList.EMPTY;
        }
        this.executorServiceOrNull = objCopyOf;
        this.readyAsyncCalls = nalUnitUtil$H265VideoSignalInfosAndIndices;
        this.runningAsyncCalls = weakCache;
        this.runningSyncCalls = nalUnitUtil$H265VideoSignalInfosAndIndices2;
    }

    public Dispatcher(DataStoreImpl dataStoreImpl, List list) {
        this.$r8$classId = (byte) 4;
        this.runningSyncCalls = dataStoreImpl;
        this.executorServiceOrNull = new MutexImpl();
        this.readyAsyncCalls = AwaitKt.CompletableDeferred$default();
        this.runningAsyncCalls = CollectionsKt.toList(list);
    }

    public Dispatcher(AudioTrack audioTrack, AtomicInt atomicInt) {
        this.$r8$classId = (byte) 9;
        this.executorServiceOrNull = audioTrack;
        this.readyAsyncCalls = atomicInt;
        Handler handlerCreateHandlerForCurrentLooper = Util.createHandlerForCurrentLooper(null);
        this.runningAsyncCalls = handlerCreateHandlerForCurrentLooper;
        AudioRouting.OnRoutingChangedListener onRoutingChangedListener = new AudioRouting.OnRoutingChangedListener() { // from class: androidx.media3.exoplayer.audio.AudioTrackAudioOutput$OnRoutingChangedListenerApi24$$ExternalSyntheticLambda0
            @Override // android.media.AudioRouting.OnRoutingChangedListener
            public final void onRoutingChanged(AudioRouting audioRouting) {
                Dispatcher dispatcher = this.f$0;
                if (((AudioTrackAudioOutput$OnRoutingChangedListenerApi24$$ExternalSyntheticLambda0) dispatcher.runningSyncCalls) == null) {
                    return;
                }
                Log.get().execute(new ComponentActivity$$ExternalSyntheticLambda10(dispatcher, audioRouting, (byte) 21));
            }
        };
        this.runningSyncCalls = onRoutingChangedListener;
        audioTrack.addOnRoutingChangedListener(onRoutingChangedListener, handlerCreateHandlerForCurrentLooper);
    }

    public Dispatcher(Animations animations) {
        this.$r8$classId = (byte) 2;
        this.executorServiceOrNull = animations;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Dispatcher(FloatAnimationSpec floatAnimationSpec) {
        this(new DrawResult((byte) 11, (Object) floatAnimationSpec));
        this.$r8$classId = (byte) 2;
    }

    public Dispatcher(TrackGroupArray trackGroupArray, boolean[] zArr) {
        this.$r8$classId = (byte) 11;
        this.executorServiceOrNull = trackGroupArray;
        this.readyAsyncCalls = zArr;
        int i = trackGroupArray.length;
        this.runningAsyncCalls = new boolean[i];
        this.runningSyncCalls = new boolean[i];
    }
}
