package com.metrolist.music.eq.data;

import j$.net.URLEncoder;
import java.io.UnsupportedEncodingException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.json.JsonBuilder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GitHubAutoEqSearch$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws UnsupportedEncodingException {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                String str = (String) obj;
                str.getClass();
                String strEncode = URLEncoder.encode(str, "UTF-8");
                strEncode.getClass();
                return StringsKt__StringsJVMKt.replace(strEncode, "+", "%20", false);
            case 1:
                JsonBuilder jsonBuilder = (JsonBuilder) obj;
                jsonBuilder.getClass();
                jsonBuilder.ignoreUnknownKeys = true;
                jsonBuilder.prettyPrint = true;
                return unit;
            default:
                JsonBuilder jsonBuilder2 = (JsonBuilder) obj;
                jsonBuilder2.getClass();
                jsonBuilder2.ignoreUnknownKeys = true;
                return unit;
        }
    }
}
