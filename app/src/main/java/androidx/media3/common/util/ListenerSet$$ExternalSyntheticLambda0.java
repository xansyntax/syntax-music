package androidx.media3.common.util;

import android.os.Handler;
import android.os.Message;
import androidx.compose.ui.node.NodeChain;
import androidx.media3.common.FlagSet;
import androidx.media3.exoplayer.offline.Download;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.session.MediaControllerImplLegacy;
import com.google.common.base.Splitter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ListenerSet$$ExternalSyntheticLambda0 implements Handler.Callback {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ListenerSet$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        byte b = this.$r8$classId;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                ListenerSet listenerSet = (ListenerSet) obj;
                ListenerSet.IterationFinishedEvent iterationFinishedEvent = listenerSet.iterationFinishedEvent;
                iterationFinishedEvent.getClass();
                for (ListenerSet.ListenerHolder listenerHolder : listenerSet.listeners) {
                    if (!listenerHolder.released && listenerHolder.needsIterationFinishedEvent) {
                        FlagSet flagSetBuild = listenerHolder.flagsBuilder.build();
                        listenerHolder.flagsBuilder = new FlagSet.Builder((byte) 0);
                        listenerHolder.needsIterationFinishedEvent = false;
                        iterationFinishedEvent.invoke(listenerHolder.listener, flagSetBuild);
                    }
                    SystemHandlerWrapper systemHandlerWrapper = listenerSet.iterationFinishedHandler;
                    systemHandlerWrapper.getClass();
                    if (systemHandlerWrapper.handler.hasMessages(1)) {
                        return true;
                    }
                }
                return true;
            case 1:
                NodeChain nodeChain = (NodeChain) obj;
                int i = message.what;
                if (i == 1) {
                    ((StuckPlayerDetector$StuckBufferingDetector) nodeChain.current).update();
                } else if (i == 2) {
                    ((StuckPlayerDetector$StuckPlayingDetector) nodeChain.buffers).update();
                } else if (i == 3) {
                    ((StuckPlayerDetector$StuckPlayingNotEndingDetector) nodeChain.stack).update();
                } else {
                    if (i != 4) {
                        return false;
                    }
                    ((StuckPlayerDetector$StuckSuppressedDetector) nodeChain.cachedDiffer).update();
                }
                return true;
            case 2:
                DownloadManager downloadManager = (DownloadManager) obj;
                CopyOnWriteArraySet copyOnWriteArraySet = downloadManager.listeners;
                int i2 = message.what;
                if (i2 == 1) {
                    List list = (List) message.obj;
                    downloadManager.initialized = true;
                    downloadManager.downloads = Collections.unmodifiableList(list);
                    boolean zUpdateWaitingForRequirements = downloadManager.updateWaitingForRequirements();
                    Iterator it = copyOnWriteArraySet.iterator();
                    while (it.hasNext()) {
                        ((DownloadManager.Listener) it.next()).onInitialized(downloadManager);
                    }
                    if (zUpdateWaitingForRequirements) {
                        downloadManager.notifyWaitingForRequirementsChanged();
                    }
                } else if (i2 == 2) {
                    int i3 = message.arg1;
                    int i4 = message.arg2;
                    int i5 = downloadManager.pendingMessages - i3;
                    downloadManager.pendingMessages = i5;
                    downloadManager.activeTaskCount = i4;
                    if (i4 == 0 && i5 == 0) {
                        Iterator it2 = copyOnWriteArraySet.iterator();
                        while (it2.hasNext()) {
                            ((DownloadManager.Listener) it2.next()).onIdle();
                        }
                    }
                } else {
                    if (i2 != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m();
                        return false;
                    }
                    DownloadManager.DownloadUpdate downloadUpdate = (DownloadManager.DownloadUpdate) message.obj;
                    downloadManager.downloads = Collections.unmodifiableList(downloadUpdate.downloads);
                    Download download = downloadUpdate.download;
                    boolean zUpdateWaitingForRequirements2 = downloadManager.updateWaitingForRequirements();
                    if (downloadUpdate.isRemove) {
                        Iterator it3 = copyOnWriteArraySet.iterator();
                        while (it3.hasNext()) {
                            ((DownloadManager.Listener) it3.next()).onDownloadRemoved(downloadManager, download);
                        }
                    } else {
                        Iterator it4 = copyOnWriteArraySet.iterator();
                        while (it4.hasNext()) {
                            ((DownloadManager.Listener) it4.next()).onDownloadChanged(downloadManager, download, downloadUpdate.finalException);
                        }
                    }
                    if (zUpdateWaitingForRequirements2) {
                        downloadManager.notifyWaitingForRequirementsChanged();
                    }
                }
                return true;
            case 3:
                Splitter splitter = (Splitter) obj;
                if (message.what == 1) {
                    splitter.flushCommandQueue();
                }
                return true;
            default:
                MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback = (MediaControllerImplLegacy.ControllerCompatCallback) obj;
                if (message.what == 1) {
                    MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                    mediaControllerImplLegacy.handleNewLegacyParameters(false, mediaControllerImplLegacy.pendingLegacyPlayerInfo);
                }
                return true;
        }
    }
}
