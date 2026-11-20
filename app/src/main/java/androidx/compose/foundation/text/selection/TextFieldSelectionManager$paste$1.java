package androidx.compose.foundation.text.selection;

import android.content.ClipData;
import android.os.Parcel;
import android.text.Annotation;
import android.text.Spanned;
import android.util.Base64;
import androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2;
import androidx.compose.foundation.internal.DecodeHelper;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.platform.AndroidClipboardImpl;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import com.google.common.math.IntMath;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.network.sockets.DatagramKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSelectionManager$paste$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public byte label;
    public final /* synthetic */ TextFieldSelectionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldSelectionManager$paste$1(TextFieldSelectionManager textFieldSelectionManager, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = textFieldSelectionManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        switch (b) {
            case 0:
                return new TextFieldSelectionManager$paste$1(textFieldSelectionManager, continuation, (byte) 0);
            default:
                TextFieldSelectionManager$paste$1 textFieldSelectionManager$paste$1 = new TextFieldSelectionManager$paste$1(textFieldSelectionManager, continuation, (byte) 1);
                long j = ((Offset) obj).packedValue;
                return textFieldSelectionManager$paste$1;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((TextFieldSelectionManager$paste$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            default:
                long j = ((Offset) obj).packedValue;
                return new TextFieldSelectionManager$paste$1(this.this$0, (Continuation) obj2, (byte) 1).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object clipEntry;
        Object annotatedString;
        CharSequence text;
        CharSequence charSequence;
        int i;
        int i2;
        AnnotatedString annotatedString2;
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                byte b2 = this.label;
                if (b2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Clipboard clipboard = textFieldSelectionManager.clipboard;
                    if (clipboard != null) {
                        this.label = (byte) 1;
                        ClipData primaryClip = ((AndroidClipboardImpl) clipboard).androidClipboardManager.getClipboardManager().getPrimaryClip();
                        clipEntry = primaryClip != null ? new ClipEntry(primaryClip) : null;
                        if (clipEntry == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return unit;
                }
                if (b2 == 1) {
                    ResultKt.throwOnFailure(obj);
                    clipEntry = obj;
                } else {
                    if (b2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    annotatedString = obj;
                }
                annotatedString2 = (AnnotatedString) annotatedString;
                if (annotatedString2 != null && textFieldSelectionManager.getEditable()) {
                    AnnotatedString.Builder builder = new AnnotatedString.Builder(DatabaseDao_Impl.AnonymousClass17.getTextBeforeSelection(textFieldSelectionManager.getValue$foundation(), textFieldSelectionManager.getValue$foundation().annotatedString.text.length()));
                    builder.append(annotatedString2);
                    AnnotatedString annotatedString3 = builder.toAnnotatedString();
                    AnnotatedString textAfterSelection = DatabaseDao_Impl.AnonymousClass17.getTextAfterSelection(textFieldSelectionManager.getValue$foundation(), textFieldSelectionManager.getValue$foundation().annotatedString.text.length());
                    AnnotatedString.Builder builder2 = new AnnotatedString.Builder(annotatedString3);
                    builder2.append(textAfterSelection);
                    AnnotatedString annotatedString4 = builder2.toAnnotatedString();
                    int length = annotatedString2.text.length() + TextRange.m744getMinimpl(textFieldSelectionManager.getValue$foundation().selection);
                    textFieldSelectionManager.onValueChange.invoke(TextFieldSelectionManager.m230createTextFieldValueFDrldGo(annotatedString4, TextRangeKt.TextRange(length, length)));
                    textFieldSelectionManager.setHandleState(HandleState.None);
                    textFieldSelectionManager.undoManager.forceNextSnapshot = true;
                }
                return unit;
                ClipEntry clipEntry2 = (ClipEntry) clipEntry;
                if (clipEntry2 != null) {
                    this.label = (byte) 2;
                    int i3 = 0;
                    ClipData.Item itemAt = clipEntry2.clipData.getItemAt(0);
                    if (itemAt == null || (text = itemAt.getText()) == null) {
                        annotatedString = null;
                    } else if (text instanceof Spanned) {
                        Spanned spanned = (Spanned) text;
                        Annotation[] annotationArr = (Annotation[]) spanned.getSpans(0, spanned.length(), Annotation.class);
                        ArrayList arrayList = new ArrayList();
                        annotationArr.getClass();
                        int length2 = annotationArr.length - 1;
                        if (length2 >= 0) {
                            int i4 = 0;
                            while (true) {
                                Annotation annotation = annotationArr[i4];
                                if (Intrinsics.areEqual(annotation.getKey(), "androidx.compose.text.SpanStyle")) {
                                    int spanStart = spanned.getSpanStart(annotation);
                                    int spanEnd = spanned.getSpanEnd(annotation);
                                    String value = annotation.getValue();
                                    DecodeHelper decodeHelper = new DecodeHelper();
                                    Parcel parcelObtain = Parcel.obtain();
                                    decodeHelper.parcel = parcelObtain;
                                    byte[] bArrDecode = Base64.decode(value, i3);
                                    parcelObtain.unmarshall(bArrDecode, i3, bArrDecode.length);
                                    parcelObtain.setDataPosition(i3);
                                    Parcel parcel = decodeHelper.parcel;
                                    Rgb rgb = ColorSpaces.Unspecified;
                                    long jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
                                    i = i3;
                                    long jPack = IntMath.pack(0L, Float.NaN);
                                    long jPack2 = IntMath.pack(0L, Float.NaN);
                                    long jM109decodeColor0d7_KjU = jColor;
                                    long jM110decodeTextUnitXSAIIZE = jPack;
                                    long jColor2 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
                                    FontWeight fontWeight = null;
                                    FontStyle fontStyle = null;
                                    FontSynthesis fontSynthesis = null;
                                    String string = null;
                                    BaselineShift baselineShift = null;
                                    TextGeometricTransform textGeometricTransform = null;
                                    TextDecoration textDecoration = null;
                                    Shadow shadow = null;
                                    while (true) {
                                        if (parcel.dataAvail() > 1) {
                                            byte b3 = parcel.readByte();
                                            if (b3 == 1) {
                                                if (parcel.dataAvail() >= 8) {
                                                    jM109decodeColor0d7_KjU = decodeHelper.m109decodeColor0d7_KjU();
                                                }
                                            } else if (b3 == 2) {
                                                if (parcel.dataAvail() >= 5) {
                                                    jM110decodeTextUnitXSAIIZE = decodeHelper.m110decodeTextUnitXSAIIZE();
                                                }
                                            } else if (b3 == 3) {
                                                if (parcel.dataAvail() >= 4) {
                                                    fontWeight = new FontWeight(parcel.readInt());
                                                }
                                            } else if (b3 == 4) {
                                                if (parcel.dataAvail() >= 1) {
                                                    byte b4 = parcel.readByte();
                                                    fontStyle = new FontStyle((b4 != 0 && b4 == 1) ? 1 : i);
                                                }
                                            } else if (b3 == 5) {
                                                if (parcel.dataAvail() >= 1) {
                                                    byte b5 = parcel.readByte();
                                                    if (b5 == 0) {
                                                        i2 = i;
                                                    } else if (b5 == 1) {
                                                        i2 = DatagramKt.MAX_DATAGRAM_SIZE;
                                                    } else {
                                                        if (b5 == 3) {
                                                            i2 = 2;
                                                        } else {
                                                            i2 = b5 == 2 ? 1 : i;
                                                        }
                                                        fontSynthesis = new FontSynthesis(i2);
                                                    }
                                                    fontSynthesis = new FontSynthesis(i2);
                                                }
                                            } else if (b3 == 6) {
                                                string = parcel.readString();
                                            } else if (b3 == 7) {
                                                if (parcel.dataAvail() >= 5) {
                                                    jPack2 = decodeHelper.m110decodeTextUnitXSAIIZE();
                                                }
                                            } else if (b3 == 8) {
                                                if (parcel.dataAvail() >= 4) {
                                                    baselineShift = new BaselineShift(parcel.readFloat());
                                                }
                                            } else if (b3 == 9) {
                                                if (parcel.dataAvail() >= 8) {
                                                    textGeometricTransform = new TextGeometricTransform(parcel.readFloat(), parcel.readFloat());
                                                }
                                            } else if (b3 != 10) {
                                                if (b3 != 11) {
                                                    charSequence = text;
                                                    if (b3 == 12) {
                                                        if (parcel.dataAvail() >= 20) {
                                                            text = charSequence;
                                                            shadow = new Shadow(decodeHelper.m109decodeColor0d7_KjU(), (((long) Float.floatToRawIntBits(parcel.readFloat())) << 32) | (((long) Float.floatToRawIntBits(parcel.readFloat())) & 4294967295L), parcel.readFloat());
                                                        }
                                                    }
                                                } else if (parcel.dataAvail() >= 4) {
                                                    int i5 = parcel.readInt();
                                                    int i6 = (i5 & 2) != 0 ? 1 : i;
                                                    int i7 = (i5 & 1) != 0 ? 1 : i;
                                                    TextDecoration textDecoration2 = TextDecoration.LineThrough;
                                                    TextDecoration textDecoration3 = TextDecoration.Underline;
                                                    if (i6 == 0 || i7 == 0) {
                                                        charSequence = text;
                                                        if (i6 != 0) {
                                                            textDecoration = textDecoration2;
                                                        } else {
                                                            textDecoration = i7 != 0 ? textDecoration3 : TextDecoration.None;
                                                        }
                                                    } else {
                                                        List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new TextDecoration[]{textDecoration2, textDecoration3});
                                                        Integer numValueOf = Integer.valueOf(i);
                                                        int size = listListOf.size();
                                                        int i8 = i;
                                                        while (i8 < size) {
                                                            numValueOf = Integer.valueOf(((TextDecoration) listListOf.get(i8)).mask | numValueOf.intValue());
                                                            i8++;
                                                            text = text;
                                                        }
                                                        charSequence = text;
                                                        textDecoration = new TextDecoration(numValueOf.intValue());
                                                    }
                                                }
                                                text = charSequence;
                                            } else if (parcel.dataAvail() >= 8) {
                                                jColor2 = decodeHelper.m109decodeColor0d7_KjU();
                                            }
                                        }
                                        charSequence = text;
                                    }
                                    arrayList.add(new AnnotatedString.Range(spanStart, spanEnd, new SpanStyle(jM109decodeColor0d7_KjU, jM110decodeTextUnitXSAIIZE, fontWeight, fontStyle, fontSynthesis, (FontFamily) null, string, jPack2, baselineShift, textGeometricTransform, (LocaleList) null, jColor2, textDecoration, shadow, 49152)));
                                } else {
                                    charSequence = text;
                                    i = i3;
                                }
                                if (i4 != length2) {
                                    i4++;
                                    i3 = i;
                                    spanned = spanned;
                                    text = charSequence;
                                }
                            }
                        } else {
                            charSequence = text;
                        }
                        String string2 = charSequence.toString();
                        AnnotatedString annotatedString5 = AnnotatedStringKt.EmptyAnnotatedString;
                        annotatedString = new AnnotatedString(arrayList.isEmpty() ? null : arrayList, string2);
                    } else {
                        annotatedString = new AnnotatedString(text.toString());
                    }
                    if (annotatedString == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    annotatedString2 = (AnnotatedString) annotatedString;
                    if (annotatedString2 != null) {
                        AnnotatedString.Builder builder3 = new AnnotatedString.Builder(DatabaseDao_Impl.AnonymousClass17.getTextBeforeSelection(textFieldSelectionManager.getValue$foundation(), textFieldSelectionManager.getValue$foundation().annotatedString.text.length()));
                        builder3.append(annotatedString2);
                        AnnotatedString annotatedString6 = builder3.toAnnotatedString();
                        AnnotatedString textAfterSelection2 = DatabaseDao_Impl.AnonymousClass17.getTextAfterSelection(textFieldSelectionManager.getValue$foundation(), textFieldSelectionManager.getValue$foundation().annotatedString.text.length());
                        AnnotatedString.Builder builder4 = new AnnotatedString.Builder(annotatedString6);
                        builder4.append(textAfterSelection2);
                        AnnotatedString annotatedString7 = builder4.toAnnotatedString();
                        int length3 = annotatedString2.text.length() + TextRange.m744getMinimpl(textFieldSelectionManager.getValue$foundation().selection);
                        textFieldSelectionManager.onValueChange.invoke(TextFieldSelectionManager.m230createTextFieldValueFDrldGo(annotatedString7, TextRangeKt.TextRange(length3, length3)));
                        textFieldSelectionManager.setHandleState(HandleState.None);
                        textFieldSelectionManager.undoManager.forceNextSnapshot = true;
                    }
                }
                return unit;
            default:
                byte b6 = this.label;
                if (b6 != 0) {
                    if (b6 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (b6 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                this.label = (byte) 1;
                if (textFieldSelectionManager.updateClipboardEntry$foundation(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                Pair contextTextAndSelection = textFieldSelectionManager.getContextTextAndSelection();
                if (contextTextAndSelection != null) {
                    String str = (String) contextTextAndSelection.first;
                    long j = ((TextRange) contextTextAndSelection.second).packedValue;
                    PlatformSelectionBehaviors platformSelectionBehaviors = textFieldSelectionManager.platformSelectionBehaviors;
                    if (platformSelectionBehaviors != null) {
                        this.label = (byte) 2;
                        PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl = (PlatformSelectionBehaviorsImpl) platformSelectionBehaviors;
                        Object objWithContext = (str.length() == 0 || TextRange.m741getCollapsedimpl(j)) ? unit : AwaitKt.withContext(platformSelectionBehaviorsImpl.coroutineContext, new PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2(platformSelectionBehaviorsImpl, new ScrollableKt$semanticsScrollBy$2(j, platformSelectionBehaviorsImpl, str, (Continuation) null), null), this);
                        if (objWithContext != coroutineSingletons) {
                            objWithContext = unit;
                        }
                        if (objWithContext == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                }
                return unit;
        }
    }
}
