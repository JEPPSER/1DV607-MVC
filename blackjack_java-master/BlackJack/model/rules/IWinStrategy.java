package BlackJack.model.rules;

import BlackJack.model.Player;

public interface IWinStrategy {
	public boolean IsDealerWinner(Player a_player, Player a_dealer, int g_maxScore);
}
