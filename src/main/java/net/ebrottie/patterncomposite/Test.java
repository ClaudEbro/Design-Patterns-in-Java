package net.ebrottie.patterncomposite;

import net.ebrottie.patterncomposite.composite.File;
import net.ebrottie.patterncomposite.composite.Folder;

public class Test {

    public static void main(String[] args) {

        Folder root = new Folder("/");

        root.addChild(new File("Test.java"));
        root.addChild(new File("Config.xml"));

        //Create Folders
        Folder entities = (Folder) root.addChild(new Folder("Entities"));
        Folder repo = (Folder) root.addChild(new Folder("Repositories"));

        //Add files in created folders
        entities.addChild(new File("Product.java"));
        entities.addChild(new File("Category.java"));
        repo.addChild(new File("ProductRepository"));
        repo.addChild(new File("CategoryRepository"));

        //Add a sub repository
        repo.addChild(new Folder("SubRepo"));
        root.print();
    }
}
