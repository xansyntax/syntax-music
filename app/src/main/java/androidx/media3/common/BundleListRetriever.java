package androidx.media3.common;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BundleListRetriever extends Binder {
    public final ImmutableList list;

    public BundleListRetriever(List list) {
        this.list = ImmutableList.copyOf((Collection) list);
    }

    public static ImmutableList getList(IBinder iBinder) {
        int i;
        if (iBinder instanceof BundleListRetriever) {
            return ((BundleListRetriever) iBinder).list;
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        int i2 = 0;
        int i3 = 1;
        while (i3 != 0) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInt(i2);
                try {
                    iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    while (true) {
                        i = parcelObtain2.readInt();
                        if (i == 1) {
                            Bundle bundle = parcelObtain2.readBundle();
                            bundle.getClass();
                            builder.add((Object) bundle);
                            i2++;
                        }
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    i3 = i;
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }
        return builder.build();
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        if (parcel2 == null) {
            return false;
        }
        ImmutableList immutableList = this.list;
        int size = immutableList.size();
        int i3 = parcel.readInt();
        while (i3 < size && parcel2.dataSize() < C.SUGGESTED_MAX_IPC_SIZE) {
            parcel2.writeInt(1);
            parcel2.writeBundle((Bundle) immutableList.get(i3));
            i3++;
        }
        parcel2.writeInt(i3 < size ? 2 : 0);
        return true;
    }
}
