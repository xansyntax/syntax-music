package coil3.compose;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.BitmapImage;
import coil3.DrawableImage;
import coil3.Extras;
import coil3.Image;
import coil3.SingletonImageLoader;
import coil3.UriKt;
import coil3.compose.internal.AsyncImageState;
import coil3.compose.internal.ContentPainterElement;
import coil3.compose.internal.UtilsKt;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import coil3.compose.internal.UtilsKt$UseMinConstraintsMeasurePolicy$1;
import coil3.request.ImageRequest;
import coil3.size.SizeResolver;
import com.google.accompanist.drawablepainter.DrawablePainter;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AsyncImageKt {
    public static final AsyncImagePainter_androidKt$FakeTransitionTarget$1 FakeTransitionTarget = new AsyncImagePainter_androidKt$FakeTransitionTarget$1();
    public static final Extras.Key preferEndFirstIntrinsicSizeKey;
    public static final Extras.Key useExistingImageAsPlaceholderKey;

    static {
        Boolean bool = Boolean.FALSE;
        useExistingImageAsPlaceholderKey = new Extras.Key(bool);
        preferEndFirstIntrinsicSizeKey = new Extras.Key(bool);
    }

    /* JADX INFO: renamed from: AsyncImage-10Xjiaw, reason: not valid java name */
    public static final void m849AsyncImage10Xjiaw(Object obj, Modifier modifier, ContentScale contentScale, Composer composer, int i, int i2) {
        GapComposer gapComposer = (GapComposer) composer;
        int i3 = i << 3;
        int i4 = (i & 126) | (i3 & 7168) | (i3 & 57344) | (i3 & 458752) | (i3 & 3670016) | (i3 & 29360128) | (i3 & 234881024) | (i3 & 1879048192);
        int i5 = i4 >> 3;
        m850AsyncImage76YX9Dk(new AsyncImageState(obj, (AsyncImageModelEqualityDelegate$Companion$Default$1) gapComposer.consume(LocalAsyncImageModelEqualityDelegateKt.LocalAsyncImageModelEqualityDelegate), SingletonImageLoader.get((Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext))), modifier, AsyncImagePainter.DefaultTransform, null, Alignment.Companion.Center, (i2 & 64) != 0 ? ContentScale.Companion.Fit : contentScale, gapComposer, (i4 & 112) | (i5 & 896) | (i5 & 7168) | (i5 & 57344) | (i5 & 458752) | (i5 & 3670016) | (i5 & 29360128) | (i5 & 234881024) | ((((i >> 27) & 14) << 27) & 1879048192), 0);
    }

    /* JADX WARN: Code duplicated, block: B:111:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:112:0x01c9  */
    /* JADX INFO: renamed from: AsyncImage-76YX9Dk, reason: not valid java name */
    public static final void m850AsyncImage76YX9Dk(final AsyncImageState asyncImageState, final Modifier modifier, final Function1 function1, final Function1 function2, final Alignment alignment, final ContentScale contentScale, Composer composer, final int i, final int i2) {
        int i3;
        Function1 function3;
        Alignment alignment2;
        int i4;
        ImageRequest imageRequest;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1236588022);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(asyncImageState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer.changed((Object) null) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            function3 = function2;
            i3 |= gapComposer.changedInstance(function3) ? 16384 : 8192;
        } else {
            function3 = function2;
        }
        if ((196608 & i) == 0) {
            alignment2 = alignment;
            i3 |= gapComposer.changed(alignment2) ? 131072 : 65536;
        } else {
            alignment2 = alignment;
        }
        if ((1572864 & i) == 0) {
            i3 |= gapComposer.changed(contentScale) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= gapComposer.changed(1.0f) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= gapComposer.changed((Object) null) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= gapComposer.changed(1) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (gapComposer.changed(true) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if (gapComposer.shouldExecute(i3 & 1, ((306783379 & i3) == 306783378 && (i4 & 3) == 2) ? false : true)) {
            Object obj = asyncImageState.model;
            int i5 = UtilsKt.$r8$clinit;
            gapComposer.startReplaceGroup(-329318062);
            boolean z = obj instanceof ImageRequest;
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z) {
                gapComposer.startReplaceGroup(-1008942344);
                imageRequest = (ImageRequest) obj;
                if (imageRequest.defined.sizeResolver != null) {
                    gapComposer.startReplaceGroup(-1008902292);
                    gapComposer.end(false);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-1008854118);
                    SizeResolver sizeResolverRememberSizeResolver = UtilsKt.rememberSizeResolver(contentScale, gapComposer);
                    boolean zChanged = gapComposer.changed(obj) | gapComposer.changed(sizeResolverRememberSizeResolver);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        ImageRequest.Builder builderNewBuilder$default = ImageRequest.newBuilder$default(imageRequest);
                        builderNewBuilder$default.sizeResolver = sizeResolverRememberSizeResolver;
                        objRememberedValue = builderNewBuilder$default.build();
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    imageRequest = (ImageRequest) objRememberedValue;
                    Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, false, false);
                }
                UtilsKt.validateRequest(imageRequest);
                Modifier modifierThen = modifier.then(new ContentPainterElement(imageRequest, asyncImageState.imageLoader, asyncImageState.modelEqualityDelegate, function1, function3, alignment2, contentScale, UtilsKt.previewHandler(gapComposer)));
                int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                ComposeUiNode.Companion.getClass();
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(LayoutNode.Constructor);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, UtilsKt$UseMinConstraintsMeasurePolicy$1.INSTANCE, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m389reconcileimpl(gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                gapComposer.end(true);
            } else {
                gapComposer.startReplaceGroup(-1008595950);
                Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
                SizeResolver sizeResolverRememberSizeResolver2 = UtilsKt.rememberSizeResolver(contentScale, gapComposer);
                boolean zChanged2 = gapComposer.changed(context) | gapComposer.changed(obj) | gapComposer.changed(sizeResolverRememberSizeResolver2);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                    ImageRequest.Builder builder = new ImageRequest.Builder(context);
                    builder.data = obj;
                    builder.sizeResolver = sizeResolverRememberSizeResolver2;
                    objRememberedValue2 = builder.build();
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                imageRequest = (ImageRequest) objRememberedValue2;
                gapComposer.end(false);
            }
            gapComposer.end(false);
            UtilsKt.validateRequest(imageRequest);
            Modifier modifierThen2 = modifier.then(new ContentPainterElement(imageRequest, asyncImageState.imageLoader, asyncImageState.modelEqualityDelegate, function1, function3, alignment2, contentScale, UtilsKt.previewHandler(gapComposer)));
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen2);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, UtilsKt$UseMinConstraintsMeasurePolicy$1.INSTANCE, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.SetCompositeKeyHash);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: coil3.compose.AsyncImageKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    ((Integer) obj3).getClass();
                    AsyncImageKt.m850AsyncImage76YX9Dk(asyncImageState, modifier, function1, function2, alignment, contentScale, (Composer) obj2, Stack.updateChangedFlags(i | 1), Stack.updateChangedFlags(i2));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: AsyncImage-x1rPTaM, reason: not valid java name */
    public static final void m851AsyncImagex1rPTaM(ImageRequest imageRequest, Modifier modifier, Painter painter, Painter painter2, ContentScale contentScale, Composer composer, int i) {
        BiasAlignment biasAlignment = Alignment.Companion.Center;
        GapComposer gapComposer = (GapComposer) composer;
        int i2 = (i << 3) & 112;
        AsyncImageState asyncImageState = new AsyncImageState(imageRequest, (AsyncImageModelEqualityDelegate$Companion$Default$1) gapComposer.consume(LocalAsyncImageModelEqualityDelegateKt.LocalAsyncImageModelEqualityDelegate), SingletonImageLoader.get((Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext)));
        int i3 = UtilsKt.$r8$clinit;
        m850AsyncImage76YX9Dk(asyncImageState, modifier, (painter == null && painter2 == null && painter2 == null) ? AsyncImagePainter.DefaultTransform : new UtilsKt$$ExternalSyntheticLambda0((Object) painter, (Object) painter2, (Object) painter2, (byte) 0), null, biasAlignment, contentScale, gapComposer, 48 | ((i2 << 15) & 3670016), 0);
    }

    /* JADX INFO: renamed from: asPainter-55t9-rM, reason: not valid java name */
    public static final Painter m852asPainter55t9rM(Image image, Context context) {
        if (!(image instanceof BitmapImage)) {
            if (!(image instanceof DrawableImage)) {
                return new ImagePainter(image);
            }
            Drawable drawableMutate = UriKt.asDrawable(image, context.getResources()).mutate();
            drawableMutate.setFilterBitmap(true);
            return new DrawablePainter(drawableMutate);
        }
        Bitmap bitmap = ((BitmapImage) image).bitmap;
        BitmapPainter bitmapPainter = new BitmapPainter(new AndroidImageBitmap(bitmap), (((long) bitmap.getWidth()) << 32) | (((long) bitmap.getHeight()) & 4294967295L));
        bitmapPainter.filterQuality = true;
        return bitmapPainter;
    }
}
