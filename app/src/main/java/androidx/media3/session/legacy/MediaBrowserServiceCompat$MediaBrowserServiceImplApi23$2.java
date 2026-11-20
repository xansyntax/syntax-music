package androidx.media3.session.legacy;

import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import coil3.ImageLoader$Builder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$2 extends MediaBrowserServiceCompat$Result {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaBrowserCompat val$resultWrapper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$2(ImageLoader$Builder imageLoader$Builder, String str, MediaBrowserCompat mediaBrowserCompat, Bundle bundle) {
        super(str);
        this.$r8$classId = (byte) 2;
        this.val$resultWrapper = mediaBrowserCompat;
    }

    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat$Result
    public final void detach() {
        byte b = this.$r8$classId;
        MediaBrowserCompat mediaBrowserCompat = this.val$resultWrapper;
        switch (b) {
            case 0:
                ((MediaBrowserService.Result) mediaBrowserCompat.impl).detach();
                break;
            case 1:
                ((MediaBrowserService.Result) mediaBrowserCompat.impl).detach();
                break;
            default:
                ((MediaBrowserService.Result) mediaBrowserCompat.impl).detach();
                break;
        }
    }

    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat$Result
    public final void onResultSent(Object obj) {
        byte b = this.$r8$classId;
        ArrayList arrayList = null;
        MediaBrowserCompat mediaBrowserCompat = this.val$resultWrapper;
        switch (b) {
            case 0:
                List<MediaBrowserCompat.MediaItem> list = (List) obj;
                if (list != null) {
                    arrayList = new ArrayList(list.size());
                    for (MediaBrowserCompat.MediaItem mediaItem : list) {
                        Parcel parcelObtain = Parcel.obtain();
                        mediaItem.writeToParcel(parcelObtain, 0);
                        arrayList.add(parcelObtain);
                    }
                }
                mediaBrowserCompat.sendResult(arrayList);
                break;
            case 1:
                MediaBrowserCompat.MediaItem mediaItem2 = (MediaBrowserCompat.MediaItem) obj;
                if (mediaItem2 == null) {
                    mediaBrowserCompat.sendResult(null);
                } else {
                    Parcel parcelObtain2 = Parcel.obtain();
                    mediaItem2.writeToParcel(parcelObtain2, 0);
                    mediaBrowserCompat.sendResult(parcelObtain2);
                }
                break;
            default:
                List<MediaBrowserCompat.MediaItem> list2 = (List) obj;
                if (list2 == null) {
                    mediaBrowserCompat.sendResult(null);
                } else {
                    ArrayList arrayList2 = new ArrayList(list2.size());
                    for (MediaBrowserCompat.MediaItem mediaItem3 : list2) {
                        Parcel parcelObtain3 = Parcel.obtain();
                        mediaItem3.writeToParcel(parcelObtain3, 0);
                        arrayList2.add(parcelObtain3);
                    }
                    mediaBrowserCompat.sendResult(arrayList2);
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$2(String str, MediaBrowserCompat mediaBrowserCompat, byte b) {
        super(str);
        this.$r8$classId = b;
        this.val$resultWrapper = mediaBrowserCompat;
    }
}
