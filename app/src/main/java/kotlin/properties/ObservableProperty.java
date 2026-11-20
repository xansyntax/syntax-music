package kotlin.properties;

import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ObservableProperty implements ReadWriteProperty {
    private Object value;

    public ObservableProperty(Object obj) {
        this.value = obj;
    }

    public abstract void afterChange(KProperty kProperty, Object obj, Object obj2);

    public boolean beforeChange(KProperty<?> kProperty, Object obj, Object obj2) {
        kProperty.getClass();
        return true;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public Object getValue(Object obj, KProperty<?> kProperty) {
        kProperty.getClass();
        return this.value;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object obj, KProperty<?> kProperty, Object obj2) {
        kProperty.getClass();
        Object obj3 = this.value;
        if (beforeChange(kProperty, obj3, obj2)) {
            this.value = obj2;
            afterChange(kProperty, obj3, obj2);
        }
    }

    public String toString() {
        return "ObservableProperty(value=" + this.value + ')';
    }
}
