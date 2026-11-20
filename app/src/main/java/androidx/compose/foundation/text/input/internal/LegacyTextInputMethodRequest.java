package androidx.compose.foundation.text.input.internal;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.core.widget.NestedScrollView;
import androidx.emoji2.text.EmojiCompat;
import androidx.sqlite.SQLite;
import io.ktor.util.cio.ByteBufferPoolKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LegacyTextInputMethodRequest {
    public final LegacyCursorAnchorInfoController cursorAnchorInfoController;
    public Rect focusedRect;
    public final WeakCache inputMethodManager;
    public LegacyTextFieldState legacyTextFieldState;
    public TextFieldSelectionManager textFieldSelectionManager;
    public final View view;
    public ViewConfiguration viewConfiguration;
    public Function1 onEditCommand = new ChipKt$$ExternalSyntheticLambda3(12);
    public Function1 onImeActionPerformed = new ChipKt$$ExternalSyntheticLambda3(13);
    public TextFieldValue state = new TextFieldValue(4, TextRange.Zero, "");
    public ImeOptions imeOptions = ImeOptions.Default;
    public final ArrayList ics = new ArrayList();
    public final Lazy baseInputConnection$delegate = ResultKt.lazy(LazyThreadSafetyMode.NONE, new SliderState$$ExternalSyntheticLambda0(22, this));

    public LegacyTextInputMethodRequest(View view, AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1 androidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1, WeakCache weakCache) {
        this.view = view;
        this.inputMethodManager = weakCache;
        this.cursorAnchorInfoController = new LegacyCursorAnchorInfoController(androidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1, weakCache);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00a5 A[PHI: r15
      0x00a5: PHI (r15v12 int) = (r15v0 int), (r15v11 int) binds: [B:36:0x00a3, B:77:0x0108] A[DONT_GENERATE, DONT_INLINE]] */
    public final RecordingInputConnection createInputConnection(EditorInfo editorInfo) {
        int i;
        int i2;
        TextFieldValue textFieldValue = this.state;
        String str = textFieldValue.annotatedString.text;
        long j = textFieldValue.selection;
        ImeOptions imeOptions = this.imeOptions;
        int i3 = imeOptions.imeAction;
        int i4 = imeOptions.keyboardType;
        boolean z = imeOptions.singleLine;
        int i5 = 3;
        if (i3 == 1) {
            i = z ? 6 : 0;
        } else if (i3 == 0) {
            i = 1;
        } else if (i3 == 2) {
            i = 2;
        } else if (i3 == 6) {
            i = 5;
        } else if (i3 == 5) {
            i = 7;
        } else if (i3 == 3) {
            i = 3;
        } else if (i3 == 4) {
            i = 4;
        } else {
            if (i3 != 7) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("invalid ImeAction");
                return null;
            }
        }
        editorInfo.imeOptions = i;
        LocaleList localeList = imeOptions.hintLocales;
        if (Intrinsics.areEqual(localeList, LocaleList.Empty)) {
            editorInfo.hintLocales = null;
        } else {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(localeList, 10));
            Iterator it = localeList.localeList.iterator();
            while (it.hasNext()) {
                arrayList.add(((Locale) it.next()).platformLocale);
            }
            java.util.Locale[] localeArr = (java.util.Locale[]) arrayList.toArray(new java.util.Locale[0]);
            editorInfo.hintLocales = new android.os.LocaleList((java.util.Locale[]) Arrays.copyOf(localeArr, localeArr.length));
        }
        byte b = 18;
        if (i4 == 1) {
            i2 = 1;
        } else if (i4 == 2) {
            editorInfo.imeOptions |= Integer.MIN_VALUE;
            i2 = 1;
        } else if (i4 == 3) {
            i2 = 2;
        } else if (i4 == 4) {
            i2 = i5;
        } else {
            i2 = 17;
            if (i4 != 5) {
                if (i4 == 6) {
                    i2 = 33;
                } else if (i4 == 7) {
                    i2 = 129;
                } else if (i4 == 8) {
                    i2 = 18;
                } else if (i4 == 9) {
                    i2 = 8194;
                } else if (i4 == 10) {
                    i2 = 145;
                } else if (i4 == 11) {
                    i2 = 113;
                } else if (i4 == 12) {
                    i2 = 97;
                } else if (i4 == 13) {
                    i2 = 49;
                } else if (i4 == 14) {
                    i2 = 65;
                } else if (i4 == 15) {
                    i2 = 81;
                } else if (i4 == 16) {
                    i2 = 177;
                } else if (i4 == 17) {
                    i2 = 193;
                } else if (i4 == 18) {
                    i2 = 4;
                } else {
                    i5 = 20;
                    if (i4 == 19) {
                        i2 = i5;
                    } else if (i4 == 20) {
                        i2 = 36;
                    } else if (i4 == 21) {
                        i2 = ByteBufferPoolKt.DEFAULT_BUFFER_SIZE;
                    } else if (i4 == 22) {
                        i2 = 12290;
                    } else if (i4 == 23) {
                        i2 = 8210;
                    } else if (i4 == 24) {
                        i2 = 4114;
                    } else {
                        if (i4 != 25) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Invalid Keyboard Type");
                            return null;
                        }
                        i2 = 12306;
                    }
                }
            }
        }
        editorInfo.inputType = i2;
        if (!z && (i2 & 15) == 1) {
            i2 |= 131072;
            editorInfo.inputType = i2;
            if (imeOptions.imeAction == 1) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if ((i2 & 15) == 1) {
            int i6 = imeOptions.capitalization;
            if (i6 == 1) {
                i2 |= 4096;
                editorInfo.inputType = i2;
            } else if (i6 == 2) {
                i2 |= 8192;
                editorInfo.inputType = i2;
            } else if (i6 == 3) {
                i2 |= 16384;
                editorInfo.inputType = i2;
            }
            if (imeOptions.autoCorrect) {
                i2 |= 32768;
                editorInfo.inputType = i2;
            }
            if (Build.VERSION.SDK_INT >= 37) {
                editorInfo.inputType = 2097152 | i2;
            }
        }
        int i7 = TextRange.$r8$clinit;
        editorInfo.initialSelStart = (int) (j >> 32);
        editorInfo.initialSelEnd = (int) (j & 4294967295L);
        SQLite.setInitialSurroundingText(editorInfo, str);
        editorInfo.imeOptions |= 33554432;
        if (!StylusHandwriting_androidKt.isStylusHandwritingSupported || i4 == 7 || i4 == 10 || i4 == 8 || i4 == 23 || i4 == 24 || i4 == 25) {
            if (Build.VERSION.SDK_INT >= 35) {
                NestedScrollView.Api35Impl.setStylusHandwritingEnabled(editorInfo, false);
            }
            Bundle bundle = editorInfo.extras;
            if (bundle == null) {
                bundle = new Bundle();
                editorInfo.extras = bundle;
            }
            bundle.putBoolean("androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED", false);
        } else {
            if (Build.VERSION.SDK_INT >= 35) {
                NestedScrollView.Api35Impl.setStylusHandwritingEnabled(editorInfo, true);
            }
            Bundle bundle2 = editorInfo.extras;
            if (bundle2 == null) {
                bundle2 = new Bundle();
                editorInfo.extras = bundle2;
            }
            bundle2.putBoolean("androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED", true);
            EditorInfoApi34.setHandwritingGestures(editorInfo);
        }
        LegacyPlatformTextInputServiceAdapter_androidKt$inputMethodManagerFactory$1 legacyPlatformTextInputServiceAdapter_androidKt$inputMethodManagerFactory$1 = LegacyPlatformTextInputServiceAdapter_androidKt.inputMethodManagerFactory;
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
        RecordingInputConnection recordingInputConnection = new RecordingInputConnection(this.state, new DrawResult(b, this), this.imeOptions.autoCorrect, this.legacyTextFieldState, this.textFieldSelectionManager, this.viewConfiguration);
        this.ics.add(new WeakReference(recordingInputConnection));
        return recordingInputConnection;
    }
}
