package androidx.media3.exoplayer.scheduler;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.offline.DownloadManager;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RequirementsWatcher {
    public final Context context;
    public final Handler handler = Util.createHandlerForCurrentOrMainLooper(null);
    public final OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 listener;
    public NetworkCallback networkCallback;
    public int notMetRequirements;
    public NetworkTypeObserver.Receiver receiver;
    public final Requirements requirements;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class NetworkCallback extends ConnectivityManager.NetworkCallback {
        public boolean networkValidated;
        public boolean receivedCapabilitiesChange;

        public NetworkCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network network) {
            RequirementsWatcher.this.handler.post(new RequirementsWatcher$NetworkCallback$$ExternalSyntheticLambda0(this, (byte) 0));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onBlockedStatusChanged(Network network, boolean z) {
            if (z) {
                return;
            }
            RequirementsWatcher.this.handler.post(new RequirementsWatcher$NetworkCallback$$ExternalSyntheticLambda0(this, (byte) 1));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            boolean zHasCapability = networkCapabilities.hasCapability(16);
            boolean z = this.receivedCapabilitiesChange;
            RequirementsWatcher requirementsWatcher = RequirementsWatcher.this;
            if (z && this.networkValidated == zHasCapability) {
                if (zHasCapability) {
                    requirementsWatcher.handler.post(new RequirementsWatcher$NetworkCallback$$ExternalSyntheticLambda0(this, (byte) 1));
                }
            } else {
                this.receivedCapabilitiesChange = true;
                this.networkValidated = zHasCapability;
                requirementsWatcher.handler.post(new RequirementsWatcher$NetworkCallback$$ExternalSyntheticLambda0(this, (byte) 0));
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network network) {
            RequirementsWatcher.this.handler.post(new RequirementsWatcher$NetworkCallback$$ExternalSyntheticLambda0(this, (byte) 0));
        }
    }

    public RequirementsWatcher(Context context, OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0, Requirements requirements) {
        this.context = context.getApplicationContext();
        this.listener = onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
        this.requirements = requirements;
    }

    public final void checkRequirements() {
        int notMetRequirements = this.requirements.getNotMetRequirements(this.context);
        if (this.notMetRequirements != notMetRequirements) {
            this.notMetRequirements = notMetRequirements;
            ((DownloadManager) this.listener.f$0).onRequirementsStateChanged(this, notMetRequirements);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final int start() {
        Requirements requirements = this.requirements;
        Context context = this.context;
        this.notMetRequirements = requirements.getNotMetRequirements(context);
        IntentFilter intentFilter = new IntentFilter();
        int i = requirements.requirements;
        if ((i & 1) != 0) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            connectivityManager.getClass();
            NetworkCallback networkCallback = new NetworkCallback();
            this.networkCallback = networkCallback;
            connectivityManager.registerDefaultNetworkCallback(networkCallback);
        }
        if ((i & 8) != 0) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if ((i & 4) != 0) {
            intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        }
        if ((i & 16) != 0) {
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        }
        NetworkTypeObserver.Receiver receiver = new NetworkTypeObserver.Receiver((byte) 4, this);
        this.receiver = receiver;
        context.registerReceiver(receiver, intentFilter, null, this.handler);
        return this.notMetRequirements;
    }
}
