package edu.isu.cs.cs2263.hw02.views;

import edu.isu.cs.cs2263.hw02.App;
import javafx.scene.Node;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

/**
 * Add Log4j2 from lombok to make logging available for the class
 */
@Log4j2
public abstract class AppView implements IAppView {
    /**
     * Add @Getter so we can call getView without the use of methods
     */
    protected @Getter Node view;
    protected App parent;

    public AppView(App parent) {
        this.parent = parent;
        initView();
    }
}
