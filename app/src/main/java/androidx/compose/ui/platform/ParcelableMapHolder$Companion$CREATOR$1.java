package androidx.compose.ui.platform;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.MapWrapper;
import androidx.collection.MutableScatterMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ParcelableMapHolder$Companion$CREATOR$1 implements Parcelable.ClassLoaderCreator {
    public static ParcelableMapHolder createFromParcel(Parcel parcel, ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = ParcelableMapHolder.class.getClassLoader();
        }
        int i = parcel.readInt();
        MutableScatterMap mutableScatterMap = new MutableScatterMap(i);
        for (int i2 = 0; i2 < i; i2++) {
            String string = parcel.readString();
            if (string != null) {
                Object value = parcel.readValue(classLoader);
                value.getClass();
                mutableScatterMap.set(string, (List) value);
            }
        }
        return new ParcelableMapHolder(new MapWrapper(mutableScatterMap));
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new ParcelableMapHolder[i];
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
