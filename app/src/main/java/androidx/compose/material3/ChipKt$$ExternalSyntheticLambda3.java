package androidx.compose.material3;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import androidx.collection.MutableIntList;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.TextFieldScrollerPosition;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.material3.internal.MenuPosition;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.emoji2.text.EmojiCompat;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.network.sockets.DatagramKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ChipKt$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ChipKt$$ExternalSyntheticLambda3(byte b) {
        this.$r8$classId = b;
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0322  */
    /* JADX WARN: Code duplicated, block: B:67:0x01dd  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int iOffsetByCodePoints;
        TextLinkStyles styles;
        SpanStyle spanStyle;
        String str;
        byte b = this.$r8$classId;
        int i = 0;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                SemanticsPropertiesKt.m718setRolekuIjeqM((SemanticsPropertyReceiver) obj, 0);
                return unit;
            case 1:
                TextFieldPreparedSelection textFieldPreparedSelection = (TextFieldPreparedSelection) obj;
                String str2 = textFieldPreparedSelection.annotatedString.text;
                long j = textFieldPreparedSelection.selection;
                int i2 = TextRange.$r8$clinit;
                int i3 = (int) (j & 4294967295L);
                if (i3 > 0) {
                    EmojiCompat emojiCompatIfLoaded = BasicTextKt.getEmojiCompatIfLoaded();
                    if (emojiCompatIfLoaded != null) {
                        int emojiStart = emojiCompatIfLoaded.getEmojiStart(str2, i3 - 1);
                        if (emojiStart >= 0) {
                            iOffsetByCodePoints = emojiStart;
                        } else if (i3 <= 0) {
                            iOffsetByCodePoints = -1;
                        } else {
                            iOffsetByCodePoints = Character.offsetByCodePoints(str2, i3, -1);
                        }
                    } else if (i3 <= 0) {
                        iOffsetByCodePoints = -1;
                    } else {
                        iOffsetByCodePoints = Character.offsetByCodePoints(str2, i3, -1);
                    }
                } else {
                    iOffsetByCodePoints = -1;
                }
                if (iOffsetByCodePoints == -1) {
                    return null;
                }
                return new DeleteSurroundingTextCommand(((int) (textFieldPreparedSelection.selection & 4294967295L)) - iOffsetByCodePoints, 0);
            case 2:
                TextFieldPreparedSelection textFieldPreparedSelection2 = (TextFieldPreparedSelection) obj;
                String str3 = textFieldPreparedSelection2.annotatedString.text;
                long j2 = textFieldPreparedSelection2.selection;
                int i4 = TextRange.$r8$clinit;
                int iFindFollowingBreak = BasicTextKt.findFollowingBreak((int) (j2 & 4294967295L), str3);
                if (iFindFollowingBreak != -1) {
                    return new DeleteSurroundingTextCommand(0, iFindFollowingBreak - ((int) (textFieldPreparedSelection2.selection & 4294967295L)));
                }
                return null;
            case 3:
                TextFieldPreparedSelection textFieldPreparedSelection3 = (TextFieldPreparedSelection) obj;
                Integer previousWordOffset = textFieldPreparedSelection3.getPreviousWordOffset();
                if (previousWordOffset == null) {
                    return null;
                }
                int iIntValue = previousWordOffset.intValue();
                long j3 = textFieldPreparedSelection3.selection;
                int i5 = TextRange.$r8$clinit;
                return new DeleteSurroundingTextCommand(((int) (j3 & 4294967295L)) - iIntValue, 0);
            case 4:
                TextFieldPreparedSelection textFieldPreparedSelection4 = (TextFieldPreparedSelection) obj;
                Integer nextWordOffset = textFieldPreparedSelection4.getNextWordOffset();
                if (nextWordOffset == null) {
                    return null;
                }
                int iIntValue2 = nextWordOffset.intValue();
                long j4 = textFieldPreparedSelection4.selection;
                int i6 = TextRange.$r8$clinit;
                return new DeleteSurroundingTextCommand(0, iIntValue2 - ((int) (j4 & 4294967295L)));
            case 5:
                TextFieldPreparedSelection textFieldPreparedSelection5 = (TextFieldPreparedSelection) obj;
                Integer lineStartByOffset = textFieldPreparedSelection5.getLineStartByOffset();
                if (lineStartByOffset == null) {
                    return null;
                }
                int iIntValue3 = lineStartByOffset.intValue();
                long j5 = textFieldPreparedSelection5.selection;
                int i7 = TextRange.$r8$clinit;
                return new DeleteSurroundingTextCommand(((int) (j5 & 4294967295L)) - iIntValue3, 0);
            case 6:
                TextFieldPreparedSelection textFieldPreparedSelection6 = (TextFieldPreparedSelection) obj;
                Integer lineEndByOffset = textFieldPreparedSelection6.getLineEndByOffset();
                if (lineEndByOffset == null) {
                    return null;
                }
                int iIntValue4 = lineEndByOffset.intValue();
                long j6 = textFieldPreparedSelection6.selection;
                int i8 = TextRange.$r8$clinit;
                return new DeleteSurroundingTextCommand(0, iIntValue4 - ((int) (j6 & 4294967295L)));
            case 7:
                List list = (List) obj;
                Object obj2 = list.get(1);
                obj2.getClass();
                Orientation orientation = ((Boolean) obj2).booleanValue() ? Orientation.Vertical : Orientation.Horizontal;
                Object obj3 = list.get(0);
                obj3.getClass();
                return new TextFieldScrollerPosition(orientation, ((Float) obj3).floatValue());
            case 8:
                AnnotatedString.Range range = (AnnotatedString.Range) obj;
                Object obj4 = range.item;
                if (!(obj4 instanceof LinkAnnotation) || (styles = ((LinkAnnotation) obj4).getStyles()) == null || (styles.style == null && styles.focusedStyle == null && styles.hoveredStyle == null && styles.pressedStyle == null)) {
                    return CollectionsKt__IterablesKt.arrayListOf(range);
                }
                Object obj5 = range.item;
                obj5.getClass();
                TextLinkStyles styles2 = ((LinkAnnotation) obj5).getStyles();
                if (styles2 == null || (spanStyle = styles2.style) == null) {
                    spanStyle = new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, DatagramKt.MAX_DATAGRAM_SIZE);
                }
                return CollectionsKt__IterablesKt.arrayListOf(range, new AnnotatedString.Range(range.start, range.end, spanStyle));
            case 9:
                ((SemanticsPropertyReceiver) obj).set(SemanticsProperties.LinkTestMarker, unit);
                return unit;
            case 10:
                Context context = (Context) obj;
                List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain"), 0);
                ArrayList arrayList = new ArrayList(listQueryIntentActivities.size());
                int size = listQueryIntentActivities.size();
                while (i < size) {
                    ResolveInfo resolveInfo = listQueryIntentActivities.get(i);
                    ResolveInfo resolveInfo2 = resolveInfo;
                    if (context.getPackageName().equals(resolveInfo2.activityInfo.packageName)) {
                        arrayList.add(resolveInfo);
                    } else {
                        ActivityInfo activityInfo = resolveInfo2.activityInfo;
                        if (activityInfo.exported && ((str = activityInfo.permission) == null || context.checkSelfPermission(str) == 0)) {
                            arrayList.add(resolveInfo);
                        }
                    }
                    i++;
                }
                return arrayList;
            case 11:
                ((Long) obj).getClass();
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return unit;
            case 13:
                return unit;
            case 14:
                Offset offset = (Offset) obj;
                long j7 = offset.packedValue;
                return (9223372034707292159L & j7) != 9205357640488583168L ? new AnimationVector2D(Float.intBitsToFloat((int) (j7 >> 32)), Float.intBitsToFloat((int) (offset.packedValue & 4294967295L))) : SelectionMagnifierKt.UnspecifiedAnimationVector2D;
            case 15:
                AnimationVector2D animationVector2D = (AnimationVector2D) obj;
                return new Offset((((long) Float.floatToRawIntBits(animationVector2D.v1)) << 32) | (((long) Float.floatToRawIntBits(animationVector2D.v2)) & 4294967295L));
            case 16:
                return unit;
            case 17:
                SemanticsPropertiesKt.setTraversalGroup((SemanticsPropertyReceiver) obj);
                return unit;
            case 18:
                LookaheadCapablePlaceable.ResettableRulerScope resettableRulerScope = (LookaheadCapablePlaceable.ResettableRulerScope) obj;
                resettableRulerScope.provides(CardKt.BadgeEndRuler, (int) (resettableRulerScope.getCoordinates().mo603getSizeYbymL2g() >> 32));
                resettableRulerScope.provides(CardKt.BadgeTopRuler, CropImageView.DEFAULT_ASPECT_RATIO);
                return unit;
            case 19:
                SemanticsPropertiesKt.m718setRolekuIjeqM((SemanticsPropertyReceiver) obj, 0);
                return unit;
            case 20:
                SemanticsPropertiesKt.m718setRolekuIjeqM((SemanticsPropertyReceiver) obj, 0);
                return unit;
            case 21:
                SemanticsPropertiesKt.m718setRolekuIjeqM((SemanticsPropertyReceiver) obj, 1);
                return unit;
            case 22:
                return unit;
            case 23:
                SemanticsPropertiesKt.m718setRolekuIjeqM((SemanticsPropertyReceiver) obj, 0);
                return unit;
            case 24:
                SemanticsPropertiesKt.m718setRolekuIjeqM((SemanticsPropertyReceiver) obj, 0);
                return unit;
            case 25:
                MenuPositionScopeImpl menuPositionScopeImpl = (MenuPositionScopeImpl) obj;
                List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new MenuPosition.Horizontal[]{MenuPosition.startToAnchorStart, MenuPosition.endToAnchorEnd, ((int) (menuPositionScopeImpl.anchorBounds.m808getCenternOccac() >> 32)) < ((int) (menuPositionScopeImpl.windowSize >> 32)) / 2 ? MenuPosition.leftToWindowLeft : MenuPosition.rightToWindowRight});
                IntRect intRect = menuPositionScopeImpl.anchorBounds;
                long j8 = menuPositionScopeImpl.windowSize;
                int i9 = (int) (menuPositionScopeImpl.menuSize >> 32);
                LayoutDirection layoutDirection = menuPositionScopeImpl.layoutDirection;
                MutableIntList mutableIntList = new MutableIntList(listListOf.size());
                int size2 = listListOf.size();
                while (i < size2) {
                    mutableIntList.add(((MenuPosition.Horizontal) listListOf.get(i)).mo365position95KtPRI(intRect, j8, i9, layoutDirection));
                    i++;
                }
                return mutableIntList;
            case 26:
                MenuPositionScopeImpl menuPositionScopeImpl2 = (MenuPositionScopeImpl) obj;
                int iM808getCenternOccac = (int) (menuPositionScopeImpl2.anchorBounds.m808getCenternOccac() & 4294967295L);
                long j9 = menuPositionScopeImpl2.windowSize;
                List listListOf2 = CollectionsKt__IterablesKt.listOf((Object[]) new MenuPosition.Vertical[]{MenuPosition.topToAnchorBottom, MenuPosition.bottomToAnchorTop, MenuPosition.centerToAnchorTop, iM808getCenternOccac < ((int) (j9 & 4294967295L)) / 2 ? MenuPosition.topToWindowTop : MenuPosition.bottomToWindowBottom});
                IntRect intRect2 = menuPositionScopeImpl2.anchorBounds;
                int i10 = (int) (menuPositionScopeImpl2.menuSize & 4294967295L);
                MutableIntList mutableIntList2 = new MutableIntList(listListOf2.size());
                int size3 = listListOf2.size();
                while (i < size3) {
                    mutableIntList2.add(((MenuPosition.Vertical) listListOf2.get(i)).mo366positionJVtK1S4(intRect2, j9, i10));
                    i++;
                }
                return mutableIntList2;
            case 27:
                SemanticsPropertiesKt.setTraversalGroup((SemanticsPropertyReceiver) obj);
                return unit;
            case 28:
                KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                ((SemanticsPropertyReceiver) obj).set(SemanticsProperties.IsDialog, unit);
                return unit;
            default:
                SemanticsPropertiesKt.setTraversalGroup((SemanticsPropertyReceiver) obj);
                return unit;
        }
    }
}
