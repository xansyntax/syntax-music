package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new FragmentState.AnonymousClass1(5);
    public IResultReceiver mReceiver;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            try {
                IResultReceiver myResultReceiver = this.mReceiver;
                if (myResultReceiver == null) {
                    myResultReceiver = new MyResultReceiver();
                    this.mReceiver = myResultReceiver;
                }
                parcel.writeStrongBinder(myResultReceiver.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MyResultReceiver extends Binder implements IResultReceiver {
        public static final /* synthetic */ int $r8$clinit = 0;

        public MyResultReceiver() {
            attachInterface(this, IResultReceiver.DESCRIPTOR);
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String str = IResultReceiver.DESCRIPTOR;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            send(parcel.readInt(), (Bundle) parcel.readTypedObject(Bundle.CREATOR));
            return true;
        }

        @Override // android.support.v4.os.IResultReceiver
        public final void send(int i, Bundle bundle) {
            ResultReceiver.this.onReceiveResult(i, bundle);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }
    }

    public void onReceiveResult(int i, Bundle bundle) {
    }
}
