package edu.parinya.softarchdesign.structural;


import java.util.LinkedHashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable {
    private Set<HealthcareServiceable> members;

    public HealthcareWorkerTeam() {
        members = new LinkedHashSet<HealthcareServiceable>();
    }

    @Override
    public void service() {
        for (HealthcareServiceable member : members) {
            member.service();
        }
    }

    @Override
    public double getPrice() {
        double sumPrice = 0;
        for (HealthcareServiceable member : members) {
            sumPrice += member.getPrice();
        }
        return sumPrice;
    }
    
    public void addMember(HealthcareServiceable member){
        members.add(member);
    }

    public void removeMember(HealthcareServiceable member){
        members.remove(member);
    }
}
