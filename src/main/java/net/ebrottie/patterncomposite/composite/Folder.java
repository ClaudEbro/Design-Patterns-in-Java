package net.ebrottie.patterncomposite.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Component{

    private List<Component> components = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    @Override
    public void print() {

        System.out.println(getTab()+"Folder : "+name);

        for (Component c:components){
            c.print();
        }
    }

    public Component addChild(Component component){
        component.level = this.level+1;
        this.components.add(component);
        return component;
    }

}
