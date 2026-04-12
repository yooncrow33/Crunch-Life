package com.dsce.base.core.graphics.popup;

import com.dsce.base.core.Game;
import com.dsce.base.core.GameState;
import com.dsce.base.core.graphics.popup.internal.Popup;

public class CommitPopup extends Popup {

    final Game game;
    final GameState.state type;

    @Override
    public void exe() {
        game.shutter.changScreen(type);
    }

    public CommitPopup(Game game,String e, String key, GameState.state type) {
        super("Are You Sure?", e, key);
        this.game = game;
        this.type = type;
    }
}
