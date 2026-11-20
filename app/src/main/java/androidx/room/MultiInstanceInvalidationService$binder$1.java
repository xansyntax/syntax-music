package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MultiInstanceInvalidationService$binder$1 extends Binder implements IMultiInstanceInvalidationService {
    public final /* synthetic */ MultiInstanceInvalidationService this$0;

    public MultiInstanceInvalidationService$binder$1(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.this$0 = multiInstanceInvalidationService;
        attachInterface(this, IMultiInstanceInvalidationService.DESCRIPTOR);
    }

    @Override // androidx.room.IMultiInstanceInvalidationService
    public final void broadcastInvalidation(String[] strArr, int i) {
        strArr.getClass();
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
        synchronized (multiInstanceInvalidationService.callbackList) {
            String str = (String) multiInstanceInvalidationService.clientNames.get(Integer.valueOf(i));
            if (str == null) {
                Log.w("ROOM", "Remote invalidation client ID not registered");
                return;
            }
            int iBeginBroadcast = multiInstanceInvalidationService.callbackList.beginBroadcast();
            int i2 = 0;
            while (true) {
                MultiInstanceInvalidationService$callbackList$1 multiInstanceInvalidationService$callbackList$1 = multiInstanceInvalidationService.callbackList;
                if (i2 >= iBeginBroadcast) {
                    multiInstanceInvalidationService$callbackList$1.finishBroadcast();
                    return;
                }
                try {
                    Object broadcastCookie = multiInstanceInvalidationService$callbackList$1.getBroadcastCookie(i2);
                    broadcastCookie.getClass();
                    Integer num = (Integer) broadcastCookie;
                    int iIntValue = num.intValue();
                    String str2 = (String) multiInstanceInvalidationService.clientNames.get(num);
                    if (i != iIntValue && str.equals(str2)) {
                        try {
                            ((IMultiInstanceInvalidationCallback) multiInstanceInvalidationService.callbackList.getBroadcastItem(i2)).onInvalidation(strArr);
                        } catch (RemoteException e) {
                            Log.w("ROOM", "Error invoking a remote callback", e);
                        }
                    }
                    i2++;
                } catch (Throwable th) {
                    multiInstanceInvalidationService.callbackList.finishBroadcast();
                    throw th;
                }
            }
        }
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        String str = IMultiInstanceInvalidationService.DESCRIPTOR;
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback = null;
        IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback2 = null;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                broadcastInvalidation(parcel.createStringArray(), parcel.readInt());
                return true;
            }
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(IMultiInstanceInvalidationCallback.DESCRIPTOR);
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMultiInstanceInvalidationCallback)) {
                    IMultiInstanceInvalidationCallback$Stub$Proxy iMultiInstanceInvalidationCallback$Stub$Proxy = new IMultiInstanceInvalidationCallback$Stub$Proxy();
                    iMultiInstanceInvalidationCallback$Stub$Proxy.mRemote = strongBinder;
                    iMultiInstanceInvalidationCallback2 = iMultiInstanceInvalidationCallback$Stub$Proxy;
                } else {
                    iMultiInstanceInvalidationCallback2 = (IMultiInstanceInvalidationCallback) iInterfaceQueryLocalInterface;
                }
            }
            int i3 = parcel.readInt();
            iMultiInstanceInvalidationCallback2.getClass();
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            synchronized (multiInstanceInvalidationService.callbackList) {
                multiInstanceInvalidationService.callbackList.unregister(iMultiInstanceInvalidationCallback2);
            }
            parcel2.writeNoException();
            return true;
        }
        IBinder strongBinder2 = parcel.readStrongBinder();
        if (strongBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface(IMultiInstanceInvalidationCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof IMultiInstanceInvalidationCallback)) {
                IMultiInstanceInvalidationCallback$Stub$Proxy iMultiInstanceInvalidationCallback$Stub$Proxy2 = new IMultiInstanceInvalidationCallback$Stub$Proxy();
                iMultiInstanceInvalidationCallback$Stub$Proxy2.mRemote = strongBinder2;
                iMultiInstanceInvalidationCallback = iMultiInstanceInvalidationCallback$Stub$Proxy2;
            } else {
                iMultiInstanceInvalidationCallback = (IMultiInstanceInvalidationCallback) iInterfaceQueryLocalInterface2;
            }
        }
        String string = parcel.readString();
        iMultiInstanceInvalidationCallback.getClass();
        int i4 = 0;
        if (string != null) {
            MultiInstanceInvalidationService multiInstanceInvalidationService2 = this.this$0;
            synchronized (multiInstanceInvalidationService2.callbackList) {
                try {
                    int i5 = multiInstanceInvalidationService2.maxClientId + 1;
                    multiInstanceInvalidationService2.maxClientId = i5;
                    if (multiInstanceInvalidationService2.callbackList.register(iMultiInstanceInvalidationCallback, Integer.valueOf(i5))) {
                        multiInstanceInvalidationService2.clientNames.put(Integer.valueOf(i5), string);
                        i4 = i5;
                    } else {
                        multiInstanceInvalidationService2.maxClientId--;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        parcel2.writeNoException();
        parcel2.writeInt(i4);
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
