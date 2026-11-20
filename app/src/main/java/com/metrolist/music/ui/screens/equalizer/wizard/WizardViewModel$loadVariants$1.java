package com.metrolist.music.ui.screens.equalizer.wizard;

import androidx.compose.foundation.text.TextDelegate;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.eq.data.Entry;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WizardViewModel$loadVariants$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $modelId;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ WizardViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WizardViewModel$loadVariants$1(WizardViewModel wizardViewModel, String str, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = wizardViewModel;
        this.$modelId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        String str = this.$modelId;
        WizardViewModel wizardViewModel = this.this$0;
        switch (b) {
            case 0:
                return new WizardViewModel$loadVariants$1(wizardViewModel, str, continuation, (byte) 0);
            default:
                return new WizardViewModel$loadVariants$1(wizardViewModel, str, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                ((WizardViewModel$loadVariants$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((WizardViewModel$loadVariants$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0099, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b8, code lost:
    
        r0 = r1.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x010e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x010f, code lost:
    
        r21 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v4 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object value;
        Object value2;
        Object value3;
        Object value4;
        Object value5;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        WizardViewModel wizardViewModel = this.this$0;
        boolean z = false;
        ?? r7 = 1;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                StateFlowImpl stateFlowImpl = wizardViewModel._state;
                do {
                    value = stateFlowImpl.getValue();
                } while (!stateFlowImpl.compareAndSet(value, WizardState.copy$default((WizardState) value, null, null, null, null, null, null, true, null, 639)));
                DeviceModel deviceModel = ((WizardState) stateFlowImpl.getValue()).selectedModel;
                String str = deviceModel != null ? deviceModel.name : "";
                ArrayList variantsForModel = wizardViewModel.autoEqSearch.getVariantsForModel(str);
                if (variantsForModel.isEmpty()) {
                    do {
                        value3 = stateFlowImpl.getValue();
                    } while (!stateFlowImpl.compareAndSet(value3, WizardState.copy$default((WizardState) value3, null, null, null, null, null, null, false, "No EQ profiles found for " + str, 639)));
                    return unit;
                }
                String str2 = this.$modelId;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(variantsForModel, 10));
                int size = variantsForModel.size();
                int i = 0;
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = variantsForModel.get(i2);
                    int i3 = i2 + 1;
                    int i4 = i + 1;
                    if (i < 0) {
                        CollectionsKt__IterablesKt.throwIndexOverflow();
                        throw null;
                    }
                    Entry entry = (Entry) obj2;
                    String str3 = entry.label;
                    boolean z2 = (StringsKt.contains(str3, "(ANC", r7) || StringsKt.contains(str3, "ANC ON", r7) || StringsKt.contains(str3, "ANC Off", r7)) ? r7 : z;
                    boolean z3 = (StringsKt.contains(str3, "velour", r7) || (StringsKt.contains(str3, "pad", r7) && !StringsKt.contains(str3, "(sample", r7))) ? r7 : z;
                    String str4 = str2 + "_" + i;
                    String str5 = entry.label;
                    String str6 = variantsForModel.size() > r7 ? entry.source + " - " + entry.rig : null;
                    String str7 = entry.source;
                    String str8 = entry.rig;
                    String str9 = entry.form;
                    StringBuilder sb = new StringBuilder();
                    Unit unit2 = unit;
                    try {
                        sb.append("Measured by ");
                        sb.append(str7);
                        sb.append(" on ");
                        sb.append(str8);
                        sb.append(" (");
                        sb.append(str9);
                        sb.append(")");
                        arrayList.add(new EQProfileVariant(str4, str2, str5, str6, z2, z3, sb.toString(), str7, str8));
                        i2 = i3;
                        i = i4;
                        unit = unit2;
                        z = false;
                        r7 = 1;
                    } catch (Exception e) {
                        e = e;
                        Exception exc = e;
                        do {
                            value2 = stateFlowImpl.getValue();
                        } while (!stateFlowImpl.compareAndSet(value2, WizardState.copy$default((WizardState) value2, null, null, null, null, EmptyList.INSTANCE, null, false, Fragment$5$$ExternalSyntheticOutline0.m("Failed to load variants: ", exc.getMessage()), 623)));
                        return unit2;
                    }
                }
                Unit unit3 = unit;
                while (true) {
                    Object value6 = stateFlowImpl.getValue();
                    ArrayList arrayList2 = arrayList;
                    if (stateFlowImpl.compareAndSet(value6, WizardState.copy$default((WizardState) value6, WizardStep.VARIANT_SELECTION, null, null, null, arrayList2, null, false, null, 878))) {
                        return unit3;
                    }
                    arrayList = arrayList2;
                }
                break;
            default:
                ResultKt.throwOnFailure(obj);
                StateFlowImpl stateFlowImpl2 = wizardViewModel._state;
                do {
                    value4 = stateFlowImpl2.getValue();
                } while (!stateFlowImpl2.compareAndSet(value4, WizardState.copy$default((WizardState) value4, null, null, null, null, null, null, true, null, 639)));
                Map mapSearchModels$default = TextDelegate.searchModels$default(wizardViewModel.autoEqSearch, this.$modelId);
                ArrayList arrayList3 = new ArrayList(mapSearchModels$default.size());
                for (Map.Entry entry2 : mapSearchModels$default.entrySet()) {
                    String str10 = (String) entry2.getKey();
                    List list = (List) entry2.getValue();
                    String lowerCase = str10.toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                    String strReplace = StringsKt__StringsJVMKt.replace(lowerCase, ServerSentEventKt.SPACE, "_", false);
                    Pattern patternCompile = Pattern.compile("[^a-z0-9_]");
                    patternCompile.getClass();
                    String strReplaceAll = patternCompile.matcher(strReplace).replaceAll("");
                    strReplaceAll.getClass();
                    arrayList3.add(new DeviceModel(strReplaceAll, str10, list.size() > 1));
                }
                do {
                    value5 = stateFlowImpl2.getValue();
                    break;
                } while (!stateFlowImpl2.compareAndSet(value5, WizardState.copy$default((WizardState) value5, null, null, arrayList3, null, null, null, false, null, 891)));
                return unit;
        }
    }
}
