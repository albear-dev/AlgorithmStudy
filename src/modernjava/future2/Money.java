package modernjava.future2;

public enum Money {
  USD(1407.80),
  EUR(1383.45),
  JYP(972.04)
  ;

  private Double amount;

  Money(Double amount){
    this.amount = amount;
  }

  public Double getAmount(){
    return amount;
  }
}
