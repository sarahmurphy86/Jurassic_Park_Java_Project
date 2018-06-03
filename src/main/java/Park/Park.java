package Park;

import Paddocks.Paddock;
import Visitors.Visitor;

import java.util.ArrayList;

public class Park {
    protected String name;
    private ArrayList<Paddock> paddockList;
    private ArrayList<Visitor> visitorList;

    public Park(String name){
        this.name = name;
        this.paddockList = new ArrayList<Paddock>();
        this.visitorList =new ArrayList<Visitor>();
    }

    public String getName() {
        return this.name;
    }

    public int getVisitorCount() {
        return this.visitorList.size();
    }

    public void addVisitor(Visitor visitor) {
        this.visitorList.add(visitor);
    }
}
