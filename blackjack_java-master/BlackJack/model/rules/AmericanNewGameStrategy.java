package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {

    a_player.DealCard(a_deck.GetCard(), true);
    a_dealer.DealCard(a_deck.GetCard(), true);
    a_player.DealCard(a_deck.GetCard(), true);
    a_dealer.DealCard(a_deck.GetCard(), false);
    
    return true;
  }
}