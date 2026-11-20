package androidx.media3.exoplayer.drm;

import android.media.ResourceBusyException;
import android.media.UnsupportedSchemeException;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.appcompat.app.AlertController;
import androidx.collection.internal.Lock;
import androidx.compose.runtime.Latch;
import androidx.compose.ui.platform.WeakCache;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.extractor.text.CueDecoder;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultDrmSessionManager implements DrmSessionManager {
    public final Latch callback;
    public ExoMediaDrm exoMediaDrm;
    public final FrameworkMediaDrm$$ExternalSyntheticLambda0 exoMediaDrmProvider;
    public final Set keepaliveSessions;
    public final HashMap keyRequestParameters;
    public final CueDecoder loadErrorHandlingPolicy;
    public volatile AlertController.ButtonHandler mediaDrmHandler;
    public final boolean multiSession;
    public DefaultDrmSession noMultiSessionDrmSession;
    public byte[] offlineLicenseKeySetId;
    public DefaultDrmSession placeholderDrmSession;
    public final boolean playClearSamplesWithoutKeys;
    public Handler playbackHandler;
    public Looper playbackLooper;
    public PlayerId playerId;
    public final Set preacquiredSessionReferences;
    public int prepareCallsCount;
    public final WeakCache provisioningManagerImpl;
    public final MediaDrmEventListener referenceCountListener;
    public final int sessionKeepaliveMs;
    public final ArrayList sessions;
    public final int[] useDrmSessionsForClearContentTrackTypes;
    public final UUID uuid;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MediaDrmEventListener {
        public /* synthetic */ MediaDrmEventListener() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MissingSchemeDataException extends Exception {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PreacquiredSessionReference implements DrmSessionManager.DrmSessionReference {
        public final DrmSessionEventListener.EventDispatcher eventDispatcher;
        public boolean isReleased;
        public DrmSession session;

        public PreacquiredSessionReference(DrmSessionEventListener.EventDispatcher eventDispatcher) {
            this.eventDispatcher = eventDispatcher;
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionManager.DrmSessionReference
        public final void release() {
            Handler handler = DefaultDrmSessionManager.this.playbackHandler;
            handler.getClass();
            Util.postOrRun(handler, new ActivityCompat$$ExternalSyntheticLambda0((byte) 23, (Object) this));
        }
    }

    public DefaultDrmSessionManager(UUID uuid, Latch latch, HashMap map, boolean z, int[] iArr, boolean z2, CueDecoder cueDecoder) {
        uuid.getClass();
        UtilsKt.checkArgument("Use C.CLEARKEY_UUID instead", !C.COMMON_PSSH_UUID.equals(uuid));
        this.uuid = uuid;
        this.exoMediaDrmProvider = FrameworkMediaDrm.DEFAULT_PROVIDER;
        this.callback = latch;
        this.keyRequestParameters = map;
        this.multiSession = z;
        this.useDrmSessionsForClearContentTrackTypes = iArr;
        this.playClearSamplesWithoutKeys = z2;
        this.loadErrorHandlingPolicy = cueDecoder;
        this.provisioningManagerImpl = new WeakCache((byte) 24);
        this.referenceCountListener = new MediaDrmEventListener();
        this.sessions = new ArrayList();
        this.preacquiredSessionReferences = Collections.newSetFromMap(new IdentityHashMap());
        this.keepaliveSessions = Collections.newSetFromMap(new IdentityHashMap());
        this.sessionKeepaliveMs = 300000;
    }

    public static boolean acquisitionFailedIndicatingResourceShortage(DefaultDrmSession defaultDrmSession) {
        defaultDrmSession.verifyPlaybackThread();
        if (defaultDrmSession.state != 1) {
            return false;
        }
        DrmSession.DrmSessionException error = defaultDrmSession.getError();
        error.getClass();
        Throwable cause = error.getCause();
        return (cause instanceof ResourceBusyException) || MathKt.isFailureToConstructResourceBusyException(cause);
    }

    public static ArrayList getSchemeDatas(DrmInitData drmInitData, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(drmInitData.schemeDataCount);
        for (int i = 0; i < drmInitData.schemeDataCount; i++) {
            DrmInitData.SchemeData schemeData = drmInitData.schemeDatas[i];
            if ((schemeData.matches(uuid) || (C.CLEARKEY_UUID.equals(uuid) && schemeData.matches(C.COMMON_PSSH_UUID))) && (schemeData.data != null || z)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    public final DrmSession acquireSession(Looper looper, DrmSessionEventListener.EventDispatcher eventDispatcher, Format format, boolean z) {
        ArrayList schemeDatas;
        byte b = 2;
        if (this.mediaDrmHandler == null) {
            this.mediaDrmHandler = new AlertController.ButtonHandler(this, looper, b);
        }
        DrmInitData drmInitData = format.drmInitData;
        int i = 0;
        DefaultDrmSession defaultDrmSession = null;
        if (drmInitData == null) {
            int trackType = MimeTypes.getTrackType(format.sampleMimeType);
            ExoMediaDrm exoMediaDrm = this.exoMediaDrm;
            exoMediaDrm.getClass();
            if (exoMediaDrm.getCryptoType() != 2 || !FrameworkCryptoConfig.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) {
                int[] iArr = this.useDrmSessionsForClearContentTrackTypes;
                while (true) {
                    if (i >= iArr.length) {
                        i = -1;
                        break;
                    }
                    if (iArr[i] == trackType) {
                        break;
                    }
                    i++;
                }
                if (i != -1 && exoMediaDrm.getCryptoType() != 1) {
                    DefaultDrmSession defaultDrmSession2 = this.placeholderDrmSession;
                    if (defaultDrmSession2 == null) {
                        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
                        DefaultDrmSession defaultDrmSessionCreateAndAcquireSessionWithRetry = createAndAcquireSessionWithRetry(RegularImmutableList.EMPTY, true, null, z);
                        this.sessions.add(defaultDrmSessionCreateAndAcquireSessionWithRetry);
                        this.placeholderDrmSession = defaultDrmSessionCreateAndAcquireSessionWithRetry;
                    } else {
                        defaultDrmSession2.acquire(null);
                    }
                    return this.placeholderDrmSession;
                }
            }
            return null;
        }
        if (this.offlineLicenseKeySetId == null) {
            schemeDatas = getSchemeDatas(drmInitData, this.uuid, false);
            if (schemeDatas.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException("Media does not support uuid: " + this.uuid);
                Log.e("DefaultDrmSessionMgr", "DRM error", missingSchemeDataException);
                eventDispatcher.drmSessionManagerError(missingSchemeDataException);
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(missingSchemeDataException, 6003));
            }
        } else {
            schemeDatas = null;
        }
        if (this.multiSession) {
            ArrayList arrayList = this.sessions;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                DefaultDrmSession defaultDrmSession3 = (DefaultDrmSession) obj;
                if (Objects.equals(defaultDrmSession3.schemeDatas, schemeDatas)) {
                    defaultDrmSession = defaultDrmSession3;
                    break;
                }
            }
        } else {
            defaultDrmSession = this.noMultiSessionDrmSession;
        }
        if (defaultDrmSession != null) {
            defaultDrmSession.acquire(eventDispatcher);
            return defaultDrmSession;
        }
        DefaultDrmSession defaultDrmSessionCreateAndAcquireSessionWithRetry2 = createAndAcquireSessionWithRetry(schemeDatas, false, eventDispatcher, z);
        if (!this.multiSession) {
            this.noMultiSessionDrmSession = defaultDrmSessionCreateAndAcquireSessionWithRetry2;
        }
        this.sessions.add(defaultDrmSessionCreateAndAcquireSessionWithRetry2);
        return defaultDrmSessionCreateAndAcquireSessionWithRetry2;
    }

    public final DefaultDrmSession createAndAcquireSession(List list, boolean z, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.exoMediaDrm.getClass();
        boolean z2 = this.playClearSamplesWithoutKeys | z;
        ExoMediaDrm exoMediaDrm = this.exoMediaDrm;
        byte[] bArr = this.offlineLicenseKeySetId;
        Looper looper = this.playbackLooper;
        looper.getClass();
        PlayerId playerId = this.playerId;
        playerId.getClass();
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.uuid, exoMediaDrm, this.provisioningManagerImpl, this.referenceCountListener, list, z2, z, bArr, this.keyRequestParameters, this.callback, looper, this.loadErrorHandlingPolicy, playerId);
        defaultDrmSession.acquire(eventDispatcher);
        if (this.sessionKeepaliveMs != -9223372036854775807L) {
            defaultDrmSession.acquire(null);
        }
        return defaultDrmSession;
    }

    public final DefaultDrmSession createAndAcquireSessionWithRetry(List list, boolean z, DrmSessionEventListener.EventDispatcher eventDispatcher, boolean z2) {
        DefaultDrmSession defaultDrmSessionCreateAndAcquireSession = createAndAcquireSession(list, z, eventDispatcher);
        boolean zAcquisitionFailedIndicatingResourceShortage = acquisitionFailedIndicatingResourceShortage(defaultDrmSessionCreateAndAcquireSession);
        int i = this.sessionKeepaliveMs;
        Set set = this.keepaliveSessions;
        if (zAcquisitionFailedIndicatingResourceShortage && !set.isEmpty()) {
            UnmodifiableIterator it = ImmutableSet.copyOf((Collection) set).iterator();
            while (it.hasNext()) {
                ((DrmSession) it.next()).release(null);
            }
            defaultDrmSessionCreateAndAcquireSession.release(eventDispatcher);
            if (i != -9223372036854775807L) {
                defaultDrmSessionCreateAndAcquireSession.release(null);
            }
            defaultDrmSessionCreateAndAcquireSession = createAndAcquireSession(list, z, eventDispatcher);
        }
        if (acquisitionFailedIndicatingResourceShortage(defaultDrmSessionCreateAndAcquireSession) && z2) {
            Set set2 = this.preacquiredSessionReferences;
            if (!set2.isEmpty()) {
                UnmodifiableIterator it2 = ImmutableSet.copyOf((Collection) set2).iterator();
                while (it2.hasNext()) {
                    ((PreacquiredSessionReference) it2.next()).release();
                }
                if (!set.isEmpty()) {
                    UnmodifiableIterator it3 = ImmutableSet.copyOf((Collection) set).iterator();
                    while (it3.hasNext()) {
                        ((DrmSession) it3.next()).release(null);
                    }
                }
                defaultDrmSessionCreateAndAcquireSession.release(eventDispatcher);
                if (i != -9223372036854775807L) {
                    defaultDrmSessionCreateAndAcquireSession.release(null);
                }
                return createAndAcquireSession(list, z, eventDispatcher);
            }
        }
        return defaultDrmSessionCreateAndAcquireSession;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager
    public final int getCryptoType(Format format) {
        verifyPlaybackThread(false);
        ExoMediaDrm exoMediaDrm = this.exoMediaDrm;
        exoMediaDrm.getClass();
        int cryptoType = exoMediaDrm.getCryptoType();
        DrmInitData drmInitData = format.drmInitData;
        if (drmInitData == null) {
            int trackType = MimeTypes.getTrackType(format.sampleMimeType);
            int i = 0;
            while (true) {
                int[] iArr = this.useDrmSessionsForClearContentTrackTypes;
                if (i >= iArr.length) {
                    i = -1;
                    break;
                }
                if (iArr[i] == trackType) {
                    break;
                }
                i++;
            }
            if (i == -1) {
                return 0;
            }
        } else if (this.offlineLicenseKeySetId == null) {
            UUID uuid = this.uuid;
            if (getSchemeDatas(drmInitData, uuid, true).isEmpty()) {
                if (drmInitData.schemeDataCount == 1 && drmInitData.schemeDatas[0].matches(C.COMMON_PSSH_UUID)) {
                    Log.w("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + uuid);
                }
                return 1;
            }
            String str = drmInitData.schemeType;
            if (str != null && !"cenc".equals(str) && !"cbcs".equals(str) && ("cbc1".equals(str) || "cens".equals(str))) {
                return 1;
            }
        }
        return cryptoType;
    }

    public final void maybeReleaseMediaDrm() {
        if (this.exoMediaDrm != null && this.prepareCallsCount == 0 && this.sessions.isEmpty() && this.preacquiredSessionReferences.isEmpty()) {
            ExoMediaDrm exoMediaDrm = this.exoMediaDrm;
            exoMediaDrm.getClass();
            exoMediaDrm.release();
            this.exoMediaDrm = null;
        }
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager
    public final DrmSessionManager.DrmSessionReference preacquireSession(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        UtilsKt.checkState(this.prepareCallsCount > 0);
        this.playbackLooper.getClass();
        PreacquiredSessionReference preacquiredSessionReference = new PreacquiredSessionReference(eventDispatcher);
        Handler handler = this.playbackHandler;
        handler.getClass();
        handler.post(new ComponentActivity$$ExternalSyntheticLambda10(preacquiredSessionReference, format, (byte) 23));
        return preacquiredSessionReference;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager
    public final void prepare() {
        ExoMediaDrm lock;
        verifyPlaybackThread(true);
        int i = this.prepareCallsCount;
        this.prepareCallsCount = i + 1;
        if (i != 0) {
            return;
        }
        if (this.exoMediaDrm == null) {
            UUID uuid = this.uuid;
            this.exoMediaDrmProvider.getClass();
            try {
                try {
                    try {
                        lock = new FrameworkMediaDrm(uuid);
                    } catch (Exception e) {
                        throw new UnsupportedDrmException(e);
                    }
                } catch (UnsupportedSchemeException e2) {
                    throw new UnsupportedDrmException(e2);
                }
            } catch (UnsupportedDrmException unused) {
                Log.e("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
                lock = new Lock((byte) 29);
            }
            this.exoMediaDrm = lock;
            lock.setOnEventListener(new MediaDrmEventListener());
            return;
        }
        if (this.sessionKeepaliveMs == -9223372036854775807L) {
            return;
        }
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.sessions;
            if (i2 >= arrayList.size()) {
                return;
            }
            ((DefaultDrmSession) arrayList.get(i2)).acquire(null);
            i2++;
        }
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager
    public final void release() {
        verifyPlaybackThread(true);
        int i = this.prepareCallsCount - 1;
        this.prepareCallsCount = i;
        if (i != 0) {
            return;
        }
        if (this.sessionKeepaliveMs != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.sessions);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ((DefaultDrmSession) arrayList.get(i2)).release(null);
            }
        }
        UnmodifiableIterator it = ImmutableSet.copyOf((Collection) this.preacquiredSessionReferences).iterator();
        while (it.hasNext()) {
            ((PreacquiredSessionReference) it.next()).release();
        }
        maybeReleaseMediaDrm();
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager
    public final void setPlayer(Looper looper, PlayerId playerId) {
        synchronized (this) {
            try {
                Looper looper2 = this.playbackLooper;
                if (looper2 == null) {
                    this.playbackLooper = looper;
                    this.playbackHandler = new Handler(looper);
                } else {
                    UtilsKt.checkState(looper2 == looper);
                    this.playbackHandler.getClass();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.playerId = playerId;
    }

    public final void verifyPlaybackThread(boolean z) {
        if (z && this.playbackLooper == null) {
            Log.w("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed before setPlayer(), possibly on the wrong thread.", new IllegalStateException());
            return;
        }
        Thread threadCurrentThread = Thread.currentThread();
        Looper looper = this.playbackLooper;
        looper.getClass();
        if (threadCurrentThread != looper.getThread()) {
            Log.w("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.playbackLooper.getThread().getName(), new IllegalStateException());
        }
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager
    public final DrmSession acquireSession(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        verifyPlaybackThread(false);
        UtilsKt.checkState(this.prepareCallsCount > 0);
        this.playbackLooper.getClass();
        return acquireSession(this.playbackLooper, eventDispatcher, format, true);
    }
}
