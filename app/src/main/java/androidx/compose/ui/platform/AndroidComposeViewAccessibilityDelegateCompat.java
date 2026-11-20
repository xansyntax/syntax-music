package androidx.compose.ui.platform;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ClipDescription;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Trace;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TtsSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.collection.ArraySet;
import androidx.collection.ArraySetKt;
import androidx.collection.IntIntMapKt;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.IntListKt;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.ScatterSetKt;
import androidx.collection.SparseArrayCompat;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.InnerNodeCoordinator;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda1;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.AdjustedSemanticsNode;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsSortKt;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.UrlAnnotation;
import androidx.compose.ui.text.VerbatimTtsAnnotation;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.ComposeClickableSpan;
import androidx.compose.ui.text.style.ColorStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.os.BuildCompat;
import androidx.core.provider.CallbackWrapper;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat$Api34Impl;
import androidx.datastore.core.AtomicInt;
import androidx.emoji2.text.EmojiProcessor;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import coil3.Extras;
import coil3.size.SizeKt;
import com.google.common.math.IntMath;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import dagger.hilt.EntryPoints;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteChannelKt;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatRange;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator;
import kotlinx.coroutines.channels.ChannelIterator;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat implements View.OnAttachStateChangeListener, android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener, android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener {
    public static final MutableIntList AccessibilityActionsResourceIds = IntListKt.intListOf(R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31);
    public final String ExtraDataTestTraversalAfterVal;
    public final String ExtraDataTestTraversalBeforeVal;
    public int accessibilityCursorPosition;
    public int accessibilityFocusedVirtualViewId;
    public final SparseArrayCompat actionIdToLabel;
    public final BufferedChannel boundsUpdateChannel;
    public boolean checkingForSemanticsChanges;
    public MutableIntObjectMap currentSemanticsNodes;
    public boolean currentSemanticsNodesInvalidated;
    public AccessibilityNodeInfoCompat currentlyAccessibilityFocusedANI;
    public AccessibilityNodeInfoCompat currentlyFocusedANI;
    public final MutableIntIntMap drawingOrder;
    public int focusedVirtualViewId;
    public final MutableIntIntMap idToAfterMap;
    public final MutableIntIntMap idToBeforeMap;
    public final SparseArrayCompat labelToActionId;
    public final ComposeAccessibilityNodeProvider nodeProvider;
    public final MutableIntSet paneDisplayed;
    public final MutableIntObjectMap pendingHorizontalScrollEvents;
    public PendingTextTraversedEvent pendingTextTraversedEvent;
    public final MutableIntObjectMap pendingVerticalScrollEvents;
    public final MutableIntObjectMap previousSemanticsNodes;
    public SemanticsNodeCopy previousSemanticsRoot;
    public Integer previousTraversedNode;
    public final AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda2 scheduleScrollEventIfNeededLambda;
    public final ArrayList scrollObservationScopes;
    public final ActivityCompat$$ExternalSyntheticLambda0 semanticsChangeChecker;
    public boolean sendingFocusAffectingEvent;
    public final ArraySet subtreeChangedLayoutNodes;
    public final EmojiProcessor urlSpanCache;
    public final AndroidComposeView view;
    public int hoveredVirtualViewId = Integer.MIN_VALUE;
    public final AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda2 onSendAccessibilityEvent = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda2(this, 0);
    public long SendRecurringAccessibilityEventsIntervalMillis = 100;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api37Impl {
        /* JADX WARN: Code duplicated, block: B:13:0x0034  */
        public static final void setExtraRenderingInfo(SemanticsNode semanticsNode, AccessibilityNodeInfo accessibilityNodeInfo) {
            Integer numValueOf;
            AnnotatedString annotatedString;
            Object obj;
            SpanStyle spanStyle;
            LayoutNode layoutNode = semanticsNode.layoutNode;
            SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
            Owner owner = layoutNode.owner;
            Integer numValueOf2 = null;
            if ((owner instanceof AndroidComposeView ? (AndroidComposeView) owner : null) == null) {
                return;
            }
            AccessibilityNodeInfo.ExtraRenderingInfo.Builder builder = new AccessibilityNodeInfo.ExtraRenderingInfo.Builder();
            TextLayoutResult textLayoutResult = InvertMatrixKt.getTextLayoutResult(semanticsConfiguration);
            if (textLayoutResult != null) {
                long jM752getColor0d7_KjU = textLayoutResult.layoutInput.style.m752getColor0d7_KjU();
                if (jM752getColor0d7_KjU != 16) {
                    numValueOf = Integer.valueOf(ColorKt.m498toArgb8_81llA(jM752getColor0d7_KjU));
                } else {
                    numValueOf = null;
                }
            } else {
                numValueOf = null;
            }
            if (numValueOf != null) {
                builder.setTextColor(numValueOf.intValue());
            }
            Object obj2 = semanticsConfiguration.props.get(SemanticsProperties.Text);
            if (obj2 == null) {
                obj2 = null;
            }
            List list = (List) obj2;
            if (list != null && (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) != null) {
                List linkAnnotations = annotatedString.getLinkAnnotations(annotatedString.text.length());
                ArrayList arrayList = new ArrayList(linkAnnotations.size());
                int size = linkAnnotations.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    TextLinkStyles styles = ((LinkAnnotation) ((AnnotatedString.Range) linkAnnotations.get(i2)).item).getStyles();
                    Color color = (styles == null || (spanStyle = styles.style) == null) ? null : new Color(spanStyle.textForegroundStyle.mo768getColor0d7_KjU());
                    if (color != null) {
                        arrayList.add(color);
                    }
                }
                int size2 = arrayList.size();
                while (true) {
                    if (i >= size2) {
                        obj = null;
                        break;
                    }
                    obj = arrayList.get(i);
                    if (((Color) obj).value != 16) {
                        break;
                    } else {
                        i++;
                    }
                }
                Color color2 = (Color) obj;
                if (color2 != null) {
                    numValueOf2 = Integer.valueOf(ColorKt.m498toArgb8_81llA(color2.value));
                }
            }
            if (numValueOf2 != null) {
                builder.setLinkTextColor(numValueOf2.intValue());
            }
            accessibilityNodeInfo.setExtraRenderingInfo(builder.build());
        }

        public static final void setInputTextSuggestionTextChangeTypes(SemanticsNode semanticsNode, AccessibilityEvent accessibilityEvent) {
            SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
            Object obj = semanticsConfiguration.props.get(SemanticsProperties.InputTextSuggestionState);
            if (obj == null) {
                obj = null;
            }
            if (obj != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
            } else {
                Object obj2 = semanticsConfiguration.props.get(SemanticsProperties.TextCompositionRange);
                accessibilityEvent.setTextChangeTypes((((TextRange) (obj2 != null ? obj2 : null)) != null ? 1 : 0) | accessibilityEvent.getTextChangeTypes());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ComposeAccessibilityNodeProvider extends AtomicInt {
        public ComposeAccessibilityNodeProvider() {
            super((byte) 6);
        }

        @Override // androidx.datastore.core.AtomicInt
        public final void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
            AndroidComposeViewAccessibilityDelegateCompat.this.addExtraDataToAccessibilityNodeInfoHelper(i, accessibilityNodeInfoCompat, str, bundle);
        }

        /* JADX WARN: Code duplicated, block: B:107:0x0217  */
        /* JADX WARN: Code duplicated, block: B:109:0x0223  */
        /* JADX WARN: Code duplicated, block: B:111:0x023b  */
        /* JADX WARN: Code duplicated, block: B:117:0x0252  */
        /* JADX WARN: Code duplicated, block: B:118:0x025c  */
        /* JADX WARN: Code duplicated, block: B:121:0x026b  */
        /* JADX WARN: Code duplicated, block: B:123:0x0285  */
        /* JADX WARN: Code duplicated, block: B:125:0x028e  */
        /* JADX WARN: Code duplicated, block: B:128:0x02dc  */
        /* JADX WARN: Code duplicated, block: B:130:0x02e0  */
        /* JADX WARN: Code duplicated, block: B:131:0x02e6  */
        /* JADX WARN: Code duplicated, block: B:137:0x0306 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:138:0x0308  */
        /* JADX WARN: Code duplicated, block: B:139:0x030b  */
        /* JADX WARN: Code duplicated, block: B:141:0x030f  */
        /* JADX WARN: Code duplicated, block: B:142:0x0312  */
        /* JADX WARN: Code duplicated, block: B:145:0x0323  */
        /* JADX WARN: Code duplicated, block: B:147:0x0329  */
        /* JADX WARN: Code duplicated, block: B:150:0x0335  */
        /* JADX WARN: Code duplicated, block: B:152:0x033f  */
        /* JADX WARN: Code duplicated, block: B:155:0x0350  */
        /* JADX WARN: Code duplicated, block: B:158:0x0386  */
        /* JADX WARN: Code duplicated, block: B:161:0x0391  */
        /* JADX WARN: Code duplicated, block: B:163:0x03a1  */
        /* JADX WARN: Code duplicated, block: B:169:0x03bf  */
        /* JADX WARN: Code duplicated, block: B:172:0x03c7  */
        /* JADX WARN: Code duplicated, block: B:174:0x03d9 A[LOOP:4: B:171:0x03c5->B:174:0x03d9, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:179:0x03f6  */
        /* JADX WARN: Code duplicated, block: B:181:0x0406  */
        /* JADX WARN: Code duplicated, block: B:189:0x042b  */
        /* JADX WARN: Code duplicated, block: B:191:0x0445  */
        /* JADX WARN: Code duplicated, block: B:195:0x046c  */
        /* JADX WARN: Code duplicated, block: B:197:0x047a  */
        /* JADX WARN: Code duplicated, block: B:205:0x04ae  */
        /* JADX WARN: Code duplicated, block: B:207:0x04b8  */
        /* JADX WARN: Code duplicated, block: B:209:0x04c8  */
        /* JADX WARN: Code duplicated, block: B:212:0x04d6  */
        /* JADX WARN: Code duplicated, block: B:215:0x04f2  */
        /* JADX WARN: Code duplicated, block: B:217:0x04fe  */
        /* JADX WARN: Code duplicated, block: B:220:0x0508  */
        /* JADX WARN: Code duplicated, block: B:223:0x0515  */
        /* JADX WARN: Code duplicated, block: B:224:0x0519  */
        /* JADX WARN: Code duplicated, block: B:227:0x0531  */
        /* JADX WARN: Code duplicated, block: B:230:0x0537  */
        /* JADX WARN: Code duplicated, block: B:232:0x053b  */
        /* JADX WARN: Code duplicated, block: B:233:0x0540  */
        /* JADX WARN: Code duplicated, block: B:235:0x0544  */
        /* JADX WARN: Code duplicated, block: B:238:0x0550  */
        /* JADX WARN: Code duplicated, block: B:241:0x0556  */
        /* JADX WARN: Code duplicated, block: B:243:0x055c  */
        /* JADX WARN: Code duplicated, block: B:244:0x0560  */
        /* JADX WARN: Code duplicated, block: B:246:0x0567  */
        /* JADX WARN: Code duplicated, block: B:249:0x0571  */
        /* JADX WARN: Code duplicated, block: B:254:0x0583  */
        /* JADX WARN: Code duplicated, block: B:256:0x058b  */
        /* JADX WARN: Code duplicated, block: B:259:0x0591  */
        /* JADX WARN: Code duplicated, block: B:25:0x0085  */
        /* JADX WARN: Code duplicated, block: B:260:0x0598  */
        /* JADX WARN: Code duplicated, block: B:264:0x05a5  */
        /* JADX WARN: Code duplicated, block: B:267:0x05ab  */
        /* JADX WARN: Code duplicated, block: B:269:0x05ae  */
        /* JADX WARN: Code duplicated, block: B:272:0x05c5 A[LOOP:8: B:268:0x05ac->B:272:0x05c5, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:275:0x05cd  */
        /* JADX WARN: Code duplicated, block: B:278:0x05d8  */
        /* JADX WARN: Code duplicated, block: B:27:0x0092  */
        /* JADX WARN: Code duplicated, block: B:281:0x05de  */
        /* JADX WARN: Code duplicated, block: B:284:0x05e9  */
        /* JADX WARN: Code duplicated, block: B:287:0x05ef  */
        /* JADX WARN: Code duplicated, block: B:288:0x05f6  */
        /* JADX WARN: Code duplicated, block: B:28:0x0096  */
        /* JADX WARN: Code duplicated, block: B:291:0x0600  */
        /* JADX WARN: Code duplicated, block: B:294:0x0606  */
        /* JADX WARN: Code duplicated, block: B:297:0x0610  */
        /* JADX WARN: Code duplicated, block: B:299:0x061a  */
        /* JADX WARN: Code duplicated, block: B:300:0x061e  */
        /* JADX WARN: Code duplicated, block: B:303:0x0636  */
        /* JADX WARN: Code duplicated, block: B:306:0x0649  */
        /* JADX WARN: Code duplicated, block: B:309:0x064f  */
        /* JADX WARN: Code duplicated, block: B:310:0x0654  */
        /* JADX WARN: Code duplicated, block: B:313:0x066e  */
        /* JADX WARN: Code duplicated, block: B:315:0x0681  */
        /* JADX WARN: Code duplicated, block: B:316:0x0688  */
        /* JADX WARN: Code duplicated, block: B:31:0x009e  */
        /* JADX WARN: Code duplicated, block: B:321:0x0696  */
        /* JADX WARN: Code duplicated, block: B:324:0x06a0  */
        /* JADX WARN: Code duplicated, block: B:325:0x06a8  */
        /* JADX WARN: Code duplicated, block: B:328:0x06b3  */
        /* JADX WARN: Code duplicated, block: B:331:0x06bf  */
        /* JADX WARN: Code duplicated, block: B:334:0x06c5  */
        /* JADX WARN: Code duplicated, block: B:336:0x06c9  */
        /* JADX WARN: Code duplicated, block: B:33:0x00a6  */
        /* JADX WARN: Code duplicated, block: B:343:0x06de  */
        /* JADX WARN: Code duplicated, block: B:346:0x06e7  */
        /* JADX WARN: Code duplicated, block: B:348:0x06ef  */
        /* JADX WARN: Code duplicated, block: B:34:0x00a9  */
        /* JADX WARN: Code duplicated, block: B:366:0x0711  */
        /* JADX WARN: Code duplicated, block: B:36:0x00b0  */
        /* JADX WARN: Code duplicated, block: B:374:0x073b  */
        /* JADX WARN: Code duplicated, block: B:376:0x0745  */
        /* JADX WARN: Code duplicated, block: B:379:0x075b  */
        /* JADX WARN: Code duplicated, block: B:382:0x076d  */
        /* JADX WARN: Code duplicated, block: B:384:0x0777  */
        /* JADX WARN: Code duplicated, block: B:387:0x078d  */
        /* JADX WARN: Code duplicated, block: B:38:0x00b6  */
        /* JADX WARN: Code duplicated, block: B:390:0x07a4  */
        /* JADX WARN: Code duplicated, block: B:397:0x07d0  */
        /* JADX WARN: Code duplicated, block: B:398:0x07d8  */
        /* JADX WARN: Code duplicated, block: B:39:0x00bd  */
        /* JADX WARN: Code duplicated, block: B:400:0x07db  */
        /* JADX WARN: Code duplicated, block: B:408:0x080d  */
        /* JADX WARN: Code duplicated, block: B:409:0x0810  */
        /* JADX WARN: Code duplicated, block: B:418:0x084c  */
        /* JADX WARN: Code duplicated, block: B:41:0x00c0  */
        /* JADX WARN: Code duplicated, block: B:420:0x0858  */
        /* JADX WARN: Code duplicated, block: B:424:0x0862  */
        /* JADX WARN: Code duplicated, block: B:426:0x086a  */
        /* JADX WARN: Code duplicated, block: B:428:0x0870  */
        /* JADX WARN: Code duplicated, block: B:436:0x0888  */
        /* JADX WARN: Code duplicated, block: B:438:0x088e  */
        /* JADX WARN: Code duplicated, block: B:43:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:440:0x0898  */
        /* JADX WARN: Code duplicated, block: B:442:0x08a0  */
        /* JADX WARN: Code duplicated, block: B:444:0x08a3  */
        /* JADX WARN: Code duplicated, block: B:447:0x08a8  */
        /* JADX WARN: Code duplicated, block: B:469:0x0904  */
        /* JADX WARN: Code duplicated, block: B:472:0x0911  */
        /* JADX WARN: Code duplicated, block: B:475:0x0932  */
        /* JADX WARN: Code duplicated, block: B:477:0x093e  */
        /* JADX WARN: Code duplicated, block: B:478:0x0944  */
        /* JADX WARN: Code duplicated, block: B:481:0x094d  */
        /* JADX WARN: Code duplicated, block: B:482:0x0965  */
        /* JADX WARN: Code duplicated, block: B:489:0x098b  */
        /* JADX WARN: Code duplicated, block: B:492:0x0990  */
        /* JADX WARN: Code duplicated, block: B:495:0x09ab  */
        /* JADX WARN: Code duplicated, block: B:498:0x09b0  */
        /* JADX WARN: Code duplicated, block: B:499:0x09b6  */
        /* JADX WARN: Code duplicated, block: B:502:0x09be  */
        /* JADX WARN: Code duplicated, block: B:504:0x09ca  */
        /* JADX WARN: Code duplicated, block: B:507:0x09cf  */
        /* JADX WARN: Code duplicated, block: B:513:0x0a06  */
        /* JADX WARN: Code duplicated, block: B:515:0x0a09  */
        /* JADX WARN: Code duplicated, block: B:517:0x0a17  */
        /* JADX WARN: Code duplicated, block: B:51:0x0100  */
        /* JADX WARN: Code duplicated, block: B:520:0x0a1b  */
        /* JADX WARN: Code duplicated, block: B:523:0x0a30  */
        /* JADX WARN: Code duplicated, block: B:526:0x0a3a  */
        /* JADX WARN: Code duplicated, block: B:528:0x0a42  */
        /* JADX WARN: Code duplicated, block: B:530:0x0a4d  */
        /* JADX WARN: Code duplicated, block: B:531:0x0a50  */
        /* JADX WARN: Code duplicated, block: B:533:0x0a56  */
        /* JADX WARN: Code duplicated, block: B:536:0x0a5e  */
        /* JADX WARN: Code duplicated, block: B:538:0x0a67  */
        /* JADX WARN: Code duplicated, block: B:539:0x0a6a  */
        /* JADX WARN: Code duplicated, block: B:54:0x0113  */
        /* JADX WARN: Code duplicated, block: B:565:0x0ade  */
        /* JADX WARN: Code duplicated, block: B:568:0x0ae5  */
        /* JADX WARN: Code duplicated, block: B:571:0x0af9  */
        /* JADX WARN: Code duplicated, block: B:573:0x0b03  */
        /* JADX WARN: Code duplicated, block: B:576:0x0b19  */
        /* JADX WARN: Code duplicated, block: B:579:0x0b2f  */
        /* JADX WARN: Code duplicated, block: B:57:0x0120  */
        /* JADX WARN: Code duplicated, block: B:582:0x0b43  */
        /* JADX WARN: Code duplicated, block: B:584:0x0b53  */
        /* JADX WARN: Code duplicated, block: B:586:0x0b63  */
        /* JADX WARN: Code duplicated, block: B:590:0x0b71  */
        /* JADX WARN: Code duplicated, block: B:592:0x0b74  */
        /* JADX WARN: Code duplicated, block: B:594:0x0b87  */
        /* JADX WARN: Code duplicated, block: B:596:0x0b92  */
        /* JADX WARN: Code duplicated, block: B:597:0x0ba2  */
        /* JADX WARN: Code duplicated, block: B:601:0x0bb7  */
        /* JADX WARN: Code duplicated, block: B:603:0x0bbd  */
        /* JADX WARN: Code duplicated, block: B:604:0x0bbf  */
        /* JADX WARN: Code duplicated, block: B:606:0x0bc9  */
        /* JADX WARN: Code duplicated, block: B:608:0x0bd0  */
        /* JADX WARN: Code duplicated, block: B:60:0x012d  */
        /* JADX WARN: Code duplicated, block: B:610:0x0bd4  */
        /* JADX WARN: Code duplicated, block: B:612:0x0be1  */
        /* JADX WARN: Code duplicated, block: B:616:0x0bf4  */
        /* JADX WARN: Code duplicated, block: B:618:0x0bff  */
        /* JADX WARN: Code duplicated, block: B:622:0x0c1c  */
        /* JADX WARN: Code duplicated, block: B:624:0x0c22  */
        /* JADX WARN: Code duplicated, block: B:625:0x0c27  */
        /* JADX WARN: Code duplicated, block: B:627:0x0c2a  */
        /* JADX WARN: Code duplicated, block: B:628:0x0c30  */
        /* JADX WARN: Code duplicated, block: B:630:0x0c3c  */
        /* JADX WARN: Code duplicated, block: B:633:0x0c47  */
        /* JADX WARN: Code duplicated, block: B:635:0x0c4d  */
        /* JADX WARN: Code duplicated, block: B:636:0x0c52  */
        /* JADX WARN: Code duplicated, block: B:638:0x0c55  */
        /* JADX WARN: Code duplicated, block: B:63:0x0134  */
        /* JADX WARN: Code duplicated, block: B:641:0x0c68  */
        /* JADX WARN: Code duplicated, block: B:651:0x0c7c  */
        /* JADX WARN: Code duplicated, block: B:660:0x035c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:666:0x03ec A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:673:0x044f A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:678:0x05ca A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:679:0x05ba A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:680:0x0885 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:682:0x0880 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:690:0x0245 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:69:0x014c  */
        /* JADX WARN: Code duplicated, block: B:70:0x015b  */
        /* JADX WARN: Code duplicated, block: B:72:0x015e  */
        /* JADX WARN: Code duplicated, block: B:73:0x016d  */
        /* JADX WARN: Code duplicated, block: B:79:0x017e  */
        /* JADX WARN: Code duplicated, block: B:7:0x002c  */
        /* JADX WARN: Code duplicated, block: B:80:0x0182  */
        /* JADX WARN: Code duplicated, block: B:83:0x01a2  */
        /* JADX WARN: Code duplicated, block: B:84:0x01a7  */
        /* JADX WARN: Code duplicated, block: B:87:0x01b0  */
        /* JADX WARN: Instruction removed from duplicated block: B:651:0x0c7c, please report this as an issue */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v27, types: [androidx.compose.ui.semantics.SemanticsNode[], java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r3v32, types: [kotlin.collections.EmptyList] */
        /* JADX WARN: Type inference failed for: r3v33, types: [java.util.Collection, java.util.List] */
        /* JADX WARN: Type inference failed for: r3v37, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r4v38 */
        /* JADX WARN: Type inference failed for: r4v39, types: [java.util.Collection, java.util.List] */
        /* JADX WARN: Type inference failed for: r4v48, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r9v86, types: [androidx.compose.ui.semantics.SemanticsNode] */
        @Override // androidx.datastore.core.AtomicInt
        public final AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
            int i2;
            SemanticsNode parent;
            Integer numValueOf;
            int iIntValue;
            SparseArrayCompat sparseArrayCompat;
            Resources resources;
            AdjustedSemanticsNode adjustedSemanticsNode;
            boolean z;
            SemanticsConfiguration semanticsConfiguration;
            MutableScatterMap mutableScatterMap;
            Object obj;
            Role role;
            AndroidComposeView androidComposeView;
            android.view.accessibility.AccessibilityManager accessibilityManager;
            boolean zIsRequestFromAccessibilityTool;
            Object obj2;
            boolean zBooleanValue;
            List children$ui;
            int size;
            int i3;
            AdjustedSemanticsNode adjustedSemanticsNode2;
            int i4;
            AccessibilityNodeInfo accessibilityNodeInfo;
            AnnotatedString infoText;
            SemanticsNode semanticsNode;
            SemanticsConfiguration semanticsConfiguration2;
            Role role2;
            AccessibilityNodeInfo accessibilityNodeInfo2;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
            SpannableString spannableString;
            AccessibilityNodeInfo accessibilityNodeInfo3;
            SemanticsPropertyKey semanticsPropertyKey;
            AccessibilityNodeInfo accessibilityNodeInfo4;
            SemanticsNode semanticsNode2;
            String infoStateDescriptionOrNull;
            Object obj3;
            ToggleableState toggleableState;
            Object obj4;
            Boolean bool;
            Role role3;
            int i5;
            SemanticsConfiguration semanticsConfiguration3;
            Object obj5;
            List list;
            String str;
            Object obj6;
            String str2;
            Object obj7;
            String str3;
            Object obj8;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3;
            Object obj9;
            int i6;
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat;
            Object obj10;
            Boolean bool2;
            Object obj11;
            Integer num;
            int iIntValue2;
            SemanticsPropertyKey semanticsPropertyKey2;
            boolean z2;
            SemanticsNode parent2;
            Object obj12;
            LiveRegionMode liveRegionMode;
            Object obj13;
            AccessibilityAction accessibilityAction;
            AccessibilityAction accessibilityAction2;
            AccessibilityAction accessibilityAction3;
            String iterableTextForAccessibility;
            ArrayList arrayList;
            CharSequence text;
            ProgressBarRangeInfo progressBarRangeInfo;
            ScrollAxisRange scrollAxisRange;
            ScrollAxisRange scrollAxisRange2;
            boolean z3;
            int orDefault;
            AndroidComposeView androidComposeView2;
            int orDefault2;
            String str4;
            AndroidViewsHandler androidViewsHandler$ui;
            AndroidViewHolder androidViewHolderSemanticsIdToView;
            AndroidViewsHandler androidViewsHandler$ui2;
            AndroidViewHolder androidViewHolderSemanticsIdToView2;
            AccessibilityAction accessibilityAction4;
            AccessibilityAction accessibilityAction5;
            AccessibilityAction accessibilityAction6;
            SemanticsPropertyKey semanticsPropertyKey3;
            List list2;
            int size2;
            MutableIntList mutableIntList;
            int i7;
            MutableObjectIntMap mutableObjectIntMap;
            int[] iArr;
            int i8;
            int[] iArrCopyOf;
            int i9;
            int i10;
            ArrayList arrayList2;
            int i11;
            Object obj14;
            boolean zPopulateAccessibilityNodeInfoProperties$canScrollForward;
            LayoutDirection layoutDirection;
            LayoutNode layoutNode;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2;
            Object obj15;
            Object obj16;
            AccessibilityAction accessibilityAction7;
            float f;
            ClosedFloatRange closedFloatRange;
            SemanticsPropertyKey semanticsPropertyKey4;
            float fFloatValue;
            float fFloatValue2;
            float fFloatValue3;
            float fFloatValue4;
            CharSequence text2;
            AccessibilityAction accessibilityAction8;
            String str5;
            List list3;
            LayoutNode parent$ui;
            SemanticsConfiguration semanticsConfiguration4;
            boolean zAreEqual;
            Object obj17;
            SemanticsConfiguration semanticsConfiguration5;
            boolean z4;
            Object obj18;
            AccessibilityAction accessibilityAction9;
            AccessibilityAction accessibilityAction10;
            AccessibilityAction accessibilityAction11;
            AccessibilityAction accessibilityAction12;
            ClipDescription primaryClipDescription;
            boolean zHasMimeType;
            Object obj19;
            boolean z5;
            boolean z6;
            boolean z7;
            int i12;
            int orDefault3;
            SemanticsNode parent3;
            boolean zBooleanValue2;
            SemanticsConfiguration semanticsConfiguration6;
            SemanticsPropertyKey semanticsPropertyKey5;
            boolean zBooleanValue3;
            Object obj20;
            Density density;
            EmojiProcessor emojiProcessor;
            SpannableString spannableString2;
            List list4;
            ArrayList arrayList3;
            EmojiProcessor emojiProcessor2;
            SpannableString spannableString3;
            ?? arrayList4;
            ?? arrayList5;
            int size3;
            int i13;
            int size4;
            int i14;
            EmojiProcessor emojiProcessor3;
            List linkAnnotations;
            int size5;
            int i15;
            AnnotatedString.Range range;
            int i16;
            Object obj21;
            int i17;
            LinkAnnotation linkAnnotation;
            WeakHashMap weakHashMap;
            Object composeClickableSpan;
            UrlAnnotation urlAnnotation;
            WeakHashMap weakHashMap2;
            Object uRLSpan;
            int size6;
            int i18;
            AnnotatedString.Range range2;
            VerbatimTtsAnnotation verbatimTtsAnnotation;
            int i19;
            int i20;
            int size7;
            int i21;
            AnnotatedString.Range range3;
            int size8;
            int i22;
            int i23;
            int i24;
            long jMo768getColor0d7_KjU;
            FontWeight fontWeight;
            FontStyle fontStyle;
            TextGeometricTransform textGeometricTransform;
            long j;
            TextDecoration textDecoration;
            TextForegroundStyle colorStyle;
            SpannableString spannableString4;
            FontWeight fontWeight2;
            int i25;
            int i26;
            int i27;
            byte b;
            String strM713toLegacyClassNameV4PA4sw;
            Object parentForAccessibility;
            View view;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat4;
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat2 = AndroidComposeViewAccessibilityDelegateCompat.this;
            AndroidComposeView androidComposeView3 = androidComposeViewAccessibilityDelegateCompat2.view;
            if (((LifecycleRegistry) androidComposeView3.getComposeViewContext().getLifecycleOwner$ui().getLifecycle()).state == Lifecycle.State.DESTROYED) {
                if (androidComposeViewAccessibilityDelegateCompat2.isAccessibilityEnabled()) {
                    accessibilityNodeInfoCompat4 = null;
                } else {
                    accessibilityNodeInfoCompat4 = new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain());
                }
                androidComposeViewAccessibilityDelegateCompat = androidComposeViewAccessibilityDelegateCompat2;
                accessibilityNodeInfoCompat3 = accessibilityNodeInfoCompat4;
                i6 = i;
            } else {
                AdjustedSemanticsNode adjustedSemanticsNode3 = (AdjustedSemanticsNode) androidComposeViewAccessibilityDelegateCompat2.getCurrentSemanticsNodes().get(i);
                if (adjustedSemanticsNode3 == null) {
                    if (androidComposeViewAccessibilityDelegateCompat2.isAccessibilityEnabled()) {
                        accessibilityNodeInfoCompat4 = null;
                    } else {
                        accessibilityNodeInfoCompat4 = new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain());
                    }
                    androidComposeViewAccessibilityDelegateCompat = androidComposeViewAccessibilityDelegateCompat2;
                    accessibilityNodeInfoCompat3 = accessibilityNodeInfoCompat4;
                    i6 = i;
                } else {
                    SemanticsNode semanticsNode3 = adjustedSemanticsNode3.semanticsNode;
                    SemanticsConfiguration config = semanticsNode3.getConfig();
                    LayoutNode layoutNode2 = semanticsNode3.layoutNode;
                    Object obj22 = config.props.get(SemanticsProperties.IsSensitiveData);
                    if (obj22 == null) {
                        obj22 = null;
                    }
                    boolean zAreEqual2 = Intrinsics.areEqual(obj22, Boolean.TRUE);
                    if (!zAreEqual2) {
                        accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
                        accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfoObtain);
                        i2 = Build.VERSION.SDK_INT;
                        if (i2 >= 34) {
                            TextViewCompat$Api34Impl.setAccessibilityDataSensitive(accessibilityNodeInfoObtain, zAreEqual2);
                        } else {
                            accessibilityNodeInfoCompat.setBooleanProperty(64, zAreEqual2);
                        }
                        if (i == -1) {
                            parentForAccessibility = androidComposeView3.getParentForAccessibility();
                            if (parentForAccessibility instanceof View) {
                                view = (View) parentForAccessibility;
                            } else {
                                view = null;
                            }
                            accessibilityNodeInfoCompat.mParentVirtualDescendantId = -1;
                            accessibilityNodeInfoObtain.setParent(view);
                        } else {
                            parent = semanticsNode3.getParent();
                            if (parent != null) {
                                numValueOf = Integer.valueOf(parent.id);
                            } else {
                                numValueOf = null;
                            }
                            if (numValueOf != null) {
                                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("semanticsNode " + i + " has null parent");
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                                return null;
                            }
                            iIntValue = numValueOf.intValue();
                            if (iIntValue == androidComposeView3.getSemanticsOwner().getUnmergedRootSemanticsNode().id) {
                                iIntValue = -1;
                            }
                            accessibilityNodeInfoCompat.mParentVirtualDescendantId = iIntValue;
                            accessibilityNodeInfoObtain.setParent(androidComposeView3, iIntValue);
                        }
                        accessibilityNodeInfoCompat.mVirtualDescendantId = i;
                        accessibilityNodeInfoObtain.setSource(androidComposeView3, i);
                        accessibilityNodeInfoObtain.setBoundsInScreen(androidComposeViewAccessibilityDelegateCompat2.boundsInScreen(adjustedSemanticsNode3));
                        sparseArrayCompat = androidComposeViewAccessibilityDelegateCompat2.labelToActionId;
                        resources = androidComposeView3.getContext().getResources();
                        adjustedSemanticsNode = (AdjustedSemanticsNode) androidComposeViewAccessibilityDelegateCompat2.getCurrentSemanticsNodes().get(i);
                        if (adjustedSemanticsNode == null) {
                            z = false;
                        } else {
                            z = false;
                        }
                        accessibilityNodeInfoCompat.setClassName("android.view.View");
                        semanticsConfiguration = semanticsNode3.unmergedConfig;
                        mutableScatterMap = semanticsConfiguration.props;
                        if (mutableScatterMap.containsKey(SemanticsProperties.EditableText)) {
                            accessibilityNodeInfoCompat.setClassName("android.widget.EditText");
                        }
                        if (mutableScatterMap.containsKey(SemanticsProperties.Text)) {
                            accessibilityNodeInfoCompat.setClassName("android.widget.TextView");
                        }
                        obj = mutableScatterMap.get(SemanticsProperties.Role);
                        if (obj == null) {
                            obj = null;
                        }
                        role = (Role) obj;
                        if (role != null) {
                            b = role.value;
                            if (semanticsNode3.isFake$ui()) {
                            }
                            androidComposeView = androidComposeView3;
                            if (b == 4) {
                                accessibilityNodeInfoObtain.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", resources.getString(R.string.tab));
                            } else if (b == 2) {
                                accessibilityNodeInfoObtain.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", resources.getString(R.string.switch_role));
                            } else {
                                strM713toLegacyClassNameV4PA4sw = InvertMatrixKt.m713toLegacyClassNameV4PA4sw(b);
                                if (b == 5) {
                                    accessibilityNodeInfoCompat.setClassName(strM713toLegacyClassNameV4PA4sw);
                                } else {
                                    accessibilityNodeInfoCompat.setClassName(strM713toLegacyClassNameV4PA4sw);
                                }
                            }
                        } else {
                            androidComposeView = androidComposeView3;
                        }
                        accessibilityNodeInfoObtain.setPackageName(androidComposeView.getContext().getPackageName());
                        accessibilityNodeInfoObtain.setImportantForAccessibility(SemanticsNodeKt.isImportantForAccessibility(semanticsNode3));
                        accessibilityManager = androidComposeView.getComposeViewContext().accessibilityManager.accessibilityManager;
                        if (i2 >= 34) {
                            zIsRequestFromAccessibilityTool = TextViewCompat$Api34Impl.isRequestFromAccessibilityTool(accessibilityManager);
                        } else {
                            zIsRequestFromAccessibilityTool = true;
                        }
                        obj2 = mutableScatterMap.get(SemanticsProperties.IsTraversalGroup);
                        if (obj2 == null) {
                            obj2 = Boolean.FALSE;
                        }
                        zBooleanValue = ((Boolean) obj2).booleanValue();
                        boolean z8 = semanticsConfiguration.isMergingSemanticsOfDescendants;
                        children$ui = semanticsNode3.getChildren$ui((4 & 1) != 0 ? !semanticsNode3.mergingEnabled : false, (4 & 2) == 0);
                        int size9 = children$ui.size();
                        if (zBooleanValue) {
                            size = children$ui.size();
                            i3 = 0;
                            int i28 = 0;
                            while (i3 < size) {
                                SemanticsNode semanticsNode4 = (SemanticsNode) children$ui.get(i3);
                                int i29 = size;
                                List list5 = children$ui;
                                adjustedSemanticsNode2 = (AdjustedSemanticsNode) androidComposeViewAccessibilityDelegateCompat2.getCurrentSemanticsNodes().get(semanticsNode4.id);
                                if (adjustedSemanticsNode2 == null) {
                                }
                                i3++;
                                size = i29;
                                children$ui = list5;
                            }
                        } else {
                            size = children$ui.size();
                            i3 = 0;
                            int i210 = 0;
                            while (i3 < size) {
                                SemanticsNode semanticsNode5 = (SemanticsNode) children$ui.get(i3);
                                int i211 = size;
                                List list6 = children$ui;
                                adjustedSemanticsNode2 = (AdjustedSemanticsNode) androidComposeViewAccessibilityDelegateCompat2.getCurrentSemanticsNodes().get(semanticsNode5.id);
                                if (adjustedSemanticsNode2 == null) {
                                }
                                i3++;
                                size = i211;
                                children$ui = list6;
                            }
                        }
                        i4 = androidComposeViewAccessibilityDelegateCompat2.accessibilityFocusedVirtualViewId;
                        accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
                        if (i == i4) {
                            accessibilityNodeInfo.setAccessibilityFocused(true);
                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                        } else {
                            accessibilityNodeInfo.setAccessibilityFocused(false);
                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
                        }
                        infoText = InvertMatrixKt.getInfoText(semanticsNode3);
                        if (infoText != null) {
                            androidComposeView.getFontFamilyResolver();
                            density = androidComposeView.getDensity();
                            emojiProcessor = androidComposeViewAccessibilityDelegateCompat2.urlSpanCache;
                            String str6 = infoText.text;
                            list4 = infoText.annotations;
                            spannableString2 = new SpannableString(str6);
                            arrayList3 = infoText.spanStylesOrNull;
                            if (arrayList3 != null) {
                                size8 = arrayList3.size();
                                i22 = 0;
                                while (i22 < size8) {
                                    int i30 = i22;
                                    AnnotatedString.Range range4 = (AnnotatedString.Range) arrayList3.get(i22);
                                    int i31 = size8;
                                    SpanStyle spanStyle = (SpanStyle) range4.item;
                                    ArrayList arrayList6 = arrayList3;
                                    i23 = range4.start;
                                    i24 = range4.end;
                                    SemanticsConfiguration semanticsConfiguration7 = semanticsConfiguration;
                                    Role role4 = role;
                                    jMo768getColor0d7_KjU = spanStyle.textForegroundStyle.mo768getColor0d7_KjU();
                                    AccessibilityNodeInfo accessibilityNodeInfo5 = accessibilityNodeInfoObtain;
                                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat5 = accessibilityNodeInfoCompat;
                                    long j2 = spanStyle.fontSize;
                                    fontWeight = spanStyle.fontWeight;
                                    fontStyle = spanStyle.fontStyle;
                                    textGeometricTransform = spanStyle.textGeometricTransform;
                                    LocaleList localeList = spanStyle.localeList;
                                    AccessibilityNodeInfo accessibilityNodeInfo6 = accessibilityNodeInfo;
                                    SemanticsNode semanticsNode6 = semanticsNode3;
                                    j = spanStyle.background;
                                    textDecoration = spanStyle.textDecoration;
                                    colorStyle = spanStyle.textForegroundStyle;
                                    EmojiProcessor emojiProcessor4 = emojiProcessor;
                                    if (!ULong.m1869equalsimpl0(jMo768getColor0d7_KjU, colorStyle.mo768getColor0d7_KjU())) {
                                        if (jMo768getColor0d7_KjU != 16) {
                                            colorStyle = new ColorStyle(jMo768getColor0d7_KjU);
                                        } else {
                                            colorStyle = TextForegroundStyle.Unspecified.INSTANCE;
                                        }
                                    }
                                    SizeKt.m871setColorRPmYEkk(spannableString2, colorStyle.mo768getColor0d7_KjU(), i23, i24);
                                    spannableString4 = spannableString2;
                                    SizeKt.m872setFontSizeKmRG4DE(spannableString4, j2, density, i23, i24);
                                    if (fontWeight == null) {
                                        if (fontWeight == null) {
                                            fontWeight2 = FontWeight.Normal;
                                        } else {
                                            fontWeight2 = fontWeight;
                                        }
                                        if (fontStyle != null) {
                                            i25 = fontStyle.value;
                                        } else {
                                            i25 = 0;
                                        }
                                        StyleSpan styleSpan = new StyleSpan(DatabaseDao_Impl.AnonymousClass17.m1061getAndroidTypefaceStyleFO1MlWM(fontWeight2, i25));
                                        i26 = 33;
                                        spannableString4.setSpan(styleSpan, i23, i24, 33);
                                    } else {
                                        if (fontWeight == null) {
                                            fontWeight2 = FontWeight.Normal;
                                        } else {
                                            fontWeight2 = fontWeight;
                                        }
                                        if (fontStyle != null) {
                                            i25 = fontStyle.value;
                                        } else {
                                            i25 = 0;
                                        }
                                        StyleSpan styleSpan2 = new StyleSpan(DatabaseDao_Impl.AnonymousClass17.m1061getAndroidTypefaceStyleFO1MlWM(fontWeight2, i25));
                                        i26 = 33;
                                        spannableString4.setSpan(styleSpan2, i23, i24, 33);
                                    }
                                    if (textDecoration != null) {
                                        i27 = textDecoration.mask;
                                        if ((i27 | 1) == i27) {
                                            spannableString4.setSpan(new UnderlineSpan(), i23, i24, i26);
                                        }
                                        if ((i27 | 2) == i27) {
                                            spannableString4.setSpan(new StrikethroughSpan(), i23, i24, i26);
                                        }
                                    }
                                    if (textGeometricTransform != null) {
                                        spannableString4.setSpan(new ScaleXSpan(textGeometricTransform.scaleX), i23, i24, i26);
                                    }
                                    SizeKt.setLocaleList(spannableString4, localeList, i23, i24);
                                    if (j != 16) {
                                        spannableString4.setSpan(new BackgroundColorSpan(ColorKt.m498toArgb8_81llA(j)), i23, i24, i26);
                                    }
                                    spannableString2 = spannableString4;
                                    i22 = i30 + 1;
                                    size8 = i31;
                                    arrayList3 = arrayList6;
                                    semanticsConfiguration = semanticsConfiguration7;
                                    role = role4;
                                    accessibilityNodeInfoCompat = accessibilityNodeInfoCompat5;
                                    accessibilityNodeInfoObtain = accessibilityNodeInfo5;
                                    semanticsNode3 = semanticsNode6;
                                    accessibilityNodeInfo = accessibilityNodeInfo6;
                                    emojiProcessor = emojiProcessor4;
                                }
                            }
                            AccessibilityNodeInfo accessibilityNodeInfo7 = accessibilityNodeInfo;
                            semanticsNode = semanticsNode3;
                            semanticsConfiguration2 = semanticsConfiguration;
                            role2 = role;
                            emojiProcessor2 = emojiProcessor;
                            spannableString3 = spannableString2;
                            accessibilityNodeInfo2 = accessibilityNodeInfoObtain;
                            accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
                            int length = str6.length();
                            arrayList4 = EmptyList.INSTANCE;
                            if (list4 != null) {
                                arrayList5 = new ArrayList(list4.size());
                                size7 = list4.size();
                                while (i21 < size7) {
                                    Object obj23 = list4.get(i21);
                                    range3 = (AnnotatedString.Range) obj23;
                                    if (!(range3.item instanceof VerbatimTtsAnnotation)) {
                                    }
                                }
                            } else {
                                arrayList5 = arrayList4;
                            }
                            size3 = arrayList5.size();
                            while (i13 < size3) {
                                AnnotatedString.Range range5 = (AnnotatedString.Range) arrayList5.get(i13);
                                verbatimTtsAnnotation = (VerbatimTtsAnnotation) range5.item;
                                i19 = range5.start;
                                i20 = range5.end;
                                if (verbatimTtsAnnotation instanceof VerbatimTtsAnnotation) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                spannableString3.setSpan(new TtsSpan.VerbatimBuilder(verbatimTtsAnnotation.verbatim).build(), i19, i20, 33);
                            }
                            int length2 = str6.length();
                            if (list4 != null) {
                                arrayList4 = new ArrayList(list4.size());
                                size6 = list4.size();
                                while (i18 < size6) {
                                    Object obj24 = list4.get(i18);
                                    range2 = (AnnotatedString.Range) obj24;
                                    if (!(range2.item instanceof UrlAnnotation)) {
                                    }
                                }
                            }
                            size4 = arrayList4.size();
                            i14 = 0;
                            while (i14 < size4) {
                                AnnotatedString.Range range6 = (AnnotatedString.Range) arrayList4.get(i14);
                                urlAnnotation = (UrlAnnotation) range6.item;
                                int i32 = range6.start;
                                int i33 = range6.end;
                                EmojiProcessor emojiProcessor5 = emojiProcessor2;
                                weakHashMap2 = (WeakHashMap) emojiProcessor5.mSpanFactory;
                                uRLSpan = weakHashMap2.get(urlAnnotation);
                                if (uRLSpan == null) {
                                    uRLSpan = new URLSpan(urlAnnotation.url);
                                    weakHashMap2.put(urlAnnotation, uRLSpan);
                                }
                                spannableString3.setSpan((URLSpan) uRLSpan, i32, i33, 33);
                                i14++;
                                emojiProcessor2 = emojiProcessor5;
                            }
                            emojiProcessor3 = emojiProcessor2;
                            linkAnnotations = infoText.getLinkAnnotations(str6.length());
                            size5 = linkAnnotations.size();
                            while (i15 < size5) {
                                range = (AnnotatedString.Range) linkAnnotations.get(i15);
                                i16 = range.start;
                                obj21 = range.item;
                                i17 = range.end;
                                if (i16 != i17) {
                                    linkAnnotation = (LinkAnnotation) obj21;
                                    if (linkAnnotation instanceof LinkAnnotation.Url) {
                                        weakHashMap = (WeakHashMap) emojiProcessor3.mGlyphChecker;
                                        composeClickableSpan = weakHashMap.get(range);
                                        if (composeClickableSpan == null) {
                                            composeClickableSpan = new ComposeClickableSpan(linkAnnotation);
                                            weakHashMap.put(range, composeClickableSpan);
                                        }
                                        spannableString3.setSpan((ClickableSpan) composeClickableSpan, i16, i17, 33);
                                    } else {
                                        weakHashMap = (WeakHashMap) emojiProcessor3.mGlyphChecker;
                                        composeClickableSpan = weakHashMap.get(range);
                                        if (composeClickableSpan == null) {
                                            composeClickableSpan = new ComposeClickableSpan(linkAnnotation);
                                            weakHashMap.put(range, composeClickableSpan);
                                        }
                                        spannableString3.setSpan((ClickableSpan) composeClickableSpan, i16, i17, 33);
                                    }
                                }
                            }
                            spannableString = (SpannableString) AndroidComposeViewAccessibilityDelegateCompat.trimToSize(spannableString3);
                            accessibilityNodeInfo3 = accessibilityNodeInfo7;
                        } else {
                            androidComposeViewAccessibilityDelegateCompat2 = androidComposeViewAccessibilityDelegateCompat2;
                            semanticsNode = semanticsNode3;
                            semanticsConfiguration2 = semanticsConfiguration;
                            role2 = role;
                            accessibilityNodeInfo2 = accessibilityNodeInfoObtain;
                            accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
                            spannableString = null;
                            accessibilityNodeInfo3 = accessibilityNodeInfo;
                        }
                        accessibilityNodeInfo3.setText(spannableString);
                        semanticsPropertyKey = SemanticsProperties.Error;
                        if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
                            accessibilityNodeInfo4 = accessibilityNodeInfo2;
                            accessibilityNodeInfo4.setContentInvalid(true);
                            obj20 = mutableScatterMap.get(semanticsPropertyKey);
                            if (obj20 == null) {
                                obj20 = null;
                            }
                            accessibilityNodeInfo4.setError((CharSequence) obj20);
                        } else {
                            accessibilityNodeInfo4 = accessibilityNodeInfo2;
                        }
                        semanticsNode2 = semanticsNode;
                        infoStateDescriptionOrNull = InvertMatrixKt.getInfoStateDescriptionOrNull(semanticsNode2, resources);
                        if (Build.VERSION.SDK_INT >= 30) {
                            BuildCompat.Api30Impl.setStateDescription(accessibilityNodeInfo3, infoStateDescriptionOrNull);
                        } else {
                            accessibilityNodeInfo3.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", infoStateDescriptionOrNull);
                        }
                        accessibilityNodeInfo4.setCheckable(InvertMatrixKt.getInfoIsCheckable(semanticsNode2));
                        obj3 = mutableScatterMap.get(SemanticsProperties.ToggleableState);
                        if (obj3 == null) {
                            obj3 = null;
                        }
                        toggleableState = (ToggleableState) obj3;
                        if (toggleableState != null) {
                            if (toggleableState == ToggleableState.On) {
                                accessibilityNodeInfo3.setChecked(true);
                            } else if (toggleableState == ToggleableState.Off) {
                                accessibilityNodeInfo3.setChecked(false);
                            }
                        }
                        obj4 = mutableScatterMap.get(SemanticsProperties.Selected);
                        if (obj4 == null) {
                            obj4 = null;
                        }
                        bool = (Boolean) obj4;
                        if (bool != null) {
                            zBooleanValue3 = bool.booleanValue();
                            if (role2 == null) {
                                role3 = role2;
                                i5 = 4;
                            } else {
                                role3 = role2;
                                i5 = 4;
                                if (role3.value == 4) {
                                    accessibilityNodeInfo4.setSelected(zBooleanValue3);
                                }
                            }
                            accessibilityNodeInfo3.setChecked(zBooleanValue3);
                        } else {
                            role3 = role2;
                            i5 = 4;
                        }
                        semanticsConfiguration3 = semanticsConfiguration2;
                        if (semanticsConfiguration3.isMergingSemanticsOfDescendants) {
                            obj5 = mutableScatterMap.get(SemanticsProperties.ContentDescription);
                            if (obj5 == null) {
                                obj5 = null;
                            }
                            list = (List) obj5;
                            if (list != null) {
                                str = (String) CollectionsKt.firstOrNull(list);
                            } else {
                                str = null;
                            }
                            accessibilityNodeInfo4.setContentDescription(str);
                        } else {
                            obj5 = mutableScatterMap.get(SemanticsProperties.ContentDescription);
                            if (obj5 == null) {
                                obj5 = null;
                            }
                            list = (List) obj5;
                            if (list != null) {
                                str = (String) CollectionsKt.firstOrNull(list);
                            } else {
                                str = null;
                            }
                            accessibilityNodeInfo4.setContentDescription(str);
                        }
                        obj6 = mutableScatterMap.get(SemanticsProperties.TestTag);
                        if (obj6 == null) {
                            obj6 = null;
                        }
                        str2 = (String) obj6;
                        if (str2 != null) {
                            parent3 = semanticsNode2;
                            while (true) {
                                if (parent3 != null) {
                                    zBooleanValue2 = false;
                                    break;
                                }
                                semanticsConfiguration6 = parent3.unmergedConfig;
                                semanticsPropertyKey5 = SemanticsNodeKt.TestTagsAsResourceId;
                                if (semanticsConfiguration6.props.containsKey(semanticsPropertyKey5)) {
                                    zBooleanValue2 = ((Boolean) semanticsConfiguration6.get(semanticsPropertyKey5)).booleanValue();
                                    break;
                                }
                                parent3 = parent3.getParent();
                            }
                            if (zBooleanValue2) {
                                accessibilityNodeInfo4.setViewIdResourceName(str2);
                            }
                        }
                        obj7 = mutableScatterMap.get(SemanticsProperties.HintText);
                        if (obj7 == null) {
                            obj7 = null;
                        }
                        str3 = (String) obj7;
                        if (str3 != null) {
                            accessibilityNodeInfo4.setHintText(str3);
                        }
                        obj8 = mutableScatterMap.get(SemanticsProperties.Heading);
                        if (obj8 == null) {
                            obj8 = null;
                        }
                        if (((Unit) obj8) != null) {
                            accessibilityNodeInfoCompat3 = accessibilityNodeInfoCompat2;
                            accessibilityNodeInfoCompat3.setHeading(true);
                        } else {
                            accessibilityNodeInfoCompat3 = accessibilityNodeInfoCompat2;
                        }
                        obj9 = mutableScatterMap.get(SemanticsProperties.TextEntryKey);
                        if (obj9 == null) {
                            obj9 = null;
                        }
                        if (((Unit) obj9) != null) {
                            accessibilityNodeInfoCompat3.setTextEntryKey();
                        }
                        i6 = i;
                        androidComposeViewAccessibilityDelegateCompat = androidComposeViewAccessibilityDelegateCompat2;
                        if (i6 != -1) {
                            orDefault3 = androidComposeViewAccessibilityDelegateCompat.drawingOrder.getOrDefault(semanticsNode2.id, -1);
                            if (orDefault3 != -1) {
                                accessibilityNodeInfo4.setDrawingOrder(orDefault3);
                            } else {
                                Log.w("AccessibilityDelegate", "Drawing order is not available, was AccessibilityNodeInfo requested for a child node before its parent?");
                            }
                        }
                        accessibilityNodeInfo4.setPassword(mutableScatterMap.containsKey(SemanticsProperties.Password));
                        obj10 = mutableScatterMap.get(SemanticsProperties.IsEditable);
                        if (obj10 == null) {
                            obj10 = null;
                        }
                        bool2 = Boolean.TRUE;
                        accessibilityNodeInfo4.setEditable(Intrinsics.areEqual(obj10, bool2));
                        obj11 = mutableScatterMap.get(SemanticsProperties.MaxTextLength);
                        if (obj11 == null) {
                            obj11 = null;
                        }
                        num = (Integer) obj11;
                        if (num != null) {
                            iIntValue2 = num.intValue();
                        } else {
                            iIntValue2 = -1;
                        }
                        accessibilityNodeInfo4.setMaxTextLength(iIntValue2);
                        accessibilityNodeInfo4.setEnabled(InvertMatrixKt.enabled(semanticsNode2));
                        semanticsPropertyKey2 = SemanticsProperties.Focused;
                        accessibilityNodeInfo4.setFocusable(mutableScatterMap.containsKey(semanticsPropertyKey2));
                        if (accessibilityNodeInfo4.isFocusable()) {
                            accessibilityNodeInfo4.setFocused(((Boolean) semanticsConfiguration3.get(semanticsPropertyKey2)).booleanValue());
                            if (accessibilityNodeInfo4.isFocused()) {
                                accessibilityNodeInfo3.addAction(2);
                                androidComposeViewAccessibilityDelegateCompat.focusedVirtualViewId = i6;
                            } else {
                                accessibilityNodeInfo3.addAction(1);
                            }
                        }
                        if (SemanticsNodeKt.isHidden(semanticsNode2)) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        accessibilityNodeInfo3.setVisibleToUser(z2);
                        if (semanticsNode2.isFake$ui()) {
                            parent2 = semanticsNode2.getParent();
                            parent2.getClass();
                        } else {
                            parent2 = semanticsNode2;
                        }
                        if (parent2.getTouchBoundsInRoot().isEmpty()) {
                            accessibilityNodeInfo3.setVisibleToUser(false);
                        }
                        obj12 = mutableScatterMap.get(SemanticsProperties.LiveRegion);
                        if (obj12 == null) {
                            obj12 = null;
                        }
                        liveRegionMode = (LiveRegionMode) obj12;
                        if (liveRegionMode != null) {
                            z7 = liveRegionMode.value;
                            if (z7) {
                                i12 = 1;
                            } else {
                                i12 = 2;
                            }
                            accessibilityNodeInfo4.setLiveRegion(i12);
                        }
                        accessibilityNodeInfo3.setClickable(false);
                        obj13 = mutableScatterMap.get(SemanticsActions.OnClick);
                        if (obj13 == null) {
                            obj13 = null;
                        }
                        accessibilityAction = (AccessibilityAction) obj13;
                        if (accessibilityAction != null) {
                            obj19 = mutableScatterMap.get(SemanticsProperties.Selected);
                            if (obj19 == null) {
                                obj19 = null;
                            }
                            boolean zAreEqual3 = Intrinsics.areEqual(obj19, bool2);
                            if (role3 == null) {
                            }
                            if (z5) {
                                z6 = true;
                            } else {
                                z6 = true;
                            }
                            accessibilityNodeInfo3.setClickable(z6);
                            if (InvertMatrixKt.enabled(semanticsNode2)) {
                                accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(null, 16, accessibilityAction.label, null));
                            }
                        }
                        accessibilityNodeInfo3.setLongClickable(false);
                        accessibilityAction2 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.OnLongClick);
                        if (accessibilityAction2 != null) {
                            accessibilityNodeInfo3.setLongClickable(true);
                            if (InvertMatrixKt.enabled(semanticsNode2)) {
                                accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, accessibilityAction2.label));
                            }
                        }
                        accessibilityAction3 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.CopyText);
                        if (accessibilityAction3 != null) {
                            accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, accessibilityAction3.label));
                        }
                        if (InvertMatrixKt.enabled(semanticsNode2)) {
                            accessibilityAction9 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.SetText);
                            if (accessibilityAction9 != null) {
                                accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, accessibilityAction9.label));
                            }
                            accessibilityAction10 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.OnImeAction);
                            if (accessibilityAction10 != null) {
                                accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionImeEnter, accessibilityAction10.label));
                            }
                            accessibilityAction11 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.CutText);
                            if (accessibilityAction11 != null) {
                                accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, accessibilityAction11.label));
                            }
                            accessibilityAction12 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.PasteText);
                            if (accessibilityAction12 != null) {
                                primaryClipDescription = ((CallbackWrapper) androidComposeView.getClipboardManager()).getClipboardManager().getPrimaryClipDescription();
                                if (primaryClipDescription != null) {
                                    zHasMimeType = primaryClipDescription.hasMimeType("text/*");
                                } else {
                                    zHasMimeType = false;
                                }
                                if (zHasMimeType) {
                                    accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, accessibilityAction12.label));
                                }
                            }
                        }
                        iterableTextForAccessibility = AndroidComposeViewAccessibilityDelegateCompat.getIterableTextForAccessibility(semanticsNode2);
                        if (iterableTextForAccessibility != null) {
                            accessibilityNodeInfo4.setTextSelection(androidComposeViewAccessibilityDelegateCompat.getAccessibilitySelectionStart(semanticsNode2), androidComposeViewAccessibilityDelegateCompat.getAccessibilitySelectionEnd(semanticsNode2));
                            accessibilityAction8 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.SetSelection);
                            if (accessibilityAction8 != null) {
                                str5 = accessibilityAction8.label;
                            } else {
                                str5 = null;
                            }
                            accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, str5));
                            accessibilityNodeInfo3.addAction(256);
                            accessibilityNodeInfo3.addAction(512);
                            accessibilityNodeInfo3.setMovementGranularities(11);
                            list3 = (List) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.ContentDescription);
                            if (list3 != null) {
                                if (semanticsNode2.unmergedConfig.props.containsKey(SemanticsProperties.EditableText)) {
                                    obj18 = semanticsNode2.unmergedConfig.props.get(SemanticsProperties.Focused);
                                    if (obj18 == null) {
                                        obj18 = null;
                                    }
                                    if (Intrinsics.areEqual(obj18, Boolean.TRUE)) {
                                        parent$ui = semanticsNode2.layoutNode.getParent$ui();
                                        while (true) {
                                            if (parent$ui == null) {
                                                parent$ui = null;
                                                break;
                                            }
                                            semanticsConfiguration5 = parent$ui.getSemanticsConfiguration();
                                            if (semanticsConfiguration5 == null) {
                                            }
                                            parent$ui = parent$ui.getParent$ui();
                                        }
                                        if (parent$ui != null) {
                                            semanticsConfiguration4 = parent$ui.getSemanticsConfiguration();
                                            if (semanticsConfiguration4 != null) {
                                                obj17 = semanticsConfiguration4.props.get(SemanticsProperties.Focused);
                                                if (obj17 == null) {
                                                    obj17 = null;
                                                }
                                                zAreEqual = Intrinsics.areEqual(obj17, Boolean.TRUE);
                                            } else {
                                                zAreEqual = false;
                                            }
                                            if (zAreEqual) {
                                            }
                                        }
                                    }
                                } else {
                                    parent$ui = semanticsNode2.layoutNode.getParent$ui();
                                    while (true) {
                                        if (parent$ui == null) {
                                            parent$ui = null;
                                            break;
                                        }
                                        semanticsConfiguration5 = parent$ui.getSemanticsConfiguration();
                                        if (semanticsConfiguration5 == null) {
                                        }
                                        parent$ui = parent$ui.getParent$ui();
                                    }
                                    if (parent$ui != null) {
                                        semanticsConfiguration4 = parent$ui.getSemanticsConfiguration();
                                        if (semanticsConfiguration4 != null) {
                                            obj17 = semanticsConfiguration4.props.get(SemanticsProperties.Focused);
                                            if (obj17 == null) {
                                                obj17 = null;
                                            }
                                            zAreEqual = Intrinsics.areEqual(obj17, Boolean.TRUE);
                                        } else {
                                            zAreEqual = false;
                                        }
                                        if (zAreEqual) {
                                        }
                                    }
                                }
                                if (!z4) {
                                    accessibilityNodeInfo3.setMovementGranularities(accessibilityNodeInfo4.getMovementGranularities() | 20);
                                }
                            } else {
                                if (semanticsNode2.unmergedConfig.props.containsKey(SemanticsProperties.EditableText)) {
                                    obj18 = semanticsNode2.unmergedConfig.props.get(SemanticsProperties.Focused);
                                    if (obj18 == null) {
                                        obj18 = null;
                                    }
                                    if (Intrinsics.areEqual(obj18, Boolean.TRUE)) {
                                        parent$ui = semanticsNode2.layoutNode.getParent$ui();
                                        while (true) {
                                            if (parent$ui == null) {
                                                parent$ui = null;
                                                break;
                                            }
                                            semanticsConfiguration5 = parent$ui.getSemanticsConfiguration();
                                            if (semanticsConfiguration5 == null) {
                                            }
                                            parent$ui = parent$ui.getParent$ui();
                                        }
                                        if (parent$ui != null) {
                                            semanticsConfiguration4 = parent$ui.getSemanticsConfiguration();
                                            if (semanticsConfiguration4 != null) {
                                                obj17 = semanticsConfiguration4.props.get(SemanticsProperties.Focused);
                                                if (obj17 == null) {
                                                    obj17 = null;
                                                }
                                                zAreEqual = Intrinsics.areEqual(obj17, Boolean.TRUE);
                                            } else {
                                                zAreEqual = false;
                                            }
                                            if (zAreEqual) {
                                            }
                                        }
                                    }
                                } else {
                                    parent$ui = semanticsNode2.layoutNode.getParent$ui();
                                    while (true) {
                                        if (parent$ui == null) {
                                            parent$ui = null;
                                            break;
                                        }
                                        semanticsConfiguration5 = parent$ui.getSemanticsConfiguration();
                                        if (semanticsConfiguration5 == null) {
                                        }
                                        parent$ui = parent$ui.getParent$ui();
                                    }
                                    if (parent$ui != null) {
                                        semanticsConfiguration4 = parent$ui.getSemanticsConfiguration();
                                        if (semanticsConfiguration4 != null) {
                                            obj17 = semanticsConfiguration4.props.get(SemanticsProperties.Focused);
                                            if (obj17 == null) {
                                                obj17 = null;
                                            }
                                            zAreEqual = Intrinsics.areEqual(obj17, Boolean.TRUE);
                                        } else {
                                            zAreEqual = false;
                                        }
                                        if (zAreEqual) {
                                        }
                                    }
                                }
                                if (!z4) {
                                    accessibilityNodeInfo3.setMovementGranularities(accessibilityNodeInfo4.getMovementGranularities() | 20);
                                }
                            }
                        }
                        arrayList = new ArrayList();
                        arrayList.add("androidx.compose.ui.semantics.id");
                        text = accessibilityNodeInfoCompat3.getText();
                        if (text != null) {
                            arrayList.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
                        }
                        if (Build.VERSION.SDK_INT >= 37) {
                            arrayList.add("android.view.accessibility.extra.DATA_RENDERING_INFO_KEY");
                        }
                        if (mutableScatterMap.containsKey(SemanticsProperties.TestTag)) {
                            arrayList.add("androidx.compose.ui.semantics.testTag");
                        }
                        if (mutableScatterMap.containsKey(SemanticsProperties.Shape)) {
                            arrayList.add("androidx.compose.ui.semantics.shapeType");
                            arrayList.add("androidx.compose.ui.semantics.shapeRect");
                            arrayList.add("androidx.compose.ui.semantics.shapeCorners");
                            arrayList.add("androidx.compose.ui.semantics.shapeRegion");
                        }
                        accessibilityNodeInfo4.setAvailableExtraData(arrayList);
                        progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.ProgressBarRangeInfo);
                        if (progressBarRangeInfo != null) {
                            f = progressBarRangeInfo.current;
                            closedFloatRange = progressBarRangeInfo.range;
                            semanticsPropertyKey4 = SemanticsActions.SetProgress;
                            if (mutableScatterMap.containsKey(semanticsPropertyKey4)) {
                                accessibilityNodeInfoCompat3.setClassName("android.widget.SeekBar");
                            } else {
                                accessibilityNodeInfoCompat3.setClassName("android.widget.ProgressBar");
                            }
                            if (progressBarRangeInfo != ProgressBarRangeInfo.Indeterminate) {
                                accessibilityNodeInfo3.setRangeInfo((AccessibilityNodeInfo.RangeInfo) new Extras.Key(AccessibilityNodeInfo.RangeInfo.obtain(1, closedFloatRange._start, closedFloatRange._endInclusive, f)).f9default);
                            }
                            if (mutableScatterMap.containsKey(semanticsPropertyKey4)) {
                                float f2 = closedFloatRange._endInclusive;
                                float f3 = closedFloatRange._start;
                                fFloatValue = Float.valueOf(f2).floatValue();
                                fFloatValue2 = Float.valueOf(f3).floatValue();
                                if (fFloatValue < fFloatValue2) {
                                    fFloatValue = fFloatValue2;
                                }
                                if (f < fFloatValue) {
                                    accessibilityNodeInfoCompat3.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                                }
                                fFloatValue3 = Float.valueOf(f3).floatValue();
                                fFloatValue4 = Float.valueOf(closedFloatRange._endInclusive).floatValue();
                                if (fFloatValue3 > fFloatValue4) {
                                    fFloatValue3 = fFloatValue4;
                                }
                                if (f > fFloatValue3) {
                                    accessibilityNodeInfoCompat3.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                }
                            }
                        }
                        if (InvertMatrixKt.enabled(semanticsNode2)) {
                            obj16 = semanticsNode2.unmergedConfig.props.get(SemanticsActions.SetProgress);
                            if (obj16 == null) {
                                obj16 = null;
                            }
                            accessibilityAction7 = (AccessibilityAction) obj16;
                            if (accessibilityAction7 != null) {
                                accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(null, android.R.id.accessibilityActionSetProgress, accessibilityAction7.label, null));
                            }
                        }
                        DatabaseDao_Impl.AnonymousClass17.setCollectionInfo(semanticsNode2, accessibilityNodeInfoCompat3);
                        DatabaseDao_Impl.AnonymousClass17.setCollectionItemInfo(semanticsNode2, accessibilityNodeInfoCompat3);
                        scrollAxisRange = (ScrollAxisRange) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.HorizontalScrollAxisRange);
                        AccessibilityAction accessibilityAction13 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.ScrollBy);
                        if (scrollAxisRange != null) {
                            obj14 = semanticsNode2.getConfig().props.get(SemanticsProperties.CollectionInfo);
                            if (obj14 == null) {
                                obj14 = null;
                            }
                            if (obj14 == null) {
                                obj15 = semanticsNode2.getConfig().props.get(SemanticsProperties.SelectableGroup);
                                if (obj15 == null) {
                                    obj15 = null;
                                }
                                if (obj15 == null) {
                                    accessibilityNodeInfoCompat3.setClassName("android.widget.HorizontalScrollView");
                                }
                            }
                            if (((Number) scrollAxisRange.maxValue.invoke()).floatValue() > CropImageView.DEFAULT_ASPECT_RATIO) {
                                accessibilityNodeInfo3.setScrollable(true);
                            }
                            if (InvertMatrixKt.enabled(semanticsNode2)) {
                                zPopulateAccessibilityNodeInfoProperties$canScrollForward = AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange);
                                layoutDirection = LayoutDirection.Rtl;
                                if (zPopulateAccessibilityNodeInfoProperties$canScrollForward) {
                                    accessibilityNodeInfoCompat3.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                                    layoutNode = layoutNode2;
                                    if (layoutNode.layoutDirection == layoutDirection) {
                                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                                    } else {
                                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                                    }
                                    accessibilityNodeInfoCompat3.addAction(accessibilityActionCompat2);
                                } else {
                                    layoutNode = layoutNode2;
                                }
                                if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange)) {
                                    accessibilityNodeInfoCompat3.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                    if (layoutNode.layoutDirection == layoutDirection) {
                                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                                    } else {
                                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                                    }
                                    accessibilityNodeInfoCompat3.addAction(accessibilityActionCompat);
                                }
                            }
                        }
                        scrollAxisRange2 = (ScrollAxisRange) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.VerticalScrollAxisRange);
                        if (scrollAxisRange2 != null) {
                            z3 = true;
                        } else {
                            z3 = true;
                        }
                        if (Build.VERSION.SDK_INT >= 29) {
                            InvertMatrixKt.addPageActions(semanticsNode2, accessibilityNodeInfoCompat3);
                        }
                        accessibilityNodeInfoCompat3.setPaneTitle((CharSequence) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.PaneTitle));
                        if (InvertMatrixKt.enabled(semanticsNode2)) {
                            accessibilityAction4 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.Expand);
                            if (accessibilityAction4 != null) {
                                accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, accessibilityAction4.label));
                            }
                            accessibilityAction5 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.Collapse);
                            if (accessibilityAction5 != null) {
                                accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, accessibilityAction5.label));
                            }
                            accessibilityAction6 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.Dismiss);
                            if (accessibilityAction6 != null) {
                                accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(ByteChannelKt.CHANNEL_MAX_SIZE, accessibilityAction6.label));
                            }
                            semanticsPropertyKey3 = SemanticsActions.CustomActions;
                            if (mutableScatterMap.containsKey(semanticsPropertyKey3)) {
                                list2 = (List) semanticsConfiguration3.get(semanticsPropertyKey3);
                                size2 = list2.size();
                                mutableIntList = AndroidComposeViewAccessibilityDelegateCompat.AccessibilityActionsResourceIds;
                                i7 = mutableIntList._size;
                                if (size2 < i7) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2(IntIntPair$$ExternalSyntheticOutline0.m(i7, "Can't have more than ", " custom actions for one widget"));
                                    return null;
                                }
                                SparseArrayCompat sparseArrayCompat2 = new SparseArrayCompat(0);
                                MutableObjectIntMap mutableObjectIntMapMutableObjectIntMapOf = ObjectIntMapKt.mutableObjectIntMapOf();
                                if (sparseArrayCompat.garbage) {
                                    ArraySetKt.gc(sparseArrayCompat);
                                }
                                if (ContainerHelpersKt.binarySearch(sparseArrayCompat.size, i6, sparseArrayCompat.keys) < 0) {
                                    z3 = false;
                                }
                                if (z3) {
                                    mutableObjectIntMap = (MutableObjectIntMap) ArraySetKt.commonGet(sparseArrayCompat, i6);
                                    iArr = mutableIntList.content;
                                    i8 = mutableIntList._size;
                                    iArrCopyOf = new int[16];
                                    i9 = 0;
                                    i10 = 0;
                                    while (i9 < i8) {
                                        int i34 = iArr[i9];
                                        int i35 = i8;
                                        i11 = i10 + 1;
                                        int i36 = i9;
                                        if (iArrCopyOf.length < i11) {
                                            iArrCopyOf = Arrays.copyOf(iArrCopyOf, Math.max(i11, (iArrCopyOf.length * 3) / 2));
                                        }
                                        iArrCopyOf[i10] = i34;
                                        i9 = i36 + 1;
                                        i10 = i11;
                                        i8 = i35;
                                    }
                                    arrayList2 = new ArrayList();
                                    if (list2.size() <= 0) {
                                        Fragment$5$$ExternalSyntheticOutline0.m833m(list2.get(0));
                                        mutableObjectIntMap.getClass();
                                        throw null;
                                    }
                                    if (arrayList2.size() <= 0) {
                                        Fragment$5$$ExternalSyntheticOutline0.m833m(arrayList2.get(0));
                                        if (i10 <= 0) {
                                            _UtilJvmKt$$ExternalSyntheticLambda0.m("Index must be between 0 and size");
                                            return null;
                                        }
                                        int i37 = iArrCopyOf[0];
                                        throw null;
                                    }
                                } else if (list2.size() > 0) {
                                    Fragment$5$$ExternalSyntheticOutline0.m833m(list2.get(0));
                                    mutableIntList.get(0);
                                    throw null;
                                }
                                androidComposeViewAccessibilityDelegateCompat.actionIdToLabel.put(i6, sparseArrayCompat2);
                                sparseArrayCompat.put(i6, mutableObjectIntMapMutableObjectIntMapOf);
                            }
                        }
                        accessibilityNodeInfoCompat3.setScreenReaderFocusable(InvertMatrixKt.isScreenReaderFocusable(semanticsNode2, resources, z));
                        orDefault = androidComposeViewAccessibilityDelegateCompat.idToBeforeMap.getOrDefault(i6, -1);
                        if (orDefault != -1) {
                            androidViewsHandler$ui2 = androidComposeView.getAndroidViewsHandler$ui();
                            if (androidViewsHandler$ui2 != null) {
                                androidViewHolderSemanticsIdToView2 = InvertMatrixKt.semanticsIdToView(androidViewsHandler$ui2, orDefault);
                            } else {
                                androidViewHolderSemanticsIdToView2 = null;
                            }
                            if (androidViewHolderSemanticsIdToView2 != null) {
                                accessibilityNodeInfo3.setTraversalBefore(androidViewHolderSemanticsIdToView2);
                                androidComposeView2 = androidComposeView;
                            } else {
                                androidComposeView2 = androidComposeView;
                                accessibilityNodeInfo3.setTraversalBefore(androidComposeView2, orDefault);
                            }
                            androidComposeViewAccessibilityDelegateCompat.addExtraDataToAccessibilityNodeInfoHelper(i6, accessibilityNodeInfoCompat3, androidComposeViewAccessibilityDelegateCompat.ExtraDataTestTraversalBeforeVal, null);
                        } else {
                            androidComposeView2 = androidComposeView;
                        }
                        orDefault2 = androidComposeViewAccessibilityDelegateCompat.idToAfterMap.getOrDefault(i6, -1);
                        if (orDefault2 != -1) {
                            androidViewsHandler$ui = androidComposeView2.getAndroidViewsHandler$ui();
                            if (androidViewsHandler$ui != null) {
                                androidViewHolderSemanticsIdToView = InvertMatrixKt.semanticsIdToView(androidViewsHandler$ui, orDefault2);
                            } else {
                                androidViewHolderSemanticsIdToView = null;
                            }
                            if (androidViewHolderSemanticsIdToView != null) {
                                accessibilityNodeInfo3.setTraversalAfter(androidViewHolderSemanticsIdToView);
                                androidComposeViewAccessibilityDelegateCompat.addExtraDataToAccessibilityNodeInfoHelper(i6, accessibilityNodeInfoCompat3, androidComposeViewAccessibilityDelegateCompat.ExtraDataTestTraversalAfterVal, null);
                            }
                        }
                        str4 = (String) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsNodeKt.AccessibilityClassName);
                        if (str4 != null) {
                            accessibilityNodeInfoCompat3.setClassName(str4);
                        }
                    } else if (Build.VERSION.SDK_INT >= 34 ? TextViewCompat$Api34Impl.isRequestFromAccessibilityTool(androidComposeView3.getComposeViewContext().accessibilityManager.accessibilityManager) : true) {
                        accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
                        accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfoObtain);
                        i2 = Build.VERSION.SDK_INT;
                        if (i2 >= 34) {
                            TextViewCompat$Api34Impl.setAccessibilityDataSensitive(accessibilityNodeInfoObtain, zAreEqual2);
                        } else {
                            accessibilityNodeInfoCompat.setBooleanProperty(64, zAreEqual2);
                        }
                        if (i == -1) {
                            parentForAccessibility = androidComposeView3.getParentForAccessibility();
                            if (parentForAccessibility instanceof View) {
                                view = (View) parentForAccessibility;
                            } else {
                                view = null;
                            }
                            accessibilityNodeInfoCompat.mParentVirtualDescendantId = -1;
                            accessibilityNodeInfoObtain.setParent(view);
                        } else {
                            parent = semanticsNode3.getParent();
                            if (parent != null) {
                                numValueOf = Integer.valueOf(parent.id);
                            } else {
                                numValueOf = null;
                            }
                            if (numValueOf != null) {
                                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("semanticsNode " + i + " has null parent");
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                                return null;
                            }
                            iIntValue = numValueOf.intValue();
                            if (iIntValue == androidComposeView3.getSemanticsOwner().getUnmergedRootSemanticsNode().id) {
                                iIntValue = -1;
                            }
                            accessibilityNodeInfoCompat.mParentVirtualDescendantId = iIntValue;
                            accessibilityNodeInfoObtain.setParent(androidComposeView3, iIntValue);
                        }
                        accessibilityNodeInfoCompat.mVirtualDescendantId = i;
                        accessibilityNodeInfoObtain.setSource(androidComposeView3, i);
                        accessibilityNodeInfoObtain.setBoundsInScreen(androidComposeViewAccessibilityDelegateCompat2.boundsInScreen(adjustedSemanticsNode3));
                        sparseArrayCompat = androidComposeViewAccessibilityDelegateCompat2.labelToActionId;
                        resources = androidComposeView3.getContext().getResources();
                        adjustedSemanticsNode = (AdjustedSemanticsNode) androidComposeViewAccessibilityDelegateCompat2.getCurrentSemanticsNodes().get(i);
                        if (adjustedSemanticsNode == null && adjustedSemanticsNode.isInMergingHiddenSubtree) {
                            z = true;
                        } else {
                            z = false;
                        }
                        accessibilityNodeInfoCompat.setClassName("android.view.View");
                        semanticsConfiguration = semanticsNode3.unmergedConfig;
                        mutableScatterMap = semanticsConfiguration.props;
                        if (mutableScatterMap.containsKey(SemanticsProperties.EditableText)) {
                            accessibilityNodeInfoCompat.setClassName("android.widget.EditText");
                        }
                        if (mutableScatterMap.containsKey(SemanticsProperties.Text)) {
                            accessibilityNodeInfoCompat.setClassName("android.widget.TextView");
                        }
                        obj = mutableScatterMap.get(SemanticsProperties.Role);
                        if (obj == null) {
                            obj = null;
                        }
                        role = (Role) obj;
                        if (role != null) {
                            b = role.value;
                            if (!semanticsNode3.isFake$ui() || semanticsNode3.getChildren$ui((4 & 1) != 0 ? !semanticsNode3.mergingEnabled : false, (4 & 2) == 0).isEmpty()) {
                                androidComposeView = androidComposeView3;
                                if (b == 4) {
                                    accessibilityNodeInfoObtain.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", resources.getString(R.string.tab));
                                } else if (b == 2) {
                                    accessibilityNodeInfoObtain.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", resources.getString(R.string.switch_role));
                                } else {
                                    strM713toLegacyClassNameV4PA4sw = InvertMatrixKt.m713toLegacyClassNameV4PA4sw(b);
                                    if (b == 5 || InvertMatrixKt.isUnmergedLeafNode(semanticsNode3) || semanticsConfiguration.isMergingSemanticsOfDescendants) {
                                        accessibilityNodeInfoCompat.setClassName(strM713toLegacyClassNameV4PA4sw);
                                    }
                                }
                            } else {
                                androidComposeView = androidComposeView3;
                            }
                        } else {
                            androidComposeView = androidComposeView3;
                        }
                        accessibilityNodeInfoObtain.setPackageName(androidComposeView.getContext().getPackageName());
                        accessibilityNodeInfoObtain.setImportantForAccessibility(SemanticsNodeKt.isImportantForAccessibility(semanticsNode3));
                        accessibilityManager = androidComposeView.getComposeViewContext().accessibilityManager.accessibilityManager;
                        if (i2 >= 34) {
                            zIsRequestFromAccessibilityTool = TextViewCompat$Api34Impl.isRequestFromAccessibilityTool(accessibilityManager);
                        } else {
                            zIsRequestFromAccessibilityTool = true;
                        }
                        obj2 = mutableScatterMap.get(SemanticsProperties.IsTraversalGroup);
                        if (obj2 == null) {
                            obj2 = Boolean.FALSE;
                        }
                        zBooleanValue = ((Boolean) obj2).booleanValue();
                        boolean z9 = semanticsConfiguration.isMergingSemanticsOfDescendants;
                        children$ui = semanticsNode3.getChildren$ui((4 & 1) != 0 ? !semanticsNode3.mergingEnabled : false, (4 & 2) == 0);
                        int size10 = children$ui.size();
                        if (zBooleanValue || !z9 || size10 <= 1) {
                            size = children$ui.size();
                            i3 = 0;
                            int i212 = 0;
                            while (i3 < size) {
                                SemanticsNode semanticsNode7 = (SemanticsNode) children$ui.get(i3);
                                int i213 = size;
                                List list7 = children$ui;
                                adjustedSemanticsNode2 = (AdjustedSemanticsNode) androidComposeViewAccessibilityDelegateCompat2.getCurrentSemanticsNodes().get(semanticsNode7.id);
                                if (adjustedSemanticsNode2 == null && semanticsNode7.id != -1) {
                                    androidComposeViewAccessibilityDelegateCompat2.addChildToNodeInfo(adjustedSemanticsNode2, accessibilityNodeInfoCompat, zIsRequestFromAccessibilityTool, i212);
                                    i212++;
                                }
                                i3++;
                                size = i213;
                                children$ui = list7;
                            }
                        } else {
                            int size11 = children$ui.size();
                            ?? r14 = new SemanticsNode[size11];
                            for (int i38 = 0; i38 < size11; i38++) {
                                r14[i38] = children$ui.get(i38);
                            }
                            Comparator[] comparatorArr = SemanticsSortKt.semanticComparators;
                            LayoutNode$$ExternalSyntheticLambda1 layoutNode$$ExternalSyntheticLambda1 = new LayoutNode$$ExternalSyntheticLambda1((byte) 4);
                            if (size11 > 1) {
                                Arrays.sort(r14, layoutNode$$ExternalSyntheticLambda1);
                            }
                            int i39 = 0;
                            int i40 = 0;
                            while (i39 < size10) {
                                ?? r9 = r14[i39];
                                int i41 = i39;
                                int i42 = size10;
                                AdjustedSemanticsNode adjustedSemanticsNode4 = (AdjustedSemanticsNode) androidComposeViewAccessibilityDelegateCompat2.getCurrentSemanticsNodes().get(r9.id);
                                if (adjustedSemanticsNode4 != null && r9.id != -1) {
                                    androidComposeViewAccessibilityDelegateCompat2.addChildToNodeInfo(adjustedSemanticsNode4, accessibilityNodeInfoCompat, zIsRequestFromAccessibilityTool, i40);
                                    i40++;
                                }
                                i39 = i41 + 1;
                                size10 = i42;
                            }
                        }
                        i4 = androidComposeViewAccessibilityDelegateCompat2.accessibilityFocusedVirtualViewId;
                        accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
                        if (i == i4) {
                            accessibilityNodeInfo.setAccessibilityFocused(true);
                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                        } else {
                            accessibilityNodeInfo.setAccessibilityFocused(false);
                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
                        }
                        infoText = InvertMatrixKt.getInfoText(semanticsNode3);
                        if (infoText != null) {
                            androidComposeView.getFontFamilyResolver();
                            density = androidComposeView.getDensity();
                            emojiProcessor = androidComposeViewAccessibilityDelegateCompat2.urlSpanCache;
                            String str7 = infoText.text;
                            list4 = infoText.annotations;
                            spannableString2 = new SpannableString(str7);
                            arrayList3 = infoText.spanStylesOrNull;
                            if (arrayList3 != null) {
                                size8 = arrayList3.size();
                                i22 = 0;
                                while (i22 < size8) {
                                    int i310 = i22;
                                    AnnotatedString.Range range7 = (AnnotatedString.Range) arrayList3.get(i22);
                                    int i311 = size8;
                                    SpanStyle spanStyle2 = (SpanStyle) range7.item;
                                    ArrayList arrayList7 = arrayList3;
                                    i23 = range7.start;
                                    i24 = range7.end;
                                    SemanticsConfiguration semanticsConfiguration8 = semanticsConfiguration;
                                    Role role5 = role;
                                    jMo768getColor0d7_KjU = spanStyle2.textForegroundStyle.mo768getColor0d7_KjU();
                                    AccessibilityNodeInfo accessibilityNodeInfo8 = accessibilityNodeInfoObtain;
                                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat6 = accessibilityNodeInfoCompat;
                                    long j3 = spanStyle2.fontSize;
                                    fontWeight = spanStyle2.fontWeight;
                                    fontStyle = spanStyle2.fontStyle;
                                    textGeometricTransform = spanStyle2.textGeometricTransform;
                                    LocaleList localeList2 = spanStyle2.localeList;
                                    AccessibilityNodeInfo accessibilityNodeInfo9 = accessibilityNodeInfo;
                                    SemanticsNode semanticsNode8 = semanticsNode3;
                                    j = spanStyle2.background;
                                    textDecoration = spanStyle2.textDecoration;
                                    colorStyle = spanStyle2.textForegroundStyle;
                                    EmojiProcessor emojiProcessor6 = emojiProcessor;
                                    if (!ULong.m1869equalsimpl0(jMo768getColor0d7_KjU, colorStyle.mo768getColor0d7_KjU())) {
                                        if (jMo768getColor0d7_KjU != 16) {
                                            colorStyle = new ColorStyle(jMo768getColor0d7_KjU);
                                        } else {
                                            colorStyle = TextForegroundStyle.Unspecified.INSTANCE;
                                        }
                                    }
                                    SizeKt.m871setColorRPmYEkk(spannableString2, colorStyle.mo768getColor0d7_KjU(), i23, i24);
                                    spannableString4 = spannableString2;
                                    SizeKt.m872setFontSizeKmRG4DE(spannableString4, j3, density, i23, i24);
                                    if (fontWeight == null || fontStyle != null) {
                                        if (fontWeight == null) {
                                            fontWeight2 = FontWeight.Normal;
                                        } else {
                                            fontWeight2 = fontWeight;
                                        }
                                        if (fontStyle != null) {
                                            i25 = fontStyle.value;
                                        } else {
                                            i25 = 0;
                                        }
                                        StyleSpan styleSpan3 = new StyleSpan(DatabaseDao_Impl.AnonymousClass17.m1061getAndroidTypefaceStyleFO1MlWM(fontWeight2, i25));
                                        i26 = 33;
                                        spannableString4.setSpan(styleSpan3, i23, i24, 33);
                                    } else {
                                        i26 = 33;
                                    }
                                    if (textDecoration != null) {
                                        i27 = textDecoration.mask;
                                        if ((i27 | 1) == i27) {
                                            spannableString4.setSpan(new UnderlineSpan(), i23, i24, i26);
                                        }
                                        if ((i27 | 2) == i27) {
                                            spannableString4.setSpan(new StrikethroughSpan(), i23, i24, i26);
                                        }
                                    }
                                    if (textGeometricTransform != null) {
                                        spannableString4.setSpan(new ScaleXSpan(textGeometricTransform.scaleX), i23, i24, i26);
                                    }
                                    SizeKt.setLocaleList(spannableString4, localeList2, i23, i24);
                                    if (j != 16) {
                                        spannableString4.setSpan(new BackgroundColorSpan(ColorKt.m498toArgb8_81llA(j)), i23, i24, i26);
                                    }
                                    spannableString2 = spannableString4;
                                    i22 = i310 + 1;
                                    size8 = i311;
                                    arrayList3 = arrayList7;
                                    semanticsConfiguration = semanticsConfiguration8;
                                    role = role5;
                                    accessibilityNodeInfoCompat = accessibilityNodeInfoCompat6;
                                    accessibilityNodeInfoObtain = accessibilityNodeInfo8;
                                    semanticsNode3 = semanticsNode8;
                                    accessibilityNodeInfo = accessibilityNodeInfo9;
                                    emojiProcessor = emojiProcessor6;
                                }
                            }
                            AccessibilityNodeInfo accessibilityNodeInfo10 = accessibilityNodeInfo;
                            semanticsNode = semanticsNode3;
                            semanticsConfiguration2 = semanticsConfiguration;
                            role2 = role;
                            emojiProcessor2 = emojiProcessor;
                            spannableString3 = spannableString2;
                            accessibilityNodeInfo2 = accessibilityNodeInfoObtain;
                            accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
                            int length3 = str7.length();
                            arrayList4 = EmptyList.INSTANCE;
                            if (list4 != null) {
                                arrayList5 = new ArrayList(list4.size());
                                size7 = list4.size();
                                for (i21 = 0; i21 < size7; i21++) {
                                    Object obj25 = list4.get(i21);
                                    range3 = (AnnotatedString.Range) obj25;
                                    if (!(range3.item instanceof VerbatimTtsAnnotation) && AnnotatedStringKt.intersect(0, length3, range3.start, range3.end)) {
                                        arrayList5.add(obj25);
                                    }
                                }
                            } else {
                                arrayList5 = arrayList4;
                            }
                            size3 = arrayList5.size();
                            for (i13 = 0; i13 < size3; i13++) {
                                AnnotatedString.Range range8 = (AnnotatedString.Range) arrayList5.get(i13);
                                verbatimTtsAnnotation = (VerbatimTtsAnnotation) range8.item;
                                i19 = range8.start;
                                i20 = range8.end;
                                if (verbatimTtsAnnotation instanceof VerbatimTtsAnnotation) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                spannableString3.setSpan(new TtsSpan.VerbatimBuilder(verbatimTtsAnnotation.verbatim).build(), i19, i20, 33);
                            }
                            int length4 = str7.length();
                            if (list4 != null) {
                                arrayList4 = new ArrayList(list4.size());
                                size6 = list4.size();
                                for (i18 = 0; i18 < size6; i18++) {
                                    Object obj26 = list4.get(i18);
                                    range2 = (AnnotatedString.Range) obj26;
                                    if (!(range2.item instanceof UrlAnnotation) && AnnotatedStringKt.intersect(0, length4, range2.start, range2.end)) {
                                        arrayList4.add(obj26);
                                    }
                                }
                            }
                            size4 = arrayList4.size();
                            i14 = 0;
                            while (i14 < size4) {
                                AnnotatedString.Range range9 = (AnnotatedString.Range) arrayList4.get(i14);
                                urlAnnotation = (UrlAnnotation) range9.item;
                                int i312 = range9.start;
                                int i313 = range9.end;
                                EmojiProcessor emojiProcessor7 = emojiProcessor2;
                                weakHashMap2 = (WeakHashMap) emojiProcessor7.mSpanFactory;
                                uRLSpan = weakHashMap2.get(urlAnnotation);
                                if (uRLSpan == null) {
                                    uRLSpan = new URLSpan(urlAnnotation.url);
                                    weakHashMap2.put(urlAnnotation, uRLSpan);
                                }
                                spannableString3.setSpan((URLSpan) uRLSpan, i312, i313, 33);
                                i14++;
                                emojiProcessor2 = emojiProcessor7;
                            }
                            emojiProcessor3 = emojiProcessor2;
                            linkAnnotations = infoText.getLinkAnnotations(str7.length());
                            size5 = linkAnnotations.size();
                            for (i15 = 0; i15 < size5; i15++) {
                                range = (AnnotatedString.Range) linkAnnotations.get(i15);
                                i16 = range.start;
                                obj21 = range.item;
                                i17 = range.end;
                                if (i16 != i17) {
                                    linkAnnotation = (LinkAnnotation) obj21;
                                    if ((linkAnnotation instanceof LinkAnnotation.Url) || ((LinkAnnotation.Url) linkAnnotation).linkInteractionListener != null) {
                                        weakHashMap = (WeakHashMap) emojiProcessor3.mGlyphChecker;
                                        composeClickableSpan = weakHashMap.get(range);
                                        if (composeClickableSpan == null) {
                                            composeClickableSpan = new ComposeClickableSpan(linkAnnotation);
                                            weakHashMap.put(range, composeClickableSpan);
                                        }
                                        spannableString3.setSpan((ClickableSpan) composeClickableSpan, i16, i17, 33);
                                    } else {
                                        obj21.getClass();
                                        LinkAnnotation.Url url = (LinkAnnotation.Url) obj21;
                                        AnnotatedString.Range range10 = new AnnotatedString.Range(i16, i17, url);
                                        WeakHashMap weakHashMap3 = (WeakHashMap) emojiProcessor3.mMetadataRepo;
                                        Object uRLSpan2 = weakHashMap3.get(range10);
                                        if (uRLSpan2 == null) {
                                            uRLSpan2 = new URLSpan(url.url);
                                            weakHashMap3.put(range10, uRLSpan2);
                                        }
                                        spannableString3.setSpan((URLSpan) uRLSpan2, i16, i17, 33);
                                    }
                                }
                            }
                            spannableString = (SpannableString) AndroidComposeViewAccessibilityDelegateCompat.trimToSize(spannableString3);
                            accessibilityNodeInfo3 = accessibilityNodeInfo10;
                        } else {
                            androidComposeViewAccessibilityDelegateCompat2 = androidComposeViewAccessibilityDelegateCompat2;
                            semanticsNode = semanticsNode3;
                            semanticsConfiguration2 = semanticsConfiguration;
                            role2 = role;
                            accessibilityNodeInfo2 = accessibilityNodeInfoObtain;
                            accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
                            spannableString = null;
                            accessibilityNodeInfo3 = accessibilityNodeInfo;
                        }
                        accessibilityNodeInfo3.setText(spannableString);
                        semanticsPropertyKey = SemanticsProperties.Error;
                        if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
                            accessibilityNodeInfo4 = accessibilityNodeInfo2;
                            accessibilityNodeInfo4.setContentInvalid(true);
                            obj20 = mutableScatterMap.get(semanticsPropertyKey);
                            if (obj20 == null) {
                                obj20 = null;
                            }
                            accessibilityNodeInfo4.setError((CharSequence) obj20);
                        } else {
                            accessibilityNodeInfo4 = accessibilityNodeInfo2;
                        }
                        semanticsNode2 = semanticsNode;
                        infoStateDescriptionOrNull = InvertMatrixKt.getInfoStateDescriptionOrNull(semanticsNode2, resources);
                        if (Build.VERSION.SDK_INT >= 30) {
                            BuildCompat.Api30Impl.setStateDescription(accessibilityNodeInfo3, infoStateDescriptionOrNull);
                        } else {
                            accessibilityNodeInfo3.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", infoStateDescriptionOrNull);
                        }
                        accessibilityNodeInfo4.setCheckable(InvertMatrixKt.getInfoIsCheckable(semanticsNode2));
                        obj3 = mutableScatterMap.get(SemanticsProperties.ToggleableState);
                        if (obj3 == null) {
                            obj3 = null;
                        }
                        toggleableState = (ToggleableState) obj3;
                        if (toggleableState != null) {
                            if (toggleableState == ToggleableState.On) {
                                accessibilityNodeInfo3.setChecked(true);
                            } else if (toggleableState == ToggleableState.Off) {
                                accessibilityNodeInfo3.setChecked(false);
                            }
                        }
                        obj4 = mutableScatterMap.get(SemanticsProperties.Selected);
                        if (obj4 == null) {
                            obj4 = null;
                        }
                        bool = (Boolean) obj4;
                        if (bool != null) {
                            zBooleanValue3 = bool.booleanValue();
                            if (role2 == null) {
                                role3 = role2;
                                i5 = 4;
                            } else {
                                role3 = role2;
                                i5 = 4;
                                if (role3.value == 4) {
                                    accessibilityNodeInfo4.setSelected(zBooleanValue3);
                                }
                            }
                            accessibilityNodeInfo3.setChecked(zBooleanValue3);
                        } else {
                            role3 = role2;
                            i5 = 4;
                        }
                        semanticsConfiguration3 = semanticsConfiguration2;
                        if (semanticsConfiguration3.isMergingSemanticsOfDescendants || semanticsNode2.getChildren$ui((4 & 1) != 0 ? !semanticsNode2.mergingEnabled : false, (4 & 2) == 0).isEmpty()) {
                            obj5 = mutableScatterMap.get(SemanticsProperties.ContentDescription);
                            if (obj5 == null) {
                                obj5 = null;
                            }
                            list = (List) obj5;
                            if (list != null) {
                                str = (String) CollectionsKt.firstOrNull(list);
                            } else {
                                str = null;
                            }
                            accessibilityNodeInfo4.setContentDescription(str);
                        }
                        obj6 = mutableScatterMap.get(SemanticsProperties.TestTag);
                        if (obj6 == null) {
                            obj6 = null;
                        }
                        str2 = (String) obj6;
                        if (str2 != null) {
                            parent3 = semanticsNode2;
                            while (true) {
                                if (parent3 != null) {
                                    zBooleanValue2 = false;
                                    break;
                                }
                                semanticsConfiguration6 = parent3.unmergedConfig;
                                semanticsPropertyKey5 = SemanticsNodeKt.TestTagsAsResourceId;
                                if (semanticsConfiguration6.props.containsKey(semanticsPropertyKey5)) {
                                    zBooleanValue2 = ((Boolean) semanticsConfiguration6.get(semanticsPropertyKey5)).booleanValue();
                                    break;
                                }
                                parent3 = parent3.getParent();
                            }
                            if (zBooleanValue2) {
                                accessibilityNodeInfo4.setViewIdResourceName(str2);
                            }
                        }
                        obj7 = mutableScatterMap.get(SemanticsProperties.HintText);
                        if (obj7 == null) {
                            obj7 = null;
                        }
                        str3 = (String) obj7;
                        if (str3 != null) {
                            accessibilityNodeInfo4.setHintText(str3);
                        }
                        obj8 = mutableScatterMap.get(SemanticsProperties.Heading);
                        if (obj8 == null) {
                            obj8 = null;
                        }
                        if (((Unit) obj8) != null) {
                            accessibilityNodeInfoCompat3 = accessibilityNodeInfoCompat2;
                            accessibilityNodeInfoCompat3.setHeading(true);
                        } else {
                            accessibilityNodeInfoCompat3 = accessibilityNodeInfoCompat2;
                        }
                        obj9 = mutableScatterMap.get(SemanticsProperties.TextEntryKey);
                        if (obj9 == null) {
                            obj9 = null;
                        }
                        if (((Unit) obj9) != null) {
                            accessibilityNodeInfoCompat3.setTextEntryKey();
                        }
                        i6 = i;
                        androidComposeViewAccessibilityDelegateCompat = androidComposeViewAccessibilityDelegateCompat2;
                        if (i6 != -1) {
                            orDefault3 = androidComposeViewAccessibilityDelegateCompat.drawingOrder.getOrDefault(semanticsNode2.id, -1);
                            if (orDefault3 != -1) {
                                accessibilityNodeInfo4.setDrawingOrder(orDefault3);
                            } else {
                                Log.w("AccessibilityDelegate", "Drawing order is not available, was AccessibilityNodeInfo requested for a child node before its parent?");
                            }
                        }
                        accessibilityNodeInfo4.setPassword(mutableScatterMap.containsKey(SemanticsProperties.Password));
                        obj10 = mutableScatterMap.get(SemanticsProperties.IsEditable);
                        if (obj10 == null) {
                            obj10 = null;
                        }
                        bool2 = Boolean.TRUE;
                        accessibilityNodeInfo4.setEditable(Intrinsics.areEqual(obj10, bool2));
                        obj11 = mutableScatterMap.get(SemanticsProperties.MaxTextLength);
                        if (obj11 == null) {
                            obj11 = null;
                        }
                        num = (Integer) obj11;
                        if (num != null) {
                            iIntValue2 = num.intValue();
                        } else {
                            iIntValue2 = -1;
                        }
                        accessibilityNodeInfo4.setMaxTextLength(iIntValue2);
                        accessibilityNodeInfo4.setEnabled(InvertMatrixKt.enabled(semanticsNode2));
                        semanticsPropertyKey2 = SemanticsProperties.Focused;
                        accessibilityNodeInfo4.setFocusable(mutableScatterMap.containsKey(semanticsPropertyKey2));
                        if (accessibilityNodeInfo4.isFocusable()) {
                            accessibilityNodeInfo4.setFocused(((Boolean) semanticsConfiguration3.get(semanticsPropertyKey2)).booleanValue());
                            if (accessibilityNodeInfo4.isFocused()) {
                                accessibilityNodeInfo3.addAction(2);
                                androidComposeViewAccessibilityDelegateCompat.focusedVirtualViewId = i6;
                            } else {
                                accessibilityNodeInfo3.addAction(1);
                            }
                        }
                        if (!SemanticsNodeKt.isHidden(semanticsNode2) || z) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        accessibilityNodeInfo3.setVisibleToUser(z2);
                        if (semanticsNode2.isFake$ui()) {
                            parent2 = semanticsNode2.getParent();
                            parent2.getClass();
                        } else {
                            parent2 = semanticsNode2;
                        }
                        if (parent2.getTouchBoundsInRoot().isEmpty()) {
                            accessibilityNodeInfo3.setVisibleToUser(false);
                        }
                        obj12 = mutableScatterMap.get(SemanticsProperties.LiveRegion);
                        if (obj12 == null) {
                            obj12 = null;
                        }
                        liveRegionMode = (LiveRegionMode) obj12;
                        if (liveRegionMode != null) {
                            z7 = liveRegionMode.value;
                            if (!z7 && z7) {
                                i12 = 2;
                            } else {
                                i12 = 1;
                            }
                            accessibilityNodeInfo4.setLiveRegion(i12);
                        }
                        accessibilityNodeInfo3.setClickable(false);
                        obj13 = mutableScatterMap.get(SemanticsActions.OnClick);
                        if (obj13 == null) {
                            obj13 = null;
                        }
                        accessibilityAction = (AccessibilityAction) obj13;
                        if (accessibilityAction != null) {
                            obj19 = mutableScatterMap.get(SemanticsProperties.Selected);
                            if (obj19 == null) {
                                obj19 = null;
                            }
                            boolean zAreEqual4 = Intrinsics.areEqual(obj19, bool2);
                            z5 = (role3 == null && role3.value == 4) || (role3 != null && role3.value == 3);
                            if (z5 || (z5 && !zAreEqual4)) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            accessibilityNodeInfo3.setClickable(z6);
                            if (InvertMatrixKt.enabled(semanticsNode2) && accessibilityNodeInfo4.isClickable()) {
                                accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(null, 16, accessibilityAction.label, null));
                            }
                        }
                        accessibilityNodeInfo3.setLongClickable(false);
                        accessibilityAction2 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.OnLongClick);
                        if (accessibilityAction2 != null) {
                            accessibilityNodeInfo3.setLongClickable(true);
                            if (InvertMatrixKt.enabled(semanticsNode2)) {
                                accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, accessibilityAction2.label));
                            }
                        }
                        accessibilityAction3 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.CopyText);
                        if (accessibilityAction3 != null) {
                            accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, accessibilityAction3.label));
                        }
                        if (InvertMatrixKt.enabled(semanticsNode2)) {
                            accessibilityAction9 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.SetText);
                            if (accessibilityAction9 != null) {
                                accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, accessibilityAction9.label));
                            }
                            accessibilityAction10 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.OnImeAction);
                            if (accessibilityAction10 != null) {
                                accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionImeEnter, accessibilityAction10.label));
                            }
                            accessibilityAction11 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.CutText);
                            if (accessibilityAction11 != null) {
                                accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, accessibilityAction11.label));
                            }
                            accessibilityAction12 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.PasteText);
                            if (accessibilityAction12 != null && accessibilityNodeInfo4.isFocused()) {
                                primaryClipDescription = ((CallbackWrapper) androidComposeView.getClipboardManager()).getClipboardManager().getPrimaryClipDescription();
                                if (primaryClipDescription != null) {
                                    zHasMimeType = primaryClipDescription.hasMimeType("text/*");
                                } else {
                                    zHasMimeType = false;
                                }
                                if (zHasMimeType) {
                                    accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, accessibilityAction12.label));
                                }
                            }
                        }
                        iterableTextForAccessibility = AndroidComposeViewAccessibilityDelegateCompat.getIterableTextForAccessibility(semanticsNode2);
                        if (iterableTextForAccessibility != null && iterableTextForAccessibility.length() != 0) {
                            accessibilityNodeInfo4.setTextSelection(androidComposeViewAccessibilityDelegateCompat.getAccessibilitySelectionStart(semanticsNode2), androidComposeViewAccessibilityDelegateCompat.getAccessibilitySelectionEnd(semanticsNode2));
                            accessibilityAction8 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.SetSelection);
                            if (accessibilityAction8 != null) {
                                str5 = accessibilityAction8.label;
                            } else {
                                str5 = null;
                            }
                            accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, str5));
                            accessibilityNodeInfo3.addAction(256);
                            accessibilityNodeInfo3.addAction(512);
                            accessibilityNodeInfo3.setMovementGranularities(11);
                            list3 = (List) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.ContentDescription);
                            if ((list3 != null || list3.isEmpty()) && mutableScatterMap.containsKey(SemanticsActions.GetTextLayoutResult)) {
                                if (semanticsNode2.unmergedConfig.props.containsKey(SemanticsProperties.EditableText)) {
                                    obj18 = semanticsNode2.unmergedConfig.props.get(SemanticsProperties.Focused);
                                    if (obj18 == null) {
                                        obj18 = null;
                                    }
                                    if (Intrinsics.areEqual(obj18, Boolean.TRUE)) {
                                        parent$ui = semanticsNode2.layoutNode.getParent$ui();
                                        while (true) {
                                            if (parent$ui == null) {
                                                parent$ui = null;
                                                break;
                                            }
                                            semanticsConfiguration5 = parent$ui.getSemanticsConfiguration();
                                            if (semanticsConfiguration5 == null && semanticsConfiguration5.isMergingSemanticsOfDescendants) {
                                                if (semanticsConfiguration5.props.containsKey(SemanticsProperties.EditableText)) {
                                                    break;
                                                }
                                            }
                                            parent$ui = parent$ui.getParent$ui();
                                        }
                                        if (parent$ui != null) {
                                            semanticsConfiguration4 = parent$ui.getSemanticsConfiguration();
                                            if (semanticsConfiguration4 != null) {
                                                obj17 = semanticsConfiguration4.props.get(SemanticsProperties.Focused);
                                                if (obj17 == null) {
                                                    obj17 = null;
                                                }
                                                zAreEqual = Intrinsics.areEqual(obj17, Boolean.TRUE);
                                            } else {
                                                zAreEqual = false;
                                            }
                                            z4 = zAreEqual ? false : true;
                                        }
                                    }
                                } else {
                                    parent$ui = semanticsNode2.layoutNode.getParent$ui();
                                    while (true) {
                                        if (parent$ui == null) {
                                            parent$ui = null;
                                            break;
                                        }
                                        semanticsConfiguration5 = parent$ui.getSemanticsConfiguration();
                                        if (semanticsConfiguration5 == null) {
                                        }
                                        parent$ui = parent$ui.getParent$ui();
                                    }
                                    if (parent$ui != null) {
                                        semanticsConfiguration4 = parent$ui.getSemanticsConfiguration();
                                        if (semanticsConfiguration4 != null) {
                                            obj17 = semanticsConfiguration4.props.get(SemanticsProperties.Focused);
                                            if (obj17 == null) {
                                                obj17 = null;
                                            }
                                            zAreEqual = Intrinsics.areEqual(obj17, Boolean.TRUE);
                                        } else {
                                            zAreEqual = false;
                                        }
                                        if (zAreEqual) {
                                        }
                                    }
                                }
                                if (!z4) {
                                    accessibilityNodeInfo3.setMovementGranularities(accessibilityNodeInfo4.getMovementGranularities() | 20);
                                }
                            }
                        }
                        arrayList = new ArrayList();
                        arrayList.add("androidx.compose.ui.semantics.id");
                        text = accessibilityNodeInfoCompat3.getText();
                        if (text != null && text.length() != 0 && mutableScatterMap.containsKey(SemanticsActions.GetTextLayoutResult)) {
                            arrayList.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
                        }
                        if (Build.VERSION.SDK_INT >= 37 && (((text2 = accessibilityNodeInfoCompat3.getText()) != null && text2.length() != 0) || mutableScatterMap.containsKey(SemanticsProperties.EditableText) || mutableScatterMap.containsKey(SemanticsActions.GetTextLayoutResult))) {
                            arrayList.add("android.view.accessibility.extra.DATA_RENDERING_INFO_KEY");
                        }
                        if (mutableScatterMap.containsKey(SemanticsProperties.TestTag)) {
                            arrayList.add("androidx.compose.ui.semantics.testTag");
                        }
                        if (mutableScatterMap.containsKey(SemanticsProperties.Shape)) {
                            arrayList.add("androidx.compose.ui.semantics.shapeType");
                            arrayList.add("androidx.compose.ui.semantics.shapeRect");
                            arrayList.add("androidx.compose.ui.semantics.shapeCorners");
                            arrayList.add("androidx.compose.ui.semantics.shapeRegion");
                        }
                        accessibilityNodeInfo4.setAvailableExtraData(arrayList);
                        progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.ProgressBarRangeInfo);
                        if (progressBarRangeInfo != null) {
                            f = progressBarRangeInfo.current;
                            closedFloatRange = progressBarRangeInfo.range;
                            semanticsPropertyKey4 = SemanticsActions.SetProgress;
                            if (mutableScatterMap.containsKey(semanticsPropertyKey4)) {
                                accessibilityNodeInfoCompat3.setClassName("android.widget.SeekBar");
                            } else {
                                accessibilityNodeInfoCompat3.setClassName("android.widget.ProgressBar");
                            }
                            if (progressBarRangeInfo != ProgressBarRangeInfo.Indeterminate) {
                                accessibilityNodeInfo3.setRangeInfo((AccessibilityNodeInfo.RangeInfo) new Extras.Key(AccessibilityNodeInfo.RangeInfo.obtain(1, closedFloatRange._start, closedFloatRange._endInclusive, f)).f9default);
                            }
                            if (mutableScatterMap.containsKey(semanticsPropertyKey4) && InvertMatrixKt.enabled(semanticsNode2)) {
                                float f4 = closedFloatRange._endInclusive;
                                float f5 = closedFloatRange._start;
                                fFloatValue = Float.valueOf(f4).floatValue();
                                fFloatValue2 = Float.valueOf(f5).floatValue();
                                if (fFloatValue < fFloatValue2) {
                                    fFloatValue = fFloatValue2;
                                }
                                if (f < fFloatValue) {
                                    accessibilityNodeInfoCompat3.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                                }
                                fFloatValue3 = Float.valueOf(f5).floatValue();
                                fFloatValue4 = Float.valueOf(closedFloatRange._endInclusive).floatValue();
                                if (fFloatValue3 > fFloatValue4) {
                                    fFloatValue3 = fFloatValue4;
                                }
                                if (f > fFloatValue3) {
                                    accessibilityNodeInfoCompat3.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                }
                            }
                        }
                        if (InvertMatrixKt.enabled(semanticsNode2)) {
                            obj16 = semanticsNode2.unmergedConfig.props.get(SemanticsActions.SetProgress);
                            if (obj16 == null) {
                                obj16 = null;
                            }
                            accessibilityAction7 = (AccessibilityAction) obj16;
                            if (accessibilityAction7 != null) {
                                accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(null, android.R.id.accessibilityActionSetProgress, accessibilityAction7.label, null));
                            }
                        }
                        DatabaseDao_Impl.AnonymousClass17.setCollectionInfo(semanticsNode2, accessibilityNodeInfoCompat3);
                        DatabaseDao_Impl.AnonymousClass17.setCollectionItemInfo(semanticsNode2, accessibilityNodeInfoCompat3);
                        scrollAxisRange = (ScrollAxisRange) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.HorizontalScrollAxisRange);
                        AccessibilityAction accessibilityAction14 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.ScrollBy);
                        if (scrollAxisRange != null && accessibilityAction14 != null) {
                            obj14 = semanticsNode2.getConfig().props.get(SemanticsProperties.CollectionInfo);
                            if (obj14 == null) {
                                obj14 = null;
                            }
                            if (obj14 == null) {
                                obj15 = semanticsNode2.getConfig().props.get(SemanticsProperties.SelectableGroup);
                                if (obj15 == null) {
                                    obj15 = null;
                                }
                                if (obj15 == null) {
                                    accessibilityNodeInfoCompat3.setClassName("android.widget.HorizontalScrollView");
                                }
                            }
                            if (((Number) scrollAxisRange.maxValue.invoke()).floatValue() > CropImageView.DEFAULT_ASPECT_RATIO) {
                                accessibilityNodeInfo3.setScrollable(true);
                            }
                            if (InvertMatrixKt.enabled(semanticsNode2)) {
                                zPopulateAccessibilityNodeInfoProperties$canScrollForward = AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange);
                                layoutDirection = LayoutDirection.Rtl;
                                if (zPopulateAccessibilityNodeInfoProperties$canScrollForward) {
                                    accessibilityNodeInfoCompat3.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                                    layoutNode = layoutNode2;
                                    if (layoutNode.layoutDirection == layoutDirection) {
                                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                                    } else {
                                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                                    }
                                    accessibilityNodeInfoCompat3.addAction(accessibilityActionCompat2);
                                } else {
                                    layoutNode = layoutNode2;
                                }
                                if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange)) {
                                    accessibilityNodeInfoCompat3.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                    if (layoutNode.layoutDirection == layoutDirection) {
                                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                                    } else {
                                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                                    }
                                    accessibilityNodeInfoCompat3.addAction(accessibilityActionCompat);
                                }
                            }
                        }
                        scrollAxisRange2 = (ScrollAxisRange) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.VerticalScrollAxisRange);
                        if (scrollAxisRange2 != null || accessibilityAction14 == null) {
                            z3 = true;
                        } else {
                            Object obj27 = semanticsNode2.getConfig().props.get(SemanticsProperties.CollectionInfo);
                            if (obj27 == null) {
                                obj27 = null;
                            }
                            if (obj27 == null) {
                                Object obj28 = semanticsNode2.getConfig().props.get(SemanticsProperties.SelectableGroup);
                                if (obj28 == null) {
                                    obj28 = null;
                                }
                                if (obj28 == null) {
                                    accessibilityNodeInfoCompat3.setClassName("android.widget.ScrollView");
                                }
                            }
                            z3 = true;
                            if (((Number) scrollAxisRange2.maxValue.invoke()).floatValue() > CropImageView.DEFAULT_ASPECT_RATIO) {
                                accessibilityNodeInfo3.setScrollable(true);
                            }
                            if (InvertMatrixKt.enabled(semanticsNode2)) {
                                if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange2)) {
                                    accessibilityNodeInfoCompat3.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                                    accessibilityNodeInfoCompat3.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                                }
                                if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange2)) {
                                    accessibilityNodeInfoCompat3.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                    accessibilityNodeInfoCompat3.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                                }
                            }
                        }
                        if (Build.VERSION.SDK_INT >= 29) {
                            InvertMatrixKt.addPageActions(semanticsNode2, accessibilityNodeInfoCompat3);
                        }
                        accessibilityNodeInfoCompat3.setPaneTitle((CharSequence) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.PaneTitle));
                        if (InvertMatrixKt.enabled(semanticsNode2)) {
                            accessibilityAction4 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.Expand);
                            if (accessibilityAction4 != null) {
                                accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, accessibilityAction4.label));
                            }
                            accessibilityAction5 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.Collapse);
                            if (accessibilityAction5 != null) {
                                accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, accessibilityAction5.label));
                            }
                            accessibilityAction6 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.Dismiss);
                            if (accessibilityAction6 != null) {
                                accessibilityNodeInfoCompat3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(ByteChannelKt.CHANNEL_MAX_SIZE, accessibilityAction6.label));
                            }
                            semanticsPropertyKey3 = SemanticsActions.CustomActions;
                            if (mutableScatterMap.containsKey(semanticsPropertyKey3)) {
                                list2 = (List) semanticsConfiguration3.get(semanticsPropertyKey3);
                                size2 = list2.size();
                                mutableIntList = AndroidComposeViewAccessibilityDelegateCompat.AccessibilityActionsResourceIds;
                                i7 = mutableIntList._size;
                                if (size2 < i7) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2(IntIntPair$$ExternalSyntheticOutline0.m(i7, "Can't have more than ", " custom actions for one widget"));
                                    return null;
                                }
                                SparseArrayCompat sparseArrayCompat3 = new SparseArrayCompat(0);
                                MutableObjectIntMap mutableObjectIntMapMutableObjectIntMapOf2 = ObjectIntMapKt.mutableObjectIntMapOf();
                                if (sparseArrayCompat.garbage) {
                                    ArraySetKt.gc(sparseArrayCompat);
                                }
                                if (ContainerHelpersKt.binarySearch(sparseArrayCompat.size, i6, sparseArrayCompat.keys) < 0) {
                                    z3 = false;
                                }
                                if (z3) {
                                    mutableObjectIntMap = (MutableObjectIntMap) ArraySetKt.commonGet(sparseArrayCompat, i6);
                                    iArr = mutableIntList.content;
                                    i8 = mutableIntList._size;
                                    iArrCopyOf = new int[16];
                                    i9 = 0;
                                    i10 = 0;
                                    while (i9 < i8) {
                                        int i314 = iArr[i9];
                                        int i315 = i8;
                                        i11 = i10 + 1;
                                        int i316 = i9;
                                        if (iArrCopyOf.length < i11) {
                                            iArrCopyOf = Arrays.copyOf(iArrCopyOf, Math.max(i11, (iArrCopyOf.length * 3) / 2));
                                        }
                                        iArrCopyOf[i10] = i314;
                                        i9 = i316 + 1;
                                        i10 = i11;
                                        i8 = i315;
                                    }
                                    arrayList2 = new ArrayList();
                                    if (list2.size() <= 0) {
                                        Fragment$5$$ExternalSyntheticOutline0.m833m(list2.get(0));
                                        mutableObjectIntMap.getClass();
                                        throw null;
                                    }
                                    if (arrayList2.size() <= 0) {
                                        Fragment$5$$ExternalSyntheticOutline0.m833m(arrayList2.get(0));
                                        if (i10 <= 0) {
                                            _UtilJvmKt$$ExternalSyntheticLambda0.m("Index must be between 0 and size");
                                            return null;
                                        }
                                        int i317 = iArrCopyOf[0];
                                        throw null;
                                    }
                                } else if (list2.size() > 0) {
                                    Fragment$5$$ExternalSyntheticOutline0.m833m(list2.get(0));
                                    mutableIntList.get(0);
                                    throw null;
                                }
                                androidComposeViewAccessibilityDelegateCompat.actionIdToLabel.put(i6, sparseArrayCompat3);
                                sparseArrayCompat.put(i6, mutableObjectIntMapMutableObjectIntMapOf2);
                            }
                        }
                        accessibilityNodeInfoCompat3.setScreenReaderFocusable(InvertMatrixKt.isScreenReaderFocusable(semanticsNode2, resources, z));
                        orDefault = androidComposeViewAccessibilityDelegateCompat.idToBeforeMap.getOrDefault(i6, -1);
                        if (orDefault != -1) {
                            androidViewsHandler$ui2 = androidComposeView.getAndroidViewsHandler$ui();
                            if (androidViewsHandler$ui2 != null) {
                                androidViewHolderSemanticsIdToView2 = InvertMatrixKt.semanticsIdToView(androidViewsHandler$ui2, orDefault);
                            } else {
                                androidViewHolderSemanticsIdToView2 = null;
                            }
                            if (androidViewHolderSemanticsIdToView2 != null) {
                                accessibilityNodeInfo3.setTraversalBefore(androidViewHolderSemanticsIdToView2);
                                androidComposeView2 = androidComposeView;
                            } else {
                                androidComposeView2 = androidComposeView;
                                accessibilityNodeInfo3.setTraversalBefore(androidComposeView2, orDefault);
                            }
                            androidComposeViewAccessibilityDelegateCompat.addExtraDataToAccessibilityNodeInfoHelper(i6, accessibilityNodeInfoCompat3, androidComposeViewAccessibilityDelegateCompat.ExtraDataTestTraversalBeforeVal, null);
                        } else {
                            androidComposeView2 = androidComposeView;
                        }
                        orDefault2 = androidComposeViewAccessibilityDelegateCompat.idToAfterMap.getOrDefault(i6, -1);
                        if (orDefault2 != -1) {
                            androidViewsHandler$ui = androidComposeView2.getAndroidViewsHandler$ui();
                            if (androidViewsHandler$ui != null) {
                                androidViewHolderSemanticsIdToView = InvertMatrixKt.semanticsIdToView(androidViewsHandler$ui, orDefault2);
                            } else {
                                androidViewHolderSemanticsIdToView = null;
                            }
                            if (androidViewHolderSemanticsIdToView != null) {
                                accessibilityNodeInfo3.setTraversalAfter(androidViewHolderSemanticsIdToView);
                                androidComposeViewAccessibilityDelegateCompat.addExtraDataToAccessibilityNodeInfoHelper(i6, accessibilityNodeInfoCompat3, androidComposeViewAccessibilityDelegateCompat.ExtraDataTestTraversalAfterVal, null);
                            }
                        }
                        str4 = (String) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsNodeKt.AccessibilityClassName);
                        if (str4 != null) {
                            accessibilityNodeInfoCompat3.setClassName(str4);
                        }
                    } else {
                        androidComposeViewAccessibilityDelegateCompat = androidComposeViewAccessibilityDelegateCompat2;
                        i6 = i;
                        accessibilityNodeInfoCompat3 = null;
                    }
                }
            }
            if (androidComposeViewAccessibilityDelegateCompat.sendingFocusAffectingEvent) {
                if (i6 == androidComposeViewAccessibilityDelegateCompat.accessibilityFocusedVirtualViewId) {
                    androidComposeViewAccessibilityDelegateCompat.currentlyAccessibilityFocusedANI = accessibilityNodeInfoCompat3;
                }
                if (i6 == androidComposeViewAccessibilityDelegateCompat.focusedVirtualViewId) {
                    androidComposeViewAccessibilityDelegateCompat.currentlyFocusedANI = accessibilityNodeInfoCompat3;
                }
            }
            return accessibilityNodeInfoCompat3;
        }

        @Override // androidx.datastore.core.AtomicInt
        public final AccessibilityNodeInfoCompat findFocus(int i) {
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
            if (i != 1) {
                if (i == 2) {
                    return createAccessibilityNodeInfo(androidComposeViewAccessibilityDelegateCompat.accessibilityFocusedVirtualViewId);
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "Unknown focus type: "));
                return null;
            }
            int i2 = androidComposeViewAccessibilityDelegateCompat.focusedVirtualViewId;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return createAccessibilityNodeInfo(i2);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:159:0x0269  */
        /* JADX WARN: Code duplicated, block: B:18:0x0058  */
        /* JADX WARN: Code duplicated, block: B:20:0x005e  */
        /* JADX WARN: Code duplicated, block: B:22:0x0062  */
        /* JADX WARN: Code duplicated, block: B:272:0x0440  */
        /* JADX WARN: Code duplicated, block: B:273:0x0442  */
        /* JADX WARN: Code duplicated, block: B:276:0x0447  */
        /* JADX WARN: Code duplicated, block: B:277:0x0449  */
        /* JADX WARN: Code duplicated, block: B:280:0x044f  */
        /* JADX WARN: Code duplicated, block: B:281:0x0451  */
        /* JADX WARN: Code duplicated, block: B:284:0x0457  */
        /* JADX WARN: Code duplicated, block: B:285:0x0459  */
        /* JADX WARN: Code duplicated, block: B:288:0x045f  */
        /* JADX WARN: Code duplicated, block: B:289:0x0461  */
        /* JADX WARN: Code duplicated, block: B:292:0x0467  */
        /* JADX WARN: Code duplicated, block: B:293:0x0469  */
        /* JADX WARN: Code duplicated, block: B:300:0x0475  */
        /* JADX WARN: Code duplicated, block: B:307:0x0481  */
        /* JADX WARN: Code duplicated, block: B:310:0x0486  */
        /* JADX WARN: Code duplicated, block: B:312:0x048e  */
        /* JADX WARN: Code duplicated, block: B:315:0x0499  */
        /* JADX WARN: Code duplicated, block: B:318:0x049e  */
        /* JADX WARN: Code duplicated, block: B:320:0x04a2  */
        /* JADX WARN: Code duplicated, block: B:322:0x04aa  */
        /* JADX WARN: Code duplicated, block: B:323:0x04ac  */
        /* JADX WARN: Code duplicated, block: B:327:0x04b2  */
        /* JADX WARN: Code duplicated, block: B:330:0x04b7  */
        /* JADX WARN: Code duplicated, block: B:332:0x04bf  */
        /* JADX WARN: Code duplicated, block: B:334:0x04c5  */
        /* JADX WARN: Code duplicated, block: B:337:0x04cc  */
        /* JADX WARN: Code duplicated, block: B:339:0x04de  */
        /* JADX WARN: Code duplicated, block: B:341:0x04f9  */
        /* JADX WARN: Code duplicated, block: B:344:0x04fe  */
        /* JADX WARN: Code duplicated, block: B:349:0x0517  */
        /* JADX WARN: Code duplicated, block: B:352:0x0520  */
        /* JADX WARN: Code duplicated, block: B:356:0x0527  */
        /* JADX WARN: Code duplicated, block: B:358:0x0531  */
        /* JADX WARN: Code duplicated, block: B:361:0x0536 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:401:0x05b6  */
        /* JADX WARN: Code duplicated, block: B:404:0x05c2  */
        /* JADX WARN: Code duplicated, block: B:407:0x05c7 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:409:0x05cb  */
        /* JADX WARN: Code duplicated, block: B:410:0x05d0  */
        /* JADX WARN: Code duplicated, block: B:412:0x05d9 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:413:0x05db  */
        /* JADX WARN: Code duplicated, block: B:416:0x05e2  */
        /* JADX WARN: Code duplicated, block: B:418:0x05ea  */
        /* JADX WARN: Code duplicated, block: B:425:0x0606  */
        /* JADX WARN: Code duplicated, block: B:427:0x060a  */
        /* JADX WARN: Code duplicated, block: B:429:0x0612  */
        /* JADX WARN: Code duplicated, block: B:430:0x0614  */
        /* JADX WARN: Code duplicated, block: B:432:0x0618  */
        /* JADX WARN: Code duplicated, block: B:434:0x061e  */
        /* JADX WARN: Code duplicated, block: B:435:0x0620  */
        /* JADX WARN: Code duplicated, block: B:438:0x0625  */
        /* JADX WARN: Code duplicated, block: B:506:0x070c A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:507:0x070e  */
        /* JADX WARN: Code duplicated, block: B:509:0x071c  */
        /* JADX WARN: Code duplicated, block: B:510:0x071e  */
        /* JADX WARN: Code duplicated, block: B:514:0x0724  */
        /* JADX WARN: Code duplicated, block: B:516:0x072a  */
        /* JADX WARN: Code duplicated, block: B:519:0x0738  */
        /* JADX WARN: Code duplicated, block: B:524:0x0746  */
        /* JADX WARN: Code duplicated, block: B:537:0x075e  */
        /* JADX WARN: Code duplicated, block: B:542:0x0770  */
        /* JADX WARN: Code duplicated, block: B:549:0x0782  */
        /* JADX WARN: Code duplicated, block: B:551:0x0786  */
        /* JADX WARN: Code duplicated, block: B:553:0x0793  */
        /* JADX WARN: Code duplicated, block: B:555:0x0797  */
        /* JADX WARN: Code duplicated, block: B:568:0x07f7  */
        /* JADX WARN: Code duplicated, block: B:570:0x07fd A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:571:0x07ff  */
        /* JADX WARN: Code duplicated, block: B:572:0x0801  */
        /* JADX WARN: Code duplicated, block: B:575:0x0808  */
        /* JADX WARN: Code duplicated, block: B:576:0x080d  */
        /* JADX WARN: Code duplicated, block: B:579:0x0815  */
        /* JADX WARN: Code duplicated, block: B:581:0x081f  */
        /* JADX WARN: Code duplicated, block: B:593:0x0840 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:594:0x0842  */
        /* JADX WARN: Code duplicated, block: B:595:0x0844  */
        /* JADX WARN: Code duplicated, block: B:598:0x0848  */
        /* JADX WARN: Code duplicated, block: B:599:0x084a  */
        /* JADX WARN: Code duplicated, block: B:602:0x085e  */
        /* JADX WARN: Code duplicated, block: B:604:0x0863  */
        /* JADX WARN: Code duplicated, block: B:606:0x0873 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:608:0x0876  */
        /* JADX WARN: Code duplicated, block: B:96:0x0145  */
        /* JADX WARN: Code restructure failed: missing block: B:622:0x01b9, code lost:
        
            r1 = null;
         */
        /* JADX WARN: Instruction removed from duplicated block: B:22:0x0062, please report this as an issue */
        @Override // androidx.datastore.core.AtomicInt
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean performAction(int i, int i2, Bundle bundle) {
            SemanticsNode semanticsNode;
            int i3;
            int i4;
            Integer num;
            int i5;
            boolean z;
            boolean z2;
            Integer num2;
            String iterableTextForAccessibility;
            String iterableTextForAccessibility2;
            BaseMenuWrapper baseMenuWrapper;
            int accessibilitySelectionEnd;
            int[] iArrPreceding;
            int i6;
            int i7;
            int accessibilitySelectionStart;
            int i8;
            int i9;
            int length;
            AccessibilityIterators$WordTextSegmentIterator accessibilityIterators$WordTextSegmentIterator;
            TextLayoutResult textLayoutResult;
            AccessibilityIterators$PageTextSegmentIterator accessibilityIterators$PageTextSegmentIterator;
            AccessibilityIterators$PageTextSegmentIterator accessibilityIterators$PageTextSegmentIterator2;
            AccessibilityIterators$WordTextSegmentIterator accessibilityIterators$WordTextSegmentIterator2;
            AccessibilityIterators$WordTextSegmentIterator accessibilityIterators$WordTextSegmentIterator3;
            AccessibilityIterators$ParagraphTextSegmentIterator accessibilityIterators$ParagraphTextSegmentIterator;
            Function0 function0;
            Function0 function1;
            Function0 function2;
            Function0 function3;
            Function0 function4;
            Function0 function5;
            Function0 function6;
            Function0 function7;
            Function0 function8;
            Function1 function9;
            AccessibilityAction accessibilityAction;
            long jMo606localToRootMKHz9U;
            long jFloatToRawIntBits;
            Function1 function10;
            Function0 function11;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            Object obj;
            ProgressBarRangeInfo progressBarRangeInfo;
            Object obj2;
            AccessibilityAction accessibilityAction2;
            ClosedFloatRange closedFloatRange;
            float f;
            float f2;
            float f3;
            int i10;
            float f4;
            float f5;
            float f6;
            Function1 function12;
            long jM444getSizeNHjbRc;
            Object obj3;
            AccessibilityAction accessibilityAction3;
            Float f7;
            Object obj4;
            AccessibilityAction accessibilityAction4;
            Object obj5;
            ScrollAxisRange scrollAxisRange;
            Object obj6;
            ScrollAxisRange scrollAxisRange2;
            float fIntBitsToFloat;
            SemanticsPropertyKey semanticsPropertyKey;
            Object obj7;
            Object obj8;
            AccessibilityAction accessibilityAction5;
            Function0 function13;
            Object obj9;
            Object obj10;
            AccessibilityAction accessibilityAction6;
            Function0 function14;
            Function1 function15;
            Function0 function16;
            Function0 function17;
            Function0 function18;
            Function0 function19;
            Float fValueOf = Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO);
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
            AndroidComposeView androidComposeView = androidComposeViewAccessibilityDelegateCompat.view;
            AdjustedSemanticsNode adjustedSemanticsNode = (AdjustedSemanticsNode) androidComposeViewAccessibilityDelegateCompat.getCurrentSemanticsNodes().get(i);
            if (adjustedSemanticsNode != null && (semanticsNode = adjustedSemanticsNode.semanticsNode) != null) {
                LayoutNode layoutNode = semanticsNode.layoutNode;
                int i11 = semanticsNode.id;
                SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
                MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
                Object obj11 = mutableScatterMap.get(SemanticsProperties.IsSensitiveData);
                if (obj11 == null) {
                    obj11 = null;
                }
                Boolean bool = Boolean.TRUE;
                if (Intrinsics.areEqual(obj11, bool)) {
                    if (Build.VERSION.SDK_INT >= 34 ? TextViewCompat$Api34Impl.isRequestFromAccessibilityTool(androidComposeView.getComposeViewContext().accessibilityManager.accessibilityManager) : true) {
                        if (i2 != 64) {
                            if (androidComposeViewAccessibilityDelegateCompat.isAccessibilityEnabled() || !androidComposeView.getComposeViewContext()._isTouchExplorationEnabled || (i3 = androidComposeViewAccessibilityDelegateCompat.accessibilityFocusedVirtualViewId) == i) {
                                return false;
                            }
                            if (i3 != Integer.MIN_VALUE) {
                                i4 = 12;
                                num = null;
                                AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, i3, 65536, null, 12);
                            } else {
                                i4 = 12;
                                num = null;
                            }
                            androidComposeViewAccessibilityDelegateCompat.accessibilityFocusedVirtualViewId = i;
                            androidComposeView.invalidate();
                            AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, i, 32768, num, i4);
                            return true;
                        }
                        if (i2 != 128) {
                            if (androidComposeViewAccessibilityDelegateCompat.accessibilityFocusedVirtualViewId == i) {
                                return false;
                            }
                            androidComposeViewAccessibilityDelegateCompat.accessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
                            androidComposeViewAccessibilityDelegateCompat.currentlyAccessibilityFocusedANI = null;
                            androidComposeView.invalidate();
                            AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, i, 65536, null, 12);
                            return true;
                        }
                        if (i2 != 256 || i2 == 512) {
                            if (bundle != null) {
                                i5 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
                                z = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
                                if (i2 == 256) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                num2 = androidComposeViewAccessibilityDelegateCompat.previousTraversedNode;
                                if (num2 != null || i11 != num2.intValue()) {
                                    androidComposeViewAccessibilityDelegateCompat.accessibilityCursorPosition = -1;
                                    androidComposeViewAccessibilityDelegateCompat.previousTraversedNode = Integer.valueOf(i11);
                                }
                                iterableTextForAccessibility = AndroidComposeViewAccessibilityDelegateCompat.getIterableTextForAccessibility(semanticsNode);
                                if (iterableTextForAccessibility != null && iterableTextForAccessibility.length() != 0) {
                                    iterableTextForAccessibility2 = AndroidComposeViewAccessibilityDelegateCompat.getIterableTextForAccessibility(semanticsNode);
                                    if (iterableTextForAccessibility2 != null || iterableTextForAccessibility2.length() == 0) {
                                        baseMenuWrapper = null;
                                    } else {
                                        if (i5 == 1) {
                                            Locale locale = androidComposeView.getContext().getResources().getConfiguration().locale;
                                            accessibilityIterators$WordTextSegmentIterator = AccessibilityIterators$WordTextSegmentIterator.instance$1;
                                            if (accessibilityIterators$WordTextSegmentIterator == null) {
                                                accessibilityIterators$WordTextSegmentIterator = new AccessibilityIterators$WordTextSegmentIterator((byte) 1);
                                                accessibilityIterators$WordTextSegmentIterator.impl = BreakIterator.getCharacterInstance(locale);
                                                AccessibilityIterators$WordTextSegmentIterator.instance$1 = accessibilityIterators$WordTextSegmentIterator;
                                            }
                                            accessibilityIterators$WordTextSegmentIterator.initialize(iterableTextForAccessibility2);
                                        } else if (i5 == 2) {
                                            Locale locale2 = androidComposeView.getContext().getResources().getConfiguration().locale;
                                            accessibilityIterators$WordTextSegmentIterator = AccessibilityIterators$WordTextSegmentIterator.instance;
                                            if (accessibilityIterators$WordTextSegmentIterator == null) {
                                                accessibilityIterators$WordTextSegmentIterator = new AccessibilityIterators$WordTextSegmentIterator((byte) 0);
                                                accessibilityIterators$WordTextSegmentIterator.impl = BreakIterator.getWordInstance(locale2);
                                                AccessibilityIterators$WordTextSegmentIterator.instance = accessibilityIterators$WordTextSegmentIterator;
                                            }
                                            accessibilityIterators$WordTextSegmentIterator.initialize(iterableTextForAccessibility2);
                                        } else if (i5 == 4) {
                                            if (mutableScatterMap.containsKey(SemanticsActions.GetTextLayoutResult) || (textLayoutResult = InvertMatrixKt.getTextLayoutResult(semanticsConfiguration)) == null) {
                                                baseMenuWrapper = null;
                                            } else if (i5 == 4) {
                                                accessibilityIterators$WordTextSegmentIterator2 = AccessibilityIterators$WordTextSegmentIterator.lineInstance;
                                                if (accessibilityIterators$WordTextSegmentIterator2 == null) {
                                                    accessibilityIterators$WordTextSegmentIterator3 = accessibilityIterators$WordTextSegmentIterator2;
                                                    AccessibilityIterators$WordTextSegmentIterator accessibilityIterators$WordTextSegmentIterator4 = new AccessibilityIterators$WordTextSegmentIterator((byte) 2);
                                                    AccessibilityIterators$WordTextSegmentIterator.lineInstance = accessibilityIterators$WordTextSegmentIterator4;
                                                    accessibilityIterators$WordTextSegmentIterator3 = accessibilityIterators$WordTextSegmentIterator4;
                                                }
                                                accessibilityIterators$WordTextSegmentIterator3 = accessibilityIterators$WordTextSegmentIterator2;
                                                accessibilityIterators$WordTextSegmentIterator3.mContext = iterableTextForAccessibility2;
                                                accessibilityIterators$WordTextSegmentIterator3.impl = textLayoutResult;
                                                baseMenuWrapper = accessibilityIterators$WordTextSegmentIterator3;
                                            } else {
                                                accessibilityIterators$PageTextSegmentIterator = AccessibilityIterators$PageTextSegmentIterator.pageInstance;
                                                if (accessibilityIterators$PageTextSegmentIterator == null) {
                                                    accessibilityIterators$PageTextSegmentIterator2 = accessibilityIterators$PageTextSegmentIterator;
                                                    AccessibilityIterators$PageTextSegmentIterator accessibilityIterators$PageTextSegmentIterator3 = new AccessibilityIterators$PageTextSegmentIterator();
                                                    new Rect();
                                                    AccessibilityIterators$PageTextSegmentIterator.pageInstance = accessibilityIterators$PageTextSegmentIterator3;
                                                    accessibilityIterators$PageTextSegmentIterator2 = accessibilityIterators$PageTextSegmentIterator3;
                                                }
                                                accessibilityIterators$PageTextSegmentIterator2 = accessibilityIterators$PageTextSegmentIterator;
                                                accessibilityIterators$PageTextSegmentIterator2.mContext = iterableTextForAccessibility2;
                                                accessibilityIterators$PageTextSegmentIterator2.layoutResult = textLayoutResult;
                                                accessibilityIterators$PageTextSegmentIterator2.node = semanticsNode;
                                                baseMenuWrapper = accessibilityIterators$PageTextSegmentIterator2;
                                            }
                                        } else if (i5 == 8) {
                                            AccessibilityIterators$ParagraphTextSegmentIterator accessibilityIterators$ParagraphTextSegmentIterator2 = AccessibilityIterators$ParagraphTextSegmentIterator.instance;
                                            if (accessibilityIterators$ParagraphTextSegmentIterator2 == null) {
                                                accessibilityIterators$ParagraphTextSegmentIterator = accessibilityIterators$ParagraphTextSegmentIterator2;
                                                AccessibilityIterators$ParagraphTextSegmentIterator accessibilityIterators$ParagraphTextSegmentIterator3 = new AccessibilityIterators$ParagraphTextSegmentIterator();
                                                AccessibilityIterators$ParagraphTextSegmentIterator.instance = accessibilityIterators$ParagraphTextSegmentIterator3;
                                                accessibilityIterators$ParagraphTextSegmentIterator = accessibilityIterators$ParagraphTextSegmentIterator3;
                                            }
                                            accessibilityIterators$ParagraphTextSegmentIterator = accessibilityIterators$ParagraphTextSegmentIterator2;
                                            accessibilityIterators$ParagraphTextSegmentIterator.mContext = iterableTextForAccessibility2;
                                            baseMenuWrapper = accessibilityIterators$ParagraphTextSegmentIterator;
                                        } else if (i5 != 16) {
                                            baseMenuWrapper = null;
                                        } else if (mutableScatterMap.containsKey(SemanticsActions.GetTextLayoutResult)) {
                                            baseMenuWrapper = null;
                                        } else if (i5 == 4) {
                                            accessibilityIterators$WordTextSegmentIterator2 = AccessibilityIterators$WordTextSegmentIterator.lineInstance;
                                            if (accessibilityIterators$WordTextSegmentIterator2 == null) {
                                                accessibilityIterators$WordTextSegmentIterator3 = accessibilityIterators$WordTextSegmentIterator2;
                                                AccessibilityIterators$WordTextSegmentIterator accessibilityIterators$WordTextSegmentIterator5 = new AccessibilityIterators$WordTextSegmentIterator((byte) 2);
                                                AccessibilityIterators$WordTextSegmentIterator.lineInstance = accessibilityIterators$WordTextSegmentIterator5;
                                                accessibilityIterators$WordTextSegmentIterator3 = accessibilityIterators$WordTextSegmentIterator5;
                                            }
                                            accessibilityIterators$WordTextSegmentIterator3 = accessibilityIterators$WordTextSegmentIterator2;
                                            accessibilityIterators$WordTextSegmentIterator3.mContext = iterableTextForAccessibility2;
                                            accessibilityIterators$WordTextSegmentIterator3.impl = textLayoutResult;
                                            baseMenuWrapper = accessibilityIterators$WordTextSegmentIterator3;
                                        } else {
                                            accessibilityIterators$PageTextSegmentIterator = AccessibilityIterators$PageTextSegmentIterator.pageInstance;
                                            if (accessibilityIterators$PageTextSegmentIterator == null) {
                                                accessibilityIterators$PageTextSegmentIterator2 = accessibilityIterators$PageTextSegmentIterator;
                                                AccessibilityIterators$PageTextSegmentIterator accessibilityIterators$PageTextSegmentIterator4 = new AccessibilityIterators$PageTextSegmentIterator();
                                                new Rect();
                                                AccessibilityIterators$PageTextSegmentIterator.pageInstance = accessibilityIterators$PageTextSegmentIterator4;
                                                accessibilityIterators$PageTextSegmentIterator2 = accessibilityIterators$PageTextSegmentIterator4;
                                            }
                                            accessibilityIterators$PageTextSegmentIterator2 = accessibilityIterators$PageTextSegmentIterator;
                                            accessibilityIterators$PageTextSegmentIterator2.mContext = iterableTextForAccessibility2;
                                            accessibilityIterators$PageTextSegmentIterator2.layoutResult = textLayoutResult;
                                            accessibilityIterators$PageTextSegmentIterator2.node = semanticsNode;
                                            baseMenuWrapper = accessibilityIterators$PageTextSegmentIterator2;
                                        }
                                        baseMenuWrapper = accessibilityIterators$WordTextSegmentIterator;
                                    }
                                    if (baseMenuWrapper != null) {
                                        accessibilitySelectionEnd = androidComposeViewAccessibilityDelegateCompat.getAccessibilitySelectionEnd(semanticsNode);
                                        if (accessibilitySelectionEnd == -1) {
                                            if (z2) {
                                                length = 0;
                                            } else {
                                                length = iterableTextForAccessibility.length();
                                            }
                                            accessibilitySelectionEnd = length;
                                        }
                                        if (z2) {
                                            iArrPreceding = baseMenuWrapper.following(accessibilitySelectionEnd);
                                        } else {
                                            iArrPreceding = baseMenuWrapper.preceding(accessibilitySelectionEnd);
                                        }
                                        if (iArrPreceding != null) {
                                            i6 = iArrPreceding[0];
                                            i7 = iArrPreceding[1];
                                            if (z || mutableScatterMap.containsKey(SemanticsProperties.ContentDescription) || !mutableScatterMap.containsKey(SemanticsProperties.EditableText)) {
                                                if (z2) {
                                                    accessibilitySelectionStart = i7;
                                                } else {
                                                    accessibilitySelectionStart = i6;
                                                }
                                                i8 = accessibilitySelectionStart;
                                            } else {
                                                accessibilitySelectionStart = androidComposeViewAccessibilityDelegateCompat.getAccessibilitySelectionStart(semanticsNode);
                                                if (accessibilitySelectionStart == -1) {
                                                    accessibilitySelectionStart = z2 ? i6 : i7;
                                                }
                                                i8 = z2 ? i7 : i6;
                                            }
                                            if (z2) {
                                                i9 = 256;
                                            } else {
                                                i9 = 512;
                                            }
                                            androidComposeViewAccessibilityDelegateCompat.pendingTextTraversedEvent = new PendingTextTraversedEvent(semanticsNode, i9, i5, i6, i7, SystemClock.uptimeMillis());
                                            androidComposeViewAccessibilityDelegateCompat.setAccessibilitySelection(semanticsNode, accessibilitySelectionStart, i8, true);
                                            return true;
                                        }
                                    }
                                }
                            }
                        } else if (i2 == 16384) {
                            Object obj12 = mutableScatterMap.get(SemanticsActions.CopyText);
                            AccessibilityAction accessibilityAction7 = (AccessibilityAction) (obj12 == null ? null : obj12);
                            if (accessibilityAction7 != null && (function0 = (Function0) accessibilityAction7.action) != null) {
                                return ((Boolean) function0.invoke()).booleanValue();
                            }
                        } else {
                            if (i2 == 131072) {
                                boolean accessibilitySelection = androidComposeViewAccessibilityDelegateCompat.setAccessibilitySelection(semanticsNode, bundle != null ? bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT", -1) : -1, bundle != null ? bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT", -1) : -1, false);
                                if (accessibilitySelection) {
                                    AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i11), 0, null, 12);
                                }
                                return accessibilitySelection;
                            }
                            if (InvertMatrixKt.enabled(semanticsNode)) {
                                if (i2 == 1) {
                                    if (androidComposeView.isInTouchMode()) {
                                        androidComposeView.requestFocusFromTouch();
                                    }
                                    Object obj13 = mutableScatterMap.get(SemanticsActions.RequestFocus);
                                    AccessibilityAction accessibilityAction8 = (AccessibilityAction) (obj13 == null ? null : obj13);
                                    if (accessibilityAction8 != null && (function1 = (Function0) accessibilityAction8.action) != null) {
                                        return ((Boolean) function1.invoke()).booleanValue();
                                    }
                                } else if (i2 != 2) {
                                    LayoutDirection layoutDirection = LayoutDirection.Rtl;
                                    switch (i2) {
                                        case 16:
                                            Object obj14 = mutableScatterMap.get(SemanticsActions.OnClick);
                                            if (obj14 == null) {
                                                obj14 = null;
                                            }
                                            AccessibilityAction accessibilityAction9 = (AccessibilityAction) obj14;
                                            Boolean bool2 = (accessibilityAction9 == null || (function2 = (Function0) accessibilityAction9.action) == null) ? null : (Boolean) function2.invoke();
                                            AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, i, 1, null, 12);
                                            if (bool2 != null) {
                                                return bool2.booleanValue();
                                            }
                                            break;
                                        case 32:
                                            Object obj15 = mutableScatterMap.get(SemanticsActions.OnLongClick);
                                            AccessibilityAction accessibilityAction10 = (AccessibilityAction) (obj15 == null ? null : obj15);
                                            if (accessibilityAction10 != null && (function3 = (Function0) accessibilityAction10.action) != null) {
                                                return ((Boolean) function3.invoke()).booleanValue();
                                            }
                                            break;
                                        case 4096:
                                        case 8192:
                                            if (i2 == 4096) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            if (i2 == 8192) {
                                                z4 = true;
                                            } else {
                                                z4 = false;
                                            }
                                            if (i2 == 16908345) {
                                                z5 = true;
                                            } else {
                                                z5 = false;
                                            }
                                            if (i2 == 16908347) {
                                                z6 = true;
                                            } else {
                                                z6 = false;
                                            }
                                            if (i2 == 16908344) {
                                                z7 = true;
                                            } else {
                                                z7 = false;
                                            }
                                            if (i2 == 16908346) {
                                                z8 = true;
                                            } else {
                                                z8 = false;
                                            }
                                            if (!z5 || z6 || z3 || z4) {
                                                z9 = true;
                                            } else {
                                                z9 = false;
                                            }
                                            if (!z7 || z8 || z3 || z4) {
                                                z10 = true;
                                            } else {
                                                z10 = false;
                                            }
                                            if (!z3 || z4) {
                                                obj = mutableScatterMap.get(SemanticsProperties.ProgressBarRangeInfo);
                                                if (obj == null) {
                                                    obj = null;
                                                }
                                                progressBarRangeInfo = (ProgressBarRangeInfo) obj;
                                                obj2 = mutableScatterMap.get(SemanticsActions.SetProgress);
                                                if (obj2 == null) {
                                                    obj2 = null;
                                                }
                                                accessibilityAction2 = (AccessibilityAction) obj2;
                                                if (progressBarRangeInfo != null) {
                                                    closedFloatRange = progressBarRangeInfo.range;
                                                    if (accessibilityAction2 != null) {
                                                        f = closedFloatRange._endInclusive;
                                                        f2 = closedFloatRange._start;
                                                        if (f < f2) {
                                                            f3 = f2;
                                                        } else {
                                                            f3 = f;
                                                        }
                                                        if (f2 <= f) {
                                                            f = f2;
                                                        }
                                                        i10 = progressBarRangeInfo.steps;
                                                        if (i10 > 0) {
                                                            f4 = f3 - f;
                                                            f5 = i10 + 1;
                                                        } else {
                                                            f4 = f3 - f;
                                                            f5 = 20.0f;
                                                        }
                                                        f6 = f4 / f5;
                                                        if (z4) {
                                                            f6 = -f6;
                                                        }
                                                        function12 = (Function1) accessibilityAction2.action;
                                                        if (function12 != null) {
                                                            return ((Boolean) function12.invoke(Float.valueOf(progressBarRangeInfo.current + f6))).booleanValue();
                                                        }
                                                    } else {
                                                        jM444getSizeNHjbRc = RulerKt.boundsInParent((InnerNodeCoordinator) layoutNode.nodes.innerCoordinator).m444getSizeNHjbRc();
                                                        ArrayList arrayList = new ArrayList();
                                                        obj3 = mutableScatterMap.get(SemanticsActions.GetScrollViewportLength);
                                                        if (obj3 == null) {
                                                            obj3 = null;
                                                        }
                                                        accessibilityAction3 = (AccessibilityAction) obj3;
                                                        if (accessibilityAction3 == null && (function15 = (Function1) accessibilityAction3.action) != null && ((Boolean) function15.invoke(arrayList)).booleanValue()) {
                                                            f7 = (Float) CollectionsKt.firstOrNull((List) arrayList);
                                                        } else {
                                                            f7 = null;
                                                        }
                                                        obj4 = mutableScatterMap.get(SemanticsActions.ScrollBy);
                                                        if (obj4 == null) {
                                                            obj4 = null;
                                                        }
                                                        accessibilityAction4 = (AccessibilityAction) obj4;
                                                        if (accessibilityAction4 != null) {
                                                            Function function = accessibilityAction4.action;
                                                            obj5 = mutableScatterMap.get(SemanticsProperties.HorizontalScrollAxisRange);
                                                            if (obj5 == null) {
                                                                obj5 = null;
                                                            }
                                                            scrollAxisRange = (ScrollAxisRange) obj5;
                                                            if (scrollAxisRange == null && z9) {
                                                                float fFloatValue = f7 != null ? f7.floatValue() : Float.intBitsToFloat((int) (jM444getSizeNHjbRc >> 32));
                                                                if (z5 || z4) {
                                                                    fFloatValue = -fFloatValue;
                                                                }
                                                                if (layoutNode.layoutDirection == layoutDirection && (z5 || z6)) {
                                                                    fFloatValue = -fFloatValue;
                                                                }
                                                                if (AndroidComposeViewAccessibilityDelegateCompat.performActionHelper$canScroll(scrollAxisRange, fFloatValue)) {
                                                                    SemanticsPropertyKey semanticsPropertyKey2 = SemanticsActions.PageLeft;
                                                                    if (mutableScatterMap.containsKey(semanticsPropertyKey2) || mutableScatterMap.containsKey(SemanticsActions.PageRight)) {
                                                                        if (fFloatValue > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                            Object obj16 = mutableScatterMap.get(SemanticsActions.PageRight);
                                                                            accessibilityAction6 = (AccessibilityAction) (obj16 == null ? null : obj16);
                                                                        } else {
                                                                            Object obj17 = mutableScatterMap.get(semanticsPropertyKey2);
                                                                            accessibilityAction6 = (AccessibilityAction) (obj17 == null ? null : obj17);
                                                                        }
                                                                        if (accessibilityAction6 != null && (function14 = (Function0) accessibilityAction6.action) != null) {
                                                                            return ((Boolean) function14.invoke()).booleanValue();
                                                                        }
                                                                    } else {
                                                                        Function2 function20 = (Function2) function;
                                                                        if (function20 != null) {
                                                                            return ((Boolean) function20.invoke(Float.valueOf(fFloatValue), fValueOf)).booleanValue();
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                f7 = f7;
                                                                z10 = z10;
                                                            }
                                                            obj6 = mutableScatterMap.get(SemanticsProperties.VerticalScrollAxisRange);
                                                            if (obj6 == null) {
                                                                obj6 = null;
                                                            }
                                                            scrollAxisRange2 = (ScrollAxisRange) obj6;
                                                            if (scrollAxisRange2 != null && z10) {
                                                                if (f7 != null) {
                                                                    fIntBitsToFloat = f7.floatValue();
                                                                } else {
                                                                    fIntBitsToFloat = Float.intBitsToFloat((int) (jM444getSizeNHjbRc & 4294967295L));
                                                                }
                                                                if (z7 || z4) {
                                                                    fIntBitsToFloat = -fIntBitsToFloat;
                                                                }
                                                                if (AndroidComposeViewAccessibilityDelegateCompat.performActionHelper$canScroll(scrollAxisRange2, fIntBitsToFloat)) {
                                                                    semanticsPropertyKey = SemanticsActions.PageUp;
                                                                    if (!mutableScatterMap.containsKey(semanticsPropertyKey) || mutableScatterMap.containsKey(SemanticsActions.PageDown)) {
                                                                        if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                            obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                            if (obj9 == null) {
                                                                                obj10 = null;
                                                                            } else {
                                                                                obj10 = obj9;
                                                                            }
                                                                            accessibilityAction5 = (AccessibilityAction) obj10;
                                                                        } else {
                                                                            obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                            if (obj7 == null) {
                                                                                obj8 = null;
                                                                            } else {
                                                                                obj8 = obj7;
                                                                            }
                                                                            accessibilityAction5 = (AccessibilityAction) obj8;
                                                                        }
                                                                        if (accessibilityAction5 != null && (function13 = (Function0) accessibilityAction5.action) != null) {
                                                                            return ((Boolean) function13.invoke()).booleanValue();
                                                                        }
                                                                    } else {
                                                                        Function2 function21 = (Function2) function;
                                                                        if (function21 != null) {
                                                                            return ((Boolean) function21.invoke(fValueOf, Float.valueOf(fIntBitsToFloat))).booleanValue();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    jM444getSizeNHjbRc = RulerKt.boundsInParent((InnerNodeCoordinator) layoutNode.nodes.innerCoordinator).m444getSizeNHjbRc();
                                                    ArrayList arrayList2 = new ArrayList();
                                                    obj3 = mutableScatterMap.get(SemanticsActions.GetScrollViewportLength);
                                                    if (obj3 == null) {
                                                        obj3 = null;
                                                    }
                                                    accessibilityAction3 = (AccessibilityAction) obj3;
                                                    if (accessibilityAction3 == null) {
                                                        f7 = null;
                                                    } else {
                                                        f7 = null;
                                                    }
                                                    obj4 = mutableScatterMap.get(SemanticsActions.ScrollBy);
                                                    if (obj4 == null) {
                                                        obj4 = null;
                                                    }
                                                    accessibilityAction4 = (AccessibilityAction) obj4;
                                                    if (accessibilityAction4 != null) {
                                                        Function function22 = accessibilityAction4.action;
                                                        obj5 = mutableScatterMap.get(SemanticsProperties.HorizontalScrollAxisRange);
                                                        if (obj5 == null) {
                                                            obj5 = null;
                                                        }
                                                        scrollAxisRange = (ScrollAxisRange) obj5;
                                                        if (scrollAxisRange == null) {
                                                            f7 = f7;
                                                            z10 = z10;
                                                            obj6 = mutableScatterMap.get(SemanticsProperties.VerticalScrollAxisRange);
                                                            if (obj6 == null) {
                                                                obj6 = null;
                                                            }
                                                            scrollAxisRange2 = (ScrollAxisRange) obj6;
                                                            if (scrollAxisRange2 != null) {
                                                                if (f7 != null) {
                                                                    fIntBitsToFloat = f7.floatValue();
                                                                } else {
                                                                    fIntBitsToFloat = Float.intBitsToFloat((int) (jM444getSizeNHjbRc & 4294967295L));
                                                                }
                                                                if (z7) {
                                                                    fIntBitsToFloat = -fIntBitsToFloat;
                                                                } else {
                                                                    fIntBitsToFloat = -fIntBitsToFloat;
                                                                }
                                                                if (AndroidComposeViewAccessibilityDelegateCompat.performActionHelper$canScroll(scrollAxisRange2, fIntBitsToFloat)) {
                                                                    semanticsPropertyKey = SemanticsActions.PageUp;
                                                                    if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
                                                                        if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                            obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                            if (obj9 == null) {
                                                                                obj10 = null;
                                                                            } else {
                                                                                obj10 = obj9;
                                                                            }
                                                                            accessibilityAction5 = (AccessibilityAction) obj10;
                                                                        } else {
                                                                            obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                            if (obj7 == null) {
                                                                                obj8 = null;
                                                                            } else {
                                                                                obj8 = obj7;
                                                                            }
                                                                            accessibilityAction5 = (AccessibilityAction) obj8;
                                                                        }
                                                                        if (accessibilityAction5 != null) {
                                                                            return ((Boolean) function13.invoke()).booleanValue();
                                                                        }
                                                                    } else {
                                                                        if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                            obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                            if (obj9 == null) {
                                                                                obj10 = null;
                                                                            } else {
                                                                                obj10 = obj9;
                                                                            }
                                                                            accessibilityAction5 = (AccessibilityAction) obj10;
                                                                        } else {
                                                                            obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                            if (obj7 == null) {
                                                                                obj8 = null;
                                                                            } else {
                                                                                obj8 = obj7;
                                                                            }
                                                                            accessibilityAction5 = (AccessibilityAction) obj8;
                                                                        }
                                                                        if (accessibilityAction5 != null) {
                                                                            return ((Boolean) function13.invoke()).booleanValue();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            f7 = f7;
                                                            z10 = z10;
                                                            obj6 = mutableScatterMap.get(SemanticsProperties.VerticalScrollAxisRange);
                                                            if (obj6 == null) {
                                                                obj6 = null;
                                                            }
                                                            scrollAxisRange2 = (ScrollAxisRange) obj6;
                                                            if (scrollAxisRange2 != null) {
                                                                if (f7 != null) {
                                                                    fIntBitsToFloat = f7.floatValue();
                                                                } else {
                                                                    fIntBitsToFloat = Float.intBitsToFloat((int) (jM444getSizeNHjbRc & 4294967295L));
                                                                }
                                                                if (z7) {
                                                                    fIntBitsToFloat = -fIntBitsToFloat;
                                                                } else {
                                                                    fIntBitsToFloat = -fIntBitsToFloat;
                                                                }
                                                                if (AndroidComposeViewAccessibilityDelegateCompat.performActionHelper$canScroll(scrollAxisRange2, fIntBitsToFloat)) {
                                                                    semanticsPropertyKey = SemanticsActions.PageUp;
                                                                    if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
                                                                        if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                            obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                            if (obj9 == null) {
                                                                                obj10 = null;
                                                                            } else {
                                                                                obj10 = obj9;
                                                                            }
                                                                            accessibilityAction5 = (AccessibilityAction) obj10;
                                                                        } else {
                                                                            obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                            if (obj7 == null) {
                                                                                obj8 = null;
                                                                            } else {
                                                                                obj8 = obj7;
                                                                            }
                                                                            accessibilityAction5 = (AccessibilityAction) obj8;
                                                                        }
                                                                        if (accessibilityAction5 != null) {
                                                                            return ((Boolean) function13.invoke()).booleanValue();
                                                                        }
                                                                    } else {
                                                                        if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                            obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                            if (obj9 == null) {
                                                                                obj10 = null;
                                                                            } else {
                                                                                obj10 = obj9;
                                                                            }
                                                                            accessibilityAction5 = (AccessibilityAction) obj10;
                                                                        } else {
                                                                            obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                            if (obj7 == null) {
                                                                                obj8 = null;
                                                                            } else {
                                                                                obj8 = obj7;
                                                                            }
                                                                            accessibilityAction5 = (AccessibilityAction) obj8;
                                                                        }
                                                                        if (accessibilityAction5 != null) {
                                                                            return ((Boolean) function13.invoke()).booleanValue();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                jM444getSizeNHjbRc = RulerKt.boundsInParent((InnerNodeCoordinator) layoutNode.nodes.innerCoordinator).m444getSizeNHjbRc();
                                                ArrayList arrayList3 = new ArrayList();
                                                obj3 = mutableScatterMap.get(SemanticsActions.GetScrollViewportLength);
                                                if (obj3 == null) {
                                                    obj3 = null;
                                                }
                                                accessibilityAction3 = (AccessibilityAction) obj3;
                                                if (accessibilityAction3 == null) {
                                                    f7 = null;
                                                } else {
                                                    f7 = null;
                                                }
                                                obj4 = mutableScatterMap.get(SemanticsActions.ScrollBy);
                                                if (obj4 == null) {
                                                    obj4 = null;
                                                }
                                                accessibilityAction4 = (AccessibilityAction) obj4;
                                                if (accessibilityAction4 != null) {
                                                    Function function23 = accessibilityAction4.action;
                                                    obj5 = mutableScatterMap.get(SemanticsProperties.HorizontalScrollAxisRange);
                                                    if (obj5 == null) {
                                                        obj5 = null;
                                                    }
                                                    scrollAxisRange = (ScrollAxisRange) obj5;
                                                    if (scrollAxisRange == null) {
                                                        f7 = f7;
                                                        z10 = z10;
                                                        obj6 = mutableScatterMap.get(SemanticsProperties.VerticalScrollAxisRange);
                                                        if (obj6 == null) {
                                                            obj6 = null;
                                                        }
                                                        scrollAxisRange2 = (ScrollAxisRange) obj6;
                                                        if (scrollAxisRange2 != null) {
                                                            if (f7 != null) {
                                                                fIntBitsToFloat = f7.floatValue();
                                                            } else {
                                                                fIntBitsToFloat = Float.intBitsToFloat((int) (jM444getSizeNHjbRc & 4294967295L));
                                                            }
                                                            if (z7) {
                                                                fIntBitsToFloat = -fIntBitsToFloat;
                                                            } else {
                                                                fIntBitsToFloat = -fIntBitsToFloat;
                                                            }
                                                            if (AndroidComposeViewAccessibilityDelegateCompat.performActionHelper$canScroll(scrollAxisRange2, fIntBitsToFloat)) {
                                                                semanticsPropertyKey = SemanticsActions.PageUp;
                                                                if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
                                                                    if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                        obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                        if (obj9 == null) {
                                                                            obj10 = null;
                                                                        } else {
                                                                            obj10 = obj9;
                                                                        }
                                                                        accessibilityAction5 = (AccessibilityAction) obj10;
                                                                    } else {
                                                                        obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                        if (obj7 == null) {
                                                                            obj8 = null;
                                                                        } else {
                                                                            obj8 = obj7;
                                                                        }
                                                                        accessibilityAction5 = (AccessibilityAction) obj8;
                                                                    }
                                                                    if (accessibilityAction5 != null) {
                                                                        return ((Boolean) function13.invoke()).booleanValue();
                                                                    }
                                                                } else {
                                                                    if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                        obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                        if (obj9 == null) {
                                                                            obj10 = null;
                                                                        } else {
                                                                            obj10 = obj9;
                                                                        }
                                                                        accessibilityAction5 = (AccessibilityAction) obj10;
                                                                    } else {
                                                                        obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                        if (obj7 == null) {
                                                                            obj8 = null;
                                                                        } else {
                                                                            obj8 = obj7;
                                                                        }
                                                                        accessibilityAction5 = (AccessibilityAction) obj8;
                                                                    }
                                                                    if (accessibilityAction5 != null) {
                                                                        return ((Boolean) function13.invoke()).booleanValue();
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        f7 = f7;
                                                        z10 = z10;
                                                        obj6 = mutableScatterMap.get(SemanticsProperties.VerticalScrollAxisRange);
                                                        if (obj6 == null) {
                                                            obj6 = null;
                                                        }
                                                        scrollAxisRange2 = (ScrollAxisRange) obj6;
                                                        if (scrollAxisRange2 != null) {
                                                            if (f7 != null) {
                                                                fIntBitsToFloat = f7.floatValue();
                                                            } else {
                                                                fIntBitsToFloat = Float.intBitsToFloat((int) (jM444getSizeNHjbRc & 4294967295L));
                                                            }
                                                            if (z7) {
                                                                fIntBitsToFloat = -fIntBitsToFloat;
                                                            } else {
                                                                fIntBitsToFloat = -fIntBitsToFloat;
                                                            }
                                                            if (AndroidComposeViewAccessibilityDelegateCompat.performActionHelper$canScroll(scrollAxisRange2, fIntBitsToFloat)) {
                                                                semanticsPropertyKey = SemanticsActions.PageUp;
                                                                if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
                                                                    if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                        obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                        if (obj9 == null) {
                                                                            obj10 = null;
                                                                        } else {
                                                                            obj10 = obj9;
                                                                        }
                                                                        accessibilityAction5 = (AccessibilityAction) obj10;
                                                                    } else {
                                                                        obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                        if (obj7 == null) {
                                                                            obj8 = null;
                                                                        } else {
                                                                            obj8 = obj7;
                                                                        }
                                                                        accessibilityAction5 = (AccessibilityAction) obj8;
                                                                    }
                                                                    if (accessibilityAction5 != null) {
                                                                        return ((Boolean) function13.invoke()).booleanValue();
                                                                    }
                                                                } else {
                                                                    if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                        obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                        if (obj9 == null) {
                                                                            obj10 = null;
                                                                        } else {
                                                                            obj10 = obj9;
                                                                        }
                                                                        accessibilityAction5 = (AccessibilityAction) obj10;
                                                                    } else {
                                                                        obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                        if (obj7 == null) {
                                                                            obj8 = null;
                                                                        } else {
                                                                            obj8 = obj7;
                                                                        }
                                                                        accessibilityAction5 = (AccessibilityAction) obj8;
                                                                    }
                                                                    if (accessibilityAction5 != null) {
                                                                        return ((Boolean) function13.invoke()).booleanValue();
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            break;
                                        case 32768:
                                            Object obj18 = mutableScatterMap.get(SemanticsActions.PasteText);
                                            AccessibilityAction accessibilityAction11 = (AccessibilityAction) (obj18 == null ? null : obj18);
                                            if (accessibilityAction11 != null && (function4 = (Function0) accessibilityAction11.action) != null) {
                                                return ((Boolean) function4.invoke()).booleanValue();
                                            }
                                            break;
                                        case 65536:
                                            Object obj19 = mutableScatterMap.get(SemanticsActions.CutText);
                                            AccessibilityAction accessibilityAction12 = (AccessibilityAction) (obj19 == null ? null : obj19);
                                            if (accessibilityAction12 != null && (function5 = (Function0) accessibilityAction12.action) != null) {
                                                return ((Boolean) function5.invoke()).booleanValue();
                                            }
                                            break;
                                        case 262144:
                                            Object obj20 = mutableScatterMap.get(SemanticsActions.Expand);
                                            AccessibilityAction accessibilityAction13 = (AccessibilityAction) (obj20 == null ? null : obj20);
                                            if (accessibilityAction13 != null && (function6 = (Function0) accessibilityAction13.action) != null) {
                                                return ((Boolean) function6.invoke()).booleanValue();
                                            }
                                            break;
                                        case 524288:
                                            Object obj21 = mutableScatterMap.get(SemanticsActions.Collapse);
                                            AccessibilityAction accessibilityAction14 = (AccessibilityAction) (obj21 == null ? null : obj21);
                                            if (accessibilityAction14 != null && (function7 = (Function0) accessibilityAction14.action) != null) {
                                                return ((Boolean) function7.invoke()).booleanValue();
                                            }
                                            break;
                                        case ByteChannelKt.CHANNEL_MAX_SIZE /* 1048576 */:
                                            Object obj22 = mutableScatterMap.get(SemanticsActions.Dismiss);
                                            AccessibilityAction accessibilityAction15 = (AccessibilityAction) (obj22 == null ? null : obj22);
                                            if (accessibilityAction15 != null && (function8 = (Function0) accessibilityAction15.action) != null) {
                                                return ((Boolean) function8.invoke()).booleanValue();
                                            }
                                            break;
                                        case 2097152:
                                            String string = bundle != null ? bundle.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE") : null;
                                            Object obj23 = mutableScatterMap.get(SemanticsActions.SetText);
                                            AccessibilityAction accessibilityAction16 = (AccessibilityAction) (obj23 == null ? null : obj23);
                                            if (accessibilityAction16 != null && (function9 = (Function1) accessibilityAction16.action) != null) {
                                                if (string == null) {
                                                    string = "";
                                                }
                                                return ((Boolean) function9.invoke(new AnnotatedString(string))).booleanValue();
                                            }
                                            break;
                                        case android.R.id.accessibilityActionShowOnScreen:
                                            SemanticsNode parent = semanticsNode.getParent();
                                            if (parent != null) {
                                                Object obj24 = parent.unmergedConfig.props.get(SemanticsActions.ScrollBy);
                                                if (obj24 == null) {
                                                    obj24 = null;
                                                }
                                                accessibilityAction = (AccessibilityAction) obj24;
                                                while (accessibilityAction == null && parent != null) {
                                                    parent = parent.getParent();
                                                    if (parent != null) {
                                                        Object obj25 = parent.unmergedConfig.props.get(SemanticsActions.ScrollBy);
                                                        if (obj25 == null) {
                                                            obj25 = null;
                                                        }
                                                        accessibilityAction = (AccessibilityAction) obj25;
                                                    } else {
                                                        accessibilityAction = null;
                                                    }
                                                }
                                                if (parent == null) {
                                                    androidx.compose.ui.geometry.Rect boundsInRoot = semanticsNode.getBoundsInRoot();
                                                    return androidComposeView.requestRectangleOnScreen(new Rect((int) Math.floor(boundsInRoot.left), (int) Math.floor(boundsInRoot.top), MathKt.roundToInt((float) Math.ceil(boundsInRoot.right)), MathKt.roundToInt((float) Math.ceil(boundsInRoot.bottom))));
                                                }
                                                long j = 0;
                                                long jM438minusMKHz9U = 0;
                                                boolean z11 = false;
                                                while (parent != null) {
                                                    LayoutNode layoutNode2 = parent.layoutNode;
                                                    MutableScatterMap mutableScatterMap2 = parent.unmergedConfig.props;
                                                    Object obj26 = mutableScatterMap2.get(SemanticsActions.ScrollBy);
                                                    if (obj26 == null) {
                                                        obj26 = null;
                                                    }
                                                    AccessibilityAction accessibilityAction17 = (AccessibilityAction) obj26;
                                                    if (accessibilityAction17 != null) {
                                                        androidx.compose.ui.geometry.Rect rectBoundsInParent = RulerKt.boundsInParent((InnerNodeCoordinator) layoutNode2.nodes.innerCoordinator);
                                                        LayoutCoordinates parentLayoutCoordinates = ((InnerNodeCoordinator) layoutNode2.nodes.innerCoordinator).getParentLayoutCoordinates();
                                                        androidx.compose.ui.geometry.Rect rectM446translatek4lQ0M = rectBoundsInParent.m446translatek4lQ0M(parentLayoutCoordinates != null ? ((NodeCoordinator) parentLayoutCoordinates).mo606localToRootMKHz9U(j) : j);
                                                        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = semanticsNode.findCoordinatorToGetBounds$ui();
                                                        if (nodeCoordinatorFindCoordinatorToGetBounds$ui == null) {
                                                            jMo606localToRootMKHz9U = j;
                                                        } else {
                                                            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui.getTail().isAttached) {
                                                                nodeCoordinatorFindCoordinatorToGetBounds$ui = null;
                                                            }
                                                            if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
                                                                jMo606localToRootMKHz9U = nodeCoordinatorFindCoordinatorToGetBounds$ui.mo606localToRootMKHz9U(j);
                                                            } else {
                                                                jMo606localToRootMKHz9U = j;
                                                            }
                                                        }
                                                        long jM439plusMKHz9U = Offset.m439plusMKHz9U(jMo606localToRootMKHz9U, jM438minusMKHz9U);
                                                        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui2 = semanticsNode.findCoordinatorToGetBounds$ui();
                                                        boolean z12 = z11;
                                                        androidx.compose.ui.geometry.Rect rectM896Recttz77jQw = IntMath.m896Recttz77jQw(jM439plusMKHz9U, SizeKt.m876toSizeozmzZPI(nodeCoordinatorFindCoordinatorToGetBounds$ui2 != null ? nodeCoordinatorFindCoordinatorToGetBounds$ui2.measuredSize : j));
                                                        float f8 = rectM896Recttz77jQw.left - rectM446translatek4lQ0M.left;
                                                        float f9 = rectM896Recttz77jQw.right - rectM446translatek4lQ0M.right;
                                                        if (Math.signum(f8) != Math.signum(f9)) {
                                                            f8 = 0.0f;
                                                        } else if (Math.abs(f8) >= Math.abs(f9)) {
                                                            f8 = f9;
                                                        }
                                                        float f10 = rectM896Recttz77jQw.top - rectM446translatek4lQ0M.top;
                                                        float f11 = rectM896Recttz77jQw.bottom - rectM446translatek4lQ0M.bottom;
                                                        if (Math.signum(f10) != Math.signum(f11)) {
                                                            f10 = 0.0f;
                                                        } else if (Math.abs(f10) >= Math.abs(f11)) {
                                                            f10 = f11;
                                                        }
                                                        long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(f8)) << 32) | (((long) Float.floatToRawIntBits(f10)) & 4294967295L);
                                                        if (Offset.m434equalsimpl0(jFloatToRawIntBits2, j)) {
                                                            jFloatToRawIntBits = jFloatToRawIntBits2;
                                                        } else {
                                                            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jFloatToRawIntBits2 >> 32));
                                                            float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jFloatToRawIntBits2 & 4294967295L));
                                                            Object obj27 = mutableScatterMap2.get(SemanticsProperties.HorizontalScrollAxisRange);
                                                            if (obj27 == null) {
                                                                obj27 = null;
                                                            }
                                                            if (layoutNode.layoutDirection == layoutDirection) {
                                                                fIntBitsToFloat2 = -fIntBitsToFloat2;
                                                            }
                                                            Object obj28 = mutableScatterMap2.get(SemanticsProperties.VerticalScrollAxisRange);
                                                            if (obj28 == null) {
                                                                obj28 = null;
                                                            }
                                                            jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat3)) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32);
                                                        }
                                                        Function2 function24 = (Function2) accessibilityAction17.action;
                                                        boolean z13 = (function24 != null && ((Boolean) function24.invoke(Float.valueOf(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32))), Float.valueOf(Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L))))).booleanValue()) || z12;
                                                        jM438minusMKHz9U = Offset.m438minusMKHz9U(jM438minusMKHz9U, jFloatToRawIntBits2);
                                                        z11 = z13;
                                                    }
                                                    parent = parent.getParent();
                                                    j = 0;
                                                }
                                                return z11;
                                            }
                                            accessibilityAction = null;
                                            break;
                                        case android.R.id.accessibilityActionSetProgress:
                                            if (bundle != null && bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                                                Object obj29 = mutableScatterMap.get(SemanticsActions.SetProgress);
                                                AccessibilityAction accessibilityAction18 = (AccessibilityAction) (obj29 == null ? null : obj29);
                                                if (accessibilityAction18 != null && (function10 = (Function1) accessibilityAction18.action) != null) {
                                                    return ((Boolean) function10.invoke(Float.valueOf(bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")))).booleanValue();
                                                }
                                            }
                                            break;
                                        case android.R.id.accessibilityActionImeEnter:
                                            Object obj30 = mutableScatterMap.get(SemanticsActions.OnImeAction);
                                            AccessibilityAction accessibilityAction19 = (AccessibilityAction) (obj30 == null ? null : obj30);
                                            if (accessibilityAction19 != null && (function11 = (Function0) accessibilityAction19.action) != null) {
                                                return ((Boolean) function11.invoke()).booleanValue();
                                            }
                                            break;
                                        default:
                                            switch (i2) {
                                                case android.R.id.accessibilityActionScrollUp:
                                                case android.R.id.accessibilityActionScrollLeft:
                                                case android.R.id.accessibilityActionScrollDown:
                                                case android.R.id.accessibilityActionScrollRight:
                                                    if (i2 == 4096) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    if (i2 == 8192) {
                                                        z4 = true;
                                                    } else {
                                                        z4 = false;
                                                    }
                                                    if (i2 == 16908345) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    if (i2 == 16908347) {
                                                        z6 = true;
                                                    } else {
                                                        z6 = false;
                                                    }
                                                    if (i2 == 16908344) {
                                                        z7 = true;
                                                    } else {
                                                        z7 = false;
                                                    }
                                                    if (i2 == 16908346) {
                                                        z8 = true;
                                                    } else {
                                                        z8 = false;
                                                    }
                                                    if (z5) {
                                                        z9 = true;
                                                    } else {
                                                        z9 = true;
                                                    }
                                                    if (z7) {
                                                        z10 = true;
                                                    } else {
                                                        z10 = true;
                                                    }
                                                    if (z3) {
                                                        obj = mutableScatterMap.get(SemanticsProperties.ProgressBarRangeInfo);
                                                        if (obj == null) {
                                                            obj = null;
                                                        }
                                                        progressBarRangeInfo = (ProgressBarRangeInfo) obj;
                                                        obj2 = mutableScatterMap.get(SemanticsActions.SetProgress);
                                                        if (obj2 == null) {
                                                            obj2 = null;
                                                        }
                                                        accessibilityAction2 = (AccessibilityAction) obj2;
                                                        if (progressBarRangeInfo != null) {
                                                            closedFloatRange = progressBarRangeInfo.range;
                                                            if (accessibilityAction2 != null) {
                                                                f = closedFloatRange._endInclusive;
                                                                f2 = closedFloatRange._start;
                                                                if (f < f2) {
                                                                    f3 = f2;
                                                                } else {
                                                                    f3 = f;
                                                                }
                                                                if (f2 <= f) {
                                                                    f = f2;
                                                                }
                                                                i10 = progressBarRangeInfo.steps;
                                                                if (i10 > 0) {
                                                                    f4 = f3 - f;
                                                                    f5 = i10 + 1;
                                                                } else {
                                                                    f4 = f3 - f;
                                                                    f5 = 20.0f;
                                                                }
                                                                f6 = f4 / f5;
                                                                if (z4) {
                                                                    f6 = -f6;
                                                                }
                                                                function12 = (Function1) accessibilityAction2.action;
                                                                if (function12 != null) {
                                                                    return ((Boolean) function12.invoke(Float.valueOf(progressBarRangeInfo.current + f6))).booleanValue();
                                                                }
                                                            } else {
                                                                jM444getSizeNHjbRc = RulerKt.boundsInParent((InnerNodeCoordinator) layoutNode.nodes.innerCoordinator).m444getSizeNHjbRc();
                                                                ArrayList arrayList4 = new ArrayList();
                                                                obj3 = mutableScatterMap.get(SemanticsActions.GetScrollViewportLength);
                                                                if (obj3 == null) {
                                                                    obj3 = null;
                                                                }
                                                                accessibilityAction3 = (AccessibilityAction) obj3;
                                                                if (accessibilityAction3 == null) {
                                                                    f7 = null;
                                                                } else {
                                                                    f7 = null;
                                                                }
                                                                obj4 = mutableScatterMap.get(SemanticsActions.ScrollBy);
                                                                if (obj4 == null) {
                                                                    obj4 = null;
                                                                }
                                                                accessibilityAction4 = (AccessibilityAction) obj4;
                                                                if (accessibilityAction4 != null) {
                                                                    Function function25 = accessibilityAction4.action;
                                                                    obj5 = mutableScatterMap.get(SemanticsProperties.HorizontalScrollAxisRange);
                                                                    if (obj5 == null) {
                                                                        obj5 = null;
                                                                    }
                                                                    scrollAxisRange = (ScrollAxisRange) obj5;
                                                                    if (scrollAxisRange == null) {
                                                                        f7 = f7;
                                                                        z10 = z10;
                                                                        obj6 = mutableScatterMap.get(SemanticsProperties.VerticalScrollAxisRange);
                                                                        if (obj6 == null) {
                                                                            obj6 = null;
                                                                        }
                                                                        scrollAxisRange2 = (ScrollAxisRange) obj6;
                                                                        if (scrollAxisRange2 != null) {
                                                                            if (f7 != null) {
                                                                                fIntBitsToFloat = f7.floatValue();
                                                                            } else {
                                                                                fIntBitsToFloat = Float.intBitsToFloat((int) (jM444getSizeNHjbRc & 4294967295L));
                                                                            }
                                                                            if (z7) {
                                                                                fIntBitsToFloat = -fIntBitsToFloat;
                                                                            } else {
                                                                                fIntBitsToFloat = -fIntBitsToFloat;
                                                                            }
                                                                            if (AndroidComposeViewAccessibilityDelegateCompat.performActionHelper$canScroll(scrollAxisRange2, fIntBitsToFloat)) {
                                                                                semanticsPropertyKey = SemanticsActions.PageUp;
                                                                                if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
                                                                                    if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                                        obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                                        if (obj9 == null) {
                                                                                            obj10 = null;
                                                                                        } else {
                                                                                            obj10 = obj9;
                                                                                        }
                                                                                        accessibilityAction5 = (AccessibilityAction) obj10;
                                                                                    } else {
                                                                                        obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                                        if (obj7 == null) {
                                                                                            obj8 = null;
                                                                                        } else {
                                                                                            obj8 = obj7;
                                                                                        }
                                                                                        accessibilityAction5 = (AccessibilityAction) obj8;
                                                                                    }
                                                                                    if (accessibilityAction5 != null) {
                                                                                        return ((Boolean) function13.invoke()).booleanValue();
                                                                                    }
                                                                                } else {
                                                                                    if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                                        obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                                        if (obj9 == null) {
                                                                                            obj10 = null;
                                                                                        } else {
                                                                                            obj10 = obj9;
                                                                                        }
                                                                                        accessibilityAction5 = (AccessibilityAction) obj10;
                                                                                    } else {
                                                                                        obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                                        if (obj7 == null) {
                                                                                            obj8 = null;
                                                                                        } else {
                                                                                            obj8 = obj7;
                                                                                        }
                                                                                        accessibilityAction5 = (AccessibilityAction) obj8;
                                                                                    }
                                                                                    if (accessibilityAction5 != null) {
                                                                                        return ((Boolean) function13.invoke()).booleanValue();
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        f7 = f7;
                                                                        z10 = z10;
                                                                        obj6 = mutableScatterMap.get(SemanticsProperties.VerticalScrollAxisRange);
                                                                        if (obj6 == null) {
                                                                            obj6 = null;
                                                                        }
                                                                        scrollAxisRange2 = (ScrollAxisRange) obj6;
                                                                        if (scrollAxisRange2 != null) {
                                                                            if (f7 != null) {
                                                                                fIntBitsToFloat = f7.floatValue();
                                                                            } else {
                                                                                fIntBitsToFloat = Float.intBitsToFloat((int) (jM444getSizeNHjbRc & 4294967295L));
                                                                            }
                                                                            if (z7) {
                                                                                fIntBitsToFloat = -fIntBitsToFloat;
                                                                            } else {
                                                                                fIntBitsToFloat = -fIntBitsToFloat;
                                                                            }
                                                                            if (AndroidComposeViewAccessibilityDelegateCompat.performActionHelper$canScroll(scrollAxisRange2, fIntBitsToFloat)) {
                                                                                semanticsPropertyKey = SemanticsActions.PageUp;
                                                                                if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
                                                                                    if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                                        obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                                        if (obj9 == null) {
                                                                                            obj10 = null;
                                                                                        } else {
                                                                                            obj10 = obj9;
                                                                                        }
                                                                                        accessibilityAction5 = (AccessibilityAction) obj10;
                                                                                    } else {
                                                                                        obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                                        if (obj7 == null) {
                                                                                            obj8 = null;
                                                                                        } else {
                                                                                            obj8 = obj7;
                                                                                        }
                                                                                        accessibilityAction5 = (AccessibilityAction) obj8;
                                                                                    }
                                                                                    if (accessibilityAction5 != null) {
                                                                                        return ((Boolean) function13.invoke()).booleanValue();
                                                                                    }
                                                                                } else {
                                                                                    if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                                        obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                                        if (obj9 == null) {
                                                                                            obj10 = null;
                                                                                        } else {
                                                                                            obj10 = obj9;
                                                                                        }
                                                                                        accessibilityAction5 = (AccessibilityAction) obj10;
                                                                                    } else {
                                                                                        obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                                        if (obj7 == null) {
                                                                                            obj8 = null;
                                                                                        } else {
                                                                                            obj8 = obj7;
                                                                                        }
                                                                                        accessibilityAction5 = (AccessibilityAction) obj8;
                                                                                    }
                                                                                    if (accessibilityAction5 != null) {
                                                                                        return ((Boolean) function13.invoke()).booleanValue();
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            jM444getSizeNHjbRc = RulerKt.boundsInParent((InnerNodeCoordinator) layoutNode.nodes.innerCoordinator).m444getSizeNHjbRc();
                                                            ArrayList arrayList5 = new ArrayList();
                                                            obj3 = mutableScatterMap.get(SemanticsActions.GetScrollViewportLength);
                                                            if (obj3 == null) {
                                                                obj3 = null;
                                                            }
                                                            accessibilityAction3 = (AccessibilityAction) obj3;
                                                            if (accessibilityAction3 == null) {
                                                                f7 = null;
                                                            } else {
                                                                f7 = null;
                                                            }
                                                            obj4 = mutableScatterMap.get(SemanticsActions.ScrollBy);
                                                            if (obj4 == null) {
                                                                obj4 = null;
                                                            }
                                                            accessibilityAction4 = (AccessibilityAction) obj4;
                                                            if (accessibilityAction4 != null) {
                                                                Function function26 = accessibilityAction4.action;
                                                                obj5 = mutableScatterMap.get(SemanticsProperties.HorizontalScrollAxisRange);
                                                                if (obj5 == null) {
                                                                    obj5 = null;
                                                                }
                                                                scrollAxisRange = (ScrollAxisRange) obj5;
                                                                if (scrollAxisRange == null) {
                                                                    f7 = f7;
                                                                    z10 = z10;
                                                                    obj6 = mutableScatterMap.get(SemanticsProperties.VerticalScrollAxisRange);
                                                                    if (obj6 == null) {
                                                                        obj6 = null;
                                                                    }
                                                                    scrollAxisRange2 = (ScrollAxisRange) obj6;
                                                                    if (scrollAxisRange2 != null) {
                                                                        if (f7 != null) {
                                                                            fIntBitsToFloat = f7.floatValue();
                                                                        } else {
                                                                            fIntBitsToFloat = Float.intBitsToFloat((int) (jM444getSizeNHjbRc & 4294967295L));
                                                                        }
                                                                        if (z7) {
                                                                            fIntBitsToFloat = -fIntBitsToFloat;
                                                                        } else {
                                                                            fIntBitsToFloat = -fIntBitsToFloat;
                                                                        }
                                                                        if (AndroidComposeViewAccessibilityDelegateCompat.performActionHelper$canScroll(scrollAxisRange2, fIntBitsToFloat)) {
                                                                            semanticsPropertyKey = SemanticsActions.PageUp;
                                                                            if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
                                                                                if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                                    obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                                    if (obj9 == null) {
                                                                                        obj10 = null;
                                                                                    } else {
                                                                                        obj10 = obj9;
                                                                                    }
                                                                                    accessibilityAction5 = (AccessibilityAction) obj10;
                                                                                } else {
                                                                                    obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                                    if (obj7 == null) {
                                                                                        obj8 = null;
                                                                                    } else {
                                                                                        obj8 = obj7;
                                                                                    }
                                                                                    accessibilityAction5 = (AccessibilityAction) obj8;
                                                                                }
                                                                                if (accessibilityAction5 != null) {
                                                                                    return ((Boolean) function13.invoke()).booleanValue();
                                                                                }
                                                                            } else {
                                                                                if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                                    obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                                    if (obj9 == null) {
                                                                                        obj10 = null;
                                                                                    } else {
                                                                                        obj10 = obj9;
                                                                                    }
                                                                                    accessibilityAction5 = (AccessibilityAction) obj10;
                                                                                } else {
                                                                                    obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                                    if (obj7 == null) {
                                                                                        obj8 = null;
                                                                                    } else {
                                                                                        obj8 = obj7;
                                                                                    }
                                                                                    accessibilityAction5 = (AccessibilityAction) obj8;
                                                                                }
                                                                                if (accessibilityAction5 != null) {
                                                                                    return ((Boolean) function13.invoke()).booleanValue();
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    f7 = f7;
                                                                    z10 = z10;
                                                                    obj6 = mutableScatterMap.get(SemanticsProperties.VerticalScrollAxisRange);
                                                                    if (obj6 == null) {
                                                                        obj6 = null;
                                                                    }
                                                                    scrollAxisRange2 = (ScrollAxisRange) obj6;
                                                                    if (scrollAxisRange2 != null) {
                                                                        if (f7 != null) {
                                                                            fIntBitsToFloat = f7.floatValue();
                                                                        } else {
                                                                            fIntBitsToFloat = Float.intBitsToFloat((int) (jM444getSizeNHjbRc & 4294967295L));
                                                                        }
                                                                        if (z7) {
                                                                            fIntBitsToFloat = -fIntBitsToFloat;
                                                                        } else {
                                                                            fIntBitsToFloat = -fIntBitsToFloat;
                                                                        }
                                                                        if (AndroidComposeViewAccessibilityDelegateCompat.performActionHelper$canScroll(scrollAxisRange2, fIntBitsToFloat)) {
                                                                            semanticsPropertyKey = SemanticsActions.PageUp;
                                                                            if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
                                                                                if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                                    obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                                    if (obj9 == null) {
                                                                                        obj10 = null;
                                                                                    } else {
                                                                                        obj10 = obj9;
                                                                                    }
                                                                                    accessibilityAction5 = (AccessibilityAction) obj10;
                                                                                } else {
                                                                                    obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                                    if (obj7 == null) {
                                                                                        obj8 = null;
                                                                                    } else {
                                                                                        obj8 = obj7;
                                                                                    }
                                                                                    accessibilityAction5 = (AccessibilityAction) obj8;
                                                                                }
                                                                                if (accessibilityAction5 != null) {
                                                                                    return ((Boolean) function13.invoke()).booleanValue();
                                                                                }
                                                                            } else {
                                                                                if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                                    obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                                    if (obj9 == null) {
                                                                                        obj10 = null;
                                                                                    } else {
                                                                                        obj10 = obj9;
                                                                                    }
                                                                                    accessibilityAction5 = (AccessibilityAction) obj10;
                                                                                } else {
                                                                                    obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                                    if (obj7 == null) {
                                                                                        obj8 = null;
                                                                                    } else {
                                                                                        obj8 = obj7;
                                                                                    }
                                                                                    accessibilityAction5 = (AccessibilityAction) obj8;
                                                                                }
                                                                                if (accessibilityAction5 != null) {
                                                                                    return ((Boolean) function13.invoke()).booleanValue();
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        obj = mutableScatterMap.get(SemanticsProperties.ProgressBarRangeInfo);
                                                        if (obj == null) {
                                                            obj = null;
                                                        }
                                                        progressBarRangeInfo = (ProgressBarRangeInfo) obj;
                                                        obj2 = mutableScatterMap.get(SemanticsActions.SetProgress);
                                                        if (obj2 == null) {
                                                            obj2 = null;
                                                        }
                                                        accessibilityAction2 = (AccessibilityAction) obj2;
                                                        if (progressBarRangeInfo != null) {
                                                            closedFloatRange = progressBarRangeInfo.range;
                                                            if (accessibilityAction2 != null) {
                                                                f = closedFloatRange._endInclusive;
                                                                f2 = closedFloatRange._start;
                                                                if (f < f2) {
                                                                    f3 = f2;
                                                                } else {
                                                                    f3 = f;
                                                                }
                                                                if (f2 <= f) {
                                                                    f = f2;
                                                                }
                                                                i10 = progressBarRangeInfo.steps;
                                                                if (i10 > 0) {
                                                                    f4 = f3 - f;
                                                                    f5 = i10 + 1;
                                                                } else {
                                                                    f4 = f3 - f;
                                                                    f5 = 20.0f;
                                                                }
                                                                f6 = f4 / f5;
                                                                if (z4) {
                                                                    f6 = -f6;
                                                                }
                                                                function12 = (Function1) accessibilityAction2.action;
                                                                if (function12 != null) {
                                                                    return ((Boolean) function12.invoke(Float.valueOf(progressBarRangeInfo.current + f6))).booleanValue();
                                                                }
                                                            } else {
                                                                jM444getSizeNHjbRc = RulerKt.boundsInParent((InnerNodeCoordinator) layoutNode.nodes.innerCoordinator).m444getSizeNHjbRc();
                                                                ArrayList arrayList6 = new ArrayList();
                                                                obj3 = mutableScatterMap.get(SemanticsActions.GetScrollViewportLength);
                                                                if (obj3 == null) {
                                                                    obj3 = null;
                                                                }
                                                                accessibilityAction3 = (AccessibilityAction) obj3;
                                                                if (accessibilityAction3 == null) {
                                                                    f7 = null;
                                                                } else {
                                                                    f7 = null;
                                                                }
                                                                obj4 = mutableScatterMap.get(SemanticsActions.ScrollBy);
                                                                if (obj4 == null) {
                                                                    obj4 = null;
                                                                }
                                                                accessibilityAction4 = (AccessibilityAction) obj4;
                                                                if (accessibilityAction4 != null) {
                                                                    Function function27 = accessibilityAction4.action;
                                                                    obj5 = mutableScatterMap.get(SemanticsProperties.HorizontalScrollAxisRange);
                                                                    if (obj5 == null) {
                                                                        obj5 = null;
                                                                    }
                                                                    scrollAxisRange = (ScrollAxisRange) obj5;
                                                                    if (scrollAxisRange == null) {
                                                                        f7 = f7;
                                                                        z10 = z10;
                                                                        obj6 = mutableScatterMap.get(SemanticsProperties.VerticalScrollAxisRange);
                                                                        if (obj6 == null) {
                                                                            obj6 = null;
                                                                        }
                                                                        scrollAxisRange2 = (ScrollAxisRange) obj6;
                                                                        if (scrollAxisRange2 != null) {
                                                                            if (f7 != null) {
                                                                                fIntBitsToFloat = f7.floatValue();
                                                                            } else {
                                                                                fIntBitsToFloat = Float.intBitsToFloat((int) (jM444getSizeNHjbRc & 4294967295L));
                                                                            }
                                                                            if (z7) {
                                                                                fIntBitsToFloat = -fIntBitsToFloat;
                                                                            } else {
                                                                                fIntBitsToFloat = -fIntBitsToFloat;
                                                                            }
                                                                            if (AndroidComposeViewAccessibilityDelegateCompat.performActionHelper$canScroll(scrollAxisRange2, fIntBitsToFloat)) {
                                                                                semanticsPropertyKey = SemanticsActions.PageUp;
                                                                                if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
                                                                                    if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                                        obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                                        if (obj9 == null) {
                                                                                            obj10 = null;
                                                                                        } else {
                                                                                            obj10 = obj9;
                                                                                        }
                                                                                        accessibilityAction5 = (AccessibilityAction) obj10;
                                                                                    } else {
                                                                                        obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                                        if (obj7 == null) {
                                                                                            obj8 = null;
                                                                                        } else {
                                                                                            obj8 = obj7;
                                                                                        }
                                                                                        accessibilityAction5 = (AccessibilityAction) obj8;
                                                                                    }
                                                                                    if (accessibilityAction5 != null) {
                                                                                        return ((Boolean) function13.invoke()).booleanValue();
                                                                                    }
                                                                                } else {
                                                                                    if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                                        obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                                        if (obj9 == null) {
                                                                                            obj10 = null;
                                                                                        } else {
                                                                                            obj10 = obj9;
                                                                                        }
                                                                                        accessibilityAction5 = (AccessibilityAction) obj10;
                                                                                    } else {
                                                                                        obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                                        if (obj7 == null) {
                                                                                            obj8 = null;
                                                                                        } else {
                                                                                            obj8 = obj7;
                                                                                        }
                                                                                        accessibilityAction5 = (AccessibilityAction) obj8;
                                                                                    }
                                                                                    if (accessibilityAction5 != null) {
                                                                                        return ((Boolean) function13.invoke()).booleanValue();
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        f7 = f7;
                                                                        z10 = z10;
                                                                        obj6 = mutableScatterMap.get(SemanticsProperties.VerticalScrollAxisRange);
                                                                        if (obj6 == null) {
                                                                            obj6 = null;
                                                                        }
                                                                        scrollAxisRange2 = (ScrollAxisRange) obj6;
                                                                        if (scrollAxisRange2 != null) {
                                                                            if (f7 != null) {
                                                                                fIntBitsToFloat = f7.floatValue();
                                                                            } else {
                                                                                fIntBitsToFloat = Float.intBitsToFloat((int) (jM444getSizeNHjbRc & 4294967295L));
                                                                            }
                                                                            if (z7) {
                                                                                fIntBitsToFloat = -fIntBitsToFloat;
                                                                            } else {
                                                                                fIntBitsToFloat = -fIntBitsToFloat;
                                                                            }
                                                                            if (AndroidComposeViewAccessibilityDelegateCompat.performActionHelper$canScroll(scrollAxisRange2, fIntBitsToFloat)) {
                                                                                semanticsPropertyKey = SemanticsActions.PageUp;
                                                                                if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
                                                                                    if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                                        obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                                        if (obj9 == null) {
                                                                                            obj10 = null;
                                                                                        } else {
                                                                                            obj10 = obj9;
                                                                                        }
                                                                                        accessibilityAction5 = (AccessibilityAction) obj10;
                                                                                    } else {
                                                                                        obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                                        if (obj7 == null) {
                                                                                            obj8 = null;
                                                                                        } else {
                                                                                            obj8 = obj7;
                                                                                        }
                                                                                        accessibilityAction5 = (AccessibilityAction) obj8;
                                                                                    }
                                                                                    if (accessibilityAction5 != null) {
                                                                                        return ((Boolean) function13.invoke()).booleanValue();
                                                                                    }
                                                                                } else {
                                                                                    if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                                        obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                                        if (obj9 == null) {
                                                                                            obj10 = null;
                                                                                        } else {
                                                                                            obj10 = obj9;
                                                                                        }
                                                                                        accessibilityAction5 = (AccessibilityAction) obj10;
                                                                                    } else {
                                                                                        obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                                        if (obj7 == null) {
                                                                                            obj8 = null;
                                                                                        } else {
                                                                                            obj8 = obj7;
                                                                                        }
                                                                                        accessibilityAction5 = (AccessibilityAction) obj8;
                                                                                    }
                                                                                    if (accessibilityAction5 != null) {
                                                                                        return ((Boolean) function13.invoke()).booleanValue();
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            jM444getSizeNHjbRc = RulerKt.boundsInParent((InnerNodeCoordinator) layoutNode.nodes.innerCoordinator).m444getSizeNHjbRc();
                                                            ArrayList arrayList7 = new ArrayList();
                                                            obj3 = mutableScatterMap.get(SemanticsActions.GetScrollViewportLength);
                                                            if (obj3 == null) {
                                                                obj3 = null;
                                                            }
                                                            accessibilityAction3 = (AccessibilityAction) obj3;
                                                            if (accessibilityAction3 == null) {
                                                                f7 = null;
                                                            } else {
                                                                f7 = null;
                                                            }
                                                            obj4 = mutableScatterMap.get(SemanticsActions.ScrollBy);
                                                            if (obj4 == null) {
                                                                obj4 = null;
                                                            }
                                                            accessibilityAction4 = (AccessibilityAction) obj4;
                                                            if (accessibilityAction4 != null) {
                                                                Function function28 = accessibilityAction4.action;
                                                                obj5 = mutableScatterMap.get(SemanticsProperties.HorizontalScrollAxisRange);
                                                                if (obj5 == null) {
                                                                    obj5 = null;
                                                                }
                                                                scrollAxisRange = (ScrollAxisRange) obj5;
                                                                if (scrollAxisRange == null) {
                                                                    f7 = f7;
                                                                    z10 = z10;
                                                                    obj6 = mutableScatterMap.get(SemanticsProperties.VerticalScrollAxisRange);
                                                                    if (obj6 == null) {
                                                                        obj6 = null;
                                                                    }
                                                                    scrollAxisRange2 = (ScrollAxisRange) obj6;
                                                                    if (scrollAxisRange2 != null) {
                                                                        if (f7 != null) {
                                                                            fIntBitsToFloat = f7.floatValue();
                                                                        } else {
                                                                            fIntBitsToFloat = Float.intBitsToFloat((int) (jM444getSizeNHjbRc & 4294967295L));
                                                                        }
                                                                        if (z7) {
                                                                            fIntBitsToFloat = -fIntBitsToFloat;
                                                                        } else {
                                                                            fIntBitsToFloat = -fIntBitsToFloat;
                                                                        }
                                                                        if (AndroidComposeViewAccessibilityDelegateCompat.performActionHelper$canScroll(scrollAxisRange2, fIntBitsToFloat)) {
                                                                            semanticsPropertyKey = SemanticsActions.PageUp;
                                                                            if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
                                                                                if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                                    obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                                    if (obj9 == null) {
                                                                                        obj10 = null;
                                                                                    } else {
                                                                                        obj10 = obj9;
                                                                                    }
                                                                                    accessibilityAction5 = (AccessibilityAction) obj10;
                                                                                } else {
                                                                                    obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                                    if (obj7 == null) {
                                                                                        obj8 = null;
                                                                                    } else {
                                                                                        obj8 = obj7;
                                                                                    }
                                                                                    accessibilityAction5 = (AccessibilityAction) obj8;
                                                                                }
                                                                                if (accessibilityAction5 != null) {
                                                                                    return ((Boolean) function13.invoke()).booleanValue();
                                                                                }
                                                                            } else {
                                                                                if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                                    obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                                    if (obj9 == null) {
                                                                                        obj10 = null;
                                                                                    } else {
                                                                                        obj10 = obj9;
                                                                                    }
                                                                                    accessibilityAction5 = (AccessibilityAction) obj10;
                                                                                } else {
                                                                                    obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                                    if (obj7 == null) {
                                                                                        obj8 = null;
                                                                                    } else {
                                                                                        obj8 = obj7;
                                                                                    }
                                                                                    accessibilityAction5 = (AccessibilityAction) obj8;
                                                                                }
                                                                                if (accessibilityAction5 != null) {
                                                                                    return ((Boolean) function13.invoke()).booleanValue();
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    f7 = f7;
                                                                    z10 = z10;
                                                                    obj6 = mutableScatterMap.get(SemanticsProperties.VerticalScrollAxisRange);
                                                                    if (obj6 == null) {
                                                                        obj6 = null;
                                                                    }
                                                                    scrollAxisRange2 = (ScrollAxisRange) obj6;
                                                                    if (scrollAxisRange2 != null) {
                                                                        if (f7 != null) {
                                                                            fIntBitsToFloat = f7.floatValue();
                                                                        } else {
                                                                            fIntBitsToFloat = Float.intBitsToFloat((int) (jM444getSizeNHjbRc & 4294967295L));
                                                                        }
                                                                        if (z7) {
                                                                            fIntBitsToFloat = -fIntBitsToFloat;
                                                                        } else {
                                                                            fIntBitsToFloat = -fIntBitsToFloat;
                                                                        }
                                                                        if (AndroidComposeViewAccessibilityDelegateCompat.performActionHelper$canScroll(scrollAxisRange2, fIntBitsToFloat)) {
                                                                            semanticsPropertyKey = SemanticsActions.PageUp;
                                                                            if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
                                                                                if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                                    obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                                    if (obj9 == null) {
                                                                                        obj10 = null;
                                                                                    } else {
                                                                                        obj10 = obj9;
                                                                                    }
                                                                                    accessibilityAction5 = (AccessibilityAction) obj10;
                                                                                } else {
                                                                                    obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                                    if (obj7 == null) {
                                                                                        obj8 = null;
                                                                                    } else {
                                                                                        obj8 = obj7;
                                                                                    }
                                                                                    accessibilityAction5 = (AccessibilityAction) obj8;
                                                                                }
                                                                                if (accessibilityAction5 != null) {
                                                                                    return ((Boolean) function13.invoke()).booleanValue();
                                                                                }
                                                                            } else {
                                                                                if (fIntBitsToFloat > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                                                    obj9 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                                                    if (obj9 == null) {
                                                                                        obj10 = null;
                                                                                    } else {
                                                                                        obj10 = obj9;
                                                                                    }
                                                                                    accessibilityAction5 = (AccessibilityAction) obj10;
                                                                                } else {
                                                                                    obj7 = mutableScatterMap.get(semanticsPropertyKey);
                                                                                    if (obj7 == null) {
                                                                                        obj8 = null;
                                                                                    } else {
                                                                                        obj8 = obj7;
                                                                                    }
                                                                                    accessibilityAction5 = (AccessibilityAction) obj8;
                                                                                }
                                                                                if (accessibilityAction5 != null) {
                                                                                    return ((Boolean) function13.invoke()).booleanValue();
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    break;
                                                default:
                                                    switch (i2) {
                                                        case android.R.id.accessibilityActionPageUp:
                                                            Object obj31 = mutableScatterMap.get(SemanticsActions.PageUp);
                                                            AccessibilityAction accessibilityAction20 = (AccessibilityAction) (obj31 == null ? null : obj31);
                                                            if (accessibilityAction20 != null && (function16 = (Function0) accessibilityAction20.action) != null) {
                                                                return ((Boolean) function16.invoke()).booleanValue();
                                                            }
                                                            break;
                                                        case android.R.id.accessibilityActionPageDown:
                                                            Object obj32 = mutableScatterMap.get(SemanticsActions.PageDown);
                                                            AccessibilityAction accessibilityAction21 = (AccessibilityAction) (obj32 == null ? null : obj32);
                                                            if (accessibilityAction21 != null && (function17 = (Function0) accessibilityAction21.action) != null) {
                                                                return ((Boolean) function17.invoke()).booleanValue();
                                                            }
                                                            break;
                                                        case android.R.id.accessibilityActionPageLeft:
                                                            Object obj33 = mutableScatterMap.get(SemanticsActions.PageLeft);
                                                            AccessibilityAction accessibilityAction22 = (AccessibilityAction) (obj33 == null ? null : obj33);
                                                            if (accessibilityAction22 != null && (function18 = (Function0) accessibilityAction22.action) != null) {
                                                                return ((Boolean) function18.invoke()).booleanValue();
                                                            }
                                                            break;
                                                        case android.R.id.accessibilityActionPageRight:
                                                            Object obj34 = mutableScatterMap.get(SemanticsActions.PageRight);
                                                            AccessibilityAction accessibilityAction23 = (AccessibilityAction) (obj34 == null ? null : obj34);
                                                            if (accessibilityAction23 != null && (function19 = (Function0) accessibilityAction23.action) != null) {
                                                                return ((Boolean) function19.invoke()).booleanValue();
                                                            }
                                                            break;
                                                        default:
                                                            SparseArrayCompat sparseArrayCompat = androidComposeViewAccessibilityDelegateCompat.actionIdToLabel;
                                                            sparseArrayCompat.getClass();
                                                            SparseArrayCompat sparseArrayCompat2 = (SparseArrayCompat) ArraySetKt.commonGet(sparseArrayCompat, i);
                                                            if (sparseArrayCompat2 != null && ((CharSequence) ArraySetKt.commonGet(sparseArrayCompat2, i2)) != null) {
                                                                Object obj35 = mutableScatterMap.get(SemanticsActions.CustomActions);
                                                                List list = (List) (obj35 == null ? null : obj35);
                                                                if (list != null && list.size() > 0) {
                                                                    list.get(0).getClass();
                                                                    PathKt$$ExternalSyntheticBUOutline0.m();
                                                                    return false;
                                                                }
                                                            }
                                                            break;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                } else {
                                    Object obj36 = mutableScatterMap.get(SemanticsProperties.Focused);
                                    if (Intrinsics.areEqual(obj36 == null ? null : obj36, bool)) {
                                        ((FocusOwnerImpl) androidComposeView.getFocusOwner()).m409clearFocusI7lrPNg(8, false, true);
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (i2 != 64) {
                        if (androidComposeViewAccessibilityDelegateCompat.isAccessibilityEnabled()) {
                        }
                        return false;
                    }
                    if (i2 != 128) {
                        if (androidComposeViewAccessibilityDelegateCompat.accessibilityFocusedVirtualViewId == i) {
                            return false;
                        }
                        androidComposeViewAccessibilityDelegateCompat.accessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
                        androidComposeViewAccessibilityDelegateCompat.currentlyAccessibilityFocusedANI = null;
                        androidComposeView.invalidate();
                        AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, i, 65536, null, 12);
                        return true;
                    }
                    if (i2 != 256) {
                        if (bundle != null) {
                            i5 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
                            z = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
                            if (i2 == 256) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            num2 = androidComposeViewAccessibilityDelegateCompat.previousTraversedNode;
                            if (num2 != null) {
                                androidComposeViewAccessibilityDelegateCompat.accessibilityCursorPosition = -1;
                                androidComposeViewAccessibilityDelegateCompat.previousTraversedNode = Integer.valueOf(i11);
                            } else {
                                androidComposeViewAccessibilityDelegateCompat.accessibilityCursorPosition = -1;
                                androidComposeViewAccessibilityDelegateCompat.previousTraversedNode = Integer.valueOf(i11);
                            }
                            iterableTextForAccessibility = AndroidComposeViewAccessibilityDelegateCompat.getIterableTextForAccessibility(semanticsNode);
                            if (iterableTextForAccessibility != null) {
                                iterableTextForAccessibility2 = AndroidComposeViewAccessibilityDelegateCompat.getIterableTextForAccessibility(semanticsNode);
                                if (iterableTextForAccessibility2 != null) {
                                    baseMenuWrapper = null;
                                } else {
                                    baseMenuWrapper = null;
                                }
                                if (baseMenuWrapper != null) {
                                    accessibilitySelectionEnd = androidComposeViewAccessibilityDelegateCompat.getAccessibilitySelectionEnd(semanticsNode);
                                    if (accessibilitySelectionEnd == -1) {
                                        if (z2) {
                                            length = 0;
                                        } else {
                                            length = iterableTextForAccessibility.length();
                                        }
                                        accessibilitySelectionEnd = length;
                                    }
                                    if (z2) {
                                        iArrPreceding = baseMenuWrapper.following(accessibilitySelectionEnd);
                                    } else {
                                        iArrPreceding = baseMenuWrapper.preceding(accessibilitySelectionEnd);
                                    }
                                    if (iArrPreceding != null) {
                                        i6 = iArrPreceding[0];
                                        i7 = iArrPreceding[1];
                                        if (z) {
                                            if (z2) {
                                                accessibilitySelectionStart = i7;
                                            } else {
                                                accessibilitySelectionStart = i6;
                                            }
                                            i8 = accessibilitySelectionStart;
                                        } else {
                                            if (z2) {
                                                accessibilitySelectionStart = i7;
                                            } else {
                                                accessibilitySelectionStart = i6;
                                            }
                                            i8 = accessibilitySelectionStart;
                                        }
                                        if (z2) {
                                            i9 = 256;
                                        } else {
                                            i9 = 512;
                                        }
                                        androidComposeViewAccessibilityDelegateCompat.pendingTextTraversedEvent = new PendingTextTraversedEvent(semanticsNode, i9, i5, i6, i7, SystemClock.uptimeMillis());
                                        androidComposeViewAccessibilityDelegateCompat.setAccessibilitySelection(semanticsNode, accessibilitySelectionStart, i8, true);
                                        return true;
                                    }
                                }
                            }
                        }
                    } else if (bundle != null) {
                        i5 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
                        z = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
                        if (i2 == 256) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        num2 = androidComposeViewAccessibilityDelegateCompat.previousTraversedNode;
                        if (num2 != null) {
                            androidComposeViewAccessibilityDelegateCompat.accessibilityCursorPosition = -1;
                            androidComposeViewAccessibilityDelegateCompat.previousTraversedNode = Integer.valueOf(i11);
                        } else {
                            androidComposeViewAccessibilityDelegateCompat.accessibilityCursorPosition = -1;
                            androidComposeViewAccessibilityDelegateCompat.previousTraversedNode = Integer.valueOf(i11);
                        }
                        iterableTextForAccessibility = AndroidComposeViewAccessibilityDelegateCompat.getIterableTextForAccessibility(semanticsNode);
                        if (iterableTextForAccessibility != null) {
                            iterableTextForAccessibility2 = AndroidComposeViewAccessibilityDelegateCompat.getIterableTextForAccessibility(semanticsNode);
                            if (iterableTextForAccessibility2 != null) {
                                baseMenuWrapper = null;
                            } else {
                                baseMenuWrapper = null;
                            }
                            if (baseMenuWrapper != null) {
                                accessibilitySelectionEnd = androidComposeViewAccessibilityDelegateCompat.getAccessibilitySelectionEnd(semanticsNode);
                                if (accessibilitySelectionEnd == -1) {
                                    if (z2) {
                                        length = 0;
                                    } else {
                                        length = iterableTextForAccessibility.length();
                                    }
                                    accessibilitySelectionEnd = length;
                                }
                                if (z2) {
                                    iArrPreceding = baseMenuWrapper.following(accessibilitySelectionEnd);
                                } else {
                                    iArrPreceding = baseMenuWrapper.preceding(accessibilitySelectionEnd);
                                }
                                if (iArrPreceding != null) {
                                    i6 = iArrPreceding[0];
                                    i7 = iArrPreceding[1];
                                    if (z) {
                                        if (z2) {
                                            accessibilitySelectionStart = i7;
                                        } else {
                                            accessibilitySelectionStart = i6;
                                        }
                                        i8 = accessibilitySelectionStart;
                                    } else {
                                        if (z2) {
                                            accessibilitySelectionStart = i7;
                                        } else {
                                            accessibilitySelectionStart = i6;
                                        }
                                        i8 = accessibilitySelectionStart;
                                    }
                                    if (z2) {
                                        i9 = 256;
                                    } else {
                                        i9 = 512;
                                    }
                                    androidComposeViewAccessibilityDelegateCompat.pendingTextTraversedEvent = new PendingTextTraversedEvent(semanticsNode, i9, i5, i6, i7, SystemClock.uptimeMillis());
                                    androidComposeViewAccessibilityDelegateCompat.setAccessibilitySelection(semanticsNode, accessibilitySelectionStart, i8, true);
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PendingTextTraversedEvent {
        public final int action;
        public final int fromIndex;
        public final int granularity;
        public final SemanticsNode node;
        public final int toIndex;
        public final long traverseTime;

        public PendingTextTraversedEvent(SemanticsNode semanticsNode, int i, int i2, int i3, int i4, long j) {
            this.node = semanticsNode;
            this.action = i;
            this.granularity = i2;
            this.fromIndex = i3;
            this.toIndex = i4;
            this.traverseTime = j;
        }
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView androidComposeView) {
        this.view = androidComposeView;
        new Handler(Looper.getMainLooper());
        this.nodeProvider = new ComposeAccessibilityNodeProvider();
        this.accessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.pendingHorizontalScrollEvents = new MutableIntObjectMap();
        this.pendingVerticalScrollEvents = new MutableIntObjectMap();
        this.actionIdToLabel = new SparseArrayCompat(0);
        this.labelToActionId = new SparseArrayCompat(0);
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet(0);
        this.boundsUpdateChannel = EntryPoints.Channel$default(1, 6, null);
        this.currentSemanticsNodesInvalidated = true;
        MutableIntObjectMap mutableIntObjectMap = IntObjectMapKt.EmptyIntObjectMap;
        mutableIntObjectMap.getClass();
        this.currentSemanticsNodes = mutableIntObjectMap;
        this.paneDisplayed = new MutableIntSet();
        this.idToBeforeMap = new MutableIntIntMap();
        this.idToAfterMap = new MutableIntIntMap();
        this.ExtraDataTestTraversalBeforeVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.ExtraDataTestTraversalAfterVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.urlSpanCache = new EmojiProcessor((byte) 16);
        this.previousSemanticsNodes = new MutableIntObjectMap();
        this.previousSemanticsRoot = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), mutableIntObjectMap);
        int i = IntIntMapKt.$r8$clinit;
        this.drawingOrder = new MutableIntIntMap();
        androidComposeView.addOnAttachStateChangeListener(this);
        this.semanticsChangeChecker = new ActivityCompat$$ExternalSyntheticLambda0((byte) 7, (Object) this);
        this.scrollObservationScopes = new ArrayList();
        this.scheduleScrollEventIfNeededLambda = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda2(this, (byte) 1);
    }

    public static String getIterableTextForAccessibility(SemanticsNode semanticsNode) {
        AnnotatedString annotatedString;
        if (semanticsNode != null) {
            SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
            MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
            SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
            if (mutableScatterMap.containsKey(semanticsPropertyKey)) {
                return ListUtilsKt.fastJoinToString$default((List) semanticsConfiguration.get(semanticsPropertyKey), ",", null, 62);
            }
            SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.EditableText;
            if (mutableScatterMap.containsKey(semanticsPropertyKey2)) {
                Object obj = mutableScatterMap.get(semanticsPropertyKey2);
                if (obj == null) {
                    obj = null;
                }
                AnnotatedString annotatedString2 = (AnnotatedString) obj;
                if (annotatedString2 != null) {
                    return annotatedString2.text;
                }
            } else {
                Object obj2 = mutableScatterMap.get(SemanticsProperties.Text);
                if (obj2 == null) {
                    obj2 = null;
                }
                List list = (List) obj2;
                if (list != null && (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) != null) {
                    return annotatedString.text;
                }
            }
        }
        return null;
    }

    public static final boolean performActionHelper$canScroll(ScrollAxisRange scrollAxisRange, float f) {
        Function0 function0 = scrollAxisRange.value;
        if (f >= CropImageView.DEFAULT_ASPECT_RATIO || ((Number) function0.invoke()).floatValue() <= CropImageView.DEFAULT_ASPECT_RATIO) {
            return f > CropImageView.DEFAULT_ASPECT_RATIO && ((Number) function0.invoke()).floatValue() < ((Number) scrollAxisRange.maxValue.invoke()).floatValue();
        }
        return true;
    }

    public static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange scrollAxisRange) {
        Function0 function0 = scrollAxisRange.value;
        if (((Number) function0.invoke()).floatValue() > CropImageView.DEFAULT_ASPECT_RATIO) {
            return true;
        }
        ((Number) function0.invoke()).floatValue();
        ((Number) scrollAxisRange.maxValue.invoke()).floatValue();
        return false;
    }

    public static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange scrollAxisRange) {
        Function0 function0 = scrollAxisRange.value;
        if (((Number) function0.invoke()).floatValue() < ((Number) scrollAxisRange.maxValue.invoke()).floatValue()) {
            return true;
        }
        ((Number) function0.invoke()).floatValue();
        return false;
    }

    public static /* synthetic */ void sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i, int i2, Integer num, int i3) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i, i2, num, null);
    }

    public static Rect toAndroidRect(ColorKt colorKt, float f, float f2) {
        if (!(colorKt instanceof Outline$Rectangle) && !(colorKt instanceof Outline$Rounded)) {
            return null;
        }
        androidx.compose.ui.geometry.Rect bounds = colorKt.getBounds();
        return new Rect((int) (bounds.left + f), (int) (bounds.top + f2), (int) (bounds.right + f), (int) (bounds.bottom + f2));
    }

    public static float[] toCornerArray(ColorKt colorKt) {
        if (!(colorKt instanceof Outline$Rounded)) {
            return null;
        }
        RoundRect roundRect = ((Outline$Rounded) colorKt).roundRect;
        long j = roundRect.bottomLeftCornerRadius;
        long j2 = roundRect.bottomRightCornerRadius;
        long j3 = roundRect.topRightCornerRadius;
        long j4 = roundRect.topLeftCornerRadius;
        return new float[]{Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat((int) (j4 & 4294967295L)), Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)), Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)), Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L))};
    }

    public static Region toRegion(ColorKt colorKt, float f, float f2) {
        if (colorKt instanceof Outline$Generic) {
            Outline$Generic outline$Generic = (Outline$Generic) colorKt;
            androidx.compose.ui.geometry.Rect rectTranslate = outline$Generic.getBounds().translate(f, f2);
            Region region = new Region(new Rect((int) (rectTranslate.left + CropImageView.DEFAULT_ASPECT_RATIO), (int) (rectTranslate.top + CropImageView.DEFAULT_ASPECT_RATIO), (int) (rectTranslate.right + CropImageView.DEFAULT_ASPECT_RATIO), (int) (rectTranslate.bottom + CropImageView.DEFAULT_ASPECT_RATIO)));
            Region region2 = new Region();
            AndroidPath androidPath = outline$Generic.path;
            if (androidPath instanceof AndroidPath) {
                Path path = androidPath.internalPath;
                path.offset(f, f2);
                region2.setPath(path, region);
                return region2;
            }
            PathKt$$ExternalSyntheticBUOutline0.m$2("Unable to obtain android.graphics.Path");
        }
        return null;
    }

    public static CharSequence trimToSize(CharSequence charSequence) {
        if (charSequence.length() != 0) {
            int i = 100000;
            if (charSequence.length() > 100000) {
                if (Character.isHighSurrogate(charSequence.charAt(99999)) && Character.isLowSurrogate(charSequence.charAt(100000))) {
                    i = 99999;
                }
                CharSequence charSequenceSubSequence = charSequence.subSequence(0, i);
                charSequenceSubSequence.getClass();
                return charSequenceSubSequence;
            }
        }
        return charSequence;
    }

    public final void addChildToNodeInfo(AdjustedSemanticsNode adjustedSemanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, boolean z, int i) {
        AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
        SemanticsNode semanticsNode = adjustedSemanticsNode.semanticsNode;
        AndroidComposeView androidComposeView = this.view;
        AndroidViewsHandler androidViewsHandler$ui = androidComposeView.getAndroidViewsHandler$ui();
        AndroidViewHolder androidViewHolder = androidViewsHandler$ui != null ? androidViewsHandler$ui.getLayoutNodeToHolder().get(semanticsNode.layoutNode) : null;
        if (androidViewHolder != null) {
            accessibilityNodeInfo.addChild(androidViewHolder);
        } else {
            Object obj = semanticsNode.getConfig().props.get(SemanticsProperties.IsSensitiveData);
            boolean zAreEqual = Intrinsics.areEqual(obj != null ? obj : null, Boolean.TRUE);
            if (z || !zAreEqual) {
                accessibilityNodeInfo.addChild(androidComposeView, semanticsNode.id);
            }
        }
        this.drawingOrder.set(semanticsNode.id, i);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0092  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c1  */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
        SemanticsNode semanticsNode;
        RectF[] rectFArr;
        int i2;
        AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
        AdjustedSemanticsNode adjustedSemanticsNode = (AdjustedSemanticsNode) getCurrentSemanticsNodes().get(i);
        if (adjustedSemanticsNode == null || (semanticsNode = adjustedSemanticsNode.semanticsNode) == null) {
            return;
        }
        LayoutNode layoutNode = semanticsNode.layoutNode;
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if (Intrinsics.areEqual(str, this.ExtraDataTestTraversalBeforeVal)) {
            int orDefault = this.idToBeforeMap.getOrDefault(i, -1);
            if (orDefault != -1) {
                accessibilityNodeInfo.getExtras().putInt(str, orDefault);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(str, this.ExtraDataTestTraversalAfterVal)) {
            int orDefault2 = this.idToAfterMap.getOrDefault(i, -1);
            if (orDefault2 != -1) {
                accessibilityNodeInfo.getExtras().putInt(str, orDefault2);
                return;
            }
            return;
        }
        boolean zContainsKey = mutableScatterMap.containsKey(SemanticsActions.GetTextLayoutResult);
        AndroidComposeView androidComposeView = this.view;
        int i3 = 0;
        if (zContainsKey && bundle != null && Intrinsics.areEqual(str, "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
            int i4 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
            int i5 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
            if (i5 > 0 && i4 >= 0) {
                if (i4 < (iterableTextForAccessibility != null ? iterableTextForAccessibility.length() : Integer.MAX_VALUE)) {
                    TextLayoutResult textLayoutResult = InvertMatrixKt.getTextLayoutResult(semanticsConfiguration);
                    if (textLayoutResult == null) {
                        rectFArr = null;
                    } else {
                        InnerNodeCoordinator innerNodeCoordinator = (InnerNodeCoordinator) layoutNode.nodes.innerCoordinator;
                        if (!innerNodeCoordinator.tail.isAttached) {
                            innerNodeCoordinator = null;
                        }
                        if (innerNodeCoordinator != null) {
                            long jMo606localToRootMKHz9U = innerNodeCoordinator.mo606localToRootMKHz9U(0L);
                            androidx.compose.ui.geometry.Rect boundsInRoot = semanticsNode.getBoundsInRoot();
                            RectF[] rectFArr2 = new RectF[i5];
                            while (i3 < i5) {
                                int i6 = i4 + i3;
                                if (i6 >= textLayoutResult.layoutInput.text.text.length()) {
                                    i2 = i3;
                                } else {
                                    androidx.compose.ui.geometry.Rect rectM446translatek4lQ0M = textLayoutResult.getBoundingBox(i6).m446translatek4lQ0M(jMo606localToRootMKHz9U);
                                    androidx.compose.ui.geometry.Rect rectIntersect = rectM446translatek4lQ0M.overlaps(boundsInRoot) ? rectM446translatek4lQ0M.intersect(boundsInRoot) : null;
                                    if (rectIntersect != null) {
                                        i2 = i3;
                                        long jM686localToScreenMKHz9U = androidComposeView.m686localToScreenMKHz9U((((long) Float.floatToRawIntBits(rectIntersect.left)) << 32) | (((long) Float.floatToRawIntBits(rectIntersect.top)) & 4294967295L));
                                        long jM686localToScreenMKHz9U2 = androidComposeView.m686localToScreenMKHz9U((((long) Float.floatToRawIntBits(rectIntersect.bottom)) & 4294967295L) | (((long) Float.floatToRawIntBits(rectIntersect.right)) << 32));
                                        int i7 = (int) (jM686localToScreenMKHz9U >> 32);
                                        int i8 = (int) (jM686localToScreenMKHz9U2 >> 32);
                                        int i9 = (int) (jM686localToScreenMKHz9U & 4294967295L);
                                        int i10 = (int) (jM686localToScreenMKHz9U2 & 4294967295L);
                                        rectFArr2[i2] = new RectF(Math.min(Float.intBitsToFloat(i7), Float.intBitsToFloat(i8)), Math.min(Float.intBitsToFloat(i9), Float.intBitsToFloat(i10)), Math.max(Float.intBitsToFloat(i7), Float.intBitsToFloat(i8)), Math.max(Float.intBitsToFloat(i9), Float.intBitsToFloat(i10)));
                                    } else {
                                        i2 = i3;
                                    }
                                }
                                i3 = i2 + 1;
                                textLayoutResult = textLayoutResult;
                                i5 = i5;
                                boundsInRoot = boundsInRoot;
                                i4 = i4;
                            }
                            rectFArr = rectFArr2;
                        } else {
                            rectFArr = null;
                        }
                    }
                    if (rectFArr == null) {
                        return;
                    }
                    accessibilityNodeInfo.getExtras().putParcelableArray(str, rectFArr);
                    return;
                }
            }
            Log.e("AccessibilityDelegate", "Invalid arguments for accessibility character locations");
            return;
        }
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.TestTag;
        if (mutableScatterMap.containsKey(semanticsPropertyKey) && bundle != null && Intrinsics.areEqual(str, "androidx.compose.ui.semantics.testTag")) {
            Object obj = mutableScatterMap.get(semanticsPropertyKey);
            String str2 = (String) (obj == null ? null : obj);
            if (str2 != null) {
                accessibilityNodeInfo.getExtras().putCharSequence(str, str2);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(str, "androidx.compose.ui.semantics.id")) {
            accessibilityNodeInfo.getExtras().putInt(str, semanticsNode.id);
            return;
        }
        if (Intrinsics.areEqual(str, "androidx.compose.ui.semantics.shapeType")) {
            Object obj2 = mutableScatterMap.get(SemanticsProperties.Shape);
            Shape shape = (Shape) (obj2 == null ? null : obj2);
            if (shape != null) {
                Rect rect = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect);
                androidx.compose.ui.geometry.Rect shapeBounds = getShapeBounds(semanticsNode, rect, shape);
                float f = shapeBounds.top;
                float f2 = shapeBounds.left;
                ColorKt colorKtMo56createOutlinePq9zytI = shape.mo56createOutlinePq9zytI(shapeBounds.m444getSizeNHjbRc(), layoutNode.layoutDirection, androidComposeView.getDensity());
                if (colorKtMo56createOutlinePq9zytI instanceof Outline$Rectangle) {
                    accessibilityNodeInfo.getExtras().putInt("androidx.compose.ui.semantics.shapeType", 0);
                    accessibilityNodeInfo.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRect", toAndroidRect(colorKtMo56createOutlinePq9zytI, f2, f));
                    return;
                } else if (colorKtMo56createOutlinePq9zytI instanceof Outline$Rounded) {
                    accessibilityNodeInfo.getExtras().putInt("androidx.compose.ui.semantics.shapeType", 1);
                    accessibilityNodeInfo.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRect", toAndroidRect(colorKtMo56createOutlinePq9zytI, f2, f));
                    accessibilityNodeInfo.getExtras().putFloatArray("androidx.compose.ui.semantics.shapeCorners", toCornerArray(colorKtMo56createOutlinePq9zytI));
                    return;
                } else if (!(colorKtMo56createOutlinePq9zytI instanceof Outline$Generic)) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return;
                } else {
                    accessibilityNodeInfo.getExtras().putInt("androidx.compose.ui.semantics.shapeType", 2);
                    accessibilityNodeInfo.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRegion", toRegion(colorKtMo56createOutlinePq9zytI, f2, f));
                    return;
                }
            }
            return;
        }
        if (Intrinsics.areEqual(str, "androidx.compose.ui.semantics.shapeRect")) {
            Object obj3 = mutableScatterMap.get(SemanticsProperties.Shape);
            Shape shape2 = (Shape) (obj3 == null ? null : obj3);
            if (shape2 != null) {
                Rect rect2 = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect2);
                androidx.compose.ui.geometry.Rect shapeBounds2 = getShapeBounds(semanticsNode, rect2, shape2);
                Rect androidRect = toAndroidRect(shape2.mo56createOutlinePq9zytI(shapeBounds2.m444getSizeNHjbRc(), layoutNode.layoutDirection, androidComposeView.getDensity()), shapeBounds2.left, shapeBounds2.top);
                if (androidRect != null) {
                    accessibilityNodeInfo.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRect", androidRect);
                    return;
                }
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(str, "androidx.compose.ui.semantics.shapeCorners")) {
            Object obj4 = mutableScatterMap.get(SemanticsProperties.Shape);
            Shape shape3 = (Shape) (obj4 == null ? null : obj4);
            if (shape3 != null) {
                Rect rect3 = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect3);
                float[] cornerArray = toCornerArray(shape3.mo56createOutlinePq9zytI(getShapeBounds(semanticsNode, rect3, shape3).m444getSizeNHjbRc(), layoutNode.layoutDirection, androidComposeView.getDensity()));
                if (cornerArray != null) {
                    accessibilityNodeInfo.getExtras().putFloatArray("androidx.compose.ui.semantics.shapeCorners", cornerArray);
                    return;
                }
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(str, "androidx.compose.ui.semantics.shapeRegion")) {
            if (Build.VERSION.SDK_INT < 37 || !Intrinsics.areEqual(str, "android.view.accessibility.extra.DATA_RENDERING_INFO_KEY")) {
                return;
            }
            Api37Impl.setExtraRenderingInfo(semanticsNode, accessibilityNodeInfo);
            return;
        }
        Object obj5 = mutableScatterMap.get(SemanticsProperties.Shape);
        Shape shape4 = (Shape) (obj5 == null ? null : obj5);
        if (shape4 != null) {
            Rect rect4 = new Rect();
            accessibilityNodeInfo.getBoundsInScreen(rect4);
            androidx.compose.ui.geometry.Rect shapeBounds3 = getShapeBounds(semanticsNode, rect4, shape4);
            Region region = toRegion(shape4.mo56createOutlinePq9zytI(shapeBounds3.m444getSizeNHjbRc(), layoutNode.layoutDirection, androidComposeView.getDensity()), shapeBounds3.left, shapeBounds3.top);
            if (region != null) {
                accessibilityNodeInfo.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRegion", region);
            }
        }
    }

    public final Rect boundsInScreen(AdjustedSemanticsNode adjustedSemanticsNode) {
        IntRect intRect = adjustedSemanticsNode.adjustedBounds;
        return toBoundsInScreen(intRect.left, intRect.top, intRect.right, intRect.bottom);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0065  */
    /* JADX WARN: Code duplicated, block: B:27:0x0066  */
    /* JADX WARN: Code duplicated, block: B:30:0x0071 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:13:0x002c, B:24:0x0056, B:28:0x0069, B:30:0x0071, B:32:0x007c, B:34:0x0087, B:37:0x0096, B:39:0x009f, B:40:0x00a2, B:41:0x00a3, B:20:0x0040, B:23:0x0047, B:33:0x0081), top: B:48:0x0022, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x007c A[Catch: all -> 0x0032, TRY_LEAVE, TryCatch #0 {all -> 0x0032, blocks: (B:13:0x002c, B:24:0x0056, B:28:0x0069, B:30:0x0071, B:32:0x007c, B:34:0x0087, B:37:0x0096, B:39:0x009f, B:40:0x00a2, B:41:0x00a3, B:20:0x0040, B:23:0x0047, B:33:0x0081), top: B:48:0x0022, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0094 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:44:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bc, code lost:
    
        if (kotlinx.coroutines.AwaitKt.delay(r7, r0) == r5) goto L43;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00bc -> B:14:0x002f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object boundsUpdatesEventLoop$ui(ContinuationImpl continuationImpl) {
        AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1;
        MutableIntSet mutableIntSet;
        MutableIntSet mutableIntSet2;
        ChannelIterator channelIterator;
        Handler handler;
        ChannelIterator bufferedChannelIterator;
        BufferedChannel.BufferedChannelIterator bufferedChannelIterator2;
        Object objHasNext;
        ChannelIterator channelIterator2;
        if (continuationImpl instanceof AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1) {
            androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 = (AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1) continuationImpl;
            int i = androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label = i - Integer.MIN_VALUE;
            } else {
                androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 = new AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1(this, continuationImpl);
            }
        } else {
            androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 = new AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1(this, continuationImpl);
        }
        Object obj = androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.result;
        int i2 = androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label;
        ArraySet arraySet = this.subtreeChangedLayoutNodes;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutableIntSet = new MutableIntSet();
                BufferedChannel bufferedChannel = this.boundsUpdateChannel;
                bufferedChannel.getClass();
                bufferedChannelIterator = bufferedChannel.new BufferedChannelIterator();
                androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$0 = mutableIntSet;
                androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$1 = bufferedChannelIterator;
                androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label = 1;
                bufferedChannelIterator2 = (BufferedChannel.BufferedChannelIterator) bufferedChannelIterator;
                objHasNext = bufferedChannelIterator2.hasNext(androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1);
                if (objHasNext == coroutineSingletons) {
                    mutableIntSet2 = mutableIntSet;
                    obj = objHasNext;
                    channelIterator = bufferedChannelIterator2;
                    if (!((Boolean) obj).booleanValue()) {
                        arraySet.clear();
                        return Unit.INSTANCE;
                    }
                    BufferedChannel.BufferedChannelIterator bufferedChannelIterator3 = (BufferedChannel.BufferedChannelIterator) channelIterator;
                    bufferedChannelIterator3.next();
                    if (isEnabled$ui()) {
                        Trace.beginSection("Compose:semantics:boundUpdates");
                        updateBounds(mutableIntSet2);
                        mutableIntSet2.clear();
                        Trace.endSection();
                        handler = this.view.getHandler();
                        if (!this.checkingForSemanticsChanges) {
                            this.checkingForSemanticsChanges = true;
                            handler.post(this.semanticsChangeChecker);
                        }
                    }
                    arraySet.clear();
                    this.pendingHorizontalScrollEvents.clear();
                    this.pendingVerticalScrollEvents.clear();
                    long j = this.SendRecurringAccessibilityEventsIntervalMillis;
                    androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$0 = mutableIntSet2;
                    androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$1 = bufferedChannelIterator3;
                    androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label = 2;
                    channelIterator2 = bufferedChannelIterator3;
                }
                return coroutineSingletons;
            }
            if (i2 == 1) {
                ChannelIterator channelIterator3 = androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$1;
                mutableIntSet2 = androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$0;
                ResultKt.throwOnFailure(obj);
                channelIterator = channelIterator3;
                if (!((Boolean) obj).booleanValue()) {
                    arraySet.clear();
                    return Unit.INSTANCE;
                }
                BufferedChannel.BufferedChannelIterator bufferedChannelIterator4 = (BufferedChannel.BufferedChannelIterator) channelIterator;
                bufferedChannelIterator4.next();
                if (isEnabled$ui()) {
                    try {
                        Trace.beginSection("Compose:semantics:boundUpdates");
                        updateBounds(mutableIntSet2);
                        mutableIntSet2.clear();
                        Trace.endSection();
                        handler = this.view.getHandler();
                        if (!this.checkingForSemanticsChanges && handler != null) {
                            this.checkingForSemanticsChanges = true;
                            handler.post(this.semanticsChangeChecker);
                        }
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                }
                arraySet.clear();
                this.pendingHorizontalScrollEvents.clear();
                this.pendingVerticalScrollEvents.clear();
                long j2 = this.SendRecurringAccessibilityEventsIntervalMillis;
                androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$0 = mutableIntSet2;
                androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$1 = bufferedChannelIterator4;
                androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label = 2;
                channelIterator2 = bufferedChannelIterator4;
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ChannelIterator channelIterator4 = androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$1;
                mutableIntSet2 = androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$0;
                ResultKt.throwOnFailure(obj);
                channelIterator2 = channelIterator4;
            }
            mutableIntSet = mutableIntSet2;
            bufferedChannelIterator = channelIterator2;
            androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$0 = mutableIntSet;
            androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$1 = bufferedChannelIterator;
            androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label = 1;
            bufferedChannelIterator2 = (BufferedChannel.BufferedChannelIterator) bufferedChannelIterator;
            objHasNext = bufferedChannelIterator2.hasNext(androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1);
            if (objHasNext == coroutineSingletons) {
                mutableIntSet2 = mutableIntSet;
                obj = objHasNext;
                channelIterator = bufferedChannelIterator2;
                if (!((Boolean) obj).booleanValue()) {
                    arraySet.clear();
                    return Unit.INSTANCE;
                }
                BufferedChannel.BufferedChannelIterator bufferedChannelIterator5 = (BufferedChannel.BufferedChannelIterator) channelIterator;
                bufferedChannelIterator5.next();
                if (isEnabled$ui()) {
                    Trace.beginSection("Compose:semantics:boundUpdates");
                    updateBounds(mutableIntSet2);
                    mutableIntSet2.clear();
                    Trace.endSection();
                    handler = this.view.getHandler();
                    if (!this.checkingForSemanticsChanges) {
                        this.checkingForSemanticsChanges = true;
                        handler.post(this.semanticsChangeChecker);
                    }
                }
                arraySet.clear();
                this.pendingHorizontalScrollEvents.clear();
                this.pendingVerticalScrollEvents.clear();
                long j3 = this.SendRecurringAccessibilityEventsIntervalMillis;
                androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$0 = mutableIntSet2;
                androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.L$1 = bufferedChannelIterator5;
                androidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1.label = 2;
                channelIterator2 = bufferedChannelIterator5;
            }
            return coroutineSingletons;
        } catch (Throwable th2) {
            arraySet.clear();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00f9  */
    /* JADX INFO: renamed from: canScroll-0AR0LA0$ui, reason: not valid java name */
    public final boolean m700canScroll0AR0LA0$ui(int i, long j, boolean z) {
        SemanticsPropertyKey semanticsPropertyKey;
        int i2;
        if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            IntObjectMap currentSemanticsNodes = getCurrentSemanticsNodes();
            if (!Offset.m434equalsimpl0(j, 9205357640488583168L) && (((9223372034707292159L & j) + 36028792732385279L) & (-9223372034707292160L)) == 0) {
                if (z) {
                    semanticsPropertyKey = SemanticsProperties.VerticalScrollAxisRange;
                } else {
                    if (z) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return false;
                    }
                    semanticsPropertyKey = SemanticsProperties.HorizontalScrollAxisRange;
                }
                Object[] objArr = currentSemanticsNodes.values;
                long[] jArr = currentSemanticsNodes.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i3 = 0;
                    boolean z2 = false;
                    while (true) {
                        long j2 = jArr[i3];
                        if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i4 = 8;
                            int i5 = 8 - ((~(i3 - length)) >>> 31);
                            int i6 = 0;
                            while (i6 < i5) {
                                if ((255 & j2) < 128) {
                                    AdjustedSemanticsNode adjustedSemanticsNode = (AdjustedSemanticsNode) objArr[(i3 << 3) + i6];
                                    IntRect intRect = adjustedSemanticsNode.adjustedBounds;
                                    float f = intRect.left;
                                    i2 = i4;
                                    float f2 = intRect.top;
                                    float f3 = intRect.right;
                                    float f4 = intRect.bottom;
                                    float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
                                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
                                    if ((fIntBitsToFloat2 < f4) & (fIntBitsToFloat >= f) & (fIntBitsToFloat < f3) & (fIntBitsToFloat2 >= f2)) {
                                        Object obj = adjustedSemanticsNode.semanticsNode.unmergedConfig.props.get(semanticsPropertyKey);
                                        if (obj == null) {
                                            obj = null;
                                        }
                                        ScrollAxisRange scrollAxisRange = (ScrollAxisRange) obj;
                                        if (scrollAxisRange != null) {
                                            Function0 function0 = scrollAxisRange.value;
                                            if (i < 0) {
                                                if (((Number) function0.invoke()).floatValue() > CropImageView.DEFAULT_ASPECT_RATIO) {
                                                    z2 = true;
                                                }
                                            } else if (((Number) function0.invoke()).floatValue() < ((Number) scrollAxisRange.maxValue.invoke()).floatValue()) {
                                                z2 = true;
                                            }
                                        }
                                    }
                                } else {
                                    i2 = i4;
                                }
                                j2 >>= i2;
                                i6++;
                                i4 = i2;
                            }
                            if (i5 != i4) {
                                return z2;
                            }
                        }
                        if (i3 == length) {
                            return z2;
                        }
                        i3++;
                    }
                }
            }
        }
        return false;
    }

    public final void checkForSemanticsChanges() {
        Trace.beginSection("Compose:semantics:sendAccessibilitySemanticsStructureChangeEvents");
        try {
            if (isEnabled$ui()) {
                sendAccessibilitySemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
            }
            Trace.endSection();
            Trace.beginSection("Compose:semantics:sendSemanticsPropertyChangeEvents");
            try {
                sendSemanticsPropertyChangeEvents(getCurrentSemanticsNodes());
                Trace.endSection();
                Trace.beginSection("Compose:semantics:updateSemanticsNodesCopyAndPanes");
                try {
                    updateSemanticsNodesCopyAndPanes();
                } finally {
                    Trace.endSection();
                }
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    public final AccessibilityEvent createEvent(int i, int i2) {
        AdjustedSemanticsNode adjustedSemanticsNode;
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
        accessibilityEventObtain.setEnabled(true);
        accessibilityEventObtain.setClassName("android.view.View");
        AndroidComposeView androidComposeView = this.view;
        accessibilityEventObtain.setPackageName(androidComposeView.getContext().getPackageName());
        accessibilityEventObtain.setSource(androidComposeView, i);
        if (isEnabled$ui() && (adjustedSemanticsNode = (AdjustedSemanticsNode) getCurrentSemanticsNodes().get(i)) != null) {
            SemanticsNode semanticsNode = adjustedSemanticsNode.semanticsNode;
            accessibilityEventObtain.setPassword(semanticsNode.unmergedConfig.props.containsKey(SemanticsProperties.Password));
            Object obj = semanticsNode.unmergedConfig.props.get(SemanticsProperties.IsSensitiveData);
            if (obj == null) {
                obj = null;
            }
            boolean zAreEqual = Intrinsics.areEqual(obj, Boolean.TRUE);
            if (Build.VERSION.SDK_INT >= 34) {
                TextViewCompat$Api34Impl.setAccessibilityDataSensitive(accessibilityEventObtain, zAreEqual);
            }
        }
        return accessibilityEventObtain;
    }

    public final AccessibilityEvent createTextSelectionChangedEvent(int i, Integer num, Integer num2, Integer num3, CharSequence charSequence) {
        AccessibilityEvent accessibilityEventCreateEvent = createEvent(i, 8192);
        if (num != null) {
            accessibilityEventCreateEvent.setFromIndex(num.intValue());
        }
        if (num2 != null) {
            accessibilityEventCreateEvent.setToIndex(num2.intValue());
        }
        if (num3 != null) {
            accessibilityEventCreateEvent.setItemCount(num3.intValue());
        }
        if (charSequence != null) {
            accessibilityEventCreateEvent.getText().add(charSequence);
        }
        return accessibilityEventCreateEvent;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final AtomicInt getAccessibilityNodeProvider(View view) {
        return this.nodeProvider;
    }

    public final int getAccessibilitySelectionEnd(SemanticsNode semanticsNode) {
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        if (!semanticsConfiguration.props.containsKey(SemanticsProperties.ContentDescription)) {
            SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.TextSelectionRange;
            if (semanticsConfiguration.props.containsKey(semanticsPropertyKey)) {
                return (int) (((TextRange) semanticsConfiguration.get(semanticsPropertyKey)).packedValue & 4294967295L);
            }
        }
        return this.accessibilityCursorPosition;
    }

    public final int getAccessibilitySelectionStart(SemanticsNode semanticsNode) {
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        if (!semanticsConfiguration.props.containsKey(SemanticsProperties.ContentDescription)) {
            SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.TextSelectionRange;
            if (semanticsConfiguration.props.containsKey(semanticsPropertyKey)) {
                return (int) (((TextRange) semanticsConfiguration.get(semanticsPropertyKey)).packedValue >> 32);
            }
        }
        return this.accessibilityCursorPosition;
    }

    public final IntObjectMap getCurrentSemanticsNodes() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            AndroidComposeView androidComposeView = this.view;
            this.currentSemanticsNodes = SemanticsNodeKt.getAllUncoveredSemanticsNodesToIntObjectMap(androidComposeView.getSemanticsOwner(), new ComposedModifierKt$$ExternalSyntheticLambda0((byte) 26));
            if (isEnabled$ui()) {
                MutableIntObjectMap mutableIntObjectMap = this.currentSemanticsNodes;
                Resources resources = androidComposeView.getContext().getResources();
                MutableIntIntMap mutableIntIntMap = this.idToBeforeMap;
                mutableIntIntMap.clear();
                MutableIntIntMap mutableIntIntMap2 = this.idToAfterMap;
                mutableIntIntMap2.clear();
                AdjustedSemanticsNode adjustedSemanticsNode = (AdjustedSemanticsNode) mutableIntObjectMap.get(-1);
                SemanticsNode semanticsNode = adjustedSemanticsNode != null ? adjustedSemanticsNode.semanticsNode : null;
                semanticsNode.getClass();
                ArrayList arrayListSubtreeSortedByGeometryGrouping = SemanticsSortKt.subtreeSortedByGeometryGrouping(semanticsNode, new TextKt$$ExternalSyntheticLambda2((byte) 28, mutableIntObjectMap), new ZIndexNode$$ExternalSyntheticLambda0((Object) resources, (Object) mutableIntObjectMap, (byte) 27), CollectionsKt__IterablesKt.listOf(semanticsNode));
                int i = 1;
                int size = arrayListSubtreeSortedByGeometryGrouping.size() - 1;
                if (1 <= size) {
                    while (true) {
                        int i2 = ((SemanticsNode) arrayListSubtreeSortedByGeometryGrouping.get(i - 1)).id;
                        int i3 = ((SemanticsNode) arrayListSubtreeSortedByGeometryGrouping.get(i)).id;
                        mutableIntIntMap.set(i2, i3);
                        mutableIntIntMap2.set(i3, i2);
                        if (i == size) {
                            break;
                        }
                        i++;
                    }
                }
            }
        }
        return this.currentSemanticsNodes;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0075 A[LOOP:0: B:4:0x0016->B:36:0x0075, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:47:0x0078 A[EDGE_INSN: B:47:0x0078->B:37:0x0078 BREAK  A[LOOP:0: B:4:0x0016->B:36:0x0075], SYNTHETIC] */
    public final androidx.compose.ui.geometry.Rect getShapeBounds(SemanticsNode semanticsNode, Rect rect, Shape shape) {
        AndroidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1 androidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1 = new AndroidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1(shape);
        LayoutNode layoutNode = semanticsNode.layoutNode;
        Modifier.Node node = (Modifier.Node) layoutNode.nodes.head;
        DelegatableNode delegatableNode = null;
        if ((node.aggregateChildKindSet & 8) != 0) {
            loop0: while (node != null) {
                if ((node.kindSet & 8) == 0) {
                    if ((node.aggregateChildKindSet & 8) != 0) {
                        break;
                        break;
                    }
                    node = node.child;
                } else {
                    Modifier.Node nodePop = node;
                    MutableVector mutableVector = null;
                    while (nodePop != null) {
                        if (nodePop instanceof SemanticsModifierNode) {
                            ((SemanticsModifierNode) nodePop).applySemantics(androidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1);
                            if (androidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1.hasMatchedShape) {
                                delegatableNode = nodePop;
                                break loop0;
                            }
                        } else if ((nodePop.kindSet & 8) != 0 && (nodePop instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node node2 = ((DelegatingNode) nodePop).delegate; node2 != null; node2 = node2.child) {
                                if ((node2.kindSet & 8) != 0) {
                                    i++;
                                    if (i == 1) {
                                        nodePop = node2;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (nodePop != null) {
                                            mutableVector.add(nodePop);
                                            nodePop = null;
                                        }
                                        mutableVector.add(node2);
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        nodePop = HitTestResultKt.pop(mutableVector);
                    }
                    if ((node.aggregateChildKindSet & 8) != 0) {
                        break;
                    }
                    node = node.child;
                }
            }
        }
        DelegatableNode delegatableNode2 = (SemanticsModifierNode) delegatableNode;
        if (delegatableNode2 == null || !((Modifier.Node) delegatableNode2).node.isAttached) {
            return RulerKt.boundsInWindow((NodeCoordinator) layoutNode.nodes.outerCoordinator, false);
        }
        NodeCoordinator nodeCoordinatorRequireLayoutCoordinates = HitTestResultKt.requireLayoutCoordinates(delegatableNode2);
        androidx.compose.ui.geometry.Rect rectLocalBoundingBoxOf = RulerKt.findRootCoordinates(nodeCoordinatorRequireLayoutCoordinates).localBoundingBoxOf(nodeCoordinatorRequireLayoutCoordinates, false);
        Rect boundsInScreen = toBoundsInScreen(rectLocalBoundingBoxOf.left, rectLocalBoundingBoxOf.top, rectLocalBoundingBoxOf.right, rectLocalBoundingBoxOf.bottom);
        float f = boundsInScreen.left - rect.left;
        float f2 = boundsInScreen.top - rect.top;
        return new androidx.compose.ui.geometry.Rect(f, f2, boundsInScreen.width() + f, boundsInScreen.height() + f2);
    }

    public final boolean isAccessibilityEnabled() {
        ComposeViewContext composeViewContext = this.view.getComposeViewContext();
        return composeViewContext._isAccessibilityEnabled && composeViewContext.accessibilityManager.accessibilityManager.isEnabled();
    }

    public final boolean isEnabled$ui() {
        if (!isAccessibilityEnabled()) {
            return false;
        }
        ComposeViewContext composeViewContext = this.view.getComposeViewContext();
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = composeViewContext._enabledServices;
        if (enabledAccessibilityServiceList == null) {
            enabledAccessibilityServiceList = composeViewContext.accessibilityManager.accessibilityManager.getEnabledAccessibilityServiceList(-1);
            composeViewContext._enabledServices = enabledAccessibilityServiceList;
        }
        return !enabledAccessibilityServiceList.isEmpty();
    }

    public final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.mo1712trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        Handler handler = this.view.getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.semanticsChangeChecker);
        }
    }

    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int i) {
        if (i == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().id) {
            return -1;
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0086 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0088 A[LOOP:1: B:15:0x004c->B:28:0x0088, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:44:0x008b A[EDGE_INSN: B:44:0x008b->B:29:0x008b BREAK  A[LOOP:1: B:15:0x004c->B:28:0x0088], SYNTHETIC] */
    public final void sendAccessibilitySemanticsStructureChangeEvents(SemanticsNode semanticsNode, SemanticsNodeCopy semanticsNodeCopy) {
        int[] iArr = IntSetKt.EmptyIntArray;
        MutableIntSet mutableIntSet = new MutableIntSet();
        List children$ui = semanticsNode.getChildren$ui((4 & 1) != 0 ? !semanticsNode.mergingEnabled : false, (4 & 2) == 0);
        LayoutNode layoutNode = semanticsNode.layoutNode;
        int size = children$ui.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode2 = (SemanticsNode) children$ui.get(i);
            IntObjectMap currentSemanticsNodes = getCurrentSemanticsNodes();
            int i2 = semanticsNode2.id;
            if (currentSemanticsNodes.containsKey(i2)) {
                if (!semanticsNodeCopy.children.contains(i2)) {
                    notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
                    return;
                }
                mutableIntSet.add(i2);
            }
        }
        MutableIntSet mutableIntSet2 = semanticsNodeCopy.children;
        int[] iArr2 = mutableIntSet2.elements;
        long[] jArr = mutableIntSet2.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i3 = 0;
            while (true) {
                long j = jArr[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i3 != length) {
                        break;
                        break;
                    }
                    i3++;
                } else {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128 && !mutableIntSet.contains(iArr2[(i3 << 3) + i5])) {
                            notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
                            return;
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        break;
                    } else if (i3 != length) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        List children$ui2 = semanticsNode.getChildren$ui((4 & 1) != 0 ? !semanticsNode.mergingEnabled : false, (4 & 2) == 0);
        int size2 = children$ui2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            SemanticsNode semanticsNode3 = (SemanticsNode) children$ui2.get(i6);
            SemanticsNodeCopy semanticsNodeCopy2 = (SemanticsNodeCopy) this.previousSemanticsNodes.get(semanticsNode3.id);
            if (semanticsNodeCopy2 != null && getCurrentSemanticsNodes().containsKey(semanticsNode3.id)) {
                sendAccessibilitySemanticsStructureChangeEvents(semanticsNode3, semanticsNodeCopy2);
            }
        }
    }

    public final boolean sendEvent(AccessibilityEvent accessibilityEvent) {
        if (!isEnabled$ui()) {
            return false;
        }
        if (accessibilityEvent.getEventType() == 2048 || accessibilityEvent.getEventType() == 32768) {
            this.sendingFocusAffectingEvent = true;
        }
        try {
            return ((Boolean) this.onSendAccessibilityEvent.invoke(accessibilityEvent)).booleanValue();
        } finally {
            this.sendingFocusAffectingEvent = false;
        }
    }

    public final boolean sendEventForVirtualView(int i, int i2, Integer num, List list) {
        if (i == Integer.MIN_VALUE || !isEnabled$ui()) {
            return false;
        }
        AccessibilityEvent accessibilityEventCreateEvent = createEvent(i, i2);
        if (num != null) {
            accessibilityEventCreateEvent.setContentChangeTypes(num.intValue());
        }
        if (list != null) {
            accessibilityEventCreateEvent.setContentDescription(ListUtilsKt.fastJoinToString$default(list, ",", null, 62));
        }
        return sendEvent(accessibilityEventCreateEvent);
    }

    public final void sendPaneChangeEvents(int i, int i2, String str) {
        AccessibilityEvent accessibilityEventCreateEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i), 32);
        accessibilityEventCreateEvent.setContentChangeTypes(i2);
        if (str != null) {
            accessibilityEventCreateEvent.getText().add(str);
        }
        sendEvent(accessibilityEventCreateEvent);
    }

    public final void sendPendingTextTraversedAtGranularityEvent(int i) {
        PendingTextTraversedEvent pendingTextTraversedEvent = this.pendingTextTraversedEvent;
        if (pendingTextTraversedEvent != null) {
            SemanticsNode semanticsNode = pendingTextTraversedEvent.node;
            if (i != semanticsNode.id) {
                return;
            }
            if (SystemClock.uptimeMillis() - pendingTextTraversedEvent.traverseTime <= 1000) {
                AccessibilityEvent accessibilityEventCreateEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.id), 131072);
                accessibilityEventCreateEvent.setFromIndex(pendingTextTraversedEvent.fromIndex);
                accessibilityEventCreateEvent.setToIndex(pendingTextTraversedEvent.toIndex);
                accessibilityEventCreateEvent.setAction(pendingTextTraversedEvent.action);
                accessibilityEventCreateEvent.setMovementGranularity(pendingTextTraversedEvent.granularity);
                accessibilityEventCreateEvent.getText().add(getIterableTextForAccessibility(semanticsNode));
                sendEvent(accessibilityEventCreateEvent);
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0253  */
    /* JADX WARN: Code duplicated, block: B:102:0x0260  */
    /* JADX WARN: Code duplicated, block: B:106:0x028e  */
    /* JADX WARN: Code duplicated, block: B:108:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:109:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:111:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:113:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:115:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:119:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:122:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:126:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:129:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:130:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:134:0x0301  */
    /* JADX WARN: Code duplicated, block: B:137:0x030e A[LOOP:4: B:132:0x02fd->B:137:0x030e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:142:0x031c  */
    /* JADX WARN: Code duplicated, block: B:145:0x0330 A[LOOP:5: B:140:0x0318->B:145:0x0330, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:152:0x0356  */
    /* JADX WARN: Code duplicated, block: B:157:0x0360  */
    /* JADX WARN: Code duplicated, block: B:162:0x0388  */
    /* JADX WARN: Code duplicated, block: B:165:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:169:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:171:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:172:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:174:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:176:0x03f5  */
    /* JADX WARN: Code duplicated, block: B:185:0x043d  */
    /* JADX WARN: Code duplicated, block: B:253:0x0529  */
    /* JADX WARN: Code duplicated, block: B:256:0x053c A[LOOP:6: B:252:0x0527->B:256:0x053c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:260:0x054d  */
    /* JADX WARN: Code duplicated, block: B:263:0x055a  */
    /* JADX WARN: Code duplicated, block: B:266:0x0567 A[PHI: r0 r4 r7 r8 r9 r13 r14 r15 r37 r40 r52
      0x0567: PHI (r0v19 androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat) = 
      (r0v10 androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat)
      (r0v14 androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat)
      (r0v10 androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat)
     binds: [B:265:0x0565, B:184:0x0439, B:105:0x0288] A[DONT_GENERATE, DONT_INLINE]
      0x0567: PHI (r4v47 java.util.ArrayList) = (r4v25 java.util.ArrayList), (r4v34 java.util.ArrayList), (r4v48 java.util.ArrayList) binds: [B:265:0x0565, B:184:0x0439, B:105:0x0288] A[DONT_GENERATE, DONT_INLINE]
      0x0567: PHI (r7v32 int) = (r7v15 int), (r7v15 int), (r7v33 int) binds: [B:265:0x0565, B:184:0x0439, B:105:0x0288] A[DONT_GENERATE, DONT_INLINE]
      0x0567: PHI (r8v32 java.lang.Integer) = (r8v25 java.lang.Integer), (r8v26 java.lang.Integer), (r8v33 java.lang.Integer) binds: [B:265:0x0565, B:184:0x0439, B:105:0x0288] A[DONT_GENERATE, DONT_INLINE]
      0x0567: PHI (r9v34 int) = (r9v18 int), (r9v18 int), (r9v35 int) binds: [B:265:0x0565, B:184:0x0439, B:105:0x0288] A[DONT_GENERATE, DONT_INLINE]
      0x0567: PHI (r13v42 androidx.compose.ui.semantics.SemanticsNode) = 
      (r13v41 androidx.compose.ui.semantics.SemanticsNode)
      (r13v41 androidx.compose.ui.semantics.SemanticsNode)
      (r13v43 androidx.compose.ui.semantics.SemanticsNode)
     binds: [B:265:0x0565, B:184:0x0439, B:105:0x0288] A[DONT_GENERATE, DONT_INLINE]
      0x0567: PHI (r14v40 androidx.collection.MutableScatterMap) = 
      (r14v29 androidx.collection.MutableScatterMap)
      (r14v29 androidx.collection.MutableScatterMap)
      (r14v41 androidx.collection.MutableScatterMap)
     binds: [B:265:0x0565, B:184:0x0439, B:105:0x0288] A[DONT_GENERATE, DONT_INLINE]
      0x0567: PHI (r15v38 androidx.compose.ui.node.LayoutNode) = 
      (r15v37 androidx.compose.ui.node.LayoutNode)
      (r15v37 androidx.compose.ui.node.LayoutNode)
      (r15v39 androidx.compose.ui.node.LayoutNode)
     binds: [B:265:0x0565, B:184:0x0439, B:105:0x0288] A[DONT_GENERATE, DONT_INLINE]
      0x0567: PHI (r37v13 boolean) = (r37v7 boolean), (r37v12 boolean), (r37v7 boolean) binds: [B:265:0x0565, B:184:0x0439, B:105:0x0288] A[DONT_GENERATE, DONT_INLINE]
      0x0567: PHI (r40v6 int) = (r40v5 int), (r40v5 int), (r40v7 int) binds: [B:265:0x0565, B:184:0x0439, B:105:0x0288] A[DONT_GENERATE, DONT_INLINE]
      0x0567: PHI (r52v17 java.lang.Integer) = (r52v13 java.lang.Integer), (r52v13 java.lang.Integer), (r52v18 java.lang.Integer) binds: [B:265:0x0565, B:184:0x0439, B:105:0x0288] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:267:0x0569  */
    /* JADX WARN: Code duplicated, block: B:293:0x0641  */
    /* JADX WARN: Code duplicated, block: B:315:0x0315 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:316:0x0317 A[EDGE_INSN: B:316:0x0317->B:139:0x0317 BREAK  A[LOOP:4: B:132:0x02fd->B:137:0x030e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:317:0x0333 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:318:0x0335 A[EDGE_INSN: B:318:0x0335->B:147:0x0335 BREAK  A[LOOP:5: B:140:0x0318->B:145:0x0330], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:319:0x0541 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:320:0x0535 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0137  */
    /* JADX WARN: Code duplicated, block: B:54:0x013f  */
    /* JADX WARN: Code duplicated, block: B:56:0x014c  */
    /* JADX WARN: Code duplicated, block: B:57:0x0150  */
    /* JADX WARN: Code duplicated, block: B:59:0x015a  */
    /* JADX WARN: Code duplicated, block: B:60:0x016b  */
    /* JADX WARN: Code duplicated, block: B:62:0x0175  */
    /* JADX WARN: Code duplicated, block: B:63:0x018c  */
    /* JADX WARN: Code duplicated, block: B:65:0x0194  */
    /* JADX WARN: Code duplicated, block: B:66:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:68:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:69:0x01be  */
    /* JADX WARN: Code duplicated, block: B:71:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:73:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:76:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:84:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:86:0x021a  */
    /* JADX WARN: Code duplicated, block: B:89:0x0228  */
    /* JADX WARN: Code duplicated, block: B:92:0x023b  */
    /* JADX WARN: Code duplicated, block: B:95:0x0242  */
    /* JADX WARN: Code duplicated, block: B:96:0x024a  */
    /* JADX WARN: Code duplicated, block: B:98:0x024e  */
    public final void sendSemanticsPropertyChangeEvents(IntObjectMap intObjectMap) {
        Integer num;
        ArrayList arrayList;
        ArrayList arrayList2;
        int[] iArr;
        long[] jArr;
        Integer num2;
        int i;
        int i2;
        Integer num3;
        ArrayList arrayList3;
        ArrayList arrayList4;
        int[] iArr2;
        long[] jArr2;
        int i3;
        int i4;
        Integer num4;
        int i5;
        SemanticsConfiguration semanticsConfiguration;
        SemanticsNode semanticsNode;
        boolean z;
        int i6;
        boolean z2;
        boolean z3;
        MutableScatterMap mutableScatterMap;
        LayoutNode layoutNode;
        int i7;
        SemanticsConfiguration semanticsConfiguration2;
        long j;
        int i8;
        int i9;
        int i10;
        Integer num5;
        ScrollObservationScope scrollObservationScope;
        boolean z4;
        SemanticsPropertyKey semanticsPropertyKey;
        int i11;
        SemanticsPropertyKey semanticsPropertyKey2;
        ArrayList arrayList5;
        SemanticsPropertyKey semanticsPropertyKey3;
        String str;
        SemanticsPropertyKey semanticsPropertyKey4;
        int size;
        int i12;
        ScrollObservationScope scrollObservationScope2;
        Object obj;
        Object obj2;
        Function function;
        boolean z5;
        int i13;
        Object obj3;
        AnnotatedString annotatedString;
        String str2;
        Object obj4;
        AnnotatedString annotatedString2;
        Object obj5;
        CharSequence charSequence;
        CharSequence charSequenceTrimToSize;
        int length;
        int length2;
        int i14;
        Integer num6;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean zContainsKey;
        boolean z6;
        boolean z7;
        AccessibilityEvent accessibilityEventCreateTextSelectionChangedEvent;
        Object obj6;
        Role role;
        Object obj7;
        AccessibilityEvent accessibilityEventCreateEvent;
        Object obj8;
        String strFastJoinToString$default;
        Object obj9;
        List list;
        String strFastJoinToString$default2;
        String str3;
        boolean zContainsKey2;
        int i19;
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this;
        IntObjectMap intObjectMap2 = intObjectMap;
        Integer num7 = 64;
        ArrayList arrayList6 = androidComposeViewAccessibilityDelegateCompat.scrollObservationScopes;
        ArrayList arrayList7 = new ArrayList(arrayList6);
        arrayList6.clear();
        int[] iArr3 = intObjectMap2.keys;
        long[] jArr3 = intObjectMap2.metadata;
        int i20 = 2;
        int length3 = jArr3.length - 2;
        int i21 = 0;
        Integer num8 = 0;
        if (length3 < 0) {
            return;
        }
        int i22 = 0;
        while (true) {
            long j2 = jArr3[i22];
            int i23 = i20;
            int i24 = length3;
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i25 = 8;
                int i26 = 8 - ((~(i22 - i24)) >>> 31);
                long j3 = j2;
                int i27 = i21;
                while (i27 < i26) {
                    if ((j3 & 255) < 128) {
                        int i28 = iArr3[(i22 << 3) + i27];
                        SemanticsNodeCopy semanticsNodeCopy = (SemanticsNodeCopy) androidComposeViewAccessibilityDelegateCompat.previousSemanticsNodes.get(i28);
                        if (semanticsNodeCopy == null) {
                            i2 = i27;
                            num3 = num7;
                            arrayList3 = arrayList7;
                            arrayList4 = arrayList6;
                            iArr2 = iArr3;
                            jArr2 = jArr3;
                            i3 = i26;
                            i4 = i22;
                            num4 = num8;
                            i5 = i25;
                        } else {
                            SemanticsConfiguration semanticsConfiguration3 = semanticsNodeCopy.unmergedConfig;
                            MutableScatterMap mutableScatterMap2 = semanticsConfiguration3.props;
                            AdjustedSemanticsNode adjustedSemanticsNode = (AdjustedSemanticsNode) intObjectMap2.get(i28);
                            int i29 = i25;
                            SemanticsNode semanticsNode2 = adjustedSemanticsNode != null ? adjustedSemanticsNode.semanticsNode : null;
                            if (semanticsNode2 == null) {
                                throw Fragment$5$$ExternalSyntheticOutline0.m$2("no value for specified key");
                            }
                            LayoutNode layoutNode2 = semanticsNode2.layoutNode;
                            SemanticsConfiguration semanticsConfiguration4 = semanticsNode2.unmergedConfig;
                            iArr2 = iArr3;
                            int i30 = semanticsNode2.id;
                            jArr2 = jArr3;
                            MutableScatterMap mutableScatterMap3 = semanticsConfiguration4.props;
                            i4 = i22;
                            Object[] objArr = mutableScatterMap3.keys;
                            Object[] objArr2 = mutableScatterMap3.values;
                            long[] jArr4 = mutableScatterMap3.metadata;
                            i2 = i27;
                            int length4 = jArr4.length - 2;
                            if (length4 >= 0) {
                                LayoutNode layoutNode3 = layoutNode2;
                                i3 = i26;
                                int i31 = 0;
                                z2 = false;
                                while (true) {
                                    long j4 = jArr4[i31];
                                    SemanticsNode semanticsNode3 = semanticsNode2;
                                    int i32 = i31;
                                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i33 = 8 - ((~(i32 - length4)) >>> 31);
                                        int i34 = 0;
                                        while (i34 < i33) {
                                            if ((j4 & 255) < 128) {
                                                int i35 = (i32 << 3) + i34;
                                                Object obj10 = objArr[i35];
                                                int i36 = length4;
                                                Object obj11 = objArr2[i35];
                                                semanticsConfiguration2 = semanticsConfiguration3;
                                                SemanticsPropertyKey semanticsPropertyKey5 = (SemanticsPropertyKey) obj10;
                                                j = j4;
                                                SemanticsPropertyKey semanticsPropertyKey6 = SemanticsProperties.HorizontalScrollAxisRange;
                                                if (Intrinsics.areEqual(semanticsPropertyKey5, semanticsPropertyKey6) || Intrinsics.areEqual(semanticsPropertyKey5, SemanticsProperties.VerticalScrollAxisRange)) {
                                                    int size2 = arrayList7.size();
                                                    int i37 = 0;
                                                    while (true) {
                                                        if (i37 >= size2) {
                                                            scrollObservationScope = null;
                                                            break;
                                                        }
                                                        int i38 = size2;
                                                        if (((ScrollObservationScope) arrayList7.get(i37)).semanticsNodeId == i28) {
                                                            scrollObservationScope = (ScrollObservationScope) arrayList7.get(i37);
                                                            break;
                                                        } else {
                                                            i37++;
                                                            size2 = i38;
                                                        }
                                                    }
                                                    if (scrollObservationScope != null) {
                                                        z4 = false;
                                                    } else {
                                                        scrollObservationScope = new ScrollObservationScope(i28, arrayList6);
                                                        z4 = true;
                                                    }
                                                    arrayList6.add(scrollObservationScope);
                                                } else {
                                                    z4 = false;
                                                }
                                                if (z4) {
                                                    semanticsPropertyKey = SemanticsProperties.PaneTitle;
                                                    if (Intrinsics.areEqual(semanticsPropertyKey5, semanticsPropertyKey)) {
                                                        obj11.getClass();
                                                        str3 = (String) obj11;
                                                        zContainsKey2 = mutableScatterMap2.containsKey(semanticsPropertyKey);
                                                        i19 = i29;
                                                        if (zContainsKey2) {
                                                            androidComposeViewAccessibilityDelegateCompat.sendPaneChangeEvents(i28, i19, str3);
                                                        }
                                                    } else {
                                                        i11 = i29;
                                                        if (Intrinsics.areEqual(semanticsPropertyKey5, SemanticsProperties.StateDescription)) {
                                                            sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, num7, i11);
                                                            sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, num8, i11);
                                                        } else if (Intrinsics.areEqual(semanticsPropertyKey5, SemanticsProperties.ToggleableState)) {
                                                            sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, 8192, 8);
                                                            sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, num8, 8);
                                                        } else if (Intrinsics.areEqual(semanticsPropertyKey5, SemanticsProperties.Error)) {
                                                            sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, 3072, 8);
                                                        } else if (Intrinsics.areEqual(semanticsPropertyKey5, SemanticsProperties.ProgressBarRangeInfo)) {
                                                            sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, num7, 8);
                                                            sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, num8, 8);
                                                        } else {
                                                            semanticsPropertyKey2 = SemanticsProperties.Selected;
                                                            arrayList7 = arrayList7;
                                                            if (Intrinsics.areEqual(semanticsPropertyKey5, semanticsPropertyKey2)) {
                                                                obj6 = mutableScatterMap3.get(SemanticsProperties.Role);
                                                                if (obj6 == null) {
                                                                    obj6 = null;
                                                                }
                                                                role = (Role) obj6;
                                                                if (role == null && role.value == 4) {
                                                                    obj7 = mutableScatterMap3.get(semanticsPropertyKey2);
                                                                    if (obj7 == null) {
                                                                        obj7 = null;
                                                                    }
                                                                    if (Intrinsics.areEqual(obj7, Boolean.TRUE)) {
                                                                        accessibilityEventCreateEvent = androidComposeViewAccessibilityDelegateCompat.createEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 4);
                                                                        semanticsNode3 = semanticsNode3;
                                                                        layoutNode3 = layoutNode3;
                                                                        SemanticsNode semanticsNode4 = new SemanticsNode(semanticsNode3.outerSemanticsNode, true, layoutNode3, semanticsConfiguration4);
                                                                        obj8 = semanticsNode4.getConfig().props.get(SemanticsProperties.ContentDescription);
                                                                        if (obj8 == null) {
                                                                            obj8 = null;
                                                                        }
                                                                        List list2 = (List) obj8;
                                                                        i9 = i33;
                                                                        strFastJoinToString$default = list2 != null ? ListUtilsKt.fastJoinToString$default(list2, ",", null, 62) : null;
                                                                        obj9 = semanticsNode4.getConfig().props.get(SemanticsProperties.Text);
                                                                        if (obj9 == null) {
                                                                            obj9 = null;
                                                                        }
                                                                        list = (List) obj9;
                                                                        arrayList5 = arrayList6;
                                                                        if (list != null) {
                                                                            strFastJoinToString$default2 = ListUtilsKt.fastJoinToString$default(list, ",", null, 62);
                                                                        } else {
                                                                            strFastJoinToString$default2 = null;
                                                                        }
                                                                        if (strFastJoinToString$default != null) {
                                                                            accessibilityEventCreateEvent.setContentDescription(strFastJoinToString$default);
                                                                        }
                                                                        if (strFastJoinToString$default2 != null) {
                                                                            accessibilityEventCreateEvent.getText().add(strFastJoinToString$default2);
                                                                        }
                                                                        androidComposeViewAccessibilityDelegateCompat.sendEvent(accessibilityEventCreateEvent);
                                                                    } else {
                                                                        arrayList5 = arrayList6;
                                                                        layoutNode3 = layoutNode3;
                                                                        semanticsNode3 = semanticsNode3;
                                                                        i9 = i33;
                                                                        sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, num8, 8);
                                                                    }
                                                                } else {
                                                                    arrayList5 = arrayList6;
                                                                    layoutNode3 = layoutNode3;
                                                                    semanticsNode3 = semanticsNode3;
                                                                    i9 = i33;
                                                                    sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, num7, 8);
                                                                    sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, num8, 8);
                                                                }
                                                            } else {
                                                                arrayList5 = arrayList6;
                                                                layoutNode3 = layoutNode3;
                                                                semanticsNode3 = semanticsNode3;
                                                                i9 = i33;
                                                                if (Intrinsics.areEqual(semanticsPropertyKey5, SemanticsProperties.ContentDescription)) {
                                                                    int iSemanticsNodeIdToAccessibilityVirtualNodeId = androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28);
                                                                    obj11.getClass();
                                                                    androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(iSemanticsNodeIdToAccessibilityVirtualNodeId, 2048, 4, (List) obj11);
                                                                } else {
                                                                    semanticsPropertyKey3 = SemanticsProperties.EditableText;
                                                                    str = "";
                                                                    if (Intrinsics.areEqual(semanticsPropertyKey5, semanticsPropertyKey3)) {
                                                                        if (mutableScatterMap3.containsKey(SemanticsActions.SetText)) {
                                                                            obj4 = mutableScatterMap2.get(semanticsPropertyKey3);
                                                                            if (obj4 == null) {
                                                                                obj4 = null;
                                                                            }
                                                                            annotatedString2 = (AnnotatedString) obj4;
                                                                            if (annotatedString2 == null) {
                                                                                annotatedString2 = "";
                                                                            }
                                                                            obj5 = mutableScatterMap3.get(semanticsPropertyKey3);
                                                                            if (obj5 == null) {
                                                                                obj5 = null;
                                                                            }
                                                                            charSequence = (AnnotatedString) obj5;
                                                                            if (charSequence == null) {
                                                                                charSequence = "";
                                                                            }
                                                                            charSequenceTrimToSize = trimToSize(charSequence);
                                                                            length = annotatedString2.length();
                                                                            length2 = charSequence.length();
                                                                            if (length > length2) {
                                                                                i14 = length2;
                                                                            } else {
                                                                                i14 = length;
                                                                            }
                                                                            num6 = num8;
                                                                            i15 = 0;
                                                                            while (true) {
                                                                                num7 = num7;
                                                                                if (i15 < i14) {
                                                                                    i16 = length;
                                                                                    break;
                                                                                }
                                                                                i16 = length;
                                                                                if (annotatedString2.charAt(i15) != charSequence.charAt(i15)) {
                                                                                    break;
                                                                                }
                                                                                i15++;
                                                                                length = i16;
                                                                                num7 = num7;
                                                                            }
                                                                            i17 = 0;
                                                                            while (true) {
                                                                                if (i17 < i14 - i15) {
                                                                                    i18 = i17;
                                                                                    break;
                                                                                }
                                                                                i18 = i17;
                                                                                if (annotatedString2.charAt((i16 - 1) - i17) != charSequence.charAt((length2 - 1) - i18)) {
                                                                                    break;
                                                                                } else {
                                                                                    i17 = i18 + 1;
                                                                                }
                                                                            }
                                                                            int i39 = (i16 - i18) - i15;
                                                                            int i40 = (length2 - i18) - i15;
                                                                            SemanticsPropertyKey semanticsPropertyKey7 = SemanticsProperties.Password;
                                                                            boolean zContainsKey3 = mutableScatterMap2.containsKey(semanticsPropertyKey7);
                                                                            boolean zContainsKey4 = mutableScatterMap3.containsKey(semanticsPropertyKey7);
                                                                            zContainsKey = mutableScatterMap2.containsKey(SemanticsProperties.EditableText);
                                                                            if (zContainsKey || zContainsKey3 || !zContainsKey4) {
                                                                                z6 = false;
                                                                            } else {
                                                                                z6 = true;
                                                                            }
                                                                            if (zContainsKey || !zContainsKey3 || zContainsKey4) {
                                                                                z7 = false;
                                                                            } else {
                                                                                z7 = true;
                                                                            }
                                                                            if (!z6 || z7) {
                                                                                i10 = i28;
                                                                                num8 = num6;
                                                                                accessibilityEventCreateTextSelectionChangedEvent = androidComposeViewAccessibilityDelegateCompat.createTextSelectionChangedEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), num8, num6, Integer.valueOf(length2), charSequenceTrimToSize);
                                                                            } else {
                                                                                accessibilityEventCreateTextSelectionChangedEvent = androidComposeViewAccessibilityDelegateCompat.createEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 16);
                                                                                accessibilityEventCreateTextSelectionChangedEvent.setFromIndex(i15);
                                                                                accessibilityEventCreateTextSelectionChangedEvent.setRemovedCount(i39);
                                                                                accessibilityEventCreateTextSelectionChangedEvent.setAddedCount(i40);
                                                                                accessibilityEventCreateTextSelectionChangedEvent.setBeforeText(annotatedString2);
                                                                                accessibilityEventCreateTextSelectionChangedEvent.getText().add(charSequenceTrimToSize);
                                                                                i10 = i28;
                                                                                num8 = num6;
                                                                            }
                                                                            accessibilityEventCreateTextSelectionChangedEvent.setClassName("android.widget.EditText");
                                                                            if (Build.VERSION.SDK_INT >= 37) {
                                                                                Api37Impl.setInputTextSuggestionTextChangeTypes(semanticsNode3, accessibilityEventCreateTextSelectionChangedEvent);
                                                                            }
                                                                            androidComposeViewAccessibilityDelegateCompat.sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                            if (z6 || z7) {
                                                                                long j5 = ((TextRange) semanticsConfiguration4.get(SemanticsProperties.TextSelectionRange)).packedValue;
                                                                                accessibilityEventCreateTextSelectionChangedEvent.setFromIndex((int) (j5 >> 32));
                                                                                accessibilityEventCreateTextSelectionChangedEvent.setToIndex((int) (j5 & 4294967295L));
                                                                                androidComposeViewAccessibilityDelegateCompat.sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                            }
                                                                        } else {
                                                                            i10 = i28;
                                                                            mutableScatterMap2 = mutableScatterMap2;
                                                                            num7 = num7;
                                                                            sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i10), 2048, Integer.valueOf(i23), 8);
                                                                        }
                                                                        num5 = num8;
                                                                        arrayList6 = arrayList5;
                                                                        i8 = i36;
                                                                    } else {
                                                                        i10 = i28;
                                                                        mutableScatterMap2 = mutableScatterMap2;
                                                                        num7 = num7;
                                                                        i8 = i36;
                                                                        semanticsPropertyKey4 = SemanticsProperties.TextSelectionRange;
                                                                        if (Intrinsics.areEqual(semanticsPropertyKey5, semanticsPropertyKey4)) {
                                                                            obj3 = mutableScatterMap3.get(semanticsPropertyKey3);
                                                                            if (obj3 == null) {
                                                                                obj3 = null;
                                                                            }
                                                                            annotatedString = (AnnotatedString) obj3;
                                                                            if (annotatedString != null && (str2 = annotatedString.text) != null) {
                                                                                str = str2;
                                                                            }
                                                                            long j6 = ((TextRange) semanticsConfiguration4.get(semanticsPropertyKey4)).packedValue;
                                                                            num5 = num8;
                                                                            androidComposeViewAccessibilityDelegateCompat = this;
                                                                            androidComposeViewAccessibilityDelegateCompat.sendEvent(androidComposeViewAccessibilityDelegateCompat.createTextSelectionChangedEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i10), Integer.valueOf((int) (j6 >> 32)), Integer.valueOf((int) (j6 & 4294967295L)), Integer.valueOf(str.length()), trimToSize(str)));
                                                                            androidComposeViewAccessibilityDelegateCompat.sendPendingTextTraversedAtGranularityEvent(i30);
                                                                        } else {
                                                                            num5 = num8;
                                                                            if (!Intrinsics.areEqual(semanticsPropertyKey5, semanticsPropertyKey6) || Intrinsics.areEqual(semanticsPropertyKey5, SemanticsProperties.VerticalScrollAxisRange)) {
                                                                                androidComposeViewAccessibilityDelegateCompat.notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode3);
                                                                                size = arrayList5.size();
                                                                                i12 = 0;
                                                                                while (true) {
                                                                                    if (i12 < size) {
                                                                                        arrayList6 = arrayList5;
                                                                                        scrollObservationScope2 = null;
                                                                                        break;
                                                                                    }
                                                                                    arrayList6 = arrayList5;
                                                                                    if (((ScrollObservationScope) arrayList6.get(i12)).semanticsNodeId == i10) {
                                                                                        scrollObservationScope2 = (ScrollObservationScope) arrayList6.get(i12);
                                                                                        break;
                                                                                    } else {
                                                                                        i12++;
                                                                                        arrayList5 = arrayList6;
                                                                                    }
                                                                                }
                                                                                scrollObservationScope2.getClass();
                                                                                obj = mutableScatterMap3.get(semanticsPropertyKey6);
                                                                                if (obj == null) {
                                                                                    obj = null;
                                                                                }
                                                                                scrollObservationScope2.horizontalScrollAxisRange = (ScrollAxisRange) obj;
                                                                                obj2 = mutableScatterMap3.get(SemanticsProperties.VerticalScrollAxisRange);
                                                                                if (obj2 == null) {
                                                                                    obj2 = null;
                                                                                }
                                                                                scrollObservationScope2.verticalScrollAxisRange = (ScrollAxisRange) obj2;
                                                                                if (!scrollObservationScope2.allScopes.contains(scrollObservationScope2)) {
                                                                                    androidComposeViewAccessibilityDelegateCompat.view.getSnapshotObserver().observer.observeReads(scrollObservationScope2, androidComposeViewAccessibilityDelegateCompat.scheduleScrollEventIfNeededLambda, new ComponentRegistry$Builder$$ExternalSyntheticLambda2((Object) scrollObservationScope2, (Object) androidComposeViewAccessibilityDelegateCompat, (byte) 1));
                                                                                }
                                                                            } else if (Intrinsics.areEqual(semanticsPropertyKey5, SemanticsProperties.Focused)) {
                                                                                obj11.getClass();
                                                                                if (((Boolean) obj11).booleanValue()) {
                                                                                    i13 = 8;
                                                                                    androidComposeViewAccessibilityDelegateCompat.sendEvent(androidComposeViewAccessibilityDelegateCompat.createEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i30), 8));
                                                                                } else {
                                                                                    i13 = 8;
                                                                                }
                                                                                sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i30), 2048, num5, i13);
                                                                            } else {
                                                                                SemanticsPropertyKey semanticsPropertyKey8 = SemanticsActions.CustomActions;
                                                                                if (Intrinsics.areEqual(semanticsPropertyKey5, semanticsPropertyKey8)) {
                                                                                    List list3 = (List) semanticsConfiguration4.get(semanticsPropertyKey8);
                                                                                    Object obj12 = mutableScatterMap2.get(semanticsPropertyKey8);
                                                                                    if (obj12 == null) {
                                                                                        obj12 = null;
                                                                                    }
                                                                                    List list4 = (List) obj12;
                                                                                    if (list4 != null) {
                                                                                        MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
                                                                                        MutableScatterSet mutableScatterSet2 = new MutableScatterSet();
                                                                                        if (list3.size() > 0) {
                                                                                            list3.get(0).getClass();
                                                                                            PathKt$$ExternalSyntheticBUOutline0.m();
                                                                                            return;
                                                                                        }
                                                                                        MutableScatterSet mutableScatterSet3 = new MutableScatterSet();
                                                                                        if (list4.size() > 0) {
                                                                                            list4.get(0).getClass();
                                                                                            PathKt$$ExternalSyntheticBUOutline0.m();
                                                                                            return;
                                                                                        }
                                                                                        z5 = z2 || !mutableScatterSet2.equals(mutableScatterSet3);
                                                                                    } else {
                                                                                        z5 = z2 || !list3.isEmpty();
                                                                                    }
                                                                                    z2 = z5;
                                                                                } else if (z2 || !(obj11 instanceof AccessibilityAction)) {
                                                                                    z2 = true;
                                                                                } else {
                                                                                    AccessibilityAction accessibilityAction = (AccessibilityAction) obj11;
                                                                                    Object obj13 = mutableScatterMap2.get(semanticsPropertyKey5);
                                                                                    if (obj13 == null) {
                                                                                        obj13 = null;
                                                                                    }
                                                                                    if (accessibilityAction != obj13) {
                                                                                        if (obj13 instanceof AccessibilityAction) {
                                                                                            String str4 = accessibilityAction.label;
                                                                                            AccessibilityAction accessibilityAction2 = (AccessibilityAction) obj13;
                                                                                            Function function2 = accessibilityAction2.action;
                                                                                            if (Intrinsics.areEqual(str4, accessibilityAction2.label) && (((function = accessibilityAction.action) != null || function2 == null) && (function == null || function2 != null))) {
                                                                                            }
                                                                                        }
                                                                                        z2 = true;
                                                                                    }
                                                                                    z2 = false;
                                                                                }
                                                                            }
                                                                        }
                                                                        arrayList6 = arrayList5;
                                                                    }
                                                                }
                                                            }
                                                            num5 = num8;
                                                            i10 = i28;
                                                            mutableScatterMap2 = mutableScatterMap2;
                                                            num7 = num7;
                                                            arrayList6 = arrayList5;
                                                            i8 = i36;
                                                        }
                                                    }
                                                    i8 = i36;
                                                } else {
                                                    Object obj14 = mutableScatterMap2.get(semanticsPropertyKey5);
                                                    if (obj14 == null) {
                                                        obj14 = null;
                                                    }
                                                    if (!Intrinsics.areEqual(obj11, obj14)) {
                                                        semanticsPropertyKey = SemanticsProperties.PaneTitle;
                                                        if (Intrinsics.areEqual(semanticsPropertyKey5, semanticsPropertyKey)) {
                                                            obj11.getClass();
                                                            str3 = (String) obj11;
                                                            zContainsKey2 = mutableScatterMap2.containsKey(semanticsPropertyKey);
                                                            i19 = i29;
                                                            if (zContainsKey2) {
                                                                androidComposeViewAccessibilityDelegateCompat.sendPaneChangeEvents(i28, i19, str3);
                                                            }
                                                        } else {
                                                            i11 = i29;
                                                            if (Intrinsics.areEqual(semanticsPropertyKey5, SemanticsProperties.StateDescription)) {
                                                                sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, num7, i11);
                                                                sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, num8, i11);
                                                            } else if (Intrinsics.areEqual(semanticsPropertyKey5, SemanticsProperties.ToggleableState)) {
                                                                sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, 8192, 8);
                                                                sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, num8, 8);
                                                            } else if (Intrinsics.areEqual(semanticsPropertyKey5, SemanticsProperties.Error)) {
                                                                sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, 3072, 8);
                                                            } else if (Intrinsics.areEqual(semanticsPropertyKey5, SemanticsProperties.ProgressBarRangeInfo)) {
                                                                sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, num7, 8);
                                                                sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, num8, 8);
                                                            } else {
                                                                semanticsPropertyKey2 = SemanticsProperties.Selected;
                                                                arrayList7 = arrayList7;
                                                                if (Intrinsics.areEqual(semanticsPropertyKey5, semanticsPropertyKey2)) {
                                                                    obj6 = mutableScatterMap3.get(SemanticsProperties.Role);
                                                                    if (obj6 == null) {
                                                                        obj6 = null;
                                                                    }
                                                                    role = (Role) obj6;
                                                                    if (role == null) {
                                                                        arrayList5 = arrayList6;
                                                                        layoutNode3 = layoutNode3;
                                                                        semanticsNode3 = semanticsNode3;
                                                                        i9 = i33;
                                                                        sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, num7, 8);
                                                                        sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, num8, 8);
                                                                    } else {
                                                                        obj7 = mutableScatterMap3.get(semanticsPropertyKey2);
                                                                        if (obj7 == null) {
                                                                            obj7 = null;
                                                                        }
                                                                        if (Intrinsics.areEqual(obj7, Boolean.TRUE)) {
                                                                            accessibilityEventCreateEvent = androidComposeViewAccessibilityDelegateCompat.createEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 4);
                                                                            semanticsNode3 = semanticsNode3;
                                                                            layoutNode3 = layoutNode3;
                                                                            SemanticsNode semanticsNode5 = new SemanticsNode(semanticsNode3.outerSemanticsNode, true, layoutNode3, semanticsConfiguration4);
                                                                            obj8 = semanticsNode5.getConfig().props.get(SemanticsProperties.ContentDescription);
                                                                            if (obj8 == null) {
                                                                                obj8 = null;
                                                                            }
                                                                            List list5 = (List) obj8;
                                                                            i9 = i33;
                                                                            if (list5 != null) {
                                                                            }
                                                                            obj9 = semanticsNode5.getConfig().props.get(SemanticsProperties.Text);
                                                                            if (obj9 == null) {
                                                                                obj9 = null;
                                                                            }
                                                                            list = (List) obj9;
                                                                            arrayList5 = arrayList6;
                                                                            if (list != null) {
                                                                                strFastJoinToString$default2 = ListUtilsKt.fastJoinToString$default(list, ",", null, 62);
                                                                            } else {
                                                                                strFastJoinToString$default2 = null;
                                                                            }
                                                                            if (strFastJoinToString$default != null) {
                                                                                accessibilityEventCreateEvent.setContentDescription(strFastJoinToString$default);
                                                                            }
                                                                            if (strFastJoinToString$default2 != null) {
                                                                                accessibilityEventCreateEvent.getText().add(strFastJoinToString$default2);
                                                                            }
                                                                            androidComposeViewAccessibilityDelegateCompat.sendEvent(accessibilityEventCreateEvent);
                                                                        } else {
                                                                            arrayList5 = arrayList6;
                                                                            layoutNode3 = layoutNode3;
                                                                            semanticsNode3 = semanticsNode3;
                                                                            i9 = i33;
                                                                            sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), 2048, num8, 8);
                                                                        }
                                                                    }
                                                                } else {
                                                                    arrayList5 = arrayList6;
                                                                    layoutNode3 = layoutNode3;
                                                                    semanticsNode3 = semanticsNode3;
                                                                    i9 = i33;
                                                                    if (Intrinsics.areEqual(semanticsPropertyKey5, SemanticsProperties.ContentDescription)) {
                                                                        int iSemanticsNodeIdToAccessibilityVirtualNodeId2 = androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28);
                                                                        obj11.getClass();
                                                                        androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(iSemanticsNodeIdToAccessibilityVirtualNodeId2, 2048, 4, (List) obj11);
                                                                    } else {
                                                                        semanticsPropertyKey3 = SemanticsProperties.EditableText;
                                                                        str = "";
                                                                        if (Intrinsics.areEqual(semanticsPropertyKey5, semanticsPropertyKey3)) {
                                                                            if (mutableScatterMap3.containsKey(SemanticsActions.SetText)) {
                                                                                obj4 = mutableScatterMap2.get(semanticsPropertyKey3);
                                                                                if (obj4 == null) {
                                                                                    obj4 = null;
                                                                                }
                                                                                annotatedString2 = (AnnotatedString) obj4;
                                                                                if (annotatedString2 == null) {
                                                                                    annotatedString2 = "";
                                                                                }
                                                                                obj5 = mutableScatterMap3.get(semanticsPropertyKey3);
                                                                                if (obj5 == null) {
                                                                                    obj5 = null;
                                                                                }
                                                                                charSequence = (AnnotatedString) obj5;
                                                                                if (charSequence == null) {
                                                                                    charSequence = "";
                                                                                }
                                                                                charSequenceTrimToSize = trimToSize(charSequence);
                                                                                length = annotatedString2.length();
                                                                                length2 = charSequence.length();
                                                                                if (length > length2) {
                                                                                    i14 = length2;
                                                                                } else {
                                                                                    i14 = length;
                                                                                }
                                                                                num6 = num8;
                                                                                i15 = 0;
                                                                                while (true) {
                                                                                    num7 = num7;
                                                                                    if (i15 < i14) {
                                                                                        i16 = length;
                                                                                        break;
                                                                                    }
                                                                                    i16 = length;
                                                                                    if (annotatedString2.charAt(i15) != charSequence.charAt(i15)) {
                                                                                        break;
                                                                                        break;
                                                                                    } else {
                                                                                        i15++;
                                                                                        length = i16;
                                                                                        num7 = num7;
                                                                                    }
                                                                                }
                                                                                i17 = 0;
                                                                                while (true) {
                                                                                    if (i17 < i14 - i15) {
                                                                                        i18 = i17;
                                                                                        break;
                                                                                    }
                                                                                    i18 = i17;
                                                                                    if (annotatedString2.charAt((i16 - 1) - i17) != charSequence.charAt((length2 - 1) - i18)) {
                                                                                        break;
                                                                                        break;
                                                                                    }
                                                                                    i17 = i18 + 1;
                                                                                }
                                                                                int i310 = (i16 - i18) - i15;
                                                                                int i41 = (length2 - i18) - i15;
                                                                                SemanticsPropertyKey semanticsPropertyKey9 = SemanticsProperties.Password;
                                                                                boolean zContainsKey5 = mutableScatterMap2.containsKey(semanticsPropertyKey9);
                                                                                boolean zContainsKey6 = mutableScatterMap3.containsKey(semanticsPropertyKey9);
                                                                                zContainsKey = mutableScatterMap2.containsKey(SemanticsProperties.EditableText);
                                                                                if (zContainsKey) {
                                                                                    z6 = false;
                                                                                } else {
                                                                                    z6 = false;
                                                                                }
                                                                                if (zContainsKey) {
                                                                                    z7 = false;
                                                                                } else {
                                                                                    z7 = false;
                                                                                }
                                                                                if (z6) {
                                                                                    i10 = i28;
                                                                                    num8 = num6;
                                                                                    accessibilityEventCreateTextSelectionChangedEvent = androidComposeViewAccessibilityDelegateCompat.createTextSelectionChangedEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), num8, num6, Integer.valueOf(length2), charSequenceTrimToSize);
                                                                                } else {
                                                                                    i10 = i28;
                                                                                    num8 = num6;
                                                                                    accessibilityEventCreateTextSelectionChangedEvent = androidComposeViewAccessibilityDelegateCompat.createTextSelectionChangedEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i28), num8, num6, Integer.valueOf(length2), charSequenceTrimToSize);
                                                                                }
                                                                                accessibilityEventCreateTextSelectionChangedEvent.setClassName("android.widget.EditText");
                                                                                if (Build.VERSION.SDK_INT >= 37) {
                                                                                    Api37Impl.setInputTextSuggestionTextChangeTypes(semanticsNode3, accessibilityEventCreateTextSelectionChangedEvent);
                                                                                }
                                                                                androidComposeViewAccessibilityDelegateCompat.sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                                if (z6) {
                                                                                    long j7 = ((TextRange) semanticsConfiguration4.get(SemanticsProperties.TextSelectionRange)).packedValue;
                                                                                    accessibilityEventCreateTextSelectionChangedEvent.setFromIndex((int) (j7 >> 32));
                                                                                    accessibilityEventCreateTextSelectionChangedEvent.setToIndex((int) (j7 & 4294967295L));
                                                                                    androidComposeViewAccessibilityDelegateCompat.sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                                } else {
                                                                                    long j8 = ((TextRange) semanticsConfiguration4.get(SemanticsProperties.TextSelectionRange)).packedValue;
                                                                                    accessibilityEventCreateTextSelectionChangedEvent.setFromIndex((int) (j8 >> 32));
                                                                                    accessibilityEventCreateTextSelectionChangedEvent.setToIndex((int) (j8 & 4294967295L));
                                                                                    androidComposeViewAccessibilityDelegateCompat.sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                                }
                                                                            } else {
                                                                                i10 = i28;
                                                                                mutableScatterMap2 = mutableScatterMap2;
                                                                                num7 = num7;
                                                                                sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i10), 2048, Integer.valueOf(i23), 8);
                                                                            }
                                                                            num5 = num8;
                                                                            arrayList6 = arrayList5;
                                                                            i8 = i36;
                                                                        } else {
                                                                            i10 = i28;
                                                                            mutableScatterMap2 = mutableScatterMap2;
                                                                            num7 = num7;
                                                                            i8 = i36;
                                                                            semanticsPropertyKey4 = SemanticsProperties.TextSelectionRange;
                                                                            if (Intrinsics.areEqual(semanticsPropertyKey5, semanticsPropertyKey4)) {
                                                                                obj3 = mutableScatterMap3.get(semanticsPropertyKey3);
                                                                                if (obj3 == null) {
                                                                                    obj3 = null;
                                                                                }
                                                                                annotatedString = (AnnotatedString) obj3;
                                                                                if (annotatedString != null) {
                                                                                    str = str2;
                                                                                }
                                                                                long j9 = ((TextRange) semanticsConfiguration4.get(semanticsPropertyKey4)).packedValue;
                                                                                num5 = num8;
                                                                                androidComposeViewAccessibilityDelegateCompat = this;
                                                                                androidComposeViewAccessibilityDelegateCompat.sendEvent(androidComposeViewAccessibilityDelegateCompat.createTextSelectionChangedEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i10), Integer.valueOf((int) (j9 >> 32)), Integer.valueOf((int) (j9 & 4294967295L)), Integer.valueOf(str.length()), trimToSize(str)));
                                                                                androidComposeViewAccessibilityDelegateCompat.sendPendingTextTraversedAtGranularityEvent(i30);
                                                                            } else {
                                                                                num5 = num8;
                                                                                if (Intrinsics.areEqual(semanticsPropertyKey5, semanticsPropertyKey6)) {
                                                                                }
                                                                                androidComposeViewAccessibilityDelegateCompat.notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode3);
                                                                                size = arrayList5.size();
                                                                                i12 = 0;
                                                                                while (true) {
                                                                                    if (i12 < size) {
                                                                                        arrayList6 = arrayList5;
                                                                                        scrollObservationScope2 = null;
                                                                                        break;
                                                                                    }
                                                                                    arrayList6 = arrayList5;
                                                                                    if (((ScrollObservationScope) arrayList6.get(i12)).semanticsNodeId == i10) {
                                                                                        scrollObservationScope2 = (ScrollObservationScope) arrayList6.get(i12);
                                                                                        break;
                                                                                    } else {
                                                                                        i12++;
                                                                                        arrayList5 = arrayList6;
                                                                                    }
                                                                                }
                                                                                scrollObservationScope2.getClass();
                                                                                obj = mutableScatterMap3.get(semanticsPropertyKey6);
                                                                                if (obj == null) {
                                                                                    obj = null;
                                                                                }
                                                                                scrollObservationScope2.horizontalScrollAxisRange = (ScrollAxisRange) obj;
                                                                                obj2 = mutableScatterMap3.get(SemanticsProperties.VerticalScrollAxisRange);
                                                                                if (obj2 == null) {
                                                                                    obj2 = null;
                                                                                }
                                                                                scrollObservationScope2.verticalScrollAxisRange = (ScrollAxisRange) obj2;
                                                                                if (!scrollObservationScope2.allScopes.contains(scrollObservationScope2)) {
                                                                                    androidComposeViewAccessibilityDelegateCompat.view.getSnapshotObserver().observer.observeReads(scrollObservationScope2, androidComposeViewAccessibilityDelegateCompat.scheduleScrollEventIfNeededLambda, new ComponentRegistry$Builder$$ExternalSyntheticLambda2((Object) scrollObservationScope2, (Object) androidComposeViewAccessibilityDelegateCompat, (byte) 1));
                                                                                }
                                                                            }
                                                                            arrayList6 = arrayList5;
                                                                        }
                                                                    }
                                                                }
                                                                num5 = num8;
                                                                i10 = i28;
                                                                mutableScatterMap2 = mutableScatterMap2;
                                                                num7 = num7;
                                                                arrayList6 = arrayList5;
                                                                i8 = i36;
                                                            }
                                                        }
                                                    }
                                                    i8 = i36;
                                                }
                                                i29 = 8;
                                                mutableScatterMap2 = mutableScatterMap2;
                                                layoutNode3 = layoutNode3;
                                                i33 = i9;
                                                i34++;
                                                i28 = i10;
                                                semanticsNode3 = semanticsNode3;
                                                j4 = j >> 8;
                                                arrayList6 = arrayList6;
                                                length4 = i8;
                                                num8 = num5;
                                                semanticsConfiguration3 = semanticsConfiguration2;
                                                arrayList7 = arrayList7;
                                                num7 = num7;
                                            } else {
                                                semanticsConfiguration2 = semanticsConfiguration3;
                                                j = j4;
                                                i34 = i34;
                                                i8 = length4;
                                            }
                                            num5 = num8;
                                            i10 = i28;
                                            i9 = i33;
                                            mutableScatterMap2 = mutableScatterMap2;
                                            i29 = 8;
                                            mutableScatterMap2 = mutableScatterMap2;
                                            layoutNode3 = layoutNode3;
                                            i33 = i9;
                                            i34++;
                                            i28 = i10;
                                            semanticsNode3 = semanticsNode3;
                                            j4 = j >> 8;
                                            arrayList6 = arrayList6;
                                            length4 = i8;
                                            num8 = num5;
                                            semanticsConfiguration3 = semanticsConfiguration2;
                                            arrayList7 = arrayList7;
                                            num7 = num7;
                                        }
                                        semanticsConfiguration = semanticsConfiguration3;
                                        num3 = num7;
                                        arrayList3 = arrayList7;
                                        arrayList4 = arrayList6;
                                        layoutNode = layoutNode3;
                                        semanticsNode = semanticsNode3;
                                        z = true;
                                        i7 = length4;
                                        num4 = num8;
                                        i6 = i28;
                                        int i42 = i33;
                                        mutableScatterMap = mutableScatterMap2;
                                        if (i42 != i29) {
                                            break;
                                        }
                                    } else {
                                        semanticsConfiguration = semanticsConfiguration3;
                                        mutableScatterMap = mutableScatterMap2;
                                        num3 = num7;
                                        arrayList3 = arrayList7;
                                        arrayList4 = arrayList6;
                                        layoutNode = layoutNode3;
                                        semanticsNode = semanticsNode3;
                                        z = true;
                                        i7 = length4;
                                        num4 = num8;
                                        i6 = i28;
                                    }
                                    if (i32 == i7) {
                                        break;
                                    }
                                    num8 = num4;
                                    i28 = i6;
                                    mutableScatterMap2 = mutableScatterMap;
                                    layoutNode3 = layoutNode;
                                    arrayList7 = arrayList3;
                                    i29 = 8;
                                    i31 = i32 + 1;
                                    arrayList6 = arrayList4;
                                    length4 = i7;
                                    semanticsNode2 = semanticsNode;
                                    semanticsConfiguration3 = semanticsConfiguration;
                                    num7 = num3;
                                }
                            } else {
                                semanticsConfiguration = semanticsConfiguration3;
                                num3 = num7;
                                arrayList3 = arrayList7;
                                arrayList4 = arrayList6;
                                i3 = i26;
                                semanticsNode = semanticsNode2;
                                z = true;
                                num4 = num8;
                                i6 = i28;
                                z2 = false;
                            }
                            if (!z2) {
                                Iterator it = semanticsConfiguration.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z3 = false;
                                        break;
                                    } else {
                                        if (!semanticsNode.getConfig().props.containsKey((SemanticsPropertyKey) ((Map.Entry) it.next()).getKey())) {
                                            z3 = z;
                                            break;
                                        }
                                    }
                                }
                                z2 = z3;
                            }
                            if (z2) {
                                i5 = 8;
                                sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i6), 2048, num4, 8);
                            } else {
                                i5 = 8;
                            }
                        }
                    } else {
                        i2 = i27;
                        num3 = num7;
                        arrayList3 = arrayList7;
                        arrayList4 = arrayList6;
                        iArr2 = iArr3;
                        jArr2 = jArr3;
                        i3 = i26;
                        i4 = i22;
                        num4 = num8;
                        i5 = i25;
                    }
                    j3 >>= i5;
                    i27 = i2 + 1;
                    intObjectMap2 = intObjectMap;
                    arrayList6 = arrayList4;
                    num8 = num4;
                    i25 = i5;
                    iArr3 = iArr2;
                    jArr3 = jArr2;
                    i22 = i4;
                    i26 = i3;
                    arrayList7 = arrayList3;
                    num7 = num3;
                }
                num = num7;
                arrayList = arrayList7;
                arrayList2 = arrayList6;
                iArr = iArr3;
                jArr = jArr3;
                int i43 = i22;
                num2 = num8;
                if (i26 != i25) {
                    return;
                } else {
                    i = i43;
                }
            } else {
                num = num7;
                arrayList = arrayList7;
                arrayList2 = arrayList6;
                iArr = iArr3;
                jArr = jArr3;
                num2 = num8;
                i = i22;
            }
            if (i == i24) {
                return;
            }
            i22 = i + 1;
            intObjectMap2 = intObjectMap;
            length3 = i24;
            arrayList6 = arrayList2;
            num8 = num2;
            i20 = i23;
            iArr3 = iArr;
            jArr3 = jArr;
            arrayList7 = arrayList;
            num7 = num;
            i21 = 0;
        }
    }

    public final boolean setAccessibilitySelection(SemanticsNode semanticsNode, int i, int i2, boolean z) {
        String iterableTextForAccessibility;
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        int i3 = semanticsNode.id;
        SemanticsPropertyKey semanticsPropertyKey = SemanticsActions.SetSelection;
        if (semanticsConfiguration.props.containsKey(semanticsPropertyKey) && InvertMatrixKt.enabled(semanticsNode)) {
            Function3 function3 = (Function3) ((AccessibilityAction) semanticsNode.unmergedConfig.get(semanticsPropertyKey)).action;
            if (function3 != null) {
                return ((Boolean) function3.invoke(Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
            }
        } else if ((i != i2 || i2 != this.accessibilityCursorPosition) && (iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode)) != null) {
            if (i < 0 || i != i2 || i2 > iterableTextForAccessibility.length()) {
                i = -1;
            }
            this.accessibilityCursorPosition = i;
            boolean z2 = iterableTextForAccessibility.length() > 0;
            sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i3), z2 ? Integer.valueOf(this.accessibilityCursorPosition) : null, z2 ? Integer.valueOf(this.accessibilityCursorPosition) : null, z2 ? Integer.valueOf(iterableTextForAccessibility.length()) : null, iterableTextForAccessibility));
            sendPendingTextTraversedAtGranularityEvent(i3);
            return true;
        }
        return false;
    }

    public final Rect toBoundsInScreen(float f, float f2, float f3, float f4) {
        long jFloatToRawIntBits = Float.floatToRawIntBits(f);
        long jFloatToRawIntBits2 = ((long) Float.floatToRawIntBits(f2)) & 4294967295L;
        AndroidComposeView androidComposeView = this.view;
        long jM686localToScreenMKHz9U = androidComposeView.m686localToScreenMKHz9U(jFloatToRawIntBits2 | (jFloatToRawIntBits << 32));
        long jM686localToScreenMKHz9U2 = androidComposeView.m686localToScreenMKHz9U((((long) Float.floatToRawIntBits(f4)) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32));
        int i = (int) (jM686localToScreenMKHz9U >> 32);
        int i2 = (int) (jM686localToScreenMKHz9U2 >> 32);
        int i3 = (int) (jM686localToScreenMKHz9U & 4294967295L);
        int i4 = (int) (jM686localToScreenMKHz9U2 & 4294967295L);
        return new Rect((int) Math.floor(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2))), (int) Math.floor(Math.min(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4))), (int) Math.ceil(Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2))), (int) Math.ceil(Math.max(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4))));
    }

    public final void updateBounds(MutableIntSet mutableIntSet) {
        AndroidViewsHandler androidViewsHandler$ui;
        HashMap<LayoutNode, AndroidViewHolder> layoutNodeToHolder;
        AndroidViewsHandler androidViewsHandler$ui2;
        LayoutNode parent$ui;
        SemanticsConfiguration semanticsConfiguration;
        HashMap<LayoutNode, AndroidViewHolder> layoutNodeToHolder2;
        ArraySet arraySet = this.subtreeChangedLayoutNodes;
        int i = arraySet._size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode = (LayoutNode) arraySet.array[i2];
            boolean zIsAttached$1 = layoutNode.isAttached$1();
            AndroidComposeView androidComposeView = this.view;
            if (zIsAttached$1 && ((androidViewsHandler$ui2 = androidComposeView.getAndroidViewsHandler$ui()) == null || (layoutNodeToHolder2 = androidViewsHandler$ui2.getLayoutNodeToHolder()) == null || !layoutNodeToHolder2.containsKey(layoutNode))) {
                LayoutNode layoutNode2 = null;
                if (!layoutNode.nodes.m662hasH91voCI$ui(8)) {
                    parent$ui = layoutNode.getParent$ui();
                    while (true) {
                        if (parent$ui == null) {
                            parent$ui = null;
                            break;
                        } else if (parent$ui.nodes.m662hasH91voCI$ui(8)) {
                            break;
                        } else {
                            parent$ui = parent$ui.getParent$ui();
                        }
                    }
                } else {
                    parent$ui = layoutNode;
                }
                if (parent$ui != null && (semanticsConfiguration = parent$ui.getSemanticsConfiguration()) != null) {
                    if (!semanticsConfiguration.isMergingSemanticsOfDescendants) {
                        for (LayoutNode parent$ui2 = parent$ui.getParent$ui(); parent$ui2 != null; parent$ui2 = parent$ui2.getParent$ui()) {
                            SemanticsConfiguration semanticsConfiguration2 = parent$ui2.getSemanticsConfiguration();
                            if (semanticsConfiguration2 != null && semanticsConfiguration2.isMergingSemanticsOfDescendants) {
                                layoutNode2 = parent$ui2;
                                break;
                            }
                        }
                        if (layoutNode2 != null) {
                            parent$ui = layoutNode2;
                        }
                    }
                    int i3 = parent$ui.semanticsId;
                    if (mutableIntSet.add(i3)) {
                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(i3), 2048, 1, 8);
                    }
                }
            }
            if (layoutNode.isAttached$1() && ((androidViewsHandler$ui = androidComposeView.getAndroidViewsHandler$ui()) == null || (layoutNodeToHolder = androidViewsHandler$ui.getLayoutNodeToHolder()) == null || !layoutNodeToHolder.containsKey(layoutNode))) {
                int i4 = layoutNode.semanticsId;
                ScrollAxisRange scrollAxisRange = (ScrollAxisRange) this.pendingHorizontalScrollEvents.get(i4);
                ScrollAxisRange scrollAxisRange2 = (ScrollAxisRange) this.pendingVerticalScrollEvents.get(i4);
                if (scrollAxisRange != null || scrollAxisRange2 != null) {
                    AccessibilityEvent accessibilityEventCreateEvent = createEvent(i4, 4096);
                    if (scrollAxisRange != null) {
                        accessibilityEventCreateEvent.setScrollX((int) ((Number) scrollAxisRange.value.invoke()).floatValue());
                        accessibilityEventCreateEvent.setMaxScrollX((int) ((Number) scrollAxisRange.maxValue.invoke()).floatValue());
                    }
                    if (scrollAxisRange2 != null) {
                        accessibilityEventCreateEvent.setScrollY((int) ((Number) scrollAxisRange2.value.invoke()).floatValue());
                        accessibilityEventCreateEvent.setMaxScrollY((int) ((Number) scrollAxisRange2.maxValue.invoke()).floatValue());
                    }
                    sendEvent(accessibilityEventCreateEvent);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0064  */
    /* JADX WARN: Code duplicated, block: B:20:0x006f  */
    /* JADX WARN: Code duplicated, block: B:23:0x007c  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void updateSemanticsNodesCopyAndPanes() {
        long j;
        long j2;
        long j3;
        char c;
        long[] jArr;
        long[] jArr2;
        long j4;
        int i;
        int iNumberOfTrailingZeros;
        char c2;
        SemanticsNodeCopy semanticsNodeCopy;
        MutableIntSet mutableIntSet = new MutableIntSet();
        MutableIntSet mutableIntSet2 = this.paneDisplayed;
        int[] iArr = mutableIntSet2.elements;
        long[] jArr3 = mutableIntSet2.metadata;
        int length = jArr3.length - 2;
        MutableIntObjectMap mutableIntObjectMap = this.previousSemanticsNodes;
        int i2 = 8;
        if (length >= 0) {
            int i3 = 0;
            j = 128;
            j2 = 255;
            while (true) {
                long j5 = jArr3[i3];
                char c3 = 7;
                j3 = -9187201950435737472L;
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j5 & 255) < 128) {
                            int i6 = iArr[(i3 << 3) + i5];
                            c2 = c3;
                            AdjustedSemanticsNode adjustedSemanticsNode = (AdjustedSemanticsNode) getCurrentSemanticsNodes().get(i6);
                            Object obj = null;
                            SemanticsNode semanticsNode = adjustedSemanticsNode != null ? adjustedSemanticsNode.semanticsNode : null;
                            if (semanticsNode != null) {
                                if (!semanticsNode.unmergedConfig.props.containsKey(SemanticsProperties.PaneTitle)) {
                                    mutableIntSet.add(i6);
                                    semanticsNodeCopy = (SemanticsNodeCopy) mutableIntObjectMap.get(i6);
                                    if (semanticsNodeCopy != null) {
                                        Object obj2 = semanticsNodeCopy.unmergedConfig.props.get(SemanticsProperties.PaneTitle);
                                        obj = (String) (obj2 != null ? obj2 : null);
                                    }
                                    sendPaneChangeEvents(i6, 32, obj);
                                }
                            } else {
                                mutableIntSet.add(i6);
                                semanticsNodeCopy = (SemanticsNodeCopy) mutableIntObjectMap.get(i6);
                                if (semanticsNodeCopy != null) {
                                    Object obj3 = semanticsNodeCopy.unmergedConfig.props.get(SemanticsProperties.PaneTitle);
                                    obj = (String) (obj3 != null ? obj3 : null);
                                }
                                sendPaneChangeEvents(i6, 32, obj);
                            }
                        } else {
                            c2 = c3;
                        }
                        j5 >>= 8;
                        i5++;
                        c3 = c2;
                    }
                    c = c3;
                    if (i4 != 8) {
                        break;
                    }
                } else {
                    c = 7;
                }
                if (i3 == length) {
                    break;
                } else {
                    i3++;
                }
            }
        } else {
            j = 128;
            j2 = 255;
            j3 = -9187201950435737472L;
            c = 7;
        }
        int[] iArr2 = mutableIntSet.elements;
        long[] jArr4 = mutableIntSet.metadata;
        int length2 = jArr4.length - 2;
        if (length2 >= 0) {
            int i7 = 0;
            while (true) {
                long j6 = jArr4[i7];
                if ((((~j6) << c) & j6 & j3) != j3) {
                    int i8 = 8 - ((~(i7 - length2)) >>> 31);
                    int i9 = 0;
                    while (i9 < i8) {
                        if ((j6 & j2) < j) {
                            int i10 = iArr2[(i7 << 3) + i9];
                            int iHashCode = Integer.hashCode(i10) * (-862048943);
                            int i11 = iHashCode ^ (iHashCode << 16);
                            int i12 = i11 & 127;
                            int i13 = mutableIntSet2._capacity;
                            int i14 = (i11 >>> 7) & i13;
                            i = i2;
                            int i15 = 0;
                            while (true) {
                                long[] jArr5 = mutableIntSet2.metadata;
                                int i16 = i14 >> 3;
                                jArr2 = jArr4;
                                int i17 = (i14 & 7) << 3;
                                j4 = j6;
                                long j7 = (jArr5[i16] >>> i17) | ((jArr5[i16 + 1] << (64 - i17)) & ((-i17) >> 63));
                                int i18 = i13;
                                long j8 = (((long) i12) * 72340172838076673L) ^ j7;
                                long j9 = (j8 - 72340172838076673L) & (~j8) & j3;
                                while (j9 != 0) {
                                    iNumberOfTrailingZeros = (i14 + (Long.numberOfTrailingZeros(j9) >> 3)) & i18;
                                    int i19 = i18;
                                    if (mutableIntSet2.elements[iNumberOfTrailingZeros] == i10) {
                                        break;
                                    }
                                    j9 &= j9 - 1;
                                    i18 = i19;
                                }
                                int i20 = i18;
                                if ((j7 & ((~j7) << 6) & j3) != 0) {
                                    iNumberOfTrailingZeros = -1;
                                    break;
                                }
                                i15 += 8;
                                i14 = (i14 + i15) & i20;
                                jArr4 = jArr2;
                                i13 = i20;
                                j6 = j4;
                            }
                            int i21 = iNumberOfTrailingZeros;
                            if (i21 >= 0) {
                                mutableIntSet2.removeElementAt(i21);
                            }
                        } else {
                            jArr2 = jArr4;
                            j4 = j6;
                            i = i2;
                        }
                        j6 = j4 >> i;
                        i9++;
                        i2 = i;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    if (i8 != i2) {
                        break;
                    }
                } else {
                    jArr = jArr4;
                }
                if (i7 == length2) {
                    break;
                }
                i7++;
                jArr4 = jArr;
                i2 = 8;
            }
        }
        mutableIntObjectMap.clear();
        IntObjectMap currentSemanticsNodes = getCurrentSemanticsNodes();
        int[] iArr3 = currentSemanticsNodes.keys;
        Object[] objArr = currentSemanticsNodes.values;
        long[] jArr6 = currentSemanticsNodes.metadata;
        int length3 = jArr6.length - 2;
        if (length3 >= 0) {
            int i22 = 0;
            while (true) {
                long j10 = jArr6[i22];
                if ((((~j10) << c) & j10 & j3) != j3) {
                    int i23 = 8 - ((~(i22 - length3)) >>> 31);
                    for (int i24 = 0; i24 < i23; i24++) {
                        if ((j10 & j2) < j) {
                            int i25 = (i22 << 3) + i24;
                            int i26 = iArr3[i25];
                            SemanticsNode semanticsNode2 = ((AdjustedSemanticsNode) objArr[i25]).semanticsNode;
                            SemanticsConfiguration semanticsConfiguration = semanticsNode2.unmergedConfig;
                            SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.PaneTitle;
                            if (semanticsConfiguration.props.containsKey(semanticsPropertyKey) && mutableIntSet2.add(i26)) {
                                sendPaneChangeEvents(i26, 16, (String) semanticsNode2.unmergedConfig.get(semanticsPropertyKey));
                            }
                            mutableIntObjectMap.set(i26, new SemanticsNodeCopy(semanticsNode2, getCurrentSemanticsNodes()));
                        }
                        j10 >>= 8;
                    }
                    if (i23 != 8) {
                        break;
                    }
                }
                if (i22 == length3) {
                    break;
                } else {
                    i22++;
                }
            }
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes());
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z) {
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
