package androidx.media3.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IMediaSessionService$Stub$Proxy implements IMediaSessionService {
    public IBinder mRemote;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.mRemote;
    }

    @Override // androidx.media3.session.IMediaSessionService
    public final void connect(IMediaController iMediaController, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaSessionService");
            parcelObtain.writeStrongInterface(iMediaController);
            parcelObtain.writeInt(1);
            bundle.writeToParcel(parcelObtain, 0);
            this.mRemote.transact(3001, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }
}
