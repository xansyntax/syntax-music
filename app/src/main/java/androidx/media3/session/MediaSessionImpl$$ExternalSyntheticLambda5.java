package androidx.media3.session;

import com.google.common.collect.CompactHashSet;
import com.google.common.collect.HashMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionImpl$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaLibrarySessionImpl f$0;
    public final /* synthetic */ MediaSession$ControllerInfo f$1;

    public /* synthetic */ MediaSessionImpl$$ExternalSyntheticLambda5(MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSession$ControllerInfo mediaSession$ControllerInfo, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaLibrarySessionImpl;
        this.f$1 = mediaSession$ControllerInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Set setUnmodifiableSet;
        byte b = 12;
        switch (this.$r8$classId) {
            case 0:
                this.f$0.sessionStub.queueSessionTaskWithPlayerCommandForControllerInfo(this.f$1, Integer.MIN_VALUE, 1, MediaSessionStub.sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8(b)));
                return;
            case 1:
                MediaLibrarySessionImpl mediaLibrarySessionImpl = this.f$0;
                MediaSession$ControllerInfo mediaSession$ControllerInfo = this.f$1;
                if (mediaLibrarySessionImpl.isReleased()) {
                    return;
                }
                MediaSession$ControllerCb mediaSession$ControllerCb = mediaSession$ControllerInfo.controllerCb;
                mediaSession$ControllerCb.getClass();
                synchronized (mediaLibrarySessionImpl) {
                    try {
                        HashMultimap hashMultimap = mediaLibrarySessionImpl.controllerToSubscribedParentIds;
                        Collection collection = (Collection) hashMultimap.map.remove(mediaSession$ControllerCb);
                        if (collection == null) {
                            setUnmodifiableSet = Collections.EMPTY_SET;
                        } else {
                            CompactHashSet compactHashSetCreateWithExpectedSize = CompactHashSet.createWithExpectedSize(hashMultimap.expectedValuesPerKey);
                            compactHashSetCreateWithExpectedSize.addAll(collection);
                            hashMultimap.totalSize -= collection.size();
                            collection.clear();
                            setUnmodifiableSet = Collections.unmodifiableSet(compactHashSetCreateWithExpectedSize);
                        }
                        Iterator it = setUnmodifiableSet.iterator();
                        while (it.hasNext()) {
                            mediaLibrarySessionImpl.parentIdToSubscribedControllers.remove((String) it.next(), mediaSession$ControllerInfo);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                if (mediaLibrarySessionImpl.isMediaNotificationControllerConnected) {
                    if (MediaLibrarySessionImpl.isSystemUiController(mediaSession$ControllerInfo)) {
                        return;
                    }
                    if (mediaLibrarySessionImpl.isMediaNotificationController(mediaSession$ControllerInfo)) {
                        mediaLibrarySessionImpl.isMediaNotificationControllerConnected = false;
                    }
                }
                mediaLibrarySessionImpl.callback$1.getClass();
                return;
            case 2:
                this.f$0.sessionStub.queueSessionTaskWithPlayerCommandForControllerInfo(this.f$1, Integer.MIN_VALUE, 7, MediaSessionStub.sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 16)));
                return;
            case 3:
                this.f$0.sessionStub.queueSessionTaskWithPlayerCommandForControllerInfo(this.f$1, Integer.MIN_VALUE, 12, MediaSessionStub.sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 18)));
                return;
            case 4:
                this.f$0.sessionStub.queueSessionTaskWithPlayerCommandForControllerInfo(this.f$1, Integer.MIN_VALUE, 11, MediaSessionStub.sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 15)));
                return;
            case 5:
                this.f$0.sessionStub.queueSessionTaskWithPlayerCommandForControllerInfo(this.f$1, Integer.MIN_VALUE, 3, MediaSessionStub.sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 24)));
                return;
            case 6:
                this.f$0.sessionStub.playForControllerInfo(this.f$1, Integer.MIN_VALUE);
                return;
            case 7:
                this.f$0.sessionStub.playForControllerInfo(this.f$1, Integer.MIN_VALUE);
                return;
            case 8:
                this.f$0.sessionStub.queueSessionTaskWithPlayerCommandForControllerInfo(this.f$1, Integer.MIN_VALUE, 1, MediaSessionStub.sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8(b)));
                return;
            default:
                this.f$0.sessionStub.queueSessionTaskWithPlayerCommandForControllerInfo(this.f$1, Integer.MIN_VALUE, 9, MediaSessionStub.sendSessionResultSuccess(new MediaSessionStub$$ExternalSyntheticLambda8((byte) 19)));
                return;
        }
    }
}
