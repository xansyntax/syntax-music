package androidx.collection.internal;

import android.app.Application;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.media.MediaDrmException;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.ActionBarDrawerToggle$Delegate;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.runtime.DerivedSnapshotState$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.TransparentObserverMutableSnapshot;
import androidx.compose.runtime.snapshots.TransparentObserverSnapshot;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.LinearGradient;
import androidx.compose.ui.graphics.RadialGradient;
import androidx.core.view.ScrollFeedbackProviderCompat;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.exoplayer.drm.FrameworkCryptoConfig;
import androidx.savedstate.SavedStateRegistryOwner;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;
import kotlin.text.CharsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class Lock implements ActionBarDrawerToggle$Delegate, MenuPresenter.Callback, FloatDecayAnimationSpec, CoroutineContext.Key, ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl, CreationExtras.Key, ExoMediaDrm {
    public static Lock DEFAULT;
    public final /* synthetic */ byte $r8$classId;

    public Lock() {
        this.$r8$classId = (byte) 28;
        if (Build.VERSION.SDK_INT >= 35) {
        }
    }

    public static Snapshot getCurrentThreadSnapshot() {
        return (Snapshot) SnapshotKt.threadSnapshot.get();
    }

    /* JADX INFO: renamed from: linearGradient-mHitzGk, reason: not valid java name */
    public static LinearGradient m9linearGradientmHitzGk(Pair[] pairArr, long j, long j2) {
        ArrayList arrayList = new ArrayList(pairArr.length);
        for (Pair pair : pairArr) {
            Color color = (Color) pair.second;
            long j3 = color.value;
            arrayList.add(color);
        }
        ArrayList arrayList2 = new ArrayList(pairArr.length);
        for (Pair pair2 : pairArr) {
            arrayList2.add(Float.valueOf(((Number) pair2.first).floatValue()));
        }
        return new LinearGradient(j, j2, arrayList, arrayList2);
    }

    public static Snapshot makeCurrentNonObservable(Snapshot snapshot) {
        if (snapshot instanceof TransparentObserverMutableSnapshot) {
            TransparentObserverMutableSnapshot transparentObserverMutableSnapshot = (TransparentObserverMutableSnapshot) snapshot;
            if (transparentObserverMutableSnapshot.threadId == Expect_jvmKt.currentThreadId()) {
                transparentObserverMutableSnapshot.readObserver = null;
                return snapshot;
            }
        }
        if (snapshot instanceof TransparentObserverSnapshot) {
            TransparentObserverSnapshot transparentObserverSnapshot = (TransparentObserverSnapshot) snapshot;
            if (transparentObserverSnapshot.threadId == Expect_jvmKt.currentThreadId()) {
                transparentObserverSnapshot.readObserver = null;
                return snapshot;
            }
        }
        Snapshot snapshotCreateTransparentSnapshotWithNoParentReadObserver = SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(snapshot, null, false);
        snapshotCreateTransparentSnapshotWithNoParentReadObserver.makeCurrent();
        return snapshotCreateTransparentSnapshotWithNoParentReadObserver;
    }

    public static Object observe(DerivedSnapshotState$$ExternalSyntheticLambda0 derivedSnapshotState$$ExternalSyntheticLambda0, Function0 function0) {
        Snapshot transparentObserverMutableSnapshot;
        Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
        if (snapshot instanceof TransparentObserverMutableSnapshot) {
            TransparentObserverMutableSnapshot transparentObserverMutableSnapshot2 = (TransparentObserverMutableSnapshot) snapshot;
            if (transparentObserverMutableSnapshot2.threadId == Expect_jvmKt.currentThreadId()) {
                Function1 function1 = transparentObserverMutableSnapshot2.readObserver;
                Function1 function2 = transparentObserverMutableSnapshot2.writeObserver;
                try {
                    ((TransparentObserverMutableSnapshot) snapshot).readObserver = SnapshotKt.mergedReadObserver(derivedSnapshotState$$ExternalSyntheticLambda0, function1, true);
                    ((TransparentObserverMutableSnapshot) snapshot).writeObserver = function2;
                    return function0.invoke();
                } finally {
                    transparentObserverMutableSnapshot2.readObserver = function1;
                    transparentObserverMutableSnapshot2.writeObserver = function2;
                }
            }
        }
        if (snapshot == null || (snapshot instanceof MutableSnapshot)) {
            transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null, derivedSnapshotState$$ExternalSyntheticLambda0, null, true, false);
        } else {
            transparentObserverMutableSnapshot = snapshot.takeNestedSnapshot(derivedSnapshotState$$ExternalSyntheticLambda0);
        }
        try {
            Snapshot snapshotMakeCurrent = transparentObserverMutableSnapshot.makeCurrent();
            try {
                Object objInvoke = function0.invoke();
                Snapshot.restoreCurrent(snapshotMakeCurrent);
                transparentObserverMutableSnapshot.dispose();
                return objInvoke;
            } catch (Throwable th) {
                Snapshot.restoreCurrent(snapshotMakeCurrent);
                throw th;
            }
        } catch (Throwable th2) {
            transparentObserverMutableSnapshot.dispose();
            throw th2;
        }
    }

    /* JADX INFO: renamed from: radialGradient-P_Vx-Ks$default, reason: not valid java name */
    public static RadialGradient m10radialGradientP_VxKs$default(List list, long j, float f) {
        return new RadialGradient(list, null, j, f);
    }

    public static void restoreNonObservable(Snapshot snapshot, Snapshot snapshot2, Function1 function1) {
        if (snapshot != snapshot2) {
            snapshot2.getClass();
            Snapshot.restoreCurrent(snapshot);
            snapshot2.dispose();
        } else if (snapshot instanceof TransparentObserverMutableSnapshot) {
            ((TransparentObserverMutableSnapshot) snapshot).readObserver = function1;
        } else if (snapshot instanceof TransparentObserverSnapshot) {
            ((TransparentObserverSnapshot) snapshot).readObserver = function1;
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3(snapshot, "Non-transparent snapshot was reused: ");
        }
    }

    /* JADX INFO: renamed from: verticalGradient-8A-3gB4$default, reason: not valid java name */
    public static LinearGradient m11verticalGradient8A3gB4$default(List list, float f, float f2, int i) {
        return new LinearGradient((((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits((i & 2) != 0 ? 0.0f : f)) & 4294967295L), (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits((i & 4) != 0 ? Float.POSITIVE_INFINITY : f2)) & 4294967295L), list, null);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public FrameworkCryptoConfig createCryptoConfig(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getAbsVelocityThreshold() {
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public int getCryptoType() {
        return 1;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public long getDurationNanos(float f) {
        return 0L;
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public ExoMediaDrm.KeyRequest getKeyRequest(byte[] bArr, List list, int i, HashMap map) {
        throw new IllegalStateException();
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public ExoMediaDrm.ProvisionRequest getProvisionRequest() {
        throw new IllegalStateException();
    }

    public Signature[] getSigningSignatures(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getTargetValue(float f, float f2) {
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getValueFromNanos(float f, float f2, long j) {
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getVelocityFromNanos(long j, float f) {
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public boolean isPrecomputedText(CharSequence charSequence) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        return false;
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public byte[] openSession() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public void provideProvisionResponse(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public Map queryKeyStatus(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public boolean requiresSecureDecoder(String str, byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 6:
                return "CompositionErrorContext";
            case 22:
                int iHashCode = hashCode();
                CharsKt.checkRadix(16);
                String string = Integer.toString(iHashCode, 16);
                string.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("CreationExtras.Key@", string, "<", Reflection.getOrCreateKotlinClass(SavedStateRegistryOwner.class).getSimpleName(), ">");
            case 23:
                int iHashCode2 = hashCode();
                CharsKt.checkRadix(16);
                String string2 = Integer.toString(iHashCode2, 16);
                string2.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("CreationExtras.Key@", string2, "<", Reflection.getOrCreateKotlinClass(ViewModelStoreOwner.class).getSimpleName(), ">");
            case 24:
                int iHashCode3 = hashCode();
                CharsKt.checkRadix(16);
                String string3 = Integer.toString(iHashCode3, 16);
                string3.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("CreationExtras.Key@", string3, "<", Reflection.getOrCreateKotlinClass(Bundle.class).getSimpleName(), ">");
            case 25:
                int iHashCode4 = hashCode();
                CharsKt.checkRadix(16);
                String string4 = Integer.toString(iHashCode4, 16);
                string4.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("CreationExtras.Key@", string4, "<", Reflection.getOrCreateKotlinClass(Application.class).getSimpleName(), ">");
            case 26:
                int iHashCode5 = hashCode();
                CharsKt.checkRadix(16);
                String string5 = Integer.toString(iHashCode5, 16);
                string5.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("CreationExtras.Key@", string5, "<", Reflection.getOrCreateKotlinClass(String.class).getSimpleName(), ">");
            default:
                return super.toString();
        }
    }

    public /* synthetic */ Lock(byte b) {
        this.$r8$classId = b;
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public void release() {
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public void closeSession(byte[] bArr) {
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public void setOnEventListener(DefaultDrmSessionManager.MediaDrmEventListener mediaDrmEventListener) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
    public void onScrollLimit(int i, int i2, int i3, boolean z) {
    }

    @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
    public void onScrollProgress(int i, int i2, int i3, int i4) {
    }
}
