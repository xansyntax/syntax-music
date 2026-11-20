package androidx.media3.session.legacy;

import android.os.IBinder;
import android.os.Messenger;
import androidx.collection.ArrayMap;
import androidx.media3.session.MediaLibraryServiceLegacyStub;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaBrowserServiceCompat$ConnectionRecord implements IBinder.DeathRecipient {
    public final MediaSessionManager$RemoteUserInfo browserInfo;
    public final MediaBrowserCompat callbacks;
    public final int pid;
    public final String pkg;
    public final HashMap subscriptions = new HashMap();
    public final /* synthetic */ MediaLibraryServiceLegacyStub this$0;
    public final int uid;

    public MediaBrowserServiceCompat$ConnectionRecord(MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub, String str, int i, int i2, MediaBrowserCompat mediaBrowserCompat) {
        this.this$0 = mediaLibraryServiceLegacyStub;
        this.pkg = str;
        this.pid = i;
        this.uid = i2;
        this.browserInfo = new MediaSessionManager$RemoteUserInfo(str, i, i2);
        this.callbacks = mediaBrowserCompat;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        this.this$0.handler.post(new Runnable() { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat$ConnectionRecord.1
            @Override // java.lang.Runnable
            public final void run() {
                MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = MediaBrowserServiceCompat$ConnectionRecord.this;
                ArrayMap arrayMap = mediaBrowserServiceCompat$ConnectionRecord.this$0.connections;
                MediaBrowserCompat mediaBrowserCompat = mediaBrowserServiceCompat$ConnectionRecord.callbacks;
                mediaBrowserCompat.getClass();
                arrayMap.remove(((Messenger) mediaBrowserCompat.impl).getBinder());
            }
        });
    }
}
