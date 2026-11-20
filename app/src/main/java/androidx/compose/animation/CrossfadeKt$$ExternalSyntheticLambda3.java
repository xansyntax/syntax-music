package androidx.compose.animation;

import android.content.Context;
import android.widget.Toast;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.internal.Lock;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.foundation.HoverableElement;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextLinkScope;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.compose.foundation.text.TextRangeLayoutModifier;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.ListItemKt$InteractiveListItem$$inlined$animateColor$1;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda5;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.input.pointer.PointerHoverIconModifierElement;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.media3.extractor.flv.TagPayloadReader;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda21;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda29;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.listentogether.ConnectionState;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.player.QueueKt;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda39;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.screens.HomeScreenKt;
import com.metrolist.music.ui.screens.ListenTogetherScreenKt;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import com.metrolist.music.ui.screens.search.LocalSearchScreenKt;
import com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda18;
import com.metrolist.music.ui.screens.settings.AiSettingsKt$$ExternalSyntheticLambda3;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.viewmodels.CommunityPlaylistItem;
import com.metrolist.music.viewmodels.LyricsMenuViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.plugins.cache.HttpCacheKt$$ExternalSyntheticLambda0;
import io.ktor.websocket.ControlFramesKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatRange;
import kotlin.uuid.UuidKt;
import kotlinx.io.SourcesJvmKt$asInputStream$isClosed$1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CrossfadeKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ CrossfadeKt$$ExternalSyntheticLambda3(Modifier modifier, MutableState mutableState, ComposableLambdaImpl composableLambdaImpl, BasicTextContextMenuProvider basicTextContextMenuProvider) {
        this.$r8$classId = (byte) 2;
        this.f$0 = modifier;
        this.f$1 = mutableState;
        this.f$3 = composableLambdaImpl;
        this.f$2 = basicTextContextMenuProvider;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        boolean z;
        Object objM;
        GapComposer gapComposer;
        Modifier.Companion companion;
        Modifier modifierM136paddingVpY3zN4;
        Modifier.Companion companion2;
        boolean z2;
        byte b = this.$r8$classId;
        Modifier.Companion companion3 = Modifier.Companion.$$INSTANCE;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$3;
        Object obj4 = this.f$2;
        Object obj5 = this.f$1;
        Object obj6 = this.f$0;
        switch (b) {
            case 0:
                TransitionInstance transitionInstance = (TransitionInstance) obj6;
                FiniteAnimationSpec finiteAnimationSpec = (FiniteAnimationSpec) obj5;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer;
                if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    TwoWayConverterImpl twoWayConverterImpl = ArcSplineKt.FloatToVector;
                    boolean zIsSeeking = transitionInstance.isSeeking();
                    TagPayloadReader tagPayloadReader = transitionInstance.transitionState;
                    if (zIsSeeking) {
                        z = false;
                        objM = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2, 1666827533, false, tagPayloadReader);
                    } else {
                        gapComposer2.startReplaceGroup(1666573488);
                        boolean zChanged = gapComposer2.changed(transitionInstance);
                        objM = gapComposer2.rememberedValue();
                        if (zChanged || objM == neverEqualPolicy) {
                            Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                            Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                            try {
                                Object currentState = tagPayloadReader.getCurrentState();
                                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                gapComposer2.updateRememberedValue(currentState);
                                objM = currentState;
                            } catch (Throwable th) {
                                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                throw th;
                            }
                        }
                        gapComposer2.end(false);
                        z = false;
                    }
                    gapComposer2.startReplaceGroup(1378811975);
                    float f = Intrinsics.areEqual(objM, obj4) ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO;
                    gapComposer2.end(z);
                    Float fValueOf = Float.valueOf(f);
                    boolean zChanged2 = gapComposer2.changed(transitionInstance);
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance, (byte) 1));
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Object value = ((State) objRememberedValue).getValue();
                    gapComposer2.startReplaceGroup(1378811975);
                    float f2 = Intrinsics.areEqual(value, obj4) ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO;
                    gapComposer2.end(false);
                    Float fValueOf2 = Float.valueOf(f2);
                    boolean zChanged3 = gapComposer2.changed(transitionInstance);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged3 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance, (byte) 2));
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    gapComposer2.startReplaceGroup(955869654);
                    gapComposer2.end(false);
                    Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transitionInstance, fValueOf, fValueOf2, finiteAnimationSpec, twoWayConverterImpl, gapComposer2, 0);
                    boolean zChanged4 = gapComposer2.changed(transitionAnimationStateCreateTransitionAnimation);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged4 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new AppBarKt$$ExternalSyntheticLambda3(transitionAnimationStateCreateTransitionAnimation, (byte) 1);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    Modifier modifierGraphicsLayer = ColorKt.graphicsLayer(companion3, (Function1) objRememberedValue3);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierGraphicsLayer);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m386initimpl(gapComposer2, Integer.valueOf(iHashCode));
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda1);
                    composableLambdaImpl.invoke(obj4, (Object) gapComposer2, (Object) 0);
                    gapComposer2.end(true);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 1:
                TextLinkScope textLinkScope = (TextLinkScope) obj6;
                AnnotatedString.Range range = (AnnotatedString.Range) obj5;
                MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) obj4;
                UriHandler uriHandler = (UriHandler) obj3;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer2;
                if (gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    Modifier modifierGraphicsLayer2 = ColorKt.graphicsLayer(companion3, new ZIndexNode$$ExternalSyntheticLambda0((Object) textLinkScope, (Object) range, (byte) 6));
                    Object objRememberedValue4 = gapComposer3.rememberedValue();
                    if (objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new ChipKt$$ExternalSyntheticLambda3((byte) 9);
                        gapComposer3.updateRememberedValue(objRememberedValue4);
                    }
                    Modifier modifierThen = SemanticsModifierKt.semantics(modifierGraphicsLayer2, false, (Function1) objRememberedValue4).then(new TextRangeLayoutModifier(new TextLinkScope$$ExternalSyntheticLambda10(textLinkScope, range, (byte) 0))).then(new HoverableElement(mutableInteractionSourceImpl));
                    PointerIcon.Companion.getClass();
                    Modifier modifierThen2 = modifierThen.then(new PointerHoverIconModifierElement(PointerIconKt.pointerIconHand));
                    boolean zChangedInstance = gapComposer3.changedInstance(textLinkScope) | gapComposer3.changed(range) | gapComposer3.changedInstance(uriHandler);
                    Object objRememberedValue5 = gapComposer3.rememberedValue();
                    if (zChangedInstance || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new Recomposer$$ExternalSyntheticLambda6(textLinkScope, range, uriHandler);
                        gapComposer3.updateRememberedValue(objRememberedValue5);
                    }
                    BoxKt.Box(ImageKt.m47combinedClickableauXiCPI$default(modifierThen2, mutableInteractionSourceImpl, null, false, null, null, (Function0) objRememberedValue5, 508), gapComposer3, 0);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 2:
                Modifier modifier = (Modifier) obj6;
                MutableState mutableState = (MutableState) obj5;
                ComposableLambdaImpl composableLambdaImpl2 = (ComposableLambdaImpl) obj3;
                BasicTextContextMenuProvider basicTextContextMenuProvider = (BasicTextContextMenuProvider) obj4;
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer3;
                if (gapComposer4.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    Object objRememberedValue6 = gapComposer4.rememberedValue();
                    if (objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new TooltipKt$$ExternalSyntheticLambda5(mutableState, (byte) 8);
                        gapComposer4.updateRememberedValue(objRememberedValue6);
                    }
                    Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(modifier, (Function1) objRememberedValue6);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                    int iHashCode2 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierOnGloballyPositioned);
                    ComposeUiNode.Companion.getClass();
                    gapComposer4.startReusableNode();
                    if (gapComposer4.inserting) {
                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer4.useNode();
                    }
                    Stack.m390setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda0);
                    Stack.m389reconcileimpl(gapComposer4);
                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda1);
                    composableLambdaImpl2.invoke((Object) gapComposer4, (Object) 0);
                    Object objRememberedValue7 = gapComposer4.rememberedValue();
                    if (objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new MainActivity$$ExternalSyntheticLambda29(mutableState, (byte) 8);
                        gapComposer4.updateRememberedValue(objRememberedValue7);
                    }
                    basicTextContextMenuProvider.ContextMenu((Function0) objRememberedValue7, gapComposer4, 6);
                    gapComposer4.end(true);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 3:
                MutableState mutableState2 = (MutableState) obj6;
                ScrimKt scrimKt = (ScrimKt) obj5;
                PaddingValues paddingValues = (PaddingValues) obj4;
                Function2 function2 = (Function2) obj3;
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer4;
                if (gapComposer5.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    Modifier modifierDrawWithContent = ClipKt.drawWithContent(RulerKt.layoutId(companion3, "Container"), new ZIndexNode$$ExternalSyntheticLambda0((Object) new SourcesJvmKt$asInputStream$isClosed$1(mutableState2, MutableState.class, "value", "getValue()Ljava/lang/Object;", 0, (byte) 1), (Object) paddingValues, (byte) 13));
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                    int iHashCode3 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer5.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer5, modifierDrawWithContent);
                    ComposeUiNode.Companion.getClass();
                    gapComposer5.startReusableNode();
                    if (gapComposer5.inserting) {
                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer5.useNode();
                    }
                    Stack.m390setimpl(gapComposer5, measurePolicyMaybeCachedBoxMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer5, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda0);
                    Stack.m389reconcileimpl(gapComposer5);
                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda1);
                    function2.invoke(gapComposer5, 0);
                    gapComposer5.end(true);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 4:
                Context context = (Context) obj6;
                String str = (String) obj5;
                Function1 function1 = (Function1) obj4;
                String str2 = (String) obj;
                boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                str2.getClass();
                if (((Boolean) ((MutableState) obj3).getValue()).booleanValue() && !zBooleanValue) {
                    Toast.makeText(context, str, 1).show();
                }
                if (function1 != null) {
                    function1.invoke(str2);
                }
                return unit;
            case 5:
                ClosedFloatRange closedFloatRange = (ClosedFloatRange) obj5;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) obj3;
                float fFloatValue = ((Float) obj2).floatValue();
                ((PointerInputChange) obj).getClass();
                parcelableSnapshotMutableFloatState.setFloatValue(UuidKt.coerceIn((fFloatValue / ((int) (((SuspendingPointerInputModifierNodeImpl) ((PointerInputScope) obj6)).boundsSize >> 32))) + parcelableSnapshotMutableFloatState.getFloatValue(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                float f3 = closedFloatRange._start;
                ((Function1) obj4).invoke(Float.valueOf(((closedFloatRange._endInclusive - f3) * parcelableSnapshotMutableFloatState.getFloatValue()) + f3));
                return unit;
            case 6:
                Function0 function0 = (Function0) obj6;
                LyricsMenuViewModel lyricsMenuViewModel = (LyricsMenuViewModel) obj5;
                Function0 function3 = (Function0) obj4;
                Function0 function4 = (Function0) obj3;
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer5;
                if (gapComposer6.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    function0.invoke();
                    MediaMetadata mediaMetadata = (MediaMetadata) function3.invoke();
                    LyricsEntity lyricsEntity = (LyricsEntity) function4.invoke();
                    mediaMetadata.getClass();
                    lyricsMenuViewModel.database.query(new HttpCacheKt$$ExternalSyntheticLambda0(lyricsEntity, mediaMetadata, lyricsMenuViewModel, (byte) 1));
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 7:
                Context context2 = (Context) obj6;
                String str3 = (String) obj5;
                PlayerConnection playerConnection = (PlayerConnection) obj4;
                Function0 function5 = (Function0) obj3;
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer6;
                if (gapComposer7.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    Toast.makeText(context2, str3, 0).show();
                    playerConnection.startRadioSeamlessly();
                    function5.invoke();
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 8:
                Song song = (Song) obj6;
                MutableState mutableState3 = (MutableState) obj5;
                MutableState mutableState4 = (MutableState) obj4;
                MutableState mutableState5 = (MutableState) obj3;
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer7;
                if (gapComposer8.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    mutableState3.setValue(new TextFieldValue(6, 0L, song.song.title));
                    List orderedArtists = song.getOrderedArtists();
                    Object objRememberedValue8 = gapComposer8.rememberedValue();
                    if (objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new SongMenuKt$$ExternalSyntheticLambda16((byte) 11);
                        gapComposer8.updateRememberedValue(objRememberedValue8);
                    }
                    mutableState4.setValue(new TextFieldValue(6, 0L, CollectionsKt.joinToString$default(orderedArtists, ", ", null, null, (Function1) objRememberedValue8, 30)));
                    mutableState5.setValue(Boolean.TRUE);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 9:
                ((Integer) obj2).getClass();
                QueueKt.MiniPlayer((ParcelableSnapshotMutableLongState) obj6, (ParcelableSnapshotMutableLongState) obj5, (Modifier) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(55));
                return unit;
            case 10:
                ((Integer) obj2).getClass();
                AlbumScreenKt.PodcastChannelAccountItem((String) obj6, (String) obj5, (Function0) obj4, (Modifier) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 11:
                ((Integer) obj2).getClass();
                HomeScreenKt.CommunityPlaylistCard((CommunityPlaylistItem) obj6, (Function0) obj5, (Function1) obj4, (Modifier) obj3, (Composer) obj, Stack.updateChangedFlags(9));
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((Integer) obj2).getClass();
                ListenTogetherScreenKt.ConnectionStatusCard((ConnectionState) obj6, (Function0) obj5, (Function0) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 13:
                ((Integer) obj2).getClass();
                LibraryScreenKt.PodcastEpisodePlaylistItem((PodcastEntity) obj6, (Function0) obj5, (Function0) obj4, (Modifier) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 14:
                FocusRequester focusRequester = (FocusRequester) obj6;
                Function1 function6 = (Function1) obj5;
                MutableState mutableState6 = (MutableState) obj4;
                MutableState mutableState7 = (MutableState) obj3;
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer8;
                if (gapComposer9.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    Modifier.Companion companion4 = Modifier.Companion.$$INSTANCE;
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion4, 1.0f);
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer9, 48);
                    int iHashCode4 = Long.hashCode(gapComposer9.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer9.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer9, modifierFillMaxWidth);
                    ComposeUiNode.Companion.getClass();
                    gapComposer9.startReusableNode();
                    if (gapComposer9.inserting) {
                        gapComposer9.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer9.useNode();
                    }
                    Stack.m390setimpl(gapComposer9, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer9, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer9, Integer.valueOf(iHashCode4), updater$$ExternalSyntheticLambda0);
                    Stack.m389reconcileimpl(gapComposer9);
                    Stack.m390setimpl(gapComposer9, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda1);
                    TextFieldValue textFieldValue = (TextFieldValue) mutableState6.getValue();
                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                    if (UiStyleKt.isGlassStyle(gapComposer9)) {
                        gapComposer9.startReplaceGroup(-659439411);
                        companion = companion4;
                        gapComposer = gapComposer9;
                        modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(GlassComponentsKt.glass(companion4, RoundedCornerShapeKt.RoundedCornerShape(50), false, gapComposer9, 6, 2), 18.0f, 10.0f);
                        gapComposer.end(false);
                    } else {
                        gapComposer = gapComposer9;
                        companion = companion4;
                        gapComposer.startReplaceGroup(-659437816);
                        gapComposer.end(false);
                        modifierM136paddingVpY3zN4 = companion;
                    }
                    Modifier modifierFocusRequester = FocusTraversalKt.focusRequester(layoutWeightElement.then(modifierM136paddingVpY3zN4), focusRequester);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextStyle textStyleM750copyp1EtxEg$default = TextStyle.m750copyp1EtxEg$default(((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.titleLarge, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, IntMath.getSp(20), null, null, null, null, 0L, 0L, null, null, 16777212);
                    SolidColor solidColor = new SolidColor(((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary);
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, 3, 119);
                    boolean zChanged5 = gapComposer.changed(function6) | gapComposer.changed(mutableState6);
                    Object objRememberedValue9 = gapComposer.rememberedValue();
                    if (zChanged5 || objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = new ClickableTextKt$$ExternalSyntheticLambda1(function6, mutableState6, (byte) 3);
                        gapComposer.updateRememberedValue(objRememberedValue9);
                    }
                    KeyboardActions keyboardActions = new KeyboardActions(null, (Function1) objRememberedValue9, 47);
                    boolean zChanged6 = gapComposer.changed(mutableState6);
                    Object objRememberedValue10 = gapComposer.rememberedValue();
                    if (zChanged6 || objRememberedValue10 == neverEqualPolicy) {
                        objRememberedValue10 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState6, (byte) 18);
                        gapComposer.updateRememberedValue(objRememberedValue10);
                    }
                    BasicTextKt.BasicTextField(textFieldValue, (Function1) objRememberedValue10, modifierFocusRequester, false, textStyleM750copyp1EtxEg$default, keyboardOptions, keyboardActions, true, 0, 0, (VisualTransformation) null, (Function1) null, (MutableInteractionSourceImpl) null, solidColor, Expect_jvmKt.rememberComposableLambda(-308372477, new SearchScreenKt$$ExternalSyntheticLambda18(mutableState6, mutableState7, (byte) 0), gapComposer), (Composer) gapComposer, 102236160, 15896);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$End$1, Alignment.Companion.Top, gapComposer, 0);
                    int iHashCode5 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer, companion);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer, updater$$ExternalSyntheticLambda0, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda1);
                    if (((TextFieldValue) mutableState6.getValue()).annotatedString.text.length() > 0) {
                        gapComposer.startReplaceGroup(-957209966);
                        boolean zChanged7 = gapComposer.changed(mutableState6);
                        Object objRememberedValue11 = gapComposer.rememberedValue();
                        if (zChanged7 || objRememberedValue11 == neverEqualPolicy) {
                            objRememberedValue11 = new AiSettingsKt$$ExternalSyntheticLambda3(mutableState6, (byte) 3);
                            gapComposer.updateRememberedValue(objRememberedValue11);
                        }
                        CardKt.IconButton((Function0) objRememberedValue11, null, false, null, null, LocalSearchScreenKt.lambda$454144867, gapComposer, 1572864, 62);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-956760218);
                        gapComposer.end(false);
                    }
                    boolean zChanged8 = gapComposer.changed(mutableState7);
                    Object objRememberedValue12 = gapComposer.rememberedValue();
                    if (zChanged8 || objRememberedValue12 == neverEqualPolicy) {
                        objRememberedValue12 = new AiSettingsKt$$ExternalSyntheticLambda3(mutableState7, (byte) 4);
                        gapComposer.updateRememberedValue(objRememberedValue12);
                    }
                    CardKt.IconButton((Function0) objRememberedValue12, null, false, null, null, Expect_jvmKt.rememberComposableLambda(1464280030, new QueueKt$$ExternalSyntheticLambda39(mutableState7, (byte) 17), gapComposer), gapComposer, 1572864, 62);
                    gapComposer.end(true);
                    gapComposer.end(true);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 15:
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj6;
                ArrayList arrayList = (ArrayList) obj5;
                Set set = (Set) obj4;
                Function1 function7 = (Function1) obj3;
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer9;
                if (gapComposer10.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    Modifier.Companion companion5 = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(companion5, 1.0f), 300.0f);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer10, 0);
                    int iHashCode6 = Long.hashCode(gapComposer10.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer10.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer10, modifierM145height3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer10.startReusableNode();
                    if (gapComposer10.inserting) {
                        gapComposer10.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer10.useNode();
                    }
                    Stack.m390setimpl(gapComposer10, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer10, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer10, Integer.valueOf(iHashCode6), updater$$ExternalSyntheticLambda0);
                    Stack.m389reconcileimpl(gapComposer10);
                    Stack.m390setimpl(gapComposer10, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda1);
                    String strStringResource = MathKt.stringResource(R.string.lyrics_provider_priority_desc, gapComposer10);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource, OffsetKt.m139paddingqDBjuR0$default(companion5, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 7), ((MaterialTheme$Values) gapComposer10.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer10.consume(staticProvidableCompositionLocal2)).typography.bodySmall, gapComposer10, 48, 0, 131064);
                    boolean zChangedInstance2 = gapComposer10.changedInstance(arrayList) | gapComposer10.changedInstance(set) | gapComposer10.changed(function7);
                    Object objRememberedValue13 = gapComposer10.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue13 == neverEqualPolicy) {
                        objRememberedValue13 = new MainActivity$$ExternalSyntheticLambda21((Object) arrayList, (Object) function7, (Object) set, (byte) 28);
                        gapComposer10.updateRememberedValue(objRememberedValue13);
                    }
                    DialogKt.DraggableLyricsProviderList(snapshotStateList, (Function1) objRememberedValue13, SizeKt.fillMaxWidth(companion5, 1.0f).then(new LayoutWeightElement(1.0f, true)), gapComposer10, 6);
                    gapComposer10.end(true);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            default:
                MutableState mutableState8 = (MutableState) obj6;
                MutableState mutableState9 = (MutableState) obj5;
                MutableState mutableState10 = (MutableState) obj4;
                MutableState mutableState11 = (MutableState) obj3;
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer10;
                if (gapComposer11.shouldExecute(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                    ScrollState scrollStateRememberScrollState = ImageKt.rememberScrollState(gapComposer11);
                    Modifier.Companion companion6 = Modifier.Companion.$$INSTANCE;
                    Modifier modifierScroll$default = ImageKt.scroll$default(companion6, scrollStateRememberScrollState, true);
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Start, gapComposer11, 6);
                    int iHashCode7 = Long.hashCode(gapComposer11.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope7 = gapComposer11.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier7 = ZIndexModifierKt.materializeModifier(gapComposer11, modifierScroll$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer11.startReusableNode();
                    if (gapComposer11.inserting) {
                        gapComposer11.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer11.useNode();
                    }
                    Stack.m390setimpl(gapComposer11, columnMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer11, persistentCompositionLocalHashMapCurrentCompositionLocalScope7, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer11, Integer.valueOf(iHashCode7), updater$$ExternalSyntheticLambda0);
                    Stack.m389reconcileimpl(gapComposer11);
                    Stack.m390setimpl(gapComposer11, modifierMaterializeModifier7, updater$$ExternalSyntheticLambda1);
                    String str4 = (String) mutableState8.getValue();
                    boolean z3 = !((Boolean) mutableState11.getValue()).booleanValue();
                    boolean zChanged9 = gapComposer11.changed(mutableState8) | gapComposer11.changed(mutableState9);
                    Object objRememberedValue14 = gapComposer11.rememberedValue();
                    if (zChanged9 || objRememberedValue14 == neverEqualPolicy) {
                        objRememberedValue14 = new AlbumMenuKt$$ExternalSyntheticLambda8(mutableState8, mutableState9, (byte) 8);
                        gapComposer11.updateRememberedValue(objRememberedValue14);
                    }
                    ScrimKt.OutlinedTextField(str4, (Function1) objRememberedValue14, null, z3, false, null, LastFMSettingsKt.lambda$1923122485, null, null, null, null, null, null, null, true, 0, 0, null, null, gapComposer11, 1572864, 12582912, 8257460);
                    String str5 = (String) mutableState10.getValue();
                    PasswordVisualTransformation passwordVisualTransformation = new PasswordVisualTransformation();
                    KeyboardOptions keyboardOptions2 = new KeyboardOptions(7, 0, ControlFramesKt.MAX_CLOSE_REASON_MESSAGE_SIZE);
                    boolean z4 = !((Boolean) mutableState11.getValue()).booleanValue();
                    boolean zChanged10 = gapComposer11.changed(mutableState10) | gapComposer11.changed(mutableState9);
                    Object objRememberedValue15 = gapComposer11.rememberedValue();
                    if (zChanged10 || objRememberedValue15 == neverEqualPolicy) {
                        objRememberedValue15 = new AlbumMenuKt$$ExternalSyntheticLambda8(mutableState10, mutableState9, (byte) 9);
                        gapComposer11.updateRememberedValue(objRememberedValue15);
                    }
                    ScrimKt.OutlinedTextField(str5, (Function1) objRememberedValue15, null, z4, false, null, LastFMSettingsKt.lambda$1427564318, null, null, null, null, passwordVisualTransformation, keyboardOptions2, null, true, 0, 0, null, null, gapComposer11, 1572864, 12779520, 8208308);
                    String str6 = (String) mutableState9.getValue();
                    if (str6 == null) {
                        gapComposer11.startReplaceGroup(-370368517);
                        gapComposer11.end(false);
                        companion2 = companion6;
                    } else {
                        gapComposer11.startReplaceGroup(-370368516);
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                        companion2 = companion6;
                        TextKt.m352TextNvy7gAk(str6, OffsetKt.m139paddingqDBjuR0$default(companion6, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13), ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal3)).colorScheme.error, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal3)).typography.bodySmall, gapComposer11, 48, 0, 131064);
                        gapComposer11.end(false);
                    }
                    if (((Boolean) mutableState11.getValue()).booleanValue()) {
                        gapComposer11.startReplaceGroup(-369931385);
                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion2, 1.0f);
                        RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(OffsetKt.Center, Alignment.Companion.CenterVertically, gapComposer11, 54);
                        int iHashCode8 = Long.hashCode(gapComposer11.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope8 = gapComposer11.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier8 = ZIndexModifierKt.materializeModifier(gapComposer11, modifierFillMaxWidth2);
                        gapComposer11.startReusableNode();
                        if (gapComposer11.inserting) {
                            gapComposer11.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer11.useNode();
                        }
                        Stack.m390setimpl(gapComposer11, rowMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                        Stack.m390setimpl(gapComposer11, persistentCompositionLocalHashMapCurrentCompositionLocalScope8, updater$$ExternalSyntheticLambda2);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode8, gapComposer11, updater$$ExternalSyntheticLambda0, gapComposer11);
                        Stack.m390setimpl(gapComposer11, modifierMaterializeModifier8, updater$$ExternalSyntheticLambda1);
                        DialogKt.m1464CircularProgressIndicatorLxG7B9w(CropImageView.DEFAULT_ASPECT_RATIO, 0, 6, 30, 0L, 0L, gapComposer11, SizeKt.m151size3ABfNKs(companion2, 16.0f));
                        OffsetKt.Spacer(gapComposer11, SizeKt.m151size3ABfNKs(companion2, 8.0f));
                        TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.logging_in, gapComposer11), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer11.consume(MaterialThemeKt._localMaterialTheme)).typography.bodySmall, gapComposer11, 0, 0, 131070);
                        z2 = true;
                        gapComposer11.end(true);
                        gapComposer11.end(false);
                    } else {
                        z2 = true;
                        gapComposer11.startReplaceGroup(-369212557);
                        gapComposer11.end(false);
                    }
                    gapComposer11.end(z2);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ CrossfadeKt$$ExternalSyntheticLambda3(Object obj, Object obj2, Object obj3, Object obj4, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
    }

    public /* synthetic */ CrossfadeKt$$ExternalSyntheticLambda3(Object obj, Object obj2, Object obj3, Object obj4, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
    }
}
