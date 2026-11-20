package androidx.media3.session.legacy;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import androidx.activity.EdgeToEdge$$ExternalSyntheticLambda0;
import androidx.collection.ArrayMap;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaLibraryServiceLegacyStub;
import androidx.media3.session.MediaSession$ControllerInfo;
import androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda3;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaBrowserServiceCompat$ServiceBinderImpl$6 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaBrowserCompat this$1;
    public final /* synthetic */ MediaBrowserCompat val$callbacks;
    public final /* synthetic */ Bundle val$extras;
    public final /* synthetic */ String val$query;
    public final /* synthetic */ Object val$receiver;

    public MediaBrowserServiceCompat$ServiceBinderImpl$6(MediaBrowserCompat mediaBrowserCompat, MediaBrowserCompat mediaBrowserCompat2, String str, IBinder iBinder, Bundle bundle) {
        this.$r8$classId = (byte) 2;
        this.this$1 = mediaBrowserCompat;
        this.val$callbacks = mediaBrowserCompat2;
        this.val$query = str;
        this.val$receiver = iBinder;
        this.val$extras = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        Object obj = this.val$receiver;
        String str = this.val$query;
        MediaBrowserCompat mediaBrowserCompat = this.this$1;
        MediaBrowserCompat mediaBrowserCompat2 = this.val$callbacks;
        switch (b) {
            case 0:
                MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = (MediaBrowserServiceCompat$ConnectionRecord) ((MediaLibraryServiceLegacyStub) mediaBrowserCompat.impl).connections.get(((Messenger) mediaBrowserCompat2.impl).getBinder());
                if (mediaBrowserServiceCompat$ConnectionRecord == null) {
                    Log.w("MBServiceCompat", "search for callback that isn't registered query=" + str);
                    return;
                }
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = (MediaLibraryServiceLegacyStub) mediaBrowserCompat.impl;
                String str2 = this.val$query;
                MediaBrowserServiceCompat$2 mediaBrowserServiceCompat$2 = new MediaBrowserServiceCompat$2(str2, (ResultReceiver) obj, (byte) 1);
                mediaLibraryServiceLegacyStub.curConnection = mediaBrowserServiceCompat$ConnectionRecord;
                MediaSession$ControllerInfo currentController = mediaLibraryServiceLegacyStub.getCurrentController();
                if (currentController == null) {
                    mediaBrowserServiceCompat$2.sendResult(null);
                } else if (TextUtils.isEmpty(str2)) {
                    Log.w("MLSLegacyStub", "Ignoring empty query from " + currentController);
                    mediaBrowserServiceCompat$2.sendResult(null);
                } else if (currentController.controllerCb instanceof MediaLibraryServiceLegacyStub.BrowserLegacyCb) {
                    mediaBrowserServiceCompat$2.detach();
                    Util.postOrRun(mediaLibraryServiceLegacyStub.librarySessionImpl.applicationHandler, new EdgeToEdge$$ExternalSyntheticLambda0(mediaLibraryServiceLegacyStub, currentController, mediaBrowserServiceCompat$2, str2, this.val$extras, (byte) 5));
                }
                mediaLibraryServiceLegacyStub.curConnection = null;
                if (mediaBrowserServiceCompat$2.isDone()) {
                    return;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2(Fragment$5$$ExternalSyntheticOutline0.m("onSearch must call detach() or sendResult() before returning for query=", str2));
                return;
            case 1:
                MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord2 = (MediaBrowserServiceCompat$ConnectionRecord) ((MediaLibraryServiceLegacyStub) mediaBrowserCompat.impl).connections.get(((Messenger) mediaBrowserCompat2.impl).getBinder());
                Bundle bundle = this.val$extras;
                if (mediaBrowserServiceCompat$ConnectionRecord2 == null) {
                    Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + str + ", extras=" + bundle);
                    return;
                }
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub2 = (MediaLibraryServiceLegacyStub) mediaBrowserCompat.impl;
                String str3 = this.val$query;
                MediaBrowserServiceCompat$2 mediaBrowserServiceCompat$3 = new MediaBrowserServiceCompat$2(str3, (ResultReceiver) obj, (byte) 2);
                mediaLibraryServiceLegacyStub2.curConnection = mediaBrowserServiceCompat$ConnectionRecord2;
                Bundle bundle2 = bundle == null ? Bundle.EMPTY : bundle;
                MediaSession$ControllerInfo currentController2 = mediaLibraryServiceLegacyStub2.getCurrentController();
                if (currentController2 == null) {
                    mediaBrowserServiceCompat$3.sendError();
                } else {
                    mediaBrowserServiceCompat$3.detach();
                    Util.postOrRun(mediaLibraryServiceLegacyStub2.librarySessionImpl.applicationHandler, new EdgeToEdge$$ExternalSyntheticLambda0(mediaLibraryServiceLegacyStub2, str3, currentController2, mediaBrowserServiceCompat$3, bundle2, (byte) 3));
                }
                mediaLibraryServiceLegacyStub2.curConnection = null;
                if (mediaBrowserServiceCompat$3.isDone()) {
                    return;
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1("onCustomAction must call detach() or sendResult() or sendError() before returning for action=", str3, " extras=", bundle);
                return;
            default:
                final MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord3 = (MediaBrowserServiceCompat$ConnectionRecord) ((MediaLibraryServiceLegacyStub) mediaBrowserCompat.impl).connections.get(((Messenger) mediaBrowserCompat2.impl).getBinder());
                if (mediaBrowserServiceCompat$ConnectionRecord3 == null) {
                    Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + str);
                    return;
                }
                HashMap map = mediaBrowserServiceCompat$ConnectionRecord3.subscriptions;
                final MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub3 = (MediaLibraryServiceLegacyStub) mediaBrowserCompat.impl;
                IBinder iBinder = (IBinder) obj;
                final String str4 = this.val$query;
                List arrayList = (List) map.get(str4);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    final Bundle bundle3 = this.val$extras;
                    if (!zHasNext) {
                        arrayList.add(new Pair(iBinder, bundle3));
                        map.put(str4, arrayList);
                        MediaBrowserServiceCompat$Result mediaBrowserServiceCompat$Result = new MediaBrowserServiceCompat$Result(str4) { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat$1
                            @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat$Result
                            public final void onResultSent(Object obj2) {
                                List list = (List) obj2;
                                ArrayMap arrayMap = mediaLibraryServiceLegacyStub3.connections;
                                MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord4 = mediaBrowserServiceCompat$ConnectionRecord3;
                                MediaBrowserCompat mediaBrowserCompat3 = mediaBrowserServiceCompat$ConnectionRecord4.callbacks;
                                String str5 = mediaBrowserServiceCompat$ConnectionRecord4.pkg;
                                mediaBrowserCompat3.getClass();
                                Object obj3 = arrayMap.get(((Messenger) mediaBrowserCompat3.impl).getBinder());
                                String str6 = str4;
                                if (obj3 != mediaBrowserServiceCompat$ConnectionRecord4) {
                                    Log.d("Not sending onLoadChildren result for connection that has been disconnected. pkg=" + str5 + " id=" + str6);
                                    return;
                                }
                                try {
                                    mediaBrowserCompat3.onLoadChildren(bundle3, str6, list);
                                } catch (RemoteException unused) {
                                    Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + str6 + " package=" + str5);
                                }
                            }
                        };
                        mediaLibraryServiceLegacyStub3.curConnection = mediaBrowserServiceCompat$ConnectionRecord3;
                        if (bundle3 == null) {
                            mediaLibraryServiceLegacyStub3.onLoadChildren(str4, mediaBrowserServiceCompat$Result, null);
                        } else {
                            mediaLibraryServiceLegacyStub3.onLoadChildren(str4, mediaBrowserServiceCompat$Result, bundle3);
                        }
                        mediaLibraryServiceLegacyStub3.curConnection = null;
                        if (!mediaBrowserServiceCompat$Result.isDone()) {
                            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + mediaBrowserServiceCompat$ConnectionRecord3.pkg + " id=" + str4);
                        }
                        mediaLibraryServiceLegacyStub3.curConnection = mediaBrowserServiceCompat$ConnectionRecord3;
                        MediaSession$ControllerInfo currentController3 = mediaLibraryServiceLegacyStub3.getCurrentController();
                        if (currentController3 != null) {
                            if (TextUtils.isEmpty(str4)) {
                                Log.w("MLSLegacyStub", "onSubscribe(): Ignoring empty id from " + currentController3);
                            } else {
                                Util.postOrRun(mediaLibraryServiceLegacyStub3.librarySessionImpl.applicationHandler, new MediaSessionStub$$ExternalSyntheticLambda3((Object) mediaLibraryServiceLegacyStub3, (Object) currentController3, (Object) bundle3, (Object) str4, (byte) 3));
                            }
                        }
                        mediaLibraryServiceLegacyStub3.curConnection = null;
                        return;
                    }
                    Pair pair = (Pair) it.next();
                    if (iBinder == pair.first) {
                        Bundle bundle4 = (Bundle) pair.second;
                        if (bundle3 == bundle4) {
                            return;
                        }
                        if (bundle3 == null) {
                            bundle4.getClass();
                            if (bundle4.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle4.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1) {
                                return;
                            }
                        } else if (bundle4 == null) {
                            if (bundle3.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle3.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1) {
                                return;
                            }
                        } else if (bundle3.getInt("android.media.browse.extra.PAGE", -1) == bundle4.getInt("android.media.browse.extra.PAGE", -1) && bundle3.getInt("android.media.browse.extra.PAGE_SIZE", -1) == bundle4.getInt("android.media.browse.extra.PAGE_SIZE", -1)) {
                            return;
                        }
                    }
                }
                break;
        }
    }

    public /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl$6(MediaBrowserCompat mediaBrowserCompat, MediaBrowserCompat mediaBrowserCompat2, String str, Bundle bundle, ResultReceiver resultReceiver, byte b) {
        this.$r8$classId = b;
        this.this$1 = mediaBrowserCompat;
        this.val$callbacks = mediaBrowserCompat2;
        this.val$query = str;
        this.val$extras = bundle;
        this.val$receiver = resultReceiver;
    }
}
