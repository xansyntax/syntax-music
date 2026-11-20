package androidx.media3.session;

import androidx.compose.ui.node.NodeChain;
import androidx.media3.common.Player;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ConnectedControllersManager$ConnectedControllerRecord {
    public boolean commandQueueIsFlushing;
    public final Object controllerKey;
    public Player.Commands playerCommands;
    public final NodeChain.Differ sequencedFutureManager;
    public SessionCommands sessionCommands;
    public final ArrayDeque commandQueue = new ArrayDeque();
    public Player.Commands commandQueuePlayerCommands = Player.Commands.EMPTY;

    public ConnectedControllersManager$ConnectedControllerRecord(Object obj, NodeChain.Differ differ, SessionCommands sessionCommands, Player.Commands commands) {
        this.controllerKey = obj;
        this.sequencedFutureManager = differ;
        this.sessionCommands = sessionCommands;
        this.playerCommands = commands;
    }
}
