package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import kotlin.Function;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0 implements ColorProducer, FunctionAdapter {
    public final /* synthetic */ PropertyReference0Impl function;

    public TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(PropertyReference0Impl propertyReference0Impl) {
        this.function = propertyReference0Impl;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ColorProducer) || !(obj instanceof FunctionAdapter)) {
            return false;
        }
        return this.function.equals(((FunctionAdapter) obj).getFunctionDelegate());
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return this.function.hashCode();
    }

    @Override // androidx.compose.ui.graphics.ColorProducer
    /* JADX INFO: renamed from: invoke-0d7_KjU */
    public final long mo314invoke0d7_KjU() {
        return ((Color) this.function.get()).value;
    }
}
