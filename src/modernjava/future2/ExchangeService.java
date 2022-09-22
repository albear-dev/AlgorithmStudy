package modernjava.future2;

public class ExchangeService {
  public Double getRate (Money src, Money dest){
    return dest.getAmount() / src.getAmount();
  }
}
