package androidx.media3.session.legacy;

import android.media.session.MediaSession;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.FragmentState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionCompat$QueueItem implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$QueueItem> CREATOR = new FragmentState.AnonymousClass1((byte) 21);
    public final MediaDescriptionCompat description;
    public final long id;
    public MediaSession.QueueItem itemFwk;

    public MediaSessionCompat$QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j) {
        if (j == -1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Id cannot be QueueItem.UNKNOWN_ID");
            throw null;
        }
        this.description = mediaDescriptionCompat;
        this.id = j;
        this.itemFwk = queueItem;
    }

    public static ArrayList fromQueueItemList(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MediaSession.QueueItem queueItem = (MediaSession.QueueItem) it.next();
            arrayList.add(new MediaSessionCompat$QueueItem(queueItem, MediaDescriptionCompat.fromMediaDescription(queueItem.getDescription()), queueItem.getQueueId()));
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MediaSession.QueueItem { Description=");
        sb.append(this.description);
        sb.append(", Id=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.id, " }");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        this.description.writeToParcel(parcel, i);
        parcel.writeLong(this.id);
    }

    public MediaSessionCompat$QueueItem(Parcel parcel) {
        this.description = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        this.id = parcel.readLong();
    }
}
