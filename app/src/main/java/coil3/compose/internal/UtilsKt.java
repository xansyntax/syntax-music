package coil3.compose.internal;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.lifecycle.Lifecycle;
import coil3.UriKt;
import coil3.compose.AsyncImagePreviewHandler$Companion$Default$1;
import coil3.compose.ConstraintsSizeResolver;
import coil3.compose.LocalAsyncImagePreviewHandlerKt;
import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.size.SizeResolver;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UtilsKt {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long ZeroConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 5);

    public static final AsyncImagePreviewHandler$Companion$Default$1 previewHandler(Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        if (!((Boolean) gapComposer.consume(InspectionModeKt.LocalInspectionMode)).booleanValue()) {
            gapComposer.startReplaceGroup(2019088453);
            gapComposer.end(false);
            return null;
        }
        gapComposer.startReplaceGroup(2019030948);
        AsyncImagePreviewHandler$Companion$Default$1 asyncImagePreviewHandler$Companion$Default$1 = (AsyncImagePreviewHandler$Companion$Default$1) gapComposer.consume(LocalAsyncImagePreviewHandlerKt.LocalAsyncImagePreviewHandler);
        gapComposer.end(false);
        return asyncImagePreviewHandler$Companion$Default$1;
    }

    public static final SizeResolver rememberSizeResolver(ContentScale contentScale, Composer composer) {
        Object obj;
        Object obj2;
        boolean zAreEqual = Intrinsics.areEqual(contentScale, ContentScale.Companion.None);
        GapComposer gapComposer = (GapComposer) composer;
        boolean zChanged = gapComposer.changed(zAreEqual);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            if (zAreEqual) {
                obj = SizeResolver.ORIGINAL;
            } else {
                ConstraintsSizeResolver constraintsSizeResolver = new ConstraintsSizeResolver();
                constraintsSizeResolver.latestConstraints = ZeroConstraints;
                constraintsSizeResolver.continuations = new ArrayList();
                obj = constraintsSizeResolver;
            }
            Object obj3 = obj;
            gapComposer.updateRememberedValue(obj3);
            obj2 = obj3;
        }
        obj2 = objRememberedValue;
        return (SizeResolver) obj2;
    }

    public static final ImageRequest requestOf(Object obj, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(1319639034);
        if (obj instanceof ImageRequest) {
            gapComposer.startReplaceGroup(1530875884);
            ImageRequest imageRequest = (ImageRequest) obj;
            gapComposer.end(false);
            gapComposer.end(false);
            return imageRequest;
        }
        gapComposer.startReplaceGroup(1530915130);
        Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
        boolean zChanged = gapComposer.changed(context) | gapComposer.changed(obj);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            ImageRequest.Builder builder = new ImageRequest.Builder(context);
            builder.data = obj;
            objRememberedValue = builder.build();
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        ImageRequest imageRequest2 = (ImageRequest) objRememberedValue;
        gapComposer.end(false);
        gapComposer.end(false);
        return imageRequest2;
    }

    /* JADX INFO: renamed from: toIntSize-uvyYCjk, reason: not valid java name */
    public static final long m856toIntSizeuvyYCjk(long j) {
        int iRoundToInt = MathKt.roundToInt(Float.intBitsToFloat((int) (j >> 32)));
        return (((long) MathKt.roundToInt(Float.intBitsToFloat((int) (j & 4294967295L)))) & 4294967295L) | (((long) iRoundToInt) << 32);
    }

    public static void unsupportedData$default(String str) {
        throw new IllegalArgumentException("Unsupported type: " + str + ". " + IntIntPair$$ExternalSyntheticOutline0.m("If you wish to display this ", str, ", use androidx.compose.foundation.Image."));
    }

    public static final void validateRequest(ImageRequest imageRequest) {
        Object obj = imageRequest.data;
        if (obj instanceof ImageRequest.Builder) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Unsupported type: ImageRequest.Builder. Did you forget to call ImageRequest.Builder.build()?");
            return;
        }
        if (obj instanceof ImageBitmap) {
            unsupportedData$default("ImageBitmap");
            throw null;
        }
        if (obj instanceof ImageVector) {
            unsupportedData$default("ImageVector");
            throw null;
        }
        if (obj instanceof Painter) {
            unsupportedData$default("Painter");
            throw null;
        }
        if (imageRequest.target != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("request.target must be null.");
        } else {
            if (((Lifecycle) UriKt.getExtra(imageRequest, ImageRequests_androidKt.lifecycleKey)) == null) {
                return;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("request.lifecycle must be null.");
        }
    }
}
