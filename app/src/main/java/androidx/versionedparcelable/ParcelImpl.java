package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new FragmentState.AnonymousClass1((byte) 26);
    public final VersionedParcelable mParcel;

    public ParcelImpl(Parcel parcel) {
        this.mParcel = new VersionedParcelParcel(parcel).readVersionedParcelable();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new VersionedParcelParcel(parcel).writeVersionedParcelable$1(this.mParcel);
    }

    public ParcelImpl(VersionedParcelable versionedParcelable) {
        this.mParcel = versionedParcelable;
    }
}
