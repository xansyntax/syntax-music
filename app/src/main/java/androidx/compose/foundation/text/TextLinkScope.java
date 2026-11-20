package androidx.compose.foundation.text;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda3;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import com.metrolist.music.utils.SyncUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextLinkScope {
    public final SnapshotStateList annotators;
    public AnnotatedString text;
    public final ParcelableSnapshotMutableState textLayoutResult$delegate = Stack.mutableStateOf$default(null);

    public TextLinkScope(AnnotatedString annotatedString) {
        ChipKt$$ExternalSyntheticLambda3 chipKt$$ExternalSyntheticLambda3 = new ChipKt$$ExternalSyntheticLambda3((byte) 8);
        annotatedString.getClass();
        AnnotatedString.Builder builder = new AnnotatedString.Builder(annotatedString);
        ArrayList arrayList = builder.annotations;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            List list = (List) chipKt$$ExternalSyntheticLambda3.invoke(((AnnotatedString.Builder.MutableRange) arrayList.get(i)).toRange(Integer.MIN_VALUE));
            ArrayList arrayList3 = new ArrayList(list.size());
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                AnnotatedString.Range range = (AnnotatedString.Range) list.get(i2);
                arrayList3.add(new AnnotatedString.Builder.MutableRange(range.item, range.start, range.end, range.tag));
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList3, arrayList2);
        }
        arrayList.clear();
        arrayList.addAll(arrayList2);
        this.text = builder.toAnnotatedString();
        this.annotators = new SnapshotStateList();
    }

    public static AnnotatedString.Range calculateVisibleLinkRange(AnnotatedString.Range range, TextLayoutResult textLayoutResult) {
        MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
        int lineEnd = multiParagraph.getLineEnd(multiParagraph.lineCount - 1, false);
        if (range.start < lineEnd) {
            return AnnotatedString.Range.copy$default(range, null, Math.min(range.end, lineEnd), 11);
        }
        return null;
    }

    public final void LinksComposables(int i, Composer composer) {
        Object objM;
        boolean z;
        Object obj;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1154651354);
        char c = 2;
        int i2 = i | (gapComposer.changedInstance(this) ? 4 : 2);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            UriHandler uriHandler = (UriHandler) gapComposer.consume(CompositionLocalsKt.LocalUriHandler);
            AnnotatedString annotatedString = this.text;
            List linkAnnotations = annotatedString.getLinkAnnotations(annotatedString.text.length());
            int size = linkAnnotations.size();
            int i3 = 0;
            while (i3 < size) {
                AnnotatedString.Range range = (AnnotatedString.Range) linkAnnotations.get(i3);
                int i4 = range.start;
                Object obj2 = range.item;
                if (i4 != range.end) {
                    gapComposer.startReplaceGroup(725516538);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                    if (objRememberedValue == neverEqualPolicy) {
                        objM = objRememberedValue;
                        objM = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    objM = objRememberedValue;
                    MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objM;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(1731209863, new CrossfadeKt$$ExternalSyntheticLambda3(this, range, mutableInteractionSourceImpl, uriHandler, (byte) 1), gapComposer);
                    gapComposer.startReplaceGroup(727333386);
                    composableLambdaImplRememberComposableLambda.invoke((Object) gapComposer, (Object) 6);
                    gapComposer.end(false);
                    LinkAnnotation linkAnnotation = (LinkAnnotation) obj2;
                    TextLinkStyles styles = linkAnnotation.getStyles();
                    if (styles == null || (styles.style == null && styles.focusedStyle == null && styles.hoveredStyle == null && styles.pressedStyle == null)) {
                        gapComposer.startReplaceGroup(729535006);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(727506335);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        Object obj3 = objRememberedValue2;
                        if (objRememberedValue2 == neverEqualPolicy) {
                            LinkStateInteractionSourceObserver linkStateInteractionSourceObserver = new LinkStateInteractionSourceObserver(mutableInteractionSourceImpl);
                            gapComposer.updateRememberedValue(linkStateInteractionSourceObserver);
                            obj3 = linkStateInteractionSourceObserver;
                        }
                        LinkStateInteractionSourceObserver linkStateInteractionSourceObserver2 = (LinkStateInteractionSourceObserver) obj3;
                        Object objRememberedValue3 = gapComposer.rememberedValue();
                        if (objRememberedValue3 == neverEqualPolicy) {
                            z = true;
                            SyncUtils.AnonymousClass2 anonymousClass2 = new SyncUtils.AnonymousClass2(linkStateInteractionSourceObserver2, false ? 1 : 0, (byte) 8);
                            gapComposer.updateRememberedValue(anonymousClass2);
                            obj = anonymousClass2;
                        } else {
                            z = true;
                            obj = objRememberedValue3;
                        }
                        Stack.LaunchedEffect(gapComposer, Unit.INSTANCE, (Function2) obj);
                        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = linkStateInteractionSourceObserver2.interactionState;
                        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = linkStateInteractionSourceObserver2.interactionState;
                        Boolean boolValueOf = Boolean.valueOf((parcelableSnapshotMutableIntState.getIntValue() & 2) != 0 ? z : false);
                        Boolean boolValueOf2 = Boolean.valueOf((parcelableSnapshotMutableIntState2.getIntValue() & 1) != 0 ? z : false);
                        Boolean boolValueOf3 = Boolean.valueOf((parcelableSnapshotMutableIntState2.getIntValue() & 4) != 0 ? z : false);
                        TextLinkStyles styles2 = linkAnnotation.getStyles();
                        SpanStyle spanStyle = styles2 != null ? styles2.style : null;
                        TextLinkStyles styles3 = linkAnnotation.getStyles();
                        SpanStyle spanStyle2 = styles3 != null ? styles3.focusedStyle : null;
                        TextLinkStyles styles4 = linkAnnotation.getStyles();
                        SpanStyle spanStyle3 = styles4 != null ? styles4.hoveredStyle : null;
                        TextLinkStyles styles5 = linkAnnotation.getStyles();
                        Object[] objArr = {boolValueOf, boolValueOf2, boolValueOf3, spanStyle, spanStyle2, spanStyle3, styles5 != null ? styles5.pressedStyle : null};
                        boolean zChangedInstance = gapComposer.changedInstance(this) | gapComposer.changed(range);
                        Object objRememberedValue4 = gapComposer.rememberedValue();
                        Object obj4 = objRememberedValue4;
                        if (zChangedInstance || objRememberedValue4 == neverEqualPolicy) {
                            ZIndexNode$$ExternalSyntheticLambda0 zIndexNode$$ExternalSyntheticLambda0 = new ZIndexNode$$ExternalSyntheticLambda0(this, range, linkStateInteractionSourceObserver2);
                            gapComposer.updateRememberedValue(zIndexNode$$ExternalSyntheticLambda0);
                            obj4 = zIndexNode$$ExternalSyntheticLambda0;
                        }
                        StyleAnnotation(objArr, (Function1) obj4, gapComposer, (i2 << 6) & 896);
                        gapComposer.end(false);
                    }
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(729548894);
                    gapComposer.end(false);
                }
                i3++;
                c = c;
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ComposerKt$$ExternalSyntheticLambda0(this, i, (byte) 9);
        }
    }

    public final void StyleAnnotation(Object[] objArr, Function1 function1, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-2083052099);
        int i2 = (i & 48) == 0 ? (gapComposer.changedInstance(function1) ? 32 : 16) | i : i;
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(this) ? 256 : 128;
        }
        gapComposer.startMovableGroup(-358306546, Integer.valueOf(objArr.length));
        int i3 = i2 | (gapComposer.changed(objArr.length) ? 4 : 0);
        for (Object obj : objArr) {
            i3 |= gapComposer.changedInstance(obj) ? 4 : 0;
        }
        gapComposer.end(false);
        if ((i3 & 14) == 0) {
            i3 |= 2;
        }
        byte b = 1;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
            Headers.Builder builder = new Headers.Builder(2);
            builder.add(function1);
            builder.addSpread(objArr);
            ArrayList arrayList = builder.namesAndValues;
            Object[] array = arrayList.toArray(new Object[arrayList.size()]);
            boolean zChangedInstance = gapComposer.changedInstance(this) | ((i3 & 112) == 32);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new BasicTextKt$$ExternalSyntheticLambda5(this, function1, b);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Stack.DisposableEffect(array, (Function1) objRememberedValue, (Composer) gapComposer);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda0((byte) 4, i, (Object) this, (Object) objArr, (Object) function1);
        }
    }
}
