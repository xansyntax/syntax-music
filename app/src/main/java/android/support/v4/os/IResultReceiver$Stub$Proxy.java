package android.support.v4.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IResultReceiver$Stub$Proxy implements IResultReceiver {
    public IBinder mRemote;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.mRemote;
    }

    @Override // android.support.v4.os.IResultReceiver
    public final void send(int i, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(IResultReceiver.DESCRIPTOR);
            parcelObtain.writeInt(i);
            parcelObtain.writeTypedObject(bundle, 0);
            this.mRemote.transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }
}
