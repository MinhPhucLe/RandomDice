package Repository;

import models.BasePlayer;

import java.util.List;

public class PlayerRepoImpl implements PlayerRepo {
    List<BasePlayer> players;
    private static PlayerRepoImpl instance;

    public PlayerRepoImpl getInstance() {
        if (instance == null) instance = new PlayerRepoImpl();
        return instance;
    }

    public void setPlayers(List<BasePlayer> players) {
        this.players = players;
    }

    public List<BasePlayer> getPlayers() {
        return this.players;
    }

    @Override
    public StringBuffer showPlayerStats() {
        StringBuffer stats = new StringBuffer();
        stats.append("======================== Point Board ========================\n");
        for (BasePlayer player : players) {
            stats.append(player.toString());
            stats.append(" " + (player.isLose() ? "Eliminated" : ""));
            stats.append("\n");
        }
        stats.append("=============================================================\n");
        return stats;
    }
}
