package androidx.compose.foundation.text.selection;

import android.app.RemoteAction;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.text.TextUtils;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.PlatformLocaleKt;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlatformSelectionBehaviorsImpl implements PlatformSelectionBehaviors {
    public final Context context;
    public final CoroutineContext coroutineContext;
    public final LocaleList localeList;
    public final SelectedTextType selectedTextType;
    public TextClassifier textClassificationSession;
    public final MutexImpl mutex = new MutexImpl();
    public final ParcelableSnapshotMutableState textClassificationResult$delegate = Stack.mutableStateOf$default(null);
    public final Object AssistantItemKey = new Object();

    public PlatformSelectionBehaviorsImpl(CoroutineContext coroutineContext, Context context, SelectedTextType selectedTextType, LocaleList localeList) {
        this.coroutineContext = coroutineContext;
        this.context = context;
        this.selectedTextType = selectedTextType;
        this.localeList = localeList;
    }

    /* JADX INFO: renamed from: addSmartSelectionTextContextMenuItems-YmzfRxQ$foundation, reason: not valid java name */
    public final void m226addSmartSelectionTextContextMenuItemsYmzfRxQ$foundation(TextContextMenuBuilderScope textContextMenuBuilderScope, String str, long j, UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0) throws Throwable {
        MutexImpl mutexImpl = this.mutex;
        TextClassificationResult textClassificationResult = null;
        if (mutexImpl.tryLock()) {
            TextClassificationResult textClassificationResult2 = (TextClassificationResult) this.textClassificationResult$delegate.getValue();
            if (textClassificationResult2 == null || !TextRange.m740equalsimpl0(j, textClassificationResult2.selection) || !Intrinsics.areEqual(str, textClassificationResult2.text)) {
                textClassificationResult2 = null;
            }
            mutexImpl.unlock(null);
            textClassificationResult = textClassificationResult2;
        }
        if (textClassificationResult == null) {
            utilsKt$$ExternalSyntheticLambda0.invoke(textContextMenuBuilderScope);
            return;
        }
        ArrayList arrayList = textClassificationResult.icons;
        TextClassification textClassification = textClassificationResult.textClassification;
        boolean zIsEmpty = textClassification.getActions().isEmpty();
        Object obj = this.AssistantItemKey;
        if (!zIsEmpty) {
            textContextMenuBuilderScope.components.add(new TextContextMenuTextClassificationItem(obj, textClassification, 0, (Drawable) arrayList.get(0)));
        } else if ((textClassification.getIcon() != null || !TextUtils.isEmpty(textClassification.getLabel())) && (textClassification.getIntent() != null || textClassification.getOnClickListener() != null)) {
            textContextMenuBuilderScope.components.add(new TextContextMenuTextClassificationItem(obj, textClassification, -1, textClassification.getIcon()));
        }
        utilsKt$$ExternalSyntheticLambda0.invoke(textContextMenuBuilderScope);
        List<RemoteAction> actions = textClassification.getActions();
        int size = actions.size();
        for (int i = 0; i < size; i++) {
            actions.get(i);
            if (i > 0) {
                textContextMenuBuilderScope.components.add(new TextContextMenuTextClassificationItem(obj, textClassification, i, (Drawable) arrayList.get(i)));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX INFO: renamed from: classifyText-M8tDOmk, reason: not valid java name */
    public final Object m227classifyTextM8tDOmk(CharSequence charSequence, long j, TextClassifier textClassifier, ContinuationImpl continuationImpl) throws Throwable {
        PlatformSelectionBehaviorsImpl$classifyText$1 platformSelectionBehaviorsImpl$classifyText$1;
        long j2;
        CharSequence charSequence2;
        TextClassifier textClassifier2;
        MutexImpl mutexImpl;
        Object obj;
        Object obj2;
        TextClassificationResult textClassificationResultM228createTextClassificationResultSbBc2M;
        Object obj3;
        Mutex mutex;
        if (continuationImpl instanceof PlatformSelectionBehaviorsImpl$classifyText$1) {
            platformSelectionBehaviorsImpl$classifyText$1 = (PlatformSelectionBehaviorsImpl$classifyText$1) continuationImpl;
            int i = platformSelectionBehaviorsImpl$classifyText$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                platformSelectionBehaviorsImpl$classifyText$1.label = i - Integer.MIN_VALUE;
            } else {
                platformSelectionBehaviorsImpl$classifyText$1 = new PlatformSelectionBehaviorsImpl$classifyText$1(this, continuationImpl);
            }
        } else {
            platformSelectionBehaviorsImpl$classifyText$1 = new PlatformSelectionBehaviorsImpl$classifyText$1(this, continuationImpl);
        }
        Object obj4 = platformSelectionBehaviorsImpl$classifyText$1.result;
        int i2 = platformSelectionBehaviorsImpl$classifyText$1.label;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.textClassificationResult$delegate;
        Unit unit = Unit.INSTANCE;
        MutexImpl mutexImpl2 = this.mutex;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 != 0) {
                    if (i2 == 1) {
                        j2 = platformSelectionBehaviorsImpl$classifyText$1.J$0;
                        MutexImpl mutexImpl3 = platformSelectionBehaviorsImpl$classifyText$1.L$2;
                        textClassifier2 = (TextClassifier) platformSelectionBehaviorsImpl$classifyText$1.L$1;
                        charSequence2 = (CharSequence) platformSelectionBehaviorsImpl$classifyText$1.L$0;
                        ResultKt.throwOnFailure(obj4);
                        mutexImpl = mutexImpl3;
                    } else {
                        if (i2 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        Mutex mutex2 = (Mutex) platformSelectionBehaviorsImpl$classifyText$1.L$1;
                        textClassificationResultM228createTextClassificationResultSbBc2M = (TextClassificationResult) platformSelectionBehaviorsImpl$classifyText$1.L$0;
                        ResultKt.throwOnFailure(obj4);
                        obj3 = null;
                        mutex = mutex2;
                    }
                    parcelableSnapshotMutableState.setValue(textClassificationResultM228createTextClassificationResultSbBc2M);
                    return unit;
                }
                ResultKt.throwOnFailure(obj4);
                platformSelectionBehaviorsImpl$classifyText$1.L$0 = charSequence;
                platformSelectionBehaviorsImpl$classifyText$1.L$1 = textClassifier;
                platformSelectionBehaviorsImpl$classifyText$1.L$2 = mutexImpl2;
                j2 = j;
                platformSelectionBehaviorsImpl$classifyText$1.J$0 = j2;
                platformSelectionBehaviorsImpl$classifyText$1.label = 1;
                if (mutexImpl2.lock(platformSelectionBehaviorsImpl$classifyText$1) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                charSequence2 = charSequence;
                textClassifier2 = textClassifier;
                mutexImpl = mutexImpl2;
                parcelableSnapshotMutableState.setValue(textClassificationResultM228createTextClassificationResultSbBc2M);
                return unit;
            } finally {
                mutex.unlock(obj3);
            }
            TextClassificationResult textClassificationResult = (TextClassificationResult) parcelableSnapshotMutableState.getValue();
            if (textClassificationResult != null) {
                try {
                    if (TextRange.m740equalsimpl0(j2, textClassificationResult.selection) && Intrinsics.areEqual(charSequence2, textClassificationResult.text)) {
                        mutexImpl.unlock(null);
                        return unit;
                    }
                    obj2 = null;
                } catch (Throwable th) {
                    th = th;
                    obj = null;
                    mutexImpl.unlock(obj);
                    throw th;
                }
            } else {
                obj2 = null;
            }
            mutexImpl.unlock(obj2);
            textClassificationResultM228createTextClassificationResultSbBc2M = m228createTextClassificationResultSbBc2M(charSequence2, j2, textClassifier2.classifyText(new TextClassification.Request.Builder(charSequence2, TextRange.m744getMinimpl(j2), TextRange.m743getMaximpl(j2)).setDefaultLocales(getAndroidLocalList()).build()));
            platformSelectionBehaviorsImpl$classifyText$1.L$0 = textClassificationResultM228createTextClassificationResultSbBc2M;
            platformSelectionBehaviorsImpl$classifyText$1.L$1 = mutexImpl2;
            obj3 = null;
            platformSelectionBehaviorsImpl$classifyText$1.L$2 = null;
            platformSelectionBehaviorsImpl$classifyText$1.label = 2;
            Object objLock = mutexImpl2.lock(platformSelectionBehaviorsImpl$classifyText$1);
            mutex = mutexImpl2;
            if (objLock == coroutineSingletons) {
                return coroutineSingletons;
            }
        } catch (Throwable th2) {
            th = th2;
            obj = null;
        }
    }

    /* JADX INFO: renamed from: createTextClassificationResult-Sb-Bc2M, reason: not valid java name */
    public final TextClassificationResult m228createTextClassificationResultSbBc2M(CharSequence charSequence, long j, TextClassification textClassification) {
        Icon icon;
        int size = textClassification.getActions().size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            RemoteAction remoteAction = textClassification.getActions().get(i);
            RemoteAction remoteAction2 = remoteAction;
            Drawable drawableLoadDrawable = null;
            if (i != 0 && !remoteAction2.shouldShowIcon()) {
                remoteAction = null;
            }
            RemoteAction remoteAction3 = remoteAction;
            if (remoteAction3 != null && (icon = remoteAction3.getIcon()) != null) {
                drawableLoadDrawable = icon.loadDrawable(this.context);
            }
            arrayList.add(drawableLoadDrawable);
        }
        return new TextClassificationResult(charSequence, j, textClassification, arrayList);
    }

    public final android.os.LocaleList getAndroidLocalList() {
        LocaleList localeList = this.localeList;
        if (localeList == null) {
            return new android.os.LocaleList(((Locale) PlatformLocaleKt.platformLocaleDelegate.getCurrent().localeList.get(0)).platformLocale);
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(localeList, 10));
        Iterator it = localeList.localeList.iterator();
        while (it.hasNext()) {
            arrayList.add(((Locale) it.next()).platformLocale);
        }
        java.util.Locale[] localeArr = (java.util.Locale[]) arrayList.toArray(new java.util.Locale[0]);
        return new android.os.LocaleList((java.util.Locale[]) Arrays.copyOf(localeArr, localeArr.length));
    }
}
