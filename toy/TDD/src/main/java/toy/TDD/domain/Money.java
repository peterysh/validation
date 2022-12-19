package toy.TDD.domain;

import lombok.ToString;

@ToString
public class Money implements Expression{
    public int amount;
    public String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money times(int multiplier){
        return new Money(amount * multiplier,currency);
    }

    public String currency(){
        return currency;
    };

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount){
        return new Money(amount, "CHF");
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return amount == money.amount
                && currency().equals(money.currency());
    }

    public Expression plus(Money addend){
        return new Money(amount + addend.amount, currency);
    }
}
