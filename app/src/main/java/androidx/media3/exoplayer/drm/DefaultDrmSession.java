package androidx.media3.exoplayer.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Pair;
import androidx.appcompat.app.AlertController;
import androidx.compose.runtime.Latch;
import androidx.compose.ui.platform.WeakCache;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.datastore.core.AtomicInt;
import androidx.media3.common.C;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.CopyOnWriteMultiset;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource$CleartextNotPermittedException;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.session.MediaControllerImplLegacy;
import androidx.media3.session.legacy.IMediaSession;
import androidx.media3.session.legacy.MediaControllerCompat$MediaControllerImplApi23;
import androidx.media3.session.legacy.PlaybackStateCompat;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.collect.ImmutableList;
import io.ktor.client.utils.CIOKt;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.io.FileSystemException;
import kotlin.math.MathKt;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultDrmSession implements DrmSession {
    public final Latch callback;
    public FrameworkCryptoConfig cryptoConfig;
    public ExoMediaDrm.KeyRequest currentKeyRequest;
    public AtomicInt currentKeyRequestInfo;
    public ExoMediaDrm.ProvisionRequest currentProvisionRequest;
    public final CopyOnWriteMultiset eventDispatchers;
    public final boolean isPlaceholderSession;
    public final Object keyRequestInfoLock;
    public final HashMap keyRequestParameters;
    public DrmSession.DrmSessionException lastException;
    public final CueDecoder loadErrorHandlingPolicy;
    public final ExoMediaDrm mediaDrm;
    public byte[] offlineLicenseKeySetId;
    public final boolean playClearSamplesWithoutKeys;
    public final Looper playbackLooper;
    public final PlayerId playerId;
    public final WeakCache provisioningManager;
    public int referenceCount;
    public final DefaultDrmSessionManager.MediaDrmEventListener referenceCountListener;
    public RequestHandler requestHandler;
    public HandlerThread requestHandlerThread;
    public final AlertController.ButtonHandler responseHandler;
    public final List schemeDatas;
    public byte[] sessionId;
    public byte state;
    public final UUID uuid;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RequestTask {
        public final boolean allowRetry;
        public int errorCount;
        public final Object request;
        public final long taskId;

        public RequestTask(long j, boolean z, long j2, Object obj) {
            this.taskId = j;
            this.allowRetry = z;
            this.request = obj;
        }
    }

    public DefaultDrmSession(UUID uuid, ExoMediaDrm exoMediaDrm, WeakCache weakCache, DefaultDrmSessionManager.MediaDrmEventListener mediaDrmEventListener, List list, boolean z, boolean z2, byte[] bArr, HashMap map, Latch latch, Looper looper, CueDecoder cueDecoder, PlayerId playerId) {
        this.uuid = uuid;
        this.provisioningManager = weakCache;
        this.referenceCountListener = mediaDrmEventListener;
        this.mediaDrm = exoMediaDrm;
        this.playClearSamplesWithoutKeys = z;
        this.isPlaceholderSession = z2;
        if (bArr != null) {
            this.offlineLicenseKeySetId = bArr;
            this.schemeDatas = null;
        } else {
            list.getClass();
            this.schemeDatas = Collections.unmodifiableList(list);
        }
        this.keyRequestParameters = map;
        this.callback = latch;
        this.eventDispatchers = new CopyOnWriteMultiset();
        this.loadErrorHandlingPolicy = cueDecoder;
        this.playerId = playerId;
        this.state = (byte) 2;
        this.playbackLooper = looper;
        this.responseHandler = new AlertController.ButtonHandler(this, looper, (byte) 1);
        this.keyRequestInfoLock = new Object();
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final void acquire(DrmSessionEventListener.EventDispatcher eventDispatcher) {
        verifyPlaybackThread();
        if (this.referenceCount < 0) {
            Log.e("DefaultDrmSession", "Session reference count less than zero: " + this.referenceCount);
            this.referenceCount = 0;
        }
        if (eventDispatcher != null) {
            CopyOnWriteMultiset copyOnWriteMultiset = this.eventDispatchers;
            synchronized (copyOnWriteMultiset.lock) {
                try {
                    ArrayList arrayList = new ArrayList(copyOnWriteMultiset.elements);
                    arrayList.add(eventDispatcher);
                    copyOnWriteMultiset.elements = Collections.unmodifiableList(arrayList);
                    Integer num = (Integer) copyOnWriteMultiset.elementCounts.get(eventDispatcher);
                    if (num == null) {
                        HashSet hashSet = new HashSet(copyOnWriteMultiset.elementSet);
                        hashSet.add(eventDispatcher);
                        copyOnWriteMultiset.elementSet = Collections.unmodifiableSet(hashSet);
                    }
                    copyOnWriteMultiset.elementCounts.put(eventDispatcher, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        int i = this.referenceCount + 1;
        this.referenceCount = i;
        if (i == 1) {
            UtilsKt.checkState(this.state == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.requestHandlerThread = handlerThread;
            handlerThread.start();
            this.requestHandler = new RequestHandler(this, this.requestHandlerThread.getLooper());
            if (openInternal()) {
                doLicense(true);
            }
        } else if (eventDispatcher != null && isOpen() && this.eventDispatchers.count(eventDispatcher) == 1) {
            eventDispatcher.drmSessionAcquired(this.state);
        }
        DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
        if (defaultDrmSessionManager.sessionKeepaliveMs != -9223372036854775807L) {
            defaultDrmSessionManager.keepaliveSessions.remove(this);
            Handler handler = defaultDrmSessionManager.playbackHandler;
            handler.getClass();
            handler.removeCallbacksAndMessages(this);
        }
    }

    public final void doLicense(boolean z) {
        long jMin;
        long j;
        Set set;
        if (this.isPlaceholderSession) {
            return;
        }
        byte[] bArr = this.sessionId;
        String str = Util.DEVICE_DEBUG_INFO;
        boolean z2 = true;
        if (this.offlineLicenseKeySetId == null) {
            postKeyRequest(1, z, bArr);
            return;
        }
        if (this.state != 4) {
            try {
                this.mediaDrm.restoreKeys(this.sessionId, this.offlineLicenseKeySetId);
            } catch (Exception | NoSuchMethodError e) {
                onError(e, 1);
                z2 = false;
            }
            if (!z2) {
                return;
            }
        }
        if (C.WIDEVINE_UUID.equals(this.uuid)) {
            verifyPlaybackThread();
            byte[] bArr2 = this.sessionId;
            Pair pair = null;
            Map mapQueryKeyStatus = bArr2 == null ? null : this.mediaDrm.queryKeyStatus(bArr2);
            if (mapQueryKeyStatus != null) {
                long j2 = -9223372036854775807L;
                try {
                    String str2 = (String) mapQueryKeyStatus.get("LicenseDurationRemaining");
                    j = str2 != null ? Long.parseLong(str2) : -9223372036854775807L;
                } catch (NumberFormatException unused) {
                }
                Long lValueOf = Long.valueOf(j);
                try {
                    String str3 = (String) mapQueryKeyStatus.get("PlaybackDurationRemaining");
                    if (str3 != null) {
                        j2 = Long.parseLong(str3);
                    }
                } catch (NumberFormatException unused2) {
                }
                pair = new Pair(lValueOf, Long.valueOf(j2));
            }
            pair.getClass();
            jMin = Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
        } else {
            jMin = Long.MAX_VALUE;
        }
        if (jMin <= 60) {
            Log.d("Offline license has expired or will expire soon. Remaining seconds: " + jMin);
            postKeyRequest(2, z, bArr);
            return;
        }
        if (jMin <= 0) {
            onError(new KeysExpiredException(), 2);
            return;
        }
        this.state = (byte) 4;
        CopyOnWriteMultiset copyOnWriteMultiset = this.eventDispatchers;
        synchronized (copyOnWriteMultiset.lock) {
            set = copyOnWriteMultiset.elementSet;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((DrmSessionEventListener.EventDispatcher) it.next()).drmKeysRestored();
        }
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final FrameworkCryptoConfig getCryptoConfig() {
        verifyPlaybackThread();
        return this.cryptoConfig;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final DrmSession.DrmSessionException getError() {
        verifyPlaybackThread();
        if (this.state == 1) {
            return this.lastException;
        }
        return null;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final UUID getSchemeUuid() {
        verifyPlaybackThread();
        return this.uuid;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final int getState() {
        verifyPlaybackThread();
        return this.state;
    }

    public final boolean isOpen() {
        byte b = this.state;
        return b == 3 || b == 4;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    public final void onError(Throwable th, int i) {
        int errorCodeForMediaDrmErrorCode;
        Set set;
        if (th instanceof MediaDrm.MediaDrmStateException) {
            errorCodeForMediaDrmErrorCode = Util.getErrorCodeForMediaDrmErrorCode(Util.getErrorCodeFromPlatformDiagnosticsInfo(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo()));
        } else if (th instanceof MediaDrmResetException) {
            errorCodeForMediaDrmErrorCode = 6006;
        } else if ((th instanceof NotProvisionedException) || MathKt.isFailureToConstructNotProvisionedException(th)) {
            errorCodeForMediaDrmErrorCode = 6002;
        } else if (th instanceof DeniedByServerException) {
            errorCodeForMediaDrmErrorCode = 6007;
        } else if (th instanceof UnsupportedDrmException) {
            errorCodeForMediaDrmErrorCode = 6001;
        } else if (th instanceof DefaultDrmSessionManager.MissingSchemeDataException) {
            errorCodeForMediaDrmErrorCode = 6003;
        } else if (th instanceof KeysExpiredException) {
            errorCodeForMediaDrmErrorCode = 6008;
        } else if (i == 1) {
            errorCodeForMediaDrmErrorCode = 6006;
        } else if (i == 2) {
            errorCodeForMediaDrmErrorCode = 6004;
        } else {
            if (i != 3) {
                Path$$ExternalSyntheticBUOutline0.m();
                return;
            }
            errorCodeForMediaDrmErrorCode = 6002;
        }
        this.lastException = new DrmSession.DrmSessionException(th, errorCodeForMediaDrmErrorCode);
        Log.e("DefaultDrmSession", "DRM session error", th);
        if (th instanceof Exception) {
            CopyOnWriteMultiset copyOnWriteMultiset = this.eventDispatchers;
            synchronized (copyOnWriteMultiset.lock) {
                set = copyOnWriteMultiset.elementSet;
            }
            Iterator it = set.iterator();
            while (it.hasNext()) {
                ((DrmSessionEventListener.EventDispatcher) it.next()).drmSessionManagerError((Exception) th);
            }
        } else {
            if (!(th instanceof Error)) {
                throw new IllegalStateException("Unexpected Throwable subclass", th);
            }
            if (!MathKt.isFailureToConstructResourceBusyException(th) && !MathKt.isFailureToConstructNotProvisionedException(th)) {
                throw ((Error) th);
            }
        }
        if (this.state != 4) {
            this.state = (byte) 1;
        }
    }

    public final void onKeysError(Throwable th, boolean z) {
        if ((th instanceof NotProvisionedException) || MathKt.isFailureToConstructNotProvisionedException(th)) {
            this.provisioningManager.provisionRequired(this);
        } else {
            onError(th, z ? 1 : 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0053  */
    /* JADX WARN: Code duplicated, block: B:25:0x0059  */
    public final boolean openInternal() {
        Set set;
        if (isOpen()) {
            return true;
        }
        try {
            byte[] bArrOpenSession = this.mediaDrm.openSession();
            this.sessionId = bArrOpenSession;
            this.mediaDrm.setPlayerIdForSession(bArrOpenSession, this.playerId);
            this.cryptoConfig = this.mediaDrm.createCryptoConfig(this.sessionId);
            this.state = (byte) 3;
            CopyOnWriteMultiset copyOnWriteMultiset = this.eventDispatchers;
            synchronized (copyOnWriteMultiset.lock) {
                set = copyOnWriteMultiset.elementSet;
            }
            Iterator it = set.iterator();
            while (it.hasNext()) {
                ((DrmSessionEventListener.EventDispatcher) it.next()).drmSessionAcquired(3);
            }
            this.sessionId.getClass();
            return true;
        } catch (NotProvisionedException unused) {
            this.provisioningManager.provisionRequired(this);
            return false;
        } catch (Exception e) {
            e = e;
            if (MathKt.isFailureToConstructNotProvisionedException(e)) {
                this.provisioningManager.provisionRequired(this);
                return false;
            }
            onError(e, 1);
            return false;
        } catch (NoSuchMethodError e2) {
            e = e2;
            if (MathKt.isFailureToConstructNotProvisionedException(e)) {
                this.provisioningManager.provisionRequired(this);
                return false;
            }
            onError(e, 1);
            return false;
        }
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final boolean playClearSamplesWithoutKeys() {
        verifyPlaybackThread();
        return this.playClearSamplesWithoutKeys;
    }

    public final void postKeyRequest(int i, boolean z, byte[] bArr) {
        try {
            synchronized (this.keyRequestInfoLock) {
                try {
                    this.currentKeyRequestInfo = new AtomicInt((byte) 24);
                    List list = this.schemeDatas;
                    if (list != null) {
                        ImmutableList.copyOf((Collection) list);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            ExoMediaDrm.KeyRequest keyRequest = this.mediaDrm.getKeyRequest(bArr, this.schemeDatas, i, this.keyRequestParameters);
            this.currentKeyRequest = keyRequest;
            RequestHandler requestHandler = this.requestHandler;
            String str = Util.DEVICE_DEBUG_INFO;
            keyRequest.getClass();
            requestHandler.getClass();
            requestHandler.obtainMessage(2, new RequestTask(LoadEventInfo.idSource.getAndIncrement(), z, SystemClock.elapsedRealtime(), keyRequest)).sendToTarget();
        } catch (Exception | NoSuchMethodError e) {
            onKeysError(e, true);
        }
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final void release(DrmSessionEventListener.EventDispatcher eventDispatcher) {
        verifyPlaybackThread();
        int i = this.referenceCount;
        if (i <= 0) {
            Log.e("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i2 = i - 1;
        this.referenceCount = i2;
        if (i2 == 0) {
            this.state = (byte) 0;
            AlertController.ButtonHandler buttonHandler = this.responseHandler;
            String str = Util.DEVICE_DEBUG_INFO;
            buttonHandler.removeCallbacksAndMessages(null);
            RequestHandler requestHandler = this.requestHandler;
            synchronized (requestHandler) {
                requestHandler.removeCallbacksAndMessages(null);
                requestHandler.isReleased = true;
            }
            this.requestHandler = null;
            this.requestHandlerThread.quit();
            this.requestHandlerThread = null;
            this.cryptoConfig = null;
            this.lastException = null;
            this.currentKeyRequest = null;
            synchronized (this.keyRequestInfoLock) {
                this.currentKeyRequestInfo = null;
            }
            this.currentProvisionRequest = null;
            byte[] bArr = this.sessionId;
            if (bArr != null) {
                this.mediaDrm.closeSession(bArr);
                this.sessionId = null;
            }
        }
        if (eventDispatcher != null) {
            CopyOnWriteMultiset copyOnWriteMultiset = this.eventDispatchers;
            synchronized (copyOnWriteMultiset.lock) {
                try {
                    Integer num = (Integer) copyOnWriteMultiset.elementCounts.get(eventDispatcher);
                    if (num != null) {
                        ArrayList arrayList = new ArrayList(copyOnWriteMultiset.elements);
                        arrayList.remove(eventDispatcher);
                        copyOnWriteMultiset.elements = Collections.unmodifiableList(arrayList);
                        int iIntValue = num.intValue();
                        HashMap map = copyOnWriteMultiset.elementCounts;
                        if (iIntValue == 1) {
                            map.remove(eventDispatcher);
                            HashSet hashSet = new HashSet(copyOnWriteMultiset.elementSet);
                            hashSet.remove(eventDispatcher);
                            copyOnWriteMultiset.elementSet = Collections.unmodifiableSet(hashSet);
                        } else {
                            map.put(eventDispatcher, Integer.valueOf(num.intValue() - 1));
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.eventDispatchers.count(eventDispatcher) == 0) {
                eventDispatcher.drmSessionReleased();
            }
        }
        DefaultDrmSessionManager.MediaDrmEventListener mediaDrmEventListener = this.referenceCountListener;
        int i3 = this.referenceCount;
        DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
        if (i3 == 1 && defaultDrmSessionManager.prepareCallsCount > 0 && defaultDrmSessionManager.sessionKeepaliveMs != -9223372036854775807L) {
            defaultDrmSessionManager.keepaliveSessions.add(this);
            Handler handler = defaultDrmSessionManager.playbackHandler;
            handler.getClass();
            handler.postAtTime(new ActivityCompat$$ExternalSyntheticLambda0((byte) 24, (Object) this), this, SystemClock.uptimeMillis() + ((long) defaultDrmSessionManager.sessionKeepaliveMs));
        } else if (i3 == 0) {
            defaultDrmSessionManager.sessions.remove(this);
            if (defaultDrmSessionManager.placeholderDrmSession == this) {
                defaultDrmSessionManager.placeholderDrmSession = null;
            }
            if (defaultDrmSessionManager.noMultiSessionDrmSession == this) {
                defaultDrmSessionManager.noMultiSessionDrmSession = null;
            }
            WeakCache weakCache = defaultDrmSessionManager.provisioningManagerImpl;
            HashSet hashSet2 = (HashSet) weakCache.values;
            hashSet2.remove(this);
            if (((DefaultDrmSession) weakCache.referenceQueue) == this) {
                weakCache.referenceQueue = null;
                if (!hashSet2.isEmpty()) {
                    DefaultDrmSession defaultDrmSession = (DefaultDrmSession) hashSet2.iterator().next();
                    weakCache.referenceQueue = defaultDrmSession;
                    ExoMediaDrm.ProvisionRequest provisionRequest = defaultDrmSession.mediaDrm.getProvisionRequest();
                    defaultDrmSession.currentProvisionRequest = provisionRequest;
                    RequestHandler requestHandler2 = defaultDrmSession.requestHandler;
                    String str2 = Util.DEVICE_DEBUG_INFO;
                    provisionRequest.getClass();
                    requestHandler2.getClass();
                    requestHandler2.obtainMessage(1, new RequestTask(LoadEventInfo.idSource.getAndIncrement(), true, SystemClock.elapsedRealtime(), provisionRequest)).sendToTarget();
                }
            }
            if (defaultDrmSessionManager.sessionKeepaliveMs != -9223372036854775807L) {
                Handler handler2 = defaultDrmSessionManager.playbackHandler;
                handler2.getClass();
                handler2.removeCallbacksAndMessages(this);
                defaultDrmSessionManager.keepaliveSessions.remove(this);
            }
        }
        defaultDrmSessionManager.maybeReleaseMediaDrm();
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final boolean requiresSecureDecoder(String str) {
        verifyPlaybackThread();
        byte[] bArr = this.sessionId;
        bArr.getClass();
        return this.mediaDrm.requiresSecureDecoder(str, bArr);
    }

    public final void verifyPlaybackThread() {
        Thread threadCurrentThread = Thread.currentThread();
        Looper looper = this.playbackLooper;
        if (threadCurrentThread != looper.getThread()) {
            Log.w("DefaultDrmSession", "DefaultDrmSession accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + looper.getThread().getName(), new IllegalStateException());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RequestHandler extends Handler {
        public final /* synthetic */ byte $r8$classId = 0;
        public boolean isReleased;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestHandler(MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback, Looper looper) {
            super(looper);
            this.this$0 = controllerCompatCallback;
            this.isReleased = false;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Throwable fileSystemException;
            long jMin;
            Object objExecuteProvisionRequest;
            LoadEventInfo loadEventInfo;
            int repeatMode;
            boolean zIsCaptioningEnabled;
            switch (this.$r8$classId) {
                case 0:
                    RequestTask requestTask = (RequestTask) message.obj;
                    try {
                        int i = message.what;
                        if (i == 1) {
                            objExecuteProvisionRequest = ((DefaultDrmSession) this.this$0).callback.executeProvisionRequest((ExoMediaDrm.ProvisionRequest) requestTask.request);
                        } else {
                            if (i != 2) {
                                throw new RuntimeException();
                            }
                            DefaultDrmSession defaultDrmSession = (DefaultDrmSession) this.this$0;
                            MediaDrmCallback$Response mediaDrmCallback$ResponseExecuteKeyRequest = defaultDrmSession.callback.executeKeyRequest(defaultDrmSession.uuid, (ExoMediaDrm.KeyRequest) requestTask.request);
                            synchronized (((DefaultDrmSession) this.this$0).keyRequestInfoLock) {
                                try {
                                    AtomicInt atomicInt = ((DefaultDrmSession) this.this$0).currentKeyRequestInfo;
                                    if (atomicInt != null && (loadEventInfo = mediaDrmCallback$ResponseExecuteKeyRequest.loadEventInfo) != null) {
                                        SystemClock.elapsedRealtime();
                                        ((ImmutableList.Builder) atomicInt.delegate).add((Object) new LoadEventInfo(loadEventInfo.dataSpec, loadEventInfo.uri, loadEventInfo.responseHeaders, loadEventInfo.elapsedRealtimeMs, loadEventInfo.bytesLoaded));
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                                break;
                            }
                            objExecuteProvisionRequest = mediaDrmCallback$ResponseExecuteKeyRequest;
                        }
                    } catch (MediaDrmCallbackException e) {
                        RequestTask requestTask2 = (RequestTask) message.obj;
                        objExecuteProvisionRequest = e;
                        if (requestTask2.allowRetry) {
                            int i2 = requestTask2.errorCount + 1;
                            requestTask2.errorCount = i2;
                            ((DefaultDrmSession) this.this$0).loadErrorHandlingPolicy.getClass();
                            if (i2 <= 3) {
                                DataSpec dataSpec = e.dataSpec;
                                Uri uri = e.uriAfterRedirects;
                                Map map = e.responseHeaders;
                                long jElapsedRealtime = SystemClock.elapsedRealtime();
                                SystemClock.elapsedRealtime();
                                LoadEventInfo loadEventInfo2 = new LoadEventInfo(dataSpec, uri, map, jElapsedRealtime, e.bytesLoaded);
                                if (e.getCause() instanceof IOException) {
                                    objExecuteProvisionRequest = e;
                                    fileSystemException = (IOException) e.getCause();
                                } else {
                                    objExecuteProvisionRequest = e;
                                    fileSystemException = new FileSystemException(e.getCause());
                                }
                                CueDecoder cueDecoder = ((DefaultDrmSession) this.this$0).loadErrorHandlingPolicy;
                                int i3 = requestTask2.errorCount;
                                cueDecoder.getClass();
                                while (true) {
                                    if (fileSystemException == null) {
                                        jMin = Math.min((i3 - 1) * CIOKt.DEFAULT_HTTP_POOL_SIZE, 5000);
                                    } else if ((fileSystemException instanceof ParserException) || (fileSystemException instanceof FileNotFoundException) || (fileSystemException instanceof HttpDataSource$CleartextNotPermittedException) || (fileSystemException instanceof Loader.UnexpectedLoaderException) || ((fileSystemException instanceof DataSourceException) && ((DataSourceException) fileSystemException).reason == 2008)) {
                                        jMin = -9223372036854775807L;
                                    } else {
                                        fileSystemException = fileSystemException.getCause();
                                    }
                                }
                                objExecuteProvisionRequest = e;
                                if (jMin != -9223372036854775807L) {
                                    synchronized (((DefaultDrmSession) this.this$0).keyRequestInfoLock) {
                                        AtomicInt atomicInt2 = ((DefaultDrmSession) this.this$0).currentKeyRequestInfo;
                                        if (atomicInt2 != null) {
                                            ((ImmutableList.Builder) atomicInt2.delegate).add((Object) loadEventInfo2);
                                        }
                                        synchronized (this) {
                                            try {
                                                if (!this.isReleased) {
                                                    sendMessageDelayed(Message.obtain(message), jMin);
                                                    return;
                                                }
                                                objExecuteProvisionRequest = e;
                                            } catch (Throwable th2) {
                                                throw th2;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        Log.w("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e2);
                        objExecuteProvisionRequest = e2;
                    }
                    objExecuteProvisionRequest = e;
                    CueDecoder cueDecoder2 = ((DefaultDrmSession) this.this$0).loadErrorHandlingPolicy;
                    long j = requestTask.taskId;
                    cueDecoder2.getClass();
                    synchronized (this) {
                        try {
                            if (!this.isReleased) {
                                ((DefaultDrmSession) this.this$0).responseHandler.obtainMessage(message.what, Pair.create(requestTask.request, objExecuteProvisionRequest)).sendToTarget();
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                        break;
                    }
                    return;
                default:
                    MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback = (MediaControllerImplLegacy.ControllerCompatCallback) this.this$0;
                    MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                    if (this.isReleased) {
                        int i4 = message.what;
                        if (i4 == 2) {
                            controllerCompatCallback.onPlaybackStateChanged((PlaybackStateCompat) message.obj);
                            return;
                        }
                        if (i4 == 8) {
                            mediaControllerImplLegacy.instance.release();
                            return;
                        }
                        if (i4 == 9) {
                            int iIntValue = ((Integer) message.obj).intValue();
                            MediaControllerImplLegacy.LegacyPlayerInfo legacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo;
                            mediaControllerImplLegacy.pendingLegacyPlayerInfo = new MediaControllerImplLegacy.LegacyPlayerInfo(legacyPlayerInfo.playbackInfoCompat, legacyPlayerInfo.playbackStateCompat, legacyPlayerInfo.mediaMetadataCompat, legacyPlayerInfo.queue, legacyPlayerInfo.queueTitle, iIntValue, legacyPlayerInfo.shuffleMode, legacyPlayerInfo.sessionExtras);
                            controllerCompatCallback.startWaitingForPendingChanges();
                            return;
                        }
                        switch (i4) {
                            case 11:
                                controllerCompatCallback.onCaptioningEnabledChanged(((Boolean) message.obj).booleanValue());
                                return;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                int iIntValue2 = ((Integer) message.obj).intValue();
                                MediaControllerImplLegacy.LegacyPlayerInfo legacyPlayerInfo2 = mediaControllerImplLegacy.pendingLegacyPlayerInfo;
                                mediaControllerImplLegacy.pendingLegacyPlayerInfo = new MediaControllerImplLegacy.LegacyPlayerInfo(legacyPlayerInfo2.playbackInfoCompat, legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, legacyPlayerInfo2.queue, legacyPlayerInfo2.queueTitle, legacyPlayerInfo2.repeatMode, iIntValue2, legacyPlayerInfo2.sessionExtras);
                                controllerCompatCallback.startWaitingForPendingChanges();
                                return;
                            case 13:
                                if (!mediaControllerImplLegacy.connected) {
                                    mediaControllerImplLegacy.onConnected();
                                    return;
                                }
                                MediaControllerImplLegacy.LegacyPlayerInfo legacyPlayerInfo3 = mediaControllerImplLegacy.pendingLegacyPlayerInfo;
                                PlaybackStateCompat playbackStateCompatConvertToSafePlaybackStateCompat = MediaControllerImplLegacy.convertToSafePlaybackStateCompat(mediaControllerImplLegacy.controllerCompat.getPlaybackState());
                                IMediaSession extraBinder = ((MediaControllerCompat$MediaControllerImplApi23) mediaControllerImplLegacy.controllerCompat.mCallback).sessionToken.getExtraBinder();
                                int shuffleMode = -1;
                                if (extraBinder != null) {
                                    try {
                                        repeatMode = extraBinder.getRepeatMode();
                                    } catch (RemoteException | SecurityException e3) {
                                        Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", e3);
                                        repeatMode = -1;
                                    }
                                } else {
                                    repeatMode = -1;
                                }
                                IMediaSession extraBinder2 = ((MediaControllerCompat$MediaControllerImplApi23) mediaControllerImplLegacy.controllerCompat.mCallback).sessionToken.getExtraBinder();
                                if (extraBinder2 != null) {
                                    try {
                                        shuffleMode = extraBinder2.getShuffleMode();
                                    } catch (RemoteException | SecurityException e4) {
                                        Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", e4);
                                    }
                                    break;
                                }
                                mediaControllerImplLegacy.pendingLegacyPlayerInfo = new MediaControllerImplLegacy.LegacyPlayerInfo(legacyPlayerInfo3.playbackInfoCompat, playbackStateCompatConvertToSafePlaybackStateCompat, legacyPlayerInfo3.mediaMetadataCompat, legacyPlayerInfo3.queue, legacyPlayerInfo3.queueTitle, repeatMode, shuffleMode, legacyPlayerInfo3.sessionExtras);
                                IMediaSession extraBinder3 = ((MediaControllerCompat$MediaControllerImplApi23) mediaControllerImplLegacy.controllerCompat.mCallback).sessionToken.getExtraBinder();
                                if (extraBinder3 != null) {
                                    try {
                                        zIsCaptioningEnabled = extraBinder3.isCaptioningEnabled();
                                    } catch (RemoteException | SecurityException e5) {
                                        Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", e5);
                                        zIsCaptioningEnabled = false;
                                    }
                                    break;
                                } else {
                                    zIsCaptioningEnabled = false;
                                }
                                controllerCompatCallback.onCaptioningEnabledChanged(zIsCaptioningEnabled);
                                controllerCompatCallback.pendingChangesHandler.removeMessages(1);
                                mediaControllerImplLegacy.handleNewLegacyParameters(false, mediaControllerImplLegacy.pendingLegacyPlayerInfo);
                                return;
                            default:
                                return;
                        }
                    }
                    return;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestHandler(DefaultDrmSession defaultDrmSession, Looper looper) {
            super(looper);
            this.this$0 = defaultDrmSession;
        }
    }
}
