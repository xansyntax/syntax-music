package androidx.compose.ui.node;

import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.layout.VerticalRuler;
import androidx.core.os.HandlerCompat$Api28Impl;
import androidx.media3.common.util.BackgroundThreadStateHandler$$ExternalSyntheticLambda0;
import androidx.media3.common.util.BackgroundThreadStateHandler$StateChangeListener;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.SystemHandlerWrapper;
import androidx.media3.common.util.Util;
import androidx.media3.container.ReorderingBufferQueue$BuffersWithTimestamp;
import androidx.media3.exoplayer.StreamVolumeManager$$ExternalSyntheticLambda3;
import androidx.media3.exoplayer.StreamVolumeManager$StreamVolumeState;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavDestination;
import coil3.util.UtilsKt;
import com.google.common.base.Function;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import kotlin.SynchronizedLazyImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RulerTrackingMap {
    public Object accessFlags;
    public Object layoutNodes;
    public Object newRulers;
    public Object rulers;
    public int size;
    public Object values;

    public RulerTrackingMap(Object obj, Looper looper, Looper looper2, BackgroundThreadStateHandler$StateChangeListener backgroundThreadStateHandler$StateChangeListener) {
        this.rulers = new SystemHandlerWrapper(new Handler(looper, null));
        this.values = new SystemHandlerWrapper(new Handler(looper2, null));
        this.layoutNodes = obj;
        this.newRulers = obj;
        this.accessFlags = backgroundThreadStateHandler$StateChangeListener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:
    
        if (r10 < r3.presentationTimeUs) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void add(long j, ParsableByteArray parsableByteArray) {
        int i;
        ArrayDeque arrayDeque = (ArrayDeque) this.accessFlags;
        PriorityQueue priorityQueue = (PriorityQueue) this.layoutNodes;
        if (j != -9223372036854775807L && (i = this.size) != 0) {
            if (i != -1 && priorityQueue.size() >= this.size) {
                ReorderingBufferQueue$BuffersWithTimestamp reorderingBufferQueue$BuffersWithTimestamp = (ReorderingBufferQueue$BuffersWithTimestamp) priorityQueue.peek();
                String str = Util.DEVICE_DEBUG_INFO;
            }
            ArrayDeque arrayDeque2 = (ArrayDeque) this.values;
            ParsableByteArray parsableByteArray2 = arrayDeque2.isEmpty() ? new ParsableByteArray() : (ParsableByteArray) arrayDeque2.pop();
            parsableByteArray2.reset(parsableByteArray.bytesLeft());
            System.arraycopy(parsableByteArray.data, parsableByteArray.position, parsableByteArray2.data, 0, parsableByteArray2.bytesLeft());
            ReorderingBufferQueue$BuffersWithTimestamp reorderingBufferQueue$BuffersWithTimestamp2 = (ReorderingBufferQueue$BuffersWithTimestamp) this.newRulers;
            if (reorderingBufferQueue$BuffersWithTimestamp2 != null && j == reorderingBufferQueue$BuffersWithTimestamp2.presentationTimeUs) {
                reorderingBufferQueue$BuffersWithTimestamp2.nalBuffers.add(parsableByteArray2);
                return;
            }
            ReorderingBufferQueue$BuffersWithTimestamp reorderingBufferQueue$BuffersWithTimestamp3 = arrayDeque.isEmpty() ? new ReorderingBufferQueue$BuffersWithTimestamp() : (ReorderingBufferQueue$BuffersWithTimestamp) arrayDeque.pop();
            ArrayList arrayList = reorderingBufferQueue$BuffersWithTimestamp3.nalBuffers;
            UtilsKt.checkArgument(j != -9223372036854775807L);
            UtilsKt.checkState(arrayList.isEmpty());
            reorderingBufferQueue$BuffersWithTimestamp3.presentationTimeUs = j;
            arrayList.add(parsableByteArray2);
            priorityQueue.add(reorderingBufferQueue$BuffersWithTimestamp3);
            this.newRulers = reorderingBufferQueue$BuffersWithTimestamp3;
            int i2 = this.size;
            if (i2 != -1) {
                flushQueueDownToSize(i2);
                return;
            }
            return;
        }
        ((OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0) this.rulers).consume(j, parsableByteArray);
    }

    public void flushQueueDownToSize(int i) {
        ArrayList arrayList;
        PriorityQueue priorityQueue = (PriorityQueue) this.layoutNodes;
        while (priorityQueue.size() > i) {
            ReorderingBufferQueue$BuffersWithTimestamp reorderingBufferQueue$BuffersWithTimestamp = (ReorderingBufferQueue$BuffersWithTimestamp) priorityQueue.poll();
            String str = Util.DEVICE_DEBUG_INFO;
            int i2 = 0;
            while (true) {
                arrayList = reorderingBufferQueue$BuffersWithTimestamp.nalBuffers;
                if (i2 >= arrayList.size()) {
                    break;
                }
                ((OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0) this.rulers).consume(reorderingBufferQueue$BuffersWithTimestamp.presentationTimeUs, (ParsableByteArray) arrayList.get(i2));
                ((ArrayDeque) this.values).push((ParsableByteArray) arrayList.get(i2));
                i2++;
            }
            arrayList.clear();
            ReorderingBufferQueue$BuffersWithTimestamp reorderingBufferQueue$BuffersWithTimestamp2 = (ReorderingBufferQueue$BuffersWithTimestamp) this.newRulers;
            if (reorderingBufferQueue$BuffersWithTimestamp2 != null && reorderingBufferQueue$BuffersWithTimestamp2.presentationTimeUs == reorderingBufferQueue$BuffersWithTimestamp.presentationTimeUs) {
                this.newRulers = null;
            }
            ((ArrayDeque) this.accessFlags).push(reorderingBufferQueue$BuffersWithTimestamp);
        }
    }

    public StreamVolumeManager$StreamVolumeState generateState(int i) {
        int streamMaxVolume;
        ((AudioManager) this.layoutNodes).getClass();
        AudioManager audioManager = (AudioManager) this.layoutNodes;
        try {
            streamMaxVolume = audioManager.getStreamVolume(i);
        } catch (RuntimeException e) {
            Log.w("AudioManagerCompat", "Could not retrieve stream volume for stream type " + i, e);
            streamMaxVolume = audioManager.getStreamMaxVolume(i);
        }
        return new StreamVolumeManager$StreamVolumeState(((AudioManager) this.layoutNodes).isStreamMute(i), i, streamMaxVolume, HandlerCompat$Api28Impl.getStreamMinVolume((AudioManager) this.layoutNodes, i), ((AudioManager) this.layoutNodes).getStreamMaxVolume(i));
    }

    public Object get() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == ((SystemHandlerWrapper) this.values).handler.getLooper()) {
            return this.layoutNodes;
        }
        UtilsKt.checkState(looperMyLooper == ((SystemHandlerWrapper) this.rulers).handler.getLooper());
        return this.newRulers;
    }

    public void increaseVolume(int i) {
        RulerTrackingMap rulerTrackingMap = (RulerTrackingMap) this.accessFlags;
        StreamVolumeManager$$ExternalSyntheticLambda3 streamVolumeManager$$ExternalSyntheticLambda3 = new StreamVolumeManager$$ExternalSyntheticLambda3(this, i, (byte) 2);
        rulerTrackingMap.getClass();
        UtilsKt.checkState(Looper.myLooper() == ((SystemHandlerWrapper) rulerTrackingMap.values).handler.getLooper());
        rulerTrackingMap.size++;
        rulerTrackingMap.runInBackground(new ComponentActivity$$ExternalSyntheticLambda10(rulerTrackingMap, streamVolumeManager$$ExternalSyntheticLambda3, (byte) 6));
        StreamVolumeManager$StreamVolumeState streamVolumeManager$StreamVolumeState = (StreamVolumeManager$StreamVolumeState) rulerTrackingMap.layoutNodes;
        int i2 = streamVolumeManager$StreamVolumeState.streamType;
        int i3 = streamVolumeManager$StreamVolumeState.volume;
        int i4 = streamVolumeManager$StreamVolumeState.maxVolume;
        rulerTrackingMap.updateStateInForeground(new StreamVolumeManager$StreamVolumeState(false, i2, i3 < i4 ? i3 + 1 : i4, streamVolumeManager$StreamVolumeState.minVolume, i4));
    }

    public NavDestination.DeepLinkMatch matchRoute$navigation_common_release(String str) {
        NavDeepLink navDeepLink;
        str.getClass();
        SynchronizedLazyImpl synchronizedLazyImpl = (SynchronizedLazyImpl) this.newRulers;
        if (synchronizedLazyImpl == null || (navDeepLink = (NavDeepLink) synchronizedLazyImpl.getValue()) == null) {
            return null;
        }
        int i = NavDestination.$r8$clinit;
        Uri uri = Uri.parse("android-app://androidx.navigation/".concat(str));
        uri.getClass();
        Bundle matchingArguments = navDeepLink.getMatchingArguments(uri, (LinkedHashMap) this.accessFlags);
        if (matchingArguments == null) {
            return null;
        }
        return new NavDestination.DeepLinkMatch((NavDestination) this.rulers, matchingArguments, navDeepLink.isExactDeepLink, navDeepLink.calculateMatchingPathSegments$navigation_common_release(uri), false);
    }

    public void runInBackground(Runnable runnable) {
        SystemHandlerWrapper systemHandlerWrapper = (SystemHandlerWrapper) this.rulers;
        if (systemHandlerWrapper.handler.getLooper().getThread().isAlive()) {
            systemHandlerWrapper.post(runnable);
        }
    }

    public void setMaxSize(int i) {
        UtilsKt.checkState(i >= 0);
        this.size = i;
        flushQueueDownToSize(i);
    }

    public void setStateInBackground(Object obj) {
        this.newRulers = obj;
        BackgroundThreadStateHandler$$ExternalSyntheticLambda0 backgroundThreadStateHandler$$ExternalSyntheticLambda0 = new BackgroundThreadStateHandler$$ExternalSyntheticLambda0(this, obj, (byte) 0);
        SystemHandlerWrapper systemHandlerWrapper = (SystemHandlerWrapper) this.values;
        if (systemHandlerWrapper.handler.getLooper().getThread().isAlive()) {
            systemHandlerWrapper.post(backgroundThreadStateHandler$$ExternalSyntheticLambda0);
        }
    }

    public void updateStateAsync(Function function, Function function2) {
        UtilsKt.checkState(Looper.myLooper() == ((SystemHandlerWrapper) this.values).handler.getLooper());
        this.size++;
        runInBackground(new ComponentActivity$$ExternalSyntheticLambda10(this, function2, (byte) 6));
        updateStateInForeground(function.apply(this.layoutNodes));
    }

    public void updateStateInForeground(Object obj) {
        Object obj2 = this.layoutNodes;
        this.layoutNodes = obj;
        if (obj2.equals(obj)) {
            return;
        }
        ((BackgroundThreadStateHandler$StateChangeListener) this.accessFlags).onStateChanged(obj2, obj);
    }

    public RulerTrackingMap(OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0) {
        this.rulers = onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
        this.values = new ArrayDeque();
        this.accessFlags = new ArrayDeque();
        this.layoutNodes = new PriorityQueue();
        this.size = -1;
    }

    public RulerTrackingMap() {
        this.rulers = new VerticalRuler[32];
        this.values = new float[32];
        this.accessFlags = new byte[32];
        MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
        this.layoutNodes = new MutableScatterSet();
        this.newRulers = new MutableScatterSet();
    }
}
