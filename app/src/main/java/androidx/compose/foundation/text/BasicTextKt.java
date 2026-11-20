package androidx.compose.foundation.text;

import android.text.Spanned;
import android.view.KeyEvent;
import androidx.collection.internal.Lock;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider_androidKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuModifierKt;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.TextStringSimpleElement;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager$contextMenuAreaModifier$3;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager$paste$1;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.SliderKt$SliderImpl$3$1;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda5;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.pointer.AndroidPointerIconType;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.StringAnnotation;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PlatformTextInputService;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.provider.CallbackWrapper;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiProcessor;
import androidx.emoji2.text.TypefaceEmojiSpan;
import androidx.media3.session.MediaNotificationManager$$ExternalSyntheticLambda6;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import coil3.util.FileSystemsKt;
import com.google.common.math.IntMath;
import com.metrolist.innertubex.InnerTube$$ExternalSyntheticLambda2;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda29;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda9;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.ui.component.AuralysBrandKt$$ExternalSyntheticLambda6;
import com.metrolist.music.ui.component.BottomSheetKt$BottomSheet$3$1;
import com.metrolist.music.utils.SyncUtils$executeSyncPlaylist$2;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlin.text.StringsKt__StringsKt$$ExternalSyntheticLambda1;
import kotlin.uuid.UuidKt;
import okhttp3.internal.http2.Huffman;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BasicTextKt {
    public static final DrawResult defaultKeyMapping = new DrawResult((byte) 17, (Object) new KeyMappingKt$commonKeyMapping$1(0));
    public static final KeyMappingKt$commonKeyMapping$1 platformDefaultKeyMapping = new KeyMappingKt$commonKeyMapping$1(1);
    public static final AndroidPointerIconType handwritingPointerIcon = new AndroidPointerIconType(1022);

    /* JADX WARN: Code duplicated, block: B:100:0x011c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x011e  */
    /* JADX WARN: Code duplicated, block: B:102:0x0120  */
    /* JADX WARN: Code duplicated, block: B:104:0x0123  */
    /* JADX WARN: Code duplicated, block: B:105:0x0127  */
    /* JADX WARN: Code duplicated, block: B:108:0x0134  */
    /* JADX WARN: Code duplicated, block: B:110:0x0149  */
    /* JADX WARN: Code duplicated, block: B:112:0x0150  */
    /* JADX WARN: Code duplicated, block: B:119:0x0176  */
    /* JADX WARN: Code duplicated, block: B:121:0x017d A[EDGE_INSN: B:121:0x017d->B:122:0x0180 BREAK  A[LOOP:0: B:111:0x014e->B:120:0x0177], PHI: r9
      0x017d: PHI (r9v5 boolean) = (r9v2 boolean), (r9v12 boolean) binds: [B:109:0x0147, B:152:0x017d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:130:0x0200  */
    /* JADX WARN: Code duplicated, block: B:132:0x020d  */
    /* JADX WARN: Code duplicated, block: B:133:0x020f  */
    /* JADX WARN: Code duplicated, block: B:136:0x0218 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:137:0x021a  */
    /* JADX WARN: Code duplicated, block: B:140:0x0233 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:141:0x0235  */
    /* JADX WARN: Code duplicated, block: B:144:0x0289  */
    /* JADX WARN: Code duplicated, block: B:146:0x028d  */
    /* JADX WARN: Code duplicated, block: B:149:0x029a  */
    /* JADX WARN: Code duplicated, block: B:152:0x017d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:79:0x00db  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:84:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:97:0x0113  */
    /* JADX INFO: renamed from: BasicText-CL7eQgs, reason: not valid java name */
    public static final void m186BasicTextCL7eQgs(final AnnotatedString annotatedString, final Modifier modifier, final TextStyle textStyle, final Function1 function1, final int i, final boolean z, final int i2, int i3, Map map, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        TextStyle textStyle2;
        Function1 function2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean zChangedInstance;
        int i13;
        boolean z2;
        boolean z3;
        GapComposer gapComposer;
        final Map map2;
        final int i14;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i15;
        Map map3;
        List list;
        boolean z4;
        boolean z5;
        FontFamily.Resolver resolver;
        boolean z6;
        Object objRememberedValue;
        MutableState mutableState;
        boolean zChanged;
        Object objRememberedValue2;
        Map map4;
        int size;
        int i16;
        AnnotatedString.Range range;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-1343466571);
        if ((i4 & 6) == 0) {
            i7 = (gapComposer2.changed(annotatedString) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        if ((i4 & 48) == 0) {
            i7 |= gapComposer2.changed(modifier) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            textStyle2 = textStyle;
            i7 |= gapComposer2.changed(textStyle2) ? 256 : 128;
        } else {
            textStyle2 = textStyle;
        }
        if ((i4 & 3072) == 0) {
            function2 = function1;
            i7 |= gapComposer2.changedInstance(function2) ? 2048 : 1024;
        } else {
            function2 = function1;
        }
        if ((i4 & 24576) == 0) {
            i7 |= gapComposer2.changed(i) ? 16384 : 8192;
        }
        if ((196608 & i4) == 0) {
            i7 |= gapComposer2.changed(z) ? 131072 : 65536;
        }
        if ((1572864 & i4) == 0) {
            i7 |= gapComposer2.changed(i2) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        int i17 = i6 & 128;
        if (i17 == 0) {
            if ((12582912 & i4) == 0) {
                i8 = i3;
                i7 |= gapComposer2.changed(i8) ? 8388608 : 4194304;
            }
            i9 = i6 & 256;
            if (i9 != 0) {
                i7 |= 100663296;
            } else if ((i4 & 100663296) == 0) {
                if (gapComposer2.changedInstance(map)) {
                    i10 = 67108864;
                } else {
                    i10 = 33554432;
                }
                i7 |= i10;
            }
            i11 = i7 | 805306368;
            if ((i6 & 1024) != 0) {
                i12 = i5 | 6;
            } else if ((i5 & 6) == 0) {
                if ((i5 & 8) == 0) {
                    zChangedInstance = gapComposer2.changed((Object) null);
                } else {
                    zChangedInstance = gapComposer2.changedInstance(null);
                }
                if (zChangedInstance) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i12 = i5 | i13;
            } else {
                i12 = i5;
            }
            z2 = false;
            if ((i11 & 306783379) == 306783378 || (i12 & 3) != 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (gapComposer2.shouldExecute(i11 & 1, z3)) {
                if (i17 != 0) {
                    i15 = 1;
                } else {
                    i15 = i8;
                }
                if (i9 != 0) {
                    map3 = EmptyMap.INSTANCE;
                } else {
                    map3 = map;
                }
                validateMinMaxLines(i15, i2);
                if (gapComposer2.consume(SelectionRegistrarKt.LocalSelectionRegistrar) == null) {
                    PathKt$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                gapComposer2.startReplaceGroup(1588900273);
                gapComposer2.end(false);
                Pair pair = AnnotatedStringResolveInlineContentKt.EmptyInlineContent;
                int length = annotatedString.text.length();
                list = annotatedString.annotations;
                if (list != null) {
                    z4 = z2;
                    z5 = z4;
                    break;
                }
                size = list.size();
                i16 = 0;
                while (true) {
                    if (i16 < size) {
                        z4 = z2;
                        z5 = z4;
                        break;
                    }
                    range = (AnnotatedString.Range) list.get(i16);
                    if ((range.item instanceof StringAnnotation) || !"androidx.compose.foundation.text.inlineContent".equals(range.tag)) {
                        z4 = false;
                    } else {
                        int i18 = range.start;
                        int i19 = range.end;
                        z4 = false;
                        if (AnnotatedStringKt.intersect(0, length, i18, i19)) {
                            z5 = true;
                            break;
                        }
                    }
                    i16++;
                    z2 = z4;
                }
                boolean zHasLinks = MathKt.hasLinks(annotatedString);
                resolver = (FontFamily.Resolver) gapComposer2.consume(CompositionLocalsKt.LocalFontFamilyResolver);
                if (!z5 || zHasLinks) {
                    gapComposer = gapComposer2;
                    gapComposer.startReplaceGroup(1590195670);
                    if ((i11 & 14) == 4) {
                        z6 = true;
                    } else {
                        z6 = z4;
                    }
                    objRememberedValue = gapComposer.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                    if (z6 || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = Stack.mutableStateOf$default(annotatedString);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    AnnotatedString annotatedString2 = (AnnotatedString) mutableState.getValue();
                    zChanged = gapComposer.changed(mutableState);
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda5(mutableState, (byte) 3);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    int i20 = i11 << 6;
                    int i21 = i15;
                    map4 = map3;
                    m190LayoutWithLinksAndInlineContent11Od_4g(modifier, annotatedString2, function1, z5, map4, textStyle, i, z, i2, i21, resolver, (Function1) objRememberedValue2, gapComposer, ((i11 >> 3) & 910) | ((i11 >> 12) & 57344) | ((i11 << 9) & 458752) | (3670016 & i20) | (29360128 & i20) | (234881024 & i20) | (i20 & 1879048192), ((i11 >> 21) & 896) | ((i12 << 12) & 57344));
                    i15 = i21;
                    gapComposer.end(z4);
                } else {
                    gapComposer2.startReplaceGroup(1589148149);
                    BasicText_androidKt.BackgroundTextMeasurement(annotatedString, textStyle2, resolver, null, z, gapComposer2);
                    gapComposer = gapComposer2;
                    Modifier modifierM193textModifierCL7eQgs = m193textModifierCL7eQgs(modifier, annotatedString, textStyle, function2, i, z, i2, i15, resolver, null, null, null);
                    EmptyMeasurePolicy emptyMeasurePolicy = EmptyMeasurePolicy.INSTANCE;
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM193textModifierCL7eQgs);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, emptyMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    gapComposer.end(true);
                    gapComposer.end(false);
                    map4 = map3;
                }
                map2 = map4;
                i14 = i15;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                map2 = map;
                i14 = i8;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                        AnnotatedString annotatedString3 = annotatedString;
                        Modifier modifier2 = modifier;
                        TextStyle textStyle3 = textStyle;
                        Function1 function3 = function1;
                        int i22 = i;
                        boolean z7 = z;
                        int i23 = i2;
                        boolean z8 = i14;
                        Map map5 = map2;
                        BasicTextKt.m186BasicTextCL7eQgs(annotatedString3, modifier2, textStyle3, function3, i22, z7, i23, z8 ? 1 : 0, map5, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i6);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i7 |= 12582912;
        i8 = i3;
        i9 = i6 & 256;
        if (i9 != 0) {
            i7 |= 100663296;
        } else if ((i4 & 100663296) == 0) {
            if (gapComposer2.changedInstance(map)) {
                i10 = 67108864;
            } else {
                i10 = 33554432;
            }
            i7 |= i10;
        }
        i11 = i7 | 805306368;
        if ((i6 & 1024) != 0) {
            i12 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            if ((i5 & 8) == 0) {
                zChangedInstance = gapComposer2.changed((Object) null);
            } else {
                zChangedInstance = gapComposer2.changedInstance(null);
            }
            if (zChangedInstance) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i5 | i13;
        } else {
            i12 = i5;
        }
        z2 = false;
        if ((i11 & 306783379) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (gapComposer2.shouldExecute(i11 & 1, z3)) {
            if (i17 != 0) {
                i15 = 1;
            } else {
                i15 = i8;
            }
            if (i9 != 0) {
                map3 = EmptyMap.INSTANCE;
            } else {
                map3 = map;
            }
            validateMinMaxLines(i15, i2);
            if (gapComposer2.consume(SelectionRegistrarKt.LocalSelectionRegistrar) == null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
                return;
            }
            gapComposer2.startReplaceGroup(1588900273);
            gapComposer2.end(false);
            Pair pair2 = AnnotatedStringResolveInlineContentKt.EmptyInlineContent;
            int length2 = annotatedString.text.length();
            list = annotatedString.annotations;
            if (list != null) {
                z4 = z2;
                z5 = z4;
                break;
            }
            size = list.size();
            i16 = 0;
            while (true) {
                if (i16 < size) {
                    z4 = z2;
                    z5 = z4;
                    break;
                }
                range = (AnnotatedString.Range) list.get(i16);
                if (range.item instanceof StringAnnotation) {
                    z4 = false;
                } else {
                    z4 = false;
                }
                i16++;
                z2 = z4;
            }
            boolean zHasLinks2 = MathKt.hasLinks(annotatedString);
            resolver = (FontFamily.Resolver) gapComposer2.consume(CompositionLocalsKt.LocalFontFamilyResolver);
            if (z5) {
                gapComposer = gapComposer2;
                gapComposer.startReplaceGroup(1590195670);
                if ((i11 & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = z4;
                }
                objRememberedValue = gapComposer.rememberedValue();
                NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                if (z6) {
                    objRememberedValue = Stack.mutableStateOf$default(annotatedString);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = Stack.mutableStateOf$default(annotatedString);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                AnnotatedString annotatedString3 = (AnnotatedString) mutableState.getValue();
                zChanged = gapComposer.changed(mutableState);
                objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda5(mutableState, (byte) 3);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda5(mutableState, (byte) 3);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                int i22 = i11 << 6;
                int i23 = i15;
                map4 = map3;
                m190LayoutWithLinksAndInlineContent11Od_4g(modifier, annotatedString3, function1, z5, map4, textStyle, i, z, i2, i23, resolver, (Function1) objRememberedValue2, gapComposer, ((i11 >> 3) & 910) | ((i11 >> 12) & 57344) | ((i11 << 9) & 458752) | (3670016 & i22) | (29360128 & i22) | (234881024 & i22) | (i22 & 1879048192), ((i11 >> 21) & 896) | ((i12 << 12) & 57344));
                i15 = i23;
                gapComposer.end(z4);
            } else {
                gapComposer = gapComposer2;
                gapComposer.startReplaceGroup(1590195670);
                if ((i11 & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = z4;
                }
                objRememberedValue = gapComposer.rememberedValue();
                NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
                if (z6) {
                    objRememberedValue = Stack.mutableStateOf$default(annotatedString);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = Stack.mutableStateOf$default(annotatedString);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                AnnotatedString annotatedString4 = (AnnotatedString) mutableState.getValue();
                zChanged = gapComposer.changed(mutableState);
                objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda5(mutableState, (byte) 3);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda5(mutableState, (byte) 3);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                int i24 = i11 << 6;
                int i25 = i15;
                map4 = map3;
                m190LayoutWithLinksAndInlineContent11Od_4g(modifier, annotatedString4, function1, z5, map4, textStyle, i, z, i2, i25, resolver, (Function1) objRememberedValue2, gapComposer, ((i11 >> 3) & 910) | ((i11 >> 12) & 57344) | ((i11 << 9) & 458752) | (3670016 & i24) | (29360128 & i24) | (234881024 & i24) | (i24 & 1879048192), ((i11 >> 21) & 896) | ((i12 << 12) & 57344));
                i15 = i25;
                gapComposer.end(z4);
            }
            map2 = map4;
            i14 = i15;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            map2 = map;
            i14 = i8;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                    AnnotatedString annotatedString5 = annotatedString;
                    Modifier modifier2 = modifier;
                    TextStyle textStyle3 = textStyle;
                    Function1 function3 = function1;
                    int i26 = i;
                    boolean z7 = z;
                    int i27 = i2;
                    boolean z8 = i14;
                    Map map5 = map2;
                    BasicTextKt.m186BasicTextCL7eQgs(annotatedString5, modifier2, textStyle3, function3, i26, z7, i27, z8 ? 1 : 0, map5, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i6);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x010a  */
    /* JADX WARN: Code duplicated, block: B:101:0x010c  */
    /* JADX WARN: Code duplicated, block: B:104:0x0119  */
    /* JADX WARN: Code duplicated, block: B:106:0x0137  */
    /* JADX WARN: Code duplicated, block: B:117:0x0171  */
    /* JADX WARN: Code duplicated, block: B:120:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:121:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:123:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:125:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:128:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0083  */
    /* JADX WARN: Code duplicated, block: B:51:0x0086  */
    /* JADX WARN: Code duplicated, block: B:53:0x008e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0091  */
    /* JADX WARN: Code duplicated, block: B:58:0x0099  */
    /* JADX WARN: Code duplicated, block: B:60:0x009f  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:67:0x00af  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:72:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:81:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:82:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:93:0x00fe A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x0100  */
    /* JADX WARN: Code duplicated, block: B:95:0x0102  */
    /* JADX WARN: Code duplicated, block: B:97:0x0105  */
    /* JADX WARN: Code duplicated, block: B:98:0x0107  */
    /* JADX INFO: renamed from: BasicText-RWo7tUw, reason: not valid java name */
    public static final void m187BasicTextRWo7tUw(final String str, final Modifier modifier, final TextStyle textStyle, int i, boolean z, final int i2, int i3, Composer composer, final int i4, final int i5) {
        int i6;
        int i7;
        int i8;
        boolean z2;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean zChangedInstance;
        int i13;
        boolean z3;
        final int i14;
        final int i15;
        final boolean z4;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i16;
        boolean z5;
        int i17;
        Executor executor;
        boolean z6;
        int i18;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1040751001);
        if ((i4 & 6) == 0) {
            i6 = (gapComposer.changed(str) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i6 |= gapComposer.changed(textStyle) ? 256 : 128;
        }
        if ((i5 & 8) != 0) {
            i6 |= 3072;
        } else if ((i4 & 3072) == 0) {
            i6 |= gapComposer.changedInstance(null) ? 2048 : 1024;
        }
        int i19 = i5 & 16;
        if (i19 == 0) {
            if ((i4 & 24576) == 0) {
                i7 = i;
                i6 |= gapComposer.changed(i7) ? 16384 : 8192;
            }
            i8 = i5 & 32;
            if (i8 != 0) {
                if ((196608 & i4) == 0) {
                    z2 = z;
                    if (gapComposer.changed(z2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i6 |= i9;
                }
                if ((1572864 & i4) == 0) {
                    if (gapComposer.changed(i2)) {
                        i18 = ByteChannelKt.CHANNEL_MAX_SIZE;
                    } else {
                        i18 = 524288;
                    }
                    i6 |= i18;
                }
                i10 = i5 & 128;
                if (i10 != 0) {
                    if ((12582912 & i4) == 0) {
                        if (gapComposer.changed(i3)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i6 |= i11;
                    }
                    i12 = 100663296 | i6;
                    if ((i5 & 512) != 0) {
                        i12 = i6 | 905969664;
                    } else if ((805306368 & i4) == 0) {
                        if ((1073741824 & i4) == 0) {
                            zChangedInstance = gapComposer.changed((Object) null);
                        } else {
                            zChangedInstance = gapComposer.changedInstance(null);
                        }
                        if (zChangedInstance) {
                            i13 = 536870912;
                        } else {
                            i13 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                        }
                        i12 |= i13;
                    }
                    if ((306783379 & i12) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (gapComposer.shouldExecute(i12 & 1, z3)) {
                        if (i19 != 0) {
                            i16 = 1;
                        } else {
                            i16 = i7;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i10 != 0) {
                            i17 = 1;
                        } else {
                            i17 = i3;
                        }
                        validateMinMaxLines(i17, i2);
                        if (gapComposer.consume(SelectionRegistrarKt.LocalSelectionRegistrar) == null) {
                            PathKt$$ExternalSyntheticBUOutline0.m();
                            return;
                        }
                        gapComposer.startReplaceGroup(357055103);
                        gapComposer.end(false);
                        FontFamily.Resolver resolver = (FontFamily.Resolver) gapComposer.consume(CompositionLocalsKt.LocalFontFamilyResolver);
                        executor = (Executor) gapComposer.consume(BasicText_androidKt.LocalBackgroundTextMeasurementExecutor);
                        if (executor == null && BasicText_androidKt.shouldPrefetch(str.length())) {
                            gapComposer.startReplaceGroup(-1250263182);
                            try {
                                z6 = true;
                                boolean z7 = z5;
                                try {
                                    try {
                                        executor.execute(new MediaNotificationManager$$ExternalSyntheticLambda6((byte) 1, textStyle, (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection), str, (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity), resolver, z7));
                                    } catch (RejectedExecutionException unused) {
                                    }
                                } catch (RejectedExecutionException unused2) {
                                    z5 = z7;
                                }
                            } catch (RejectedExecutionException unused3) {
                                z6 = true;
                            }
                            gapComposer.end(false);
                        } else {
                            z6 = true;
                            gapComposer.startReplaceGroup(-1248455541);
                            gapComposer.end(false);
                        }
                        gapComposer.startReplaceGroup(358076243);
                        gapComposer.end(false);
                        boolean z8 = z6;
                        Modifier modifierThen = modifier.then(new TextStringSimpleElement(str, textStyle, resolver, i16, z5, i2, i17));
                        EmptyMeasurePolicy emptyMeasurePolicy = EmptyMeasurePolicy.INSTANCE;
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
                        Stack.m390setimpl(gapComposer, emptyMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m389reconcileimpl(gapComposer);
                        Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                        gapComposer.end(z8);
                        i15 = i16;
                        z4 = z5;
                        i14 = i17;
                    } else {
                        gapComposer.skipToGroupEnd();
                        i14 = i3;
                        i15 = i7;
                        z4 = z2;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                String str2 = str;
                                Modifier modifier2 = modifier;
                                TextStyle textStyle2 = textStyle;
                                byte b = i15;
                                boolean z9 = z4;
                                int i20 = i2;
                                boolean z10 = i14;
                                BasicTextKt.m187BasicTextRWo7tUw(str2, modifier2, textStyle2, b, z9, i20, z10 ? 1 : 0, (Composer) obj, iUpdateChangedFlags, i5);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i6 |= 12582912;
                i12 = 100663296 | i6;
                if ((i5 & 512) != 0) {
                    i12 = i6 | 905969664;
                } else if ((805306368 & i4) == 0) {
                    if ((1073741824 & i4) == 0) {
                        zChangedInstance = gapComposer.changed((Object) null);
                    } else {
                        zChangedInstance = gapComposer.changedInstance(null);
                    }
                    if (zChangedInstance) {
                        i13 = 536870912;
                    } else {
                        i13 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                    }
                    i12 |= i13;
                }
                if ((306783379 & i12) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z3)) {
                    if (i19 != 0) {
                        i16 = 1;
                    } else {
                        i16 = i7;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        i17 = 1;
                    } else {
                        i17 = i3;
                    }
                    validateMinMaxLines(i17, i2);
                    if (gapComposer.consume(SelectionRegistrarKt.LocalSelectionRegistrar) == null) {
                        PathKt$$ExternalSyntheticBUOutline0.m();
                        return;
                    }
                    gapComposer.startReplaceGroup(357055103);
                    gapComposer.end(false);
                    FontFamily.Resolver resolver2 = (FontFamily.Resolver) gapComposer.consume(CompositionLocalsKt.LocalFontFamilyResolver);
                    executor = (Executor) gapComposer.consume(BasicText_androidKt.LocalBackgroundTextMeasurementExecutor);
                    if (executor == null) {
                        z6 = true;
                        gapComposer.startReplaceGroup(-1248455541);
                        gapComposer.end(false);
                    } else {
                        z6 = true;
                        gapComposer.startReplaceGroup(-1248455541);
                        gapComposer.end(false);
                    }
                    gapComposer.startReplaceGroup(358076243);
                    gapComposer.end(false);
                    boolean z9 = z6;
                    Modifier modifierThen2 = modifier.then(new TextStringSimpleElement(str, textStyle, resolver2, i16, z5, i2, i17));
                    EmptyMeasurePolicy emptyMeasurePolicy2 = EmptyMeasurePolicy.INSTANCE;
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
                    Stack.m390setimpl(gapComposer, emptyMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.SetCompositeKeyHash);
                    gapComposer.end(z9);
                    i15 = i16;
                    z4 = z5;
                    i14 = i17;
                } else {
                    gapComposer.skipToGroupEnd();
                    i14 = i3;
                    i15 = i7;
                    z4 = z2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                            String str2 = str;
                            Modifier modifier2 = modifier;
                            TextStyle textStyle2 = textStyle;
                            byte b = i15;
                            boolean z10 = z4;
                            int i20 = i2;
                            boolean z11 = i14;
                            BasicTextKt.m187BasicTextRWo7tUw(str2, modifier2, textStyle2, b, z10, i20, z11 ? 1 : 0, (Composer) obj, iUpdateChangedFlags, i5);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i6 |= 196608;
            z2 = z;
            if ((1572864 & i4) == 0) {
                if (gapComposer.changed(i2)) {
                    i18 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i18 = 524288;
                }
                i6 |= i18;
            }
            i10 = i5 & 128;
            if (i10 != 0) {
                if ((12582912 & i4) == 0) {
                    if (gapComposer.changed(i3)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i6 |= i11;
                }
                i12 = 100663296 | i6;
                if ((i5 & 512) != 0) {
                    i12 = i6 | 905969664;
                } else if ((805306368 & i4) == 0) {
                    if ((1073741824 & i4) == 0) {
                        zChangedInstance = gapComposer.changed((Object) null);
                    } else {
                        zChangedInstance = gapComposer.changedInstance(null);
                    }
                    if (zChangedInstance) {
                        i13 = 536870912;
                    } else {
                        i13 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                    }
                    i12 |= i13;
                }
                if ((306783379 & i12) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z3)) {
                    if (i19 != 0) {
                        i16 = 1;
                    } else {
                        i16 = i7;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        i17 = 1;
                    } else {
                        i17 = i3;
                    }
                    validateMinMaxLines(i17, i2);
                    if (gapComposer.consume(SelectionRegistrarKt.LocalSelectionRegistrar) == null) {
                        PathKt$$ExternalSyntheticBUOutline0.m();
                        return;
                    }
                    gapComposer.startReplaceGroup(357055103);
                    gapComposer.end(false);
                    FontFamily.Resolver resolver3 = (FontFamily.Resolver) gapComposer.consume(CompositionLocalsKt.LocalFontFamilyResolver);
                    executor = (Executor) gapComposer.consume(BasicText_androidKt.LocalBackgroundTextMeasurementExecutor);
                    if (executor == null) {
                        z6 = true;
                        gapComposer.startReplaceGroup(-1248455541);
                        gapComposer.end(false);
                    } else {
                        z6 = true;
                        gapComposer.startReplaceGroup(-1248455541);
                        gapComposer.end(false);
                    }
                    gapComposer.startReplaceGroup(358076243);
                    gapComposer.end(false);
                    boolean z10 = z6;
                    Modifier modifierThen3 = modifier.then(new TextStringSimpleElement(str, textStyle, resolver3, i16, z5, i2, i17));
                    EmptyMeasurePolicy emptyMeasurePolicy3 = EmptyMeasurePolicy.INSTANCE;
                    int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen3);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, emptyMeasurePolicy3, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, ComposeUiNode.Companion.SetModifier);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.SetCompositeKeyHash);
                    gapComposer.end(z10);
                    i15 = i16;
                    z4 = z5;
                    i14 = i17;
                } else {
                    gapComposer.skipToGroupEnd();
                    i14 = i3;
                    i15 = i7;
                    z4 = z2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                            String str2 = str;
                            Modifier modifier2 = modifier;
                            TextStyle textStyle2 = textStyle;
                            byte b = i15;
                            boolean z11 = z4;
                            int i20 = i2;
                            boolean z12 = i14;
                            BasicTextKt.m187BasicTextRWo7tUw(str2, modifier2, textStyle2, b, z11, i20, z12 ? 1 : 0, (Composer) obj, iUpdateChangedFlags, i5);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i6 |= 12582912;
            i12 = 100663296 | i6;
            if ((i5 & 512) != 0) {
                i12 = i6 | 905969664;
            } else if ((805306368 & i4) == 0) {
                if ((1073741824 & i4) == 0) {
                    zChangedInstance = gapComposer.changed((Object) null);
                } else {
                    zChangedInstance = gapComposer.changedInstance(null);
                }
                if (zChangedInstance) {
                    i13 = 536870912;
                } else {
                    i13 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                }
                i12 |= i13;
            }
            if ((306783379 & i12) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (gapComposer.shouldExecute(i12 & 1, z3)) {
                if (i19 != 0) {
                    i16 = 1;
                } else {
                    i16 = i7;
                }
                if (i8 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i10 != 0) {
                    i17 = 1;
                } else {
                    i17 = i3;
                }
                validateMinMaxLines(i17, i2);
                if (gapComposer.consume(SelectionRegistrarKt.LocalSelectionRegistrar) == null) {
                    PathKt$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                gapComposer.startReplaceGroup(357055103);
                gapComposer.end(false);
                FontFamily.Resolver resolver4 = (FontFamily.Resolver) gapComposer.consume(CompositionLocalsKt.LocalFontFamilyResolver);
                executor = (Executor) gapComposer.consume(BasicText_androidKt.LocalBackgroundTextMeasurementExecutor);
                if (executor == null) {
                    z6 = true;
                    gapComposer.startReplaceGroup(-1248455541);
                    gapComposer.end(false);
                } else {
                    z6 = true;
                    gapComposer.startReplaceGroup(-1248455541);
                    gapComposer.end(false);
                }
                gapComposer.startReplaceGroup(358076243);
                gapComposer.end(false);
                boolean z11 = z6;
                Modifier modifierThen4 = modifier.then(new TextStringSimpleElement(str, textStyle, resolver4, i16, z5, i2, i17));
                EmptyMeasurePolicy emptyMeasurePolicy4 = EmptyMeasurePolicy.INSTANCE;
                int iHashCode4 = Long.hashCode(gapComposer.compositeKeyHashCode);
                Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen4);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer.currentCompositionLocalScope();
                ComposeUiNode.Companion.getClass();
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(LayoutNode.Constructor);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, emptyMeasurePolicy4, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m389reconcileimpl(gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier4, ComposeUiNode.Companion.SetModifier);
                Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode4), ComposeUiNode.Companion.SetCompositeKeyHash);
                gapComposer.end(z11);
                i15 = i16;
                z4 = z5;
                i14 = i17;
            } else {
                gapComposer.skipToGroupEnd();
                i14 = i3;
                i15 = i7;
                z4 = z2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                        String str2 = str;
                        Modifier modifier2 = modifier;
                        TextStyle textStyle2 = textStyle;
                        byte b = i15;
                        boolean z12 = z4;
                        int i20 = i2;
                        boolean z13 = i14;
                        BasicTextKt.m187BasicTextRWo7tUw(str2, modifier2, textStyle2, b, z12, i20, z13 ? 1 : 0, (Composer) obj, iUpdateChangedFlags, i5);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i6 |= 24576;
        i7 = i;
        i8 = i5 & 32;
        if (i8 != 0) {
            if ((196608 & i4) == 0) {
                z2 = z;
                if (gapComposer.changed(z2)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i6 |= i9;
            }
            if ((1572864 & i4) == 0) {
                if (gapComposer.changed(i2)) {
                    i18 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i18 = 524288;
                }
                i6 |= i18;
            }
            i10 = i5 & 128;
            if (i10 != 0) {
                if ((12582912 & i4) == 0) {
                    if (gapComposer.changed(i3)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i6 |= i11;
                }
                i12 = 100663296 | i6;
                if ((i5 & 512) != 0) {
                    i12 = i6 | 905969664;
                } else if ((805306368 & i4) == 0) {
                    if ((1073741824 & i4) == 0) {
                        zChangedInstance = gapComposer.changed((Object) null);
                    } else {
                        zChangedInstance = gapComposer.changedInstance(null);
                    }
                    if (zChangedInstance) {
                        i13 = 536870912;
                    } else {
                        i13 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                    }
                    i12 |= i13;
                }
                if ((306783379 & i12) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z3)) {
                    if (i19 != 0) {
                        i16 = 1;
                    } else {
                        i16 = i7;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i10 != 0) {
                        i17 = 1;
                    } else {
                        i17 = i3;
                    }
                    validateMinMaxLines(i17, i2);
                    if (gapComposer.consume(SelectionRegistrarKt.LocalSelectionRegistrar) == null) {
                        PathKt$$ExternalSyntheticBUOutline0.m();
                        return;
                    }
                    gapComposer.startReplaceGroup(357055103);
                    gapComposer.end(false);
                    FontFamily.Resolver resolver5 = (FontFamily.Resolver) gapComposer.consume(CompositionLocalsKt.LocalFontFamilyResolver);
                    executor = (Executor) gapComposer.consume(BasicText_androidKt.LocalBackgroundTextMeasurementExecutor);
                    if (executor == null) {
                        z6 = true;
                        gapComposer.startReplaceGroup(-1248455541);
                        gapComposer.end(false);
                    } else {
                        z6 = true;
                        gapComposer.startReplaceGroup(-1248455541);
                        gapComposer.end(false);
                    }
                    gapComposer.startReplaceGroup(358076243);
                    gapComposer.end(false);
                    boolean z12 = z6;
                    Modifier modifierThen5 = modifier.then(new TextStringSimpleElement(str, textStyle, resolver5, i16, z5, i2, i17));
                    EmptyMeasurePolicy emptyMeasurePolicy5 = EmptyMeasurePolicy.INSTANCE;
                    int iHashCode5 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen5);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer.currentCompositionLocalScope();
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, emptyMeasurePolicy5, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier5, ComposeUiNode.Companion.SetModifier);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode5), ComposeUiNode.Companion.SetCompositeKeyHash);
                    gapComposer.end(z12);
                    i15 = i16;
                    z4 = z5;
                    i14 = i17;
                } else {
                    gapComposer.skipToGroupEnd();
                    i14 = i3;
                    i15 = i7;
                    z4 = z2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                            String str2 = str;
                            Modifier modifier2 = modifier;
                            TextStyle textStyle2 = textStyle;
                            byte b = i15;
                            boolean z13 = z4;
                            int i20 = i2;
                            boolean z14 = i14;
                            BasicTextKt.m187BasicTextRWo7tUw(str2, modifier2, textStyle2, b, z13, i20, z14 ? 1 : 0, (Composer) obj, iUpdateChangedFlags, i5);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i6 |= 12582912;
            i12 = 100663296 | i6;
            if ((i5 & 512) != 0) {
                i12 = i6 | 905969664;
            } else if ((805306368 & i4) == 0) {
                if ((1073741824 & i4) == 0) {
                    zChangedInstance = gapComposer.changed((Object) null);
                } else {
                    zChangedInstance = gapComposer.changedInstance(null);
                }
                if (zChangedInstance) {
                    i13 = 536870912;
                } else {
                    i13 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                }
                i12 |= i13;
            }
            if ((306783379 & i12) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (gapComposer.shouldExecute(i12 & 1, z3)) {
                if (i19 != 0) {
                    i16 = 1;
                } else {
                    i16 = i7;
                }
                if (i8 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i10 != 0) {
                    i17 = 1;
                } else {
                    i17 = i3;
                }
                validateMinMaxLines(i17, i2);
                if (gapComposer.consume(SelectionRegistrarKt.LocalSelectionRegistrar) == null) {
                    PathKt$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                gapComposer.startReplaceGroup(357055103);
                gapComposer.end(false);
                FontFamily.Resolver resolver6 = (FontFamily.Resolver) gapComposer.consume(CompositionLocalsKt.LocalFontFamilyResolver);
                executor = (Executor) gapComposer.consume(BasicText_androidKt.LocalBackgroundTextMeasurementExecutor);
                if (executor == null) {
                    z6 = true;
                    gapComposer.startReplaceGroup(-1248455541);
                    gapComposer.end(false);
                } else {
                    z6 = true;
                    gapComposer.startReplaceGroup(-1248455541);
                    gapComposer.end(false);
                }
                gapComposer.startReplaceGroup(358076243);
                gapComposer.end(false);
                boolean z13 = z6;
                Modifier modifierThen6 = modifier.then(new TextStringSimpleElement(str, textStyle, resolver6, i16, z5, i2, i17));
                EmptyMeasurePolicy emptyMeasurePolicy6 = EmptyMeasurePolicy.INSTANCE;
                int iHashCode6 = Long.hashCode(gapComposer.compositeKeyHashCode);
                Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen6);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer.currentCompositionLocalScope();
                ComposeUiNode.Companion.getClass();
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(LayoutNode.Constructor);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, emptyMeasurePolicy6, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m389reconcileimpl(gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier6, ComposeUiNode.Companion.SetModifier);
                Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode6), ComposeUiNode.Companion.SetCompositeKeyHash);
                gapComposer.end(z13);
                i15 = i16;
                z4 = z5;
                i14 = i17;
            } else {
                gapComposer.skipToGroupEnd();
                i14 = i3;
                i15 = i7;
                z4 = z2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                        String str2 = str;
                        Modifier modifier2 = modifier;
                        TextStyle textStyle2 = textStyle;
                        byte b = i15;
                        boolean z14 = z4;
                        int i20 = i2;
                        boolean z15 = i14;
                        BasicTextKt.m187BasicTextRWo7tUw(str2, modifier2, textStyle2, b, z14, i20, z15 ? 1 : 0, (Composer) obj, iUpdateChangedFlags, i5);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i6 |= 196608;
        z2 = z;
        if ((1572864 & i4) == 0) {
            if (gapComposer.changed(i2)) {
                i18 = ByteChannelKt.CHANNEL_MAX_SIZE;
            } else {
                i18 = 524288;
            }
            i6 |= i18;
        }
        i10 = i5 & 128;
        if (i10 != 0) {
            if ((12582912 & i4) == 0) {
                if (gapComposer.changed(i3)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i6 |= i11;
            }
            i12 = 100663296 | i6;
            if ((i5 & 512) != 0) {
                i12 = i6 | 905969664;
            } else if ((805306368 & i4) == 0) {
                if ((1073741824 & i4) == 0) {
                    zChangedInstance = gapComposer.changed((Object) null);
                } else {
                    zChangedInstance = gapComposer.changedInstance(null);
                }
                if (zChangedInstance) {
                    i13 = 536870912;
                } else {
                    i13 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                }
                i12 |= i13;
            }
            if ((306783379 & i12) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (gapComposer.shouldExecute(i12 & 1, z3)) {
                if (i19 != 0) {
                    i16 = 1;
                } else {
                    i16 = i7;
                }
                if (i8 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i10 != 0) {
                    i17 = 1;
                } else {
                    i17 = i3;
                }
                validateMinMaxLines(i17, i2);
                if (gapComposer.consume(SelectionRegistrarKt.LocalSelectionRegistrar) == null) {
                    PathKt$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                gapComposer.startReplaceGroup(357055103);
                gapComposer.end(false);
                FontFamily.Resolver resolver7 = (FontFamily.Resolver) gapComposer.consume(CompositionLocalsKt.LocalFontFamilyResolver);
                executor = (Executor) gapComposer.consume(BasicText_androidKt.LocalBackgroundTextMeasurementExecutor);
                if (executor == null) {
                    z6 = true;
                    gapComposer.startReplaceGroup(-1248455541);
                    gapComposer.end(false);
                } else {
                    z6 = true;
                    gapComposer.startReplaceGroup(-1248455541);
                    gapComposer.end(false);
                }
                gapComposer.startReplaceGroup(358076243);
                gapComposer.end(false);
                boolean z14 = z6;
                Modifier modifierThen7 = modifier.then(new TextStringSimpleElement(str, textStyle, resolver7, i16, z5, i2, i17));
                EmptyMeasurePolicy emptyMeasurePolicy7 = EmptyMeasurePolicy.INSTANCE;
                int iHashCode7 = Long.hashCode(gapComposer.compositeKeyHashCode);
                Modifier modifierMaterializeModifier7 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen7);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope7 = gapComposer.currentCompositionLocalScope();
                ComposeUiNode.Companion.getClass();
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(LayoutNode.Constructor);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, emptyMeasurePolicy7, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope7, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m389reconcileimpl(gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier7, ComposeUiNode.Companion.SetModifier);
                Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode7), ComposeUiNode.Companion.SetCompositeKeyHash);
                gapComposer.end(z14);
                i15 = i16;
                z4 = z5;
                i14 = i17;
            } else {
                gapComposer.skipToGroupEnd();
                i14 = i3;
                i15 = i7;
                z4 = z2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                        String str2 = str;
                        Modifier modifier2 = modifier;
                        TextStyle textStyle2 = textStyle;
                        byte b = i15;
                        boolean z15 = z4;
                        int i20 = i2;
                        boolean z16 = i14;
                        BasicTextKt.m187BasicTextRWo7tUw(str2, modifier2, textStyle2, b, z15, i20, z16 ? 1 : 0, (Composer) obj, iUpdateChangedFlags, i5);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i6 |= 12582912;
        i12 = 100663296 | i6;
        if ((i5 & 512) != 0) {
            i12 = i6 | 905969664;
        } else if ((805306368 & i4) == 0) {
            if ((1073741824 & i4) == 0) {
                zChangedInstance = gapComposer.changed((Object) null);
            } else {
                zChangedInstance = gapComposer.changedInstance(null);
            }
            if (zChangedInstance) {
                i13 = 536870912;
            } else {
                i13 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
            }
            i12 |= i13;
        }
        if ((306783379 & i12) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (gapComposer.shouldExecute(i12 & 1, z3)) {
            if (i19 != 0) {
                i16 = 1;
            } else {
                i16 = i7;
            }
            if (i8 != 0) {
                z5 = true;
            } else {
                z5 = z2;
            }
            if (i10 != 0) {
                i17 = 1;
            } else {
                i17 = i3;
            }
            validateMinMaxLines(i17, i2);
            if (gapComposer.consume(SelectionRegistrarKt.LocalSelectionRegistrar) == null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
                return;
            }
            gapComposer.startReplaceGroup(357055103);
            gapComposer.end(false);
            FontFamily.Resolver resolver8 = (FontFamily.Resolver) gapComposer.consume(CompositionLocalsKt.LocalFontFamilyResolver);
            executor = (Executor) gapComposer.consume(BasicText_androidKt.LocalBackgroundTextMeasurementExecutor);
            if (executor == null) {
                z6 = true;
                gapComposer.startReplaceGroup(-1248455541);
                gapComposer.end(false);
            } else {
                z6 = true;
                gapComposer.startReplaceGroup(-1248455541);
                gapComposer.end(false);
            }
            gapComposer.startReplaceGroup(358076243);
            gapComposer.end(false);
            boolean z15 = z6;
            Modifier modifierThen8 = modifier.then(new TextStringSimpleElement(str, textStyle, resolver8, i16, z5, i2, i17));
            EmptyMeasurePolicy emptyMeasurePolicy8 = EmptyMeasurePolicy.INSTANCE;
            int iHashCode8 = Long.hashCode(gapComposer.compositeKeyHashCode);
            Modifier modifierMaterializeModifier8 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen8);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope8 = gapComposer.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, emptyMeasurePolicy8, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope8, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier8, ComposeUiNode.Companion.SetModifier);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode8), ComposeUiNode.Companion.SetCompositeKeyHash);
            gapComposer.end(z15);
            i15 = i16;
            z4 = z5;
            i14 = i17;
        } else {
            gapComposer.skipToGroupEnd();
            i14 = i3;
            i15 = i7;
            z4 = z2;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                    String str2 = str;
                    Modifier modifier2 = modifier;
                    TextStyle textStyle2 = textStyle;
                    byte b = i15;
                    boolean z16 = z4;
                    int i20 = i2;
                    boolean z17 = i14;
                    BasicTextKt.m187BasicTextRWo7tUw(str2, modifier2, textStyle2, b, z16, i20, z17 ? 1 : 0, (Composer) obj, iUpdateChangedFlags, i5);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0182 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x0184  */
    /* JADX WARN: Code duplicated, block: B:112:0x0189 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x018b  */
    /* JADX WARN: Code duplicated, block: B:114:0x018d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0195  */
    /* JADX WARN: Code duplicated, block: B:118:0x0198  */
    /* JADX WARN: Code duplicated, block: B:120:0x019b  */
    /* JADX WARN: Code duplicated, block: B:121:0x019e  */
    /* JADX WARN: Code duplicated, block: B:124:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:127:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:128:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:132:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:133:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:135:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:136:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:139:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:140:0x01db  */
    /* JADX WARN: Code duplicated, block: B:143:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:144:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:147:0x01f1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:148:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:150:0x0246  */
    /* JADX WARN: Code duplicated, block: B:153:0x025a  */
    /* JADX WARN: Code duplicated, block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:65:0x00da  */
    /* JADX WARN: Code duplicated, block: B:66:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:74:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:79:0x0106  */
    /* JADX WARN: Code duplicated, block: B:81:0x0111  */
    /* JADX WARN: Code duplicated, block: B:83:0x0119  */
    /* JADX WARN: Code duplicated, block: B:84:0x011c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0127  */
    /* JADX WARN: Code duplicated, block: B:95:0x0142  */
    /* JADX WARN: Code duplicated, block: B:98:0x014b  */
    public static final void BasicTextField(final TextFieldValue textFieldValue, final Function1 function1, final Modifier modifier, boolean z, final TextStyle textStyle, final KeyboardOptions keyboardOptions, final KeyboardActions keyboardActions, final boolean z2, int i, int i2, VisualTransformation visualTransformation, Function1 function2, MutableInteractionSourceImpl mutableInteractionSourceImpl, final SolidColor solidColor, final ComposableLambdaImpl composableLambdaImpl, Composer composer, final int i3, final int i4) {
        boolean z3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        boolean z4;
        GapComposer gapComposer;
        final VisualTransformation visualTransformation2;
        final Function1 function3;
        final MutableInteractionSourceImpl mutableInteractionSourceImpl2;
        final int i23;
        final int i24;
        final boolean z5;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i25;
        NeverEqualPolicy neverEqualPolicy;
        int i26;
        VisualTransformation visualTransformation3;
        Object objRememberedValue;
        Function1 function4;
        MutableInteractionSourceImpl mutableInteractionSourceImpl3;
        int i27;
        VisualTransformation visualTransformation4;
        MutableInteractionSourceImpl mutableInteractionSourceImpl4;
        int i28;
        boolean z6;
        int i29;
        int i30;
        int i31;
        boolean z7;
        boolean z8;
        boolean z9;
        Object objRememberedValue2;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-971111025);
        int i32 = i3 | (gapComposer2.changed(textFieldValue) ? 4 : 2) | (gapComposer2.changedInstance(function1) ? 32 : 16) | (gapComposer2.changed(modifier) ? 256 : 128);
        int i33 = i4 & 8;
        if (i33 != 0) {
            i5 = i32 | 3072;
            z3 = z;
        } else {
            z3 = z;
            i5 = i32 | (gapComposer2.changed(z3) ? 2048 : 1024);
        }
        if ((i4 & 16) != 0) {
            i6 = i5 | 24576;
        } else {
            i6 = i5 | (gapComposer2.changed(false) ? 16384 : 8192);
        }
        int i34 = i6 | (gapComposer2.changed(textStyle) ? 131072 : 65536);
        if ((i3 & 1572864) == 0) {
            i34 |= gapComposer2.changed(keyboardOptions) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        int i35 = i34 | (gapComposer2.changed(keyboardActions) ? 8388608 : 4194304);
        if ((i3 & 100663296) == 0) {
            i35 |= gapComposer2.changed(z2) ? 67108864 : 33554432;
        }
        if ((i4 & 512) == 0) {
            i7 = i;
            if (gapComposer2.changed(i7)) {
                i8 = 536870912;
            }
            int i36 = i35 | i8;
            i9 = i4 & 1024;
            if (i9 != 0) {
                i12 = 196614;
                i10 = i2;
            } else {
                i10 = i2;
                if (gapComposer2.changed(i10)) {
                    i11 = 4;
                } else {
                    i11 = 2;
                }
                i12 = 196608 | i11;
            }
            i13 = i4 & 2048;
            if (i13 != 0) {
                i15 = i12 | 48;
            } else {
                if (gapComposer2.changed(visualTransformation)) {
                    i14 = 32;
                } else {
                    i14 = 16;
                }
                i15 = i12 | i14;
            }
            i16 = i36;
            i17 = i15;
            i18 = i17 | 384;
            i19 = i4 & 8192;
            if (i19 != 0) {
                i21 = i17 | 3456;
            } else {
                if (gapComposer2.changed(mutableInteractionSourceImpl)) {
                    i20 = 2048;
                } else {
                    i20 = 1024;
                }
                i21 = i18 | i20;
            }
            i22 = i21 | (gapComposer2.changed(solidColor) ? 16384 : 8192);
            if ((i16 & 306783379) == 306783378 || (i22 & 74899) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (gapComposer2.shouldExecute(i16 & 1, z4)) {
                gapComposer2.startDefaults();
                i25 = i3 & 1;
                neverEqualPolicy = Composer.Companion.Empty;
                if (i25 != 0 || gapComposer2.getDefaultsInvalid()) {
                    if (i33 != 0) {
                        z3 = true;
                    }
                    if ((i4 & 512) != 0) {
                        if (z2) {
                            i26 = 1;
                        } else {
                            i26 = Integer.MAX_VALUE;
                        }
                        i16 &= -1879048193;
                    } else {
                        i26 = i7;
                    }
                    if (i9 != 0) {
                        i10 = 1;
                    }
                    if (i13 != 0) {
                        visualTransformation3 = VisualTransformation.Companion.None;
                    } else {
                        visualTransformation3 = visualTransformation;
                    }
                    objRememberedValue = gapComposer2.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new OffsetKt$$ExternalSyntheticLambda0((byte) 23);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    function4 = (Function1) objRememberedValue;
                    if (i19 != 0) {
                        mutableInteractionSourceImpl3 = null;
                    } else {
                        mutableInteractionSourceImpl3 = mutableInteractionSourceImpl;
                    }
                    i27 = i26;
                    visualTransformation4 = visualTransformation3;
                    mutableInteractionSourceImpl4 = mutableInteractionSourceImpl3;
                } else {
                    gapComposer2.skipToGroupEnd();
                    if ((i4 & 512) != 0) {
                        visualTransformation4 = visualTransformation;
                        function4 = function2;
                        i27 = i7;
                        i28 = i10;
                        z6 = z3;
                        i29 = i16 & (-1879048193);
                        mutableInteractionSourceImpl4 = mutableInteractionSourceImpl;
                    } else {
                        visualTransformation4 = visualTransformation;
                        function4 = function2;
                        mutableInteractionSourceImpl4 = mutableInteractionSourceImpl;
                        i27 = i7;
                    }
                    gapComposer2.endDefaults();
                    Function1 function5 = function4;
                    ImeOptions imeOptions$foundation = keyboardOptions.toImeOptions$foundation(z2);
                    boolean z10 = !z2;
                    if (z2) {
                        i30 = 1;
                    } else {
                        i30 = i28;
                    }
                    if (z2) {
                        i31 = 1;
                    } else {
                        i31 = i27;
                    }
                    if ((i29 & 14) == 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    boolean z11 = z7;
                    if ((i29 & 112) == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z11 | z8;
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (z9 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) textFieldValue, (Object) function1, (byte) 1);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    int i37 = i22 << 9;
                    gapComposer = gapComposer2;
                    CoreTextField(textFieldValue, (Function1) objRememberedValue2, modifier, textStyle, visualTransformation4, function5, mutableInteractionSourceImpl4, solidColor, z10, i31, i30, imeOptions$foundation, keyboardActions, z6, false, composableLambdaImpl, gapComposer, (i29 & 910) | ((i29 >> 6) & 7168) | (i37 & 57344) | 196608 | (i37 & 3670016) | (i37 & 29360128), ((i29 >> 15) & 896) | (i29 & 7168) | (i29 & 57344) | 196608);
                    visualTransformation2 = visualTransformation4;
                    function3 = function5;
                    z5 = z6;
                    i23 = i27;
                    i24 = i28;
                    mutableInteractionSourceImpl2 = mutableInteractionSourceImpl4;
                }
                i28 = i10;
                z6 = z3;
                i29 = i16;
                gapComposer2.endDefaults();
                Function1 function6 = function4;
                ImeOptions imeOptions$foundation2 = keyboardOptions.toImeOptions$foundation(z2);
                boolean z12 = !z2;
                if (z2) {
                    i30 = 1;
                } else {
                    i30 = i28;
                }
                if (z2) {
                    i31 = 1;
                } else {
                    i31 = i27;
                }
                if ((i29 & 14) == 4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                boolean z13 = z7;
                if ((i29 & 112) == 32) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z13 | z8;
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (z9) {
                    objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) textFieldValue, (Object) function1, (byte) 1);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) textFieldValue, (Object) function1, (byte) 1);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                int i38 = i22 << 9;
                gapComposer = gapComposer2;
                CoreTextField(textFieldValue, (Function1) objRememberedValue2, modifier, textStyle, visualTransformation4, function6, mutableInteractionSourceImpl4, solidColor, z12, i31, i30, imeOptions$foundation2, keyboardActions, z6, false, composableLambdaImpl, gapComposer, (i29 & 910) | ((i29 >> 6) & 7168) | (i38 & 57344) | 196608 | (i38 & 3670016) | (i38 & 29360128), ((i29 >> 15) & 896) | (i29 & 7168) | (i29 & 57344) | 196608);
                visualTransformation2 = visualTransformation4;
                function3 = function6;
                z5 = z6;
                i23 = i27;
                i24 = i28;
                mutableInteractionSourceImpl2 = mutableInteractionSourceImpl4;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                visualTransformation2 = visualTransformation;
                function3 = function2;
                mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                i23 = i7;
                i24 = i10;
                z5 = z3;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                        TextFieldValue textFieldValue2 = textFieldValue;
                        Function1 function7 = function1;
                        Modifier modifier2 = modifier;
                        boolean z14 = z5;
                        TextStyle textStyle2 = textStyle;
                        KeyboardOptions keyboardOptions2 = keyboardOptions;
                        KeyboardActions keyboardActions2 = keyboardActions;
                        boolean z15 = z2;
                        int i39 = i23;
                        boolean z16 = i24;
                        VisualTransformation visualTransformation5 = visualTransformation2;
                        Function1 function8 = function3;
                        MutableInteractionSourceImpl mutableInteractionSourceImpl5 = mutableInteractionSourceImpl2;
                        SolidColor solidColor2 = solidColor;
                        ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImpl;
                        short s = i4;
                        BasicTextKt.BasicTextField(textFieldValue2, function7, modifier2, z14, textStyle2, keyboardOptions2, keyboardActions2, z15, i39, z16 ? 1 : 0, visualTransformation5, function8, mutableInteractionSourceImpl5, solidColor2, composableLambdaImpl2, (Composer) obj, iUpdateChangedFlags, s);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i7 = i;
        i8 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        int i39 = i35 | i8;
        i9 = i4 & 1024;
        if (i9 != 0) {
            i12 = 196614;
            i10 = i2;
        } else {
            i10 = i2;
            if (gapComposer2.changed(i10)) {
                i11 = 4;
            } else {
                i11 = 2;
            }
            i12 = 196608 | i11;
        }
        i13 = i4 & 2048;
        if (i13 != 0) {
            i15 = i12 | 48;
        } else {
            if (gapComposer2.changed(visualTransformation)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i15 = i12 | i14;
        }
        i16 = i39;
        i17 = i15;
        i18 = i17 | 384;
        i19 = i4 & 8192;
        if (i19 != 0) {
            i21 = i17 | 3456;
        } else {
            if (gapComposer2.changed(mutableInteractionSourceImpl)) {
                i20 = 2048;
            } else {
                i20 = 1024;
            }
            i21 = i18 | i20;
        }
        i22 = i21 | (gapComposer2.changed(solidColor) ? 16384 : 8192);
        if ((i16 & 306783379) == 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (gapComposer2.shouldExecute(i16 & 1, z4)) {
            gapComposer2.startDefaults();
            i25 = i3 & 1;
            neverEqualPolicy = Composer.Companion.Empty;
            if (i25 != 0) {
                if (i33 != 0) {
                    z3 = true;
                }
                if ((i4 & 512) != 0) {
                    if (z2) {
                        i26 = 1;
                    } else {
                        i26 = Integer.MAX_VALUE;
                    }
                    i16 &= -1879048193;
                } else {
                    i26 = i7;
                }
                if (i9 != 0) {
                    i10 = 1;
                }
                if (i13 != 0) {
                    visualTransformation3 = VisualTransformation.Companion.None;
                } else {
                    visualTransformation3 = visualTransformation;
                }
                objRememberedValue = gapComposer2.rememberedValue();
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new OffsetKt$$ExternalSyntheticLambda0((byte) 23);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                function4 = (Function1) objRememberedValue;
                if (i19 != 0) {
                    mutableInteractionSourceImpl3 = null;
                } else {
                    mutableInteractionSourceImpl3 = mutableInteractionSourceImpl;
                }
                i27 = i26;
                visualTransformation4 = visualTransformation3;
                mutableInteractionSourceImpl4 = mutableInteractionSourceImpl3;
                i28 = i10;
                z6 = z3;
                i29 = i16;
            } else {
                if (i33 != 0) {
                    z3 = true;
                }
                if ((i4 & 512) != 0) {
                    if (z2) {
                        i26 = 1;
                    } else {
                        i26 = Integer.MAX_VALUE;
                    }
                    i16 &= -1879048193;
                } else {
                    i26 = i7;
                }
                if (i9 != 0) {
                    i10 = 1;
                }
                if (i13 != 0) {
                    visualTransformation3 = VisualTransformation.Companion.None;
                } else {
                    visualTransformation3 = visualTransformation;
                }
                objRememberedValue = gapComposer2.rememberedValue();
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new OffsetKt$$ExternalSyntheticLambda0((byte) 23);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                function4 = (Function1) objRememberedValue;
                if (i19 != 0) {
                    mutableInteractionSourceImpl3 = null;
                } else {
                    mutableInteractionSourceImpl3 = mutableInteractionSourceImpl;
                }
                i27 = i26;
                visualTransformation4 = visualTransformation3;
                mutableInteractionSourceImpl4 = mutableInteractionSourceImpl3;
                i28 = i10;
                z6 = z3;
                i29 = i16;
            }
            gapComposer2.endDefaults();
            Function1 function7 = function4;
            ImeOptions imeOptions$foundation3 = keyboardOptions.toImeOptions$foundation(z2);
            boolean z14 = !z2;
            if (z2) {
                i30 = 1;
            } else {
                i30 = i28;
            }
            if (z2) {
                i31 = 1;
            } else {
                i31 = i27;
            }
            if ((i29 & 14) == 4) {
                z7 = true;
            } else {
                z7 = false;
            }
            boolean z15 = z7;
            if ((i29 & 112) == 32) {
                z8 = true;
            } else {
                z8 = false;
            }
            z9 = z15 | z8;
            objRememberedValue2 = gapComposer2.rememberedValue();
            if (z9) {
                objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) textFieldValue, (Object) function1, (byte) 1);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) textFieldValue, (Object) function1, (byte) 1);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            int i310 = i22 << 9;
            gapComposer = gapComposer2;
            CoreTextField(textFieldValue, (Function1) objRememberedValue2, modifier, textStyle, visualTransformation4, function7, mutableInteractionSourceImpl4, solidColor, z14, i31, i30, imeOptions$foundation3, keyboardActions, z6, false, composableLambdaImpl, gapComposer, (i29 & 910) | ((i29 >> 6) & 7168) | (i310 & 57344) | 196608 | (i310 & 3670016) | (i310 & 29360128), ((i29 >> 15) & 896) | (i29 & 7168) | (i29 & 57344) | 196608);
            visualTransformation2 = visualTransformation4;
            function3 = function7;
            z5 = z6;
            i23 = i27;
            i24 = i28;
            mutableInteractionSourceImpl2 = mutableInteractionSourceImpl4;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            visualTransformation2 = visualTransformation;
            function3 = function2;
            mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
            i23 = i7;
            i24 = i10;
            z5 = z3;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                    TextFieldValue textFieldValue2 = textFieldValue;
                    Function1 function8 = function1;
                    Modifier modifier2 = modifier;
                    boolean z16 = z5;
                    TextStyle textStyle2 = textStyle;
                    KeyboardOptions keyboardOptions2 = keyboardOptions;
                    KeyboardActions keyboardActions2 = keyboardActions;
                    boolean z17 = z2;
                    int i311 = i23;
                    boolean z18 = i24;
                    VisualTransformation visualTransformation5 = visualTransformation2;
                    Function1 function9 = function3;
                    MutableInteractionSourceImpl mutableInteractionSourceImpl5 = mutableInteractionSourceImpl2;
                    SolidColor solidColor2 = solidColor;
                    ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImpl;
                    short s = i4;
                    BasicTextKt.BasicTextField(textFieldValue2, function8, modifier2, z16, textStyle2, keyboardOptions2, keyboardActions2, z17, i311, z18 ? 1 : 0, visualTransformation5, function9, mutableInteractionSourceImpl5, solidColor2, composableLambdaImpl2, (Composer) obj, iUpdateChangedFlags, s);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0051  */
    /* JADX WARN: Code duplicated, block: B:26:0x0059  */
    /* JADX WARN: Code duplicated, block: B:27:0x005c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0063  */
    /* JADX WARN: Code duplicated, block: B:32:0x0069  */
    /* JADX WARN: Code duplicated, block: B:34:0x0071  */
    /* JADX WARN: Code duplicated, block: B:35:0x0074  */
    /* JADX WARN: Code duplicated, block: B:39:0x007f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0081  */
    /* JADX WARN: Code duplicated, block: B:43:0x0090  */
    /* JADX WARN: Code duplicated, block: B:44:0x0092  */
    /* JADX WARN: Code duplicated, block: B:47:0x009b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x009d  */
    /* JADX WARN: Code duplicated, block: B:49:0x009f  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:53:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:66:0x00da  */
    /* JADX WARN: Code duplicated, block: B:67:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:75:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:79:0x0105  */
    /* JADX WARN: Code duplicated, block: B:81:0x0132  */
    /* JADX WARN: Code duplicated, block: B:84:0x0143  */
    /* JADX WARN: Code duplicated, block: B:86:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: ClickableText-4YKlhWE, reason: not valid java name */
    public static final void m188ClickableText4YKlhWE(final AnnotatedString annotatedString, Modifier modifier, final TextStyle textStyle, boolean z, int i, int i2, Function1 function1, final Function1 function2, Composer composer, final int i3, final int i4) {
        int i5;
        int i6;
        final int i7;
        int i8;
        int i9;
        int i10;
        Function1 function3;
        int i11;
        int i12;
        int i13;
        int i14;
        byte b;
        boolean z2;
        GapComposer gapComposer;
        final Modifier modifier2;
        final boolean z3;
        final int i15;
        final Function1 function4;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i16;
        int i17;
        NeverEqualPolicy neverEqualPolicy;
        Function1 function5;
        Object objRememberedValue;
        MutableState mutableState;
        boolean z4;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-246609449);
        int i18 = (gapComposer2.changed(annotatedString) ? 4 : 2) | i3 | 48 | (gapComposer2.changed(textStyle) ? 256 : 128);
        int i19 = i18 | 3072;
        int i20 = i4 & 16;
        if (i20 == 0) {
            if ((i3 & 24576) == 0) {
                i5 = i;
                i19 |= gapComposer2.changed(i5) ? 16384 : 8192;
            }
            i6 = i4 & 32;
            if (i6 != 0) {
                i9 = i19 | 196608;
                i7 = i2;
            } else {
                i7 = i2;
                if (gapComposer2.changed(i7)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i9 = i19 | i8;
            }
            i10 = i4 & 64;
            if (i10 != 0) {
                i12 = i9 | 1572864;
                function3 = function1;
            } else {
                function3 = function1;
                if (gapComposer2.changedInstance(function3)) {
                    i11 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i11 = 524288;
                }
                i12 = i9 | i11;
            }
            if (gapComposer2.changedInstance(function2)) {
                i13 = 8388608;
            } else {
                i13 = 4194304;
            }
            i14 = i12 | i13;
            b = 1;
            if ((4793491 & i14) != 4793490) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                if (i20 != 0) {
                    i16 = 1;
                } else {
                    i16 = i5;
                }
                if (i6 != 0) {
                    i17 = Integer.MAX_VALUE;
                } else {
                    i17 = i7;
                }
                neverEqualPolicy = Composer.Companion.Empty;
                if (i10 != 0) {
                    objRememberedValue4 = gapComposer2.rememberedValue();
                    if (objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new OffsetKt$$ExternalSyntheticLambda0((byte) 25);
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    function5 = (Function1) objRememberedValue4;
                } else {
                    function5 = function3;
                }
                objRememberedValue = gapComposer2.rememberedValue();
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.mutableStateOf$default(null);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                if ((29360128 & i14) == 8388608) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (z4 || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new BottomSheetKt$BottomSheet$3$1(mutableState, function2, b);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function2, (PointerInputEventHandler) objRememberedValue2);
                b = (i14 & 3670016) != 1048576 ? (byte) 0 : (byte) 1;
                objRememberedValue3 = gapComposer2.rememberedValue();
                if (b == 0 || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new ClickableTextKt$$ExternalSyntheticLambda1(mutableState, function5, (byte) 0);
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                gapComposer = gapComposer2;
                m186BasicTextCL7eQgs(annotatedString, modifierPointerInput, textStyle, (Function1) objRememberedValue3, i16, true, i17, 0, null, gapComposer, (58254 & i14) | 196608 | ((i14 << 3) & 3670016), 0, 1920);
                function4 = function5;
                modifier2 = companion;
                i15 = i16;
                z3 = true;
                i7 = i17;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                modifier2 = modifier;
                z3 = z;
                i15 = i5;
                function4 = function3;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        BasicTextKt.m188ClickableText4YKlhWE(annotatedString, modifier2, textStyle, z3, i15, i7, function4, function2, (Composer) obj, Stack.updateChangedFlags(i3 | 1), i4);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i19 = i18 | 27648;
        i5 = i;
        i6 = i4 & 32;
        if (i6 != 0) {
            i9 = i19 | 196608;
            i7 = i2;
        } else {
            i7 = i2;
            if (gapComposer2.changed(i7)) {
                i8 = 131072;
            } else {
                i8 = 65536;
            }
            i9 = i19 | i8;
        }
        i10 = i4 & 64;
        if (i10 != 0) {
            i12 = i9 | 1572864;
            function3 = function1;
        } else {
            function3 = function1;
            if (gapComposer2.changedInstance(function3)) {
                i11 = ByteChannelKt.CHANNEL_MAX_SIZE;
            } else {
                i11 = 524288;
            }
            i12 = i9 | i11;
        }
        if (gapComposer2.changedInstance(function2)) {
            i13 = 8388608;
        } else {
            i13 = 4194304;
        }
        i14 = i12 | i13;
        b = 1;
        if ((4793491 & i14) != 4793490) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (gapComposer2.shouldExecute(i14 & 1, z2)) {
            if (i20 != 0) {
                i16 = 1;
            } else {
                i16 = i5;
            }
            if (i6 != 0) {
                i17 = Integer.MAX_VALUE;
            } else {
                i17 = i7;
            }
            neverEqualPolicy = Composer.Companion.Empty;
            if (i10 != 0) {
                objRememberedValue4 = gapComposer2.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new OffsetKt$$ExternalSyntheticLambda0((byte) 25);
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                }
                function5 = (Function1) objRememberedValue4;
            } else {
                function5 = function3;
            }
            objRememberedValue = gapComposer2.rememberedValue();
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(null);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            if ((29360128 & i14) == 8388608) {
                z4 = true;
            } else {
                z4 = false;
            }
            objRememberedValue2 = gapComposer2.rememberedValue();
            if (z4) {
                objRememberedValue2 = new BottomSheetKt$BottomSheet$3$1(mutableState, function2, b);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new BottomSheetKt$BottomSheet$3$1(mutableState, function2, b);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            Modifier modifierPointerInput2 = SuspendingPointerInputFilterKt.pointerInput(companion2, function2, (PointerInputEventHandler) objRememberedValue2);
            if ((i14 & 3670016) != 1048576) {
            }
            objRememberedValue3 = gapComposer2.rememberedValue();
            if (b == 0) {
                objRememberedValue3 = new ClickableTextKt$$ExternalSyntheticLambda1(mutableState, function5, (byte) 0);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new ClickableTextKt$$ExternalSyntheticLambda1(mutableState, function5, (byte) 0);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            gapComposer = gapComposer2;
            m186BasicTextCL7eQgs(annotatedString, modifierPointerInput2, textStyle, (Function1) objRememberedValue3, i16, true, i17, 0, null, gapComposer, (58254 & i14) | 196608 | ((i14 << 3) & 3670016), 0, 1920);
            function4 = function5;
            modifier2 = companion2;
            i15 = i16;
            z3 = true;
            i7 = i17;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            z3 = z;
            i15 = i5;
            function4 = function3;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    BasicTextKt.m188ClickableText4YKlhWE(annotatedString, modifier2, textStyle, z3, i15, i7, function4, function2, (Composer) obj, Stack.updateChangedFlags(i3 | 1), i4);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void CommonContextMenuArea(TextFieldSelectionManager textFieldSelectionManager, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        Modifier modifierTextContextMenuToolbarHandler;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1533506138);
        byte b = 2;
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        byte b2 = 1;
        byte b3 = 0;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            gapComposer.startReplaceGroup(-885604480);
            if (textFieldSelectionManager.getEnabled()) {
                Continuation continuation = null;
                modifierTextContextMenuToolbarHandler = TextContextMenuModifierKt.textContextMenuToolbarHandler(TextContextMenuModifierKt.showTextContextMenuOnSecondaryClick(new TextFieldSelectionManager$paste$1(textFieldSelectionManager, continuation, b2)), textFieldSelectionManager.toolbarRequester, new SyncUtils$executeSyncPlaylist$2.AnonymousClass1(textFieldSelectionManager, continuation, b2), new TextFieldSelectionManager$contextMenuAreaModifier$3(textFieldSelectionManager, continuation, b3), new CoreTextFieldKt$$ExternalSyntheticLambda7(textFieldSelectionManager, b));
            } else {
                modifierTextContextMenuToolbarHandler = Modifier.Companion.$$INSTANCE;
            }
            AndroidTextContextMenuToolbarProvider_androidKt.ProvideDefaultPlatformTextContextMenuProviders(modifierTextContextMenuToolbarHandler, composableLambdaImpl, gapComposer, i2 & 112);
            gapComposer.end(false);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ContextMenu_androidKt$$ExternalSyntheticLambda0(textFieldSelectionManager, composableLambdaImpl, i, b2);
        }
    }

    public static final void ContextMenuArea(TextFieldSelectionManager textFieldSelectionManager, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(2080741862);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        byte b = 0;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            CommonContextMenuArea(textFieldSelectionManager, composableLambdaImpl, gapComposer, i2 & 126);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ContextMenu_androidKt$$ExternalSyntheticLambda0(textFieldSelectionManager, composableLambdaImpl, i, b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v21, types: [androidx.compose.ui.Modifier] */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v18 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.ModVisitor.anonymousCallArgMod(ModVisitor.java:535)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:528)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:111)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    public static final void CoreTextField(androidx.compose.ui.text.input.TextFieldValue r67, kotlin.jvm.functions.Function1 r68, androidx.compose.ui.Modifier r69, androidx.compose.ui.text.TextStyle r70, androidx.compose.ui.text.input.VisualTransformation r71, kotlin.jvm.functions.Function1 r72, androidx.compose.foundation.interaction.MutableInteractionSourceImpl r73, androidx.compose.ui.graphics.SolidColor r74, boolean r75, int r76, int r77, androidx.compose.ui.text.input.ImeOptions r78, androidx.compose.foundation.text.KeyboardActions r79, boolean r80, boolean r81, androidx.compose.runtime.internal.ComposableLambdaImpl r82, androidx.compose.runtime.Composer r83, int r84, int r85) {
        /*
            Method dump skipped, instruction units count: 2571
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.CoreTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSourceImpl, androidx.compose.ui.graphics.SolidColor, boolean, int, int, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.text.KeyboardActions, boolean, boolean, androidx.compose.runtime.internal.ComposableLambdaImpl, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void CoreTextFieldRootBox(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(2036174316);
        int i2 = (gapComposer.changed(modifier) ? 4 : 2) | i | (gapComposer.changedInstance(textFieldSelectionManager) ? 32 : 16);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifier);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            ContextMenuArea(textFieldSelectionManager, composableLambdaImpl, gapComposer, (i2 >> 3) & 126);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda9((byte) 2, i, modifier, textFieldSelectionManager, composableLambdaImpl);
        }
    }

    /* JADX INFO: renamed from: CursorHandle-USBMPiE, reason: not valid java name */
    public static final void m189CursorHandleUSBMPiE(OffsetProvider offsetProvider, Modifier modifier, long j, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1776202187);
        int i3 = (gapComposer.changed(offsetProvider) ? 4 : 2) | i | (gapComposer.changed(modifier) ? 32 : 16) | 128;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                i2 = i3 & (-897);
                j = 9205357640488583168L;
            } else {
                gapComposer.skipToGroupEnd();
                i2 = i3 & (-897);
            }
            gapComposer.endDefaults();
            int i4 = i2 & 14;
            boolean z = i4 == 4;
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new ScrollState$$ExternalSyntheticLambda0((byte) 21, offsetProvider);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            FileSystemsKt.HandlePopup(offsetProvider, Alignment.Companion.TopCenter, Expect_jvmKt.rememberComposableLambda(-1653527038, new AuralysBrandKt$$ExternalSyntheticLambda6(j, SemanticsModifierKt.semantics(modifier, false, (Function1) objRememberedValue)), gapComposer), gapComposer, i4 | 432);
        } else {
            gapComposer.skipToGroupEnd();
        }
        long j2 = j;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda4(offsetProvider, modifier, j2, i, (byte) 1);
        }
    }

    public static final void DefaultCursorHandle(Modifier modifier, Composer composer, int i, int i2) {
        int i3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(694251107);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else {
            i3 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        }
        byte b = 1;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 3) != 2)) {
            if (i4 != 0) {
                modifier = Modifier.Companion.$$INSTANCE;
            }
            OffsetKt.Spacer(gapComposer, ClipKt.drawWithCache(SizeKt.m152sizeVpY3zN4(modifier, 20.710678f, 25.0f), new InnerTube$$ExternalSyntheticLambda2(((TextSelectionColors) gapComposer.consume(TextSelectionColorsKt.LocalTextSelectionColors)).handleColor, b)));
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new StringsKt__StringsKt$$ExternalSyntheticLambda1(modifier, i, i2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:157:0x0201  */
    /* JADX INFO: renamed from: LayoutWithLinksAndInlineContent-11Od_4g, reason: not valid java name */
    public static final void m190LayoutWithLinksAndInlineContent11Od_4g(final Modifier modifier, AnnotatedString annotatedString, final Function1 function1, final boolean z, final Map map, final TextStyle textStyle, final int i, final boolean z2, final int i2, final int i3, final FontFamily.Resolver resolver, final Function1 function2, Composer composer, final int i4, final int i5) {
        int i6;
        int i7;
        TextLinkScope textLinkScope;
        Function0 function0;
        Pair pair;
        MutableState mutableState;
        MutableState mutableState2;
        Function1 function3;
        Object obj;
        Object textMeasurePolicy;
        boolean z3;
        boolean z4;
        Object obj2;
        Object obj3;
        Object obj4;
        final AnnotatedString annotatedString2 = annotatedString;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-2118572703);
        if ((i4 & 6) == 0) {
            i6 = (gapComposer.changed(modifier) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= gapComposer.changed(annotatedString2) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i6 |= gapComposer.changedInstance(function1) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            i6 |= gapComposer.changed(z) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i6 |= gapComposer.changedInstance(map) ? 16384 : 8192;
        }
        if ((196608 & i4) == 0) {
            i6 |= gapComposer.changed(textStyle) ? 131072 : 65536;
        }
        if ((i4 & 1572864) == 0) {
            i6 |= gapComposer.changed(i) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((i4 & 12582912) == 0) {
            i6 |= gapComposer.changed(z2) ? 8388608 : 4194304;
        }
        if ((i4 & 100663296) == 0) {
            i6 |= gapComposer.changed(i2) ? 67108864 : 33554432;
        }
        if ((i4 & 805306368) == 0) {
            i6 |= gapComposer.changed(i3) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        if ((i5 & 6) == 0) {
            i7 = i5 | (gapComposer.changedInstance(resolver) ? 4 : 2);
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= gapComposer.changedInstance(null) ? 32 : 16;
        }
        int i8 = i6;
        if ((i5 & 384) == 0) {
            i7 |= gapComposer.changedInstance(null) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= gapComposer.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= (32768 & i5) == 0 ? gapComposer.changed((Object) null) : gapComposer.changedInstance(null) ? 16384 : 8192;
        }
        if (gapComposer.shouldExecute(i8 & 1, ((i8 & 306783379) == 306783378 && (i7 & 9363) == 9362) ? false : true)) {
            boolean zHasLinks = MathKt.hasLinks(annotatedString2);
            Object obj5 = Composer.Companion.Empty;
            if (zHasLinks) {
                gapComposer.startReplaceGroup(145641571);
                boolean z5 = (i8 & 112) == 32;
                Object objRememberedValue = gapComposer.rememberedValue();
                Object obj6 = objRememberedValue;
                if (z5 || objRememberedValue == obj5) {
                    Object textLinkScope2 = new TextLinkScope(annotatedString2);
                    gapComposer.updateRememberedValue(textLinkScope2);
                    obj6 = textLinkScope2;
                }
                textLinkScope = (TextLinkScope) obj6;
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(145707228);
                gapComposer.end(false);
                textLinkScope = null;
            }
            if (MathKt.hasLinks(annotatedString2)) {
                gapComposer.startReplaceGroup(145905443);
                boolean zChanged = ((i8 & 112) == 32) | gapComposer.changed(textLinkScope);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                Object obj7 = objRememberedValue2;
                if (zChanged || objRememberedValue2 == obj5) {
                    Object recomposer$$ExternalSyntheticLambda6 = new Recomposer$$ExternalSyntheticLambda6((Object) textLinkScope, (Object) annotatedString2, (byte) 10);
                    gapComposer.updateRememberedValue(recomposer$$ExternalSyntheticLambda6);
                    obj7 = recomposer$$ExternalSyntheticLambda6;
                }
                function0 = (Function0) obj7;
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(146002721);
                boolean z6 = (i8 & 112) == 32;
                Object objRememberedValue3 = gapComposer.rememberedValue();
                Object obj8 = objRememberedValue3;
                if (z6 || objRememberedValue3 == obj5) {
                    Object sliderState$$ExternalSyntheticLambda0 = new SliderState$$ExternalSyntheticLambda0((byte) 12, annotatedString2);
                    gapComposer.updateRememberedValue(sliderState$$ExternalSyntheticLambda0);
                    obj8 = sliderState$$ExternalSyntheticLambda0;
                }
                function0 = (Function0) obj8;
                gapComposer.end(false);
            }
            if (z) {
                if (map != null) {
                    Pair pair2 = AnnotatedStringResolveInlineContentKt.EmptyInlineContent;
                    if (map.isEmpty()) {
                        pair = AnnotatedStringResolveInlineContentKt.EmptyInlineContent;
                    } else {
                        List stringAnnotations = annotatedString2.getStringAnnotations(0, annotatedString2.text.length(), "androidx.compose.foundation.text.inlineContent");
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        int size = stringAnnotations.size();
                        int i9 = 0;
                        while (i9 < size) {
                            List list = stringAnnotations;
                            if (map.get(((AnnotatedString.Range) stringAnnotations.get(i9)).item) != null) {
                                PathKt$$ExternalSyntheticBUOutline0.m();
                                return;
                            } else {
                                i9++;
                                stringAnnotations = list;
                            }
                        }
                        pair = new Pair(arrayList, arrayList2);
                    }
                } else {
                    pair = AnnotatedStringResolveInlineContentKt.EmptyInlineContent;
                }
                mutableState = null;
            } else {
                textLinkScope = textLinkScope;
                mutableState = null;
                pair = new Pair(null, null);
            }
            List list2 = (List) pair.first;
            List list3 = (List) pair.second;
            if (z) {
                gapComposer.startReplaceGroup(146318828);
                Object objRememberedValue4 = gapComposer.rememberedValue();
                if (objRememberedValue4 == obj5) {
                    obj4 = objRememberedValue4;
                    Object objMutableStateOf$default = Stack.mutableStateOf$default(mutableState);
                    gapComposer.updateRememberedValue(objMutableStateOf$default);
                    obj4 = objMutableStateOf$default;
                }
                obj4 = objRememberedValue4;
                mutableState2 = (MutableState) obj4;
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(146406588);
                gapComposer.end(false);
                mutableState2 = mutableState;
            }
            if (z) {
                gapComposer.startReplaceGroup(146499837);
                boolean zChanged2 = gapComposer.changed(mutableState2);
                Object objRememberedValue5 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue5 == obj5) {
                    obj3 = objRememberedValue5;
                    Object tooltipKt$$ExternalSyntheticLambda5 = new TooltipKt$$ExternalSyntheticLambda5(mutableState2, (byte) 4);
                    gapComposer.updateRememberedValue(tooltipKt$$ExternalSyntheticLambda5);
                    obj3 = tooltipKt$$ExternalSyntheticLambda5;
                }
                gapComposer.end(false);
                function3 = (Function1) obj3;
            } else {
                gapComposer.startReplaceGroup(146571260);
                gapComposer.end(false);
                function3 = null;
            }
            int i10 = (i8 >> 3) & 14;
            MutableState mutableState3 = mutableState2;
            TextLinkScope textLinkScope3 = textLinkScope;
            BasicText_androidKt.BackgroundTextMeasurement(annotatedString, textStyle, resolver, list2, z2, gapComposer);
            annotatedString2 = annotatedString;
            AnnotatedString annotatedString3 = (AnnotatedString) function0.invoke();
            boolean zChangedInstance = gapComposer.changedInstance(textLinkScope3) | ((i8 & 896) == 256);
            Object objRememberedValue6 = gapComposer.rememberedValue();
            Object obj9 = objRememberedValue6;
            if (zChangedInstance || objRememberedValue6 == obj5) {
                Object basicTextKt$$ExternalSyntheticLambda5 = new BasicTextKt$$ExternalSyntheticLambda5(textLinkScope3, function1, (byte) 0);
                gapComposer.updateRememberedValue(basicTextKt$$ExternalSyntheticLambda5);
                obj9 = basicTextKt$$ExternalSyntheticLambda5;
            }
            Modifier modifierM193textModifierCL7eQgs = m193textModifierCL7eQgs(modifier, annotatedString3, textStyle, (Function1) obj9, i, z2, i2, i3, resolver, list2, function3, function2);
            if (z) {
                gapComposer.startReplaceGroup(147956465);
                boolean zChangedInstance2 = gapComposer.changedInstance(textLinkScope3);
                Object objRememberedValue7 = gapComposer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue7 == obj5) {
                    obj = objRememberedValue7;
                    Object basicTextKt$$ExternalSyntheticLambda6 = new BasicTextKt$$ExternalSyntheticLambda6(textLinkScope3, (byte) 1);
                    gapComposer.updateRememberedValue(basicTextKt$$ExternalSyntheticLambda6);
                    obj = basicTextKt$$ExternalSyntheticLambda6;
                }
                Function0 function4 = (Function0) obj;
                boolean zChanged3 = gapComposer.changed(mutableState3);
                Object objRememberedValue8 = gapComposer.rememberedValue();
                Object obj10 = objRememberedValue8;
                if (zChanged3 || objRememberedValue8 == obj5) {
                    Object mainActivity$$ExternalSyntheticLambda29 = new MainActivity$$ExternalSyntheticLambda29(mutableState3, (byte) 4);
                    gapComposer.updateRememberedValue(mainActivity$$ExternalSyntheticLambda29);
                    obj10 = mainActivity$$ExternalSyntheticLambda29;
                }
                textMeasurePolicy = new TextMeasurePolicy(function4, (Function0) obj10, (byte) 0);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(147779703);
                boolean zChangedInstance3 = gapComposer.changedInstance(textLinkScope3);
                Object objRememberedValue9 = gapComposer.rememberedValue();
                if (zChangedInstance3 || objRememberedValue9 == obj5) {
                    z4 = false;
                    Object basicTextKt$$ExternalSyntheticLambda7 = new BasicTextKt$$ExternalSyntheticLambda6(textLinkScope3, false ? 1 : 0);
                    gapComposer.updateRememberedValue(basicTextKt$$ExternalSyntheticLambda7);
                    obj2 = basicTextKt$$ExternalSyntheticLambda7;
                } else {
                    z4 = false;
                    obj2 = objRememberedValue9;
                }
                textMeasurePolicy = new SliderKt$SliderImpl$3$1((Function0) obj2);
                gapComposer.end(z4);
            }
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM193textModifierCL7eQgs);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, textMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            if (textLinkScope3 == null) {
                gapComposer.startReplaceGroup(-433557001);
                z3 = false;
            } else {
                z3 = false;
                gapComposer.startReplaceGroup(-291080374);
                textLinkScope3.LinksComposables(0, gapComposer);
            }
            gapComposer.end(z3);
            if (list3 == null) {
                gapComposer.startReplaceGroup(-433506223);
            } else {
                gapComposer.startReplaceGroup(-433506222);
                AnnotatedStringResolveInlineContentKt.InlineChildren(annotatedString2, list3, gapComposer, i10);
            }
            gapComposer.end(z3);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj11, Object obj12) {
                    ((Integer) obj12).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                    BasicTextKt.m190LayoutWithLinksAndInlineContent11Od_4g(modifier, annotatedString2, function1, z, map, textStyle, i, z2, i2, i3, resolver, function2, (Composer) obj11, iUpdateChangedFlags, iUpdateChangedFlags2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void SelectionToolbarAndHandles(TextFieldSelectionManager textFieldSelectionManager, boolean z, Composer composer, int i) {
        TextLayoutResultProxy layoutResult;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(626339208);
        int i2 = (gapComposer.changedInstance(textFieldSelectionManager) ? 4 : 2) | i | (gapComposer.changed(z) ? 32 : 16);
        if (!gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            gapComposer.skipToGroupEnd();
        } else if (z) {
            gapComposer.startReplaceGroup(1530097388);
            LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
            TextLayoutResult textLayoutResult = null;
            if (legacyTextFieldState != null && (layoutResult = legacyTextFieldState.getLayoutResult()) != null) {
                TextLayoutResult textLayoutResult2 = layoutResult.value;
                LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager.state;
                if (!(legacyTextFieldState2 != null ? legacyTextFieldState2.isLayoutResultStale : true)) {
                    textLayoutResult = textLayoutResult2;
                }
            }
            if (textLayoutResult == null) {
                gapComposer.startReplaceGroup(1530097387);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1530097388);
                if (TextRange.m741getCollapsedimpl(textFieldSelectionManager.getValue$foundation().selection)) {
                    gapComposer.startReplaceGroup(2110860558);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(2109807302);
                    int iOriginalToTransformed = textFieldSelectionManager.offsetMapping.originalToTransformed((int) (textFieldSelectionManager.getValue$foundation().selection >> 32));
                    int iOriginalToTransformed2 = textFieldSelectionManager.offsetMapping.originalToTransformed((int) (textFieldSelectionManager.getValue$foundation().selection & 4294967295L));
                    ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(iOriginalToTransformed);
                    ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(iOriginalToTransformed2 - 1, 0));
                    LegacyTextFieldState legacyTextFieldState3 = textFieldSelectionManager.state;
                    if (legacyTextFieldState3 == null || !((Boolean) legacyTextFieldState3.showSelectionHandleStart$delegate.getValue()).booleanValue()) {
                        gapComposer.startReplaceGroup(2110490542);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(2110225306);
                        MathKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, gapComposer, ((i2 << 6) & 896) | 6);
                        gapComposer.end(false);
                    }
                    LegacyTextFieldState legacyTextFieldState4 = textFieldSelectionManager.state;
                    if (legacyTextFieldState4 == null || !((Boolean) legacyTextFieldState4.showSelectionHandleEnd$delegate.getValue()).booleanValue()) {
                        gapComposer.startReplaceGroup(2110838734);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(2110574459);
                        MathKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, gapComposer, ((i2 << 6) & 896) | 6);
                        gapComposer.end(false);
                    }
                    gapComposer.end(false);
                }
                LegacyTextFieldState legacyTextFieldState5 = textFieldSelectionManager.state;
                if (legacyTextFieldState5 != null) {
                    ParcelableSnapshotMutableState parcelableSnapshotMutableState = legacyTextFieldState5.showFloatingToolbar$delegate;
                    if (!Intrinsics.areEqual(textFieldSelectionManager.oldValue.annotatedString.text, textFieldSelectionManager.getValue$foundation().annotatedString.text)) {
                        parcelableSnapshotMutableState.setValue(Boolean.FALSE);
                    }
                    if (legacyTextFieldState5.getHasFocus()) {
                        if (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
                            textFieldSelectionManager.showSelectionToolbar$foundation();
                        } else {
                            textFieldSelectionManager.hideSelectionToolbar$foundation();
                        }
                    }
                }
                gapComposer.end(false);
            }
            gapComposer.end(false);
        } else {
            gapComposer.startReplaceGroup(1989076778);
            gapComposer.end(false);
            textFieldSelectionManager.hideSelectionToolbar$foundation();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new StringsKt__StringsKt$$ExternalSyntheticLambda1(textFieldSelectionManager, z, i);
        }
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionManager textFieldSelectionManager, Composer composer, int i) {
        AnnotatedString transformedText$foundation;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1436003720);
        byte b = 2;
        int i2 = (gapComposer.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
            if (legacyTextFieldState == null || !((Boolean) legacyTextFieldState.showCursorHandle$delegate.getValue()).booleanValue() || (transformedText$foundation = textFieldSelectionManager.getTransformedText$foundation()) == null || transformedText$foundation.text.length() <= 0) {
                gapComposer.startReplaceGroup(-2111042550);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-2112351432);
                boolean zChanged = gapComposer.changed(textFieldSelectionManager);
                Object objRememberedValue = gapComposer.rememberedValue();
                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                if (zChanged || objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$cursorDragObserver$1
                        @Override // androidx.compose.foundation.text.TextDragObserver
                        /* JADX INFO: renamed from: onDrag-k-4lQ0M */
                        public final void mo201onDragk4lQ0M(long j) {
                            TextLayoutResultProxy layoutResult;
                            HapticFeedback hapticFeedback;
                            TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                            textFieldSelectionManager2.dragTotalDistance = Offset.m439plusMKHz9U(textFieldSelectionManager2.dragTotalDistance, j);
                            LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager2.state;
                            if (legacyTextFieldState2 == null || (layoutResult = legacyTextFieldState2.getLayoutResult()) == null) {
                                return;
                            }
                            textFieldSelectionManager2.m235setCurrentDragPosition_kEHs6E(new Offset(Offset.m439plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
                            OffsetMapping offsetMapping = textFieldSelectionManager2.offsetMapping;
                            Offset offsetM232getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m232getCurrentDragPosition_m7T9E();
                            offsetM232getCurrentDragPosition_m7T9E.getClass();
                            int iTransformedToOriginal = offsetMapping.transformedToOriginal(layoutResult.m204getOffsetForPosition3MmeM6k(offsetM232getCurrentDragPosition_m7T9E.packedValue, true));
                            long jTextRange = TextRangeKt.TextRange(iTransformedToOriginal, iTransformedToOriginal);
                            if (TextRange.m740equalsimpl0(jTextRange, textFieldSelectionManager2.getValue$foundation().selection)) {
                                return;
                            }
                            LegacyTextFieldState legacyTextFieldState3 = textFieldSelectionManager2.state;
                            if ((legacyTextFieldState3 == null || ((Boolean) legacyTextFieldState3.isInTouchMode$delegate.getValue()).booleanValue()) && (hapticFeedback = textFieldSelectionManager2.hapticFeedBack) != null) {
                                ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(9);
                            }
                            textFieldSelectionManager2.onValueChange.invoke(TextFieldSelectionManager.m230createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation().annotatedString, jTextRange));
                            textFieldSelectionManager2.latestSelection = new TextRange(jTextRange);
                        }

                        @Override // androidx.compose.foundation.text.TextDragObserver
                        /* JADX INFO: renamed from: onStart-3MmeM6k */
                        public final void mo202onStart3MmeM6k(long j, MarqueeSpacing$Companion$$ExternalSyntheticLambda0 marqueeSpacing$Companion$$ExternalSyntheticLambda0) {
                            TextLayoutResultProxy layoutResult;
                            TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                            long jM229getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m229getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager2.m233getHandlePositiontuRUvjQ$foundation(true));
                            LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager2.state;
                            if (legacyTextFieldState2 == null || (layoutResult = legacyTextFieldState2.getLayoutResult()) == null) {
                                return;
                            }
                            long jM207translateInnerToDecorationCoordinatesMKHz9U$foundation = layoutResult.m207translateInnerToDecorationCoordinatesMKHz9U$foundation(jM229getAdjustedCoordinatesk4lQ0M);
                            textFieldSelectionManager2.dragBeginPosition = jM207translateInnerToDecorationCoordinatesMKHz9U$foundation;
                            textFieldSelectionManager2.m235setCurrentDragPosition_kEHs6E(new Offset(jM207translateInnerToDecorationCoordinatesMKHz9U$foundation));
                            textFieldSelectionManager2.dragTotalDistance = 0L;
                            textFieldSelectionManager2.setDraggingHandle(Handle.Cursor);
                            textFieldSelectionManager2.updateFloatingToolbar(false);
                        }

                        @Override // androidx.compose.foundation.text.TextDragObserver
                        public final void onStop() {
                            TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                            textFieldSelectionManager2.setDraggingHandle(null);
                            textFieldSelectionManager2.m235setCurrentDragPosition_kEHs6E(null);
                        }

                        @Override // androidx.compose.foundation.text.TextDragObserver
                        public final void onUp() {
                            TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                            textFieldSelectionManager2.setDraggingHandle(null);
                            textFieldSelectionManager2.m235setCurrentDragPosition_kEHs6E(null);
                        }

                        @Override // androidx.compose.foundation.text.TextDragObserver
                        public final void onCancel() {
                        }

                        @Override // androidx.compose.foundation.text.TextDragObserver
                        /* JADX INFO: renamed from: onDown-k-4lQ0M */
                        public final void mo200onDownk4lQ0M() {
                        }
                    };
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue;
                Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
                OffsetMapping offsetMapping = textFieldSelectionManager.offsetMapping;
                long j = textFieldSelectionManager.getValue$foundation().selection;
                int i3 = TextRange.$r8$clinit;
                int iOriginalToTransformed = offsetMapping.originalToTransformed((int) (j >> 32));
                LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager.state;
                TextLayoutResultProxy layoutResult = legacyTextFieldState2 != null ? legacyTextFieldState2.getLayoutResult() : null;
                layoutResult.getClass();
                TextLayoutResult textLayoutResult = layoutResult.value;
                Rect cursorRect = textLayoutResult.getCursorRect(UuidKt.coerceIn(iOriginalToTransformed, 0, textLayoutResult.layoutInput.text.text.length()));
                final long jFloatToRawIntBits = (((long) Float.floatToRawIntBits((density.mo81toPx0680j_4(2.0f) / 2.0f) + cursorRect.left)) << 32) | (((long) Float.floatToRawIntBits(cursorRect.bottom)) & 4294967295L);
                boolean zChanged2 = gapComposer.changed(jFloatToRawIntBits);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* JADX INFO: renamed from: provide-F1C5BW0, reason: not valid java name */
                        public final long mo194provideF1C5BW0() {
                            return jFloatToRawIntBits;
                        }
                    };
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                OffsetProvider offsetProvider = (OffsetProvider) objRememberedValue2;
                boolean zChangedInstance = gapComposer.changedInstance(textDragObserver) | gapComposer.changedInstance(textFieldSelectionManager);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new BottomSheetKt$BottomSheet$3$1(textDragObserver, textFieldSelectionManager, b);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion.$$INSTANCE, textDragObserver, (PointerInputEventHandler) objRememberedValue3);
                boolean zChanged3 = gapComposer.changed(jFloatToRawIntBits);
                Object objRememberedValue4 = gapComposer.rememberedValue();
                if (zChanged3 || objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new InnerTube$$ExternalSyntheticLambda2(jFloatToRawIntBits, b);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                m189CursorHandleUSBMPiE(offsetProvider, SemanticsModifierKt.semantics(modifierPointerInput, false, (Function1) objRememberedValue4), 0L, gapComposer, 0);
                gapComposer.end(false);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ComposerKt$$ExternalSyntheticLambda0(textFieldSelectionManager, i, (byte) 7);
        }
    }

    public static final int ceilToIntPx(float f) {
        return Math.round((float) Math.ceil(f));
    }

    public static final int computeHeightFromThreeLines(float f, float f2, float f3, int i, int i2) {
        if (i == i2) {
            return -1;
        }
        int i3 = i - 2;
        if (i3 < 0) {
            i3 = 0;
        }
        int i4 = i - 1;
        return MathKt.roundToInt((f3 * (i4 <= 1 ? i4 : 1)) + (f2 * i3) + f);
    }

    public static final void endInputSession(LegacyTextFieldState legacyTextFieldState) {
        TextInputSession textInputSession = legacyTextFieldState.inputSession;
        if (textInputSession != null) {
            legacyTextFieldState.onValueChange.invoke(TextFieldValue.m762copy3r_uNRQ$default((TextFieldValue) legacyTextFieldState.processor.mCallback, null, 0L, 3));
            TextInputService textInputService = textInputSession.textInputService;
            AtomicReference atomicReference = textInputService._currentInputSession;
            while (!atomicReference.compareAndSet(textInputSession, null)) {
                if (atomicReference.get() != textInputSession) {
                }
            }
            textInputService.platformTextInputService.stopInput();
        }
        legacyTextFieldState.inputSession = null;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0049  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.text.BreakIterator] */
    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.emoji2.text.EmojiProcessor, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
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
    public static final int findFollowingBreak(int i, String str) {
        ?? r5;
        ?? r6;
        int spanEnd;
        EmojiCompat emojiCompatIfLoaded = getEmojiCompatIfLoaded();
        Integer num = null;
        if (emojiCompatIfLoaded != null) {
            DatabaseDao_Impl.AnonymousClass17.checkState("Not initialized yet", emojiCompatIfLoaded.getLoadState() == 1);
            DatabaseDao_Impl.AnonymousClass17.checkNotNull(str, "charSequence cannot be null");
            ?? r4 = emojiCompatIfLoaded.mHelper.mProcessor;
            r4.getClass();
            if (i < 0 || i >= str.length()) {
                r6 = str;
                spanEnd = -1;
            } else if (str instanceof Spanned) {
                Spanned spanned = (Spanned) str;
                TypefaceEmojiSpan[] typefaceEmojiSpanArr = (TypefaceEmojiSpan[]) spanned.getSpans(i, i + 1, TypefaceEmojiSpan.class);
                if (typefaceEmojiSpanArr.length > 0) {
                    spanEnd = spanned.getSpanEnd(typefaceEmojiSpanArr[0]);
                    r6 = str;
                } else {
                    ?? r7 = str;
                    spanEnd = ((EmojiProcessor.EmojiProcessLookupCallback) r4.process(r7, Math.max(0, i - 16), Math.min(str.length(), i + 16), Integer.MAX_VALUE, true, new EmojiProcessor.EmojiProcessLookupCallback(i))).end;
                    r6 = r7;
                }
            } else {
                ?? r8 = str;
                spanEnd = ((EmojiProcessor.EmojiProcessLookupCallback) r4.process(r8, Math.max(0, i - 16), Math.min(str.length(), i + 16), Integer.MAX_VALUE, true, new EmojiProcessor.EmojiProcessLookupCallback(i))).end;
                r6 = r8;
            }
            Integer numValueOf = Integer.valueOf(spanEnd);
            r5 = r6;
            if (spanEnd != -1) {
                num = numValueOf;
            }
        } else {
            r5 = str;
        }
        if (num != null) {
            r5 = r6;
            return num.intValue();
        }
        r5 = r6;
        ?? characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(r5);
        return characterInstance.following(i);
    }

    public static final int findParagraphEnd(CharSequence charSequence, int i) {
        int length = charSequence.length();
        while (i < length) {
            if (charSequence.charAt(i) == '\n') {
                return i;
            }
            i++;
        }
        return charSequence.length();
    }

    public static final int findParagraphStart(CharSequence charSequence, int i) {
        while (i > 0) {
            if (charSequence.charAt(i - 1) == '\n') {
                return i;
            }
            i--;
        }
        return 0;
    }

    public static final int findPrecedingBreak(int i, String str) {
        EmojiCompat emojiCompatIfLoaded = getEmojiCompatIfLoaded();
        Integer num = null;
        if (emojiCompatIfLoaded != null) {
            Integer numValueOf = Integer.valueOf(emojiCompatIfLoaded.getEmojiStart(str, Math.max(0, i - 1)));
            if (numValueOf.intValue() != -1) {
                num = numValueOf;
            }
        }
        if (num != null) {
            return num.intValue();
        }
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(str);
        return characterInstance.preceding(i);
    }

    public static final Rect getCursorRectInScroller(Placeable.PlacementScope placementScope, int i, TransformedText transformedText, TextLayoutResult textLayoutResult, boolean z, int i2) {
        Rect cursorRect = textLayoutResult != null ? textLayoutResult.getCursorRect(transformedText.offsetMapping.originalToTransformed(i)) : Rect.Zero;
        int iMo75roundToPx0680j_4 = placementScope.mo75roundToPx0680j_4(2.0f);
        float f = cursorRect.left;
        return Rect.copy$default(cursorRect, z ? (i2 - f) - iMo75roundToPx0680j_4 : f, z ? i2 - f : iMo75roundToPx0680j_4 + f, 10);
    }

    public static final EmojiCompat getEmojiCompatIfLoaded() {
        if (!EmojiCompat.isConfigured()) {
            return null;
        }
        EmojiCompat emojiCompat = EmojiCompat.get();
        if (emojiCompat.getLoadState() == 1) {
            return emojiCompat;
        }
        return null;
    }

    /* JADX INFO: renamed from: getModifiers-ZmokQxo, reason: not valid java name */
    public static final int m191getModifiersZmokQxo(KeyEvent keyEvent) {
        return (keyEvent.isAltPressed() ? 1 : 0) | (keyEvent.isCtrlPressed() ? 2 : 0) | (keyEvent.isMetaPressed() ? 4 : 0) | (keyEvent.isShiftPressed() ? 8 : 0);
    }

    /* JADX INFO: renamed from: isKeyCode-YhN2O0w, reason: not valid java name */
    public static final boolean m192isKeyCodeYhN2O0w(int i, KeyEvent keyEvent) {
        return ((int) (Key.m580getKeyZmokQxo(keyEvent) >> 32)) == i;
    }

    public static final ArrayList measureWithTextRangeMeasureConstraints(Function0 function0, List list) {
        Huffman.Node node;
        if (!((Boolean) function0.invoke()).booleanValue()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Measurable measurable = (Measurable) list.get(i2);
            Object parentData = measurable.getParentData();
            parentData.getClass();
            TextLinkScope$$ExternalSyntheticLambda10 textLinkScope$$ExternalSyntheticLambda10 = ((TextRangeLayoutModifier) parentData).measurePolicy;
            TextLinkScope textLinkScope = (TextLinkScope) textLinkScope$$ExternalSyntheticLambda10.f$0;
            AnnotatedString.Range range = (AnnotatedString.Range) textLinkScope$$ExternalSyntheticLambda10.f$1;
            TextLayoutResult textLayoutResult = (TextLayoutResult) textLinkScope.textLayoutResult$delegate.getValue();
            if (textLayoutResult == null) {
                node = new Huffman.Node(i, i, new ScrollKt$$ExternalSyntheticLambda0((byte) 23));
            } else {
                AnnotatedString.Range rangeCalculateVisibleLinkRange = TextLinkScope.calculateVisibleLinkRange(range, textLayoutResult);
                if (rangeCalculateVisibleLinkRange == null) {
                    node = new Huffman.Node(i, i, new ScrollKt$$ExternalSyntheticLambda0((byte) 24));
                } else {
                    IntRect intRectRoundToIntRect = DatabaseDao_Impl.AnonymousClass17.roundToIntRect(textLayoutResult.getPathForRange(rangeCalculateVisibleLinkRange.start, rangeCalculateVisibleLinkRange.end).getBounds());
                    node = new Huffman.Node(intRectRoundToIntRect.getWidth(), intRectRoundToIntRect.getHeight(), new SliderState$$ExternalSyntheticLambda0((byte) 15, intRectRoundToIntRect));
                }
            }
            int i3 = node.symbol;
            int i4 = node.terminalBitCount;
            arrayList.add(new Pair(measurable.mo598measureBRTryo0(FileSystemsKt.m880fitPrioritizingWidthZbe2FdA(i3, i3, i4, i4)), (Function0) node.children));
        }
        return arrayList;
    }

    public static final void notifyFocusedRect(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
            if (layoutResult == null) {
                return;
            }
            TextInputSession textInputSession = legacyTextFieldState.inputSession;
            if (textInputSession == null) {
                return;
            }
            LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
            if (layoutCoordinates == null) {
                return;
            }
            notifyFocusedRect$foundation(textFieldValue, legacyTextFieldState.textDelegate, layoutResult.value, layoutCoordinates, textInputSession, legacyTextFieldState.getHasFocus(), offsetMapping);
        } finally {
            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }

    public static void notifyFocusedRect$foundation(TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, TextInputSession textInputSession, boolean z, OffsetMapping offsetMapping) {
        Rect boundingBox;
        if (z) {
            int iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m743getMaximpl(textFieldValue.selection));
            String str = TextFieldDelegateKt.EmptyTextReplacement;
            if (iOriginalToTransformed < textLayoutResult.layoutInput.text.text.length()) {
                boundingBox = textLayoutResult.getBoundingBox(iOriginalToTransformed);
            } else {
                boundingBox = iOriginalToTransformed != 0 ? textLayoutResult.getBoundingBox(iOriginalToTransformed - 1) : new Rect(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, (int) (TextFieldDelegateKt.computeSizeForDefaultText$default((TextStyle) textDelegate.style, (Density) textDelegate.density, (FontFamily.Resolver) textDelegate.fontFamilyResolver) & 4294967295L));
            }
            float f = boundingBox.top;
            float f2 = boundingBox.left;
            long jMo606localToRootMKHz9U = layoutCoordinates.mo606localToRootMKHz9U((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
            Rect rectM896Recttz77jQw = IntMath.m896Recttz77jQw((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jMo606localToRootMKHz9U & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jMo606localToRootMKHz9U >> 32)))) << 32), (((long) Float.floatToRawIntBits(boundingBox.right - f2)) << 32) | (((long) Float.floatToRawIntBits(boundingBox.bottom - f)) & 4294967295L));
            if (Intrinsics.areEqual((TextInputSession) textInputSession.textInputService._currentInputSession.get(), textInputSession)) {
                textInputSession.platformTextInputService.notifyFocusedRect(rectM896Recttz77jQw);
            }
        }
    }

    public static final void startInputSession(TextInputService textInputService, LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        CallbackWrapper callbackWrapper = legacyTextFieldState.processor;
        CoreTextFieldKt$$ExternalSyntheticLambda1 coreTextFieldKt$$ExternalSyntheticLambda1 = legacyTextFieldState.onValueChange;
        CoreTextFieldKt$$ExternalSyntheticLambda1 coreTextFieldKt$$ExternalSyntheticLambda2 = legacyTextFieldState.onImeActionPerformed;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0 = new UtilsKt$$ExternalSyntheticLambda0((Object) callbackWrapper, (Object) coreTextFieldKt$$ExternalSyntheticLambda1, (Object) ref$ObjectRef, (byte) 9);
        PlatformTextInputService platformTextInputService = textInputService.platformTextInputService;
        platformTextInputService.startInput(textFieldValue, imeOptions, utilsKt$$ExternalSyntheticLambda0, coreTextFieldKt$$ExternalSyntheticLambda2);
        TextInputSession textInputSession = new TextInputSession(textInputService, platformTextInputService);
        textInputService._currentInputSession.set(textInputSession);
        ref$ObjectRef.element = textInputSession;
        legacyTextFieldState.inputSession = textInputSession;
        notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
    }

    /* JADX INFO: renamed from: textModifier-CL7eQgs, reason: not valid java name */
    public static final Modifier m193textModifierCL7eQgs(Modifier modifier, AnnotatedString annotatedString, TextStyle textStyle, Function1 function1, int i, boolean z, int i2, int i3, FontFamily.Resolver resolver, List list, Function1 function2, Function1 function3) {
        return modifier.then(Modifier.Companion.$$INSTANCE).then(new TextAnnotatedStringElement(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function2, function3));
    }

    public static final void validateMinMaxLines(int i, int i2) {
        if (!(i > 0 && i2 > 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("both minLines " + i + " and maxLines " + i2 + " must be greater than zero");
        }
        if (i <= i2) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("minLines " + i + " must be less than or equal to maxLines " + i2);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:102:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:105:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:109:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:88:0x017f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0182  */
    /* JADX WARN: Code duplicated, block: B:93:0x018c  */
    /* JADX WARN: Code duplicated, block: B:96:0x019f  */
    /* JADX WARN: Code duplicated, block: B:98:0x01a4  */
    public static final void BasicTextField(final String str, final Function1 function1, final Modifier modifier, final boolean z, final boolean z2, final TextStyle textStyle, final KeyboardOptions keyboardOptions, final KeyboardActions keyboardActions, final boolean z3, final int i, final int i2, final VisualTransformation visualTransformation, Function1 function2, final MutableInteractionSourceImpl mutableInteractionSourceImpl, final SolidColor solidColor, final ComposableLambdaImpl composableLambdaImpl, Composer composer, final int i3) {
        GapComposer gapComposer;
        final Function1 function3;
        Function1 function4;
        NeverEqualPolicy neverEqualPolicy;
        boolean z4;
        Object objRememberedValue;
        MutableState mutableState;
        int i4;
        byte b;
        int i5;
        boolean zChanged;
        Object objRememberedValue2;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(2026950908);
        int i6 = i3 | (gapComposer2.changed(str) ? 4 : 2) | (gapComposer2.changedInstance(function1) ? 32 : 16) | (gapComposer2.changed(modifier) ? 256 : 128) | (gapComposer2.changed(z) ? 2048 : 1024) | (gapComposer2.changed(z2) ? 16384 : 8192) | (gapComposer2.changed(textStyle) ? 131072 : 65536) | (gapComposer2.changed(keyboardOptions) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288) | (gapComposer2.changed(keyboardActions) ? 8388608 : 4194304) | (gapComposer2.changed(z3) ? 67108864 : 33554432) | (gapComposer2.changed(i) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE);
        int i7 = 196608 | (gapComposer2.changed(i2) ? 4 : 2) | (gapComposer2.changed(visualTransformation) ? 32 : 16) | 384 | (gapComposer2.changed(mutableInteractionSourceImpl) ? 2048 : 1024) | (gapComposer2.changed(solidColor) ? 16384 : 8192);
        if (gapComposer2.shouldExecute(i6 & 1, ((i6 & 306783379) == 306783378 && (74899 & i7) == 74898) ? false : true)) {
            gapComposer2.startDefaults();
            int i8 = i3 & 1;
            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
            if (i8 != 0 && !gapComposer2.getDefaultsInvalid()) {
                gapComposer2.skipToGroupEnd();
                function4 = function2;
            } else {
                Object objRememberedValue3 = gapComposer2.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy2) {
                    objRememberedValue3 = new OffsetKt$$ExternalSyntheticLambda0((byte) 24);
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                function4 = (Function1) objRememberedValue3;
            }
            gapComposer2.endDefaults();
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            Function1 function5 = function4;
            if (objRememberedValue4 == neverEqualPolicy2) {
                objRememberedValue4 = Stack.mutableStateOf$default(new TextFieldValue(6, 0L, str));
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue4;
            TextFieldValue textFieldValue = (TextFieldValue) mutableState2.getValue();
            TextFieldValue textFieldValue2 = new TextFieldValue(new AnnotatedString(str), textFieldValue.selection, textFieldValue.composition);
            boolean zChanged2 = gapComposer2.changed(textFieldValue2);
            Object objRememberedValue5 = gapComposer2.rememberedValue();
            byte b2 = 9;
            if (zChanged2) {
                neverEqualPolicy = neverEqualPolicy2;
            } else {
                neverEqualPolicy = neverEqualPolicy2;
                if (objRememberedValue5 == neverEqualPolicy) {
                }
                Stack.SideEffect((Function0) objRememberedValue5, gapComposer2);
                if ((i6 & 14) == 4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                objRememberedValue = gapComposer2.rememberedValue();
                if (!z4 || objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.mutableStateOf$default(str);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ImeOptions imeOptions$foundation = keyboardOptions.toImeOptions$foundation(z3);
                boolean z5 = !z3;
                if (z3) {
                    i4 = 1;
                } else {
                    i4 = i2;
                }
                b = 6;
                if (z3) {
                    i5 = 1;
                } else {
                    i5 = i;
                }
                zChanged = gapComposer2.changed(mutableState) | ((i6 & 112) == 32);
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (!zChanged || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new UtilsKt$$ExternalSyntheticLambda0(function1, mutableState2, mutableState, b);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                int i9 = i7 << 9;
                gapComposer = gapComposer2;
                CoreTextField(textFieldValue2, (Function1) objRememberedValue2, modifier, textStyle, visualTransformation, function5, mutableInteractionSourceImpl, solidColor, z5, i5, i4, imeOptions$foundation, keyboardActions, z, z2, composableLambdaImpl, gapComposer, (i6 & 896) | ((i6 >> 6) & 7168) | (i9 & 57344) | 196608 | (3670016 & i9) | (i9 & 29360128), (i6 & 57344) | ((i6 >> 15) & 896) | (i6 & 7168) | 196608);
                function3 = function5;
            }
            objRememberedValue5 = new Recomposer$$ExternalSyntheticLambda6(textFieldValue2, mutableState2, b2);
            gapComposer2.updateRememberedValue(objRememberedValue5);
            Stack.SideEffect((Function0) objRememberedValue5, gapComposer2);
            if ((i6 & 14) == 4) {
                z4 = true;
            } else {
                z4 = false;
            }
            objRememberedValue = gapComposer2.rememberedValue();
            if (!z4) {
                objRememberedValue = Stack.mutableStateOf$default(str);
                gapComposer2.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = Stack.mutableStateOf$default(str);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ImeOptions imeOptions$foundation2 = keyboardOptions.toImeOptions$foundation(z3);
            boolean z6 = !z3;
            if (z3) {
                i4 = 1;
            } else {
                i4 = i2;
            }
            b = 6;
            if (z3) {
                i5 = 1;
            } else {
                i5 = i;
            }
            zChanged = gapComposer2.changed(mutableState) | ((i6 & 112) == 32);
            objRememberedValue2 = gapComposer2.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = new UtilsKt$$ExternalSyntheticLambda0(function1, mutableState2, mutableState, b);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new UtilsKt$$ExternalSyntheticLambda0(function1, mutableState2, mutableState, b);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            int i10 = i7 << 9;
            gapComposer = gapComposer2;
            CoreTextField(textFieldValue2, (Function1) objRememberedValue2, modifier, textStyle, visualTransformation, function5, mutableInteractionSourceImpl, solidColor, z6, i5, i4, imeOptions$foundation2, keyboardActions, z, z2, composableLambdaImpl, gapComposer, (i6 & 896) | ((i6 >> 6) & 7168) | (i10 & 57344) | 196608 | (3670016 & i10) | (i10 & 29360128), (i6 & 57344) | ((i6 >> 15) & 896) | (i6 & 7168) | 196608);
            function3 = function5;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            function3 = function2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(str, function1, modifier, z, z2, textStyle, keyboardOptions, keyboardActions, z3, i, i2, visualTransformation, function3, mutableInteractionSourceImpl, solidColor, composableLambdaImpl, i3) { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda6
                public final /* synthetic */ String f$0;
                public final /* synthetic */ Function1 f$1;
                public final /* synthetic */ boolean f$10;
                public final /* synthetic */ VisualTransformation f$11;
                public final /* synthetic */ Function1 f$12;
                public final /* synthetic */ MutableInteractionSourceImpl f$13;
                public final /* synthetic */ SolidColor f$14;
                public final /* synthetic */ ComposableLambdaImpl f$15;
                public final /* synthetic */ Modifier f$2;
                public final /* synthetic */ boolean f$3;
                public final /* synthetic */ boolean f$4;
                public final /* synthetic */ TextStyle f$5;
                public final /* synthetic */ KeyboardOptions f$6;
                public final /* synthetic */ KeyboardActions f$7;
                public final /* synthetic */ boolean f$8;
                public final /* synthetic */ int f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    String str2 = this.f$0;
                    Function1 function6 = this.f$1;
                    Modifier modifier2 = this.f$2;
                    boolean z7 = this.f$3;
                    boolean z8 = this.f$4;
                    TextStyle textStyle2 = this.f$5;
                    KeyboardOptions keyboardOptions2 = this.f$6;
                    KeyboardActions keyboardActions2 = this.f$7;
                    boolean z9 = this.f$8;
                    int i11 = this.f$9;
                    boolean z10 = this.f$10;
                    VisualTransformation visualTransformation2 = this.f$11;
                    Function1 function7 = this.f$12;
                    MutableInteractionSourceImpl mutableInteractionSourceImpl2 = this.f$13;
                    SolidColor solidColor2 = this.f$14;
                    ComposableLambdaImpl composableLambdaImpl2 = this.f$15;
                    BasicTextKt.BasicTextField(str2, function6, modifier2, z7, z8, textStyle2, keyboardOptions2, keyboardActions2, z9, i11, z10 ? 1 : 0, visualTransformation2, function7, mutableInteractionSourceImpl2, solidColor2, composableLambdaImpl2, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
