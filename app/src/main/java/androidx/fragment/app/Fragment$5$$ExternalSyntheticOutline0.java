package androidx.fragment.app;

import android.content.res.TypedArray;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.datastore.preferences.PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility;
import coil3.network.HttpException;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class Fragment$5$$ExternalSyntheticOutline0 {
    public static final void _applyState(View view, int i) {
        int iOrdinal = PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility.ordinal(i);
        if (iOrdinal == 0) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    view.toString();
                    viewGroup.toString();
                }
                viewGroup.removeView(view);
                return;
            }
            return;
        }
        if (iOrdinal == 1) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(view);
            }
            view.setVisibility(0);
        } else if (iOrdinal == 2) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(view);
            }
            view.setVisibility(8);
        } else {
            if (iOrdinal != 3) {
                return;
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(view);
            }
            view.setVisibility(4);
        }
    }

    public static int _from(View view) {
        if (view.getAlpha() == CropImageView.DEFAULT_ASPECT_RATIO && view.getVisibility() == 0) {
            return 4;
        }
        return _from(view.getVisibility());
    }

    public static /* synthetic */ void m(AutoCloseable autoCloseable) throws Exception {
        boolean zIsTerminated;
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (!(autoCloseable instanceof ExecutorService)) {
            if (autoCloseable instanceof TypedArray) {
                ((TypedArray) autoCloseable).recycle();
                return;
            }
            if (autoCloseable instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) autoCloseable).release();
                return;
            } else if (autoCloseable instanceof MediaDrm) {
                ((MediaDrm) autoCloseable).release();
                return;
            } else {
                Path$$ExternalSyntheticBUOutline0.m();
                return;
            }
        }
        ExecutorService executorService = (ExecutorService) autoCloseable;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    executorService.shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static HttpException m$1(String str) {
        ListUtilsKt.throwNoSuchElementException(str);
        return new HttpException();
    }

    public static HttpException m$2(String str) {
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(str);
        return new HttpException();
    }

    public static int _from(int i) {
        if (i == 0) {
            return 2;
        }
        if (i == 4) {
            return 4;
        }
        if (i == 8) {
            return 3;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "Unknown visibility "));
        return 0;
    }

    public static int m(int i, int i2, String str) {
        return (str.hashCode() + i) * i2;
    }

    public static int m(int i, int i2, List list) {
        return (list.hashCode() + i) * i2;
    }

    public static int m(TextStyle textStyle, int i, int i2) {
        return (textStyle.hashCode() + i) * i2;
    }

    public static ParcelableSnapshotMutableIntState m(int i, GapComposer gapComposer) {
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = new ParcelableSnapshotMutableIntState(i);
        gapComposer.updateRememberedValue(parcelableSnapshotMutableIntState);
        return parcelableSnapshotMutableIntState;
    }

    public static ProvidedValue m(long j, StaticProvidableCompositionLocal staticProvidableCompositionLocal) {
        return staticProvidableCompositionLocal.defaultProvidedValue$runtime(new Color(j));
    }

    public static SnapshotStateList m(GapComposer gapComposer) {
        SnapshotStateList snapshotStateList = new SnapshotStateList();
        gapComposer.updateRememberedValue(snapshotStateList);
        return snapshotStateList;
    }

    public static Color m(GapComposer gapComposer, boolean z, long j) {
        gapComposer.end(z);
        return new Color(j);
    }

    public static HttpException m(Object obj) {
        ResultKt.throwOnFailure(obj);
        return new HttpException();
    }

    public static HttpException m(String str) {
        androidx.compose.foundation.internal.InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck(str);
        return new HttpException();
    }

    public static String m(int i, int i2, String str, String str2) {
        return str + i + str2 + i2;
    }

    public static String m(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String m(String str, String str2) {
        return str + str2;
    }

    public static String m(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String m(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static String m(String str, String str2, List list) {
        return str + list + str2;
    }

    public static String m(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder m(long j, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(j);
        sb.append(str2);
        return sb;
    }

    public static void m(int i, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, boolean z) {
        composableLambdaImpl.invoke(gapComposer, Integer.valueOf(i));
        gapComposer.end(z);
    }

    public static void m(GapComposer gapComposer, boolean z, boolean z2, boolean z3) {
        gapComposer.end(z);
        gapComposer.end(z2);
        gapComposer.end(z3);
    }

    public static int m(double d, int i, int i2) {
        return (Double.hashCode(d) + i) * i2;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m833m(Object obj) {
        if (obj == null) {
            return;
        }
        PathKt$$ExternalSyntheticBUOutline0.m();
    }

    public static void m(StringBuilder sb, boolean z, String str, boolean z2, String str2) {
        sb.append(z);
        sb.append(str);
        sb.append(z2);
        sb.append(str2);
    }
}
