package androidx.compose.foundation.lazy.layout;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultLazyKey implements Parcelable {
    public static final Parcelable.Creator<DefaultLazyKey> CREATOR = new DefaultLazyKey$Companion$CREATOR$1();
    public final int index;

    public DefaultLazyKey(int i) {
        this.index = i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DefaultLazyKey) && this.index == ((DefaultLazyKey) obj).index;
    }

    public final int hashCode() {
        return Integer.hashCode(this.index);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(this.index, "DefaultLazyKey(index=", ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.index);
    }
}
