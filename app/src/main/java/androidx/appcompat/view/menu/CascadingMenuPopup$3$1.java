package androidx.appcompat.view.menu;

import android.animation.ValueAnimator;
import android.os.IBinder;
import android.os.Messenger;
import android.support.v4.os.ResultReceiver;
import android.view.View;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.platform.WeakCache;
import androidx.core.util.Pair;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.util.Log;
import androidx.media3.session.MediaLibraryServiceLegacyStub;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaBrowserServiceCompat$2;
import androidx.media3.session.legacy.MediaBrowserServiceCompat$ConnectionRecord;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CascadingMenuPopup$3$1 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object this$1;
    public final /* synthetic */ Object val$item;
    public final /* synthetic */ Object val$menu;
    public final /* synthetic */ Object val$nextInfo;

    public CascadingMenuPopup$3$1(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WeakCache weakCache, ValueAnimator valueAnimator) {
        this.$r8$classId = (byte) 1;
        this.val$nextInfo = view;
        this.val$item = windowInsetsAnimationCompat;
        this.val$menu = weakCache;
        this.this$1 = valueAnimator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b;
        byte b2 = this.$r8$classId;
        byte b3 = 0;
        Object obj = this.val$menu;
        Object obj2 = this.this$1;
        Object obj3 = this.val$nextInfo;
        Object obj4 = this.val$item;
        switch (b2) {
            case 0:
                CascadingMenuPopup cascadingMenuPopup = (CascadingMenuPopup) ((DrawResult) obj2).block;
                MenuItemImpl menuItemImpl = (MenuItemImpl) obj4;
                CascadingMenuPopup.CascadingMenuInfo cascadingMenuInfo = (CascadingMenuPopup.CascadingMenuInfo) obj3;
                if (cascadingMenuInfo != null) {
                    cascadingMenuPopup.mShouldCloseImmediately = true;
                    cascadingMenuInfo.menu.close(false);
                    cascadingMenuPopup.mShouldCloseImmediately = false;
                }
                if (menuItemImpl.isEnabled() && menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) obj).performItemAction(menuItemImpl, null, 4);
                    return;
                }
                return;
            case 1:
                WindowInsetsAnimationCompat.Impl21.dispatchOnStart((View) obj3, (WindowInsetsAnimationCompat) obj4, (WeakCache) obj);
                ((ValueAnimator) obj2).start();
                return;
            case 2:
                String str = (String) obj4;
                MediaBrowserCompat mediaBrowserCompat = (MediaBrowserCompat) obj2;
                MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = (MediaBrowserServiceCompat$ConnectionRecord) ((MediaLibraryServiceLegacyStub) mediaBrowserCompat.impl).connections.get(((Messenger) ((MediaBrowserCompat) obj3).impl).getBinder());
                if (mediaBrowserServiceCompat$ConnectionRecord == null) {
                    Format$$ExternalSyntheticOutline0.m("removeSubscription for callback that isn't registered id=", str, "MBServiceCompat");
                    return;
                }
                HashMap map = mediaBrowserServiceCompat$ConnectionRecord.subscriptions;
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = (MediaLibraryServiceLegacyStub) mediaBrowserCompat.impl;
                IBinder iBinder = (IBinder) obj;
                try {
                    if (iBinder == null) {
                        b = map.remove(str) == null ? (byte) 0 : (byte) 1;
                        mediaLibraryServiceLegacyStub.curConnection = mediaBrowserServiceCompat$ConnectionRecord;
                        mediaLibraryServiceLegacyStub.onUnsubscribe(str);
                        mediaLibraryServiceLegacyStub.curConnection = null;
                    } else {
                        List list = (List) map.get(str);
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                if (iBinder == ((Pair) it.next()).first) {
                                    it.remove();
                                    b3 = 1;
                                }
                            }
                            if (list.isEmpty()) {
                                map.remove(str);
                            }
                        }
                        mediaLibraryServiceLegacyStub.curConnection = mediaBrowserServiceCompat$ConnectionRecord;
                        mediaLibraryServiceLegacyStub.onUnsubscribe(str);
                        mediaLibraryServiceLegacyStub.curConnection = null;
                        b = b3;
                    }
                    if (b == 0) {
                        Log.w("MBServiceCompat", "removeSubscription called for " + str + " which is not subscribed");
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    mediaLibraryServiceLegacyStub.curConnection = mediaBrowserServiceCompat$ConnectionRecord;
                    mediaLibraryServiceLegacyStub.onUnsubscribe(str);
                    mediaLibraryServiceLegacyStub.curConnection = null;
                    throw th;
                }
            default:
                String str2 = (String) obj4;
                MediaBrowserCompat mediaBrowserCompat2 = (MediaBrowserCompat) obj2;
                MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord2 = (MediaBrowserServiceCompat$ConnectionRecord) ((MediaLibraryServiceLegacyStub) mediaBrowserCompat2.impl).connections.get(((Messenger) ((MediaBrowserCompat) obj3).impl).getBinder());
                if (mediaBrowserServiceCompat$ConnectionRecord2 == null) {
                    Format$$ExternalSyntheticOutline0.m("getMediaItem for callback that isn't registered id=", str2, "MBServiceCompat");
                    return;
                }
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub2 = (MediaLibraryServiceLegacyStub) mediaBrowserCompat2.impl;
                MediaBrowserServiceCompat$2 mediaBrowserServiceCompat$2 = new MediaBrowserServiceCompat$2(str2, (ResultReceiver) obj, b3);
                mediaLibraryServiceLegacyStub2.curConnection = mediaBrowserServiceCompat$ConnectionRecord2;
                mediaLibraryServiceLegacyStub2.onLoadItem(str2, mediaBrowserServiceCompat$2);
                mediaLibraryServiceLegacyStub2.curConnection = null;
                if (mediaBrowserServiceCompat$2.isDone()) {
                    return;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2(Fragment$5$$ExternalSyntheticOutline0.m("onLoadItem must call detach() or sendResult() before returning for id=", str2));
                return;
        }
    }

    public /* synthetic */ CascadingMenuPopup$3$1(Object obj, Object obj2, Object obj3, Object obj4, byte b) {
        this.$r8$classId = b;
        this.this$1 = obj;
        this.val$nextInfo = obj2;
        this.val$item = obj3;
        this.val$menu = obj4;
    }
}
