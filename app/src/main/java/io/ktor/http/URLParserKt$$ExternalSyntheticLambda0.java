package io.ktor.http;

import _COROUTINE.ArtificialStackFramesUnsafe;
import android.os.Trace;
import androidx.collection.LruCache;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import coil3.util.LifecyclesKt;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.constants.AudioQuality;
import com.metrolist.music.constants.LoudnessLevel;
import com.metrolist.music.constants.QuickPicks;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda1;
import com.metrolist.music.ui.utils.AppBarKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.HazeEffectNode;
import dev.chrisbanes.haze.HazeEffectNodeKt;
import dev.chrisbanes.haze.RenderEffectBlurEffect;
import dev.chrisbanes.haze.RenderEffectParams;
import dev.chrisbanes.haze.RenderEffect_androidKt;
import io.ktor.client.plugins.compression.ContentEncodingKt;
import java.net.Proxy;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatRange;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.flow.internal.SafeCollector;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class URLParserKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ URLParserKt$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0045 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x004c  */
    /* JADX WARN: Code duplicated, block: B:8:0x0030  */
    /* JADX WARN: Instruction removed from duplicated block: B:21:0x004c, please report this as an issue */
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
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        byte b = this.$r8$classId;
        RenderEffect renderEffect = null;
        Job job = null;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$0;
        switch (b) {
            case 0:
                return URLParserKt.parseQuery$lambda$1((URLBuilder) obj3, (String) obj, (List) obj2);
            case 1:
                Proxy.Type type = (Proxy.Type) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(type.name(), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 2:
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) obj3;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterVertically, gapComposer2, 54);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierFillMaxWidth);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    TextKt.m352TextNvy7gAk(String.valueOf((int) parcelableSnapshotMutableFloatState.getFloatValue()), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262142);
                    float floatValue = parcelableSnapshotMutableFloatState.getFloatValue();
                    boolean zChanged = gapComposer2.changed(parcelableSnapshotMutableFloatState);
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new PlayerKt$$ExternalSyntheticLambda1(parcelableSnapshotMutableFloatState, (byte) 11);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    SliderKt.Slider(floatValue, (Function1) objRememberedValue, null, false, new ClosedFloatRange(1.0f, 100.0f), 98, null, null, gapComposer2, 196608, 460);
                    gapComposer2.end(true);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 3:
                AddToPlaylistPosition addToPlaylistPosition = (AddToPlaylistPosition) obj3;
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    int iOrdinal = addToPlaylistPosition.ordinal();
                    if (iOrdinal == 0) {
                        i = 1105381977;
                        i2 = R.string.playlist_position_beginning;
                    } else {
                        if (iOrdinal != 1) {
                            throw Format$$ExternalSyntheticOutline0.m(gapComposer3, 1105379077, false);
                        }
                        i = 1105385619;
                        i2 = R.string.playlist_position_end;
                    }
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer3, i, i2, gapComposer3, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 4:
                QuickPicks quickPicks = (QuickPicks) obj3;
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    int iOrdinal2 = quickPicks.ordinal();
                    if (iOrdinal2 == 0) {
                        i3 = 698104422;
                        i4 = R.string.quick_picks;
                    } else {
                        if (iOrdinal2 != 1) {
                            throw Format$$ExternalSyntheticOutline0.m(gapComposer4, 698102136, false);
                        }
                        i3 = 698107469;
                        i4 = R.string.last_song_listened;
                    }
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer4, i3, i4, gapComposer4, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262142);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 5:
                LoudnessLevel loudnessLevel = (LoudnessLevel) obj3;
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(AppBarKt.getLoudnessLevelLabel(loudnessLevel, gapComposer5), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262142);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 6:
                AudioQuality audioQuality = (AudioQuality) obj3;
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    int iOrdinal3 = audioQuality.ordinal();
                    if (iOrdinal3 == 0) {
                        i5 = -26428658;
                        i6 = R.string.audio_quality_auto;
                    } else if (iOrdinal3 == 1) {
                        i5 = -26422483;
                        i6 = R.string.audio_quality_low;
                    } else {
                        if (iOrdinal3 != 2) {
                            throw Format$$ExternalSyntheticOutline0.m(gapComposer6, -26430761, false);
                        }
                        i5 = -26425554;
                        i6 = R.string.audio_quality_high;
                    }
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer6, i5, i6, gapComposer6, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 0, 0, 262142);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 7:
                float fFloatValue = ((Float) obj).floatValue();
                ((Float) obj2).floatValue();
                ((TopAppBarState) obj3).setHeightOffset(fFloatValue);
                return unit;
            case 8:
                RenderEffectBlurEffect renderEffectBlurEffect = (RenderEffectBlurEffect) obj3;
                DrawScope drawScope = (DrawScope) obj;
                GraphicsLayer graphicsLayer = (GraphicsLayer) obj2;
                drawScope.getClass();
                graphicsLayer.getClass();
                HazeEffectNode hazeEffectNode = renderEffectBlurEffect.node;
                RenderEffect renderEffect2 = renderEffectBlurEffect.renderEffect;
                if (renderEffect2 == null || (hazeEffectNode.dirtyTracker & 907003) != 0) {
                    float fM1544calculateInputScaleFactor3ABfNKs$default = HazeEffectNodeKt.m1544calculateInputScaleFactor3ABfNKs$default(hazeEffectNode);
                    float fResolveBlurRadius = HazeEffectNodeKt.resolveBlurRadius(hazeEffectNode);
                    if (Float.isNaN(fResolveBlurRadius)) {
                        fResolveBlurRadius = CropImageView.DEFAULT_ASPECT_RATIO;
                    }
                    float f = fResolveBlurRadius;
                    float fResolveNoiseFactor = HazeEffectNodeKt.resolveNoiseFactor(hazeEffectNode);
                    List listResolveTints = HazeEffectNodeKt.resolveTints(hazeEffectNode);
                    long j = hazeEffectNode.size;
                    long j2 = hazeEffectNode.layerOffset;
                    int i7 = Intrinsics.areEqual(hazeEffectNode.blurredEdgeTreatment, (Object) null) ? 3 : 0;
                    Trace.beginSection(DatabaseDao_Impl.AnonymousClass17.truncatedTraceSectionLabel("HazeEffectNode-getOrCreateRenderEffect"));
                    try {
                        RenderEffectParams renderEffectParams = new RenderEffectParams(f, fResolveNoiseFactor, fM1544calculateInputScaleFactor3ABfNKs$default, j, j2, listResolveTints, 1.0f, null, i7);
                        Lazy lazy = HazeEffectNodeKt.renderEffectCache$delegate;
                        RenderEffect renderEffectCreateRenderEffect = (RenderEffect) ((LruCache) lazy.getValue()).get(renderEffectParams);
                        if (renderEffectCreateRenderEffect == null) {
                            renderEffectCreateRenderEffect = RenderEffect_androidKt.createRenderEffect(hazeEffectNode, renderEffectParams);
                            if (renderEffectCreateRenderEffect != null) {
                                ((LruCache) lazy.getValue()).put(renderEffectParams, renderEffectCreateRenderEffect);
                                renderEffect = renderEffectCreateRenderEffect;
                            }
                        } else {
                            renderEffect = renderEffectCreateRenderEffect;
                        }
                        Trace.endSection();
                        renderEffectBlurEffect.renderEffect = renderEffect;
                        renderEffect2 = renderEffect;
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                }
                GraphicsLayerImpl graphicsLayerImpl = graphicsLayer.impl;
                if (!Intrinsics.areEqual(graphicsLayerImpl.getRenderEffect(), renderEffect2)) {
                    graphicsLayerImpl.setRenderEffect(renderEffect2);
                }
                graphicsLayer.setAlpha(hazeEffectNode.alpha);
                LifecyclesKt.drawLayer(drawScope, graphicsLayer);
                return unit;
            case 9:
                return ContentEncodingKt.ContentEncoding$lambda$0$decode$4$0((HeadersBuilder) obj3, (String) obj, (List) obj2);
            case 10:
                CharSequence charSequence = (CharSequence) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                charSequence.getClass();
                int iIndexOfAny = StringsKt.indexOfAny(charSequence, (char[]) obj3, iIntValue7, false);
                if (iIndexOfAny < 0) {
                    return null;
                }
                return new Pair(Integer.valueOf(iIndexOfAny), 1);
            default:
                int iIntValue8 = ((Integer) obj).intValue();
                CoroutineContext.Element element = (CoroutineContext.Element) obj2;
                CoroutineContext.Key key = element.getKey();
                CoroutineContext.Element element2 = ((SafeCollector) obj3).collectContext.get(key);
                if (key == Job.Key.$$INSTANCE) {
                    Job job2 = (Job) element2;
                    Job parent = (Job) element;
                    while (parent != null) {
                        if (parent != job2 && (parent instanceof ScopeCoroutine)) {
                            ChildHandle childHandle = (ChildHandle) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile((ScopeCoroutine) parent, JobSupport._parentHandle$volatile$FU$offset);
                            parent = childHandle != null ? childHandle.getParent() : null;
                        } else {
                            job = parent;
                            if (job == job2) {
                                throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + job + ", expected child of " + job2 + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
                            }
                            if (job2 != null) {
                                iIntValue8++;
                            }
                        }
                    }
                    if (job == job2) {
                        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + job + ", expected child of " + job2 + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
                    }
                    if (job2 != null) {
                        iIntValue8++;
                    }
                } else if (element != element2) {
                    iIntValue8 = Integer.MIN_VALUE;
                } else {
                    iIntValue8++;
                }
                return Integer.valueOf(iIntValue8);
        }
    }
}
