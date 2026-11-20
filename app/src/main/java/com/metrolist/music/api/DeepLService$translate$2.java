package com.metrolist.music.api;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DeepLService$translate$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $apiKey;
    public final /* synthetic */ String $formality;
    public final /* synthetic */ byte $maxRetries;
    public final /* synthetic */ String $targetLanguage;
    public final /* synthetic */ String $text;
    public int I$0;
    public int I$1;
    public List L$0;
    public String L$1;
    public String L$2;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DeepLService$translate$2(String str, String str2, String str3, int i, String str4, Continuation continuation) {
        super(2, continuation);
        this.$text = str;
        this.$targetLanguage = str2;
        this.$apiKey = str3;
        this.$maxRetries = i;
        this.$formality = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeepLService$translate$2(this.$text, this.$targetLanguage, this.$apiKey, this.$maxRetries, this.$formality, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((DeepLService$translate$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0257  */
    /* JADX WARN: Code duplicated, block: B:102:0x0259 A[Catch: Exception -> 0x01c2, TryCatch #3 {Exception -> 0x01c2, blocks: (B:74:0x0178, B:76:0x01bd, B:80:0x01c8, B:83:0x01ce, B:99:0x0236, B:98:0x021d, B:102:0x0259, B:103:0x025c, B:105:0x026a, B:107:0x0270, B:108:0x0288, B:110:0x028f, B:111:0x02a2, B:113:0x02a8, B:115:0x02ae, B:117:0x02b4, B:119:0x02be, B:120:0x02c3, B:122:0x02c9, B:123:0x02cd, B:91:0x01f3, B:94:0x01f8, B:96:0x0203), top: B:146:0x0178, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x025c A[Catch: Exception -> 0x01c2, TryCatch #3 {Exception -> 0x01c2, blocks: (B:74:0x0178, B:76:0x01bd, B:80:0x01c8, B:83:0x01ce, B:99:0x0236, B:98:0x021d, B:102:0x0259, B:103:0x025c, B:105:0x026a, B:107:0x0270, B:108:0x0288, B:110:0x028f, B:111:0x02a2, B:113:0x02a8, B:115:0x02ae, B:117:0x02b4, B:119:0x02be, B:120:0x02c3, B:122:0x02c9, B:123:0x02cd, B:91:0x01f3, B:94:0x01f8, B:96:0x0203), top: B:146:0x0178, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x026a A[Catch: Exception -> 0x01c2, TryCatch #3 {Exception -> 0x01c2, blocks: (B:74:0x0178, B:76:0x01bd, B:80:0x01c8, B:83:0x01ce, B:99:0x0236, B:98:0x021d, B:102:0x0259, B:103:0x025c, B:105:0x026a, B:107:0x0270, B:108:0x0288, B:110:0x028f, B:111:0x02a2, B:113:0x02a8, B:115:0x02ae, B:117:0x02b4, B:119:0x02be, B:120:0x02c3, B:122:0x02c9, B:123:0x02cd, B:91:0x01f3, B:94:0x01f8, B:96:0x0203), top: B:146:0x0178, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:136:0x0306  */
    /* JADX WARN: Code duplicated, block: B:140:0x01f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x0134 A[Catch: Exception -> 0x004a, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x004a, blocks: (B:67:0x0134, B:71:0x0152, B:87:0x01d9, B:10:0x0045), top: B:144:0x0045 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0152 A[Catch: Exception -> 0x004a, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x004a, blocks: (B:67:0x0134, B:71:0x0152, B:87:0x01d9, B:10:0x0045), top: B:144:0x0045 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x01bd A[Catch: Exception -> 0x01c2, TryCatch #3 {Exception -> 0x01c2, blocks: (B:74:0x0178, B:76:0x01bd, B:80:0x01c8, B:83:0x01ce, B:99:0x0236, B:98:0x021d, B:102:0x0259, B:103:0x025c, B:105:0x026a, B:107:0x0270, B:108:0x0288, B:110:0x028f, B:111:0x02a2, B:113:0x02a8, B:115:0x02ae, B:117:0x02b4, B:119:0x02be, B:120:0x02c3, B:122:0x02c9, B:123:0x02cd, B:91:0x01f3, B:94:0x01f8, B:96:0x0203), top: B:146:0x0178, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:83:0x01ce A[Catch: Exception -> 0x01c2, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x01c2, blocks: (B:74:0x0178, B:76:0x01bd, B:80:0x01c8, B:83:0x01ce, B:99:0x0236, B:98:0x021d, B:102:0x0259, B:103:0x025c, B:105:0x026a, B:107:0x0270, B:108:0x0288, B:110:0x028f, B:111:0x02a2, B:113:0x02a8, B:115:0x02ae, B:117:0x02b4, B:119:0x02be, B:120:0x02c3, B:122:0x02c9, B:123:0x02cd, B:91:0x01f3, B:94:0x01f8, B:96:0x0203), top: B:146:0x0178, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:93:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:96:0x0203 A[Catch: Exception -> 0x021d, TRY_LEAVE, TryCatch #0 {Exception -> 0x021d, blocks: (B:91:0x01f3, B:94:0x01f8, B:96:0x0203), top: B:140:0x01f3, outer: #3 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:136:0x0306 -> B:137:0x030b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x01ee -> B:63:0x011c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:101:0x0257
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            Method dump skipped, instruction units count: 852
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.api.DeepLService$translate$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
