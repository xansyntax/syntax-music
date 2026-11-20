package androidx.media3.session.legacy;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.IResultReceiver;
import android.support.v4.os.ResultReceiver;
import com.metrolist.music.db.DatabaseDao_Impl;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaBrowserServiceCompat$2 extends MediaBrowserServiceCompat$Result {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ResultReceiver val$receiver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MediaBrowserServiceCompat$2(Object obj, ResultReceiver resultReceiver, byte b) {
        super(obj);
        this.$r8$classId = b;
        this.val$receiver = resultReceiver;
    }

    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat$Result
    public void onErrorSent() {
        switch (this.$r8$classId) {
            case 2:
                IResultReceiver iResultReceiver = this.val$receiver.mReceiver;
                if (iResultReceiver != null) {
                    try {
                        iResultReceiver.send(-1, null);
                    } catch (RemoteException unused) {
                        return;
                    }
                }
                break;
            default:
                super.onErrorSent();
                break;
        }
    }

    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat$Result
    public final void onResultSent(Object obj) {
        byte b = this.$r8$classId;
        ResultReceiver resultReceiver = this.val$receiver;
        switch (b) {
            case 0:
                Bundle bundle = new Bundle();
                bundle.putParcelable("media_item", DatabaseDao_Impl.AnonymousClass17.convert((MediaBrowserCompat.MediaItem) obj, android.support.v4.media.MediaBrowserCompat$MediaItem.CREATOR));
                IResultReceiver iResultReceiver = resultReceiver.mReceiver;
                if (iResultReceiver != null) {
                    try {
                        iResultReceiver.send(0, bundle);
                    } catch (RemoteException unused) {
                        return;
                    }
                }
                break;
            case 1:
                List list = (List) obj;
                try {
                    if (list == null) {
                        IResultReceiver iResultReceiver2 = resultReceiver.mReceiver;
                        if (iResultReceiver2 != null) {
                            iResultReceiver2.send(-1, null);
                        }
                    } else {
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelableArray("search_results", (Parcelable[]) DatabaseDao_Impl.AnonymousClass17.convertList(list, android.support.v4.media.MediaBrowserCompat$MediaItem.CREATOR).toArray(new android.support.v4.media.MediaBrowserCompat$MediaItem[0]));
                        IResultReceiver iResultReceiver3 = resultReceiver.mReceiver;
                        if (iResultReceiver3 != null) {
                            iResultReceiver3.send(0, bundle2);
                        }
                    }
                } catch (RemoteException unused2) {
                    return;
                }
                break;
            default:
                Bundle bundle3 = (Bundle) obj;
                IResultReceiver iResultReceiver4 = resultReceiver.mReceiver;
                if (iResultReceiver4 != null) {
                    try {
                        iResultReceiver4.send(0, bundle3);
                    } catch (RemoteException unused3) {
                        return;
                    }
                }
                break;
        }
    }
}
