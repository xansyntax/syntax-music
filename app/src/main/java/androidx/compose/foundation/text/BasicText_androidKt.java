package androidx.compose.foundation.text;

import android.os.Build;
import android.os.Trace;
import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import coil3.ImageLoader$Builder;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BasicText_androidKt {
    public static final StaticProvidableCompositionLocal LocalBackgroundTextMeasurementExecutor = new StaticProvidableCompositionLocal(new ScrollKt$$ExternalSyntheticLambda0((byte) 22), (byte) 0);
    public static Boolean backingCoreCountSatisfactory;

    public static final void BackgroundTextMeasurement(final AnnotatedString annotatedString, final TextStyle textStyle, final FontFamily.Resolver resolver, final List list, final boolean z, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        Executor executor = (Executor) gapComposer.consume(LocalBackgroundTextMeasurementExecutor);
        if (executor == null || !shouldPrefetch(annotatedString.text.length())) {
            gapComposer.startReplaceGroup(317137883);
            gapComposer.end(false);
            return;
        }
        gapComposer.startReplaceGroup(315439796);
        final LayoutDirection layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
        final Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
        try {
            executor.execute(new Runnable() { // from class: androidx.compose.foundation.text.BasicText_androidKt$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MutableSnapshot mutableSnapshotTakeNestedMutableSnapshot;
                    TextStyle textStyle2 = textStyle;
                    LayoutDirection layoutDirection2 = layoutDirection;
                    AnnotatedString annotatedString2 = annotatedString;
                    Density density2 = density;
                    FontFamily.Resolver resolver2 = resolver;
                    boolean z2 = z;
                    Trace.beginSection("BackgroundTextMeasurement");
                    try {
                        Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                        MutableSnapshot mutableSnapshot = snapshotCurrentSnapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshotCurrentSnapshot : null;
                        if (mutableSnapshot == null || (mutableSnapshotTakeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(null, null)) == null) {
                            throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
                        }
                        try {
                            Snapshot snapshotMakeCurrent = mutableSnapshotTakeNestedMutableSnapshot.makeCurrent();
                            try {
                                TextStyle textStyleResolveDefaults = TextRangeKt.resolveDefaults(textStyle2, layoutDirection2);
                                List list2 = list;
                                if (list2 == null) {
                                    list2 = EmptyList.INSTANCE;
                                }
                                ImageLoader$Builder imageLoader$Builder = new ImageLoader$Builder(annotatedString2, textStyleResolveDefaults, resolver2, density2, list2, z2);
                                imageLoader$Builder.getMaxIntrinsicWidth();
                                imageLoader$Builder.getMinIntrinsicWidth();
                                Snapshot.restoreCurrent(snapshotMakeCurrent);
                                mutableSnapshotTakeNestedMutableSnapshot.apply().check();
                                mutableSnapshotTakeNestedMutableSnapshot.dispose();
                                Trace.endSection();
                            } catch (Throwable th) {
                                Snapshot.restoreCurrent(snapshotMakeCurrent);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            try {
                                throw th2;
                            } catch (Throwable th3) {
                                mutableSnapshotTakeNestedMutableSnapshot.dispose();
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        Trace.endSection();
                        throw th4;
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
        gapComposer.end(false);
    }

    public static final boolean shouldPrefetch(int i) {
        if (Build.VERSION.SDK_INT >= 28 && i >= 8 && i < 1000) {
            Boolean boolValueOf = backingCoreCountSatisfactory;
            if (boolValueOf == null) {
                boolValueOf = Boolean.valueOf(Runtime.getRuntime().availableProcessors() >= 4);
                backingCoreCountSatisfactory = boolValueOf;
            }
            if (boolValueOf.booleanValue()) {
                return true;
            }
        }
        return false;
    }
}
