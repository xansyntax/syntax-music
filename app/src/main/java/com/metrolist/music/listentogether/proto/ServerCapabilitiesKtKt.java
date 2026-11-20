package com.metrolist.music.listentogether.proto;

import com.google.protobuf.GeneratedMessageLite;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a'\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\b\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"Lkotlin/Function1;", "Lcom/metrolist/music/listentogether/proto/ServerCapabilitiesKt$Dsl;", "", "block", "Lcom/metrolist/music/listentogether/proto/Listentogether$ServerCapabilities;", "-initializeserverCapabilities", "(Lkotlin/jvm/functions/Function1;)Lcom/metrolist/music/listentogether/proto/Listentogether$ServerCapabilities;", "serverCapabilities", "copy", "(Lcom/metrolist/music/listentogether/proto/Listentogether$ServerCapabilities;Lkotlin/jvm/functions/Function1;)Lcom/metrolist/music/listentogether/proto/Listentogether$ServerCapabilities;", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class ServerCapabilitiesKtKt {
    /* JADX INFO: renamed from: -initializeserverCapabilities, reason: not valid java name */
    public static final Listentogether.ServerCapabilities m1437initializeserverCapabilities(Function1 function1) {
        function1.getClass();
        ServerCapabilitiesKt.Dsl.Companion companion = ServerCapabilitiesKt.Dsl.INSTANCE;
        Listentogether.ServerCapabilities.Builder builderNewBuilder = Listentogether.ServerCapabilities.newBuilder();
        builderNewBuilder.getClass();
        ServerCapabilitiesKt.Dsl dsl_create = companion._create(builderNewBuilder);
        function1.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final Listentogether.ServerCapabilities copy(Listentogether.ServerCapabilities serverCapabilities, Function1 function1) {
        serverCapabilities.getClass();
        function1.getClass();
        ServerCapabilitiesKt.Dsl.Companion companion = ServerCapabilitiesKt.Dsl.INSTANCE;
        GeneratedMessageLite.Builder builderM914toBuilder = serverCapabilities.m914toBuilder();
        builderM914toBuilder.getClass();
        ServerCapabilitiesKt.Dsl dsl_create = companion._create((Listentogether.ServerCapabilities.Builder) builderM914toBuilder);
        function1.invoke(dsl_create);
        return dsl_create._build();
    }
}
