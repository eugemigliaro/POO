package PrimerosParciales.P1C12022.ej1;

import java.util.Iterator;

public class MilesClient implements Iterable<String>{
    private final Plan plan;
    private final String name;
    private final int months;

    public MilesClient (String name, int months, Plan plan){
        this.name = name;
        this.months = months;
        this.plan = plan;
    }

    public int getMonths(){
        return months;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>(){
            private int currentMonth = 0;

            @Override
            public boolean hasNext(){
                return currentMonth < months;
            }

            @Override
            public String next(){
                if(!hasNext()){
                    throw new InvalidMonthException();
                }

                String ans = "Client " + name + ": Month " + (currentMonth + 1) + " earned " + plan.getMilesPerMonth(currentMonth) + " miles for $" + plan.getPricePerMonth();
                currentMonth++;
                return ans;
            }
        };
    }
}
