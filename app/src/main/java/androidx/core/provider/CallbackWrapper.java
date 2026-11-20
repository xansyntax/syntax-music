package androidx.core.provider;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.PowerManager;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.widget.EditText;
import androidx.appcompat.app.AlertController;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableOrderedScatterSet;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.Values;
import androidx.collection.internal.Lock;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.compose.runtime.CancellationHandle;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.PausedCompositionImpl;
import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.android.selection.SegmentFinder;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.core.app.ActivityRecreator;
import androidx.datastore.core.AtomicInt;
import androidx.emoji2.text.EmojiProcessor;
import androidx.emoji2.viewsintegration.EmojiEditableFactory;
import androidx.emoji2.viewsintegration.EmojiTextWatcher;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.container.ObuParser$NotYetImplementedException;
import androidx.media3.container.ObuParser$Obu;
import androidx.media3.container.ObuParser$SequenceHeader;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.okhttp.OkHttpDataSource;
import androidx.media3.exoplayer.CodecParameters;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.extractor.BinarySearchSeeker$TimestampSeeker;
import androidx.media3.session.legacy.IMediaControllerCallback;
import androidx.media3.session.legacy.IMediaSession;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaButtonReceiver;
import androidx.media3.session.legacy.MediaControllerCompat$MediaControllerImplApi23;
import androidx.media3.session.legacy.MediaControllerCompat$MediaControllerImplApi29;
import androidx.media3.session.legacy.MediaControllerCompat$TransportControlsApi29;
import androidx.media3.session.legacy.MediaDescriptionCompat;
import androidx.media3.session.legacy.MediaMetadataCompat;
import androidx.media3.session.legacy.MediaSessionCompat$1;
import androidx.media3.session.legacy.MediaSessionCompat$Callback;
import androidx.media3.session.legacy.MediaSessionCompat$MediaSessionImplApi23;
import androidx.media3.session.legacy.MediaSessionCompat$MediaSessionImplApi28;
import androidx.media3.session.legacy.MediaSessionCompat$MediaSessionImplApi29;
import androidx.media3.session.legacy.MediaSessionCompat$QueueItem;
import androidx.media3.session.legacy.MediaSessionCompat$Token;
import androidx.media3.session.legacy.PlaybackStateCompat;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.google.common.util.concurrent.ListenableFuture;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CallbackWrapper implements SubcomposeSlotReusePolicy, CancellationHandle, Saver, SubcomposeLayoutState.PausedPrecomposition, ClipboardManager, SegmentFinder, DataSource.Factory, BinarySearchSeeker$TimestampSeeker, BitmapLoader {
    public final /* synthetic */ byte $r8$classId;
    public Object mCallback;
    public Object mExecutor;

    /* JADX INFO: renamed from: androidx.core.provider.CallbackWrapper$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements Runnable {
        public final /* synthetic */ AtomicInt val$callback;
        public final /* synthetic */ int val$reason;

        public AnonymousClass2(AtomicInt atomicInt, int i) {
            this.val$callback = atomicInt;
            this.val$reason = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TimedValueQueue timedValueQueue = (TimedValueQueue) this.val$callback.delegate;
            if (timedValueQueue != null) {
                timedValueQueue.onFontRetrievalFailed(this.val$reason);
            }
        }
    }

    public CallbackWrapper(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23;
        this.$r8$classId = (byte) 1;
        if (TextUtils.isEmpty(str)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("tag must not be null or empty");
            throw null;
        }
        if (componentName == null) {
            int i = MediaButtonReceiver.$r8$clinit;
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
            intent.setPackage(context.getPackageName());
            List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            if (listQueryBroadcastReceivers.size() == 1) {
                ActivityInfo activityInfo = listQueryBroadcastReceivers.get(0).activityInfo;
                componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
            } else {
                if (listQueryBroadcastReceivers.size() > 1) {
                    Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
                }
                componentName = null;
            }
            if (componentName == null) {
                Log.i("MediaSessionCompat", "Couldn't find a unique registered media button receiver in the given context.");
            }
        }
        if (componentName != null && pendingIntent == null) {
            Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON");
            intent2.setComponent(componentName);
            pendingIntent = PendingIntent.getBroadcast(context, 0, intent2, Build.VERSION.SDK_INT >= 31 ? 33554432 : 0);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            mediaSessionCompat$MediaSessionImplApi23 = new MediaSessionCompat$MediaSessionImplApi29(context, str, bundle);
            this.mCallback = mediaSessionCompat$MediaSessionImplApi23;
        } else if (i2 >= 28) {
            mediaSessionCompat$MediaSessionImplApi23 = new MediaSessionCompat$MediaSessionImplApi28(context, str, bundle);
            this.mCallback = mediaSessionCompat$MediaSessionImplApi23;
        } else {
            mediaSessionCompat$MediaSessionImplApi23 = new MediaSessionCompat$MediaSessionImplApi23(context, str, bundle);
            this.mCallback = mediaSessionCompat$MediaSessionImplApi23;
        }
        Looper looperMyLooper = Looper.myLooper();
        setCallback(new MediaSessionCompat$1(), new Handler(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper));
        mediaSessionCompat$MediaSessionImplApi23.sessionFwk.setMediaButtonReceiver(pendingIntent);
        this.mExecutor = new CallbackWrapper(context, mediaSessionCompat$MediaSessionImplApi23.token);
    }

    public static CodecParameters createFilteredCodecParameters(CodecParameters codecParameters, List list) {
        codecParameters.getClass();
        Map map = codecParameters.params;
        HashMap map2 = new HashMap(map);
        HashSet hashSet = new HashSet(list);
        for (String str : map.keySet()) {
            if (!hashSet.contains(str)) {
                map2.remove(str);
            }
        }
        return new CodecParameters(map2);
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        MediaControllerCompat$MediaControllerImplApi23 mediaControllerCompat$MediaControllerImplApi23 = (MediaControllerCompat$MediaControllerImplApi23) this.mCallback;
        if ((mediaControllerCompat$MediaControllerImplApi23.controllerFwk.getFlags() & 4) == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", DatabaseDao_Impl.AnonymousClass17.convert(mediaDescriptionCompat, android.support.v4.media.MediaDescriptionCompat.CREATOR));
        bundle.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", i);
        mediaControllerCompat$MediaControllerImplApi23.controllerFwk.sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT", bundle, null);
    }

    public TextFieldValue apply(List list) throws IOException {
        EditCommand editCommand;
        Exception e;
        try {
            int size = list.size();
            int i = 0;
            editCommand = null;
            while (i < size) {
                try {
                    EditCommand editCommand2 = (EditCommand) list.get(i);
                    try {
                        editCommand2.applyTo((LongArrayQueue) this.mExecutor);
                        i++;
                        editCommand = editCommand2;
                    } catch (Exception e2) {
                        e = e2;
                        editCommand = editCommand2;
                        StringBuilder sb = new StringBuilder();
                        int length = ((TimedValueQueue) ((LongArrayQueue) this.mExecutor).data).getLength();
                        TextRange textRangeM836getCompositionMzsxiRA$ui_text = ((LongArrayQueue) this.mExecutor).m836getCompositionMzsxiRA$ui_text();
                        LongArrayQueue longArrayQueue = (LongArrayQueue) this.mExecutor;
                        sb.append("Error while applying EditCommand batch to buffer (length=" + length + ", composition=" + textRangeM836getCompositionMzsxiRA$ui_text + ", selection=" + TextRange.m746toStringimpl(TextRangeKt.TextRange(longArrayQueue.headIndex, longArrayQueue.tailIndex)) + "):");
                        sb.append('\n');
                        CollectionsKt.joinTo$default(list, sb, "\n", new DiskLruCache$$ExternalSyntheticLambda0(editCommand, this, (byte) 8), 60);
                        throw new RuntimeException(sb.toString(), e);
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            LongArrayQueue longArrayQueue2 = (LongArrayQueue) this.mExecutor;
            longArrayQueue2.getClass();
            AnnotatedString annotatedString = new AnnotatedString(((TimedValueQueue) longArrayQueue2.data).toString());
            LongArrayQueue longArrayQueue3 = (LongArrayQueue) this.mExecutor;
            long jTextRange = TextRangeKt.TextRange(longArrayQueue3.headIndex, longArrayQueue3.tailIndex);
            TextRange textRange = TextRange.m745getReversedimpl(((TextFieldValue) this.mCallback).selection) ? null : new TextRange(jTextRange);
            TextFieldValue textFieldValue = new TextFieldValue(annotatedString, textRange != null ? textRange.packedValue : TextRangeKt.TextRange(TextRange.m743getMaximpl(jTextRange), TextRange.m744getMinimpl(jTextRange)), ((LongArrayQueue) this.mExecutor).m836getCompositionMzsxiRA$ui_text());
            this.mCallback = textFieldValue;
            return textFieldValue;
        } catch (Exception e4) {
            editCommand = null;
            e = e4;
        }
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public boolean areCompatible(Object obj, Object obj2) {
        LazyLayoutItemContentFactory lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) this.mCallback;
        return Intrinsics.areEqual(lazyLayoutItemContentFactory.getContentType(obj), lazyLayoutItemContentFactory.getContentType(obj2));
    }

    @Override // androidx.compose.runtime.CancellationHandle
    public void cancel() {
        switch (this.$r8$classId) {
            case 6:
                if (!((androidx.compose.runtime.internal.AtomicInt) this.mExecutor).compareAndSet(1, 1)) {
                    ((GapComposer$$ExternalSyntheticLambda0) this.mCallback).invoke();
                }
                break;
            default:
                LayoutNodeSubcompositionsState.NodeState nodeState = getNodeState();
                if ((nodeState != null ? nodeState.pausedComposition : null) != null) {
                    ((LayoutNodeSubcompositionsState) this.mCallback).disposePrecomposedSlot(this.mExecutor);
                }
                break;
        }
    }

    public boolean contains(int i) {
        return ((FlagSet) this.mCallback).flags.get(i);
    }

    @Override // androidx.media3.datasource.DataSource.Factory
    public DataSource createDataSource() {
        return new OkHttpDataSource((OkHttpClient) this.mExecutor, (CallbackWrapper) this.mCallback);
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public ListenableFuture decodeBitmap(byte[] bArr) {
        byte[] bArr2;
        EmojiProcessor emojiProcessor = (EmojiProcessor) this.mExecutor;
        if (emojiProcessor == null || (bArr2 = (byte[]) emojiProcessor.mSpanFactory) == null || !Arrays.equals(bArr2, bArr)) {
            ListenableFuture listenableFutureDecodeBitmap = ((BitmapLoader) this.mCallback).decodeBitmap(bArr);
            this.mExecutor = new EmojiProcessor(bArr, listenableFutureDecodeBitmap);
            return listenableFutureDecodeBitmap;
        }
        ListenableFuture listenableFuture = (ListenableFuture) ((EmojiProcessor) this.mExecutor).mGlyphChecker;
        listenableFuture.getClass();
        return listenableFuture;
    }

    public android.content.ClipboardManager getClipboardManager() {
        android.content.ClipboardManager clipboardManager = (android.content.ClipboardManager) this.mExecutor;
        if (clipboardManager != null) {
            return clipboardManager;
        }
        Object systemService = ((Context) this.mCallback).getSystemService("clipboard");
        systemService.getClass();
        android.content.ClipboardManager clipboardManager2 = (android.content.ClipboardManager) systemService;
        this.mExecutor = clipboardManager2;
        return clipboardManager2;
    }

    public AnalyticsListener.EventTime getEventTime(int i) {
        AnalyticsListener.EventTime eventTime = (AnalyticsListener.EventTime) ((SparseArray) this.mExecutor).get(i);
        eventTime.getClass();
        return eventTime;
    }

    public LayoutNodeSubcompositionsState.NodeState getNodeState() {
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = (LayoutNodeSubcompositionsState) this.mCallback;
        LayoutNode layoutNode = (LayoutNode) layoutNodeSubcompositionsState.precomposeMap.get(this.mExecutor);
        if (layoutNode != null) {
            return (LayoutNodeSubcompositionsState.NodeState) layoutNodeSubcompositionsState.nodeToNodeState.get(layoutNode);
        }
        return null;
    }

    public PlaybackStateCompat getPlaybackState() {
        MediaControllerCompat$MediaControllerImplApi23 mediaControllerCompat$MediaControllerImplApi23 = (MediaControllerCompat$MediaControllerImplApi23) this.mCallback;
        IMediaSession extraBinder = mediaControllerCompat$MediaControllerImplApi23.sessionToken.getExtraBinder();
        if (extraBinder != null) {
            try {
                return extraBinder.getPlaybackState();
            } catch (RemoteException | SecurityException e) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e);
            }
        }
        PlaybackState playbackState = mediaControllerCompat$MediaControllerImplApi23.controllerFwk.getPlaybackState();
        if (playbackState != null) {
            return PlaybackStateCompat.fromPlaybackState(playbackState);
        }
        return null;
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public void getSlotsToRetain(Values values) {
        MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) this.mExecutor;
        mutableObjectIntMap.clear();
        MutableOrderedScatterSet mutableOrderedScatterSet = (MutableOrderedScatterSet) values.parent;
        Object[] objArr = mutableOrderedScatterSet.elements;
        long[] jArr = mutableOrderedScatterSet.nodes;
        int i = mutableOrderedScatterSet.tail;
        while (i != Integer.MAX_VALUE) {
            int i2 = (int) ((jArr[i] >> 31) & 2147483647L);
            Object obj = objArr[i];
            Object contentType = ((LazyLayoutItemContentFactory) this.mCallback).getContentType(obj);
            int iFindKeyIndex = mutableObjectIntMap.findKeyIndex(contentType);
            int i3 = iFindKeyIndex >= 0 ? mutableObjectIntMap.values[iFindKeyIndex] : 0;
            if (i3 == 7) {
                values.remove(obj);
            } else {
                mutableObjectIntMap.set(i3 + 1, contentType);
            }
            i = i2;
        }
    }

    public synchronized Map getSnapshot() {
        Map mapUnmodifiableMap;
        mapUnmodifiableMap = (Map) this.mExecutor;
        if (mapUnmodifiableMap == null) {
            mapUnmodifiableMap = Collections.unmodifiableMap(new HashMap((HashMap) this.mCallback));
            this.mExecutor = mapUnmodifiableMap;
        }
        return mapUnmodifiableMap;
    }

    public MediaBrowserCompat getTransportControls() {
        MediaController.TransportControls transportControls = ((MediaControllerCompat$MediaControllerImplApi23) this.mCallback).controllerFwk.getTransportControls();
        return Build.VERSION.SDK_INT >= 29 ? new MediaControllerCompat$TransportControlsApi29(transportControls) : new MediaBrowserCompat(transportControls);
    }

    @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
    public boolean isComplete() {
        PausedCompositionImpl pausedCompositionImpl;
        LayoutNodeSubcompositionsState.NodeState nodeState = getNodeState();
        if (nodeState == null || (pausedCompositionImpl = nodeState.pausedComposition) == null) {
            return true;
        }
        return pausedCompositionImpl.isComplete();
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public ListenableFuture loadBitmap(Uri uri) {
        Uri uri2;
        EmojiProcessor emojiProcessor = (EmojiProcessor) this.mExecutor;
        if (emojiProcessor == null || (uri2 = (Uri) emojiProcessor.mMetadataRepo) == null || !uri2.equals(uri)) {
            ListenableFuture listenableFutureLoadBitmap = ((BitmapLoader) this.mCallback).loadBitmap(uri);
            this.mExecutor = new EmojiProcessor(uri, listenableFutureLoadBitmap);
            return listenableFutureLoadBitmap;
        }
        ListenableFuture listenableFuture = (ListenableFuture) ((EmojiProcessor) this.mExecutor).mGlyphChecker;
        listenableFuture.getClass();
        return listenableFuture;
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public ListenableFuture loadBitmapFromMetadata(MediaMetadata mediaMetadata) {
        Uri uri;
        byte[] bArr;
        EmojiProcessor emojiProcessor = (EmojiProcessor) this.mExecutor;
        if (emojiProcessor != null && (((uri = (Uri) emojiProcessor.mMetadataRepo) != null && uri.equals(mediaMetadata.artworkUri)) || ((bArr = (byte[]) emojiProcessor.mSpanFactory) != null && Arrays.equals(bArr, mediaMetadata.artworkData)))) {
            ListenableFuture listenableFuture = (ListenableFuture) ((EmojiProcessor) this.mExecutor).mGlyphChecker;
            listenableFuture.getClass();
            return listenableFuture;
        }
        ListenableFuture listenableFutureLoadBitmapFromMetadata = ((BitmapLoader) this.mCallback).loadBitmapFromMetadata(mediaMetadata);
        if (listenableFutureLoadBitmapFromMetadata == null) {
            return null;
        }
        this.mExecutor = new EmojiProcessor(mediaMetadata, listenableFutureLoadBitmapFromMetadata);
        return listenableFutureLoadBitmapFromMetadata;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int nextEndBoundary(int i) {
        do {
            i = ((TimedValueQueue) this.mExecutor).nextBoundary(i);
            if (i == -1) {
                return -1;
            }
        } while (Character.isWhitespace(((CharSequence) this.mCallback).charAt(i - 1)));
        return i;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int nextStartBoundary(int i) {
        CharSequence charSequence = (CharSequence) this.mCallback;
        do {
            i = ((TimedValueQueue) this.mExecutor).nextBoundary(i);
            if (i == -1 || i == charSequence.length()) {
                return -1;
            }
        } while (Character.isWhitespace(charSequence.charAt(i)));
        return i;
    }

    public void onParametersChanged(CodecParameters codecParameters) {
        for (Map.Entry entry : new HashMap((HashMap) this.mCallback).entrySet()) {
            if (entry.getKey() != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
                return;
            } else {
                List list = (List) entry.getValue();
                if (!createFilteredCodecParameters(codecParameters, list).equals(createFilteredCodecParameters((CodecParameters) this.mExecutor, list))) {
                    throw null;
                }
            }
        }
        this.mExecutor = codecParameters;
    }

    @Override // androidx.media3.extractor.BinarySearchSeeker$TimestampSeeker
    public void onSeekFinished() {
        ParsableByteArray parsableByteArray = (ParsableByteArray) this.mExecutor;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        parsableByteArray.reset(bArr, bArr.length);
    }

    public void onTypefaceResult(FontRequestWorker.TypefaceResult typefaceResult) {
        RequestExecutor$HandlerExecutor requestExecutor$HandlerExecutor = (RequestExecutor$HandlerExecutor) this.mExecutor;
        AtomicInt atomicInt = (AtomicInt) this.mCallback;
        int i = typefaceResult.mResult;
        if (i == 0) {
            requestExecutor$HandlerExecutor.execute(new ActivityRecreator.AnonymousClass1(atomicInt, typefaceResult.mTypeface, (byte) 4));
        } else {
            requestExecutor$HandlerExecutor.execute(new AnonymousClass2(atomicInt, i));
        }
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int previousEndBoundary(int i) {
        do {
            i = ((TimedValueQueue) this.mExecutor).prevBoundary(i);
            if (i == -1 || i == 0) {
                return -1;
            }
        } while (Character.isWhitespace(((CharSequence) this.mCallback).charAt(i - 1)));
        return i;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int previousStartBoundary(int i) {
        do {
            i = ((TimedValueQueue) this.mExecutor).prevBoundary(i);
            if (i == -1) {
                return -1;
            }
        } while (Character.isWhitespace(((CharSequence) this.mCallback).charAt(i)));
        return i;
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        MediaControllerCompat$MediaControllerImplApi23 mediaControllerCompat$MediaControllerImplApi23 = (MediaControllerCompat$MediaControllerImplApi23) this.mCallback;
        if ((mediaControllerCompat$MediaControllerImplApi23.controllerFwk.getFlags() & 4) == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", DatabaseDao_Impl.AnonymousClass17.convert(mediaDescriptionCompat, android.support.v4.media.MediaDescriptionCompat.CREATOR));
        mediaControllerCompat$MediaControllerImplApi23.controllerFwk.sendCommand("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM", bundle, null);
    }

    @Override // androidx.compose.runtime.saveable.Saver
    public Object restore(Object obj) {
        return ((Function1) this.mExecutor).invoke(obj);
    }

    @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
    public boolean resume(TextLinkScope$$ExternalSyntheticLambda10 textLinkScope$$ExternalSyntheticLambda10) {
        LayoutNodeSubcompositionsState.NodeState nodeState = getNodeState();
        PausedCompositionImpl pausedCompositionImpl = nodeState != null ? nodeState.pausedComposition : null;
        if (pausedCompositionImpl == null || pausedCompositionImpl.isComplete()) {
            return true;
        }
        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            boolean zResume = pausedCompositionImpl.resume(textLinkScope$$ExternalSyntheticLambda10);
            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            return zResume;
        } catch (Throwable th) {
            try {
                nodeState.getClass();
                throw th;
            } catch (Throwable th2) {
                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                throw th2;
            }
        }
    }

    @Override // androidx.compose.runtime.saveable.Saver
    public Object save(SaveableHolder saveableHolder, Object obj) {
        return ((Function2) this.mCallback).invoke(saveableHolder, obj);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:38:0x00e2
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // androidx.media3.extractor.BinarySearchSeeker$TimestampSeeker
    public androidx.media3.extractor.BinarySearchSeeker$TimestampSearchResult searchForTimestamp(androidx.media3.extractor.ExtractorInput r17, long r18) {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.CallbackWrapper.searchForTimestamp(androidx.media3.extractor.ExtractorInput, long):androidx.media3.extractor.BinarySearchSeeker$TimestampSearchResult");
    }

    public void sendRequest(int i, Bundle bundle, Messenger messenger) throws RemoteException {
        Messenger messenger2 = (Messenger) this.mCallback;
        if (messenger2.getBinder().isBinderAlive()) {
            Message messageObtain = Message.obtain();
            messageObtain.what = i;
            messageObtain.arg1 = 1;
            if (bundle != null) {
                messageObtain.setData(bundle);
            }
            messageObtain.replyTo = messenger;
            messenger2.send(messageObtain);
        }
    }

    public void setCallback(MediaSessionCompat$Callback mediaSessionCompat$Callback, Handler handler) {
        MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23 = (MediaSessionCompat$MediaSessionImplApi23) this.mCallback;
        synchronized (mediaSessionCompat$MediaSessionImplApi23.lock) {
            mediaSessionCompat$MediaSessionImplApi23.callback = mediaSessionCompat$Callback;
            mediaSessionCompat$MediaSessionImplApi23.sessionFwk.setCallback((MediaSessionCompat$Callback.MediaSessionCallback) mediaSessionCompat$Callback.callbackFwk, handler);
            synchronized (mediaSessionCompat$Callback.lock) {
                try {
                    mediaSessionCompat$Callback.sessionImpl = new WeakReference(mediaSessionCompat$MediaSessionImplApi23);
                    AlertController.ButtonHandler buttonHandler = (AlertController.ButtonHandler) mediaSessionCompat$Callback.callbackHandler;
                    if (buttonHandler != null) {
                        buttonHandler.removeCallbacksAndMessages(null);
                    }
                    mediaSessionCompat$Callback.callbackHandler = new AlertController.ButtonHandler(mediaSessionCompat$Callback, handler.getLooper(), (byte) 6);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23 = (MediaSessionCompat$MediaSessionImplApi23) this.mCallback;
        mediaSessionCompat$MediaSessionImplApi23.metadata = mediaMetadataCompat;
        MediaSession mediaSession = mediaSessionCompat$MediaSessionImplApi23.sessionFwk;
        Bundle bundle = mediaMetadataCompat.bundle;
        android.media.MediaMetadata mediaMetadataBuild = mediaMetadataCompat.metadataFwk;
        if (mediaMetadataBuild == null) {
            android.media.MediaMetadata.Builder builder = new android.media.MediaMetadata.Builder();
            for (String str : bundle.keySet()) {
                Integer num = (Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str);
                if (num == null) {
                    num = -1;
                }
                int iIntValue = num.intValue();
                if (iIntValue == 0) {
                    builder.putLong(str, bundle.getLong(str));
                } else if (iIntValue == 1) {
                    builder.putText(str, bundle.getCharSequence(str));
                } else if (iIntValue == 2) {
                    builder.putBitmap(str, (Bitmap) bundle.getParcelable(str));
                } else if (iIntValue != 3) {
                    Object obj = bundle.get(str);
                    if (obj == null || (obj instanceof CharSequence)) {
                        builder.putText(str, (CharSequence) obj);
                    } else if (obj instanceof Long) {
                        builder.putLong(str, ((Long) obj).longValue());
                    }
                } else {
                    builder.putRating(str, (Rating) bundle.getParcelable(str));
                }
            }
            mediaMetadataBuild = builder.build();
            mediaMetadataCompat.metadataFwk = mediaMetadataBuild;
        }
        mediaSession.setMetadata(mediaMetadataBuild);
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        RemoteCallbackList remoteCallbackList;
        MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23 = (MediaSessionCompat$MediaSessionImplApi23) this.mCallback;
        mediaSessionCompat$MediaSessionImplApi23.playbackState = playbackStateCompat;
        synchronized (mediaSessionCompat$MediaSessionImplApi23.lock) {
            int iBeginBroadcast = mediaSessionCompat$MediaSessionImplApi23.extraControllerCallbacks.beginBroadcast() - 1;
            while (true) {
                remoteCallbackList = mediaSessionCompat$MediaSessionImplApi23.extraControllerCallbacks;
                if (iBeginBroadcast < 0) {
                    break;
                }
                try {
                    ((IMediaControllerCallback) remoteCallbackList.getBroadcastItem(iBeginBroadcast)).onPlaybackStateChanged(playbackStateCompat);
                } catch (RemoteException | SecurityException e) {
                    Log.e("MediaSessionCompat", "Dead object in setPlaybackState.", e);
                }
                iBeginBroadcast--;
            }
            remoteCallbackList.finishBroadcast();
        }
        MediaSession mediaSession = mediaSessionCompat$MediaSessionImplApi23.sessionFwk;
        PlaybackState playbackStateBuild = playbackStateCompat.stateFwk;
        if (playbackStateBuild == null) {
            PlaybackState.Builder builder = new PlaybackState.Builder();
            builder.setState(playbackStateCompat.state, playbackStateCompat.position, playbackStateCompat.speed, playbackStateCompat.updateTime);
            builder.setBufferedPosition(playbackStateCompat.bufferedPosition);
            builder.setActions(playbackStateCompat.actions);
            builder.setErrorMessage(playbackStateCompat.errorMessage);
            for (PlaybackStateCompat.CustomAction customAction : playbackStateCompat.customActions) {
                PlaybackState.CustomAction customActionBuild = customAction.customActionFwk;
                if (customActionBuild == null) {
                    PlaybackState.CustomAction.Builder builder2 = new PlaybackState.CustomAction.Builder(customAction.action, customAction.name, customAction.icon);
                    builder2.setExtras(customAction.extras);
                    customActionBuild = builder2.build();
                }
                if (customActionBuild != null) {
                    builder.addCustomAction(customActionBuild);
                }
            }
            builder.setActiveQueueItemId(playbackStateCompat.activeItemId);
            builder.setExtras(playbackStateCompat.extras);
            playbackStateBuild = builder.build();
            playbackStateCompat.stateFwk = playbackStateBuild;
        }
        mediaSession.setPlaybackState(playbackStateBuild);
    }

    public void setQueue(ArrayList arrayList) {
        int i = 0;
        if (arrayList != null) {
            HashSet hashSet = new HashSet();
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                long j = ((MediaSessionCompat$QueueItem) obj).id;
                if (hashSet.contains(Long.valueOf(j))) {
                    Log.e("MediaSessionCompat", Format$$ExternalSyntheticOutline0.m(j, "Found duplicate queue id: "), new IllegalArgumentException("id of each queue item should be unique"));
                }
                hashSet.add(Long.valueOf(j));
            }
        }
        MediaSessionCompat$MediaSessionImplApi23 mediaSessionCompat$MediaSessionImplApi23 = (MediaSessionCompat$MediaSessionImplApi23) this.mCallback;
        MediaSession mediaSession = mediaSessionCompat$MediaSessionImplApi23.sessionFwk;
        mediaSessionCompat$MediaSessionImplApi23.queue = arrayList;
        if (arrayList == null) {
            mediaSession.setQueue(null);
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj2 = arrayList.get(i);
            i++;
            MediaSessionCompat$QueueItem mediaSessionCompat$QueueItem = (MediaSessionCompat$QueueItem) obj2;
            MediaSession.QueueItem queueItem = mediaSessionCompat$QueueItem.itemFwk;
            if (queueItem == null) {
                MediaSession.QueueItem queueItem2 = new MediaSession.QueueItem(mediaSessionCompat$QueueItem.description.getMediaDescription(), mediaSessionCompat$QueueItem.id);
                mediaSessionCompat$QueueItem.itemFwk = queueItem2;
                queueItem = queueItem2;
            }
            arrayList2.add(queueItem);
        }
        mediaSession.setQueue(arrayList2);
    }

    /* JADX INFO: renamed from: transform-Q8lPUPs, reason: not valid java name */
    public void m829transformQ8lPUPs(float[] fArr) {
        Matrix matrix;
        if (fArr == null) {
            matrix = null;
            this.mCallback = null;
        } else {
            Matrix matrix2 = (Matrix) this.mCallback;
            if (matrix2 == null) {
                matrix2 = new Matrix();
                this.mCallback = matrix2;
            }
            ColorKt.m495setFromEL8BTi8(matrix2, fArr);
            matrix = matrix2;
        }
        Shader shader = (Shader) this.mExecutor;
        if (shader != null) {
            shader.setLocalMatrix(matrix);
        }
    }

    public void updateSequenceHeaders(ArrayList arrayList) {
        ObuParser$SequenceHeader obuParser$SequenceHeader;
        for (int i = 0; i < arrayList.size(); i++) {
            if (((ObuParser$Obu) arrayList.get(i)).type == 1) {
                try {
                    obuParser$SequenceHeader = new ObuParser$SequenceHeader((ObuParser$Obu) arrayList.get(i));
                } catch (ObuParser$NotYetImplementedException unused) {
                    obuParser$SequenceHeader = null;
                }
                this.mExecutor = obuParser$SequenceHeader;
            }
        }
    }

    public synchronized void updateWakeLock(boolean z, boolean z2) {
        boolean z3 = false;
        if (z) {
            if (((PowerManager.WakeLock) this.mExecutor) == null) {
                if (((Context) this.mCallback).checkSelfPermission("android.permission.WAKE_LOCK") != 0) {
                    Log.w("WakeLockManager", "WAKE_LOCK permission not granted, can't acquire wake lock for playback");
                    return;
                }
                PowerManager powerManager = (PowerManager) ((Context) this.mCallback).getSystemService("power");
                if (powerManager == null) {
                    Log.w("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                    return;
                } else {
                    PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                    this.mExecutor = wakeLockNewWakeLock;
                    wakeLockNewWakeLock.setReferenceCounted(false);
                }
            }
        }
        PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) this.mExecutor;
        if (wakeLock == null) {
            return;
        }
        if (z && z2) {
            z3 = true;
        }
        if (z3) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }

    public /* synthetic */ CallbackWrapper(byte b, boolean z) {
        this.$r8$classId = b;
    }

    public /* synthetic */ CallbackWrapper(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.mCallback = obj;
        this.mExecutor = obj2;
    }

    public CallbackWrapper(byte b) {
        this.$r8$classId = b;
        switch (b) {
            case 5:
                this.mCallback = new LinkedHashMap();
                this.mExecutor = new LinkedHashMap();
                break;
            case 17:
                this.mCallback = new HashMap();
                break;
            case 19:
                this.mCallback = new HashMap();
                this.mExecutor = CodecParameters.EMPTY;
                break;
            case 22:
                this.mCallback = ByteBuffer.allocateDirect(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
                break;
            default:
                this.mCallback = new VelocityTracker1D(0);
                this.mExecutor = new VelocityTracker1D(0);
                break;
        }
    }

    public CallbackWrapper(GapComposer$$ExternalSyntheticLambda0 gapComposer$$ExternalSyntheticLambda0) {
        this.$r8$classId = (byte) 6;
        this.mCallback = gapComposer$$ExternalSyntheticLambda0;
        this.mExecutor = new androidx.compose.runtime.internal.AtomicInt(0);
    }

    public CallbackWrapper(TimestampAdjuster timestampAdjuster) {
        this.$r8$classId = (byte) 25;
        this.mCallback = timestampAdjuster;
        this.mExecutor = new ParsableByteArray();
    }

    public CallbackWrapper(OkHttpClient okHttpClient) {
        this.$r8$classId = (byte) 18;
        this.mExecutor = okHttpClient;
        this.mCallback = new CallbackWrapper((byte) 17);
    }

    public CallbackWrapper(FlagSet flagSet, SparseArray sparseArray) {
        this.$r8$classId = (byte) 20;
        this.mCallback = flagSet;
        SparseBooleanArray sparseBooleanArray = flagSet.flags;
        SparseArray sparseArray2 = new SparseArray(sparseBooleanArray.size());
        for (int i = 0; i < sparseBooleanArray.size(); i++) {
            int i2 = flagSet.get(i);
            AnalyticsListener.EventTime eventTime = (AnalyticsListener.EventTime) sparseArray.get(i2);
            eventTime.getClass();
            sparseArray2.append(i2, eventTime);
        }
        this.mExecutor = sparseArray2;
    }

    @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
    public SubcomposeLayoutState.PrecomposedSlotHandle apply() {
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = (LayoutNodeSubcompositionsState) this.mCallback;
        LayoutNodeSubcompositionsState.NodeState nodeState = getNodeState();
        if (nodeState != null) {
            layoutNodeSubcompositionsState.applyPausedPrecomposition(nodeState, false);
        }
        return layoutNodeSubcompositionsState.createPrecomposedSlotHandle(this.mExecutor);
    }

    public CallbackWrapper(LazyLayoutItemContentFactory lazyLayoutItemContentFactory) {
        this.$r8$classId = (byte) 3;
        this.mCallback = lazyLayoutItemContentFactory;
        MutableObjectIntMap mutableObjectIntMap = ObjectIntMapKt.EmptyObjectIntMap;
        this.mExecutor = new MutableObjectIntMap();
    }

    public CallbackWrapper(Context context, MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.$r8$classId = (byte) 29;
        this.mExecutor = Collections.synchronizedSet(new HashSet());
        if (Build.VERSION.SDK_INT >= 29) {
            this.mCallback = new MediaControllerCompat$MediaControllerImplApi29(context, mediaSessionCompat$Token);
        } else {
            this.mCallback = new MediaControllerCompat$MediaControllerImplApi23(context, mediaSessionCompat$Token);
        }
    }

    public CallbackWrapper(EditText editText) {
        this.$r8$classId = (byte) 15;
        this.mCallback = editText;
        EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText);
        this.mExecutor = emojiTextWatcher;
        editText.addTextChangedListener(emojiTextWatcher);
        if (EmojiEditableFactory.sInstance == null) {
            synchronized (EmojiEditableFactory.INSTANCE_LOCK) {
                try {
                    if (EmojiEditableFactory.sInstance == null) {
                        EmojiEditableFactory emojiEditableFactory = new EmojiEditableFactory();
                        try {
                            EmojiEditableFactory.sWatcherClass = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, EmojiEditableFactory.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        EmojiEditableFactory.sInstance = emojiEditableFactory;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        editText.setEditableFactory(EmojiEditableFactory.sInstance);
    }

    public /* synthetic */ CallbackWrapper(byte b, Object obj) {
        this.$r8$classId = b;
        this.mCallback = obj;
    }

    public CallbackWrapper(IBinder iBinder, Bundle bundle) {
        this.$r8$classId = (byte) 28;
        this.mCallback = new Messenger(iBinder);
        this.mExecutor = bundle;
    }
}
