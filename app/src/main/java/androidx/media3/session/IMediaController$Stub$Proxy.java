package androidx.media3.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import coil3.util.FileSystemsKt;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IMediaController$Stub$Proxy implements IMediaController {
    public IBinder mRemote;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.mRemote;
    }

    @Override // androidx.media3.session.IMediaController
    public final void onAvailableCommandsChangedFromPlayer(int i, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            FileSystemsKt.writeTypedObject(parcelObtain, bundle);
            this.mRemote.transact(3009, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onConnected(int i, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            FileSystemsKt.writeTypedObject(parcelObtain, bundle);
            this.mRemote.transact(3001, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onCustomCommand(int i, Bundle bundle, Bundle bundle2) {
        Bundle bundle3 = Bundle.EMPTY;
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            FileSystemsKt.writeTypedObject(parcelObtain, bundle);
            FileSystemsKt.writeTypedObject(parcelObtain, bundle3);
            this.mRemote.transact(3005, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onDisconnected() {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(0);
            this.mRemote.transact(3006, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onLibraryResult(int i, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            FileSystemsKt.writeTypedObject(parcelObtain, bundle);
            this.mRemote.transact(3003, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onPeriodicSessionPositionInfoChanged(int i, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            FileSystemsKt.writeTypedObject(parcelObtain, bundle);
            this.mRemote.transact(3008, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onPlayerInfoChanged(int i, Bundle bundle, boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            FileSystemsKt.writeTypedObject(parcelObtain, bundle);
            parcelObtain.writeInt(z ? 1 : 0);
            this.mRemote.transact(3007, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onPlayerInfoChangedWithExclusions(int i, Bundle bundle, Bundle bundle2) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            FileSystemsKt.writeTypedObject(parcelObtain, bundle);
            FileSystemsKt.writeTypedObject(parcelObtain, bundle2);
            this.mRemote.transact(3013, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onRenderedFirstFrame(int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            this.mRemote.transact(3011, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onSearchResultChanged(int i, int i2, Bundle bundle, String str) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str);
            parcelObtain.writeInt(1);
            FileSystemsKt.writeTypedObject(parcelObtain, bundle);
            this.mRemote.transact(4002, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onSessionResult(int i, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            FileSystemsKt.writeTypedObject(parcelObtain, bundle);
            this.mRemote.transact(3002, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onSetCustomLayout(int i, List list) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            if (list == null) {
                parcelObtain.writeInt(-1);
            } else {
                int i2 = ((RegularImmutableList) list).size;
                parcelObtain.writeInt(i2);
                for (int i3 = 0; i3 < i2; i3++) {
                    FileSystemsKt.writeTypedObject(parcelObtain, (Parcelable) ((RegularImmutableList) list).get(i3));
                }
            }
            this.mRemote.transact(3004, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // androidx.media3.session.IMediaController
    public final void onSurfaceSizeChanged(int i, int i2, int i3) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i3);
            this.mRemote.transact(3018, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }
}
