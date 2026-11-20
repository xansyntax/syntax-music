package androidx.media3.exoplayer.scheduler;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import androidx.fragment.app.FragmentState;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Requirements implements Parcelable {
    public static final Parcelable.Creator<Requirements> CREATOR = new FragmentState.AnonymousClass1((byte) 17);
    public final int requirements;

    public Requirements(int i) {
        this.requirements = (i & 2) != 0 ? i | 1 : i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Requirements.class == obj.getClass()) {
            if (this.requirements == ((Requirements) obj).requirements) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0040  */
    public final int getNotMetRequirements(Context context) {
        Intent intentRegisterReceiver;
        int intExtra;
        Network activeNetwork;
        int i = this.requirements;
        int i2 = 0;
        if ((i & 1) != 0) {
            Object systemService = context.getSystemService("connectivity");
            systemService.getClass();
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || (activeNetwork = connectivityManager.getActiveNetwork()) == null) {
                i2 = i & 3;
            } else {
                try {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                    if (networkCapabilities == null || !networkCapabilities.hasCapability(16)) {
                        i2 = i & 3;
                    } else if ((i & 2) != 0 && connectivityManager.isActiveNetworkMetered()) {
                        i2 = 2;
                    }
                } catch (SecurityException unused) {
                }
            }
        }
        if ((i & 8) != 0 && ((intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null || ((intExtra = intentRegisterReceiver.getIntExtra("status", -1)) != 2 && intExtra != 5))) {
            i2 |= 8;
        }
        if ((i & 4) != 0) {
            Object systemService2 = context.getSystemService("power");
            systemService2.getClass();
            if (!((PowerManager) systemService2).isDeviceIdleMode()) {
                i2 |= 4;
            }
        }
        return ((i & 16) == 0 || context.registerReceiver(null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) == null) ? i2 : i2 | 16;
    }

    public final int hashCode() {
        return this.requirements;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.requirements);
    }
}
