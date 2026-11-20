package androidx.media3.session;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.legacy.MediaBrowserCompat;
import com.metrolist.music.db.DatabaseDao_Impl;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionImpl$MediaPlayPauseKeyHandler extends Handler {
    public final /* synthetic */ byte $r8$classId = 0;
    public Object playPauseTask;
    public Object this$0;

    public MediaSessionImpl$MediaPlayPauseKeyHandler(MediaBrowserCompat.MediaBrowserImplApi26 mediaBrowserImplApi26) {
        this.playPauseTask = new WeakReference(mediaBrowserImplApi26);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (this.$r8$classId) {
            case 1:
                WeakReference weakReference = (WeakReference) this.this$0;
                if (weakReference == null) {
                    return;
                }
                Messenger messenger = (Messenger) weakReference.get();
                MediaBrowserCompat.MediaBrowserImplApi26 mediaBrowserImplApi26 = (MediaBrowserCompat.MediaBrowserImplApi26) ((WeakReference) this.playPauseTask).get();
                if (messenger == null || mediaBrowserImplApi26 == null) {
                    return;
                }
                Bundle data = message.getData();
                if (data != null) {
                    ClassLoader classLoader = CallbackWrapper.class.getClassLoader();
                    classLoader.getClass();
                    data.setClassLoader(classLoader);
                }
                try {
                    if (message.what != 3) {
                        Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                        return;
                    }
                    Util.convertToNullIfInvalid(data.getBundle("data_options"));
                    Util.convertToNullIfInvalid(data.getBundle("data_notify_children_changed_options"));
                    String string = data.getString("data_media_item_id");
                    DatabaseDao_Impl.AnonymousClass17.convertList(data.getParcelableArrayList("data_media_item_list"), MediaBrowserCompat.MediaItem.CREATOR);
                    if (mediaBrowserImplApi26.callbacksMessenger != messenger) {
                        return;
                    }
                    if (string != null && mediaBrowserImplApi26.subscriptions.get(string) != null) {
                        throw new ClassCastException();
                    }
                    Log.d("onLoadChildren for id that isn't subscribed id=" + string);
                    return;
                } catch (BadParcelableException unused) {
                    Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                    return;
                }
            default:
                super.handleMessage(message);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaSessionImpl$MediaPlayPauseKeyHandler(MediaLibrarySessionImpl mediaLibrarySessionImpl, Looper looper) {
        super(looper);
        this.this$0 = mediaLibrarySessionImpl;
    }
}
