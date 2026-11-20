package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ParcelableSnapshotMutableState$Companion$CREATOR$1 implements Parcelable.ClassLoaderCreator {
    public static ParcelableSnapshotMutableState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        NeverEqualPolicy neverEqualPolicy;
        if (classLoader == null) {
            classLoader = ParcelableSnapshotMutableState$Companion$CREATOR$1.class.getClassLoader();
        }
        Object value = parcel.readValue(classLoader);
        int i = parcel.readInt();
        if (i == 0) {
            neverEqualPolicy = NeverEqualPolicy.INSTANCE;
        } else if (i == 1) {
            neverEqualPolicy = NeverEqualPolicy.INSTANCE$3;
        } else {
            if (i != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2(IntIntPair$$ExternalSyntheticOutline0.m(i, "Unsupported MutableState policy ", " was restored"));
                return null;
            }
            neverEqualPolicy = NeverEqualPolicy.INSTANCE$1;
        }
        return new ParcelableSnapshotMutableState(value, neverEqualPolicy);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new ParcelableSnapshotMutableState[i];
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return createFromParcel(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel, (ClassLoader) null);
    }
}
