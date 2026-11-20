package androidx.media3.exoplayer.offline;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda1;
import androidx.compose.ui.platform.WeakCache;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.ListenerSet$$ExternalSyntheticLambda0;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.database.StandaloneDatabaseProvider;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.datasource.cache.SimpleCache;
import androidx.media3.exoplayer.scheduler.Requirements;
import androidx.media3.exoplayer.scheduler.RequirementsWatcher;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.playback.DownloadUtil$$ExternalSyntheticLambda2;
import io.ktor.client.utils.CIOKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.io.FileSystemException;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DownloadManager {
    public static final Requirements DEFAULT_REQUIREMENTS = new Requirements(1);
    public int activeTaskCount;
    public final Context context;
    public final DefaultDownloadIndex downloadIndex;
    public List downloads;
    public boolean downloadsPaused;
    public boolean initialized;
    public final InternalHandler internalHandler;
    public final CopyOnWriteArraySet listeners;
    public byte maxParallelDownloads;
    public int notMetRequirements;
    public int pendingMessages;
    public final OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 requirementsListener;
    public RequirementsWatcher requirementsWatcher;
    public boolean waitingForRequirements;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DownloadUpdate {
        public final Download download;
        public final ArrayList downloads;
        public final Exception finalException;
        public final boolean isRemove;

        public DownloadUpdate(Download download, boolean z, ArrayList arrayList, Exception exc) {
            this.download = download;
            this.isRemove = z;
            this.downloads = arrayList;
            this.finalException = exc;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class InternalHandler extends Handler {
        public int activeDownloadTaskCount;
        public final HashMap activeTasks;
        public final DefaultDownloadIndex downloadIndex;
        public final EmojiProcessor downloaderFactory;
        public final ArrayList downloads;
        public boolean downloadsPaused;
        public boolean hasActiveRemoveTask;
        public final Handler mainHandler;
        public int maxParallelDownloads;
        public int minRetryCount;
        public int notMetRequirements;
        public final HandlerThread thread;

        public InternalHandler(HandlerThread handlerThread, DefaultDownloadIndex defaultDownloadIndex, EmojiProcessor emojiProcessor, Handler handler, int i, boolean z) {
            super(handlerThread.getLooper());
            this.thread = handlerThread;
            this.downloadIndex = defaultDownloadIndex;
            this.downloaderFactory = emojiProcessor;
            this.mainHandler = handler;
            this.maxParallelDownloads = i;
            this.minRetryCount = 5;
            this.downloadsPaused = z;
            this.downloads = new ArrayList();
            this.activeTasks = new HashMap();
        }

        public static Download copyDownloadWithState(Download download, int i, int i2) {
            return new Download(download.request, i, download.startTimeMs, System.currentTimeMillis(), download.contentLength, i2, 0, download.progress);
        }

        public final Download getDownload(String str, boolean z) {
            int downloadIndex = getDownloadIndex(str);
            if (downloadIndex != -1) {
                return (Download) this.downloads.get(downloadIndex);
            }
            if (!z) {
                return null;
            }
            try {
                return this.downloadIndex.getDownload(str);
            } catch (IOException e) {
                Log.e("DownloadManager", "Failed to load download: " + str, e);
                return null;
            }
        }

        public final int getDownloadIndex(String str) {
            int i = 0;
            while (true) {
                ArrayList arrayList = this.downloads;
                if (i >= arrayList.size()) {
                    return -1;
                }
                if (((Download) arrayList.get(i)).request.id.equals(str)) {
                    return i;
                }
                i++;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r29v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r4v10, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v14, types: [java.util.ArrayList] */
        @Override // android.os.Handler
        public final void handleMessage(Message message) throws Throwable {
            ?? arrayList;
            int i = 7;
            DefaultDownloadIndex.DownloadCursorImpl downloadCursorImpl = null;
            i = 0;
            int i2 = 0;
            switch (message.what) {
                case 1:
                    int i3 = message.arg1;
                    DefaultDownloadIndex defaultDownloadIndex = this.downloadIndex;
                    ArrayList arrayList2 = this.downloads;
                    this.notMetRequirements = i3;
                    try {
                        try {
                            defaultDownloadIndex.setDownloadingStatesToQueued();
                            defaultDownloadIndex.ensureInitialized();
                            DefaultDownloadIndex.DownloadCursorImpl downloadCursorImpl2 = new DefaultDownloadIndex.DownloadCursorImpl(defaultDownloadIndex.getCursor(DefaultDownloadIndex.getStateQuery(0, 1, 2, 5, 7), null));
                            while (true) {
                                try {
                                    Cursor cursor = downloadCursorImpl2.cursor;
                                    if (cursor.moveToPosition(cursor.getPosition() + 1)) {
                                        arrayList2.add(DefaultDownloadIndex.getDownloadForCurrentRow(downloadCursorImpl2.cursor));
                                    } else {
                                        Util.closeQuietly(downloadCursorImpl2);
                                    }
                                } catch (IOException e) {
                                    e = e;
                                    downloadCursorImpl = downloadCursorImpl2;
                                    Log.e("DownloadManager", "Failed to load index.", e);
                                    arrayList2.clear();
                                    Util.closeQuietly(downloadCursorImpl);
                                } catch (Throwable th) {
                                    th = th;
                                    downloadCursorImpl = downloadCursorImpl2;
                                    Util.closeQuietly(downloadCursorImpl);
                                    throw th;
                                }
                                this.mainHandler.obtainMessage(1, new ArrayList(arrayList2)).sendToTarget();
                                syncTasks();
                                i2 = 1;
                                this.mainHandler.obtainMessage(2, i2, this.activeTasks.size()).sendToTarget();
                                return;
                            }
                        } catch (IOException e2) {
                            e = e2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    break;
                case 2:
                    this.downloadsPaused = message.arg1 != 0;
                    syncTasks();
                    i2 = 1;
                    this.mainHandler.obtainMessage(2, i2, this.activeTasks.size()).sendToTarget();
                    return;
                case 3:
                    this.notMetRequirements = message.arg1;
                    syncTasks();
                    i2 = 1;
                    this.mainHandler.obtainMessage(2, i2, this.activeTasks.size()).sendToTarget();
                    return;
                case 4:
                    String str = (String) message.obj;
                    int i4 = message.arg1;
                    DefaultDownloadIndex defaultDownloadIndex2 = this.downloadIndex;
                    ArrayList arrayList3 = this.downloads;
                    if (str != null) {
                        Download download = getDownload(str, false);
                        if (download != null) {
                            setStopReason(download, i4);
                        } else {
                            try {
                                defaultDownloadIndex2.setStopReason(i4, str);
                            } catch (IOException e3) {
                                Log.e("DownloadManager", "Failed to set manual stop reason: ".concat(str), e3);
                            }
                        }
                        break;
                    } else {
                        for (int i5 = 0; i5 < arrayList3.size(); i5++) {
                            setStopReason((Download) arrayList3.get(i5), i4);
                        }
                        try {
                            defaultDownloadIndex2.ensureInitialized();
                            try {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("stop_reason", Integer.valueOf(i4));
                                defaultDownloadIndex2.databaseProvider.getWritableDatabase().update("ExoPlayerDownloads", contentValues, DefaultDownloadIndex.WHERE_STATE_IS_TERMINAL, null);
                            } catch (SQLException e4) {
                                throw new FileSystemException(e4);
                            }
                        } catch (IOException e5) {
                            Log.e("DownloadManager", "Failed to set manual stop reason", e5);
                        }
                        break;
                    }
                    syncTasks();
                    i2 = 1;
                    this.mainHandler.obtainMessage(2, i2, this.activeTasks.size()).sendToTarget();
                    return;
                case 5:
                    this.maxParallelDownloads = message.arg1;
                    syncTasks();
                    i2 = 1;
                    this.mainHandler.obtainMessage(2, i2, this.activeTasks.size()).sendToTarget();
                    return;
                case 6:
                    this.minRetryCount = message.arg1;
                    i2 = 1;
                    this.mainHandler.obtainMessage(2, i2, this.activeTasks.size()).sendToTarget();
                    return;
                case 7:
                    DownloadRequest downloadRequest = (DownloadRequest) message.obj;
                    int i6 = message.arg1;
                    Download download2 = getDownload(downloadRequest.id, true);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (download2 != null) {
                        int i7 = download2.state;
                        long j = (i7 == 5 || i7 == 3 || i7 == 4) ? jCurrentTimeMillis : download2.startTimeMs;
                        if (i7 != 5 && i7 != 7) {
                            i = i6 != 0 ? 1 : 0;
                        }
                        DownloadRequest downloadRequest2 = download2.request;
                        String str2 = downloadRequest2.id;
                        String str3 = downloadRequest.id;
                        List list = downloadRequest.streamKeys;
                        UtilsKt.checkArgument(str2.equals(str3));
                        List list2 = downloadRequest2.streamKeys;
                        if (list2.isEmpty() || list.isEmpty()) {
                            arrayList = Collections.EMPTY_LIST;
                        } else {
                            arrayList = new ArrayList(list2);
                            for (int i8 = 0; i8 < list.size(); i8++) {
                                StreamKey streamKey = (StreamKey) list.get(i8);
                                if (!arrayList.contains(streamKey)) {
                                    arrayList.add(streamKey);
                                }
                            }
                        }
                        putDownload(new Download(new DownloadRequest(downloadRequest2.id, downloadRequest.uri, downloadRequest.mimeType, arrayList, downloadRequest.keySetId, downloadRequest.customCacheKey, downloadRequest.data, downloadRequest.byteRange, downloadRequest.timeRange), i, j, jCurrentTimeMillis, i6));
                    } else {
                        putDownload(new Download(downloadRequest, i6 != 0 ? 1 : 0, jCurrentTimeMillis, jCurrentTimeMillis, i6));
                    }
                    syncTasks();
                    i2 = 1;
                    this.mainHandler.obtainMessage(2, i2, this.activeTasks.size()).sendToTarget();
                    return;
                case 8:
                    String str4 = (String) message.obj;
                    Download download3 = getDownload(str4, true);
                    if (download3 == null) {
                        Log.e("DownloadManager", "Failed to remove nonexistent download: " + str4);
                    } else {
                        putDownloadWithState(download3, 5, 0);
                        syncTasks();
                    }
                    i2 = 1;
                    this.mainHandler.obtainMessage(2, i2, this.activeTasks.size()).sendToTarget();
                    return;
                case 9:
                    DefaultDownloadIndex defaultDownloadIndex3 = this.downloadIndex;
                    ArrayList arrayList4 = this.downloads;
                    ArrayList arrayList5 = new ArrayList();
                    try {
                        defaultDownloadIndex3.ensureInitialized();
                        Cursor cursor2 = defaultDownloadIndex3.getCursor(DefaultDownloadIndex.getStateQuery(3, 4), null);
                        while (cursor2.moveToPosition(cursor2.getPosition() + 1)) {
                            try {
                                arrayList5.add(DefaultDownloadIndex.getDownloadForCurrentRow(cursor2));
                            } catch (Throwable th3) {
                                try {
                                    cursor2.close();
                                    throw th3;
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                    throw th3;
                                }
                            }
                        }
                        cursor2.close();
                    } catch (IOException unused) {
                        Log.e("DownloadManager", "Failed to load downloads.");
                    }
                    for (int i9 = 0; i9 < arrayList4.size(); i9++) {
                        arrayList4.set(i9, copyDownloadWithState((Download) arrayList4.get(i9), 5, 0));
                    }
                    for (int i10 = 0; i10 < arrayList5.size(); i10++) {
                        arrayList4.add(copyDownloadWithState((Download) arrayList5.get(i10), 5, 0));
                    }
                    Collections.sort(arrayList4, new LayoutNode$$ExternalSyntheticLambda1((byte) 9));
                    try {
                        defaultDownloadIndex3.setStatesToRemoving();
                        break;
                    } catch (IOException e6) {
                        Log.e("DownloadManager", "Failed to update index.", e6);
                    }
                    ArrayList arrayList6 = new ArrayList(arrayList4);
                    for (int i11 = 0; i11 < arrayList4.size(); i11++) {
                        this.mainHandler.obtainMessage(3, new DownloadUpdate((Download) arrayList4.get(i11), false, arrayList6, null)).sendToTarget();
                    }
                    syncTasks();
                    i2 = 1;
                    this.mainHandler.obtainMessage(2, i2, this.activeTasks.size()).sendToTarget();
                    return;
                case 10:
                    Task task = (Task) message.obj;
                    String str5 = task.request.id;
                    this.activeTasks.remove(str5);
                    boolean z = task.isRemove;
                    if (z) {
                        this.hasActiveRemoveTask = false;
                    } else {
                        int i12 = this.activeDownloadTaskCount - 1;
                        this.activeDownloadTaskCount = i12;
                        if (i12 == 0) {
                            removeMessages(12);
                        }
                    }
                    if (!task.isCanceled) {
                        Exception exc = task.finalException;
                        if (exc != null) {
                            Log.e("DownloadManager", "Task failed: " + task.request + ", " + z, exc);
                        }
                        Download download4 = getDownload(str5, false);
                        download4.getClass();
                        int i13 = download4.state;
                        if (i13 == 2) {
                            UtilsKt.checkState(!z);
                            ArrayList arrayList7 = this.downloads;
                            Download download5 = new Download(download4.request, exc == null ? 3 : 4, download4.startTimeMs, System.currentTimeMillis(), download4.contentLength, download4.stopReason, exc == null ? 0 : 1, download4.progress);
                            arrayList7.remove(getDownloadIndex(download5.request.id));
                            try {
                                this.downloadIndex.putDownload(download5);
                            } catch (IOException e7) {
                                Log.e("DownloadManager", "Failed to update index.", e7);
                            }
                            this.mainHandler.obtainMessage(3, new DownloadUpdate(download5, false, new ArrayList(arrayList7), exc)).sendToTarget();
                        } else {
                            if (i13 != 5 && i13 != 7) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                return;
                            }
                            UtilsKt.checkState(z);
                            ArrayList arrayList8 = this.downloads;
                            int i14 = download4.state;
                            DownloadRequest downloadRequest3 = download4.request;
                            if (i14 == 7) {
                                int i15 = download4.stopReason;
                                putDownloadWithState(download4, i15 == 0 ? 0 : 1, i15);
                                syncTasks();
                            } else {
                                arrayList8.remove(getDownloadIndex(downloadRequest3.id));
                                try {
                                    DefaultDownloadIndex defaultDownloadIndex4 = this.downloadIndex;
                                    String str6 = downloadRequest3.id;
                                    defaultDownloadIndex4.ensureInitialized();
                                    try {
                                        defaultDownloadIndex4.databaseProvider.getWritableDatabase().delete("ExoPlayerDownloads", "id = ?", new String[]{str6});
                                    } catch (SQLiteException e8) {
                                        throw new FileSystemException(e8);
                                    }
                                } catch (IOException unused2) {
                                    Log.e("DownloadManager", "Failed to remove from database");
                                }
                                this.mainHandler.obtainMessage(3, new DownloadUpdate(download4, true, new ArrayList(arrayList8), null)).sendToTarget();
                            }
                        }
                        syncTasks();
                        break;
                    } else {
                        syncTasks();
                    }
                    this.mainHandler.obtainMessage(2, i2, this.activeTasks.size()).sendToTarget();
                    return;
                case 11:
                    Task task2 = (Task) message.obj;
                    int i16 = message.arg1;
                    int i17 = message.arg2;
                    String str7 = Util.DEVICE_DEBUG_INFO;
                    long j2 = ((((long) i16) & 4294967295L) << 32) | (4294967295L & ((long) i17));
                    Download download6 = getDownload(task2.request.id, false);
                    download6.getClass();
                    if (j2 == download6.contentLength || j2 == -1) {
                        return;
                    }
                    putDownload(new Download(download6.request, download6.state, download6.startTimeMs, System.currentTimeMillis(), j2, download6.stopReason, download6.failureReason, download6.progress));
                    return;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    ArrayList arrayList9 = this.downloads;
                    for (int i18 = 0; i18 < arrayList9.size(); i18++) {
                        Download download7 = (Download) arrayList9.get(i18);
                        if (download7.state == 2) {
                            try {
                                this.downloadIndex.putDownload(download7);
                            } catch (IOException e9) {
                                Log.e("DownloadManager", "Failed to update index.", e9);
                            }
                        }
                    }
                    sendEmptyMessageDelayed(12, 5000L);
                    return;
                case 13:
                    Iterator it = this.activeTasks.values().iterator();
                    while (it.hasNext()) {
                        ((Task) it.next()).cancel(true);
                    }
                    try {
                        this.downloadIndex.setDownloadingStatesToQueued();
                        break;
                    } catch (IOException e10) {
                        Log.e("DownloadManager", "Failed to update index.", e10);
                    }
                    this.downloads.clear();
                    this.thread.quit();
                    synchronized (this) {
                        notifyAll();
                        break;
                    }
                    return;
                default:
                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                    return;
            }
        }

        public final void putDownload(Download download) {
            int i = download.state;
            UtilsKt.checkState((i == 3 || i == 4) ? false : true);
            int downloadIndex = getDownloadIndex(download.request.id);
            ArrayList arrayList = this.downloads;
            if (downloadIndex == -1) {
                arrayList.add(download);
                Collections.sort(arrayList, new LayoutNode$$ExternalSyntheticLambda1((byte) 9));
            } else {
                boolean z = download.startTimeMs != ((Download) arrayList.get(downloadIndex)).startTimeMs;
                arrayList.set(downloadIndex, download);
                if (z) {
                    Collections.sort(arrayList, new LayoutNode$$ExternalSyntheticLambda1((byte) 9));
                }
            }
            try {
                this.downloadIndex.putDownload(download);
            } catch (IOException e) {
                Log.e("DownloadManager", "Failed to update index.", e);
            }
            this.mainHandler.obtainMessage(3, new DownloadUpdate(download, false, new ArrayList(arrayList), null)).sendToTarget();
        }

        public final Download putDownloadWithState(Download download, int i, int i2) {
            UtilsKt.checkState((i == 3 || i == 4) ? false : true);
            Download downloadCopyDownloadWithState = copyDownloadWithState(download, i, i2);
            putDownload(downloadCopyDownloadWithState);
            return downloadCopyDownloadWithState;
        }

        public final void setStopReason(Download download, int i) {
            if (i == 0) {
                if (download.state == 1) {
                    putDownloadWithState(download, 0, 0);
                }
            } else if (i != download.stopReason) {
                int i2 = download.state;
                if (i2 == 0 || i2 == 2) {
                    i2 = 1;
                }
                putDownload(new Download(download.request, i2, download.startTimeMs, System.currentTimeMillis(), download.contentLength, i, 0, download.progress));
            }
        }

        public final void syncTasks() {
            Task task;
            int i = 0;
            int i2 = 0;
            while (true) {
                ArrayList arrayList = this.downloads;
                if (i >= arrayList.size()) {
                    return;
                }
                Download download = (Download) arrayList.get(i);
                DownloadRequest downloadRequest = download.request;
                String str = downloadRequest.id;
                HashMap map = this.activeTasks;
                Task task2 = (Task) map.get(str);
                int i3 = download.state;
                EmojiProcessor emojiProcessor = this.downloaderFactory;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            task2.getClass();
                            UtilsKt.checkState(!task2.isRemove);
                            if (this.downloadsPaused || this.notMetRequirements != 0 || i2 >= this.maxParallelDownloads) {
                                putDownloadWithState(download, 0, 0);
                                task2.cancel(false);
                            }
                        } else {
                            if (i3 != 5 && i3 != 7) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                return;
                            }
                            if (task2 != null) {
                                if (!task2.isRemove) {
                                    task2.cancel(false);
                                }
                            } else if (!this.hasActiveRemoveTask) {
                                Task task3 = new Task(download.request, emojiProcessor.createDownloader(downloadRequest), download.progress, true, this.minRetryCount, this);
                                map.put(downloadRequest.id, task3);
                                this.hasActiveRemoveTask = true;
                                task3.start();
                            }
                        }
                    } else if (task2 != null) {
                        UtilsKt.checkState(!task2.isRemove);
                        task2.cancel(false);
                    }
                } else if (task2 != null) {
                    UtilsKt.checkState(!task2.isRemove);
                    task2.cancel(false);
                } else {
                    if (this.downloadsPaused || this.notMetRequirements != 0 || this.activeDownloadTaskCount >= this.maxParallelDownloads) {
                        task = null;
                    } else {
                        Download downloadPutDownloadWithState = putDownloadWithState(download, 2, 0);
                        DownloadRequest downloadRequest2 = downloadPutDownloadWithState.request;
                        task = new Task(downloadPutDownloadWithState.request, emojiProcessor.createDownloader(downloadRequest2), downloadPutDownloadWithState.progress, false, this.minRetryCount, this);
                        map.put(downloadRequest2.id, task);
                        int i4 = this.activeDownloadTaskCount;
                        this.activeDownloadTaskCount = i4 + 1;
                        if (i4 == 0) {
                            sendEmptyMessageDelayed(12, 5000L);
                        }
                        task.start();
                    }
                    task2 = task;
                }
                if (task2 != null && !task2.isRemove) {
                    i2++;
                }
                i++;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Task extends Thread {
        public long contentLength = -1;
        public final DownloadProgress downloadProgress;
        public final ProgressiveDownloader downloader;
        public Exception finalException;
        public volatile InternalHandler internalHandler;
        public volatile boolean isCanceled;
        public final boolean isRemove;
        public final int minRetryCount;
        public final DownloadRequest request;

        public Task(DownloadRequest downloadRequest, ProgressiveDownloader progressiveDownloader, DownloadProgress downloadProgress, boolean z, int i, InternalHandler internalHandler) {
            this.request = downloadRequest;
            this.downloader = progressiveDownloader;
            this.downloadProgress = downloadProgress;
            this.isRemove = z;
            this.minRetryCount = i;
            this.internalHandler = internalHandler;
        }

        public final void cancel(boolean z) {
            if (z) {
                this.internalHandler = null;
            }
            if (this.isCanceled) {
                return;
            }
            this.isCanceled = true;
            ProgressiveDownloader progressiveDownloader = this.downloader;
            progressiveDownloader.isCanceled = true;
            ProgressiveDownloader.AnonymousClass1 anonymousClass1 = progressiveDownloader.downloadRunnable;
            if (anonymousClass1 != null) {
                anonymousClass1.cancel(true);
            }
            interrupt();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (this.isRemove) {
                    ProgressiveDownloader progressiveDownloader = this.downloader;
                    SimpleCache simpleCache = progressiveDownloader.dataSource.cache;
                    DataSpec dataSpec = progressiveDownloader.dataSpec;
                    String string = dataSpec.key;
                    if (string == null) {
                        string = dataSpec.uri.toString();
                    }
                    simpleCache.removeResource(string);
                } else {
                    long j = -1;
                    int i = 0;
                    while (!this.isCanceled) {
                        try {
                            this.downloader.download(this);
                            break;
                        } catch (IOException e) {
                            if (!this.isCanceled) {
                                long j2 = this.downloadProgress.bytesDownloaded;
                                if (j2 != j) {
                                    i = 0;
                                    j = j2;
                                }
                                int i2 = i + 1;
                                if (i2 > this.minRetryCount) {
                                    throw e;
                                }
                                Thread.sleep(Math.min(i * CIOKt.DEFAULT_HTTP_POOL_SIZE, 5000));
                                i = i2;
                            }
                        }
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (Exception e2) {
                this.finalException = e2;
            }
            InternalHandler internalHandler = this.internalHandler;
            if (internalHandler != null) {
                internalHandler.obtainMessage(10, this).sendToTarget();
            }
        }
    }

    public DownloadManager(Context context, StandaloneDatabaseProvider standaloneDatabaseProvider, SimpleCache simpleCache, WeakCache weakCache, DownloadUtil$$ExternalSyntheticLambda2 downloadUtil$$ExternalSyntheticLambda2) {
        DefaultDownloadIndex defaultDownloadIndex = new DefaultDownloadIndex(standaloneDatabaseProvider);
        CacheDataSource.Factory factory = new CacheDataSource.Factory();
        factory.cache = simpleCache;
        factory.upstreamDataSourceFactory = weakCache;
        EmojiProcessor emojiProcessor = new EmojiProcessor(factory, downloadUtil$$ExternalSyntheticLambda2);
        this.context = context.getApplicationContext();
        this.downloadIndex = defaultDownloadIndex;
        this.maxParallelDownloads = (byte) 3;
        this.downloadsPaused = true;
        this.downloads = Collections.EMPTY_LIST;
        this.listeners = new CopyOnWriteArraySet();
        Handler handlerCreateHandlerForCurrentOrMainLooper = Util.createHandlerForCurrentOrMainLooper(new ListenerSet$$ExternalSyntheticLambda0((byte) 2, this));
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadManager");
        handlerThread.start();
        InternalHandler internalHandler = new InternalHandler(handlerThread, defaultDownloadIndex, emojiProcessor, handlerCreateHandlerForCurrentOrMainLooper, this.maxParallelDownloads, this.downloadsPaused);
        this.internalHandler = internalHandler;
        OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 = new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 16, (Object) this);
        this.requirementsListener = onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
        RequirementsWatcher requirementsWatcher = new RequirementsWatcher(context, onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0, DEFAULT_REQUIREMENTS);
        this.requirementsWatcher = requirementsWatcher;
        int iStart = requirementsWatcher.start();
        this.notMetRequirements = iStart;
        this.pendingMessages = 1;
        internalHandler.obtainMessage(1, iStart, 0).sendToTarget();
    }

    public final void notifyWaitingForRequirementsChanged() {
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onWaitingForRequirementsChanged(this, this.waitingForRequirements);
        }
    }

    public final void onRequirementsStateChanged(RequirementsWatcher requirementsWatcher, int i) {
        Requirements requirements = requirementsWatcher.requirements;
        if (this.notMetRequirements != i) {
            this.notMetRequirements = i;
            this.pendingMessages++;
            this.internalHandler.obtainMessage(3, i, 0).sendToTarget();
        }
        boolean zUpdateWaitingForRequirements = updateWaitingForRequirements();
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onRequirementsStateChanged();
        }
        if (zUpdateWaitingForRequirements) {
            notifyWaitingForRequirementsChanged();
        }
    }

    public final void setDownloadsPaused(boolean z) {
        if (this.downloadsPaused == z) {
            return;
        }
        this.downloadsPaused = z;
        this.pendingMessages++;
        this.internalHandler.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        boolean zUpdateWaitingForRequirements = updateWaitingForRequirements();
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).getClass();
        }
        if (zUpdateWaitingForRequirements) {
            notifyWaitingForRequirementsChanged();
        }
    }

    public final boolean updateWaitingForRequirements() {
        boolean z;
        if (!this.downloadsPaused && this.notMetRequirements != 0) {
            int i = 0;
            while (true) {
                if (i >= this.downloads.size()) {
                    z = false;
                    break;
                }
                if (((Download) this.downloads.get(i)).state == 0) {
                    z = true;
                    break;
                }
                i++;
            }
        } else {
            z = false;
            break;
        }
        boolean z2 = this.waitingForRequirements != z;
        this.waitingForRequirements = z;
        return z2;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Listener {
        void onDownloadChanged(DownloadManager downloadManager, Download download, Exception exc);

        void onDownloadRemoved(DownloadManager downloadManager, Download download);

        default void onIdle() {
        }

        default void onRequirementsStateChanged() {
        }

        default void onInitialized(DownloadManager downloadManager) {
        }

        default void onWaitingForRequirementsChanged(DownloadManager downloadManager, boolean z) {
        }
    }
}
