package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    return new BasicHitStrategy();
  }
  
  public IHitStrategy GetSoft17HitRule() {
	  return new Soft17HitStrategy();
  }
  
  public IWinStrategy GetDealerWinStrategy() {
	  return new DealerWinStrategy();
  }
  
  public IWinStrategy GetPlayerWinStrategy() {
	  return new PlayerWinStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
}