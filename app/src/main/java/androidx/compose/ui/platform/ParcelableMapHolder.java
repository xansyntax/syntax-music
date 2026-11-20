package androidx.compose.ui.platform;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ParcelableMapHolder implements Parcelable {
    public static final Parcelable.Creator<ParcelableMapHolder> CREATOR = new ParcelableMapHolder$Companion$CREATOR$1();
    public final Map map;

    public ParcelableMapHolder(Map map) {
        this.map = map;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Map map = this.map;
        parcel.writeInt(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            parcel.writeString(str);
            parcel.writeValue(list);
        }
    }
}
