package dev.chrisbanes.haze;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Trace;
import android.renderscript.RenderScript;
import android.view.Surface;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.MultiParagraph$$ExternalSyntheticLambda0;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import coil3.size.SizeKt;
import coil3.util.LifecyclesKt;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.playback.MusicService;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RenderScriptBlurEffect implements BlurEffect {
    public static boolean isEnabled = true;
    public final GraphicsLayer contentLayer;
    public StandaloneCoroutine currentJob;
    public final CanvasDrawScope drawScope = new CanvasDrawScope();
    public boolean drawSkipped;
    public final HazeEffectNode node;
    public final RenderScript renderScript;
    public RenderScriptContext renderScriptContext;

    /* JADX INFO: renamed from: dev.chrisbanes.haze.RenderScriptBlurEffect$updateSurface$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public float F$0;
        public int I$0;
        public int I$1;
        public int I$2;
        public int I$3;
        public int I$4;
        public GraphicsLayer L$0;
        public String L$2;
        public RenderScriptContext L$4;
        public String L$7;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RenderScriptBlurEffect.this.updateSurface(null, CropImageView.DEFAULT_ASPECT_RATIO, this);
        }
    }

    public RenderScriptBlurEffect(HazeEffectNode hazeEffectNode) {
        this.node = hazeEffectNode;
        this.renderScript = RenderScript.create((Context) HitTestResultKt.currentValueOf(hazeEffectNode, AndroidCompositionLocals_androidKt.LocalContext));
        this.contentLayer = ((GraphicsContext) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalGraphicsContext)).createGraphicsLayer();
    }

    @Override // dev.chrisbanes.haze.BlurEffect
    public final void cleanup() {
        StandaloneCoroutine standaloneCoroutine = this.currentJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        ((GraphicsContext) HitTestResultKt.currentValueOf(this.node, CompositionLocalsKt.LocalGraphicsContext)).releaseGraphicsLayer(this.contentLayer);
        RenderScriptContext renderScriptContext = this.renderScriptContext;
        if (renderScriptContext != null) {
            renderScriptContext.isDestroyed = true;
            renderScriptContext.blurScript.destroy();
            renderScriptContext.inputAlloc.destroy();
            renderScriptContext.outputAlloc.destroy();
            renderScriptContext.rs.destroy();
        }
    }

    @Override // dev.chrisbanes.haze.BlurEffect
    public final void drawEffect(LayoutNodeDrawScope layoutNodeDrawScope) throws Throwable {
        LayoutNodeDrawScope layoutNodeDrawScope2;
        HazeEffectNode hazeEffectNode;
        StandaloneCoroutine standaloneCoroutine;
        RenderScriptBlurEffect renderScriptBlurEffect = this;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal = AndroidCompositionLocals_androidKt.LocalContext;
        HazeEffectNode hazeEffectNode2 = renderScriptBlurEffect.node;
        Context context = (Context) HitTestResultKt.currentValueOf(hazeEffectNode2, staticProvidableCompositionLocal);
        long j = hazeEffectNode2.layerOffset;
        Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        float fM1544calculateInputScaleFactor3ABfNKs$default = HazeEffectNodeKt.m1544calculateInputScaleFactor3ABfNKs$default(hazeEffectNode2);
        ref$FloatRef.element = fM1544calculateInputScaleFactor3ABfNKs$default;
        Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
        layoutNodeDrawScope.getDensity();
        float fMo81toPx0680j_4 = layoutNodeDrawScope.mo81toPx0680j_4(HazeEffectNodeKt.resolveBlurRadius(hazeEffectNode2)) * fM1544calculateInputScaleFactor3ABfNKs$default;
        ref$FloatRef2.element = fMo81toPx0680j_4;
        if (fMo81toPx0680j_4 > 25.0f) {
            ref$FloatRef.element = (25.0f / fMo81toPx0680j_4) * ref$FloatRef.element;
            ref$FloatRef2.element = 25.0f;
        }
        GraphicsLayer graphicsLayer = renderScriptBlurEffect.contentLayer;
        if (IntSize.m810equalsimpl0(graphicsLayer.size, 0L) || (standaloneCoroutine = renderScriptBlurEffect.currentJob) == null || !standaloneCoroutine.isActive()) {
            renderScriptBlurEffect.drawSkipped = false;
            GraphicsLayer graphicsLayerM1538createScaledContentLayerwZMzALA = CanvasKt.m1538createScaledContentLayerwZMzALA(layoutNodeDrawScope, hazeEffectNode2, ref$FloatRef.element, hazeEffectNode2.layerSize, j);
            layoutNodeDrawScope2 = layoutNodeDrawScope;
            if (graphicsLayerM1538createScaledContentLayerwZMzALA != null) {
                graphicsLayerM1538createScaledContentLayerwZMzALA.setClip(hazeEffectNode2.blurredEdgeTreatment != null);
                Continuation continuation = null;
                if (IntSize.m810equalsimpl0(graphicsLayer.size, 0L)) {
                    hazeEffectNode = hazeEffectNode2;
                    AwaitKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new RenderScriptBlurEffect$drawEffect$2$1(renderScriptBlurEffect, graphicsLayerM1538createScaledContentLayerwZMzALA, ref$FloatRef2, continuation, (byte) 0));
                    renderScriptBlurEffect = this;
                } else {
                    hazeEffectNode = hazeEffectNode2;
                    CoroutineScope coroutineScope = hazeEffectNode.getCoroutineScope();
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    renderScriptBlurEffect = this;
                    renderScriptBlurEffect.currentJob = AwaitKt.launch$default(coroutineScope, MainDispatcherLoader.dispatcher.immediate, null, new RenderScriptBlurEffect$drawEffect$2$1(renderScriptBlurEffect, graphicsLayerM1538createScaledContentLayerwZMzALA, ref$FloatRef2, continuation, (byte) 1), 2);
                }
            } else {
                hazeEffectNode = hazeEffectNode2;
            }
        } else {
            renderScriptBlurEffect.drawSkipped = true;
            layoutNodeDrawScope2 = layoutNodeDrawScope;
            hazeEffectNode = hazeEffectNode2;
        }
        GraphicsContext graphicsContext = (GraphicsContext) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalGraphicsContext);
        GraphicsLayer graphicsLayerCreateGraphicsLayer = graphicsContext.createGraphicsLayer();
        try {
            graphicsLayerCreateGraphicsLayer.getClass();
            graphicsLayerCreateGraphicsLayer.setAlpha(hazeEffectNode.alpha);
            Lazy lazy = HazeEffectNodeKt.renderEffectCache$delegate;
            graphicsLayerCreateGraphicsLayer.setClip(hazeEffectNode.blurredEdgeTreatment != null);
            layoutNodeDrawScope2.m651recordJVtK1S4(SizeKt.m875toIntSizeuvyYCjk(layoutNodeDrawScope2.canvasDrawScope.mo556getSizeNHjbRc()), graphicsLayerCreateGraphicsLayer, new MultiParagraph$$ExternalSyntheticLambda0(j, ref$FloatRef, renderScriptBlurEffect, context));
            LifecyclesKt.drawLayer(layoutNodeDrawScope2, graphicsLayerCreateGraphicsLayer);
        } finally {
            graphicsContext.releaseGraphicsLayer(graphicsLayerCreateGraphicsLayer);
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:48:0x00fe A[Catch: all -> 0x0187, TRY_LEAVE, TryCatch #3 {all -> 0x0187, blocks: (B:43:0x00ee, B:48:0x00fe, B:68:0x018c, B:74:0x01b1, B:75:0x01b4), top: B:82:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:52:0x012b  */
    /* JADX WARN: Code duplicated, block: B:67:0x018a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.compose.ui.graphics.layer.GraphicsLayer] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.ui.graphics.layer.GraphicsLayer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2, types: [dev.chrisbanes.haze.RenderScriptBlurEffect$updateSurface$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r6v4, types: [kotlinx.coroutines.channels.BufferedChannel] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v4, types: [int] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9 */
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
    public final Object updateSurface(GraphicsLayer graphicsLayer, float f, ContinuationImpl continuationImpl) throws Throwable {
        ?? anonymousClass1;
        ?? r10;
        String str;
        RenderScriptContext renderScriptContext;
        float f2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        String str2;
        ?? r1;
        String str3;
        DefaultScheduler defaultScheduler;
        MusicService.AnonymousClass13 anonymousClass13;
        ?? r9;
        ?? r7;
        ?? r2 = graphicsLayer;
        if (continuationImpl instanceof AnonymousClass1) {
            AnonymousClass1 anonymousClass2 = (AnonymousClass1) continuationImpl;
            int i6 = anonymousClass2.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label = i6 - Integer.MIN_VALUE;
                anonymousClass1 = anonymousClass2;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i7 = anonymousClass1.label;
        Unit unit = Unit.INSTANCE;
        HazeEffectNode hazeEffectNode = this.node;
        ?? r11 = 0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i7 == 0) {
                    ResultKt.throwOnFailure(obj);
                    String str4 = "Haze-RenderScriptBlurEffect-updateSurface";
                    DatabaseDao_Impl.AnonymousClass17.beginAsyncSection("Haze-RenderScriptBlurEffect-updateSurface");
                    try {
                        long j = r2.size;
                        RenderScriptContext renderScriptContext2 = this.renderScriptContext;
                        if (renderScriptContext2 == null || !IntSize.m810equalsimpl0(renderScriptContext2.size, j)) {
                            if (renderScriptContext2 != null) {
                                renderScriptContext2.isDestroyed = true;
                                renderScriptContext2.blurScript.destroy();
                                renderScriptContext2.inputAlloc.destroy();
                                renderScriptContext2.outputAlloc.destroy();
                                renderScriptContext2.rs.destroy();
                            }
                            RenderScript renderScript = this.renderScript;
                            renderScript.getClass();
                            renderScriptContext2 = new RenderScriptContext(renderScript, j);
                            this.renderScriptContext = renderScriptContext2;
                        }
                        str = "Haze-RenderScriptBlurEffect-updateSurface-drawLayerToSurface";
                        DatabaseDao_Impl.AnonymousClass17.beginAsyncSection("Haze-RenderScriptBlurEffect-updateSurface-drawLayerToSurface");
                        try {
                            Surface surface = renderScriptContext2.inputAlloc.getSurface();
                            surface.getClass();
                            CanvasKt.drawGraphicsLayer(surface, r2, HitTestResultKt.requireLayoutNode(hazeEffectNode).density, this.drawScope);
                            anonymousClass1.L$0 = r2;
                            anonymousClass1.L$2 = "Haze-RenderScriptBlurEffect-updateSurface";
                            anonymousClass1.L$4 = renderScriptContext2;
                            anonymousClass1.L$7 = "Haze-RenderScriptBlurEffect-updateSurface-drawLayerToSurface";
                            anonymousClass1.F$0 = f;
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.I$1 = 0;
                            anonymousClass1.I$2 = 0;
                            anonymousClass1.I$3 = 0;
                            anonymousClass1.I$4 = 0;
                            anonymousClass1.label = 1;
                            Object objReceive = renderScriptContext2.channel.receive(anonymousClass1);
                            if (objReceive != coroutineSingletons) {
                                objReceive = unit;
                            }
                            if (objReceive != coroutineSingletons) {
                                renderScriptContext = renderScriptContext2;
                                f2 = f;
                                i = 0;
                                i2 = 0;
                                i3 = 0;
                                i4 = 0;
                                i5 = 0;
                                r1 = r2;
                                str2 = str4;
                                DatabaseDao_Impl.AnonymousClass17.endAsyncSection(0, str);
                                if (!hazeEffectNode.isAttached) {
                                    unit = unit;
                                    r7 = i3;
                                    r9 = str2;
                                } else if (f2 > CropImageView.DEFAULT_ASPECT_RATIO) {
                                    DatabaseDao_Impl.AnonymousClass17.beginAsyncSection("Haze-RenderScriptBlurEffect-updateSurface-applyBlur");
                                    defaultScheduler = Dispatchers.Default;
                                    anonymousClass13 = new MusicService.AnonymousClass13(renderScriptContext, f2, null);
                                    anonymousClass1.L$0 = null;
                                    anonymousClass1.L$2 = str2;
                                    anonymousClass1.L$4 = renderScriptContext;
                                    anonymousClass1.L$7 = "Haze-RenderScriptBlurEffect-updateSurface-applyBlur";
                                    anonymousClass1.F$0 = f2;
                                    anonymousClass1.I$0 = i5;
                                    anonymousClass1.I$1 = i4;
                                    anonymousClass1.I$2 = i3 == true ? 1 : 0;
                                    anonymousClass1.I$3 = i2;
                                    anonymousClass1.I$4 = i;
                                    anonymousClass1.label = 2;
                                    if (AwaitKt.withContext(defaultScheduler, anonymousClass13, anonymousClass1) != coroutineSingletons) {
                                        str3 = "Haze-RenderScriptBlurEffect-updateSurface-applyBlur";
                                        r2 = i3 == true ? 1 : 0;
                                        anonymousClass1 = str2;
                                        DatabaseDao_Impl.AnonymousClass17.endAsyncSection(0, str3);
                                        Trace.beginSection(DatabaseDao_Impl.AnonymousClass17.truncatedTraceSectionLabel("Haze-RenderScriptBlurEffect-updateSurface-drawToContentLayer"));
                                        Bitmap bitmap = renderScriptContext.outputBitmap;
                                        this.contentLayer.m557recordmLhObY(HitTestResultKt.requireLayoutNode(hazeEffectNode).density, (LayoutDirection) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalLayoutDirection), (((long) bitmap.getWidth()) << 32) | (((long) bitmap.getHeight()) & 4294967295L), new RenderScriptBlurEffect$updateSurface$2$4((byte) 22, bitmap));
                                        Trace.endSection();
                                        r7 = r2;
                                        r9 = anonymousClass1;
                                    }
                                } else {
                                    unit = unit;
                                    this.contentLayer.m557recordmLhObY(HitTestResultKt.requireLayoutNode(hazeEffectNode).density, (LayoutDirection) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalLayoutDirection), r1.size, new RenderScriptBlurEffect$updateSurface$2$4((byte) 0, r1));
                                    r7 = i3;
                                    r9 = str2;
                                }
                            }
                            return coroutineSingletons;
                        } catch (Throwable th) {
                            th = th;
                            DatabaseDao_Impl.AnonymousClass17.endAsyncSection(0, str);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r10 = 0;
                        r11 = str4;
                        DatabaseDao_Impl.AnonymousClass17.endAsyncSection(r10, r11);
                        throw th;
                    }
                }
                if (i7 == 1) {
                    int i8 = anonymousClass1.I$4;
                    i2 = anonymousClass1.I$3;
                    int i9 = anonymousClass1.I$2;
                    i4 = anonymousClass1.I$1;
                    i5 = anonymousClass1.I$0;
                    f2 = anonymousClass1.F$0;
                    str = anonymousClass1.L$7;
                    renderScriptContext = anonymousClass1.L$4;
                    String str5 = anonymousClass1.L$2;
                    GraphicsLayer graphicsLayer2 = anonymousClass1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        i = i8;
                        r1 = graphicsLayer2;
                        i3 = i9;
                        str2 = str5;
                        DatabaseDao_Impl.AnonymousClass17.endAsyncSection(0, str);
                        if (!hazeEffectNode.isAttached) {
                            unit = unit;
                            r7 = i3;
                            r9 = str2;
                        } else {
                            if (f2 > CropImageView.DEFAULT_ASPECT_RATIO) {
                                DatabaseDao_Impl.AnonymousClass17.beginAsyncSection("Haze-RenderScriptBlurEffect-updateSurface-applyBlur");
                                try {
                                    defaultScheduler = Dispatchers.Default;
                                    anonymousClass13 = new MusicService.AnonymousClass13(renderScriptContext, f2, null);
                                    anonymousClass1.L$0 = null;
                                    anonymousClass1.L$2 = str2;
                                    anonymousClass1.L$4 = renderScriptContext;
                                    anonymousClass1.L$7 = "Haze-RenderScriptBlurEffect-updateSurface-applyBlur";
                                    anonymousClass1.F$0 = f2;
                                    anonymousClass1.I$0 = i5;
                                    anonymousClass1.I$1 = i4;
                                    anonymousClass1.I$2 = i3 == true ? 1 : 0;
                                    anonymousClass1.I$3 = i2;
                                    anonymousClass1.I$4 = i;
                                    anonymousClass1.label = 2;
                                    if (AwaitKt.withContext(defaultScheduler, anonymousClass13, anonymousClass1) != coroutineSingletons) {
                                        str3 = "Haze-RenderScriptBlurEffect-updateSurface-applyBlur";
                                        r2 = i3 == true ? 1 : 0;
                                        anonymousClass1 = str2;
                                        DatabaseDao_Impl.AnonymousClass17.endAsyncSection(0, str3);
                                        Trace.beginSection(DatabaseDao_Impl.AnonymousClass17.truncatedTraceSectionLabel("Haze-RenderScriptBlurEffect-updateSurface-drawToContentLayer"));
                                        Bitmap bitmap2 = renderScriptContext.outputBitmap;
                                        this.contentLayer.m557recordmLhObY(HitTestResultKt.requireLayoutNode(hazeEffectNode).density, (LayoutDirection) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalLayoutDirection), (((long) bitmap2.getWidth()) << 32) | (((long) bitmap2.getHeight()) & 4294967295L), new RenderScriptBlurEffect$updateSurface$2$4((byte) 22, bitmap2));
                                        Trace.endSection();
                                        r7 = r2;
                                        r9 = anonymousClass1;
                                    }
                                    return coroutineSingletons;
                                } catch (Throwable th3) {
                                    th = th3;
                                    str3 = "Haze-RenderScriptBlurEffect-updateSurface-applyBlur";
                                    boolean z = i3 == true ? 1 : 0;
                                    DatabaseDao_Impl.AnonymousClass17.endAsyncSection(0, str3);
                                    throw th;
                                }
                            }
                            unit = unit;
                            this.contentLayer.m557recordmLhObY(HitTestResultKt.requireLayoutNode(hazeEffectNode).density, (LayoutDirection) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalLayoutDirection), r1.size, new RenderScriptBlurEffect$updateSurface$2$4((byte) 0, r1));
                            r7 = i3;
                            r9 = str2;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        DatabaseDao_Impl.AnonymousClass17.endAsyncSection(0, str);
                        throw th;
                    }
                } else {
                    if (i7 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    int i10 = anonymousClass1.I$2;
                    str3 = anonymousClass1.L$7;
                    renderScriptContext = anonymousClass1.L$4;
                    String str6 = anonymousClass1.L$2;
                    try {
                        ResultKt.throwOnFailure(obj);
                        r2 = i10;
                        anonymousClass1 = str6;
                        DatabaseDao_Impl.AnonymousClass17.endAsyncSection(0, str3);
                        Trace.beginSection(DatabaseDao_Impl.AnonymousClass17.truncatedTraceSectionLabel("Haze-RenderScriptBlurEffect-updateSurface-drawToContentLayer"));
                        try {
                            Bitmap bitmap3 = renderScriptContext.outputBitmap;
                            this.contentLayer.m557recordmLhObY(HitTestResultKt.requireLayoutNode(hazeEffectNode).density, (LayoutDirection) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalLayoutDirection), (((long) bitmap3.getWidth()) << 32) | (((long) bitmap3.getHeight()) & 4294967295L), new RenderScriptBlurEffect$updateSurface$2$4((byte) 22, bitmap3));
                            Trace.endSection();
                            r7 = r2;
                            r9 = anonymousClass1;
                        } catch (Throwable th5) {
                            Trace.endSection();
                            throw th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        DatabaseDao_Impl.AnonymousClass17.endAsyncSection(0, str3);
                        throw th;
                    }
                }
                DatabaseDao_Impl.AnonymousClass17.endAsyncSection(r7, r9);
                return unit;
            } catch (Throwable th7) {
                th = th7;
                r10 = r2;
                r11 = anonymousClass1;
            }
        } catch (Throwable th8) {
            th = th8;
            r10 = 1;
        }
    }
}
