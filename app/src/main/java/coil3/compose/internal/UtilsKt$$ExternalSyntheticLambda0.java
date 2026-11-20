package coil3.compose.internal;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.animation.EnterExitState;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.animation.ScaleConfig;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.contextmenu.ContextMenuPopupPositionProviderKt;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.gestures.ContentInViewNode;
import androidx.compose.foundation.gestures.DefaultDraggableState;
import androidx.compose.foundation.gestures.DefaultFlingBehavior;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableKt$NoOpOnDragStarted$1;
import androidx.compose.foundation.gestures.DraggableNode;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollingLogic;
import androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1;
import androidx.compose.foundation.gestures.UpdatableAnimationState;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.TextFieldKeyInput;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuKeys;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28;
import androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28$textClassificationItem$2$1;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager$contextMenuAreaModifier$3;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.SliderState;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.material3.SliderState$dragScope$1;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.material3.internal.AnchoredDraggableUninitializedException;
import androidx.compose.material3.internal.DraggableAnchorsNode;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.saveable.SaveableStateRegistryWrapper;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda5;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint_androidKt;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.ViewFactoryHolder;
import androidx.core.provider.CallbackWrapper;
import androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda0;
import androidx.emoji2.text.EmojiProcessor;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LifecycleStartStopEffectScope;
import androidx.media3.session.MediaSessionImpl$1;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.compose.DialogNavigator;
import androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda3;
import coil3.RealImageLoader;
import coil3.compose.AsyncImagePainter;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil3.request.ErrorResult;
import coil3.request.NullRequestDataException;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertube.YouTube$$ExternalSyntheticLambda2;
import com.metrolist.innertubex.InnerTube;
import com.metrolist.innertubex.extraction.YtConfigParserImpl;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda49;
import com.metrolist.music.ui.screens.settings.AboutScreenKt$DevBannerVideo$lambda$1$0$$inlined$onDispose$1;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.utils.CacheControl;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.network.sockets.DatagramKt;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlin.reflect.KProperty;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.time.InstantJvmKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class UtilsKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ UtilsKt$$ExternalSyntheticLambda0(boolean z, String str, String str2, String str3, FocusRequester focusRequester, PlayerKt$$ExternalSyntheticLambda49 playerKt$$ExternalSyntheticLambda49, SoftwareKeyboardController softwareKeyboardController) {
        this.$r8$classId = (byte) 14;
        this.f$0 = focusRequester;
        this.f$1 = playerKt$$ExternalSyntheticLambda49;
        this.f$2 = softwareKeyboardController;
    }

    private final Object invoke$androidx$compose$material3$internal$DraggableAnchorsNode$$ExternalSyntheticLambda0(Object obj) throws AnchoredDraggableUninitializedException {
        MeasureScope measureScope = (MeasureScope) this.f$0;
        DraggableAnchorsNode draggableAnchorsNode = (DraggableAnchorsNode) this.f$1;
        Placeable placeable = (Placeable) this.f$2;
        Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
        boolean zIsLookingAhead = measureScope.isLookingAhead();
        NodeChain nodeChain = draggableAnchorsNode.state;
        float fPositionOf = zIsLookingAhead ? nodeChain.getAnchors().positionOf(((DerivedSnapshotState) draggableAnchorsNode.state.tail).getValue()) : ((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue();
        boolean zIsLookingAhead2 = measureScope.isLookingAhead();
        if (Float.isNaN(fPositionOf)) {
            throw new AnchoredDraggableUninitializedException(zIsLookingAhead2, draggableAnchorsNode.didInitializeAnchors, draggableAnchorsNode.state.getAnchors(), ((DerivedSnapshotState) draggableAnchorsNode.state.tail).getValue());
        }
        LayoutDirection layoutDirection = HitTestResultKt.requireLayoutNode(draggableAnchorsNode).layoutDirection;
        LayoutDirection layoutDirection2 = LayoutDirection.Rtl;
        Orientation orientation = Orientation.Horizontal;
        float f = (layoutDirection == layoutDirection2 && draggableAnchorsNode.orientation == orientation) ? -1.0f : 1.0f;
        Orientation orientation2 = draggableAnchorsNode.orientation;
        float f2 = orientation2 == orientation ? f * fPositionOf : 0.0f;
        if (orientation2 != Orientation.Vertical) {
            fPositionOf = 0.0f;
        }
        placementScope.motionFrameOfReferencePlacement = true;
        placementScope.place(placeable, MathKt.roundToInt(f2), MathKt.roundToInt(fPositionOf), CropImageView.DEFAULT_ASPECT_RATIO);
        placementScope.motionFrameOfReferencePlacement = false;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x006f A[LOOP:0: B:11:0x002b->B:24:0x006f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:32:0x0084 A[EDGE_INSN: B:32:0x0084->B:29:0x0084 BREAK  A[LOOP:0: B:11:0x002b->B:24:0x006f], SYNTHETIC] */
    private final Object invoke$androidx$compose$runtime$MultiSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda2(Object obj) {
        Object obj2;
        Set set = (Set) this.f$0;
        MultiSubscriptionSnapshotFlowManager multiSubscriptionSnapshotFlowManager = (MultiSubscriptionSnapshotFlowManager) this.f$1;
        Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) this.f$2;
        if (set.contains(obj) && (obj2 = multiSubscriptionSnapshotFlowManager.subscriptions.get(obj)) != null) {
            if (obj2 instanceof MutableScatterSet) {
                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                Object[] objArr = mutableScatterSet.elements;
                long[] jArr = mutableScatterSet.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                            if (i != length) {
                                break;
                                break;
                            }
                            i++;
                        } else {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128) {
                                    SendChannel sendChannel = (SendChannel) objArr[(i << 3) + i3];
                                    Object arrayList = ref$ObjectRef.element;
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                        ref$ObjectRef.element = arrayList;
                                    }
                                    ((List) arrayList).add(sendChannel);
                                }
                                j >>= 8;
                            }
                            if (i2 != 8) {
                                break;
                            }
                            if (i != length) {
                                break;
                            }
                            i++;
                        }
                    }
                }
            } else {
                SendChannel sendChannel2 = (SendChannel) obj2;
                Object arrayList2 = ref$ObjectRef.element;
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    ref$ObjectRef.element = arrayList2;
                }
                ((List) arrayList2).add(sendChannel2);
            }
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$androidx$compose$ui$node$LayoutNodeDrawScope$$ExternalSyntheticLambda0(Object obj) throws Throwable {
        DrawModifierNode drawModifierNode;
        LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) this.f$0;
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        DrawModifierNode drawModifierNode2 = (DrawModifierNode) this.f$1;
        Function1 function1 = (Function1) this.f$2;
        DrawScope drawScope = (DrawScope) obj;
        DrawModifierNode drawModifierNode3 = layoutNodeDrawScope.drawNode;
        layoutNodeDrawScope.drawNode = drawModifierNode2;
        try {
            Density density = drawScope.getDrawContext().getDensity();
            LayoutDirection layoutDirection = drawScope.getDrawContext().getLayoutDirection();
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            long jM831getSizeNHjbRc = drawScope.getDrawContext().m831getSizeNHjbRc();
            GraphicsLayer graphicsLayer = (GraphicsLayer) drawScope.getDrawContext().mMetadataRepo;
            Density density2 = canvasDrawScope.drawContext.getDensity();
            LayoutDirection layoutDirection2 = canvasDrawScope.drawContext.getLayoutDirection();
            Canvas canvas2 = canvasDrawScope.drawContext.getCanvas();
            long jM831getSizeNHjbRc2 = canvasDrawScope.drawContext.m831getSizeNHjbRc();
            EmojiProcessor emojiProcessor = canvasDrawScope.drawContext;
            try {
                GraphicsLayer graphicsLayer2 = (GraphicsLayer) emojiProcessor.mMetadataRepo;
                emojiProcessor.setDensity(density);
                emojiProcessor.setLayoutDirection(layoutDirection);
                emojiProcessor.setCanvas(canvas);
                emojiProcessor.m832setSizeuvyYCjk(jM831getSizeNHjbRc);
                emojiProcessor.mMetadataRepo = graphicsLayer;
                canvas.save();
                try {
                    function1.invoke(layoutNodeDrawScope);
                    canvas.restore();
                    EmojiProcessor emojiProcessor2 = canvasDrawScope.drawContext;
                    emojiProcessor2.setDensity(density2);
                    emojiProcessor2.setLayoutDirection(layoutDirection2);
                    emojiProcessor2.setCanvas(canvas2);
                    emojiProcessor2.m832setSizeuvyYCjk(jM831getSizeNHjbRc2);
                    emojiProcessor2.mMetadataRepo = graphicsLayer2;
                    layoutNodeDrawScope.drawNode = drawModifierNode3;
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    drawModifierNode = drawModifierNode3;
                    try {
                        canvas.restore();
                        EmojiProcessor emojiProcessor3 = canvasDrawScope.drawContext;
                        emojiProcessor3.setDensity(density2);
                        emojiProcessor3.setLayoutDirection(layoutDirection2);
                        emojiProcessor3.setCanvas(canvas2);
                        emojiProcessor3.m832setSizeuvyYCjk(jM831getSizeNHjbRc2);
                        emojiProcessor3.mMetadataRepo = graphicsLayer2;
                        throw th;
                    } catch (Throwable th2) {
                        th = th2;
                        layoutNodeDrawScope.drawNode = drawModifierNode;
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                drawModifierNode = drawModifierNode3;
            }
        } catch (Throwable th4) {
            th = th4;
            drawModifierNode = drawModifierNode3;
        }
    }

    private final Object invoke$androidx$compose$ui$viewinterop$AndroidViewHolder$$ExternalSyntheticLambda10(Object obj) {
        ViewFactoryHolder viewFactoryHolder = (ViewFactoryHolder) this.f$0;
        LayoutNode layoutNode = (LayoutNode) this.f$1;
        ViewFactoryHolder viewFactoryHolder2 = (ViewFactoryHolder) this.f$2;
        Canvas canvas = ((DrawScope) obj).getDrawContext().getCanvas();
        if (viewFactoryHolder.view.getVisibility() != 8) {
            viewFactoryHolder.isDrawing = true;
            Owner owner = layoutNode.owner;
            AndroidComposeView androidComposeView = owner instanceof AndroidComposeView ? (AndroidComposeView) owner : null;
            if (androidComposeView != null) {
                android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
                if (androidComposeView._androidViewsHandler != null) {
                    viewFactoryHolder2.draw(nativeCanvas);
                }
            }
            viewFactoryHolder.isDrawing = false;
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$androidx$lifecycle$compose$LifecycleEffectKt$$ExternalSyntheticLambda1(Object obj) {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this.f$0;
        LifecycleStartStopEffectScope lifecycleStartStopEffectScope = (LifecycleStartStopEffectScope) this.f$1;
        Function1 function1 = (Function1) this.f$2;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        MenuHostHelper$$ExternalSyntheticLambda0 menuHostHelper$$ExternalSyntheticLambda0 = new MenuHostHelper$$ExternalSyntheticLambda0(lifecycleStartStopEffectScope, ref$ObjectRef, function1, (byte) 1);
        lifecycleOwner.getLifecycle().addObserver(menuHostHelper$$ExternalSyntheticLambda0);
        return new AboutScreenKt$DevBannerVideo$lambda$1$0$$inlined$onDispose$1(lifecycleOwner, menuHostHelper$$ExternalSyntheticLambda0, ref$ObjectRef, (byte) 4);
    }

    private final Object invoke$androidx$navigation$compose$DialogHostKt$DialogHost$1$2$$ExternalSyntheticLambda0(Object obj) {
        SnapshotStateList snapshotStateList = (SnapshotStateList) this.f$0;
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.f$1;
        DialogNavigator dialogNavigator = (DialogNavigator) this.f$2;
        snapshotStateList.add(navBackStackEntry);
        return new AboutScreenKt$DevBannerVideo$lambda$1$0$$inlined$onDispose$1(dialogNavigator, navBackStackEntry, snapshotStateList, (byte) 5);
    }

    private final Object invoke$com$metrolist$innertubex$InnerTube$registerStatsWithSession$2$1$$ExternalSyntheticLambda0(Object obj) throws NoSuchAlgorithmException {
        String str;
        YouTubeClient youTubeClient = (YouTubeClient) this.f$0;
        String str2 = (String) this.f$1;
        InnerTube.SessionSnapshot sessionSnapshot = (InnerTube.SessionSnapshot) this.f$2;
        HeadersBuilder headersBuilder = (HeadersBuilder) obj;
        headersBuilder.append("X-Goog-Api-Format-Version", "1");
        headersBuilder.append("X-YouTube-Client-Name", youTubeClient.clientId);
        headersBuilder.append("X-YouTube-Client-Version", youTubeClient.clientVersion);
        headersBuilder.append(HttpHeaders.Origin, str2);
        headersBuilder.append("X-Origin", str2);
        headersBuilder.append(HttpHeaders.Referrer, Intrinsics.areEqual(youTubeClient.clientName, "WEB_REMIX") ? "https://music.youtube.com/" : "https://www.youtube.com/");
        headersBuilder.append(HttpHeaders.AcceptLanguage, sessionSnapshot.locale.acceptLanguageHeader$com_github_MetrolistGroup_innertubex());
        headersBuilder.append(HttpHeaders.CacheControl, CacheControl.NO_CACHE);
        headersBuilder.append(HttpHeaders.ContentType, "application/json");
        String str3 = sessionSnapshot.visitorData;
        if (str3 != null) {
            headersBuilder.append("X-Goog-Visitor-Id", str3);
        }
        if (youTubeClient.loginSupported && (str = sessionSnapshot.cookie) != null) {
            headersBuilder.append(HttpHeaders.Cookie, str);
            headersBuilder.append("X-Goog-AuthUser", sessionSnapshot.authUser);
            String str4 = sessionSnapshot.sapisid;
            if (str4 != null && !StringsKt.isBlank(str4)) {
                long epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds() / 1000;
                String strSha1 = CharsKt.sha1(epochMilliseconds + ServerSentEventKt.SPACE + str4 + ServerSentEventKt.SPACE + str2);
                StringBuilder sb = new StringBuilder("SAPISIDHASH ");
                sb.append(epochMilliseconds);
                sb.append("_");
                sb.append(strSha1);
                headersBuilder.append(HttpHeaders.Authorization, sb.toString());
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:380:0x090f  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v111, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v22 */
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
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Throwable {
        TransformOrigin transformOrigin;
        Canvas canvas;
        AnnotatedString.Range range;
        Integer previousWordOffset;
        Integer nextWordOffset;
        Integer nextWordOffset2;
        Integer previousWordOffset2;
        TextLayoutResult textLayoutResult;
        TextLayoutResult textLayoutResult2;
        TextLayoutResultProxy textLayoutResultProxy;
        TextLayoutResultProxy textLayoutResultProxy2;
        TextLayoutResult textLayoutResult3;
        TextLayoutResult textLayoutResult4;
        TextLayoutResultProxy textLayoutResultProxy3;
        TextLayoutResultProxy textLayoutResultProxy4;
        Integer nextWordOffset3;
        Integer previousWordOffset3;
        Integer previousWordOffset4;
        Integer nextWordOffset4;
        CallbackWrapper callbackWrapper;
        TextFieldValue textFieldValue;
        boolean z;
        LegacyTextFieldState legacyTextFieldState;
        byte b = this.$r8$classId;
        byte b2 = 6;
        final byte b3 = 2;
        byte b4 = 3;
        ?? r11 = 0;
        TextFieldValue textFieldValue2 = null;
        r11 = 0;
        boolean zBooleanValue = false;
        Unit unit = Unit.INSTANCE;
        byte b5 = 1;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        switch (b) {
            case 0:
                Painter painter = (Painter) obj4;
                Painter painter2 = (Painter) obj3;
                Painter painter3 = (Painter) obj2;
                AsyncImagePainter.State state = (AsyncImagePainter.State) obj;
                if (state instanceof AsyncImagePainter.State.Loading) {
                    return painter != null ? new AsyncImagePainter.State.Loading(painter) : (AsyncImagePainter.State.Loading) state;
                }
                if (!(state instanceof AsyncImagePainter.State.Error)) {
                    return state;
                }
                AsyncImagePainter.State.Error error = (AsyncImagePainter.State.Error) state;
                ErrorResult errorResult = error.result;
                if (errorResult.throwable instanceof NullRequestDataException) {
                    return painter2 != null ? new AsyncImagePainter.State.Error(painter2, errorResult) : error;
                }
                return painter3 != null ? new AsyncImagePainter.State.Error(painter3, errorResult) : error;
            case 1:
                return new AboutScreenKt$DevBannerVideo$lambda$1$0$$inlined$onDispose$1((SnapshotStateList) obj4, obj3, (AnimatedContentTransitionScopeImpl) obj2, (byte) 1);
            case 2:
                TransformOrigin transformOrigin2 = (TransformOrigin) obj4;
                EnterTransitionImpl enterTransitionImpl = (EnterTransitionImpl) obj3;
                ExitTransitionImpl exitTransitionImpl = (ExitTransitionImpl) obj2;
                int iOrdinal = ((EnterExitState) obj).ordinal();
                if (iOrdinal == 0) {
                    ScaleConfig scaleConfig = enterTransitionImpl.config.scale;
                    if (scaleConfig != null) {
                        transformOrigin = new TransformOrigin(scaleConfig.transformOrigin);
                    } else {
                        ScaleConfig scaleConfig2 = exitTransitionImpl.config.scale;
                        transformOrigin = scaleConfig2 != null ? new TransformOrigin(scaleConfig2.transformOrigin) : null;
                    }
                } else if (iOrdinal == 1) {
                    transformOrigin = transformOrigin2;
                } else {
                    if (iOrdinal != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    ScaleConfig scaleConfig3 = exitTransitionImpl.config.scale;
                    transformOrigin = new TransformOrigin(scaleConfig3 != null ? scaleConfig3.transformOrigin : ColorKt.TransformOrigin(0.5f, 0.5f));
                }
                return new TransformOrigin(transformOrigin != null ? transformOrigin.packedValue : ColorKt.TransformOrigin(0.5f, 0.5f));
            case 3:
                ContentInViewNode contentInViewNode = (ContentInViewNode) obj4;
                Job job = (Job) obj3;
                ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1 = (ScrollingLogic$nestedScrollScope$1) obj2;
                float fFloatValue = ((Float) obj).floatValue();
                float f = contentInViewNode.reverseDirection ? 1.0f : -1.0f;
                ScrollingLogic scrollingLogic = contentInViewNode.scrollingLogic;
                long jM104reverseIfNeededMKHz9U = scrollingLogic.m104reverseIfNeededMKHz9U(scrollingLogic.m106toOffsettuRUvjQ(f * fFloatValue));
                ScrollingLogic scrollingLogic2 = scrollingLogic$nestedScrollScope$1.this$0;
                float fM105toFloatk4lQ0M = scrollingLogic.m105toFloatk4lQ0M(scrollingLogic.m104reverseIfNeededMKHz9U(scrollingLogic2.m103performScroll3eAAhYA(scrollingLogic2.outerStateScope, jM104reverseIfNeededMKHz9U, 1))) * f;
                if (Math.abs(fM105toFloatk4lQ0M) < Math.abs(fFloatValue)) {
                    job.cancel(AwaitKt.CancellationException("Scroll animation cancelled because scroll was not consumed (" + fM105toFloatk4lQ0M + " < " + fFloatValue + ")", null));
                }
                return unit;
            case 4:
                Ref$FloatRef ref$FloatRef = (Ref$FloatRef) obj4;
                AnimationScope animationScope = (AnimationScope) obj;
                float fFloatValue2 = ((Number) animationScope.value$delegate.getValue()).floatValue() - ref$FloatRef.element;
                float fScrollBy = ((ScrollScope) obj3).scrollBy(fFloatValue2);
                ref$FloatRef.element = ((Number) animationScope.value$delegate.getValue()).floatValue();
                ((Ref$FloatRef) obj2).element = ((Number) animationScope.typeConverter.convertFromVector.invoke(animationScope.velocityVector)).floatValue();
                if (Math.abs(fFloatValue2 - fScrollBy) > 0.5f) {
                    animationScope.cancelAnimation();
                }
                return unit;
            case 5:
                SliderState$dragScope$1 sliderState$dragScope$1 = (SliderState$dragScope$1) obj4;
                Orientation orientation = (Orientation) obj2;
                long j = ((DragEvent.DragDelta) obj).delta;
                long jM440timestuRUvjQ = ((DraggableNode) obj3).reverseDirection ? Offset.m440timestuRUvjQ(j, -1.0f) : Offset.m440timestuRUvjQ(j, 1.0f);
                DraggableKt$NoOpOnDragStarted$1 draggableKt$NoOpOnDragStarted$1 = DraggableKt.NoOpOnDragStarted;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (orientation == Orientation.Vertical ? jM440timestuRUvjQ & 4294967295L : jM440timestuRUvjQ >> 32));
                switch (sliderState$dragScope$1.$r8$classId) {
                    case 0:
                        ((SliderState) sliderState$dragScope$1.this$0).dispatchRawDeltaInternal$material3(fIntBitsToFloat);
                        return unit;
                    default:
                        ((DefaultDraggableState) sliderState$dragScope$1.this$0).onDelta.invoke(Float.valueOf(fIntBitsToFloat));
                        return unit;
                }
            case 6:
                Function1 function1 = (Function1) obj4;
                MutableState mutableState = (MutableState) obj2;
                TextFieldValue textFieldValue3 = (TextFieldValue) obj;
                ((MutableState) obj3).setValue(textFieldValue3);
                boolean zAreEqual = Intrinsics.areEqual((String) mutableState.getValue(), textFieldValue3.annotatedString.text);
                AnnotatedString annotatedString = textFieldValue3.annotatedString;
                mutableState.setValue(annotatedString.text);
                if (!zAreEqual) {
                    function1.invoke(annotatedString.text);
                }
                return unit;
            case 7:
                LegacyTextFieldState legacyTextFieldState2 = (LegacyTextFieldState) obj4;
                TextFieldValue textFieldValue4 = (TextFieldValue) obj3;
                OffsetMapping offsetMapping = (OffsetMapping) obj2;
                DrawScope drawScope = (DrawScope) obj;
                TextLayoutResultProxy layoutResult = legacyTextFieldState2.getLayoutResult();
                if (layoutResult != null) {
                    Canvas canvas2 = drawScope.getDrawContext().getCanvas();
                    long j2 = ((TextRange) legacyTextFieldState2.selectionPreviewHighlightRange$delegate.getValue()).packedValue;
                    long j3 = ((TextRange) legacyTextFieldState2.deletionPreviewHighlightRange$delegate.getValue()).packedValue;
                    TextLayoutResult textLayoutResult5 = layoutResult.value;
                    MultiParagraph multiParagraph = textLayoutResult5.multiParagraph;
                    TextLayoutInput textLayoutInput = textLayoutResult5.layoutInput;
                    AndroidPaint androidPaint = legacyTextFieldState2.highlightPaint;
                    long j4 = legacyTextFieldState2.selectionBackgroundColor;
                    if (!TextRange.m741getCollapsedimpl(j2)) {
                        androidPaint.m464setColor8_81llA(j4);
                        int iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m744getMinimpl(j2));
                        int iOriginalToTransformed2 = offsetMapping.originalToTransformed(TextRange.m743getMaximpl(j2));
                        if (iOriginalToTransformed != iOriginalToTransformed2) {
                            canvas2.drawPath(textLayoutResult5.getPathForRange(iOriginalToTransformed, iOriginalToTransformed2), androidPaint);
                        }
                    } else if (!TextRange.m741getCollapsedimpl(j3)) {
                        long jM752getColor0d7_KjU = textLayoutInput.style.m752getColor0d7_KjU();
                        Color color = jM752getColor0d7_KjU == 16 ? null : new Color(jM752getColor0d7_KjU);
                        long j5 = color != null ? color.value : -72057594037927936L;
                        androidPaint.m464setColor8_81llA(ColorKt.Color(Color.m485getRedimpl(j5), Color.m484getGreenimpl(j5), Color.m482getBlueimpl(j5), Color.m481getAlphaimpl(j5) * 0.2f, Color.m483getColorSpaceimpl(j5)));
                        int iOriginalToTransformed3 = offsetMapping.originalToTransformed(TextRange.m744getMinimpl(j3));
                        int iOriginalToTransformed4 = offsetMapping.originalToTransformed(TextRange.m743getMaximpl(j3));
                        if (iOriginalToTransformed3 != iOriginalToTransformed4) {
                            canvas2.drawPath(textLayoutResult5.getPathForRange(iOriginalToTransformed3, iOriginalToTransformed4), androidPaint);
                        }
                    } else if (!TextRange.m741getCollapsedimpl(textFieldValue4.selection)) {
                        androidPaint.m464setColor8_81llA(j4);
                        long j6 = textFieldValue4.selection;
                        int iOriginalToTransformed5 = offsetMapping.originalToTransformed(TextRange.m744getMinimpl(j6));
                        int iOriginalToTransformed6 = offsetMapping.originalToTransformed(TextRange.m743getMaximpl(j6));
                        if (iOriginalToTransformed5 != iOriginalToTransformed6) {
                            canvas2.drawPath(textLayoutResult5.getPathForRange(iOriginalToTransformed5, iOriginalToTransformed6), androidPaint);
                        }
                    }
                    boolean z2 = textLayoutResult5.getHasVisualOverflow() && textLayoutInput.overflow != 3;
                    if (z2) {
                        long j7 = textLayoutResult5.size;
                        Rect rectM896Recttz77jQw = IntMath.m896Recttz77jQw(0L, (((long) Float.floatToRawIntBits((int) (j7 & 4294967295L))) & 4294967295L) | (((long) Float.floatToRawIntBits((int) (j7 >> 32))) << 32));
                        canvas2.save();
                        canvas2.mo453clipRectN_I0leg(rectM896Recttz77jQw.left, rectM896Recttz77jQw.top, rectM896Recttz77jQw.right, rectM896Recttz77jQw.bottom, 1);
                    }
                    SpanStyle spanStyle = textLayoutInput.style.spanStyle;
                    TextDecoration textDecoration = spanStyle.textDecoration;
                    TextForegroundStyle textForegroundStyle = spanStyle.textForegroundStyle;
                    if (textDecoration == null) {
                        textDecoration = TextDecoration.None;
                    }
                    TextDecoration textDecoration2 = textDecoration;
                    Shadow shadow = spanStyle.shadow;
                    if (shadow == null) {
                        shadow = Shadow.None;
                    }
                    DrawStyle drawStyle = spanStyle.drawStyle;
                    if (drawStyle == null) {
                        drawStyle = Fill.INSTANCE;
                    }
                    DrawStyle drawStyle2 = drawStyle;
                    try {
                        Brush brush = textForegroundStyle.getBrush();
                        TextForegroundStyle.Unspecified unspecified = TextForegroundStyle.Unspecified.INSTANCE;
                        try {
                            if (brush != null) {
                                canvas = canvas2;
                                AndroidTextPaint_androidKt.m766drawMultiParagraph7AXcY_I(multiParagraph, canvas, brush, textForegroundStyle != unspecified ? textForegroundStyle.getAlpha() : 1.0f, shadow, textDecoration2, drawStyle2);
                            } else {
                                canvas = canvas2;
                                multiParagraph.m731paintLG529CI(canvas, textForegroundStyle != unspecified ? textForegroundStyle.mo768getColor0d7_KjU() : -72057594037927936L, shadow, textDecoration2, drawStyle2);
                            }
                            if (z2) {
                                canvas.restore();
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (z2) {
                                canvas2.restore();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                return unit;
            case 8:
                Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) obj4;
                AnnotatedString.Range range2 = (AnnotatedString.Range) obj3;
                SpanStyle spanStyle2 = (SpanStyle) obj2;
                AnnotatedString.Range range3 = (AnnotatedString.Range) obj;
                if (ref$BooleanRef.element) {
                    Object obj5 = range3.item;
                    int i = range3.end;
                    int i2 = range3.start;
                    if ((obj5 instanceof SpanStyle) && i2 == range2.start && i == range2.end) {
                        if (spanStyle2 == null) {
                            spanStyle2 = new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, DatagramKt.MAX_DATAGRAM_SIZE);
                        }
                        range = new AnnotatedString.Range(i2, i, spanStyle2);
                    } else {
                        range = range3;
                    }
                } else {
                    range = range3;
                }
                ref$BooleanRef.element = range2.equals(range3);
                return range;
            case 9:
                Function1 function2 = (Function1) obj3;
                TextInputSession textInputSession = (TextInputSession) ((Ref$ObjectRef) obj2).element;
                TextFieldValue textFieldValueApply = ((CallbackWrapper) obj4).apply((List) obj);
                if (textInputSession != null) {
                    textInputSession.updateState(null, textFieldValueApply);
                }
                function2.invoke(textFieldValueApply);
                return unit;
            case 10:
                TextFieldKeyInput textFieldKeyInput = (TextFieldKeyInput) obj3;
                Ref$BooleanRef ref$BooleanRef2 = (Ref$BooleanRef) obj2;
                TextFieldPreparedSelection textFieldPreparedSelection = (TextFieldPreparedSelection) obj;
                byte b6 = 4;
                switch (((KeyCommand) obj4).ordinal()) {
                    case 0:
                        textFieldPreparedSelection.state.cachedX = null;
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0) {
                            if (TextRange.m741getCollapsedimpl(textFieldPreparedSelection.selection)) {
                                textFieldPreparedSelection.moveCursorLeft();
                            } else {
                                boolean zIsLtr = textFieldPreparedSelection.isLtr();
                                long j8 = textFieldPreparedSelection.selection;
                                if (zIsLtr) {
                                    int iM744getMinimpl = TextRange.m744getMinimpl(j8);
                                    textFieldPreparedSelection.setSelection(iM744getMinimpl, iM744getMinimpl);
                                } else {
                                    int iM743getMaximpl = TextRange.m743getMaximpl(j8);
                                    textFieldPreparedSelection.setSelection(iM743getMaximpl, iM743getMaximpl);
                                }
                            }
                        }
                        break;
                    case 1:
                        textFieldPreparedSelection.state.cachedX = null;
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0) {
                            if (TextRange.m741getCollapsedimpl(textFieldPreparedSelection.selection)) {
                                textFieldPreparedSelection.moveCursorRight();
                            } else {
                                boolean zIsLtr2 = textFieldPreparedSelection.isLtr();
                                long j9 = textFieldPreparedSelection.selection;
                                if (zIsLtr2) {
                                    int iM743getMaximpl2 = TextRange.m743getMaximpl(j9);
                                    textFieldPreparedSelection.setSelection(iM743getMaximpl2, iM743getMaximpl2);
                                } else {
                                    int iM744getMinimpl2 = TextRange.m744getMinimpl(j9);
                                    textFieldPreparedSelection.setSelection(iM744getMinimpl2, iM744getMinimpl2);
                                }
                            }
                        }
                        break;
                    case 2:
                        TextPreparedSelectionState textPreparedSelectionState = textFieldPreparedSelection.state;
                        textPreparedSelectionState.cachedX = null;
                        AnnotatedString annotatedString2 = textFieldPreparedSelection.annotatedString;
                        String str = annotatedString2.text;
                        String str2 = annotatedString2.text;
                        if (str.length() > 0) {
                            if (textFieldPreparedSelection.isLtr()) {
                                textPreparedSelectionState.cachedX = null;
                                if (str2.length() > 0 && (nextWordOffset = textFieldPreparedSelection.getNextWordOffset()) != null) {
                                    int iIntValue = nextWordOffset.intValue();
                                    textFieldPreparedSelection.setSelection(iIntValue, iIntValue);
                                }
                            } else {
                                textPreparedSelectionState.cachedX = null;
                                if (str2.length() > 0 && (previousWordOffset = textFieldPreparedSelection.getPreviousWordOffset()) != null) {
                                    int iIntValue2 = previousWordOffset.intValue();
                                    textFieldPreparedSelection.setSelection(iIntValue2, iIntValue2);
                                }
                            }
                        }
                        break;
                    case 3:
                        TextPreparedSelectionState textPreparedSelectionState2 = textFieldPreparedSelection.state;
                        textPreparedSelectionState2.cachedX = null;
                        AnnotatedString annotatedString3 = textFieldPreparedSelection.annotatedString;
                        String str3 = annotatedString3.text;
                        String str4 = annotatedString3.text;
                        if (str3.length() > 0) {
                            if (textFieldPreparedSelection.isLtr()) {
                                textPreparedSelectionState2.cachedX = null;
                                if (str4.length() > 0 && (previousWordOffset2 = textFieldPreparedSelection.getPreviousWordOffset()) != null) {
                                    int iIntValue3 = previousWordOffset2.intValue();
                                    textFieldPreparedSelection.setSelection(iIntValue3, iIntValue3);
                                }
                            } else {
                                textPreparedSelectionState2.cachedX = null;
                                if (str4.length() > 0 && (nextWordOffset2 = textFieldPreparedSelection.getNextWordOffset()) != null) {
                                    int iIntValue4 = nextWordOffset2.intValue();
                                    textFieldPreparedSelection.setSelection(iIntValue4, iIntValue4);
                                }
                            }
                        }
                        break;
                    case 4:
                        textFieldPreparedSelection.moveCursorNextByParagraph();
                        break;
                    case 5:
                        textFieldPreparedSelection.moveCursorPrevByParagraph();
                        break;
                    case 6:
                        textFieldPreparedSelection.moveCursorToLineStart();
                        break;
                    case 7:
                        textFieldPreparedSelection.moveCursorToLineEnd();
                        break;
                    case 8:
                        textFieldPreparedSelection.state.cachedX = null;
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0) {
                            if (textFieldPreparedSelection.isLtr()) {
                                textFieldPreparedSelection.moveCursorToLineStart();
                            } else {
                                textFieldPreparedSelection.moveCursorToLineEnd();
                            }
                        }
                        break;
                    case 9:
                        textFieldPreparedSelection.state.cachedX = null;
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0) {
                            if (textFieldPreparedSelection.isLtr()) {
                                textFieldPreparedSelection.moveCursorToLineEnd();
                            } else {
                                textFieldPreparedSelection.moveCursorToLineStart();
                            }
                        }
                        break;
                    case 10:
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0 && (textLayoutResult = textFieldPreparedSelection.layoutResult) != null) {
                            int iJumpByLinesOffset = textFieldPreparedSelection.jumpByLinesOffset(textLayoutResult, -1);
                            textFieldPreparedSelection.setSelection(iJumpByLinesOffset, iJumpByLinesOffset);
                        }
                        break;
                    case 11:
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0 && (textLayoutResult2 = textFieldPreparedSelection.layoutResult) != null) {
                            int iJumpByLinesOffset2 = textFieldPreparedSelection.jumpByLinesOffset(textLayoutResult2, 1);
                            textFieldPreparedSelection.setSelection(iJumpByLinesOffset2, iJumpByLinesOffset2);
                        }
                        break;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                    case 48:
                        break;
                    case 13:
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0 && (textLayoutResultProxy = textFieldPreparedSelection.layoutResultProxy) != null) {
                            int iJumpByPagesOffset = textFieldPreparedSelection.jumpByPagesOffset(textLayoutResultProxy, -1);
                            textFieldPreparedSelection.setSelection(iJumpByPagesOffset, iJumpByPagesOffset);
                        }
                        break;
                    case 14:
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0 && (textLayoutResultProxy2 = textFieldPreparedSelection.layoutResultProxy) != null) {
                            int iJumpByPagesOffset2 = textFieldPreparedSelection.jumpByPagesOffset(textLayoutResultProxy2, 1);
                            textFieldPreparedSelection.setSelection(iJumpByPagesOffset2, iJumpByPagesOffset2);
                        }
                        break;
                    case 15:
                        textFieldPreparedSelection.state.cachedX = null;
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0) {
                            textFieldPreparedSelection.setSelection(0, 0);
                        }
                        break;
                    case 16:
                        textFieldPreparedSelection.state.cachedX = null;
                        AnnotatedString annotatedString4 = textFieldPreparedSelection.annotatedString;
                        if (annotatedString4.text.length() > 0) {
                            int length = annotatedString4.text.length();
                            textFieldPreparedSelection.setSelection(length, length);
                        }
                        break;
                    case 17:
                        textFieldKeyInput.selectionManager.copy$foundation(false);
                        break;
                    case 18:
                        textFieldKeyInput.selectionManager.paste$foundation();
                        break;
                    case 19:
                        textFieldKeyInput.selectionManager.cut$foundation();
                        break;
                    case 20:
                        List listDeleteIfSelectedOr = textFieldPreparedSelection.deleteIfSelectedOr(new ChipKt$$ExternalSyntheticLambda3((byte) 1));
                        if (listDeleteIfSelectedOr != null) {
                            textFieldKeyInput.apply(listDeleteIfSelectedOr);
                        }
                        break;
                    case 21:
                        List listDeleteIfSelectedOr2 = textFieldPreparedSelection.deleteIfSelectedOr(new ChipKt$$ExternalSyntheticLambda3(b3));
                        if (listDeleteIfSelectedOr2 != null) {
                            textFieldKeyInput.apply(listDeleteIfSelectedOr2);
                        }
                        break;
                    case 22:
                        List listDeleteIfSelectedOr3 = textFieldPreparedSelection.deleteIfSelectedOr(new ChipKt$$ExternalSyntheticLambda3(b4));
                        if (listDeleteIfSelectedOr3 != null) {
                            textFieldKeyInput.apply(listDeleteIfSelectedOr3);
                        }
                        break;
                    case 23:
                        List listDeleteIfSelectedOr4 = textFieldPreparedSelection.deleteIfSelectedOr(new ChipKt$$ExternalSyntheticLambda3(b6));
                        if (listDeleteIfSelectedOr4 != null) {
                            textFieldKeyInput.apply(listDeleteIfSelectedOr4);
                        }
                        break;
                    case 24:
                        List listDeleteIfSelectedOr5 = textFieldPreparedSelection.deleteIfSelectedOr(new ChipKt$$ExternalSyntheticLambda3((byte) 5));
                        if (listDeleteIfSelectedOr5 != null) {
                            textFieldKeyInput.apply(listDeleteIfSelectedOr5);
                        }
                        break;
                    case 25:
                        List listDeleteIfSelectedOr6 = textFieldPreparedSelection.deleteIfSelectedOr(new ChipKt$$ExternalSyntheticLambda3(b2));
                        if (listDeleteIfSelectedOr6 != null) {
                            textFieldKeyInput.apply(listDeleteIfSelectedOr6);
                        }
                        break;
                    case 26:
                        textFieldPreparedSelection.state.cachedX = null;
                        AnnotatedString annotatedString5 = textFieldPreparedSelection.annotatedString;
                        if (annotatedString5.text.length() > 0) {
                            textFieldPreparedSelection.setSelection(0, annotatedString5.text.length());
                        }
                        break;
                    case 27:
                        textFieldPreparedSelection.moveCursorLeft();
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 28:
                        textFieldPreparedSelection.moveCursorRight();
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 29:
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0 && (textLayoutResult3 = textFieldPreparedSelection.layoutResult) != null) {
                            int iJumpByLinesOffset3 = textFieldPreparedSelection.jumpByLinesOffset(textLayoutResult3, -1);
                            textFieldPreparedSelection.setSelection(iJumpByLinesOffset3, iJumpByLinesOffset3);
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 30:
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0 && (textLayoutResult4 = textFieldPreparedSelection.layoutResult) != null) {
                            int iJumpByLinesOffset4 = textFieldPreparedSelection.jumpByLinesOffset(textLayoutResult4, 1);
                            textFieldPreparedSelection.setSelection(iJumpByLinesOffset4, iJumpByLinesOffset4);
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 31:
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0 && (textLayoutResultProxy3 = textFieldPreparedSelection.layoutResultProxy) != null) {
                            int iJumpByPagesOffset3 = textFieldPreparedSelection.jumpByPagesOffset(textLayoutResultProxy3, -1);
                            textFieldPreparedSelection.setSelection(iJumpByPagesOffset3, iJumpByPagesOffset3);
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 32:
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0 && (textLayoutResultProxy4 = textFieldPreparedSelection.layoutResultProxy) != null) {
                            int iJumpByPagesOffset4 = textFieldPreparedSelection.jumpByPagesOffset(textLayoutResultProxy4, 1);
                            textFieldPreparedSelection.setSelection(iJumpByPagesOffset4, iJumpByPagesOffset4);
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 33:
                        textFieldPreparedSelection.state.cachedX = null;
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0) {
                            textFieldPreparedSelection.setSelection(0, 0);
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 34:
                        textFieldPreparedSelection.state.cachedX = null;
                        AnnotatedString annotatedString6 = textFieldPreparedSelection.annotatedString;
                        if (annotatedString6.text.length() > 0) {
                            int length2 = annotatedString6.text.length();
                            textFieldPreparedSelection.setSelection(length2, length2);
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 35:
                        TextPreparedSelectionState textPreparedSelectionState3 = textFieldPreparedSelection.state;
                        textPreparedSelectionState3.cachedX = null;
                        AnnotatedString annotatedString7 = textFieldPreparedSelection.annotatedString;
                        String str5 = annotatedString7.text;
                        String str6 = annotatedString7.text;
                        if (str5.length() > 0) {
                            if (textFieldPreparedSelection.isLtr()) {
                                textPreparedSelectionState3.cachedX = null;
                                if (str6.length() > 0 && (previousWordOffset3 = textFieldPreparedSelection.getPreviousWordOffset()) != null) {
                                    int iIntValue5 = previousWordOffset3.intValue();
                                    textFieldPreparedSelection.setSelection(iIntValue5, iIntValue5);
                                }
                            } else {
                                textPreparedSelectionState3.cachedX = null;
                                if (str6.length() > 0 && (nextWordOffset3 = textFieldPreparedSelection.getNextWordOffset()) != null) {
                                    int iIntValue6 = nextWordOffset3.intValue();
                                    textFieldPreparedSelection.setSelection(iIntValue6, iIntValue6);
                                }
                            }
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 36:
                        TextPreparedSelectionState textPreparedSelectionState4 = textFieldPreparedSelection.state;
                        textPreparedSelectionState4.cachedX = null;
                        AnnotatedString annotatedString8 = textFieldPreparedSelection.annotatedString;
                        String str7 = annotatedString8.text;
                        String str8 = annotatedString8.text;
                        if (str7.length() > 0) {
                            if (textFieldPreparedSelection.isLtr()) {
                                textPreparedSelectionState4.cachedX = null;
                                if (str8.length() > 0 && (nextWordOffset4 = textFieldPreparedSelection.getNextWordOffset()) != null) {
                                    int iIntValue7 = nextWordOffset4.intValue();
                                    textFieldPreparedSelection.setSelection(iIntValue7, iIntValue7);
                                }
                            } else {
                                textPreparedSelectionState4.cachedX = null;
                                if (str8.length() > 0 && (previousWordOffset4 = textFieldPreparedSelection.getPreviousWordOffset()) != null) {
                                    int iIntValue8 = previousWordOffset4.intValue();
                                    textFieldPreparedSelection.setSelection(iIntValue8, iIntValue8);
                                }
                            }
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 37:
                        textFieldPreparedSelection.moveCursorNextByParagraph();
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 38:
                        textFieldPreparedSelection.moveCursorPrevByParagraph();
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 39:
                        textFieldPreparedSelection.moveCursorToLineStart();
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 40:
                        textFieldPreparedSelection.moveCursorToLineEnd();
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 41:
                        textFieldPreparedSelection.state.cachedX = null;
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0) {
                            if (textFieldPreparedSelection.isLtr()) {
                                textFieldPreparedSelection.moveCursorToLineStart();
                            } else {
                                textFieldPreparedSelection.moveCursorToLineEnd();
                            }
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 42:
                        textFieldPreparedSelection.state.cachedX = null;
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0) {
                            if (textFieldPreparedSelection.isLtr()) {
                                textFieldPreparedSelection.moveCursorToLineEnd();
                            } else {
                                textFieldPreparedSelection.moveCursorToLineStart();
                            }
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 43:
                        textFieldPreparedSelection.state.cachedX = null;
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0) {
                            long j10 = textFieldPreparedSelection.selection;
                            int i3 = TextRange.$r8$clinit;
                            int i4 = (int) (j10 & 4294967295L);
                            textFieldPreparedSelection.setSelection(i4, i4);
                        }
                        break;
                    case 44:
                        if (textFieldKeyInput.singleLine) {
                            ref$BooleanRef2.element = textFieldKeyInput.state.onImeActionPerformedWithResult.f$0.keyboardActionRunner.m197runActionKlQnJC8(textFieldKeyInput.imeAction);
                        } else {
                            textFieldKeyInput.apply(CollectionsKt__IterablesKt.listOf(new CommitTextCommand("\n", 1)));
                        }
                        break;
                    case 45:
                        if (textFieldKeyInput.singleLine) {
                            ref$BooleanRef2.element = false;
                        } else {
                            textFieldKeyInput.apply(CollectionsKt__IterablesKt.listOf(new CommitTextCommand("\t", 1)));
                        }
                        break;
                    case 46:
                        textFieldKeyInput.undoManager.makeSnapshot(TextFieldValue.m762copy3r_uNRQ$default(textFieldPreparedSelection.currentValue, textFieldPreparedSelection.annotatedString, textFieldPreparedSelection.selection, 4));
                        UndoManager undoManager = textFieldKeyInput.undoManager;
                        CallbackWrapper callbackWrapper2 = undoManager.undoStack;
                        if (callbackWrapper2 != null && (callbackWrapper = (CallbackWrapper) callbackWrapper2.mCallback) != null) {
                            undoManager.undoStack = callbackWrapper;
                            undoManager.storedCharacters -= ((TextFieldValue) callbackWrapper2.mExecutor).annotatedString.text.length();
                            undoManager.redoStack = new CallbackWrapper(undoManager.redoStack, (TextFieldValue) callbackWrapper2.mExecutor, b6);
                            textFieldValue = (TextFieldValue) callbackWrapper.mExecutor;
                        }
                        if (r11 != 0) {
                            r11 = textFieldValue;
                            textFieldKeyInput.onValueChange.invoke(r11);
                        }
                        break;
                    case 47:
                        UndoManager undoManager2 = textFieldKeyInput.undoManager;
                        CallbackWrapper callbackWrapper3 = undoManager2.redoStack;
                        if (callbackWrapper3 != null) {
                            undoManager2.redoStack = (CallbackWrapper) callbackWrapper3.mCallback;
                            TextFieldValue textFieldValue5 = (TextFieldValue) callbackWrapper3.mExecutor;
                            undoManager2.undoStack = new CallbackWrapper(undoManager2.undoStack, textFieldValue5, b6);
                            undoManager2.storedCharacters = textFieldValue5.annotatedString.text.length() + undoManager2.storedCharacters;
                            textFieldValue2 = (TextFieldValue) callbackWrapper3.mExecutor;
                        }
                        if (textFieldValue2 != null) {
                            textFieldKeyInput.onValueChange.invoke(textFieldValue2);
                        }
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                }
                r11 = textFieldValue;
                return unit;
            case 11:
                Context context = (Context) obj3;
                TextContextMenuSession textContextMenuSession = (TextContextMenuSession) obj2;
                ContextMenuScope contextMenuScope = (ContextMenuScope) obj;
                List list = ((TextContextMenuData) obj4).components;
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    TextContextMenuComponent textContextMenuComponent = (TextContextMenuComponent) list.get(i5);
                    if (textContextMenuComponent instanceof TextContextMenuItem) {
                        TextContextMenuItem textContextMenuItem = (TextContextMenuItem) textContextMenuComponent;
                        ContextMenuScope.item$default(contextMenuScope, new ComposerKt$$ExternalSyntheticLambda0((byte) 10, textContextMenuItem), textContextMenuItem.leadingIcon == 0 ? null : new ComposableLambdaImpl(true, -1930700965, new TextContextMenuHelperApi28$textClassificationItem$2$1(b3, textContextMenuItem)), new Recomposer$$ExternalSyntheticLambda6((Object) textContextMenuItem, (Object) textContextMenuSession, (byte) 14), 6);
                    } else if (textContextMenuComponent instanceof TextContextMenuTextClassificationItem) {
                        if (Build.VERSION.SDK_INT >= 28) {
                            TextContextMenuHelperApi28.textClassificationItem(contextMenuScope, context, (TextContextMenuTextClassificationItem) textContextMenuComponent);
                        }
                    } else if (textContextMenuComponent instanceof TextContextMenuSeparator) {
                        contextMenuScope.composables.add(ContextMenuPopupPositionProviderKt.f0lambda$1455401925);
                    }
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                MediaSessionImpl$1 mediaSessionImpl$1 = (MediaSessionImpl$1) obj4;
                MarqueeSpacing$Companion$$ExternalSyntheticLambda0 marqueeSpacing$Companion$$ExternalSyntheticLambda0 = (MarqueeSpacing$Companion$$ExternalSyntheticLambda0) obj3;
                Ref$BooleanRef ref$BooleanRef3 = (Ref$BooleanRef) obj2;
                PointerInputChange pointerInputChange = (PointerInputChange) obj;
                long j11 = pointerInputChange.position;
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) mediaSessionImpl$1.this$0;
                if (!textFieldSelectionManager.getEnabled() || textFieldSelectionManager.getValue$foundation().annotatedString.text.length() == 0 || (legacyTextFieldState = textFieldSelectionManager.state) == null || legacyTextFieldState.getLayoutResult() == null) {
                    z = false;
                } else {
                    mediaSessionImpl$1.updateMouseSelection(textFieldSelectionManager.getValue$foundation(), j11, false, marqueeSpacing$Companion$$ExternalSyntheticLambda0);
                    z = true;
                }
                if (z) {
                    pointerInputChange.consume();
                    ref$BooleanRef3.element = true;
                }
                return unit;
            case 13:
                final TextFieldSelectionManager textFieldSelectionManager2 = (TextFieldSelectionManager) obj4;
                CoroutineScope coroutineScope = (CoroutineScope) obj3;
                Context context2 = (Context) obj2;
                TextContextMenuBuilderScope textContextMenuBuilderScope = (TextContextMenuBuilderScope) obj;
                MutableObjectList mutableObjectList = textContextMenuBuilderScope.components;
                MutableObjectList mutableObjectList2 = textContextMenuBuilderScope.components;
                TextContextMenuSeparator textContextMenuSeparator = TextContextMenuSeparator.INSTANCE;
                mutableObjectList.add(textContextMenuSeparator);
                TextContextMenuItems textContextMenuItems = TextContextMenuItems.Autofill;
                boolean z3 = (TextRange.m741getCollapsedimpl(textFieldSelectionManager2.getValue$foundation().selection) || !textFieldSelectionManager2.getEditable() || (textFieldSelectionManager2.visualTransformation instanceof PasswordVisualTransformation) || textFieldSelectionManager2.clipboard == null) ? false : true;
                byte b7 = 16;
                Recomposer$$ExternalSyntheticLambda6 recomposer$$ExternalSyntheticLambda6 = new Recomposer$$ExternalSyntheticLambda6(coroutineScope, new TextFieldSelectionManager$contextMenuAreaModifier$3(textFieldSelectionManager2, r11, b5), b7);
                Resources resources = context2.getResources();
                ZIndexNode$$ExternalSyntheticLambda0 zIndexNode$$ExternalSyntheticLambda0 = new ZIndexNode$$ExternalSyntheticLambda0((Object) recomposer$$ExternalSyntheticLambda6, (Object) r11, (byte) 8);
                if (z3) {
                    mutableObjectList2.add(new TextContextMenuItem(TextContextMenuKeys.CutKey, resources.getString(R.string.cut), R.attr.actionModeCutDrawable, zIndexNode$$ExternalSyntheticLambda0));
                }
                TextContextMenuItems textContextMenuItems2 = TextContextMenuItems.Autofill;
                boolean z4 = (TextRange.m741getCollapsedimpl(textFieldSelectionManager2.getValue$foundation().selection) || (textFieldSelectionManager2.visualTransformation instanceof PasswordVisualTransformation) || textFieldSelectionManager2.clipboard == null) ? false : true;
                Recomposer$$ExternalSyntheticLambda6 recomposer$$ExternalSyntheticLambda7 = new Recomposer$$ExternalSyntheticLambda6(coroutineScope, new TextFieldSelectionManager$contextMenuAreaModifier$3(textFieldSelectionManager2, r11, b3), b7);
                Resources resources2 = context2.getResources();
                ZIndexNode$$ExternalSyntheticLambda0 zIndexNode$$ExternalSyntheticLambda1 = new ZIndexNode$$ExternalSyntheticLambda0((Object) recomposer$$ExternalSyntheticLambda7, (Object) r11, (byte) 8);
                if (z4) {
                    mutableObjectList2.add(new TextContextMenuItem(TextContextMenuKeys.CopyKey, resources2.getString(R.string.copy), R.attr.actionModeCopyDrawable, zIndexNode$$ExternalSyntheticLambda1));
                }
                TextContextMenuItems textContextMenuItems3 = TextContextMenuItems.Autofill;
                boolean z5 = textFieldSelectionManager2.getEditable() && ((Boolean) textFieldSelectionManager2.hasAvailableTextToPaste$delegate.getValue()).booleanValue() && textFieldSelectionManager2.clipboard != null;
                Recomposer$$ExternalSyntheticLambda6 recomposer$$ExternalSyntheticLambda8 = new Recomposer$$ExternalSyntheticLambda6(coroutineScope, new TextFieldSelectionManager$contextMenuAreaModifier$3(textFieldSelectionManager2, r11, b4), b7);
                Resources resources3 = context2.getResources();
                ZIndexNode$$ExternalSyntheticLambda0 zIndexNode$$ExternalSyntheticLambda2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) recomposer$$ExternalSyntheticLambda8, (Object) r11, (byte) 8);
                if (z5) {
                    mutableObjectList2.add(new TextContextMenuItem(TextContextMenuKeys.PasteKey, resources3.getString(R.string.paste), R.attr.actionModePasteDrawable, zIndexNode$$ExternalSyntheticLambda2));
                }
                TextContextMenuItems textContextMenuItems4 = TextContextMenuItems.Autofill;
                boolean z6 = TextRange.m742getLengthimpl(textFieldSelectionManager2.getValue$foundation().selection) != textFieldSelectionManager2.getValue$foundation().annotatedString.text.length();
                final byte b8 = 0;
                Function0 function0 = new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        byte b9 = b8;
                        Unit unit2 = Unit.INSTANCE;
                        TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2;
                        switch (b9) {
                            case 0:
                                return Boolean.valueOf(!textFieldSelectionManager3.textToolbarShownViaProvider);
                            case 1:
                                TextFieldValue textFieldValueM230createTextFieldValueFDrldGo = TextFieldSelectionManager.m230createTextFieldValueFDrldGo(textFieldSelectionManager3.getValue$foundation().annotatedString, TextRangeKt.TextRange(0, textFieldSelectionManager3.getValue$foundation().annotatedString.text.length()));
                                textFieldSelectionManager3.onValueChange.invoke(textFieldValueM230createTextFieldValueFDrldGo);
                                long j12 = textFieldValueM230createTextFieldValueFDrldGo.selection;
                                textFieldSelectionManager3.latestSelection = new TextRange(j12);
                                textFieldSelectionManager3.oldValue = TextFieldValue.m762copy3r_uNRQ$default(textFieldSelectionManager3.oldValue, null, j12, 5);
                                textFieldSelectionManager3.enterSelectionMode$foundation(true);
                                return unit2;
                            default:
                                Function0 function3 = textFieldSelectionManager3.requestAutofillAction;
                                if (function3 != null) {
                                    function3.invoke();
                                }
                                return unit2;
                        }
                    }
                };
                final byte b9 = 1;
                Function0 function3 = new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        byte b10 = b9;
                        Unit unit2 = Unit.INSTANCE;
                        TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2;
                        switch (b10) {
                            case 0:
                                return Boolean.valueOf(!textFieldSelectionManager3.textToolbarShownViaProvider);
                            case 1:
                                TextFieldValue textFieldValueM230createTextFieldValueFDrldGo = TextFieldSelectionManager.m230createTextFieldValueFDrldGo(textFieldSelectionManager3.getValue$foundation().annotatedString, TextRangeKt.TextRange(0, textFieldSelectionManager3.getValue$foundation().annotatedString.text.length()));
                                textFieldSelectionManager3.onValueChange.invoke(textFieldValueM230createTextFieldValueFDrldGo);
                                long j12 = textFieldValueM230createTextFieldValueFDrldGo.selection;
                                textFieldSelectionManager3.latestSelection = new TextRange(j12);
                                textFieldSelectionManager3.oldValue = TextFieldValue.m762copy3r_uNRQ$default(textFieldSelectionManager3.oldValue, null, j12, 5);
                                textFieldSelectionManager3.enterSelectionMode$foundation(true);
                                return unit2;
                            default:
                                Function0 function4 = textFieldSelectionManager3.requestAutofillAction;
                                if (function4 != null) {
                                    function4.invoke();
                                }
                                return unit2;
                        }
                    }
                };
                Resources resources4 = context2.getResources();
                ZIndexNode$$ExternalSyntheticLambda0 zIndexNode$$ExternalSyntheticLambda3 = new ZIndexNode$$ExternalSyntheticLambda0((Object) function3, (Object) function0, (byte) 8);
                if (z6) {
                    mutableObjectList2.add(new TextContextMenuItem(TextContextMenuKeys.SelectAllKey, resources4.getString(R.string.selectAll), R.attr.actionModeSelectAllDrawable, zIndexNode$$ExternalSyntheticLambda3));
                }
                TextContextMenuItems textContextMenuItems5 = TextContextMenuItems.Autofill;
                boolean z7 = textFieldSelectionManager2.getEditable() && TextRange.m741getCollapsedimpl(textFieldSelectionManager2.getValue$foundation().selection);
                Function0 function4 = new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        byte b10 = b3;
                        Unit unit2 = Unit.INSTANCE;
                        TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2;
                        switch (b10) {
                            case 0:
                                return Boolean.valueOf(!textFieldSelectionManager3.textToolbarShownViaProvider);
                            case 1:
                                TextFieldValue textFieldValueM230createTextFieldValueFDrldGo = TextFieldSelectionManager.m230createTextFieldValueFDrldGo(textFieldSelectionManager3.getValue$foundation().annotatedString, TextRangeKt.TextRange(0, textFieldSelectionManager3.getValue$foundation().annotatedString.text.length()));
                                textFieldSelectionManager3.onValueChange.invoke(textFieldValueM230createTextFieldValueFDrldGo);
                                long j12 = textFieldValueM230createTextFieldValueFDrldGo.selection;
                                textFieldSelectionManager3.latestSelection = new TextRange(j12);
                                textFieldSelectionManager3.oldValue = TextFieldValue.m762copy3r_uNRQ$default(textFieldSelectionManager3.oldValue, null, j12, 5);
                                textFieldSelectionManager3.enterSelectionMode$foundation(true);
                                return unit2;
                            default:
                                Function0 function5 = textFieldSelectionManager3.requestAutofillAction;
                                if (function5 != null) {
                                    function5.invoke();
                                }
                                return unit2;
                        }
                    }
                };
                Resources resources5 = context2.getResources();
                ZIndexNode$$ExternalSyntheticLambda0 zIndexNode$$ExternalSyntheticLambda4 = new ZIndexNode$$ExternalSyntheticLambda0((Object) function4, (Object) r11, (byte) 8);
                if (z7) {
                    mutableObjectList2.add(new TextContextMenuItem(textContextMenuItems5.key, resources5.getString(textContextMenuItems5.stringId), textContextMenuItems5.drawableId, zIndexNode$$ExternalSyntheticLambda4));
                }
                mutableObjectList2.add(textContextMenuSeparator);
                return unit;
            case 14:
                SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj;
                SemanticsPropertiesKt.m718setRolekuIjeqM(semanticsPropertyReceiver, 6);
                semanticsPropertyReceiver.set(SemanticsActions.OnClick, new AccessibilityAction(null, new SliderState$$ExternalSyntheticLambda0((FocusRequester) obj4, (PlayerKt$$ExternalSyntheticLambda49) obj3, (SoftwareKeyboardController) obj2)));
                return unit;
            case 15:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope.setShadowElevation(((Density) obj4).mo81toPx0680j_4(((Dp) ((State) obj2).getValue()).value));
                reusableGraphicsLayerScope.setShape((Shape) obj3);
                reusableGraphicsLayerScope.setClip(false);
                return unit;
            case 16:
                LifecycleOwner lifecycleOwner = (LifecycleOwner) obj4;
                NavControllerImpl$$ExternalSyntheticLambda3 navControllerImpl$$ExternalSyntheticLambda3 = new NavControllerImpl$$ExternalSyntheticLambda3(b5, (Function1) obj3);
                lifecycleOwner.getLifecycle().addObserver(navControllerImpl$$ExternalSyntheticLambda3);
                return new AboutScreenKt$DevBannerVideo$lambda$1$0$$inlined$onDispose$1((Function0) obj2, lifecycleOwner, navControllerImpl$$ExternalSyntheticLambda3);
            case 17:
                AwaitKt.launch$default((CoroutineScope) obj4, null, null, new RealImageLoader.AnonymousClass2((FocusStateImpl) obj, (MutableState) obj3, (TooltipStateImpl) obj2, null, (byte) 20, false), 3);
                return unit;
            case 18:
                Recomposer$$ExternalSyntheticLambda6 recomposer$$ExternalSyntheticLambda9 = new Recomposer$$ExternalSyntheticLambda6(obj3, obj2, (byte) 21);
                KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                ((SemanticsPropertyReceiver) obj).set(SemanticsActions.OnLongClick, new AccessibilityAction((String) obj4, recomposer$$ExternalSyntheticLambda9));
                return unit;
            case 19:
                return invoke$androidx$compose$material3$internal$DraggableAnchorsNode$$ExternalSyntheticLambda0(obj);
            case 20:
                return invoke$androidx$compose$runtime$MultiSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda2(obj);
            case 21:
                SaveableStateHolderImpl saveableStateHolderImpl = (SaveableStateHolderImpl) obj4;
                SaveableStateRegistryWrapper saveableStateRegistryWrapper = (SaveableStateRegistryWrapper) obj2;
                MutableScatterMap mutableScatterMap = saveableStateHolderImpl.registries;
                if (mutableScatterMap.contains(obj3)) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m("Key ", obj3, " was used multiple times ");
                    return null;
                }
                saveableStateHolderImpl.savedStates.remove(obj3);
                mutableScatterMap.set(obj3, saveableStateRegistryWrapper);
                return new AboutScreenKt$DevBannerVideo$lambda$1$0$$inlined$onDispose$1(saveableStateHolderImpl, obj3, saveableStateRegistryWrapper, b4);
            case 22:
                FocusOwnerImpl focusOwnerImpl = (FocusOwnerImpl) obj3;
                Function1 function5 = (Function1) obj2;
                FocusTargetNode focusTargetNode = (FocusTargetNode) obj;
                if (!Intrinsics.areEqual(focusTargetNode, (FocusTargetNode) obj4)) {
                    if (Intrinsics.areEqual(focusTargetNode, focusOwnerImpl.rootFocusNode)) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Focus search landed at the root.");
                        return null;
                    }
                    zBooleanValue = ((Boolean) function5.invoke(focusTargetNode)).booleanValue();
                }
                return Boolean.valueOf(zBooleanValue);
            case 23:
                return invoke$androidx$compose$ui$node$LayoutNodeDrawScope$$ExternalSyntheticLambda0(obj);
            case 24:
                return invoke$androidx$compose$ui$viewinterop$AndroidViewHolder$$ExternalSyntheticLambda10(obj);
            case 25:
                SaversKt$$ExternalSyntheticLambda5 saversKt$$ExternalSyntheticLambda5 = (SaversKt$$ExternalSyntheticLambda5) obj2;
                Throwable th3 = (Throwable) obj;
                ((DiskLruCache$$ExternalSyntheticLambda0) obj4).invoke(th3);
                BufferedChannel bufferedChannel = (BufferedChannel) ((Dispatcher) obj3).runningAsyncCalls;
                bufferedChannel.closeOrCancelImpl(th3, false);
                while (true) {
                    Object objM1903getOrNullimpl = ChannelResult.m1903getOrNullimpl(bufferedChannel.mo1861tryReceivePtdJZtk());
                    if (objM1903getOrNullimpl == null) {
                        return unit;
                    }
                    saversKt$$ExternalSyntheticLambda5.invoke(objM1903getOrNullimpl, th3);
                }
                break;
            case 26:
                return invoke$androidx$lifecycle$compose$LifecycleEffectKt$$ExternalSyntheticLambda1(obj);
            case 27:
                return invoke$androidx$navigation$compose$DialogHostKt$DialogHost$1$2$$ExternalSyntheticLambda0(obj);
            case 28:
                return invoke$com$metrolist$innertubex$InnerTube$registerStatsWithSession$2$1$$ExternalSyntheticLambda0(obj);
            default:
                String str9 = (String) obj4;
                String str10 = (String) obj3;
                YtConfigParserImpl ytConfigParserImpl = (YtConfigParserImpl) obj2;
                HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) obj;
                httpRequestBuilder.getClass();
                io.ktor.client.request.UtilsKt.header(httpRequestBuilder, HttpHeaders.UserAgent, "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0");
                io.ktor.client.request.UtilsKt.header(httpRequestBuilder, HttpHeaders.Accept, "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
                if (str9 != null) {
                    io.ktor.client.request.UtilsKt.header(httpRequestBuilder, HttpHeaders.Referrer, str9);
                }
                if (str10 != null) {
                    io.ktor.client.request.UtilsKt.header(httpRequestBuilder, HttpHeaders.Cookie, str10);
                }
                io.ktor.client.request.UtilsKt.header(httpRequestBuilder, HttpHeaders.AcceptLanguage, ((InnerTube.SessionSnapshot) ytConfigParserImpl.innerTube.session.get()).locale.acceptLanguageHeader$com_github_MetrolistGroup_innertubex());
                HttpTimeoutKt.timeout(httpRequestBuilder, new YouTube$$ExternalSyntheticLambda2((byte) 27));
                return unit;
        }
    }

    public /* synthetic */ UtilsKt$$ExternalSyntheticLambda0(Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    public /* synthetic */ UtilsKt$$ExternalSyntheticLambda0(Ref$FloatRef ref$FloatRef, ScrollScope scrollScope, Ref$FloatRef ref$FloatRef2, DefaultFlingBehavior defaultFlingBehavior) {
        this.$r8$classId = (byte) 4;
        this.f$0 = ref$FloatRef;
        this.f$1 = scrollScope;
        this.f$2 = ref$FloatRef2;
    }

    public /* synthetic */ UtilsKt$$ExternalSyntheticLambda0(ContentInViewNode contentInViewNode, UpdatableAnimationState updatableAnimationState, Job job, ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1) {
        this.$r8$classId = (byte) 3;
        this.f$0 = contentInViewNode;
        this.f$1 = job;
        this.f$2 = scrollingLogic$nestedScrollScope$1;
    }
}
