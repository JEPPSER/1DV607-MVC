package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;
import BlackJack.model.rules.IObserver;

public class PlayGame implements IObserver {
  
  private Game m_game;
  private IView m_view;

  public PlayGame(Game a_game, IView a_view) {
    m_game = a_game;
	m_view = a_view;
	m_game.addObserver(this);
  }
  
  public boolean Play() {
    m_view.DisplayWelcomeMessage();
    
    m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
    m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());

    if (m_game.IsGameOver())
    {
        m_view.DisplayGameOver(m_game.IsDealerWinner());
    }

    Actions input = m_view.GetInput();
    
    switch (input)
    {
    case PLAY:
    	m_game.NewGame();
    	break;
    case HIT:
    	m_game.Hit();
    	break;
    case STAND:
    	m_game.Stand();
    	break;
    case QUIT:
    	return false;
    case NOACTION:
	default:
		break;
    }
    
    return true;
  }

  @Override
  public void update() {
    m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
    m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());
  }
}