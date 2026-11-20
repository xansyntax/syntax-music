package okhttp3;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Handler;
import android.util.SparseBooleanArray;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.offline.Download;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.offline.DownloadService;
import androidx.media3.session.MediaLibrarySessionImpl;
import androidx.media3.session.MediaSession$ControllerInfo;
import androidx.media3.session.MediaSession$MediaItemsWithStartPosition;
import androidx.media3.session.MediaSessionLegacyStub;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import coil3.util.UtilsKt;
import com.google.common.util.concurrent.FutureCallback;
import com.metrolist.music.playback.ExoDownloadService;
import com.yalantis.ucrop.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.comparisons.NaturalOrderComparator;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ConnectionSpec {
    public static final ConnectionSpec CLEARTEXT;
    public static final ConnectionSpec MODERN_TLS;
    public final String[] cipherSuitesAsString;
    public final boolean isTls;
    public final boolean supportsTlsExtensions;
    public final String[] tlsVersionsAsString;

    static {
        CipherSuite cipherSuite = CipherSuite.TLS_AES_128_GCM_SHA256;
        CipherSuite cipherSuite2 = CipherSuite.TLS_AES_256_GCM_SHA384;
        CipherSuite cipherSuite3 = CipherSuite.TLS_CHACHA20_POLY1305_SHA256;
        CipherSuite cipherSuite4 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        CipherSuite cipherSuite5 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        CipherSuite cipherSuite6 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        CipherSuite cipherSuite7 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        CipherSuite cipherSuite8 = CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
        CipherSuite cipherSuite9 = CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
        List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new CipherSuite[]{cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9});
        List listListOf2 = CollectionsKt__IterablesKt.listOf((Object[]) new CipherSuite[]{cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA});
        Builder builder = new Builder();
        CipherSuite[] cipherSuiteArr = (CipherSuite[]) listListOf.toArray(new CipherSuite[0]);
        builder.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr, cipherSuiteArr.length));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        builder.tlsVersions(tlsVersion, tlsVersion2);
        builder.supportsTlsExtensions = true;
        builder.build();
        Builder builder2 = new Builder();
        CipherSuite[] cipherSuiteArr2 = (CipherSuite[]) listListOf2.toArray(new CipherSuite[0]);
        builder2.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr2, cipherSuiteArr2.length));
        builder2.tlsVersions(tlsVersion, tlsVersion2);
        builder2.supportsTlsExtensions = true;
        MODERN_TLS = builder2.build();
        Builder builder3 = new Builder();
        CipherSuite[] cipherSuiteArr3 = (CipherSuite[]) listListOf2.toArray(new CipherSuite[0]);
        builder3.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr3, cipherSuiteArr3.length));
        builder3.tlsVersions(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        builder3.supportsTlsExtensions = true;
        builder3.build();
        CLEARTEXT = new ConnectionSpec(false, false, null, null);
    }

    public ConnectionSpec(boolean z, boolean z2, String[] strArr, String[] strArr2) {
        this.isTls = z;
        this.supportsTlsExtensions = z2;
        this.cipherSuitesAsString = strArr;
        this.tlsVersionsAsString = strArr2;
    }

    public final void apply$okhttp(SSLSocket sSLSocket, boolean z) {
        String[] enabledProtocols;
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        enabledCipherSuites.getClass();
        String[] strArr = this.cipherSuitesAsString;
        if (strArr != null) {
            enabledCipherSuites = _UtilCommonKt.intersect(strArr, enabledCipherSuites, CipherSuite.ORDER_BY_NAME);
        }
        String[] strArr2 = this.tlsVersionsAsString;
        if (strArr2 != null) {
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            enabledProtocols2.getClass();
            enabledProtocols = _UtilCommonKt.intersect(enabledProtocols2, strArr2, NaturalOrderComparator.INSTANCE);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        supportedCipherSuites.getClass();
        CipherSuite$Companion$ORDER_BY_NAME$1 cipherSuite$Companion$ORDER_BY_NAME$1 = CipherSuite.ORDER_BY_NAME;
        byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
        int length = supportedCipherSuites.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (cipherSuite$Companion$ORDER_BY_NAME$1.compare(supportedCipherSuites[i], "TLS_FALLBACK_SCSV") == 0) {
                break;
            } else {
                i++;
            }
        }
        if (z && i != -1) {
            String str = supportedCipherSuites[i];
            str.getClass();
            enabledCipherSuites.getClass();
            enabledCipherSuites = (String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
            enabledCipherSuites[enabledCipherSuites.length - 1] = str;
        }
        String[] strArr3 = (String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length);
        boolean z2 = this.isTls;
        if (!z2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("no cipher suites for cleartext connections");
            return;
        }
        if (strArr3.length == 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("At least one cipher suite is required");
            return;
        }
        String[] strArr4 = (String[]) Arrays.copyOf(strArr3, strArr3.length);
        String[] strArr5 = (String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length);
        if (!z2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("no TLS versions for cleartext connections");
            return;
        }
        if (strArr5.length == 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("At least one TLS version is required");
            return;
        }
        ConnectionSpec connectionSpec = new ConnectionSpec(z2, this.supportsTlsExtensions, strArr4, (String[]) Arrays.copyOf(strArr5, strArr5.length));
        if (connectionSpec.tlsVersions() != null) {
            sSLSocket.setEnabledProtocols(connectionSpec.tlsVersionsAsString);
        }
        if (connectionSpec.cipherSuites() != null) {
            sSLSocket.setEnabledCipherSuites(connectionSpec.cipherSuitesAsString);
        }
    }

    public final ArrayList cipherSuites() {
        String[] strArr = this.cipherSuitesAsString;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(CipherSuite.Companion.m1909forJavaName(str));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        boolean z = connectionSpec.isTls;
        boolean z2 = this.isTls;
        if (z2 != z) {
            return false;
        }
        if (z2) {
            return Arrays.equals(this.cipherSuitesAsString, connectionSpec.cipherSuitesAsString) && Arrays.equals(this.tlsVersionsAsString, connectionSpec.tlsVersionsAsString) && this.supportsTlsExtensions == connectionSpec.supportsTlsExtensions;
        }
        return true;
    }

    public final int hashCode() {
        if (!this.isTls) {
            return 17;
        }
        String[] strArr = this.cipherSuitesAsString;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.tlsVersionsAsString;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.supportsTlsExtensions ? 1 : 0);
    }

    public final ArrayList tlsVersions() {
        String[] strArr = this.tlsVersionsAsString;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            TlsVersion.Companion.getClass();
            arrayList.add(Protocol.Companion.forJavaName(str));
        }
        return arrayList;
    }

    public final String toString() {
        if (!this.isTls) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(cipherSuites(), "[all enabled]") + ", tlsVersions=" + Objects.toString(tlsVersions(), "[all enabled]") + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ')';
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    /* JADX INFO: loaded from: classes.dex */
    public final class Builder implements FutureCallback {
        public Object cipherSuites;
        public boolean supportsTlsExtensions;
        public boolean tls = true;
        public Object tlsVersions;

        public ConnectionSpec build() {
            return new ConnectionSpec(this.tls, this.supportsTlsExtensions, (String[]) this.cipherSuites, (String[]) this.tlsVersions);
        }

        public void cipherSuites(CipherSuite... cipherSuiteArr) {
            if (!this.tls) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("no cipher suites for cleartext connections");
                return;
            }
            ArrayList arrayList = new ArrayList(cipherSuiteArr.length);
            for (CipherSuite cipherSuite : cipherSuiteArr) {
                arrayList.add(cipherSuite.javaName);
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
            if (!this.tls) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("no cipher suites for cleartext connections");
            } else if (strArr2.length != 0) {
                this.cipherSuites = (String[]) Arrays.copyOf(strArr2, strArr2.length);
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("At least one cipher suite is required");
            }
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onSuccess(Object obj) {
            final MediaSession$MediaItemsWithStartPosition mediaSession$MediaItemsWithStartPosition = (MediaSession$MediaItemsWithStartPosition) obj;
            MediaLibrarySessionImpl mediaLibrarySessionImpl = ((MediaSessionLegacyStub) this.tlsVersions).sessionImpl;
            Handler handler = mediaLibrarySessionImpl.applicationHandler;
            final MediaSession$ControllerInfo mediaSession$ControllerInfo = (MediaSession$ControllerInfo) this.cipherSuites;
            final boolean z = this.tls;
            final boolean z2 = this.supportsTlsExtensions;
            Util.postOrRun(handler, new TransactionExecutor$$ExternalSyntheticLambda0(mediaLibrarySessionImpl, mediaSession$ControllerInfo, new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MediaLibrarySessionImpl mediaLibrarySessionImpl2 = ((MediaSessionLegacyStub) this.f$0.tlsVersions).sessionImpl;
                    PlayerWrapper playerWrapper = mediaLibrarySessionImpl2.playerWrapper;
                    MediaUtils.setMediaItemsWithStartIndexAndPosition(playerWrapper, mediaSession$MediaItemsWithStartPosition);
                    int playbackState = playerWrapper.getPlaybackState();
                    if (z) {
                        if (playbackState == 1) {
                            if (playerWrapper.isCommandAvailable(2)) {
                                playerWrapper.prepare();
                            }
                        } else if (playbackState == 4 && playerWrapper.isCommandAvailable(4)) {
                            playerWrapper.seekToDefaultPosition();
                        }
                    }
                    boolean z3 = z2;
                    if (z3 && playerWrapper.isCommandAvailable(1)) {
                        playerWrapper.play();
                    }
                    SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
                    for (int i : new int[]{31, 2}) {
                        UtilsKt.checkState(!false);
                        sparseBooleanArray.append(i, true);
                    }
                    if (z3) {
                        UtilsKt.checkState(!false);
                        sparseBooleanArray.append(1, true);
                    }
                    UtilsKt.checkState(!false);
                    mediaLibrarySessionImpl2.onPlayerInteractionFinishedOnHandler(mediaSession$ControllerInfo);
                }
            }));
        }

        public void tlsVersions(TlsVersion... tlsVersionArr) {
            if (!this.tls) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("no TLS versions for cleartext connections");
                return;
            }
            ArrayList arrayList = new ArrayList(tlsVersionArr.length);
            for (TlsVersion tlsVersion : tlsVersionArr) {
                arrayList.add(tlsVersion.javaName);
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
            if (!this.tls) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("no TLS versions for cleartext connections");
            } else if (strArr2.length != 0) {
                this.tlsVersions = (String[]) Arrays.copyOf(strArr2, strArr2.length);
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("At least one TLS version is required");
            }
        }

        public void update() {
            Handler handler = (Handler) this.cipherSuites;
            DownloadService downloadService = (DownloadService) this.tlsVersions;
            DownloadService.DownloadManagerHelper downloadManagerHelper = downloadService.downloadManagerHelper;
            downloadManagerHelper.getClass();
            DownloadManager downloadManager = downloadManagerHelper.downloadManager;
            List list = downloadManager.downloads;
            int i = downloadManager.notMetRequirements;
            ExoDownloadService exoDownloadService = (ExoDownloadService) downloadService;
            list.getClass();
            Notification notificationBuildProgressNotification = exoDownloadService.getDownloadUtil().downloadNotificationHelper.buildProgressNotification(i, exoDownloadService, list.size() == 1 ? Util.fromUtf8Bytes(((Download) list.get(0)).request.data) : exoDownloadService.getResources().getQuantityString(R.plurals.n_song, list.size(), Integer.valueOf(list.size())), list);
            notificationBuildProgressNotification.getClass();
            Notification.Action actionBuild = new Notification.Action.Builder(Icon.createWithResource(exoDownloadService, R.drawable.close), exoDownloadService.getString(android.R.string.cancel), PendingIntent.getService(exoDownloadService, 0, new Intent(exoDownloadService, (Class<?>) ExoDownloadService.class).setAction("REMOVE_ALL_PENDING_DOWNLOADS"), 67108864)).build();
            actionBuild.getClass();
            Notification notificationBuild = Notification.Builder.recoverBuilder(exoDownloadService, notificationBuildProgressNotification).setActions(actionBuild).build();
            notificationBuild.getClass();
            if (this.supportsTlsExtensions) {
                ((NotificationManager) downloadService.getSystemService("notification")).notify(1, notificationBuild);
            } else {
                String str = Util.DEVICE_DEBUG_INFO;
                if (Build.VERSION.SDK_INT >= 29) {
                    Util.Api29.startForeground(downloadService, 1, notificationBuild, 1, "dataSync");
                } else {
                    downloadService.startForeground(1, notificationBuild);
                }
                this.supportsTlsExtensions = true;
            }
            if (this.tls) {
                handler.removeCallbacksAndMessages(null);
                handler.postDelayed(new ActivityCompat$$ExternalSyntheticLambda0((byte) 26, (Object) this), 1000L);
            }
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onFailure(Throwable th) {
        }
    }
}
