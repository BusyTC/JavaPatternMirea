package practice_7.composite;

import java.util.ArrayList;

public class Composite implements IComponent {
    private final ArrayList<IComponent> components = new ArrayList<>();

    @Override
    public String getName() {
        if (components.isEmpty()) return "";
        StringBuilder res = new StringBuilder(components.get(0).getName());
        for (int i = 1; i < components.size(); i++) {
            res.append("; ");
            res.append(components.get(i).getName());
        }
        return res.toString();
    }

    public void add(IComponent component) {
        components.add(component);
    }

    public void remove(IComponent component) {
        components.remove(component);
    }

    public IComponent getChild(int index) {
        return components.get(index);
    }
}
