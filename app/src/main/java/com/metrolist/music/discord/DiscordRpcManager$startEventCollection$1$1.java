package com.metrolist.music.discord;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordRpcManager$startEventCollection$1$1 implements FlowCollector {
    public static final DiscordRpcManager$startEventCollection$1$1 INSTANCE = new DiscordRpcManager$startEventCollection$1$1();

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        Object objHandleGatewayEvent = DiscordRpcManager.INSTANCE.handleGatewayEvent((GatewayEvent) obj, continuation);
        return objHandleGatewayEvent == CoroutineSingletons.COROUTINE_SUSPENDED ? objHandleGatewayEvent : Unit.INSTANCE;
    }
}
